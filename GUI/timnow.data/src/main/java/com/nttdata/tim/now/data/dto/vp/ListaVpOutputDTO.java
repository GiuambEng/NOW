package com.nttdata.tim.now.data.dto.vp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaVpOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = -6395722070559332061L;
	
	@JsonProperty("VPOutput")
	private List<VpOutputDTO> vps;

	public List<VpOutputDTO> getVps() {
		return vps;
	}

	public void setVps(List<VpOutputDTO> vps) {
		this.vps = vps;
	}

}
