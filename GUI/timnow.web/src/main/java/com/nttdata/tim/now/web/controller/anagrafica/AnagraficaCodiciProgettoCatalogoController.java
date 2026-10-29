package com.nttdata.tim.now.web.controller.anagrafica;


import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.AnagraficaCodiciProgettoCatalogoManagerBL;
import com.nttdata.tim.now.data.bean.anagraficacodiciprogettocatalogo.AnagraficaCodiciProgettoCatalogoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1485
@RestController
@RequestMapping("/anagraficaCodiciProgettoCatalogo")
public class AnagraficaCodiciProgettoCatalogoController extends GenericController {

    @Autowired
    private AnagraficaCodiciProgettoCatalogoManagerBL anagraficaCodiciProgettoCatalogoManagerBL;
    
    @JsonGetMapping("/liste")
    public AnagraficaCodiciProgettoCatalogoWrapperOutputBean listaCodiciProgettoCatalogo(HttpSession session) throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        AnagraficaCodiciProgettoCatalogoWrapperOutputBean bean = anagraficaCodiciProgettoCatalogoManagerBL.listaCodiciProgettoCatalogo(user.getCodiceProfilo());
        return bean;
    }
}
