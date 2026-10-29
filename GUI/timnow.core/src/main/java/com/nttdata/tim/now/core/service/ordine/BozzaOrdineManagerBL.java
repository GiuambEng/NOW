package com.nttdata.tim.now.core.service.ordine;

import java.util.Date;
import java.util.Locale;

import com.nttdata.tim.now.adapters.esb.ordine.OrdineBozzaRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.exception.DuplicateEntryException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.ordine.draft.OrderDraftBean;
import com.nttdata.tim.now.data.bean.ordine.draft.OrdineBozzaInputBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.ordine.draft.OrderDraftListDTO;
import com.nttdata.tim.now.data.dto.ordine.draft.OrdineBozzaInputDTO;
import com.nttdata.tim.now.data.enumeration.BackEndResultCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BozzaOrdineManagerBL extends AbstractBL {

	@Autowired
	private OrdineBozzaRESTClient bozzaRestIL;

	public EmptyBean createUpdateDraft(OrdineBozzaInputBean body, String tipoProfilo) throws BusinessLayerException, DuplicateEntryException {
		EmptyBean bean = null;
	    Locale.setDefault(Locale.ENGLISH);
		try {
			if (body.getOperationType()!=null && "UPDATE".equals(body.getOperationType().toUpperCase())){
				OrdineBozzaInputDTO inputDTO = mapper.translate(body, OrdineBozzaInputDTO.class);
				inputDTO.setUltimoAggiornamento(new Date());
				ESBResultDTO outputDto = bozzaRestIL.updateDraft(inputDTO, tipoProfilo);
				validateResponseResult(outputDto);
				bean = mapper.translate(outputDto, EmptyBean.class);
			}else{
				OrdineBozzaInputDTO inputDTO = mapper.translate(body, OrdineBozzaInputDTO.class);
				ESBResultDTO outputDto = bozzaRestIL.createDraft(inputDTO, tipoProfilo);
				validateResponseResult(outputDto);
				bean = mapper.translate(outputDto, EmptyBean.class);
			}
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (bean != null && bean.getResult() != null
				&& (BackEndResultCode.ALREADY_EXISTS.getCode().equals(bean.getResult().getCode()))) {
			throw new DuplicateEntryException();
		}

		return bean;
	}

	public GenericListBean<OrderDraftBean> getDrafts(String tipoProfilo, String codOloAgcom, String userId)
			throws BusinessLayerException {
		GenericListBean<OrderDraftBean> bean = new GenericListBean<>();
		try {
			OrderDraftListDTO dto = bozzaRestIL.getDrafts(tipoProfilo, codOloAgcom, userId);
			validateResponseResult(dto);
			bean.setData(mapper.translateList(dto.getDrafts(), OrderDraftBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public OrderDraftBean getDraft(String codOrdOlo, String codOloAgcom, String tipoProfilo) throws BusinessLayerException {
		OrderDraftBean bean = null;
		try {
			OrderDraftListDTO outputDto = bozzaRestIL.getDraft(codOrdOlo, codOloAgcom, tipoProfilo);
			validateResponseResult(outputDto);
			if (outputDto != null && outputDto.getDrafts() != null && !outputDto.getDrafts().isEmpty()) {
				bean = mapper.translate(outputDto.getDrafts().get(0), OrderDraftBean.class);
			}
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public EmptyBean deleteDraft(String codOrdOlo, String codOloAgcom, String tipoProfilo) throws BusinessLayerException {
		EmptyBean bean = null;
		try {
			ESBResultDTO outputDto = bozzaRestIL.deleteDraft(codOrdOlo, codOloAgcom, tipoProfilo);
			validateResponseResult(outputDto);
			bean = mapper.translate(outputDto, EmptyBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

}
