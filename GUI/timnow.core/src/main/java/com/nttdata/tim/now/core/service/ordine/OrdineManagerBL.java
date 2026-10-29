package com.nttdata.tim.now.core.service.ordine;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nttdata.tim.now.adapters.esb.ordine.OrdineRESTClient;
import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.AbstractBL;
import com.nttdata.tim.now.data.bean.asset.VerificaIdRisorsaInputBean;
import com.nttdata.tim.now.data.bean.asset.VerificaIdRisorsaNakedInputBean;
import com.nttdata.tim.now.data.bean.asset.VerificaIdRisorsaNakedOutputBean;
import com.nttdata.tim.now.data.bean.asset.VerificaIdRisorsaOutputBean;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.bean.ordine.CheckNumMaxVCConfigurabiliOutputBean;
import com.nttdata.tim.now.data.bean.ordine.CoerenzaOutputBean;
import com.nttdata.tim.now.data.bean.ordine.CompatibilitaProfiloTecnicoLineaProfiloVCBean;
import com.nttdata.tim.now.data.bean.ordine.ConfigurazioneOutputBean;
import com.nttdata.tim.now.data.bean.ordine.ConsistenzaOutputBean;
import com.nttdata.tim.now.data.bean.ordine.ConsuntivoOrdineOutputBean;
import com.nttdata.tim.now.data.bean.ordine.CreazioneNuovoOrdineInputBean;
import com.nttdata.tim.now.data.bean.ordine.OrdineOutputBean;
import com.nttdata.tim.now.data.bean.ordine.PresenzaOutputBean;
import com.nttdata.tim.now.data.bean.ordine.PreventivoOrdineOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCARInputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCARWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCampiOffertaVPInputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCampiOffertaVPWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaClusterAccessoOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCodOloSubContractorWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCodiceOperatoreSecondarioWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCodiceServizioSystemUnicoInputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCodiceServizioSystemUnicoOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCodiceSubAppaltoInputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCodiceSubAppaltoOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCodiceSystemUnicoInputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCodiceSystemUnicoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCodiciTdKitInputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaCodiciTdKitWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaIdGponInputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaIdGponWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaMacroAreaInputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaMacroAreaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaProfiliFwaInputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaProfiliFwaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaServiziOpzionaliAlternativiWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaSubContractorWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaTipologiaImpresaInputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperaTipologiaImpresaOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RecuperoDataTimeoutOutputBean;
import com.nttdata.tim.now.data.bean.ordine.RichiestaPreventivoOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaAbilitazioneMulticastContrattoWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaCodiceOrdineOloOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaCodiceProgettoOneStepInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaCodiceTdKitInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaCodiceTdKitWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaCompatibilitaLavorazioneInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaCompatibilitaLavorazioneOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaCompatibilitaProfiloTecnicoLineaInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaComuneOffertaInfratelInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaComuneOffertaInfratelWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaCongruenzaClusterComuneVlanInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaCongruenzaClusterComuneVlanOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaContrattoCoinvestimentoComuneInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaContrattoCoinvestimentoComuneWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaContrattoPerVariazioneOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaIdRisorsaSwitchoffFwaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaIntermediateAgentFullInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaIntermediateAgentFullWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaKitAbilitatoNGAInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaKitAbilitatoNGAWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaModelloKitInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaModelloKitMadrWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaModelloKitWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaNoteOperatoreInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaNoteOperatoreWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaOloWholesalerInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaOloWholesalerOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaOrdineVariazioneDowngradeFastInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaPerVariazioneWlrInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaPerVariazioneWlrOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaProfiloTecnicoLineaX1X2WrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaRecuperoModemWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaTecnologiaOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaTipologiaContrattoFwaInputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaTipologiaContrattoFwaWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaVpFlatAttestazioneOutputBean;
import com.nttdata.tim.now.data.bean.ordine.VerificaVpFlatAttestazioneWrapperInputBean;
import com.nttdata.tim.now.data.bean.ordine.VisualizzaCampiOfferteVLANInputBean;
import com.nttdata.tim.now.data.bean.ordine.VisualizzaCampiOfferteVLANWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.dettaglio.DettaglioOrdineOutputBean;
import com.nttdata.tim.now.data.bean.ordine.donating.RecuperoCodiceDonatingOutputBean;
import com.nttdata.tim.now.data.bean.ordine.export.RichiestaExportOrdiniInputBean;
import com.nttdata.tim.now.data.bean.ordine.export.RichiestaExportOrdiniOutputBean;
import com.nttdata.tim.now.data.bean.ordine.multicast.VisualizzaCampiOfferteMulticastInputBean;
import com.nttdata.tim.now.data.bean.ordine.multicast.VisualizzaCampiOfferteMulticastWrapperOutputBean;
import com.nttdata.tim.now.data.bean.ordine.richiesta.RecuperaRichiesteOutputBean;
import com.nttdata.tim.now.data.bean.ordine.verificarichiesta.VerificaRichiestaInputBean;
import com.nttdata.tim.now.data.bean.ordine.verificarichiesta.VerificaRichiestaOutputBean;
import com.nttdata.tim.now.data.bean.ordine.verifichevlan.VerificaCongruenzaDRGOffertaInputBean;
import com.nttdata.tim.now.data.bean.ordine.verifichevlan.VerificaSpostamentoVLANInputBean;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.dto.asset.VerificaIdRisorsaInputDTO;
import com.nttdata.tim.now.data.dto.asset.VerificaIdRisorsaNakedInputDTO;
import com.nttdata.tim.now.data.dto.asset.VerificaIdRisorsaNakedOutputDTO;
import com.nttdata.tim.now.data.dto.asset.VerificaIdRisorsaOutputDTO;
import com.nttdata.tim.now.data.dto.base.CreateResponseDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;
import com.nttdata.tim.now.data.dto.ordine.CheckNumMaxVCConfigurabiliOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.CoerenzaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.CompatibilitaProfiloTecnicoLineaProfiloVC_DTO;
import com.nttdata.tim.now.data.dto.ordine.ConfigurazioneListOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.ConsistenzaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.CreazioneNuovoOrdineInputDTO;
import com.nttdata.tim.now.data.dto.ordine.OrderConsuntivoOutputListDTO;
import com.nttdata.tim.now.data.dto.ordine.OrderPreventivoOutputListDTO;
import com.nttdata.tim.now.data.dto.ordine.OrdersListDTO;
import com.nttdata.tim.now.data.dto.ordine.PresenzaOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCARInputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCARWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCampiOffertaVPInputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCampiOffertaVPWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaClusterAccessoOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCodOloSubContractorWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCodiceOperatoreSecondarioWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCodiceServizioSystemUnicoInputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCodiceServizioSystemUnicoOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCodiceSubAppaltoInputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCodiceSubAppaltoOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCodiceSystemUnicoInputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCodiceSystemUnicoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCodiciTdKitInputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaCodiciTdKitWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaIdGponInputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaIdGponWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaMacroAreaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaMacroAreaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaProfiliFwaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaProfiliFwaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaServiziOpzionaliAlternativiWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaSubContractorWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaTipologiaImpresaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperaTipologiaImpresaOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RecuperoDataTimeoutOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.RichiestaPreventivoOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaAbilitazioneMulticastContrattoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaCodiceOrdineOloWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaCodiceProgettoOneStepInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaCodiceProgettoOneStepOutputWrapperDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaCodiceTdKitInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaCodiceTdKitWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaCompatibilitaLavorazioneInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaCompatibilitaLavorazioneOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaCompatibilitaProfiloTecnicoLineaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaComuneOffertaInfratelInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaComuneOffertaInfratelWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaCongruenzaClusterComuneVlanInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaCongruenzaClusterComuneVlanOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaContrattoCoinvestimentoComuneInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaContrattoCoinvestimentoComuneWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaContrattoPerVariazioneOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaIdRisorsaSwitchoffFwaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaInConsistenzaPresenzaModemOutputWrapperDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaIntermediateAgentFullInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaIntermediateAgentFullWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaKitAbilitatoNGAInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaKitAbilitatoNGAWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaModelloKitInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaModelloKitMadrWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaModelloKitWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaNoteOperatoreInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaNoteOperatoreWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaOloWholesalerInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaOloWholesalerOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaOrdineVariazioneDowngradeFastInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaOrdineVariazioneDowngradeFastWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaPerVariazioneWlrInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaPerVariazioneWlrOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaProfiloTecnicoLineaX1X2WrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaRecuperoModemWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaTecnologiaOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaTicketTTMWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaTipologiaContrattoFwaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaTipologiaContrattoFwaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaVpFlatAttestazioneOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.VerificaVpFlatAttestazioneWrapperInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VisualizzaCampiOfferteVLANInputDTO;
import com.nttdata.tim.now.data.dto.ordine.VisualizzaCampiOfferteVLANWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.dettaglio.DettaglioOrdineWrapperDTO;
import com.nttdata.tim.now.data.dto.ordine.donating.RecuperoCodiceDonatingWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.export.RichiestaExportOrdiniInputDTO;
import com.nttdata.tim.now.data.dto.ordine.export.RichiestaExportOrdiniOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.multicast.VisualizzaCampiOfferteMulticastInputDTO;
import com.nttdata.tim.now.data.dto.ordine.multicast.VisualizzaCampiOfferteMulticastWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.richiesta.RecuperaRichiesteWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.verificarichiesta.VerificaRichiestaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.verificarichiesta.VerificaRichiestaOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.verifichevlan.VerificaCongruenzaDRGOffertaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.verifichevlan.VerificaSpostamentoVLANInputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.enumeration.OrderListType;
import com.nttdata.tim.now.data.enumeration.OrderState;

