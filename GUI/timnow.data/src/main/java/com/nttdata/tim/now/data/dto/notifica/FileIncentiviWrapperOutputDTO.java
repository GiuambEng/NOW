package com.nttdata.tim.now.data.dto.notifica;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1127
@JsonInclude(Include.NON_NULL)
public class FileIncentiviWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = 3564486566597532327L;
	
	@JsonProperty("listaFileIncentivi")	
    private List<FileIncentiviOutputDTO> listaFileIncentivi;

	public List<FileIncentiviOutputDTO> getListaFileIncentivi() {
		return listaFileIncentivi;
	}

	public void setListaFileIncentivi(List<FileIncentiviOutputDTO> listaFileIncentivi) {
		this.listaFileIncentivi = listaFileIncentivi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaFileIncentivi == null) ? 0 : listaFileIncentivi.hashCode());
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
		FileIncentiviWrapperOutputDTO other = (FileIncentiviWrapperOutputDTO) obj;
		if (listaFileIncentivi == null) {
			if (other.listaFileIncentivi != null)
				return false;
		} else if (!listaFileIncentivi.equals(other.listaFileIncentivi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileIncentiviWrapperOutputDTO [listaFileIncentivi=" + listaFileIncentivi + "]";
	}
}
