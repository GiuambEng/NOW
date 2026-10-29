package com.nttdata.tim.now.data.dto.anagraficagpon;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_13389
@JsonInclude(Include.NON_NULL)
public class ListaStoricoSplittingGponOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -7775661331422945010L;
	
	@JsonProperty("listaStoricoGpon")
	private List<StoricoSplittingGponOutputDTO> listaStoricoGpon;

	public List<StoricoSplittingGponOutputDTO> getListaStoricoGpon() {
		return listaStoricoGpon;
	}

	public void setListaStoricoGpon(List<StoricoSplittingGponOutputDTO> listaStoricoGpon) {
		this.listaStoricoGpon = listaStoricoGpon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listaStoricoGpon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaStoricoSplittingGponOutputDTO other = (ListaStoricoSplittingGponOutputDTO) obj;
		return Objects.equals(listaStoricoGpon, other.listaStoricoGpon);
	}

	@Override
	public String toString() {
		return "ListaStoricoSplittingGponOutputDTO [listaStoricoGpon=" + listaStoricoGpon + "]";
	}
	
}