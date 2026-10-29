package com.nttdata.tim.now.web.controller.offerta;

import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.offerta.CpeManagerBL;
import com.nttdata.tim.now.data.bean.cpe.CpeWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_921
@RestController
@RequestMapping("/cpes")
public class CpeController extends GenericController {
    
    @Autowired
    private CpeManagerBL cpeManagerBL;

	// Nuovo Ordine -> Configurazione offerta FWA step 4 
	@JsonGetMapping
	public CpeWrapperOutputBean getCpeList(@QueryParam("profiloFwa") String profiloFwa, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
		CpeWrapperOutputBean bean = cpeManagerBL.getCpeList(user.getCodiceProfilo(), profiloFwa);
		bean = ensureBeanResult(bean, CpeWrapperOutputBean.class);
		return bean;
	}

}
