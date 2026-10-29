package com.nttdata.tim.now.core.service.anagrafica;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.anagrafica.ContattoRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.contatto.ContattoOutputBean;
import com.nttdata.tim.now.data.bean.contatto.RiferimentiContattoOutputBean;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.contatto.ListaContattiOutputDTO;
import com.nttdata.tim.now.data.dto.contatto.ListaRiferimentiContattoOutputDTO;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class ContattoManagerBL extends AbstractBL {

	@Autowired
	private ContattoRESTClient contattoRestIL;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	@Cacheable(value = "contacts", key = "#codOlo + '-' + #tipoProfilo")
	public GenericListBean<ContattoOutputBean> getContacts(String codOlo, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListBean<ContattoOutputBean> list = new GenericListBean<>();
		boolean isLimited;
		//Gestione lista limitata
		try {
			ListaContattiOutputDTO dto = contattoRestIL.getContacts(codOlo, tipoProfilo, userId);
			isLimited = validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getContacts(), ContattoOutputBean.class));
			list.setIsLimitedList(isLimited);
		} catch (Exception e) {
			logger.error("Error reading contacts", e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

	@Cacheable(value = "contact", key = "#idContact")
	public GenericListBean<RiferimentiContattoOutputBean> getReferences(String idContact, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<RiferimentiContattoOutputBean> list = new GenericListBean<>();
		try {
			ListaRiferimentiContattoOutputDTO dto = contattoRestIL.getReferences(idContact, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getReferences(), RiferimentiContattoOutputBean.class));
		} catch (Exception bee) {
			logger.error("Error reading references", bee);
			throw new BusinessLayerException(bee);
		}
		return list;
	}

	public GenericListBean<ContattoOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String codOloAgcom, String tipoProfilo, String userId) throws BusinessLayerException {
		GenericListBean<ContattoOutputBean> list = new GenericListBean<>();
		boolean isLimited;
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata Contatto");
    	}

		//Gestione lista limitata
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ListaContattiOutputDTO dto = contattoRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
			isLimited = validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getContacts(), ContattoOutputBean.class));
			list.setIsLimitedList(isLimited);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public ExportableDataOutputBean requestExport(RicercaAvanzataInputBean inputBean, String codOloAgcom, String tipoProfilo, String userId) throws BusinessLayerException {
		ExportableDataOutputBean bean = new ExportableDataOutputBean();
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ExportableDataOutputDTO dto = contattoRestIL.advancedSearch(inputDto, codOloAgcom, tipoProfilo, userId);
			validateResponseResult(dto);
			bean = mapper.translate(dto, ExportableDataOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
