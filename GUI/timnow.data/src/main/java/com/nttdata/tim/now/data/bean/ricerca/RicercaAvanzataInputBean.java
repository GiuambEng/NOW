package com.nttdata.tim.now.data.bean.ricerca;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class RicercaAvanzataInputBean implements Serializable {

    private static final long serialVersionUID = 6268930440017648972L;

    @JsonProperty("indiceriga")
	private String indiceriga;

	@JsonProperty("numerorighe")
	private String numerorighe;

	@JsonProperty("tipoprofilo")
	private String tipoprofilo;

	@JsonProperty("cod_olo")
	private String codOlo;

	@JsonProperty("exportRequest")
	private boolean exportRequest;

	@JsonProperty("conditions")
	private List<ConditionBean> conditions;
	
	//RU_963
	@JsonProperty("fileType")
	private String fileType;
	
	//R1F-21-0411
	@JsonProperty("idReport")
	private String idReport;

	public String getIndiceriga() {
		return indiceriga;
	}

	public void setIndiceriga(String indiceriga) {
		this.indiceriga = indiceriga;
	}

	public String getNumerorighe() {
		return numerorighe;
	}

	public void setNumerorighe(String numerorighe) {
		this.numerorighe = numerorighe;
	}

	public String getTipoprofilo() {
		return tipoprofilo;
	}

	public void setTipoprofilo(String tipoprofilo) {
		this.tipoprofilo = tipoprofilo;
	}

	public String getCodOlo() {
		return codOlo;
	}

	public void setCodOlo(String codOlo) {
		this.codOlo = codOlo;
	}

	public boolean isExportRequest() {
		return exportRequest;
	}

	public void setExportRequest(boolean exportRequest) {
		this.exportRequest = exportRequest;
	}

	public List<ConditionBean> getConditions() {
		return conditions;
	}

	public void setConditions(List<ConditionBean> conditions) {
		this.conditions = conditions;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getIdReport() {
		return idReport;
	}

	public void setIdReport(String idReport) {
		this.idReport = idReport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOlo == null) ? 0 : codOlo.hashCode());
		result = prime * result + ((conditions == null) ? 0 : conditions.hashCode());
		result = prime * result + (exportRequest ? 1231 : 1237);
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((idReport == null) ? 0 : idReport.hashCode());
		result = prime * result + ((indiceriga == null) ? 0 : indiceriga.hashCode());
		result = prime * result + ((numerorighe == null) ? 0 : numerorighe.hashCode());
		result = prime * result + ((tipoprofilo == null) ? 0 : tipoprofilo.hashCode());
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
		RicercaAvanzataInputBean other = (RicercaAvanzataInputBean) obj;
		if (codOlo == null) {
			if (other.codOlo != null)
				return false;
		} else if (!codOlo.equals(other.codOlo))
			return false;
		if (conditions == null) {
			if (other.conditions != null)
				return false;
		} else if (!conditions.equals(other.conditions))
			return false;
		if (exportRequest != other.exportRequest)
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (idReport == null) {
			if (other.idReport != null)
				return false;
		} else if (!idReport.equals(other.idReport))
			return false;
		if (indiceriga == null) {
			if (other.indiceriga != null)
				return false;
		} else if (!indiceriga.equals(other.indiceriga))
			return false;
		if (numerorighe == null) {
			if (other.numerorighe != null)
				return false;
		} else if (!numerorighe.equals(other.numerorighe))
			return false;
		if (tipoprofilo == null) {
			if (other.tipoprofilo != null)
				return false;
		} else if (!tipoprofilo.equals(other.tipoprofilo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RicercaAvanzataInputBean [indiceriga=" + indiceriga + ", numerorighe=" + numerorighe + ", tipoprofilo="
				+ tipoprofilo + ", codOlo=" + codOlo + ", exportRequest=" + exportRequest + ", conditions=" + conditions
				+ ", fileType=" + fileType + ", idReport=" + idReport + "]";
	}

}