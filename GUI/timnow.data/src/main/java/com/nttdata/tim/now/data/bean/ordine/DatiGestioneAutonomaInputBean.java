package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1393
@JsonInclude(Include.NON_NULL)
public class DatiGestioneAutonomaInputBean implements Serializable {

	private static final long serialVersionUID = -7575007334663187188L;
	
	@JsonProperty("operatoreSystem")
	private String operatoreSystem;

	@JsonProperty("systemUnico")
	private String systemUnico;
	
	@JsonProperty("noteSu")
	private String noteSu;
	
	@JsonProperty("impresaSystem")
	private String impresaSystem;
	
	@JsonProperty("subAppalto")
	private String subAppalto;
	
	//RU_1428
	@JsonProperty("tipologiaImpresa")
	private String tipologiaImpresa;

	public String getOperatoreSystem() {
		return operatoreSystem;
	}

	public void setOperatoreSystem(String operatoreSystem) {
		this.operatoreSystem = operatoreSystem;
	}

	public String getSystemUnico() {
		return systemUnico;
	}

	public void setSystemUnico(String systemUnico) {
		this.systemUnico = systemUnico;
	}

	public String getNoteSu() {
		return noteSu;
	}

	public void setNoteSu(String noteSu) {
		this.noteSu = noteSu;
	}

	public String getImpresaSystem() {
		return impresaSystem;
	}

	public void setImpresaSystem(String impresaSystem) {
		this.impresaSystem = impresaSystem;
	}

	public String getSubAppalto() {
		return subAppalto;
	}

	public void setSubAppalto(String subAppalto) {
		this.subAppalto = subAppalto;
	}

	public String getTipologiaImpresa() {
		return tipologiaImpresa;
	}

	public void setTipologiaImpresa(String tipologiaImpresa) {
		this.tipologiaImpresa = tipologiaImpresa;
	}
}
