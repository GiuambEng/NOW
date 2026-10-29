package com.nttdata.tim.now.data.dto.asset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class AssetOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 2342860477161745802L;

	@JsonProperty("codiceOlo")
	private String codiceOlo;

	@JsonProperty("codiceOrdineTI")
	private String codiceOrdineTI;

	@JsonProperty("oao")
	private String oao;

	@JsonProperty("idAssetCrm")
	private String idAssetCrm;

	@JsonProperty("idRisorsa")
	private String idRisorsa;

	@JsonProperty("identificativoAsset")
	private String identificativoAsset;

	@JsonProperty("identificativoStatoAsset")
	private String identificativoStatoAsset;

	@JsonProperty("identificativoTipologiaAccesso")
	private String identificativoTipologiaAccesso;

	@JsonProperty("offerta")
	private String offerta;
	
	//RU_737
	@JsonProperty("idRisorsaOperatoreRete")
	private String idRisorsaOperatoreRete;

	public String getCodiceOlo() {
		return codiceOlo;
	}

	public void setCodiceOlo(String codiceOlo) {
		this.codiceOlo = codiceOlo;
	}

	public String getCodiceOrdineTI() {
		return codiceOrdineTI;
	}

	public void setCodiceOrdineTI(String codiceOrdineTI) {
		this.codiceOrdineTI = codiceOrdineTI;
	}

	public String getOao() {
		return oao;
	}

	public void setOao(String oao) {
		this.oao = oao;
	}

	public String getIdAssetCrm() {
		return idAssetCrm;
	}

	public void setIdAssetCrm(String idAssetCrm) {
		this.idAssetCrm = idAssetCrm;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getIdentificativoAsset() {
		return identificativoAsset;
	}

	public void setIdentificativoAsset(String identificativoAsset) {
		this.identificativoAsset = identificativoAsset;
	}

	public String getIdentificativoStatoAsset() {
		return identificativoStatoAsset;
	}

	public void setIdentificativoStatoAsset(String identificativoStatoAsset) {
		this.identificativoStatoAsset = identificativoStatoAsset;
	}

	public String getIdentificativoTipologiaAccesso() {
		return identificativoTipologiaAccesso;
	}

	public void setIdentificativoTipologiaAccesso(String identificativoTipologiaAccesso) {
		this.identificativoTipologiaAccesso = identificativoTipologiaAccesso;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}
	
	public String getIdRisorsaOperatoreRete() {
		return idRisorsaOperatoreRete;
	}

	public void setIdRisorsaOperatoreRete(String idRisorsaOperatoreRete) {
		this.idRisorsaOperatoreRete = idRisorsaOperatoreRete;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceOlo == null) ? 0 : codiceOlo.hashCode());
		result = prime * result + ((codiceOrdineTI == null) ? 0 : codiceOrdineTI.hashCode());
		result = prime * result + ((idAssetCrm == null) ? 0 : idAssetCrm.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((identificativoAsset == null) ? 0 : identificativoAsset.hashCode());
		result = prime * result + ((identificativoStatoAsset == null) ? 0 : identificativoStatoAsset.hashCode());
		result = prime * result
				+ ((identificativoTipologiaAccesso == null) ? 0 : identificativoTipologiaAccesso.hashCode());
		result = prime * result + ((oao == null) ? 0 : oao.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((idRisorsaOperatoreRete == null) ? 0 : idRisorsaOperatoreRete.hashCode());
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
		AssetOutputDTO other = (AssetOutputDTO) obj;
		if (codiceOlo == null) {
			if (other.codiceOlo != null)
				return false;
		} else if (!codiceOlo.equals(other.codiceOlo))
			return false;
		if (codiceOrdineTI == null) {
			if (other.codiceOrdineTI != null)
				return false;
		} else if (!codiceOrdineTI.equals(other.codiceOrdineTI))
			return false;
		if (idAssetCrm == null) {
			if (other.idAssetCrm != null)
				return false;
		} else if (!idAssetCrm.equals(other.idAssetCrm))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (identificativoAsset == null) {
			if (other.identificativoAsset != null)
				return false;
		} else if (!identificativoAsset.equals(other.identificativoAsset))
			return false;
		if (identificativoStatoAsset == null) {
			if (other.identificativoStatoAsset != null)
				return false;
		} else if (!identificativoStatoAsset.equals(other.identificativoStatoAsset))
			return false;
		if (identificativoTipologiaAccesso == null) {
			if (other.identificativoTipologiaAccesso != null)
				return false;
		} else if (!identificativoTipologiaAccesso.equals(other.identificativoTipologiaAccesso))
			return false;
		if (oao == null) {
			if (other.oao != null)
				return false;
		} else if (!oao.equals(other.oao))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (idRisorsaOperatoreRete == null) {
			if (other.idRisorsaOperatoreRete != null)
				return false;
		} else if (!idRisorsaOperatoreRete.equals(other.idRisorsaOperatoreRete))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssetOutputDTO [codiceOlo=" + codiceOlo + ", codiceOrdineTI=" + codiceOrdineTI + ", oao=" + oao
				+ ", idAssetCrm=" + idAssetCrm + ", idRisorsa=" + idRisorsa + ", identificativoAsset="
				+ identificativoAsset + ", identificativoStatoAsset=" + identificativoStatoAsset
				+ ", identificativoTipologiaAccesso=" + identificativoTipologiaAccesso + ", offerta=" + offerta + ", idRisorsaOperatoreRete=" + idRisorsaOperatoreRete + "]";
	}

	
}
