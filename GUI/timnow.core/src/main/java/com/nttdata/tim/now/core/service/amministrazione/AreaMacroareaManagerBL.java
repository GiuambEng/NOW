package com.nttdata.tim.now.core.service.amministrazione;

import com.nttdata.tim.now.adapters.esb.amministrazione.AreaMacroareaRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.areamacroarea.AreaMacroareaOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.dto.areamacroarea.ListaAreaMacroareaOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1058
@Service
public class AreaMacroareaManagerBL extends AbstractBL {

	@Autowired
	private AreaMacroareaRESTClient areaMacroareaRESTClient;

    public GenericListBean<AreaMacroareaOutputBean> getList()
            throws BusinessLayerException {

        GenericListBean<AreaMacroareaOutputBean> list = new GenericListBean<>();
        ListaAreaMacroareaOutputDTO result = null;
        boolean isLimited;
        try {
            result = areaMacroareaRESTClient.getList();
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaAreaMacroarea(), AreaMacroareaOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
}
