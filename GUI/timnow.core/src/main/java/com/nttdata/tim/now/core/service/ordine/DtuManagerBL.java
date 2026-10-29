package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.DtuRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.dtu.DettaglioDtuOutputBean;
import com.nttdata.tim.now.data.bean.dtu.DtuOutputBean;
import com.nttdata.tim.now.data.dto.dtu.DettaglioDtuWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.dtu.ListaDtuOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtuManagerBL extends AbstractBL {


	@Autowired
	private DtuRESTClient dtuRestIL;

	public DettaglioDtuOutputBean getDtu(String idEventoNow, String tipoprofilo, String progressivoEventoDtu, String idRichiestaOlo) throws BusinessLayerException {
		DettaglioDtuOutputBean bean = null;
		try {
			DettaglioDtuWrapperOutputDTO dto = dtuRestIL.getDtu(idEventoNow, tipoprofilo, progressivoEventoDtu, idRichiestaOlo);
			validateResponseResult(dto);
			bean = mapper.translate(dto.getDtu(), DettaglioDtuOutputBean.class);
		} catch (Exception e) {
			logger.error("Error reading dtu by id richiesta", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<DtuOutputBean> getDtus(String tipoprofilo, String idrichiestaolo) throws BusinessLayerException {
		GenericListBean<DtuOutputBean> list = new GenericListBean<>();
		try {
			ListaDtuOutputDTO dto = dtuRestIL.getDtus(tipoprofilo, idrichiestaolo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getDtus(), DtuOutputBean.class));
		} catch (Exception e) {
			logger.error("Error reading dtus", e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

}
