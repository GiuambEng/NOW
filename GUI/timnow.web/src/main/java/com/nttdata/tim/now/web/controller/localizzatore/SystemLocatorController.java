package com.nttdata.tim.now.web.controller.localizzatore;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.localizzatore.SystemLocatorManagerBL;
import com.nttdata.tim.now.data.bean.locator.SystemLocatorInputBean;
import com.nttdata.tim.now.data.bean.locator.SystemLocatorOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locators")
public class SystemLocatorController extends GenericController {

    @Autowired
    private SystemLocatorManagerBL systemLocatorManagerBL;
    
	// System Locator
	@JsonPostMapping
	public SystemLocatorOutputBean createSystemLocator(@RequestBody SystemLocatorInputBean body, HttpSession session) throws BusinessLayerException {


//      Segnalazione sm_3575 stato richiesta dal team Nello di rimuovere questa istruzione 16.6.2017		
//		if(body.getServizio() != null) {
//			body.setServizio(body.getServizio().replace(StringUtils.SPACE, StringUtils.EMPTY));
//		}
		
		if(body.getCodiceOlo() == null) {
			UserBean user = getCurrentUser(session);
			body.setCodiceOlo(user.getCodificaOloAgcom());
		}

		SystemLocatorOutputBean bean = systemLocatorManagerBL.createSystemLocator(body);

		if (bean != null) {
			logger.debug("System Locator found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("System Locator NOT found");
			bean = new SystemLocatorOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}
}
