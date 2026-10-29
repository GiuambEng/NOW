package com.nttdata.tim.now.data.dto.vc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaProfiliVcOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = 3960961596776331351L;
	
	@JsonProperty("ProfiliVcOutput")
	private List<ProfiloVcOutputDTO> profilesVc;

	public List<ProfiloVcOutputDTO> getProfilesVc() {
		return profilesVc;
	}

	public void setProfilesVc(List<ProfiloVcOutputDTO> profilesVc) {
		this.profilesVc = profilesVc;
	}

}
