package com.nttdata.tim.now.data.dto.gui;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class VisualizzazioneGuiOutputDTO implements Serializable {
	
	private static final long serialVersionUID = 2335464815239716686L;

	@JsonProperty("codice_olo_numerico")
	private String codiceOloNumerico;

	@JsonProperty("codifica_olo_agcom")
	private String codificaOloAgcom;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_inizio_abilitazione")
	private Date dataInizioAbilitazione;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_fine_abilitazione")
	private Date dataFineAbilitazione;

	@JsonProperty("flag_monitoraggio")
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
