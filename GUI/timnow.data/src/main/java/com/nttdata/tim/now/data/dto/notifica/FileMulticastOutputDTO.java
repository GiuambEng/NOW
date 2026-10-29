package com.nttdata.tim.now.data.dto.notifica;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class FileMulticastOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 8482671893554435588L;

	@JsonProperty("nomeFile")
	private String nomeFile;
	
	@JsonProperty("numeroOrdini")
	private String numeroOrdini;
	
	@JsonProperty("dataInserimentoFile")
	private String dataInserimentoFile;
	
	@JsonProperty("idFile")
	private String idFile;
	
	@JsonProperty("statoElaborazioneFile")
	private String statoElaborazioneFile;
	
	@JsonProperty("position")
	private Integer position;
	
	@JsonProperty("idInterfaccia")
	private String idInterfaccia;

	@JsonProperty("tipologiaTracciato")
	private String tipologiaTracciato;
	
	@JsonProperty("dataUltimoAggiornamento")
	private String dataUltimoAggiornamento;

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getNumeroOrdini() {
		return numeroOrdini;
	}

	public void setNumeroOrdini(String numeroOrdini) {
		this.numeroOrdini = numeroOrdini;
	}

	public String getDataInserimentoFile() {
		return dataInserimentoFile;
	}

	public void setDataInserimentoFile(String dataInserimentoFile) {
		this.dataInserimentoFile = dataInserimentoFile;
	}

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	public String getStatoElaborazioneFile() {
		return statoElaborazioneFile;
	}

	public void setStatoElaborazioneFile(String statoElaborazioneFile) {
		this.statoElaborazioneFile = statoElaborazioneFile;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getIdInterfaccia() {
		return idInterfaccia;
	}

	public void setIdInterfaccia(String idInterfaccia) {
		this.idInterfaccia = idInterfaccia;
	}

	public String getTipologiaTracciato() {
		return tipologiaTracciato;
	}

	public void setTipologiaTracciato(String tipologiaTracciato) {
		this.tipologiaTracciato = tipologiaTracciato;
	}

	public String getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}

	public void setDataUltimoAggiornamento(String dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}

	
}
