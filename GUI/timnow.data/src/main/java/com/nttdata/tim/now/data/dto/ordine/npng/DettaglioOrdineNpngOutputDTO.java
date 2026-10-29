package com.nttdata.tim.now.data.dto.ordine.npng;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.ordine.npng.CausaleRifiutoOutputBean;

//RU_1203
@JsonInclude(Include.NON_NULL)
public class DettaglioOrdineNpngOutputDTO implements Serializable {

	private static final long serialVersionUID = 8222470990423418385L;
	@JsonProperty("noteAggiuntive")
	private String noteAggiuntive;
	
	@JsonProperty("unitaOrganizzativa")
	private String unitaOrganizzativa;

	@JsonProperty("causaleRifiuto")
	private List<CausaleRifiutoOutputBean> causaleRifiuto;
	
	@JsonProperty("opzioneTraffico")
	private String opzioneTraffico;
	
	@JsonProperty("dac")
	private String dac;
	
	@JsonProperty("statoOrdine")
	private String statoOrdine;
	
	@JsonProperty("oloDonating")
	private String oloDonating;
	
	@JsonProperty("idRichiestaOlo")
	private String idRichiestaOlo;
	
	@JsonProperty("codOrdineTi")
	private String codOrdineTi;
	
	@JsonProperty("lavorazione")
	private String lavorazione;
	
	@JsonProperty("oloDonor")
	private String oloDonor;
	
	@JsonProperty("statoSuccessivo")
	private List<String> statoSuccessivo;
	
	@JsonProperty("codProgetto")
	private String codProgetto;
	
	@JsonProperty("routingNumber")
	private String routingNumber;
	
	@JsonProperty("olo")
	private String olo;	
	
	@JsonProperty("dsc")
	private String dsc;
	
	@JsonProperty("ultimaFattura")
	private String ultimaFattura;
	
	@JsonProperty("tipologiaProvisioning")
	private String tipologiaProvisioning;
	
	@JsonProperty("penultimaFattura")
	private String penultimaFattura;
	
	//Bug #36077
	@JsonProperty("tipoMovimentazione")
	private String tipoMovimentazione;
	
	//SM_10866
	@JsonProperty("oraCutOver")
	private String oraCutOver;
	
	public String getNoteAggiuntive() {
		return noteAggiuntive;
	}

	public void setNoteAggiuntive(String noteAggiuntive) {
		this.noteAggiuntive = noteAggiuntive;
	}

	public String getUnitaOrganizzativa() {
		return unitaOrganizzativa;
	}

	public void setUnitaOrganizzativa(String unitaOrganizzativa) {
		this.unitaOrganizzativa = unitaOrganizzativa;
	}

	public List<CausaleRifiutoOutputBean> getCausaleRifiuto() {
		return causaleRifiuto;
	}

	public void setCausaleRifiuto(List<CausaleRifiutoOutputBean> causaleRifiuto) {
		this.causaleRifiuto = causaleRifiuto;
	}

	public String getOpzioneTraffico() {
		return opzioneTraffico;
	}

	public void setOpzioneTraffico(String opzioneTraffico) {
		this.opzioneTraffico = opzioneTraffico;
	}

	public String getDac() {
		return dac;
	}

	public void setDac(String dac) {
		this.dac = dac;
	}

	public String getStatoOrdine() {
		return statoOrdine;
	}

	public void setStatoOrdine(String statoOrdine) {
		this.statoOrdine = statoOrdine;
	}

	public String getOloDonating() {
		return oloDonating;
	}

	public void setOloDonating(String oloDonating) {
		this.oloDonating = oloDonating;
	}

	public String getCodOrdineTi() {
		return codOrdineTi;
	}

	public void setCodOrdineTi(String codOrdineTi) {
		this.codOrdineTi = codOrdineTi;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getOloDonor() {
		return oloDonor;
	}

	public void setOloDonor(String oloDonor) {
		this.oloDonor = oloDonor;
	}

	public String getCodProgetto() {
		return codProgetto;
	}

	public void setCodProgetto(String codProgetto) {
		this.codProgetto = codProgetto;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getOlo() {
		return olo;
	}

	public void setOlo(String olo) {
		this.olo = olo;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public String getUltimaFattura() {
		return ultimaFattura;
	}

	public void setUltimaFattura(String ultimaFattura) {
		this.ultimaFattura = ultimaFattura;
	}

	public String getTipologiaProvisioning() {
		return tipologiaProvisioning;
	}

	public void setTipologiaProvisioning(String tipologiaProvisioning) {
		this.tipologiaProvisioning = tipologiaProvisioning;
	}

	public String getPenultimaFattura() {
		return penultimaFattura;
	}

	public void setPenultimaFattura(String penultimaFattura) {
		this.penultimaFattura = penultimaFattura;
	}

	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}

	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
	}

	public List<String> getStatoSuccessivo() {
		return statoSuccessivo;
	}

	public void setStatoSuccessivo(List<String> statoSuccessivo) {
		this.statoSuccessivo = statoSuccessivo;
	}

	public String getTipoMovimentazione() {
		return tipoMovimentazione;
	}

	public void setTipoMovimentazione(String tipoMovimentazione) {
		this.tipoMovimentazione = tipoMovimentazione;
	}

	public String getOraCutOver() {
		return oraCutOver;
	}

	public void setOraCutOver(String oraCutOver) {
		this.oraCutOver = oraCutOver;
	}
}
