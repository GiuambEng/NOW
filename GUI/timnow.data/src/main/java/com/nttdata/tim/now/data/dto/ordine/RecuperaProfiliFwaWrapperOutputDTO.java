package com.nttdata.tim.now.data.dto.ordine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class RecuperaProfiliFwaWrapperOutputDTO extends ESBResultDTO{

	private static final long serialVersionUID = 1L;

    @JsonProperty("recuperaProfiliFWAOutput")
    private List<RecuperaProfiliFwaOutputDTO> recuperaProfiliFWAOutput;

	public List<RecuperaProfiliFwaOutputDTO> getRecuperaProfiliFWAOutput() {
		return recuperaProfiliFWAOutput;
	}

	public void setRecuperaProfiliFWAOutput(List<RecuperaProfiliFwaOutputDTO> recuperaProfiliFWAOutput) {
		this.recuperaProfiliFWAOutput = recuperaProfiliFWAOutput;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recuperaProfiliFWAOutput == null) ? 0 : recuperaProfiliFWAOutput.hashCode());
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
		RecuperaProfiliFwaWrapperOutputDTO other = (RecuperaProfiliFwaWrapperOutputDTO) obj;
		if (recuperaProfiliFWAOutput == null) {
			if (other.recuperaProfiliFWAOutput != null)
				return false;
		} else if (!recuperaProfiliFWAOutput.equals(other.recuperaProfiliFWAOutput))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaProfiliFwaWrapperOutputDTO [recuperaProfiliFWAOutput=" + recuperaProfiliFWAOutput + "]";
	}

    
}
