package com.nttdata.tim.now.core.service.anagrafica;

import com.nttdata.tim.now.adapters.esb.anagrafica.GestioneAutonomaRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.gestioneautonoma.AssociazioneOaoImpresaAreaOutputBean;
import com.nttdata.tim.now.data.dto.gestioneautonoma.ListaAssociazioneOaoImpresaAreaOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1393
@Service
public class GestioneAutonomaManagerBL extends AbstractBL {

    @Autowired
    private GestioneAutonomaRESTClient gestioneAutonomaRestClient;
    
    public GenericListBean<AssociazioneOaoImpresaAreaOutputBean> getList(String codOloAgcom, String tipoProfilo)
            throws BusinessLayerException {

        GenericListBean<AssociazioneOaoImpresaAreaOutputBean> list = new GenericListBean<>();
        ListaAssociazioneOaoImpresaAreaOutputDTO result = null;
        boolean isLimited;
        try {
            result = gestioneAutonomaRestClient.getList(codOloAgcom, tipoProfilo);
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaAnagraficaFcSemiGpon(), AssociazioneOaoImpresaAreaOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
}
