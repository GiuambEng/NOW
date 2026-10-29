package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1150
//RU_1274
@JsonInclude(Include.NON_NULL)
public class RecuperaIdGponOutputDTO implements Serializable{

	private static final long serialVersionUID = 2627257012660258803L;

	@JsonProperty("IDGPON")
    private String idGpon;

    @JsonProperty("codificaOlo")
    private String codificaOlo;

    @JsonProperty("codiceAreaCentrale")
    private String codiceAreaCentrale;
        
    @JsonProperty("puntoInterconnessione")
    private String puntoInterconnessione;
    
    //RU_1338
    @JsonProperty("fattoreDiSplitting")
    private String fattoreDiSplitting;
    
    @JsonProperty("dataRegistrazioneFattoreDiSplitting")
    private String dataRegistrazioneFattoreDiSplitting;
    
    @JsonProperty("idGponValido")
    private String idGponValido;

	public String getIdGpon() {
		return idGpon;
	}

	public void setIdGpon(String idGpon) {
		this.idGpon = idGpon;
	}

	public String getCodificaOlo() {
		return codificaOlo;
	}

	public void setCodificaOlo(String codificaOlo) {
		this.codificaOlo = codificaOlo;
	}

	public String getCodiceAreaCentrale() {
		return codiceAreaCentrale;
	}

	public void setCodiceAreaCentrale(String codiceAreaCentrale) {
		this.codiceAreaCentrale = codiceAreaCentrale;
	}

	public String getPuntoInterconnessione() {
		return puntoInterconnessione;
	}

	public void setPuntoInterconnessione(String puntoInterconnessione) {
		this.puntoInterconnessione = puntoInterconnessione;
	}

	public String getFattoreDiSplitting() {
		return fattoreDiSplitting;
	}

	public void setFattoreDiSplitting(String fattoreDiSplitting) {
		this.fattoreDiSplitting = fattoreDiSplitting;
	}

	public String getDataRegistrazioneFattoreDiSplitting() {
		return dataRegistrazioneFattoreDiSplitting;
	}

	public void setDataRegistrazioneFattoreDiSplitting(String dataRegistrazioneFattoreDiSplitting) {
		this.dataRegistrazioneFattoreDiSplitting = dataRegistrazioneFattoreDiSplitting;
	}

	public String getIdGponValido() {
		return idGponValido;
	}

	public void setIdGponValido(String idGponValido) {
		this.idGponValido = idGponValido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceAreaCentrale, codificaOlo, dataRegistrazioneFattoreDiSplitting, fattoreDiSplitting,
				idGpon, idGponValido, puntoInterconnessione);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecuperaIdGponOutputDTO other = (RecuperaIdGponOutputDTO) obj;
		return Objects.equals(codiceAreaCentrale, other.codiceAreaCentrale)
				&& Objects.equals(codificaOlo, other.codificaOlo)
				&& Objects.equals(dataRegistrazioneFattoreDiSplitting, other.dataRegistrazioneFattoreDiSplitting)
				&& Objects.equals(fattoreDiSplitting, other.fattoreDiSplitting) && Objects.equals(idGpon, other.idGpon)
				&& Objects.equals(idGponValido, other.idGponValido)
				&& Objects.equals(puntoInterconnessione, other.puntoInterconnessione);
	}

	@Override
	public String toString() {
		return "RecuperaIdGponOutputDTO [idGpon=" + idGpon + ", codificaOlo=" + codificaOlo + ", codiceAreaCentrale="
				+ codiceAreaCentrale + ", puntoInterconnessione=" + puntoInterconnessione + ", fattoreDiSplitting="
				+ fattoreDiSplitting + ", dataRegistrazioneFattoreDiSplitting=" + dataRegistrazioneFattoreDiSplitting
				+ ", idGponValido=" + idGponValido + "]";
	}
	
}
