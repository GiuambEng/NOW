package com.nttdata.tim.now.core.service.offerta;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.offerta.ProfiloLineaRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.profilolinea.ProfiloLineaOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.profilolinea.LineProfileListDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProfiloLineaManagerBL extends AbstractBL {

	@Autowired
	private ProfiloLineaRESTClient profiloLineaRestIL;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	public GenericListBean<ProfiloLineaOutputBean> getLineProfiles(String tipoProfilo) throws BusinessLayerException {
		GenericListBean<ProfiloLineaOutputBean> list = new GenericListBean<>();
		try {
			LineProfileListDTO dto = profiloLineaRestIL.getLineProfiles(tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getLineProfiles(), ProfiloLineaOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public GenericListBean<ProfiloLineaOutputBean> getLineProfilesByOffer(String offerId, String modulazione, String caratteristica, String tipoProfilo, String protocollo) throws BusinessLayerException {
		GenericListBean<ProfiloLineaOutputBean> list = new GenericListBean<>();
		try {
			LineProfileListDTO dto = profiloLineaRestIL.getLineProfilesByOffer(offerId, modulazione, caratteristica, tipoProfilo, protocollo); //SM_8252
	         validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getLineProfiles(), ProfiloLineaOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public GenericListBean<ProfiloLineaOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata ProfiloLineaManager");
    	}

		GenericListBean<ProfiloLineaOutputBean> list = new GenericListBean<>();
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			LineProfileListDTO dto = profiloLineaRestIL.advancedSearch(inputDto, tipoProfilo);
	         validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getLineProfiles(), ProfiloLineaOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}
	
}
