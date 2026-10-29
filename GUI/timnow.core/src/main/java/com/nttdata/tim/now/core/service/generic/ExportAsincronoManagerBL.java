package com.nttdata.tim.now.core.service.generic;

import com.nttdata.tim.now.adapters.esb.generic.ExportAsincronoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.NotReadyException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;
import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileWrapperDTO;
import com.nttdata.tim.now.data.enumeration.BackEndResultCode;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExportAsincronoManagerBL extends AbstractBL {

	@Autowired
	private ExportAsincronoRESTClient exportAsincronoRestIL;

	public CodiceOutputBean checkExport(String idFile, String userId, String tipoProfilo) throws BusinessLayerException {
		CodiceOutputBean bean = new CodiceOutputBean();
		ESBResultDTO dto = null;
		try {
			dto = exportAsincronoRestIL.check(idFile, userId, tipoProfilo);
			validateResponseResult(dto);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		String code = dto.getResult().getCode();
		if (BackEndResultCode.FILE_NOT_READY.getCode().equals(code)) {
			throw new NotReadyException();
		} else if (BackEndResultCode.ERROR.getCode().equals(code)) {
			throw new BusinessLayerException("Impossibile completare export file");
		} else {
			bean.setCodice("OK");
		}

		return bean;
	}

	//RU_902
	public FileScaricatoBean getExport(String idFile, 
			String userId, 
			String tipoProfilo, 
			Integer numeroDatiEsportati, 
			String filtriDatiEsportati, 
			String vista, //SM_8904 
			UserBean user) throws BusinessLayerException {
		FileWrapperDTO wrapper;
		try {
			//SM_8904
			wrapper = exportAsincronoRestIL.download(idFile, userId, tipoProfilo, numeroDatiEsportati, filtriDatiEsportati, vista, user);
			validateResponseResult(wrapper);
		} catch (IntegrationLayerException e) {
			logger.error("Error downloading file", e);
			throw new BusinessLayerException(e);
		}
		FileScaricatoBean bean;
		if (wrapper != null && wrapper.getFile() != null) {
			bean = new FileScaricatoBean();
			byte[] fileData = new Base64().decode(wrapper.getFile().getContenutoFile().getBytes());
			bean.setFileData(fileData);
			bean.setName(wrapper.getFile().getNomeFile());
			bean.setSize(fileData.length);
		} else {
			throw new NotReadyException("Not ready export data with id " + idFile);
		}
		return bean;
	}
	
}
