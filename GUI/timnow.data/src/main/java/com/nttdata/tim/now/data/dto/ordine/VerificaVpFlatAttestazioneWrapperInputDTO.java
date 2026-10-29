package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaVpFlatAttestazioneWrapperInputDTO implements Serializable {
	
	private static final long serialVersionUID = 7655611276406701449L;
	
	@JsonProperty("vc")
	private List<VerificaVpFlatAttestazioneInputDTO> vc;
	
	@JsonProperty("codOLOAgcom")
	private String codOloAgcom;

	public List<VerificaVpFlatAttestazioneInputDTO> getVc() {
		return vc;
	}

	public void setVc(List<VerificaVpFlatAttestazioneInputDTO> vc) {
		this.vc = vc;
	}

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
		result = prime * result + ((vc == null) ? 0 : vc.hashCode());
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
		VerificaVpFlatAttestazioneWrapperInputDTO other = (VerificaVpFlatAttestazioneWrapperInputDTO) obj;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (vc == null) {
			if (other.vc != null)
				return false;
		} else if (!vc.equals(other.vc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaVpFlatAttestazioneWrapperInputDTO [vc=" + vc + ", codOloAgcom=" + codOloAgcom + "]";
	}

}
