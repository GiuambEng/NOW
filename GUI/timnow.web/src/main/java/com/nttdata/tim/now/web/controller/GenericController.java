package com.nttdata.tim.now.web.controller;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.base.GenericListExportBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.web.utils.WebAttributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

public abstract class GenericController extends DefaultHandlerExceptionResolver {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	public Result getResult(String code, String description, String message) {
		return new Result(code, description, message);
	}

	public EmptyBean getEmptyBean(Result result) {
		return new EmptyBean(result);
	}

	public Result getSuccessResult() {
		ResultCodeEnum result = ResultCodeEnum.OK;
		return new Result(result.getCode(), result.name(), result.getMessage());
	}

	public Result getResultNotFound() {
		ResultCodeEnum result = ResultCodeEnum.NOT_FOUND;
		return new Result(result.getCode(), "Risorsa non trovata", result.getMessage());
	}

	public EmptyBean getSuccessEmptyBean() {
		return new EmptyBean(getSuccessResult());
	}


	public UserBean getCurrentUser(HttpSession session) {
		return (UserBean) session.getAttribute(WebAttributes.SESSION_CURRENT_USER);
	}

	/**
	 * Verifica che l'oggetto passato in input sia valido (non nullo e con la
	 * lista dati valorizzata) e lo arricchisce l'oggetto di result.
	 * 
	 * @param bean
	 * @return
	 */
	protected <T> GenericListBean<T> ensureListBeanResult(GenericListBean<T> bean) {
		if (bean != null && bean.getData() != null) {
			logger.debug("List data found. Record number: {}", bean.getData().size());
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("List data NOT found");
			Result result = getResultNotFound();
			bean = new GenericListBean<T>();
			bean.setResult(result);
		}
		return bean;
	}

	/**
	 * Verifica che l'oggetto passato in input sia valido (non nullo e con la
	 * lista dati valorizzata) e lo arricchisce l'oggetto di result.
	 * 
	 * @param bean
	 * @return
	 */
	protected <T> GenericListExportBean<T> ensureListBeanResult(GenericListExportBean<T> bean) {
		if (bean != null && bean.getData() != null) {
			logger.debug("List data found. Record number: {}", bean.getData().size());
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("List data NOT found");
			Result result = getResultNotFound();
			bean = new GenericListExportBean<T>();
			bean.setResult(result);
		}
		return bean;
	}

	/**
	 * Verifica che l'oggetto passato in input sia valido (non nullo) e lo
	 * arricchisce l'oggetto di result.
	 * 
	 * @param bean
	 * @return
	 */
	protected <T extends AbstractOutputBean> T ensureBeanResult(T bean, Class<T> clazz) {
		if (bean != null) {
			bean.setResult(getSuccessResult()); 
			return bean;
		} 
		
		if (clazz == null) {
			return bean;
		}
		
		try {
			bean = clazz.newInstance();
			bean.setResult(getResultNotFound());
		} catch (Exception e) {
			logger.warn("Impossibile istanziare la classe " + clazz.getName(), e);
		}

		return bean;
	}
	
}
