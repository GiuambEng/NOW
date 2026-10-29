package com.nttdata.tim.now.data.bean.monitoring.koolo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class MonitoraggioKoOloOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 3232512900641975085L;

    @JsonProperty("codiceCausaleOlo")
	private String codiceCausaleOlo;

	@JsonProperty("codiceFamigliaCausale")
	private String codiceFamigliaCausale;

	@JsonProperty("estrazione1")
	private String estrazione1;

	@JsonProperty("estrazione2")
	private String estrazione2;

	@JsonProperty("estrazione3")
	private String estrazione3;

	@JsonProperty("estrazione4")
	private String estrazione4;

	@JsonProperty("estrazione5")
	private String estrazione5;

	@JsonProperty("estrazione6")
	private String estrazione6;

	@JsonProperty("estrazione7")
	private String estrazione7;

	@JsonProperty("totaleComplessivo")
	private String totaleComplessivo;

	public String getCodiceCausaleOlo() {
		return codiceCausaleOlo;
	}

	public void setCodiceCausaleOlo(String codiceCausaleOlo) {
		this.codiceCausaleOlo = codiceCausaleOlo;
	}

	public String getCodiceFamigliaCausale() {
		return codiceFamigliaCausale;
	}

	public void setCodiceFamigliaCausale(String codiceFamigliaCausale) {
		this.codiceFamigliaCausale = codiceFamigliaCausale;
	}

	public String getEstrazione1() {
		return estrazione1;
	}

	public void setEstrazione1(String estrazione1) {
		this.estrazione1 = estrazione1;
	}

	public String getEstrazione2() {
		return estrazione2;
	}

	public void setEstrazione2(String estrazione2) {
		this.estrazione2 = estrazione2;
	}

	public String getEstrazione3() {
		return estrazione3;
	}

	public void setEstrazione3(String estrazione3) {
		this.estrazione3 = estrazione3;
	}

	public String getEstrazione4() {
		return estrazione4;
	}

	public void setEstrazione4(String estrazione4) {
		this.estrazione4 = estrazione4;
	}

	public String getEstrazione5() {
		return estrazione5;
	}

	public void setEstrazione5(String estrazione5) {
		this.estrazione5 = estrazione5;
	}

	public String getEstrazione6() {
		return estrazione6;
	}

	public void setEstrazione6(String estrazione6) {
		this.estrazione6 = estrazione6;
	}

	public String getEstrazione7() {
		return estrazione7;
	}

	public void setEstrazione7(String estrazione7) {
		this.estrazione7 = estrazione7;
	}

	public String getTotaleComplessivo() {
		return totaleComplessivo;
	}

	public void setTotaleComplessivo(String totaleComplessivo) {
		this.totaleComplessivo = totaleComplessivo;
	}

}