package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1188
@JsonInclude(Include.NON_NULL)
public class RaccoltaVlanGbeOutputDTO implements Serializable {

	private static final long serialVersionUID = 5746880358647973454L;

	@JsonProperty("flagmulticos")
    private String flagMulticos;
	
    @JsonProperty("supermacroarea")
    private String superMacroarea;
    
    @JsonProperty("nomearearaccolta")
    private String nomeAreaRaccolta;
    
    @JsonProperty("codicetdkit")
    private String codiceTdKit;
    
    @JsonProperty("vpirete")
    private String vpiRete;
    
    @JsonProperty("tipologiavlan")
    private String tipologiaVlan;
    
    @JsonProperty("nomeclli")
    private String nomeClli;
    
    @JsonProperty("identificativovlanolo")
    private String identificativoVlanOlo;
    
    @JsonProperty("famigliavlan")
    private String famigliaVlan;
    
    @JsonProperty("idvlanrete")
    private String idVlanRete;
    
    @JsonProperty("distanzanodo")
    private String distanzaNodo;
    
    @JsonProperty("profilobmc")
    private String profiloBmc;
    
    @JsonProperty("multicast")
    private String multicast;
    
    @JsonProperty("idrisorsa")
    private String idRisorsa;
    
    @JsonProperty("longdistance")
    private String longDistance;
    
    @JsonProperty("puntoconsegna")
    private String puntoConsegna;
    
    @JsonProperty("identificativocar")
    private String identificativoCar;
    
    @JsonProperty("flagvlantranslation")
    private String flagVlanTranslation;
    
    @JsonProperty("qinqflag")
    private String qinqFlag;
    
    @JsonProperty("nomemacroarea")
    private String nomeMacroarea;
    
    @JsonProperty("codiceclli")
    private String codiceClli;
    
    @JsonProperty("trasporto")
    private String trasporto;
    
    @JsonProperty("tipovlan")
    private String tipoVlan;

	public String getFlagMulticos() {
		return flagMulticos;
	}

	public String getSuperMacroarea() {
		return superMacroarea;
	}

	public String getNomeAreaRaccolta() {
		return nomeAreaRaccolta;
	}

	public String getCodiceTdKit() {
		return codiceTdKit;
	}

	public String getVpiRete() {
		return vpiRete;
	}

	public String getTipologiaVlan() {
		return tipologiaVlan;
	}

	public String getNomeClli() {
		return nomeClli;
	}

	public String getIdentificativoVlanOlo() {
		return identificativoVlanOlo;
	}

	public String getFamigliaVlan() {
		return famigliaVlan;
	}

	public String getIdVlanRete() {
		return idVlanRete;
	}

	public String getDistanzaNodo() {
		return distanzaNodo;
	}

	public String getProfiloBmc() {
		return profiloBmc;
	}

	public String getMulticast() {
		return multicast;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public String getLongDistance() {
		return longDistance;
	}

	public String getPuntoConsegna() {
		return puntoConsegna;
	}

	public String getIdentificativoCar() {
		return identificativoCar;
	}

	public String getFlagVlanTranslation() {
		return flagVlanTranslation;
	}

	public String getQinqFlag() {
		return qinqFlag;
	}

	public String getNomeMacroarea() {
		return nomeMacroarea;
	}

	public String getCodiceClli() {
		return codiceClli;
	}

	public String getTrasporto() {
		return trasporto;
	}

	public String getTipoVlan() {
		return tipoVlan;
	}

	public void setFlagMulticos(String flagMulticos) {
		this.flagMulticos = flagMulticos;
	}

	public void setSuperMacroarea(String superMacroarea) {
		this.superMacroarea = superMacroarea;
	}

	public void setNomeAreaRaccolta(String nomeAreaRaccolta) {
		this.nomeAreaRaccolta = nomeAreaRaccolta;
	}

	public void setCodiceTdKit(String codiceTdKit) {
		this.codiceTdKit = codiceTdKit;
	}

	public void setVpiRete(String vpiRete) {
		this.vpiRete = vpiRete;
	}

	public void setTipologiaVlan(String tipologiaVlan) {
		this.tipologiaVlan = tipologiaVlan;
	}

	public void setNomeClli(String nomeClli) {
		this.nomeClli = nomeClli;
	}

	public void setIdentificativoVlanOlo(String identificativoVlanOlo) {
		this.identificativoVlanOlo = identificativoVlanOlo;
	}

	public void setFamigliaVlan(String famigliaVlan) {
		this.famigliaVlan = famigliaVlan;
	}

	public void setIdVlanRete(String idVlanRete) {
		this.idVlanRete = idVlanRete;
	}

	public void setDistanzaNodo(String distanzaNodo) {
		this.distanzaNodo = distanzaNodo;
	}

	public void setProfiloBmc(String profiloBmc) {
		this.profiloBmc = profiloBmc;
	}

	public void setMulticast(String multicast) {
		this.multicast = multicast;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public void setLongDistance(String longDistance) {
		this.longDistance = longDistance;
	}

	public void setPuntoConsegna(String puntoConsegna) {
		this.puntoConsegna = puntoConsegna;
	}

	public void setIdentificativoCar(String identificativoCar) {
		this.identificativoCar = identificativoCar;
	}

	public void setFlagVlanTranslation(String flagVlanTranslation) {
		this.flagVlanTranslation = flagVlanTranslation;
	}

	public void setQinqFlag(String qinqFlag) {
		this.qinqFlag = qinqFlag;
	}

	public void setNomeMacroarea(String nomeMacroarea) {
		this.nomeMacroarea = nomeMacroarea;
	}

	public void setCodiceClli(String codiceClli) {
		this.codiceClli = codiceClli;
	}

	public void setTrasporto(String trasporto) {
		this.trasporto = trasporto;
	}

	public void setTipoVlan(String tipoVlan) {
		this.tipoVlan = tipoVlan;
	}}
