package com.nttdata.tim.now.web.controller.ordine;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.DuplicateEntryException;
import com.nttdata.tim.now.core.service.ordine.BozzaOrdineManagerBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ordine.draft.OrderDraftBean;
import com.nttdata.tim.now.data.bean.ordine.draft.OrdineBozzaInputBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/drafts")
public class OrdineBozzaController extends GenericController {

	@Autowired
	private BozzaOrdineManagerBL draftManagerBL;

	// Ordini Bozza 
	// change from put to post for RU_532
	@JsonPostMapping
	public EmptyBean createUpdateDraft(@RequestBody OrdineBozzaInputBean body, HttpSession session)
			throws BusinessLayerException {
		EmptyBean result;
		try {
			UserBean user = getCurrentUser(session);
			body.setUserId(user.getUserId());
			result = draftManagerBL.createUpdateDraft(body, user.getCodiceProfilo());
			return ensureBeanResult(result, EmptyBean.class);

		} catch (DuplicateEntryException e) {
			logger.debug("updateDraft error", e);
			ResultCodeEnum code = ResultCodeEnum.ALREADY_EXISTS;
			result = getEmptyBean(new Result(code.getCode(), "", code.getMessage()));
		}
		return result;
	}

	// Ordini Bozza (GET)
	@JsonGetMapping
	public GenericListBean<OrderDraftBean> getDrafts(HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<OrderDraftBean> bean = draftManagerBL.getDrafts(user.getCodiceProfilo(),
				user.getCodificaOloAgcom(), user.getUserId());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ordini Bozza (GET)
	@JsonGetMapping("/{operationType}/{listaOrdiniBozzaOp}")
	public OrderDraftBean getDraft(@RequestParam(value = "codOloAgcom") String codOloAgcom,
                                   @RequestParam(value = "codOrdOlo") String codOrdOlo, HttpSession session)
			throws BusinessLayerException {

		UserBean user = getCurrentUser(session);
		OrderDraftBean bean = draftManagerBL.getDraft(codOrdOlo, codOloAgcom, user.getCodiceProfilo());

		if (bean != null) {
			logger.debug("Draft found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Draft NOT found");
			bean = new OrderDraftBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

	// Ordini Bozza (DELETE)
	// change from delete to get for RU_532
	@JsonGetMapping("/{operationType}")
	public EmptyBean deleteDraft(@RequestParam(value = "codOloAgcom") String codOloAgcom,
			                     @RequestParam(value = "codOrdOlo") String codOrdOlo, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		return draftManagerBL.deleteDraft(codOrdOlo, codOloAgcom, user.getCodiceProfilo());
	}

	
	@InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request)
    {
       binder.setAllowedFields("codOloAgcom","codOloNumerico","ordineBozza","userId","codOrdineOlo","tipologiaLavorazione","note","ultimoAggiornamento","operationType");
    }

}
