package com.nttdata.tim.now.data.dto.locator;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE, setterVisibility=JsonAutoDetect.Visibility.NONE, creatorVisibility=JsonAutoDetect.Visibility.NONE)
public class SystemLocatorInputDTO implements Serializable {
	
	private static final long serialVersionUID = 5531972180564845120L;

	@JsonProperty("Transaction_Id")
	private String transactionId;

	@JsonProperty("CodiceOLO")
	private String codiceOlo;
	
	@JsonProperty("CodiceISP")
	private int codiceIsp;

	@JsonProperty("CodiceComune")
	private String codiceComune;

	@JsonProperty("Servizio")
	private String servizio;

	@JsonProperty("Lavorazione")
	private String lavorazione;

	@JsonProperty("CodiceOrdineOlo")
	private String codiceOrdineOlo;

	@JsonProperty("CodiceOrdineRiferimentoTI")
	private String codiceOrdineRiferimentoTi;

	@JsonProperty("IdRisorsa")
	private String idRisorsa;
	
	@JsonProperty("IdRisorsa2")
	private String idRisorsa2;
	
	@JsonProperty("DN")
	private String dn;
	
	@JsonProperty("sottolavorazione")
	private String sottolavorazione;
	
	@JsonProperty("DNAggiuntivi")
	private List<String> DNAggiuntivi;

	@JsonProperty("rientro")
	private String rientro;
	
	@JsonProperty("tipoLinea")
	private String tipoLinea;

	@JsonProperty("numeroLinea")
	private String numeroLinea;
	
	@JsonProperty("tipologiaAccesso") //SM_8153
	private String tipologiaAccesso;
	
	@JsonProperty("provincia") //SM_8415
	private String provincia;
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCodiceOlo() {
		return codiceOlo;
	}

	public void setCodiceOlo(String codiceOlo) {
		this.codiceOlo = codiceOlo;
	}

	public int getCodiceIsp() {
		return codiceIsp;
	}

	public void setCodiceIsp(int codiceIsp) {
		this.codiceIsp = codiceIsp;
	}

	public String getCodiceComune() {
		return codiceComune;
	}

	public void setCodiceComune(String codiceComune) {
		this.codiceComune = codiceComune;
	}

	public String getServizio() {
		return servizio;
	}

