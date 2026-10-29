package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

public class ConfigurazioneListOutputDTO extends ESBResultDTO implements Serializable {

    private static final long serialVersionUID = -6523929069690819533L;
    
    @JsonProperty("outputConfigurazione")
	private List<ConfigurazioneOutputDTO> conflist;

    public List<ConfigurazioneOutputDTO> getConflist() {
        return conflist;
    }

    public void setConflist(List<ConfigurazioneOutputDTO> conflist) {
        this.conflist = conflist;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((conflist == null) ? 0 : conflist.hashCode());
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
        ConfigurazioneListOutputDTO other = (ConfigurazioneListOutputDTO) obj;
        if (conflist == null) {
            if (other.conflist != null)
                return false;
        } else if (!conflist.equals(other.conflist))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ConfigurazioneListOutputDTO [conflist=" + conflist + "]";
    }

	
}
