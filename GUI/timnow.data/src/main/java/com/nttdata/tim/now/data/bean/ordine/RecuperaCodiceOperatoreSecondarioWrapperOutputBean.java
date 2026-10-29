package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class RecuperaCodiceOperatoreSecondarioWrapperOutputBean extends AbstractOutputBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5454131939256379511L;
	
	
	@JsonProperty("CodiceOperatoreSecondario")
	private List<String> CodiceOperatoreSecondario;

	public List<String> getCodiceOperatoreSecondario() {
		return CodiceOperatoreSecondario;
	}


	public void setCodiceOperatoreSecondario(List<String> codiceOperatoreSecondario) {
		this.CodiceOperatoreSecondario = codiceOperatoreSecondario;
	}


	@Override
	public int hashCode() {
		return Objects.hash(CodiceOperatoreSecondario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecuperaCodiceOperatoreSecondarioWrapperOutputBean other = (RecuperaCodiceOperatoreSecondarioWrapperOutputBean) obj;
		return Objects.equals(CodiceOperatoreSecondario, other.CodiceOperatoreSecondario);
	}


	@Override
	public String toString() {
		String objToString = "codiceOperatoreSecondario=[";
		if(CodiceOperatoreSecondario != null && !CodiceOperatoreSecondario.isEmpty()) {
			for(String s : CodiceOperatoreSecondario)
				objToString += s + ",";
			objToString = objToString.substring(0, objToString.length() - 1);
		}
		objToString += "]";
		return objToString;
	}
	
}
