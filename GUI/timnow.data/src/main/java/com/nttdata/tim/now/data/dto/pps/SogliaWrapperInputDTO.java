package com.nttdata.tim.now.data.dto.pps;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class SogliaWrapperInputDTO implements Serializable {

    private static final long serialVersionUID = -8343220370038635552L;

    @JsonProperty("Input_EditingLista")
	private SogliaInputDTO threshold;

	public SogliaInputDTO getThreshold() {
		return threshold;
	}

	public void setThreshold(SogliaInputDTO threshold) {
		this.threshold = threshold;
	}

}
