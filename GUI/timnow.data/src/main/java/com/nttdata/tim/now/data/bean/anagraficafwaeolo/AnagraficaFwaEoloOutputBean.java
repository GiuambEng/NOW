package com.nttdata.tim.now.data.bean.anagraficafwaeolo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1479
@JsonInclude(Include.NON_NULL)
public class AnagraficaFwaEoloOutputBean implements Serializable {

	private static final long serialVersionUID = -1124476567264868271L;

	@JsonProperty("idVlanOlo")
    private String idVlanOlo;
	
    @JsonProperty("codOloAgcom")
    private String codOloAgcom;
	
    @JsonProperty("dataInizioValidita")
    private String dataInizioValidita;
	
    @JsonProperty("dataFineValidita")
    private String dataFineValidita;
    
    @JsonProperty("idVlanEolo")
    private String idVlanEolo;
    
    @JsonProperty("svlanCode")
    private String svlanCode;

	public String getIdVlanOlo() {
		return idVlanOlo;
	}

	public void setIdVlanOlo(String idVlanOlo) {
		this.idVlanOlo = idVlanOlo;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(String dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public String getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(String dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public String getIdVlanEolo() {
		return idVlanEolo;
	}

	public void setIdVlanEolo(String idVlanEolo) {
		this.idVlanEolo = idVlanEolo;
	}

	public String getSvlanCode() {
		return svlanCode;
	}

	public void setSvlanCode(String svlanCode) {
		this.svlanCode = svlanCode;
	}
}
