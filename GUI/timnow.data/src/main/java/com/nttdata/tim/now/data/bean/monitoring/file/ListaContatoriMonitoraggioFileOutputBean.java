package com.nttdata.tim.now.data.bean.monitoring.file;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListaContatoriMonitoraggioFileOutputBean extends AbstractOutputBean {
	
	private static final long serialVersionUID = 8245773511536285020L;

	@JsonProperty("data")
	private List<ContatoreMonitoraggioFileOutputBean> monitorings;
    
    @JsonProperty("idExportFile")
    private String idFile;

    public List<ContatoreMonitoraggioFileOutputBean> getMonitorings() {
        return monitorings;
    }

    public void setMonitorings(List<ContatoreMonitoraggioFileOutputBean> monitorings) {
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
        ListaContatoriMonitoraggioFileOutputBean other = (ListaContatoriMonitoraggioFileOutputBean) obj;
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
        return "ListaContatoriMonitoraggioFileOutputBean [monitorings=" + monitorings + ", idFile=" + idFile + "]";
    }
    
    

}
