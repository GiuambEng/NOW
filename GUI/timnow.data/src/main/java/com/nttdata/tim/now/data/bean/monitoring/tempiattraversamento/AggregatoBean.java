package com.nttdata.tim.now.data.bean.monitoring.tempiattraversamento;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class AggregatoBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -8379892280238586692L;

    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataEstrazione")
	private Date dataEstrazione;

	@JsonProperty("ambito")
	private String ambito;

	@JsonProperty("servizio")
	private String servizio;

	@JsonProperty("ordinativiInSlaDtu")
	private String ordinativiInSlaDtu;

	@JsonProperty("percentualeOrdinativiInSlaDtu")
	private String percentualeOrdinativiInSlaDtu;

	@JsonProperty("ordinativiFuoriSlaDtu")
	private String ordinativiFuoriSlaDtu;

	@JsonProperty("percentualeOrdinativiFuoriSlaDtu")
	private String percentualeOrdinativiFuoriSlaDtu;

	@JsonProperty("ordinativiRimodulatiDtu")
	private String ordinativiRimodulatiDtu;

	@JsonProperty("percentualeOrdinativiRimodulatiDtu")
	private String percentualeOrdinativiRimodulatiDtu;

	@JsonProperty("ordinativiInSlaNow")
	private String ordinativiInSlaNow;

	@JsonProperty("percentualeOrdinativiInSlaNow")
	private String percentualeOrdinativiInSlaNow;

	@JsonProperty("ordinativiFuoriSlaNow")
	private String ordinativiFuoriSlaNow;

	@JsonProperty("percentualeOrdinativiFuoriSlaNow")
	private String percentualeOrdinativiFuoriSlaNow;

	@JsonProperty("ordinativiRimodulatiNow")
	private String ordinativiRimodulatiNow;

	@JsonProperty("percentualeOrdinativiRimodulatiNow")
	private String percentualeOrdinativiRimodulatiNow;

	@JsonProperty("ordinativiInSlaE2E")
	private String ordinativiInSlaE2E;

	@JsonProperty("percentualeOrdinativiInSlaE2E")
	private String percentualeOrdinativiInSlaE2E;

	@JsonProperty("ordinativiFuoriSlaE2E")
	private String ordinativiFuoriSlaE2E;

	@JsonProperty("percentualeOrdinativiFuoriSlaE2E")
	private String percentualeOrdinativiFuoriSlaE2E;

	public Date getDataEstrazione() {
		return dataEstrazione;
	}

	public void setDataEstrazione(Date dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public String getServizio() {
		return servizio;
	}

	public void setServizio(String servizio) {
		this.servizio = servizio;
	}

	public String getOrdinativiInSlaDtu() {
		return ordinativiInSlaDtu;
	}

	public void setOrdinativiInSlaDtu(String ordinativiInSlaDtu) {
		this.ordinativiInSlaDtu = ordinativiInSlaDtu;
	}

	public String getPercentualeOrdinativiInSlaDtu() {
		return percentualeOrdinativiInSlaDtu;
	}

	public void setPercentualeOrdinativiInSlaDtu(String percentualeOrdinativiInSlaDtu) {
		this.percentualeOrdinativiInSlaDtu = percentualeOrdinativiInSlaDtu;
	}

	public String getOrdinativiFuoriSlaDtu() {
		return ordinativiFuoriSlaDtu;
	}

	public void setOrdinativiFuoriSlaDtu(String ordinativiFuoriSlaDtu) {
		this.ordinativiFuoriSlaDtu = ordinativiFuoriSlaDtu;
	}

	public String getPercentualeOrdinativiFuoriSlaDtu() {
		return percentualeOrdinativiFuoriSlaDtu;
	}

	public void setPercentualeOrdinativiFuoriSlaDtu(String percentualeOrdinativiFuoriSlaDtu) {
		this.percentualeOrdinativiFuoriSlaDtu = percentualeOrdinativiFuoriSlaDtu;
	}

	public String getOrdinativiRimodulatiDtu() {
		return ordinativiRimodulatiDtu;
	}

	public void setOrdinativiRimodulatiDtu(String ordinativiRimodulatiDtu) {
		this.ordinativiRimodulatiDtu = ordinativiRimodulatiDtu;
	}

	public String getPercentualeOrdinativiRimodulatiDtu() {
		return percentualeOrdinativiRimodulatiDtu;
	}

	public void setPercentualeOrdinativiRimodulatiDtu(String percentualeOrdinativiRimodulatiDtu) {
		this.percentualeOrdinativiRimodulatiDtu = percentualeOrdinativiRimodulatiDtu;
	}

	public String getOrdinativiInSlaNow() {
		return ordinativiInSlaNow;
	}

	public void setOrdinativiInSlaNow(String ordinativiInSlaNow) {
		this.ordinativiInSlaNow = ordinativiInSlaNow;
	}

	public String getPercentualeOrdinativiInSlaNow() {
		return percentualeOrdinativiInSlaNow;
	}

	public void setPercentualeOrdinativiInSlaNow(String percentualeOrdinativiInSlaNow) {
		this.percentualeOrdinativiInSlaNow = percentualeOrdinativiInSlaNow;
	}

	public String getOrdinativiFuoriSlaNow() {
		return ordinativiFuoriSlaNow;
	}

	public void setOrdinativiFuoriSlaNow(String ordinativiFuoriSlaNow) {
		this.ordinativiFuoriSlaNow = ordinativiFuoriSlaNow;
	}

	public String getPercentualeOrdinativiFuoriSlaNow() {
		return percentualeOrdinativiFuoriSlaNow;
	}

	public void setPercentualeOrdinativiFuoriSlaNow(String percentualeOrdinativiFuoriSlaNow) {
		this.percentualeOrdinativiFuoriSlaNow = percentualeOrdinativiFuoriSlaNow;
	}

	public String getOrdinativiRimodulatiNow() {
		return ordinativiRimodulatiNow;
	}

	public void setOrdinativiRimodulatiNow(String ordinativiRimodulatiNow) {
		this.ordinativiRimodulatiNow = ordinativiRimodulatiNow;
	}

	public String getPercentualeOrdinativiRimodulatiNow() {
		return percentualeOrdinativiRimodulatiNow;
	}

	public void setPercentualeOrdinativiRimodulatiNow(String percentualeOrdinativiRimodulatiNow) {
		this.percentualeOrdinativiRimodulatiNow = percentualeOrdinativiRimodulatiNow;
	}

	public String getOrdinativiInSlaE2E() {
		return ordinativiInSlaE2E;
	}

	public void setOrdinativiInSlaE2E(String ordinativiInSlaE2E) {
		this.ordinativiInSlaE2E = ordinativiInSlaE2E;
	}

	public String getPercentualeOrdinativiInSlaE2E() {
		return percentualeOrdinativiInSlaE2E;
	}

	public void setPercentualeOrdinativiInSlaE2E(String percentualeOrdinativiInSlaE2E) {
		this.percentualeOrdinativiInSlaE2E = percentualeOrdinativiInSlaE2E;
	}

	public String getOrdinativiFuoriSlaE2E() {
		return ordinativiFuoriSlaE2E;
	}

	public void setOrdinativiFuoriSlaE2E(String ordinativiFuoriSlaE2E) {
		this.ordinativiFuoriSlaE2E = ordinativiFuoriSlaE2E;
	}

	public String getPercentualeOrdinativiFuoriSlaE2E() {
		return percentualeOrdinativiFuoriSlaE2E;
	}

	public void setPercentualeOrdinativiFuoriSlaE2E(String percentualeOrdinativiFuoriSlaE2E) {
		this.percentualeOrdinativiFuoriSlaE2E = percentualeOrdinativiFuoriSlaE2E;
	}

}