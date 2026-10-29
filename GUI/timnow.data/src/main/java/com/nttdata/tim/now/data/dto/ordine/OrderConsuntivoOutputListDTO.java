package com.nttdata.tim.now.data.dto.ordine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class OrderConsuntivoOutputListDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = -922262754214509696L;
	
	@JsonProperty("Lista_Output_consuntivo")
	private List<OrderConsuntivoDTO> orders;

	public List<OrderConsuntivoDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderConsuntivoDTO> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
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
		OrderConsuntivoOutputListDTO other = (OrderConsuntivoOutputListDTO) obj;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderConsuntivoOutputListDTO [orders=" + orders + "]";
	}
	
}
