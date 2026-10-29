package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1598
public class RecuperaClusterAccessoOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 4623266331810276543L;
	
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
