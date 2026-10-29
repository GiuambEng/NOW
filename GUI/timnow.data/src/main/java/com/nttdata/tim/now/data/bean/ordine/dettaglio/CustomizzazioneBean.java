package com.nttdata.tim.now.data.bean.ordine.dettaglio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class CustomizzazioneBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -6344150796830864794L;

    @JsonProperty("attribute")
	private String attribute;

	@JsonProperty("value")
	private String value;

	@JsonProperty("valueOld")
	private String valueOld;

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValueOld() {
		return valueOld;
	}

	public void setValueOld(String valueOld) {
		this.valueOld = valueOld;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((valueOld == null) ? 0 : valueOld.hashCode());
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
		CustomizzazioneBean other = (CustomizzazioneBean) obj;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (valueOld == null) {
			if (other.valueOld != null)
				return false;
		} else if (!valueOld.equals(other.valueOld))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomizzazioneBean [attribute=" + attribute + ", value=" + value + ", valueOld=" + valueOld + "]";
	}


}