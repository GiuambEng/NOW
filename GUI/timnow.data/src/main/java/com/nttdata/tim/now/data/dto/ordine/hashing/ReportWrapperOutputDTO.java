package com.nttdata.tim.now.data.dto.ordine.hashing;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.ordine.hashing.ReportOutputBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//R1F-21-0411
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 4538670075948874930L;

	@JsonProperty("outputListaReport")
	private List<ReportOutputBean> outputListaReport;

	public List<ReportOutputBean> getOutputListaReport() {
		return outputListaReport;
	}

	public void setOutputListaReport(List<ReportOutputBean> outputListaReport) {
		this.outputListaReport = outputListaReport;
	}
}
