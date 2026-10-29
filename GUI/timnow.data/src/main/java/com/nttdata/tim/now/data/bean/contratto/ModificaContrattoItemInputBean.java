package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL) 
public class ModificaContrattoItemInputBean implements Serializable{

	private static final long serialVersionUID = 8051492375415417074L;

	@JsonProperty("idContratto")
    private String idContratto;
    
    @JsonProperty("idContrattoOffertaCatalogo")
    private String idContrattoOffertaCatalogo;
    
    @JsonProperty("flagAbilitato")
    private String flagAbilitato;
    
    @JsonProperty("flagFileNotify")
    private String flagFileNotify;
    
    @JsonProperty("flagValido")
    private String flagValido;
    
    @JsonProperty("dataFineValiditaContratto")
    private String dataFineValiditaContratto;

    @JsonProperty("operatore")
    private String operatore;
    
    @JsonProperty("dataFineAssociazioneOffertaContratto")
    private String dataFineAssociazioneOffertaContratto;
    
    @JsonProperty("tipoProfilo")
    private String tipoProfilo;
    
	//SM_9996
	@JsonProperty("contrattoFwaInfratel")
	private String contrattoFwaInfratel;
	
	@JsonProperty("contrattoFwaPlus")
	private String contrattoFwaPlus;
	
	@JsonProperty("contrattoFwaDecommissioning")
	private String contrattoFwaDecommissioning;
	
	//SM_9996
    @JsonProperty("dataInizioValiditaContratto")
    private String dataInizioValiditaContratto;
    
	//RU_1164
	@JsonProperty("dataInizioCoinvestimento")
	private String dataInizioCoinvestimento;
	
	@JsonProperty("dataFineCoinvestimento")
	private String dataFineCoinvestimento;
	
	//RU_1180
    @JsonProperty("bouquet")
    private String bouquet;
    
    //SM_10292
    @JsonProperty("datiSospensioneServizio")
    private DatiSospensioneServizioInputBean datiSospensioneServizio;
    
    //SM_10433
    @JsonProperty("flagMulticast")
    private String flagMulticast;
    
    //SM_11396
    @JsonProperty("emailOffertaFwa1GigaSardegna")
    private String emailOffertaFwa1GigaSardegna;

    public String getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(String idContratto) {
		this.idContratto = idContratto;
	}

	public String getIdContrattoOffertaCatalogo() {
		return idContrattoOffertaCatalogo;
	}

	public void setIdContrattoOffertaCatalogo(String idContrattoOffertaCatalogo) {
		this.idContrattoOffertaCatalogo = idContrattoOffertaCatalogo;
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

	public String getDataFineValiditaContratto() {
		return dataFineValiditaContratto;
	}

	public void setDataFineValiditaContratto(String dataFineValiditaContratto) {
		this.dataFineValiditaContratto = dataFineValiditaContratto;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
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

	public String getContrattoFwaInfratel() {
		return contrattoFwaInfratel;
	}

	public String getContrattoFwaPlus() {
		return contrattoFwaPlus;
	}

	public String getContrattoFwaDecommissioning() {
		return contrattoFwaDecommissioning;
	}

	public void setContrattoFwaInfratel(String contrattoFwaInfratel) {
		this.contrattoFwaInfratel = contrattoFwaInfratel;
	}

	public void setContrattoFwaPlus(String contrattoFwaPlus) {
		this.contrattoFwaPlus = contrattoFwaPlus;
	}

	public void setContrattoFwaDecommissioning(String contrattoFwaDecommissioning) {
		this.contrattoFwaDecommissioning = contrattoFwaDecommissioning;
	}

	public String getDataInizioValiditaContratto() {
		return dataInizioValiditaContratto;
	}

	public void setDataInizioValiditaContratto(String dataInizioValiditaContratto) {
		this.dataInizioValiditaContratto = dataInizioValiditaContratto;
	}


	public String getDataInizioCoinvestimento() {
		return dataInizioCoinvestimento;
	}

	public String getDataFineCoinvestimento() {
		return dataFineCoinvestimento;
	}

	public void setDataInizioCoinvestimento(String dataInizioCoinvestimento) {
		this.dataInizioCoinvestimento = dataInizioCoinvestimento;
	}

	public void setDataFineCoinvestimento(String dataFineCoinvestimento) {
		this.dataFineCoinvestimento = dataFineCoinvestimento;
	}

	public String getBouquet() {
		return bouquet;
	}

	public void setBouquet(String bouquet) {
		this.bouquet = bouquet;
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
