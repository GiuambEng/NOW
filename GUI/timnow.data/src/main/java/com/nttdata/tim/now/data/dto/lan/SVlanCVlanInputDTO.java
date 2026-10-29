package com.nttdata.tim.now.data.dto.lan;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SVlanCVlanInputDTO implements Serializable {

	private static final long serialVersionUID = -6755588367836152116L;

	@JsonProperty("id")
	private String id;	
	
	@JsonProperty("value")
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		SVlanCVlanInputDTO other = (SVlanCVlanInputDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SVlanCVlanInputDTO [id=" + id + ", value=" + value + "]";
	}

}
