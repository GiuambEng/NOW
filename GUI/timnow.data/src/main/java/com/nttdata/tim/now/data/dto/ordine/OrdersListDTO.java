package com.nttdata.tim.now.data.dto.ordine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class OrdersListDTO extends ESBResultDTO {

	private static final long serialVersionUID = -6778460242705763675L;
	
	@JsonProperty("OutputListaOrdiniNoOLO")
	private List<OrderDTO> orders;

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}
	
}
