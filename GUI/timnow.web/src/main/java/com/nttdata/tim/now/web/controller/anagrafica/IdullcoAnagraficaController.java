package com.nttdata.tim.now.web.controller.anagrafica;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.IdullcoManagerBL;
import com.nttdata.tim.now.data.bean.anagraficaidullco.AnagraficaIdullcoOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/anagraficaIdullco")
public class IdullcoAnagraficaController extends GenericController {

    @Autowired
    private IdullcoManagerBL idullcoManagerBL;
    

	// Ricerca Avanzata
	@JsonPostMapping("/search")
	public GenericListBean<AnagraficaIdullcoOutputBean> search(@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<AnagraficaIdullcoOutputBean> bean = idullcoManagerBL.advancedSearch(body, user.getCodificaOloAgcom(), user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request)
    {
       binder.setAllowedFields("indiceriga","numerorighe","tipoprofilo","cod_olo","exportRequest","conditions");
    }

	
}
