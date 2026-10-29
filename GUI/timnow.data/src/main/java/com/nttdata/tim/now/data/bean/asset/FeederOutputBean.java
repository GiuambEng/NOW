package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//R1I-21-0203
@JsonInclude(Include.NON_NULL)
public class FeederOutputBean implements Serializable {

	private static final long serialVersionUID = 4117817945855310263L;

	@JsonProperty("nomeMacroarea")
	private String nomeMacroarea;
	
	@JsonProperty("des")
	private String des;
	
	@JsonProperty("clliFeederSuccessivo")
	private String clliFeederSuccessivo;
	
	@JsonProperty("idRisorsa")
	private String idRisorsa;
	
	@JsonProperty("codiceMacroarea")
	private String codiceMacroarea;
	
	@JsonProperty("clliPrimoFeeder")
	private String clliPrimoFeeder;

	public String getNomeMacroarea() {
		return nomeMacroarea;
	}

	public void setNomeMacroarea(String nomeMacroarea) {
		this.nomeMacroarea = nomeMacroarea;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getClliFeederSuccessivo() {
		return clliFeederSuccessivo;
	}

	public void setClliFeederSuccessivo(String clliFeederSuccessivo) {
		this.clliFeederSuccessivo = clliFeederSuccessivo;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getCodiceMacroarea() {
		return codiceMacroarea;
	}

	public void setCodiceMacroarea(String codiceMacroarea) {
		this.codiceMacroarea = codiceMacroarea;
	}

	public String getClliPrimoFeeder() {
		return clliPrimoFeeder;
	}

	public void setClliPrimoFeeder(String clliPrimoFeeder) {
		this.clliPrimoFeeder = clliPrimoFeeder;
	}


}
