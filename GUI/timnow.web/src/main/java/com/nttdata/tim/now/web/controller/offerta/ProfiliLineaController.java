package com.nttdata.tim.now.web.controller.offerta;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.offerta.ProfiloLineaManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.profilolinea.ProfiloLineaOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lines")
public class ProfiliLineaController extends GenericController {

    
    @Autowired
    private ProfiloLineaManagerBL profiloManagerBL;
    
	// Profili Linea -> Profili Linea
	@JsonGetMapping
	public GenericListBean<ProfiloLineaOutputBean> getLineProfiles(HttpSession session) throws BusinessLayerException {
		logger.info("get Line Profiles");
		UserBean user = getCurrentUser(session); 
		GenericListBean<ProfiloLineaOutputBean> bean = profiloManagerBL.getLineProfiles(user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Nuovo Ordine -> Profili Linea
	@JsonGetMapping("/{idOfferta:[A-Za-z0-9_:]+}")
	public GenericListBean<ProfiloLineaOutputBean> getNewOrderLineProfiles(@PathVariable String idOfferta,
			@RequestParam(value = "modulazione", required = false) String modulazione,
			@RequestParam(value = "caratteristica", required = false) String caratteristica,  
			@RequestParam(value = "protocollo", required = false) String protocollo, HttpSession session) throws BusinessLayerException { //SM_8252
		logger.info("get Line Profiles");
		UserBean user = getCurrentUser(session); 
		GenericListBean<ProfiloLineaOutputBean> bean = profiloManagerBL.getLineProfilesByOffer(idOfferta, modulazione, caratteristica, user.getCodiceProfilo(), protocollo); //SM_8252
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ricerca Avanzata
	@JsonPostMapping("/search")
	public GenericListBean<ProfiloLineaOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session); 
		GenericListBean<ProfiloLineaOutputBean> bean = profiloManagerBL.advancedSearch(body, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
