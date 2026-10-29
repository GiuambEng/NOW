package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1166
@JsonInclude(Include.NON_NULL)
public class RecuperaMacroAreaInputDTO implements Serializable {

	private static final long serialVersionUID = 1165105069742791549L;

	@JsonProperty("idOfferta")
	private String idOfferta;
	
	@JsonProperty("supermacroarea")
    private String supermacroarea;
	
	@JsonProperty("ccLib")
    private String ccLib;

	@JsonProperty("codiceTdKit")
    private String codiceTdKit;
	
	@JsonProperty("cos")
    private String cos;

	public String getIdOfferta() {
		return idOfferta;
	}

	public String getSupermacroarea() {
		return supermacroarea;
	}

	public String getCcLib() {
		return ccLib;
	}

	public String getCodiceTdKit() {
		return codiceTdKit;
	}

	public String getCos() {
		return cos;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public void setSupermacroarea(String supermacroarea) {
		this.supermacroarea = supermacroarea;
	}

	public void setCcLib(String ccLib) {
		this.ccLib = ccLib;
	}

	public void setCodiceTdKit(String codiceTdKit) {
		this.codiceTdKit = codiceTdKit;
	}

	public void setCos(String cos) {
		this.cos = cos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccLib == null) ? 0 : ccLib.hashCode());
		result = prime * result + ((codiceTdKit == null) ? 0 : codiceTdKit.hashCode());
		result = prime * result + ((cos == null) ? 0 : cos.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((supermacroarea == null) ? 0 : supermacroarea.hashCode());
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
		RecuperaMacroAreaInputDTO other = (RecuperaMacroAreaInputDTO) obj;
		if (ccLib == null) {
			if (other.ccLib != null)
				return false;
		} else if (!ccLib.equals(other.ccLib))
			return false;
		if (codiceTdKit == null) {
			if (other.codiceTdKit != null)
				return false;
		} else if (!codiceTdKit.equals(other.codiceTdKit))
			return false;
		if (cos == null) {
			if (other.cos != null)
				return false;
		} else if (!cos.equals(other.cos))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (supermacroarea == null) {
			if (other.supermacroarea != null)
				return false;
		} else if (!supermacroarea.equals(other.supermacroarea))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaMacroAreaInputDTO [idOfferta=" + idOfferta + ", supermacroarea=" + supermacroarea + ", ccLib="
				+ ccLib + ", codiceTdKit=" + codiceTdKit + ", cos=" + cos + "]";
	}
	
	
}
