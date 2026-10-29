package com.nttdata.tim.now.core.service.anagrafica;

import com.nttdata.tim.now.adapters.esb.anagrafica.AnagraficaFwaEoloRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficafwaeolo.AnagraficaFwaEoloOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.dto.anagraficafwaeolo.ListaAnagraficaFwaEoloOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1479
@Service
public class AnagraficaFwaEoloManagerBL extends AbstractBL {

    @Autowired
    private AnagraficaFwaEoloRESTClient anagraficaFwaEoloRestClient;
    
    public GenericListBean<AnagraficaFwaEoloOutputBean> getList(String tipoProfilo)
            throws BusinessLayerException {

        GenericListBean<AnagraficaFwaEoloOutputBean> list = new GenericListBean<>();
        ListaAnagraficaFwaEoloOutputDTO result = null;
        boolean isLimited;
        try {
            result = anagraficaFwaEoloRestClient.getList(tipoProfilo);
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaAnagraficaFwaEolo(), AnagraficaFwaEoloOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
}
