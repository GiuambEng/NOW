package com.nttdata.tim.now.data.bean.td;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class ListaCodiciTdOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = -1994332244701085220L;

	@JsonProperty("codiciTD")
	private List<CodiceTdBean> codiciTD;

	public List<CodiceTdBean> getCodiciTD() {
		return codiciTD;
	}

	public void setCodiciTD(List<CodiceTdBean> codiciTD) {
		this.codiciTD = codiciTD;
	}
}
