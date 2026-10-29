package com.nttdata.tim.now.data.dto.ordine.dettaglio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.cliente.ClienteFinaleDTO;
import com.nttdata.tim.now.data.dto.ordine.code.CodiceOrdineTiDTO;
import com.nttdata.tim.now.data.dto.referente.ReferenteDTO;

@JsonInclude(Include.NON_NULL)
public class DettaglioOrdineOutputDTO implements Serializable {

	private static final long serialVersionUID = 6364134502982215458L;

	@JsonProperty("codiceOrdineTI")
	private String codiceOrdineTI;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonProperty("codiceOloNow")
	private String codiceOloNow;

	@JsonProperty("idrichiestaolo")
	private String idrichiestaolo;

	@JsonProperty("codiceOrdineOLO")
	private String codiceOrdineOLO;

	@JsonProperty("canaleRichiesta")
	private String canaleRichiesta;

	@JsonProperty("tipoRichiesta")
	private String tipoRichiesta;

	@JsonProperty("statoRichiestaNow")
	private String statoRichiestaNow;

	@JsonProperty("statoRichiestaOlo")
	private String statoRichiestaOlo;

	@JsonProperty("note")
	private String note;

	@JsonProperty("oao")
	private String oao;

	@JsonProperty("codiceCausaleNow")
	private String codiceCausaleNow;

	@JsonProperty("codiceCausaleOao")
	private String codiceCausaleOao;

	@JsonProperty("causaleOao")
	private String causaleOao;

	@JsonProperty("descrizioneCausaleNow")
	private String descrizioneCausaleNow;

	@JsonProperty("idRisorsa")
	private String idRisorsa;

	@JsonProperty("codiceOrdineOloPadre")
	private String codiceOrdineOloPadre;

	@JsonProperty("codiceOrdineOloTarget")
	private String codiceOrdineOloTarget;

	@JsonProperty("codiceProgetto")
	private String codiceProgetto;

	@JsonProperty("lavorazioneRichiesta")
	private String lavorazioneRichiesta;

	@JsonProperty("testMode")
	private String testMode;

	@JsonProperty("dataInvioRichiesta")
	private String dataInvioRichiesta;

	@JsonProperty("dro")
	private String dro;

	@JsonProperty("dac")
	private String dac;

	@JsonProperty("des")
	private String des;

	// RU_749
	@JsonProperty("descrizioneScenario")
	private String descrizioneScenario;

	@JsonProperty("timestampAggiornamento")
	private String timestampAggiornamento;

	@JsonProperty("timestampInserimento")
	private String timestampInserimento;

	@JsonProperty("flagNaked")
	private String flagNaked;

	@JsonProperty("richiesta")
	private RichiestaOutputDTO richiesta;

	@JsonProperty("clienteFinale")
	private ClienteFinaleDTO clienteFinale;

	@JsonProperty("servizi")
	private List<ServizioDTO> servizi;

	@JsonProperty("referenti")
	private List<ReferenteDTO> referenti;

	@JsonProperty("dettaglioordine")
	private DettagliDettaglioOrdineDTO orderDetails;

	@JsonProperty("codiceordineTInonvalorizzato")
	private List<CodiceOrdineTiDTO> orderCodeTi;

	@JsonProperty("attributiDettaglioOrdine")
	private List<AttributoDettaglioOrdineDTO> attributes;

	@JsonProperty("oaoDonating")
	private String oaoDonating;

	@JsonProperty("oaoDonor")
	private String oaoDonor;

	@JsonProperty("richiestaXML")
	private String richiestaXml;

	@JsonProperty("idOfferta")
	private String idOfferta;

	// RU_737
	@JsonProperty("numeroTelefonicoAggiuntivo")
	private List<String> numeroTelefonicoAggiuntivo;

	// RU_918
	@JsonProperty("cambioTecnologia")
	private List<CambioTecnologiaDTO> cambioTecnologia;

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

	public List<CambioTecnologiaDTO> getCambioTecnologia() {
		return cambioTecnologia;
	}

	public void setCambioTecnologia(List<CambioTecnologiaDTO> cambioTecnologia) {
		this.cambioTecnologia = cambioTecnologia;
	}

	public List<String> getNumeroTelefonicoAggiuntivo() {
		return numeroTelefonicoAggiuntivo;
	}

