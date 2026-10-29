package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.OrdineDonatingManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ordine.donating.OrdineDonatingDetailListOutputBean;
import com.nttdata.tim.now.data.bean.ordine.donating.OrdineDonatingInputBean;
import com.nttdata.tim.now.data.bean.ordine.donating.OrdineDonatingOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordini-donating")
public class OrdineDonatingController extends GenericController {
    
    @Autowired
    private OrdineDonatingManagerBL ordineDonatingManagerBL;

	@JsonGetMapping
	public GenericListBean<OrdineDonatingOutputBean> getList(
			@RequestParam(value = "codiceOrdineTI", required = false) String codiceOrdineTI,
			@RequestParam(value = "nomeFileNotifica", required = false) String nomeFileNotifica,
			@RequestParam(value = "idRisorsa", required = false) String idRisorsa,
			@RequestParam(value = "codiceSessione", required = false) String codiceSessione,
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		
		OrdineDonatingInputBean input = new OrdineDonatingInputBean();
		input.setCodiceOrdineTI(codiceOrdineTI);
		input.setNomeFileNotifica(nomeFileNotifica);
		input.setCodificaAgcom(user.getCodificaOloAgcom());
		input.setTipoProfilo(user.getCodiceProfilo());
		input.setCodiceSessione(codiceSessione);
		input.setIdRisorsa(idRisorsa);

		GenericListBean<OrdineDonatingOutputBean> bean = ordineDonatingManagerBL.getList(input,user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		
		return bean;
	}
	
	@JsonGetMapping("/{idRichiestaOLO}")
	public OrdineDonatingDetailListOutputBean getDetail(@PathVariable String idRichiestaOLO, HttpSession session) throws BusinessLayerException  {
		UserBean user = getCurrentUser(session);
		OrdineDonatingDetailListOutputBean bean = ordineDonatingManagerBL.getDetailList(idRichiestaOLO, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, OrdineDonatingDetailListOutputBean.class);
		return bean;
	}
	
}
