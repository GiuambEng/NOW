package com.nttdata.tim.now.core.service.asset;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.asset.RichiestaAssetRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.asset.CodiciRifiutoOutputBean;
import com.nttdata.tim.now.data.bean.asset.ListaCodiciRifiutoOutputBean;
import com.nttdata.tim.now.data.bean.asset.RichiesteAssetOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.asset.ListaCodiciRifiutoOutputDTO;
import com.nttdata.tim.now.data.dto.asset.RichiesteAssetWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RichiestaAssetManagerBL extends AbstractBL {

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	@Autowired
	private RichiestaAssetRESTClient richiestaAssetRestClient;
	
	public GenericListBean<RichiesteAssetOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String codOloAgcom,
			String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListBean<RichiesteAssetOutputBean> bean = new GenericListBean<RichiesteAssetOutputBean>();
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata RichiesteRicaricaAsset");
    	}

		boolean isLimited;
		//Gestione lista limitata
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			RichiesteAssetWrapperOutputDTO dto = richiestaAssetRestClient.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
			isLimited = validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getList(), RichiesteAssetOutputBean.class));
			bean.setIsLimitedList(isLimited);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	public ExportableDataOutputBean requestExport(RicercaAvanzataInputBean inputBean, String codOloAgcom,
			String tipoProfilo, String userId) throws BusinessLayerException {
		ExportableDataOutputBean bean = new ExportableDataOutputBean();
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ExportableDataOutputDTO dto = richiestaAssetRestClient.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
			validateResponseResult(dto);
			bean = mapper.translate(dto, ExportableDataOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public ListaCodiciRifiutoOutputBean visualizzacodicirifiuto(String ambitoServizioRecipient,
			String ambitoServizioDonating, String codiceProfilo) throws BusinessLayerException {
		ListaCodiciRifiutoOutputBean bean = new ListaCodiciRifiutoOutputBean();
		try {
			ListaCodiciRifiutoOutputDTO dto = richiestaAssetRestClient.visualizzacodicirifiuto(ambitoServizioRecipient, ambitoServizioDonating, codiceProfilo);
			validateResponseResult(dto);
			bean.setLista(mapper.translateList(dto.getLista(), CodiciRifiutoOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
