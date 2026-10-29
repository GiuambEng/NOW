package com.nttdata.tim.now.data.bean.monitoring.warning;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class MonitoraggioKoWarningOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -5833146207351438525L;

    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataEstrazione")
	private Date dataEstrazione;

	@JsonProperty("totale")
	private String totale;

	@JsonProperty("causaleErrore")
	private String causaleErrore;

	public Date getDataEstrazione() {
		return dataEstrazione;
	}

	public void setDataEstrazione(Date dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}

	public String getTotale() {
		return totale;
	}

	public void setTotale(String totale) {
		this.totale = totale;
	}

	public String getCausaleErrore() {
		return causaleErrore;
	}

	public void setCausaleErrore(String causaleErrore) {
		this.causaleErrore = causaleErrore;
	}

}