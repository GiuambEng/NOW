package com.nttdata.tim.now.data.bean.anagraficacoinvestimento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1276
@JsonInclude(Include.NON_NULL)
public class ComuniCoinvestimentoWrapperOutputBean extends AbstractOutputBean implements Serializable{

	private static final long serialVersionUID = -6436717038046608556L;
	
	@JsonProperty("listaComuniCoinvestiti")
    private List<ComuniCoinvestimentoOutputBean> listaComuniCoinvestiti;
	
	@JsonProperty("idExportFile")
    private String idExportFile;

	public List<ComuniCoinvestimentoOutputBean> getListaComuniCoinvestiti() {
		return listaComuniCoinvestiti;
	}

	public void setListaComuniCoinvestiti(List<ComuniCoinvestimentoOutputBean> listaComuniCoinvestiti) {
		this.listaComuniCoinvestiti = listaComuniCoinvestiti;
	}

	public String getIdExportFile() {
		return idExportFile;
	}

	public void setIdExportFile(String idExportFile) {
		this.idExportFile = idExportFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaComuniCoinvestiti == null) ? 0 : listaComuniCoinvestiti.hashCode());
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
		ComuniCoinvestimentoWrapperOutputBean other = (ComuniCoinvestimentoWrapperOutputBean) obj;
		if (listaComuniCoinvestiti == null) {
			if (other.listaComuniCoinvestiti != null)
				return false;
		} else if (!listaComuniCoinvestiti.equals(other.listaComuniCoinvestiti))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComuniCoinvestimentoWrapperOutputBean [listaComuniCoinvestiti=" + listaComuniCoinvestiti + "]";
	}	
}
