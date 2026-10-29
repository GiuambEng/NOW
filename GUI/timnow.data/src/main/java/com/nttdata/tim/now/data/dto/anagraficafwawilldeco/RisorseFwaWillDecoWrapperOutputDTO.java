package com.nttdata.tim.now.data.dto.anagraficafwawilldeco;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class RisorseFwaWillDecoWrapperOutputDTO extends ESBResultDTO implements Serializable{

	private static final long serialVersionUID = 8552321557487841134L;
	
	@JsonProperty("listaRisorseFwa")
    private List<RisorseFwaWillDecoListItemOutputDTO> listaRisorseFwa;

	public List<RisorseFwaWillDecoListItemOutputDTO> getListaRisorseFwa() {
		return listaRisorseFwa;
	}

	public void setListaRisorseFwa(List<RisorseFwaWillDecoListItemOutputDTO> listaRisorseFwa) {
		this.listaRisorseFwa = listaRisorseFwa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listaRisorseFwa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RisorseFwaWillDecoWrapperOutputDTO other = (RisorseFwaWillDecoWrapperOutputDTO) obj;
		return Objects.equals(listaRisorseFwa, other.listaRisorseFwa);
	}

	@Override
	public String toString() {
		return "RisorseFwaWillDecoWrapperOutputDTO [listaRisorseFwa=" + listaRisorseFwa + "]";
	}
	
}
