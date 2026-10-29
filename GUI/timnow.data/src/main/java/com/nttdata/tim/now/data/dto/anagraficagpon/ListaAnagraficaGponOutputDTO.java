package com.nttdata.tim.now.data.dto.anagraficagpon;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1308
@JsonInclude(Include.NON_NULL)
public class ListaAnagraficaGponOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 8817751651418382349L;

	@JsonProperty("listaAnagraficaGpon")
	private List<AnagraficaGponOutputDTO> listaAnagraficaGpon;

	public List<AnagraficaGponOutputDTO> getListaAnagraficaGpon() {
		return listaAnagraficaGpon;
	}

	public void setListaAnagraficaGpon(List<AnagraficaGponOutputDTO> listaAnagraficaGpon) {
		this.listaAnagraficaGpon = listaAnagraficaGpon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listaAnagraficaGpon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaAnagraficaGponOutputDTO other = (ListaAnagraficaGponOutputDTO) obj;
		return Objects.equals(listaAnagraficaGpon, other.listaAnagraficaGpon);
	}

	@Override
	public String toString() {
		return "ListaAnagraficaGponOutputDTO [listaAnagraficaGpon=" + listaAnagraficaGpon + "]";
	}
	
}