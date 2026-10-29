package com.nttdata.tim.now.data.bean.notifica;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class FileMulticastOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 2203432366110901335L;

	@JsonProperty("idFile")
	private String idFile;
	
	@JsonProperty("nomeFile")
	private String nomeFile;
	
	@JsonProperty("codificaOao")
	private String codificaOao;
	
	@JsonProperty("position")
	private Integer position;

	@JsonProperty("dataCreazioneFile")
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	private String dataCreazioneFile;
	
	@JsonProperty("tipologiaTracciato")
	private String tipologiaTracciato;
	
	@JsonProperty("dataInserimentoFile")
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	private String dataInserimentoFile;
	
	@JsonProperty("statoElaborazioneFile")
	private String statoElaborazioneFile;
	
	@JsonProperty("idInterfaccia")
	private String idInterfaccia;
	
	@JsonProperty("dataUltimoAggiornamento")
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	private String dataUltimoAggiornamento;
	
	@JsonProperty("numeroOrdini")
	private String numeroOrdini;

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

	public String getTipologiaTracciato() {
		return tipologiaTracciato;
	}

	public String getDataInserimentoFile() {
		return dataInserimentoFile;
	}

	public String getStatoElaborazioneFile() {
		return statoElaborazioneFile;
	}

	public String getIdInterfaccia() {
		return idInterfaccia;
	}

	public void setTipologiaTracciato(String tipologiaTracciato) {
		this.tipologiaTracciato = tipologiaTracciato;
	}

	public void setDataInserimentoFile(String dataInserimentoFile) {
		this.dataInserimentoFile = dataInserimentoFile;
	}

	public void setStatoElaborazioneFile(String statoElaborazioneFile) {
		this.statoElaborazioneFile = statoElaborazioneFile;
	}

	public void setIdInterfaccia(String idInterfaccia) {
		this.idInterfaccia = idInterfaccia;
	}

	public String getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}

	public void setDataUltimoAggiornamento(String dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}

	public String getNumeroOrdini() {
		return numeroOrdini;
	}

	public void setNumeroOrdini(String numeroOrdini) {
		this.numeroOrdini = numeroOrdini;
	}	
}