@Service
public class OrdineManagerBL extends AbstractBL {

	@Autowired
	private OrdineRESTClient ordineRestClient;

	@Value("${pattern.advancedSearch.regex}")
	private String patterRegex;

	public boolean createOrder(CreazioneNuovoOrdineInputDTO bean, String tipoProfilo) throws BusinessLayerException {
		try {
			CreateResponseDTO dto = ordineRestClient.createOrder(bean, tipoProfilo);
			validateResponseResult(dto);
		} catch (Exception e) {
			logger.error("Error creating order", e);
			throw new BusinessLayerException(e);
		}
		return true;
	}

	public GenericListBean<OrdineOutputBean> getOrders(String tipoProfilo, String codOlo, OrderState tipoLista)
			throws BusinessLayerException {
		GenericListBean<OrdineOutputBean> list = new GenericListBean<>();
		OrdersListDTO result;
		boolean isLimited;
		// Gestione lista limitata
		try {
			result = ordineRestClient.getOrders(tipoProfilo, codOlo, tipoLista);
			isLimited = validateResponseResult(result);
			list.setData(mapper.translateList(result.getOrders(), OrdineOutputBean.class));
			list.setIsLimitedList(isLimited);
		} catch (Exception e) {
			logger.error("Error reading order list", e);
			throw new BusinessLayerException(e);
		}

		return list;
	}

	public DettaglioOrdineOutputBean getOrder(String number, boolean isOloRequestId, String tipoProfilo)
			throws BusinessLayerException {
		DettaglioOrdineOutputBean bean = null;
		DettaglioOrdineWrapperDTO orderDTO = null;

		try {
			orderDTO = ordineRestClient.getDetailOrder(number, isOloRequestId, tipoProfilo);
			validateResponseResult(orderDTO);
		} catch (Exception e) {
			logger.error("Error reading order by number", e);
			throw new BusinessLayerException(e);
		}
		if (orderDTO != null) {
			bean = mapper.translate(orderDTO.getOrderDetailDTO(), DettaglioOrdineOutputBean.class);
		}
		return bean;
	}

	public EmptyBean createOrder(CreazioneNuovoOrdineInputBean order, String userId, String tipoProfilo)
			throws BusinessLayerException {
		try {
			CreazioneNuovoOrdineInputDTO orderInputDTO = mapper.translate(order, CreazioneNuovoOrdineInputDTO.class);
			orderInputDTO.setOperatore(userId);
			CreateResponseDTO dto = ordineRestClient.createOrder(orderInputDTO, tipoProfilo);
			validateResponseResult(dto);
			logger.debug("CreazioneNuovoOrdineInputBean: " + order.toString());
			logger.debug("CreazioneNuovoOrdineInputDTO: " + orderInputDTO.toString());
			return mapper.translate(dto, EmptyBean.class); // RU_844
		} catch (Exception e) {
			logger.error("Error creating order", e);
			throw new BusinessLayerException(e);
		}

	}

