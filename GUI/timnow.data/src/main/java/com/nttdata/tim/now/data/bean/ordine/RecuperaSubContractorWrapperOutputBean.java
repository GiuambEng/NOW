package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1058
public class RecuperaSubContractorWrapperOutputBean extends AbstractOutputBean implements Serializable{

	private static final long serialVersionUID = -391953799933512337L;
	
	@JsonProperty("listaSubcontractor")
    private List<RecuperaSubContractorOutputBean> listaSubcontractor;

	public List<RecuperaSubContractorOutputBean> getListaSubcontractor() {
		return listaSubcontractor;
	}

	public void setListaSubcontractor(List<RecuperaSubContractorOutputBean> listaSubcontractor) {
		this.listaSubcontractor = listaSubcontractor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaSubcontractor == null) ? 0 : listaSubcontractor.hashCode());
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
		RecuperaSubContractorWrapperOutputBean other = (RecuperaSubContractorWrapperOutputBean) obj;
		if (listaSubcontractor == null) {
			if (other.listaSubcontractor != null)
				return false;
		} else if (!listaSubcontractor.equals(other.listaSubcontractor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaSubContractorWrapperOutputBean [listaSubcontractor=" + listaSubcontractor + "]";
	}
	
}
