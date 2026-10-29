package com.nttdata.tim.now.core.service.offerta;

import com.nttdata.tim.now.adapters.esb.offerta.TDRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.td.ListaCodiciTdOutputBean;
import com.nttdata.tim.now.data.dto.td.ListaCodiciTdOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TDManagerBL extends AbstractBL {

    @Autowired
    private TDRESTClient tdRestIL;

    public ListaCodiciTdOutputBean getTdCodes(String codificaOloAgcom, String tipoProfilo) throws BusinessLayerException {
        ListaCodiciTdOutputBean bean = null;
        try {
            ListaCodiciTdOutputDTO response = tdRestIL.getTdCodes(codificaOloAgcom, tipoProfilo);
            validateResponseResult(response);
            bean = mapper.translate(response, ListaCodiciTdOutputBean.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessLayerException(e);
        }
        return bean;
    }

}
