package com.nttdata.tim.now.core.service.olo;

import com.nttdata.tim.now.adapters.esb.olo.OaoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OaoManagerBL extends AbstractBL {

	@Autowired
	private OaoRESTClient oaoRestIL;

	public EsitoOutputBean checkActivationOao(String codOlo, String offer, String idContratto, String tipoProfilo) throws BusinessLayerException {
		EsitoOutputBean bean = null;
		try {
			EsitoDTO dto = oaoRestIL.checkActivationOao(codOlo, offer, idContratto, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public EsitoOutputBean checkCessationOao(String codOlo, String idResource, String tipoProfilo) throws BusinessLayerException {
		EsitoOutputBean bean = null;
		try {
			EsitoDTO dto = oaoRestIL.checkCessationOao(codOlo, idResource, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
