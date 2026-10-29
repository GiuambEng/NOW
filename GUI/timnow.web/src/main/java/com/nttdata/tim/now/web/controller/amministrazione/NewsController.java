package com.nttdata.tim.now.web.controller.amministrazione;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.amministrazione.NewsManagerBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.news.NewsBean;
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
@RequestMapping("/news")
public class NewsController extends GenericController {

    @Autowired
    private NewsManagerBL newsManagerBL;
    
	@JsonGetMapping
	public GenericListBean<NewsBean> getNews(HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<NewsBean> bean = newsManagerBL.getNews(false, user.getCodiceProfilo());
		return ensureListBeanResult(bean);
	}

	// change from put to post for RU_532
	@JsonPostMapping
	public GenericListBean<NewsBean> createUpdateNews(@RequestBody NewsBean body, HttpSession session) throws BusinessLayerException {
		logger.debug("Inside createUpdateNews");
		UserBean user = getCurrentUser(session);
		GenericListBean<NewsBean> bean = newsManagerBL.createUpdateNews(body, user);
		return ensureListBeanResult(bean);
	}


	// change from delete to get for RU_532
	@JsonGetMapping("/{idNews:[A-Za-z0-9]+}")
	public GenericListBean<NewsBean> deleteNews(@PathVariable String idNews, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<NewsBean> bean = newsManagerBL.deleteNews(idNews, user.getCodiceProfilo());
		return ensureListBeanResult(bean);
	}

	@JsonGetMapping("/visible")
	public GenericListBean<NewsBean> getLatestNews(HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<NewsBean> bean = newsManagerBL.getNews(true, user.getCodiceProfilo());
		return ensureListBeanResult(bean);
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request)
    {
       binder.setAllowedFields("content","idNews","note","operator","title","updateOperator","visible","delete","insertDate","updateDate","operationType");
    }


}
