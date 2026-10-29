package com.nttdata.tim.now.data.dto.ordine.eolo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1475
@JsonInclude(Include.NON_NULL)
public class CodiceVlanEoloFwaInputDTO implements Serializable {

	private static final long serialVersionUID = 279635025444547348L;
	
	@JsonProperty("idVlanOlolight")
    private String idVlanOlolight;
	
	@JsonProperty("idVlanEololight")
    private String idVlanEololight;
	
	@JsonProperty("svlanCodelight")
    private String svlanCodelight;
	
	@JsonProperty("codOloAgcom")
	private String codOloAgcom;

	public String getIdVlanOlolight() {
		return idVlanOlolight;
	}

	public void setIdVlanOlolight(String idVlanOlolight) {
		this.idVlanOlolight = idVlanOlolight;
	}

	public String getIdVlanEololight() {
		return idVlanEololight;
	}

	public void setIdVlanEololight(String idVlanEololight) {
		this.idVlanEololight = idVlanEololight;
	}

	public String getSvlanCodelight() {
		return svlanCodelight;
	}

	public void setSvlanCodelight(String svlanCodelight) {
		this.svlanCodelight = svlanCodelight;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

}
