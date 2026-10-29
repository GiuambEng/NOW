package com.nttdata.tim.now.core.service.amministrazione;

import com.nttdata.tim.now.adapters.esb.amministrazione.ArchiTDRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.architd.GestioneArchiNumerazioniTDEditInputBean;
import com.nttdata.tim.now.data.bean.architd.GestioneArchiNumerazioniTDListOutputBean;
import com.nttdata.tim.now.data.bean.architd.GestioneArchiNumerazioniTDOutputBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.dto.architd.GestioneArchiNumerazioniTDEditInputDTO;
import com.nttdata.tim.now.data.dto.architd.GestioneArchiNumerazioniTDWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchiTDManagerBL extends AbstractBL {

	@Autowired
	private ArchiTDRESTClient archiTdRestIL;

	public GestioneArchiNumerazioniTDListOutputBean gestionearchinumerazionitd(String profilo)
			throws BusinessLayerException {
		GestioneArchiNumerazioniTDListOutputBean bean = new GestioneArchiNumerazioniTDListOutputBean();
		try {
			GestioneArchiNumerazioniTDWrapperOutputDTO dto = archiTdRestIL.gestionearchinumerazionitd(profilo);
			validateResponseResult(dto);
			bean.setLista(mapper.translateList(dto.getLista(), GestioneArchiNumerazioniTDOutputBean.class));
			bean.setTdResidui(dto.getTdResidui());
		} catch (Exception e) {
			logger.error("Error getting gestionearchinumerazionitd list", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public EsitoOutputBean update(GestioneArchiNumerazioniTDEditInputBean inputBean, String profilo) throws BusinessLayerException {
		EsitoOutputBean bean = new EsitoOutputBean();
		try {
			GestioneArchiNumerazioniTDEditInputDTO inputDto = mapper.translate(inputBean, GestioneArchiNumerazioniTDEditInputDTO.class);
			EsitoDTO dto = archiTdRestIL.update(inputDto, profilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.error("Error update archi numerazioni TD", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public EsitoOutputBean insert(GestioneArchiNumerazioniTDEditInputBean inputBean, String profilo) throws BusinessLayerException {
		EsitoOutputBean bean = new EsitoOutputBean();
		try {
			GestioneArchiNumerazioniTDEditInputDTO inputDto = mapper.translate(inputBean, GestioneArchiNumerazioniTDEditInputDTO.class);
			EsitoDTO dto = archiTdRestIL.insert(inputDto, profilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.error("Error update archi numerazioni TD", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
