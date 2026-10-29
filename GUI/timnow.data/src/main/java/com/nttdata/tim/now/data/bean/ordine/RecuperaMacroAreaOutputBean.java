package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1166
@JsonInclude(Include.NON_NULL)
public class RecuperaMacroAreaOutputBean implements Serializable {

	private static final long serialVersionUID = 7349369293532986926L;

	@JsonProperty("idAdrCrmws")
    private String idAdrCrmws;

    @JsonProperty("descrizioneArea")
    private String descrizioneArea;

	public String getIdAdrCrmws() {
		return idAdrCrmws;
	}

	public String getDescrizioneArea() {
		return descrizioneArea;
	}

	public void setIdAdrCrmws(String idAdrCrmws) {
		this.idAdrCrmws = idAdrCrmws;
	}

	public void setDescrizioneArea(String descrizioneArea) {
		this.descrizioneArea = descrizioneArea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizioneArea == null) ? 0 : descrizioneArea.hashCode());
		result = prime * result + ((idAdrCrmws == null) ? 0 : idAdrCrmws.hashCode());
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
		RecuperaMacroAreaOutputBean other = (RecuperaMacroAreaOutputBean) obj;
		if (descrizioneArea == null) {
			if (other.descrizioneArea != null)
				return false;
		} else if (!descrizioneArea.equals(other.descrizioneArea))
			return false;
		if (idAdrCrmws == null) {
			if (other.idAdrCrmws != null)
				return false;
		} else if (!idAdrCrmws.equals(other.idAdrCrmws))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaMacroAreaOutputBean [idAdrCrmws=" + idAdrCrmws + ", descrizioneArea=" + descrizioneArea + "]";
	}

	
}