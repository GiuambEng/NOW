package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.OrdineTrackingRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ordine.tracking.OrderTrackingInputBean;
import com.nttdata.tim.now.data.bean.ordine.tracking.OrderTrackingOutputBean;
import com.nttdata.tim.now.data.bean.ordine.tracking.OrderTrackingOutputLevel2Bean;
import com.nttdata.tim.now.data.dto.ordine.tracking.OrderTrackingInputLevel2DTO;
import com.nttdata.tim.now.data.dto.ordine.tracking.OrderTrackingListLevel2OutputDTO;
import com.nttdata.tim.now.data.dto.ordine.tracking.OrderTrackingListOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataRecoveryManagerBL extends AbstractBL {

	@Autowired
	private OrdineTrackingRESTClient orderTrackingRestIL;

	public GenericListBean<OrderTrackingOutputBean> getOrderTracking(String idRichiestaOlo, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<OrderTrackingOutputBean> list = new GenericListBean<>();
		try {
			OrderTrackingListOutputDTO dtoOutput = orderTrackingRestIL.getOrderTracking(idRichiestaOlo, tipoProfilo);
			list.setData(mapper.translateList(dtoOutput.getDataRecoveries(), OrderTrackingOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		return list;
	}

	public GenericListBean<OrderTrackingOutputLevel2Bean> getOrderTrackingLevel2(OrderTrackingInputBean inputBean) throws BusinessLayerException {
		GenericListBean<OrderTrackingOutputLevel2Bean> list = new GenericListBean<OrderTrackingOutputLevel2Bean>();
		try {
			OrderTrackingInputLevel2DTO inputDTO = mapper.translate(inputBean, OrderTrackingInputLevel2DTO.class);
			OrderTrackingListLevel2OutputDTO dtoOutput = orderTrackingRestIL.getOrderTrackingLevel2(inputDTO);
			list.setData(mapper.translateList(dtoOutput.getOutTracciamentoObj2(), OrderTrackingOutputLevel2Bean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		return list;
	}

}
