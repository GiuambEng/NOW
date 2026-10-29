package com.nttdata.tim.now.data.dto.referente;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class ReferenteDTO implements Serializable {

	private static final long serialVersionUID = 1329313234821071294L;

	@JsonProperty("Nome")
	private String nome;

	@JsonProperty("Cognome")
	private String cognome;

	@JsonProperty("Telefono")
	private String telefonoFisso;

	@JsonProperty("Cellulare")
	private String cellulare;

	@JsonProperty("Qualifica")
	private String qualifica;

	@JsonProperty("progressivo")
	private String progressivo;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataUltimoAggiornamento")
	private Date dataUltimoAggiornamento;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInserimento")
	private Date dataInserimento;

    @JsonProperty("onfield")
	private String onfield;

	@JsonProperty("email")
	private String email;
	
	//RU_1058
	@JsonProperty("DistrettoFisso")
	private String distrettoFisso;
	
	@JsonProperty("NumeroFisso")
	private String numeroFisso;
	
	@JsonProperty("DistrettoMobile")
	private String distrettoMobile;
	
	@JsonProperty("NumeroMobile")
	private String numeroMobile;

	public String getOnfield() {
		return onfield;
	}

	public void setOnfield(String onfield) {
		this.onfield = onfield;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefonoFisso() {
		return telefonoFisso;
	}

	public void setTelefonoFisso(String telefonoFisso) {
		this.telefonoFisso = telefonoFisso;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getQualifica() {
		return qualifica;
	}

	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}

	public String getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(String progressivo) {
		this.progressivo = progressivo;
	}

	public Date getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}

	public void setDataUltimoAggiornamento(Date dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDistrettoFisso() {
		return distrettoFisso;
	}

	public void setDistrettoFisso(String distrettoFisso) {
		this.distrettoFisso = distrettoFisso;
	}

	public String getNumeroFisso() {
		return numeroFisso;
	}

	public void setNumeroFisso(String numeroFisso) {
		this.numeroFisso = numeroFisso;
	}

	public String getDistrettoMobile() {
		return distrettoMobile;
	}

	public void setDistrettoMobile(String distrettoMobile) {
		this.distrettoMobile = distrettoMobile;
	}

	public String getNumeroMobile() {
		return numeroMobile;
	}

	public void setNumeroMobile(String numeroMobile) {
		this.numeroMobile = numeroMobile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellulare == null) ? 0 : cellulare.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataInserimento == null) ? 0 : dataInserimento.hashCode());
		result = prime * result + ((dataUltimoAggiornamento == null) ? 0 : dataUltimoAggiornamento.hashCode());
		result = prime * result + ((distrettoFisso == null) ? 0 : distrettoFisso.hashCode());
		result = prime * result + ((distrettoMobile == null) ? 0 : distrettoMobile.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroFisso == null) ? 0 : numeroFisso.hashCode());
		result = prime * result + ((numeroMobile == null) ? 0 : numeroMobile.hashCode());
		result = prime * result + ((onfield == null) ? 0 : onfield.hashCode());
		result = prime * result + ((progressivo == null) ? 0 : progressivo.hashCode());
		result = prime * result + ((qualifica == null) ? 0 : qualifica.hashCode());
		result = prime * result + ((telefonoFisso == null) ? 0 : telefonoFisso.hashCode());
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
		ReferenteDTO other = (ReferenteDTO) obj;
		if (cellulare == null) {
			if (other.cellulare != null)
				return false;
		} else if (!cellulare.equals(other.cellulare))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataInserimento == null) {
			if (other.dataInserimento != null)
				return false;
		} else if (!dataInserimento.equals(other.dataInserimento))
			return false;
		if (dataUltimoAggiornamento == null) {
			if (other.dataUltimoAggiornamento != null)
				return false;
		} else if (!dataUltimoAggiornamento.equals(other.dataUltimoAggiornamento))
			return false;
		if (distrettoFisso == null) {
			if (other.distrettoFisso != null)
				return false;
		} else if (!distrettoFisso.equals(other.distrettoFisso))
			return false;
		if (distrettoMobile == null) {
			if (other.distrettoMobile != null)
				return false;
		} else if (!distrettoMobile.equals(other.distrettoMobile))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroFisso == null) {
			if (other.numeroFisso != null)
				return false;
		} else if (!numeroFisso.equals(other.numeroFisso))
			return false;
		if (numeroMobile == null) {
			if (other.numeroMobile != null)
				return false;
		} else if (!numeroMobile.equals(other.numeroMobile))
			return false;
		if (onfield == null) {
			if (other.onfield != null)
				return false;
		} else if (!onfield.equals(other.onfield))
			return false;
		if (progressivo == null) {
			if (other.progressivo != null)
				return false;
		} else if (!progressivo.equals(other.progressivo))
			return false;
		if (qualifica == null) {
			if (other.qualifica != null)
				return false;
		} else if (!qualifica.equals(other.qualifica))
			return false;
		if (telefonoFisso == null) {
			if (other.telefonoFisso != null)
				return false;
		} else if (!telefonoFisso.equals(other.telefonoFisso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReferenteDTO [nome=" + nome + ", cognome=" + cognome + ", telefonoFisso=" + telefonoFisso
				+ ", cellulare=" + cellulare + ", qualifica=" + qualifica + ", progressivo=" + progressivo
				+ ", dataUltimoAggiornamento=" + dataUltimoAggiornamento + ", dataInserimento=" + dataInserimento
				+ ", onfield=" + onfield + ", email=" + email + ", distrettoFisso=" + distrettoFisso + ", numeroFisso="
				+ numeroFisso + ", distrettoMobile=" + distrettoMobile + ", numeroMobile=" + numeroMobile + "]";
	}

	

}
