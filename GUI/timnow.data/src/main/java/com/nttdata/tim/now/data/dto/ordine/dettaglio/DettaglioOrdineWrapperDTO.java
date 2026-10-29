package com.nttdata.tim.now.data.dto.ordine.dettaglio;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class DettaglioOrdineWrapperDTO extends ESBResultDTO {

	private static final long serialVersionUID = -4042145461038195295L;
	
	@JsonProperty("OutputDatiOrdine")
	private DettaglioOrdineOutputDTO orderDetailDTO;

	public DettaglioOrdineOutputDTO getOrderDetailDTO() {
		return orderDetailDTO;
	}

	public void setOrderDetailDTO(DettaglioOrdineOutputDTO orderDetailDTO) {
		this.orderDetailDTO = orderDetailDTO;
	}

	@Override
	public String toString() {
		return "DettaglioOrdineWrapperDTO [orderDetailDTO=" + orderDetailDTO + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderDetailDTO == null) ? 0 : orderDetailDTO.hashCode());
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
		DettaglioOrdineWrapperDTO other = (DettaglioOrdineWrapperDTO) obj;
		if (orderDetailDTO == null) {
			if (other.orderDetailDTO != null)
				return false;
		} else if (!orderDetailDTO.equals(other.orderDetailDTO))
			return false;
		return true;
	}

}
