package com.nttdata.tim.now.data.dto.dtu;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class DbcfxOutputDTO implements Serializable {

	private static final long serialVersionUID = 3033771413279379285L;

	@JsonProperty("numeroAggiuntivo")
	private String numeroAggiuntivo;

	@JsonProperty("direzionalita")
	private String direzionalita;

	public String getNumeroAggiuntivo() {
		return numeroAggiuntivo;
	}

	public void setNumeroAggiuntivo(String numeroAggiuntivo) {
		this.numeroAggiuntivo = numeroAggiuntivo;
	}

	public String getDirezionalita() {
		return direzionalita;
	}

	public void setDirezionalita(String direzionalita) {
		this.direzionalita = direzionalita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direzionalita == null) ? 0 : direzionalita.hashCode());
		result = prime * result + ((numeroAggiuntivo == null) ? 0 : numeroAggiuntivo.hashCode());
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
		DbcfxOutputDTO other = (DbcfxOutputDTO) obj;
		if (direzionalita == null) {
			if (other.direzionalita != null)
				return false;
		} else if (!direzionalita.equals(other.direzionalita))
			return false;
		if (numeroAggiuntivo == null) {
			if (other.numeroAggiuntivo != null)
				return false;
		} else if (!numeroAggiuntivo.equals(other.numeroAggiuntivo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DbcfxOutputDTO [numeroAggiuntivo=" + numeroAggiuntivo + ", direzionalita=" + direzionalita + "]";
	}

    
}
