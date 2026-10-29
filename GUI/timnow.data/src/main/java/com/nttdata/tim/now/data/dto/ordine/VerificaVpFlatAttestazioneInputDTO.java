package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaVpFlatAttestazioneInputDTO implements Serializable {
	
	private static final long serialVersionUID = 8723689104958875328L;

	@JsonProperty("vpCode")
	private String vpCode;
	
	@JsonProperty("tipoBanda")
    private String tipoBanda;
	
	@JsonProperty("tipoProfiloVC")
    private String tipoProfiloVC;
	
	@JsonProperty("idVc")
	private String idVc;

	public String getVpCode() {
		return vpCode;
	}

	public void setVpCode(String vpCode) {
		this.vpCode = vpCode;
	}

	public String getTipoBanda() {
		return tipoBanda;
	}

	public void setTipoBanda(String tipoBanda) {
		this.tipoBanda = tipoBanda;
	}

	public String getTipoProfiloVC() {
		return tipoProfiloVC;
	}

	public void setTipoProfiloVC(String tipoProfiloVC) {
		this.tipoProfiloVC = tipoProfiloVC;
	}

	public String getIdVc() {
		return idVc;
	}

	public void setIdVc(String idVc) {
		this.idVc = idVc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVc == null) ? 0 : idVc.hashCode());
		result = prime * result + ((tipoBanda == null) ? 0 : tipoBanda.hashCode());
		result = prime * result + ((tipoProfiloVC == null) ? 0 : tipoProfiloVC.hashCode());
		result = prime * result + ((vpCode == null) ? 0 : vpCode.hashCode());
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
		VerificaVpFlatAttestazioneInputDTO other = (VerificaVpFlatAttestazioneInputDTO) obj;
		if (idVc == null) {
			if (other.idVc != null)
				return false;
		} else if (!idVc.equals(other.idVc))
			return false;
		if (tipoBanda == null) {
			if (other.tipoBanda != null)
				return false;
		} else if (!tipoBanda.equals(other.tipoBanda))
			return false;
		if (tipoProfiloVC == null) {
			if (other.tipoProfiloVC != null)
				return false;
		} else if (!tipoProfiloVC.equals(other.tipoProfiloVC))
			return false;
		if (vpCode == null) {
			if (other.vpCode != null)
				return false;
		} else if (!vpCode.equals(other.vpCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaVpFlatAttestazioneInputDTO [vpCode=" + vpCode + ", tipoBanda=" + tipoBanda + ", tipoProfiloVC="
				+ tipoProfiloVC + ", idVc=" + idVc + "]";
	}
	
}
