package com.nttdata.tim.now.data.dto.ricerca;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ConditionDTO implements Serializable {

	private static final long serialVersionUID = 698125033292493628L;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("operazione")
	private String operazione;

	@JsonProperty("valore")
	private String valore;

	@JsonProperty("tipo")
	private String tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOperazione() {
		return operazione;
	}

	public void setOperazione(String operazione) {
		this.operazione = operazione;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((operazione == null) ? 0 : operazione.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((valore == null) ? 0 : valore.hashCode());
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
        ConditionDTO other = (ConditionDTO) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (operazione == null) {
            if (other.operazione != null)
                return false;
        } else if (!operazione.equals(other.operazione))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (valore == null) {
            if (other.valore != null)
                return false;
        } else if (!valore.equals(other.valore))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ConditionDTO [nome=" + nome + ", operazione=[" + operazione + "], valore=" + valore + ", tipo=" + tipo + "]";
    }

	
}
