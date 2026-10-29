package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.KitVlanManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.kitvlan.KitVlanOutputBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1058
@RestController
@RequestMapping("/kitVlan")
public class KitVlanController extends GenericController {

    @Autowired
    private KitVlanManagerBL kitVlanManagerBL;
    
    // Lista
    @JsonGetMapping
    public GenericListBean<KitVlanOutputBean> getList(HttpSession session) throws BusinessLayerException {

        GenericListBean<KitVlanOutputBean> bean = kitVlanManagerBL.getList();
        bean = ensureListBeanResult(bean);
        return bean;
    }    
}
