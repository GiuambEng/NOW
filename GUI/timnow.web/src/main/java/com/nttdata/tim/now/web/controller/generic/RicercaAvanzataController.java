package com.nttdata.tim.now.web.controller.generic;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.DuplicateEntryException;
import com.nttdata.tim.now.core.service.generic.RicercaAvanzataManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.ricerca.RicercaCampiOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.SalvaRicercaBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/advancedsearch")
public class RicercaAvanzataController extends GenericController {

    
    @Autowired
    private RicercaAvanzataManagerBL ricercaAvanzata;
    
	// Ricerca Avanzata -> Ricerca Campi
    //R1F-21-0411
	@JsonGetMapping("/fields/{tipoLista:[A-Za-z0-9:_ ]+}")
	public GenericListBean<RicercaCampiOutputBean> getFieldsResearch(@PathVariable String tipoLista, @RequestParam(required = false) String flagHashing, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<RicercaCampiOutputBean> bean = ricercaAvanzata.getFieldsResearch(tipoLista, user.getCodiceProfilo(), flagHashing);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Salva Ricerca
	@JsonGetMapping("/{codFunzione:[A-Za-z0-9:_ ]+}")
	public GenericListBean<SalvaRicercaBean> getSaveResearch(@PathVariable String codFunzione, HttpSession session)	throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<SalvaRicercaBean> bean = ricercaAvanzata.getSaveResearch(user.getUserId(), codFunzione);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Salva Ricerca
	@JsonPostMapping("/{codFunzione:[A-Za-z0-9:_ ]+}/{operationType}")
	public EmptyBean createSaveResearch(@RequestBody SalvaRicercaBean body, @PathVariable String codFunzione, HttpSession session, @PathVariable String operationType) throws BusinessLayerException {
		EmptyBean result;
		try {
			UserBean user = getCurrentUser(session);
			ricercaAvanzata.createSaveResearch(body, user.getUserId(), codFunzione);
			result = getSuccessEmptyBean();
		} catch (DuplicateEntryException e) {
			logger.warn("Duplicate entry error", e);
			ResultCodeEnum code = ResultCodeEnum.ALREADY_EXISTS;
			result = getEmptyBean(new Result(code.getCode(), "", code.getMessage()));
		}
		return result;
	}

	// Delete Salva Ricerca
	//change for RU 532 from delete to get
	@JsonGetMapping("/{codFunzione:[A-Za-z0-9:_ ]+}/{operationType}")
	public EmptyBean deleteSaveResearch(@RequestParam(value = "nomeFiltro") String nomeFiltro, @PathVariable String codFunzione, HttpSession session, @PathVariable String operationType ) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		ricercaAvanzata.deleteSaveResearch(user.getUserId(), codFunzione, nomeFiltro);
		return getSuccessEmptyBean();
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request)
    {
       binder.setAllowedFields("description","nomeFiltro","userId","codFunzione","timestampInserimento","filters");
    }


}
