package com.nttdata.tim.now.web.controller.filenotifiche;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.filenotifiche.StatoFileManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.semaforo.RisottomissioneOutputBean;
import com.nttdata.tim.now.data.bean.semaforo.SemaforoOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.ProfiloCRM;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filestate")
public class StatoFileController extends GenericController {

    @Autowired
    private StatoFileManagerBL statoFileManagerBL;
    
	// File -> Visualizzazione Semaforo
	@JsonGetMapping("/order_request")
	public GenericListBean<SemaforoOutputBean> getOrderRequestFilesState(@RequestParam(value = "selectedOLO", required = false) String selectedOLO, HttpSession session) throws BusinessLayerException {
		logger.info("get getOrderRequestFilesState");
		UserBean user = getCurrentUser(session);
		String codOloAgcom = StringUtils.defaultString(selectedOLO, user.getCodificaOloAgcom());
		String codiceProfilo = this.getCodiceProfilo(user);
		GenericListBean<SemaforoOutputBean> bean = statoFileManagerBL.getOrderRequestFileState(codOloAgcom, codiceProfilo, user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Risottometti File
	@JsonGetMapping("/order_request/{idFile}") //SM_7978 - La chiamata al servizio viene effettuata passando idFile in queryString
	public RisottomissioneOutputBean risottomissione(@PathVariable String idFile, HttpSession session) throws BusinessLayerException {
	    logger.info("get risottomissione");
		UserBean user = getCurrentUser(session);
	    RisottomissioneOutputBean bean = statoFileManagerBL.risottomissione(idFile, user.getCodiceProfilo());
	    bean = ensureBeanResult(bean, RisottomissioneOutputBean.class);
	    return bean;
	}

	// Ricerca Avanzata export
	@JsonPostMapping("/search")
	public GenericListBean<SemaforoOutputBean> search(@RequestBody RicercaAvanzataInputBean body, @RequestParam(value = "selectedOLO", required = false) String selectedOLO, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		String codOloAgcom = StringUtils.defaultString(selectedOLO, user.getCodificaOloAgcom());
		String codiceProfilo = this.getCodiceProfilo(user);
		GenericListBean<SemaforoOutputBean> bean = statoFileManagerBL.advancedSearch(body, codOloAgcom, codiceProfilo, user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ricerca Avanzata export
	@JsonPostMapping("/export")
	public ExportableDataOutputBean requestExport(@RequestBody RicercaAvanzataInputBean body, @RequestParam(value = "selectedOLO", required = false) String selectedOLO, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		String codOloAgcom = StringUtils.defaultString(selectedOLO, user.getCodificaOloAgcom());
		String codiceProfilo = this.getCodiceProfilo(user);
		ExportableDataOutputBean bean = statoFileManagerBL.requestExport(body, codOloAgcom, codiceProfilo, user.getUserId());
		ensureBeanResult(bean, ExportableDataOutputBean.class);
		return bean;
	}

	
	/**
	 * Porcata richiesta da Nello. In caso di profili non OLO viene passato il
	 * profilo CRM_OLO oltre al codice olo agcom per forzare la visualizzazione
	 * di un singolo olo.
	 * 
	 * @param user l'utente corrente 
	 * @return il codice profilo 
	 */
	private String getCodiceProfilo(UserBean user) {
		//String codiceProfilo = user.getCodiceProfilo();
		//if (!ProfiloCRM.CRM_DG.name().equals(codiceProfilo)) {
		//	codiceProfilo = ProfiloCRM.CRM_OLO.name();
		//}
		//return codiceProfilo;
		return ProfiloCRM.CRM_OLO.name();
	}

}
