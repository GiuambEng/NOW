package com.nttdata.tim.now.core.service.ordine;

import com.nttdata.tim.now.adapters.esb.ordine.EsitiRichiesteRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.ordine.RichiestaInputBean;
import com.nttdata.tim.now.data.bean.richiesta.EsitiRichiesteInputBean;
import com.nttdata.tim.now.data.bean.richiesta.EsitiRichiesteOutputBean;
import com.nttdata.tim.now.data.bean.richiesta.RecuperaNotificheRichiestaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.base.CreateResponseDTO;
import com.nttdata.tim.now.data.dto.richiesta.EsitiRichiesteInputDTO;
import com.nttdata.tim.now.data.dto.richiesta.EsitiRichiesteOutputDTO;
import com.nttdata.tim.now.data.dto.richiesta.RecuperaNotificheRichiestaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.richiesta.RequestDTO;
import com.nttdata.tim.now.data.dto.richiesta.RequestReferentDTO;
import com.nttdata.tim.now.util.FlagHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EsitiRichiesteManagerBL extends AbstractBL {

	@Autowired
	private EsitiRichiesteRESTClient esitiRichiesteRestIL;

	public EsitiRichiesteOutputBean getOutcomesRequets(String idRichiesta, String tipoProfilo, String codAgcom) throws BusinessLayerException {
		EsitiRichiesteOutputBean bean = null;
		try {
			EsitiRichiesteOutputDTO dto = esitiRichiesteRestIL.getOutcomesRequets(idRichiesta, tipoProfilo, codAgcom);
			validateResponseResult(dto);
			bean = mapper.translate(dto, EsitiRichiesteOutputBean.class);
		} catch (Exception bee) {
			logger.error("Error reading outcomes request", bee);
			throw new BusinessLayerException(bee);
		}
		return bean;
	}

	public EmptyBean createRequest(RichiestaInputBean bean, String userId, String tipoProfilo) throws BusinessLayerException {
		RequestDTO inputDTO = mapper.translate(bean, RequestDTO.class);
		inputDTO.setOperatore(userId);
		inputDTO.setFlagAccettazione(FlagHelper.convertFromFE(bean.isFlagAccettazione()));
		CreateResponseDTO outputDTO = null;
		EmptyBean outputBean = null;
		if (StringUtils.isNotBlank(bean.getCognome())) {
			inputDTO.setReferente(mapper.translate(bean, RequestReferentDTO.class));
		}
		try {
			outputDTO = esitiRichiesteRestIL.createRequest(inputDTO, tipoProfilo);
		    validateResponseResult(outputDTO);
		    outputBean = mapper.translate(outputDTO, EmptyBean.class);
		    
		} catch (Exception e) {
			logger.error("Error creating request", e);
			throw new BusinessLayerException(e);
		}
		return outputBean;
	}
	
	//RU_888
	public RecuperaNotificheRichiestaWrapperOutputBean getNotificheRichiesta(String idRichiesta, String tipoProfilo, String codAgcom) throws BusinessLayerException {
		RecuperaNotificheRichiestaWrapperOutputBean bean = null;
		try {
			RecuperaNotificheRichiestaWrapperOutputDTO dto = esitiRichiesteRestIL.getNotificheRichiesta(idRichiesta, tipoProfilo, codAgcom);
			validateResponseResult(dto);
			bean = mapper.translate(dto, RecuperaNotificheRichiestaWrapperOutputBean.class);
		} catch (Exception bee) {
			logger.error("Error reading getNotificheRichiesta in manager", bee);
			throw new BusinessLayerException(bee);
		}
		return bean;
	}
	
	//SM_9693
	public EsitiRichiesteOutputBean recuperaEsitiERichieste(EsitiRichiesteInputBean input, UserBean user) throws BusinessLayerException {
		EsitiRichiesteOutputBean bean = null;
		try {
			//Valorizzazione dell' IP client
			if(user != null && user.getRequestInfo() != null && user.getRequestInfo().getIpClient() != null) {
				input.setIpClient(user.getRequestInfo().getIpClient());
				input.setOperatore(user.getUserId());
				input.setTipoProfilo(user.getCodiceProfilo());
			}
			
			EsitiRichiesteInputDTO inputDto = mapper.translate(input, EsitiRichiesteInputDTO.class);
			
			EsitiRichiesteOutputDTO dto = esitiRichiesteRestIL.recuperaEsitiERichieste(inputDto);
			
			validateResponseResult(dto);
			bean = mapper.translate(dto, EsitiRichiesteOutputBean.class);
		} catch (Exception bee) {
			logger.error("Error reading outcomes request", bee);
			throw new BusinessLayerException(bee);
		}
		return bean;
	}
}
