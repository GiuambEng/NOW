package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.PosizioneCodaRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.posizionecoda.PosizioneCodaOutputBean;
import com.nttdata.tim.now.data.dto.posizionecoda.PosizioneCodaOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosizioneCodaManagerBL extends AbstractBL {

	@Autowired
	private PosizioneCodaRESTClient posizioneCodaRestIL;

	public PosizioneCodaOutputBean getQueuePosition(String idRisorsa, String tipoProfilo) throws BusinessLayerException {
		PosizioneCodaOutputBean bean;
		try {
			PosizioneCodaOutputDTO dto = posizioneCodaRestIL.getQueuePosition(idRisorsa, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, PosizioneCodaOutputBean.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
