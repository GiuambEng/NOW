package com.nttdata.tim.now.data.bean.monitoring;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RichiestaOloBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -8269403523992367664L;

	@JsonProperty("codiceOrdineOAO")
	protected String codiceOrdineOAO;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataCreazioneRichiesta")
	protected Date dataCreazioneRichiesta;

	@JsonProperty("codificaOAO")
	protected String codificaOAO;

	@JsonProperty("codiceOAO")
	protected String codiceOAO;

	@JsonProperty("ordineTI")
	protected String ordineTI;

	@JsonProperty("idStatoNow")
	protected String idStatoNow;

	@JsonProperty("statoNOW")
	protected String statoNOW;

	@JsonProperty("statoOAO")
	private String statoOAO;

	@JsonProperty("codiceOrdineTI")
	protected String codiceOrdineTI;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dro")
	protected Date dro;

	@JsonProperty("statoOLO")
	protected String statoOLO;

	@JsonProperty("idRisorsa")
	protected String idRisorsa;

	@JsonProperty("idOfferta")
	protected String idOfferta;

	@JsonProperty("offerta")
	protected String offerta;

	@JsonProperty("ambito")
	protected String ambito;

	@JsonProperty("codiceOrdineOLO")
	protected String codiceOrdineOLO;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("DataInvioRichiesta")
	protected Date dataInvioRichiesta;

	@JsonProperty("idRisorsaNow")
	protected String idRisorsaNow;

	@JsonProperty("codOloAgcom")
	protected String codOloAgcom;

	@JsonProperty("codOloNow")
	protected String codOloNow;

	@JsonProperty("codificaOloAgcom")
	protected String codificaOloAgcom;

	@JsonProperty("codificaOloNow")
	protected String codificaOloNow;

    public String getCodiceOrdineOLO() {
        return codiceOrdineOLO;
    }

    public void setCodiceOrdineOLO(String codiceOrdineOLO) {
        this.codiceOrdineOLO = codiceOrdineOLO;
    }

	public String getCodiceOrdineOAO() {
		return codiceOrdineOAO;
	}

	public void setCodiceOrdineOAO(String codiceOrdineOAO) {
		this.codiceOrdineOAO = codiceOrdineOAO;
	}

	public Date getDataCreazioneRichiesta() {
		return dataCreazioneRichiesta;
	}

	public void setDataCreazioneRichiesta(Date dataCreazioneRichiesta) {
		this.dataCreazioneRichiesta = dataCreazioneRichiesta;
	}

	public String getCodificaOAO() {
		return codificaOAO;
	}

	public void setCodificaOAO(String codificaOAO) {
		this.codificaOAO = codificaOAO;
	}

	public String getCodiceOAO() {
		return codiceOAO;
	}

	public void setCodiceOAO(String codiceOAO) {
		this.codiceOAO = codiceOAO;
	}

	public String getOrdineTI() {
		return ordineTI;
	}

	public void setOrdineTI(String ordineTI) {
		this.ordineTI = ordineTI;
	}

	public String getStatoNOW() {
		return statoNOW;
	}

	public void setStatoNOW(String statoNOW) {
		this.statoNOW = statoNOW;
	}

	public String getStatoOAO() {
		return statoOAO;
	}

	public void setStatoOAO(String statoOAO) {
		this.statoOAO = statoOAO;
	}

	public String getCodiceOrdineTI() {
		return codiceOrdineTI;
	}

	public void setCodiceOrdineTI(String codiceOrdineTI) {
		this.codiceOrdineTI = codiceOrdineTI;
	}

	public Date getDro() {
		return dro;
	}

	public void setDro(Date dro) {
		this.dro = dro;
	}

	public String getStatoOLO() {
		return statoOLO;
	}

	public void setStatoOLO(String statoOLO) {
		this.statoOLO = statoOLO;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public Date getDataInvioRichiesta() {
		return dataInvioRichiesta;
	}

	public void setDataInvioRichiesta(Date dataInvioRichiesta) {
		this.dataInvioRichiesta = dataInvioRichiesta;
	}

	public String getIdRisorsaNow() {
		return idRisorsaNow;
	}

	public void setIdRisorsaNow(String idRisorsaNow) {
		this.idRisorsaNow = idRisorsaNow;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getCodOloNow() {
		return codOloNow;
	}

	public void setCodOloNow(String codOloNow) {
		this.codOloNow = codOloNow;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getCodificaOloNow() {
		return codificaOloNow;
	}

	public void setCodificaOloNow(String codificaOloNow) {
		this.codificaOloNow = codificaOloNow;
	}

	public String getIdStatoNow() {
		return idStatoNow;
	}

	public void setIdStatoNow(String idStatoNow) {
		this.idStatoNow = idStatoNow;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	@Override
	public String toString() {
		return "RichiestaOloBean [codiceOrdineOAO=" + codiceOrdineOAO + ", dataCreazioneRichiesta="
				+ dataCreazioneRichiesta + ", codificaOAO=" + codificaOAO + ", codiceOAO=" + codiceOAO + ", ordineTI="
				+ ordineTI + ", idStatoNow=" + idStatoNow + ", statoNOW=" + statoNOW + ", statoOAO=" + statoOAO
				+ ", codiceOrdineTI=" + codiceOrdineTI + ", dro=" + dro + ", statoOLO=" + statoOLO + ", idRisorsa="
				+ idRisorsa + ", idOfferta=" + idOfferta + ", offerta=" + offerta + ", ambito=" + ambito
				+ ", dataInvioRichiesta=" + dataInvioRichiesta + ", idRisorsaNow=" + idRisorsaNow + ", codOloAgcom="
				+ codOloAgcom + ", codOloNow=" + codOloNow + ", codificaOloAgcom=" + codificaOloAgcom
				+ ", codificaOloNow=" + codificaOloNow + "]";
	}

}