package com.nttdata.tim.now.data.dto.ordine.tracking;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class OrderTrackingListOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 8377420063633351723L;
	
	@JsonProperty("OutTracciamentoObj")
	private List<OrderTrackingOutputDTO> dataRecoveries;

	public List<OrderTrackingOutputDTO> getDataRecoveries() {
		return dataRecoveries;
	}

	public void setDataRecoveries(List<OrderTrackingOutputDTO> dataRecoveries) {
		this.dataRecoveries = dataRecoveries;
	}

}
