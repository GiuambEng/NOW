package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.FiberstreamRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ordine.fiberstream.CodiceVlanFiberstreamInputBean;
import com.nttdata.tim.now.data.bean.ordine.fiberstream.CodiceVlanFiberstreamOutputBean;
import com.nttdata.tim.now.data.bean.ordine.fiberstream.NomeServizioAggiuntivoFiberstreamOutputBean;
import com.nttdata.tim.now.data.bean.ordine.fiberstream.TipologiaApparatoFiberstreamOutputBean;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.CodiceVlanFiberstreamInputDTO;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.ListaApparatiFiberstreamOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.ListaCodiceVlanFiberstreamOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.ListaNomeServizioAggiuntivoFiberstreamOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.fiberstream.TipologiaApparatoFiberstreamOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1462
@Service
public class FiberstreamManagerBL extends AbstractBL {

	@Autowired
	private FiberstreamRESTClient fiberstreamRestClient;


	public GenericListBean<CodiceVlanFiberstreamOutputBean> getVlanFiberstream(CodiceVlanFiberstreamInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<CodiceVlanFiberstreamOutputBean> list = new GenericListBean<>();
		try {
			CodiceVlanFiberstreamInputDTO inputDto = mapper.translate(inputBean, CodiceVlanFiberstreamInputDTO.class);
			ListaCodiceVlanFiberstreamOutputDTO dto = fiberstreamRestClient.getVlanFiberstream(inputDto, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getAttributi(), CodiceVlanFiberstreamOutputBean.class));

		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		return list;
	}
	
	public GenericListBean<NomeServizioAggiuntivoFiberstreamOutputBean> getNomeServizioAggiuntivoFiberstream(String tipoProfilo) throws BusinessLayerException {
		GenericListBean<NomeServizioAggiuntivoFiberstreamOutputBean> list = new GenericListBean<>();
		try {
			ListaNomeServizioAggiuntivoFiberstreamOutputDTO dto = fiberstreamRestClient.getNomeServizioAggiuntivoFiberstream(tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getNomeServizio(), NomeServizioAggiuntivoFiberstreamOutputBean.class));

		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}
	
	public TipologiaApparatoFiberstreamOutputBean getTipologiaApparatoFiberstream(String codiceNmu, String tipoProfilo) throws BusinessLayerException {
		TipologiaApparatoFiberstreamOutputBean bean = new TipologiaApparatoFiberstreamOutputBean();
		try {
			TipologiaApparatoFiberstreamOutputDTO dto = fiberstreamRestClient.getTipologiaApparatoFiberstream(codiceNmu, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, TipologiaApparatoFiberstreamOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	public GenericListBean<String> getApparatiFiberstream(String codiceNmuLight, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<String> list = new GenericListBean<>();
		try {
			ListaApparatiFiberstreamOutputDTO dto = fiberstreamRestClient.getApparatiFiberstream(codiceNmuLight, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getCodiceNmu(), String.class));

		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}
	
}
