package com.nttdata.tim.now.data.bean.gui;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class VisualizzazioneGuiOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -6121901610310104050L;

    @JsonProperty("codiceOloNumerico")
	private String codiceOloNumerico;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioAbilitazione")
	private Date dataInizioAbilitazione;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineAbilitazione")
	private Date dataFineAbilitazione;

	@JsonProperty("flagMonitoraggio")
	private boolean flagMonitoraggio;

	public String getCodiceOloNumerico() {
		return codiceOloNumerico;
	}

	public void setCodiceOloNumerico(String codiceOloNumerico) {
		this.codiceOloNumerico = codiceOloNumerico;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public Date getDataInizioAbilitazione() {
		return dataInizioAbilitazione;
	}

	public void setDataInizioAbilitazione(Date dataInizioAbilitazione) {
		this.dataInizioAbilitazione = dataInizioAbilitazione;
	}

	public Date getDataFineAbilitazione() {
		return dataFineAbilitazione;
	}

	public void setDataFineAbilitazione(Date dataFineAbilitazione) {
		this.dataFineAbilitazione = dataFineAbilitazione;
	}

	public boolean isFlagMonitoraggio() {
		return flagMonitoraggio;
	}

	public void setFlagMonitoraggio(boolean flagMonitoraggio) {
		this.flagMonitoraggio = flagMonitoraggio;
	}

}