package com.nttdata.tim.now.data.dto.ordine.dettaglio;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DettagliDettaglioOrdineDTO implements Serializable {

	private static final long serialVersionUID = -1276761598061503215L;

	@JsonProperty("CodiceCausaleNOW")
    private String codiceCausaleNOW;

    @JsonProperty("CodiceCausaleOLO")
    private String codiceCausaleOLO;

    @JsonProperty("DescrizioneCausaleOLO")
    private String descrizioneCausaleOLO;

    @JsonProperty("DescrizioneCausaleNOW")
    private String descrizioneCausaleNOW;

    @JsonProperty("DUVO")
    private String duvo;

    @JsonProperty("Sottolavorazione")
    private String sottolavorazione;

    @JsonProperty("TipoLavorazione")
    private String tipoLavorazione;

    @JsonProperty("ModalitaFatturazione")
    private String modalitaFatturazione;

    @JsonProperty("DPP")
    private String dpp;

    @JsonProperty("TipoPacchetto")
    private String tipoPacchetto;

    @JsonProperty("NoteDaCliente")
    private String noteDaCliente;

    @JsonProperty("IdRisorsa")
    private String idRisorsa;

    @JsonProperty("CodiceOrdineOlo")
    private String codiceOrdineOlo;

    @JsonProperty("FlagLavorazioneManuale")
    private String flagLavorazioneManuale;

    @JsonProperty("CodiceOrdineTI")
    private String codiceOrdineTI;

    @JsonProperty("NoteDaSistema")
    private String noteDaSistema;

    @JsonProperty("CodiceOLO")
    private String codiceOLO;

    @JsonProperty("Contratto")
    private String contratto;
    
    @JsonProperty("NomeFile")
    private String nomeFile;

    @JsonProperty("CodiceOLOOrdinePadre")
    private String codiceOLOOrdinePadre;

    @JsonProperty("DataChiusuraOrdine")
    private String dataChiusuraOrdine;

    @JsonProperty("identificativoCorrelazioni")
    private String identificativoCorrelazioni;

    @JsonProperty("TotaleOrdiniPacchetto")
    private String totaleOrdiniPacchetto;

    @JsonProperty("Progetto")
    private String progetto;

    @JsonProperty("CodiceDelivery")
    private String codiceDelivery;

    @JsonProperty("CodiceQualita")
    private String codiceQualita;

    @JsonProperty("CodiceTTM")
    private String codiceTTM;

    @JsonProperty("FlagMonitoraggio")
    private String flagMonitoraggio;

    @JsonProperty("StatoNOW")
    private String statoNOW;

    @JsonProperty("StatoOLO")
    private String statoOLO;

    @JsonProperty("Offerta")
    private String offerta;

    @JsonProperty("DRO")
    private String dro;

    @JsonProperty("DAC")
    private String dac;

    @JsonProperty("DACRimodulata")
    private String dacRimodulata;

    @JsonProperty("DataEspletamentoTecnico")
    private String dataEspletamentoTecnico;

    @JsonProperty("DataEspletamentoCommerciale")
    private String dataEspletamentoCommerciale;

    @JsonProperty("DAD")
    private String dad;

    @JsonProperty("FasciaOraria")
    private String fasciaOraria;

    @JsonProperty("DataInvioOrdineDelivery")
    private String dataInvioOrdineDelivery;

    @JsonProperty("DataInvioCommercializzazione")
    private String dataInvioCommercializzazione;

    @JsonProperty("IDULLCO")
    private String idullco;

    @JsonProperty("NumeroVerdeOLOPT")
    private String numeroVerdeOLOPT;

    @JsonProperty("NumeroVerdeOLOCollaudo")
    private String numeroVerdeOLOCollaudo;

    @JsonProperty("Centrale")
    private String centrale;

    @JsonProperty("CodiceGAT")
    private String codiceGAT;

    @JsonProperty("DNOloCollaudo")
    private String dnOloCollaudo;

    @JsonProperty("IDSLUCO")
    private String idsluco;

    @JsonProperty("DADRimodulata")
    private String dadRimodulata;

    @JsonProperty("RO")
    private String ro;

    @JsonProperty("CONTENUTOXML")
    private String contenutoXml;
    
    @JsonProperty("FlagPreventivo")
    private String flagPreventivo;

    @JsonProperty("FlagOpereSpeciali")
    private String flagOpereSpeciali;

    @JsonProperty("IdOfferta")
    private String idOfferta;

    @JsonProperty("DataPrevistaSoluzione")
    private String dataPrevistaSoluzione;
    
    @JsonProperty("inAttesaDesospensioneDaOao")
    private String inAttesaDesospensioneDaOao;
    
	@JsonFormat(pattern = DateHelper.DATE_BE_LONG, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataUltimoAppuntamento")
    private Date dataUltimoAppuntamento;
    
    @JsonProperty("oraUltimoAppuntamento")
    private String oraUltimoAppuntamento;
    
    //RU_628
   	@JsonProperty("codiceRisorsaDonating1")
    private String codiceRisorsaDonating1;
    
    @JsonProperty("codiceRisorsaDonating2")
    private String codiceRisorsaDonating2;
    
    @JsonProperty("codiceSessione1")
    private String codiceSessione1;
    
    @JsonProperty("codiceSessione2")
    private String codiceSessione2;
    
    //RU_628
    @JsonProperty("opzioneDinamica")
    private String opzioneDinamica;
    
    //RU_737
    @JsonProperty("idRisorsaOperatoreRete")
    private String idRisorsaOperatoreRete;
    
    //field non presente nel JSON
    @JsonProperty("DataCreazioneOrdine")
    private String dataCreazioneOrdine;

    //RU_823
    @JsonProperty("rendezVous")
    private String rendezVous;

    //RU_817
    @JsonProperty("dettagliAltroOperatoreRete")
    private String dettagliAltroOperatoreRete;
    
    //SM_9839
    @JsonProperty("operatoreRete")
    private String operatoreRete;
    
    @JsonProperty("intermediateAgentFull")
    private String intermediateAgentFull;
    
	public String getCodiceCausaleNOW() {
		return codiceCausaleNOW;
	}

	public void setCodiceCausaleNOW(String codiceCausaleNOW) {
		this.codiceCausaleNOW = codiceCausaleNOW;
	}

	public String getCodiceCausaleOLO() {
		return codiceCausaleOLO;
	}

	public void setCodiceCausaleOLO(String codiceCausaleOLO) {
		this.codiceCausaleOLO = codiceCausaleOLO;
	}

	public String getDescrizioneCausaleOLO() {
		return descrizioneCausaleOLO;
	}

	public void setDescrizioneCausaleOLO(String descrizioneCausaleOLO) {
		this.descrizioneCausaleOLO = descrizioneCausaleOLO;
	}

	public String getDescrizioneCausaleNOW() {
		return descrizioneCausaleNOW;
	}

	public void setDescrizioneCausaleNOW(String descrizioneCausaleNOW) {
		this.descrizioneCausaleNOW = descrizioneCausaleNOW;
	}

	public String getDuvo() {
		return duvo;
	}

	public void setDuvo(String duvo) {
		this.duvo = duvo;
	}

	public String getSottolavorazione() {
		return sottolavorazione;
	}

	public void setSottolavorazione(String sottolavorazione) {
		this.sottolavorazione = sottolavorazione;
	}

	public String getTipoLavorazione() {
		return tipoLavorazione;
	}

	public void setTipoLavorazione(String tipoLavorazione) {
		this.tipoLavorazione = tipoLavorazione;
	}

	public String getModalitaFatturazione() {
		return modalitaFatturazione;
	}

	public void setModalitaFatturazione(String modalitaFatturazione) {
		this.modalitaFatturazione = modalitaFatturazione;
	}

	public String getDpp() {
		return dpp;
	}

	public void setDpp(String dpp) {
		this.dpp = dpp;
	}

	public String getTipoPacchetto() {
		return tipoPacchetto;
	}

	public void setTipoPacchetto(String tipoPacchetto) {
		this.tipoPacchetto = tipoPacchetto;
	}

	public String getNoteDaCliente() {
		return noteDaCliente;
	}

	public void setNoteDaCliente(String noteDaCliente) {
		this.noteDaCliente = noteDaCliente;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getCodiceOrdineOlo() {
		return codiceOrdineOlo;
	}

	public void setCodiceOrdineOlo(String codiceOrdineOlo) {
		this.codiceOrdineOlo = codiceOrdineOlo;
	}

	public String getFlagLavorazioneManuale() {
		return flagLavorazioneManuale;
	}

	public void setFlagLavorazioneManuale(String flagLavorazioneManuale) {
		this.flagLavorazioneManuale = flagLavorazioneManuale;
	}

	public String getCodiceOrdineTI() {
		return codiceOrdineTI;
	}

	public void setCodiceOrdineTI(String codiceOrdineTI) {
		this.codiceOrdineTI = codiceOrdineTI;
	}

	public String getNoteDaSistema() {
		return noteDaSistema;
	}

	public void setNoteDaSistema(String noteDaSistema) {
		this.noteDaSistema = noteDaSistema;
	}

	public String getCodiceOLO() {
		return codiceOLO;
	}

	public void setCodiceOLO(String codiceOLO) {
		this.codiceOLO = codiceOLO;
	}

	public String getContratto() {
		return contratto;
	}

	public void setContratto(String contratto) {
		this.contratto = contratto;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getCodiceOLOOrdinePadre() {
		return codiceOLOOrdinePadre;
	}

	public void setCodiceOLOOrdinePadre(String codiceOLOOrdinePadre) {
		this.codiceOLOOrdinePadre = codiceOLOOrdinePadre;
	}

	public String getDataChiusuraOrdine() {
		return dataChiusuraOrdine;
	}

	public void setDataChiusuraOrdine(String dataChiusuraOrdine) {
		this.dataChiusuraOrdine = dataChiusuraOrdine;
	}

	public String getIdentificativoCorrelazioni() {
		return identificativoCorrelazioni;
	}

	public void setIdentificativoCorrelazioni(String identificativoCorrelazioni) {
		this.identificativoCorrelazioni = identificativoCorrelazioni;
	}

	public String getTotaleOrdiniPacchetto() {
		return totaleOrdiniPacchetto;
	}

	public void setTotaleOrdiniPacchetto(String totaleOrdiniPacchetto) {
		this.totaleOrdiniPacchetto = totaleOrdiniPacchetto;
	}

	public String getProgetto() {
		return progetto;
	}

	public void setProgetto(String progetto) {
		this.progetto = progetto;
	}

	public String getCodiceDelivery() {
		return codiceDelivery;
	}

	public void setCodiceDelivery(String codiceDelivery) {
		this.codiceDelivery = codiceDelivery;
	}

	public String getCodiceQualita() {
		return codiceQualita;
	}

	public void setCodiceQualita(String codiceQualita) {
		this.codiceQualita = codiceQualita;
	}

	public String getCodiceTTM() {
		return codiceTTM;
	}

	public void setCodiceTTM(String codiceTTM) {
		this.codiceTTM = codiceTTM;
	}

	public String getFlagMonitoraggio() {
		return flagMonitoraggio;
	}

	public void setFlagMonitoraggio(String flagMonitoraggio) {
		this.flagMonitoraggio = flagMonitoraggio;
	}

	public String getStatoNOW() {
		return statoNOW;
	}

	public void setStatoNOW(String statoNOW) {
		this.statoNOW = statoNOW;
	}

	public String getStatoOLO() {
		return statoOLO;
	}

	public void setStatoOLO(String statoOLO) {
		this.statoOLO = statoOLO;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
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

	public String getDacRimodulata() {
		return dacRimodulata;
	}

	public void setDacRimodulata(String dacRimodulata) {
		this.dacRimodulata = dacRimodulata;
	}

	public String getDataEspletamentoTecnico() {
		return dataEspletamentoTecnico;
	}

	public void setDataEspletamentoTecnico(String dataEspletamentoTecnico) {
		this.dataEspletamentoTecnico = dataEspletamentoTecnico;
	}

	public String getDataEspletamentoCommerciale() {
		return dataEspletamentoCommerciale;
	}

	public void setDataEspletamentoCommerciale(String dataEspletamentoCommerciale) {
		this.dataEspletamentoCommerciale = dataEspletamentoCommerciale;
	}

	public String getDad() {
		return dad;
	}

	public void setDad(String dad) {
		this.dad = dad;
	}

	public String getFasciaOraria() {
		return fasciaOraria;
	}

	public void setFasciaOraria(String fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}

	public String getDataInvioOrdineDelivery() {
		return dataInvioOrdineDelivery;
	}

	public void setDataInvioOrdineDelivery(String dataInvioOrdineDelivery) {
		this.dataInvioOrdineDelivery = dataInvioOrdineDelivery;
	}

	public String getDataInvioCommercializzazione() {
		return dataInvioCommercializzazione;
	}

	public void setDataInvioCommercializzazione(String dataInvioCommercializzazione) {
		this.dataInvioCommercializzazione = dataInvioCommercializzazione;
	}

	public String getIdullco() {
		return idullco;
	}

	public void setIdullco(String idullco) {
		this.idullco = idullco;
	}

	public String getNumeroVerdeOLOPT() {
		return numeroVerdeOLOPT;
	}

	public void setNumeroVerdeOLOPT(String numeroVerdeOLOPT) {
		this.numeroVerdeOLOPT = numeroVerdeOLOPT;
	}

	public String getNumeroVerdeOLOCollaudo() {
		return numeroVerdeOLOCollaudo;
	}

	public void setNumeroVerdeOLOCollaudo(String numeroVerdeOLOCollaudo) {
		this.numeroVerdeOLOCollaudo = numeroVerdeOLOCollaudo;
	}

	public String getCentrale() {
		return centrale;
	}

	public void setCentrale(String centrale) {
		this.centrale = centrale;
	}

	public String getCodiceGAT() {
		return codiceGAT;
	}

	public void setCodiceGAT(String codiceGAT) {
		this.codiceGAT = codiceGAT;
	}

	public String getDnOloCollaudo() {
		return dnOloCollaudo;
	}

	public void setDnOloCollaudo(String dnOloCollaudo) {
		this.dnOloCollaudo = dnOloCollaudo;
	}

	public String getIdsluco() {
		return idsluco;
	}

	public void setIdsluco(String idsluco) {
		this.idsluco = idsluco;
	}

	public String getDadRimodulata() {
		return dadRimodulata;
	}

	public void setDadRimodulata(String dadRimodulata) {
		this.dadRimodulata = dadRimodulata;
	}

	public String getRo() {
		return ro;
	}

	public void setRo(String ro) {
		this.ro = ro;
	}

	public String getContenutoXml() {
		return contenutoXml;
	}

	public void setContenutoXml(String contenutoXml) {
		this.contenutoXml = contenutoXml;
	}

	public String getFlagPreventivo() {
		return flagPreventivo;
	}

	public void setFlagPreventivo(String flagPreventivo) {
		this.flagPreventivo = flagPreventivo;
	}

	public String getFlagOpereSpeciali() {
		return flagOpereSpeciali;
	}

	public void setFlagOpereSpeciali(String flagOpereSpeciali) {
		this.flagOpereSpeciali = flagOpereSpeciali;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getDataPrevistaSoluzione() {
		return dataPrevistaSoluzione;
	}

	public void setDataPrevistaSoluzione(String dataPrevistaSoluzione) {
		this.dataPrevistaSoluzione = dataPrevistaSoluzione;
	}

	public String getInAttesaDesospensioneDaOao() {
		return inAttesaDesospensioneDaOao;
	}

	public void setInAttesaDesospensioneDaOao(String inAttesaDesospensioneDaOao) {
		this.inAttesaDesospensioneDaOao = inAttesaDesospensioneDaOao;
	}

	public Date getDataUltimoAppuntamento() {
		return dataUltimoAppuntamento;
	}

	public void setDataUltimoAppuntamento(Date dataUltimoAppuntamento) {
		this.dataUltimoAppuntamento = dataUltimoAppuntamento;
	}

	public String getOraUltimoAppuntamento() {
		return oraUltimoAppuntamento;
	}

	public void setOraUltimoAppuntamento(String oraUltimoAppuntamento) {
		this.oraUltimoAppuntamento = oraUltimoAppuntamento;
	}
	
	public String getIdRisorsaOperatoreRete() { //RU_737
		return idRisorsaOperatoreRete;
	}

	public void setIdRisorsaOperatoreRete(String idRisorsaOperatoreRete) { //RU_737
		this.idRisorsaOperatoreRete = idRisorsaOperatoreRete;
	}

	public String getDataCreazioneOrdine() {
		return dataCreazioneOrdine;
	}

	public void setDataCreazioneOrdine(String dataCreazioneOrdine) {
		this.dataCreazioneOrdine = dataCreazioneOrdine;
	}
	
	public String getCodiceRisorsaDonating1() {
		return codiceRisorsaDonating1;
	}

	public void setCodiceRisorsaDonating1(String codiceRisorsaDonating1) {
		this.codiceRisorsaDonating1 = codiceRisorsaDonating1;
	}

	public String getCodiceRisorsaDonating2() {
		return codiceRisorsaDonating2;
	}

	public void setCodiceRisorsaDonating2(String codiceRisorsaDonating2) {
		this.codiceRisorsaDonating2 = codiceRisorsaDonating2;
	}

	public String getCodiceSessione1() {
		return codiceSessione1;
	}

	public void setCodiceSessione1(String codiceSessione1) {
		this.codiceSessione1 = codiceSessione1;
	}

	public String getCodiceSessione2() {
		return codiceSessione2;
	}

	public void setCodiceSessione2(String codiceSessione2) {
		this.codiceSessione2 = codiceSessione2;
	}

	public String getOpzioneDinamica() {
		return opzioneDinamica;
	}

	public void setOpzioneDinamica(String opzioneDinamica) {
		this.opzioneDinamica = opzioneDinamica;
	}

	public String getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(String rendezVous) {
		this.rendezVous = rendezVous;
	}

	public String getDettagliAltroOperatoreRete() {
		return dettagliAltroOperatoreRete;
	}

	public void setDettagliAltroOperatoreRete(String dettagliAltroOperatoreRete) {
		this.dettagliAltroOperatoreRete = dettagliAltroOperatoreRete;
	}

	public String getOperatoreRete() {
		return operatoreRete;
	}

	public void setOperatoreRete(String operatoreRete) {
		this.operatoreRete = operatoreRete;
	}

	public String getIntermediateAgentFull() {
		return intermediateAgentFull;
	}

	public void setIntermediateAgentFull(String intermediateAgentFull) {
		this.intermediateAgentFull = intermediateAgentFull;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centrale == null) ? 0 : centrale.hashCode());
		result = prime * result + ((codiceCausaleNOW == null) ? 0 : codiceCausaleNOW.hashCode());
		result = prime * result + ((codiceCausaleOLO == null) ? 0 : codiceCausaleOLO.hashCode());
		result = prime * result + ((codiceDelivery == null) ? 0 : codiceDelivery.hashCode());
		result = prime * result + ((codiceGAT == null) ? 0 : codiceGAT.hashCode());
		result = prime * result + ((codiceOLO == null) ? 0 : codiceOLO.hashCode());
		result = prime * result + ((codiceOLOOrdinePadre == null) ? 0 : codiceOLOOrdinePadre.hashCode());
		result = prime * result + ((codiceOrdineOlo == null) ? 0 : codiceOrdineOlo.hashCode());
		result = prime * result + ((codiceOrdineTI == null) ? 0 : codiceOrdineTI.hashCode());
		result = prime * result + ((codiceQualita == null) ? 0 : codiceQualita.hashCode());
		result = prime * result + ((codiceRisorsaDonating1 == null) ? 0 : codiceRisorsaDonating1.hashCode());
		result = prime * result + ((codiceRisorsaDonating2 == null) ? 0 : codiceRisorsaDonating2.hashCode());
		result = prime * result + ((codiceSessione1 == null) ? 0 : codiceSessione1.hashCode());
		result = prime * result + ((codiceSessione2 == null) ? 0 : codiceSessione2.hashCode());
		result = prime * result + ((codiceTTM == null) ? 0 : codiceTTM.hashCode());
		result = prime * result + ((contenutoXml == null) ? 0 : contenutoXml.hashCode());
		result = prime * result + ((contratto == null) ? 0 : contratto.hashCode());
		result = prime * result + ((dac == null) ? 0 : dac.hashCode());
		result = prime * result + ((dacRimodulata == null) ? 0 : dacRimodulata.hashCode());
		result = prime * result + ((dad == null) ? 0 : dad.hashCode());
		result = prime * result + ((dadRimodulata == null) ? 0 : dadRimodulata.hashCode());
		result = prime * result + ((dataChiusuraOrdine == null) ? 0 : dataChiusuraOrdine.hashCode());
		result = prime * result + ((dataCreazioneOrdine == null) ? 0 : dataCreazioneOrdine.hashCode());
		result = prime * result + ((dataEspletamentoCommerciale == null) ? 0 : dataEspletamentoCommerciale.hashCode());
		result = prime * result + ((dataEspletamentoTecnico == null) ? 0 : dataEspletamentoTecnico.hashCode());
		result = prime * result
				+ ((dataInvioCommercializzazione == null) ? 0 : dataInvioCommercializzazione.hashCode());
		result = prime * result + ((dataInvioOrdineDelivery == null) ? 0 : dataInvioOrdineDelivery.hashCode());
		result = prime * result + ((dataPrevistaSoluzione == null) ? 0 : dataPrevistaSoluzione.hashCode());
		result = prime * result + ((dataUltimoAppuntamento == null) ? 0 : dataUltimoAppuntamento.hashCode());
		result = prime * result + ((descrizioneCausaleNOW == null) ? 0 : descrizioneCausaleNOW.hashCode());
		result = prime * result + ((descrizioneCausaleOLO == null) ? 0 : descrizioneCausaleOLO.hashCode());
		result = prime * result + ((dettagliAltroOperatoreRete == null) ? 0 : dettagliAltroOperatoreRete.hashCode());
		result = prime * result + ((dnOloCollaudo == null) ? 0 : dnOloCollaudo.hashCode());
		result = prime * result + ((dpp == null) ? 0 : dpp.hashCode());
		result = prime * result + ((dro == null) ? 0 : dro.hashCode());
		result = prime * result + ((duvo == null) ? 0 : duvo.hashCode());
		result = prime * result + ((fasciaOraria == null) ? 0 : fasciaOraria.hashCode());
		result = prime * result + ((flagLavorazioneManuale == null) ? 0 : flagLavorazioneManuale.hashCode());
		result = prime * result + ((flagMonitoraggio == null) ? 0 : flagMonitoraggio.hashCode());
		result = prime * result + ((flagOpereSpeciali == null) ? 0 : flagOpereSpeciali.hashCode());
		result = prime * result + ((flagPreventivo == null) ? 0 : flagPreventivo.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((idRisorsaOperatoreRete == null) ? 0 : idRisorsaOperatoreRete.hashCode());
		result = prime * result + ((identificativoCorrelazioni == null) ? 0 : identificativoCorrelazioni.hashCode());
		result = prime * result + ((idsluco == null) ? 0 : idsluco.hashCode());
		result = prime * result + ((idullco == null) ? 0 : idullco.hashCode());
		result = prime * result + ((inAttesaDesospensioneDaOao == null) ? 0 : inAttesaDesospensioneDaOao.hashCode());
		result = prime * result + ((intermediateAgentFull == null) ? 0 : intermediateAgentFull.hashCode());
		result = prime * result + ((modalitaFatturazione == null) ? 0 : modalitaFatturazione.hashCode());
		result = prime * result + ((nomeFile == null) ? 0 : nomeFile.hashCode());
		result = prime * result + ((noteDaCliente == null) ? 0 : noteDaCliente.hashCode());
		result = prime * result + ((noteDaSistema == null) ? 0 : noteDaSistema.hashCode());
		result = prime * result + ((numeroVerdeOLOCollaudo == null) ? 0 : numeroVerdeOLOCollaudo.hashCode());
		result = prime * result + ((numeroVerdeOLOPT == null) ? 0 : numeroVerdeOLOPT.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((operatoreRete == null) ? 0 : operatoreRete.hashCode());
		result = prime * result + ((opzioneDinamica == null) ? 0 : opzioneDinamica.hashCode());
		result = prime * result + ((oraUltimoAppuntamento == null) ? 0 : oraUltimoAppuntamento.hashCode());
		result = prime * result + ((progetto == null) ? 0 : progetto.hashCode());
		result = prime * result + ((rendezVous == null) ? 0 : rendezVous.hashCode());
		result = prime * result + ((ro == null) ? 0 : ro.hashCode());
		result = prime * result + ((sottolavorazione == null) ? 0 : sottolavorazione.hashCode());
		result = prime * result + ((statoNOW == null) ? 0 : statoNOW.hashCode());
		result = prime * result + ((statoOLO == null) ? 0 : statoOLO.hashCode());
		result = prime * result + ((tipoLavorazione == null) ? 0 : tipoLavorazione.hashCode());
		result = prime * result + ((tipoPacchetto == null) ? 0 : tipoPacchetto.hashCode());
		result = prime * result + ((totaleOrdiniPacchetto == null) ? 0 : totaleOrdiniPacchetto.hashCode());
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
		DettagliDettaglioOrdineDTO other = (DettagliDettaglioOrdineDTO) obj;
		if (centrale == null) {
			if (other.centrale != null)
				return false;
		} else if (!centrale.equals(other.centrale))
			return false;
		if (codiceCausaleNOW == null) {
			if (other.codiceCausaleNOW != null)
				return false;
		} else if (!codiceCausaleNOW.equals(other.codiceCausaleNOW))
			return false;
		if (codiceCausaleOLO == null) {
			if (other.codiceCausaleOLO != null)
				return false;
		} else if (!codiceCausaleOLO.equals(other.codiceCausaleOLO))
			return false;
		if (codiceDelivery == null) {
			if (other.codiceDelivery != null)
				return false;
		} else if (!codiceDelivery.equals(other.codiceDelivery))
			return false;
		if (codiceGAT == null) {
			if (other.codiceGAT != null)
				return false;
		} else if (!codiceGAT.equals(other.codiceGAT))
			return false;
		if (codiceOLO == null) {
			if (other.codiceOLO != null)
				return false;
		} else if (!codiceOLO.equals(other.codiceOLO))
			return false;
		if (codiceOLOOrdinePadre == null) {
			if (other.codiceOLOOrdinePadre != null)
				return false;
		} else if (!codiceOLOOrdinePadre.equals(other.codiceOLOOrdinePadre))
			return false;
		if (codiceOrdineOlo == null) {
			if (other.codiceOrdineOlo != null)
				return false;
		} else if (!codiceOrdineOlo.equals(other.codiceOrdineOlo))
			return false;
		if (codiceOrdineTI == null) {
			if (other.codiceOrdineTI != null)
				return false;
		} else if (!codiceOrdineTI.equals(other.codiceOrdineTI))
			return false;
		if (codiceQualita == null) {
			if (other.codiceQualita != null)
				return false;
		} else if (!codiceQualita.equals(other.codiceQualita))
			return false;
		if (codiceRisorsaDonating1 == null) {
			if (other.codiceRisorsaDonating1 != null)
				return false;
		} else if (!codiceRisorsaDonating1.equals(other.codiceRisorsaDonating1))
			return false;
		if (codiceRisorsaDonating2 == null) {
			if (other.codiceRisorsaDonating2 != null)
				return false;
		} else if (!codiceRisorsaDonating2.equals(other.codiceRisorsaDonating2))
			return false;
		if (codiceSessione1 == null) {
			if (other.codiceSessione1 != null)
				return false;
		} else if (!codiceSessione1.equals(other.codiceSessione1))
			return false;
		if (codiceSessione2 == null) {
			if (other.codiceSessione2 != null)
				return false;
		} else if (!codiceSessione2.equals(other.codiceSessione2))
			return false;
		if (codiceTTM == null) {
			if (other.codiceTTM != null)
				return false;
		} else if (!codiceTTM.equals(other.codiceTTM))
			return false;
		if (contenutoXml == null) {
			if (other.contenutoXml != null)
				return false;
		} else if (!contenutoXml.equals(other.contenutoXml))
			return false;
		if (contratto == null) {
			if (other.contratto != null)
				return false;
		} else if (!contratto.equals(other.contratto))
			return false;
		if (dac == null) {
			if (other.dac != null)
				return false;
		} else if (!dac.equals(other.dac))
			return false;
		if (dacRimodulata == null) {
			if (other.dacRimodulata != null)
				return false;
		} else if (!dacRimodulata.equals(other.dacRimodulata))
			return false;
		if (dad == null) {
			if (other.dad != null)
				return false;
		} else if (!dad.equals(other.dad))
			return false;
		if (dadRimodulata == null) {
			if (other.dadRimodulata != null)
				return false;
		} else if (!dadRimodulata.equals(other.dadRimodulata))
			return false;
		if (dataChiusuraOrdine == null) {
			if (other.dataChiusuraOrdine != null)
				return false;
		} else if (!dataChiusuraOrdine.equals(other.dataChiusuraOrdine))
			return false;
		if (dataCreazioneOrdine == null) {
			if (other.dataCreazioneOrdine != null)
				return false;
		} else if (!dataCreazioneOrdine.equals(other.dataCreazioneOrdine))
			return false;
		if (dataEspletamentoCommerciale == null) {
			if (other.dataEspletamentoCommerciale != null)
				return false;
		} else if (!dataEspletamentoCommerciale.equals(other.dataEspletamentoCommerciale))
			return false;
		if (dataEspletamentoTecnico == null) {
			if (other.dataEspletamentoTecnico != null)
				return false;
		} else if (!dataEspletamentoTecnico.equals(other.dataEspletamentoTecnico))
			return false;
		if (dataInvioCommercializzazione == null) {
			if (other.dataInvioCommercializzazione != null)
				return false;
		} else if (!dataInvioCommercializzazione.equals(other.dataInvioCommercializzazione))
			return false;
		if (dataInvioOrdineDelivery == null) {
			if (other.dataInvioOrdineDelivery != null)
				return false;
		} else if (!dataInvioOrdineDelivery.equals(other.dataInvioOrdineDelivery))
			return false;
		if (dataPrevistaSoluzione == null) {
			if (other.dataPrevistaSoluzione != null)
				return false;
		} else if (!dataPrevistaSoluzione.equals(other.dataPrevistaSoluzione))
			return false;
		if (dataUltimoAppuntamento == null) {
			if (other.dataUltimoAppuntamento != null)
				return false;
		} else if (!dataUltimoAppuntamento.equals(other.dataUltimoAppuntamento))
			return false;
		if (descrizioneCausaleNOW == null) {
			if (other.descrizioneCausaleNOW != null)
				return false;
		} else if (!descrizioneCausaleNOW.equals(other.descrizioneCausaleNOW))
			return false;
		if (descrizioneCausaleOLO == null) {
			if (other.descrizioneCausaleOLO != null)
				return false;
		} else if (!descrizioneCausaleOLO.equals(other.descrizioneCausaleOLO))
			return false;
		if (dettagliAltroOperatoreRete == null) {
			if (other.dettagliAltroOperatoreRete != null)
				return false;
		} else if (!dettagliAltroOperatoreRete.equals(other.dettagliAltroOperatoreRete))
			return false;
		if (dnOloCollaudo == null) {
			if (other.dnOloCollaudo != null)
				return false;
		} else if (!dnOloCollaudo.equals(other.dnOloCollaudo))
			return false;
		if (dpp == null) {
			if (other.dpp != null)
				return false;
		} else if (!dpp.equals(other.dpp))
			return false;
		if (dro == null) {
			if (other.dro != null)
				return false;
		} else if (!dro.equals(other.dro))
			return false;
		if (duvo == null) {
			if (other.duvo != null)
				return false;
		} else if (!duvo.equals(other.duvo))
			return false;
		if (fasciaOraria == null) {
			if (other.fasciaOraria != null)
				return false;
		} else if (!fasciaOraria.equals(other.fasciaOraria))
			return false;
		if (flagLavorazioneManuale == null) {
			if (other.flagLavorazioneManuale != null)
				return false;
		} else if (!flagLavorazioneManuale.equals(other.flagLavorazioneManuale))
			return false;
		if (flagMonitoraggio == null) {
			if (other.flagMonitoraggio != null)
				return false;
		} else if (!flagMonitoraggio.equals(other.flagMonitoraggio))
			return false;
		if (flagOpereSpeciali == null) {
			if (other.flagOpereSpeciali != null)
				return false;
		} else if (!flagOpereSpeciali.equals(other.flagOpereSpeciali))
			return false;
		if (flagPreventivo == null) {
			if (other.flagPreventivo != null)
				return false;
		} else if (!flagPreventivo.equals(other.flagPreventivo))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (idRisorsaOperatoreRete == null) {
			if (other.idRisorsaOperatoreRete != null)
				return false;
		} else if (!idRisorsaOperatoreRete.equals(other.idRisorsaOperatoreRete))
			return false;
		if (identificativoCorrelazioni == null) {
			if (other.identificativoCorrelazioni != null)
				return false;
		} else if (!identificativoCorrelazioni.equals(other.identificativoCorrelazioni))
			return false;
		if (idsluco == null) {
			if (other.idsluco != null)
				return false;
		} else if (!idsluco.equals(other.idsluco))
			return false;
		if (idullco == null) {
			if (other.idullco != null)
				return false;
		} else if (!idullco.equals(other.idullco))
			return false;
		if (inAttesaDesospensioneDaOao == null) {
			if (other.inAttesaDesospensioneDaOao != null)
				return false;
		} else if (!inAttesaDesospensioneDaOao.equals(other.inAttesaDesospensioneDaOao))
			return false;
		if (intermediateAgentFull == null) {
			if (other.intermediateAgentFull != null)
				return false;
		} else if (!intermediateAgentFull.equals(other.intermediateAgentFull))
			return false;
		if (modalitaFatturazione == null) {
			if (other.modalitaFatturazione != null)
				return false;
		} else if (!modalitaFatturazione.equals(other.modalitaFatturazione))
			return false;
		if (nomeFile == null) {
			if (other.nomeFile != null)
				return false;
		} else if (!nomeFile.equals(other.nomeFile))
			return false;
		if (noteDaCliente == null) {
			if (other.noteDaCliente != null)
				return false;
		} else if (!noteDaCliente.equals(other.noteDaCliente))
			return false;
		if (noteDaSistema == null) {
			if (other.noteDaSistema != null)
				return false;
		} else if (!noteDaSistema.equals(other.noteDaSistema))
			return false;
		if (numeroVerdeOLOCollaudo == null) {
			if (other.numeroVerdeOLOCollaudo != null)
				return false;
		} else if (!numeroVerdeOLOCollaudo.equals(other.numeroVerdeOLOCollaudo))
			return false;
		if (numeroVerdeOLOPT == null) {
			if (other.numeroVerdeOLOPT != null)
				return false;
		} else if (!numeroVerdeOLOPT.equals(other.numeroVerdeOLOPT))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (operatoreRete == null) {
			if (other.operatoreRete != null)
				return false;
		} else if (!operatoreRete.equals(other.operatoreRete))
			return false;
		if (opzioneDinamica == null) {
			if (other.opzioneDinamica != null)
				return false;
		} else if (!opzioneDinamica.equals(other.opzioneDinamica))
			return false;
		if (oraUltimoAppuntamento == null) {
			if (other.oraUltimoAppuntamento != null)
				return false;
		} else if (!oraUltimoAppuntamento.equals(other.oraUltimoAppuntamento))
			return false;
		if (progetto == null) {
			if (other.progetto != null)
				return false;
		} else if (!progetto.equals(other.progetto))
			return false;
		if (rendezVous == null) {
			if (other.rendezVous != null)
				return false;
		} else if (!rendezVous.equals(other.rendezVous))
			return false;
		if (ro == null) {
			if (other.ro != null)
				return false;
		} else if (!ro.equals(other.ro))
			return false;
		if (sottolavorazione == null) {
			if (other.sottolavorazione != null)
				return false;
		} else if (!sottolavorazione.equals(other.sottolavorazione))
			return false;
		if (statoNOW == null) {
			if (other.statoNOW != null)
				return false;
		} else if (!statoNOW.equals(other.statoNOW))
			return false;
		if (statoOLO == null) {
			if (other.statoOLO != null)
				return false;
		} else if (!statoOLO.equals(other.statoOLO))
			return false;
		if (tipoLavorazione == null) {
			if (other.tipoLavorazione != null)
				return false;
		} else if (!tipoLavorazione.equals(other.tipoLavorazione))
			return false;
		if (tipoPacchetto == null) {
			if (other.tipoPacchetto != null)
				return false;
		} else if (!tipoPacchetto.equals(other.tipoPacchetto))
			return false;
		if (totaleOrdiniPacchetto == null) {
			if (other.totaleOrdiniPacchetto != null)
				return false;
		} else if (!totaleOrdiniPacchetto.equals(other.totaleOrdiniPacchetto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DettagliDettaglioOrdineDTO [codiceCausaleNOW=" + codiceCausaleNOW + ", codiceCausaleOLO="
				+ codiceCausaleOLO + ", descrizioneCausaleOLO=" + descrizioneCausaleOLO + ", descrizioneCausaleNOW="
				+ descrizioneCausaleNOW + ", duvo=" + duvo + ", sottolavorazione=" + sottolavorazione
				+ ", tipoLavorazione=" + tipoLavorazione + ", modalitaFatturazione=" + modalitaFatturazione + ", dpp="
				+ dpp + ", tipoPacchetto=" + tipoPacchetto + ", noteDaCliente=" + noteDaCliente + ", idRisorsa="
				+ idRisorsa + ", codiceOrdineOlo=" + codiceOrdineOlo + ", flagLavorazioneManuale="
				+ flagLavorazioneManuale + ", codiceOrdineTI=" + codiceOrdineTI + ", noteDaSistema=" + noteDaSistema
				+ ", codiceOLO=" + codiceOLO + ", contratto=" + contratto + ", nomeFile=" + nomeFile
				+ ", codiceOLOOrdinePadre=" + codiceOLOOrdinePadre + ", dataChiusuraOrdine=" + dataChiusuraOrdine
				+ ", identificativoCorrelazioni=" + identificativoCorrelazioni + ", totaleOrdiniPacchetto="
				+ totaleOrdiniPacchetto + ", progetto=" + progetto + ", codiceDelivery=" + codiceDelivery
				+ ", codiceQualita=" + codiceQualita + ", codiceTTM=" + codiceTTM + ", flagMonitoraggio="
				+ flagMonitoraggio + ", statoNOW=" + statoNOW + ", statoOLO=" + statoOLO + ", offerta=" + offerta
				+ ", dro=" + dro + ", dac=" + dac + ", dacRimodulata=" + dacRimodulata + ", dataEspletamentoTecnico="
				+ dataEspletamentoTecnico + ", dataEspletamentoCommerciale=" + dataEspletamentoCommerciale + ", dad="
				+ dad + ", fasciaOraria=" + fasciaOraria + ", dataInvioOrdineDelivery=" + dataInvioOrdineDelivery
				+ ", dataInvioCommercializzazione=" + dataInvioCommercializzazione + ", idullco=" + idullco
				+ ", numeroVerdeOLOPT=" + numeroVerdeOLOPT + ", numeroVerdeOLOCollaudo=" + numeroVerdeOLOCollaudo
				+ ", centrale=" + centrale + ", codiceGAT=" + codiceGAT + ", dnOloCollaudo=" + dnOloCollaudo
				+ ", idsluco=" + idsluco + ", dadRimodulata=" + dadRimodulata + ", ro=" + ro + ", contenutoXml="
				+ contenutoXml + ", flagPreventivo=" + flagPreventivo + ", flagOpereSpeciali=" + flagOpereSpeciali
				+ ", idOfferta=" + idOfferta + ", dataPrevistaSoluzione=" + dataPrevistaSoluzione
				+ ", inAttesaDesospensioneDaOao=" + inAttesaDesospensioneDaOao + ", dataUltimoAppuntamento="
				+ dataUltimoAppuntamento + ", oraUltimoAppuntamento=" + oraUltimoAppuntamento
				+ ", codiceRisorsaDonating1=" + codiceRisorsaDonating1 + ", codiceRisorsaDonating2="
				+ codiceRisorsaDonating2 + ", codiceSessione1=" + codiceSessione1 + ", codiceSessione2="
				+ codiceSessione2 + ", opzioneDinamica=" + opzioneDinamica + ", idRisorsaOperatoreRete="
				+ idRisorsaOperatoreRete + ", dataCreazioneOrdine=" + dataCreazioneOrdine + ", rendezVous=" + rendezVous
				+ ", dettagliAltroOperatoreRete=" + dettagliAltroOperatoreRete + ", operatoreRete=" + operatoreRete
				+ ", intermediateAgentFull=" + intermediateAgentFull + "]";
	}

	
}
