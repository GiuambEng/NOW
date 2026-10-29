package com.nttdata.tim.now.data.dto.ordine.tracking;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class OrderTrackingListLevel2OutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -3736092271696040560L;

	@JsonProperty("OutTracciamentoObj2")
	private List<OrderTrackingOutputLevel2DTO> outTracciamentoObj2;

	public List<OrderTrackingOutputLevel2DTO> getOutTracciamentoObj2() {
		return outTracciamentoObj2;
	}

	public void setOutTracciamentoObj2(List<OrderTrackingOutputLevel2DTO> outTracciamentoObj2) {
		this.outTracciamentoObj2 = outTracciamentoObj2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outTracciamentoObj2 == null) ? 0 : outTracciamentoObj2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderTrackingListLevel2OutputDTO other = (OrderTrackingListLevel2OutputDTO) obj;
		if (outTracciamentoObj2 == null) {
			if (other.outTracciamentoObj2 != null)
				return false;
		} else if (!outTracciamentoObj2.equals(other.outTracciamentoObj2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderTrackingListLevel2OutputDTO [outTracciamentoObj2=" + outTracciamentoObj2 + "]";
	}

	
}
