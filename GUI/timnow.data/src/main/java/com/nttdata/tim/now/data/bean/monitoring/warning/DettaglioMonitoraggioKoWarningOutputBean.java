package com.nttdata.tim.now.data.bean.monitoring.warning;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DettaglioMonitoraggioKoWarningOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 7072139455475178797L;

    @JsonProperty("lavorazione")
	private String lavorazione;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataEstrazione")
	private Date dataEstrazione;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("descrizioneCausaleOrdineOlo")
	private String descrizioneCausaleOrdineOlo;

	@JsonProperty("causaleOrdineOlo")
	private String causaleOrdineOlo;

	@JsonProperty("totale")
	private String totale;

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public Date getDataEstrazione() {
		return dataEstrazione;
	}

	public void setDataEstrazione(Date dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getDescrizioneCausaleOrdineOlo() {
		return descrizioneCausaleOrdineOlo;
	}

	public void setDescrizioneCausaleOrdineOlo(String descrizioneCausaleOrdineOlo) {
		this.descrizioneCausaleOrdineOlo = descrizioneCausaleOrdineOlo;
	}

	public String getCausaleOrdineOlo() {
		return causaleOrdineOlo;
	}

	public void setCausaleOrdineOlo(String causaleOrdineOlo) {
		this.causaleOrdineOlo = causaleOrdineOlo;
	}

	public String getTotale() {
		return totale;
	}

	public void setTotale(String totale) {
		this.totale = totale;
	}

}