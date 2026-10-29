package com.nttdata.tim.now.data.dto.anagraficaolo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ProfiloOloOutputDTO implements Serializable {
	
	private static final long serialVersionUID = -148471019258766081L;

	@JsonProperty("anagraficaOlo")
	private List<AnagraficaOloOutputDTO> anagraficaOlo;

	@JsonProperty("codiceAgcom")
	private String codiceAgcom;

	@JsonProperty("flagAccorpante")
	private String flagAccorpante;
	
	//RU_1180
	@JsonProperty("codiceAgcomNumerico")
	private String codiceAgcomNumerico;

	public List<AnagraficaOloOutputDTO> getAnagraficaOlo() {
		return anagraficaOlo;
	}

	public void setAnagraficaOlo(List<AnagraficaOloOutputDTO> anagraficaOlo) {
		this.anagraficaOlo = anagraficaOlo;
	}

	public String getCodiceAgcom() {
		return codiceAgcom;
	}

	public void setCodiceAgcom(String codiceAgcom) {
		this.codiceAgcom = codiceAgcom;
	}

	public String getFlagAccorpante() {
		return flagAccorpante;
	}

	public void setFlagAccorpante(String flagAccorpante) {
		this.flagAccorpante = flagAccorpante;
	}

	public String getCodiceAgcomNumerico() {
		return codiceAgcomNumerico;
	}

	public void setCodiceAgcomNumerico(String codiceAgcomNumerico) {
		this.codiceAgcomNumerico = codiceAgcomNumerico;
	}

}
