package com.nttdata.tim.now.data.bean.idsluco;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class IdslucoOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -8671188689619201278L;

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

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineValidita")
	private Date dataFineValidita;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioValidita")
	private Date dataInizioValidita;

	@JsonProperty("dataInvioRichiesta")
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceClliCentrale == null) ? 0 : codiceClliCentrale.hashCode());
		result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
		result = prime * result + ((coppiA == null) ? 0 : coppiA.hashCode());
		result = prime * result + ((coppiaDa == null) ? 0 : coppiaDa.hashCode());
		result = prime * result + ((dataFineValidita == null) ? 0 : dataFineValidita.hashCode());
		result = prime * result + ((dataInizioValidita == null) ? 0 : dataInizioValidita.hashCode());
		result = prime * result + ((dataInvioRichiesta == null) ? 0 : dataInvioRichiesta.hashCode());
		result = prime * result + identificativoRichiestaFattibilita;
		result = prime * result + ((idsluco == null) ? 0 : idsluco.hashCode());
		result = prime * result + progressivo;
		result = prime * result + ((testarmadio == null) ? 0 : testarmadio.hashCode());
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
		IdslucoOutputBean other = (IdslucoOutputBean) obj;
		if (codiceClliCentrale == null) {
			if (other.codiceClliCentrale != null)
				return false;
		} else if (!codiceClliCentrale.equals(other.codiceClliCentrale))
			return false;
		if (codificaOloAgcom == null) {
			if (other.codificaOloAgcom != null)
				return false;
		} else if (!codificaOloAgcom.equals(other.codificaOloAgcom))
			return false;
		if (coppiA == null) {
			if (other.coppiA != null)
				return false;
		} else if (!coppiA.equals(other.coppiA))
			return false;
		if (coppiaDa == null) {
			if (other.coppiaDa != null)
				return false;
		} else if (!coppiaDa.equals(other.coppiaDa))
			return false;
		if (dataFineValidita == null) {
			if (other.dataFineValidita != null)
				return false;
		} else if (!dataFineValidita.equals(other.dataFineValidita))
			return false;
		if (dataInizioValidita == null) {
			if (other.dataInizioValidita != null)
				return false;
		} else if (!dataInizioValidita.equals(other.dataInizioValidita))
			return false;
		if (dataInvioRichiesta == null) {
			if (other.dataInvioRichiesta != null)
				return false;
		} else if (!dataInvioRichiesta.equals(other.dataInvioRichiesta))
			return false;
		if (identificativoRichiestaFattibilita != other.identificativoRichiestaFattibilita)
			return false;
		if (idsluco == null) {
			if (other.idsluco != null)
				return false;
		} else if (!idsluco.equals(other.idsluco))
			return false;
		if (progressivo != other.progressivo)
			return false;
		if (testarmadio == null) {
			if (other.testarmadio != null)
				return false;
		} else if (!testarmadio.equals(other.testarmadio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IdslucoOutputBean [codiceClliCentrale=" + codiceClliCentrale + ", codificaOloAgcom=" + codificaOloAgcom
				+ ", coppiA=" + coppiA + ", coppiaDa=" + coppiaDa + ", idsluco=" + idsluco + ", testarmadio="
				+ testarmadio + ", progressivo=" + progressivo + ", identificativoRichiestaFattibilita="
				+ identificativoRichiestaFattibilita + ", dataFineValidita=" + dataFineValidita
				+ ", dataInizioValidita=" + dataInizioValidita + ", dataInvioRichiesta=" + dataInvioRichiesta + "]";
	}

}