package com.nttdata.tim.now.web.controller.generic;

import javax.servlet.http.HttpSession;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.NotFoundException;
import com.nttdata.tim.now.core.exception.NotReadyException;
import com.nttdata.tim.now.core.service.generic.ExportAsincronoManagerBL;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.ProfiloCRM;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.controller.FileDownloadController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exportdata")
public class ExportAsincronoController extends FileDownloadController {
    
    @Autowired
    private ExportAsincronoManagerBL exportAsincronoManagerBL;

	private static final String DEFAULT_EXPORT_PROCESS = "DEFAULT";

    
	@JsonGetMapping("/file/check")
	public CodiceOutputBean checkFileReady(@RequestParam(value = "idExport") String idExport, @RequestParam(value = "areaFunzione") String areaFunzione, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		CodiceOutputBean bean = null;
		String codiceprofilo = "";
		if (!DEFAULT_EXPORT_PROCESS.equals(areaFunzione)) {
		   logger.debug("areaFunzione = "+ areaFunzione);
		   codiceprofilo = getCodiceProfiloOLO();
		}else {
			codiceprofilo = user.getCodiceProfilo();
		}
        try {
		    bean = exportAsincronoManagerBL.checkExport(idExport, user.getUserId(), codiceprofilo);
			bean.setResult(getSuccessResult());
		} catch (NotReadyException e) {
			logger.info("Recupero Export: file ancora non pronto id:"+idExport);
			return getFileNotReadyResult();
		}
		return bean;
	}

	//RU_902
	@JsonGetMapping("/file")
	public ResponseEntity<byte[]> download(@RequestParam(value = "idFile") String idFile, 
										   @RequestParam(value = "areaFunzione") String areaFunzione, 
										   @RequestParam(value = "vista", required = false) String vista,	//SM_8904
										   @RequestParam(value = "numeroDatiEsportati", required = false) Integer numeroDatiEsportati, 
										   @RequestParam(value = "filtriDatiEsportati", required = false) String filtriDatiEsportati,
										   HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		String codiceprofilo = "";
		if (!DEFAULT_EXPORT_PROCESS.equals(areaFunzione)) {
			   logger.debug("areaFunzione = "+ areaFunzione);
			   codiceprofilo = getCodiceProfiloOLO();
			}else {
				codiceprofilo = user.getCodiceProfilo();
			}
		try {
			//SM_8904
			if(vista == null) {
				vista = "";
			}
			FileScaricatoBean fileBean = exportAsincronoManagerBL.getExport(idFile, user.getUserId(), codiceprofilo, numeroDatiEsportati, filtriDatiEsportati, vista, user);
			return getFileResponseEntity(fileBean);
		} catch (NotReadyException e) {
			logger.info("Recupero Export fallito: file ancora non pronto o non esistente", e);
			throw new NotFoundException();
		}
	}

	protected CodiceOutputBean getFileNotReadyResult() {
		Result result = new Result();
		result.setCode(ResultCodeEnum.NOT_READY.getCode());
		result.setDescription("KO");
		result.setMessage(ResultCodeEnum.NOT_READY.getMessage());
		
		CodiceOutputBean bean = new CodiceOutputBean();
		bean.setCodice("KO");
		bean.setResult(result);
		return bean;
	}
	
	private String getCodiceProfiloOLO() {
		return ProfiloCRM.CRM_OLO.name();
	}

}
