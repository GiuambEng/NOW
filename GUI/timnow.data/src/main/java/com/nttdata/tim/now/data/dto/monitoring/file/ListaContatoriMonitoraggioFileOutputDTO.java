package com.nttdata.tim.now.data.dto.monitoring.file;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultExportDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListaContatoriMonitoraggioFileOutputDTO extends ESBResultExportDTO {
	
	private static final long serialVersionUID = -454656968450962690L;
 
	@JsonProperty("MonitoraggioFiledd1")
	private List<ContatoreMonitoraggioFileOutputDTO> monitorings;

    @JsonProperty("idFile")
    private String idFile;

	public List<ContatoreMonitoraggioFileOutputDTO> getMonitorings() {
		return monitorings;
	}

	public void setMonitorings(List<ContatoreMonitoraggioFileOutputDTO> monitorings) {
		this.monitorings = monitorings;
	}

    public String getIdFile() {
        return idFile;
    }

    public void setIdFile(String idFile) {
        this.idFile = idFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
        result = prime * result + ((idFile == null) ? 0 : idFile.hashCode());
		result = prime * result + ((monitorings == null) ? 0 : monitorings.hashCode());
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
		ListaContatoriMonitoraggioFileOutputDTO other = (ListaContatoriMonitoraggioFileOutputDTO) obj;
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
		return true;
	}

    @Override
    public String toString() {
        return "ListaContatoriMonitoraggioFileOutputDTO [monitorings=" + monitorings + ", idFile=" + idFile + "]";
    }
    
    
    
    

}
