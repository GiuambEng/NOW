package com.nttdata.tim.now.core.service.anagrafica;

import com.nttdata.tim.now.adapters.esb.anagrafica.RisorseFwaWillDecoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficafwawilldeco.DettaglioRisorsaFwaWillDecoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.anagraficafwawilldeco.ModificaRisorsaFwaWillDecoInputBean;
import com.nttdata.tim.now.data.bean.anagraficafwawilldeco.NuovaRisorsaFwaWillDecoInputBean;
import com.nttdata.tim.now.data.bean.anagraficafwawilldeco.RisorseFwaWillDecoListItemOutputBean;
import com.nttdata.tim.now.data.bean.anagraficafwawilldeco.RisorseFwaWillDecoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.dto.anagraficafwawilldeco.DettaglioRisorsaFwaWillDecoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficafwawilldeco.ModificaRisorsaFwaWillDecoInputDTO;
import com.nttdata.tim.now.data.dto.anagraficafwawilldeco.NuovaRisorsaFwaWillDecoInputDTO;
import com.nttdata.tim.now.data.dto.anagraficafwawilldeco.RisorseFwaWillDecoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//RU_1335
@Service
public class RisorseFwaWillDecoManagerBL extends AbstractBL {

	@Autowired
	private RisorseFwaWillDecoRESTClient risorseFwaWillDecoRestClient;

	@Cacheable(value = "risorseFwa")
	public RisorseFwaWillDecoWrapperOutputBean list(String tipoProfilo) throws BusinessLayerException {
		RisorseFwaWillDecoWrapperOutputBean list = new RisorseFwaWillDecoWrapperOutputBean();
		boolean isLimited;
		//Gestione lista limitata
		try {
			RisorseFwaWillDecoWrapperOutputDTO dto = risorseFwaWillDecoRestClient.list(tipoProfilo);
			isLimited = validateResponseResult(dto);
			list.setListaRisorseFwa(mapper.translateList(dto.getListaRisorseFwa(), RisorseFwaWillDecoListItemOutputBean.class));
			list.setIsLimitedList(isLimited);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public EsitoOutputBean edit(ModificaRisorsaFwaWillDecoInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
		logger.info("Modifica Risorsa FWA Will Deco " + inputBean.getIdRisorsaSwitchOff());
		EsitoOutputBean bean = new EsitoOutputBean();
		try {
			ModificaRisorsaFwaWillDecoInputDTO inputDto = mapper.translate(inputBean, ModificaRisorsaFwaWillDecoInputDTO.class);
			EsitoDTO dto = risorseFwaWillDecoRestClient.edit(inputDto, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.error("Errore modifica risorsa FWA Will Deco", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public EsitoOutputBean create(NuovaRisorsaFwaWillDecoInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
		logger.info("Nuova Risorsa FWA Will Deco " + inputBean.getIdRisorsaSwitchOff());
		EsitoOutputBean bean = new EsitoOutputBean();
		try {
			NuovaRisorsaFwaWillDecoInputDTO inputDto = mapper.translate(inputBean, NuovaRisorsaFwaWillDecoInputDTO.class);
			EsitoDTO dto = risorseFwaWillDecoRestClient.create(inputDto, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.error("Errore creazione risorsa FWA Will Deco", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public DettaglioRisorsaFwaWillDecoWrapperOutputBean details(String idRisorsa, String tipoProfilo) throws BusinessLayerException {
		logger.info("Dettaglio risorsa FWA Will DECO " + idRisorsa);
		DettaglioRisorsaFwaWillDecoWrapperOutputBean bean = new DettaglioRisorsaFwaWillDecoWrapperOutputBean();
		try {
			DettaglioRisorsaFwaWillDecoWrapperOutputDTO dto = risorseFwaWillDecoRestClient.details(idRisorsa, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, DettaglioRisorsaFwaWillDecoWrapperOutputBean.class);
		} catch (Exception e) {
			logger.error("Error recupero dettaglio risorsa FWA Will Deco", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
