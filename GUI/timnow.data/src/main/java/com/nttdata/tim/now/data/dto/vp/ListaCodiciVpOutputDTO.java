package com.nttdata.tim.now.data.dto.vp;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaCodiciVpOutputDTO  extends ESBResultDTO  {
	
	private static final long serialVersionUID = 1098909725898001665L;
	
	@JsonProperty("outVisualizzaCodVp")
	private List<CodiceVpOutputDTO> vpCodeDTOList;

	
	public List<CodiceVpOutputDTO> getVpCodeDTOList() {
		return vpCodeDTOList;
	}
	public void setVpCodeDTOList(List<CodiceVpOutputDTO> vpCodeDTOList) {
		this.vpCodeDTOList = vpCodeDTOList;
	}
	
	
}
