package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//R1I-21-0138
@JsonInclude(Include.NON_NULL)
public class VerificaCompatibilitaProfiloTecnicoLineaInputDTO implements Serializable {

	private static final long serialVersionUID = -3420620007899277881L;

    @JsonProperty("lavorazione")
    private String lavorazione;
	
	@JsonProperty("profiloTecnicoLinea")
    private String profiloTecnicoLinea;
    
    @JsonProperty("idAsset")
    private String idAsset;
        
    @JsonProperty("idOfferta")
    private String idOfferta;

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getProfiloTecnicoLinea() {
		return profiloTecnicoLinea;
	}

	public void setProfiloTecnicoLinea(String profiloTecnicoLinea) {
		this.profiloTecnicoLinea = profiloTecnicoLinea;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}	
}
