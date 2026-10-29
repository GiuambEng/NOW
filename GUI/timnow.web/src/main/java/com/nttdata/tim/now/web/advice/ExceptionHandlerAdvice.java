package com.nttdata.tim.now.web.advice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.NotFoundException;
import com.nttdata.tim.now.core.exception.NotReadyException;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.web.exception.FileNotFoundHttpException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class ExceptionHandlerAdvice {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(value = { Exception.class, BusinessLayerException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public EmptyBean exception(Exception exception) {
		logger.error("Generic Exception", exception);
		EmptyBean errorBean = new EmptyBean();
		errorBean.setResult(new Result(ResultCodeEnum.GENERIC_ERROR.getCode(), exception.getMessage(), ResultCodeEnum.GENERIC_ERROR.getMessage()));
		return errorBean;
	}
	
	@ExceptionHandler(value = IOException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ModelAndView ioException(Exception exception) {
		if (("Connessione in corso interrotta forzatamente dall'host remoto".equals(exception.getCause().getMessage()))
				|| ("Connessione interrotta dal software del computer host".equals(exception.getCause().getMessage()))) {
			logger.debug("Catturato evento: " + exception.getCause().getMessage());
		} else {
			logger.error("Connection Error", exception);
		}
		Map<String, Object> model = new HashMap<>();
		model.put("exceptionName", exception.getClass().getSimpleName());
		model.put("exceptionMessage", exception.getMessage());
		ModelAndView mav = new ModelAndView("errore", "model", model);
		mav.setStatus(null);
		mav.setView(null);
		mav.clear();
		return mav;
	}

	@ExceptionHandler(value = {NotFoundException.class, NotReadyException.class})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public EmptyBean notFound(NotFoundException exception) {
		EmptyBean errorBean = new EmptyBean();
		errorBean.setResult(new Result(ResultCodeEnum.NOT_FOUND.getCode(), exception.getMessage(), ResultCodeEnum.NOT_FOUND.getMessage()));
		return errorBean;
	}

	@ExceptionHandler(value = MaxUploadSizeExceededException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public EmptyBean notFound(MaxUploadSizeExceededException ex) {
		logger.info("File Upload fallito", ex);
		EmptyBean errorBean = new EmptyBean();
		errorBean.setResult(new Result(ResultCodeEnum.VALIDATION_ERROR.getCode(), "Le dimensioni del file superano il limite di 20MB", ResultCodeEnum.VALIDATION_ERROR.getMessage()));
		return errorBean;
	}

	@ExceptionHandler(value = FileNotFoundHttpException.class)
	public String fileNotFound(FileNotFoundHttpException ex) throws IOException {
		logger.info("Impossibile effettuare il download del file." + ex.getMessage());
		return "redirect:/404.html";
	}
}
