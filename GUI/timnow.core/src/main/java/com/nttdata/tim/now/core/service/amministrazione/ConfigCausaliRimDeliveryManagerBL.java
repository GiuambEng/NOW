package com.nttdata.tim.now.core.service.amministrazione;

import com.nttdata.tim.now.adapters.esb.amministrazione.ConfigCausaliRimDeliveryRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.configcausali.ConfigCausaliRimDeliveryOutputBean;
import com.nttdata.tim.now.data.bean.configcausali.ListaModificaConfigCausaliRimDeliveryInputBean;
import com.nttdata.tim.now.data.bean.configcausali.ModificaConfigCausaliRimDeliveryOutputBean;
import com.nttdata.tim.now.data.dto.configcausali.ListaConfigCausaliRimDeliveryOutputDTO;
import com.nttdata.tim.now.data.dto.configcausali.ListaModificaConfigCausaliRimDeliveryInputDTO;
import com.nttdata.tim.now.data.dto.configcausali.ListaModificaConfigCausaliRimDeliveryOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigCausaliRimDeliveryManagerBL extends AbstractBL {

	@Autowired
	private ConfigCausaliRimDeliveryRESTClient configCausaliRimDeliveryRestIL;

	public GenericListBean<ConfigCausaliRimDeliveryOutputBean> getLista(String flagEsplicita, String profilo)
			throws BusinessLayerException {
		GenericListBean<ConfigCausaliRimDeliveryOutputBean> bean = new GenericListBean<>();
		try {
			ListaConfigCausaliRimDeliveryOutputDTO dto = configCausaliRimDeliveryRestIL.getLista(flagEsplicita, profilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getListaConfig(), ConfigCausaliRimDeliveryOutputBean.class));
		} catch (Exception e) {
			logger.error("Error getting config causali rim delivery list", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<ModificaConfigCausaliRimDeliveryOutputBean> modificaLista(
			ListaModificaConfigCausaliRimDeliveryInputBean inputBean, String profilo) throws BusinessLayerException {
		GenericListBean<ModificaConfigCausaliRimDeliveryOutputBean> bean = new GenericListBean<>();
		try {
			ListaModificaConfigCausaliRimDeliveryInputDTO dtoInput = mapper.translate(inputBean,
					ListaModificaConfigCausaliRimDeliveryInputDTO.class);
			ListaModificaConfigCausaliRimDeliveryOutputDTO dto = configCausaliRimDeliveryRestIL.modificaLista(dtoInput, profilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getListaConfig(), ModificaConfigCausaliRimDeliveryOutputBean.class));

		} catch (Exception e) {
			logger.error("Error modify config causali rim delivery list", e);
			throw new BusinessLayerException(e);
		}

		return bean;
	}

	public GenericListBean<ModificaConfigCausaliRimDeliveryOutputBean> deleteLista(
			ListaModificaConfigCausaliRimDeliveryInputBean inputBean, String profilo) throws BusinessLayerException {
		GenericListBean<ModificaConfigCausaliRimDeliveryOutputBean> bean = new GenericListBean<>();
		try {
			ListaModificaConfigCausaliRimDeliveryInputDTO dtoInput = mapper.translate(inputBean,
					ListaModificaConfigCausaliRimDeliveryInputDTO.class);
			ListaModificaConfigCausaliRimDeliveryOutputDTO dto = configCausaliRimDeliveryRestIL.deleteLista(dtoInput, profilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getListaConfig(), ModificaConfigCausaliRimDeliveryOutputBean.class));

		} catch (Exception e) {
			logger.error("Error delete config causali rim delivery list", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
