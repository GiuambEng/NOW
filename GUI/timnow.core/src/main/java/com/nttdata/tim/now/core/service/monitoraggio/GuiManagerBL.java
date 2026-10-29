package com.nttdata.tim.now.core.service.monitoraggio;

import com.nttdata.tim.now.adapters.esb.monitoraggio.GuiRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.gui.VisualizzazioneGuiOutputBean;
import com.nttdata.tim.now.data.dto.gui.ListaVisualizzazioneGuiOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuiManagerBL extends AbstractBL {

	@Autowired
	private GuiRESTClient guiRestIL;

	public GenericListBean<VisualizzazioneGuiOutputBean> getGui(String tipoProfilo) throws BusinessLayerException {
		GenericListBean<VisualizzazioneGuiOutputBean> bean = new GenericListBean<>();
		try {
			ListaVisualizzazioneGuiOutputDTO dto = guiRestIL.getGui(tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getGuis(), VisualizzazioneGuiOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		return bean;
	}

}
