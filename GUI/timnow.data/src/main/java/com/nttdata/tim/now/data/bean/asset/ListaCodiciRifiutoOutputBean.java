package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class ListaCodiciRifiutoOutputBean extends AbstractOutputBean implements Serializable  {

	private static final long serialVersionUID = 3149430426299182580L;

	@JsonProperty("lista")
	private List<CodiciRifiutoOutputBean>  lista;

	public List<CodiciRifiutoOutputBean> getLista() {
		return lista;
	}

	public void setLista(List<CodiciRifiutoOutputBean> lista) {
		this.lista = lista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
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
		ListaCodiciRifiutoOutputBean other = (ListaCodiciRifiutoOutputBean) obj;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaCodiciRifiutoOutputBean [lista=" + lista + "]";
	}
	
	
}
