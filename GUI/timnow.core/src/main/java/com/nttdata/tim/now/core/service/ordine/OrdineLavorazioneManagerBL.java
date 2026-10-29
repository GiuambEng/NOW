package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.OrdineLavorazioneRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ordine.lavorazione.RecuperoTipologiaLavorazioneOutputBean;
import com.nttdata.tim.now.data.dto.ordine.lavorazione.OutputRecuperoTipologiaLavorazioneDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineLavorazioneManagerBL extends AbstractBL {

	@Autowired
	private OrdineLavorazioneRESTClient ordineLavorazioneRestIL;
	
	public GenericListBean<RecuperoTipologiaLavorazioneOutputBean> getTipologiaLavorazione(String tipoProfilo) throws BusinessLayerException {
	    GenericListBean<RecuperoTipologiaLavorazioneOutputBean> bean = new GenericListBean<>();
		try {
		    OutputRecuperoTipologiaLavorazioneDTO tipologiaLavorazione = ordineLavorazioneRestIL.getTipologiaLavorazione(tipoProfilo);
			validateResponseResult(tipologiaLavorazione);
			bean.setData(mapper.translateList(tipologiaLavorazione.getRecuperoTipologiaLavorazione(), RecuperoTipologiaLavorazioneOutputBean.class));
		} catch(Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
}
