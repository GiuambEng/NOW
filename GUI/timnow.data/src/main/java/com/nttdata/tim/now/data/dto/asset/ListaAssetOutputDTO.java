package com.nttdata.tim.now.data.dto.asset;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaAssetOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = 3473538189373668961L;
	@JsonProperty("OutputAsset")
	private List<AssetOutputDTO> outputAsset;

	public List<AssetOutputDTO> getOutputAsset() {
		return outputAsset;
	}

	public void setOutputAsset(List<AssetOutputDTO> outputAsset) {
		this.outputAsset = outputAsset;
	}

}
