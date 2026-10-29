package com.nttdata.tim.now.data.bean.vp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.codice.CodiceOutputBean;

public class MaxVCVPOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 4121277286249312333L;

	@JsonProperty("esito")
	private CodiceOutputBean esito;

	public CodiceOutputBean getEsito() {
		return esito;
	}

	public void setEsito(CodiceOutputBean esito) {
		this.esito = esito;
	}
}
