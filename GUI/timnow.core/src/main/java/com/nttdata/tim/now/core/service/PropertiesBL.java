package com.nttdata.tim.now.core.service;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.integrationlayer.PropertiesIL;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.stereotype.Component;

@Component(PropertiesBL.BEAN_NAME)
public class PropertiesBL extends AbstractBL {

	public static final String BEAN_NAME = "propertiesBL";

	public void reloadProperties() throws BusinessLayerException {
		try {
			PropertiesIL.loadProperties();
		} catch (IntegrationLayerException e) {
			throw new BusinessLayerException(e);
		}
	}

}