	public GenericListBean<OrdineOutputBean> advancedSearch(RicercaAvanzataInputBean inputBean, String codOloAgcom,
			String tipoProfilo, OrderState stato, OrderListType tipoLista) throws BusinessLayerException {
		Pattern pattern = Pattern.compile(patterRegex, Pattern.CASE_INSENSITIVE);
		if (!checkPassValidationInputSearch(inputBean.getConditions(), pattern)) {
			logger.info("checkPassValidationInputSearch NON SUPERATO*******");
			throw new BusinessLayerException(
					"Non superato il validatore della form di input della ricerca avanzata Ordine");
		}

		GenericListBean<OrdineOutputBean> list = new GenericListBean<>();
		OrdersListDTO result = null;
		boolean isLimited;
		// Gestione lista limitata
		try {
			AdvancedResearchInputDTO inputDto = mapper.translate(inputBean, AdvancedResearchInputDTO.class);
			result = ordineRestClient.advancedSearch(inputDto, codOloAgcom, tipoProfilo, stato, tipoLista);
			isLimited = validateResponseResult(result);
			list.setData(mapper.translateList(result.getOrders(), OrdineOutputBean.class));
			list.setIsLimitedList(isLimited);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public RichiestaExportOrdiniOutputBean requestExport(RichiestaExportOrdiniInputBean bean, String tipoProfilo)
			throws BusinessLayerException {
		try {
			RichiestaExportOrdiniInputDTO input = mapper.translate(bean, RichiestaExportOrdiniInputDTO.class);
			RichiestaExportOrdiniOutputDTO output = ordineRestClient.requestOrderExport(input, tipoProfilo);
			validateResponseResult(output);
			return mapper.translate(output, RichiestaExportOrdiniOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public VerificaRichiestaOutputBean verificaRichiestaOrdine(VerificaRichiestaInputBean bean, String tipoProfilo)
			throws BusinessLayerException {
		try {
			VerificaRichiestaInputDTO input = mapper.translate(bean, VerificaRichiestaInputDTO.class);
			VerificaRichiestaOutputDTO output = ordineRestClient.verificaRichiesta(input, tipoProfilo);
			validateResponseResult(output);
			return mapper.translate(output, VerificaRichiestaOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public VerificaIdRisorsaOutputBean requestVerifyResourceId(VerificaIdRisorsaInputBean bean, String tipoProfilo)
			throws BusinessLayerException {
		try {
			VerificaIdRisorsaInputDTO input = mapper.translate(bean, VerificaIdRisorsaInputDTO.class);
			VerificaIdRisorsaOutputDTO output = ordineRestClient.requestVerifyResourceId(input, tipoProfilo);
			validateResponseResult(output);
			return mapper.translate(output, VerificaIdRisorsaOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public VerificaIdRisorsaNakedOutputBean requestVerifyResourceIdNaked(VerificaIdRisorsaNakedInputBean bean,
			String tipoProfilo) throws BusinessLayerException {
		try {
			VerificaIdRisorsaNakedInputDTO input = mapper.translate(bean, VerificaIdRisorsaNakedInputDTO.class);
			VerificaIdRisorsaNakedOutputDTO output = ordineRestClient.requestVerifyResourceIdNaked(input, tipoProfilo);
			validateResponseResult(output);
			return mapper.translate(output, VerificaIdRisorsaNakedOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public VerificaOloWholesalerOutputBean requestVerifyOloWholesaler(VerificaOloWholesalerInputBean bean,
			String tipoProfilo) throws BusinessLayerException {
		try {
			VerificaOloWholesalerInputDTO input = mapper.translate(bean, VerificaOloWholesalerInputDTO.class);
			VerificaOloWholesalerOutputDTO output = ordineRestClient.requestVerifyOloWholesaler(input, tipoProfilo);
			validateResponseResult(output);
			return mapper.translate(output, VerificaOloWholesalerOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

	}

	public GenericListBean<ConfigurazioneOutputBean> getConfigurazione(String codFunzione, String idOfferta,
			String opzioneVariazione, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<ConfigurazioneOutputBean> list = new GenericListBean<>();
		ConfigurazioneListOutputDTO result = null;
		try {
			result = ordineRestClient.getConfigurazione(codFunzione, idOfferta, opzioneVariazione, tipoProfilo);
			validateResponseResult(result);
			list.setData(mapper.translateList(result.getConflist(), ConfigurazioneOutputBean.class));
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public ConsistenzaOutputBean getConsistenzaIdRisorsa(String idRisorsa, String tipoOperazione, String tipoProfilo)
			throws BusinessLayerException {
		ConsistenzaWrapperOutputDTO result = null;
		ConsistenzaOutputBean bean = null;
		try {
			result = ordineRestClient.getConsistenzaIdRisorsa(idRisorsa, tipoOperazione, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null && result.getConsistenza() != null) {
			bean = mapper.translate(result.getConsistenza(), ConsistenzaOutputBean.class);
		}

		return bean;
	}

	public VerificaCompatibilitaLavorazioneOutputBean verifyCompatibilitaLavorazione(
			VerificaCompatibilitaLavorazioneInputBean bean, String tipoProfilo) throws BusinessLayerException {
		try {
			VerificaCompatibilitaLavorazioneInputDTO input = mapper.translate(bean,
					VerificaCompatibilitaLavorazioneInputDTO.class);
			VerificaCompatibilitaLavorazioneOutputDTO output = ordineRestClient.verifyCompatibilitaLavorazione(input,
					tipoProfilo);
			validateResponseResult(output);
			return mapper.translate(output, VerificaCompatibilitaLavorazioneOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

	}

	public RichiestaPreventivoOutputBean getRichiestaPreventivo(String idRichiestaOlo, String tipoProfilo)
			throws BusinessLayerException {
		RichiestaPreventivoOutputBean bean = null;
		try {
			RichiestaPreventivoOutputDTO dto = ordineRestClient.getRichiestaPreventivo(idRichiestaOlo, tipoProfilo);
			validateResponseResult(dto);
			if (dto != null) {
				bean = mapper.translate(dto, RichiestaPreventivoOutputBean.class);
			}
		} catch (Exception e) {
			logger.error("Errore in richiesta preventivo", e);
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	public GenericListBean<ConsuntivoOrdineOutputBean> getListaConsuntivo(String idRichiestaOlo, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<ConsuntivoOrdineOutputBean> list = new GenericListBean<>();
		OrderConsuntivoOutputListDTO dto;
		boolean isLimited;
		// Gestione lista limitata
		try {
			dto = ordineRestClient.getOrdiniConsuntivo(idRichiestaOlo, tipoProfilo);
			isLimited = validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getOrders(), ConsuntivoOrdineOutputBean.class));
			list.setIsLimitedList(isLimited);
		} catch (Exception e) {
			logger.error("Error reading order consuntivo list", e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public GenericListBean<PreventivoOrdineOutputBean> getListaPreventivo(String idRichiestaOlo, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<PreventivoOrdineOutputBean> list = new GenericListBean<>();
		OrderPreventivoOutputListDTO dto;
		boolean isLimited;
		// Gestione lista limitata
		try {
			dto = ordineRestClient.getOrdiniPreventivo(idRichiestaOlo, tipoProfilo);
			isLimited = validateResponseResult(dto);
			list.setData(mapper.translateList(dto.getOrders(), PreventivoOrdineOutputBean.class));
			list.setIsLimitedList(isLimited);
		} catch (Exception e) {
			logger.error("Error reading order preventivo list", e);
			throw new BusinessLayerException(e);
		}
		return list;
	}

	public VerificaPerVariazioneWlrOutputBean getRichiestaVariazionePerWlr(VerificaPerVariazioneWlrInputBean bean,
			String tipoProfilo) throws BusinessLayerException {
		try {
			VerificaPerVariazioneWlrInputDTO input = mapper.translate(bean, VerificaPerVariazioneWlrInputDTO.class);
			VerificaPerVariazioneWlrOutputDTO output = ordineRestClient.getRichiestaVariazionePerWlr(input,
					tipoProfilo);
			validateResponseResult(output);
			return mapper.translate(output, VerificaPerVariazioneWlrOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public VerificaContrattoPerVariazioneOutputBean verificaContrattoPerVariazione(String idAsset, String tipoProfilo,
			String codOloAgcom) throws BusinessLayerException {
		try {
			VerificaContrattoPerVariazioneOutputDTO output = ordineRestClient.verificaContrattoPerVariazione(idAsset,
					tipoProfilo, codOloAgcom);
			validateResponseResult(output);
			return mapper.translate(output, VerificaContrattoPerVariazioneOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public CoerenzaOutputBean getCoerenzaIdRisorsa(String idRisorsa, String codOloAgcom, String tipoProfilo)
			throws BusinessLayerException {
		CoerenzaWrapperOutputDTO result = null;
		CoerenzaOutputBean bean = null;
		try {
			result = ordineRestClient.getCoerenzaIdRisorsa(idRisorsa, codOloAgcom, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null && result.getCoerenza() != null) {
			bean = mapper.translate(result.getCoerenza(), CoerenzaOutputBean.class);
		}

		return bean;
	}

	public PresenzaOutputBean getPresenzaIdRisorsa(String idRisorsa, String tipoProfilo) throws BusinessLayerException {
		PresenzaOutputDTO result = null;
		PresenzaOutputBean bean = null;
		try {
			result = ordineRestClient.getPresenzaIdRisorsa(idRisorsa, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, PresenzaOutputBean.class);
		}

		return bean;
	}

	public VerificaVpFlatAttestazioneOutputBean getVerificaVpFlatAttestazione(
			VerificaVpFlatAttestazioneWrapperInputBean bean, String tipoProfilo) throws BusinessLayerException {
		try {
			VerificaVpFlatAttestazioneWrapperInputDTO input = mapper.translate(bean,
					VerificaVpFlatAttestazioneWrapperInputDTO.class);
			VerificaVpFlatAttestazioneOutputDTO output = ordineRestClient.getVerificaVpFlatAttestazione(input,
					tipoProfilo);
			validateResponseResult(output);
			return mapper.translate(output, VerificaVpFlatAttestazioneOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public RecuperoCodiceDonatingOutputBean getRecuperoCodiceDonating(String idRisorsa1, String codDonating1,
			String idRisorsa2, String codDonating2, String tipoProfilo) throws BusinessLayerException {

		try {
			RecuperoCodiceDonatingWrapperOutputDTO wrapper = ordineRestClient.getRecuperoCodiceDonating(idRisorsa1,
					codDonating1, idRisorsa2, codDonating2, tipoProfilo);
			validateResponseResult(wrapper.getRecuperocoddonating());
			return mapper.translate(wrapper.getRecuperocoddonating(), RecuperoCodiceDonatingOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public EsitoOutputBean verificacongruenzaoffertacodordine(String idOfferta, String codOrdine, String codOrdinePadre,
			String tipoProfilo) throws BusinessLayerException {
		try {
			EsitoDTO dto = ordineRestClient.verificacongruenzaoffertacodordine(idOfferta, codOrdine, codOrdinePadre,
					tipoProfilo);
			validateResponseResult(dto);
			return mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public CheckNumMaxVCConfigurabiliOutputBean numeromaxvcconfig(String idOfferta, String profiloTecnicoLinea,
			String tipoProfilo) throws BusinessLayerException {
		try {
			CheckNumMaxVCConfigurabiliOutputDTO dto = ordineRestClient.numeromaxvcconfig(idOfferta, profiloTecnicoLinea,
					tipoProfilo);
			validateResponseResult(dto);
			return mapper.translate(dto, CheckNumMaxVCConfigurabiliOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	// RU_995
	public EsitoOutputBean verificaTicketTTM(String idTicketTTM, String idRisorsa, String tipoLinea, String tipoProfilo)
			throws BusinessLayerException {
		try {
			VerificaTicketTTMWrapperOutputDTO dto = ordineRestClient.verificaTicketTTM(idTicketTTM, idRisorsa,
					tipoLinea, tipoProfilo);
			validateResponseResult(dto);
			return mapper.translate(dto.getCheckTTM(), EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public VerificaTecnologiaOutputBean verificaTecnologia(String profiloTecnicoLinea, String idOfferta,
			String tipoProfilo) throws BusinessLayerException {
		try {
			VerificaTecnologiaOutputDTO dto = ordineRestClient.verificaTecnologia(profiloTecnicoLinea, idOfferta,
					tipoProfilo);
			validateResponseResult(dto);
			return mapper.translate(dto, VerificaTecnologiaOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public RecuperoDataTimeoutOutputBean recuperodatatimeout(String idRichiestaOlo, String tipoProfilo)
			throws BusinessLayerException {
		try {
			RecuperoDataTimeoutOutputDTO dto = ordineRestClient.recuperodatatimeout(idRichiestaOlo, tipoProfilo);
			validateResponseResult(dto);
			return mapper.translate(dto, RecuperoDataTimeoutOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	public GenericListBean<RecuperaRichiesteOutputBean> getRecuperaRichieste(String lavorazione, String idOfferta,
			String statoNow, String flagNaked, String tipoProfilo) throws BusinessLayerException {
		GenericListBean<RecuperaRichiesteOutputBean> list = new GenericListBean<>();
		try {
			RecuperaRichiesteWrapperOutputDTO wrapper = ordineRestClient.getRecuperaRichieste(lavorazione, idOfferta,
					statoNow, flagNaked, tipoProfilo);
			validateResponseResult(wrapper);
			list.setData(mapper.translateList(wrapper.getOutputRichieste(), RecuperaRichiesteOutputBean.class));
			return list;
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	// RU_713
	public EsitoOutputBean verificacompatibproftecnlineaprofilovc(
			CompatibilitaProfiloTecnicoLineaProfiloVCBean inputBean) throws BusinessLayerException {

		try {
			CompatibilitaProfiloTecnicoLineaProfiloVC_DTO input = mapper.translate(inputBean,
					CompatibilitaProfiloTecnicoLineaProfiloVC_DTO.class);
			EsitoDTO dto = ordineRestClient.verificacompatibproftecnlineaprofilovc(input);
			validateResponseResult(dto);
			return mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	// RU_833 FIX FWA CESSAZIONE
	public VerificaCodiceOrdineOloOutputBean verificaCodiceOrdineOlo(String codiceOrdineOlo, String codOloAgcom)
			throws BusinessLayerException {
		VerificaCodiceOrdineOloWrapperOutputDTO result = null;
		VerificaCodiceOrdineOloOutputBean bean = null;
		try {
			result = ordineRestClient.verificaCodiceOrdineOlo(codiceOrdineOlo, codOloAgcom);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null && result.getVerificaCodiceOrdineOloOutput() != null) {
			bean = mapper.translate(result.getVerificaCodiceOrdineOloOutput(), VerificaCodiceOrdineOloOutputBean.class);
		}

		return bean;
	}

	// RU_871
	public EsitoOutputBean verificaInConsistenzaPresenzaModem(String idRisorsa, String idOfferta, String flagReferente)
			throws BusinessLayerException {
		VerificaInConsistenzaPresenzaModemOutputWrapperDTO result = null;
		EsitoOutputBean bean = null;
		try {
			result = ordineRestClient.verificaInConsistenzaPresenzaModem(idRisorsa, idOfferta, flagReferente);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result.getVerificaInConsistenzaPresenzaModemOutput(), EsitoOutputBean.class);
		}

		return bean;
	}

	// RU_863
	public RecuperaProfiliFwaWrapperOutputBean recuperaProfiliFwa(String profiloFwa) throws BusinessLayerException {
		RecuperaProfiliFwaWrapperOutputDTO result = null;
		RecuperaProfiliFwaWrapperOutputBean bean = null;
		try {
			result = ordineRestClient.recuperaProfiliFwa(profiloFwa);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, RecuperaProfiliFwaWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_875
	// SM_10241
	public EsitoOutputBean verificaCodiceProgettoOneStep(VerificaCodiceProgettoOneStepInputBean input)
			throws BusinessLayerException {
		VerificaCodiceProgettoOneStepOutputWrapperDTO result = null;
		EsitoOutputBean bean = null;
		VerificaCodiceProgettoOneStepInputDTO dto = new VerificaCodiceProgettoOneStepInputDTO();
		try {

			dto = mapper.translate(input, VerificaCodiceProgettoOneStepInputDTO.class);

			result = ordineRestClient.verificaCodiceProgettoOneStep(dto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result.getVerificaCodiceProgettoOneStepOutput(), EsitoOutputBean.class);
		}

		return bean;
	}

	// RU_966
	public VerificaIntermediateAgentFullWrapperOutputBean verificaIntermediateAgentFull(
			VerificaIntermediateAgentFullInputBean inputBean) throws BusinessLayerException {
		VerificaIntermediateAgentFullWrapperOutputDTO result = null;
		VerificaIntermediateAgentFullWrapperOutputBean bean = null;
		try {
			VerificaIntermediateAgentFullInputDTO inputDto = mapper.translate(inputBean,
					VerificaIntermediateAgentFullInputDTO.class);
			result = ordineRestClient.verificaIntermediateAgentFull(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaIntermediateAgentFullWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_980
	public RecuperaCodiceServizioSystemUnicoOutputBean recuperaCodiceServizioSystemUnico(
			RecuperaCodiceServizioSystemUnicoInputBean inputBean) throws BusinessLayerException {
		RecuperaCodiceServizioSystemUnicoOutputDTO result = null;
		RecuperaCodiceServizioSystemUnicoOutputBean bean = null;
		try {
			RecuperaCodiceServizioSystemUnicoInputDTO inputDto = mapper.translate(inputBean,
					RecuperaCodiceServizioSystemUnicoInputDTO.class);
			result = ordineRestClient.recuperaCodiceServizioSystemUnico(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, RecuperaCodiceServizioSystemUnicoOutputBean.class);
		}

		return bean;
	}

	// RU_995
	public EsitoOutputBean verificaOrdineVariazioneDowngradeFast(VerificaOrdineVariazioneDowngradeFastInputBean input,
			String tipoProfilo) throws BusinessLayerException {
		try {
			VerificaOrdineVariazioneDowngradeFastInputDTO dto = mapper.translate(input,
					VerificaOrdineVariazioneDowngradeFastInputDTO.class);
			VerificaOrdineVariazioneDowngradeFastWrapperOutputDTO result = ordineRestClient
					.verificaOrdineVariazioneDowngradeFast(dto, tipoProfilo);
			validateResponseResult(result);
			return mapper.translate(result.getCheckDowngradeFast(), EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	// RU_1058
	public VisualizzaCampiOfferteVLANWrapperOutputBean visualizzaCampiOfferteVLAN(
			VisualizzaCampiOfferteVLANInputBean inputBean) throws BusinessLayerException {
		VisualizzaCampiOfferteVLANWrapperOutputDTO result = null;
		VisualizzaCampiOfferteVLANWrapperOutputBean bean = null;
		try {
			VisualizzaCampiOfferteVLANInputDTO inputDto = mapper.translate(inputBean,
					VisualizzaCampiOfferteVLANInputDTO.class);
			result = ordineRestClient.visualizzaCampiOfferteVLAN(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VisualizzaCampiOfferteVLANWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_1058
	public VerificaKitAbilitatoNGAWrapperOutputBean verificaKitAbilitatoNGA(VerificaKitAbilitatoNGAInputBean inputBean)
			throws BusinessLayerException {
		VerificaKitAbilitatoNGAWrapperOutputDTO result = null;
		VerificaKitAbilitatoNGAWrapperOutputBean bean = null;
		try {
			VerificaKitAbilitatoNGAInputDTO inputDto = mapper.translate(inputBean,
					VerificaKitAbilitatoNGAInputDTO.class);
			result = ordineRestClient.verificaKitAbilitatoNGA(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaKitAbilitatoNGAWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_1058
	public RecuperaCampiOffertaVPWrapperOutputBean recuperaCampiOffertaVP(RecuperaCampiOffertaVPInputBean inputBean)
			throws BusinessLayerException {
		RecuperaCampiOffertaVPWrapperOutputDTO result = null;
		RecuperaCampiOffertaVPWrapperOutputBean bean = null;
		try {
			RecuperaCampiOffertaVPInputDTO inputDto = mapper.translate(inputBean, RecuperaCampiOffertaVPInputDTO.class);
			result = ordineRestClient.recuperaCampiOffertaVP(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		if (result != null) {
			bean = mapper.translate(result, RecuperaCampiOffertaVPWrapperOutputBean.class);
		}
		return bean;
	}

	// RU_1058
	public VerificaCodiceTdKitWrapperOutputBean verificaCodiceTdKit(VerificaCodiceTdKitInputBean inputBean)
			throws BusinessLayerException {
		VerificaCodiceTdKitWrapperOutputDTO result = null;
		VerificaCodiceTdKitWrapperOutputBean bean = null;
		try {
			VerificaCodiceTdKitInputDTO inputDto = mapper.translate(inputBean, VerificaCodiceTdKitInputDTO.class);
			result = ordineRestClient.verificaCodiceTdKit(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaCodiceTdKitWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_1058
	// SM_9723
	public VerificaModelloKitWrapperOutputBean verificaModelloKit(VerificaModelloKitInputBean inputBean)
			throws BusinessLayerException {
		VerificaModelloKitWrapperOutputDTO result = null;
		VerificaModelloKitWrapperOutputBean bean = null;
		try {
			VerificaModelloKitInputDTO inputDto = mapper.translate(inputBean, VerificaModelloKitInputDTO.class);
			result = ordineRestClient.verificaModelloKit(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaModelloKitWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_1058
	public RecuperaCARWrapperOutputBean recuperaCar(RecuperaCARInputBean inputBean) throws BusinessLayerException {
		RecuperaCARWrapperOutputDTO result = null;
		RecuperaCARWrapperOutputBean bean = null;
		try {
			RecuperaCARInputDTO inputDto = mapper.translate(inputBean, RecuperaCARInputDTO.class);
			result = ordineRestClient.recuperaCar(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		if (result != null) {
			bean = mapper.translate(result, RecuperaCARWrapperOutputBean.class);
		}
		return bean;
	}

	// RU_1058
	public RecuperaSubContractorWrapperOutputBean recuperaSubContractor(String idRisorsa)
			throws BusinessLayerException {
		RecuperaSubContractorWrapperOutputDTO result = null;
		RecuperaSubContractorWrapperOutputBean bean = null;
		try {
			result = ordineRestClient.recuperaSubContractor(idRisorsa);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		if (result != null) {
			bean = mapper.translate(result, RecuperaSubContractorWrapperOutputBean.class);
		}
		return bean;
	}

	// RU_1058
	public RecuperaCodOloSubContractorWrapperOutputBean recuperaCodOloSubContractor(String idRisorsa)
			throws BusinessLayerException {
		RecuperaCodOloSubContractorWrapperOutputDTO result = null;
		RecuperaCodOloSubContractorWrapperOutputBean bean = null;
		try {
			result = ordineRestClient.recuperaCodOloSubContractor(idRisorsa);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		if (result != null) {
			bean = mapper.translate(result, RecuperaCodOloSubContractorWrapperOutputBean.class);
		}
		return bean;
	}

	// RU_1060
	public VerificaComuneOffertaInfratelWrapperOutputBean verificaComuneOffertaInfratel(
			VerificaComuneOffertaInfratelInputBean inputBean) throws BusinessLayerException {
		VerificaComuneOffertaInfratelWrapperOutputDTO result = null;
		VerificaComuneOffertaInfratelWrapperOutputBean bean = null;
		try {
			VerificaComuneOffertaInfratelInputDTO inputDto = mapper.translate(inputBean,
					VerificaComuneOffertaInfratelInputDTO.class);
			result = ordineRestClient.verificaComuneOffertaInfratel(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaComuneOffertaInfratelWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_1089
	public VerificaCongruenzaClusterComuneVlanOutputBean verificaCongruenzaClusterComuneVlan(
			VerificaCongruenzaClusterComuneVlanInputBean inputBean) throws BusinessLayerException {
		VerificaCongruenzaClusterComuneVlanOutputDTO result = null;
		VerificaCongruenzaClusterComuneVlanOutputBean bean = null;
		try {
			VerificaCongruenzaClusterComuneVlanInputDTO inputDto = mapper.translate(inputBean,
					VerificaCongruenzaClusterComuneVlanInputDTO.class);
			result = ordineRestClient.verificaCongruenzaClusterComuneVlan(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaCongruenzaClusterComuneVlanOutputBean.class);
		}

		return bean;
	}

	// RU_1129
	public RecuperaProfiliFwaWrapperOutputBean recuperaProfiliFwa(RecuperaProfiliFwaInputBean inputBean)
			throws BusinessLayerException {
		RecuperaProfiliFwaWrapperOutputDTO result = null;
		RecuperaProfiliFwaWrapperOutputBean bean = null;
		try {
			RecuperaProfiliFwaInputDTO inputDto = mapper.translate(inputBean, RecuperaProfiliFwaInputDTO.class);
			result = ordineRestClient.recuperaProfiliFwa(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, RecuperaProfiliFwaWrapperOutputBean.class);
		}

		return bean;
	}

	public VerificaTipologiaContrattoFwaWrapperOutputBean verificaTipologiaContrattoFwa(
			VerificaTipologiaContrattoFwaInputBean inputBean) throws BusinessLayerException {
		VerificaTipologiaContrattoFwaWrapperOutputDTO result = null;
		VerificaTipologiaContrattoFwaWrapperOutputBean bean = null;
		try {
			VerificaTipologiaContrattoFwaInputDTO inputDto = mapper.translate(inputBean,
					VerificaTipologiaContrattoFwaInputDTO.class);
			result = ordineRestClient.verificaTipologiaContrattoFwa(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaTipologiaContrattoFwaWrapperOutputBean.class);
		}

		return bean;
	}

	// SM_9825
	public RecuperaCodiciTdKitWrapperOutputBean recuperaCodiciTdKit(RecuperaCodiciTdKitInputBean inputBean)
			throws BusinessLayerException {
		RecuperaCodiciTdKitWrapperOutputDTO result = null;
		RecuperaCodiciTdKitWrapperOutputBean bean = null;
		try {
			RecuperaCodiciTdKitInputDTO inputDto = mapper.translate(inputBean, RecuperaCodiciTdKitInputDTO.class);
			result = ordineRestClient.recuperaCodiciTdKit(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, RecuperaCodiciTdKitWrapperOutputBean.class);
		}

		return bean;
	}

	// SM_9825
	public VerificaModelloKitMadrWrapperOutputBean verificaModelloKitMadr(String codiceTdKit)
			throws BusinessLayerException {
		try {
			VerificaModelloKitMadrWrapperOutputDTO output = ordineRestClient.verificaModelloKitMadr(codiceTdKit);
			validateResponseResult(output);
			return mapper.translate(output, VerificaModelloKitMadrWrapperOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

	}

	// RU_1150
	// RU_1274
	public RecuperaIdGponWrapperOutputBean recuperaIdGpon(RecuperaIdGponInputBean inputBean, String tipoProfilo)
			throws BusinessLayerException {
		RecuperaIdGponWrapperOutputDTO result = null;
		RecuperaIdGponWrapperOutputBean bean = null;
		try {
			RecuperaIdGponInputDTO inputDto = mapper.translate(inputBean, RecuperaIdGponInputDTO.class);
			result = ordineRestClient.recuperaIdGpon(inputDto, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, RecuperaIdGponWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_1166
	public RecuperaMacroAreaWrapperOutputBean recuperaMacroArea(RecuperaMacroAreaInputBean inputBean)
			throws BusinessLayerException {
		RecuperaMacroAreaWrapperOutputDTO result = null;
		RecuperaMacroAreaWrapperOutputBean bean = null;
		try {
			RecuperaMacroAreaInputDTO inputDto = mapper.translate(inputBean, RecuperaMacroAreaInputDTO.class);
			result = ordineRestClient.recuperaMacroArea(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, RecuperaMacroAreaWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_1164
	public VerificaContrattoCoinvestimentoComuneWrapperOutputBean verificaContrattoCoinvestimentoComune(
			VerificaContrattoCoinvestimentoComuneInputBean inputBean) throws BusinessLayerException {
		VerificaContrattoCoinvestimentoComuneWrapperOutputDTO result = null;
		VerificaContrattoCoinvestimentoComuneWrapperOutputBean bean = null;
		try {
			VerificaContrattoCoinvestimentoComuneInputDTO inputDto = mapper.translate(inputBean,
					VerificaContrattoCoinvestimentoComuneInputDTO.class);
			result = ordineRestClient.verificaContrattoCoinvestimentoComune(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaContrattoCoinvestimentoComuneWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_1180
	public VisualizzaCampiOfferteMulticastWrapperOutputBean visualizzaCampiOfferteMulticast(
			VisualizzaCampiOfferteMulticastInputBean inputBean) throws BusinessLayerException {
		VisualizzaCampiOfferteMulticastWrapperOutputDTO result = null;
		VisualizzaCampiOfferteMulticastWrapperOutputBean bean = null;
		try {
			VisualizzaCampiOfferteMulticastInputDTO inputDto = mapper.translate(inputBean,
					VisualizzaCampiOfferteMulticastInputDTO.class);
			result = ordineRestClient.visualizzaCampiOfferteMulticast(inputDto);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VisualizzaCampiOfferteMulticastWrapperOutputBean.class);
		}

		return bean;
	}

	public VerificaAbilitazioneMulticastContrattoWrapperOutputBean verificaAbilitazioneMcContratto(String codOloAgcom,
			String flagPrimoFeeder) throws BusinessLayerException {
		VerificaAbilitazioneMulticastContrattoWrapperOutputDTO result = null;
		VerificaAbilitazioneMulticastContrattoWrapperOutputBean bean = null;
		try {
			result = ordineRestClient.verificaAbilitazioneMcContratto(codOloAgcom, flagPrimoFeeder);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaAbilitazioneMulticastContrattoWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_1181
	public VerificaRecuperoModemWrapperOutputBean verificaRecuperoModem(String idAsset) throws BusinessLayerException {
		VerificaRecuperoModemWrapperOutputDTO result = null;
		VerificaRecuperoModemWrapperOutputBean bean = null;
		try {
			result = ordineRestClient.verificaRecuperoModem(idAsset);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaRecuperoModemWrapperOutputBean.class);
		}

		return bean;
	}

	// R1I-21-0138
	public VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputBean verificaCompatibilitaProfiloTecnicoLinea(
			VerificaCompatibilitaProfiloTecnicoLineaInputBean input, String tipoProfilo) throws BusinessLayerException {
		VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputDTO result = null;
		VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputBean bean = null;
		try {
			VerificaCompatibilitaProfiloTecnicoLineaInputDTO dto = null;
			dto = mapper.translate(input, VerificaCompatibilitaProfiloTecnicoLineaInputDTO.class);
			result = ordineRestClient.verificaCompatibilitaProfiloTecnicoLinea(dto, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputBean.class);
		}

		return bean;
	}

	// R1F-20-0236.D
	public VerificaNoteOperatoreWrapperOutputBean verificaNumeriNoteOperatore(VerificaNoteOperatoreInputBean input,
			String tipoProfilo) throws BusinessLayerException {
		VerificaNoteOperatoreWrapperOutputDTO result = null;
		VerificaNoteOperatoreWrapperOutputBean bean = null;
		try {
			VerificaNoteOperatoreInputDTO dto = null;
			dto = mapper.translate(input, VerificaNoteOperatoreInputDTO.class);
			result = ordineRestClient.verificaNumeriNoteOperatore(dto, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaNoteOperatoreWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_1270
	public VerificaProfiloTecnicoLineaX1X2WrapperOutputBean verificaProfiloTecnicoLineaX1X2(String idOfferta,
			String profiloTecnicoLinea, String tipoProfilo) throws BusinessLayerException {
		VerificaProfiloTecnicoLineaX1X2WrapperOutputDTO result = null;
		VerificaProfiloTecnicoLineaX1X2WrapperOutputBean bean = null;
		try {
			result = ordineRestClient.verificaProfiloTecnicoLineaX1X2(idOfferta, profiloTecnicoLinea, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaProfiloTecnicoLineaX1X2WrapperOutputBean.class);
		}
		return bean;
	}

	// RU_1335
	public VerificaIdRisorsaSwitchoffFwaWrapperOutputBean verificaIdRisorsaSwitchoffContrattoFwa(String idRisorsa,
			String tipoProfilo) throws BusinessLayerException {
		VerificaIdRisorsaSwitchoffFwaWrapperOutputDTO result = null;
		VerificaIdRisorsaSwitchoffFwaWrapperOutputBean bean = null;
		try {
			result = ordineRestClient.verificaIdRisorsaSwitchoffContrattoFwa(idRisorsa, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, VerificaIdRisorsaSwitchoffFwaWrapperOutputBean.class);
		}
		return bean;
	}

	// RU_1393
	public RecuperaCodiceSystemUnicoWrapperOutputBean recuperaCodiceSystemUnico(
			RecuperaCodiceSystemUnicoInputBean inputBean, String tipoProfilo) throws BusinessLayerException {
		RecuperaCodiceSystemUnicoWrapperOutputDTO result = null;
		RecuperaCodiceSystemUnicoWrapperOutputBean bean = null;
		try {
			RecuperaCodiceSystemUnicoInputDTO inputDto = mapper.translate(inputBean,
					RecuperaCodiceSystemUnicoInputDTO.class);
			result = ordineRestClient.recuperaCodiceSystemUnico(inputDto, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, RecuperaCodiceSystemUnicoWrapperOutputBean.class);
		}

		return bean;
	}

	public RecuperaCodiceSubAppaltoOutputBean recuperaCodiceSubAppalto(RecuperaCodiceSubAppaltoInputBean inputBean,
			String tipoProfilo) throws BusinessLayerException {
		RecuperaCodiceSubAppaltoOutputDTO result = null;
		RecuperaCodiceSubAppaltoOutputBean bean = null;
		try {
			RecuperaCodiceSubAppaltoInputDTO inputDto = mapper.translate(inputBean,
					RecuperaCodiceSubAppaltoInputDTO.class);
			result = ordineRestClient.recuperaCodiceSubAppalto(inputDto, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, RecuperaCodiceSubAppaltoOutputBean.class);
		}

		return bean;
	}

	// RU_1428
	public RecuperaTipologiaImpresaOutputBean recuperaTipologiaImpresa(RecuperaTipologiaImpresaInputBean inputBean,
			String tipoProfilo) throws BusinessLayerException {
		RecuperaTipologiaImpresaOutputDTO result = null;
		RecuperaTipologiaImpresaOutputBean bean = null;
		try {
			RecuperaTipologiaImpresaInputDTO inputDto = mapper.translate(inputBean,
					RecuperaTipologiaImpresaInputDTO.class);
			result = ordineRestClient.recuperaTipologiaImpresa(inputDto, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, RecuperaTipologiaImpresaOutputBean.class);
		}

		return bean;
	}

	// RU_1485
	public RecuperaServiziOpzionaliAlternativiWrapperOutputBean recuperaServiziOpzionaliAlternativi(
			String codiceProgetto, String tipoProfilo) throws BusinessLayerException {
		RecuperaServiziOpzionaliAlternativiWrapperOutputDTO result = null;
		RecuperaServiziOpzionaliAlternativiWrapperOutputBean bean = null;
		try {
			result = ordineRestClient.recuperaServiziOpzionaliAlternativi(codiceProgetto, tipoProfilo);
			validateResponseResult(result);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}

		if (result != null) {
			bean = mapper.translate(result, RecuperaServiziOpzionaliAlternativiWrapperOutputBean.class);
		}

		return bean;
	}

	// RU_1502
	public EsitoOutputBean verificaSpostamentoVlan(VerificaSpostamentoVLANInputBean inputBean, String tipoProfilo)
			throws BusinessLayerException {

		try {
			VerificaSpostamentoVLANInputDTO input = mapper.translate(inputBean, VerificaSpostamentoVLANInputDTO.class);
			EsitoDTO dto = ordineRestClient.verificaSpostamentoVlan(input, tipoProfilo);
			validateResponseResult(dto);
			return mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	// SM_11483
	public EsitoOutputBean verificaCongruenzaDRGOfferta(VerificaCongruenzaDRGOffertaInputBean inputBean,
			String tipoProfilo) throws BusinessLayerException {

		try {
			VerificaCongruenzaDRGOffertaInputDTO input = mapper.translate(inputBean,
					VerificaCongruenzaDRGOffertaInputDTO.class);
			EsitoDTO dto = ordineRestClient.verificaCongruenzaDRGOfferta(input, tipoProfilo);
			validateResponseResult(dto);
			return mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	// RU_1543
	public EsitoOutputBean verificaAttivazioneFullGponPlus(String codOloAgcom, String idRisorsaOld, String tipoProfilo)
			throws BusinessLayerException {
		EsitoOutputBean bean = null;
		try {
			EsitoDTO outputDto = ordineRestClient.verificaAttivazioneFullGponPlus(codOloAgcom, idRisorsaOld,
					tipoProfilo);
			validateResponseResult(outputDto);
			bean = mapper.translate(outputDto, EsitoOutputBean.class);

		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}

	// RU_1560
	public RecuperaCodiceOperatoreSecondarioWrapperOutputBean getCodiceOperatoreSecondario(String codOloAgcom, String tipoProfilo)
			throws BusinessLayerException {
		GenericListBean<String> bean = new GenericListBean<>();
		try {
			RecuperaCodiceOperatoreSecondarioWrapperOutputDTO result = ordineRestClient.getCodiceOperatoreSecondario(codOloAgcom, tipoProfilo);
			validateResponseResult(result);
			return mapper.translate(result, RecuperaCodiceOperatoreSecondarioWrapperOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	// RU_1560 -> C11M08F111
	public EsitoOutputBean verificaCodiceProgettoOneStepTLC8(String codServizio, String codProgetto, String tipoProfilo) throws BusinessLayerException {
		try {
			EsitoDTO dto = ordineRestClient.verificaCodiceProgettoOneStepTLC8(codServizio, codProgetto, tipoProfilo);
			validateResponseResult(dto);
			return mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	// RU_1560 -> C11M08F112
	public EsitoOutputBean verificaSLABasePerONTOperatore(String idRisorsa, String slaAssurance, String tipoProfilo) throws BusinessLayerException {
		try {
			EsitoDTO dto = ordineRestClient.verificaSLABasePerONTOperatore(idRisorsa, slaAssurance, tipoProfilo);
			validateResponseResult(dto);
			return mapper.translate(dto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}
	
	// RU_1560 -> C11M08F113
	public EsitoOutputBean verificaAttivazioneFTTH(String codOloAgcom, String idRisorsaOld, String tipoProfilo) throws BusinessLayerException {
		try {
			EsitoDTO outputDto = ordineRestClient.verificaAttivazioneFTTH(codOloAgcom, idRisorsaOld, tipoProfilo);
			validateResponseResult(outputDto);
			return mapper.translate(outputDto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}

	// RU_1560 -> C11M08F114
	public EsitoOutputBean verificaMigrazioneFTTH(String idAsset, String offerta, String tipoProfilo) throws BusinessLayerException {
		try {
			EsitoDTO outputDto = ordineRestClient.verificaMigrazioneFTTH(idAsset, offerta, tipoProfilo);
			validateResponseResult(outputDto);
			return mapper.translate(outputDto, EsitoOutputBean.class);
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
	}
	
	// RU_1598
	public RecuperaClusterAccessoOutputBean recuperaClusterAccesso() throws BusinessLayerException {
		RecuperaClusterAccessoOutputDTO result = null;
		RecuperaClusterAccessoOutputBean bean = null;
		try {
			result = ordineRestClient.recuperaClusterAccesso();
			validateResponseResult(result);

			if (result != null) {
				bean = mapper.translate(result, RecuperaClusterAccessoOutputBean.class);
			}
		} catch (Exception e) {
			throw new BusinessLayerException(e);
		}
		return bean;
	}
}
