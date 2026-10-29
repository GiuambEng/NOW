package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.DacRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;
import com.nttdata.tim.now.data.bean.dac.VerificaDacOutputBean;
import com.nttdata.tim.now.data.dto.dac.VerificaDacOutputDTO;
import com.nttdata.tim.now.util.FlagHelper;
import com.nttdata.tim.now.util.date.DateHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DacManagerBL extends AbstractBL {

	private static final String KO = "KO";
	private static final String OK = "OK";
	private static final String WORKDAY_TEST_FAILED_MESSAGE = "Giorno scelto non lavorativo";
	private static final String SLA_TEST_FAILED_MESSAGE = "Data non conforme allo SLA previsto";

	
	@Autowired
	private DacRESTClient dacRestIL;

	//RU_920
	public VerificaDacOutputBean getWorkDac(String dac, String lavorazione, String idOfferta, String tipoProfilo) throws BusinessLayerException {
		VerificaDacOutputBean verificationWorkDacBean = null;
		VerificaDacOutputDTO verificationWorkDacDTO = null;
		try {
			verificationWorkDacDTO = dacRestIL.getWorkingDac(DateHelper.convertFromFE(dac), lavorazione, idOfferta, tipoProfilo);
			validateResponseResult(verificationWorkDacDTO);
		} catch (Exception e) {
			logger.error("Error verify work dac", e);
			throw new BusinessLayerException(e);
		}
		if (verificationWorkDacDTO != null) {
			verificationWorkDacBean = getVerificationBean(verificationWorkDacDTO, WORKDAY_TEST_FAILED_MESSAGE);
		}
		return verificationWorkDacBean;
	}

	private VerificaDacOutputBean getVerificationBean(VerificaDacOutputDTO verificationDTO, String failureMessage) {
		VerificaDacOutputBean verificationBean = new VerificaDacOutputBean();
		CodiceOutputBean outcomeBean = new CodiceOutputBean();
		boolean isValid = "Y".equalsIgnoreCase(verificationDTO.getOutcome().getCodice());
		outcomeBean.setCodice(isValid ? OK : KO);
		outcomeBean.setDescrizione(isValid ? OK : failureMessage);
		verificationBean.setOutcome(outcomeBean);
		return verificationBean;
	}

	public VerificaDacOutputBean getSLADac(String dac, String causaleOrdine, String offerta, Boolean flagNP, String sottolavorazione, String tipoProfilo) throws BusinessLayerException {
		VerificaDacOutputBean verificationWorkDacBean = null;
		VerificaDacOutputDTO verificationDacSLA = null;
		try {
		    String tmpFlagNp= flagNP==null?null:FlagHelper.convertFromFE(flagNP.booleanValue());
			verificationDacSLA = dacRestIL.getSLADac(DateHelper.convertFromFE(dac), StringUtils.upperCase(causaleOrdine), offerta, tmpFlagNp, sottolavorazione, tipoProfilo);
			validateResponseResult(verificationDacSLA);
		} catch (Exception e) {
			logger.error("Error verifying sla dac", e);
			throw new BusinessLayerException(e);
		}
		if (verificationDacSLA != null) {
			verificationWorkDacBean = getVerificationBean(verificationDacSLA, SLA_TEST_FAILED_MESSAGE);
		}
		return verificationWorkDacBean;
	}

}
