package com.nttdata.tim.now.data.dto.anagraficafwawilldeco;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class DettaglioRisorsaFwaWillDecoOutputDTO implements Serializable {

	private static final long serialVersionUID = -1715174025841276730L;

	@JsonProperty("operatoreUltimaModifica")
    private String operatoreUltimaModifica;
    
	@JsonProperty("dataInserimento")
    private String dataInserimento;
	
	@JsonProperty("operatoreInserimento")
    private String operatoreInserimento;
	
	@JsonProperty("dataScadenzaSwitchOff")
    private String dataScadenzaSwitchOff;
	
	@JsonProperty("dataUltimaModifica")
    private String dataUltimaModifica;
	
	@JsonProperty("idRisorsaSwitchOff")
    private String idRisorsaSwitchOff;
    
    @JsonProperty("statoMigrato")
    private String statoMigrato;

	public String getOperatoreUltimaModifica() {
		return operatoreUltimaModifica;
	}

	public void setOperatoreUltimaModifica(String operatoreUltimaModifica) {
		this.operatoreUltimaModifica = operatoreUltimaModifica;
	}

	public String getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(String dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getOperatoreInserimento() {
		return operatoreInserimento;
	}

	public void setOperatoreInserimento(String operatoreInserimento) {
		this.operatoreInserimento = operatoreInserimento;
	}

	public String getDataScadenzaSwitchOff() {
		return dataScadenzaSwitchOff;
	}

	public void setDataScadenzaSwitchOff(String dataScadenzaSwitchOff) {
		this.dataScadenzaSwitchOff = dataScadenzaSwitchOff;
	}

	public String getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(String dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
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
