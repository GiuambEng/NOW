package com.nttdata.tim.now.data.bean.anagraficafwawilldeco;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class RisorseFwaWillDecoWrapperOutputBean extends AbstractOutputBean implements Serializable{

	private static final long serialVersionUID = 4120089574573892255L;

	@JsonProperty("listaRisorseFwa")
    private List<RisorseFwaWillDecoListItemOutputBean> listaRisorseFwa;

	public List<RisorseFwaWillDecoListItemOutputBean> getListaRisorseFwa() {
		return listaRisorseFwa;
	}

	public void setListaRisorseFwa(List<RisorseFwaWillDecoListItemOutputBean> listaRisorseFwa) {
		this.listaRisorseFwa = listaRisorseFwa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listaRisorseFwa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RisorseFwaWillDecoWrapperOutputBean other = (RisorseFwaWillDecoWrapperOutputBean) obj;
		return Objects.equals(listaRisorseFwa, other.listaRisorseFwa);
	}

	@Override
	public String toString() {
		return "RisorseFwaWillDecoWrapperOutputBean [listaRisorseFwa=" + listaRisorseFwa + "]";
	}
	
}
