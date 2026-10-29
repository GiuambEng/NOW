package com.nttdata.tim.now.core.service.amministrazione;

import com.nttdata.tim.now.adapters.esb.amministrazione.VlanRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.vlan.VlanOutputBean;
import com.nttdata.tim.now.data.dto.vlan.ListaVlanOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1058
@Service
public class VlanManagerBL extends AbstractBL {

	@Autowired
	private VlanRESTClient vlanRESTClient;

    public GenericListBean<VlanOutputBean> getList()
            throws BusinessLayerException {

        GenericListBean<VlanOutputBean> list = new GenericListBean<>();
        ListaVlanOutputDTO result = null;
        boolean isLimited;
        try {
            result = vlanRESTClient.getList();
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaVlan(), VlanOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
}
