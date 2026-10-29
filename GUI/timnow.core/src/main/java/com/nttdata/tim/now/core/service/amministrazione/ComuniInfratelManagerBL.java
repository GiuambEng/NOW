package com.nttdata.tim.now.core.service.amministrazione;

import com.nttdata.tim.now.adapters.esb.amministrazione.ComuniInfratelRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.anagraficainfratel.AnagraficaComuneInfratelOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.dto.anagraficainfratel.ListaAnagraficaComuneInfratelOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//RU_1078
@Service
public class ComuniInfratelManagerBL extends AbstractBL {

	@Autowired
	private ComuniInfratelRESTClient comuniInfratelRESTClient;

    public GenericListBean<AnagraficaComuneInfratelOutputBean> getList(String userId, String tipoProfilo)
            throws BusinessLayerException {

        GenericListBean<AnagraficaComuneInfratelOutputBean> list = new GenericListBean<>();
        ListaAnagraficaComuneInfratelOutputDTO result = null;
        boolean isLimited;
        try {
            result = comuniInfratelRESTClient.getList(userId, tipoProfilo);
            isLimited = validateResponseResult(result);
            list.setData(mapper.translateList(result.getListaOLOComuneInfratel(), AnagraficaComuneInfratelOutputBean.class));
            list.setIsLimitedList(isLimited);
        } catch (Exception e) {
            throw new BusinessLayerException(e);
        }
        return list;
    }
}
