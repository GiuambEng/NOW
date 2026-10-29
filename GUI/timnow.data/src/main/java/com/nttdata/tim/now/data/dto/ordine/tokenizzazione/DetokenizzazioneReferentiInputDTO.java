package com.nttdata.tim.now.data.dto.ordine.tokenizzazione;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1084
@JsonInclude(Include.NON_NULL)
public class DetokenizzazioneReferentiInputDTO implements Serializable {

	private static final long serialVersionUID = 851221339808380469L;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;
		
	@JsonProperty("codOrdineOlo")
	private String codOrdineOlo;
	
	@JsonProperty("operatore")
	private String operatore;
	
	@JsonProperty("IPClient")
	private String ipClient;
	
	@JsonProperty("tokenReferenti")
	private List<TokenReferenteDTO> tokenReferenti;
	
	//SM_9686
	@JsonProperty("tracciatoXml")
	private String tracciatoXml;
	
	//R1F-20-0236.C
	@JsonProperty("flagAsset")
	private String flagAsset;
	
	//SM_10453
	@JsonProperty("referenteContattato")
	private String referenteContattato;
	
	//SM_10519
	@JsonProperty("idOfferta")
	private String idOfferta;
	
	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getCodOrdineOlo() {
		return codOrdineOlo;
	}

	public void setCodOrdineOlo(String codOrdineOlo) {
		this.codOrdineOlo = codOrdineOlo;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getIpClient() {
		return ipClient;
	}

	public void setIpClient(String ipClient) {
		this.ipClient = ipClient;
	}

	public List<TokenReferenteDTO> getTokenReferenti() {
		return tokenReferenti;
	}

	public void setTokenReferenti(List<TokenReferenteDTO> tokenReferenti) {
		this.tokenReferenti = tokenReferenti;
	}

	public String getTracciatoXml() {
		return tracciatoXml;
	}

	public void setTracciatoXml(String tracciatoXml) {
		this.tracciatoXml = tracciatoXml;
	}

	public String getFlagAsset() {
		return flagAsset;
	}

	public void setFlagAsset(String flagAsset) {
		this.flagAsset = flagAsset;
	}

	public String getReferenteContattato() {
		return referenteContattato;
	}

	public void setReferenteContattato(String referenteContattato) {
		this.referenteContattato = referenteContattato;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + ((codOrdineOlo == null) ? 0 : codOrdineOlo.hashCode());
		result = prime * result + ((flagAsset == null) ? 0 : flagAsset.hashCode());
		result = prime * result + ((ipClient == null) ? 0 : ipClient.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		result = prime * result + ((tokenReferenti == null) ? 0 : tokenReferenti.hashCode());
		result = prime * result + ((tracciatoXml == null) ? 0 : tracciatoXml.hashCode());
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
		DetokenizzazioneReferentiInputDTO other = (DetokenizzazioneReferentiInputDTO) obj;
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
		if (flagAsset == null) {
			if (other.flagAsset != null)
				return false;
		} else if (!flagAsset.equals(other.flagAsset))
			return false;
		if (ipClient == null) {
			if (other.ipClient != null)
				return false;
		} else if (!ipClient.equals(other.ipClient))
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		if (tokenReferenti == null) {
			if (other.tokenReferenti != null)
				return false;
		} else if (!tokenReferenti.equals(other.tokenReferenti))
			return false;
		if (tracciatoXml == null) {
			if (other.tracciatoXml != null)
				return false;
		} else if (!tracciatoXml.equals(other.tracciatoXml))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetokenizzazioneReferentiInputDTO [codOloAgcom=" + codOloAgcom + ", codOrdineOlo=" + codOrdineOlo
				+ ", operatore=" + operatore + ", ipClient=" + ipClient + ", tokenReferenti=" + tokenReferenti
				+ ", tracciatoXml=" + tracciatoXml + ", flagAsset=" + flagAsset + "]";
	}
			
}