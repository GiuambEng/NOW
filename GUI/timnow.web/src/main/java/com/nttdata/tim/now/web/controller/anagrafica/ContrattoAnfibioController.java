package com.nttdata.tim.now.web.controller.anagrafica;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.ContrattoAnfibioManagerBL;
import com.nttdata.tim.now.data.bean.contratto.ContrattoAnfibioOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contracts")
public class ContrattoAnfibioController extends GenericController {

    @Autowired
    private ContrattoAnfibioManagerBL contrattoAnfibioManagerBL;
    
	// Contratto -> Visualizza Contratto Olo
	@JsonGetMapping("/anfibio/{idContratto}")
	public ContrattoAnfibioOutputBean getAnfibioContract(@PathVariable String idContratto, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		ContrattoAnfibioOutputBean bean = contrattoAnfibioManagerBL.getAnfibioContract(idContratto, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, ContrattoAnfibioOutputBean.class);
		return bean;
	}

}
