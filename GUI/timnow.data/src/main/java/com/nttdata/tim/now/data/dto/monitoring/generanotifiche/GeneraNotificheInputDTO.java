package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.olo.CodiceOloDTO;

@JsonInclude(Include.NON_NULL)
public class GeneraNotificheInputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -8027286511508032791L;

	@JsonProperty("rinvioNotificheInputElement")
	private CodiceOloDTO codOlo;

	@JsonProperty("listaRichieste")
	private List<RichiestaGeneraNotificheInputDTO> listaRichieste;

	public CodiceOloDTO getCodOlo() {
		return codOlo;
	}

	public void setCodOlo(CodiceOloDTO codOlo) {
		this.codOlo = codOlo;
	}

	public List<RichiestaGeneraNotificheInputDTO> getListaRichieste() {
		return listaRichieste;
	}

	public void setListaRichieste(List<RichiestaGeneraNotificheInputDTO> listaRichieste) {
		this.listaRichieste = listaRichieste;
	}

	@Override
	public String toString() {
		return "GeneraNotificheInputDTO [codOlo=" + codOlo + ", listaRichieste=" + listaRichieste + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOlo == null) ? 0 : codOlo.hashCode());
		result = prime * result + ((listaRichieste == null) ? 0 : listaRichieste.hashCode());
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
		GeneraNotificheInputDTO other = (GeneraNotificheInputDTO) obj;
		if (codOlo == null) {
			if (other.codOlo != null)
				return false;
		} else if (!codOlo.equals(other.codOlo))
			return false;
		if (listaRichieste == null) {
			if (other.listaRichieste != null)
				return false;
		} else if (!listaRichieste.equals(other.listaRichieste))
			return false;
		return true;
	}

}
