package com.nttdata.tim.now.web.controller.offerta;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.offerta.TDManagerBL;
import com.nttdata.tim.now.data.bean.td.ListaCodiciTdOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tdCodes")
public class TDController extends GenericController {

    @Autowired
    private TDManagerBL tdManagerBL;
    
	@JsonGetMapping("/{codOlo}")
	public ListaCodiciTdOutputBean getCodes(@PathVariable String codOlo, HttpSession session) throws BusinessLayerException {

		UserBean user  = getCurrentUser(session);
		ListaCodiciTdOutputBean bean = tdManagerBL.getTdCodes(codOlo, user.getCodiceProfilo());

		if (bean != null && bean.getCodiciTD() != null) {
			logger.debug("TD Codes found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("TD Codes NOT found");
			bean = new ListaCodiciTdOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}
}
