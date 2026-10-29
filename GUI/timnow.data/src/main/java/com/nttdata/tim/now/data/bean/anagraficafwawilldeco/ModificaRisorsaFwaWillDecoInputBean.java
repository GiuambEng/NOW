package com.nttdata.tim.now.data.bean.anagraficafwawilldeco;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class ModificaRisorsaFwaWillDecoInputBean implements Serializable {

	private static final long serialVersionUID = -6672661209386925073L;

	@JsonProperty("idRisorsaSwitchOff")
    private String idRisorsaSwitchOff;
	
	@JsonProperty("dataScadenzaSwitchOff")
    private String dataScadenzaSwitchOff;
	
	@JsonProperty("operatore")
    private String operatore;

	public String getIdRisorsaSwitchOff() {
		return idRisorsaSwitchOff;
	}

	public void setIdRisorsaSwitchOff(String idRisorsaSwitchOff) {
		this.idRisorsaSwitchOff = idRisorsaSwitchOff;
	}

	public String getDataScadenzaSwitchOff() {
		return dataScadenzaSwitchOff;
	}

	public void setDataScadenzaSwitchOff(String dataScadenzaSwitchOff) {
		this.dataScadenzaSwitchOff = dataScadenzaSwitchOff;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

}
