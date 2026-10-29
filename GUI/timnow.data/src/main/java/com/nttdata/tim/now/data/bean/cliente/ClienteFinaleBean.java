package com.nttdata.tim.now.data.bean.cliente;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class ClienteFinaleBean extends AbstractOutputBean implements Serializable {
	private static final long serialVersionUID = 5509853274010206014L;

	@JsonProperty("ragioneSociale")
	private String cognomeRagioneSociale;

	@JsonProperty("codFiscale")
	private String cf;

	@JsonProperty("partitaIva")
	private String piva;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("sedeClienteFinale")
	private List<SedeClienteFinaleBean> sedeClienteFinale;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognomeRagioneSociale() {
		return cognomeRagioneSociale;
	}

	public void setCognomeRagioneSociale(String cognomeRagioneSociale) {
		this.cognomeRagioneSociale = cognomeRagioneSociale;
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

	public List<SedeClienteFinaleBean> getSedeClienteFinale() {
		return sedeClienteFinale;
	}

	public void setSedeClienteFinale(List<SedeClienteFinaleBean> sedeClienteFinale) {
		this.sedeClienteFinale = sedeClienteFinale;
	}

	@Override
	public String toString() {
		return "ClienteFinaleBean [cognomeRagioneSociale=" + cognomeRagioneSociale + ", cf=" + cf + ", piva=" + piva
				+ ", nome=" + nome + ", sedeClienteFinale=" + sedeClienteFinale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cf == null) ? 0 : cf.hashCode());
		result = prime * result + ((cognomeRagioneSociale == null) ? 0 : cognomeRagioneSociale.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((piva == null) ? 0 : piva.hashCode());
		result = prime * result + ((sedeClienteFinale == null) ? 0 : sedeClienteFinale.hashCode());
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
		ClienteFinaleBean other = (ClienteFinaleBean) obj;
		if (cf == null) {
			if (other.cf != null)
				return false;
		} else if (!cf.equals(other.cf))
			return false;
		if (cognomeRagioneSociale == null) {
			if (other.cognomeRagioneSociale != null)
				return false;
		} else if (!cognomeRagioneSociale.equals(other.cognomeRagioneSociale))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (piva == null) {
			if (other.piva != null)
				return false;
		} else if (!piva.equals(other.piva))
			return false;
		if (sedeClienteFinale == null) {
			if (other.sedeClienteFinale != null)
				return false;
		} else if (!sedeClienteFinale.equals(other.sedeClienteFinale))
			return false;
		return true;
	}

}