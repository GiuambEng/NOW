
package com.nttdata.tim.now.data.bean.monitoring.usertask;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModUserTaskCausaliImproprieBean implements Serializable{

    private static final long serialVersionUID = 7352168505285239358L;
    
    @JsonProperty("causale")
    private String causaleModificata;
    
    @JsonProperty("idWorkItem")
    private String idWorkItem;
    
    @JsonProperty("version")
    private String version;
    
    @JsonProperty("azione")
    private String azione;
    
    public String getCausaleModificata() {
        return causaleModificata;
    }
    public void setCausaleModificata(String causaleModificata) {
        this.causaleModificata = causaleModificata;
    }
    public String getIdWorkItem() {
        return idWorkItem;
    }
    public void setIdWorkItem(String idWorkItem) {
        this.idWorkItem = idWorkItem;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getAzione() {
        return azione;
    }
    public void setAzione(String azione) {
        this.azione = azione;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((azione == null) ? 0 : azione.hashCode());
        result = prime * result + ((causaleModificata == null) ? 0 : causaleModificata.hashCode());
        result = prime * result + ((idWorkItem == null) ? 0 : idWorkItem.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
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
        ModUserTaskCausaliImproprieBean other = (ModUserTaskCausaliImproprieBean) obj;
        if (azione == null) {
            if (other.azione != null)
                return false;
        } else if (!azione.equals(other.azione))
            return false;
        if (causaleModificata == null) {
            if (other.causaleModificata != null)
                return false;
        } else if (!causaleModificata.equals(other.causaleModificata))
            return false;
        if (idWorkItem == null) {
            if (other.idWorkItem != null)
                return false;
        } else if (!idWorkItem.equals(other.idWorkItem))
            return false;
        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version.equals(other.version))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "ModUserTaskCausaliImproprieBean [causaleModificata=" + causaleModificata + ", idWorkItem=" + idWorkItem + ", version=" + version + ", azione="
                + azione + "]";
    }
    

}
