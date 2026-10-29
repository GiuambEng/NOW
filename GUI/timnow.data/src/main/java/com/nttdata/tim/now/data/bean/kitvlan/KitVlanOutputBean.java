package com.nttdata.tim.now.data.bean.kitvlan;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1058
public class KitVlanOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 111386377083921831L;

	@JsonProperty("stato")
    private String stato;
	
    @JsonProperty("famigliaKit")
    private String famigliaKit;
    
    @JsonProperty("dec")
    private String dec;
    
    @JsonProperty("codiceKit")
    private String codiceKit;
    
    @JsonProperty("modelloKit")
    private String modelloKit;   
    
    @JsonProperty("idPrimeContractor")
    private String idPrimeContractor;
    
    @JsonProperty("clli")
    private String clli;
    
    @JsonProperty("codiceOlo")
    private String codiceOlo;
    
    @JsonProperty("decAttivazione")
    private String decAttivazione;
    
    @JsonProperty("codificaOloAgcom")
    private String codificaOloAgcom;
    
    @JsonProperty("abilitatoNga")
    private String abilitatoNga;

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getFamigliaKit() {
		return famigliaKit;
	}

	public void setFamigliaKit(String famigliaKit) {
		this.famigliaKit = famigliaKit;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public String getCodiceKit() {
		return codiceKit;
	}

	public void setCodiceKit(String codiceKit) {
		this.codiceKit = codiceKit;
	}

	public String getModelloKit() {
		return modelloKit;
	}

	public void setModelloKit(String modelloKit) {
		this.modelloKit = modelloKit;
	}

	public String getIdPrimeContractor() {
		return idPrimeContractor;
	}

	public void setIdPrimeContractor(String idPrimeContractor) {
		this.idPrimeContractor = idPrimeContractor;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getCodiceOlo() {
		return codiceOlo;
	}

	public void setCodiceOlo(String codiceOlo) {
		this.codiceOlo = codiceOlo;
	}

	public String getDecAttivazione() {
		return decAttivazione;
	}

	public void setDecAttivazione(String decAttivazione) {
		this.decAttivazione = decAttivazione;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getAbilitatoNga() {
		return abilitatoNga;
	}

	public void setAbilitatoNga(String abilitatoNga) {
		this.abilitatoNga = abilitatoNga;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abilitatoNga == null) ? 0 : abilitatoNga.hashCode());
		result = prime * result + ((clli == null) ? 0 : clli.hashCode());
		result = prime * result + ((codiceKit == null) ? 0 : codiceKit.hashCode());
		result = prime * result + ((codiceOlo == null) ? 0 : codiceOlo.hashCode());
		result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
		result = prime * result + ((dec == null) ? 0 : dec.hashCode());
		result = prime * result + ((decAttivazione == null) ? 0 : decAttivazione.hashCode());
		result = prime * result + ((famigliaKit == null) ? 0 : famigliaKit.hashCode());
		result = prime * result + ((idPrimeContractor == null) ? 0 : idPrimeContractor.hashCode());
		result = prime * result + ((modelloKit == null) ? 0 : modelloKit.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
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
		KitVlanOutputBean other = (KitVlanOutputBean) obj;
		if (abilitatoNga == null) {
			if (other.abilitatoNga != null)
				return false;
		} else if (!abilitatoNga.equals(other.abilitatoNga))
			return false;
		if (clli == null) {
			if (other.clli != null)
				return false;
		} else if (!clli.equals(other.clli))
			return false;
		if (codiceKit == null) {
			if (other.codiceKit != null)
				return false;
		} else if (!codiceKit.equals(other.codiceKit))
			return false;
		if (codiceOlo == null) {
			if (other.codiceOlo != null)
				return false;
		} else if (!codiceOlo.equals(other.codiceOlo))
			return false;
		if (codificaOloAgcom == null) {
			if (other.codificaOloAgcom != null)
				return false;
		} else if (!codificaOloAgcom.equals(other.codificaOloAgcom))
			return false;
		if (dec == null) {
			if (other.dec != null)
				return false;
		} else if (!dec.equals(other.dec))
			return false;
		if (decAttivazione == null) {
			if (other.decAttivazione != null)
				return false;
		} else if (!decAttivazione.equals(other.decAttivazione))
			return false;
		if (famigliaKit == null) {
			if (other.famigliaKit != null)
				return false;
		} else if (!famigliaKit.equals(other.famigliaKit))
			return false;
		if (idPrimeContractor == null) {
			if (other.idPrimeContractor != null)
				return false;
		} else if (!idPrimeContractor.equals(other.idPrimeContractor))
			return false;
		if (modelloKit == null) {
			if (other.modelloKit != null)
				return false;
		} else if (!modelloKit.equals(other.modelloKit))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KitVlanOutputDTO [stato=" + stato + ", famigliaKit=" + famigliaKit + ", dec=" + dec + ", codiceKit="
				+ codiceKit + ", modelloKit=" + modelloKit + ", idPrimeContractor=" + idPrimeContractor + ", clli="
				+ clli + ", codiceOlo=" + codiceOlo + ", decAttivazione=" + decAttivazione + ", codificaOloAgcom="
				+ codificaOloAgcom + ", abilitatoNga=" + abilitatoNga + "]";
	}
    
    
	
}
