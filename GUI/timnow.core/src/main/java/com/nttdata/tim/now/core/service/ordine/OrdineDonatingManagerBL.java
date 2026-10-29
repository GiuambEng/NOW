package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.OrdineDonatingRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ordine.donating.OrdineDonatingDetailListOutputBean;
import com.nttdata.tim.now.data.bean.ordine.donating.OrdineDonatingDetailOutputBean;
import com.nttdata.tim.now.data.bean.ordine.donating.OrdineDonatingInputBean;
import com.nttdata.tim.now.data.bean.ordine.donating.OrdineDonatingOutputBean;
import com.nttdata.tim.now.data.bean.ordine.donating.OrdineDonatingRichiesteOutputBean;
import com.nttdata.tim.now.data.dto.ordine.donating.OrdineDonatingDetailListOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.donating.OrdineDonatingInputDTO;
import com.nttdata.tim.now.data.dto.ordine.donating.OrdineDonatingListOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineDonatingManagerBL extends AbstractBL {

	@Autowired
	private OrdineDonatingRESTClient ordineDonatingRestIL;
	
	public GenericListBean<OrdineDonatingOutputBean> getList(OrdineDonatingInputBean input, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<OrdineDonatingOutputBean> bean = new GenericListBean<>();
		try {
			OrdineDonatingInputDTO inputDto = mapper.translate(input, OrdineDonatingInputDTO.class);
			OrdineDonatingListOutputDTO list = ordineDonatingRestIL.getList(inputDto, tipoProfilo);
			validateResponseResult(list);
			bean.setData(mapper.translateList(list.getList(), OrdineDonatingOutputBean.class));
		} catch(Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	public OrdineDonatingDetailListOutputBean getDetailList(String idRichiestaOLO, String tipoProfilo) throws BusinessLayerException {
		OrdineDonatingDetailListOutputBean bean = new OrdineDonatingDetailListOutputBean();
		try {
			OrdineDonatingDetailListOutputDTO list = ordineDonatingRestIL.getDetailList(idRichiestaOLO, tipoProfilo);
			validateResponseResult(list);
			bean.setList(mapper.translateList(list.getList(), OrdineDonatingDetailOutputBean.class));
			bean.setListRichieste(mapper.translateList(list.getListRichieste(), OrdineDonatingRichiesteOutputBean.class));
			
		} catch(Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
}
