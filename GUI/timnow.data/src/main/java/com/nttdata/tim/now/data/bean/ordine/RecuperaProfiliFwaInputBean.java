package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1129
@JsonInclude(Include.NON_NULL)
public class RecuperaProfiliFwaInputBean implements Serializable{

	private static final long serialVersionUID = 1745989389038896324L;

	@JsonProperty("profili")
	private List<String> profili;

	public List<String> getProfili() {
		return profili;
	}

	public void setProfili(List<String> profili) {
		this.profili = profili;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profili == null) ? 0 : profili.hashCode());
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
		RecuperaProfiliFwaInputBean other = (RecuperaProfiliFwaInputBean) obj;
		if (profili == null) {
			if (other.profili != null)
				return false;
		} else if (!profili.equals(other.profili))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaProfiliFwaInputBean [profili=" + profili + "]";
	}
	
}
