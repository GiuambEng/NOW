package com.nttdata.tim.now.core.service.offerta;

import java.util.regex.Pattern;

import com.nttdata.tim.now.adapters.esb.offerta.BandaRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.banda.BandaDedicataOutputBean;
import com.nttdata.tim.now.data.bean.banda.BandaPiccoOutputBean;
import com.nttdata.tim.now.data.bean.banda.ControlloValoriBandaPiccoOutputBean;
import com.nttdata.tim.now.data.bean.banda.ListaControlloValoriBandaPiccoInputBean;
import com.nttdata.tim.now.data.bean.banda.TipoBandaOutputBean;
import com.nttdata.tim.now.data.bean.banda.VerificaCoppiaBandePiccoInputBean;
import com.nttdata.tim.now.data.bean.banda.VerificaCoppiaBandePiccoOutputBean;
import com.nttdata.tim.now.data.bean.banda.VerificaSommaBandePiccoInputBean;
import com.nttdata.tim.now.data.bean.banda.VerificaSommaBandePiccoOutputBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.banda.BandaOutputDTO;
import com.nttdata.tim.now.data.dto.banda.ControlloValoriBandaPiccoInputDTO;
import com.nttdata.tim.now.data.dto.banda.ControlloValoriBandaPiccoOutputDTO;
import com.nttdata.tim.now.data.dto.banda.ListaBandeDedicateOutputDTO;
import com.nttdata.tim.now.data.dto.banda.ListaBandePiccoOutputDTO;
import com.nttdata.tim.now.data.dto.banda.ListaControlloValoriBandaPiccoInputDTO;
import com.nttdata.tim.now.data.dto.banda.ListaTipoBandeOutputDTO;
import com.nttdata.tim.now.data.dto.banda.VerificaCoppiaBandePiccoInputDTO;
import com.nttdata.tim.now.data.dto.banda.VerificaCoppiaBandePiccoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.banda.VerificaSommaBandePiccoInputDTO;
import com.nttdata.tim.now.data.dto.banda.VerificaSommaBandePiccoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BandaManagerBL extends AbstractBL {

	private static final String LAV_ATTIVAZIONE = "ATTIVAZIONE";
	private static final String LAV_VARIAZIONE = "VARIAZIONE";
	private static final String LAV_MIGRAZIONE = "MIGRAZIONE";

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	@Autowired
	private BandaRESTClient bandaRestIL;

	public GenericListBean<BandaPiccoOutputBean> getBands(String tipoCos, String codiceLan, String idOfferta, String profTecnicoLinea, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<BandaPiccoOutputBean> list = new GenericListBean<>();
		try {
			ListaBandePiccoOutputDTO dto = bandaRestIL.getBands(tipoCos, codiceLan, idOfferta, profTecnicoLinea, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getPeakBands(), BandaPiccoOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public GenericListBean<BandaPiccoOutputBean> getBandsNewOrder(String tipoCos, String codiceLan, String idOfferta, String profTecnicoLinea, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<BandaPiccoOutputBean> list = new GenericListBean<>();
		try {
			ListaBandePiccoOutputDTO dto = bandaRestIL.getBandsNewOrder(tipoCos, codiceLan, idOfferta, profTecnicoLinea, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getPeakBands(), BandaPiccoOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}
	
	public VerificaSommaBandePiccoOutputBean checkBand(VerificaSommaBandePiccoInputBean input, String tipoProfilo) throws BusinessLayerException {
		VerificaSommaBandePiccoOutputBean bean = new VerificaSommaBandePiccoOutputBean();
		try {
			VerificaSommaBandePiccoInputDTO inputDto = mapper.translate(input, VerificaSommaBandePiccoInputDTO.class);
			inputDto.setOfferta(inputDto.getOfferta().toUpperCase());
			inputDto.setUserVlan(mapper.translateList(input.getUserVlan(), BandaOutputDTO.class));
			VerificaSommaBandePiccoWrapperOutputDTO outputDto = bandaRestIL.checkBand(inputDto, tipoProfilo);
			validateResponseResult(outputDto);
			bean.setOutcome(mapper.translate(outputDto.getOutputVerificaSommaBandePicco(), EsitoOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<VerificaCoppiaBandePiccoOutputBean> checkCouple(VerificaCoppiaBandePiccoInputBean body, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<VerificaCoppiaBandePiccoOutputBean> list = new GenericListBean<>();
		try {
			VerificaCoppiaBandePiccoInputDTO inputDto = mapper.translate(body, VerificaCoppiaBandePiccoInputDTO.class);
			if (inputDto != null && inputDto.getLavorazione() != null && StringUtils.isNotEmpty(inputDto.getLavorazione())) {
				if (LAV_ATTIVAZIONE.equalsIgnoreCase(inputDto.getLavorazione())) {
					inputDto.setLavorazione(LAV_ATTIVAZIONE);
				} else if (LAV_VARIAZIONE.equalsIgnoreCase(inputDto.getLavorazione())) {
					inputDto.setLavorazione(LAV_VARIAZIONE);
				} else if (LAV_MIGRAZIONE.equalsIgnoreCase(inputDto.getLavorazione())) {
					inputDto.setLavorazione(LAV_MIGRAZIONE);
				} else {
					logger.debug("verifica coppia banda picco - tipo lavorazione inattesa");
				}
			}

			VerificaCoppiaBandePiccoWrapperOutputDTO outputDto = bandaRestIL.checkCouple(inputDto, tipoProfilo);
			validateResponseResult(outputDto);
			list.setData(mapper.translateList(outputDto.getOutbands(), VerificaCoppiaBandePiccoOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public GenericListBean<BandaDedicataOutputBean> viewDedicatedBand(String idOfferta, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<BandaDedicataOutputBean> list = new GenericListBean<>();
		try {
			ListaBandeDedicateOutputDTO outputDto = bandaRestIL.viewDedicatedBand(idOfferta, tipoProfilo);
			validateResponseResult(outputDto);
			list.setData(mapper.translateList(outputDto.getBandaDedicataList(), BandaDedicataOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public GenericListBean<TipoBandaOutputBean> viewTypeBand(String codVlanSvlan, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<TipoBandaOutputBean> list = new GenericListBean<>();
		try {
			ListaTipoBandeOutputDTO outputDto = bandaRestIL.viewTypeBand(codVlanSvlan, tipoProfilo);
			validateResponseResult(outputDto);
			list.setData(mapper.translateList(outputDto.getTipoBandaList(), TipoBandaOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}
	
	public GenericListBean<BandaPiccoOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
    	Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
    	if (!checkPassValidationInputSearch(inputBean.getConditions(),pattern)){
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException("Non superato il validatore della form di input della ricerca avanzata BandaManager");
    	}

		GenericListBean<BandaPiccoOutputBean> list = new GenericListBean<>();
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			ListaBandePiccoOutputDTO dto = bandaRestIL.advancedSearch(inputDto, tipoProfilo);
			validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getPeakBands(), BandaPiccoOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public ControlloValoriBandaPiccoOutputBean checkValues(ListaControlloValoriBandaPiccoInputBean input, String tipoProfilo) throws BusinessLayerException {
		ControlloValoriBandaPiccoOutputBean bean = new ControlloValoriBandaPiccoOutputBean();
		try {
			ListaControlloValoriBandaPiccoInputDTO inputDto = new ListaControlloValoriBandaPiccoInputDTO();
			inputDto.setLavorazione(input.getLavorazione());
			inputDto.setUserVlan(mapper.translateList(input.getUserVlan(), ControlloValoriBandaPiccoInputDTO.class));

			ControlloValoriBandaPiccoOutputDTO outputDto = bandaRestIL.checkValues(inputDto, tipoProfilo);
			validateResponseResult(outputDto);
			bean = mapper.translate(outputDto, ControlloValoriBandaPiccoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
