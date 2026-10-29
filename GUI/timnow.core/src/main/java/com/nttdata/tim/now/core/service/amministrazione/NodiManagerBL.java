package com.nttdata.tim.now.core.service.amministrazione;

import com.nttdata.tim.now.adapters.esb.amministrazione.NodiRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.nodi.NodoOutputBean;
import com.nttdata.tim.now.data.dto.nodi.ListaNodiOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1058
@Service
public class NodiManagerBL extends AbstractBL {

	@Autowired
	private NodiRESTClient nodiRESTClient;

    public GenericListBean<NodoOutputBean> getList()
            throws BusinessLayerException {

        GenericListBean<NodoOutputBean> list = new GenericListBean<>();
        ListaNodiOutputDTO result = null;
        boolean isLimited;
        try {
            result = nodiRESTClient.getList();
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaNodi(), NodoOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
}
