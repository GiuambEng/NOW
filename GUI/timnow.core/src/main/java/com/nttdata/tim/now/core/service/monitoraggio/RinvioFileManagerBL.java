package com.nttdata.tim.now.core.service.monitoraggio;

import java.util.List;
import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.monitoraggio.FileResendRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;
import com.nttdata.tim.now.data.bean.file.FileBean;
import com.nttdata.tim.now.data.bean.file.ListaFileScaricatiBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.codice.ListaCodiceOutputDTO;
import com.nttdata.tim.now.data.dto.file.ListaFileDTO;
import com.nttdata.tim.now.data.dto.file.ListaFileScaricatiDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RinvioFileManagerBL extends AbstractBL {

    @Autowired
    private FileResendRESTClient fileResendRESTClient;
    
	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	public GenericListBean<CodiceOutputBean> requestResendFile(ListaFileScaricatiBean body, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<CodiceOutputBean> bean = new GenericListBean<>();
		try {
			ListaFileScaricatiDTO inputDTO = mapper.translate(body, ListaFileScaricatiDTO.class);
			ListaCodiceOutputDTO outputDto = fileResendRESTClient.requestResendFile(inputDTO,tipoProfilo);
			validateResponseResult(outputDto);
			bean.setData(mapper.translateList(outputDto.getCodes(), CodiceOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<FileBean> fileAdvanceResearch(RicercaAvanzataInputBean body, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<FileBean> bean = new GenericListBean<>();
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(body.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata RinvioFileManager");
    	}
		
		boolean isLimited;
		//Gestione lista limitata
		try {
			AdvancedResearchInputDTO dto = mapper.translate(body, AdvancedResearchInputDTO.class);
			ListaFileDTO outputDto = fileResendRESTClient.advancedSearch(dto, tipoProfilo);
			isLimited = validateResponseResult(outputDto);
			List<FileBean> mails = mapper.translateList(outputDto.getFiles(), FileBean.class);
			bean.setData(mails);
			bean.setIsLimitedList(isLimited);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
