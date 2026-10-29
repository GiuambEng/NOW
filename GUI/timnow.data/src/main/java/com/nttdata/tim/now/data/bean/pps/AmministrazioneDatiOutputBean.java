package com.nttdata.tim.now.data.bean.pps;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class AmministrazioneDatiOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -8127358585764289042L;

    @JsonProperty("id")
	private String idTipologiaReport;

	@JsonProperty("nome")
	private String tipologiaReport;

	public String getIdTipologiaReport() {
		return idTipologiaReport;
	}

	public void setIdTipologiaReport(String idTipologiaReport) {
		this.idTipologiaReport = idTipologiaReport;
	}

	public String getTipologiaReport() {
		return tipologiaReport;
	}

	public void setTipologiaReport(String tipologiaReport) {
		this.tipologiaReport = tipologiaReport;
	}

}