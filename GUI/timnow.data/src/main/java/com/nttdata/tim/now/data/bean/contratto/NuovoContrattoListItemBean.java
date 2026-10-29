package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL) 
public class NuovoContrattoListItemBean implements Serializable{

	private static final long serialVersionUID = -8894370964818743012L;

	@JsonProperty("codiceContratto")
	private String codiceContratto;
	
	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;
	
	@JsonProperty("codiceOloNumerico")
	private String codiceOloNumerico;
	
	@JsonProperty("flagAbilitato")
	private String flagAbilitato;
	
	@JsonProperty("flagFileNotify")
	private String flagFileNotify;
	
	@JsonProperty("flagValido")
	private String flagValido;
	
	@JsonProperty("nomeContratto")
	private String nomeContratto;

	@JsonProperty("dataInizioValiditaContratto")
	private String dataInizioValiditaContratto;
	
	@JsonProperty("dataFineValiditaContratto")
	private String dataFineValiditaContratto;
	
	@JsonProperty("idFamigliaOfferta")
	private String idFamigliaOfferta;
	
	@JsonProperty("idSottofamigliaOfferta")
	private String idSottofamigliaOfferta;
	
	@JsonProperty("operatore")
	private String operatore;
	
	@JsonProperty("idOfferta")
	private String idOfferta;
	
	@JsonProperty("dataInizioAssociazioneOffertaContratto")
	private String dataInizioAssociazioneOffertaContratto;
	
	@JsonProperty("dataFineAssociazioneOffertaContratto")
	private String dataFineAssociazioneOffertaContratto;
	
	@JsonProperty("tipoProfilo")
	private String tipoProfilo;
	
	@JsonProperty("idTipologiaContratto")
	private String idTipologiaContratto;
	
	//RU_1129
	@JsonProperty("contrattoFwaInfratel")
	private String contrattoFwaInfratel;
	
	@JsonProperty("contrattoFwaPlus")
	private String contrattoFwaPlus;
	
	@JsonProperty("contrattoFwaDecommissioning")
	private String contrattoFwaDecommissioning;
	
	//RU_1164
	@JsonProperty("dataInizioCoinvestimento")
	private String dataInizioCoinvestimento;
	
	@JsonProperty("dataFineCoinvestimento")
	private String dataFineCoinvestimento;
	
	//Task #36345
    @JsonProperty("datiSospensioneServizio")
    private DatiSospensioneServizioInputBean datiSospensioneServizio;
    
    //SM_10433    
    @JsonProperty("flagMulticast")
    private String flagMulticast;
    
    //SM_11396
    @JsonProperty("emailOffertaFwa1GigaSardegna")
    private String emailOffertaFwa1GigaSardegna;
		
	public String getCodiceContratto() {
		return codiceContratto;
	}

