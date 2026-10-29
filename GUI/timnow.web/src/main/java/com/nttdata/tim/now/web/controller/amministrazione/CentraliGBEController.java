package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.CentraliGBEManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.centraligbe.CentraleGBEOutputBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1058
@RestController
@RequestMapping("/centraliGBE")
public class CentraliGBEController extends GenericController {

    @Autowired
    private CentraliGBEManagerBL centraliGBEManagerBL;
    
    // Lista
    @JsonGetMapping
    public GenericListBean<CentraleGBEOutputBean> getList(HttpSession session) throws BusinessLayerException {

        GenericListBean<CentraleGBEOutputBean> bean = centraliGBEManagerBL.getList();
        bean = ensureListBeanResult(bean);
        return bean;
    }    
}
