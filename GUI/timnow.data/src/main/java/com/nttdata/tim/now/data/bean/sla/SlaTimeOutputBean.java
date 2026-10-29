package com.nttdata.tim.now.data.bean.sla;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class SlaTimeOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 6637074129776178660L;

    @JsonProperty("giorniSla")
	private String giorniSla;

	@JsonProperty("tipoLinea")
	private String tipoLinea;

	@JsonProperty("causaleOrdine")
	private String causaleOrdine;

	@JsonProperty("prodotto")
	private String prodotto;

	@JsonProperty("tipoLavorazione")
	private String tipoLavorazione;

	@JsonProperty("flagMonitoraggio")
	private boolean flagMonitoraggio;

	@JsonProperty("flagReclamo")
	private boolean flagReclamo;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizio")
	private Date dataInizio;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFine")
	private Date dataFine;

	public String getGiorniSla() {
		return giorniSla;
	}

	public void setGiorniSla(String giorniSla) {
		this.giorniSla = giorniSla;
	}

	public String getTipoLinea() {
		return tipoLinea;
	}

	public void setTipoLinea(String tipoLinea) {
		this.tipoLinea = tipoLinea;
	}

	public String getCausaleOrdine() {
		return causaleOrdine;
	}

	public void setCausaleOrdine(String causaleOrdine) {
		this.causaleOrdine = causaleOrdine;
	}

	public String getProdotto() {
		return prodotto;
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public String getTipoLavorazione() {
		return tipoLavorazione;
	}

	public void setTipoLavorazione(String tipoLavorazione) {
		this.tipoLavorazione = tipoLavorazione;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public boolean isFlagMonitoraggio() {
		return flagMonitoraggio;
	}

	public void setFlagMonitoraggio(boolean flagMonitoraggio) {
		this.flagMonitoraggio = flagMonitoraggio;
	}

	public boolean isFlagReclamo() {
		return flagReclamo;
	}

	public void setFlagReclamo(boolean flagReclamo) {
		this.flagReclamo = flagReclamo;
	}

}