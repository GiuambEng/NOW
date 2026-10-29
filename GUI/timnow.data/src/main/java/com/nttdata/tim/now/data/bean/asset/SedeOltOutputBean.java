package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//R1I-21-0203
@JsonInclude(Include.NON_NULL)
public class SedeOltOutputBean implements Serializable {

	private static final long serialVersionUID = -3246072804148585866L;
	
	@JsonProperty("nomeMacroarea")
	private String nomeMacroarea;
	
	@JsonProperty("nomeCentralePDC")
	private String nomeCentralePdc;
	
	@JsonProperty("codiceClliPDC")
	private String codiceClliPdc;
	
	@JsonProperty("des")
	private String des;
	
	@JsonProperty("idRisorsa")
	private String idRisorsa;
	
	@JsonProperty("clliCentrale")
	private String clliCentrale;
	
	@JsonProperty("codiceMacroarea")
	private String codiceMacroarea;

	public String getNomeMacroarea() {
		return nomeMacroarea;
	}

	public void setNomeMacroarea(String nomeMacroarea) {
		this.nomeMacroarea = nomeMacroarea;
	}

	public String getNomeCentralePdc() {
		return nomeCentralePdc;
	}

	public void setNomeCentralePdc(String nomeCentralePdc) {
		this.nomeCentralePdc = nomeCentralePdc;
	}

	public String getCodiceClliPdc() {
		return codiceClliPdc;
	}

	public void setCodiceClliPdc(String codiceClliPdc) {
		this.codiceClliPdc = codiceClliPdc;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getClliCentrale() {
		return clliCentrale;
	}

	public void setClliCentrale(String clliCentrale) {
		this.clliCentrale = clliCentrale;
	}

	public String getCodiceMacroarea() {
		return codiceMacroarea;
	}

	public void setCodiceMacroarea(String codiceMacroarea) {
		this.codiceMacroarea = codiceMacroarea;
	}

}
