package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsistenzaOutputDTO implements Serializable {

	private static final long serialVersionUID = 3913349710729281475L;

	@JsonProperty("nome")
    private String nome;

    @JsonProperty("cognome_ragSociale")
    private String cognomeRagSociale;

    @JsonProperty("CF")
    private String cf;

    @JsonProperty("P.IVA")
    private String piva;

    @JsonProperty("provincia")
    private String provincia;

    @JsonProperty("comune")
    private String comune;
    
    @JsonProperty("localita")
    private String localita;

    @JsonProperty("codiceToponomastica")
    private String codiceToponomastica;
    
    @JsonProperty("descParticellaToponomastica")
    private String descParticellaToponomastica;

    @JsonProperty("via")
    private String via;
    
    @JsonProperty("numero")
    private String numero;

    @JsonProperty("cap")
    private String cap;
    
    @JsonProperty("complesso")
    private String complesso;

    @JsonProperty("interno")
    private String interno;
    
    @JsonProperty("scala")
    private String scala;
    
    @JsonProperty("piano")
    private String piano;

    @JsonProperty("idRisorsaNow")
    private String idRisorsaNow;
    
    @JsonProperty("esito")
    private String esito;

    @JsonProperty("descrizione")
    private String descrizione;

    @JsonProperty("outputConfigurazioneFE")
    private List<ConfigurazioneOutputDTO>  conflist;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognomeRagSociale() {
		return cognomeRagSociale;
	}

	public void setCognomeRagSociale(String cognomeRagSociale) {
		this.cognomeRagSociale = cognomeRagSociale;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getCodiceToponomastica() {
		return codiceToponomastica;
	}

	public void setCodiceToponomastica(String codiceToponomastica) {
		this.codiceToponomastica = codiceToponomastica;
	}

	public String getDescParticellaToponomastica() {
		return descParticellaToponomastica;
	}

	public void setDescParticellaToponomastica(String descParticellaToponomastica) {
		this.descParticellaToponomastica = descParticellaToponomastica;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getComplesso() {
		return complesso;
	}

	public void setComplesso(String complesso) {
		this.complesso = complesso;
	}

	public String getInterno() {
		return interno;
	}

	public void setInterno(String interno) {
		this.interno = interno;
	}

	public String getScala() {
		return scala;
	}

	public void setScala(String scala) {
		this.scala = scala;
	}

	public String getPiano() {
		return piano;
	}

	public void setPiano(String piano) {
		this.piano = piano;
	}

	public String getIdRisorsaNow() {
		return idRisorsaNow;
	}

	public void setIdRisorsaNow(String idRisorsaNow) {
		this.idRisorsaNow = idRisorsaNow;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<ConfigurazioneOutputDTO> getConflist() {
		return conflist;
	}

	public void setConflist(List<ConfigurazioneOutputDTO> conflist) {
		this.conflist = conflist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cap == null) ? 0 : cap.hashCode());
		result = prime * result + ((cf == null) ? 0 : cf.hashCode());
		result = prime * result + ((codiceToponomastica == null) ? 0 : codiceToponomastica.hashCode());
		result = prime * result + ((cognomeRagSociale == null) ? 0 : cognomeRagSociale.hashCode());
		result = prime * result + ((complesso == null) ? 0 : complesso.hashCode());
		result = prime * result + ((comune == null) ? 0 : comune.hashCode());
		result = prime * result + ((conflist == null) ? 0 : conflist.hashCode());
		result = prime * result + ((descParticellaToponomastica == null) ? 0 : descParticellaToponomastica.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
		result = prime * result + ((idRisorsaNow == null) ? 0 : idRisorsaNow.hashCode());
		result = prime * result + ((interno == null) ? 0 : interno.hashCode());
		result = prime * result + ((localita == null) ? 0 : localita.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((piano == null) ? 0 : piano.hashCode());
		result = prime * result + ((piva == null) ? 0 : piva.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((scala == null) ? 0 : scala.hashCode());
		result = prime * result + ((via == null) ? 0 : via.hashCode());
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
		ConsistenzaOutputDTO other = (ConsistenzaOutputDTO) obj;
		if (cap == null) {
			if (other.cap != null)
				return false;
		} else if (!cap.equals(other.cap))
			return false;
		if (cf == null) {
			if (other.cf != null)
				return false;
		} else if (!cf.equals(other.cf))
			return false;
		if (codiceToponomastica == null) {
			if (other.codiceToponomastica != null)
				return false;
		} else if (!codiceToponomastica.equals(other.codiceToponomastica))
			return false;
		if (cognomeRagSociale == null) {
			if (other.cognomeRagSociale != null)
				return false;
		} else if (!cognomeRagSociale.equals(other.cognomeRagSociale))
			return false;
		if (complesso == null) {
			if (other.complesso != null)
				return false;
		} else if (!complesso.equals(other.complesso))
			return false;
		if (comune == null) {
			if (other.comune != null)
				return false;
		} else if (!comune.equals(other.comune))
			return false;
		if (conflist == null) {
			if (other.conflist != null)
				return false;
		} else if (!conflist.equals(other.conflist))
			return false;
		if (descParticellaToponomastica == null) {
			if (other.descParticellaToponomastica != null)
				return false;
		} else if (!descParticellaToponomastica.equals(other.descParticellaToponomastica))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		if (idRisorsaNow == null) {
			if (other.idRisorsaNow != null)
				return false;
		} else if (!idRisorsaNow.equals(other.idRisorsaNow))
			return false;
		if (interno == null) {
			if (other.interno != null)
				return false;
		} else if (!interno.equals(other.interno))
			return false;
		if (localita == null) {
			if (other.localita != null)
				return false;
		} else if (!localita.equals(other.localita))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (piano == null) {
			if (other.piano != null)
				return false;
		} else if (!piano.equals(other.piano))
			return false;
		if (piva == null) {
			if (other.piva != null)
				return false;
		} else if (!piva.equals(other.piva))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (scala == null) {
			if (other.scala != null)
				return false;
		} else if (!scala.equals(other.scala))
			return false;
		if (via == null) {
			if (other.via != null)
				return false;
		} else if (!via.equals(other.via))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConsistenzaOutputDTO [nome=" + nome + ", cognomeRagSociale=" + cognomeRagSociale + ", cf=" + cf
				+ ", piva=" + piva + ", provincia=" + provincia + ", comune=" + comune + ", localita=" + localita
				+ ", codiceToponomastica=" + codiceToponomastica + ", descParticellaToponomastica="
				+ descParticellaToponomastica + ", via=" + via + ", numero=" + numero + ", cap=" + cap + ", complesso="
				+ complesso + ", interno=" + interno + ", scala=" + scala + ", piano=" + piano + ", idRisorsaNow="
				+ idRisorsaNow + ", esito=" + esito + ", descrizione=" + descrizione + ", conflist=" + conflist + "]";
	}

}
