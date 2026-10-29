package com.nttdata.tim.now.data.dto.asset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class DettaglioAssetWrapperOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = 7089840931549014867L;
	@JsonProperty("outputAssetDetails")
	private DettaglioAssetOutputDTO asset;

	public DettaglioAssetOutputDTO getAsset() {
	    return asset;
	}

	public void setAsset(DettaglioAssetOutputDTO asset) {
	    this.asset = asset;
	}

	@Override
	public String toString() {
		return "DettaglioAssetWrapperDTO [asset=" + asset + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asset == null) ? 0 : asset.hashCode());
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
		DettaglioAssetWrapperOutputDTO other = (DettaglioAssetWrapperOutputDTO) obj;
		if (asset == null) {
			if (other.asset != null)
				return false;
		} else if (!asset.equals(other.asset))
			return false;
		return true;
	}
	
}
