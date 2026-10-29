package com.nttdata.tim.now.data.dto.ordine.fiberstream;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1452
@JsonInclude(Include.NON_NULL)
public class CodiceVlanFiberstreamInputDTO implements Serializable {

	private static final long serialVersionUID = 139914003338765939L;

	@JsonProperty("codOloAgcom")
    private String codOloAgcom;
	
	@JsonProperty("provincia")
    private String provincia;
	
	@JsonProperty("codiceVlan")
	private String codiceVlan;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodiceVlan() {
		return codiceVlan;
	}

	public void setCodiceVlan(String codiceVlan) {
		this.codiceVlan = codiceVlan;
	}
}
