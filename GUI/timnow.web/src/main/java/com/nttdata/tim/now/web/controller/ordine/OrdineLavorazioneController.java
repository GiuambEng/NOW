package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.OrdineLavorazioneManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ordine.lavorazione.RecuperoTipologiaLavorazioneOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordine-lavorazione")
public class OrdineLavorazioneController extends GenericController {

    @Autowired
    private OrdineLavorazioneManagerBL ordineLavorazioneManagerBL;

    @JsonGetMapping
    public GenericListBean<RecuperoTipologiaLavorazioneOutputBean> getTipologiaLavorazione(HttpSession session) throws BusinessLayerException {

    	UserBean  user = getCurrentUser(session);
        GenericListBean<RecuperoTipologiaLavorazioneOutputBean> bean = ordineLavorazioneManagerBL.getTipologiaLavorazione(user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }

}
