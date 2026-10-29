package com.nttdata.tim.now.data.bean.vlan;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1058
public class VlanOutputBean implements Serializable {

	private static final long serialVersionUID = 6124009543020243612L;

	@JsonProperty("marcaggioVLAN")
    private String marcaggioVlan;
	
	@JsonProperty("ftthOnly")
    private String ftthOnly;

	public String getMarcaggioVlan() {
		return marcaggioVlan;
	}

	public void setMarcaggioVlan(String marcaggioVlan) {
		this.marcaggioVlan = marcaggioVlan;
	}

	public String getFtthOnly() {
		return ftthOnly;
	}

	public void setFtthOnly(String ftthOnly) {
		this.ftthOnly = ftthOnly;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ftthOnly == null) ? 0 : ftthOnly.hashCode());
		result = prime * result + ((marcaggioVlan == null) ? 0 : marcaggioVlan.hashCode());
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
		VlanOutputBean other = (VlanOutputBean) obj;
		if (ftthOnly == null) {
			if (other.ftthOnly != null)
				return false;
		} else if (!ftthOnly.equals(other.ftthOnly))
			return false;
		if (marcaggioVlan == null) {
			if (other.marcaggioVlan != null)
				return false;
		} else if (!marcaggioVlan.equals(other.marcaggioVlan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VlanOutputBean [marcaggioVlan=" + marcaggioVlan + ", ftthOnly=" + ftthOnly + "]";
	}
    
}
