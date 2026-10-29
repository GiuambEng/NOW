package com.nttdata.tim.now.data.bean.monitoring.tempiattraversamento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class ListaSoglieBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -3882465231464934425L;

    @JsonProperty("items")
	private List<SogliaBean> items;

	public List<SogliaBean> getItems() {
		return items;
	}

	public void setItems(List<SogliaBean> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ListaSoglieBean [items=" + items + "]";
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
		ListaSoglieBean other = (ListaSoglieBean) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

}