package com.nttdata.tim.now.data.dto.atm;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaKitAtmOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = -5046894005060120268L;
	
	@JsonProperty("kitATMOutput")
	private List<KitAtmOutputDTO> kitAtms;

	public List<KitAtmOutputDTO> getKitAtms() {
		return kitAtms;
	}

	public void setKitAtms(List<KitAtmOutputDTO> kitAtms) {
		this.kitAtms = kitAtms;
	}

}
