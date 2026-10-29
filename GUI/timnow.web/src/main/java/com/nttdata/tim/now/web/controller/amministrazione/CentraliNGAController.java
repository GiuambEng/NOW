package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.CentraliNGAManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.centralinga.CentraleNGAOutputBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1058
@RestController
@RequestMapping("/centraliNGA")
public class CentraliNGAController extends GenericController {

    @Autowired
    private CentraliNGAManagerBL centraliNGAManagerBL;
    
    // Lista
    @JsonGetMapping
    public GenericListBean<CentraleNGAOutputBean> getList(HttpSession session) throws BusinessLayerException {

        GenericListBean<CentraleNGAOutputBean> bean = centraliNGAManagerBL.getList();
        bean = ensureListBeanResult(bean);
        return bean;
    }    
}
