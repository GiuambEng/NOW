package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.olo.CodiceOloDTO;

@JsonInclude(Include.NON_NULL)
public class NotificationRequestListDTO implements Serializable {

	private static final long serialVersionUID = 1462779322242029444L;

	@JsonProperty("rinvioNotificheInputElement")
	private CodiceOloDTO codOlo;

	@JsonProperty("listaRichieste")
	private List<CodiceRichiestaDTO> listaRichieste;

	public CodiceOloDTO getCodOlo() {
		return codOlo;
	}

	public void setCodOlo(CodiceOloDTO codOlo) {
		this.codOlo = codOlo;
	}

	public List<CodiceRichiestaDTO> getListaRichieste() {
		return listaRichieste;
	}

	public void setListaRichieste(List<CodiceRichiestaDTO> listaRichieste) {
		this.listaRichieste = listaRichieste;
	}

}
