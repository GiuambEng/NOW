package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.AllarmiKoGiornalieriManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.monitoring.kogiornalieri.AllarmeKoGiornalieroOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.kogiornalieri.RichiestaAllarmiKoGiornalieriOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alarms")
public class AllarmiKoGiornalieriController extends GenericController {

    
    @Autowired
    private AllarmiKoGiornalieriManagerBL allarmiKoGiornalieriManagerBL;
	// AllarmiKOGiornalieri -> Livello 0
	@JsonGetMapping("/level0")
	public GenericListExportBean<AllarmeKoGiornalieroOutputBean> getList(@RequestParam(value = "flagExport") boolean flagExport, 
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListExportBean<AllarmeKoGiornalieroOutputBean> bean = allarmiKoGiornalieriManagerBL.getAlarmsLevel0(flagExport, user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// AllarmiKOGiornalieri -> Livello 1
	@JsonGetMapping("/level1")
	public GenericListExportBean<RichiestaAllarmiKoGiornalieriOutputBean> getDetail(@RequestParam(value = "ambito") String ambito,
			@RequestParam(value = "codCausaleOlo") String codCausaleOlo, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListExportBean<RichiestaAllarmiKoGiornalieriOutputBean> bean = allarmiKoGiornalieriManagerBL.getAlarmsLevel1(ambito, codCausaleOlo, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
