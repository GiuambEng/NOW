package com.nttdata.tim.now.data.bean.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//SM_10516
@JsonInclude(Include.NON_NULL)
public class DetokenizzaXmlInputBean implements Serializable {

	private static final long serialVersionUID = -6610071552797320355L;

	@JsonProperty("flagDetok")
	private String flagDetok;
	
	@JsonProperty("flagTokFittizia")
	private String flagTokFittizia;
	
	@JsonProperty("pattern")
	private String pattern;
	
	@JsonProperty("codOloAgcom")
	private String codOloAgcom;
	
	@JsonProperty("codOrdineOlo")
	private String codOrdineOlo;
	
	@JsonProperty("idOfferta")
	private String idOfferta;
	
	@JsonProperty("lavorazione")
	private String lavorazione;
	
	@JsonProperty("codOrdineTi")
	private String codOrdineTi;
	
	@JsonProperty("operatore")
	private String operatore;
	
	@JsonProperty("IPClient")
	private String ipClient;	
	
	@JsonProperty("tracciatoXml")
	private String tracciatoXml;
	
	//SM_10587
	@JsonProperty("idRichiestaOlo")
	private String idRichiestaOlo;

	public String getFlagDetok() {
		return flagDetok;
	}

	public String getFlagTokFittizia() {
		return flagTokFittizia;
	}

	public String getPattern() {
		return pattern;
	}

	public String getCodOrdineOlo() {
		return codOrdineOlo;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public String getCodOrdineTi() {
		return codOrdineTi;
	}

	public String getOperatore() {
		return operatore;
	}

	public String getIpClient() {
		return ipClient;
	}

	public void setFlagDetok(String flagDetok) {
		this.flagDetok = flagDetok;
	}

	public void setFlagTokFittizia(String flagTokFittizia) {
		this.flagTokFittizia = flagTokFittizia;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setCodOrdineOlo(String codOrdineOlo) {
		this.codOrdineOlo = codOrdineOlo;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public void setCodOrdineTi(String codOrdineTi) {
		this.codOrdineTi = codOrdineTi;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public void setIpClient(String ipClient) {
		this.ipClient = ipClient;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public String getTracciatoXml() {
		return tracciatoXml;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public void setTracciatoXml(String tracciatoXml) {
		this.tracciatoXml = tracciatoXml;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}

	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
	}
	
}
