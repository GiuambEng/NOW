package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1184
public class VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 583394521379385117L;
	
	@JsonProperty("VerificaStatoContrattoDisabilitazAbilitazOutput")
	private VerificaStatoContrattoAbilitazioneDisabilitazioneOutputBean VerificaStatoContrattoAbilitazioneDisabilitazione;

	public VerificaStatoContrattoAbilitazioneDisabilitazioneOutputBean getVerificaStatoContrattoAbilitazioneDisabilitazione() {
		return VerificaStatoContrattoAbilitazioneDisabilitazione;
	}

	public void setVerificaStatoContrattoAbilitazioneDisabilitazione(
			VerificaStatoContrattoAbilitazioneDisabilitazioneOutputBean verificaStatoContrattoAbilitazioneDisabilitazione) {
		VerificaStatoContrattoAbilitazioneDisabilitazione = verificaStatoContrattoAbilitazioneDisabilitazione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((VerificaStatoContrattoAbilitazioneDisabilitazione == null) ? 0
				: VerificaStatoContrattoAbilitazioneDisabilitazione.hashCode());
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
		VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputBean other = (VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputBean) obj;
		if (VerificaStatoContrattoAbilitazioneDisabilitazione == null) {
			if (other.VerificaStatoContrattoAbilitazioneDisabilitazione != null)
				return false;
		} else if (!VerificaStatoContrattoAbilitazioneDisabilitazione
				.equals(other.VerificaStatoContrattoAbilitazioneDisabilitazione))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputBean [VerificaStatoContrattoAbilitazioneDisabilitazione="
				+ VerificaStatoContrattoAbilitazioneDisabilitazione + "]";
	}
}
