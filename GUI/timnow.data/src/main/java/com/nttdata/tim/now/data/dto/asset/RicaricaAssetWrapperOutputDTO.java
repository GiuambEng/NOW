package com.nttdata.tim.now.data.dto.asset;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class RicaricaAssetWrapperOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = -4217325352836124481L;

	@JsonProperty("Lista_Ricariche")
	private List<RicaricaOutputDTO> richiesteRicaricaAssetDTO;

	@JsonProperty("dettaglioAsset")
	private RicaricaDettaglioAssetOutputDTO richiesteRicaricaDettaglioAssetDTO;

	public List<RicaricaOutputDTO> getRichiesteRicaricaAssetDTO() {
		return richiesteRicaricaAssetDTO;
	}

	public void setRichiesteRicaricaAssetDTO(List<RicaricaOutputDTO> richiesteRicaricaAssetDTO) {
		this.richiesteRicaricaAssetDTO = richiesteRicaricaAssetDTO;
	}

	public RicaricaDettaglioAssetOutputDTO getRichiesteRicaricaDettaglioAssetDTO() {
		return richiesteRicaricaDettaglioAssetDTO;
	}

	public void setRichiesteRicaricaDettaglioAssetDTO(
			RicaricaDettaglioAssetOutputDTO richiesteRicaricaDettaglioAssetDTO) {
		this.richiesteRicaricaDettaglioAssetDTO = richiesteRicaricaDettaglioAssetDTO;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((richiesteRicaricaAssetDTO == null) ? 0 : richiesteRicaricaAssetDTO.hashCode());
		result = prime * result
				+ ((richiesteRicaricaDettaglioAssetDTO == null) ? 0 : richiesteRicaricaDettaglioAssetDTO.hashCode());
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
		RicaricaAssetWrapperOutputDTO other = (RicaricaAssetWrapperOutputDTO) obj;
		if (richiesteRicaricaAssetDTO == null) {
			if (other.richiesteRicaricaAssetDTO != null)
				return false;
		} else if (!richiesteRicaricaAssetDTO.equals(other.richiesteRicaricaAssetDTO))
			return false;
		if (richiesteRicaricaDettaglioAssetDTO == null) {
			if (other.richiesteRicaricaDettaglioAssetDTO != null)
				return false;
		} else if (!richiesteRicaricaDettaglioAssetDTO.equals(other.richiesteRicaricaDettaglioAssetDTO))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RichiesteRicaricaAssetWrapperOutputDTO [richiesteRicaricaAssetDTO=" + richiesteRicaricaAssetDTO
				+ ", richiesteRicaricaDettaglioAssetDTO=" + richiesteRicaricaDettaglioAssetDTO + "]";
	}

	
}
