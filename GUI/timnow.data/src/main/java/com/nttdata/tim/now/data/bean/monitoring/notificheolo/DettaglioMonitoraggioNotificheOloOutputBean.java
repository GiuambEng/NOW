package com.nttdata.tim.now.data.bean.monitoring.notificheolo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DettaglioMonitoraggioNotificheOloOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -4312912449326819968L;

    @JsonProperty("ambito")
	private String ambito;
	
	@JsonProperty("ordineOlo")
	private String ordineOlo;

	@JsonProperty("ordineTi")
	private String ordineTi;

	@JsonProperty("codificaOao")
	private String codificaOao;

	@JsonProperty("idRichiesta")
	private String idRichiesta;

	@JsonProperty("lavorazione")
	private String lavorazione;

	@JsonProperty("statoA")
	private String statoA;

	@JsonProperty("statoDa")
	private String statoDa;

	@JsonProperty("rowIdTracciamento")
	private String rowIdTracciamento;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataNotifica")
	private Date dataNotifica;

	@JsonProperty("idNotifica")
	private String idNotifica;

	@JsonProperty("descrizione")
	private String descrizione;

	@JsonProperty("tipologiaOlo")
	private String tipologiaOlo;

	@JsonProperty("rowIdNotifica")
	private String rowIdNotifica;

	@JsonProperty("canale")
	private String canale;

	@JsonProperty("tracciatoErrore")
	private String tracciatoErrore;

	@JsonProperty("famigliaOfferta")
	private String famigliaOfferta;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("nomeFileNotificaOraria")
	private String nomeFileNotificaOraria;

	@JsonProperty("nomeFileNotificaGiornaliera")
	private String nomeFileNotificaGiornaliera;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInserimentoFile")
	private Date dataInserimentoFile;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInvioFile")
	private Date dataInvioFile;

	@JsonProperty("esitoInvio")
	private String esitoInvio;

	@JsonProperty("attesa")
	private String attesa;

	@JsonProperty("stato")
	private String stato;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataPassaggioStato")
	private Date dataPassaggioStato;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataAcquisizioneOrdine")
	private Date dataAcquisizioneOrdine;

	@JsonProperty("numeroTelefonoCliente")
	private String numeroTelefonoCliente;

	@JsonProperty("soglia")
	private String soglia;

	public String getOrdineOlo() {
		return ordineOlo;
	}

	public void setOrdineOlo(String ordineOlo) {
		this.ordineOlo = ordineOlo;
	}

	public String getOrdineTi() {
		return ordineTi;
	}

	public void setOrdineTi(String ordineTi) {
		this.ordineTi = ordineTi;
	}

	public String getCodificaOao() {
		return codificaOao;
	}

	public void setCodificaOao(String codificaOao) {
		this.codificaOao = codificaOao;
	}

	public String getIdRichiesta() {
		return idRichiesta;
	}

	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getStatoA() {
		return statoA;
	}

	public void setStatoA(String statoA) {
		this.statoA = statoA;
	}

	public String getStatoDa() {
		return statoDa;
	}

	public void setStatoDa(String statoDa) {
		this.statoDa = statoDa;
	}

	public String getRowIdTracciamento() {
		return rowIdTracciamento;
	}

	public void setRowIdTracciamento(String rowIdTracciamento) {
		this.rowIdTracciamento = rowIdTracciamento;
	}

	public Date getDataNotifica() {
		return dataNotifica;
	}

	public void setDataNotifica(Date dataNotifica) {
		this.dataNotifica = dataNotifica;
	}

	public String getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipologiaOlo() {
		return tipologiaOlo;
	}

	public void setTipologiaOlo(String tipologiaOlo) {
		this.tipologiaOlo = tipologiaOlo;
	}

	public String getRowIdNotifica() {
		return rowIdNotifica;
	}

	public void setRowIdNotifica(String rowIdNotifica) {
		this.rowIdNotifica = rowIdNotifica;
	}

	public String getCanale() {
		return canale;
	}

	public void setCanale(String canale) {
		this.canale = canale;
	}

	public String getTracciatoErrore() {
		return tracciatoErrore;
	}

	public void setTracciatoErrore(String tracciatoErrore) {
		this.tracciatoErrore = tracciatoErrore;
	}

	public String getFamigliaOfferta() {
		return famigliaOfferta;
	}

	public void setFamigliaOfferta(String famigliaOfferta) {
		this.famigliaOfferta = famigliaOfferta;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getNomeFileNotificaOraria() {
		return nomeFileNotificaOraria;
	}

	public void setNomeFileNotificaOraria(String nomeFileNotificaOraria) {
		this.nomeFileNotificaOraria = nomeFileNotificaOraria;
	}

	public String getNomeFileNotificaGiornaliera() {
		return nomeFileNotificaGiornaliera;
	}

	public void setNomeFileNotificaGiornaliera(String nomeFileNotificaGiornaliera) {
		this.nomeFileNotificaGiornaliera = nomeFileNotificaGiornaliera;
	}

	public Date getDataInserimentoFile() {
		return dataInserimentoFile;
	}

	public void setDataInserimentoFile(Date dataInserimentoFile) {
		this.dataInserimentoFile = dataInserimentoFile;
	}

	public Date getDataInvioFile() {
		return dataInvioFile;
	}

	public void setDataInvioFile(Date dataInvioFile) {
		this.dataInvioFile = dataInvioFile;
	}

	public String getEsitoInvio() {
		return esitoInvio;
	}

	public void setEsitoInvio(String esitoInvio) {
		this.esitoInvio = esitoInvio;
	}

	public String getAttesa() {
		return attesa;
	}

	public void setAttesa(String attesa) {
		this.attesa = attesa;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDataPassaggioStato() {
		return dataPassaggioStato;
	}

	public void setDataPassaggioStato(Date dataPassaggioStato) {
		this.dataPassaggioStato = dataPassaggioStato;
	}

	public Date getDataAcquisizioneOrdine() {
		return dataAcquisizioneOrdine;
	}

	public void setDataAcquisizioneOrdine(Date dataAcquisizioneOrdine) {
		this.dataAcquisizioneOrdine = dataAcquisizioneOrdine;
	}

	public String getNumeroTelefonoCliente() {
		return numeroTelefonoCliente;
	}

	public void setNumeroTelefonoCliente(String numeroTelefonoCliente) {
		this.numeroTelefonoCliente = numeroTelefonoCliente;
	}

	public String getSoglia() {
		return soglia;
	}

	public void setSoglia(String soglia) {
		this.soglia = soglia;
	}

}