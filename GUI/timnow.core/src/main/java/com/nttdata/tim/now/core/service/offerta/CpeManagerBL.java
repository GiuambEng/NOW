package com.nttdata.tim.now.core.service.offerta;

import com.nttdata.tim.now.adapters.esb.offerta.CpeRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.cpe.CpeWrapperOutputBean;
import com.nttdata.tim.now.data.dto.cpe.CpeWrapperOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_921
@Service
public class CpeManagerBL extends AbstractBL {

	@Autowired
	private CpeRESTClient cpeRestIL;

	public CpeWrapperOutputBean getCpeList(String tipoProfilo, String codiceProfiloFwa) throws BusinessLayerException {
		CpeWrapperOutputBean bean = new CpeWrapperOutputBean();
		try {
			CpeWrapperOutputDTO dto = cpeRestIL.getCpeList(tipoProfilo, codiceProfiloFwa);
			validateResponseResult(dto);
			bean = mapper.translate(dto, CpeWrapperOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
