package com.nttdata.tim.now.data.dto.idsluco;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class IdslucoOutputDTO implements Serializable {

	private static final long serialVersionUID = 3069266267506065000L;

	@JsonProperty("codiceClliCentrale")
	private String codiceClliCentrale;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonProperty("coppiA")
	private String coppiA;

	@JsonProperty("coppiaDa")
	private String coppiaDa;

	@JsonProperty("idsluco")
	private String idsluco;

	@JsonProperty("testarmadio")
	private String testarmadio;

	@JsonProperty("progressivo")
	private int progressivo;

	@JsonProperty("identificativoRichiestaFattibilita")
	private int identificativoRichiestaFattibilita;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineValidita")
	private Date dataFineValidita;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioValidita")
	private Date dataInizioValidita;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInvioRichiesta")
	private Date dataInvioRichiesta;

	public String getCodiceClliCentrale() {
		return codiceClliCentrale;
	}

	public void setCodiceClliCentrale(String codiceClliCentrale) {
		this.codiceClliCentrale = codiceClliCentrale;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getCoppiA() {
		return coppiA;
	}

	public void setCoppiA(String coppiA) {
		this.coppiA = coppiA;
	}

	public String getCoppiaDa() {
		return coppiaDa;
	}

	public void setCoppiaDa(String coppiaDa) {
		this.coppiaDa = coppiaDa;
	}

	public String getIdsluco() {
		return idsluco;
	}

	public void setIdsluco(String idsluco) {
		this.idsluco = idsluco;
	}

	public String getTestarmadio() {
		return testarmadio;
	}

	public void setTestarmadio(String testarmadio) {
		this.testarmadio = testarmadio;
	}

	public Date getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(Date dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public Date getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public Date getDataInvioRichiesta() {
		return dataInvioRichiesta;
	}

	public void setDataInvioRichiesta(Date dataInvioRichiesta) {
		this.dataInvioRichiesta = dataInvioRichiesta;
	}

	public int getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(int progressivo) {
		this.progressivo = progressivo;
	}

	public int getIdentificativoRichiestaFattibilita() {
		return identificativoRichiestaFattibilita;
	}

	public void setIdentificativoRichiestaFattibilita(int identificativoRichiestaFattibilita) {
		this.identificativoRichiestaFattibilita = identificativoRichiestaFattibilita;
	}
}
