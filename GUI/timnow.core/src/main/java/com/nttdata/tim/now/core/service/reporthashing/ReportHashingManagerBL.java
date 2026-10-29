package com.nttdata.tim.now.core.service.reporthashing;

import com.nttdata.tim.now.adapters.esb.reporthashing.ReportHashingRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.ordine.hashing.CreazioneReportInputBean;
import com.nttdata.tim.now.data.bean.ordine.hashing.DettaglioReportOutputBean;
import com.nttdata.tim.now.data.bean.ordine.hashing.ReportWrapperOutputBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.ordine.hashing.CreazioneReportInputDTO;
import com.nttdata.tim.now.data.dto.ordine.hashing.DettaglioReportOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.hashing.ReportWrapperOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//R1F-21-0411
@Service
public class ReportHashingManagerBL extends AbstractBL {

	@Autowired
	private ReportHashingRESTClient reportHashingRestClient;

	public EmptyBean creazioneReport(CreazioneReportInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
		EmptyBean bean;
		try {
			CreazioneReportInputDTO inputDto = new CreazioneReportInputDTO();
			inputDto = mapper.translate(inputBean, CreazioneReportInputDTO.class);
			ESBResultDTO dto = reportHashingRestClient.creazioneReport(inputDto, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, EmptyBean.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	public ReportWrapperOutputBean listaReport(String tipoProfilo) throws BusinessLayerException {
		ReportWrapperOutputBean bean;
		try {
			ReportWrapperOutputDTO dto = reportHashingRestClient.listaReport(tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, ReportWrapperOutputBean.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	public DettaglioReportOutputBean dettaglioReport(String idReport, String tipoLista, String tipoProfilo) throws BusinessLayerException {
		DettaglioReportOutputBean bean;
		try {
			DettaglioReportOutputDTO dto = reportHashingRestClient.dettaglioReport(idReport, tipoLista, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, DettaglioReportOutputBean.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
