package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1428
public class RecuperaTipologiaImpresaOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 1070468783820333840L;
	
	@JsonProperty("outputTipologiaImpresa")
	private List<String> tipologiaImpresa;

	public List<String> getTipologiaImpresa() {
		return tipologiaImpresa;
	}

	public void setTipologiaImpresa(List<String> tipologiaImpresa) {
		this.tipologiaImpresa = tipologiaImpresa;
	}

}
