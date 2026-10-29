package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1188
public class DettaglioAssetRaccoltaWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 4591255307036093549L;
	
	@JsonProperty("DettaglioAssetRaccoltaOutput")
	private DettaglioAssetRaccoltaOutputBean dettaglioAssetRaccoltaOutput;

	public DettaglioAssetRaccoltaOutputBean getDettaglioAssetRaccoltaOutput() {
		return dettaglioAssetRaccoltaOutput;
	}

	public void setDettaglioAssetRaccoltaOutput(DettaglioAssetRaccoltaOutputBean dettaglioAssetRaccoltaOutput) {
		this.dettaglioAssetRaccoltaOutput = dettaglioAssetRaccoltaOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dettaglioAssetRaccoltaOutput == null) ? 0 : dettaglioAssetRaccoltaOutput.hashCode());
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
		DettaglioAssetRaccoltaWrapperOutputBean other = (DettaglioAssetRaccoltaWrapperOutputBean) obj;
		if (dettaglioAssetRaccoltaOutput == null) {
			if (other.dettaglioAssetRaccoltaOutput != null)
				return false;
		} else if (!dettaglioAssetRaccoltaOutput.equals(other.dettaglioAssetRaccoltaOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DettaglioAssetRaccoltaWrapperOutputBean [dettaglioAssetRaccoltaOutput=" + dettaglioAssetRaccoltaOutput
				+ "]";
	}

}
