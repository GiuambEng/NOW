package com.nttdata.tim.now.data.bean.ordine.hashing;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class ReportWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -3085715554672892450L;
	
	@JsonProperty("outputListaReport")
	private List<ReportOutputBean> outputListaReport;

	public List<ReportOutputBean> getOutputListaReport() {
		return outputListaReport;
	}

	public void setOutputListaReport(List<ReportOutputBean> outputListaReport) {
		this.outputListaReport = outputListaReport;
	}

}
