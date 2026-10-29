package com.nttdata.tim.now.core.service.pps;

import com.nttdata.tim.now.adapters.esb.pps.PpsRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.pps.AmbitoMonitoraggioOutputBean;
import com.nttdata.tim.now.data.bean.pps.AmministrazioneDatiOutputBean;
import com.nttdata.tim.now.data.bean.pps.DettaglioAmministrazioneDatiOutputBean;
import com.nttdata.tim.now.data.bean.pps.SogliaInputBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.pps.ListaAmbitiMonitoraggioOutputDTO;
import com.nttdata.tim.now.data.dto.pps.ListaAmministrazioneDatiOutputDTO;
import com.nttdata.tim.now.data.dto.pps.ListaDettagliAmministrazioneDatiOutputDTO;
import com.nttdata.tim.now.data.dto.pps.SogliaInputDTO;
import com.nttdata.tim.now.data.dto.pps.SogliaWrapperInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PpsManagerBL extends AbstractBL {

	@Autowired
	private PpsRESTClient ppsRestIL;

	public GenericListBean<AmministrazioneDatiOutputBean> getReportTypes(String ambito, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<AmministrazioneDatiOutputBean> bean = new GenericListBean<>();
		try {
			ListaAmministrazioneDatiOutputDTO dto = ppsRestIL.getResearch(ambito, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getResearch(), AmministrazioneDatiOutputBean.class));
		} catch (Exception e) {
			logger.error("Error reading scopes", e);
			throw new BusinessLayerException(e);
		}

		return bean;
	}

	public GenericListBean<DettaglioAmministrazioneDatiOutputBean> getPPSParameters(String ambito, String report, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<DettaglioAmministrazioneDatiOutputBean> bean = new GenericListBean<>();
		try {
			ListaDettagliAmministrazioneDatiOutputDTO dto = ppsRestIL.getDetail(ambito, report, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getDetail(), DettaglioAmministrazioneDatiOutputBean.class));
		} catch (Exception e) {
			logger.error("Error reading pps parameters", e);
			throw new BusinessLayerException(e);
		}

		return bean;
	}

	public void edit(SogliaInputBean body, String tipoProfilo) throws BusinessLayerException {
		try {
			SogliaWrapperInputDTO dto = new SogliaWrapperInputDTO();
			dto.setThreshold(mapper.translate(body, SogliaInputDTO.class));
			ESBResultDTO restDto = ppsRestIL.editThreshold(dto, tipoProfilo);
            validateResponseResult(restDto);
		} catch (Exception e) {
			logger.error("Error saving PPS threshold", e);
			throw new BusinessLayerException(e);
		}
	}

	public GenericListBean<AmbitoMonitoraggioOutputBean> getScopes(String tipoProfilo) throws BusinessLayerException {
		GenericListBean<AmbitoMonitoraggioOutputBean> bean = new GenericListBean<>();
		try {
			ListaAmbitiMonitoraggioOutputDTO dto = ppsRestIL.getScopes(tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getScopes(), AmbitoMonitoraggioOutputBean.class));
		} catch (Exception e) {
			logger.error("Error reading asset", e);
			throw new BusinessLayerException(e);
		}

		return bean;
	}
}
