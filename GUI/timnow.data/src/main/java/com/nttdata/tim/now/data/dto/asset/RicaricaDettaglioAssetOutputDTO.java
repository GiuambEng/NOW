package com.nttdata.tim.now.data.dto.asset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class RicaricaDettaglioAssetOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 3652523575641654406L;

	@JsonProperty("codificaOAO")
	private String codificaOAO;

	@JsonProperty("idRisorsa")
	private String idRisorsa;
	
	@JsonProperty("offerta")
	private String offerta;
	
	@JsonProperty("codiceOrdineOao")
	private String codiceOrdineOao;
	
	@JsonProperty("codiceOrdineTI")
	private String codiceOrdineTI;
	
	@JsonProperty("opzioneDinamica")
	private String opzioneDinamica;
	
	@JsonProperty("idAsset")
	private String idAsset;
	
	@JsonProperty("stato")
	private String stato;

	@JsonProperty("taglioRicarica")
	private String taglioRicarica;

	@JsonProperty("statoAssetDinamico")
	private String statoAssetDinamico;

	public String getCodificaOAO() {
		return codificaOAO;
	}

	public void setCodificaOAO(String codificaOAO) {
		this.codificaOAO = codificaOAO;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getCodiceOrdineOao() {
		return codiceOrdineOao;
	}

	public void setCodiceOrdineOao(String codiceOrdineOao) {
		this.codiceOrdineOao = codiceOrdineOao;
	}

	public String getCodiceOrdineTI() {
		return codiceOrdineTI;
	}

	public void setCodiceOrdineTI(String codiceOrdineTI) {
		this.codiceOrdineTI = codiceOrdineTI;
	}

	public String getOpzioneDinamica() {
		return opzioneDinamica;
	}

	public void setOpzioneDinamica(String opzioneDinamica) {
		this.opzioneDinamica = opzioneDinamica;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getTaglioRicarica() {
		return taglioRicarica;
	}

	public void setTaglioRicarica(String taglioRicarica) {
		this.taglioRicarica = taglioRicarica;
	}

	public String getStatoAssetDinamico() {
		return statoAssetDinamico;
	}

	public void setStatoAssetDinamico(String statoAssetDinamico) {
		this.statoAssetDinamico = statoAssetDinamico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceOrdineOao == null) ? 0 : codiceOrdineOao.hashCode());
		result = prime * result + ((codiceOrdineTI == null) ? 0 : codiceOrdineTI.hashCode());
		result = prime * result + ((codificaOAO == null) ? 0 : codificaOAO.hashCode());
		result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((opzioneDinamica == null) ? 0 : opzioneDinamica.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((statoAssetDinamico == null) ? 0 : statoAssetDinamico.hashCode());
		result = prime * result + ((taglioRicarica == null) ? 0 : taglioRicarica.hashCode());
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
		RicaricaDettaglioAssetOutputDTO other = (RicaricaDettaglioAssetOutputDTO) obj;
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
		if (codificaOAO == null) {
			if (other.codificaOAO != null)
				return false;
		} else if (!codificaOAO.equals(other.codificaOAO))
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
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (opzioneDinamica == null) {
			if (other.opzioneDinamica != null)
				return false;
		} else if (!opzioneDinamica.equals(other.opzioneDinamica))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (statoAssetDinamico == null) {
			if (other.statoAssetDinamico != null)
				return false;
		} else if (!statoAssetDinamico.equals(other.statoAssetDinamico))
			return false;
		if (taglioRicarica == null) {
			if (other.taglioRicarica != null)
				return false;
		} else if (!taglioRicarica.equals(other.taglioRicarica))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RicaricaDettaglioAssetOutputDTO [codificaOAO=" + codificaOAO + ", idRisorsa=" + idRisorsa + ", offerta="
				+ offerta + ", codiceOrdineOao=" + codiceOrdineOao + ", codiceOrdineTI=" + codiceOrdineTI
				+ ", opzioneDinamica=" + opzioneDinamica + ", idAsset=" + idAsset + ", stato=" + stato
				+ ", taglioRicarica=" + taglioRicarica + ", statoAssetDinamico=" + statoAssetDinamico + "]";
	}
	
	
}
