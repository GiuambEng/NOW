package com.nttdata.tim.now.core.service.anagrafica;

import com.nttdata.tim.now.adapters.esb.anagrafica.OpzioneNpngRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficanpng.CampiAnagraficaNpngWrapperOutputBean;
import com.nttdata.tim.now.data.bean.anagraficanpng.ModificaOpzioneTrafficoInputBean;
import com.nttdata.tim.now.data.bean.anagraficanpng.ModificaOpzioneTrafficoOutputBean;
import com.nttdata.tim.now.data.bean.anagraficanpng.OpzioneTrafficoNpngWrapperOutputBean;
import com.nttdata.tim.now.data.dto.anagraficanpng.CampiAnagraficaNpngWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficanpng.ModificaOpzioneTrafficoInputDTO;
import com.nttdata.tim.now.data.dto.anagraficanpng.ModificaOpzioneTrafficoOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficanpng.OpzioneTrafficoNpngWrapperOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1203
@Service
public class OpzioneNpngManagerBL extends AbstractBL {

    @Autowired
    private OpzioneNpngRESTClient opzioneNpngRestClient;
    
    public OpzioneTrafficoNpngWrapperOutputBean lista(String tipoProfilo) throws BusinessLayerException {
    	OpzioneTrafficoNpngWrapperOutputDTO result = null;
    	OpzioneTrafficoNpngWrapperOutputBean bean = null;
        try {
            result = opzioneNpngRestClient.lista(tipoProfilo);
            validateResponseResult(result);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        if (result != null) {
            bean = mapper.translate(result, OpzioneTrafficoNpngWrapperOutputBean.class);
        }
        return bean;
    }
    
    public ModificaOpzioneTrafficoOutputBean modifica(ModificaOpzioneTrafficoInputBean inputBean, String userId, String tipoProfilo) throws BusinessLayerException {
    	ModificaOpzioneTrafficoInputDTO inputDto = null;
    	try {
    		inputDto = mapper.translate(inputBean, ModificaOpzioneTrafficoInputDTO.class);
    		inputDto.setOperatore(userId);
    		ModificaOpzioneTrafficoOutputDTO dto = opzioneNpngRestClient.modifica(inputDto, tipoProfilo);
            validateResponseResult(dto);
            logger.debug("ModificaOpzioneTrafficoInputBean: " + inputBean.toString());
            logger.debug("ModificaOpzioneTrafficoInputDTO: " + inputDto.toString());
            return mapper.translate(dto, ModificaOpzioneTrafficoOutputBean.class);
        } catch (Exception e) {
            logger.error("Error update option", e);
            throw new BusinessLayerException(e);
        }
    }
    
    public CampiAnagraficaNpngWrapperOutputBean recuperoCampi(String tipoProfilo) throws BusinessLayerException {
    	CampiAnagraficaNpngWrapperOutputDTO result = null;
    	CampiAnagraficaNpngWrapperOutputBean bean = null;
        try {
            result = opzioneNpngRestClient.recuperoCampi(tipoProfilo);
            validateResponseResult(result);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }

        if (result != null) {
            bean = mapper.translate(result, CampiAnagraficaNpngWrapperOutputBean.class);
        }
        return bean;
    }
}
