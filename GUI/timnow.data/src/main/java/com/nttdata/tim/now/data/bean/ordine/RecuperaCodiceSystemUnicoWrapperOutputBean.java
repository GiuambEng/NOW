package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1428
public class RecuperaCodiceSystemUnicoWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -2733523775213677207L;
	
	@JsonProperty("outputCodSystemUnico")
	private List<RecuperaCodiceSystemUnicoOutputBean> outputCodSystemUnico;

	public List<RecuperaCodiceSystemUnicoOutputBean> getOutputCodSystemUnico() {
		return outputCodSystemUnico;
	}

	public void setOutputCodSystemUnico(List<RecuperaCodiceSystemUnicoOutputBean> outputCodSystemUnico) {
		this.outputCodSystemUnico = outputCodSystemUnico;
	}

}