	public void setNumeroTelefonicoAggiuntivo(List<String> numeroTelefonicoAggiuntivo) {
		this.numeroTelefonicoAggiuntivo = numeroTelefonicoAggiuntivo;
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

	public String getTipoRichiesta() {
		return tipoRichiesta;
	}

	public void setTipoRichiesta(String tipoRichiesta) {
		this.tipoRichiesta = tipoRichiesta;
	}

	public String getStatoRichiestaNow() {
		return statoRichiestaNow;
	}

	public void setStatoRichiestaNow(String statoRichiestaNow) {
		this.statoRichiestaNow = statoRichiestaNow;
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

	public String getCodiceCausaleNow() {
		return codiceCausaleNow;
	}

	public void setCodiceCausaleNow(String codiceCausaleNow) {
		this.codiceCausaleNow = codiceCausaleNow;
	}

	public String getCodiceCausaleOao() {
		return codiceCausaleOao;
	}

	public void setCodiceCausaleOao(String codiceCausaleOao) {
		this.codiceCausaleOao = codiceCausaleOao;
	}

	public String getCausaleOao() {
		return causaleOao;
	}

	public void setCausaleOao(String causaleOao) {
		this.causaleOao = causaleOao;
	}

	// RU_749
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

	public String getDataInvioRichiesta() {
		return dataInvioRichiesta;
	}

	public void setDataInvioRichiesta(String dataInvioRichiesta) {
		this.dataInvioRichiesta = dataInvioRichiesta;
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

	public String getDescrizioneScenario() {
		return descrizioneScenario;
	}

	public void setDescrizioneScenario(String descrizioneScenario) {
		this.descrizioneScenario = descrizioneScenario;
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

	public String getFlagNaked() {
		return flagNaked;
	}

	public void setFlagNaked(String flagNaked) {
		this.flagNaked = flagNaked;
	}

	public RichiestaOutputDTO getRichiesta() {
		return richiesta;
	}

	public void setRichiesta(RichiestaOutputDTO richiesta) {
		this.richiesta = richiesta;
	}

	public ClienteFinaleDTO getClienteFinale() {
		return clienteFinale;
	}

	public void setClienteFinale(ClienteFinaleDTO clienteFinale) {
		this.clienteFinale = clienteFinale;
	}

	public List<ServizioDTO> getServizi() {
		return servizi;
	}

	public void setServizi(List<ServizioDTO> servizi) {
		this.servizi = servizi;
	}

	public List<ReferenteDTO> getReferenti() {
		return referenti;
	}

	public void setReferenti(List<ReferenteDTO> referenti) {
		this.referenti = referenti;
	}

	public DettagliDettaglioOrdineDTO getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(DettagliDettaglioOrdineDTO orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<CodiceOrdineTiDTO> getOrderCodeTi() {
		return orderCodeTi;
	}

	public void setOrderCodeTi(List<CodiceOrdineTiDTO> orderCodeTi) {
		this.orderCodeTi = orderCodeTi;
	}

	public List<AttributoDettaglioOrdineDTO> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AttributoDettaglioOrdineDTO> attributes) {
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
		return Objects.hash(attributes, cambioTecnologia, canaleRichiesta, causaleOao, clienteFinale, codiceCausaleNow,
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
		DettaglioOrdineOutputDTO other = (DettaglioOrdineOutputDTO) obj;
		return Objects.equals(attributes, other.attributes) && Objects.equals(cambioTecnologia, other.cambioTecnologia)
				&& Objects.equals(canaleRichiesta, other.canaleRichiesta)
				&& Objects.equals(causaleOao, other.causaleOao) && Objects.equals(clienteFinale, other.clienteFinale)
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
				&& Objects.equals(exDisaggregato, other.exDisaggregato) && Objects.equals(flagNaked, other.flagNaked)
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
		return "DettaglioOrdineOutputDTO [codiceOrdineTI=" + codiceOrdineTI + ", codificaOloAgcom=" + codificaOloAgcom
				+ ", codiceOloNow=" + codiceOloNow + ", idrichiestaolo=" + idrichiestaolo + ", codiceOrdineOLO="
				+ codiceOrdineOLO + ", canaleRichiesta=" + canaleRichiesta + ", tipoRichiesta=" + tipoRichiesta
				+ ", statoRichiestaNow=" + statoRichiestaNow + ", statoRichiestaOlo=" + statoRichiestaOlo + ", note="
				+ note + ", oao=" + oao + ", codiceCausaleNow=" + codiceCausaleNow + ", codiceCausaleOao="
				+ codiceCausaleOao + ", causaleOao=" + causaleOao + ", descrizioneCausaleNow=" + descrizioneCausaleNow
				+ ", idRisorsa=" + idRisorsa + ", codiceOrdineOloPadre=" + codiceOrdineOloPadre
				+ ", codiceOrdineOloTarget=" + codiceOrdineOloTarget + ", codiceProgetto=" + codiceProgetto
				+ ", lavorazioneRichiesta=" + lavorazioneRichiesta + ", testMode=" + testMode + ", dataInvioRichiesta="
				+ dataInvioRichiesta + ", dro=" + dro + ", dac=" + dac + ", des=" + des + ", descrizioneScenario="
				+ descrizioneScenario + ", timestampAggiornamento=" + timestampAggiornamento + ", timestampInserimento="
				+ timestampInserimento + ", flagNaked=" + flagNaked + ", richiesta=" + richiesta + ", clienteFinale="
				+ clienteFinale + ", servizi=" + servizi + ", referenti=" + referenti + ", orderDetails=" + orderDetails
				+ ", orderCodeTi=" + orderCodeTi + ", attributes=" + attributes + ", oaoDonating=" + oaoDonating
				+ ", oaoDonor=" + oaoDonor + ", richiestaXml=" + richiestaXml + ", idOfferta=" + idOfferta
				+ ", numeroTelefonicoAggiuntivo=" + numeroTelefonicoAggiuntivo + ", cambioTecnologia="
				+ cambioTecnologia + ", idRisorsaNow=" + idRisorsaNow + ", disaggregato=" + disaggregato
				+ ", exDisaggregato=" + exDisaggregato + ", ordineAssetWhiteList=" + ordineAssetWhiteList
				+ ", refOaoProgettiSpeciali=" + refOaoProgettiSpeciali + ", idRisorsaOF=" + idRisorsaOF
				+ ", codiceOrdineOF=" + codiceOrdineOF + ", statoOF=" + statoOF + ", noteOF=" + noteOF + "]";
	}

}
