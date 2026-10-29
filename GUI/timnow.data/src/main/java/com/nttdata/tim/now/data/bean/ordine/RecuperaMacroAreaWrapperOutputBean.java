package com.nttdata.tim.now.data.bean.ordine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1166
public class RecuperaMacroAreaWrapperOutputBean extends AbstractOutputBean{

	private static final long serialVersionUID = -5308721190026045669L;
	
	@JsonProperty("listaMacroaree")
    private List<RecuperaMacroAreaOutputBean> listaMacroaree;

	public List<RecuperaMacroAreaOutputBean> getListaMacroaree() {
		return listaMacroaree;
	}

	public void setListaMacroaree(List<RecuperaMacroAreaOutputBean> listaMacroaree) {
		this.listaMacroaree = listaMacroaree;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaMacroaree == null) ? 0 : listaMacroaree.hashCode());
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
		RecuperaMacroAreaWrapperOutputBean other = (RecuperaMacroAreaWrapperOutputBean) obj;
		if (listaMacroaree == null) {
			if (other.listaMacroaree != null)
				return false;
		} else if (!listaMacroaree.equals(other.listaMacroaree))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaMacroAreaWrapperOutputBean [listaMacroaree=" + listaMacroaree + "]";
	}

		
}
