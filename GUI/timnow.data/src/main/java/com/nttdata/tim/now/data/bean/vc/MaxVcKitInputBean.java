package com.nttdata.tim.now.data.bean.vc;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class MaxVcKitInputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 5046151358735276609L;

    @JsonProperty("tdCode")
	private List<String> tdCode;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;

	@JsonProperty("idOfferta")
	private String idOfferta;

	public List<String> getTdCode() {
		return tdCode;
	}

	public void setTdCode(List<String> tdCode) {
		this.tdCode = tdCode;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

}