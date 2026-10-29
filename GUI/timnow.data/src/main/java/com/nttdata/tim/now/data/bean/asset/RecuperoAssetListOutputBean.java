package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class RecuperoAssetListOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -4656125328857710635L;

	@JsonProperty("data")
    private List<RecuperoAssetOutputBean> data;
    
    @JsonProperty("esito")
    private String esito;

	public List<RecuperoAssetOutputBean> getData() {
		return data;
	}

	public void setData(List<RecuperoAssetOutputBean> data) {
		this.data = data;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
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
		RecuperoAssetListOutputBean other = (RecuperoAssetListOutputBean) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperoAssetListOutputBean [data=" + data + ", esito=" + esito + "]";
	}

    
}