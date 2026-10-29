package com.nttdata.tim.now.adapters.esb.ordine;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.asset.VerificaIdRisorsaInputDTO;
import com.nttdata.tim.now.data.dto.asset.VerificaIdRisorsaNakedInputDTO;
import com.nttdata.tim.now.data.dto.asset.VerificaIdRisorsaNakedOutputDTO;
import com.nttdata.tim.now.data.dto.asset.VerificaIdRisorsaOutputDTO;
import com.nttdata.tim.now.data.dto.base.CreateResponseDTO;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.base.ResultDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;
import com.nttdata.tim.now.data.dto.ordine.CheckNumMaxVCConfigurabiliOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.CoerenzaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.CompatibilitaProfiloTecnicoLineaProfiloVC_DTO;
import com.nttdata.tim.now.data.dto.ordine.ConfigurazioneListOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.ConsistenzaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.CreazioneNuovoOrdineInputDTO;
import com.nttdata.tim.now.data.dto.ordine.OrderConsuntivoOutputListDTO;
import com.nttdata.tim.now.data.dto.ordine.OrderDTO;
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
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.date.DateHelper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrdineRESTClient extends RestClientFacade {

	private static final String CODICEORDINETI = "CODICEORDINETI";
	private static final String IDRICHESTAOLO = "IDRICHESTAOLO";
	private static final String DEFAULT_LIST_TYPE = "TUTTI";

	private static final String ID_RISORSA = "id_risorsa";
	private static final String ID_RISORSA_VERIFICA_MODEM = "idRisorsa";
	private static final String IDRISORSA1 = "idRisorsa1";
	private static final String IDRISORSA2 = "idRisorsa2";
	private static final String OAODONATING1 = "oaoDonating1";
	private static final String OAODONATING2 = "oaoDonating2";
	private static final String CODORDINE = "codOrdine";
	private static final String CODORDINEPADRE = "codOrdinePadre";

	private static final String ID_OFFERTA = "idOfferta";
	private static final String OPZIONE_VARIAZIONE = "opzioneVariazione";

	private static final String PROFILO_FWA = "profilo";

	// RU_1058
	private static final String NOME_CAMPO = "nomeCampo";
	private static final String VALORE_CAMPO = "valoreCampo";
	private static final String CODICE_TDKIT = "codiceTdKit";
	private static final String CODICE_FUNZIONE = "codiceFunzione";
	private static final String CODICE_OLO_AGCOM = "codOloAgcom";

	// #Task33535
	private static final String MCR = "mcr";

	// RU_1181
	private static final String ID_ASSET = "idAsset";

	// RU_1270
	private static final String PROFILO_TECNICO_LINEA = "profiloTecnicoLinea";

	// RU_1335
	private static final String ID_RISORSA_SWITCHOFF = "idRisorsa";

	// RU_1485
	private static final String CODICE_PROGETTO = "codiceProgetto";

	@Value("${rest.integration.order.contextpath}")
	private String serviceContextPath;

	@Value("${rest.order.create_order.contextpath}")
	private String createServiceContextPath;

	@Value("${rest.integration.order_detail.contextpath}")
	private String detailServiceContextPath;

	@Value("${rest.integration.order.export.start.contextpath}")
	private String exportStartContextPath;

	@Value("${rest.controls.verifica.richiesta.ordine.contextpath}")
	private String verificaRichiestaOrdineContextPath;

	@Value("${rest.controls.asset.verify.resource.id.contextpath}")
	private String verificaIdRisorsaContextPath;

	@Value("${rest.controls.asset.verify.resource.naked.id.contextpath}")
	private String verificaIdRisorsaNakedContextPath;

	@Value("${rest.controls.verifica.wholesaler.contextpath}")
	private String verificaOloWholesalerContextPath;

	@Value("${rest.order.configurazionefe.contextpath}")
	private String configurazionefeContextPath;

	@Value("${rest.order.recuperoconsistenzaidrisorsa.contextpath}")
	private String recuperoconsistenzaidrisorsaContextPath;

	@Value("${rest.order.recuperocodicedonating.contextpath}")
	private String recuperocodicedonatingContextPath;

	@Value("${rest.order.recuperarichieste.contextpath}")
	private String recuperarichiesteContextPath;

	@Value("${rest.order.verificacompatibproftecnlineaprofilovc.contextpath}") // RU_713
	private String verificacompatibproftecnlineaprofilovcContextPath;

	@Value("${rest.controls.verificacompatibilitalavorazione.contextpath}")
	private String verificaCompatibilitaLavorazioneContextPath;

	@Value("${rest.integration.preventivo.request.contextpath}")
	private String preventivoRequestContextPath;

	@Value("${rest.controls.verificapervariazionewlr.contextpath}")
	private String verificaPerVariazioneWlrContextPath;

	@Value("${rest.controls.verificacontrattopervariazione.contextpath}")
	private String verificaContrattoPerVariazioneContextPath;

	@Value("${rest.controls.verificacoerenzaidrisorsa.contextpath}")
	private String verificaCoerenzaIdRisorsaContextPath;

	@Value("${rest.controls.verificapresenzaidrisorsa.contextpath}")
	private String verificaPresenzaIdRisorsaContextPath;

	@Value("${rest.controls.verificavpflatattestazione.contextpath}")
	private String verificaVpFlatAttestazioneContextPath;

	@Value("${rest.controls.verificacongruenzaoffertacodordine.contextpath}")
	private String verificacongruenzaoffertacodordine;

	@Value("${rest.controls.numeromaxvcconfig.contextpath}")
	private String verificanumeromaxvcconfig;

	@Value("${rest.controls.verificaticketttm.contextpath}")
	private String verificaticketttm;

	@Value("${rest.controls.verificatecnologia.contextpath}")
	private String verificatecnologia;

	@Value("${rest.integration.recuperodatatimeout.contextpath}")
	private String recuperodatatimeout;

	@Value("${auth.rest.integration.order.contextpath}")
	private String authserviceContextPath;

	@Value("${auth.rest.order.create_order.contextpath}")
	private String authcreateServiceContextPath;

	@Value("${auth.rest.integration.order_detail.contextpath}")
	private String authdetailServiceContextPath;

	@Value("${auth.rest.integration.order.export.start.contextpath}")
	private String authexportStartContextPath;

	@Value("${auth.rest.controls.verifica.richiesta.ordine.contextpath}")
	private String authverificaRichiestaOrdineContextPath;

	@Value("${auth.rest.controls.asset.verify.resource.id.contextpath}")
	private String authverificaIdRisorsaContextPath;

	@Value("${auth.rest.controls.asset.verify.resource.naked.id.contextpath}")
	private String authverificaIdRisorsaNakedContextPath;

	@Value("${auth.rest.controls.verifica.wholesaler.contextpath}")
	private String authverificaOloWholesalerContextPath;

	@Value("${auth.rest.order.configurazionefe.contextpath}")
	private String authconfigurazionefeContextPath;

	@Value("${auth.rest.order.recuperoconsistenzaidrisorsa.contextpath}")
	private String authrecuperoconsistenzaidrisorsaContextPath;

	@Value("${auth.rest.order.recuperocodicedonating.contextpath}")
	private String authrecuperocodicedonatingContextPath;

	@Value("${auth.rest.order.recuperarichieste.contextpath}")
	private String authrecuperarichiesteContextPath;

	@Value("${auth.rest.order.verificacompatibproftecnlineaprofilovc.contextpath}")
	private String authverificacompatibproftecnlineaprofilovcContextPath; // RU_713

	@Value("${auth.rest.controls.verificacompatibilitalavorazione.contextpath}")
	private String authverificaCompatibilitaLavorazioneContextPath;

	@Value("${auth.rest.integration.preventivo.request.contextpath}")
	private String authpreventivoRequestContextPath;

	@Value("${auth.rest.controls.verificapervariazionewlr.contextpath}")
	private String authverificaPerVariazioneWlrContextPath;

	@Value("${auth.rest.controls.verificacontrattopervariazione.contextpath}")
	private String authverificaContrattoPerVariazioneContextPath;

	@Value("${auth.rest.controls.verificacoerenzaidrisorsa.contextpath}")
	private String authverificaCoerenzaIdRisorsaContextPath;

	@Value("${auth.rest.controls.verificapresenzaidrisorsa.contextpath}")
	private String authverificaPresenzaIdRisorsaContextPath;

	@Value("${auth.rest.controls.verificavpflatattestazione.contextpath}")
	private String authverificaVpFlatAttestazioneContextPath;

	@Value("${auth.rest.controls.verificacongruenzaoffertacodordine.contextpath}")
	private String authverificacongruenzaoffertacodordine;

	@Value("${auth.rest.controls.numeromaxvcconfig.contextpath}")
	private String authverificanumeromaxvcconfig;

	@Value("${auth.rest.controls.verificaticketttm.contextpath}")
	private String authverificaticketttm;

	@Value("${auth.rest.controls.verificatecnologia.contextpath}")
	private String authverificatecnologia;

	@Value("${auth.rest.integration.recuperodatatimeout.contextpath}")
	private String authrecuperodatatimeout;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	@Value("${rest.order.verifica_codice_ordine_olo.contextpath}")
	private String verificaCodiceOrdineOloServiceContextPath;

	@Value("${rest.order.verifica_in_consistenza_presenza_modem.contextpath}")
	private String verificaInConsistenzaPresenzaModemServiceContextPath;

	@Value("${auth.rest.order.verifica_in_consistenza_presenza_modem.contextpath}")
	private String authVerificaInConsistenzaPresenzaModemServiceContextPath;

	@Value("${rest.order.recupera_profili_fwa.contextpath}")
	private String recuperaProfiliFwaServiceContextPath;

	@Value("${auth.rest.order.recupera_profili_fwa.contextpath}")
	private String authRecuperaProfiliFwaServiceContextPath;

	@Value("${rest.order.verifica_codice_progetto_one_step.contextpath}")
	private String verificaCodiceProgettoOneStepServiceContextPath;

	@Value("${auth.rest.order.verifica_codice_progetto_one_step.contextpath}")
	private String authVerificaCodiceProgettoOneStepServiceContextPath;

	// RU_966
	@Value("${rest.controls.verifica_compatibilita_intermediate_agent.contextpath}")
	private String verificaIntermediateAgentFullServiceContextPath;

	// RU_980
	@Value("${rest.order.recuperacodserviziosysunico}")
	private String recuperaCodInfoSysUnicoContextPath;

	// RU_995
	@Value("${auth.rest.order.verifica_ordine_variazione_downgrade_fast}")
	private String authVerificaOrdineVariazioneDowngradeFastContextPath;

	// RU_995
	@Value("${rest.order.verifica_ordine_variazione_downgrade_fast}")
	private String verificaOrdineVariazioneDowngradeFastContextPath;

	// RU_1058
	@Value("${rest.order.visualizza_campi_offerte_vlan.contextpath}")
	private String visualizzaCampiOfferteVLANContextPath;

	// RU_1058
	@Value("${rest.controls.verifica_kit_abilitato_nga.contextpath}")
	private String verificaKitAbilitatoNGAContextPath;

	// RU_1058
	@Value("${rest.order.recupera_campi_offerta_vp.contextpath}")
	private String recuperaCampiOffertaVPContextPath;

	// RU_1058
	@Value("${rest.controls.verifica_codice_tdkit.contextpath}")
	private String verificaCodiceTdKitContextPath;

	// RU_1058
	@Value("${rest.controls.verifica_modello_kit.contextpath}")
	private String verificaModelloKitContextPath;

	// RU_1058
	@Value("${rest.order.recupera_car.contextpath}")
	private String recuperaCarContextPath;

	@Value("${rest.order.recupera_subcontractor.contextpath}")
	private String recuperaSubContractorContextPath;

	@Value("${rest.order.recupera_codolosubcontractor.contextpath}")
	private String recuperaCodOloSubContractorContextPath;

	// RU_1060
	@Value("${rest.controls.verifica_comune_offerta_infratel.contextpath}")
	private String verificaComuneOffertaInfratelContextPath;

	// RU_1089
	@Value("${rest.controls.verifica_congruenza_clusterComune_vlan.contextpath}")
	private String verificaCongruenzaClusterComuneVlanContextPath;

	// RU_1129
	@Value("${rest.controls.verifica_tipologia_contratto_fwa.contextpath}")
	private String verificaTipologiaContrattoFwaContextPath;

	// SM_9825
	@Value("${rest.order.recupera_codici_tdkit.contextpath}")
	private String recuperaCodiciTdKitContextPath;

	@Value("${rest.controls.verifica_modello_kit_madr.contextpath}")
	private String verificaModelloKitMadrContextPath;

	// RU_1150
	@Value("${rest.order.recupera_idgpon_contextpath}")
	private String recuperaIdGponContextPath;

	// RU_1166
	@Value("${rest.order.recupera_macroarea_contextpath}")
	private String recuperaMacroAreaContextPath;

	// RU_1164
	@Value("${rest.controls.verifica_contratto_coinvestimento_comune.contextpath}")
	private String verificaContrattoCoinvestimentoComuneContextPath;

	// RU_1180
	@Value("${rest.order.visualizza_campi_offerte_multicast.contextpath}")
	private String visualizzaCampiOfferteMulticastContextPath;

	@Value("${rest.controls.verifica_abilitazione_multicast_contratto.contextpath}")
	private String verificaAbilitazioneMulticastContrattoContextpath;

	// RU_1181
	@Value("${rest.order.verifica_recupero_modem.contextpath}")
	private String verificaRecuperoModemContextpath;

	// R1I-21-0138
	@Value("${rest.controls.verifica_compatibilita_profilo_tecnico_linea}")
	private String verificaCompatibilitaProfiloTecnicoLineaContextpath;

	@Value("${auth.rest.controls.verifica_compatibilita_profilo_tecnico_linea.contextpath}")
	private String authVerificaCompatibilitaProfiloTecnicoLineaContextPath;

	// R1F-20-0236.D
	@Value("${rest.controls.verifica_numeri_note.contextpath}")
	private String verificaNumeriNoteContextpath;

	@Value("${auth.rest.controls.verifica_numeri_note.contextpath}")
	private String authVerificaNumeriNoteContextPath;

	// RU_1270
	@Value("${rest.controls.verifica_profilo_tecnico_linea_x1x2.contextpath}")
	private String verificaProfiloTecnicoLineaX1X2Contextpath;

	@Value("${auth.rest.controls.verifica_profilo_tecnico_linea_x1x2.contextpath}")
	private String authVerificaProfiloTecnicoLineaX1X2Contextpath;

	// RU_1274
	@Value("${auth.rest.order.recupera_idgpon_contextpath}")
	private String authRecuperaIdGponContextPath;

	// RU_1335
	@Value("${rest.controls.verifica_id_risorsa_switchoff_fwa.contextpath}")
	private String verificaIdRisorsaSwitchoffFwaContextpath;

	@Value("${auth.rest.controls.verifica_id_risorsa_switchoff_fwa.contextpath}")
	private String authVerificaIdRisorsaSwitchoffFwaContextpath;

	// RU_1393
	@Value("${rest.order.recupero_codice_subappalto.contextpath}")
	private String recuperaCodiceSubappaltoContextpath;

	@Value("${auth.rest.order.recupero_codice_subappalto.contextpath}")
	private String authRecuperaCodiceSubappaltoContextpath;

	@Value("${rest.order.recupero_codice_system_unico.contextpath}")
	private String recuperaCodiceSystemUnicoContextpath;

	@Value("${auth.rest.order.recupero_codice_system_unico.contextpath}")
	private String authRecuperaCodiceSystemUnicoContextpath;

	// RU_1428
	@Value("${rest.order.recupera_tipologia_impresa.contextpath}")
	private String recuperaTipologiaImpresaContextpath;

	@Value("${auth.rest.order.recupera_tipologia_impresa.contextpath}")
	private String authRecuperaTipologiaImpresaContextpath;

	// RU_1485
	@Value("${rest.order.recupera_servizi_opzinali_alternativi.contextpath}")
	private String recuperaServiziOpzionaliAlternativiContextpath;

	@Value("${auth.rest.order.recupera_servizi_opzinali_alternativi.contextpath}")
	private String authRecuperaServiziOpzionaliAlternativiContextpath;

	// RU_1502
	@Value("${rest.controls.verifica_spostamento_vlan.contextpath}")
	private String verificaSpostamentoVlanContextpath;

	@Value("${auth.rest.controls.verifica_spostamento_vlan.contextpath}")
	private String authVerificaSpostamentoVlanContextpath;

	// SM_11483
	@Value("${rest.controls.verifica_congruenza_drg_offerta.contextpath}")
	private String verificaCongruenzaDRGOffertaContextpath;

	@Value("${auth.rest.controls.verifica_congruenza_drg_offerta.contextpath}")
	private String authVerificaCongruenzaDRGOffertaContextpath;

	// RU_XXXX
	@Value("${rest.controls.verifica_attivazione_fullgponplus.contextpath}")
	private String verificaAttivazioneFullGponPlusContextpath;

	@Value("${auth.rest.controls.verifica_attivazione_fullgponplus.contextpath}")
	private String authVerificaAttivazioneFullGponPlusContextpath;
	
	@Value("${rest.controls.verifica_attivazione_ftth.contextpath}")
	private String verificaAttivazioneFTTHContextPath;
	
	@Value("${auth.rest.controls.verifica_attivazione_ftth.contextpath}")
	private String authVerificaAttivazioneFTTHContextPath;
	
	@Value("${rest.controls.get_cod_operatore_secondario.contextpath}")
	private String getCodOperatoreSecondarioContextPath;
	
	@Value("${auth.rest.controls.get_cod_operatore_secondario.contextpath}")
	private String authGetCodOperatoreSecondarioContextPath;
	
	@Value("${rest.controls.get_verifica_onestep_ftth.contextpath}")
	private String getVerificaOneStepFTTHContextPath;
	
	@Value("${auth.rest.controls.get_verifica_onestep_ftth.contextpath}")
	private String authGetVerificaOneStepFTTHContextPath;
	
	@Value("${rest.controls.verifica_sla_ont_operatore.contextpath}")
	private String verificaSlaBaseOntOperatoreContextPath;
	
	@Value("${auth.rest.controls.verifica_sla_ont_operatore.contextpath}")
	private String authVerificaSlaBaseOntOperatoreContextPath;
	
	@Value("${rest.controls.verifica_migrazione_ftth.contextpath}")
	private String verificaMigrazioneFTTHContextPath;
	
	@Value("${auth.rest.controls.verifica_migrazione_ftth.contextpath}")
	private String authVerificaMigrazioneFTTHContextPath;
	
	@Value("${rest.order.recupera_cluster_accesso}")
	private String recuperaClusterAccessoContextPath;

	public OrderDTO getOrder(String number, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(number);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(OrderDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public CreateResponseDTO createOrder(CreazioneNuovoOrdineInputDTO orderInput, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcreateServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcreateServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(createServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(orderInput, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(CreateResponseDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public DettaglioOrdineWrapperDTO getDetailOrder(String codiceOrd, boolean isOloRequestId, String tipoProfilo)
			throws IntegrationLayerException {
		String field = isOloRequestId ? IDRICHESTAOLO : CODICEORDINETI;
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authdetailServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authdetailServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(detailServiceContextPath).path(field)
				.path(codiceOrd);
		// WebTarget webTarget =
		// guiIntegrationClient.client.target("https://10.175.68.54:8181").path(detailServiceContextPath).path(field).path(codiceOrd);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(DettaglioOrdineWrapperDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public OrdersListDTO getOrders(String tipoProfilo, String codOlo, OrderState tipoLista)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget;
		if (tipoLista == null) {
			webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(tipoProfilo).path(codOlo)
					.path(DEFAULT_LIST_TYPE);
		} else {
			webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(tipoProfilo).path(codOlo)
					.path(tipoLista.toString());
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(OrdersListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public RichiestaExportOrdiniOutputDTO requestOrderExport(RichiestaExportOrdiniInputDTO input, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authexportStartContextPath))
				&& (!isAuthorizedService(tipoProfilo, authexportStartContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(exportStartContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RichiestaExportOrdiniOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public OrdersListDTO advancedSearch(AdvancedResearchInputDTO body, String codOloAgcom, String tipoProfilo,
			OrderState stato, OrderListType tipoLista) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget;
		// RU_1492
		if (tipoLista == null) {
			webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(tipoProfilo)
					.path(codOloAgcom).path(OrderListType.TUTTI.toString());
		} else {
			webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(tipoProfilo)
					.path(codOloAgcom).path(tipoLista.toString());
		}
		if (stato != null) {
			webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(tipoProfilo)
					.path(codOloAgcom).path(stato.toString());
		}

		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(OrdersListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaRichiestaOutputDTO verificaRichiesta(VerificaRichiestaInputDTO input, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificaRichiestaOrdineContextPath)) && (!isAuthorizedService(tipoProfilo,
				authverificaRichiestaOrdineContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaRichiestaOrdineContextPath);
		// WebTarget webTarget =
		// guiControlsRestClient.client.target("https://10.175.67.249:8184").path(verificaRichiestaOrdineContextPath);

		if (input.getCausaleRichiesta() != null) {
			// aggiunta per testare verificaRichiesta non accetta lowercase
			webTarget = webTarget.queryParam("CausaleRichiesta", input.getCausaleRichiesta().toUpperCase());
		}
		if (input.getOrdineTIRichiestaOlo() != null) {
			webTarget = webTarget.queryParam("OrdineTIRichiestaOlo", input.getOrdineTIRichiestaOlo());
		}
		if (input.getCodiceRichiesta() != null) {
			webTarget = webTarget.queryParam("CodiceRichiesta", input.getCodiceRichiesta());
		}
		if (input.getDad() != null) {
			webTarget = webTarget.queryParam("DAD", DateHelper.convertFromFE(input.getDad()));
		}
		if (input.getFasciaOraria() != null) {
			webTarget = webTarget.queryParam("FasciaOraria", input.getFasciaOraria());
		}
		if (input.getDac() != null) {
			webTarget = webTarget.queryParam("DAC", DateHelper.convertFromFE(input.getDac()));
		}

		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaRichiestaOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaIdRisorsaOutputDTO requestVerifyResourceId(VerificaIdRisorsaInputDTO input, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificaIdRisorsaContextPath)) && (!isAuthorizedService(tipoProfilo,
				authverificaIdRisorsaContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaIdRisorsaContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaIdRisorsaOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaIdRisorsaNakedOutputDTO requestVerifyResourceIdNaked(VerificaIdRisorsaNakedInputDTO input,
			String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificaIdRisorsaNakedContextPath)) && (!isAuthorizedService(tipoProfilo,
				authverificaIdRisorsaNakedContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaIdRisorsaNakedContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaIdRisorsaNakedOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaOloWholesalerOutputDTO requestVerifyOloWholesaler(VerificaOloWholesalerInputDTO input,
			String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificaOloWholesalerContextPath)) && (!isAuthorizedService(tipoProfilo,
				authverificaOloWholesalerContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaOloWholesalerContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaOloWholesalerOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ConfigurazioneListOutputDTO getConfigurazione(String codFunzione, String idOfferta, String opzioneVariazione,
			String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authconfigurazionefeContextPath)) && (!isAuthorizedService(tipoProfilo,
				authconfigurazionefeContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(configurazionefeContextPath).path(codFunzione);

		if (idOfferta != null) {
			webTarget = webTarget.queryParam(ID_OFFERTA, idOfferta);
		}
		if (opzioneVariazione != null) {
			webTarget = webTarget.queryParam(OPZIONE_VARIAZIONE, opzioneVariazione);
		}

		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ConfigurazioneListOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ConsistenzaWrapperOutputDTO getConsistenzaIdRisorsa(String idRisorsa, String tipoOperazione,
			String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authrecuperoconsistenzaidrisorsaContextPath)) && (!isAuthorizedService(tipoProfilo,
				authrecuperoconsistenzaidrisorsaContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperoconsistenzaidrisorsaContextPath)
				.path(idRisorsa).path(tipoOperazione);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ConsistenzaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public RecuperoCodiceDonatingWrapperOutputDTO getRecuperoCodiceDonating(String idRisorsa1, String oaoDonating1,
			String idRisorsa2, String oaoDonating2, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authrecuperocodicedonatingContextPath)) && (!isAuthorizedService(tipoProfilo,
				authrecuperocodicedonatingContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperocodicedonatingContextPath);
		try {
			webTarget = webTarget.queryParam(IDRISORSA1, idRisorsa1);
			webTarget = webTarget.queryParam(OAODONATING1, oaoDonating1);
			if (idRisorsa2 != null) {
				webTarget = webTarget.queryParam(IDRISORSA2, idRisorsa2);
			}
			if (oaoDonating2 != null) {
				webTarget = webTarget.queryParam(OAODONATING2, oaoDonating2);
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperoCodiceDonatingWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaCompatibilitaLavorazioneOutputDTO verifyCompatibilitaLavorazione(
			VerificaCompatibilitaLavorazioneInputDTO input, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificaCompatibilitaLavorazioneContextPath))
				&& (!isAuthorizedService(tipoProfilo, authverificaCompatibilitaLavorazioneContextPath,
						checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaCompatibilitaLavorazioneContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaCompatibilitaLavorazioneOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public RichiestaPreventivoOutputDTO getRichiestaPreventivo(String idRichiestaOlo, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authpreventivoRequestContextPath)) && (!isAuthorizedService(tipoProfilo,
				authpreventivoRequestContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(preventivoRequestContextPath)
				.path(idRichiestaOlo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RichiestaPreventivoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public OrderConsuntivoOutputListDTO getOrdiniConsuntivo(String idRichiestaOlo, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path("consuntivo")
				.path(idRichiestaOlo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(OrderConsuntivoOutputListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public OrderPreventivoOutputListDTO getOrdiniPreventivo(String idRichiestaOlo, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path("preventivo")
				.path(idRichiestaOlo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(OrderPreventivoOutputListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaPerVariazioneWlrOutputDTO getRichiestaVariazionePerWlr(VerificaPerVariazioneWlrInputDTO input,
			String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificaPerVariazioneWlrContextPath)) && (!isAuthorizedService(tipoProfilo,
				authverificaPerVariazioneWlrContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		// WebTarget webTarget =
		// guiIntegrationClient.client.target("https://VT-MasulloIl:8184").path(verificaPerVariazioneWlrContextPath);
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaPerVariazioneWlrContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaPerVariazioneWlrOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaContrattoPerVariazioneOutputDTO verificaContrattoPerVariazione(String idAsset, String tipoProfilo,
			String codOloAgcom) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificaContrattoPerVariazioneContextPath))
				&& (!isAuthorizedService(tipoProfilo, authverificaContrattoPerVariazioneContextPath,
						checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaContrattoPerVariazioneContextPath)
				.path(idAsset).path(codOloAgcom);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaContrattoPerVariazioneOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public CoerenzaWrapperOutputDTO getCoerenzaIdRisorsa(String idRisorsa, String codOloAgcom, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificaCoerenzaIdRisorsaContextPath)) && (!isAuthorizedService(tipoProfilo,
				authverificaCoerenzaIdRisorsaContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaCoerenzaIdRisorsaContextPath)
				.path(idRisorsa).path(codOloAgcom);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(CoerenzaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public PresenzaOutputDTO getPresenzaIdRisorsa(String idRisorsa, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificaPresenzaIdRisorsaContextPath)) && (!isAuthorizedService(tipoProfilo,
				authverificaPresenzaIdRisorsaContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaPresenzaIdRisorsaContextPath);
		if (idRisorsa != null) {
			webTarget = webTarget.queryParam(ID_RISORSA, idRisorsa);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(PresenzaOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaVpFlatAttestazioneOutputDTO getVerificaVpFlatAttestazione(
			VerificaVpFlatAttestazioneWrapperInputDTO input, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificaVpFlatAttestazioneContextPath)) && (!isAuthorizedService(tipoProfilo,
				authverificaVpFlatAttestazioneContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaVpFlatAttestazioneContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaVpFlatAttestazioneOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public EsitoDTO verificacongruenzaoffertacodordine(String idOfferta, String codOrdine, String codOrdinePadre,
			String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificacongruenzaoffertacodordine)) && (!isAuthorizedService(tipoProfilo,
				authverificacongruenzaoffertacodordine, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck

		//// RU_716
		// WebTarget webTarget =
		//// guiControlsRestClient.client.target("https://10.174.144.116:8184").path(verificacongruenzaoffertacodordine).path(idOfferta).queryParam(CODORDINE,
		//// codOrdine);
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificacongruenzaoffertacodordine)
				.path(idOfferta).queryParam(CODORDINE, codOrdine);
		if (codOrdinePadre != null) {
			webTarget = webTarget.queryParam(CODORDINEPADRE, codOrdinePadre);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public CheckNumMaxVCConfigurabiliOutputDTO numeromaxvcconfig(String idOfferta, String profiloTecnicoLinea,
			String tipoProfilo) throws IntegrationLayerException {

		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificanumeromaxvcconfig))
				&& (!isAuthorizedService(tipoProfilo, authverificanumeromaxvcconfig, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificanumeromaxvcconfig).path(idOfferta)
				.path(profiloTecnicoLinea);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(CheckNumMaxVCConfigurabiliOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_995
	public VerificaTicketTTMWrapperOutputDTO verificaTicketTTM(String idTicketTTM, String idRisorsa, String tipoLinea,
			String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificaticketttm))
				&& (!isAuthorizedService(tipoProfilo, authverificaticketttm, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaticketttm);

		if (idTicketTTM != null) {
			webTarget = webTarget.queryParam("idTicketTTM", idTicketTTM);
		}

		if (idRisorsa != null) {
			webTarget = webTarget.queryParam("idRisorsa", idRisorsa);
		}

		if (tipoLinea != null) {
			webTarget = webTarget.queryParam("tipoLinea", tipoLinea);
		}

		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaTicketTTMWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaTecnologiaOutputDTO verificaTecnologia(String profTecnicoLin, String idOfferta, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authverificatecnologia))
				&& (!isAuthorizedService(tipoProfilo, authverificatecnologia, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificatecnologia).path(profTecnicoLin)
				.path(idOfferta);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaTecnologiaOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public RecuperoDataTimeoutOutputDTO recuperodatatimeout(String idRichiestaOlo, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authrecuperodatatimeout))
				&& (!isAuthorizedService(tipoProfilo, authrecuperodatatimeout, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(recuperodatatimeout).path(idRichiestaOlo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperoDataTimeoutOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public RecuperaRichiesteWrapperOutputDTO getRecuperaRichieste(String lavorazione, String idOfferta, String statoNow,
			String flagNaked, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authrecuperarichiesteContextPath)) && (!isAuthorizedService(tipoProfilo,
				authrecuperarichiesteContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperarichiesteContextPath).path(lavorazione)
				.path(idOfferta).path(statoNow).path(flagNaked);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperaRichiesteWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_713
	public EsitoDTO verificacompatibproftecnlineaprofilovc(CompatibilitaProfiloTecnicoLineaProfiloVC_DTO inputDto)
			throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget()
				.path(verificacompatibproftecnlineaprofilovcContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_833 FIX FWA CESSAZIONE
	public VerificaCodiceOrdineOloWrapperOutputDTO verificaCodiceOrdineOlo(String codiceOrdineOlo, String codOloAgcom)
			throws IntegrationLayerException {

		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaCodiceOrdineOloServiceContextPath)
				.path(codiceOrdineOlo).path(codOloAgcom);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaCodiceOrdineOloWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_871
	public VerificaInConsistenzaPresenzaModemOutputWrapperDTO verificaInConsistenzaPresenzaModem(String idRisorsa,
			String idOfferta, String flagReferente) throws IntegrationLayerException {

		WebTarget webTarget = guiControlsRestClient.getBaseTarget()
				.path(verificaInConsistenzaPresenzaModemServiceContextPath)
				.queryParam(ID_RISORSA_VERIFICA_MODEM, idRisorsa).path(idOfferta).path(flagReferente);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaInConsistenzaPresenzaModemOutputWrapperDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_863
	public RecuperaProfiliFwaWrapperOutputDTO recuperaProfiliFwa(String profiloFwa) throws IntegrationLayerException {
		if (profiloFwa.equals("NULL")) {
			profiloFwa = "";
		}
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaProfiliFwaServiceContextPath)
				.queryParam(PROFILO_FWA, profiloFwa);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperaProfiliFwaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_875
	// SM_10241
	public VerificaCodiceProgettoOneStepOutputWrapperDTO verificaCodiceProgettoOneStep(
			VerificaCodiceProgettoOneStepInputDTO inputDto) throws IntegrationLayerException {

		WebTarget webTarget = guiControlsRestClient.getBaseTarget()
				.path(verificaCodiceProgettoOneStepServiceContextPath);
		// WebTarget webTarget =
		// guiControlsRestClient.client.target("https://10.172.71.93:8184").path(verificaCodiceProgettoOneStepServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaCodiceProgettoOneStepOutputWrapperDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_966
	public VerificaIntermediateAgentFullWrapperOutputDTO verificaIntermediateAgentFull(
			VerificaIntermediateAgentFullInputDTO inputDto) throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget()
				.path(verificaIntermediateAgentFullServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaIntermediateAgentFullWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_980
	public RecuperaCodiceServizioSystemUnicoOutputDTO recuperaCodiceServizioSystemUnico(
			RecuperaCodiceServizioSystemUnicoInputDTO inputDto) throws IntegrationLayerException {

		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(recuperaCodInfoSysUnicoContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RecuperaCodiceServizioSystemUnicoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_995
	public VerificaOrdineVariazioneDowngradeFastWrapperOutputDTO verificaOrdineVariazioneDowngradeFast(
			VerificaOrdineVariazioneDowngradeFastInputDTO inputDto, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVerificaOrdineVariazioneDowngradeFastContextPath))
				&& (!isAuthorizedService(tipoProfilo, authVerificaOrdineVariazioneDowngradeFastContextPath,
						checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget()
				.path(verificaOrdineVariazioneDowngradeFastContextPath);

		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaOrdineVariazioneDowngradeFastWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1058
	public VisualizzaCampiOfferteVLANWrapperOutputDTO visualizzaCampiOfferteVLAN(
			VisualizzaCampiOfferteVLANInputDTO inputDto) throws IntegrationLayerException {
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(visualizzaCampiOfferteVLANContextPath)
				.queryParam(NOME_CAMPO, inputDto.getNomeCampo()).queryParam(VALORE_CAMPO, inputDto.getValoreCampo())
				.queryParam(CODICE_OLO_AGCOM, inputDto.getCodOloAgcom())
				.queryParam(ID_OFFERTA, inputDto.getIdOfferta());
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VisualizzaCampiOfferteVLANWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1058
	public VerificaKitAbilitatoNGAWrapperOutputDTO verificaKitAbilitatoNGA(VerificaKitAbilitatoNGAInputDTO inputDto)
			throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaCodiceTdKitContextPath)
				.queryParam(CODICE_TDKIT, inputDto.getCodiceTdKit())
				.queryParam(CODICE_FUNZIONE, inputDto.getCodiceFunzione());
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaKitAbilitatoNGAWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1058
	// #Task33535
	public RecuperaCampiOffertaVPWrapperOutputDTO recuperaCampiOffertaVP(RecuperaCampiOffertaVPInputDTO inputDto)
			throws IntegrationLayerException {
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaCampiOffertaVPContextPath)
				.queryParam(NOME_CAMPO, inputDto.getNomeCampo()).queryParam(VALORE_CAMPO, inputDto.getValoreCampo())
				.queryParam(MCR, inputDto.getMcr());
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperaCampiOffertaVPWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1058
	public VerificaCodiceTdKitWrapperOutputDTO verificaCodiceTdKit(VerificaCodiceTdKitInputDTO dto)
			throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaCodiceTdKitContextPath)
				.queryParam(CODICE_FUNZIONE, dto.getCodiceFunzione()).queryParam(CODICE_TDKIT, dto.getCodiceTdKit());
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaCodiceTdKitWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1058
	// SM_9723
	public VerificaModelloKitWrapperOutputDTO verificaModelloKit(VerificaModelloKitInputDTO inputDto)
			throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaModelloKitContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaModelloKitWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1058
	public RecuperaCARWrapperOutputDTO recuperaCar(RecuperaCARInputDTO inputDto) throws IntegrationLayerException {
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaCarContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RecuperaCARWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1058
	public RecuperaSubContractorWrapperOutputDTO recuperaSubContractor(String idRisorsa)
			throws IntegrationLayerException {
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaSubContractorContextPath)
				.queryParam(ID_RISORSA_VERIFICA_MODEM, idRisorsa);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperaSubContractorWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1058
	public RecuperaCodOloSubContractorWrapperOutputDTO recuperaCodOloSubContractor(String idRisorsa)
			throws IntegrationLayerException {
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaCodOloSubContractorContextPath)
				.queryParam(ID_RISORSA_VERIFICA_MODEM, idRisorsa);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperaCodOloSubContractorWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1060
	public VerificaComuneOffertaInfratelWrapperOutputDTO verificaComuneOffertaInfratel(
			VerificaComuneOffertaInfratelInputDTO inputDto) throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaComuneOffertaInfratelContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaComuneOffertaInfratelWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1089
	public VerificaCongruenzaClusterComuneVlanOutputDTO verificaCongruenzaClusterComuneVlan(
			VerificaCongruenzaClusterComuneVlanInputDTO inputDto) throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget()
				.path(verificaCongruenzaClusterComuneVlanContextPath);

		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaCongruenzaClusterComuneVlanOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1129
	public RecuperaProfiliFwaWrapperOutputDTO recuperaProfiliFwa(RecuperaProfiliFwaInputDTO inputDto)
			throws IntegrationLayerException {
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaProfiliFwaServiceContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RecuperaProfiliFwaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaTipologiaContrattoFwaWrapperOutputDTO verificaTipologiaContrattoFwa(
			VerificaTipologiaContrattoFwaInputDTO inputDto) throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaTipologiaContrattoFwaContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaTipologiaContrattoFwaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// SM_9825
	public RecuperaCodiciTdKitWrapperOutputDTO recuperaCodiciTdKit(RecuperaCodiciTdKitInputDTO inputDto)
			throws IntegrationLayerException {
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaCodiciTdKitContextPath);

		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RecuperaCodiciTdKitWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// SM_9825
	public VerificaModelloKitMadrWrapperOutputDTO verificaModelloKitMadr(String codiceTdKit)
			throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaModelloKitMadrContextPath);
		try {
			webTarget = webTarget.queryParam(CODICE_TDKIT, codiceTdKit);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaModelloKitMadrWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1150
	public RecuperaIdGponWrapperOutputDTO recuperaIdGpon(RecuperaIdGponInputDTO inputDto, String tipoProfilo)
			throws IntegrationLayerException {
		// RU_1274
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authRecuperaIdGponContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck

		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaIdGponContextPath);

		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RecuperaIdGponWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1166
	public RecuperaMacroAreaWrapperOutputDTO recuperaMacroArea(RecuperaMacroAreaInputDTO inputDto)
			throws IntegrationLayerException {
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaMacroAreaContextPath);

		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RecuperaMacroAreaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1164
	public VerificaContrattoCoinvestimentoComuneWrapperOutputDTO verificaContrattoCoinvestimentoComune(
			VerificaContrattoCoinvestimentoComuneInputDTO inputDto) throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget()
				.path(verificaContrattoCoinvestimentoComuneContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaContrattoCoinvestimentoComuneWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1180
	public VisualizzaCampiOfferteMulticastWrapperOutputDTO visualizzaCampiOfferteMulticast(
			VisualizzaCampiOfferteMulticastInputDTO inputDto) throws IntegrationLayerException {
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(visualizzaCampiOfferteMulticastContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VisualizzaCampiOfferteMulticastWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public VerificaAbilitazioneMulticastContrattoWrapperOutputDTO verificaAbilitazioneMcContratto(String codOloAgcom,
			String flagPrimoFeeder) throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget()
				.path(verificaAbilitazioneMulticastContrattoContextpath).path(codOloAgcom).path(flagPrimoFeeder);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaAbilitazioneMulticastContrattoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1181
	public VerificaRecuperoModemWrapperOutputDTO verificaRecuperoModem(String idAsset)
			throws IntegrationLayerException {
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaRecuperoModemContextpath)
				.queryParam(ID_ASSET, idAsset);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaRecuperoModemWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// R1I-21-0138
	public VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputDTO verificaCompatibilitaProfiloTecnicoLinea(
			VerificaCompatibilitaProfiloTecnicoLineaInputDTO inputDto, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVerificaCompatibilitaProfiloTecnicoLineaContextPath))
				&& (!isAuthorizedService(tipoProfilo, authVerificaCompatibilitaProfiloTecnicoLineaContextPath,
						checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget()
				.path(verificaCompatibilitaProfiloTecnicoLineaContextpath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaCompatibilitaProfiloTecnicoLineaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// R1F-20-0236.D
	public VerificaNoteOperatoreWrapperOutputDTO verificaNumeriNoteOperatore(VerificaNoteOperatoreInputDTO inputDto,
			String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVerificaNumeriNoteContextPath)) && (!isAuthorizedService(tipoProfilo,
				authVerificaNumeriNoteContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaNumeriNoteContextpath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaNoteOperatoreWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1270
	public VerificaProfiloTecnicoLineaX1X2WrapperOutputDTO verificaProfiloTecnicoLineaX1X2(String idOfferta,
			String profiloTecninoLinea, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVerificaProfiloTecnicoLineaX1X2Contextpath))
				&& (!isAuthorizedService(tipoProfilo, authVerificaProfiloTecnicoLineaX1X2Contextpath,
						checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaProfiloTecnicoLineaX1X2Contextpath)
				.queryParam(ID_OFFERTA, idOfferta).queryParam(PROFILO_TECNICO_LINEA, profiloTecninoLinea);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaProfiloTecnicoLineaX1X2WrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1335
	public VerificaIdRisorsaSwitchoffFwaWrapperOutputDTO verificaIdRisorsaSwitchoffContrattoFwa(String idRisorsa,
			String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVerificaIdRisorsaSwitchoffFwaContextpath)) && (!isAuthorizedService(tipoProfilo,
				authVerificaIdRisorsaSwitchoffFwaContextpath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaIdRisorsaSwitchoffFwaContextpath)
				.queryParam(ID_RISORSA_SWITCHOFF, idRisorsa);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaIdRisorsaSwitchoffFwaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1393
	public RecuperaCodiceSubAppaltoOutputDTO recuperaCodiceSubAppalto(RecuperaCodiceSubAppaltoInputDTO inputDto,
			String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authRecuperaCodiceSubappaltoContextpath)) && (!isAuthorizedService(tipoProfilo,
				authRecuperaCodiceSubappaltoContextpath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaCodiceSubappaltoContextpath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RecuperaCodiceSubAppaltoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public RecuperaCodiceSystemUnicoWrapperOutputDTO recuperaCodiceSystemUnico(
			RecuperaCodiceSystemUnicoInputDTO inputDto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authRecuperaCodiceSystemUnicoContextpath)) && (!isAuthorizedService(tipoProfilo,
				authRecuperaCodiceSystemUnicoContextpath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaCodiceSystemUnicoContextpath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RecuperaCodiceSystemUnicoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1428
	public RecuperaTipologiaImpresaOutputDTO recuperaTipologiaImpresa(RecuperaTipologiaImpresaInputDTO inputDto,
			String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authRecuperaTipologiaImpresaContextpath)) && (!isAuthorizedService(tipoProfilo,
				authRecuperaTipologiaImpresaContextpath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaTipologiaImpresaContextpath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(RecuperaTipologiaImpresaOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1485
	public RecuperaServiziOpzionaliAlternativiWrapperOutputDTO recuperaServiziOpzionaliAlternativi(
			String codiceProgetto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authRecuperaServiziOpzionaliAlternativiContextpath))
				&& (!isAuthorizedService(tipoProfilo, authRecuperaServiziOpzionaliAlternativiContextpath,
						checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaServiziOpzionaliAlternativiContextpath)
				.queryParam(CODICE_PROGETTO, codiceProgetto);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperaServiziOpzionaliAlternativiWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1502
	public EsitoDTO verificaSpostamentoVlan(VerificaSpostamentoVLANInputDTO inputDto, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVerificaSpostamentoVlanContextpath)) && (!isAuthorizedService(tipoProfilo,
				authVerificaSpostamentoVlanContextpath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaSpostamentoVlanContextpath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// SM_11483
	public EsitoDTO verificaCongruenzaDRGOfferta(VerificaCongruenzaDRGOffertaInputDTO inputDto, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVerificaCongruenzaDRGOffertaContextpath)) && (!isAuthorizedService(tipoProfilo,
				authVerificaCongruenzaDRGOffertaContextpath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaCongruenzaDRGOffertaContextpath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_XXXX
	public EsitoDTO verificaAttivazioneFullGponPlus(String codOloAgcom, String idRisorsaOld, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVerificaAttivazioneFullGponPlusContextpath))
				&& (!isAuthorizedService(tipoProfilo, authVerificaAttivazioneFullGponPlusContextpath,
						checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaAttivazioneFullGponPlusContextpath)
				.queryParam("codOloAgcom", codOloAgcom).queryParam("idRisorsaOld", idRisorsaOld);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1560 -> utility recupero codici operatore secondario
	public RecuperaCodiceOperatoreSecondarioWrapperOutputDTO getCodiceOperatoreSecondario(String codOloAgcom, String tipoProfilo) throws IntegrationLayerException {
		try {
			checkAuthorizationService(authGetCodOperatoreSecondarioContextPath, checkAuthorizationContextPath, tipoProfilo);
			// endCheck
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(getCodOperatoreSecondarioContextPath)
					.queryParam("codOloAgcom", codOloAgcom);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperaCodiceOperatoreSecondarioWrapperOutputDTO.class);
		}  catch (IntegrationLayerException e) {
			throw e;
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1560 -> C11M08F111
	public EsitoDTO verificaCodiceProgettoOneStepTLC8(String codServizio, String codProgetto, String tipoProfilo) throws IntegrationLayerException {
		try {
			checkAuthorizationService(authGetVerificaOneStepFTTHContextPath, checkAuthorizationContextPath, tipoProfilo);
			// endCheck
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(getVerificaOneStepFTTHContextPath)
					.queryParam("codServizio", codServizio).queryParam("codProgetto", codProgetto);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (IntegrationLayerException e) {
			throw e;
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1560 -> C11M08F112
	public EsitoDTO verificaSLABasePerONTOperatore(String idRisorsa, String slaAssurance, String tipoProfilo) throws IntegrationLayerException {
		try {
			checkAuthorizationService(authVerificaSlaBaseOntOperatoreContextPath, checkAuthorizationContextPath, tipoProfilo);
			// endCheck
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaSlaBaseOntOperatoreContextPath)
					.queryParam("idRisorsa", idRisorsa)
					.queryParam("SLAAssurance", slaAssurance);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (IntegrationLayerException e) {
			throw e;
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	// RU_1560 -> C11M08F113
	public EsitoDTO verificaAttivazioneFTTH(String codOloAgcom, String idRisorsaOld, String tipoProfilo) throws IntegrationLayerException {
		try {
			checkAuthorizationService(authVerificaAttivazioneFTTHContextPath, checkAuthorizationContextPath, tipoProfilo);
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaAttivazioneFTTHContextPath)
					.queryParam("codOloAgcom", codOloAgcom).queryParam("idRIsorsaOLD", idRisorsaOld);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1560 -> C11M08F114
	public EsitoDTO verificaMigrazioneFTTH(String idAsset, String offerta, String tipoProfilo) throws IntegrationLayerException {
		try {
			checkAuthorizationService(authVerificaMigrazioneFTTHContextPath, checkAuthorizationContextPath, tipoProfilo);
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaMigrazioneFTTHContextPath)
					.queryParam("idAsset", idAsset).queryParam("Offerta", offerta);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	// RU_1598
	public RecuperaClusterAccessoOutputDTO recuperaClusterAccesso() throws IntegrationLayerException {
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaClusterAccessoContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperaClusterAccessoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
