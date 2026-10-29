package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaPerVariazioneWlrInputBean implements Serializable {

	private static final long serialVersionUID = 2331815562413511741L;
	
	@JsonProperty("opzioneVariazione")
	private String opzioneVariazione;
	
	@JsonProperty("codiceSTS")
	private String codiceSts;
	
	@JsonProperty("idRisorsa")
	private String idRisorsa;
	
	@JsonProperty("aggiuntiviISDN")
	private String aggiuntiviIsdn;
	
	@JsonProperty("numerazioneAggiuntiva")
	private List<String> listaNumerazioneAggiuntiva;
	
	//SM_9028
	@JsonProperty("idAsset")
	private String idAsset;

	public String getOpzioneVariazione() {
		return opzioneVariazione;
	}

	public void setOpzioneVariazione(String opzioneVariazione) {
		this.opzioneVariazione = opzioneVariazione;
	}

	public String getCodiceSts() {
		return codiceSts;
	}

	public void setCodiceSts(String codiceSts) {
		this.codiceSts = codiceSts;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getAggiuntiviIsdn() {
		return aggiuntiviIsdn;
	}

	public void setAggiuntiviIsdn(String aggiuntiviIsdn) {
		this.aggiuntiviIsdn = aggiuntiviIsdn;
	}

	public List<String> getListaNumerazioneAggiuntiva() {
		return listaNumerazioneAggiuntiva;
	}

	public void setListaNumerazioneAggiuntiva(List<String> listaNumerazioneAggiuntiva) {
		this.listaNumerazioneAggiuntiva = listaNumerazioneAggiuntiva;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aggiuntiviIsdn == null) ? 0 : aggiuntiviIsdn.hashCode());
		result = prime * result + ((codiceSts == null) ? 0 : codiceSts.hashCode());
		result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((listaNumerazioneAggiuntiva == null) ? 0 : listaNumerazioneAggiuntiva.hashCode());
		result = prime * result + ((opzioneVariazione == null) ? 0 : opzioneVariazione.hashCode());
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
		VerificaPerVariazioneWlrInputBean other = (VerificaPerVariazioneWlrInputBean) obj;
		if (aggiuntiviIsdn == null) {
			if (other.aggiuntiviIsdn != null)
				return false;
		} else if (!aggiuntiviIsdn.equals(other.aggiuntiviIsdn))
			return false;
		if (codiceSts == null) {
			if (other.codiceSts != null)
				return false;
		} else if (!codiceSts.equals(other.codiceSts))
			return false;
		if (idAsset == null) {
			if (other.idAsset != null)
				return false;
		} else if (!idAsset.equals(other.idAsset))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (listaNumerazioneAggiuntiva == null) {
			if (other.listaNumerazioneAggiuntiva != null)
				return false;
		} else if (!listaNumerazioneAggiuntiva.equals(other.listaNumerazioneAggiuntiva))
			return false;
		if (opzioneVariazione == null) {
			if (other.opzioneVariazione != null)
				return false;
		} else if (!opzioneVariazione.equals(other.opzioneVariazione))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaPerVariazioneWlrInputBean [opzioneVariazione=" + opzioneVariazione + ", codiceSts=" + codiceSts
				+ ", idRisorsa=" + idRisorsa + ", aggiuntiviIsdn=" + aggiuntiviIsdn + ", listaNumerazioneAggiuntiva="
				+ listaNumerazioneAggiuntiva + ", idAsset=" + idAsset + "]";
	}
	
}
