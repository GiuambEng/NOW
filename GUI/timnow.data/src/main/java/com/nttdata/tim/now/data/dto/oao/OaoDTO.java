package com.nttdata.tim.now.data.dto.oao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class OaoDTO extends ESBResultDTO {

	private static final long serialVersionUID = -3562827582884504764L;

	@JsonProperty("olo")
	private String olo;

	@JsonProperty("ragioneSociale")
	private String ragioneSociale;

	@JsonProperty("partitaIva")
	private String partitaIva;

	@JsonProperty("codiceOloAgcom")
	private String codiceOloAgcom;

	@JsonProperty("codiceOloNumerico")
	private String codiceOloNumerico;

	@JsonProperty("flagAccorpante")
	private String flagAccorpante;

	public String getOlo() {
		return olo;
	}

	public void setOlo(String olo) {
		this.olo = olo;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getCodiceOloAgcom() {
		return codiceOloAgcom;
	}

	public void setCodiceOloAgcom(String codiceOloAgcom) {
		this.codiceOloAgcom = codiceOloAgcom;
	}

	public String getCodiceOloNumerico() {
		return codiceOloNumerico;
	}

	public void setCodiceOloNumerico(String codiceOloNumerico) {
		this.codiceOloNumerico = codiceOloNumerico;
	}

	public String getFlagAccorpante() {
		return flagAccorpante;
	}

	public void setFlagAccorpante(String flagAccorpante) {
		this.flagAccorpante = flagAccorpante;
	}

}
