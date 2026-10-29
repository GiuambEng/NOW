package com.nttdata.tim.now.data.dto.asset;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class RecuperoAssetWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -5117334360286117371L;

	@JsonProperty("recuperoAssetOutput")
	private List<RecuperoAssetOutputDTO> recuperoAssetDTO;

	@JsonProperty("esito")
	private String esito;

	public List<RecuperoAssetOutputDTO> getRecuperoAssetDTO() {
		return recuperoAssetDTO;
	}

	public void setRecuperoAssetDTO(List<RecuperoAssetOutputDTO> recuperoAssetDTO) {
		this.recuperoAssetDTO = recuperoAssetDTO;
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
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
		result = prime * result + ((recuperoAssetDTO == null) ? 0 : recuperoAssetDTO.hashCode());
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
		RecuperoAssetWrapperOutputDTO other = (RecuperoAssetWrapperOutputDTO) obj;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		if (recuperoAssetDTO == null) {
			if (other.recuperoAssetDTO != null)
				return false;
		} else if (!recuperoAssetDTO.equals(other.recuperoAssetDTO))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperoAssetWrapperOutputDTO [recuperoAssetDTO=" + recuperoAssetDTO + ", esito=" + esito + "]";
	}

	
}
