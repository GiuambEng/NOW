package com.nttdata.tim.now.data.dto.monitoring.fatturazione;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneFileOutputDTO implements Serializable {

	private static final long serialVersionUID = -8423835332729263538L;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataAcquisizione")
	private Date dataAcquisizione;

	@JsonProperty("InviatoAFatturazione")
	private String inviatoAFatturazione;

	@JsonProperty("EspletamentoTecnico")
	private String espletamentoTecnico;

	@JsonProperty("FatturazioneKo")
	private String fatturazioneKo;

	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}

	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}

	public String getInviatoAFatturazione() {
		return inviatoAFatturazione;
	}

	public void setInviatoAFatturazione(String inviatoAFatturazione) {
		this.inviatoAFatturazione = inviatoAFatturazione;
	}

	public String getEspletamentoTecnico() {
		return espletamentoTecnico;
	}

	public void setEspletamentoTecnico(String espletamentoTecnico) {
		this.espletamentoTecnico = espletamentoTecnico;
	}

	public String getFatturazioneKo() {
		return fatturazioneKo;
	}

	public void setFatturazioneKo(String fatturazioneKo) {
		this.fatturazioneKo = fatturazioneKo;
	}

	@Override
	public String toString() {
		return "MonitoraggioFatturazioneFileOutputDTO [dataAcquisizione=" + dataAcquisizione
				+ ", inviatoAFatturazione=" + inviatoAFatturazione + ", espletamentoTecnico=" + espletamentoTecnico
				+ ", fatturazioneKo=" + fatturazioneKo + "]";
	}

}
