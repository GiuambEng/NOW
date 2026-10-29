package com.nttdata.tim.now.data.bean.monitoring.notificheolo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class MonitoraggioNotificheOloOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -9010952533860642188L;

    @JsonProperty("offerta")
	private String offerta;

	@JsonProperty("tipologiaOLO")
	private String tipologiaOLO;

	@JsonProperty("totAttese")
	private String totAttese;

	@JsonProperty("totInUscita")
	private String totInUscita;

	@JsonProperty("totInUscitaFuoriSLA")
	private String totInUscitaFuoriSLA;

	@JsonProperty("totInUscitaInSLA")
	private String totInUscitaInSLA;

	@JsonProperty("totInErrore")
	private String totInErrore;

	@JsonProperty("totInErroreInSLA")
	private String totInErroreInSLA;

	@JsonProperty("totInErroreFuoriSLA")
	private String totInErroreFuoriSLA;

	@JsonProperty("totProdotte")
	private String totProdotte;

	@JsonProperty("totProdotteInSLA")
	private String totProdotteInSLA;

	@JsonProperty("totProdotteFuoriSLA")
	private String totProdotteFuoriSLA;

	@JsonProperty("totInviate")
	private String totInviate;

	@JsonProperty("totInviateInSLA")
	private String totInviateInSLA;

	@JsonProperty("totInviateFuoriSLA")
	private String totInviateFuoriSLA;

	@JsonProperty("totMancanti")
	private String totMancanti;

	@JsonProperty("totMancantiInSLA")
	private String totMancantiInSLA;

	@JsonProperty("totMancantiFuoriSLA")
	private String totMancantiFuoriSLA;

	@JsonProperty("totNonAttese")
	private String totNonAttese;

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getTipologiaOLO() {
		return tipologiaOLO;
	}

	public void setTipologiaOLO(String tipologiaOLO) {
		this.tipologiaOLO = tipologiaOLO;
	}

	public String getTotAttese() {
		return totAttese;
	}

	public void setTotAttese(String totAttese) {
		this.totAttese = totAttese;
	}

	public String getTotInUscita() {
		return totInUscita;
	}

	public void setTotInUscita(String totInUscita) {
		this.totInUscita = totInUscita;
	}

	public String getTotInUscitaFuoriSLA() {
		return totInUscitaFuoriSLA;
	}

	public void setTotInUscitaFuoriSLA(String totInUscitaFuoriSLA) {
		this.totInUscitaFuoriSLA = totInUscitaFuoriSLA;
	}

	public String getTotInUscitaInSLA() {
		return totInUscitaInSLA;
	}

	public void setTotInUscitaInSLA(String totInUscitaInSLA) {
		this.totInUscitaInSLA = totInUscitaInSLA;
	}

	public String getTotInErrore() {
		return totInErrore;
	}

	public void setTotInErrore(String totInErrore) {
		this.totInErrore = totInErrore;
	}

	public String getTotInErroreInSLA() {
		return totInErroreInSLA;
	}

	public void setTotInErroreInSLA(String totInErroreInSLA) {
		this.totInErroreInSLA = totInErroreInSLA;
	}

	public String getTotInErroreFuoriSLA() {
		return totInErroreFuoriSLA;
	}

	public void setTotInErroreFuoriSLA(String totInErroreFuoriSLA) {
		this.totInErroreFuoriSLA = totInErroreFuoriSLA;
	}

	public String getTotProdotte() {
		return totProdotte;
	}

	public void setTotProdotte(String totProdotte) {
		this.totProdotte = totProdotte;
	}

	public String getTotProdotteInSLA() {
		return totProdotteInSLA;
	}

	public void setTotProdotteInSLA(String totProdotteInSLA) {
		this.totProdotteInSLA = totProdotteInSLA;
	}

	public String getTotProdotteFuoriSLA() {
		return totProdotteFuoriSLA;
	}

	public void setTotProdotteFuoriSLA(String totProdotteFuoriSLA) {
		this.totProdotteFuoriSLA = totProdotteFuoriSLA;
	}

	public String getTotInviate() {
		return totInviate;
	}

	public void setTotInviate(String totInviate) {
		this.totInviate = totInviate;
	}

	public String getTotInviateInSLA() {
		return totInviateInSLA;
	}

	public void setTotInviateInSLA(String totInviateInSLA) {
		this.totInviateInSLA = totInviateInSLA;
	}

	public String getTotInviateFuoriSLA() {
		return totInviateFuoriSLA;
	}

	public void setTotInviateFuoriSLA(String totInviateFuoriSLA) {
		this.totInviateFuoriSLA = totInviateFuoriSLA;
	}

	public String getTotMancanti() {
		return totMancanti;
	}

	public void setTotMancanti(String totMancanti) {
		this.totMancanti = totMancanti;
	}

	public String getTotMancantiInSLA() {
		return totMancantiInSLA;
	}

	public void setTotMancantiInSLA(String totMancantiInSLA) {
		this.totMancantiInSLA = totMancantiInSLA;
	}

	public String getTotMancantiFuoriSLA() {
		return totMancantiFuoriSLA;
	}

	public void setTotMancantiFuoriSLA(String totMancantiFuoriSLA) {
		this.totMancantiFuoriSLA = totMancantiFuoriSLA;
	}

	public String getTotNonAttese() {
		return totNonAttese;
	}

	public void setTotNonAttese(String totNonAttese) {
		this.totNonAttese = totNonAttese;
	}

}