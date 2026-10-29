package com.nttdata.tim.now.core.service.anagrafica;

import com.nttdata.tim.now.adapters.esb.anagrafica.ContrattoAnfibioRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.contratto.ContrattoAnfibioOutputBean;
import com.nttdata.tim.now.data.dto.contratto.ContrattoAnfibioOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContrattoAnfibioManagerBL extends AbstractBL {

	@Autowired
	private ContrattoAnfibioRESTClient contrattoAnfibioRestIL;

	public ContrattoAnfibioOutputBean getAnfibioContract(String idContratto, String tipoProfilo) throws BusinessLayerException {
		ContrattoAnfibioOutputBean bean = new ContrattoAnfibioOutputBean();
		try {
			ContrattoAnfibioOutputDTO dto = contrattoAnfibioRestIL.getAnfibioContract(idContratto, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, ContrattoAnfibioOutputBean.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