	public void setCodiceContratto(String codiceContratto) {
		this.codiceContratto = codiceContratto;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getCodiceOloNumerico() {
		return codiceOloNumerico;
	}

	public void setCodiceOloNumerico(String codiceOloNumerico) {
		this.codiceOloNumerico = codiceOloNumerico;
	}

	public String getFlagAbilitato() {
		return flagAbilitato;
	}

	public void setFlagAbilitato(String flagAbilitato) {
		this.flagAbilitato = flagAbilitato;
	}

	public String getFlagFileNotify() {
		return flagFileNotify;
	}

	public void setFlagFileNotify(String flagFileNotify) {
		this.flagFileNotify = flagFileNotify;
	}

	public String getFlagValido() {
		return flagValido;
	}

	public void setFlagValido(String flagValido) {
		this.flagValido = flagValido;
	}

	public String getNomeContratto() {
		return nomeContratto;
	}

	public void setNomeContratto(String nomeContratto) {
		this.nomeContratto = nomeContratto;
	}

	public String getDataInizioValiditaContratto() {
		return dataInizioValiditaContratto;
	}

	public void setDataInizioValiditaContratto(String dataInizioValiditaContratto) {
		this.dataInizioValiditaContratto = dataInizioValiditaContratto;
	}

	public String getDataFineValiditaContratto() {
		return dataFineValiditaContratto;
	}

	public void setDataFineValiditaContratto(String dataFineValiditaContratto) {
		this.dataFineValiditaContratto = dataFineValiditaContratto;
	}

	public String getIdFamigliaOfferta() {
		return idFamigliaOfferta;
	}

	public void setIdFamigliaOfferta(String idFamigliaOfferta) {
		this.idFamigliaOfferta = idFamigliaOfferta;
	}

	public String getIdSottofamigliaOfferta() {
		return idSottofamigliaOfferta;
	}

	public void setIdSottofamigliaOfferta(String idSottofamigliaOfferta) {
		this.idSottofamigliaOfferta = idSottofamigliaOfferta;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getDataInizioAssociazioneOffertaContratto() {
		return dataInizioAssociazioneOffertaContratto;
	}

	public void setDataInizioAssociazioneOffertaContratto(String dataInizioAssociazioneOffertaContratto) {
		this.dataInizioAssociazioneOffertaContratto = dataInizioAssociazioneOffertaContratto;
	}

	public String getDataFineAssociazioneOffertaContratto() {
		return dataFineAssociazioneOffertaContratto;
	}

	public void setDataFineAssociazioneOffertaContratto(String dataFineAssociazioneOffertaContratto) {
		this.dataFineAssociazioneOffertaContratto = dataFineAssociazioneOffertaContratto;
	}

	public String getTipoProfilo() {
		return tipoProfilo;
	}

	public void setTipoProfilo(String tipoProfilo) {
		this.tipoProfilo = tipoProfilo;
	}
	
	public String getIdTipologiaContratto() {
		return idTipologiaContratto;
	}

	public void setIdTipologiaContratto(String idTipologiaContratto) {
		this.idTipologiaContratto = idTipologiaContratto;
	}

	public String getContrattoFwaInfratel() {
		return contrattoFwaInfratel;
	}

	public void setContrattoFwaInfratel(String contrattoFwaInfratel) {
		this.contrattoFwaInfratel = contrattoFwaInfratel;
	}

	public String getContrattoFwaPlus() {
		return contrattoFwaPlus;
	}

	public void setContrattoFwaPlus(String contrattoFwaPlus) {
		this.contrattoFwaPlus = contrattoFwaPlus;
	}

	public String getContrattoFwaDecommissioning() {
		return contrattoFwaDecommissioning;
	}

	public void setContrattoFwaDecommissioning(String contrattoFwaDecommissioning) {
		this.contrattoFwaDecommissioning = contrattoFwaDecommissioning;
	}

	public String getDataInizioCoinvestimento() {
		return dataInizioCoinvestimento;
	}

	public void setDataInizioCoinvestimento(String dataInizioCoinvestimento) {
		this.dataInizioCoinvestimento = dataInizioCoinvestimento;
	}

	public String getDataFineCoinvestimento() {
		return dataFineCoinvestimento;
	}

	public void setDataFineCoinvestimento(String dataFineCoinvestimento) {
		this.dataFineCoinvestimento = dataFineCoinvestimento;
	}

	public DatiSospensioneServizioInputBean getDatiSospensioneServizio() {
		return datiSospensioneServizio;
	}

	public void setDatiSospensioneServizio(DatiSospensioneServizioInputBean datiSospensioneServizio) {
		this.datiSospensioneServizio = datiSospensioneServizio;
	}

	public String getFlagMulticast() {
		return flagMulticast;
	}

	public void setFlagMulticast(String flagMulticast) {
		this.flagMulticast = flagMulticast;
	}

	public String getEmailOffertaFwa1GigaSardegna() {
		return emailOffertaFwa1GigaSardegna;
	}

	public void setEmailOffertaFwa1GigaSardegna(String emailOffertaFwa1GigaSardegna) {
		this.emailOffertaFwa1GigaSardegna = emailOffertaFwa1GigaSardegna;
	}
}
