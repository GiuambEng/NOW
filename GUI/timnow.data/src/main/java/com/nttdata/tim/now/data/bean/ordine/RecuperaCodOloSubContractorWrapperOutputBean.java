package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1058
public class RecuperaCodOloSubContractorWrapperOutputBean extends AbstractOutputBean implements Serializable{

	private static final long serialVersionUID = -5901038207234078068L;
	
	@JsonProperty("listaCodOloSubcontractor")
    private List<RecuperaCodOloSubContractorOutputBean> listaCodOloSubcontractor;

	public List<RecuperaCodOloSubContractorOutputBean> getListaCodOloSubcontractor() {
		return listaCodOloSubcontractor;
	}

	public void setListaCodOloSubcontractor(List<RecuperaCodOloSubContractorOutputBean> listaCodOloSubcontractor) {
		this.listaCodOloSubcontractor = listaCodOloSubcontractor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaCodOloSubcontractor == null) ? 0 : listaCodOloSubcontractor.hashCode());
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
		RecuperaCodOloSubContractorWrapperOutputBean other = (RecuperaCodOloSubContractorWrapperOutputBean) obj;
		if (listaCodOloSubcontractor == null) {
			if (other.listaCodOloSubcontractor != null)
				return false;
		} else if (!listaCodOloSubcontractor.equals(other.listaCodOloSubcontractor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaCodOloSubContractorWrapperOutputBean [listaCodOloSubcontractor=" + listaCodOloSubcontractor
				+ "]";
	}

	
	
}
