package com.nttdata.tim.now.core.service.ordine;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.tim.now.adapters.esb.ordine.ReferenteContattatoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.referente.ReferenteContattatoOutputBean;
import com.nttdata.tim.now.data.dto.referente.ReferenteContattatoOutputDTO;
import com.nttdata.tim.now.data.dto.referente.ReferenteContattatoWrapperOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenteManagerBL extends AbstractBL {

    @Autowired
    private ReferenteContattatoRESTClient contactedReferentsRESTClient;

	public List<ReferenteContattatoOutputBean> getContactedReferents(String orderOLOCode, String tipoProfilo) throws BusinessLayerException {
		List<ReferenteContattatoOutputBean> beans = new ArrayList<>();
		ReferenteContattatoWrapperOutputDTO wrapperDTO;
		try {
			wrapperDTO = contactedReferentsRESTClient.getContactedReferents(orderOLOCode, tipoProfilo);
			validateResponseResult(wrapperDTO);
		} catch (Exception e) {
			logger.error("Error reading contacted referents", e);
			throw new BusinessLayerException("Error loading Contacted Referents", e);
		}
		List<ReferenteContattatoOutputDTO> listDTO = wrapperDTO.getVisualizzazioneReferentecontattatoOutput();
		if (listDTO != null && !listDTO.isEmpty()) {
			beans = mapper.translateList(listDTO, ReferenteContattatoOutputBean.class);
		}

		return beans;
	}

}
