package com.nttdata.tim.now.core.service.monitoraggio;

import java.util.List;
import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.monitoraggio.MailResendRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;
import com.nttdata.tim.now.data.bean.monitoring.reinviomail.RinvioMailListInputBean;
import com.nttdata.tim.now.data.bean.monitoring.reinviomail.RinvioMailOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.codice.ListaCodiceOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.reinviomail.RinvioMailListInputDTO;
import com.nttdata.tim.now.data.dto.monitoring.reinviomail.RinvioMailListOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RinvioMailManagerBL extends AbstractBL {

    @Autowired
    private MailResendRESTClient mailResendRESTClient;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	public GenericListBean<CodiceOutputBean> invioMail(RinvioMailListInputBean input, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<CodiceOutputBean> bean = new GenericListBean<>();
		try {
			RinvioMailListInputDTO inputDto = mapper.translate(input, RinvioMailListInputDTO.class);
			ListaCodiceOutputDTO dto = mailResendRESTClient.invioEmail(inputDto, tipoProfilo);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getCodes(), CodiceOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<RinvioMailOutputBean> advancedSearch(RicercaAvanzataInputBean searchBean, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<RinvioMailOutputBean> bean = new GenericListBean<>();
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(searchBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata RinvioMailManager");
    	}

		boolean isLimited;
		//Gestione lista limitata
		try {
			AdvancedResearchInputDTO dto = mapper.translate(searchBean, AdvancedResearchInputDTO.class);
			RinvioMailListOutputDTO outputDto = mailResendRESTClient.advancedSearch(dto, tipoProfilo);
			isLimited = validateResponseResult(outputDto);
			List<RinvioMailOutputBean> mails = mapper.translateList(outputDto.getMails(), RinvioMailOutputBean.class);
			bean.setData(mails);
			bean.setIsLimitedList(isLimited);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
