package com.nttdata.tim.now.data.bean.anagraficacoinvestimento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


//RU_1276
@JsonInclude(Include.NON_NULL)
public class FileComuniCoinvestimentoOutputBean implements Serializable {

	private static final long serialVersionUID = 8530239980119175210L;

	@JsonProperty("nomeFile")
    private String nomeFile;
	
    @JsonProperty("dataInserimento")
    private String dataInserimento;
    
    @JsonProperty("dataAggiornamento")
    private String dataAggiornamento;
	
    @JsonProperty("statoElaborazione")
    private String statoElaborazione;
        
    @JsonProperty("idFile")
    private String idFile;
    
    @JsonProperty("position")
    private String position;
    
    @JsonProperty("oao")
    private String oao;
    
    @JsonProperty("tipologiaTracciato")
    private String tipologiaTracciato;
    
    //RU_1301
    @JsonProperty("nomeContratto")
    private String nomeContratto;
    
    @JsonProperty("offerta")
    private String offerta;

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(String dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getDataAggiornamento() {
		return dataAggiornamento;
	}

	public void setDataAggiornamento(String dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}

	public String getStatoElaborazione() {
		return statoElaborazione;
	}

	public void setStatoElaborazione(String statoElaborazione) {
		this.statoElaborazione = statoElaborazione;
	}

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getOao() {
		return oao;
	}

	public void setOao(String oao) {
		this.oao = oao;
	}

	public String getTipologiaTracciato() {
		return tipologiaTracciato;
	}

	public void setTipologiaTracciato(String tipologiaTracciato) {
		this.tipologiaTracciato = tipologiaTracciato;
	}

	public String getNomeContratto() {
		return nomeContratto;
	}

	public void setNomeContratto(String nomeContratto) {
		this.nomeContratto = nomeContratto;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}
}
