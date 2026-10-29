package com.nttdata.tim.now.core.service.offerta;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.offerta.AtmRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.atm.KitAtmOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.atm.ListaKitAtmOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AtmManagerBL extends AbstractBL {

	@Autowired
	private AtmRESTClient atmRestIL;
	
	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;


	public GenericListBean<KitAtmOutputBean> getKitAtm(String tipoProfilo) throws BusinessLayerException {
		GenericListBean<KitAtmOutputBean> list = new GenericListBean<>();
		try {
			ListaKitAtmOutputDTO dto = atmRestIL.getKitAtm(tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getKitAtms(), KitAtmOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public GenericListBean<KitAtmOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<KitAtmOutputBean> list = new GenericListBean<>();
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata AtmManager");
    	}

		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ListaKitAtmOutputDTO dto = atmRestIL.advancedSearch(inputDto, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getKitAtms(), KitAtmOutputBean.class));
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}
}
