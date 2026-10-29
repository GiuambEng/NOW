package com.nttdata.tim.now.data.bean.ordine.npng;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1203
public class DettaglioOrdineNpngWrapperOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 6498984668679808492L;
	
	@JsonProperty("dettaglioOrdineNPNG")
	private DettaglioOrdineNpngOutputBean dettaglioOrdineNpng;

	public DettaglioOrdineNpngOutputBean getDettaglioOrdineNpng() {
		return dettaglioOrdineNpng;
	}

	public void setDettaglioOrdineNpng(DettaglioOrdineNpngOutputBean dettaglioOrdineNpng) {
		this.dettaglioOrdineNpng = dettaglioOrdineNpng;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dettaglioOrdineNpng == null) ? 0 : dettaglioOrdineNpng.hashCode());
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
		DettaglioOrdineNpngWrapperOutputBean other = (DettaglioOrdineNpngWrapperOutputBean) obj;
		if (dettaglioOrdineNpng == null) {
			if (other.dettaglioOrdineNpng != null)
				return false;
		} else if (!dettaglioOrdineNpng.equals(other.dettaglioOrdineNpng))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DettaglioOrdineNpngWrapperOutputBean [dettaglioOrdineNpng=" + dettaglioOrdineNpng + "]";
	}	
 }
