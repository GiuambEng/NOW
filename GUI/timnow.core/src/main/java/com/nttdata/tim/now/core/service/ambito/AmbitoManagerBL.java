package com.nttdata.tim.now.core.service.ambito;

import com.nttdata.tim.now.adapters.esb.ambito.AmbitoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.ambito.AmbitoOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.dto.ambito.ListaAmbitiOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmbitoManagerBL extends AbstractBL {

	@Autowired
	private AmbitoRESTClient ambitoRESTClient;

	public GenericListBean<AmbitoOutputBean> getList() throws BusinessLayerException {
		GenericListBean<AmbitoOutputBean> bean = new GenericListBean<>();
		try {
			ListaAmbitiOutputDTO dto = ambitoRESTClient.getList();
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getList(), AmbitoOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
}
