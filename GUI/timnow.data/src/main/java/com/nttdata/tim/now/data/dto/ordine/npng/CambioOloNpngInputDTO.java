package com.nttdata.tim.now.data.dto.ordine.npng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1203
@JsonInclude(Include.NON_NULL)
public class CambioOloNpngInputDTO implements Serializable {

	private static final long serialVersionUID = -4987853970149321943L;
	
	@JsonProperty("operatore")
    private String operatore;
	
	@JsonProperty("dn")
    private String dn;
	
	@JsonProperty("olo")
    private String olo;
	
	@JsonProperty("stato")
    private String stato;
	
	@JsonProperty("opzioneTraffico")
	private String opzioneTraffico;
	
	@JsonProperty("codiceProvisioning")
    private String codiceProvisioning;
	
	@JsonProperty("tipologiaProvisioning")
    private String tipologiaProvisioning;
	
	@JsonProperty("routingNumber")
	private String routingNumber;
	
	@JsonProperty("dsc")
    private String dsc;
	
	@JsonProperty("codiceOperatoreDonor")
    private String codiceOperatoreDonor;
		
	@JsonProperty("noteAggiuntive")
    private String noteAggiuntive;
	
	@JsonProperty("nuovoOlo")
    private NuovoOloInputDTO nuovoOlo;

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getOlo() {
		return olo;
	}

	public void setOlo(String olo) {
		this.olo = olo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getOpzioneTraffico() {
		return opzioneTraffico;
	}

	public void setOpzioneTraffico(String opzioneTraffico) {
		this.opzioneTraffico = opzioneTraffico;
	}

	public String getCodiceProvisioning() {
		return codiceProvisioning;
	}

	public void setCodiceProvisioning(String codiceProvisioning) {
		this.codiceProvisioning = codiceProvisioning;
	}

	public String getTipologiaProvisioning() {
		return tipologiaProvisioning;
	}

	public void setTipologiaProvisioning(String tipologiaProvisioning) {
		this.tipologiaProvisioning = tipologiaProvisioning;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public String getCodiceOperatoreDonor() {
		return codiceOperatoreDonor;
	}

	public void setCodiceOperatoreDonor(String codiceOperatoreDonor) {
		this.codiceOperatoreDonor = codiceOperatoreDonor;
	}

	public String getNoteAggiuntive() {
		return noteAggiuntive;
	}

	public void setNoteAggiuntive(String noteAggiuntive) {
		this.noteAggiuntive = noteAggiuntive;
	}

	public NuovoOloInputDTO getNuovoOlo() {
		return nuovoOlo;
	}

	public void setNuovoOlo(NuovoOloInputDTO nuovoOlo) {
		this.nuovoOlo = nuovoOlo;
	}
	
	

}
