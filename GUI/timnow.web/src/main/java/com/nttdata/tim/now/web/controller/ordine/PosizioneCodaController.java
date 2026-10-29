package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.PosizioneCodaManagerBL;
import com.nttdata.tim.now.data.bean.posizionecoda.PosizioneCodaOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/positions")
public class PosizioneCodaController extends GenericController {

    @Autowired
    private PosizioneCodaManagerBL posizioneCodaManagerBL;
    
	// Visualizzazione Posizione Coda
	//@JsonGetMapping("/{idRichiesta:[A-Za-z0-9:_]+}")
    @JsonGetMapping
	public PosizioneCodaOutputBean getQueuePosition(@RequestParam(value = "idRisorsa", required = true) String idRisorsa, HttpSession session) throws BusinessLayerException { //@PathVariable String idRichiesta
		logger.info("get queue positions");
		UserBean  user = getCurrentUser(session);
		PosizioneCodaOutputBean bean = posizioneCodaManagerBL.getQueuePosition(idRisorsa, user.getCodiceProfilo());

		if (bean != null) {
			logger.debug("Queue Position found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Queue Position NOT found");
			bean = new PosizioneCodaOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}
}
