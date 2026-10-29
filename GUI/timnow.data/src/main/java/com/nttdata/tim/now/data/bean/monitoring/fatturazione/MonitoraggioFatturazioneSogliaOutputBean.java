package com.nttdata.tim.now.data.bean.monitoring.fatturazione;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFatturazioneSogliaOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 6517066250814524523L;
	
	@JsonProperty("valoreSoglia")
	private String valoreSoglia;
	

	public String getValoreSoglia() {
		return valoreSoglia;
	}

	public void setValoreSoglia(String valoreSoglia) {
		this.valoreSoglia = valoreSoglia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valoreSoglia == null) ? 0 : valoreSoglia.hashCode());
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
		MonitoraggioFatturazioneSogliaOutputBean other = (MonitoraggioFatturazioneSogliaOutputBean) obj;
		if (valoreSoglia == null) {
			if (other.valoreSoglia != null)
				return false;
		} else if (!valoreSoglia.equals(other.valoreSoglia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MonitoraggioFatturazioneSogliaOutputBean [valoreSoglia=" + valoreSoglia + "]";
	}
	
}
