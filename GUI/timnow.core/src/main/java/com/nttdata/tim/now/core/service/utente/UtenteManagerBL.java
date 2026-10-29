package com.nttdata.tim.now.core.service.utente;

import com.nttdata.tim.now.adapters.esb.utente.UtenteRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.utente.UserWrapperDTO;
import com.nttdata.tim.now.util.Constants;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteManagerBL extends AbstractBL {

    @Autowired
    private UtenteRESTClient utenteRestIL;

    public UserBean getUser(String username) throws BusinessLayerException {
        UserBean bean = null;
        try {
            UserWrapperDTO dto = utenteRestIL.getUserDetail(username);
            validateResponseResult(dto);
            bean = mapper.translate(dto.getOutputUtente(), UserBean.class);
            if (bean != null && StringUtils.isBlank(bean.getCodificaOloAgcom())) {
                bean.setCodificaOloAgcom(Constants.DEFAULT_OLO);
            }
        } catch (Exception e) {
            logger.error("Error reading user", e);
            throw new BusinessLayerException(e);
        }
        return bean;
    }

}
