package com.nttdata.tim.now.data.bean.ordine.dettaglio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.cliente.ClienteFinaleBean;
import com.nttdata.tim.now.data.bean.referente.ReferenteBean;

@JsonInclude(Include.NON_NULL)
public class DettaglioOrdineOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 795973803520704376L;

	@JsonProperty("ordineTi")
	private String codiceOrdineTI;

	@JsonProperty("codificaOao")
	private String codificaOloAgcom;

	@JsonProperty("codiceOloNow")
	private String codiceOloNow;

	@JsonProperty("idrichiestaolo")
	private String idrichiestaolo;

	@JsonProperty("ordineOlo")
	private String codiceOrdineOLO;

	@JsonProperty("canale")
	private String canaleRichiesta;

	@JsonProperty("statoNow")
	private String statoRichiestaNow;

	@JsonProperty("codiceCausaleNow")
	private String codiceCausaleNow;

	@JsonProperty("causaleOao")
	private String causaleOao;

	@JsonProperty("descrizioneNow")
	private String descrizioneCausaleNow;

	// SM_8952
	@JsonProperty("idRisorsa")
	private String idRisorsa;

	@JsonProperty("codiceOloPadre")
	private String codiceOrdineOloPadre;

	@JsonProperty("codiceOloTarget")
	private String codiceOrdineOloTarget;

	@JsonProperty("dataInvioRichiesta")
	private String dataInvioRichiesta;

	@JsonProperty("dataAggiornamento")
	private String timestampAggiornamento;

	@JsonProperty("dataInserimento")
	private String timestampInserimento;

	@JsonProperty("Naked")
	private boolean flagNaked;

	@JsonProperty("tipoRichiesta")
	private String tipoRichiesta;

	@JsonProperty("statoRichiestaOlo")
	private String statoRichiestaOlo;

	@JsonProperty("note")
	private String note;

	@JsonProperty("oao")
	private String oao;

	@JsonProperty("codiceCausaleOao")
	private String codiceCausaleOao;

	@JsonProperty("codiceProgetto")
	private String codiceProgetto;

	@JsonProperty("lavorazioneRichiesta")
	private String lavorazioneRichiesta;

	@JsonProperty("testMode")
	private String testMode;

	@JsonProperty("dro")
	private String dro;

	@JsonProperty("dac")
	private String dac;

	@JsonProperty("des")
	private String des;

	// RU_749
	@JsonProperty("descrizioneScenario")
	private String descrizioneScenario;

	@JsonProperty("richiesta")
	private RichiestaOutputBean richiesta;

	@JsonProperty("cliente")
	private ClienteFinaleBean cliente;

	@JsonProperty("servizi")
	private List<ServizioBean> servizi;

	@JsonProperty("referenti")
	private List<ReferenteBean> referenti;

	@JsonProperty("orderDetails")
	private DettagliDettaglioOrdineBean orderDetails;

	@JsonProperty("orderCodeTi")
	private List<CodiceOrdineTiBean> orderCodeTi;

	@JsonProperty("attributes")
	private List<AttributoDettaglioOrdineBean> attributes;

	@JsonProperty("oaoDonating")
	private String oaoDonating;

	@JsonProperty("oaoDonor")
	private String oaoDonor;

	@JsonProperty("richiestaXml")
	private String richiestaXml;

	@JsonProperty("idOfferta")
	private String idOfferta;

	// RU_752
	@JsonProperty("numeroTelefonicoAggiuntivo")
	private List<String> numeroTelefonicoAggiuntivo;

	// RU_918
	@JsonProperty("cambioTecnologia")
	private List<CambioTecnologiaBean> cambioTecnologia;

	// SM_8952
	@JsonProperty("idRisorsaNow")
	private String idRisorsaNow;

	// SM_9277
	@JsonProperty("disaggregato")
	private String disaggregato;

	// SM_9277
	@JsonProperty("exDisaggregato")
	private String exDisaggregato;

	// R1E-21-0325
	@JsonProperty("ordineAssetWhiteList")
	private String ordineAssetWhiteList;

	// SM_10493
	@JsonProperty("refOaoProgettiSpeciali")
	private String refOaoProgettiSpeciali;

	// RU_1492
	@JsonProperty("idRisorsaOF")
	private String idRisorsaOF;

	@JsonProperty("codiceOrdineOF")
	private String codiceOrdineOF;

	@JsonProperty("statoOF")
	private String statoOF;

	@JsonProperty("noteOF")
	private String noteOF;

	@JsonProperty("flagAbilitazioneGuiManualOF")
	private String flagAbilitazioneGuiManualOF;

	// RU_1525
	@JsonProperty("caratterizzazioneArea")
	private String caratterizzazioneArea;

	public List<CambioTecnologiaBean> getCambioTecnologia() {
		return cambioTecnologia;
	}

	public void setCambioTecnologia(List<CambioTecnologiaBean> cambioTecnologia) {
		this.cambioTecnologia = cambioTecnologia;
	}

	public String getCodiceOrdineTI() {
		return codiceOrdineTI;
	}

	public void setCodiceOrdineTI(String codiceOrdineTI) {
		this.codiceOrdineTI = codiceOrdineTI;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getCodiceOloNow() {
		return codiceOloNow;
	}

	public void setCodiceOloNow(String codiceOloNow) {
		this.codiceOloNow = codiceOloNow;
	}

	public String getIdrichiestaolo() {
		return idrichiestaolo;
	}

	public void setIdrichiestaolo(String idrichiestaolo) {
		this.idrichiestaolo = idrichiestaolo;
	}

	public String getCodiceOrdineOLO() {
		return codiceOrdineOLO;
	}

	public void setCodiceOrdineOLO(String codiceOrdineOLO) {
		this.codiceOrdineOLO = codiceOrdineOLO;
	}

	public String getCanaleRichiesta() {
		return canaleRichiesta;
	}

	public void setCanaleRichiesta(String canaleRichiesta) {
		this.canaleRichiesta = canaleRichiesta;
	}

	public String getStatoRichiestaNow() {
		return statoRichiestaNow;
	}

	public void setStatoRichiestaNow(String statoRichiestaNow) {
		this.statoRichiestaNow = statoRichiestaNow;
	}

	public String getCodiceCausaleNow() {
		return codiceCausaleNow;
	}

	public void setCodiceCausaleNow(String codiceCausaleNow) {
		this.codiceCausaleNow = codiceCausaleNow;
	}

	public String getCausaleOao() {
		return causaleOao;
	}

	public void setCausaleOao(String causaleOao) {
		this.causaleOao = causaleOao;
	}

	public String getDescrizioneCausaleNow() {
		return descrizioneCausaleNow;
	}

	public void setDescrizioneCausaleNow(String descrizioneCausaleNow) {
		this.descrizioneCausaleNow = descrizioneCausaleNow;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getCodiceOrdineOloPadre() {
		return codiceOrdineOloPadre;
	}

	public void setCodiceOrdineOloPadre(String codiceOrdineOloPadre) {
		this.codiceOrdineOloPadre = codiceOrdineOloPadre;
	}

	public String getCodiceOrdineOloTarget() {
		return codiceOrdineOloTarget;
	}

	public void setCodiceOrdineOloTarget(String codiceOrdineOloTarget) {
		this.codiceOrdineOloTarget = codiceOrdineOloTarget;
	}

	public String getDataInvioRichiesta() {
		return dataInvioRichiesta;
	}

	public void setDataInvioRichiesta(String dataInvioRichiesta) {
		this.dataInvioRichiesta = dataInvioRichiesta;
	}

	public String getTimestampAggiornamento() {
		return timestampAggiornamento;
	}

	public void setTimestampAggiornamento(String timestampAggiornamento) {
		this.timestampAggiornamento = timestampAggiornamento;
	}

	public String getTimestampInserimento() {
		return timestampInserimento;
	}

	public void setTimestampInserimento(String timestampInserimento) {
		this.timestampInserimento = timestampInserimento;
	}

	public boolean isFlagNaked() {
		return flagNaked;
	}

	public void setFlagNaked(boolean flagNaked) {
		this.flagNaked = flagNaked;
	}

	public String getTipoRichiesta() {
		return tipoRichiesta;
	}

	public void setTipoRichiesta(String tipoRichiesta) {
		this.tipoRichiesta = tipoRichiesta;
	}

	public String getStatoRichiestaOlo() {
		return statoRichiestaOlo;
	}

	public void setStatoRichiestaOlo(String statoRichiestaOlo) {
		this.statoRichiestaOlo = statoRichiestaOlo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOao() {
		return oao;
	}

	public void setOao(String oao) {
		this.oao = oao;
	}

	public String getCodiceCausaleOao() {
		return codiceCausaleOao;
	}

	public void setCodiceCausaleOao(String codiceCausaleOao) {
		this.codiceCausaleOao = codiceCausaleOao;
	}

	public String getCodiceProgetto() {
		return codiceProgetto;
	}

	public void setCodiceProgetto(String codiceProgetto) {
		this.codiceProgetto = codiceProgetto;
	}

	public String getLavorazioneRichiesta() {
		return lavorazioneRichiesta;
	}

	public void setLavorazioneRichiesta(String lavorazioneRichiesta) {
		this.lavorazioneRichiesta = lavorazioneRichiesta;
	}

	public String getTestMode() {
		return testMode;
	}

	public void setTestMode(String testMode) {
		this.testMode = testMode;
	}

	public String getDro() {
		return dro;
	}

	public void setDro(String dro) {
		this.dro = dro;
	}

	public String getDac() {
		return dac;
	}

	public void setDac(String dac) {
		this.dac = dac;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	// RU_749
	public String getDescrizioneScenario() {
		return descrizioneScenario;
	}

	public void setDescrizioneScenario(String descrizioneScenario) {
		this.descrizioneScenario = descrizioneScenario;
	}

	public RichiestaOutputBean getRichiesta() {
		return richiesta;
	}

	public void setRichiesta(RichiestaOutputBean richiesta) {
		this.richiesta = richiesta;
	}

	public ClienteFinaleBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteFinaleBean cliente) {
		this.cliente = cliente;
	}

	public List<ServizioBean> getServizi() {
		return servizi;
	}

	public void setServizi(List<ServizioBean> servizi) {
		this.servizi = servizi;
	}

	public List<ReferenteBean> getReferenti() {
		return referenti;
	}

	public void setReferenti(List<ReferenteBean> referenti) {
		this.referenti = referenti;
	}

	public DettagliDettaglioOrdineBean getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(DettagliDettaglioOrdineBean orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<CodiceOrdineTiBean> getOrderCodeTi() {
		return orderCodeTi;
	}

	public void setOrderCodeTi(List<CodiceOrdineTiBean> orderCodeTi) {
		this.orderCodeTi = orderCodeTi;
	}

	public List<AttributoDettaglioOrdineBean> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AttributoDettaglioOrdineBean> attributes) {
		this.attributes = attributes;
	}

	public String getOaoDonating() {
		return oaoDonating;
	}

	public void setOaoDonating(String oaoDonating) {
		this.oaoDonating = oaoDonating;
	}

	public String getOaoDonor() {
		return oaoDonor;
	}

	public void setOaoDonor(String oaoDonor) {
		this.oaoDonor = oaoDonor;
	}

	public String getRichiestaXml() {
		return richiestaXml;
	}

	public void setRichiestaXml(String richiestaXml) {
		this.richiestaXml = richiestaXml;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	// RU_752
	public List<String> getNumeroTelefonicoAggiuntivo() {
		return numeroTelefonicoAggiuntivo;
	}

	public void setNumeroTelefonicoAggiuntivo(List<String> numeroTelefonicoAggiuntivo) {
		this.numeroTelefonicoAggiuntivo = numeroTelefonicoAggiuntivo;
	}

	public String getIdRisorsaNow() {
		return idRisorsaNow;
	}

	public void setIdRisorsaNow(String idRisorsaNow) {
		this.idRisorsaNow = idRisorsaNow;
	}

	public String getDisaggregato() {
		return disaggregato;
	}

	public String getExDisaggregato() {
		return exDisaggregato;
	}

	public void setDisaggregato(String disaggregato) {
		this.disaggregato = disaggregato;
	}

	public void setExDisaggregato(String exDisaggregato) {
		this.exDisaggregato = exDisaggregato;
	}

	public String getOrdineAssetWhiteList() {
		return ordineAssetWhiteList;
	}

	public void setOrdineAssetWhiteList(String ordineAssetWhiteList) {
		this.ordineAssetWhiteList = ordineAssetWhiteList;
	}

	public String getRefOaoProgettiSpeciali() {
		return refOaoProgettiSpeciali;
	}

	public void setRefOaoProgettiSpeciali(String refOaoProgettiSpeciali) {
		this.refOaoProgettiSpeciali = refOaoProgettiSpeciali;
	}

	public String getIdRisorsaOF() {
		return idRisorsaOF;
	}

	public void setIdRisorsaOF(String idRisorsaOF) {
		this.idRisorsaOF = idRisorsaOF;
	}

	public String getCodiceOrdineOF() {
		return codiceOrdineOF;
	}

	public void setCodiceOrdineOF(String codiceOrdineOF) {
		this.codiceOrdineOF = codiceOrdineOF;
	}

	public String getStatoOF() {
		return statoOF;
	}

	public void setStatoOF(String statoOF) {
		this.statoOF = statoOF;
	}

	public String getNoteOF() {
		return noteOF;
	}

	public void setNoteOF(String noteOF) {
		this.noteOF = noteOF;
	}

	public String getFlagAbilitazioneGuiManualOF() {
		return flagAbilitazioneGuiManualOF;
	}

	public void setFlagAbilitazioneGuiManualOF(String flagAbilitazioneGuiManualOF) {
		this.flagAbilitazioneGuiManualOF = flagAbilitazioneGuiManualOF;
	}

	public String getCaratterizzazioneArea() {
		return caratterizzazioneArea;
	}

	public void setCaratterizzazioneArea(String caratterizzazioneArea) {
		this.caratterizzazioneArea = caratterizzazioneArea;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attributes, cambioTecnologia, canaleRichiesta, causaleOao, cliente, codiceCausaleNow,
				codiceCausaleOao, codiceOloNow, codiceOrdineOF, codiceOrdineOLO, codiceOrdineOloPadre,
				codiceOrdineOloTarget, codiceOrdineTI, codiceProgetto, codificaOloAgcom, dac, dataInvioRichiesta, des,
				descrizioneCausaleNow, descrizioneScenario, disaggregato, dro, exDisaggregato, flagNaked, idOfferta,
				idRisorsa, idRisorsaNow, idRisorsaOF, idrichiestaolo, lavorazioneRichiesta, note, noteOF,
				numeroTelefonicoAggiuntivo, oao, oaoDonating, oaoDonor, orderCodeTi, orderDetails, ordineAssetWhiteList,
				refOaoProgettiSpeciali, referenti, richiesta, richiestaXml, servizi, statoOF, statoRichiestaNow,
				statoRichiestaOlo, testMode, timestampAggiornamento, timestampInserimento, tipoRichiesta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DettaglioOrdineOutputBean other = (DettaglioOrdineOutputBean) obj;
		return Objects.equals(attributes, other.attributes) && Objects.equals(cambioTecnologia, other.cambioTecnologia)
				&& Objects.equals(canaleRichiesta, other.canaleRichiesta)
				&& Objects.equals(causaleOao, other.causaleOao) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(codiceCausaleNow, other.codiceCausaleNow)
				&& Objects.equals(codiceCausaleOao, other.codiceCausaleOao)
				&& Objects.equals(codiceOloNow, other.codiceOloNow)
				&& Objects.equals(codiceOrdineOF, other.codiceOrdineOF)
				&& Objects.equals(codiceOrdineOLO, other.codiceOrdineOLO)
				&& Objects.equals(codiceOrdineOloPadre, other.codiceOrdineOloPadre)
				&& Objects.equals(codiceOrdineOloTarget, other.codiceOrdineOloTarget)
				&& Objects.equals(codiceOrdineTI, other.codiceOrdineTI)
				&& Objects.equals(codiceProgetto, other.codiceProgetto)
				&& Objects.equals(codificaOloAgcom, other.codificaOloAgcom) && Objects.equals(dac, other.dac)
				&& Objects.equals(dataInvioRichiesta, other.dataInvioRichiesta) && Objects.equals(des, other.des)
				&& Objects.equals(descrizioneCausaleNow, other.descrizioneCausaleNow)
				&& Objects.equals(descrizioneScenario, other.descrizioneScenario)
				&& Objects.equals(disaggregato, other.disaggregato) && Objects.equals(dro, other.dro)
				&& Objects.equals(exDisaggregato, other.exDisaggregato) && flagNaked == other.flagNaked
				&& Objects.equals(idOfferta, other.idOfferta) && Objects.equals(idRisorsa, other.idRisorsa)
				&& Objects.equals(idRisorsaNow, other.idRisorsaNow) && Objects.equals(idRisorsaOF, other.idRisorsaOF)
				&& Objects.equals(idrichiestaolo, other.idrichiestaolo)
				&& Objects.equals(lavorazioneRichiesta, other.lavorazioneRichiesta) && Objects.equals(note, other.note)
				&& Objects.equals(noteOF, other.noteOF)
				&& Objects.equals(numeroTelefonicoAggiuntivo, other.numeroTelefonicoAggiuntivo)
				&& Objects.equals(oao, other.oao) && Objects.equals(oaoDonating, other.oaoDonating)
				&& Objects.equals(oaoDonor, other.oaoDonor) && Objects.equals(orderCodeTi, other.orderCodeTi)
				&& Objects.equals(orderDetails, other.orderDetails)
				&& Objects.equals(ordineAssetWhiteList, other.ordineAssetWhiteList)
				&& Objects.equals(refOaoProgettiSpeciali, other.refOaoProgettiSpeciali)
				&& Objects.equals(referenti, other.referenti) && Objects.equals(richiesta, other.richiesta)
				&& Objects.equals(richiestaXml, other.richiestaXml) && Objects.equals(servizi, other.servizi)
				&& Objects.equals(statoOF, other.statoOF) && Objects.equals(statoRichiestaNow, other.statoRichiestaNow)
				&& Objects.equals(statoRichiestaOlo, other.statoRichiestaOlo)
				&& Objects.equals(testMode, other.testMode)
				&& Objects.equals(timestampAggiornamento, other.timestampAggiornamento)
				&& Objects.equals(timestampInserimento, other.timestampInserimento)
				&& Objects.equals(tipoRichiesta, other.tipoRichiesta);
	}

	@Override
	public String toString() {
		return "DettaglioOrdineOutputBean [codiceOrdineTI=" + codiceOrdineTI + ", codificaOloAgcom=" + codificaOloAgcom
				+ ", codiceOloNow=" + codiceOloNow + ", idrichiestaolo=" + idrichiestaolo + ", codiceOrdineOLO="
				+ codiceOrdineOLO + ", canaleRichiesta=" + canaleRichiesta + ", statoRichiestaNow=" + statoRichiestaNow
				+ ", codiceCausaleNow=" + codiceCausaleNow + ", causaleOao=" + causaleOao + ", descrizioneCausaleNow="
				+ descrizioneCausaleNow + ", idRisorsa=" + idRisorsa + ", codiceOrdineOloPadre=" + codiceOrdineOloPadre
				+ ", codiceOrdineOloTarget=" + codiceOrdineOloTarget + ", dataInvioRichiesta=" + dataInvioRichiesta
				+ ", timestampAggiornamento=" + timestampAggiornamento + ", timestampInserimento="
				+ timestampInserimento + ", flagNaked=" + flagNaked + ", tipoRichiesta=" + tipoRichiesta
				+ ", statoRichiestaOlo=" + statoRichiestaOlo + ", note=" + note + ", oao=" + oao + ", codiceCausaleOao="
				+ codiceCausaleOao + ", codiceProgetto=" + codiceProgetto + ", lavorazioneRichiesta="
				+ lavorazioneRichiesta + ", testMode=" + testMode + ", dro=" + dro + ", dac=" + dac + ", des=" + des
				+ ", descrizioneScenario=" + descrizioneScenario + ", richiesta=" + richiesta + ", cliente=" + cliente
				+ ", servizi=" + servizi + ", referenti=" + referenti + ", orderDetails=" + orderDetails
				+ ", orderCodeTi=" + orderCodeTi + ", attributes=" + attributes + ", oaoDonating=" + oaoDonating
				+ ", oaoDonor=" + oaoDonor + ", richiestaXml=" + richiestaXml + ", idOfferta=" + idOfferta
				+ ", numeroTelefonicoAggiuntivo=" + numeroTelefonicoAggiuntivo + ", cambioTecnologia="
				+ cambioTecnologia + ", idRisorsaNow=" + idRisorsaNow + ", disaggregato=" + disaggregato
				+ ", exDisaggregato=" + exDisaggregato + ", ordineAssetWhiteList=" + ordineAssetWhiteList
				+ ", refOaoProgettiSpeciali=" + refOaoProgettiSpeciali + ", idRisorsaOF=" + idRisorsaOF
				+ ", codiceOrdineOF=" + codiceOrdineOF + ", statoOF=" + statoOF + ", noteOF=" + noteOF + "]";
	}

}