package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.PuntiDiConsegnaManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.pdc.PuntoDiConsegnaOutputBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1058
@RestController
@RequestMapping("/pdc")
public class PuntiDiConsegnaController extends GenericController {

    @Autowired
    private PuntiDiConsegnaManagerBL puntiDiConsegnaManagerBL;
    
    // Lista
    @JsonGetMapping
    public GenericListBean<PuntoDiConsegnaOutputBean> getList(HttpSession session) throws BusinessLayerException {

        GenericListBean<PuntoDiConsegnaOutputBean> bean = puntiDiConsegnaManagerBL.getList();
        bean = ensureListBeanResult(bean);
        return bean;
    }    
}
