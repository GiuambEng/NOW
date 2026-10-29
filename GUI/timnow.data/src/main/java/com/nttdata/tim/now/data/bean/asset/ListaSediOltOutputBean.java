package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//R1I-21-0203
@JsonInclude(Include.NON_NULL)
public class ListaSediOltOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -8666954388418605880L;
	
	@JsonProperty("SediOltDettaglioAssetOutput")
	private List<SedeOltOutputBean> sediOlt;

	public List<SedeOltOutputBean> getSediOlt() {
		return sediOlt;
	}

	public void setSediOlt(List<SedeOltOutputBean> sediOlt) {
		this.sediOlt = sediOlt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sediOlt == null) ? 0 : sediOlt.hashCode());
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
		ListaSediOltOutputBean other = (ListaSediOltOutputBean) obj;
		if (sediOlt == null) {
			if (other.sediOlt != null)
				return false;
		} else if (!sediOlt.equals(other.sediOlt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SediOltWrapperOutputBean [sediOlt=" + sediOlt + "]";
	}

}
