package com.nttdata.tim.now.data.bean.banda;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class BandaDedicataOutputBean extends AbstractOutputBean implements Serializable {
	
	private static final long serialVersionUID = -2676427891258066912L;

	@JsonProperty("bp2")
	private String bp2;

	@JsonProperty("bp2Max")
	private String bp2Max;

	@JsonProperty("bp3")
	private String bp3;

	@JsonProperty("bp3Max")
	private String bp3Max;

	@JsonProperty("bp5")
	private String bp5;

	@JsonProperty("bp5Max")
	private String bp5Max;

	@JsonProperty("bp6")
	private String bp6;

	@JsonProperty("bp6Max")
	private String bp6Max;

	@JsonProperty("idProfiloBmd")
	private String idProfiloBmd;

	@JsonProperty("profilo")
	private String profilo;

	@JsonProperty("idSottofamigOfferta")
	private String idSottofamigOfferta;

	@JsonProperty("descrSottofamigOfferta")
	private String descrSottofamigOfferta;

	@JsonProperty("tipologVLAN")
	private String tipologVLAN;

	public String getBp2() {
		return bp2;
	}

	public void setBp2(String bp2) {
		this.bp2 = bp2;
	}

	public String getBp2Max() {
		return bp2Max;
	}

	public void setBp2Max(String bp2Max) {
		this.bp2Max = bp2Max;
	}

	public String getBp3() {
		return bp3;
	}

	public void setBp3(String bp3) {
		this.bp3 = bp3;
	}

	public String getBp3Max() {
		return bp3Max;
	}

	public void setBp3Max(String bp3Max) {
		this.bp3Max = bp3Max;
	}

	public String getBp5() {
		return bp5;
	}

	public void setBp5(String bp5) {
		this.bp5 = bp5;
	}

	public String getBp5Max() {
		return bp5Max;
	}

	public void setBp5Max(String bp5Max) {
		this.bp5Max = bp5Max;
	}

	public String getBp6() {
		return bp6;
	}

	public void setBp6(String bp6) {
		this.bp6 = bp6;
	}

	public String getBp6Max() {
		return bp6Max;
	}

	public void setBp6Max(String bp6Max) {
		this.bp6Max = bp6Max;
	}

	public String getIdProfiloBmd() {
		return idProfiloBmd;
	}

	public void setIdProfiloBmd(String idProfiloBmd) {
		this.idProfiloBmd = idProfiloBmd;
	}

	public String getProfilo() {
		return profilo;
	}

	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}

	public String getIdSottofamigOfferta() {
		return idSottofamigOfferta;
	}

	public void setIdSottofamigOfferta(String idSottofamigOfferta) {
		this.idSottofamigOfferta = idSottofamigOfferta;
	}

	public String getDescrSottofamigOfferta() {
		return descrSottofamigOfferta;
	}

	public void setDescrSottofamigOfferta(String descrSottofamigOfferta) {
		this.descrSottofamigOfferta = descrSottofamigOfferta;
	}

	public String getTipologVLAN() {
		return tipologVLAN;
	}

	public void setTipologVLAN(String tipologVLAN) {
		this.tipologVLAN = tipologVLAN;
	}

}