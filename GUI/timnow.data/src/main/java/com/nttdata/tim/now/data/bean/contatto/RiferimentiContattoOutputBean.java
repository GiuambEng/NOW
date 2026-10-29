package com.nttdata.tim.now.data.bean.contatto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class RiferimentiContattoOutputBean extends AbstractOutputBean implements Serializable {
	private static final long serialVersionUID = -2490187531124718972L;

	@JsonProperty("indirizzo")
	private String indirizzo;

	@JsonProperty("numeroCivico")
	private String numeroCivico;

	@JsonProperty("numeroMobl")
	private String numeroMobl;

	@JsonProperty("particellaTopon")
	private String particellaTopon;

	@JsonProperty("prefissoFisso")
	private String prefissoFisso;

	@JsonProperty("prefissoMobl")
	private String prefissoMobl;

	@JsonProperty("prov")
	private String prov;

	@JsonProperty("telfFisso")
	private String telfFisso;

	@JsonProperty("telfFissoAlternativo")
	private String telfFissoAlternativo;

	@JsonProperty("cap")
	private String cap;

	@JsonProperty("cellulareAlternativo")
	private String cellulareAlternativo;

	@JsonProperty("codIstatComune")
	private String codIstatComune;

	@JsonProperty("codIstatIndirizzo")
	private String codIstatIndirizzo;

	@JsonProperty("codIstatProvincia")
	private String codIstatProvincia;

	@JsonProperty("comune")
	private String comune;

	@JsonProperty("email")
	private String email;

	@JsonProperty("fax")
	private String fax;

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getNumeroMobl() {
		return numeroMobl;
	}

	public void setNumeroMobl(String numeroMobl) {
		this.numeroMobl = numeroMobl;
	}

	public String getParticellaTopon() {
		return particellaTopon;
	}

	public void setParticellaTopon(String particellaTopon) {
		this.particellaTopon = particellaTopon;
	}

	public String getPrefissoFisso() {
		return prefissoFisso;
	}

	public void setPrefissoFisso(String prefissoFisso) {
		this.prefissoFisso = prefissoFisso;
	}

	public String getPrefissoMobl() {
		return prefissoMobl;
	}

	public void setPrefissoMobl(String prefissoMobl) {
		this.prefissoMobl = prefissoMobl;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public String getTelfFisso() {
		return telfFisso;
	}

	public void setTelfFisso(String telfFisso) {
		this.telfFisso = telfFisso;
	}

	public String getTelfFissoAlternativo() {
		return telfFissoAlternativo;
	}

	public void setTelfFissoAlternativo(String telfFissoAlternativo) {
		this.telfFissoAlternativo = telfFissoAlternativo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCellulareAlternativo() {
		return cellulareAlternativo;
	}

	public void setCellulareAlternativo(String cellulareAlternativo) {
		this.cellulareAlternativo = cellulareAlternativo;
	}

	public String getCodIstatComune() {
		return codIstatComune;
	}

	public void setCodIstatComune(String codIstatComune) {
		this.codIstatComune = codIstatComune;
	}

	public String getCodIstatIndirizzo() {
		return codIstatIndirizzo;
	}

	public void setCodIstatIndirizzo(String codIstatIndirizzo) {
		this.codIstatIndirizzo = codIstatIndirizzo;
	}

	public String getCodIstatProvincia() {
		return codIstatProvincia;
	}

	public void setCodIstatProvincia(String codIstatProvincia) {
		this.codIstatProvincia = codIstatProvincia;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

}