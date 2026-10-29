package com.nttdata.tim.now.core.service.asset;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.asset.RicaricaAssetRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.asset.ListaRicaricheAssetOutputBean;
import com.nttdata.tim.now.data.bean.asset.NuovaRicaricaInputBean;
import com.nttdata.tim.now.data.bean.asset.NuovaRicaricaOutputBean;
import com.nttdata.tim.now.data.bean.asset.RicaricaDettaglioAssetOutputBean;
import com.nttdata.tim.now.data.bean.asset.RicaricaOutputBean;
import com.nttdata.tim.now.data.bean.asset.TaglioRicaricaOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.asset.NuovaRicaricaInputDTO;
import com.nttdata.tim.now.data.dto.asset.NuovaRicaricaOutputDTO;
import com.nttdata.tim.now.data.dto.asset.RicaricaAssetWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.asset.TaglioRicaricaAssetWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RicaricaAssetManagerBL extends AbstractBL {

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	@Autowired
	private RicaricaAssetRESTClient ricaricaAssetRestClient;
	
	public ListaRicaricheAssetOutputBean advancedSearch(RicercaAvanzataInputBean inputBean, String codOloAgcom,
			String tipoProfilo, String userId) throws BusinessLayerException {
		ListaRicaricheAssetOutputBean bean = new ListaRicaricheAssetOutputBean();
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata RichiesteRicaricaAsset");
    	}

		boolean isLimited;
		//Gestione lista limitata
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			RicaricaAssetWrapperOutputDTO dto = ricaricaAssetRestClient.advancedSearch(inputDto, codOloAgcom, tipoProfilo,userId);
			isLimited = validateResponseResult(dto);
			if (dto.getRichiesteRicaricaAssetDTO()!=null) {
				bean.setLista(mapper.translateList(dto.getRichiesteRicaricaAssetDTO(), RicaricaOutputBean.class));
			}
			bean.setDettaglioAsset(mapper.translate(dto.getRichiesteRicaricaDettaglioAssetDTO(), RicaricaDettaglioAssetOutputBean.class));
			bean.setIsLimitedList(isLimited);
			if (dto.getIdExportFile()!=null) {
				bean.setIdExportFile(dto.getIdExportFile());
			}
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
			ExportableDataOutputDTO dto = ricaricaAssetRestClient.advancedSearch(inputDto, codOloAgcom, tipoProfilo,userId);
			validateResponseResult(dto);
			bean = mapper.translate(dto, ExportableDataOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}


	public NuovaRicaricaOutputBean nuovaRicarica(NuovaRicaricaInputBean body, String codiceProfilo) throws BusinessLayerException {
		NuovaRicaricaOutputBean bean = new NuovaRicaricaOutputBean();
		try {
			NuovaRicaricaInputDTO inputDto = mapper.translate(body, NuovaRicaricaInputDTO.class);
			NuovaRicaricaOutputDTO dto = ricaricaAssetRestClient.nuovaRicarica(inputDto, codiceProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, NuovaRicaricaOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<TaglioRicaricaOutputBean> getTaglioRicarica(String offerta, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<TaglioRicaricaOutputBean> bean = new GenericListBean<>();
		try {
			TaglioRicaricaAssetWrapperOutputDTO dto = ricaricaAssetRestClient.getTaglioRicarica(offerta, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getList(), TaglioRicaricaOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
