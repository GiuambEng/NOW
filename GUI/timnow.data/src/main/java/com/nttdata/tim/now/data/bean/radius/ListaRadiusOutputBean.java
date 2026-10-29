package com.nttdata.tim.now.data.bean.radius;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.export.ExportableDataOutputBean;
import com.nttdata.tim.now.data.dto.radius.RadiusOutputDTO;

public class ListaRadiusOutputBean extends ExportableDataOutputBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4754424861337743210L;
	
	@JsonProperty("listaAnagraficaRadius")
	private List<RadiusOutputDTO> listaAnagraficaRadius;

	public List<RadiusOutputDTO> getListaAnagraficaRadius() {
		return listaAnagraficaRadius;
	}

	public void setListaAnagraficaRadius(List<RadiusOutputDTO> listaAnagraficaRadius) {
		this.listaAnagraficaRadius = listaAnagraficaRadius;
	}

	
}