package com.nttdata.tim.now.core.service.anagrafica;

import com.nttdata.tim.now.adapters.esb.anagrafica.AnagraficaGponRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficagpon.AnagraficaGponOutputBean;
import com.nttdata.tim.now.data.bean.anagraficagpon.StoricoSplittingGponOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.dto.anagraficagpon.ListaAnagraficaGponOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficagpon.ListaStoricoSplittingGponOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1308
@Service
public class AnagraficaGponManagerBL extends AbstractBL {

    @Autowired
    private AnagraficaGponRESTClient anagraficaGponRestClient;
    
    public GenericListBean<AnagraficaGponOutputBean> getList(String tipoProfilo)
            throws BusinessLayerException {

        GenericListBean<AnagraficaGponOutputBean> list = new GenericListBean<>();
        ListaAnagraficaGponOutputDTO result = null;
        boolean isLimited;
        try {
            result = anagraficaGponRestClient.getList(tipoProfilo);
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaAnagraficaGpon(), AnagraficaGponOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
    
    //RU_1338
    public GenericListBean<StoricoSplittingGponOutputBean> getStoricoSplitting(String idGpon, String tipoProfilo)
            throws BusinessLayerException {

        GenericListBean<StoricoSplittingGponOutputBean> list = new GenericListBean<>();
        ListaStoricoSplittingGponOutputDTO result = null;
        boolean isLimited;
        try {
            result = anagraficaGponRestClient.getStoricoSplitting(idGpon, tipoProfilo);
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaStoricoGpon(), StoricoSplittingGponOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
}
