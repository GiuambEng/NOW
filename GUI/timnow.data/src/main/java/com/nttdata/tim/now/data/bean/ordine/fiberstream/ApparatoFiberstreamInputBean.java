package com.nttdata.tim.now.data.bean.ordine.fiberstream;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1452
@JsonInclude(Include.NON_NULL)
public class ApparatoFiberstreamInputBean implements Serializable {

	private static final long serialVersionUID = -5053945428995063959L;

	@JsonProperty("idServizioAggiuntivo")
    private String idServizioAggiuntivo;
	
	@JsonProperty("codiceApparato")
    private String codiceApparato;
	
	@JsonProperty("tipologiaApparato")
    private String tipologiaApparato;
	
	@JsonProperty("passwordApparato")
    private String passwordApparato;
	
	@JsonProperty("azioneApparato")
    private String azioneApparato;
	
	@JsonProperty("qtaApparato")
    private String qtaApparato;
	
	@JsonProperty("causale")
    private String causale;

	public String getIdServizioAggiuntivo() {
		return idServizioAggiuntivo;
	}

	public void setIdServizioAggiuntivo(String idServizioAggiuntivo) {
		this.idServizioAggiuntivo = idServizioAggiuntivo;
	}

	public String getCodiceApparato() {
		return codiceApparato;
	}

	public void setCodiceApparato(String codiceApparato) {
		this.codiceApparato = codiceApparato;
	}

	public String getTipologiaApparato() {
		return tipologiaApparato;
	}

	public void setTipologiaApparato(String tipologiaApparato) {
		this.tipologiaApparato = tipologiaApparato;
	}

	public String getPasswordApparato() {
		return passwordApparato;
	}

	public void setPasswordApparato(String passwordApparato) {
		this.passwordApparato = passwordApparato;
	}

	public String getAzioneApparato() {
		return azioneApparato;
	}

	public void setAzioneApparato(String azioneApparato) {
		this.azioneApparato = azioneApparato;
	}

	public String getQtaApparato() {
		return qtaApparato;
	}

	public void setQtaApparato(String qtaApparato) {
		this.qtaApparato = qtaApparato;
	}

	public String getCausale() {
		return causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}
}
