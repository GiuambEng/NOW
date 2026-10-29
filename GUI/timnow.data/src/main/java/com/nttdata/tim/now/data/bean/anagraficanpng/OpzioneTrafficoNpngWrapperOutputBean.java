package com.nttdata.tim.now.data.bean.anagraficanpng;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1203
public class OpzioneTrafficoNpngWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -8687796261572913106L;
	
    @JsonProperty("listaOpzTrafficoNPNG")
	private List<OpzioneTrafficoNpngOutputBean> listaOpzTrafficoNPNG;

	public List<OpzioneTrafficoNpngOutputBean> getListaOpzTrafficoNPNG() {
		return listaOpzTrafficoNPNG;
	}

	public void setListaOpzTrafficoNPNG(List<OpzioneTrafficoNpngOutputBean> listaOpzTrafficoNPNG) {
		this.listaOpzTrafficoNPNG = listaOpzTrafficoNPNG;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaOpzTrafficoNPNG == null) ? 0 : listaOpzTrafficoNPNG.hashCode());
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
		OpzioneTrafficoNpngWrapperOutputBean other = (OpzioneTrafficoNpngWrapperOutputBean) obj;
		if (listaOpzTrafficoNPNG == null) {
			if (other.listaOpzTrafficoNPNG != null)
				return false;
		} else if (!listaOpzTrafficoNPNG.equals(other.listaOpzTrafficoNPNG))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OpzioneTrafficoNpngWrapperOutputBean [listaOpzTrafficoNPNG=" + listaOpzTrafficoNPNG + "]";
	}

}
