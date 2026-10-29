package com.nttdata.tim.now.data.dto.ricerca;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class AdvancedResearchInputDTO implements Serializable {

	private static final long serialVersionUID = 936700783410385626L;

	@JsonProperty("indiceriga")
	private String indiceriga;

	@JsonProperty("numerorighe")
	private String numerorighe;

	@JsonProperty("exportRequest")
	private String exportRequest;

	@JsonProperty("strutturaCondition")
	private List<ConditionDTO> conditions;
	
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

	public List<ConditionDTO> getConditions() {
		return conditions;
	}

	public void setConditions(List<ConditionDTO> conditions) {
		this.conditions = conditions;
	}

	public String getExportRequest() {
		return exportRequest;
	}

	public void setExportRequest(String exportRequest) {
		this.exportRequest = exportRequest;
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
		result = prime * result + ((conditions == null) ? 0 : conditions.hashCode());
		result = prime * result + ((exportRequest == null) ? 0 : exportRequest.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((idReport == null) ? 0 : idReport.hashCode());
		result = prime * result + ((indiceriga == null) ? 0 : indiceriga.hashCode());
		result = prime * result + ((numerorighe == null) ? 0 : numerorighe.hashCode());
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
		AdvancedResearchInputDTO other = (AdvancedResearchInputDTO) obj;
		if (conditions == null) {
			if (other.conditions != null)
				return false;
		} else if (!conditions.equals(other.conditions))
			return false;
		if (exportRequest == null) {
			if (other.exportRequest != null)
				return false;
		} else if (!exportRequest.equals(other.exportRequest))
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
		return true;
	}

    @Override
	public String toString() {
		return "AdvancedResearchInputDTO [indiceriga=" + indiceriga + ", numerorighe=" + numerorighe
				+ ", exportRequest=" + exportRequest + ", conditions=" + conditions + ", fileType=" + fileType
				+ ", idReport=" + idReport + "]";
	}

	
}
