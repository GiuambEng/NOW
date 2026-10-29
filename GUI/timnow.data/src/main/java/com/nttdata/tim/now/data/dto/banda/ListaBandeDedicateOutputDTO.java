package com.nttdata.tim.now.data.dto.banda;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaBandeDedicateOutputDTO extends ESBResultDTO {
 
	private static final long serialVersionUID = -2513589203313608250L;

	@JsonProperty("OutputVisualizzazioneBandaDedicata")
	private List<BandaDedicataOutputDTO> bandaDedicataList;

	public List<BandaDedicataOutputDTO> getBandaDedicataList() {
		return bandaDedicataList;
	}

	public void setBandaDedicataList(List<BandaDedicataOutputDTO> bandeDedicataList) {
		this.bandaDedicataList = bandeDedicataList;
	}

}
