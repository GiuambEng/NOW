package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.OrdineNpngRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.ordine.npng.CambioOloNpngInputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.CambioOloNpngOutputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.DettaglioAssetNpngWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.DettaglioOrdineNpngWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.LavorazioneManualeOrdineNpngInputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.RicercaOrdiniNpngInputBean;
import com.nttdata.tim.now.data.bean.ordine.npng.RicercaOrdiniNpngWrapperOutputBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.CambioOloNpngInputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.CambioOloNpngOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.DettaglioAssetNpngWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.DettaglioOrdineNpngWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.LavorazioneManualeOrdineNpngInputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.RicercaOrdiniNpngInputDTO;
import com.nttdata.tim.now.data.dto.ordine.npng.RicercaOrdiniNpngWrapperOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1203
@Service
public class OrdineNpngManagerBL extends AbstractBL {

    @Autowired
    private OrdineNpngRESTClient ordineNpngRestClient;
    
    public RicercaOrdiniNpngWrapperOutputBean ricercaOrdini(RicercaOrdiniNpngInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
    	RicercaOrdiniNpngWrapperOutputDTO result = null;
    	RicercaOrdiniNpngWrapperOutputBean bean = null;
        try {
        	RicercaOrdiniNpngInputDTO inputDto = mapper.translate(inputBean, RicercaOrdiniNpngInputDTO.class);
            result = ordineNpngRestClient.ricercaOrdini(inputDto, tipoProfilo);
            validateResponseResult(result);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        if (result != null) {
            bean = mapper.translate(result, RicercaOrdiniNpngWrapperOutputBean.class);
        }
        return bean;
    }
    
    public DettaglioOrdineNpngWrapperOutputBean dettaglioOrdine(String idOrdine, String tipoProfilo) throws BusinessLayerException {
    	DettaglioOrdineNpngWrapperOutputDTO result = null;
    	DettaglioOrdineNpngWrapperOutputBean bean = null;
        try {
            result = ordineNpngRestClient.dettaglioOrdine(idOrdine, tipoProfilo);
            validateResponseResult(result);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        if (result != null) {
            bean = mapper.translate(result, DettaglioOrdineNpngWrapperOutputBean.class);
        }
        return bean;
    }
    
    public EmptyBean lavorazioneManualeOrdine(LavorazioneManualeOrdineNpngInputBean inputBean, String userId, String tipoProfilo) throws BusinessLayerException {
    	LavorazioneManualeOrdineNpngInputDTO inputDto = null;
    	EmptyBean result = null;
    	try {
    		inputDto = mapper.translate(inputBean, LavorazioneManualeOrdineNpngInputDTO.class);
    		inputDto.setOperatore(userId);
            ESBResultDTO dto = ordineNpngRestClient.lavorazioneManualeOrdine(inputDto, tipoProfilo);
            validateResponseResult(dto);
            logger.debug("LavorazioneManualeOrdineNpngInputBean: " + inputBean.toString());
            logger.debug("LavorazioneManualeOrdineNpngInputDTO: " + inputDto.toString());
            result = mapper.translate(dto, EmptyBean.class); 
            return result;
        } catch (Exception e) {
            logger.error("Error creating order", e);
            throw new BusinessLayerException(e);
        }
    }
    
    public RicercaOrdiniNpngWrapperOutputBean ricercaAsset(String dn, String tipoProfilo) throws BusinessLayerException {
    	RicercaOrdiniNpngWrapperOutputDTO result = null;
    	RicercaOrdiniNpngWrapperOutputBean bean = null;
        try {
            result = ordineNpngRestClient.ricercaAsset(dn, tipoProfilo);
            validateResponseResult(result);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        if (result != null) {
            bean = mapper.translate(result, RicercaOrdiniNpngWrapperOutputBean.class);
        }
        return bean;
    }
    
    public DettaglioAssetNpngWrapperOutputBean dettaglioAsset(String idAsset, String tipoProfilo) throws BusinessLayerException {
    	DettaglioAssetNpngWrapperOutputDTO result = null;
    	DettaglioAssetNpngWrapperOutputBean bean = null;
        try {
            result = ordineNpngRestClient.dettaglioAsset(idAsset, tipoProfilo);
            validateResponseResult(result);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        if (result != null) {
            bean = mapper.translate(result, DettaglioAssetNpngWrapperOutputBean.class);
        }
        return bean;
    }
    
    public CambioOloNpngOutputBean cambioOlo(CambioOloNpngInputBean inputBean, String userId, String tipoProfilo) throws BusinessLayerException {
    	CambioOloNpngInputDTO inputDto = null;
    	CambioOloNpngOutputDTO dto = null;
    	CambioOloNpngOutputBean result = new CambioOloNpngOutputBean();
    	try {
    		inputDto = mapper.translate(inputBean, CambioOloNpngInputDTO.class);
    		inputDto.setOperatore(userId);
            dto = ordineNpngRestClient.cambioOlo(inputDto, tipoProfilo);
            validateResponseResult(dto);
            logger.debug("CambioOloNpngInputBean: " + inputBean.toString());
            logger.debug("CambioOloNpngInputDTO: " + inputDto.toString());
            result = mapper.translate(dto, CambioOloNpngOutputBean.class);
            return result;
        } catch (Exception e) {
            logger.error("Error creating order", e);
            throw new BusinessLayerException(e);
        }
    }
}
