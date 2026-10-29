package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.MonitoraggioRigenerazioneMailManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.rigenerazionemail.ListaRichiesteMonitoraggioRigenerazioneMailOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.rigenerazionemail.NotificheMonitoraggioRigenerazioneMailOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.rigenerazionemail.RinvioNotificheMonitoraggioRigenerazioneMailListInputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/monitoraggio-rigenerazione-mail")
public class MonitoraggioRigenerazioneMailController extends GenericController {

    @Autowired
    private MonitoraggioRigenerazioneMailManagerBL monitoraggioRigenerazioneMailManagerBL;

	// Ricerca Avanzata export
	@JsonPostMapping("/search")
	public ListaRichiesteMonitoraggioRigenerazioneMailOutputBean search(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		ListaRichiesteMonitoraggioRigenerazioneMailOutputBean bean = monitoraggioRigenerazioneMailManagerBL.advancedSearch(body, user.getCodiceProfilo(), user.getUserId());
		bean = ensureBeanResult(bean, ListaRichiesteMonitoraggioRigenerazioneMailOutputBean.class);
		return bean;
	}

	// da riscrivere totalmente----------------------------------------
	@JsonPostMapping("/invioNotifiche")
	public GenericListBean<CodiceOutputBean> invioNotifiche(@RequestBody RinvioNotificheMonitoraggioRigenerazioneMailListInputBean listaNotifiche, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<CodiceOutputBean> bean = monitoraggioRigenerazioneMailManagerBL.invioNotifiche(listaNotifiche, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}
    //-------------------------------------------------------------------  
	
	@JsonGetMapping("/listaNotifiche/{idRichiestaOlo}")
	public GenericListBean<NotificheMonitoraggioRigenerazioneMailOutputBean> getListaNotifiche(@PathVariable String idRichiestaOlo, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<NotificheMonitoraggioRigenerazioneMailOutputBean> bean = monitoraggioRigenerazioneMailManagerBL.getListaNotifiche(idRichiestaOlo, user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request)
    {
       binder.setAllowedFields("indiceriga","numerorighe","tipoprofilo","cod_olo","exportRequest","conditions","listaNotifiche");
    }

}
