package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1485
public class ServiziOpzionaliAlternativiOutputBean implements Serializable {

	private static final long serialVersionUID = -1872724697488515392L;

	@JsonProperty("codiceProgetto")
	private String codiceProgetto;
	
	@JsonProperty("servizioOpzionalePadre")
	private String servizioOpzionalePadre;
	
	@JsonProperty("servizioOpzionaleAlternativo")
	private String servizioOpzionaleAlternativo;
	
	@JsonProperty("descrizioneAnagraficaServizioOpzionale")
	private String descrizioneAnagraficaServizioOpzionale;

	public String getCodiceProgetto() {
		return codiceProgetto;
	}

	public void setCodiceProgetto(String codiceProgetto) {
		this.codiceProgetto = codiceProgetto;
	}

	public String getServizioOpzionalePadre() {
		return servizioOpzionalePadre;
	}

	public void setServizioOpzionalePadre(String servizioOpzionalePadre) {
		this.servizioOpzionalePadre = servizioOpzionalePadre;
	}

	public String getServizioOpzionaleAlternativo() {
		return servizioOpzionaleAlternativo;
	}

	public void setServizioOpzionaleAlternativo(String servizioOpzionaleAlternativo) {
		this.servizioOpzionaleAlternativo = servizioOpzionaleAlternativo;
	}

	public String getDescrizioneAnagraficaServizioOpzionale() {
		return descrizioneAnagraficaServizioOpzionale;
	}

	public void setDescrizioneAnagraficaServizioOpzionale(String descrizioneAnagraficaServizioOpzionale) {
		this.descrizioneAnagraficaServizioOpzionale = descrizioneAnagraficaServizioOpzionale;
	}
}
