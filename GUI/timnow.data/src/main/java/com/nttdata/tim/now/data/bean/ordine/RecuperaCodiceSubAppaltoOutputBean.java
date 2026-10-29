package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1393
public class RecuperaCodiceSubAppaltoOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 6907801160670831831L;

	@JsonProperty("codSubAppalto")
	private List<String> codSubAppalto;

	public List<String> getCodSubAppalto() {
		return codSubAppalto;
	}

	public void setCodSubAppalto(List<String> codSubAppalto) {
		this.codSubAppalto = codSubAppalto;
	}
}
