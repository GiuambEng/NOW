package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1150
//RU_1274
@JsonInclude(Include.NON_NULL)
public class RecuperaIdGponInputDTO implements Serializable {

	private static final long serialVersionUID = 882518887223085866L;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecuperaIdGponInputDTO other = (RecuperaIdGponInputDTO) obj;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaIdGponInputDTO [codOloAgcom=" + codOloAgcom + "]";
	}

}
