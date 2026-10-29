package com.nttdata.tim.now.data.dto.anagraficafwawilldeco;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class RisorseFwaWillDecoListItemOutputDTO implements Serializable {

	private static final long serialVersionUID = -7362528289475902836L;

	@JsonProperty("dataScadenzaSwitchOff")
    private String dataScadenzaSwitchOff;
	
    @JsonProperty("idRisorsaSwitchOff")
    private String idRisorsaSwitchOff;
    
    @JsonProperty("statoMigrato")
    private String statoMigrato;

	public String getDataScadenzaSwitchOff() {
		return dataScadenzaSwitchOff;
	}

	public void setDataScadenzaSwitchOff(String dataScadenzaSwitchOff) {
		this.dataScadenzaSwitchOff = dataScadenzaSwitchOff;
	}

	public String getIdRisorsaSwitchOff() {
		return idRisorsaSwitchOff;
	}

	public void setIdRisorsaSwitchOff(String idRisorsaSwitchOff) {
		this.idRisorsaSwitchOff = idRisorsaSwitchOff;
	}

	public String getStatoMigrato() {
		return statoMigrato;
	}

	public void setStatoMigrato(String statoMigrato) {
		this.statoMigrato = statoMigrato;
	}
    
}
