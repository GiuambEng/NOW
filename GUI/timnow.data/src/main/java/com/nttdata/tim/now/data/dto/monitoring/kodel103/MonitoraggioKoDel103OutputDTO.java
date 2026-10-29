package com.nttdata.tim.now.data.dto.monitoring.kodel103;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//Change Request #42013
@JsonInclude(Include.NON_NULL)
public class MonitoraggioKoDel103OutputDTO implements Serializable {
	
	private static final long serialVersionUID = -2204862043764147874L;

	@JsonProperty("dataCreazioneRichiesta")
	private String dataCreazioneRichiesta;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonProperty("lavorazione")
	private String lavorazione;
	
	@JsonProperty("offerta")
	private String offerta;
	
	@JsonProperty("codiceOrdineOlo")
	private String codiceOrdineOlo;
	
	@JsonProperty("codiceOrdineOloTarget")
	private String codiceOrdineOloTarget;
	
	@JsonProperty("codiceOrdineTiTarget")
	private String codiceOrdineTiTarget;
	
	@JsonProperty("idRisorsa")
	private String idRisorsa;
	
	@JsonProperty("idAnagraficaCausale")
	private String idAnagraficaCausale;
	
	@JsonProperty("descrizioneCausaleInterno")
	private String descrizioneCausaleInterno;
	
	@JsonProperty("statoRichiestaNow")
	private String statoRichiestaNow;
	
	@JsonProperty("tmpacknpd103")
	private String tmpacknpd103;

	@JsonProperty("dac")
	private String dac;
	
	@JsonProperty("contenutoXmlOlo")
	private String contenutoXmlOlo;

	public String getDataCreazioneRichiesta() {
		return dataCreazioneRichiesta;
	}

	public void setDataCreazioneRichiesta(String dataCreazioneRichiesta) {
		this.dataCreazioneRichiesta = dataCreazioneRichiesta;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getCodiceOrdineOlo() {
		return codiceOrdineOlo;
	}

	public void setCodiceOrdineOlo(String codiceOrdineOlo) {
		this.codiceOrdineOlo = codiceOrdineOlo;
	}

	public String getCodiceOrdineOloTarget() {
		return codiceOrdineOloTarget;
	}

	public void setCodiceOrdineOloTarget(String codiceOrdineOloTarget) {
		this.codiceOrdineOloTarget = codiceOrdineOloTarget;
	}

	public String getCodiceOrdineTiTarget() {
		return codiceOrdineTiTarget;
	}

	public void setCodiceOrdineTiTarget(String codiceOrdineTiTarget) {
		this.codiceOrdineTiTarget = codiceOrdineTiTarget;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getIdAnagraficaCausale() {
		return idAnagraficaCausale;
	}

	public void setIdAnagraficaCausale(String idAnagraficaCausale) {
		this.idAnagraficaCausale = idAnagraficaCausale;
	}

	public String getDescrizioneCausaleInterno() {
		return descrizioneCausaleInterno;
	}

	public void setDescrizioneCausaleInterno(String descrizioneCausaleInterno) {
		this.descrizioneCausaleInterno = descrizioneCausaleInterno;
	}

	public String getStatoRichiestaNow() {
		return statoRichiestaNow;
	}

	public void setStatoRichiestaNow(String statoRichiestaNow) {
		this.statoRichiestaNow = statoRichiestaNow;
	}

	public String getTmpacknpd103() {
		return tmpacknpd103;
	}

	public void setTmpacknpd103(String tmpacknpd103) {
		this.tmpacknpd103 = tmpacknpd103;
	}

	public String getDac() {
		return dac;
	}

	public void setDac(String dac) {
		this.dac = dac;
	}

	public String getContenutoXmlOlo() {
		return contenutoXmlOlo;
	}

	public void setContenutoXmlOlo(String contenutoXmlOlo) {
		this.contenutoXmlOlo = contenutoXmlOlo;
	}
}
