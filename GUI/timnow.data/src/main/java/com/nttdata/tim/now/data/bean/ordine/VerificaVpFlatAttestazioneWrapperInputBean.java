package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaVpFlatAttestazioneWrapperInputBean implements Serializable {

	private static final long serialVersionUID = 5927671770302301870L;
	
	@JsonProperty("vc")
	private List<VerificaVpFlatAttestazioneInputBean> vc;
	
	@JsonProperty("codOLOAgcom")
	private String codOloAgcom;

	public List<VerificaVpFlatAttestazioneInputBean> getVc() {
		return vc;
	}

	public void setVc(List<VerificaVpFlatAttestazioneInputBean> vc) {
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
		VerificaVpFlatAttestazioneWrapperInputBean other = (VerificaVpFlatAttestazioneWrapperInputBean) obj;
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
		return "VerificaVpFlatAttestazioneWrapperInputBean [vc=" + vc + ", codOloAgcom=" + codOloAgcom + "]";
	}

}
