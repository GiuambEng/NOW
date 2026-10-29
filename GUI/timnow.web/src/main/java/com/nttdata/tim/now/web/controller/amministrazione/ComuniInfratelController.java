package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.ComuniInfratelManagerBL;
import com.nttdata.tim.now.data.bean.anagraficainfratel.AnagraficaComuneInfratelOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1078
@RestController
@RequestMapping("/comuniInfratel")
public class ComuniInfratelController extends GenericController {

    @Autowired
    private ComuniInfratelManagerBL comuniInfratelManagerBL;
    
    // Lista
    @JsonGetMapping
    public GenericListBean<AnagraficaComuneInfratelOutputBean> getList(HttpSession session) throws BusinessLayerException {

        UserBean user = getCurrentUser(session);
        GenericListBean<AnagraficaComuneInfratelOutputBean> bean = comuniInfratelManagerBL.getList(user.getUserId(), user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
    }    
}
