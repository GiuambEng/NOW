package com.nttdata.tim.now.core.service.pps;

import com.nttdata.tim.now.adapters.esb.ordine.ProgettoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.progetto.ProgettoOutputBean;
import com.nttdata.tim.now.data.dto.progetto.ListaProgettiOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgettoManagerBL extends AbstractBL {

	@Autowired
	private ProgettoRESTClient progettoRestClient;

	public GenericListBean<ProgettoOutputBean> getProjects(String codiceAgcom, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<ProgettoOutputBean> list = new GenericListBean<>();
		try {
			ListaProgettiOutputDTO dto = progettoRestClient.getProjects(codiceAgcom, tipoProfilo);
	         validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getCodiciProgetto(), ProgettoOutputBean.class));
		} catch (Exception e) {
			logger.error("Error reading projects", e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

}
