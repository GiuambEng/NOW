package com.nttdata.tim.now.web.controller.anagrafica;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.RadiusManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.radius.ListaRadiusOutputBean;
import com.nttdata.tim.now.data.bean.radius.RadiusOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

@RestController
@RequestMapping("/radius")
public class RadiusController extends GenericController {
	
    @Autowired
    private RadiusManagerBL radiusManagerBL;

    @JsonGetMapping
	public GenericListBean<RadiusOutputBean> getRadiusList(HttpSession session) throws BusinessLayerException {
		logger.debug("getRadiusList");
		UserBean user = getCurrentUser(session);
		GenericListBean<RadiusOutputBean> bean = radiusManagerBL.getRadiusList(user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}
    
    // Ricerca Avanzata export
 	@JsonPostMapping("/export")
 	public ListaRadiusOutputBean requestExport(@RequestBody RicercaAvanzataInputBean body, HttpSession session)
 			throws BusinessLayerException {
 		UserBean user = getCurrentUser(session);

 		ListaRadiusOutputBean bean = radiusManagerBL.requestExport(body, user.getCodificaOloAgcom(), user.getCodiceProfilo(), user.getUserId());

 		if (bean != null) {
 			logger.debug("Research found");
 			bean.setResult(getSuccessResult());
 		} else {
 			logger.debug("Research NOT found");
 			bean = new ListaRadiusOutputBean();
 			bean.setResult(getResultNotFound());
 		}

 		return bean;
 	}
	
}
