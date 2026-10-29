package com.nttdata.tim.now.data.bean.ordine.npng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1203
@JsonInclude(Include.NON_NULL)
public class DettaglioAssetNpngOutputBean implements Serializable {

	private static final long serialVersionUID = -5572235451391562044L;

	@JsonProperty("noteAggiuntive")
	private String noteAggiuntive;
	
	@JsonProperty("stato")
	private String stato;
	
	@JsonProperty("routingNumber")
	private String routingNumber;
	
	@JsonProperty("olo")
	private String olo;	
	
	@JsonProperty("codiceProvisioning")
	private String codiceProvisioning;
	
	@JsonProperty("opzioneTraffico")
	private String opzioneTraffico;
	
	@JsonProperty("dsc")
	private String dsc;
	
	@JsonProperty("tipologiaProvisioning")
	private String tipologiaProvisioning;
	
	@JsonProperty("dn")
	private String dn;
	
	@JsonProperty("codiceOperatoreDonor")
	private String codiceOperatoreDonor;

	public String getNoteAggiuntive() {
		return noteAggiuntive;
	}

	public void setNoteAggiuntive(String noteAggiuntive) {
		this.noteAggiuntive = noteAggiuntive;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getOlo() {
		return olo;
	}

	public void setOlo(String olo) {
		this.olo = olo;
	}

	public String getCodiceProvisioning() {
		return codiceProvisioning;
	}

	public void setCodiceProvisioning(String codiceProvisioning) {
		this.codiceProvisioning = codiceProvisioning;
	}

	public String getOpzioneTraffico() {
		return opzioneTraffico;
	}

	public void setOpzioneTraffico(String opzioneTraffico) {
		this.opzioneTraffico = opzioneTraffico;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public String getTipologiaProvisioning() {
		return tipologiaProvisioning;
	}

	public void setTipologiaProvisioning(String tipologiaProvisioning) {
		this.tipologiaProvisioning = tipologiaProvisioning;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getCodiceOperatoreDonor() {
		return codiceOperatoreDonor;
	}

	public void setCodiceOperatoreDonor(String codiceOperatoreDonor) {
		this.codiceOperatoreDonor = codiceOperatoreDonor;
	}
}

