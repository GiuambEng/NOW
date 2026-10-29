package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.JpubRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.jpub.JpubOutputBean;
import com.nttdata.tim.now.data.dto.jpub.ListaJpubOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpubManagerBL extends AbstractBL {

	@Autowired
	private JpubRESTClient jpubRestIL;

	public GenericListBean<JpubOutputBean> getJpubs(String tipoprofilo, String idrichiestaolo) throws BusinessLayerException {
		GenericListBean<JpubOutputBean> list = new GenericListBean<>();
		try {
			ListaJpubOutputDTO dto = jpubRestIL.getJpubs(tipoprofilo, idrichiestaolo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getJpubs(), JpubOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

}
