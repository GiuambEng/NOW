package com.nttdata.tim.now.data.dto.monitoring.tempiattraversamento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ListaSoglieDTO implements Serializable {

	private static final long serialVersionUID = 5420053307286755135L;
	@JsonProperty("items")
	private List<SogliaDTO> items;

	public List<SogliaDTO> getItems() {
		return items;
	}

	public void setItems(List<SogliaDTO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ListaSoglieDTO [items=" + items + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
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
		ListaSoglieDTO other = (ListaSoglieDTO) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

}
