package com.nttdata.tim.now.web.controller.anagrafica;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.anagrafica.AnagraficaGponManagerBL;
import com.nttdata.tim.now.data.bean.anagraficagpon.AnagraficaGponOutputBean;
import com.nttdata.tim.now.data.bean.anagraficagpon.StoricoSplittingGponOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//RU_1308
@RestController()
@RequestMapping("/anagraficaGpon")
public class AnagraficaGponController extends GenericController {
	
	@Autowired
	private AnagraficaGponManagerBL anagraficaGponManagerBL;

	@JsonGetMapping("/lista")
	public GenericListBean<AnagraficaGponOutputBean> getList(HttpSession session)
			throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        GenericListBean<AnagraficaGponOutputBean> bean = anagraficaGponManagerBL.getList(user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
	}
	
	//RU_1338
	@JsonGetMapping("/storicoSplitting")
	public GenericListBean<StoricoSplittingGponOutputBean> getStoricoSplitting(@RequestParam String idGpon, HttpSession session)
			throws BusinessLayerException {
        UserBean user = getCurrentUser(session);
        GenericListBean<StoricoSplittingGponOutputBean> bean = anagraficaGponManagerBL.getStoricoSplitting(idGpon, user.getCodiceProfilo());
        bean = ensureListBeanResult(bean);
        return bean;
	}
}
