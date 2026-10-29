package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.LavorazioneManualeRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.dto.base.CreateResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1492
@Service
public class LavorazioneManualeManagerBL extends AbstractBL {


	@Autowired
	private LavorazioneManualeRESTClient lavorazioneManualeRESTClient;

	public EmptyBean scarta(String tipoProfilo, String idRichiestaOlo) throws BusinessLayerException {
		try {
			
			CreateResponseDTO dto = lavorazioneManualeRESTClient.scarta(tipoProfilo, idRichiestaOlo);
			validateResponseResult(dto);
			return mapper.translate(dto, EmptyBean.class);
		} catch (Exception e) {
			logger.error("Error creating order", e);
			throw new BusinessLayerException(e);
		}
	}
	
	public EmptyBean risottometti(String tipoProfilo, String idRichiestaOlo) throws BusinessLayerException {
		try {
			
			CreateResponseDTO dto = lavorazioneManualeRESTClient.risottometti(tipoProfilo, idRichiestaOlo);
			validateResponseResult(dto);
			return mapper.translate(dto, EmptyBean.class);
		} catch (Exception e) {
			logger.error("Error creating order", e);
			throw new BusinessLayerException(e);
		}
	}
	
	public EmptyBean modifica(String tipoProfilo, String idRichiestaOlo, String idBuilding) throws BusinessLayerException {
		try {
			
			CreateResponseDTO dto = lavorazioneManualeRESTClient.modifica(tipoProfilo, idRichiestaOlo, idBuilding);
			validateResponseResult(dto);
			return mapper.translate(dto, EmptyBean.class);
		} catch (Exception e) {
			logger.error("Error creating order", e);
			throw new BusinessLayerException(e);
		}
	}

}
