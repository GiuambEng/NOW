package com.nttdata.tim.now.data.dto.ordine.tokenizzazione;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.ordine.IndirizzoDatiClienteFinaleInputDTO;

//RU_1084
@JsonInclude(Include.NON_NULL)
public class TokenizzazioneReferentiInputDTO implements Serializable {

	private static final long serialVersionUID = -136136258369710898L;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;
	
	@JsonProperty("idOfferta")
	private String idOfferta;
	
	@JsonProperty("codOrdineOlo")
	private String codOrdineOlo;
	
	@JsonProperty("lavorazione")
	private String lavorazione;
	
	@JsonProperty("codIstatComune")
	private String codIstatComune;
	
	@JsonProperty("IPClient")
	private String ipClient;
	
	@JsonProperty("operatore")
	private String operatore;
	
	@JsonProperty("indirizzoClienteFinale")
	private IndirizzoDatiClienteFinaleInputDTO indirizzoClienteFinale;
	
	@JsonProperty("numeriReferenti")
	private List<NumeriReferenteDTO> numeriReferenti;
	
	//SM_9637
	@JsonProperty("dn")
	private String dn;
	
	//SM_9650
	@JsonProperty("referenteContattato")
	private String referenteContattato;
	
	//SM_9663
	@JsonProperty("codiceOrdineTi")
	private String codiceOrdineTi;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getCodOrdineOlo() {
		return codOrdineOlo;
	}

	public void setCodOrdineOlo(String codOrdineOlo) {
		this.codOrdineOlo = codOrdineOlo;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getCodIstatComune() {
		return codIstatComune;
	}

	public void setCodIstatComune(String codIstatComune) {
		this.codIstatComune = codIstatComune;
	}

	public String getIpClient() {
		return ipClient;
	}

	public void setIpClient(String ipClient) {
		this.ipClient = ipClient;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public IndirizzoDatiClienteFinaleInputDTO getIndirizzoClienteFinale() {
		return indirizzoClienteFinale;
	}

	public void setIndirizzoClienteFinale(IndirizzoDatiClienteFinaleInputDTO indirizzoClienteFinale) {
		this.indirizzoClienteFinale = indirizzoClienteFinale;
	}

	public List<NumeriReferenteDTO> getNumeriReferenti() {
		return numeriReferenti;
	}

	public void setNumeriReferenti(List<NumeriReferenteDTO> numeriReferenti) {
		this.numeriReferenti = numeriReferenti;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}
	
	public String getReferenteContattato() {
		return referenteContattato;
	}

	public void setReferenteContattato(String referenteContattato) {
		this.referenteContattato = referenteContattato;
	}

	public String getCodiceOrdineTi() {
		return codiceOrdineTi;
	}

	public void setCodiceOrdineTi(String codiceOrdineTi) {
		this.codiceOrdineTi = codiceOrdineTi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codIstatComune == null) ? 0 : codIstatComune.hashCode());
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + ((codOrdineOlo == null) ? 0 : codOrdineOlo.hashCode());
		result = prime * result + ((codiceOrdineTi == null) ? 0 : codiceOrdineTi.hashCode());
		result = prime * result + ((dn == null) ? 0 : dn.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((indirizzoClienteFinale == null) ? 0 : indirizzoClienteFinale.hashCode());
		result = prime * result + ((ipClient == null) ? 0 : ipClient.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((numeriReferenti == null) ? 0 : numeriReferenti.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		result = prime * result + ((referenteContattato == null) ? 0 : referenteContattato.hashCode());
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
		TokenizzazioneReferentiInputDTO other = (TokenizzazioneReferentiInputDTO) obj;
		if (codIstatComune == null) {
			if (other.codIstatComune != null)
				return false;
		} else if (!codIstatComune.equals(other.codIstatComune))
			return false;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (codOrdineOlo == null) {
			if (other.codOrdineOlo != null)
				return false;
		} else if (!codOrdineOlo.equals(other.codOrdineOlo))
			return false;
		if (codiceOrdineTi == null) {
			if (other.codiceOrdineTi != null)
				return false;
		} else if (!codiceOrdineTi.equals(other.codiceOrdineTi))
			return false;
		if (dn == null) {
			if (other.dn != null)
				return false;
		} else if (!dn.equals(other.dn))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (indirizzoClienteFinale == null) {
			if (other.indirizzoClienteFinale != null)
				return false;
		} else if (!indirizzoClienteFinale.equals(other.indirizzoClienteFinale))
			return false;
		if (ipClient == null) {
			if (other.ipClient != null)
				return false;
		} else if (!ipClient.equals(other.ipClient))
			return false;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (numeriReferenti == null) {
			if (other.numeriReferenti != null)
				return false;
		} else if (!numeriReferenti.equals(other.numeriReferenti))
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		if (referenteContattato == null) {
			if (other.referenteContattato != null)
				return false;
		} else if (!referenteContattato.equals(other.referenteContattato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TokenizzazioneReferentiInputDTO [codOloAgcom=" + codOloAgcom + ", idOfferta=" + idOfferta
				+ ", codOrdineOlo=" + codOrdineOlo + ", lavorazione=" + lavorazione + ", codIstatComune="
				+ codIstatComune + ", ipClient=" + ipClient + ", operatore=" + operatore + ", indirizzoClienteFinale="
				+ indirizzoClienteFinale + ", numeriReferenti=" + numeriReferenti + ", dn=" + dn
				+ ", referenteContattato=" + referenteContattato + ", codiceOrdineTi=" + codiceOrdineTi + "]";
	}

	
		
}