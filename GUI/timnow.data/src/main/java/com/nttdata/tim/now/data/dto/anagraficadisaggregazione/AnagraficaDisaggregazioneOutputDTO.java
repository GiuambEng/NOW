package com.nttdata.tim.now.data.dto.anagraficadisaggregazione;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class AnagraficaDisaggregazioneOutputDTO implements Serializable {

	private static final long serialVersionUID = 5036469376609150787L;

	@JsonProperty("olo")
	private String olo;

	@JsonProperty("codiceImpresa")
	private String codiceImpresa;

	@JsonProperty("areaDiCantiere")
	private String areaDiCantiere;

	@JsonProperty("ragioneSociale")
	private String ragioneSociale;
	
	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioValiditaProvisioning")
	private Date dataInizioValiditaProvisioning;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineValiditaProvisioning")
	private Date dataFineValiditaProvisioning;
	
	//R1I_20_0131
	@JsonProperty("disaggregazioneAppuntamento")
	private String disaggregazioneAppuntamento;

	public String getOlo() {
		return olo;
	}

	public void setOlo(String olo) {
		this.olo = olo;
	}

	public String getCodiceImpresa() {
		return codiceImpresa;
	}

	public void setCodiceImpresa(String codiceImpresa) {
		this.codiceImpresa = codiceImpresa;
	}

	public String getAreaDiCantiere() {
		return areaDiCantiere;
	}

	public void setAreaDiCantiere(String areaDiCantiere) {
		this.areaDiCantiere = areaDiCantiere;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public Date getDataInizioValiditaProvisioning() {
		return dataInizioValiditaProvisioning;
	}

	public void setDataInizioValiditaProvisioning(Date dataInizioValiditaProvisioning) {
		this.dataInizioValiditaProvisioning = dataInizioValiditaProvisioning;
	}

	public Date getDataFineValiditaProvisioning() {
		return dataFineValiditaProvisioning;
	}

	public void setDataFineValiditaProvisioning(Date dataFineValiditaProvisioning) {
		this.dataFineValiditaProvisioning = dataFineValiditaProvisioning;
	}

	public String getDisaggregazioneAppuntamento() {
		return disaggregazioneAppuntamento;
	}

	public void setDisaggregazioneAppuntamento(String disaggregazioneAppuntamento) {
		this.disaggregazioneAppuntamento = disaggregazioneAppuntamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaDiCantiere == null) ? 0 : areaDiCantiere.hashCode());
		result = prime * result + ((codiceImpresa == null) ? 0 : codiceImpresa.hashCode());
		result = prime * result
				+ ((dataFineValiditaProvisioning == null) ? 0 : dataFineValiditaProvisioning.hashCode());
		result = prime * result
				+ ((dataInizioValiditaProvisioning == null) ? 0 : dataInizioValiditaProvisioning.hashCode());
		result = prime * result + ((disaggregazioneAppuntamento == null) ? 0 : disaggregazioneAppuntamento.hashCode());
		result = prime * result + ((olo == null) ? 0 : olo.hashCode());
		result = prime * result + ((ragioneSociale == null) ? 0 : ragioneSociale.hashCode());
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
		AnagraficaDisaggregazioneOutputDTO other = (AnagraficaDisaggregazioneOutputDTO) obj;
		if (areaDiCantiere == null) {
			if (other.areaDiCantiere != null)
				return false;
		} else if (!areaDiCantiere.equals(other.areaDiCantiere))
			return false;
		if (codiceImpresa == null) {
			if (other.codiceImpresa != null)
				return false;
		} else if (!codiceImpresa.equals(other.codiceImpresa))
			return false;
		if (dataFineValiditaProvisioning == null) {
			if (other.dataFineValiditaProvisioning != null)
				return false;
		} else if (!dataFineValiditaProvisioning.equals(other.dataFineValiditaProvisioning))
			return false;
		if (dataInizioValiditaProvisioning == null) {
			if (other.dataInizioValiditaProvisioning != null)
				return false;
		} else if (!dataInizioValiditaProvisioning.equals(other.dataInizioValiditaProvisioning))
			return false;
		if (disaggregazioneAppuntamento == null) {
			if (other.disaggregazioneAppuntamento != null)
				return false;
		} else if (!disaggregazioneAppuntamento.equals(other.disaggregazioneAppuntamento))
			return false;
		if (olo == null) {
			if (other.olo != null)
				return false;
		} else if (!olo.equals(other.olo))
			return false;
		if (ragioneSociale == null) {
			if (other.ragioneSociale != null)
				return false;
		} else if (!ragioneSociale.equals(other.ragioneSociale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnagraficaDisaggregazioneOutputDTO [olo=" + olo + ", codiceImpresa=" + codiceImpresa
				+ ", areaDiCantiere=" + areaDiCantiere + ", ragioneSociale=" + ragioneSociale
				+ ", dataInizioValiditaProvisioning=" + dataInizioValiditaProvisioning
				+ ", dataFineValiditaProvisioning=" + dataFineValiditaProvisioning + ", disaggregazioneAppuntamento="
				+ disaggregazioneAppuntamento + "]";
	}


	
}