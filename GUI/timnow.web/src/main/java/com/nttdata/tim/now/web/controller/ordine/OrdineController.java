package com.nttdata.tim.now.web.controller.ordine;

import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.tim.now.core.exception.BusinessLayerException;
import com.nttdata.tim.now.core.service.ordine.EsitiRichiesteManagerBL;
import com.nttdata.tim.now.core.service.ordine.OrdineManagerBL;
import com.nttdata.tim.now.core.service.ordine.ReferenteManagerBL;
import com.nttdata.tim.now.data.bean.asset.VerificaIdRisorsaInputBean;
import com.nttdata.tim.now.data.bean.asset.VerificaIdRisorsaNakedInputBean;
import com.nttdata.tim.now.data.bean.asset.VerificaIdRisorsaNakedOutputBean;
import com.nttdata.tim.now.data.bean.asset.VerificaIdRisorsaOutputBean;
import com.nttdata.tim.now.data.bean.base.EmptyBean;
import com.nttdata.tim.now.data.bean.base.GenericListBean;
import com.nttdata.tim.now.data.bean.esito.EsitoOutputBean;
import com.nttdata.tim.now.data.bean.ordine.CheckNumMaxVCConfigurabiliOutputBean;
import com.nttdata.tim.now.data.bean.ordine.CodiceUnivocoOutputBean;
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
import com.nttdata.tim.now.data.bean.ordine.RichiestaInputBean;
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
import com.nttdata.tim.now.data.bean.referente.ReferenteContattatoOutputBean;
import com.nttdata.tim.now.data.bean.result.Result;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.enumeration.OrderListType;
import com.nttdata.tim.now.data.enumeration.OrderState;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.web.bind.annotation.JsonGetMapping;
import com.nttdata.tim.now.web.bind.annotation.JsonPostMapping;
import com.nttdata.tim.now.web.controller.GenericController;

@RestController
@RequestMapping("/orders")
public class OrdineController extends GenericController {

	private static final String IDRICHIESTAOLO = "idrichiestaolo";

	@Autowired
	private OrdineManagerBL ordineManagerBL;

	@Autowired
	private ReferenteManagerBL referentManagerBL;

	@Autowired
	private EsitiRichiesteManagerBL requestManagerBL;

