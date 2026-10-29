package com.nttdata.tim.now.data.dto.pps;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class AmministrazioneDatiOutputDTO implements Serializable {

	private static final long serialVersionUID = -7166183144566018899L;

	@JsonProperty("ID_PPS_TIPOLG_REPORT")
	private String idTipologiaReport;

	@JsonProperty("Tipologi_Report")
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
