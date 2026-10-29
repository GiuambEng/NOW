package com.nttdata.tim.now.data.dto.notifica;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class FileIncentiviOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 8482671893554435588L;

	@JsonProperty("idFile")
	private String idFile;
	
	@JsonProperty("nomeFile")
	private String nomeFile;
	
	@JsonProperty("codificaOao")
	private String codificaOao;
	
	@JsonProperty("position")
	private Integer position;

	@JsonProperty("dataCreazioneFile")
	private String dataCreazioneFile;
	
	//RU_1312
	@JsonProperty("tipologiaFile")
	private String tipologiaFile;
	
	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getCodificaOao() {
		return codificaOao;
	}

	public void setCodificaOao(String codificaOao) {
		this.codificaOao = codificaOao;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getDataCreazioneFile() {
		return dataCreazioneFile;
	}

	public void setDataCreazioneFile(String dataCreazioneFile) {
		this.dataCreazioneFile = dataCreazioneFile;
	}

	public String getTipologiaFile() {
		return tipologiaFile;
	}

	public void setTipologiaFile(String tipologiaFile) {
		this.tipologiaFile = tipologiaFile;
	}

}
