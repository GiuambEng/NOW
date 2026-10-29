package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class ListaRicaricheAssetOutputBean extends AbstractOutputBean implements Serializable  {

	private static final long serialVersionUID = 8826135108292199003L;

	@JsonProperty("dettaglioAsset")
	private RicaricaDettaglioAssetOutputBean dettaglioAsset;

	@JsonProperty("lista")
	private List<RicaricaOutputBean>  lista;
	
	@JsonProperty("idExportFile")
	private String idExportFile;

	public RicaricaDettaglioAssetOutputBean getDettaglioAsset() {
		return dettaglioAsset;
	}

	public void setDettaglioAsset(RicaricaDettaglioAssetOutputBean dettaglioAsset) {
		this.dettaglioAsset = dettaglioAsset;
	}

	public List<RicaricaOutputBean> getLista() {
		return lista;
	}

	public void setLista(List<RicaricaOutputBean> lista) {
		this.lista = lista;
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
		result = prime * result + ((dettaglioAsset == null) ? 0 : dettaglioAsset.hashCode());
		result = prime * result + ((idExportFile == null) ? 0 : idExportFile.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
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
		ListaRicaricheAssetOutputBean other = (ListaRicaricheAssetOutputBean) obj;
		if (dettaglioAsset == null) {
			if (other.dettaglioAsset != null)
				return false;
		} else if (!dettaglioAsset.equals(other.dettaglioAsset))
			return false;
		if (idExportFile == null) {
			if (other.idExportFile != null)
				return false;
		} else if (!idExportFile.equals(other.idExportFile))
			return false;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaRicaricheAssetOutputBean [dettaglioAsset=" + dettaglioAsset + ", lista=" + lista
				+ ", idExportFile=" + idExportFile + "]";
	}
	
	
}
