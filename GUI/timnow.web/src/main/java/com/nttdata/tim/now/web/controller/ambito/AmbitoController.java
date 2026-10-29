package com.nttdata.tim.now.web.controller.ambito;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ambito.AmbitoManagerBL;
import com.nttdata.tim.now.data.bean.ambito.AmbitoOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ambiti")
public class AmbitoController extends GenericController {
    
    @Autowired
    private AmbitoManagerBL ambitoManager;

    @JsonGetMapping
	public GenericListBean<AmbitoOutputBean> getList() throws BusinessLayerException {
		GenericListBean<AmbitoOutputBean> bean = ambitoManager.getList();
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
