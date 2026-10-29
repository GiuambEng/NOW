package com.nttdata.tim.now.data.bean.ordine.npng;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1203
public class CambioOloNpngOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 7854705290909126315L;
	
	@JsonProperty("processID")
	private String processId;

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((processId == null) ? 0 : processId.hashCode());
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
		CambioOloNpngOutputBean other = (CambioOloNpngOutputBean) obj;
		if (processId == null) {
			if (other.processId != null)
				return false;
		} else if (!processId.equals(other.processId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CambioOloNpngOutputBean [processId=" + processId + "]";
	}

 }
