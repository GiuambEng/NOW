package com.nttdata.tim.now.data.bean.ordine.donating;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdineDonatingDetailListOutputBean extends AbstractOutputBean {
	
	private static final long serialVersionUID = 179984103723803398L;
	
	@JsonProperty("OutputOrdiniDonatingDettaglio")
	private List<OrdineDonatingDetailOutputBean> list;

	@JsonProperty("OutputOrdiniDonatingRichieste")
	private List<OrdineDonatingRichiesteOutputBean> listRichieste;

	public List<OrdineDonatingDetailOutputBean> getList() {
		return list;
	}

	public void setList(List<OrdineDonatingDetailOutputBean> list) {
		this.list = list;
	}

	public List<OrdineDonatingRichiesteOutputBean> getListRichieste() {
		return listRichieste;
	}

	public void setListRichieste(List<OrdineDonatingRichiesteOutputBean> listRichieste) {
		this.listRichieste = listRichieste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((listRichieste == null) ? 0 : listRichieste.hashCode());
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
		OrdineDonatingDetailListOutputBean other = (OrdineDonatingDetailListOutputBean) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (listRichieste == null) {
			if (other.listRichieste != null)
				return false;
		} else if (!listRichieste.equals(other.listRichieste))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdineDonatingDetailListOutputBean [list=" + list + ", listRichieste=" + listRichieste + "]";
	}
	

}
