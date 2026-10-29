package com.nttdata.tim.now.web.controller.monitoraggio;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.monitoraggio.RinvioFileManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;
import com.nttdata.tim.now.data.bean.file.FileBean;
import com.nttdata.tim.now.data.bean.file.ListaFileScaricatiBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPutMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitoraggio-rinvio-file")
public class RinvioFileController extends GenericController {

    @Autowired
    private RinvioFileManagerBL fileResendManagerBL;

	@JsonPutMapping("/send")
	public GenericListBean<CodiceOutputBean> sendFile(@RequestBody ListaFileScaricatiBean body, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<CodiceOutputBean> bean = fileResendManagerBL.requestResendFile(body, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	@JsonPostMapping("/search")
	public GenericListBean<FileBean> search(@RequestBody RicercaAvanzataInputBean searchBean, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<FileBean> bean = fileResendManagerBL.fileAdvanceResearch(searchBean, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

}
