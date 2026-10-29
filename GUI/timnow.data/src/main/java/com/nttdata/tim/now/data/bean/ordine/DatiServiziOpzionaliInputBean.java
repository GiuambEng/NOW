package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_980
@JsonInclude(Include.NON_NULL)
public class DatiServiziOpzionaliInputBean implements Serializable{

	private static final long serialVersionUID = -3996430531314211875L;
	
    @JsonProperty("id")
    private String id;

    @JsonProperty("codiceServizio")
    private String codiceServizio;
    
    @JsonProperty("descrizioneServizio")
    private String descrizioneServizio;
    
    @JsonProperty("vincolantePerEspletamento")
    private String vincolantePerEspletamento;
    
    @JsonProperty("datiTecnici")
    private String datiTecnici;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodiceServizio() {
		return codiceServizio;
	}

	public void setCodiceServizio(String codiceServizio) {
		this.codiceServizio = codiceServizio;
	}

	public String getDescrizioneServizio() {
		return descrizioneServizio;
	}

	public void setDescrizioneServizio(String descrizioneServizio) {
		this.descrizioneServizio = descrizioneServizio;
	}

	public String getVincolantePerEspletamento() {
		return vincolantePerEspletamento;
	}

	public void setVincolantePerEspletamento(String vincolantePerEspletamento) {
		this.vincolantePerEspletamento = vincolantePerEspletamento;
	}

	public String getDatiTecnici() {
		return datiTecnici;
	}

	public void setDatiTecnici(String datiTecnici) {
		this.datiTecnici = datiTecnici;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceServizio == null) ? 0 : codiceServizio.hashCode());
		result = prime * result + ((datiTecnici == null) ? 0 : datiTecnici.hashCode());
		result = prime * result + ((descrizioneServizio == null) ? 0 : descrizioneServizio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((vincolantePerEspletamento == null) ? 0 : vincolantePerEspletamento.hashCode());
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
		DatiServiziOpzionaliInputBean other = (DatiServiziOpzionaliInputBean) obj;
		if (codiceServizio == null) {
			if (other.codiceServizio != null)
				return false;
		} else if (!codiceServizio.equals(other.codiceServizio))
			return false;
		if (datiTecnici == null) {
			if (other.datiTecnici != null)
				return false;
		} else if (!datiTecnici.equals(other.datiTecnici))
			return false;
		if (descrizioneServizio == null) {
			if (other.descrizioneServizio != null)
				return false;
		} else if (!descrizioneServizio.equals(other.descrizioneServizio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vincolantePerEspletamento == null) {
			if (other.vincolantePerEspletamento != null)
				return false;
		} else if (!vincolantePerEspletamento.equals(other.vincolantePerEspletamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatiServiziOpzionaliInputBean [id=" + id + ", codiceServizio=" + codiceServizio
				+ ", descrizioneServizio=" + descrizioneServizio + ", vincolantePerEspletamento="
				+ vincolantePerEspletamento + ", datiTecnici=" + datiTecnici + "]";
	}

	
}
