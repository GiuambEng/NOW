package com.nttdata.tim.now.data.dto.semaforo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaSemaforiOutputDTO extends ExportableDataOutputDTO {
	
	private static final long serialVersionUID = -8241408915704200537L;
	
	@JsonProperty("lista")
	private List<SemaforoOutputDTO> lista;
	
    public List<SemaforoOutputDTO> getLista() {
        return lista;
    }

    public void setLista(List<SemaforoOutputDTO> lista) {
        this.lista = lista;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lista == null) ? 0 : lista.hashCode());
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
        ListaSemaforiOutputDTO other = (ListaSemaforiOutputDTO) obj;
        if (lista == null) {
            if (other.lista != null)
                return false;
        } else if (!lista.equals(other.lista))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ListaSemaforiOutputDTO [lista=" + lista + "]";
    }

	
    
}
