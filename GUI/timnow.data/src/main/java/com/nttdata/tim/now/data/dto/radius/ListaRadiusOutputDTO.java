package com.nttdata.tim.now.data.dto.radius;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaRadiusOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = 8076414338868287023L;
	
	@JsonProperty("listaAnagraficaRadius")
	private List<RadiusOutputDTO> listaAnagraficaRadius;

	public List<RadiusOutputDTO> getListaAnagraficaRadius() {
		return listaAnagraficaRadius;
	}

	public void setListaAnagraficaRadius(List<RadiusOutputDTO> listaAnagraficaRadius) {
		this.listaAnagraficaRadius = listaAnagraficaRadius;
	}

}
