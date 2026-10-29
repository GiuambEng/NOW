package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.DacManagerBL;
import com.nttdata.tim.now.data.bean.dac.VerificaDacOutputBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dacs")
public class DacController extends GenericController {
    
    @Autowired
    private DacManagerBL dacManagerBL;

	// Verifica DAC -> Verifica DAC Lavorativo
	@JsonGetMapping("/work")
	//RU_920
	public VerificaDacOutputBean getWorkingDac(@RequestParam(value = "dac") String dac,
											   @RequestParam(value = "lavorazione", required = false) String lavorazione,
											   @RequestParam(value = "idOfferta", required = false) String idOfferta,
												HttpSession session) throws BusinessLayerException {
		logger.info("get working dac");
		UserBean user = getCurrentUser(session);
		VerificaDacOutputBean verificationWorkDacBean = dacManagerBL.getWorkDac(dac, lavorazione, idOfferta, user.getCodiceProfilo());
		verificationWorkDacBean.setResult(getSuccessResult());
		return verificationWorkDacBean;
	}

	// Verifica DAC -> Verifica DAC SLA
	@JsonGetMapping("/sla")
	public VerificaDacOutputBean getSLADac(
			@RequestParam("dac") String dac, 
			@RequestParam("orderType") String orderType, 
			@RequestParam("offer") String offer,
			@RequestParam(value = "flagNp", required = false) Boolean flagNp,
			@RequestParam(value = "sottolavorazione", required = false) String sottolavorazione,
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaDacOutputBean verificationWorkDacBean = null;
		if (StringUtils.isNotEmpty(offer)) {
			logger.debug("validating DAC SLA using offer");
			verificationWorkDacBean = dacManagerBL.getSLADac(dac, orderType, offer, flagNp, sottolavorazione, user.getCodiceProfilo());
		} else {
			verificationWorkDacBean = new VerificaDacOutputBean();
			verificationWorkDacBean.setResult(new Result(ResultCodeEnum.VALIDATION_ERROR.getCode(), " offer e' obbligatorio", ResultCodeEnum.VALIDATION_ERROR.getMessage()));
			return verificationWorkDacBean;
		}
		
		verificationWorkDacBean.setResult(getSuccessResult());

		return verificationWorkDacBean;
	}

}
