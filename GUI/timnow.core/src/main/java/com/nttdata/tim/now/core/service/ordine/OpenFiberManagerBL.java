package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.OpenFiberRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.eventiopenfiber.EventoOpenFiberOutputBean;
import com.nttdata.tim.now.data.dto.eventiopenfiber.ListaEventiOpenFiberOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1492
@Service
public class OpenFiberManagerBL extends AbstractBL {

	@Autowired
	private OpenFiberRESTClient openFiberRestIL;

	public GenericListBean<EventoOpenFiberOutputBean> getEventi(String tipoprofilo, String idRichiesta) throws BusinessLayerException {
		GenericListBean<EventoOpenFiberOutputBean> list = new GenericListBean<>();
		try {
			ListaEventiOpenFiberOutputDTO dto = openFiberRestIL.getEventi(tipoprofilo, idRichiesta);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getEventiOF(), EventoOpenFiberOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

}
