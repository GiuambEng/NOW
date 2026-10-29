package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.NodiManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.nodi.NodoOutputBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1058
@RestController
@RequestMapping("/nodi")
public class NodiController extends GenericController {

    @Autowired
    private NodiManagerBL nodiManagerBL;
    
    // Lista
    @JsonGetMapping
    public GenericListBean<NodoOutputBean> getList(HttpSession session) throws BusinessLayerException {

        GenericListBean<NodoOutputBean> bean = nodiManagerBL.getList();
        bean = ensureListBeanResult(bean);
        return bean;
    }    
}
