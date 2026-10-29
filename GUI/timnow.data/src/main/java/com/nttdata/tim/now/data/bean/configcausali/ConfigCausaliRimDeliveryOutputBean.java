package com.nttdata.tim.now.data.bean.configcausali;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ConfigCausaliRimDeliveryOutputBean implements Serializable {

	private static final long serialVersionUID = -8197379482084253920L;

	@JsonProperty("codiceCausale")
	private String codiceCausale;

	@JsonProperty("descrizioneCausale")
	private String descrizioneCausale;

	public String getCodiceCausale() {
		return codiceCausale;
	}

	public void setCodiceCausale(String codiceCausale) {
		this.codiceCausale = codiceCausale;
	}

	public String getDescrizioneCausale() {
		return descrizioneCausale;
	}

	public void setDescrizioneCausale(String descrizioneCausale) {
		this.descrizioneCausale = descrizioneCausale;
	}

	@Override
	public String toString() {
		return "ConfigCausaliRimDeliveryOutputBean [codiceCausale=" + codiceCausale + ", descrizioneCausale="
				+ descrizioneCausale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceCausale == null) ? 0 : codiceCausale.hashCode());
		result = prime * result + ((descrizioneCausale == null) ? 0 : descrizioneCausale.hashCode());
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
		ConfigCausaliRimDeliveryOutputBean other = (ConfigCausaliRimDeliveryOutputBean) obj;
		if (codiceCausale == null) {
			if (other.codiceCausale != null)
				return false;
		} else if (!codiceCausale.equals(other.codiceCausale))
			return false;
		if (descrizioneCausale == null) {
			if (other.descrizioneCausale != null)
				return false;
		} else if (!descrizioneCausale.equals(other.descrizioneCausale))
			return false;
		return true;
	}
	
}
	
	