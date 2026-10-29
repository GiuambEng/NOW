package com.nttdata.tim.now.data.dto.anagraficaolo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class AnagraficaOloWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 136174566853414526L;
	
	@JsonProperty("profiloOlo")
	private ProfiloOloOutputDTO profiloOlo;

	public ProfiloOloOutputDTO getProfiloOlo() {
		return profiloOlo;
	}

	public void setProfiloOlo(ProfiloOloOutputDTO profiloOlo) {
		this.profiloOlo = profiloOlo;
	}
}
