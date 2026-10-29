package com.nttdata.tim.now.data.dto.ordine.code;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CodiceOrdineTiDTO implements Serializable {

	private static final long serialVersionUID = 2329419642772352365L;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("progressivo")
	private String progressivo;

	@JsonProperty("tipologiadatorichiesta")
	private String tipologiadatorichiesta;

	@JsonProperty("richiestadettagliovalore")
	private String richiestadettagliovalore;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(String progressivo) {
		this.progressivo = progressivo;
	}

	public String getTipologiadatorichiesta() {
		return tipologiadatorichiesta;
	}

	public void setTipologiadatorichiesta(String tipologiadatorichiesta) {
		this.tipologiadatorichiesta = tipologiadatorichiesta;
	}

	public String getRichiestadettagliovalore() {
		return richiestadettagliovalore;
	}

	public void setRichiestadettagliovalore(String richiestadettagliovalore) {
		this.richiestadettagliovalore = richiestadettagliovalore;
	}

	@Override
	public String toString() {
		return "CodiceOrdineTiDTO [nome=" + nome + ", progressivo=" + progressivo + ", tipologiadatorichiesta="
				+ tipologiadatorichiesta + ", richiestadettagliovalore=" + richiestadettagliovalore + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((progressivo == null) ? 0 : progressivo.hashCode());
		result = prime * result + ((richiestadettagliovalore == null) ? 0 : richiestadettagliovalore.hashCode());
		result = prime * result + ((tipologiadatorichiesta == null) ? 0 : tipologiadatorichiesta.hashCode());
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
		CodiceOrdineTiDTO other = (CodiceOrdineTiDTO) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (progressivo == null) {
			if (other.progressivo != null)
				return false;
		} else if (!progressivo.equals(other.progressivo))
			return false;
		if (richiestadettagliovalore == null) {
			if (other.richiestadettagliovalore != null)
				return false;
		} else if (!richiestadettagliovalore.equals(other.richiestadettagliovalore))
			return false;
		if (tipologiadatorichiesta == null) {
			if (other.tipologiadatorichiesta != null)
				return false;
		} else if (!tipologiadatorichiesta.equals(other.tipologiadatorichiesta))
			return false;
		return true;
	}

}
