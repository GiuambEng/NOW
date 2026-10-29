package com.nttdata.tim.now.data.dto.radius;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class RadiusOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -8165252953049425893L;

    @JsonProperty("codiceISP")
	private String codiceISP;
    
    @JsonProperty("ordineOneStep")
	private String ordineOneStep;
    
    @JsonProperty("lavorazione")
	private String lavorazione;
    
    @JsonProperty("tecnologia")
	private String tecnologia;
    
    @JsonProperty("gestioneRadius")
	private String gestioneRadius;
    
    @JsonProperty("fornitoreRadius")
	private String fornitoreRadius;
    
    @JsonProperty("ownership")
	private String ownership;
    
    @JsonProperty("sopensioneOrdine")
	private String sopensioneOrdine;
    
    @JsonProperty("cluster")
	private String cluster;
    
    @JsonProperty("descrizioneCluster")
	private String descrizioneCluster;
    
    @JsonProperty("dnsParentalControl")
	private String dnsParentalControl;
    
    @JsonProperty("realm")
	private String realm;
    
    @JsonProperty("piattaformaO2O")
	private String piattaformaO2O;

	public String getCodiceISP() {
		return codiceISP;
	}

	public void setCodiceISP(String codiceISP) {
		this.codiceISP = codiceISP;
	}

	public String getOrdineOneStep() {
		return ordineOneStep;
	}

	public void setOrdineOneStep(String ordineOneStep) {
		this.ordineOneStep = ordineOneStep;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getGestioneRadius() {
		return gestioneRadius;
	}

	public void setGestioneRadius(String gestioneRadius) {
		this.gestioneRadius = gestioneRadius;
	}

	public String getFornitoreRadius() {
		return fornitoreRadius;
	}

	public void setFornitoreRadius(String fornitoreRadius) {
		this.fornitoreRadius = fornitoreRadius;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getSopensioneOrdine() {
		return sopensioneOrdine;
	}

	public void setSopensioneOrdine(String sopensioneOrdine) {
		this.sopensioneOrdine = sopensioneOrdine;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getDescrizioneCluster() {
		return descrizioneCluster;
	}

	public void setDescrizioneCluster(String descrizioneCluster) {
		this.descrizioneCluster = descrizioneCluster;
	}
	
	public String getDnsParentalControl() {
		return dnsParentalControl;
	}

	public void setDnsParentalControl(String dnsParentalControl) {
		this.dnsParentalControl = dnsParentalControl;
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}
	
	@JsonProperty("piattaformaO2O")
	public String getPiattaformaO2O() {
		return piattaformaO2O;
	}

	@JsonProperty("piattaformaO2O")
	public void setPiattaformaO2O(String piattaformaO2O) {
		this.piattaformaO2O = piattaformaO2O;
	}
 
}