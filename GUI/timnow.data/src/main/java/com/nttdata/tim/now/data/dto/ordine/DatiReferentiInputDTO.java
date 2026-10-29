package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class DatiReferentiInputDTO implements Serializable {

	private static final long serialVersionUID = 5091209945801157635L;

    @JsonProperty("cognome")
    private String cognome;
    
    //RU_1058
    @JsonProperty("distrettoFisso")
    private String distrettoFisso;
    
    @JsonProperty("cellulare")
    private String cellulare;
	
    @JsonProperty("qualifica")
    private String qualifica;
    
    //RU_915
    @JsonProperty("indirizzo")
    private String indirizzo;
    
    @JsonProperty("nome")
    private String nome;
    
    @JsonProperty("telefonoFisso")
    private String telefonoFisso;
    
    //RU_915
    @JsonProperty("codiceComuneReferente")
    private String codiceComuneReferente;
    
    //RU_915
    @JsonProperty("codiceReferente")
    private String codiceReferente;
       
	@JsonProperty("progressivoReferente")
    private Integer progressivoReferente;
    
    //RU_915
    @JsonProperty("cap")
    private String cap;
    
    //RU_1058
    @JsonProperty("numeroMobile")
    private String numeroMobile;
    
    //RU_1058
    @JsonProperty("numeroFisso")
    private String numeroFisso;
    
    //RU_1084
    @JsonProperty("flagToken")
    private String flagToken;
    
    //RU_915
    @JsonProperty("fax")
    private String fax;

    //RU_820
    @JsonProperty("email")
    private String email;
    
    //RU_1058
    @JsonProperty("distrettoMobile")
    private String distrettoMobile;

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDistrettoFisso() {
		return distrettoFisso;
	}

	public void setDistrettoFisso(String distrettoFisso) {
		this.distrettoFisso = distrettoFisso;
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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefonoFisso() {
		return telefonoFisso;
	}

	public void setTelefonoFisso(String telefonoFisso) {
		this.telefonoFisso = telefonoFisso;
	}

	public String getCodiceComuneReferente() {
		return codiceComuneReferente;
	}

	public void setCodiceComuneReferente(String codiceComuneReferente) {
		this.codiceComuneReferente = codiceComuneReferente;
	}

	public String getCodiceReferente() {
		return codiceReferente;
	}

	public void setCodiceReferente(String codiceReferente) {
		this.codiceReferente = codiceReferente;
	}

	public Integer getProgressivoReferente() {
		return progressivoReferente;
	}

	public void setProgressivoReferente(Integer progressivoReferente) {
		this.progressivoReferente = progressivoReferente;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getNumeroMobile() {
		return numeroMobile;
	}

	public void setNumeroMobile(String numeroMobile) {
		this.numeroMobile = numeroMobile;
	}

	public String getNumeroFisso() {
		return numeroFisso;
	}

	public void setNumeroFisso(String numeroFisso) {
		this.numeroFisso = numeroFisso;
	}

	public String getFlagToken() {
		return flagToken;
	}

	public void setFlagToken(String flagToken) {
		this.flagToken = flagToken;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDistrettoMobile() {
		return distrettoMobile;
	}

	public void setDistrettoMobile(String distrettoMobile) {
		this.distrettoMobile = distrettoMobile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cap == null) ? 0 : cap.hashCode());
		result = prime * result + ((cellulare == null) ? 0 : cellulare.hashCode());
		result = prime * result + ((codiceComuneReferente == null) ? 0 : codiceComuneReferente.hashCode());
		result = prime * result + ((codiceReferente == null) ? 0 : codiceReferente.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((distrettoFisso == null) ? 0 : distrettoFisso.hashCode());
		result = prime * result + ((distrettoMobile == null) ? 0 : distrettoMobile.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((flagToken == null) ? 0 : flagToken.hashCode());
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroFisso == null) ? 0 : numeroFisso.hashCode());
		result = prime * result + ((numeroMobile == null) ? 0 : numeroMobile.hashCode());
		result = prime * result + ((progressivoReferente == null) ? 0 : progressivoReferente.hashCode());
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
		DatiReferentiInputDTO other = (DatiReferentiInputDTO) obj;
		if (cap == null) {
			if (other.cap != null)
				return false;
		} else if (!cap.equals(other.cap))
			return false;
		if (cellulare == null) {
			if (other.cellulare != null)
				return false;
		} else if (!cellulare.equals(other.cellulare))
			return false;
		if (codiceComuneReferente == null) {
			if (other.codiceComuneReferente != null)
				return false;
		} else if (!codiceComuneReferente.equals(other.codiceComuneReferente))
			return false;
		if (codiceReferente == null) {
			if (other.codiceReferente != null)
				return false;
		} else if (!codiceReferente.equals(other.codiceReferente))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
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
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (flagToken == null) {
			if (other.flagToken != null)
				return false;
		} else if (!flagToken.equals(other.flagToken))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
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
		if (progressivoReferente == null) {
			if (other.progressivoReferente != null)
				return false;
		} else if (!progressivoReferente.equals(other.progressivoReferente))
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
		return "DatiReferentiInputDTO [cognome=" + cognome + ", distrettoFisso=" + distrettoFisso + ", cellulare="
				+ cellulare + ", qualifica=" + qualifica + ", indirizzo=" + indirizzo + ", nome=" + nome
				+ ", telefonoFisso=" + telefonoFisso + ", codiceComuneReferente=" + codiceComuneReferente
				+ ", codiceReferente=" + codiceReferente + ", progressivoReferente=" + progressivoReferente + ", cap="
				+ cap + ", numeroMobile=" + numeroMobile + ", numeroFisso=" + numeroFisso + ", flagToken=" + flagToken
				+ ", fax=" + fax + ", email=" + email + ", distrettoMobile=" + distrettoMobile + "]";
	}
    
        
}
