package com.nttdata.tim.now.data.bean.idullco;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class IdullcoOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 4802686750024597097L;

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

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataconsegnaolo")
	private Date dataconsegnaolo;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineValidita")
	private Date dataFineValidita;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clli == null) ? 0 : clli.hashCode());
		result = prime * result + ((codiceGat == null) ? 0 : codiceGat.hashCode());
		result = prime * result + ((codificaOloAgicom == null) ? 0 : codificaOloAgicom.hashCode());
		result = prime * result + ((dataFineValidita == null) ? 0 : dataFineValidita.hashCode());
		result = prime * result + ((dataInvio == null) ? 0 : dataInvio.hashCode());
		result = prime * result + ((dataconsegnaolo == null) ? 0 : dataconsegnaolo.hashCode());
		result = prime * result + ((drcpCentrale == null) ? 0 : drcpCentrale.hashCode());
		result = prime * result + ((idullco == null) ? 0 : idullco.hashCode());
		result = prime * result + ((nomeCentrale == null) ? 0 : nomeCentrale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdullcoOutputBean other = (IdullcoOutputBean) obj;
		if (clli == null) {
			if (other.clli != null)
				return false;
		} else if (!clli.equals(other.clli))
			return false;
		if (codiceGat == null) {
			if (other.codiceGat != null)
				return false;
		} else if (!codiceGat.equals(other.codiceGat))
			return false;
		if (codificaOloAgicom == null) {
			if (other.codificaOloAgicom != null)
				return false;
		} else if (!codificaOloAgicom.equals(other.codificaOloAgicom))
			return false;
		if (dataFineValidita == null) {
			if (other.dataFineValidita != null)
				return false;
		} else if (!dataFineValidita.equals(other.dataFineValidita))
			return false;
		if (dataInvio == null) {
			if (other.dataInvio != null)
				return false;
		} else if (!dataInvio.equals(other.dataInvio))
			return false;
		if (dataconsegnaolo == null) {
			if (other.dataconsegnaolo != null)
				return false;
		} else if (!dataconsegnaolo.equals(other.dataconsegnaolo))
			return false;
		if (drcpCentrale == null) {
			if (other.drcpCentrale != null)
				return false;
		} else if (!drcpCentrale.equals(other.drcpCentrale))
			return false;
		if (idullco == null) {
			if (other.idullco != null)
				return false;
		} else if (!idullco.equals(other.idullco))
			return false;
		if (nomeCentrale == null) {
			if (other.nomeCentrale != null)
				return false;
		} else if (!nomeCentrale.equals(other.nomeCentrale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IdullcoOutputBean [idullco=" + idullco + ", clli=" + clli + ", drcpCentrale=" + drcpCentrale
				+ ", codiceGat=" + codiceGat + ", nomeCentrale=" + nomeCentrale + ", codificaOloAgicom="
				+ codificaOloAgicom + ", dataconsegnaolo=" + dataconsegnaolo + ", dataFineValidita=" + dataFineValidita
				+ ", dataInvio=" + dataInvio + "]";
	}

}