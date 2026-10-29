package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1188
@JsonInclude(Include.NON_NULL)
public class RaccoltaVlanNgaOutputBean implements Serializable {

	private static final long serialVersionUID = -8816313613959902661L;

	@JsonProperty("flagmulticos")
	private String flagMulticos;

	@JsonProperty("ftthonly")
	private String ftthOnly;

	@JsonProperty("supermacroarea")
	private String superMacroarea;

	@JsonProperty("nomearearaccolta")
	private String nomeAreaRaccolta;

	@JsonProperty("nomemacroareacomm")
	private String nomeMacroareaComm;

	@JsonProperty("codicetdkit")
	private String codiceTdKit;

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

	@JsonProperty("idrisorsa")
	private String idRisorsa;

	@JsonProperty("bmclight")
	private String bmcLight;

	@JsonProperty("puntoconsegna")
	private String puntoConsegna;

	@JsonProperty("identificativocar")
	private String identificativoCar;

	@JsonProperty("flagvlantranslation")
	private String flagVlanTranslation;

	@JsonProperty("qinqflag")
	private String qinqFlag;

	@JsonProperty("tipologiaclustervlan")
	private String tipologiaClusterVlan;

	@JsonProperty("nomemacroarea")
	private String nomeMacroarea;

	@JsonProperty("codiceclli")
	private String codiceClli;

	@JsonProperty("trasporto")
	private String trasporto;

	@JsonProperty("tipovlan")
	private String tipoVlan;

	// SM_11475
	@JsonProperty("caratteristicaVlan")
	private String caratteristicaVlan;

	public String getFlagMulticos() {
		return flagMulticos;
	}

	public String getFtthOnly() {
		return ftthOnly;
	}

	public String getSuperMacroarea() {
		return superMacroarea;
	}

	public String getNomeAreaRaccolta() {
		return nomeAreaRaccolta;
	}

	public String getNomeMacroareaComm() {
		return nomeMacroareaComm;
	}

	public String getCodiceTdKit() {
		return codiceTdKit;
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

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public String getBmcLight() {
		return bmcLight;
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

	public String getTipologiaClusterVlan() {
		return tipologiaClusterVlan;
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

	public void setFtthOnly(String ftthOnly) {
		this.ftthOnly = ftthOnly;
	}

	public void setSuperMacroarea(String superMacroarea) {
		this.superMacroarea = superMacroarea;
	}

	public void setNomeAreaRaccolta(String nomeAreaRaccolta) {
		this.nomeAreaRaccolta = nomeAreaRaccolta;
	}

	public void setNomeMacroareaComm(String nomeMacroareaComm) {
		this.nomeMacroareaComm = nomeMacroareaComm;
	}

	public void setCodiceTdKit(String codiceTdKit) {
		this.codiceTdKit = codiceTdKit;
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

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public void setBmcLight(String bmcLight) {
		this.bmcLight = bmcLight;
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

	public void setTipologiaClusterVlan(String tipologiaClusterVlan) {
		this.tipologiaClusterVlan = tipologiaClusterVlan;
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
	}

	public String getCaratteristicaVlan() {
		return caratteristicaVlan;
	}

	public void setCaratteristicaVlan(String caratteristicaVlan) {
		this.caratteristicaVlan = caratteristicaVlan;
	}

}
