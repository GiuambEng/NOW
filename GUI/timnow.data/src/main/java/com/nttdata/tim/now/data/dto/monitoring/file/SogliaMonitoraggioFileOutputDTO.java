package com.nttdata.tim.now.data.dto.monitoring.file;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SogliaMonitoraggioFileOutputDTO implements Serializable {

	private static final long serialVersionUID = 7777802327222826447L;

	@JsonProperty("Elaborati_tot")
	private String elaboratiTot;
	
	@JsonProperty("InElaborazione_tot")
	private String inElaborazioneTot;

	@JsonProperty("InElaborazione_gui")
	private String inElaborazioneGui;

    @JsonProperty("InElaborazione_sftp")
    private String inElaborazioneSftp;
    
    @JsonProperty("Scartati_tot")
    private String scartatiTot;
    
    @JsonProperty("Scartati_gui")
    private String scartatiGui;
    
    @JsonProperty("Scartati_sftp")
    private String scartatiSftp;
    
    @JsonProperty("Scaduti_tot")
    private String scadutiTot;

	public String getElaboratiTot() {
		return elaboratiTot;
	}

	public void setElaboratiTot(String elaboratiTot) {
		this.elaboratiTot = elaboratiTot;
	}

	public String getInElaborazioneTot() {
		return inElaborazioneTot;
	}

	public void setInElaborazioneTot(String inElaborazioneTot) {
		this.inElaborazioneTot = inElaborazioneTot;
	}

	public String getInElaborazioneGui() {
		return inElaborazioneGui;
	}

	public void setInElaborazioneGui(String inElaborazioneGui) {
		this.inElaborazioneGui = inElaborazioneGui;
	}

	public String getInElaborazioneSftp() {
		return inElaborazioneSftp;
	}

	public void setInElaborazioneSftp(String inElaborazioneSftp) {
		this.inElaborazioneSftp = inElaborazioneSftp;
	}

	public String getScartatiTot() {
		return scartatiTot;
	}

	public void setScartatiTot(String scartatiTot) {
		this.scartatiTot = scartatiTot;
	}

	public String getScartatiGui() {
		return scartatiGui;
	}

	public void setScartatiGui(String scartatiGui) {
		this.scartatiGui = scartatiGui;
	}

	public String getScartatiSftp() {
		return scartatiSftp;
	}

	public void setScartatiSftp(String scartatiSftp) {
		this.scartatiSftp = scartatiSftp;
	}

	public String getScadutiTot() {
		return scadutiTot;
	}

	public void setScadutiTot(String scadutiTot) {
		this.scadutiTot = scadutiTot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elaboratiTot == null) ? 0 : elaboratiTot.hashCode());
		result = prime * result + ((inElaborazioneGui == null) ? 0 : inElaborazioneGui.hashCode());
		result = prime * result + ((inElaborazioneSftp == null) ? 0 : inElaborazioneSftp.hashCode());
		result = prime * result + ((inElaborazioneTot == null) ? 0 : inElaborazioneTot.hashCode());
		result = prime * result + ((scadutiTot == null) ? 0 : scadutiTot.hashCode());
		result = prime * result + ((scartatiGui == null) ? 0 : scartatiGui.hashCode());
		result = prime * result + ((scartatiSftp == null) ? 0 : scartatiSftp.hashCode());
		result = prime * result + ((scartatiTot == null) ? 0 : scartatiTot.hashCode());
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
		SogliaMonitoraggioFileOutputDTO other = (SogliaMonitoraggioFileOutputDTO) obj;
		if (elaboratiTot == null) {
			if (other.elaboratiTot != null)
				return false;
		} else if (!elaboratiTot.equals(other.elaboratiTot))
			return false;
		if (inElaborazioneGui == null) {
			if (other.inElaborazioneGui != null)
				return false;
		} else if (!inElaborazioneGui.equals(other.inElaborazioneGui))
			return false;
		if (inElaborazioneSftp == null) {
			if (other.inElaborazioneSftp != null)
				return false;
		} else if (!inElaborazioneSftp.equals(other.inElaborazioneSftp))
			return false;
		if (inElaborazioneTot == null) {
			if (other.inElaborazioneTot != null)
				return false;
		} else if (!inElaborazioneTot.equals(other.inElaborazioneTot))
			return false;
		if (scadutiTot == null) {
			if (other.scadutiTot != null)
				return false;
		} else if (!scadutiTot.equals(other.scadutiTot))
			return false;
		if (scartatiGui == null) {
			if (other.scartatiGui != null)
				return false;
		} else if (!scartatiGui.equals(other.scartatiGui))
			return false;
		if (scartatiSftp == null) {
			if (other.scartatiSftp != null)
				return false;
		} else if (!scartatiSftp.equals(other.scartatiSftp))
			return false;
		if (scartatiTot == null) {
			if (other.scartatiTot != null)
				return false;
		} else if (!scartatiTot.equals(other.scartatiTot))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SogliaMonitoraggioFileDatiFileDTO [elaboratiTot=" + elaboratiTot + ", inElaborazioneTot="
				+ inElaborazioneTot + ", inElaborazioneGui=" + inElaborazioneGui + ", inElaborazioneSftp="
				+ inElaborazioneSftp + ", scartatiTot=" + scartatiTot + ", scartatiGui=" + scartatiGui
				+ ", scartatiSftp=" + scartatiSftp + ", scadutiTot=" + scadutiTot + "]";
	}

}
