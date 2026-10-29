package com.nttdata.tim.now.data.bean.ordine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class RecuperaProfiliFwaWrapperOutputBean extends AbstractOutputBean{

	private static final long serialVersionUID = 1L;

    @JsonProperty("recuperaProfiliFWAOutput")
    private List<RecuperaProfiliFwaOutputBean> recuperaProfiliFWAOutput;

	public List<RecuperaProfiliFwaOutputBean> getRecuperaProfiliFWAOutput() {
		return recuperaProfiliFWAOutput;
	}

	public void setRecuperaProfiliFWAOutput(List<RecuperaProfiliFwaOutputBean> recuperaProfiliFWAOutput) {
		this.recuperaProfiliFWAOutput = recuperaProfiliFWAOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recuperaProfiliFWAOutput == null) ? 0 : recuperaProfiliFWAOutput.hashCode());
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
		RecuperaProfiliFwaWrapperOutputBean other = (RecuperaProfiliFwaWrapperOutputBean) obj;
		if (recuperaProfiliFWAOutput == null) {
			if (other.recuperaProfiliFWAOutput != null)
				return false;
		} else if (!recuperaProfiliFWAOutput.equals(other.recuperaProfiliFWAOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaProfiliFwaWrapperOutputBean [recuperaProfiliFWAOutput=" + recuperaProfiliFWAOutput + "]";
	}

    
}
