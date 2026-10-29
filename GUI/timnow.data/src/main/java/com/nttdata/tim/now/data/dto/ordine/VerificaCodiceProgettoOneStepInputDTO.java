package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//SM_10241
@JsonInclude(Include.NON_NULL)
public class VerificaCodiceProgettoOneStepInputDTO implements Serializable {

	private static final long serialVersionUID = 3224447079814282203L;
	
	@JsonProperty("codiceProgetto")
	private String codiceProgetto;
	
	@JsonProperty("tipoLinea")
	private String tipoLinea;
		
	@JsonProperty("idAsset")
	private String idAsset;
	
	@JsonProperty("codOloAgcom")
	private String codOloAgcom;
	
	@JsonProperty("lavorazione")
	private String lavorazione;
	
	public String getCodiceProgetto() {
		return codiceProgetto;
	}

	public void setCodiceProgetto(String codiceProgetto) {
		this.codiceProgetto = codiceProgetto;
	}

	public String getTipoLinea() {
		return tipoLinea;
	}

	public void setTipoLinea(String tipoLinea) {
		this.tipoLinea = tipoLinea;
	}


	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}
}
