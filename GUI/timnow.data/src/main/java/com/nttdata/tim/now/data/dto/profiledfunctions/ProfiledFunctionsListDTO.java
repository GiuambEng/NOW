package com.nttdata.tim.now.data.dto.profiledfunctions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ProfiledFunctionsListDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = -4410866502289217212L;
	
	@JsonProperty("profilatura")
	private List<ProfiledFunctionsDTO> profiledFunctionsDTOs;

	public List<ProfiledFunctionsDTO> getProfiledFunctionsDTOs() {
		return profiledFunctionsDTOs;
	}

	public void setProfiledFunctionsDTOs(List<ProfiledFunctionsDTO> profiledFunctionsDTOs) {
		this.profiledFunctionsDTOs = profiledFunctionsDTOs;
	}

}
