package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.contratto.ContrattoOutputBean;
import com.nttdata.tim.now.data.bean.idsluco.IdslucoOutputBean;
import com.nttdata.tim.now.data.bean.idullco.IdullcoOutputBean;
import com.nttdata.tim.now.data.bean.ordine.fiberstream.DatiServiziAggiuntiviInputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class CreazioneNuovoOrdineInputBean implements Serializable {

	private static final long serialVersionUID = 586069163928819867L;

	@JsonProperty("causale_ordine")
	private String causaleOrdine;

	@JsonProperty("oao")
	private String oao;

	@JsonProperty("codice_ordine")
	private String codiceOrdine;

	@JsonProperty("operatore")
	private String operatore;

	@JsonProperty("codice_ordine_padre")
	private String codiceOrdinePadre;

	@JsonProperty("idContratto")
	private Integer idContratto;

	@JsonProperty("idContrattoOfferta")
	private Integer idContrattoOfferta;

	@JsonProperty("note_da_operatore")
	private String noteDaOperatore;

	@JsonProperty("codice_progetto")
	private String codiceProgetto;

	@JsonProperty("codiceDelivery")
	private String codiceDelivery;

	@JsonProperty("codiceQualita")
	private String codiceQualita;

	@JsonProperty("tipo_modifica")
	private String tipoModifica;

	@JsonProperty("id_risorsa")
	private String idRisorsa;

	@JsonProperty("codiceSessione1")
	private String codiceSessione1;

	@JsonProperty("id_risorsa2")
	private String idRisorsa2;

	@JsonProperty("codiceSessione2")
	private String codiceSessione2;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dac")
	private String dac;

	@JsonProperty("flag_monitoraggio")
	private boolean flagMonitoraggio;

	@JsonProperty("flag_rientro")
	private boolean flagRientro;

	@JsonProperty("flagRientroVeloce")
	private boolean flagRientroVeloce;

	@JsonProperty("tipoRientro")
	private String tipoRientro;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataRicezioneRichiesta")
	private String dataRicezioneRichiesta;

	@JsonProperty("routingNumber")
	private String routingNumber;

	@JsonProperty("dn")
	private String dn;

	@JsonProperty("offertaCatalogo")
	private String offertaCatalogo;

	@JsonProperty("tipoVariazione")
	private String tipoVariazione;

	@JsonProperty("opzioneVariazione")
	private String opzioneVariazione;

	@JsonProperty("variazione")
	private String variazione;

	@JsonProperty("idullco")
	private IdullcoOutputBean idullco;

	@JsonProperty("visibilitaNP")
	private boolean flagNp;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dad")
	private String dad;

	@JsonProperty("fascia_oraria")
	private String fasciaOraria;

	@JsonProperty("num_verde_op_pt")
	private String numeroVerdeOperatorePT;

	@JsonProperty("num_verde_op_collaudo")
	private String numeroVerdeOperatoreCollaudo;

	@JsonProperty("centrale")
	private String centrale;

	@JsonProperty("codiceGAT")
	private String codiceGAT;

	@JsonProperty("dn_op_collaudo")
	private String dnOperatoreCollaudo;

	@JsonProperty("numero_richiesta_colocazione")
	private String numeroRichiestaColocazione;

	@JsonProperty("idsluco")
	private IdslucoOutputBean idsluco;

	@JsonProperty("idTicketTTM")
	private String idTicketTTM;

	@JsonProperty("mantenimentoProdotti")
	private String mantenimentoProdotti;

	@JsonProperty("stsDaAttivare")
	private String stsDaAttivare;

	@JsonProperty("stsDaCessare")
	private String stsDaCessare;

	@JsonProperty("numerazioneAggiuntiva")
	private List<String> numerazioneAggiuntiva;

	@JsonProperty("tipologiaAccesso")
	private String tipologiaAccesso;

	@JsonProperty("datiReferenti")
	private Map<String, DatiReferentiInputBean> datiReferenti = new HashMap<>();

	@JsonProperty("datiReferentiOnField")
	private DatiReferentiOnFieldInputBean datiReferentiOnField;

	@JsonProperty("datiClienteFinale")
	private DatiClienteFinaleInputBean datiClienteFinale;

	@JsonProperty("indirizzoDatiClienteFinale")
	private IndirizzoDatiClienteFinaleInputBean indirizzoDatiClienteFinale;

	@JsonProperty("attributiOfferta")
	private AttributiOffertaInputBean attributiOfferta;

	@JsonProperty("flagFob")
	private boolean flagFob;

	@JsonProperty("indicatoreFob")
	private String indicatoreFob;

	@JsonProperty("codiceIdentificativoLotto")
	private String codiceIdentificativoLotto;

	@JsonProperty("numeroLinea")
	private String numeroLinea;

	@JsonProperty("idRisorsaBTSNaked")
	private String idRisorsaBTSNaked;

	@JsonProperty("borchiaNT1Plus")
	private String borchiaNT1Plus;

	@JsonProperty("clirPermanente")
	private String clirPermanente;

	@JsonProperty("recapitoTelefonicoCliente")
	private String recapitoTelefonicoCliente;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataSottoscrizioneContratto")
	private String dataSottoscrizioneContratto;

	@JsonProperty("indicatoreDiScaffale")
	private boolean indicatoreDiScaffale;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataRichiestaColocazione")
	private String dataRichiestaColocazione;

	@JsonProperty("flagAggiuntivi")
	private boolean flagAggiuntivi;

	@JsonProperty("dnAggiuntive")
	private List<String> dnAggiuntive;

	@JsonProperty("idOfferta")
	private String idOfferta;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataUltimaModifica")
	private String dataUltimaModifica;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataCreazione")
	private String dataCreazione;

	@JsonProperty("flagMantenimentoSTS")
	private boolean flagMantenimentoSTS;

	@JsonProperty("flagNumerazioniAggiuntive")
	private String flagNumerazioniAggiuntive;

	@JsonProperty("aggiuntiviISDN")
	private String aggiuntiviISDN;

	@JsonProperty("flagOrdineUnico")
	private boolean flagOrdineUnico;
	
	@JsonProperty("codiceTrasloco")
	private String codiceTrasloco;
	
    @JsonProperty("prestazione")
    private String prestazione;

    @JsonProperty("oaoDonating1")
    private String oaoDonating1;
    
    @JsonProperty("oaoDonating2")
    private String oaoDonating2;

    @JsonProperty("flagModem")
    private boolean flagModem;
    
    @JsonProperty("dataDisponibilitaSede")
    private String dataDisponibilitaSede;

    @JsonProperty("tipoMigrazione")
    private String tipoMigrazione;

    @JsonProperty("idAsset")
    private String idAsset;

    @JsonProperty("opzioneDinamica")
    private boolean opzioneDinamica;
    
    // altri fields che non appartengono al DTO corrispondente
	@JsonProperty("offerDetails")
	private OffertaInputBean offerDetails;

	@JsonProperty("contratto")
	private ContrattoOutputBean contratto;
	
	//RU_886
	@JsonProperty("qualifica")
    private String qualifica;
	
	@JsonProperty("test2")
    private String test2;
	
	//RU_915
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataOrdine")
	private String dataOrdine;
	
	//RU_915
	@JsonProperty("opzioneTraffico")
    private String opzioneTraffico;
	
	//RU_915
	@JsonProperty("codiceCarrierOlo")
    private String codiceCarrierOlo;
	
	//RU_915
	@JsonProperty("flagReclamo")
    private boolean flagReclamo;
	
	//RU_915
	@JsonProperty("tipoLinea")
    private String tipoLinea;
	
	//RU_915
	@JsonProperty("strutturaLinea")
    private String strutturaLinea;
	
	//RU_915
	@JsonProperty("radicale")
    private String radicale;
	
	//RU_915
	@JsonProperty("quantitaLinee")
    private Integer quantitaLinee;
	
	//R1C-19-1212
	@JsonProperty("token")
    private String token;
	
	//RU_980
	@JsonProperty("datiServiziOpzionali")
	private List<DatiServiziOpzionaliInputBean> datiServiziOpzionali;
	
	//RU_980
	@JsonProperty("datiDisaggregazione")
	private DatiDisaggregazioneInputBean datiDisaggregazione;
	
	//RU_980
	@JsonProperty("datiAppuntamentoDisaggregazione")
	private DatiPresaAppuntamentoInputBean datiPresaAppuntamento;
	
	//RU_980
	@JsonProperty("datiPrestazioniAggiuntive")
	private DatiPrestazioniAggiuntiveInputBean datiPrestazioniAggiuntive;
		
	//RU_980
	@JsonProperty("datiSlaPlusSu")
	private DatiSlaPlusSuInputBean datiSlaPlusSu;
	
	//RU_1393
	@JsonProperty("datiGestioneAutonoma")
	private DatiGestioneAutonomaInputBean datiGestioneAutonoma;
	
	//RU_1485
	@JsonProperty("datiServiziOpzionaliAlternativi")
	private List<DatiServiziOpzionaliAlternativiInputBean> datiServiziOpzionaliAlternativi;
		
	//RU_1058
	@JsonProperty("codiceOrdineTIVlan")
    private String codiceOrdineTIVlan;
	
	//RU_1058
	@JsonProperty("codiceOrdineOloVlan")
    private String codiceOrdineOloVlan;
	
	//RU_1058
	@JsonProperty("codiceTDKit")
    private String codiceTDKit;
	
	//RU_1058
	@JsonProperty("clliCentrale")
    private String clliCentrale;
	
	//RU_1058
	@JsonProperty("idVlanOlo")
    private String idVlanOlo;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("drc")
	private String drc;
	
	//RU_1150
	@JsonProperty("coinvestimento")
    private String coinvestimento;
	
	//RU_1150
	@JsonProperty("idGpon")
    private String idGpon;
	
	//SM_10013
	@JsonProperty("profiloTecnicoLineaAsset")
	private String profiloTecnicoLineaAsset;
	
	//RU_1164
	@JsonProperty("flagOffertaSemi")
	private String flagOffertaSemi;
	
	@JsonProperty("idReteSecondariaOao")
	private String idReteSecondariaOao;
	
	//RU_1180
	@JsonProperty("datiOfferteMulticast")
	private DatiOfferteMulticastInputBean datiOfferteMulticast;
	
    //SM_10116
    @JsonProperty("whiteList")
    private String whiteList;
    
    //RU_1181
    @JsonProperty("statoRestituzioneProdotti")
    private String statoRestituzioneProdotti;
    
    //R1F-20-0236.B
    @JsonProperty("refOaoProgettiSpeciali")
    private String refOaoProgettiSpeciali;
    
    //RU_1462
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataPrevistaAttivazione")
	private String dataPrevistaAttivazione;
	
	//RU_1462
	@JsonProperty("datiServiziAggiuntivi")
	private List<DatiServiziAggiuntiviInputBean> datiServiziAggiuntivi;
	
	// RU_1560
	@JsonProperty("codOperatoreSecondario")
	private String codOperatoreSecondario;
	
	// RU_1598
	@JsonProperty("clusterAccesso")
	private String clusterAccesso;
	
	public String getCausaleOrdine() {
		return causaleOrdine;
	}

	public void setCausaleOrdine(String causaleOrdine) {
		this.causaleOrdine = causaleOrdine;
	}

	public String getOao() {
		return oao;
	}

	public void setOao(String oao) {
		this.oao = oao;
	}

	public String getCodiceOrdine() {
		return codiceOrdine;
	}

	public void setCodiceOrdine(String codiceOrdine) {
		this.codiceOrdine = codiceOrdine;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getCodiceOrdinePadre() {
		return codiceOrdinePadre;
	}

	public void setCodiceOrdinePadre(String codiceOrdinePadre) {
		this.codiceOrdinePadre = codiceOrdinePadre;
	}

	public Integer getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(Integer idContratto) {
		this.idContratto = idContratto;
	}

	public Integer getIdContrattoOfferta() {
		return idContrattoOfferta;
	}

	public void setIdContrattoOfferta(Integer idContrattoOfferta) {
		this.idContrattoOfferta = idContrattoOfferta;
	}

	public String getNoteDaOperatore() {
		return noteDaOperatore;
	}

	public void setNoteDaOperatore(String noteDaOperatore) {
		this.noteDaOperatore = noteDaOperatore;
	}

	public String getCodiceProgetto() {
		return codiceProgetto;
	}

	public void setCodiceProgetto(String codiceProgetto) {
		this.codiceProgetto = codiceProgetto;
	}

	public String getCodiceDelivery() {
		return codiceDelivery;
	}

	public void setCodiceDelivery(String codiceDelivery) {
		this.codiceDelivery = codiceDelivery;
	}

	public String getCodiceQualita() {
		return codiceQualita;
	}

	public void setCodiceQualita(String codiceQualita) {
		this.codiceQualita = codiceQualita;
	}

	public String getTipoModifica() {
		return tipoModifica;
	}

	public void setTipoModifica(String tipoModifica) {
		this.tipoModifica = tipoModifica;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getCodiceSessione1() {
		return codiceSessione1;
	}

	public void setCodiceSessione1(String codiceSessione1) {
		this.codiceSessione1 = codiceSessione1;
	}

	public String getIdRisorsa2() {
		return idRisorsa2;
	}

	public void setIdRisorsa2(String idRisorsa2) {
		this.idRisorsa2 = idRisorsa2;
	}

	public String getCodiceSessione2() {
		return codiceSessione2;
	}

	public void setCodiceSessione2(String codiceSessione2) {
		this.codiceSessione2 = codiceSessione2;
	}

	public String getDac() {
		return dac;
	}

	public void setDac(String dac) {
		this.dac = dac;
	}

	public boolean isFlagMonitoraggio() {
		return flagMonitoraggio;
	}

	public void setFlagMonitoraggio(boolean flagMonitoraggio) {
		this.flagMonitoraggio = flagMonitoraggio;
	}

	public boolean isFlagRientro() {
		return flagRientro;
	}

	public void setFlagRientro(boolean flagRientro) {
		this.flagRientro = flagRientro;
	}

	public boolean isFlagRientroVeloce() {
		return flagRientroVeloce;
	}

	public void setFlagRientroVeloce(boolean flagRientroVeloce) {
		this.flagRientroVeloce = flagRientroVeloce;
	}

	public String getTipoRientro() {
		return tipoRientro;
	}

	public void setTipoRientro(String tipoRientro) {
		this.tipoRientro = tipoRientro;
	}

	public String getDataRicezioneRichiesta() {
		return dataRicezioneRichiesta;
	}

	public void setDataRicezioneRichiesta(String dataRicezioneRichiesta) {
		this.dataRicezioneRichiesta = dataRicezioneRichiesta;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getOffertaCatalogo() {
		return offertaCatalogo;
	}

	public void setOffertaCatalogo(String offertaCatalogo) {
		this.offertaCatalogo = offertaCatalogo;
	}

	public String getTipoVariazione() {
		return tipoVariazione;
	}

	public void setTipoVariazione(String tipoVariazione) {
		this.tipoVariazione = tipoVariazione;
	}

	public String getOpzioneVariazione() {
		return opzioneVariazione;
	}

	public void setOpzioneVariazione(String opzioneVariazione) {
		this.opzioneVariazione = opzioneVariazione;
	}

	public String getVariazione() {
		return variazione;
	}

	public void setVariazione(String variazione) {
		this.variazione = variazione;
	}

	public IdullcoOutputBean getIdullco() {
		return idullco;
	}

	public void setIdullco(IdullcoOutputBean idullco) {
		this.idullco = idullco;
	}

	public boolean isFlagNp() {
		return flagNp;
	}

	public void setFlagNp(boolean flagNp) {
		this.flagNp = flagNp;
	}

	public String getDad() {
		return dad;
	}

	public void setDad(String dad) {
		this.dad = dad;
	}

	public String getFasciaOraria() {
		return fasciaOraria;
	}

	public void setFasciaOraria(String fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}

	public String getNumeroVerdeOperatorePT() {
		return numeroVerdeOperatorePT;
	}

	public void setNumeroVerdeOperatorePT(String numeroVerdeOperatorePT) {
		this.numeroVerdeOperatorePT = numeroVerdeOperatorePT;
	}

	public String getNumeroVerdeOperatoreCollaudo() {
		return numeroVerdeOperatoreCollaudo;
	}

	public void setNumeroVerdeOperatoreCollaudo(String numeroVerdeOperatoreCollaudo) {
		this.numeroVerdeOperatoreCollaudo = numeroVerdeOperatoreCollaudo;
	}

	public String getCentrale() {
		return centrale;
	}

	public void setCentrale(String centrale) {
		this.centrale = centrale;
	}

	public String getCodiceGAT() {
		return codiceGAT;
	}

	public void setCodiceGAT(String codiceGAT) {
		this.codiceGAT = codiceGAT;
	}

	public String getDnOperatoreCollaudo() {
		return dnOperatoreCollaudo;
	}

	public void setDnOperatoreCollaudo(String dnOperatoreCollaudo) {
		this.dnOperatoreCollaudo = dnOperatoreCollaudo;
	}

	public String getNumeroRichiestaColocazione() {
		return numeroRichiestaColocazione;
	}

	public void setNumeroRichiestaColocazione(String numeroRichiestaColocazione) {
		this.numeroRichiestaColocazione = numeroRichiestaColocazione;
	}

	public IdslucoOutputBean getIdsluco() {
		return idsluco;
	}

	public void setIdsluco(IdslucoOutputBean idsluco) {
		this.idsluco = idsluco;
	}

	public String getIdTicketTTM() {
		return idTicketTTM;
	}

	public void setIdTicketTTM(String idTicketTTM) {
		this.idTicketTTM = idTicketTTM;
	}

	public String getMantenimentoProdotti() {
		return mantenimentoProdotti;
	}

	public void setMantenimentoProdotti(String mantenimentoProdotti) {
		this.mantenimentoProdotti = mantenimentoProdotti;
	}

	public String getStsDaAttivare() {
		return stsDaAttivare;
	}

	public void setStsDaAttivare(String stsDaAttivare) {
		this.stsDaAttivare = stsDaAttivare;
	}

	public String getStsDaCessare() {
		return stsDaCessare;
	}

	public void setStsDaCessare(String stsDaCessare) {
		this.stsDaCessare = stsDaCessare;
	}

	public List<String> getNumerazioneAggiuntiva() {
		return numerazioneAggiuntiva;
	}

	public void setNumerazioneAggiuntiva(List<String> numerazioneAggiuntiva) {
		this.numerazioneAggiuntiva = numerazioneAggiuntiva;
	}

	public String getTipologiaAccesso() {
		return tipologiaAccesso;
	}

	public void setTipologiaAccesso(String tipologiaAccesso) {
		this.tipologiaAccesso = tipologiaAccesso;
	}

	public Map<String, DatiReferentiInputBean> getDatiReferenti() {
		return datiReferenti;
	}

	public void setDatiReferenti(Map<String, DatiReferentiInputBean> datiReferenti) {
		this.datiReferenti = datiReferenti;
	}

	public DatiReferentiOnFieldInputBean getDatiReferentiOnField() {
		return datiReferentiOnField;
	}

	public void setDatiReferentiOnField(DatiReferentiOnFieldInputBean datiReferentiOnField) {
		this.datiReferentiOnField = datiReferentiOnField;
	}

	public DatiClienteFinaleInputBean getDatiClienteFinale() {
		return datiClienteFinale;
	}

	public void setDatiClienteFinale(DatiClienteFinaleInputBean datiClienteFinale) {
		this.datiClienteFinale = datiClienteFinale;
	}

	public IndirizzoDatiClienteFinaleInputBean getIndirizzoDatiClienteFinale() {
		return indirizzoDatiClienteFinale;
	}

	public void setIndirizzoDatiClienteFinale(IndirizzoDatiClienteFinaleInputBean indirizzoDatiClienteFinale) {
		this.indirizzoDatiClienteFinale = indirizzoDatiClienteFinale;
	}

	public AttributiOffertaInputBean getAttributiOfferta() {
		return attributiOfferta;
	}

	public void setAttributiOfferta(AttributiOffertaInputBean attributiOfferta) {
		this.attributiOfferta = attributiOfferta;
	}

	public boolean isFlagFob() {
		return flagFob;
	}

	public void setFlagFob(boolean flagFob) {
		this.flagFob = flagFob;
	}

	public String getIndicatoreFob() {
		return indicatoreFob;
	}

	public void setIndicatoreFob(String indicatoreFob) {
		this.indicatoreFob = indicatoreFob;
	}

	public String getCodiceIdentificativoLotto() {
		return codiceIdentificativoLotto;
	}

	public void setCodiceIdentificativoLotto(String codiceIdentificativoLotto) {
		this.codiceIdentificativoLotto = codiceIdentificativoLotto;
	}

	public String getNumeroLinea() {
		return numeroLinea;
	}

	public void setNumeroLinea(String numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	public String getIdRisorsaBTSNaked() {
		return idRisorsaBTSNaked;
	}

	public void setIdRisorsaBTSNaked(String idRisorsaBTSNaked) {
		this.idRisorsaBTSNaked = idRisorsaBTSNaked;
	}

	public String getBorchiaNT1Plus() {
		return borchiaNT1Plus;
	}

	public void setBorchiaNT1Plus(String borchiaNT1Plus) {
		this.borchiaNT1Plus = borchiaNT1Plus;
	}

	public String getClirPermanente() {
		return clirPermanente;
	}

	public void setClirPermanente(String clirPermanente) {
		this.clirPermanente = clirPermanente;
	}

	public String getRecapitoTelefonicoCliente() {
		return recapitoTelefonicoCliente;
	}

	public void setRecapitoTelefonicoCliente(String recapitoTelefonicoCliente) {
		this.recapitoTelefonicoCliente = recapitoTelefonicoCliente;
	}

	public String getDataSottoscrizioneContratto() {
		return dataSottoscrizioneContratto;
	}

	public void setDataSottoscrizioneContratto(String dataSottoscrizioneContratto) {
		this.dataSottoscrizioneContratto = dataSottoscrizioneContratto;
	}

	public boolean isIndicatoreDiScaffale() {
		return indicatoreDiScaffale;
	}

	public void setIndicatoreDiScaffale(boolean indicatoreDiScaffale) {
		this.indicatoreDiScaffale = indicatoreDiScaffale;
	}

	public String getDataRichiestaColocazione() {
		return dataRichiestaColocazione;
	}

	public void setDataRichiestaColocazione(String dataRichiestaColocazione) {
		this.dataRichiestaColocazione = dataRichiestaColocazione;
	}

	public boolean isFlagAggiuntivi() {
		return flagAggiuntivi;
	}

	public void setFlagAggiuntivi(boolean flagAggiuntivi) {
		this.flagAggiuntivi = flagAggiuntivi;
	}

	public List<String> getDnAggiuntive() {
		return dnAggiuntive;
	}

	public void setDnAggiuntive(List<String> dnAggiuntive) {
		this.dnAggiuntive = dnAggiuntive;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(String dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public String getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public boolean isFlagMantenimentoSTS() {
		return flagMantenimentoSTS;
	}

	public void setFlagMantenimentoSTS(boolean flagMantenimentoSTS) {
		this.flagMantenimentoSTS = flagMantenimentoSTS;
	}

	public String getFlagNumerazioniAggiuntive() {
		return flagNumerazioniAggiuntive;
	}

	public void setFlagNumerazioniAggiuntive(String flagNumerazioniAggiuntive) {
		this.flagNumerazioniAggiuntive = flagNumerazioniAggiuntive;
	}

	public String getAggiuntiviISDN() {
		return aggiuntiviISDN;
	}

	public void setAggiuntiviISDN(String aggiuntiviISDN) {
		this.aggiuntiviISDN = aggiuntiviISDN;
	}

	public boolean isFlagOrdineUnico() {
		return flagOrdineUnico;
	}

	public void setFlagOrdineUnico(boolean flagOrdineUnico) {
		this.flagOrdineUnico = flagOrdineUnico;
	}

	public String getCodiceTrasloco() {
		return codiceTrasloco;
	}

	public void setCodiceTrasloco(String codiceTrasloco) {
		this.codiceTrasloco = codiceTrasloco;
	}

	public String getPrestazione() {
		return prestazione;
	}

	public void setPrestazione(String prestazione) {
		this.prestazione = prestazione;
	}

	public String getOaoDonating1() {
		return oaoDonating1;
	}

	public void setOaoDonating1(String oaoDonating1) {
		this.oaoDonating1 = oaoDonating1;
	}

	public String getOaoDonating2() {
		return oaoDonating2;
	}

	public void setOaoDonating2(String oaoDonating2) {
		this.oaoDonating2 = oaoDonating2;
	}

	public boolean isFlagModem() {
		return flagModem;
	}

	public void setFlagModem(boolean flagModem) {
		this.flagModem = flagModem;
	}

	public String getDataDisponibilitaSede() {
		return dataDisponibilitaSede;
	}

	public void setDataDisponibilitaSede(String dataDisponibilitaSede) {
		this.dataDisponibilitaSede = dataDisponibilitaSede;
	}

	public String getTipoMigrazione() {
		return tipoMigrazione;
	}

	public void setTipoMigrazione(String tipoMigrazione) {
		this.tipoMigrazione = tipoMigrazione;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public boolean isOpzioneDinamica() {
		return opzioneDinamica;
	}

	public void setOpzioneDinamica(boolean opzioneDinamica) {
		this.opzioneDinamica = opzioneDinamica;
	}

	public OffertaInputBean getOfferDetails() {
		return offerDetails;
	}

	public void setOfferDetails(OffertaInputBean offerDetails) {
		this.offerDetails = offerDetails;
	}

	public ContrattoOutputBean getContratto() {
		return contratto;
	}

	public void setContratto(ContrattoOutputBean contratto) {
		this.contratto = contratto;
	}

	public String getQualifica() {
		return qualifica;
	}

	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}

	public String getTest2() {
		return test2;
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}

	public String getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(String dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public String getOpzioneTraffico() {
		return opzioneTraffico;
	}

	public void setOpzioneTraffico(String opzioneTraffico) {
		this.opzioneTraffico = opzioneTraffico;
	}

	public String getCodiceCarrierOlo() {
		return codiceCarrierOlo;
	}

	public void setCodiceCarrierOlo(String codiceCarrierOlo) {
		this.codiceCarrierOlo = codiceCarrierOlo;
	}

	public boolean isFlagReclamo() {
		return flagReclamo;
	}

	public void setFlagReclamo(boolean flagReclamo) {
		this.flagReclamo = flagReclamo;
	}

	public String getTipoLinea() {
		return tipoLinea;
	}

	public void setTipoLinea(String tipoLinea) {
		this.tipoLinea = tipoLinea;
	}

	public String getStrutturaLinea() {
		return strutturaLinea;
	}

	public void setStrutturaLinea(String strutturaLinea) {
		this.strutturaLinea = strutturaLinea;
	}

	public String getRadicale() {
		return radicale;
	}

	public void setRadicale(String radicale) {
		this.radicale = radicale;
	}

	public Integer getQuantitaLinee() {
		return quantitaLinee;
	}

	public void setQuantitaLinee(Integer quantitaLinee) {
		this.quantitaLinee = quantitaLinee;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<DatiServiziOpzionaliInputBean> getDatiServiziOpzionali() {
		return datiServiziOpzionali;
	}

	public void setDatiServiziOpzionali(List<DatiServiziOpzionaliInputBean> datiServiziOpzionali) {
		this.datiServiziOpzionali = datiServiziOpzionali;
	}

	public DatiDisaggregazioneInputBean getDatiDisaggregazione() {
		return datiDisaggregazione;
	}

	public void setDatiDisaggregazione(DatiDisaggregazioneInputBean datiDisaggregazione) {
		this.datiDisaggregazione = datiDisaggregazione;
	}

	public DatiPresaAppuntamentoInputBean getDatiPresaAppuntamento() {
		return datiPresaAppuntamento;
	}

	public void setDatiPresaAppuntamento(DatiPresaAppuntamentoInputBean datiPresaAppuntamento) {
		this.datiPresaAppuntamento = datiPresaAppuntamento;
	}

	public DatiPrestazioniAggiuntiveInputBean getDatiPrestazioniAggiuntive() {
		return datiPrestazioniAggiuntive;
	}

	public void setDatiPrestazioniAggiuntive(DatiPrestazioniAggiuntiveInputBean datiPrestazioniAggiuntive) {
		this.datiPrestazioniAggiuntive = datiPrestazioniAggiuntive;
	}

	public DatiSlaPlusSuInputBean getDatiSlaPlusSu() {
		return datiSlaPlusSu;
	}

	public void setDatiSlaPlusSu(DatiSlaPlusSuInputBean datiSlaPlusSu) {
		this.datiSlaPlusSu = datiSlaPlusSu;
	}

	public DatiGestioneAutonomaInputBean getDatiGestioneAutonoma() {
		return datiGestioneAutonoma;
	}

	public void setDatiGestioneAutonoma(DatiGestioneAutonomaInputBean datiGestioneAutonoma) {
		this.datiGestioneAutonoma = datiGestioneAutonoma;
	}

	public List<DatiServiziOpzionaliAlternativiInputBean> getDatiServiziOpzionaliAlternativi() {
		return datiServiziOpzionaliAlternativi;
	}

	public void setDatiServiziOpzionaliAlternativi(
			List<DatiServiziOpzionaliAlternativiInputBean> datiServiziOpzionaliAlternativi) {
		this.datiServiziOpzionaliAlternativi = datiServiziOpzionaliAlternativi;
	}

	public String getCodiceTDKit() {
		return codiceTDKit;
	}

	public void setCodiceTDKit(String codiceTDKit) {
		this.codiceTDKit = codiceTDKit;
	}

	public String getClliCentrale() {
		return clliCentrale;
	}

	public void setClliCentrale(String clliCentrale) {
		this.clliCentrale = clliCentrale;
	}

	public String getIdVlanOlo() {
		return idVlanOlo;
	}

	public void setIdVlanOlo(String idVlanOlo) {
		this.idVlanOlo = idVlanOlo;
	}

	public String getCodiceOrdineTIVlan() {
		return codiceOrdineTIVlan;
	}

	public void setCodiceOrdineTIVlan(String codiceOrdineTIVlan) {
		this.codiceOrdineTIVlan = codiceOrdineTIVlan;
	}

	public String getCodiceOrdineOloVlan() {
		return codiceOrdineOloVlan;
	}

	public void setCodiceOrdineOloVlan(String codiceOrdineOloVlan) {
		this.codiceOrdineOloVlan = codiceOrdineOloVlan;
	}

	public String getDrc() {
		return drc;
	}

	public void setDrc(String drc) {
		this.drc = drc;
	}

	public String getCoinvestimento() {
		return coinvestimento;
	}

	public void setCoinvestimento(String coinvestimento) {
		this.coinvestimento = coinvestimento;
	}

	public String getIdGpon() {
		return idGpon;
	}

	public void setIdGpon(String idGpon) {
		this.idGpon = idGpon;
	}

	public String getProfiloTecnicoLineaAsset() {
		return profiloTecnicoLineaAsset;
	}

	public void setProfiloTecnicoLineaAsset(String profiloTecnicoLineaAsset) {
		this.profiloTecnicoLineaAsset = profiloTecnicoLineaAsset;
	}

	public String getFlagOffertaSemi() {
		return flagOffertaSemi;
	}

	public void setFlagOffertaSemi(String flagOffertaSemi) {
		this.flagOffertaSemi = flagOffertaSemi;
	}

	public String getIdReteSecondariaOao() {
		return idReteSecondariaOao;
	}

	public void setIdReteSecondariaOao(String idReteSecondariaOao) {
		this.idReteSecondariaOao = idReteSecondariaOao;
	}

	public DatiOfferteMulticastInputBean getDatiOfferteMulticast() {
		return datiOfferteMulticast;
	}

	public void setDatiOfferteMulticast(DatiOfferteMulticastInputBean datiOfferteMulticast) {
		this.datiOfferteMulticast = datiOfferteMulticast;
	}

	public String getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(String whiteList) {
		this.whiteList = whiteList;
	}

	public String getStatoRestituzioneProdotti() {
		return statoRestituzioneProdotti;
	}

	public void setStatoRestituzioneProdotti(String statoRestituzioneProdotti) {
		this.statoRestituzioneProdotti = statoRestituzioneProdotti;
	}

	public String getRefOaoProgettiSpeciali() {
		return refOaoProgettiSpeciali;
	}

	public void setRefOaoProgettiSpeciali(String refOaoProgettiSpeciali) {
		this.refOaoProgettiSpeciali = refOaoProgettiSpeciali;
	}

	public String getDataPrevistaAttivazione() {
		return dataPrevistaAttivazione;
	}

	public void setDataPrevistaAttivazione(String dataPrevistaAttivazione) {
		this.dataPrevistaAttivazione = dataPrevistaAttivazione;
	}

	public List<DatiServiziAggiuntiviInputBean> getDatiServiziAggiuntivi() {
		return datiServiziAggiuntivi;
	}

	public void setDatiServiziAggiuntivi(List<DatiServiziAggiuntiviInputBean> datiServiziAggiuntivi) {
		this.datiServiziAggiuntivi = datiServiziAggiuntivi;
	}
	
	public String getCodOperatoreSecondario() {
		return this.codOperatoreSecondario;
	}
	
	public void setCodOperatoreSecondario(String codOperatoreSecondario) {
		this.codOperatoreSecondario = codOperatoreSecondario;
	}
	
	public String getClusterAccesso() {
		return this.clusterAccesso;
	}
	
	public void setClusterAccesso(String clusterAccesso) {
		this.clusterAccesso = clusterAccesso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aggiuntiviISDN == null) ? 0 : aggiuntiviISDN.hashCode());
		result = prime * result + ((attributiOfferta == null) ? 0 : attributiOfferta.hashCode());
		result = prime * result + ((borchiaNT1Plus == null) ? 0 : borchiaNT1Plus.hashCode());
		result = prime * result + ((causaleOrdine == null) ? 0 : causaleOrdine.hashCode());
		result = prime * result + ((centrale == null) ? 0 : centrale.hashCode());
		result = prime * result + ((clirPermanente == null) ? 0 : clirPermanente.hashCode());
		result = prime * result + ((clliCentrale == null) ? 0 : clliCentrale.hashCode());
		result = prime * result + ((codiceCarrierOlo == null) ? 0 : codiceCarrierOlo.hashCode());
		result = prime * result + ((codiceDelivery == null) ? 0 : codiceDelivery.hashCode());
		result = prime * result + ((codiceGAT == null) ? 0 : codiceGAT.hashCode());
		result = prime * result + ((codiceIdentificativoLotto == null) ? 0 : codiceIdentificativoLotto.hashCode());
		result = prime * result + ((codiceOrdine == null) ? 0 : codiceOrdine.hashCode());
		result = prime * result + ((codiceOrdineOloVlan == null) ? 0 : codiceOrdineOloVlan.hashCode());
		result = prime * result + ((codiceOrdinePadre == null) ? 0 : codiceOrdinePadre.hashCode());
		result = prime * result + ((codiceOrdineTIVlan == null) ? 0 : codiceOrdineTIVlan.hashCode());
		result = prime * result + ((codiceProgetto == null) ? 0 : codiceProgetto.hashCode());
		result = prime * result + ((codiceQualita == null) ? 0 : codiceQualita.hashCode());
		result = prime * result + ((codiceSessione1 == null) ? 0 : codiceSessione1.hashCode());
		result = prime * result + ((codiceSessione2 == null) ? 0 : codiceSessione2.hashCode());
		result = prime * result + ((codiceTDKit == null) ? 0 : codiceTDKit.hashCode());
		result = prime * result + ((codiceTrasloco == null) ? 0 : codiceTrasloco.hashCode());
		result = prime * result + ((coinvestimento == null) ? 0 : coinvestimento.hashCode());
		result = prime * result + ((contratto == null) ? 0 : contratto.hashCode());
		result = prime * result + ((dac == null) ? 0 : dac.hashCode());
		result = prime * result + ((dad == null) ? 0 : dad.hashCode());
		result = prime * result + ((dataCreazione == null) ? 0 : dataCreazione.hashCode());
		result = prime * result + ((dataDisponibilitaSede == null) ? 0 : dataDisponibilitaSede.hashCode());
		result = prime * result + ((dataOrdine == null) ? 0 : dataOrdine.hashCode());
		result = prime * result + ((dataRicezioneRichiesta == null) ? 0 : dataRicezioneRichiesta.hashCode());
		result = prime * result + ((dataRichiestaColocazione == null) ? 0 : dataRichiestaColocazione.hashCode());
		result = prime * result + ((dataSottoscrizioneContratto == null) ? 0 : dataSottoscrizioneContratto.hashCode());
		result = prime * result + ((dataUltimaModifica == null) ? 0 : dataUltimaModifica.hashCode());
		result = prime * result + ((datiClienteFinale == null) ? 0 : datiClienteFinale.hashCode());
		result = prime * result + ((datiDisaggregazione == null) ? 0 : datiDisaggregazione.hashCode());
		result = prime * result + ((datiOfferteMulticast == null) ? 0 : datiOfferteMulticast.hashCode());
		result = prime * result + ((datiPresaAppuntamento == null) ? 0 : datiPresaAppuntamento.hashCode());
		result = prime * result + ((datiPrestazioniAggiuntive == null) ? 0 : datiPrestazioniAggiuntive.hashCode());
		result = prime * result + ((datiReferenti == null) ? 0 : datiReferenti.hashCode());
		result = prime * result + ((datiReferentiOnField == null) ? 0 : datiReferentiOnField.hashCode());
		result = prime * result + ((datiServiziOpzionali == null) ? 0 : datiServiziOpzionali.hashCode());
		result = prime * result + ((datiSlaPlusSu == null) ? 0 : datiSlaPlusSu.hashCode());
		result = prime * result + ((dn == null) ? 0 : dn.hashCode());
		result = prime * result + ((dnAggiuntive == null) ? 0 : dnAggiuntive.hashCode());
		result = prime * result + ((dnOperatoreCollaudo == null) ? 0 : dnOperatoreCollaudo.hashCode());
		result = prime * result + ((drc == null) ? 0 : drc.hashCode());
		result = prime * result + ((fasciaOraria == null) ? 0 : fasciaOraria.hashCode());
		result = prime * result + (flagAggiuntivi ? 1231 : 1237);
		result = prime * result + (flagFob ? 1231 : 1237);
		result = prime * result + (flagMantenimentoSTS ? 1231 : 1237);
		result = prime * result + (flagModem ? 1231 : 1237);
		result = prime * result + (flagMonitoraggio ? 1231 : 1237);
		result = prime * result + (flagNp ? 1231 : 1237);
		result = prime * result + ((flagNumerazioniAggiuntive == null) ? 0 : flagNumerazioniAggiuntive.hashCode());
		result = prime * result + ((flagOffertaSemi == null) ? 0 : flagOffertaSemi.hashCode());
		result = prime * result + (flagOrdineUnico ? 1231 : 1237);
		result = prime * result + (flagReclamo ? 1231 : 1237);
		result = prime * result + (flagRientro ? 1231 : 1237);
		result = prime * result + (flagRientroVeloce ? 1231 : 1237);
		result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
		result = prime * result + ((idContratto == null) ? 0 : idContratto.hashCode());
		result = prime * result + ((idContrattoOfferta == null) ? 0 : idContrattoOfferta.hashCode());
		result = prime * result + ((idGpon == null) ? 0 : idGpon.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((idReteSecondariaOao == null) ? 0 : idReteSecondariaOao.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((idRisorsa2 == null) ? 0 : idRisorsa2.hashCode());
		result = prime * result + ((idRisorsaBTSNaked == null) ? 0 : idRisorsaBTSNaked.hashCode());
		result = prime * result + ((idTicketTTM == null) ? 0 : idTicketTTM.hashCode());
		result = prime * result + ((idVlanOlo == null) ? 0 : idVlanOlo.hashCode());
		result = prime * result + ((idsluco == null) ? 0 : idsluco.hashCode());
		result = prime * result + ((idullco == null) ? 0 : idullco.hashCode());
		result = prime * result + (indicatoreDiScaffale ? 1231 : 1237);
		result = prime * result + ((indicatoreFob == null) ? 0 : indicatoreFob.hashCode());
		result = prime * result + ((indirizzoDatiClienteFinale == null) ? 0 : indirizzoDatiClienteFinale.hashCode());
		result = prime * result + ((mantenimentoProdotti == null) ? 0 : mantenimentoProdotti.hashCode());
		result = prime * result + ((noteDaOperatore == null) ? 0 : noteDaOperatore.hashCode());
		result = prime * result + ((numerazioneAggiuntiva == null) ? 0 : numerazioneAggiuntiva.hashCode());
		result = prime * result + ((numeroLinea == null) ? 0 : numeroLinea.hashCode());
		result = prime * result + ((numeroRichiestaColocazione == null) ? 0 : numeroRichiestaColocazione.hashCode());
		result = prime * result
				+ ((numeroVerdeOperatoreCollaudo == null) ? 0 : numeroVerdeOperatoreCollaudo.hashCode());
		result = prime * result + ((numeroVerdeOperatorePT == null) ? 0 : numeroVerdeOperatorePT.hashCode());
		result = prime * result + ((oao == null) ? 0 : oao.hashCode());
		result = prime * result + ((oaoDonating1 == null) ? 0 : oaoDonating1.hashCode());
		result = prime * result + ((oaoDonating2 == null) ? 0 : oaoDonating2.hashCode());
		result = prime * result + ((offerDetails == null) ? 0 : offerDetails.hashCode());
		result = prime * result + ((offertaCatalogo == null) ? 0 : offertaCatalogo.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		result = prime * result + (opzioneDinamica ? 1231 : 1237);
		result = prime * result + ((opzioneTraffico == null) ? 0 : opzioneTraffico.hashCode());
		result = prime * result + ((opzioneVariazione == null) ? 0 : opzioneVariazione.hashCode());
		result = prime * result + ((prestazione == null) ? 0 : prestazione.hashCode());
		result = prime * result + ((profiloTecnicoLineaAsset == null) ? 0 : profiloTecnicoLineaAsset.hashCode());
		result = prime * result + ((qualifica == null) ? 0 : qualifica.hashCode());
		result = prime * result + ((quantitaLinee == null) ? 0 : quantitaLinee.hashCode());
		result = prime * result + ((radicale == null) ? 0 : radicale.hashCode());
		result = prime * result + ((recapitoTelefonicoCliente == null) ? 0 : recapitoTelefonicoCliente.hashCode());
		result = prime * result + ((refOaoProgettiSpeciali == null) ? 0 : refOaoProgettiSpeciali.hashCode());
		result = prime * result + ((routingNumber == null) ? 0 : routingNumber.hashCode());
		result = prime * result + ((statoRestituzioneProdotti == null) ? 0 : statoRestituzioneProdotti.hashCode());
		result = prime * result + ((strutturaLinea == null) ? 0 : strutturaLinea.hashCode());
		result = prime * result + ((stsDaAttivare == null) ? 0 : stsDaAttivare.hashCode());
		result = prime * result + ((stsDaCessare == null) ? 0 : stsDaCessare.hashCode());
		result = prime * result + ((test2 == null) ? 0 : test2.hashCode());
		result = prime * result + ((tipoLinea == null) ? 0 : tipoLinea.hashCode());
		result = prime * result + ((tipoMigrazione == null) ? 0 : tipoMigrazione.hashCode());
		result = prime * result + ((tipoModifica == null) ? 0 : tipoModifica.hashCode());
		result = prime * result + ((tipoRientro == null) ? 0 : tipoRientro.hashCode());
		result = prime * result + ((tipoVariazione == null) ? 0 : tipoVariazione.hashCode());
		result = prime * result + ((tipologiaAccesso == null) ? 0 : tipologiaAccesso.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((variazione == null) ? 0 : variazione.hashCode());
		result = prime * result + ((whiteList == null) ? 0 : whiteList.hashCode());
		result = prime * result + ((codOperatoreSecondario == null) ? 0 : codOperatoreSecondario.hashCode());
		result = prime * result + ((clusterAccesso == null) ? 0 : clusterAccesso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreazioneNuovoOrdineInputBean other = (CreazioneNuovoOrdineInputBean) obj;
		if (aggiuntiviISDN == null) {
			if (other.aggiuntiviISDN != null)
				return false;
		} else if (!aggiuntiviISDN.equals(other.aggiuntiviISDN))
			return false;
		if (attributiOfferta == null) {
			if (other.attributiOfferta != null)
				return false;
		} else if (!attributiOfferta.equals(other.attributiOfferta))
			return false;
		if (borchiaNT1Plus == null) {
			if (other.borchiaNT1Plus != null)
				return false;
		} else if (!borchiaNT1Plus.equals(other.borchiaNT1Plus))
			return false;
		if (causaleOrdine == null) {
			if (other.causaleOrdine != null)
				return false;
		} else if (!causaleOrdine.equals(other.causaleOrdine))
			return false;
		if (centrale == null) {
			if (other.centrale != null)
				return false;
		} else if (!centrale.equals(other.centrale))
			return false;
		if (clirPermanente == null) {
			if (other.clirPermanente != null)
				return false;
		} else if (!clirPermanente.equals(other.clirPermanente))
			return false;
		if (clliCentrale == null) {
			if (other.clliCentrale != null)
				return false;
		} else if (!clliCentrale.equals(other.clliCentrale))
			return false;
		if (codiceCarrierOlo == null) {
			if (other.codiceCarrierOlo != null)
				return false;
		} else if (!codiceCarrierOlo.equals(other.codiceCarrierOlo))
			return false;
		if (codiceDelivery == null) {
			if (other.codiceDelivery != null)
				return false;
		} else if (!codiceDelivery.equals(other.codiceDelivery))
			return false;
		if (codiceGAT == null) {
			if (other.codiceGAT != null)
				return false;
		} else if (!codiceGAT.equals(other.codiceGAT))
			return false;
		if (codiceIdentificativoLotto == null) {
			if (other.codiceIdentificativoLotto != null)
				return false;
		} else if (!codiceIdentificativoLotto.equals(other.codiceIdentificativoLotto))
			return false;
		if (codiceOrdine == null) {
			if (other.codiceOrdine != null)
				return false;
		} else if (!codiceOrdine.equals(other.codiceOrdine))
			return false;
		if (codiceOrdineOloVlan == null) {
			if (other.codiceOrdineOloVlan != null)
				return false;
		} else if (!codiceOrdineOloVlan.equals(other.codiceOrdineOloVlan))
			return false;
		if (codiceOrdinePadre == null) {
			if (other.codiceOrdinePadre != null)
				return false;
		} else if (!codiceOrdinePadre.equals(other.codiceOrdinePadre))
			return false;
		if (codiceOrdineTIVlan == null) {
			if (other.codiceOrdineTIVlan != null)
				return false;
		} else if (!codiceOrdineTIVlan.equals(other.codiceOrdineTIVlan))
			return false;
		if (codiceProgetto == null) {
			if (other.codiceProgetto != null)
				return false;
		} else if (!codiceProgetto.equals(other.codiceProgetto))
			return false;
		if (codiceQualita == null) {
			if (other.codiceQualita != null)
				return false;
		} else if (!codiceQualita.equals(other.codiceQualita))
			return false;
		if (codiceSessione1 == null) {
			if (other.codiceSessione1 != null)
				return false;
		} else if (!codiceSessione1.equals(other.codiceSessione1))
			return false;
		if (codiceSessione2 == null) {
			if (other.codiceSessione2 != null)
				return false;
		} else if (!codiceSessione2.equals(other.codiceSessione2))
			return false;
		if (codiceTDKit == null) {
			if (other.codiceTDKit != null)
				return false;
		} else if (!codiceTDKit.equals(other.codiceTDKit))
			return false;
		if (codiceTrasloco == null) {
			if (other.codiceTrasloco != null)
				return false;
		} else if (!codiceTrasloco.equals(other.codiceTrasloco))
			return false;
		if (coinvestimento == null) {
			if (other.coinvestimento != null)
				return false;
		} else if (!coinvestimento.equals(other.coinvestimento))
			return false;
		if (contratto == null) {
			if (other.contratto != null)
				return false;
		} else if (!contratto.equals(other.contratto))
			return false;
		if (dac == null) {
			if (other.dac != null)
				return false;
		} else if (!dac.equals(other.dac))
			return false;
		if (dad == null) {
			if (other.dad != null)
				return false;
		} else if (!dad.equals(other.dad))
			return false;
		if (dataCreazione == null) {
			if (other.dataCreazione != null)
				return false;
		} else if (!dataCreazione.equals(other.dataCreazione))
			return false;
		if (dataDisponibilitaSede == null) {
			if (other.dataDisponibilitaSede != null)
				return false;
		} else if (!dataDisponibilitaSede.equals(other.dataDisponibilitaSede))
			return false;
		if (dataOrdine == null) {
			if (other.dataOrdine != null)
				return false;
		} else if (!dataOrdine.equals(other.dataOrdine))
			return false;
		if (dataRicezioneRichiesta == null) {
			if (other.dataRicezioneRichiesta != null)
				return false;
		} else if (!dataRicezioneRichiesta.equals(other.dataRicezioneRichiesta))
			return false;
		if (dataRichiestaColocazione == null) {
			if (other.dataRichiestaColocazione != null)
				return false;
		} else if (!dataRichiestaColocazione.equals(other.dataRichiestaColocazione))
			return false;
		if (dataSottoscrizioneContratto == null) {
			if (other.dataSottoscrizioneContratto != null)
				return false;
		} else if (!dataSottoscrizioneContratto.equals(other.dataSottoscrizioneContratto))
			return false;
		if (dataUltimaModifica == null) {
			if (other.dataUltimaModifica != null)
				return false;
		} else if (!dataUltimaModifica.equals(other.dataUltimaModifica))
			return false;
		if (datiClienteFinale == null) {
			if (other.datiClienteFinale != null)
				return false;
		} else if (!datiClienteFinale.equals(other.datiClienteFinale))
			return false;
		if (datiDisaggregazione == null) {
			if (other.datiDisaggregazione != null)
				return false;
		} else if (!datiDisaggregazione.equals(other.datiDisaggregazione))
			return false;
		if (datiOfferteMulticast == null) {
			if (other.datiOfferteMulticast != null)
				return false;
		} else if (!datiOfferteMulticast.equals(other.datiOfferteMulticast))
			return false;
		if (datiPresaAppuntamento == null) {
			if (other.datiPresaAppuntamento != null)
				return false;
		} else if (!datiPresaAppuntamento.equals(other.datiPresaAppuntamento))
			return false;
		if (datiPrestazioniAggiuntive == null) {
			if (other.datiPrestazioniAggiuntive != null)
				return false;
		} else if (!datiPrestazioniAggiuntive.equals(other.datiPrestazioniAggiuntive))
			return false;
		if (datiReferenti == null) {
			if (other.datiReferenti != null)
				return false;
		} else if (!datiReferenti.equals(other.datiReferenti))
			return false;
		if (datiReferentiOnField == null) {
			if (other.datiReferentiOnField != null)
				return false;
		} else if (!datiReferentiOnField.equals(other.datiReferentiOnField))
			return false;
		if (datiServiziOpzionali == null) {
			if (other.datiServiziOpzionali != null)
				return false;
		} else if (!datiServiziOpzionali.equals(other.datiServiziOpzionali))
			return false;
		if (datiSlaPlusSu == null) {
			if (other.datiSlaPlusSu != null)
				return false;
		} else if (!datiSlaPlusSu.equals(other.datiSlaPlusSu))
			return false;
		if (dn == null) {
			if (other.dn != null)
				return false;
		} else if (!dn.equals(other.dn))
			return false;
		if (dnAggiuntive == null) {
			if (other.dnAggiuntive != null)
				return false;
		} else if (!dnAggiuntive.equals(other.dnAggiuntive))
			return false;
		if (dnOperatoreCollaudo == null) {
			if (other.dnOperatoreCollaudo != null)
				return false;
		} else if (!dnOperatoreCollaudo.equals(other.dnOperatoreCollaudo))
			return false;
		if (drc == null) {
			if (other.drc != null)
				return false;
		} else if (!drc.equals(other.drc))
			return false;
		if (fasciaOraria == null) {
			if (other.fasciaOraria != null)
				return false;
		} else if (!fasciaOraria.equals(other.fasciaOraria))
			return false;
		if (flagAggiuntivi != other.flagAggiuntivi)
			return false;
		if (flagFob != other.flagFob)
			return false;
		if (flagMantenimentoSTS != other.flagMantenimentoSTS)
			return false;
		if (flagModem != other.flagModem)
			return false;
		if (flagMonitoraggio != other.flagMonitoraggio)
			return false;
		if (flagNp != other.flagNp)
			return false;
		if (flagNumerazioniAggiuntive == null) {
			if (other.flagNumerazioniAggiuntive != null)
				return false;
		} else if (!flagNumerazioniAggiuntive.equals(other.flagNumerazioniAggiuntive))
			return false;
		if (flagOffertaSemi == null) {
			if (other.flagOffertaSemi != null)
				return false;
		} else if (!flagOffertaSemi.equals(other.flagOffertaSemi))
			return false;
		if (flagOrdineUnico != other.flagOrdineUnico)
			return false;
		if (flagReclamo != other.flagReclamo)
			return false;
		if (flagRientro != other.flagRientro)
			return false;
		if (flagRientroVeloce != other.flagRientroVeloce)
			return false;
		if (idAsset == null) {
			if (other.idAsset != null)
				return false;
		} else if (!idAsset.equals(other.idAsset))
			return false;
		if (idContratto == null) {
			if (other.idContratto != null)
				return false;
		} else if (!idContratto.equals(other.idContratto))
			return false;
		if (idContrattoOfferta == null) {
			if (other.idContrattoOfferta != null)
				return false;
		} else if (!idContrattoOfferta.equals(other.idContrattoOfferta))
			return false;
		if (idGpon == null) {
			if (other.idGpon != null)
				return false;
		} else if (!idGpon.equals(other.idGpon))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (idReteSecondariaOao == null) {
			if (other.idReteSecondariaOao != null)
				return false;
		} else if (!idReteSecondariaOao.equals(other.idReteSecondariaOao))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (idRisorsa2 == null) {
			if (other.idRisorsa2 != null)
				return false;
		} else if (!idRisorsa2.equals(other.idRisorsa2))
			return false;
		if (idRisorsaBTSNaked == null) {
			if (other.idRisorsaBTSNaked != null)
				return false;
		} else if (!idRisorsaBTSNaked.equals(other.idRisorsaBTSNaked))
			return false;
		if (idTicketTTM == null) {
			if (other.idTicketTTM != null)
				return false;
		} else if (!idTicketTTM.equals(other.idTicketTTM))
			return false;
		if (idVlanOlo == null) {
			if (other.idVlanOlo != null)
				return false;
		} else if (!idVlanOlo.equals(other.idVlanOlo))
			return false;
		if (idsluco == null) {
			if (other.idsluco != null)
				return false;
		} else if (!idsluco.equals(other.idsluco))
			return false;
		if (idullco == null) {
			if (other.idullco != null)
				return false;
		} else if (!idullco.equals(other.idullco))
			return false;
		if (indicatoreDiScaffale != other.indicatoreDiScaffale)
			return false;
		if (indicatoreFob == null) {
			if (other.indicatoreFob != null)
				return false;
		} else if (!indicatoreFob.equals(other.indicatoreFob))
			return false;
		if (indirizzoDatiClienteFinale == null) {
			if (other.indirizzoDatiClienteFinale != null)
				return false;
		} else if (!indirizzoDatiClienteFinale.equals(other.indirizzoDatiClienteFinale))
			return false;
		if (mantenimentoProdotti == null) {
			if (other.mantenimentoProdotti != null)
				return false;
		} else if (!mantenimentoProdotti.equals(other.mantenimentoProdotti))
			return false;
		if (noteDaOperatore == null) {
			if (other.noteDaOperatore != null)
				return false;
		} else if (!noteDaOperatore.equals(other.noteDaOperatore))
			return false;
		if (numerazioneAggiuntiva == null) {
			if (other.numerazioneAggiuntiva != null)
				return false;
		} else if (!numerazioneAggiuntiva.equals(other.numerazioneAggiuntiva))
			return false;
		if (numeroLinea == null) {
			if (other.numeroLinea != null)
				return false;
		} else if (!numeroLinea.equals(other.numeroLinea))
			return false;
		if (numeroRichiestaColocazione == null) {
			if (other.numeroRichiestaColocazione != null)
				return false;
		} else if (!numeroRichiestaColocazione.equals(other.numeroRichiestaColocazione))
			return false;
		if (numeroVerdeOperatoreCollaudo == null) {
			if (other.numeroVerdeOperatoreCollaudo != null)
				return false;
		} else if (!numeroVerdeOperatoreCollaudo.equals(other.numeroVerdeOperatoreCollaudo))
			return false;
		if (numeroVerdeOperatorePT == null) {
			if (other.numeroVerdeOperatorePT != null)
				return false;
		} else if (!numeroVerdeOperatorePT.equals(other.numeroVerdeOperatorePT))
			return false;
		if (oao == null) {
			if (other.oao != null)
				return false;
		} else if (!oao.equals(other.oao))
			return false;
		if (oaoDonating1 == null) {
			if (other.oaoDonating1 != null)
				return false;
		} else if (!oaoDonating1.equals(other.oaoDonating1))
			return false;
		if (oaoDonating2 == null) {
			if (other.oaoDonating2 != null)
				return false;
		} else if (!oaoDonating2.equals(other.oaoDonating2))
			return false;
		if (offerDetails == null) {
			if (other.offerDetails != null)
				return false;
		} else if (!offerDetails.equals(other.offerDetails))
			return false;
		if (offertaCatalogo == null) {
			if (other.offertaCatalogo != null)
				return false;
		} else if (!offertaCatalogo.equals(other.offertaCatalogo))
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		if (opzioneDinamica != other.opzioneDinamica)
			return false;
		if (opzioneTraffico == null) {
			if (other.opzioneTraffico != null)
				return false;
		} else if (!opzioneTraffico.equals(other.opzioneTraffico))
			return false;
		if (opzioneVariazione == null) {
			if (other.opzioneVariazione != null)
				return false;
		} else if (!opzioneVariazione.equals(other.opzioneVariazione))
			return false;
		if (prestazione == null) {
			if (other.prestazione != null)
				return false;
		} else if (!prestazione.equals(other.prestazione))
			return false;
		if (profiloTecnicoLineaAsset == null) {
			if (other.profiloTecnicoLineaAsset != null)
				return false;
		} else if (!profiloTecnicoLineaAsset.equals(other.profiloTecnicoLineaAsset))
			return false;
		if (qualifica == null) {
			if (other.qualifica != null)
				return false;
		} else if (!qualifica.equals(other.qualifica))
			return false;
		if (quantitaLinee == null) {
			if (other.quantitaLinee != null)
				return false;
		} else if (!quantitaLinee.equals(other.quantitaLinee))
			return false;
		if (radicale == null) {
			if (other.radicale != null)
				return false;
		} else if (!radicale.equals(other.radicale))
			return false;
		if (recapitoTelefonicoCliente == null) {
			if (other.recapitoTelefonicoCliente != null)
				return false;
		} else if (!recapitoTelefonicoCliente.equals(other.recapitoTelefonicoCliente))
			return false;
		if (refOaoProgettiSpeciali == null) {
			if (other.refOaoProgettiSpeciali != null)
				return false;
		} else if (!refOaoProgettiSpeciali.equals(other.refOaoProgettiSpeciali))
			return false;
		if (routingNumber == null) {
			if (other.routingNumber != null)
				return false;
		} else if (!routingNumber.equals(other.routingNumber))
			return false;
		if (statoRestituzioneProdotti == null) {
			if (other.statoRestituzioneProdotti != null)
				return false;
		} else if (!statoRestituzioneProdotti.equals(other.statoRestituzioneProdotti))
			return false;
		if (strutturaLinea == null) {
			if (other.strutturaLinea != null)
				return false;
		} else if (!strutturaLinea.equals(other.strutturaLinea))
			return false;
		if (stsDaAttivare == null) {
			if (other.stsDaAttivare != null)
				return false;
		} else if (!stsDaAttivare.equals(other.stsDaAttivare))
			return false;
		if (stsDaCessare == null) {
			if (other.stsDaCessare != null)
				return false;
		} else if (!stsDaCessare.equals(other.stsDaCessare))
			return false;
		if (test2 == null) {
			if (other.test2 != null)
				return false;
		} else if (!test2.equals(other.test2))
			return false;
		if (tipoLinea == null) {
			if (other.tipoLinea != null)
				return false;
		} else if (!tipoLinea.equals(other.tipoLinea))
			return false;
		if (tipoMigrazione == null) {
			if (other.tipoMigrazione != null)
				return false;
		} else if (!tipoMigrazione.equals(other.tipoMigrazione))
			return false;
		if (tipoModifica == null) {
			if (other.tipoModifica != null)
				return false;
		} else if (!tipoModifica.equals(other.tipoModifica))
			return false;
		if (tipoRientro == null) {
			if (other.tipoRientro != null)
				return false;
		} else if (!tipoRientro.equals(other.tipoRientro))
			return false;
		if (tipoVariazione == null) {
			if (other.tipoVariazione != null)
				return false;
		} else if (!tipoVariazione.equals(other.tipoVariazione))
			return false;
		if (tipologiaAccesso == null) {
			if (other.tipologiaAccesso != null)
				return false;
		} else if (!tipologiaAccesso.equals(other.tipologiaAccesso))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (variazione == null) {
			if (other.variazione != null)
				return false;
		} else if (!variazione.equals(other.variazione))
			return false;
		if (whiteList == null) {
			if (other.whiteList != null)
				return false;
		} else if (!whiteList.equals(other.whiteList))
			return false;
		if (codOperatoreSecondario == null) {
			if (other.codOperatoreSecondario != null)
				return false;
		} else if (!codOperatoreSecondario.equals(other.codOperatoreSecondario))
			return false;
		if (clusterAccesso == null) {
			if (other.clusterAccesso != null)
				return false;
		} else if (!clusterAccesso.equals(other.clusterAccesso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreazioneNuovoOrdineInputBean [causaleOrdine=" + causaleOrdine + ", oao=" + oao + ", codiceOrdine="
				+ codiceOrdine + ", operatore=" + operatore + ", codiceOrdinePadre=" + codiceOrdinePadre
				+ ", idContratto=" + idContratto + ", idContrattoOfferta=" + idContrattoOfferta + ", noteDaOperatore="
				+ noteDaOperatore + ", codiceProgetto=" + codiceProgetto + ", codiceDelivery=" + codiceDelivery
				+ ", codiceQualita=" + codiceQualita + ", tipoModifica=" + tipoModifica + ", idRisorsa=" + idRisorsa
				+ ", codiceSessione1=" + codiceSessione1 + ", idRisorsa2=" + idRisorsa2 + ", codiceSessione2="
				+ codiceSessione2 + ", dac=" + dac + ", flagMonitoraggio=" + flagMonitoraggio + ", flagRientro="
				+ flagRientro + ", flagRientroVeloce=" + flagRientroVeloce + ", tipoRientro=" + tipoRientro
				+ ", dataRicezioneRichiesta=" + dataRicezioneRichiesta + ", routingNumber=" + routingNumber + ", dn="
				+ dn + ", offertaCatalogo=" + offertaCatalogo + ", tipoVariazione=" + tipoVariazione
				+ ", opzioneVariazione=" + opzioneVariazione + ", variazione=" + variazione + ", idullco=" + idullco
				+ ", flagNp=" + flagNp + ", dad=" + dad + ", fasciaOraria=" + fasciaOraria + ", numeroVerdeOperatorePT="
				+ numeroVerdeOperatorePT + ", numeroVerdeOperatoreCollaudo=" + numeroVerdeOperatoreCollaudo
				+ ", centrale=" + centrale + ", codiceGAT=" + codiceGAT + ", dnOperatoreCollaudo=" + dnOperatoreCollaudo
				+ ", numeroRichiestaColocazione=" + numeroRichiestaColocazione + ", idsluco=" + idsluco
				+ ", idTicketTTM=" + idTicketTTM + ", mantenimentoProdotti=" + mantenimentoProdotti + ", stsDaAttivare="
				+ stsDaAttivare + ", stsDaCessare=" + stsDaCessare + ", numerazioneAggiuntiva=" + numerazioneAggiuntiva
				+ ", tipologiaAccesso=" + tipologiaAccesso + ", datiReferenti=" + datiReferenti
				+ ", datiReferentiOnField=" + datiReferentiOnField + ", datiClienteFinale=" + datiClienteFinale
				+ ", indirizzoDatiClienteFinale=" + indirizzoDatiClienteFinale + ", attributiOfferta="
				+ attributiOfferta + ", flagFob=" + flagFob + ", indicatoreFob=" + indicatoreFob
				+ ", codiceIdentificativoLotto=" + codiceIdentificativoLotto + ", numeroLinea=" + numeroLinea
				+ ", idRisorsaBTSNaked=" + idRisorsaBTSNaked + ", borchiaNT1Plus=" + borchiaNT1Plus
				+ ", clirPermanente=" + clirPermanente + ", recapitoTelefonicoCliente=" + recapitoTelefonicoCliente
				+ ", dataSottoscrizioneContratto=" + dataSottoscrizioneContratto + ", indicatoreDiScaffale="
				+ indicatoreDiScaffale + ", dataRichiestaColocazione=" + dataRichiestaColocazione + ", flagAggiuntivi="
				+ flagAggiuntivi + ", dnAggiuntive=" + dnAggiuntive + ", idOfferta=" + idOfferta
				+ ", dataUltimaModifica=" + dataUltimaModifica + ", dataCreazione=" + dataCreazione
				+ ", flagMantenimentoSTS=" + flagMantenimentoSTS + ", flagNumerazioniAggiuntive="
				+ flagNumerazioniAggiuntive + ", aggiuntiviISDN=" + aggiuntiviISDN + ", flagOrdineUnico="
				+ flagOrdineUnico + ", codiceTrasloco=" + codiceTrasloco + ", prestazione=" + prestazione
				+ ", oaoDonating1=" + oaoDonating1 + ", oaoDonating2=" + oaoDonating2 + ", flagModem=" + flagModem
				+ ", dataDisponibilitaSede=" + dataDisponibilitaSede + ", tipoMigrazione=" + tipoMigrazione
				+ ", idAsset=" + idAsset + ", opzioneDinamica=" + opzioneDinamica + ", offerDetails=" + offerDetails
				+ ", contratto=" + contratto + ", qualifica=" + qualifica + ", test2=" + test2 + ", dataOrdine="
				+ dataOrdine + ", opzioneTraffico=" + opzioneTraffico + ", codiceCarrierOlo=" + codiceCarrierOlo
				+ ", flagReclamo=" + flagReclamo + ", tipoLinea=" + tipoLinea + ", strutturaLinea=" + strutturaLinea
				+ ", radicale=" + radicale + ", quantitaLinee=" + quantitaLinee + ", token=" + token
				+ ", datiServiziOpzionali=" + datiServiziOpzionali + ", datiDisaggregazione=" + datiDisaggregazione
				+ ", datiPresaAppuntamento=" + datiPresaAppuntamento + ", datiPrestazioniAggiuntive="
				+ datiPrestazioniAggiuntive + ", datiSlaPlusSu=" + datiSlaPlusSu + ", codiceOrdineTIVlan="
				+ codiceOrdineTIVlan + ", codiceOrdineOloVlan=" + codiceOrdineOloVlan + ", codiceTDKit=" + codiceTDKit
				+ ", clliCentrale=" + clliCentrale + ", idVlanOlo=" + idVlanOlo + ", drc=" + drc + ", coinvestimento="
				+ coinvestimento + ", idGpon=" + idGpon + ", profiloTecnicoLineaAsset=" + profiloTecnicoLineaAsset
				+ ", flagOffertaSemi=" + flagOffertaSemi + ", idReteSecondariaOao=" + idReteSecondariaOao
				+ ", datiOfferteMulticast=" + datiOfferteMulticast + ", whiteList=" + whiteList
				+ ", statoRestituzioneProdotti=" + statoRestituzioneProdotti + ", refOaoProgettiSpeciali="
				+ refOaoProgettiSpeciali 
				+ ", codOperatoreSecondario=" + codOperatoreSecondario
				+ ", clusterAccesso=" + clusterAccesso
				+ "]";
	}
}