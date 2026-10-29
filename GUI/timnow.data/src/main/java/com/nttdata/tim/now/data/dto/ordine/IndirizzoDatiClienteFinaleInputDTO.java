package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class IndirizzoDatiClienteFinaleInputDTO implements Serializable {
	
	private static final long serialVersionUID = -1287231486036097310L;

	@JsonProperty("provincia")
    private String provincia;
    
    @JsonProperty("localita")
    private String localita;
    
    @JsonProperty("comune")
    private String comune;
    
    @JsonProperty("partToponomastica")
    private String partToponomastica;
    
    @JsonProperty("indirizzo")
    private String indirizzo;
    
    @JsonProperty("civico")
    private String civico;
    
    @JsonProperty("cap")
    private String cap;
    
    @JsonProperty("piano")
    private String piano;
    
    @JsonProperty("complesso")
    private String complesso;
    
    @JsonProperty("scala")
    private String scala;
    
    @JsonProperty("interno")
    private String interno;
    
    //RU_915
    @JsonProperty("codiceComune")
    private String codiceComune;
    
    //RU_1150
    @JsonProperty("codiceEgon")
    private String codiceEgon;
    
    //RU_1452
    @JsonProperty("identificativoDelPOP")
    private String identificativoDelPop;


    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalita() {
        return localita;
    }

    public void setLocalita(String localita) {
        this.localita = localita;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getPartToponomastica() {
        return partToponomastica;
    }

    public void setPartToponomastica(String partToponomastica) {
        this.partToponomastica = partToponomastica;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getPiano() {
        return piano;
    }

    public void setPiano(String piano) {
        this.piano = piano;
    }

    public String getComplesso() {
        return complesso;
    }

    public void setComplesso(String complesso) {
        this.complesso = complesso;
    }

    public String getScala() {
        return scala;
    }

    public void setScala(String scala) {
        this.scala = scala;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public String getCodiceComune() {
		return codiceComune;
	}

	public void setCodiceComune(String codiceComune) {
		this.codiceComune = codiceComune;
	}

	public String getCodiceEgon() {
		return codiceEgon;
	}

	public void setCodiceEgon(String codiceEgon) {
		this.codiceEgon = codiceEgon;
	}


	public String getIdentificativoDelPop() {
		return identificativoDelPop;
	}

	public void setIdentificativoDelPop(String identificativoDelPop) {
		this.identificativoDelPop = identificativoDelPop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cap == null) ? 0 : cap.hashCode());
		result = prime * result + ((civico == null) ? 0 : civico.hashCode());
		result = prime * result + ((codiceComune == null) ? 0 : codiceComune.hashCode());
		result = prime * result + ((codiceEgon == null) ? 0 : codiceEgon.hashCode());
		result = prime * result + ((complesso == null) ? 0 : complesso.hashCode());
		result = prime * result + ((comune == null) ? 0 : comune.hashCode());
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((interno == null) ? 0 : interno.hashCode());
		result = prime * result + ((localita == null) ? 0 : localita.hashCode());
		result = prime * result + ((partToponomastica == null) ? 0 : partToponomastica.hashCode());
		result = prime * result + ((piano == null) ? 0 : piano.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((scala == null) ? 0 : scala.hashCode());
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
		IndirizzoDatiClienteFinaleInputDTO other = (IndirizzoDatiClienteFinaleInputDTO) obj;
		if (cap == null) {
			if (other.cap != null)
				return false;
		} else if (!cap.equals(other.cap))
			return false;
		if (civico == null) {
			if (other.civico != null)
				return false;
		} else if (!civico.equals(other.civico))
			return false;
		if (codiceComune == null) {
			if (other.codiceComune != null)
				return false;
		} else if (!codiceComune.equals(other.codiceComune))
			return false;
		if (codiceEgon == null) {
			if (other.codiceEgon != null)
				return false;
		} else if (!codiceEgon.equals(other.codiceEgon))
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
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
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
		if (partToponomastica == null) {
			if (other.partToponomastica != null)
				return false;
		} else if (!partToponomastica.equals(other.partToponomastica))
			return false;
		if (piano == null) {
			if (other.piano != null)
				return false;
		} else if (!piano.equals(other.piano))
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
		return true;
	}

    @Override
	public String toString() {
		return "IndirizzoDatiClienteFinaleInputDTO [provincia=" + provincia + ", localita=" + localita + ", comune="
				+ comune + ", partToponomastica=" + partToponomastica + ", indirizzo=" + indirizzo + ", civico="
				+ civico + ", cap=" + cap + ", piano=" + piano + ", complesso=" + complesso + ", scala=" + scala
				+ ", interno=" + interno + ", codiceComune=" + codiceComune + ", codiceEgon=" + codiceEgon + "]";
	}
    
    
}