	// Visualizza Ordini -> Visualizza Ordini List
	@JsonGetMapping
	public GenericListBean<OrdineOutputBean> getOrders(
			@RequestParam(value = "state", required = false) OrderState state, HttpSession session)
			throws BusinessLayerException {
		logger.info("get orders");
		UserBean user = getCurrentUser(session);
		GenericListBean<OrdineOutputBean> bean = ordineManagerBL.getOrders(user.getCodiceProfilo(),
				user.getCodificaOloAgcom(), state);
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// Ordine -> Creazione Guidata Nuovo Ordine
	@JsonPostMapping
	public EmptyBean createOrder(@RequestBody CreazioneNuovoOrdineInputBean order, HttpSession session)
			throws BusinessLayerException {
		logger.info("createOrder");
		UserBean user = getCurrentUser(session);
		EmptyBean bean = ordineManagerBL.createOrder(order, user.getUserId(), user.getCodiceProfilo()); // RU_844
		return bean;
	}

	// Visualizza Ordini -> Visualizza Ordini Data Ordini
	@JsonGetMapping("/{type:idrichiestaolo|codiceordineti}/{code:[A-Za-z0-9_: ]+}")
	public DettaglioOrdineOutputBean getOrder(@PathVariable String type, @PathVariable String code, HttpSession session)
			throws BusinessLayerException {
		logger.info("get order");
		UserBean user = getCurrentUser(session);
		DettaglioOrdineOutputBean bean = ordineManagerBL.getOrder(code, IDRICHIESTAOLO.equals(type),
				user.getCodiceProfilo());

		if (bean != null) {
			logger.debug("Order found");
			bean.setResult(getSuccessResult());
		} else {
			logger.debug("Order NOT found");
			bean = new DettaglioOrdineOutputBean();
			bean.setResult(getResultNotFound());
		}

		return bean;
	}

	// Ordine -> Visualizza Referenti Contattati
	@JsonGetMapping("/{orderNumber}/contactedreferents")
	public GenericListBean<ReferenteContattatoOutputBean> getContactedReferents(@PathVariable String orderNumber,
			HttpSession session) throws BusinessLayerException {
		logger.info("get order Contacted Referents");
		UserBean user = getCurrentUser(session);
		GenericListBean<ReferenteContattatoOutputBean> list = new GenericListBean<>();
		list.setData(referentManagerBL.getContactedReferents(orderNumber, user.getCodiceProfilo()));
		list.setResult(getSuccessResult());
		return list;
	}

	// Richiesta -> Richiesta
	@JsonPostMapping("/{orderNumber:[A-Za-z0-9_:]+}/requests")
	public EmptyBean createRequest(@RequestBody RichiestaInputBean orderRequest, @PathVariable String orderNumber,
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		EmptyBean result;
		String tmp = orderRequest.getOao().toUpperCase();
		orderRequest.setOao(tmp);
		logger.info("create order request");
		result = requestManagerBL.createRequest(orderRequest, user.getUserId(), user.getCodiceProfilo());
		return result; // RU_844
//      return ensureBeanResult(result, EmptyBean.class); //RU_844
	}

	// VerificaRichiesta
	@JsonGetMapping("/checkRequest")
	public VerificaRichiestaOutputBean checkRequestNewOrder(
			@RequestParam(value = "causaleRichiesta", required = false) String causaleRichiesta,
			@RequestParam(value = "codiceRichiesta", required = false) String codiceRichiesta,
			@RequestParam(value = "ordineTIRichiestaOlo", required = false) String ordineTIRichiestaOlo,
			@RequestParam(value = "dad", required = false) String dad,
			@RequestParam(value = "fasciaOraria", required = false) String fasciaOraria,
			@RequestParam(value = "dac", required = false) String dac, HttpSession session)
			throws BusinessLayerException {

		logger.info("get checkRequestNewOrder");
		UserBean user = getCurrentUser(session);
		VerificaRichiestaInputBean input = new VerificaRichiestaInputBean();
		input.setCausaleRichiesta(causaleRichiesta);
		input.setOrdineTIRichiestaOlo(ordineTIRichiestaOlo);
		input.setCodiceRichiesta(codiceRichiesta);
		input.setDac(dac);
		input.setDad(dad);
		input.setFasciaOraria(fasciaOraria);
		VerificaRichiestaOutputBean ret = ordineManagerBL.verificaRichiestaOrdine(input, user.getCodiceProfilo());
		ret = ensureBeanResult(ret, VerificaRichiestaOutputBean.class);

		return ret;
	}

	// Export Data Start
	@JsonPostMapping("/export")
	public RichiestaExportOrdiniOutputBean requestOrderExport(@RequestBody RichiestaExportOrdiniInputBean input,
			HttpSession session) throws BusinessLayerException {
		RichiestaExportOrdiniOutputBean bean = null;
		try {
			UserBean user = getCurrentUser(session);
			input.setUserID(user.getUserId());
			input.setTipoProfilo(user.getCodiceProfilo());

			bean = ordineManagerBL.requestExport(input, user.getCodiceProfilo());

			if (bean != null && bean.getIdFile() != null) {
				bean.setResult(getSuccessResult());
			} else {
				bean = new RichiestaExportOrdiniOutputBean();
				bean.setResult(new Result(ResultCodeEnum.GENERIC_ERROR.getCode(), "Errore Generico",
						ResultCodeEnum.GENERIC_ERROR.getMessage()));
			}
		} catch (Exception e) {
			logger.info("Richiesta di export ordine fallita", e);
			throw e;
		}
		return bean;
	}

	// Ricerca Avanzata
	@JsonPostMapping("/search")
	public GenericListBean<OrdineOutputBean> search(@RequestParam(value = "state", required = false) OrderState state,
			@RequestParam(value = "listType", required = false) OrderListType listType,
			@RequestBody RicercaAvanzataInputBean body, HttpSession session) throws BusinessLayerException {

		UserBean user = getCurrentUser(session);

		GenericListBean<OrdineOutputBean> bean = ordineManagerBL.advancedSearch(body, user.getCodificaOloAgcom(),
				user.getCodiceProfilo(), state, listType);

		bean = ensureListBeanResult(bean);

		return bean;
	}

	// Verifica ID Risorsa
	@JsonPostMapping("/verificaidrisorsa")
	public VerificaIdRisorsaOutputBean verifyResourceId(@RequestBody VerificaIdRisorsaInputBean input,
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaIdRisorsaOutputBean bean = new VerificaIdRisorsaOutputBean();
		try {
			bean = ordineManagerBL.requestVerifyResourceId(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, VerificaIdRisorsaOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta di verifica id risorsa fallita", e);
			throw e;
		}
		return bean;
	}

	// Verifica ID Risorsa Naked
	@JsonPostMapping("/verificaidrisorsa/naked")
	public VerificaIdRisorsaNakedOutputBean verifyResourceIdNaked(@RequestBody VerificaIdRisorsaNakedInputBean input,
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaIdRisorsaNakedOutputBean bean = new VerificaIdRisorsaNakedOutputBean();
		try {
			bean = ordineManagerBL.requestVerifyResourceIdNaked(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, VerificaIdRisorsaNakedOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta di verifica id risorsa naked fallita", e);
			throw e;
		}
		return bean;
	}

	// Verifica OLO wholesaler
	@JsonPostMapping("/verificaolowholesaler")
	public VerificaOloWholesalerOutputBean verifyOloWolesaler(@RequestBody VerificaOloWholesalerInputBean input,
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaOloWholesalerOutputBean bean = new VerificaOloWholesalerOutputBean();
		try {
			bean = ordineManagerBL.requestVerifyOloWholesaler(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, VerificaOloWholesalerOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta di verifica olo wholesaler fallita", e);
			throw e;
		}
		return bean;
	}

	// Ordine -> Recupera le configurazioni
	// TO DO da collegare con la parte angular e testare
	@JsonGetMapping("/configurazione/{codFunzione}")
	public GenericListBean<ConfigurazioneOutputBean> getConfigurazione(@PathVariable String codFunzione,
			@RequestParam(value = "idOfferta", required = false) String idOfferta,
			@RequestParam(value = "opzioneVariazione", required = false) String opzioneVariazione, HttpSession session)
			throws BusinessLayerException {
		logger.info("get Configurazione");
		UserBean user = getCurrentUser(session);
		GenericListBean<ConfigurazioneOutputBean> list = ordineManagerBL.getConfigurazione(codFunzione, idOfferta,
				opzioneVariazione, user.getCodiceProfilo());
		list = ensureListBeanResult(list);
		return list;
	}

	// Ordine -> Recupera le consistenze tramite IdRisorsa
	// TO DO da collegare con la parte angular e testare
	@JsonGetMapping("/recuperoconsistenzaidrisorsa/{idRisorsa}/{tipoOperazione}")
	public ConsistenzaOutputBean getConsistenzaIdRisorsa(@PathVariable String idRisorsa,
			@PathVariable String tipoOperazione, HttpSession session) throws BusinessLayerException {
		logger.info("get Configurazione");
		UserBean user = getCurrentUser(session);
		ConsistenzaOutputBean bean = ordineManagerBL.getConsistenzaIdRisorsa(idRisorsa, tipoOperazione,
				user.getCodiceProfilo());
		bean = ensureBeanResult(bean, ConsistenzaOutputBean.class);
		return bean;
	}

	// Verifica compatibilità Lavorazione
	@JsonPostMapping("/verificacompatibilitalavorazione")
	public VerificaCompatibilitaLavorazioneOutputBean verificacompatibilitalavorazione(
			@RequestBody VerificaCompatibilitaLavorazioneInputBean input, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaCompatibilitaLavorazioneOutputBean bean = new VerificaCompatibilitaLavorazioneOutputBean();
		try {
			bean = ordineManagerBL.verifyCompatibilitaLavorazione(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, VerificaCompatibilitaLavorazioneOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta di verifica compatibilita' lavorazione fallita", e);
			throw e;
		}
		return bean;
	}

	// Richiesta preventivo
	@JsonGetMapping("/richiestapreventivo/{idRichiestaOlo}")
	public RichiestaPreventivoOutputBean getRichiestaPreventivo(@PathVariable String idRichiestaOlo,
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		RichiestaPreventivoOutputBean bean = new RichiestaPreventivoOutputBean();
		try {
			bean = ordineManagerBL.getRichiestaPreventivo(idRichiestaOlo, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, RichiestaPreventivoOutputBean.class);

		} catch (Exception e) {
			logger.info("Richiesta preventivo fallita", e);
			throw e;
		}
		return bean;
	}

	// visualizza ordini consuntivo e preventivo
	@JsonGetMapping("/consuntivo/{idRichiestaOlo}")
	public GenericListBean<ConsuntivoOrdineOutputBean> getListaConsuntivo(@PathVariable String idRichiestaOlo,
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<ConsuntivoOrdineOutputBean> bean = ordineManagerBL.getListaConsuntivo(idRichiestaOlo,
				user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// visualizza ordini consuntivo e preventivo
	@JsonGetMapping("/preventivo/{idRichiestaOlo}")
	public GenericListBean<PreventivoOrdineOutputBean> getListaPreventivo(@PathVariable String idRichiestaOlo,
			HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		GenericListBean<PreventivoOrdineOutputBean> bean = ordineManagerBL.getListaPreventivo(idRichiestaOlo,
				user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// verifica per variazione wlr
	@JsonPostMapping("/verificapervariazionewlr")
	public VerificaPerVariazioneWlrOutputBean getRichiestaVariazionePerWlr(
			@RequestBody VerificaPerVariazioneWlrInputBean input, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaPerVariazioneWlrOutputBean bean = null;
		try {
			bean = ordineManagerBL.getRichiestaVariazionePerWlr(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, VerificaPerVariazioneWlrOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica per variazione wlr fallita", e);
			throw e;
		}
		return bean;

	}

	// verifica contratto per variazione
	@JsonGetMapping("/variazioni/checks/{idAsset}/contratto")
	public VerificaContrattoPerVariazioneOutputBean verificaContrattoPerVariazione(@PathVariable String idAsset,
			@RequestParam(value = "codAgcom") String codAgcom, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaContrattoPerVariazioneOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaContrattoPerVariazione(idAsset, user.getCodiceProfilo(), codAgcom);
			bean = ensureBeanResult(bean, VerificaContrattoPerVariazioneOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica per variazione wlr fallita", e);
			throw e;
		}
		return bean;

	}

	@JsonGetMapping("/verificacoerenzaidrisorsa/{idRisorsa}/{codOloAgcom}")
	public CoerenzaOutputBean getCoerenzaIdRisorsa(@PathVariable String idRisorsa, @PathVariable String codOloAgcom,
			HttpSession session) throws BusinessLayerException {
		logger.info("get Coerenza id risorsa");
		UserBean user = getCurrentUser(session);
		CoerenzaOutputBean bean = ordineManagerBL.getCoerenzaIdRisorsa(idRisorsa, codOloAgcom, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, CoerenzaOutputBean.class);
		return bean;
	}

	// Non viene invocato perchè il controllo viene effettuato da front end
	// C11M08F37
	// solo per il passaggio allo step 2
	@JsonGetMapping("/verificapresenzaidrisorsa")
	public PresenzaOutputBean getCoerenzaPresenzaIdRisorsa(
			@RequestParam(value = "idRisorsa", required = false) String idRisorsa, HttpSession session)
			throws BusinessLayerException {
		logger.info("get Presenza id risorsa");
		UserBean user = getCurrentUser(session);
		PresenzaOutputBean bean = ordineManagerBL.getPresenzaIdRisorsa(idRisorsa, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, PresenzaOutputBean.class);
		return bean;
	}

	// Verifica Vp Flat Attestazione
	@JsonPostMapping("/verificavpflatattestazione")
	public VerificaVpFlatAttestazioneOutputBean getVerificaVpFlatAttestazione(
			@RequestBody VerificaVpFlatAttestazioneWrapperInputBean input, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaVpFlatAttestazioneOutputBean bean = null;
		try {
			bean = ordineManagerBL.getVerificaVpFlatAttestazione(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, VerificaVpFlatAttestazioneOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica per attestazione fallita", e);
			throw e;
		}
		return bean;

	}

	// RecuperoCodiceDonating
	@JsonGetMapping("/recuperocoddonating")
	public RecuperoCodiceDonatingOutputBean getRecuperoCodiceDonating(
			@RequestParam(value = "idRisorsa1") String idRisorsa1,
			@RequestParam(value = "codDonating1") String codDonating1,
			@RequestParam(value = "idRisorsa2", required = false) String idRisorsa2,
			@RequestParam(value = "codDonating2", required = false) String codDonating2, HttpSession session)
			throws BusinessLayerException {
		logger.info("get getRecuperoCodiceDonating");
		UserBean user = getCurrentUser(session);
		RecuperoCodiceDonatingOutputBean bean = ordineManagerBL.getRecuperoCodiceDonating(idRisorsa1, codDonating1,
				idRisorsa2, codDonating2, user.getCodiceProfilo());
		bean = ensureBeanResult(bean, RecuperoCodiceDonatingOutputBean.class);
		return bean;
	}

	// Verifica Congruenza Offerta Cod Ordine
	@JsonGetMapping("/verificacongruenzaoffertacodordine/{idOfferta}")
	public EsitoOutputBean verificacongruenzaoffertacodordine(@PathVariable String idOfferta,
			@RequestParam(value = "codOrdine", required = true) String codOrdine, // SM_7938
			@RequestParam(value = "codOrdinePadre", required = false) String codOrdinePadre, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		EsitoOutputBean bean = new EsitoOutputBean();
		try {
			bean = ordineManagerBL.verificacongruenzaoffertacodordine(idOfferta, codOrdine, codOrdinePadre,
					user.getCodiceProfilo());
			bean = ensureBeanResult(bean, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta di verifica compatibilita' lavorazione fallita", e);
			throw e;
		}
		return bean;
	}

	// Verifica Numero massimo VC configurabili
	@JsonGetMapping("/numeromaxvcconfig/{idOfferta}/{profiloTecnicoLinea}")
	public CheckNumMaxVCConfigurabiliOutputBean numeromaxvcconfig(@PathVariable String idOfferta,
			@PathVariable String profiloTecnicoLinea, HttpSession session) throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		CheckNumMaxVCConfigurabiliOutputBean bean = new CheckNumMaxVCConfigurabiliOutputBean();
		try {
			bean = ordineManagerBL.numeromaxvcconfig(idOfferta, profiloTecnicoLinea, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, CheckNumMaxVCConfigurabiliOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta di Verifica Numero massimo VC configurabili  fallita", e);
			throw e;
		}
		return bean;
	}

	// VerificaTicketTTM
	// RU_995
	@JsonGetMapping("/verificaTicketTTM")
	public EsitoOutputBean verificaTicketTTM(@RequestParam String idTicketTTM,
			@RequestParam(required = false) String idRisorsa, String tipoLinea, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		EsitoOutputBean bean = new EsitoOutputBean();
		try {
			bean = ordineManagerBL.verificaTicketTTM(idTicketTTM, idRisorsa, tipoLinea, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta di VerificaTicketTTM fallita", e);
			throw e;
		}
		return bean;
	}

	// VerificaTecnologia
	@JsonGetMapping("/verificaTecnologia")
	public VerificaTecnologiaOutputBean verificaTecnologia(
			@RequestParam(value = "profiloTecnicoLinea", required = true) String profiloTecnicoLinea,
			@RequestParam(value = "idOfferta", required = true) String idOfferta, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		VerificaTecnologiaOutputBean bean = new VerificaTecnologiaOutputBean();
		try {
			bean = ordineManagerBL.verificaTecnologia(profiloTecnicoLinea, idOfferta, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, VerificaTecnologiaOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta di VerificaTecnologia fallita", e);
			throw e;
		}
		return bean;
	}

	// codiceUnivoco
	@JsonGetMapping("/codiceUnivoco")
	public CodiceUnivocoOutputBean getCodiceUnivoco() throws BusinessLayerException {
		CodiceUnivocoOutputBean bean = new CodiceUnivocoOutputBean();
		StringBuffer sb = new StringBuffer("" + System.currentTimeMillis() / 1000);
		SecureRandom rnd = new SecureRandom();
		sb.append(Constants.ALPHANUMERIC.charAt(rnd.nextInt(62)));
		bean.setCodiceUnivoco(sb.toString());
		logger.debug("CodiceUnivoco= " + bean.getCodiceUnivoco());
		return bean;
	}

	// recuperodatatimeout
	@JsonGetMapping("/recuperodatatimeout/{idRichiestaOlo}")
	public RecuperoDataTimeoutOutputBean recuperodatatimeout(@PathVariable String idRichiestaOlo, HttpSession session)
			throws BusinessLayerException {
		UserBean user = getCurrentUser(session);
		RecuperoDataTimeoutOutputBean bean = ordineManagerBL.recuperodatatimeout(idRichiestaOlo,
				user.getCodiceProfilo());
		ensureBeanResult(bean, RecuperoDataTimeoutOutputBean.class);
		return bean;
	}

	// RecuperaRichieste
	@JsonGetMapping("/recuperarichieste")
	public GenericListBean<RecuperaRichiesteOutputBean> getRecuperaRichieste(
			@RequestParam(value = "lavorazione") String lavorazione,
			@RequestParam(value = "idOfferta") String idOfferta, @RequestParam(value = "statoNow") String statoNow,
			@RequestParam(value = "flagNaked") String flagNaked, HttpSession session) throws BusinessLayerException {
		logger.info("getRecuperaRichieste");
		UserBean user = getCurrentUser(session);
		GenericListBean<RecuperaRichiesteOutputBean> bean = ordineManagerBL.getRecuperaRichieste(lavorazione, idOfferta,
				statoNow, flagNaked, user.getCodiceProfilo());
		bean = ensureListBeanResult(bean);
		return bean;
	}

	// RU_713
	@JsonPostMapping("/verificacompatibproftecnlineaprofilovc")
	public EsitoOutputBean verificacompatibproftecnlineaprofilovc(
			@RequestBody CompatibilitaProfiloTecnicoLineaProfiloVCBean inputBean, HttpSession session)
			throws BusinessLayerException {
		logger.info("Verifica Compatibilita Profilo Tecnico Linea Profilo VC spring controller");
		EsitoOutputBean bean = new EsitoOutputBean();
		// UserBean user = getCurrentUser(session);
		// String tipoProfilo = user.getCodiceProfilo();
		try {

//    	  	for(VCBean vc : inputBean.getVc()) {
//    	  		vc.setTipoProfilo(tipoProfilo);
//    	  	}RU_737

			bean = ordineManagerBL.verificacompatibproftecnlineaprofilovc(inputBean);
		} catch (Exception e) {
			logger.info("Verifica Compatibilita Profilo Tecnico Linea Profilo VC fallita", e);
			throw e;
		}
		// return ensureBeanResult(bean, EsitoOutputBean.class);
		return bean;
	}

	// RU_833 FIX FWA CESSAZIONE
	@JsonGetMapping("/verificacodiceordineolo/{codiceOrdineOlo}/{codOloAgcom}")
	public VerificaCodiceOrdineOloOutputBean verificaCodiceOrdineOlo(@PathVariable String codiceOrdineOlo,
			@PathVariable String codOloAgcom, HttpSession session) throws BusinessLayerException {
		logger.info("get verificaCodiceOrdineOlo");
		VerificaCodiceOrdineOloOutputBean bean = ordineManagerBL.verificaCodiceOrdineOlo(codiceOrdineOlo, codOloAgcom);
		// bean = ensureBeanResult(bean);
		return bean;
	}

	// RU_871
	@JsonGetMapping("/verificainconsistenzapresenzamodem/{idOfferta}/{flagReferente}")
	public EsitoOutputBean verificaInConsistenzaPresenzaModem(@RequestParam String idRisorsa,
			@PathVariable String idOfferta, @PathVariable String flagReferente, HttpSession session)
			throws BusinessLayerException {
		logger.info("get verificaInConsistenzaPresenzaModem");
		idRisorsa = idRisorsa.replace(",", "");
		EsitoOutputBean bean = ordineManagerBL.verificaInConsistenzaPresenzaModem(idRisorsa, idOfferta, flagReferente);
		// EsitoOutputBean bean = new EsitoOutputBean();
		bean = ensureBeanResult(bean, EsitoOutputBean.class);
		return bean;
	}

	// RU_863
	@JsonGetMapping("/recuperaprofilifwa/{profiloFwa}")
	public RecuperaProfiliFwaWrapperOutputBean recuperaProfiliFwa(@PathVariable String profiloFwa, HttpSession session)
			throws BusinessLayerException {
		logger.info("get recuperaProfiliFwa");
		RecuperaProfiliFwaWrapperOutputBean bean = ordineManagerBL.recuperaProfiliFwa(profiloFwa);
		// EsitoOutputBean bean = new EsitoOutputBean();
		// bean = ensureBeanResult(bean, EsitoOutputBean.class);
		return bean;
	}

	// RU_875
	// SM_10241
	@JsonPostMapping("/verificacodiceprogettoonestep")
	public EsitoOutputBean verificaCodiceProgettoOneStep(@RequestBody VerificaCodiceProgettoOneStepInputBean input,
			HttpSession session) throws BusinessLayerException {
		logger.info("get verificaCodiceProgettoOneStep");
		EsitoOutputBean bean = ordineManagerBL.verificaCodiceProgettoOneStep(input);
		// EsitoOutputBean bean = new EsitoOutputBean();
		// bean = ensureBeanResult(bean, EsitoOutputBean.class);
		return bean;
	}

	// RU_966
	// Verifica compatibilità Intermediate Agent Full
	@JsonPostMapping("/verificaIntermediateAgentFull")
	public VerificaIntermediateAgentFullWrapperOutputBean verificaIntermediateAgentFull(
			@RequestBody VerificaIntermediateAgentFullInputBean input, HttpSession session)
			throws BusinessLayerException {
		VerificaIntermediateAgentFullWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaIntermediateAgentFull(input);
			bean = ensureBeanResult(bean, VerificaIntermediateAgentFullWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica compatibilità intermediate agent full fallita", e);
			throw e;
		}
		return bean;

	}

	// RU_980
	// Ricerca codice servizio o system unico
	@JsonPostMapping("/recuperaCodiceServizioSystemUnico")
	public RecuperaCodiceServizioSystemUnicoOutputBean recuperaCodServizioSysUnico(
			@RequestBody RecuperaCodiceServizioSystemUnicoInputBean input, HttpSession session)
			throws BusinessLayerException {
		RecuperaCodiceServizioSystemUnicoOutputBean bean = null;
		try {
			bean = ordineManagerBL.recuperaCodiceServizioSystemUnico(input);
			bean = ensureBeanResult(bean, RecuperaCodiceServizioSystemUnicoOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero codice servizio / system unico fallita", e);
			throw e;
		}
		return bean;

	}

	// RU_994
	// Verifica ordine di variazione Downgrade Fast
	@JsonPostMapping("/verificaOrdineVariazioneDowngradeFast")
	public EsitoOutputBean verificaOrdineVariazioneDowngradeFast(
			@RequestBody VerificaOrdineVariazioneDowngradeFastInputBean input, HttpSession session)
			throws BusinessLayerException {
		EsitoOutputBean bean = new EsitoOutputBean();
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.verificaOrdineVariazioneDowngradeFast(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica ordine di variazione Downgrade Fast fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1058
	// Visualizza campi offerta VLAN
	@JsonPostMapping("/visualizzaCampiOfferteVLAN")
	public VisualizzaCampiOfferteVLANWrapperOutputBean visualizzaCampiOffertaVLAN(
			@RequestBody VisualizzaCampiOfferteVLANInputBean input, HttpSession session) throws BusinessLayerException {
		VisualizzaCampiOfferteVLANWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.visualizzaCampiOfferteVLAN(input);
			bean = ensureBeanResult(bean, VisualizzaCampiOfferteVLANWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero campi offerte VLAN fallita", e);
			throw e;
		}
		return bean;

	}

	// RU_1058
	// Verifica kit abilitato NGA (C11M08F72)
	@JsonPostMapping("/verificaKitAbilitatoNGA")
	public VerificaKitAbilitatoNGAWrapperOutputBean verificaKitAbilitatoNGA(
			@RequestBody VerificaKitAbilitatoNGAInputBean input, HttpSession session) throws BusinessLayerException {
		VerificaKitAbilitatoNGAWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaKitAbilitatoNGA(input);
			bean = ensureBeanResult(bean, VerificaKitAbilitatoNGAWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica kit abilitato NGA fallita", e);
			throw e;
		}
		return bean;

	}

	// RU_1058
	// Recupera campi offerta VP
	@JsonPostMapping("/recuperaCampiOffertaVP")
	public RecuperaCampiOffertaVPWrapperOutputBean recuperaCampiOffertaVP(
			@RequestBody RecuperaCampiOffertaVPInputBean input, HttpSession session) throws BusinessLayerException {
		RecuperaCampiOffertaVPWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.recuperaCampiOffertaVP(input);
			bean = ensureBeanResult(bean, RecuperaCampiOffertaVPWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero campi offerta VP fallita", e);
			throw e;
		}
		return bean;
	}

	@JsonPostMapping("/verificaCodiceTdKit")
	public VerificaCodiceTdKitWrapperOutputBean verificaCodiceTdKit(@RequestBody VerificaCodiceTdKitInputBean input,
			HttpSession session) throws BusinessLayerException {
		VerificaCodiceTdKitWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaCodiceTdKit(input);
			bean = ensureBeanResult(bean, VerificaCodiceTdKitWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica codice TdKit fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1058
	// SM_9723
	// Verifica modello kit (C04M01F454)
	@JsonPostMapping("/verificaModelloKit")
	public VerificaModelloKitWrapperOutputBean verificaModelloKit(@RequestBody VerificaModelloKitInputBean input,
			HttpSession session) throws BusinessLayerException {
		VerificaModelloKitWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaModelloKit(input);
			bean = ensureBeanResult(bean, VerificaModelloKitWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica modello kit fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1058
	// Recupera valori CAR
	@JsonPostMapping("/recuperaCar")
	public RecuperaCARWrapperOutputBean recuperaCar(@RequestBody RecuperaCARInputBean input, HttpSession session)
			throws BusinessLayerException {
		RecuperaCARWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.recuperaCar(input);
			bean = ensureBeanResult(bean, RecuperaCARWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero CAR fallita", e);
			throw e;
		}
		return bean;

	}

	// RU_1058
	// Recupera SubContractor
	@JsonGetMapping("/recuperaSubContractor/{idRisorsa}")
	public RecuperaSubContractorWrapperOutputBean recuperaSubContractor(@PathVariable String idRisorsa,
			HttpSession session) throws BusinessLayerException {
		RecuperaSubContractorWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.recuperaSubContractor(idRisorsa);
			bean = ensureBeanResult(bean, RecuperaSubContractorWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero sub contractor fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1058
	// Recupera CodOlo SubContractor
	@JsonGetMapping("/recuperaCodOloSubContractor/{idRisorsa}")
	public RecuperaCodOloSubContractorWrapperOutputBean recuperaCodOloSubContractor(@PathVariable String idRisorsa,
			HttpSession session) throws BusinessLayerException {
		RecuperaCodOloSubContractorWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.recuperaCodOloSubContractor(idRisorsa);
			bean = ensureBeanResult(bean, RecuperaCodOloSubContractorWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recuperoc codice olo sub contractor fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1060
	// Verifica Comune / Offerta Infratel (C11M08F75)
	@JsonPostMapping("/verificaComuneOffertaInfratel")
	public VerificaComuneOffertaInfratelWrapperOutputBean verificaComuneOffertaInfratel(
			@RequestBody VerificaComuneOffertaInfratelInputBean input, HttpSession session)
			throws BusinessLayerException {
		VerificaComuneOffertaInfratelWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaComuneOffertaInfratel(input);
			bean = ensureBeanResult(bean, VerificaComuneOffertaInfratelWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica comune / offerta Infratel fallita", e);
			throw e;
		}
		return bean;

	}

	// RU_1089
	// Verifica Congruenza Cluster Comune VLAN (C11M08F79)
	@JsonPostMapping("/verificaCongruenzaClusterComuneVlan")
	public VerificaCongruenzaClusterComuneVlanOutputBean verificaCongruenzaClusterComuneVlan(
			@RequestBody VerificaCongruenzaClusterComuneVlanInputBean input, HttpSession session)
			throws BusinessLayerException {
		VerificaCongruenzaClusterComuneVlanOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaCongruenzaClusterComuneVlan(input);
			bean = ensureBeanResult(bean, VerificaCongruenzaClusterComuneVlanOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica congruenza cluster comune VLAN fallita", e);
			throw e;
		}
		return bean;

	}

	// RU_1129
	@JsonPostMapping("/recuperaProfiliFwa")
	public RecuperaProfiliFwaWrapperOutputBean recuperaProfiliFwa(@RequestBody RecuperaProfiliFwaInputBean input,
			HttpSession session) throws BusinessLayerException {
		RecuperaProfiliFwaWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.recuperaProfiliFwa(input);
			bean = ensureBeanResult(bean, RecuperaProfiliFwaWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero profili FWA fallita", e);
			throw e;
		}
		return bean;

	}

	// Verifica Tipologia Contratto FWA (C11M08F80)
	@JsonPostMapping("/verificaTipologiaContrattoFwa")
	public VerificaTipologiaContrattoFwaWrapperOutputBean verificaTipologiaContrattoFwa(
			@RequestBody VerificaTipologiaContrattoFwaInputBean input, HttpSession session)
			throws BusinessLayerException {
		VerificaTipologiaContrattoFwaWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaTipologiaContrattoFwa(input);
			bean = ensureBeanResult(bean, VerificaTipologiaContrattoFwaWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica tipologia contratto FWA fallita", e);
			throw e;
		}
		return bean;

	}

	// SM_9825
	// Recupera codici TD Kit
	@JsonPostMapping("/recuperaCodiciTdKit")
	public RecuperaCodiciTdKitWrapperOutputBean recuperaCodiciTdKit(@RequestBody RecuperaCodiciTdKitInputBean input,
			HttpSession session) throws BusinessLayerException {
		RecuperaCodiciTdKitWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.recuperaCodiciTdKit(input);
			bean = ensureBeanResult(bean, RecuperaCodiciTdKitWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero codici Td Kit fallita", e);
			throw e;
		}
		return bean;
	}

	// SM_9825
	// Verifica Modello Kit Madr (C11M08F82)
	@JsonGetMapping("/verificaModelloKitMadr")
	public VerificaModelloKitMadrWrapperOutputBean verificaModelloKitMadr(
			@RequestParam(value = "codiceTdKit", required = true) String codiceTdKit, HttpSession session)
			throws BusinessLayerException {
		VerificaModelloKitMadrWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaModelloKitMadr(codiceTdKit);
		} catch (Exception e) {
			logger.info("Richiesta verifica modello kit madr fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1150
	// RU_1274
	// Recupera Id GPON
	@JsonPostMapping("/recuperaIdGpon")
	public RecuperaIdGponWrapperOutputBean recuperaIdGpon(@RequestBody RecuperaIdGponInputBean input,
			HttpSession session) throws BusinessLayerException {
		RecuperaIdGponWrapperOutputBean bean = null;
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.recuperaIdGpon(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, RecuperaIdGponWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero Id GPON fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1166
	// Recupera Macroarea
	@JsonPostMapping("/recuperaMacroArea")
	public RecuperaMacroAreaWrapperOutputBean recuperaMacroArea(@RequestBody RecuperaMacroAreaInputBean input,
			HttpSession session) throws BusinessLayerException {
		RecuperaMacroAreaWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.recuperaMacroArea(input);
			bean = ensureBeanResult(bean, RecuperaMacroAreaWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero Macroarea fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1164
	// Verifica Contratto Coinvestimento Comune (C11M08F84)
	@JsonPostMapping("/verificaContrattoCoinvestimentoComune")
	public VerificaContrattoCoinvestimentoComuneWrapperOutputBean verificaContrattoCoinvestimentoComune(
			@RequestBody VerificaContrattoCoinvestimentoComuneInputBean input, HttpSession session)
			throws BusinessLayerException {
		VerificaContrattoCoinvestimentoComuneWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaContrattoCoinvestimentoComune(input);
			bean = ensureBeanResult(bean, VerificaContrattoCoinvestimentoComuneWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica contratto coinvestimento comune fallita", e);
			throw e;
		}
		return bean;

	}

	// RU_1180
	// Visualizza campi offerta Multicast
	@JsonPostMapping("/visualizzaCampiOfferteMulticast")
	public VisualizzaCampiOfferteMulticastWrapperOutputBean visualizzaCampiOfferteMulticast(
			@RequestBody VisualizzaCampiOfferteMulticastInputBean input, HttpSession session)
			throws BusinessLayerException {
		VisualizzaCampiOfferteMulticastWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.visualizzaCampiOfferteMulticast(input);
			bean = ensureBeanResult(bean, VisualizzaCampiOfferteMulticastWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero campi offerte Multicast fallita", e);
			throw e;
		}
		return bean;
	}

	// Verifica abilitazione MC contratto (C04M01F473 )
	// SM_10192
	@JsonGetMapping("/verificaAbilitazioneMcContratto")
	public VerificaAbilitazioneMulticastContrattoWrapperOutputBean verificaAbilitazioneMcContratto(
			@RequestParam String codOloAgcom, @RequestParam String flagPrimoFeeder, HttpSession session)
			throws BusinessLayerException {
		VerificaAbilitazioneMulticastContrattoWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaAbilitazioneMcContratto(codOloAgcom, flagPrimoFeeder);
			bean = ensureBeanResult(bean, VerificaAbilitazioneMulticastContrattoWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica abilitazione contratto Multicast fallita", e);
			throw e;
		}
		return bean;

	}

	// Verifica Recupero Modem (C11M08F88)
	// RU_1181
	@JsonGetMapping("/verificaRecuperoModem")
	public VerificaRecuperoModemWrapperOutputBean verificaRecuperoModem(@RequestParam String idAsset,
			HttpSession session) throws BusinessLayerException {
		VerificaRecuperoModemWrapperOutputBean bean = null;
		try {
			bean = ordineManagerBL.verificaRecuperoModem(idAsset);
			bean = ensureBeanResult(bean, VerificaRecuperoModemWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica recupero modem fallita", e);
			throw e;
		}
		return bean;

	}

	// Verifica Compatibilità Profilo Tecnico Linea (C11M08F89)
	// R1I-21-0138
	@JsonPostMapping("/verificaCompatibilitaProfiloTecnicoLinea")
	public VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputBean verificaCompatibilitaProfiloTecnicoLinea(
			@RequestBody VerificaCompatibilitaProfiloTecnicoLineaInputBean input, HttpSession session)
			throws BusinessLayerException {
		VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputBean bean = null;
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.verificaCompatibilitaProfiloTecnicoLinea(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica compatibilità profilo tecnico linea fallita", e);
			throw e;
		}
		return bean;

	}

	// R1F-20-0236.D
	@JsonPostMapping("/verificaNumeriNoteOperatore")
	public VerificaNoteOperatoreWrapperOutputBean verificaNumeriNoteOperatore(
			@RequestBody VerificaNoteOperatoreInputBean input, HttpSession session) throws BusinessLayerException {
		VerificaNoteOperatoreWrapperOutputBean bean = null;
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.verificaNumeriNoteOperatore(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, VerificaNoteOperatoreWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica numeri note operatore fallita", e);
			throw e;
		}
		return bean;

	}

	// Veriìfica Profilo Tecnico Linea X1/X2 (C11M08F91)
	// RU_1270
	@JsonGetMapping("/verificaProfiloTecnicoLineaX1X2")
	public VerificaProfiloTecnicoLineaX1X2WrapperOutputBean verificaProfiloTecnicoLineaX1X2(
			@RequestParam String idOfferta, @RequestParam String profiloTecnicoLinea, HttpSession session)
			throws BusinessLayerException {
		VerificaProfiloTecnicoLineaX1X2WrapperOutputBean bean = null;
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.verificaProfiloTecnicoLineaX1X2(idOfferta, profiloTecnicoLinea,
					user.getCodiceProfilo());
			bean = ensureBeanResult(bean, VerificaProfiloTecnicoLineaX1X2WrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica profilo tecnico linea X1/X2 fallita", e);
			throw e;
		}
		return bean;

	}

	// Verifica Id Risorsa Switchoff contratto FWA (C11M08F93)
	// RU_1335
	@JsonGetMapping("/verificaIdRisorsaSwitchoffContrattoFwa")
	public VerificaIdRisorsaSwitchoffFwaWrapperOutputBean verificaIdRisorsaSwitchoffContrattoFwa(
			@RequestParam String idRisorsa, HttpSession session) throws BusinessLayerException {
		VerificaIdRisorsaSwitchoffFwaWrapperOutputBean bean = null;
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.verificaIdRisorsaSwitchoffContrattoFwa(idRisorsa, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, VerificaIdRisorsaSwitchoffFwaWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica Id Risorsa Switchoff Contratto Fwa fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1393
	// RU_1428
	@JsonPostMapping("/recuperaCodiceSystemUnico")
	public RecuperaCodiceSystemUnicoWrapperOutputBean recuperaCodiceSystemUnico(
			@RequestBody RecuperaCodiceSystemUnicoInputBean input, HttpSession session) throws BusinessLayerException {
		RecuperaCodiceSystemUnicoWrapperOutputBean bean = null;
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.recuperaCodiceSystemUnico(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, RecuperaCodiceSystemUnicoWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero codice system unico fallita", e);
			throw e;
		}
		return bean;
	}

	@JsonPostMapping("/recuperaCodiceSubAppalto")
	public RecuperaCodiceSubAppaltoOutputBean recuperaCodiceSubAppalto(
			@RequestBody RecuperaCodiceSubAppaltoInputBean input, HttpSession session) throws BusinessLayerException {
		RecuperaCodiceSubAppaltoOutputBean bean = null;
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.recuperaCodiceSubAppalto(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, RecuperaCodiceSubAppaltoOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero codice subapplato fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1428
	@JsonPostMapping("/recuperaTipologiaImpresa")
	public RecuperaTipologiaImpresaOutputBean recuperaTipologiaImpresa(
			@RequestBody RecuperaTipologiaImpresaInputBean input, HttpSession session) throws BusinessLayerException {
		RecuperaTipologiaImpresaOutputBean bean = null;
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.recuperaTipologiaImpresa(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, RecuperaTipologiaImpresaOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero tipologia impresa fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1485
	// C11M08F102 - Visualizzazione servizi opzionali alternativi
	@JsonGetMapping("/recuperaServiziOpzionaliAlternativi")
	public RecuperaServiziOpzionaliAlternativiWrapperOutputBean recuperaServiziOpzionaliAlternativi(
			@RequestParam(required = true) String codiceProgetto, HttpSession session) throws BusinessLayerException {
		RecuperaServiziOpzionaliAlternativiWrapperOutputBean bean = null;
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.recuperaServiziOpzionaliAlternativi(codiceProgetto, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, RecuperaServiziOpzionaliAlternativiWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta recupero servizi opzionali alternativi fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1502
	// C11M08F106 - Verifica spostamento VLAN
	@JsonPostMapping("/verificaSpostamentoVlan")
	public EsitoOutputBean verificaSpostamentoVlan(@RequestBody VerificaSpostamentoVLANInputBean input,
			HttpSession session) throws BusinessLayerException {
		EsitoOutputBean bean = new EsitoOutputBean();
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.verificaSpostamentoVlan(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica spostamento VLAN fallita", e);
			throw e;
		}
		return bean;
	}

	// SM_11483
	// C11M08F107 - Verifica congruenza DRG offerta
	@JsonPostMapping("/verificaCongruenzaDRGOfferta")
	public EsitoOutputBean verificaCongruenzaDRGOffeerta(@RequestBody VerificaCongruenzaDRGOffertaInputBean input,
			HttpSession session) throws BusinessLayerException {
		EsitoOutputBean bean = new EsitoOutputBean();
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.verificaCongruenzaDRGOfferta(input, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica congruenza DRG offerta fallita", e);
			throw e;
		}
		return bean;
	}

	// RU_1543
	// C11M08F108 - Verifica attivazione Full GPON Plus
	@JsonGetMapping("/verificaAttivazioneFullGponPlus")
	public EsitoOutputBean verificaAttivazioneFullGponPlus(@RequestParam(required = true) String codOloAgcom,
			@RequestParam(required = true) String idRisorsaOld, HttpSession session) throws BusinessLayerException {
		EsitoOutputBean bean = new EsitoOutputBean();
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.verificaAttivazioneFullGponPlus(codOloAgcom, idRisorsaOld, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica attivazione Full GPON Plus fallita", e);
			throw e;
		}
		return bean;
	}
	
	// RU_1560
	@JsonGetMapping("/getCodiceOperatoreSecondario")
	public RecuperaCodiceOperatoreSecondarioWrapperOutputBean getCodiceOperatoreSecondario(@RequestParam(required = true) String codOloAgcom, HttpSession session) throws BusinessLayerException {
		RecuperaCodiceOperatoreSecondarioWrapperOutputBean bean = new RecuperaCodiceOperatoreSecondarioWrapperOutputBean();
		UserBean user = getCurrentUser(session);
		try {
			bean = ordineManagerBL.getCodiceOperatoreSecondario(codOloAgcom, user.getCodiceProfilo());
			bean = ensureBeanResult(bean, RecuperaCodiceOperatoreSecondarioWrapperOutputBean.class);
		} catch (Exception e) {
			logger.info("GET codici operatore secondario fallita", e);
			throw e;
		}
		return bean;
	}
	
	// RU_1560 -> C11M08F111
	@JsonGetMapping("verificaCodiceProgettoOneStepTLC8")
	public EsitoOutputBean verificaCodiceProgettoOneStepTLC8(@RequestParam(required = true) String codServizio, @RequestParam(required = true) String codProgetto, HttpSession session) throws Exception {
		try {
			EsitoOutputBean bean = new EsitoOutputBean();
			UserBean user = getCurrentUser(session);
			bean = ordineManagerBL.verificaCodiceProgettoOneStepTLC8(codServizio, codProgetto, user.getCodiceProfilo());
			return ensureBeanResult(bean, EsitoOutputBean.class);
		} catch(Exception e) {
			logger.info("verificaCodiceProgettoOneStepTLC8 fallita", e);
			throw e;
		}
	}
	
	// RU_1560 -> C11M08F112
	@JsonGetMapping("verificaSLABasePerONTOperatore")
	public EsitoOutputBean verificaSLABasePerONTOperatore(@RequestParam(required = true) String idRisorsa, @RequestParam(required = true) String slaAssurance, HttpSession session) throws Exception {
		try {
			UserBean user = getCurrentUser(session);
			EsitoOutputBean bean = ordineManagerBL.verificaSLABasePerONTOperatore(idRisorsa, slaAssurance, user.getCodiceProfilo());
			return ensureBeanResult(bean, EsitoOutputBean.class);
		} catch(Exception e) {
			logger.info("verificaSLABasePerONTOperatore fallita", e);
			throw e;
		}
	}
	
	// RU_1560 -> C11M08F113
	@JsonGetMapping("/verificaAttivazioneFTTH")
	public EsitoOutputBean verificaAttivazioneFTTH(@RequestParam(required = true) String codOloAgcom,
			@RequestParam(required = true) String idRisorsaOld, HttpSession session) throws BusinessLayerException {
		try {
			UserBean user = getCurrentUser(session);
			EsitoOutputBean bean = ordineManagerBL.verificaAttivazioneFTTH(codOloAgcom, idRisorsaOld, user.getCodiceProfilo());
			return ensureBeanResult(bean, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.info("verificaAttivazioneFTTH fallita", e);
			throw e;
		}
	}
	
	// RU_1560 -> C11M08F114
	@JsonGetMapping("/verificaMigrazioneFTTH")
	public EsitoOutputBean verificaMigrazioneFTTH(@RequestParam(required = true) String idAsset,
			@RequestParam(required = true) String offerta, HttpSession session) throws BusinessLayerException {
		try {
			UserBean user = getCurrentUser(session);
			EsitoOutputBean bean = ordineManagerBL.verificaMigrazioneFTTH(idAsset, offerta, user.getCodiceProfilo());
			return ensureBeanResult(bean, EsitoOutputBean.class);
		} catch (Exception e) {
			logger.info("verificaMigrazioneFTTH fallita", e);
			throw e;
		}
	}
	
	// RU_1598
	@JsonGetMapping("/recuperaClusterAccesso")
	public RecuperaClusterAccessoOutputBean recuperaClusterAccesso(HttpSession session) throws BusinessLayerException {
		RecuperaClusterAccessoOutputBean bean = null;
		try {
			bean = ordineManagerBL.recuperaClusterAccesso();
			bean = ensureBeanResult(bean, RecuperaClusterAccessoOutputBean.class);
		} catch (Exception e) {
			logger.info("Richiesta verifica abilitazione contratto Multicast fallita", e);
			throw e;
		}
		return bean;

	}
	
}
