package com.nttdata.tim.now.data.dto.vc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class VcProfileOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = -822499204136092223L;
	
	@JsonProperty("outputVisualizzaProfiloVC")
	private List<ProfiloVcOutputDTO> profileVC;
		
	public List<ProfiloVcOutputDTO> getProfiliVC() {
		return profileVC;
	}
	
	public void setProfiliVC(List<ProfiloVcOutputDTO> profiliVC) {
		this.profileVC = profiliVC;
	}

}
