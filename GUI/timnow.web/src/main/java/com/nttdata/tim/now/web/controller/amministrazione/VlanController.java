package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.VlanManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.vlan.VlanOutputBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1058
@RestController
@RequestMapping("/vlan")
public class VlanController extends GenericController {

    @Autowired
    private VlanManagerBL vlanManagerBL;
    
    // Lista
    @JsonGetMapping
    public GenericListBean<VlanOutputBean> getList(HttpSession session) throws BusinessLayerException {

        GenericListBean<VlanOutputBean> bean = vlanManagerBL.getList();
        bean = ensureListBeanResult(bean);
        return bean;
    }    
}
