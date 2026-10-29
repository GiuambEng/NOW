package com.nttdata.tim.now.core.service.amministrazione;

import com.nttdata.tim.now.adapters.esb.amministrazione.PuntiDiConsegnaRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.pdc.PuntoDiConsegnaOutputBean;
import com.nttdata.tim.now.data.dto.pdc.ListaPuntiDiConsegnaOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1058
@Service
public class PuntiDiConsegnaManagerBL extends AbstractBL {

	@Autowired
	private PuntiDiConsegnaRESTClient puntiDiConsegnRESTClient;

    public GenericListBean<PuntoDiConsegnaOutputBean> getList()
            throws BusinessLayerException {

        GenericListBean<PuntoDiConsegnaOutputBean> list = new GenericListBean<>();
        ListaPuntiDiConsegnaOutputDTO result = null;
        boolean isLimited;
        try {
            result = puntiDiConsegnRESTClient.getList();
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaPDC(), PuntoDiConsegnaOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
}
