package com.nttdata.tim.now.web.controller.anagrafica;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.GestioneAutonomaManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.gestioneautonoma.AssociazioneOaoImpresaAreaOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1393
@RestController
@RequestMapping("/gestioneAutonoma")
public class GestioneAutonomaController extends GenericController {

    @Autowired
    private GestioneAutonomaManagerBL gestioneAutonomaManagerBL;
       
    @JsonGetMapping("/associazioneOao/list")
    public GenericListBean<AssociazioneOaoImpresaAreaOutputBean> getList(HttpSession session)
			throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        GenericListBean<AssociazioneOaoImpresaAreaOutputBean> bean = gestioneAutonomaManagerBL.getList(user.getCodificaOloAgcom(), user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
	}
}
