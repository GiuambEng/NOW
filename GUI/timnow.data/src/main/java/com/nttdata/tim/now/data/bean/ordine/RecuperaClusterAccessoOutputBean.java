package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1598
public class RecuperaClusterAccessoOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 4379239813158385977L;
	
	@JsonProperty("ClusterAccesso")
	private List<String> ClusterAccesso;

	@JsonProperty("ClusterAccesso")
	public List<String> getClusterAccesso() {
		return ClusterAccesso;
	}

	public void setClusterAccesso(List<String> clusterAccesso) {
		ClusterAccesso = clusterAccesso;
	}
	
}
