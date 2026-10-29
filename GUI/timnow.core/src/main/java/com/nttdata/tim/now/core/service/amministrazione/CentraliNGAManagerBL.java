package com.nttdata.tim.now.core.service.amministrazione;

import com.nttdata.tim.now.adapters.esb.amministrazione.CentraliNGARESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.centralinga.CentraleNGAOutputBean;
import com.nttdata.tim.now.data.dto.centralinga.ListaCentraliNGAOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1058
@Service
public class CentraliNGAManagerBL extends AbstractBL {

	@Autowired
	private CentraliNGARESTClient centraliNGARESTClient;

    public GenericListBean<CentraleNGAOutputBean> getList()
            throws BusinessLayerException {

        GenericListBean<CentraleNGAOutputBean> list = new GenericListBean<>();
        ListaCentraliNGAOutputDTO result = null;
        boolean isLimited;
        try {
            result = centraliNGARESTClient.getList();
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaCentraliGBE(), CentraleNGAOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
}
