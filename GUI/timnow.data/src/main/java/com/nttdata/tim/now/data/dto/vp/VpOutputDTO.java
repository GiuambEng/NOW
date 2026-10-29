package com.nttdata.tim.now.data.dto.vp;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class VpOutputDTO implements Serializable {

	private static final long serialVersionUID = 2929702367934869518L;

	@JsonProperty("codiceVP")
	private String codiceVP;

	@JsonProperty("stato")
	private String stato;

	@JsonProperty("modalitaFatturazione")
	private String modalitaFatturazione;

	@JsonProperty("tipo")
	private String tipo;

	@JsonProperty("bandaMCR")
	private String bandaMCR;

	@JsonProperty("bandaPCR")
	private String bandaPCR;

	@JsonProperty("codiceAreaRaccolta")
	private String codiceAreaRaccolta;

	@JsonProperty("descAreaRaccolta")
	private String descAreaRaccolta;

	@JsonProperty("codiceKit")
	private String codiceKit;

	@JsonProperty("vpiRete")
	private String vpiRete;

	@JsonProperty("vpi")
	private String vpi;

	@JsonProperty("tipoTrasporto")
	private String tipoTrasporto;

	@JsonProperty("clli")
	private String clli;

	@JsonProperty("nomeCentrale")
	private String nomeCentrale;

	@JsonProperty("numeroMaxVc")
	private String numeroMaxVc;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonProperty("codiceOlo")
	private String codiceOlo;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataConsegnaOlo")
	private Date dataConsegnaOlo;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("decAttivazione")
	private Date decAttivazione;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dec")
	private Date dec;

	public String getCodiceVP() {
		return codiceVP;
	}

	public void setCodiceVP(String codiceVP) {
		this.codiceVP = codiceVP;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getModalitaFatturazione() {
		return modalitaFatturazione;
	}

	public void setModalitaFatturazione(String modalitaFatturazione) {
		this.modalitaFatturazione = modalitaFatturazione;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getBandaMCR() {
		return bandaMCR;
	}

	public void setBandaMCR(String bandaMCR) {
		this.bandaMCR = bandaMCR;
	}

	public String getBandaPCR() {
		return bandaPCR;
	}

	public void setBandaPCR(String bandaPCR) {
		this.bandaPCR = bandaPCR;
	}

	public String getCodiceAreaRaccolta() {
		return codiceAreaRaccolta;
	}

	public void setCodiceAreaRaccolta(String codiceAreaRaccolta) {
		this.codiceAreaRaccolta = codiceAreaRaccolta;
	}

	public String getDescAreaRaccolta() {
		return descAreaRaccolta;
	}

	public void setDescAreaRaccolta(String descAreaRaccolta) {
		this.descAreaRaccolta = descAreaRaccolta;
	}

	public String getCodiceKit() {
		return codiceKit;
	}

	public void setCodiceKit(String codiceKit) {
		this.codiceKit = codiceKit;
	}

	public String getVpiRete() {
		return vpiRete;
	}

	public void setVpiRete(String vpiRete) {
		this.vpiRete = vpiRete;
	}

	public String getVpi() {
		return vpi;
	}

	public void setVpi(String vpi) {
		this.vpi = vpi;
	}

	public String getTipoTrasporto() {
		return tipoTrasporto;
	}

	public void setTipoTrasporto(String tipoTrasporto) {
		this.tipoTrasporto = tipoTrasporto;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getNomeCentrale() {
		return nomeCentrale;
	}

	public void setNomeCentrale(String nomeCentrale) {
		this.nomeCentrale = nomeCentrale;
	}

	public String getNumeroMaxVc() {
		return numeroMaxVc;
	}

	public void setNumeroMaxVc(String numeroMaxVc) {
		this.numeroMaxVc = numeroMaxVc;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getCodiceOlo() {
		return codiceOlo;
	}

	public void setCodiceOlo(String codiceOlo) {
		this.codiceOlo = codiceOlo;
	}

	public Date getDec() {
		return dec;
	}

	public void setDec(Date dec) {
		this.dec = dec;
	}

	public Date getDataConsegnaOlo() {
		return dataConsegnaOlo;
	}

	public void setDataConsegnaOlo(Date dataConsegnaOlo) {
		this.dataConsegnaOlo = dataConsegnaOlo;
	}

	public Date getDecAttivazione() {
		return decAttivazione;
	}

	public void setDecAttivazione(Date decAttivazione) {
		this.decAttivazione = decAttivazione;
	}

}
