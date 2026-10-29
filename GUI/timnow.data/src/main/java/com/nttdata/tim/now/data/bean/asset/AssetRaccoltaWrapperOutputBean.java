package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1188
@JsonInclude(Include.NON_NULL)
public class AssetRaccoltaWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 2252446863481343349L;
	
	@JsonProperty("ListaAssetRaccoltaOutput")
	private List<AssetRaccoltaOutputBean> listaAssetRaccoltaOutput;
	
	@JsonProperty("idExportFile")
	private String idExportFile;

	public List<AssetRaccoltaOutputBean> getListaAssetRaccoltaOutput() {
		return listaAssetRaccoltaOutput;
	}

	public void setListaAssetRaccoltaOutput(List<AssetRaccoltaOutputBean> listaAssetRaccoltaOutput) {
		this.listaAssetRaccoltaOutput = listaAssetRaccoltaOutput;
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
		result = prime * result + ((idExportFile == null) ? 0 : idExportFile.hashCode());
		result = prime * result + ((listaAssetRaccoltaOutput == null) ? 0 : listaAssetRaccoltaOutput.hashCode());
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
		AssetRaccoltaWrapperOutputBean other = (AssetRaccoltaWrapperOutputBean) obj;
		if (idExportFile == null) {
			if (other.idExportFile != null)
				return false;
		} else if (!idExportFile.equals(other.idExportFile))
			return false;
		if (listaAssetRaccoltaOutput == null) {
			if (other.listaAssetRaccoltaOutput != null)
				return false;
		} else if (!listaAssetRaccoltaOutput.equals(other.listaAssetRaccoltaOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssetRaccoltaWrapperOutputBean [listaAssetRaccoltaOutput=" + listaAssetRaccoltaOutput
				+ ", idExportFile=" + idExportFile + "]";
	}

}
