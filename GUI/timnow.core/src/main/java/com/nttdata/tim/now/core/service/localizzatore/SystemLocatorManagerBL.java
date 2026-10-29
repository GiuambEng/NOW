package com.nttdata.tim.now.core.service.localizzatore;

import com.nttdata.tim.now.adapters.esb.localizzatore.SystemLocatorRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.locator.SystemLocatorInputBean;
import com.nttdata.tim.now.data.bean.locator.SystemLocatorOutputBean;
import com.nttdata.tim.now.data.dto.locator.SystemLocatorInputDTO;
import com.nttdata.tim.now.data.dto.locator.SystemLocatorOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemLocatorManagerBL extends AbstractBL {

	@Autowired
	private SystemLocatorRESTClient systemLocatorRestIL;

	public SystemLocatorOutputBean createSystemLocator(SystemLocatorInputBean body) throws BusinessLayerException {
		SystemLocatorOutputBean bean = null;
		try {
			SystemLocatorInputDTO dtoInput = mapper.translate(body, SystemLocatorInputDTO.class);
			SystemLocatorOutputDTO dtoOutput = systemLocatorRestIL.createSystemLocator(dtoInput);
	         validateResponseResult(dtoOutput);
			bean = mapper.translate(dtoOutput, SystemLocatorOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
