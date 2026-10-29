package com.nttdata.tim.now.data.dto.ordine.hashing;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportOutputDTO implements Serializable {

	private static final long serialVersionUID = 603608275807518222L;

	@JsonProperty("dataInserimento")
	private String dataInserimento;
	
	@JsonProperty("idReport")
	private String idReport;
	
	@JsonProperty("dataAggiornamento")
	private String dataAggiornamento;
	
	@JsonProperty("statoElabReport")
	private String statoElabReport;
	
	@JsonProperty("nomeReport")
	private String nomeReport;
	
	@JsonProperty("tipoLista")
	private String tipoLista;
	
	@JsonProperty("dettaglioElabReport")
	private String dettaglioElabReport;

	public String getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(String dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getIdReport() {
		return idReport;
	}

	public void setIdReport(String idReport) {
		this.idReport = idReport;
	}

	public String getDataAggiornamento() {
		return dataAggiornamento;
	}

	public void setDataAggiornamento(String dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}

	public String getStatoElabReport() {
		return statoElabReport;
	}

	public void setStatoElabReport(String statoElabReport) {
		this.statoElabReport = statoElabReport;
	}

	public String getNomeReport() {
		return nomeReport;
	}

	public void setNomeReport(String nomeReport) {
		this.nomeReport = nomeReport;
	}

	public String getTipoLista() {
		return tipoLista;
	}

	public void setTipoLista(String tipoLista) {
		this.tipoLista = tipoLista;
	}

	public String getDettaglioElabReport() {
		return dettaglioElabReport;
	}

	public void setDettaglioElabReport(String dettaglioElabReport) {
		this.dettaglioElabReport = dettaglioElabReport;
	}
}
