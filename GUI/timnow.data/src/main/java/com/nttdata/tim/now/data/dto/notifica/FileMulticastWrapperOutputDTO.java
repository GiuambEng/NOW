package com.nttdata.tim.now.data.dto.notifica;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class FileMulticastWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 806852190977567003L;
	
	@JsonProperty("outputVisualizzaFileSediCanali")	
    private List<FileMulticastOutputDTO> outputVisualizzaFileSediCanali;

	public List<FileMulticastOutputDTO> getOutputVisualizzaFileSediCanali() {
		return outputVisualizzaFileSediCanali;
	}

	public void setListaFileIncentivi(List<FileMulticastOutputDTO> outputVisualizzaFileSediCanali) {
		this.outputVisualizzaFileSediCanali = outputVisualizzaFileSediCanali;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((outputVisualizzaFileSediCanali == null) ? 0 : outputVisualizzaFileSediCanali.hashCode());
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
		FileMulticastWrapperOutputDTO other = (FileMulticastWrapperOutputDTO) obj;
		if (outputVisualizzaFileSediCanali == null) {
			if (other.outputVisualizzaFileSediCanali != null)
				return false;
		} else if (!outputVisualizzaFileSediCanali.equals(other.outputVisualizzaFileSediCanali))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileMulticastWrapperOutputDTO [outputVisualizzaFileSediCanali=" + outputVisualizzaFileSediCanali + "]";
	}
}
