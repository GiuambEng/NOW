package com.nttdata.tim.now.data.bean.architd;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class GestioneArchiNumerazioniTDListOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -3552802286228878475L;

	@JsonProperty("data")
	private List<GestioneArchiNumerazioniTDOutputBean> lista;

	@JsonProperty("tdResidui")
	private String tdResidui;

	public List<GestioneArchiNumerazioniTDOutputBean> getLista() {
		return lista;
	}

	public void setLista(List<GestioneArchiNumerazioniTDOutputBean> lista) {
		this.lista = lista;
	}

	public String getTdResidui() {
		return tdResidui;
	}

	public void setTdResidui(String tdResidui) {
		this.tdResidui = tdResidui;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((tdResidui == null) ? 0 : tdResidui.hashCode());
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
		GestioneArchiNumerazioniTDListOutputBean other = (GestioneArchiNumerazioniTDListOutputBean) obj;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		if (tdResidui == null) {
			if (other.tdResidui != null)
				return false;
		} else if (!tdResidui.equals(other.tdResidui))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GestioneArchiNumerazioniTDListOutputBean [lista=" + lista + ", tdResidui=" + tdResidui + "]";
	}
	
    
	
    
}