package com.nttdata.tim.now.data.bean.cliente;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class ClienteOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -8512504376477227658L;

    @JsonProperty("nome")
	private String nome;

	@JsonProperty("ragioneSociale")
	private String ragioneSociale;

	@JsonProperty("indirizzoEmail")
	private String indirizzoEmail;

	@JsonProperty("partitaIva")
	private String partitaIva;

	@JsonProperty("codiceOlo")
	private String codiceOlo;

	@JsonProperty("codificaAgcom")
	private String codificaAgcom;

	@JsonProperty("codificaOloRete")
	private String codificaOloRete;

	@JsonProperty("tipologiaOlo")
	private String tipologiaOlo;

	@JsonProperty("nomeAccorpante")
	private String nomeAccorpante;

	@JsonProperty("statoAccorpamento")
	private String statoAccorpamento;

	@JsonProperty("operatore")
	private String operatore;

	@JsonProperty("moroso")
	private boolean moroso;

	@JsonProperty("flagSanMarino")
	private boolean flagSanMarino;

	@JsonProperty("flagOloAccorpante")
	private boolean flagOloAccorpante;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataAccorpamento")
	private Date dataAccorpamento;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInserimento")
	private Date dataInserimento;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataUltimoAggiornamento")
	private Date dataUltimoAggiornamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getIndirizzoEmail() {
		return indirizzoEmail;
	}

	public void setIndirizzoEmail(String indirizzoEmail) {
		this.indirizzoEmail = indirizzoEmail;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getCodiceOlo() {
		return codiceOlo;
	}

	public void setCodiceOlo(String codiceOlo) {
		this.codiceOlo = codiceOlo;
	}

	public String getCodificaAgcom() {
		return codificaAgcom;
	}

	public void setCodificaAgcom(String codificaAgcom) {
		this.codificaAgcom = codificaAgcom;
	}

	public String getCodificaOloRete() {
		return codificaOloRete;
	}

	public void setCodificaOloRete(String codificaOloRete) {
		this.codificaOloRete = codificaOloRete;
	}

	public String getTipologiaOlo() {
		return tipologiaOlo;
	}

	public void setTipologiaOlo(String tipologiaOlo) {
		this.tipologiaOlo = tipologiaOlo;
	}

	public String getNomeAccorpante() {
		return nomeAccorpante;
	}

	public void setNomeAccorpante(String nomeAccorpante) {
		this.nomeAccorpante = nomeAccorpante;
	}

	public boolean getMoroso() {
		return moroso;
	}

	public void setMoroso(boolean moroso) {
		this.moroso = moroso;
	}

	public String getStatoAccorpamento() {
		return statoAccorpamento;
	}

	public void setStatoAccorpamento(String statoAccorpamento) {
		this.statoAccorpamento = statoAccorpamento;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public boolean isFlagSanMarino() {
		return flagSanMarino;
	}

	public void setFlagSanMarino(boolean flagSanMarino) {
		this.flagSanMarino = flagSanMarino;
	}

	public boolean isFlagOloAccorpante() {
		return flagOloAccorpante;
	}

	public void setFlagOloAccorpante(boolean flagOloAccorpante) {
		this.flagOloAccorpante = flagOloAccorpante;
	}

	public Date getDataAccorpamento() {
		return dataAccorpamento;
	}

	public void setDataAccorpamento(Date dataAccorpamento) {
		this.dataAccorpamento = dataAccorpamento;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Date getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}

	public void setDataUltimoAggiornamento(Date dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}

}