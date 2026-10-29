package com.nttdata.tim.now.data.dto.anagraficagpon;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1308
@JsonInclude(Include.NON_NULL)
public class AnagraficaGponOutputDTO implements Serializable {

	private static final long serialVersionUID = 6472122809777988231L;

	@JsonProperty("idGpon")
    private String idGpon;
	
    @JsonProperty("puntoInterconnessione")
    private String puntoInterconnessione;
	
	@JsonProperty("codificaOloAgcom")
    private String codificaOloAgcom;
	
	@JsonProperty("codiceAreaCentrale")
    private String codiceAreaCentrale;
	
    @JsonProperty("dataFineValidita")
    private String dataFineValidita;
	
	@JsonProperty("tipoAccesso")
    private String tipoAccesso;
	
	@JsonProperty("coinvestimento")
    private String coinvestimento;
        
    @JsonProperty("timestampInserimento")
    private String timestampInserimento;
	
    @JsonProperty("timestampAggiornamento")
    private String timestampAggiornamento;  
	
    @JsonProperty("idFileProcstoInput")
    private String idFileProcstoInput;
    
    @JsonProperty("numeroRecord")
    private String numeroRecord;
    
    //RU_1338
    @JsonProperty("fattoreDiSplitting")
    private String fattoreDiSplitting;
    
    @JsonProperty("dataRegistrazioneFattoreSplitting")
    private String dataRegistrazioneFattoreSplitting;
    
    @JsonProperty("idGponValido")
    private String idGponValido;

	public String getIdGpon() {
		return idGpon;
	}

	public void setIdGpon(String idGpon) {
		this.idGpon = idGpon;
	}

	public String getPuntoInterconnessione() {
		return puntoInterconnessione;
	}

	public void setPuntoInterconnessione(String puntoInterconnessione) {
		this.puntoInterconnessione = puntoInterconnessione;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getCodiceAreaCentrale() {
		return codiceAreaCentrale;
	}

	public void setCodiceAreaCentrale(String codiceAreaCentrale) {
		this.codiceAreaCentrale = codiceAreaCentrale;
	}

	public String getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(String dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public String getTipoAccesso() {
		return tipoAccesso;
	}

	public void setTipoAccesso(String tipoAccesso) {
		this.tipoAccesso = tipoAccesso;
	}

	public String getCoinvestimento() {
		return coinvestimento;
	}

	public void setCoinvestimento(String coinvestimento) {
		this.coinvestimento = coinvestimento;
	}

	public String getTimestampInserimento() {
		return timestampInserimento;
	}

	public void setTimestampInserimento(String timestampInserimento) {
		this.timestampInserimento = timestampInserimento;
	}

	public String getTimestampAggiornamento() {
		return timestampAggiornamento;
	}

	public void setTimestampAggiornamento(String timestampAggiornamento) {
		this.timestampAggiornamento = timestampAggiornamento;
	}

	public String getIdFileProcstoInput() {
		return idFileProcstoInput;
	}

	public void setIdFileProcstoInput(String idFileProcstoInput) {
		this.idFileProcstoInput = idFileProcstoInput;
	}

	public String getNumeroRecord() {
		return numeroRecord;
	}

	public void setNumeroRecord(String numeroRecord) {
		this.numeroRecord = numeroRecord;
	}

	public String getFattoreDiSplitting() {
		return fattoreDiSplitting;
	}

	public void setFattoreDiSplitting(String fattoreDiSplitting) {
		this.fattoreDiSplitting = fattoreDiSplitting;
	}

	public String getDataRegistrazioneFattoreSplitting() {
		return dataRegistrazioneFattoreSplitting;
	}

	public void setDataRegistrazioneFattoreSplitting(String dataRegistrazioneFattoreSplitting) {
		this.dataRegistrazioneFattoreSplitting = dataRegistrazioneFattoreSplitting;
	}

	public String getIdGponValido() {
		return idGponValido;
	}

	public void setIdGponValido(String idGponValido) {
		this.idGponValido = idGponValido;
	}


}
