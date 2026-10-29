package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//R1I-21-0203
@JsonInclude(Include.NON_NULL)
public class ListaFeederOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -3004254285393774769L;
	
	@JsonProperty("FeederDettaglioAssetOutput")
	private List<FeederOutputBean> feeders;


	public List<FeederOutputBean> getFeeders() {
		return feeders;
	}

	public void setFeeders(List<FeederOutputBean> feeders) {
		this.feeders = feeders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feeders == null) ? 0 : feeders.hashCode());
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
		ListaFeederOutputBean other = (ListaFeederOutputBean) obj;
		if (feeders == null) {
			if (other.feeders != null)
				return false;
		} else if (!feeders.equals(other.feeders))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaFeederOutputBean [feeders=" + feeders + "]";
	}
}