	public void setServizio(String servizio) {
		this.servizio = servizio;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getCodiceOrdineOlo() {
		return codiceOrdineOlo;
	}

	public void setCodiceOrdineOlo(String codiceOrdineOlo) {
		this.codiceOrdineOlo = codiceOrdineOlo;
	}

	public String getCodiceOrdineRiferimentoTi() {
		return codiceOrdineRiferimentoTi;
	}

	public void setCodiceOrdineRiferimentoTi(String codiceOrdineRiferimentoTi) {
		this.codiceOrdineRiferimentoTi = codiceOrdineRiferimentoTi;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getIdRisorsa2() {
		return idRisorsa2;
	}

	public void setIdRisorsa2(String idRisorsa2) {
		this.idRisorsa2 = idRisorsa2;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public String getSottolavorazione() {
		return sottolavorazione;
	}

	public void setSottolavorazione(String sottolavorazione) {
		this.sottolavorazione = sottolavorazione;
	}

	public List<String> getDNAggiuntivi() {
		return DNAggiuntivi;
	}

	public void setDNAggiuntivi(List<String> dNAggiuntivi) {
		DNAggiuntivi = dNAggiuntivi;
	}

	public String getRientro() {
		return rientro;
	}

	public void setRientro(String rientro) {
		this.rientro = rientro;
	}

	public String getTipoLinea() {
		return tipoLinea;
	}

	public void setTipoLinea(String tipoLinea) {
		this.tipoLinea = tipoLinea;
	}

	public String getNumeroLinea() {
		return numeroLinea;
	}

	public void setNumeroLinea(String numeroLinea) {
		this.numeroLinea = numeroLinea;
	}
	
	public String getTipologiaAccesso() {
		return tipologiaAccesso;
	}

	public void setTipologiaAccesso(String tipologiaAccesso) {
		this.tipologiaAccesso = tipologiaAccesso;
	}

	
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNAggiuntivi == null) ? 0 : DNAggiuntivi.hashCode());
		result = prime * result + ((codiceComune == null) ? 0 : codiceComune.hashCode());
		result = prime * result + codiceIsp;
		result = prime * result + ((codiceOlo == null) ? 0 : codiceOlo.hashCode());
		result = prime * result + ((codiceOrdineOlo == null) ? 0 : codiceOrdineOlo.hashCode());
		result = prime * result + ((codiceOrdineRiferimentoTi == null) ? 0 : codiceOrdineRiferimentoTi.hashCode());
		result = prime * result + ((dn == null) ? 0 : dn.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((idRisorsa2 == null) ? 0 : idRisorsa2.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((numeroLinea == null) ? 0 : numeroLinea.hashCode());
		result = prime * result + ((rientro == null) ? 0 : rientro.hashCode());
		result = prime * result + ((servizio == null) ? 0 : servizio.hashCode());
		result = prime * result + ((sottolavorazione == null) ? 0 : sottolavorazione.hashCode());
		result = prime * result + ((tipoLinea == null) ? 0 : tipoLinea.hashCode());
		result = prime * result + ((tipologiaAccesso == null) ? 0 : tipologiaAccesso.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
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
		SystemLocatorInputDTO other = (SystemLocatorInputDTO) obj;
		if (DNAggiuntivi == null) {
			if (other.DNAggiuntivi != null)
				return false;
		} else if (!DNAggiuntivi.equals(other.DNAggiuntivi))
			return false;
		if (codiceComune == null) {
			if (other.codiceComune != null)
				return false;
		} else if (!codiceComune.equals(other.codiceComune))
			return false;
		if (codiceIsp != other.codiceIsp)
			return false;
		if (codiceOlo == null) {
			if (other.codiceOlo != null)
				return false;
		} else if (!codiceOlo.equals(other.codiceOlo))
			return false;
		if (codiceOrdineOlo == null) {
			if (other.codiceOrdineOlo != null)
				return false;
		} else if (!codiceOrdineOlo.equals(other.codiceOrdineOlo))
			return false;
		if (codiceOrdineRiferimentoTi == null) {
			if (other.codiceOrdineRiferimentoTi != null)
				return false;
		} else if (!codiceOrdineRiferimentoTi.equals(other.codiceOrdineRiferimentoTi))
			return false;
		if (dn == null) {
			if (other.dn != null)
				return false;
		} else if (!dn.equals(other.dn))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (idRisorsa2 == null) {
			if (other.idRisorsa2 != null)
				return false;
		} else if (!idRisorsa2.equals(other.idRisorsa2))
			return false;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (numeroLinea == null) {
			if (other.numeroLinea != null)
				return false;
		} else if (!numeroLinea.equals(other.numeroLinea))
			return false;
		if (rientro == null) {
			if (other.rientro != null)
				return false;
		} else if (!rientro.equals(other.rientro))
			return false;
		if (servizio == null) {
			if (other.servizio != null)
				return false;
		} else if (!servizio.equals(other.servizio))
			return false;
		if (sottolavorazione == null) {
			if (other.sottolavorazione != null)
				return false;
		} else if (!sottolavorazione.equals(other.sottolavorazione))
			return false;
		if (tipoLinea == null) {
			if (other.tipoLinea != null)
				return false;
		} else if (!tipoLinea.equals(other.tipoLinea))
			return false;
		if (tipologiaAccesso == null) {
			if (other.tipologiaAccesso != null)
				return false;
		} else if (!tipologiaAccesso.equals(other.tipologiaAccesso))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SystemLocatorInputDTO [transactionId=" + transactionId + ", codiceOlo=" + codiceOlo + ", codiceIsp="
				+ codiceIsp + ", codiceComune=" + codiceComune + ", servizio=" + servizio + ", lavorazione="
				+ lavorazione + ", codiceOrdineOlo=" + codiceOrdineOlo + ", codiceOrdineRiferimentoTi="
				+ codiceOrdineRiferimentoTi + ", idRisorsa=" + idRisorsa + ", idRisorsa2=" + idRisorsa2 + ", dn=" + dn
				+ ", sottolavorazione=" + sottolavorazione + ", DNAggiuntivi=" + DNAggiuntivi + ", rientro=" + rientro
				+ ", tipoLinea=" + tipoLinea + ", numeroLinea=" + numeroLinea + ", tipologiaAccesso=" + tipologiaAccesso
				+ ", provincia=" + provincia + "]";
	}

	
}
