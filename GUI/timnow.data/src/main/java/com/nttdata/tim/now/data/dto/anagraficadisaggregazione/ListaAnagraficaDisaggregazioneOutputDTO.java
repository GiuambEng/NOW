package com.nttdata.tim.now.data.dto.anagraficadisaggregazione;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaAnagraficaDisaggregazioneOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -7539046248838049195L;

	@JsonProperty("listaDisaggregazione")
	private List<AnagraficaDisaggregazioneOutputDTO> listaDisaggregazione;

	public List<AnagraficaDisaggregazioneOutputDTO> getListaDisaggregazione() {
		return listaDisaggregazione;
	}

	public void setListaDisaggregazione(List<AnagraficaDisaggregazioneOutputDTO> listaDisaggregazione) {
		this.listaDisaggregazione = listaDisaggregazione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaDisaggregazione == null) ? 0 : listaDisaggregazione.hashCode());
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
		ListaAnagraficaDisaggregazioneOutputDTO other = (ListaAnagraficaDisaggregazioneOutputDTO) obj;
		if (listaDisaggregazione == null) {
			if (other.listaDisaggregazione != null)
				return false;
		} else if (!listaDisaggregazione.equals(other.listaDisaggregazione))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaAnagraficaDisaggregazioneOutputDTO [listaDisaggregazione=" + listaDisaggregazione + "]";
	}

	
}