package com.nttdata.tim.now.data.dto.monitoring.file;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultExportDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFileOutputDTO extends ESBResultExportDTO {

	private static final long serialVersionUID = 2585843376406390216L;

	@JsonProperty("famigliaOfferta")
	private List<MonitoraggioFileFamigliaOffertaDTO> monitorings;

	@JsonProperty("soglia")
	private SogliaMonitoraggioFileOutputDTO soglia;

	@JsonProperty("idFile")
	private String idFile;

	@JsonProperty("esitoExport")
	private String esitoExport;

	public List<MonitoraggioFileFamigliaOffertaDTO> getMonitorings() {
		return monitorings;
	}

	public void setMonitorings(List<MonitoraggioFileFamigliaOffertaDTO> monitorings) {
		this.monitorings = monitorings;
	}

	public SogliaMonitoraggioFileOutputDTO getSoglia() {
		return soglia;
	}

	public void setSoglia(SogliaMonitoraggioFileOutputDTO soglia) {
		this.soglia = soglia;
	}

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	public String getEsitoExport() {
		return esitoExport;
	}

	public void setEsitoExport(String esitoExport) {
		this.esitoExport = esitoExport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((esitoExport == null) ? 0 : esitoExport.hashCode());
		result = prime * result + ((idFile == null) ? 0 : idFile.hashCode());
		result = prime * result + ((monitorings == null) ? 0 : monitorings.hashCode());
		result = prime * result + ((soglia == null) ? 0 : soglia.hashCode());
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
		MonitoraggioFileOutputDTO other = (MonitoraggioFileOutputDTO) obj;
		if (esitoExport == null) {
			if (other.esitoExport != null)
				return false;
		} else if (!esitoExport.equals(other.esitoExport))
			return false;
		if (idFile == null) {
			if (other.idFile != null)
				return false;
		} else if (!idFile.equals(other.idFile))
			return false;
		if (monitorings == null) {
			if (other.monitorings != null)
				return false;
		} else if (!monitorings.equals(other.monitorings))
			return false;
		if (soglia == null) {
			if (other.soglia != null)
				return false;
		} else if (!soglia.equals(other.soglia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MonitoraggioFileOutputDTO [monitorings=" + monitorings + ", soglia=" + soglia + ", idFile=" + idFile
				+ ", esitoExport=" + esitoExport + "]";
	}

}
