package com.nttdata.tim.now.data.dto.ordine.fiberstream;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1452
@JsonInclude(Include.NON_NULL)
public class CodiceVlanFiberstreamOutputDTO implements Serializable {

	private static final long serialVersionUID = 2831036771408091748L;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;

	@JsonProperty("codVlan")
	private String codVlan;

	@JsonProperty("provincia")
	private String provincia;

	@JsonProperty("siglaProvincia")
	private String siglaProvincia;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getCodVlan() {
		return codVlan;
	}

	public void setCodVlan(String codVlan) {
		this.codVlan = codVlan;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSiglaProvincia() {
		return siglaProvincia;
	}

	public void setSiglaProvincia(String siglaProvincia) {
		this.siglaProvincia = siglaProvincia;
	}

}
