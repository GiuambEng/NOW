package com.nttdata.tim.now.data.dto.notifica;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class FileFwaWrapperOutputDTO extends ESBResultDTO implements Serializable {

	private static final long serialVersionUID = -8353394990727599622L;
	
	@JsonProperty("listaFileFwa")	
    private List<FileFwaOutputDTO> listaFileFwa;

	public List<FileFwaOutputDTO> getListaFileFwa() {
		return listaFileFwa;
	}

	public void setListaFileFwa(List<FileFwaOutputDTO> listaFileFwa) {
		this.listaFileFwa = listaFileFwa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listaFileFwa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileFwaWrapperOutputDTO other = (FileFwaWrapperOutputDTO) obj;
		return Objects.equals(listaFileFwa, other.listaFileFwa);
	}

	@Override
	public String toString() {
		return "FileFwaWrapperOutputDTO [listaFileFwa=" + listaFileFwa + "]";
	}

}
