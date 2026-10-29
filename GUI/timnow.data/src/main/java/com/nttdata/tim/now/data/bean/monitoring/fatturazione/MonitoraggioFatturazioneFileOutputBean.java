package com.nttdata.tim.now.data.bean.monitoring.fatturazione;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneFileOutputBean implements Serializable {

	private static final long serialVersionUID = 7586604473173462516L;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataAcquisizione")
	private Date dataAcquisizione;

	@JsonProperty("inviatoFatturazione")
	private String inviatoAFatturazione;

	@JsonProperty("espletamentoTecnico")
	private String espletamentoTecnico;

	@JsonProperty("fatturazioneKo")
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
		return "MonitoraggioFatturazioneFileOutputBean [dataAcquisizione=" + dataAcquisizione
				+ ", inviatoAFatturazione=" + inviatoAFatturazione + ", espletamentoTecnico=" + espletamentoTecnico
				+ ", fatturazioneKo=" + fatturazioneKo + "]";
	}

}
