package com.nttdata.tim.now.data.dto.monitoring.tempiattraversamento;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class GuiDTO implements Serializable {

	private static final long serialVersionUID = 1454136714807905184L;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("DataEstrazione")
	private Date dataEstrazione;

	@JsonProperty("Lavorazione")
	private String lavorazione;

	@JsonProperty("Servizio")
	private String servizio;

	@JsonProperty("TotaleOrdini")
	private String totaleOrdini;

	@JsonProperty("NumOrdiniRimodulati")
	private String numeroOrdiniRimodulati;

	@JsonProperty("PercNumOrdiniRimodulati")
	private String percentualeNumeroOrdiniRimodulati;

	@JsonProperty("TotPervenutiInCaricoNowSla")
	private String totPervenutiInCaricoNowSla;

	@JsonProperty("TotPervenutiInCaricoNowNoSla")
	private String totPervenutiInCaricoNowNoSla;

	@JsonProperty("TotAcquisitiInCaricoNowSla")
	private String totAcquisitiInCaricoNowSla;

	@JsonProperty("TotAcquisitiInCaricoNowNoSla")
	private String totAcquisitiInCaricoNowNoSla;

	@JsonProperty("TotLavorazioniHDInCaricoNowSla")
	private String totLavorazioniHDInCaricoNowSla;

	@JsonProperty("TotLavorazioniHDInCaricoNowNoSla")
	private String totLavorazioniHDInCaricoNowNoSla;

	//new
	@JsonProperty("TotInVerificheDonatingNowSLA")
	private String totInVerificheDonatingNowSLA;
	
	@JsonProperty("TotInVerificheDonatingNowNOSLA")
	private String totInVerificheDonatingNowNOSLA;
	
	@JsonProperty("TotInVerificheTecnicheNowSLA")
	private String totInVerificheTecnicheNowSLA;
	
	@JsonProperty("TotInVerificheTecnicheNowNOSLA")
	private String totInVerificheTecnicheNowNOSLA;
	
    @JsonProperty("TotAccettatoNowSLA")
	private String totAccettatoNowSLA;
    
	@JsonProperty("TotAccettatoNowNOSLA")
	private String totAccettatoNowNOSLA;
	
	@JsonProperty("TotInConfermaAnnullamentoNowSLA")
	private String totInConfermaAnnullamentoNowSLA;
	
	@JsonProperty("TotInConfermaAnnullamentoNowNOSLA")
	private String totInConfermaAnnullamentoNowNOSLA;
	//end new
	
	@JsonProperty("TotVerificheReteInCaricoDtuSla")
	private String totVerificheReteInCaricoDtuSla;

	@JsonProperty("TotVerificheReteInCaricoDtuNoSla")
	private String totVerificheReteInCaricoDtuNoSla;

	@JsonProperty("TotInviatiDeliveryInCaricoDtuSla")
	private String totInviatiDeliveryInCaricoDtuSla;

	@JsonProperty("TotInviatiDeliveryInCaricoDtuNoSla")
	private String totInviatiDeliveryInCaricoDtuNoSla;

	@JsonProperty("TotInDeliveryInCaricoDtuSla")
	private String totInDeliveryInCaricoDtuSla;

	@JsonProperty("TotInDeliveryInCaricoDtuNoSla")
	private String totInDeliveryInCaricoDtuNoSla;

	@JsonProperty("TotAccodatiInCaricoDtuNoSla")
	private String totAccodatiInCaricoDtuNoSla;

	@JsonProperty("TotSospesiInCaricoDtuSla")
	private String totSospesiInCaricoDtuSla;

	@JsonProperty("TotSospesiInCaricoDtuNoSla")
	private String totSospesiInCaricoDtuNoSla;

	@JsonProperty("TotInAnnullamentoDeliveryInCaricoDtuSla")
	private String totInAnnullamentoDeliveryInCaricoDtuSla;

	@JsonProperty("TotInAnnullamentoDeliveryInCaricoDtuNoSla")
	private String totInAnnullamentoDeliveryInCaricoDtuNoSla;
	
	//new
	@JsonProperty("TotInAccettazionePreventivoDTUSLA")
	private String totInAccettazionePreventivoDTUSLA;
	
	@JsonProperty("TotInAccettazionePreventivoDTUNoSLA")
	private String totInAccettazionePreventivoDTUNoSLA;
	
	@JsonProperty("TotInAttesaConsuntivoDTUSLA")
	private String totInAttesaConsuntivoDTUSLA;
	
    @JsonProperty("TotInAttesaConsuntivoDTUNoSLA")
	private String totInAttesaConsuntivoDTUNoSLA;
    
    @JsonProperty("TotInAttesaEspletamentoFoniaDTUSLA")
	private String totInAttesaEspletamentoFoniaDTUSLA;
    
    @JsonProperty("TotInAttesaEspletamentoFoniaDTUNoSLA")
	private String totInAttesaEspletamentoFoniaDTUNoSLA;
    
    @JsonProperty("TotInRichiestaPreventivoDTUSLA")
	private String totInRichiestaPreventivoDTUSLA;
    
    @JsonProperty("TotInRichiestaPreventivoDTUNoSLA")
	private String totInRichiestaPreventivoDTUNoSLA;
    
    @JsonProperty("TotInAnnullamentoRifiutoPreventivoDTUSLA")
	private String totInAnnullamentoRifiutoPreventivoDTUSLA;
    
    @JsonProperty("TotInAnnullamentoRifiutoPreventivoDTUNoSLA")
    private String totInAnnullamentoRifiutoPreventivoDTUNoSLA;
	//end new
	
	@JsonProperty("IdTempiAttraversamentoGUI")
	private String idTempiAttraversamentoGUI;

	@JsonProperty("TotEspletati")
	private String totEspletati;

	@JsonProperty("TotEspletatiSLA")
	private String totEspletatiSLA;

	@JsonProperty("TotEspletatiNoSLA")
	private String totEspletatiNoSLA;

	@JsonProperty("TotAccodatiInCaricoDtuSla")
	private String totAccodatiInCaricoDtuSla;

	public Date getDataEstrazione() {
		return dataEstrazione;
	}

	public void setDataEstrazione(Date dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getServizio() {
		return servizio;
	}

	public void setServizio(String servizio) {
		this.servizio = servizio;
	}

	public String getTotaleOrdini() {
		return totaleOrdini;
	}

	public void setTotaleOrdini(String totaleOrdini) {
		this.totaleOrdini = totaleOrdini;
	}

	public String getNumeroOrdiniRimodulati() {
		return numeroOrdiniRimodulati;
	}

	public void setNumeroOrdiniRimodulati(String numeroOrdiniRimodulati) {
		this.numeroOrdiniRimodulati = numeroOrdiniRimodulati;
	}

	public String getPercentualeNumeroOrdiniRimodulati() {
		return percentualeNumeroOrdiniRimodulati;
	}

	public void setPercentualeNumeroOrdiniRimodulati(String percentualeNumeroOrdiniRimodulati) {
		this.percentualeNumeroOrdiniRimodulati = percentualeNumeroOrdiniRimodulati;
	}

	public String getTotPervenutiInCaricoNowSla() {
		return totPervenutiInCaricoNowSla;
	}

	public void setTotPervenutiInCaricoNowSla(String totPervenutiInCaricoNowSla) {
		this.totPervenutiInCaricoNowSla = totPervenutiInCaricoNowSla;
	}

	public String getTotPervenutiInCaricoNowNoSla() {
		return totPervenutiInCaricoNowNoSla;
	}

	public void setTotPervenutiInCaricoNowNoSla(String totPervenutiInCaricoNowNoSla) {
		this.totPervenutiInCaricoNowNoSla = totPervenutiInCaricoNowNoSla;
	}

	public String getTotAcquisitiInCaricoNowSla() {
		return totAcquisitiInCaricoNowSla;
	}

	public void setTotAcquisitiInCaricoNowSla(String totAcquisitiInCaricoNowSla) {
		this.totAcquisitiInCaricoNowSla = totAcquisitiInCaricoNowSla;
	}

	public String getTotAcquisitiInCaricoNowNoSla() {
		return totAcquisitiInCaricoNowNoSla;
	}

	public void setTotAcquisitiInCaricoNowNoSla(String totAcquisitiInCaricoNowNoSla) {
		this.totAcquisitiInCaricoNowNoSla = totAcquisitiInCaricoNowNoSla;
	}

	public String getTotLavorazioniHDInCaricoNowSla() {
		return totLavorazioniHDInCaricoNowSla;
	}

	public void setTotLavorazioniHDInCaricoNowSla(String totLavorazioniHDInCaricoNowSla) {
		this.totLavorazioniHDInCaricoNowSla = totLavorazioniHDInCaricoNowSla;
	}

	public String getTotLavorazioniHDInCaricoNowNoSla() {
		return totLavorazioniHDInCaricoNowNoSla;
	}

	public void setTotLavorazioniHDInCaricoNowNoSla(String totLavorazioniHDInCaricoNowNoSla) {
		this.totLavorazioniHDInCaricoNowNoSla = totLavorazioniHDInCaricoNowNoSla;
	}

	public String getTotInVerificheDonatingNowSLA() {
		return totInVerificheDonatingNowSLA;
	}

	public void setTotInVerificheDonatingNowSLA(String totInVerificheDonatingNowSLA) {
		this.totInVerificheDonatingNowSLA = totInVerificheDonatingNowSLA;
	}

	public String getTotInVerificheDonatingNowNOSLA() {
		return totInVerificheDonatingNowNOSLA;
	}

	public void setTotInVerificheDonatingNowNOSLA(String totInVerificheDonatingNowNOSLA) {
		this.totInVerificheDonatingNowNOSLA = totInVerificheDonatingNowNOSLA;
	}

	public String getTotInVerificheTecnicheNowSLA() {
		return totInVerificheTecnicheNowSLA;
	}

	public void setTotInVerificheTecnicheNowSLA(String totInVerificheTecnicheNowSLA) {
		this.totInVerificheTecnicheNowSLA = totInVerificheTecnicheNowSLA;
	}

	public String getTotInVerificheTecnicheNowNOSLA() {
		return totInVerificheTecnicheNowNOSLA;
	}

	public void setTotInVerificheTecnicheNowNOSLA(String totInVerificheTecnicheNowNOSLA) {
		this.totInVerificheTecnicheNowNOSLA = totInVerificheTecnicheNowNOSLA;
	}

	public String getTotAccettatoNowSLA() {
		return totAccettatoNowSLA;
	}

	public void setTotAccettatoNowSLA(String totAccettatoNowSLA) {
		this.totAccettatoNowSLA = totAccettatoNowSLA;
	}

	public String getTotAccettatoNowNOSLA() {
		return totAccettatoNowNOSLA;
	}

	public void setTotAccettatoNowNOSLA(String totAccettatoNowNOSLA) {
		this.totAccettatoNowNOSLA = totAccettatoNowNOSLA;
	}

	public String getTotInConfermaAnnullamentoNowSLA() {
		return totInConfermaAnnullamentoNowSLA;
	}

	public void setTotInConfermaAnnullamentoNowSLA(String totInConfermaAnnullamentoNowSLA) {
		this.totInConfermaAnnullamentoNowSLA = totInConfermaAnnullamentoNowSLA;
	}

	public String getTotInConfermaAnnullamentoNowNOSLA() {
		return totInConfermaAnnullamentoNowNOSLA;
	}

	public void setTotInConfermaAnnullamentoNowNOSLA(String totInConfermaAnnullamentoNowNOSLA) {
		this.totInConfermaAnnullamentoNowNOSLA = totInConfermaAnnullamentoNowNOSLA;
	}

	public String getTotVerificheReteInCaricoDtuSla() {
		return totVerificheReteInCaricoDtuSla;
	}

	public void setTotVerificheReteInCaricoDtuSla(String totVerificheReteInCaricoDtuSla) {
		this.totVerificheReteInCaricoDtuSla = totVerificheReteInCaricoDtuSla;
	}

	public String getTotVerificheReteInCaricoDtuNoSla() {
		return totVerificheReteInCaricoDtuNoSla;
	}

	public void setTotVerificheReteInCaricoDtuNoSla(String totVerificheReteInCaricoDtuNoSla) {
		this.totVerificheReteInCaricoDtuNoSla = totVerificheReteInCaricoDtuNoSla;
	}

	public String getTotInviatiDeliveryInCaricoDtuSla() {
		return totInviatiDeliveryInCaricoDtuSla;
	}

	public void setTotInviatiDeliveryInCaricoDtuSla(String totInviatiDeliveryInCaricoDtuSla) {
		this.totInviatiDeliveryInCaricoDtuSla = totInviatiDeliveryInCaricoDtuSla;
	}

	public String getTotInviatiDeliveryInCaricoDtuNoSla() {
		return totInviatiDeliveryInCaricoDtuNoSla;
	}

	public void setTotInviatiDeliveryInCaricoDtuNoSla(String totInviatiDeliveryInCaricoDtuNoSla) {
		this.totInviatiDeliveryInCaricoDtuNoSla = totInviatiDeliveryInCaricoDtuNoSla;
	}

	public String getTotInDeliveryInCaricoDtuSla() {
		return totInDeliveryInCaricoDtuSla;
	}

	public void setTotInDeliveryInCaricoDtuSla(String totInDeliveryInCaricoDtuSla) {
		this.totInDeliveryInCaricoDtuSla = totInDeliveryInCaricoDtuSla;
	}

	public String getTotInDeliveryInCaricoDtuNoSla() {
		return totInDeliveryInCaricoDtuNoSla;
	}

	public void setTotInDeliveryInCaricoDtuNoSla(String totInDeliveryInCaricoDtuNoSla) {
		this.totInDeliveryInCaricoDtuNoSla = totInDeliveryInCaricoDtuNoSla;
	}

	public String getTotAccodatiInCaricoDtuNoSla() {
		return totAccodatiInCaricoDtuNoSla;
	}

	public void setTotAccodatiInCaricoDtuNoSla(String totAccodatiInCaricoDtuNoSla) {
		this.totAccodatiInCaricoDtuNoSla = totAccodatiInCaricoDtuNoSla;
	}

	public String getTotSospesiInCaricoDtuSla() {
		return totSospesiInCaricoDtuSla;
	}

	public void setTotSospesiInCaricoDtuSla(String totSospesiInCaricoDtuSla) {
		this.totSospesiInCaricoDtuSla = totSospesiInCaricoDtuSla;
	}

	public String getTotSospesiInCaricoDtuNoSla() {
		return totSospesiInCaricoDtuNoSla;
	}

	public void setTotSospesiInCaricoDtuNoSla(String totSospesiInCaricoDtuNoSla) {
		this.totSospesiInCaricoDtuNoSla = totSospesiInCaricoDtuNoSla;
	}

	public String getTotInAnnullamentoDeliveryInCaricoDtuSla() {
		return totInAnnullamentoDeliveryInCaricoDtuSla;
	}

	public void setTotInAnnullamentoDeliveryInCaricoDtuSla(String totInAnnullamentoDeliveryInCaricoDtuSla) {
		this.totInAnnullamentoDeliveryInCaricoDtuSla = totInAnnullamentoDeliveryInCaricoDtuSla;
	}

	public String getTotInAnnullamentoDeliveryInCaricoDtuNoSla() {
		return totInAnnullamentoDeliveryInCaricoDtuNoSla;
	}

	public void setTotInAnnullamentoDeliveryInCaricoDtuNoSla(String totInAnnullamentoDeliveryInCaricoDtuNoSla) {
		this.totInAnnullamentoDeliveryInCaricoDtuNoSla = totInAnnullamentoDeliveryInCaricoDtuNoSla;
	}

	public String getTotInAccettazionePreventivoDTUSLA() {
		return totInAccettazionePreventivoDTUSLA;
	}

	public void setTotInAccettazionePreventivoDTUSLA(String totInAccettazionePreventivoDTUSLA) {
		this.totInAccettazionePreventivoDTUSLA = totInAccettazionePreventivoDTUSLA;
	}

	public String getTotInAccettazionePreventivoDTUNoSLA() {
		return totInAccettazionePreventivoDTUNoSLA;
	}

	public void setTotInAccettazionePreventivoDTUNoSLA(String totInAccettazionePreventivoDTUNoSLA) {
		this.totInAccettazionePreventivoDTUNoSLA = totInAccettazionePreventivoDTUNoSLA;
	}

	public String getTotInAttesaConsuntivoDTUSLA() {
		return totInAttesaConsuntivoDTUSLA;
	}

	public void setTotInAttesaConsuntivoDTUSLA(String totInAttesaConsuntivoDTUSLA) {
		this.totInAttesaConsuntivoDTUSLA = totInAttesaConsuntivoDTUSLA;
	}

	public String getTotInAttesaConsuntivoDTUNoSLA() {
		return totInAttesaConsuntivoDTUNoSLA;
	}

	public void setTotInAttesaConsuntivoDTUNoSLA(String totInAttesaConsuntivoDTUNoSLA) {
		this.totInAttesaConsuntivoDTUNoSLA = totInAttesaConsuntivoDTUNoSLA;
	}

	public String getTotInAttesaEspletamentoFoniaDTUSLA() {
		return totInAttesaEspletamentoFoniaDTUSLA;
	}

	public void setTotInAttesaEspletamentoFoniaDTUSLA(String totInAttesaEspletamentoFoniaDTUSLA) {
		this.totInAttesaEspletamentoFoniaDTUSLA = totInAttesaEspletamentoFoniaDTUSLA;
	}

	public String getTotInAttesaEspletamentoFoniaDTUNoSLA() {
		return totInAttesaEspletamentoFoniaDTUNoSLA;
	}

	public void setTotInAttesaEspletamentoFoniaDTUNoSLA(String totInAttesaEspletamentoFoniaDTUNoSLA) {
		this.totInAttesaEspletamentoFoniaDTUNoSLA = totInAttesaEspletamentoFoniaDTUNoSLA;
	}

	public String getTotInRichiestaPreventivoDTUSLA() {
		return totInRichiestaPreventivoDTUSLA;
	}

	public void setTotInRichiestaPreventivoDTUSLA(String totInRichiestaPreventivoDTUSLA) {
		this.totInRichiestaPreventivoDTUSLA = totInRichiestaPreventivoDTUSLA;
	}

	public String getTotInRichiestaPreventivoDTUNoSLA() {
		return totInRichiestaPreventivoDTUNoSLA;
	}

	public void setTotInRichiestaPreventivoDTUNoSLA(String totInRichiestaPreventivoDTUNoSLA) {
		this.totInRichiestaPreventivoDTUNoSLA = totInRichiestaPreventivoDTUNoSLA;
	}

	public String getTotInAnnullamentoRifiutoPreventivoDTUSLA() {
		return totInAnnullamentoRifiutoPreventivoDTUSLA;
	}

	public void setTotInAnnullamentoRifiutoPreventivoDTUSLA(String totInAnnullamentoRifiutoPreventivoDTUSLA) {
		this.totInAnnullamentoRifiutoPreventivoDTUSLA = totInAnnullamentoRifiutoPreventivoDTUSLA;
	}

	public String getTotInAnnullamentoRifiutoPreventivoDTUNoSLA() {
		return totInAnnullamentoRifiutoPreventivoDTUNoSLA;
	}

	public void setTotInAnnullamentoRifiutoPreventivoDTUNoSLA(String totInAnnullamentoRifiutoPreventivoDTUNoSLA) {
		this.totInAnnullamentoRifiutoPreventivoDTUNoSLA = totInAnnullamentoRifiutoPreventivoDTUNoSLA;
	}

	public String getIdTempiAttraversamentoGUI() {
		return idTempiAttraversamentoGUI;
	}

	public void setIdTempiAttraversamentoGUI(String idTempiAttraversamentoGUI) {
		this.idTempiAttraversamentoGUI = idTempiAttraversamentoGUI;
	}

	public String getTotEspletati() {
		return totEspletati;
	}

	public void setTotEspletati(String totEspletati) {
		this.totEspletati = totEspletati;
	}

	public String getTotEspletatiSLA() {
		return totEspletatiSLA;
	}

	public void setTotEspletatiSLA(String totEspletatiSLA) {
		this.totEspletatiSLA = totEspletatiSLA;
	}

	public String getTotEspletatiNoSLA() {
		return totEspletatiNoSLA;
	}

	public void setTotEspletatiNoSLA(String totEspletatiNoSLA) {
		this.totEspletatiNoSLA = totEspletatiNoSLA;
	}

	public String getTotAccodatiInCaricoDtuSla() {
		return totAccodatiInCaricoDtuSla;
	}

	public void setTotAccodatiInCaricoDtuSla(String totAccodatiInCaricoDtuSla) {
		this.totAccodatiInCaricoDtuSla = totAccodatiInCaricoDtuSla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEstrazione == null) ? 0 : dataEstrazione.hashCode());
		result = prime * result + ((idTempiAttraversamentoGUI == null) ? 0 : idTempiAttraversamentoGUI.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((numeroOrdiniRimodulati == null) ? 0 : numeroOrdiniRimodulati.hashCode());
		result = prime * result
				+ ((percentualeNumeroOrdiniRimodulati == null) ? 0 : percentualeNumeroOrdiniRimodulati.hashCode());
		result = prime * result + ((servizio == null) ? 0 : servizio.hashCode());
		result = prime * result + ((totAccettatoNowNOSLA == null) ? 0 : totAccettatoNowNOSLA.hashCode());
		result = prime * result + ((totAccettatoNowSLA == null) ? 0 : totAccettatoNowSLA.hashCode());
		result = prime * result + ((totAccodatiInCaricoDtuNoSla == null) ? 0 : totAccodatiInCaricoDtuNoSla.hashCode());
		result = prime * result + ((totAccodatiInCaricoDtuSla == null) ? 0 : totAccodatiInCaricoDtuSla.hashCode());
		result = prime * result
				+ ((totAcquisitiInCaricoNowNoSla == null) ? 0 : totAcquisitiInCaricoNowNoSla.hashCode());
		result = prime * result + ((totAcquisitiInCaricoNowSla == null) ? 0 : totAcquisitiInCaricoNowSla.hashCode());
		result = prime * result + ((totEspletati == null) ? 0 : totEspletati.hashCode());
		result = prime * result + ((totEspletatiNoSLA == null) ? 0 : totEspletatiNoSLA.hashCode());
		result = prime * result + ((totEspletatiSLA == null) ? 0 : totEspletatiSLA.hashCode());
		result = prime * result
				+ ((totInAccettazionePreventivoDTUNoSLA == null) ? 0 : totInAccettazionePreventivoDTUNoSLA.hashCode());
		result = prime * result
				+ ((totInAccettazionePreventivoDTUSLA == null) ? 0 : totInAccettazionePreventivoDTUSLA.hashCode());
		result = prime * result + ((totInAnnullamentoDeliveryInCaricoDtuNoSla == null) ? 0
				: totInAnnullamentoDeliveryInCaricoDtuNoSla.hashCode());
		result = prime * result + ((totInAnnullamentoDeliveryInCaricoDtuSla == null) ? 0
				: totInAnnullamentoDeliveryInCaricoDtuSla.hashCode());
		result = prime * result + ((totInAnnullamentoRifiutoPreventivoDTUNoSLA == null) ? 0
				: totInAnnullamentoRifiutoPreventivoDTUNoSLA.hashCode());
		result = prime * result + ((totInAnnullamentoRifiutoPreventivoDTUSLA == null) ? 0
				: totInAnnullamentoRifiutoPreventivoDTUSLA.hashCode());
		result = prime * result
				+ ((totInAttesaConsuntivoDTUNoSLA == null) ? 0 : totInAttesaConsuntivoDTUNoSLA.hashCode());
		result = prime * result + ((totInAttesaConsuntivoDTUSLA == null) ? 0 : totInAttesaConsuntivoDTUSLA.hashCode());
		result = prime * result + ((totInAttesaEspletamentoFoniaDTUNoSLA == null) ? 0
				: totInAttesaEspletamentoFoniaDTUNoSLA.hashCode());
		result = prime * result
				+ ((totInAttesaEspletamentoFoniaDTUSLA == null) ? 0 : totInAttesaEspletamentoFoniaDTUSLA.hashCode());
		result = prime * result
				+ ((totInConfermaAnnullamentoNowNOSLA == null) ? 0 : totInConfermaAnnullamentoNowNOSLA.hashCode());
		result = prime * result
				+ ((totInConfermaAnnullamentoNowSLA == null) ? 0 : totInConfermaAnnullamentoNowSLA.hashCode());
		result = prime * result
				+ ((totInDeliveryInCaricoDtuNoSla == null) ? 0 : totInDeliveryInCaricoDtuNoSla.hashCode());
		result = prime * result + ((totInDeliveryInCaricoDtuSla == null) ? 0 : totInDeliveryInCaricoDtuSla.hashCode());
		result = prime * result
				+ ((totInRichiestaPreventivoDTUNoSLA == null) ? 0 : totInRichiestaPreventivoDTUNoSLA.hashCode());
		result = prime * result
				+ ((totInRichiestaPreventivoDTUSLA == null) ? 0 : totInRichiestaPreventivoDTUSLA.hashCode());
		result = prime * result
				+ ((totInVerificheDonatingNowNOSLA == null) ? 0 : totInVerificheDonatingNowNOSLA.hashCode());
		result = prime * result
				+ ((totInVerificheDonatingNowSLA == null) ? 0 : totInVerificheDonatingNowSLA.hashCode());
		result = prime * result
				+ ((totInVerificheTecnicheNowNOSLA == null) ? 0 : totInVerificheTecnicheNowNOSLA.hashCode());
		result = prime * result
				+ ((totInVerificheTecnicheNowSLA == null) ? 0 : totInVerificheTecnicheNowSLA.hashCode());
		result = prime * result
				+ ((totInviatiDeliveryInCaricoDtuNoSla == null) ? 0 : totInviatiDeliveryInCaricoDtuNoSla.hashCode());
		result = prime * result
				+ ((totInviatiDeliveryInCaricoDtuSla == null) ? 0 : totInviatiDeliveryInCaricoDtuSla.hashCode());
		result = prime * result
				+ ((totLavorazioniHDInCaricoNowNoSla == null) ? 0 : totLavorazioniHDInCaricoNowNoSla.hashCode());
		result = prime * result
				+ ((totLavorazioniHDInCaricoNowSla == null) ? 0 : totLavorazioniHDInCaricoNowSla.hashCode());
		result = prime * result
				+ ((totPervenutiInCaricoNowNoSla == null) ? 0 : totPervenutiInCaricoNowNoSla.hashCode());
		result = prime * result + ((totPervenutiInCaricoNowSla == null) ? 0 : totPervenutiInCaricoNowSla.hashCode());
		result = prime * result + ((totSospesiInCaricoDtuNoSla == null) ? 0 : totSospesiInCaricoDtuNoSla.hashCode());
		result = prime * result + ((totSospesiInCaricoDtuSla == null) ? 0 : totSospesiInCaricoDtuSla.hashCode());
		result = prime * result
				+ ((totVerificheReteInCaricoDtuNoSla == null) ? 0 : totVerificheReteInCaricoDtuNoSla.hashCode());
		result = prime * result
				+ ((totVerificheReteInCaricoDtuSla == null) ? 0 : totVerificheReteInCaricoDtuSla.hashCode());
		result = prime * result + ((totaleOrdini == null) ? 0 : totaleOrdini.hashCode());
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
		GuiDTO other = (GuiDTO) obj;
		if (dataEstrazione == null) {
			if (other.dataEstrazione != null)
				return false;
		} else if (!dataEstrazione.equals(other.dataEstrazione))
			return false;
		if (idTempiAttraversamentoGUI == null) {
			if (other.idTempiAttraversamentoGUI != null)
				return false;
		} else if (!idTempiAttraversamentoGUI.equals(other.idTempiAttraversamentoGUI))
			return false;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (numeroOrdiniRimodulati == null) {
			if (other.numeroOrdiniRimodulati != null)
				return false;
		} else if (!numeroOrdiniRimodulati.equals(other.numeroOrdiniRimodulati))
			return false;
		if (percentualeNumeroOrdiniRimodulati == null) {
			if (other.percentualeNumeroOrdiniRimodulati != null)
				return false;
		} else if (!percentualeNumeroOrdiniRimodulati.equals(other.percentualeNumeroOrdiniRimodulati))
			return false;
		if (servizio == null) {
			if (other.servizio != null)
				return false;
		} else if (!servizio.equals(other.servizio))
			return false;
		if (totAccettatoNowNOSLA == null) {
			if (other.totAccettatoNowNOSLA != null)
				return false;
		} else if (!totAccettatoNowNOSLA.equals(other.totAccettatoNowNOSLA))
			return false;
		if (totAccettatoNowSLA == null) {
			if (other.totAccettatoNowSLA != null)
				return false;
		} else if (!totAccettatoNowSLA.equals(other.totAccettatoNowSLA))
			return false;
		if (totAccodatiInCaricoDtuNoSla == null) {
			if (other.totAccodatiInCaricoDtuNoSla != null)
				return false;
		} else if (!totAccodatiInCaricoDtuNoSla.equals(other.totAccodatiInCaricoDtuNoSla))
			return false;
		if (totAccodatiInCaricoDtuSla == null) {
			if (other.totAccodatiInCaricoDtuSla != null)
				return false;
		} else if (!totAccodatiInCaricoDtuSla.equals(other.totAccodatiInCaricoDtuSla))
			return false;
		if (totAcquisitiInCaricoNowNoSla == null) {
			if (other.totAcquisitiInCaricoNowNoSla != null)
				return false;
		} else if (!totAcquisitiInCaricoNowNoSla.equals(other.totAcquisitiInCaricoNowNoSla))
			return false;
		if (totAcquisitiInCaricoNowSla == null) {
			if (other.totAcquisitiInCaricoNowSla != null)
				return false;
		} else if (!totAcquisitiInCaricoNowSla.equals(other.totAcquisitiInCaricoNowSla))
			return false;
		if (totEspletati == null) {
			if (other.totEspletati != null)
				return false;
		} else if (!totEspletati.equals(other.totEspletati))
			return false;
		if (totEspletatiNoSLA == null) {
			if (other.totEspletatiNoSLA != null)
				return false;
		} else if (!totEspletatiNoSLA.equals(other.totEspletatiNoSLA))
			return false;
		if (totEspletatiSLA == null) {
			if (other.totEspletatiSLA != null)
				return false;
		} else if (!totEspletatiSLA.equals(other.totEspletatiSLA))
			return false;
		if (totInAccettazionePreventivoDTUNoSLA == null) {
			if (other.totInAccettazionePreventivoDTUNoSLA != null)
				return false;
		} else if (!totInAccettazionePreventivoDTUNoSLA.equals(other.totInAccettazionePreventivoDTUNoSLA))
			return false;
		if (totInAccettazionePreventivoDTUSLA == null) {
			if (other.totInAccettazionePreventivoDTUSLA != null)
				return false;
		} else if (!totInAccettazionePreventivoDTUSLA.equals(other.totInAccettazionePreventivoDTUSLA))
			return false;
		if (totInAnnullamentoDeliveryInCaricoDtuNoSla == null) {
			if (other.totInAnnullamentoDeliveryInCaricoDtuNoSla != null)
				return false;
		} else if (!totInAnnullamentoDeliveryInCaricoDtuNoSla.equals(other.totInAnnullamentoDeliveryInCaricoDtuNoSla))
			return false;
		if (totInAnnullamentoDeliveryInCaricoDtuSla == null) {
			if (other.totInAnnullamentoDeliveryInCaricoDtuSla != null)
				return false;
		} else if (!totInAnnullamentoDeliveryInCaricoDtuSla.equals(other.totInAnnullamentoDeliveryInCaricoDtuSla))
			return false;
		if (totInAnnullamentoRifiutoPreventivoDTUNoSLA == null) {
			if (other.totInAnnullamentoRifiutoPreventivoDTUNoSLA != null)
				return false;
		} else if (!totInAnnullamentoRifiutoPreventivoDTUNoSLA.equals(other.totInAnnullamentoRifiutoPreventivoDTUNoSLA))
			return false;
		if (totInAnnullamentoRifiutoPreventivoDTUSLA == null) {
			if (other.totInAnnullamentoRifiutoPreventivoDTUSLA != null)
				return false;
		} else if (!totInAnnullamentoRifiutoPreventivoDTUSLA.equals(other.totInAnnullamentoRifiutoPreventivoDTUSLA))
			return false;
		if (totInAttesaConsuntivoDTUNoSLA == null) {
			if (other.totInAttesaConsuntivoDTUNoSLA != null)
				return false;
		} else if (!totInAttesaConsuntivoDTUNoSLA.equals(other.totInAttesaConsuntivoDTUNoSLA))
			return false;
		if (totInAttesaConsuntivoDTUSLA == null) {
			if (other.totInAttesaConsuntivoDTUSLA != null)
				return false;
		} else if (!totInAttesaConsuntivoDTUSLA.equals(other.totInAttesaConsuntivoDTUSLA))
			return false;
		if (totInAttesaEspletamentoFoniaDTUNoSLA == null) {
			if (other.totInAttesaEspletamentoFoniaDTUNoSLA != null)
				return false;
		} else if (!totInAttesaEspletamentoFoniaDTUNoSLA.equals(other.totInAttesaEspletamentoFoniaDTUNoSLA))
			return false;
		if (totInAttesaEspletamentoFoniaDTUSLA == null) {
			if (other.totInAttesaEspletamentoFoniaDTUSLA != null)
				return false;
		} else if (!totInAttesaEspletamentoFoniaDTUSLA.equals(other.totInAttesaEspletamentoFoniaDTUSLA))
			return false;
		if (totInConfermaAnnullamentoNowNOSLA == null) {
			if (other.totInConfermaAnnullamentoNowNOSLA != null)
				return false;
		} else if (!totInConfermaAnnullamentoNowNOSLA.equals(other.totInConfermaAnnullamentoNowNOSLA))
			return false;
		if (totInConfermaAnnullamentoNowSLA == null) {
			if (other.totInConfermaAnnullamentoNowSLA != null)
				return false;
		} else if (!totInConfermaAnnullamentoNowSLA.equals(other.totInConfermaAnnullamentoNowSLA))
			return false;
		if (totInDeliveryInCaricoDtuNoSla == null) {
			if (other.totInDeliveryInCaricoDtuNoSla != null)
				return false;
		} else if (!totInDeliveryInCaricoDtuNoSla.equals(other.totInDeliveryInCaricoDtuNoSla))
			return false;
		if (totInDeliveryInCaricoDtuSla == null) {
			if (other.totInDeliveryInCaricoDtuSla != null)
				return false;
		} else if (!totInDeliveryInCaricoDtuSla.equals(other.totInDeliveryInCaricoDtuSla))
			return false;
		if (totInRichiestaPreventivoDTUNoSLA == null) {
			if (other.totInRichiestaPreventivoDTUNoSLA != null)
				return false;
		} else if (!totInRichiestaPreventivoDTUNoSLA.equals(other.totInRichiestaPreventivoDTUNoSLA))
			return false;
		if (totInRichiestaPreventivoDTUSLA == null) {
			if (other.totInRichiestaPreventivoDTUSLA != null)
				return false;
		} else if (!totInRichiestaPreventivoDTUSLA.equals(other.totInRichiestaPreventivoDTUSLA))
			return false;
		if (totInVerificheDonatingNowNOSLA == null) {
			if (other.totInVerificheDonatingNowNOSLA != null)
				return false;
		} else if (!totInVerificheDonatingNowNOSLA.equals(other.totInVerificheDonatingNowNOSLA))
			return false;
		if (totInVerificheDonatingNowSLA == null) {
			if (other.totInVerificheDonatingNowSLA != null)
				return false;
		} else if (!totInVerificheDonatingNowSLA.equals(other.totInVerificheDonatingNowSLA))
			return false;
		if (totInVerificheTecnicheNowNOSLA == null) {
			if (other.totInVerificheTecnicheNowNOSLA != null)
				return false;
		} else if (!totInVerificheTecnicheNowNOSLA.equals(other.totInVerificheTecnicheNowNOSLA))
			return false;
		if (totInVerificheTecnicheNowSLA == null) {
			if (other.totInVerificheTecnicheNowSLA != null)
				return false;
		} else if (!totInVerificheTecnicheNowSLA.equals(other.totInVerificheTecnicheNowSLA))
			return false;
		if (totInviatiDeliveryInCaricoDtuNoSla == null) {
			if (other.totInviatiDeliveryInCaricoDtuNoSla != null)
				return false;
		} else if (!totInviatiDeliveryInCaricoDtuNoSla.equals(other.totInviatiDeliveryInCaricoDtuNoSla))
			return false;
		if (totInviatiDeliveryInCaricoDtuSla == null) {
			if (other.totInviatiDeliveryInCaricoDtuSla != null)
				return false;
		} else if (!totInviatiDeliveryInCaricoDtuSla.equals(other.totInviatiDeliveryInCaricoDtuSla))
			return false;
		if (totLavorazioniHDInCaricoNowNoSla == null) {
			if (other.totLavorazioniHDInCaricoNowNoSla != null)
				return false;
		} else if (!totLavorazioniHDInCaricoNowNoSla.equals(other.totLavorazioniHDInCaricoNowNoSla))
			return false;
		if (totLavorazioniHDInCaricoNowSla == null) {
			if (other.totLavorazioniHDInCaricoNowSla != null)
				return false;
		} else if (!totLavorazioniHDInCaricoNowSla.equals(other.totLavorazioniHDInCaricoNowSla))
			return false;
		if (totPervenutiInCaricoNowNoSla == null) {
			if (other.totPervenutiInCaricoNowNoSla != null)
				return false;
		} else if (!totPervenutiInCaricoNowNoSla.equals(other.totPervenutiInCaricoNowNoSla))
			return false;
		if (totPervenutiInCaricoNowSla == null) {
			if (other.totPervenutiInCaricoNowSla != null)
				return false;
		} else if (!totPervenutiInCaricoNowSla.equals(other.totPervenutiInCaricoNowSla))
			return false;
		if (totSospesiInCaricoDtuNoSla == null) {
			if (other.totSospesiInCaricoDtuNoSla != null)
				return false;
		} else if (!totSospesiInCaricoDtuNoSla.equals(other.totSospesiInCaricoDtuNoSla))
			return false;
		if (totSospesiInCaricoDtuSla == null) {
			if (other.totSospesiInCaricoDtuSla != null)
				return false;
		} else if (!totSospesiInCaricoDtuSla.equals(other.totSospesiInCaricoDtuSla))
			return false;
		if (totVerificheReteInCaricoDtuNoSla == null) {
			if (other.totVerificheReteInCaricoDtuNoSla != null)
				return false;
		} else if (!totVerificheReteInCaricoDtuNoSla.equals(other.totVerificheReteInCaricoDtuNoSla))
			return false;
		if (totVerificheReteInCaricoDtuSla == null) {
			if (other.totVerificheReteInCaricoDtuSla != null)
				return false;
		} else if (!totVerificheReteInCaricoDtuSla.equals(other.totVerificheReteInCaricoDtuSla))
			return false;
		if (totaleOrdini == null) {
			if (other.totaleOrdini != null)
				return false;
		} else if (!totaleOrdini.equals(other.totaleOrdini))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GuiDTO [dataEstrazione=" + dataEstrazione + ", lavorazione=" + lavorazione + ", servizio=" + servizio
				+ ", totaleOrdini=" + totaleOrdini + ", numeroOrdiniRimodulati=" + numeroOrdiniRimodulati
				+ ", percentualeNumeroOrdiniRimodulati=" + percentualeNumeroOrdiniRimodulati
				+ ", totPervenutiInCaricoNowSla=" + totPervenutiInCaricoNowSla + ", totPervenutiInCaricoNowNoSla="
				+ totPervenutiInCaricoNowNoSla + ", totAcquisitiInCaricoNowSla=" + totAcquisitiInCaricoNowSla
				+ ", totAcquisitiInCaricoNowNoSla=" + totAcquisitiInCaricoNowNoSla + ", totLavorazioniHDInCaricoNowSla="
				+ totLavorazioniHDInCaricoNowSla + ", totLavorazioniHDInCaricoNowNoSla="
				+ totLavorazioniHDInCaricoNowNoSla + ", totInVerificheDonatingNowSLA=" + totInVerificheDonatingNowSLA
				+ ", totInVerificheDonatingNowNOSLA=" + totInVerificheDonatingNowNOSLA
				+ ", totInVerificheTecnicheNowSLA=" + totInVerificheTecnicheNowSLA + ", totInVerificheTecnicheNowNOSLA="
				+ totInVerificheTecnicheNowNOSLA + ", totAccettatoNowSLA=" + totAccettatoNowSLA
				+ ", totAccettatoNowNOSLA=" + totAccettatoNowNOSLA + ", totInConfermaAnnullamentoNowSLA="
				+ totInConfermaAnnullamentoNowSLA + ", totInConfermaAnnullamentoNowNOSLA="
				+ totInConfermaAnnullamentoNowNOSLA + ", totVerificheReteInCaricoDtuSla="
				+ totVerificheReteInCaricoDtuSla + ", totVerificheReteInCaricoDtuNoSla="
				+ totVerificheReteInCaricoDtuNoSla + ", totInviatiDeliveryInCaricoDtuSla="
				+ totInviatiDeliveryInCaricoDtuSla + ", totInviatiDeliveryInCaricoDtuNoSla="
				+ totInviatiDeliveryInCaricoDtuNoSla + ", totInDeliveryInCaricoDtuSla=" + totInDeliveryInCaricoDtuSla
				+ ", totInDeliveryInCaricoDtuNoSla=" + totInDeliveryInCaricoDtuNoSla + ", totAccodatiInCaricoDtuNoSla="
				+ totAccodatiInCaricoDtuNoSla + ", totSospesiInCaricoDtuSla=" + totSospesiInCaricoDtuSla
				+ ", totSospesiInCaricoDtuNoSla=" + totSospesiInCaricoDtuNoSla
				+ ", totInAnnullamentoDeliveryInCaricoDtuSla=" + totInAnnullamentoDeliveryInCaricoDtuSla
				+ ", totInAnnullamentoDeliveryInCaricoDtuNoSla=" + totInAnnullamentoDeliveryInCaricoDtuNoSla
				+ ", totInAccettazionePreventivoDTUSLA=" + totInAccettazionePreventivoDTUSLA
				+ ", totInAccettazionePreventivoDTUNoSLA=" + totInAccettazionePreventivoDTUNoSLA
				+ ", totInAttesaConsuntivoDTUSLA=" + totInAttesaConsuntivoDTUSLA + ", totInAttesaConsuntivoDTUNoSLA="
				+ totInAttesaConsuntivoDTUNoSLA + ", totInAttesaEspletamentoFoniaDTUSLA="
				+ totInAttesaEspletamentoFoniaDTUSLA + ", totInAttesaEspletamentoFoniaDTUNoSLA="
				+ totInAttesaEspletamentoFoniaDTUNoSLA + ", totInRichiestaPreventivoDTUSLA="
				+ totInRichiestaPreventivoDTUSLA + ", totInRichiestaPreventivoDTUNoSLA="
				+ totInRichiestaPreventivoDTUNoSLA + ", totInAnnullamentoRifiutoPreventivoDTUSLA="
				+ totInAnnullamentoRifiutoPreventivoDTUSLA + ", totInAnnullamentoRifiutoPreventivoDTUNoSLA="
				+ totInAnnullamentoRifiutoPreventivoDTUNoSLA + ", idTempiAttraversamentoGUI="
				+ idTempiAttraversamentoGUI + ", totEspletati=" + totEspletati + ", totEspletatiSLA=" + totEspletatiSLA
				+ ", totEspletatiNoSLA=" + totEspletatiNoSLA + ", totAccodatiInCaricoDtuSla="
				+ totAccodatiInCaricoDtuSla + "]";
	}
	
}