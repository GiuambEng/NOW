package com.nttdata.tim.now.core.service.olo;

import java.util.List;

import com.nttdata.tim.now.adapters.esb.olo.OloRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.carrier.VerificaCarrierOloCPSInputBean;
import com.nttdata.tim.now.data.bean.carrier.VerificaCarrierOloCPSWrapperOutputBean;
import com.nttdata.tim.now.data.bean.olo.VerificaOloNumericoOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaContrattoInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaContrattoWrapperOutputBean;
import com.nttdata.tim.now.data.dto.contratto.VerificaContrattoInputDTO;
import com.nttdata.tim.now.data.dto.contratto.VerificaContrattoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.olo.CodiceOloListDTO;
import com.nttdata.tim.now.data.dto.olo.VerificaCarrierOloCPSWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.olo.VerificaOloNumericoOutputDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OloManagerBL extends AbstractBL {

	@Autowired
	private OloRESTClient oloRestIL;

	public VerificaOloNumericoOutputBean verificaOloNumerico(String codOlo, String tipoProfilo) throws BusinessLayerException {
		VerificaOloNumericoOutputBean bean = null;
		try {
			VerificaOloNumericoOutputDTO dto = oloRestIL.verificaOloNumerico(codOlo, tipoProfilo);
			validateResponseResult(dto);
			bean = mapper.translate(dto, VerificaOloNumericoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<String> checkUnivocalOlo(String codOlo, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<String> bean = new GenericListBean<>();
		try {
			CodiceOloListDTO dto = oloRestIL.checkUnivocalOlo(codOlo, tipoProfilo);
			validateResponseResult(dto);
			List<String> list = dto.getCodOloAgcomList();
			bean.setData(list);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	//RU_915
	public VerificaCarrierOloCPSWrapperOutputBean checkCarrierOloCps(String tipoProfilo, VerificaCarrierOloCPSInputBean request) throws BusinessLayerException {
		VerificaCarrierOloCPSWrapperOutputBean bean = new VerificaCarrierOloCPSWrapperOutputBean();
		try {
			VerificaCarrierOloCPSWrapperOutputDTO dto = oloRestIL.checkCarrierOloCps(tipoProfilo, request);
			validateResponseResult(dto);
			bean = mapper.translate(dto, VerificaCarrierOloCPSWrapperOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
	
	//RU_915
	public VerificaContrattoWrapperOutputBean checkContract(String tipoProfilo, VerificaContrattoInputBean inputBean) throws BusinessLayerException {
		VerificaContrattoWrapperOutputBean bean = new VerificaContrattoWrapperOutputBean();
		try {
			VerificaContrattoInputDTO inputDto = mapper.translate(inputBean, VerificaContrattoInputDTO.class);
			VerificaContrattoWrapperOutputDTO dto = oloRestIL.checkContract(tipoProfilo, inputDto);
			validateResponseResult(dto);
			bean = mapper.translate(dto, VerificaContrattoWrapperOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
