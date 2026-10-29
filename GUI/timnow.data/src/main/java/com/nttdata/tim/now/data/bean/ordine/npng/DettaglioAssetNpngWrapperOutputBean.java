package com.nttdata.tim.now.data.bean.ordine.npng;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1203
public class DettaglioAssetNpngWrapperOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 744869735336257663L;
	
	@JsonProperty("dettaglioAssetNPNG")
	private DettaglioAssetNpngOutputBean dettaglioAssetNpng;

	public DettaglioAssetNpngOutputBean getDettaglioAssetNpng() {
		return dettaglioAssetNpng;
	}

	public void setDettaglioAssetNpng(DettaglioAssetNpngOutputBean dettaglioAssetNpng) {
		this.dettaglioAssetNpng = dettaglioAssetNpng;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dettaglioAssetNpng == null) ? 0 : dettaglioAssetNpng.hashCode());
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
		DettaglioAssetNpngWrapperOutputBean other = (DettaglioAssetNpngWrapperOutputBean) obj;
		if (dettaglioAssetNpng == null) {
			if (other.dettaglioAssetNpng != null)
				return false;
		} else if (!dettaglioAssetNpng.equals(other.dettaglioAssetNpng))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DettaglioAssetNpngWrapperOutputBean [dettaglioAssetNpng=" + dettaglioAssetNpng + "]";
	}

		
 }
