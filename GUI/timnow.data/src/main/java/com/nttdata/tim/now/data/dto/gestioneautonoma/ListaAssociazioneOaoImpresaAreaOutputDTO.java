package com.nttdata.tim.now.data.dto.gestioneautonoma;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1393
@JsonInclude(Include.NON_NULL)
public class ListaAssociazioneOaoImpresaAreaOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -4776530527942087160L;
	
	@JsonProperty("listaAnagraficaFCSemiGpon")
	private List<AssociazioneOaoImpresaAreaOutputDTO> listaAnagraficaFcSemiGpon;

	public List<AssociazioneOaoImpresaAreaOutputDTO> getListaAnagraficaFcSemiGpon() {
		return listaAnagraficaFcSemiGpon;
	}

	public void setListaAnagraficaFcSemiGpon(List<AssociazioneOaoImpresaAreaOutputDTO> listaAnagraficaFcSemiGpon) {
		this.listaAnagraficaFcSemiGpon = listaAnagraficaFcSemiGpon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listaAnagraficaFcSemiGpon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaAssociazioneOaoImpresaAreaOutputDTO other = (ListaAssociazioneOaoImpresaAreaOutputDTO) obj;
		return Objects.equals(listaAnagraficaFcSemiGpon, other.listaAnagraficaFcSemiGpon);
	}
	
}