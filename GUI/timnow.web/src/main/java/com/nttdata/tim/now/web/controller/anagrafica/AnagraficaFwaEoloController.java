package com.nttdata.tim.now.web.controller.anagrafica;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.AnagraficaFwaEoloManagerBL;
import com.nttdata.tim.now.data.bean.anagraficafwaeolo.AnagraficaFwaEoloOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RU_1479
@RestController()
@RequestMapping("/anagraficaFwaEolo")
public class AnagraficaFwaEoloController extends GenericController {
	
	@Autowired
	private AnagraficaFwaEoloManagerBL anagraficaFwaEoloManagerBL;

	@JsonGetMapping("/lista")
	public GenericListBean<AnagraficaFwaEoloOutputBean> getList(HttpSession session)
			throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        GenericListBean<AnagraficaFwaEoloOutputBean> bean = anagraficaFwaEoloManagerBL.getList(user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
	}
}
