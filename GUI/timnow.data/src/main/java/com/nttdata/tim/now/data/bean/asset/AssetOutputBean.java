package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class AssetOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 2881185646644073553L;

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
	
}