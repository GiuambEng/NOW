package com.nttdata.tim.now.core.service.amministrazione;

import com.nttdata.tim.now.adapters.esb.amministrazione.KitVlanRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.kitvlan.KitVlanOutputBean;
import com.nttdata.tim.now.data.dto.kitvlan.ListaKitVlanOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1058
@Service
public class KitVlanManagerBL extends AbstractBL {

	@Autowired
	private KitVlanRESTClient kitVlanRESTClient;

    public GenericListBean<KitVlanOutputBean> getList()
            throws BusinessLayerException {

        GenericListBean<KitVlanOutputBean> list = new GenericListBean<>();
        ListaKitVlanOutputDTO result = null;
        boolean isLimited;
        try {
            result = kitVlanRESTClient.getList();
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaKitVlan(), KitVlanOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
}
