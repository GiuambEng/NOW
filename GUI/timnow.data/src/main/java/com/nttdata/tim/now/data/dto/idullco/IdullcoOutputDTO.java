package com.nttdata.tim.now.data.dto.idullco;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class IdullcoOutputDTO implements Serializable {
	
	private static final long serialVersionUID = 5498594411802363101L;

	@JsonProperty("idullco")
	private String idullco;

	@JsonProperty("clli")
	private String clli;

	@JsonProperty("drcpCentrale")
	private String drcpCentrale;

	@JsonProperty("codiceGat")
	private String codiceGat;

	@JsonProperty("nomeCentrale")
	private String nomeCentrale;

	@JsonProperty("codificaOloAgicom")
	private String codificaOloAgicom;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataconsegnaolo")
	private Date dataconsegnaolo;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineValidita")
	private Date dataFineValidita;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInvio")
	private Date dataInvio;

	public String getIdullco() {
		return idullco;
	}

	public void setIdullco(String idullco) {
		this.idullco = idullco;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getDrcpCentrale() {
		return drcpCentrale;
	}

	public void setDrcpCentrale(String drcpCentrale) {
		this.drcpCentrale = drcpCentrale;
	}

	public String getCodiceGat() {
		return codiceGat;
	}

	public void setCodiceGat(String codiceGat) {
		this.codiceGat = codiceGat;
	}

	public String getNomeCentrale() {
		return nomeCentrale;
	}

	public void setNomeCentrale(String nomeCentrale) {
		this.nomeCentrale = nomeCentrale;
	}

	public String getCodificaOloAgicom() {
		return codificaOloAgicom;
	}

	public void setCodificaOloAgicom(String codificaOloAgicom) {
		this.codificaOloAgicom = codificaOloAgicom;
	}

	public Date getDataconsegnaolo() {
		return dataconsegnaolo;
	}

	public void setDataconsegnaolo(Date dataconsegnaolo) {
		this.dataconsegnaolo = dataconsegnaolo;
	}

	public Date getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(Date dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}
}
