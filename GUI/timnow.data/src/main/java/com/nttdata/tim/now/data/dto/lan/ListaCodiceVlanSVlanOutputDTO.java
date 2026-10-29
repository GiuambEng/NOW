package com.nttdata.tim.now.data.dto.lan;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaCodiceVlanSVlanOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = 4887027342419405392L;

	@JsonProperty("outputVLAN_SVLAN")
	private List<CodiceVlanSVlanOutputDTO> vlansvlans;

	@JsonProperty("outputrestcodvlancodsvlan")
	private List<CodiceVlanSVlanOutputDTO> orderVlanSvlans;

	public List<CodiceVlanSVlanOutputDTO> getVlansvlans() {
		return vlansvlans;
	}

	public void setVlansvlans(List<CodiceVlanSVlanOutputDTO> vlansvlans) {
		this.vlansvlans = vlansvlans;
	}

	public List<CodiceVlanSVlanOutputDTO> getOrderVlanSvlans() {
		return orderVlanSvlans;
	}

	public void setOrderVlanSvlans(List<CodiceVlanSVlanOutputDTO> orderVlanSvlans) {
		this.orderVlanSvlans = orderVlanSvlans;
	}

}
