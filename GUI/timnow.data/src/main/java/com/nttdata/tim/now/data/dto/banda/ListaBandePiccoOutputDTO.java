package com.nttdata.tim.now.data.dto.banda;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaBandePiccoOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = -4594047634049884748L;
	
	@JsonProperty("VisualizzazioneListaBandePicco_Output")
	private List<BandaPiccoOutputDTO> peakBands;

	public List<BandaPiccoOutputDTO> getPeakBands() {
		return peakBands;
	}

	public void setPeakBands(List<BandaPiccoOutputDTO> peakBands) {
		this.peakBands = peakBands;
	}

}
