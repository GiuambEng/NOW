package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.IdullcoManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.idullco.IdullcoOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idullcos")
public class IdullcoController extends GenericController {

    @Autowired 
    private IdullcoManagerBL idullcoManagerBL;
    
	// Utility -> Visualizza IDULLCO
	@JsonGetMapping
	public GenericListBean<IdullcoOutputBean> getIdullcosByAgcom(
			@RequestParam(value = "codOLO") String codOLO,
			@RequestParam(value = "valoreRicerca") String valoreRicerca, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<IdullcoOutputBean> bean = idullcoManagerBL.getIdullcos(codOLO, valoreRicerca, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
