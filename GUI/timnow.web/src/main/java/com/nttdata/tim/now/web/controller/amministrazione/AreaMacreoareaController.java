package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.AreaMacroareaManagerBL;
import com.nttdata.tim.now.data.bean.areamacroarea.AreaMacroareaOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1058
@RestController
@RequestMapping("/areaMacroarea")
public class AreaMacreoareaController extends GenericController {

    @Autowired
    private AreaMacroareaManagerBL areaMacroareaManagerBL;
    
    // Lista
    @JsonGetMapping
    public GenericListBean<AreaMacroareaOutputBean> getList(HttpSession session) throws BusinessLayerException {

        GenericListBean<AreaMacroareaOutputBean> bean = areaMacroareaManagerBL.getList();
        bean = ensureListBeanResult(bean);
        return bean;
    }    
}
