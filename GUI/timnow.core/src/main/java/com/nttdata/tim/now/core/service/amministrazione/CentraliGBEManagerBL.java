package com.nttdata.tim.now.core.service.amministrazione;

import com.nttdata.tim.now.adapters.esb.amministrazione.CentraliGBERESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.centraligbe.CentraleGBEOutputBean;
import com.nttdata.tim.now.data.dto.centraligbe.ListaCentraliGBEOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1058
@Service
public class CentraliGBEManagerBL extends AbstractBL {

	@Autowired
	private CentraliGBERESTClient centraliGBERESTClient;

    public GenericListBean<CentraleGBEOutputBean> getList()
            throws BusinessLayerException {

        GenericListBean<CentraleGBEOutputBean> list = new GenericListBean<>();
        ListaCentraliGBEOutputDTO result = null;
        boolean isLimited;
        try {
            result = centraliGBERESTClient.getList();
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaCentraliGBE(), CentraleGBEOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
}
