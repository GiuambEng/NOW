package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.FaqManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.faq.FaqBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/faqs")
public class FAQController extends GenericController {

    @Autowired
    private FaqManagerBL faqManagerBL;    
    
	@JsonGetMapping
	public GenericListBean<FaqBean> getFAQs(HttpSession session) throws BusinessLayerException {
		GenericListBean<FaqBean> bean = faqManagerBL.getFaq(false, getCurrentUser(session).getCodiceProfilo());
		return ensureListBeanResult(bean);
	}

	// change from put update to post for RU_532
	@JsonPostMapping
	public GenericListBean<FaqBean> createUpdateFaq(@RequestBody FaqBean faq, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<FaqBean> bean = faqManagerBL.createUpdateFaq(faq, user);
		return ensureListBeanResult(bean);
	}

	// change from delete to get for RU_532
	@JsonGetMapping("/{idfaq:[A-Za-z0-9]+}")
	public GenericListBean<FaqBean> deleteFaq(@PathVariable String idfaq, HttpSession session) throws BusinessLayerException {
		GenericListBean<FaqBean> bean = faqManagerBL.deleteFaq(idfaq, getCurrentUser(session).getCodiceProfilo());
		return ensureListBeanResult(bean);
	}
	
	@JsonGetMapping("/visible")
	public GenericListBean<FaqBean> getVisibleFAQs(HttpSession session) throws BusinessLayerException {
		GenericListBean<FaqBean> bean = faqManagerBL.getFaq(true, getCurrentUser(session).getCodiceProfilo());
		return ensureListBeanResult(bean);
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request)
    {
       binder.setAllowedFields("question","answer","note","operator","updateOperator","idFaq","visible","updateDate","insertDate","operationType");
    }
}
