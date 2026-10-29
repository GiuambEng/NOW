package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.GuiManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.gui.VisualizzazioneGuiOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guis")
public class GuiController extends GenericController {

    @Autowired
    private GuiManagerBL guiManagerBL;
    
	// GUI_DiVisualizzazione
	@JsonGetMapping
	public GenericListBean<VisualizzazioneGuiOutputBean> getGui(HttpSession session) throws BusinessLayerException {
		logger.info("get GUI");
		UserBean currentUser = getCurrentUser(session);
		GenericListBean<VisualizzazioneGuiOutputBean> bean = guiManagerBL.getGui(currentUser.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
