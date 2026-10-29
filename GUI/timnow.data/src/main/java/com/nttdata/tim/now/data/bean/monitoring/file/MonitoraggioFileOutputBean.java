
package com.nttdata.tim.now.data.bean.monitoring.file;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFileOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = -6659960303549722412L;

	@JsonProperty("famigliaOfferta")
	private List<FamigliaOffertaOutputBean> monitorings;

	@JsonProperty("soglia")
	private SogliaMonitoraggioFileOutputBean soglia;

	@JsonProperty("idExportFile")
	private String idFile;

	@JsonProperty("esitoExport")
	private String esitoExport;

	public List<FamigliaOffertaOutputBean> getMonitorings() {
		return monitorings;
	}

	public void setMonitorings(List<FamigliaOffertaOutputBean> monitorings) {
		this.monitorings = monitorings;
	}

	public SogliaMonitoraggioFileOutputBean getSoglia() {
		return soglia;
	}

	public void setSoglia(SogliaMonitoraggioFileOutputBean soglia) {
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
		MonitoraggioFileOutputBean other = (MonitoraggioFileOutputBean) obj;
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
		return "MonitoraggioFileOutputBean [monitorings=" + monitorings + ", soglia=" + soglia + ", idFile=" + idFile
				+ ", esitoExport=" + esitoExport + "]";
	}

}
