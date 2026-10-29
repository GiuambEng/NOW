package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class NuovaRicaricaInputDTO implements Serializable {

	private static final long serialVersionUID = 5263306809940592093L;

	@JsonProperty("idRisorsa")
    private String idRisorsa;
    
    @JsonProperty("idAsset")
    private String idAsset;
 
    @JsonProperty("tipoLavorazione")
    private String tipoLavorazione;
    
    @JsonProperty("operatore")
    private String operatore;
 
    @JsonProperty("offerta")
    private String offerta;
    
    @JsonProperty("codificaOao")
    private String codificaOao;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
    @JsonProperty("dataInizioRicarica")
    private Date dataInizioRicarica;
    
	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
    @JsonProperty("dataFineRicarica")
    private Date dataFineRicarica;
 
    @JsonProperty("taglioRicaricaInGiorni")
    private String taglioRicaricaInGiorni;
    
    @JsonProperty("codiceOrdineTI")
    private String codiceOrdineTI;

    @JsonProperty("codiceOrdineOao")
    private String codiceOrdineOao;
    
    @JsonProperty("noteDaOperatore")
    private String noteDaOperatore;
    
    @JsonProperty("idRicarica")
    private String idRicarica;
    
    @JsonProperty("tipologiaAccensioneRicarica")
    private String tipologiaAccensioneRicarica;

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public String getTipoLavorazione() {
		return tipoLavorazione;
	}

	public void setTipoLavorazione(String tipoLavorazione) {
		this.tipoLavorazione = tipoLavorazione;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getCodificaOao() {
		return codificaOao;
	}

	public void setCodificaOao(String codificaOao) {
		this.codificaOao = codificaOao;
	}

	public Date getDataInizioRicarica() {
		return dataInizioRicarica;
	}

	public void setDataInizioRicarica(Date dataInizioRicarica) {
		this.dataInizioRicarica = dataInizioRicarica;
	}

	public Date getDataFineRicarica() {
		return dataFineRicarica;
	}

	public void setDataFineRicarica(Date dataFineRicarica) {
		this.dataFineRicarica = dataFineRicarica;
	}

	public String getTaglioRicaricaInGiorni() {
		return taglioRicaricaInGiorni;
	}

	public void setTaglioRicaricaInGiorni(String taglioRicaricaInGiorni) {
		this.taglioRicaricaInGiorni = taglioRicaricaInGiorni;
	}

	public String getCodiceOrdineTI() {
		return codiceOrdineTI;
	}

	public void setCodiceOrdineTI(String codiceOrdineTI) {
		this.codiceOrdineTI = codiceOrdineTI;
	}

	public String getCodiceOrdineOao() {
		return codiceOrdineOao;
	}

	public void setCodiceOrdineOao(String codiceOrdineOao) {
		this.codiceOrdineOao = codiceOrdineOao;
	}

	public String getNoteDaOperatore() {
		return noteDaOperatore;
	}

	public void setNoteDaOperatore(String noteDaOperatore) {
		this.noteDaOperatore = noteDaOperatore;
	}

	public String getIdRicarica() {
		return idRicarica;
	}

	public void setIdRicarica(String idRicarica) {
		this.idRicarica = idRicarica;
	}

	public String getTipologiaAccensioneRicarica() {
		return tipologiaAccensioneRicarica;
	}

	public void setTipologiaAccensioneRicarica(String tipologiaAccensioneRicarica) {
		this.tipologiaAccensioneRicarica = tipologiaAccensioneRicarica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceOrdineOao == null) ? 0 : codiceOrdineOao.hashCode());
		result = prime * result + ((codiceOrdineTI == null) ? 0 : codiceOrdineTI.hashCode());
		result = prime * result + ((codificaOao == null) ? 0 : codificaOao.hashCode());
		result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
		result = prime * result + ((idRicarica == null) ? 0 : idRicarica.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((noteDaOperatore == null) ? 0 : noteDaOperatore.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		result = prime * result + ((taglioRicaricaInGiorni == null) ? 0 : taglioRicaricaInGiorni.hashCode());
		result = prime * result + ((tipoLavorazione == null) ? 0 : tipoLavorazione.hashCode());
		result = prime * result + ((tipologiaAccensioneRicarica == null) ? 0 : tipologiaAccensioneRicarica.hashCode());
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
		NuovaRicaricaInputDTO other = (NuovaRicaricaInputDTO) obj;
		if (codiceOrdineOao == null) {
			if (other.codiceOrdineOao != null)
				return false;
		} else if (!codiceOrdineOao.equals(other.codiceOrdineOao))
			return false;
		if (codiceOrdineTI == null) {
			if (other.codiceOrdineTI != null)
				return false;
		} else if (!codiceOrdineTI.equals(other.codiceOrdineTI))
			return false;
		if (codificaOao == null) {
			if (other.codificaOao != null)
				return false;
		} else if (!codificaOao.equals(other.codificaOao))
			return false;
		if (idAsset == null) {
			if (other.idAsset != null)
				return false;
		} else if (!idAsset.equals(other.idAsset))
			return false;
		if (idRicarica == null) {
			if (other.idRicarica != null)
				return false;
		} else if (!idRicarica.equals(other.idRicarica))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (noteDaOperatore == null) {
			if (other.noteDaOperatore != null)
				return false;
		} else if (!noteDaOperatore.equals(other.noteDaOperatore))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		if (taglioRicaricaInGiorni == null) {
			if (other.taglioRicaricaInGiorni != null)
				return false;
		} else if (!taglioRicaricaInGiorni.equals(other.taglioRicaricaInGiorni))
			return false;
		if (tipoLavorazione == null) {
			if (other.tipoLavorazione != null)
				return false;
		} else if (!tipoLavorazione.equals(other.tipoLavorazione))
			return false;
		if (tipologiaAccensioneRicarica == null) {
			if (other.tipologiaAccensioneRicarica != null)
				return false;
		} else if (!tipologiaAccensioneRicarica.equals(other.tipologiaAccensioneRicarica))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NuovaRicaricaInputDTO [idRisorsa=" + idRisorsa + ", idAsset=" + idAsset + ", tipoLavorazione="
				+ tipoLavorazione + ", operatore=" + operatore + ", offerta=" + offerta + ", codificaOao=" + codificaOao
				+ ", dataInizioRicarica=" + dataInizioRicarica + ", dataFineRicarica=" + dataFineRicarica
				+ ", taglioRicaricaInGiorni=" + taglioRicaricaInGiorni + ", codiceOrdineTI=" + codiceOrdineTI
				+ ", codiceOrdineOao=" + codiceOrdineOao + ", noteDaOperatore=" + noteDaOperatore + ", idRicarica="
				+ idRicarica + ", tipologiaAccensioneRicarica=" + tipologiaAccensioneRicarica + "]";
	}

    
    
}
