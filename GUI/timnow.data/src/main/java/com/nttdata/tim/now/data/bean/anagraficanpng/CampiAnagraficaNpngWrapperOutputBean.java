package com.nttdata.tim.now.data.bean.anagraficanpng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1203
public class CampiAnagraficaNpngWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 2186079234300480827L;
	
    @JsonProperty("campiAnagraficaNPNG")
	private CampiAnagraficaNpngOutputBean campiAnagraficaNpng;

	public CampiAnagraficaNpngOutputBean getCampiAnagraficaNpng() {
		return campiAnagraficaNpng;
	}

	public void setCampiAnagraficaNpng(CampiAnagraficaNpngOutputBean campiAnagraficaNpng) {
		this.campiAnagraficaNpng = campiAnagraficaNpng;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campiAnagraficaNpng == null) ? 0 : campiAnagraficaNpng.hashCode());
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
		CampiAnagraficaNpngWrapperOutputBean other = (CampiAnagraficaNpngWrapperOutputBean) obj;
		if (campiAnagraficaNpng == null) {
			if (other.campiAnagraficaNpng != null)
				return false;
		} else if (!campiAnagraficaNpng.equals(other.campiAnagraficaNpng))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CampiAnagraficaNpngWrapperOutputBean [campiAnagraficaNpng=" + campiAnagraficaNpng + "]";
	}
}
