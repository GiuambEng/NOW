package com.nttdata.tim.now.data.bean.ordine.npng;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

//RU_1203
@JsonInclude(Include.NON_NULL)
public class LavorazioneManualeOrdineNpngInputBean implements Serializable {

	private static final long serialVersionUID = -5911542658317205473L;
	
	@JsonProperty("idRichiestaOloTarget")
	private String idRichiestaOloTarget;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataDes")
    private Date dataDes;
	
	@JsonProperty("oraDes")
    private String oraDes;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataCutover")
    private Date dataCutover;
	
	@JsonProperty("oraCutover")
    private String oraCutover;
	
	@JsonProperty("tipoPortabilita")
    private String tipoPortabilita;
	
	@JsonProperty("unitaOrganizzativa")
    private String unitaOrganizzativa;
	
	@JsonProperty("ultimaFattura")
    private String ultimaFattura;
	
	@JsonProperty("penultimaFattura")
    private String penultimaFattura;
	
	@JsonProperty("causaleRifiuto")
    private String causaleRifiuto;
	
	@JsonProperty("operatore")
    private String operatore;
	
	@JsonProperty("oao")
    private String oao;
	
	@JsonProperty("stato")
    private String stato;
	
	@JsonProperty("statoSuccessivo")
    private String statoSuccessivo;
	
	@JsonProperty("lavorazione")
    private String lavorazione;

	public String getIdRichiestaOloTarget() {
		return idRichiestaOloTarget;
	}

	public Date getDataDes() {
		return dataDes;
	}

	public String getOraDes() {
		return oraDes;
	}

	public Date getDataCutover() {
		return dataCutover;
	}

	public String getOraCutover() {
		return oraCutover;
	}

	public String getTipoPortabilita() {
		return tipoPortabilita;
	}

	public String getUnitaOrganizzativa() {
		return unitaOrganizzativa;
	}

	public String getUltimaFattura() {
		return ultimaFattura;
	}

	public String getPenultimaFattura() {
		return penultimaFattura;
	}

	public String getCausaleRifiuto() {
		return causaleRifiuto;
	}

	public String getOperatore() {
		return operatore;
	}

	public String getOao() {
		return oao;
	}

	public String getStato() {
		return stato;
	}

	public String getStatoSuccessivo() {
		return statoSuccessivo;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setIdRichiestaOloTarget(String idRichiestaOloTarget) {
		this.idRichiestaOloTarget = idRichiestaOloTarget;
	}

	public void setDataDes(Date dataDes) {
		this.dataDes = dataDes;
	}

	public void setOraDes(String oraDes) {
		this.oraDes = oraDes;
	}

	public void setDataCutover(Date dataCutover) {
		this.dataCutover = dataCutover;
	}

	public void setOraCutover(String oraCutover) {
		this.oraCutover = oraCutover;
	}

	public void setTipoPortabilita(String tipoPortabilita) {
		this.tipoPortabilita = tipoPortabilita;
	}

	public void setUnitaOrganizzativa(String unitaOrganizzativa) {
		this.unitaOrganizzativa = unitaOrganizzativa;
	}

	public void setUltimaFattura(String ultimaFattura) {
		this.ultimaFattura = ultimaFattura;
	}

	public void setPenultimaFattura(String penultimaFattura) {
		this.penultimaFattura = penultimaFattura;
	}

	public void setCausaleRifiuto(String causaleRifiuto) {
		this.causaleRifiuto = causaleRifiuto;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public void setOao(String oao) {
		this.oao = oao;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public void setStatoSuccessivo(String statoSuccessivo) {
		this.statoSuccessivo = statoSuccessivo;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}
}
