package com.nttdata.tim.now.data.dto.profilolinea;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class LineProfileListDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = -7132642457981351325L;
	
	private List<LineProfileDTO> lineProfiles;

	public List<LineProfileDTO> getLineProfiles() {
		return lineProfiles;
	}

	@JsonProperty("profiliLineaOutput")
	public void setLineProfiles(List<LineProfileDTO> lineProfiles) {
		this.lineProfiles = lineProfiles;
	}

	@JsonProperty("visualizzazioneProfiloOutput")
	public void setLineProfilesByOffer(List<LineProfileDTO> lineProfiles) {
		this.lineProfiles = lineProfiles;
	}

}
