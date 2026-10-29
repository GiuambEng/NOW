package com.nttdata.tim.now.data.bean.notifica;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class FileFwaOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 7093615657644601226L;

	@JsonProperty("nomeFile")
	private String nomeFile;
	
	@JsonProperty("operatoreUltimaModifica")
	private String operatoreUltimaModifica;
	
	@JsonProperty("dataInserimento")
	private String dataInserimento;
	
	@JsonProperty("operatoreInserimento")
	private String operatoreInserimento;
	
	@JsonProperty("idFile")
	private String idFile;
	
	@JsonProperty("numeroRecord")
	private String numeroRecord;

	@JsonProperty("descrizioneEsito")
	private String descrizioneEsito;
	
	@JsonProperty("dataUltimaModifica")
	private String dataUltimaModifica;
	
	@JsonProperty("position")
	private Integer position;

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getOperatoreUltimaModifica() {
		return operatoreUltimaModifica;
	}

	public void setOperatoreUltimaModifica(String operatoreUltimaModifica) {
		this.operatoreUltimaModifica = operatoreUltimaModifica;
	}

	public String getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(String dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getOperatoreInserimento() {
		return operatoreInserimento;
	}

	public void setOperatoreInserimento(String operatoreInserimento) {
		this.operatoreInserimento = operatoreInserimento;
	}

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	public String getNumeroRecord() {
		return numeroRecord;
	}

	public void setNumeroRecord(String numeroRecord) {
		this.numeroRecord = numeroRecord;
	}

	public String getDescrizioneEsito() {
		return descrizioneEsito;
	}

	public void setDescrizioneEsito(String descrizioneEsito) {
		this.descrizioneEsito = descrizioneEsito;
	}

	public String getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(String dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
}