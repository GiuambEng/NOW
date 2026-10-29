package com.nttdata.tim.now.data.dto.dtu;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DettaglioDtuOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = 4792729126065178363L;

	@JsonProperty("cod_impianto")
	private String codiceImpianto;

	@JsonProperty("cod_indirizzo")
	private String codiceIndirizzo;

	@JsonProperty("cod_istat_comune")
	private String codiceIstatComune;

	@JsonProperty("complesso")
	private String complesso;

	@JsonProperty("comune")
	private String comune;

	@JsonProperty("coppia")
	private String coppia;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dac")
	private Date dac;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_appuntamento")
	private Date dataAppuntamento;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_asu")
	private Date dataAsu;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_chiusura")
	private Date dataChiusura;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_invio_rich")
	private Date dataInvioRichiesta;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_permuta_armadio")
	private Date dataPermutaArmadio;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_telefonata")
	private Date dataTelefonata;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("des")
	private Date des;

	@JsonProperty("desc_prov")
	private String descrizioneProv;

	@JsonProperty("destinazione_d_uso")
	private String destinazioneDUso;

	@JsonProperty("distr")
	private String distr;

	@JsonProperty("dlci_utente")
	private String dlciUtente;

	@JsonProperty("dpnr")
	private String dpnr;

	@JsonProperty("dps")
	private String dps;

	@JsonProperty("esito")
	private String esito;

	@JsonProperty("fascia_oraria")
	private String fasciaOraria;

	@JsonProperty("id_arl_ti")
	private String idArlTi;

	@JsonProperty("id_odr")
	private String idOdr;

	@JsonProperty("id_vlan")
	private String idVlan;

	@JsonProperty("idarlolo")
	private String idarlolo;

	@JsonProperty("id_rich_olo")
	private String idRichOlo;

	@JsonProperty("idsluco")
	private String idsluco;

	@JsonProperty("idullpa")
	private String idullpa;

	@JsonProperty("impresa")
	private String impresa;

	@JsonProperty("indicatore_di_assrce")
	private String indicatoreDiAssrce;

	@JsonProperty("indicatore_di_scaffale")
	private String indicatoreDiScaffale;

	@JsonProperty("indirizzo_ip_1")
	private String indirizzoIp1;

	@JsonProperty("indirizzo_ip_2")
	private String indirizzoIp2;

	@JsonProperty("indirizzo_ip_3")
	private String indirizzoIp3;

	@JsonProperty("indirizzo_ip_4")
	private String indirizzoIp4;

	@JsonProperty("intermediate_agent")
	private String intermediateAgent;

	@JsonProperty("interno")
	private String interno;

	@JsonProperty("istat_prov")
	private String istatProv;

	@JsonProperty("istat_via")
	private String istatVia;

	@JsonProperty("localita")
	private String localita;

	@JsonProperty("lunghezza_coda")
	private String lunghezzaCoda;

	@JsonProperty("margine_di_rumore_down")
	private String margineDiRumoreDown;

	@JsonProperty("margine_di_rumore_up")
	private String margineDiRumoreUp;

	@JsonProperty("modem_rete_ti")
	private String modemReteTi;

	@JsonProperty("modem_sede_cliente")
	private String modemSedeCliente;

	@JsonProperty("montante_1")
	private String montante1;

	@JsonProperty("montante_2")
	private String montante2;

	@JsonProperty("nodo_1")
	private String nodo1;

	@JsonProperty("nodo_2")
	private String nodo2;

	@JsonProperty("note_per_olo")
	private String notePerOlo;

	@JsonProperty("numero_coppie_rame")
	private String numeroCoppieRame;

	@JsonProperty("ora_appuntamento")
	private String oraAppuntamento;

	@JsonProperty("ora_des")
	private String oraDes;

	@JsonProperty("ora_telefonata")
	private String oraTelefonata;

	@JsonProperty("paglietta_1_1")
	private String paglietta11;

	@JsonProperty("paglietta_1_2")
	private String paglietta12;

	@JsonProperty("paglietta_2_1")
	private String paglietta21;

	@JsonProperty("paglietta_2_2")
	private String paglietta22;

	@JsonProperty("particella_topon")
	private String particellaTopon;

	@JsonProperty("permuta_armadio")
	private String permutaArmadio;

	@JsonProperty("piano")
	private String piano;

	@JsonProperty("posizione_arl_olo_1")
	private String posizioneArlOlo1;

	@JsonProperty("posizione_arl_olo_2")
	private String posizioneArlOlo2;

	@JsonProperty("posizione_arl_ti_1")
	private String posizioneArlTi1;

	@JsonProperty("posizione_arl_ti_2")
	private String posizioneArlTi2;

	@JsonProperty("posizione_coda")
	private String posizioneCoda;

	@JsonProperty("posizione_permutatore_1")
	private String posizionePermutatore1;

	@JsonProperty("posizione_permutatore_2")
	private String posizionePermutatore2;

	@JsonProperty("progrs_rif")
	private String progressivoRiferimento;

	@JsonProperty("rdac")
	private String rdac;

	@JsonProperty("ripartitore")
	private String ripartitore;

	@JsonProperty("scala")
	private String scala;

	@JsonProperty("tecnologia")
	private String tecnologia;

	@JsonProperty("tel_aggiuntivo_1")
	private String telefonoAggiuntivo1;

	@JsonProperty("tel_aggiuntivo_2")
	private String telefonoAggiuntivo2;

	@JsonProperty("tel_aggiuntivo_3")
	private String telefonoAggiuntivo3;

	@JsonProperty("tel_aggiuntivo_4")
	private String telefonoAggiuntivo4;

	@JsonProperty("tel_aggiuntivo_5")
	private String telefonoAggiuntivo5;

	@JsonProperty("tel_aggiuntivo_6")
	private String telefonoAggiuntivo6;

	@JsonProperty("tel_aggiuntivo_7")
	private String telefonoAggiuntivo7;

	@JsonProperty("tipo_cessazione")
	private String tipoCessazione;

	@JsonProperty("tipo_clc")
	private String tipoClc;

	@JsonProperty("transaction_id")
	private String transactionId;

	@JsonProperty("uservlan")
	private String uservlan;

	@JsonProperty("utr")
	private String utr;

	@JsonProperty("vci_sp")
	private String vciSp;

	@JsonProperty("vci_utente")
	private String vciUtente;

	@JsonProperty("velocita_aggancio_down")
	private String velocitaAggancioDown;

	@JsonProperty("velocita_aggancio_up")
	private String velocitaAggancioUp;

	@JsonProperty("via")
	private String via;

	@JsonProperty("vpi_rete")
	private String vpiRete;

	@JsonProperty("vpi_sp")
	private String vpiSp;

	@JsonProperty("vpi_utente")
	private String vpiUtente;
	
    @JsonProperty("sezioneAggiuntivi")
    private List<SezioneAggiuntiviOutputDTO> sezioneAggiuntivi;

    public String getCodiceImpianto() {
        return codiceImpianto;
    }

    public void setCodiceImpianto(String codiceImpianto) {
        this.codiceImpianto = codiceImpianto;
    }

    public String getCodiceIndirizzo() {
        return codiceIndirizzo;
    }

    public void setCodiceIndirizzo(String codiceIndirizzo) {
        this.codiceIndirizzo = codiceIndirizzo;
    }

    public String getCodiceIstatComune() {
        return codiceIstatComune;
    }

    public void setCodiceIstatComune(String codiceIstatComune) {
        this.codiceIstatComune = codiceIstatComune;
    }

    public String getComplesso() {
        return complesso;
    }

    public void setComplesso(String complesso) {
        this.complesso = complesso;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getCoppia() {
        return coppia;
    }

    public void setCoppia(String coppia) {
        this.coppia = coppia;
    }

    public Date getDac() {
        return dac;
    }

    public void setDac(Date dac) {
        this.dac = dac;
    }

    public Date getDataAppuntamento() {
        return dataAppuntamento;
    }

    public void setDataAppuntamento(Date dataAppuntamento) {
        this.dataAppuntamento = dataAppuntamento;
    }

    public Date getDataAsu() {
        return dataAsu;
    }

    public void setDataAsu(Date dataAsu) {
        this.dataAsu = dataAsu;
    }

    public Date getDataChiusura() {
        return dataChiusura;
    }

    public void setDataChiusura(Date dataChiusura) {
        this.dataChiusura = dataChiusura;
    }

    public Date getDataInvioRichiesta() {
        return dataInvioRichiesta;
    }

    public void setDataInvioRichiesta(Date dataInvioRichiesta) {
        this.dataInvioRichiesta = dataInvioRichiesta;
    }

    public Date getDataPermutaArmadio() {
        return dataPermutaArmadio;
    }

    public void setDataPermutaArmadio(Date dataPermutaArmadio) {
        this.dataPermutaArmadio = dataPermutaArmadio;
    }

    public Date getDataTelefonata() {
        return dataTelefonata;
    }

    public void setDataTelefonata(Date dataTelefonata) {
        this.dataTelefonata = dataTelefonata;
    }

    public Date getDes() {
        return des;
    }

    public void setDes(Date des) {
        this.des = des;
    }

    public String getDescrizioneProv() {
        return descrizioneProv;
    }

    public void setDescrizioneProv(String descrizioneProv) {
        this.descrizioneProv = descrizioneProv;
    }

    public String getDestinazioneDUso() {
        return destinazioneDUso;
    }

    public void setDestinazioneDUso(String destinazioneDUso) {
        this.destinazioneDUso = destinazioneDUso;
    }

    public String getDistr() {
        return distr;
    }

    public void setDistr(String distr) {
        this.distr = distr;
    }

    public String getDlciUtente() {
        return dlciUtente;
    }

    public void setDlciUtente(String dlciUtente) {
        this.dlciUtente = dlciUtente;
    }

    public String getDpnr() {
        return dpnr;
    }

    public void setDpnr(String dpnr) {
        this.dpnr = dpnr;
    }

    public String getDps() {
        return dps;
    }

    public void setDps(String dps) {
        this.dps = dps;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public String getFasciaOraria() {
        return fasciaOraria;
    }

    public void setFasciaOraria(String fasciaOraria) {
        this.fasciaOraria = fasciaOraria;
    }

    public String getIdArlTi() {
        return idArlTi;
    }

    public void setIdArlTi(String idArlTi) {
        this.idArlTi = idArlTi;
    }

    public String getIdOdr() {
        return idOdr;
    }

    public void setIdOdr(String idOdr) {
        this.idOdr = idOdr;
    }

    public String getIdVlan() {
        return idVlan;
    }

    public void setIdVlan(String idVlan) {
        this.idVlan = idVlan;
    }

    public String getIdarlolo() {
        return idarlolo;
    }

    public void setIdarlolo(String idarlolo) {
        this.idarlolo = idarlolo;
    }

    public String getIdRichOlo() {
        return idRichOlo;
    }

    public void setIdRichOlo(String idRichOlo) {
        this.idRichOlo = idRichOlo;
    }

    public String getIdsluco() {
        return idsluco;
    }

    public void setIdsluco(String idsluco) {
        this.idsluco = idsluco;
    }

    public String getIdullpa() {
        return idullpa;
    }

    public void setIdullpa(String idullpa) {
        this.idullpa = idullpa;
    }

    public String getImpresa() {
        return impresa;
    }

    public void setImpresa(String impresa) {
        this.impresa = impresa;
    }

    public String getIndicatoreDiAssrce() {
        return indicatoreDiAssrce;
    }

    public void setIndicatoreDiAssrce(String indicatoreDiAssrce) {
        this.indicatoreDiAssrce = indicatoreDiAssrce;
    }

    public String getIndicatoreDiScaffale() {
        return indicatoreDiScaffale;
    }

    public void setIndicatoreDiScaffale(String indicatoreDiScaffale) {
        this.indicatoreDiScaffale = indicatoreDiScaffale;
    }

    public String getIndirizzoIp1() {
        return indirizzoIp1;
    }

    public void setIndirizzoIp1(String indirizzoIp1) {
        this.indirizzoIp1 = indirizzoIp1;
    }

    public String getIndirizzoIp2() {
        return indirizzoIp2;
    }

    public void setIndirizzoIp2(String indirizzoIp2) {
        this.indirizzoIp2 = indirizzoIp2;
    }

    public String getIndirizzoIp3() {
        return indirizzoIp3;
    }

    public void setIndirizzoIp3(String indirizzoIp3) {
        this.indirizzoIp3 = indirizzoIp3;
    }

    public String getIndirizzoIp4() {
        return indirizzoIp4;
    }

    public void setIndirizzoIp4(String indirizzoIp4) {
        this.indirizzoIp4 = indirizzoIp4;
    }

    public String getIntermediateAgent() {
        return intermediateAgent;
    }

    public void setIntermediateAgent(String intermediateAgent) {
        this.intermediateAgent = intermediateAgent;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public String getIstatProv() {
        return istatProv;
    }

    public void setIstatProv(String istatProv) {
        this.istatProv = istatProv;
    }

    public String getIstatVia() {
        return istatVia;
    }

    public void setIstatVia(String istatVia) {
        this.istatVia = istatVia;
    }

    public String getLocalita() {
        return localita;
    }

    public void setLocalita(String localita) {
        this.localita = localita;
    }

    public String getLunghezzaCoda() {
        return lunghezzaCoda;
    }

    public void setLunghezzaCoda(String lunghezzaCoda) {
        this.lunghezzaCoda = lunghezzaCoda;
    }

    public String getMargineDiRumoreDown() {
        return margineDiRumoreDown;
    }

    public void setMargineDiRumoreDown(String margineDiRumoreDown) {
        this.margineDiRumoreDown = margineDiRumoreDown;
    }

    public String getMargineDiRumoreUp() {
        return margineDiRumoreUp;
    }

    public void setMargineDiRumoreUp(String margineDiRumoreUp) {
        this.margineDiRumoreUp = margineDiRumoreUp;
    }

    public String getModemReteTi() {
        return modemReteTi;
    }

    public void setModemReteTi(String modemReteTi) {
        this.modemReteTi = modemReteTi;
    }

    public String getModemSedeCliente() {
        return modemSedeCliente;
    }

    public void setModemSedeCliente(String modemSedeCliente) {
        this.modemSedeCliente = modemSedeCliente;
    }

    public String getMontante1() {
        return montante1;
    }

    public void setMontante1(String montante1) {
        this.montante1 = montante1;
    }

    public String getMontante2() {
        return montante2;
    }

    public void setMontante2(String montante2) {
        this.montante2 = montante2;
    }

    public String getNodo1() {
        return nodo1;
    }

    public void setNodo1(String nodo1) {
        this.nodo1 = nodo1;
    }

    public String getNodo2() {
        return nodo2;
    }

    public void setNodo2(String nodo2) {
        this.nodo2 = nodo2;
    }

    public String getNotePerOlo() {
        return notePerOlo;
    }

    public void setNotePerOlo(String notePerOlo) {
        this.notePerOlo = notePerOlo;
    }

    public String getNumeroCoppieRame() {
        return numeroCoppieRame;
    }

    public void setNumeroCoppieRame(String numeroCoppieRame) {
        this.numeroCoppieRame = numeroCoppieRame;
    }

    public String getOraAppuntamento() {
        return oraAppuntamento;
    }

    public void setOraAppuntamento(String oraAppuntamento) {
        this.oraAppuntamento = oraAppuntamento;
    }

    public String getOraDes() {
        return oraDes;
    }

    public void setOraDes(String oraDes) {
        this.oraDes = oraDes;
    }

    public String getOraTelefonata() {
        return oraTelefonata;
    }

    public void setOraTelefonata(String oraTelefonata) {
        this.oraTelefonata = oraTelefonata;
    }

    public String getPaglietta11() {
        return paglietta11;
    }

    public void setPaglietta11(String paglietta11) {
        this.paglietta11 = paglietta11;
    }

    public String getPaglietta12() {
        return paglietta12;
    }

    public void setPaglietta12(String paglietta12) {
        this.paglietta12 = paglietta12;
    }

    public String getPaglietta21() {
        return paglietta21;
    }

    public void setPaglietta21(String paglietta21) {
        this.paglietta21 = paglietta21;
    }

    public String getPaglietta22() {
        return paglietta22;
    }

    public void setPaglietta22(String paglietta22) {
        this.paglietta22 = paglietta22;
    }

    public String getParticellaTopon() {
        return particellaTopon;
    }

    public void setParticellaTopon(String particellaTopon) {
        this.particellaTopon = particellaTopon;
    }

    public String getPermutaArmadio() {
        return permutaArmadio;
    }

    public void setPermutaArmadio(String permutaArmadio) {
        this.permutaArmadio = permutaArmadio;
    }

    public String getPiano() {
        return piano;
    }

    public void setPiano(String piano) {
        this.piano = piano;
    }

    public String getPosizioneArlOlo1() {
        return posizioneArlOlo1;
    }

    public void setPosizioneArlOlo1(String posizioneArlOlo1) {
        this.posizioneArlOlo1 = posizioneArlOlo1;
    }

    public String getPosizioneArlOlo2() {
        return posizioneArlOlo2;
    }

    public void setPosizioneArlOlo2(String posizioneArlOlo2) {
        this.posizioneArlOlo2 = posizioneArlOlo2;
    }

    public String getPosizioneArlTi1() {
        return posizioneArlTi1;
    }

    public void setPosizioneArlTi1(String posizioneArlTi1) {
        this.posizioneArlTi1 = posizioneArlTi1;
    }

    public String getPosizioneArlTi2() {
        return posizioneArlTi2;
    }

    public void setPosizioneArlTi2(String posizioneArlTi2) {
        this.posizioneArlTi2 = posizioneArlTi2;
    }

    public String getPosizioneCoda() {
        return posizioneCoda;
    }

    public void setPosizioneCoda(String posizioneCoda) {
        this.posizioneCoda = posizioneCoda;
    }

    public String getPosizionePermutatore1() {
        return posizionePermutatore1;
    }

    public void setPosizionePermutatore1(String posizionePermutatore1) {
        this.posizionePermutatore1 = posizionePermutatore1;
    }

    public String getPosizionePermutatore2() {
        return posizionePermutatore2;
    }

    public void setPosizionePermutatore2(String posizionePermutatore2) {
        this.posizionePermutatore2 = posizionePermutatore2;
    }

    public String getProgressivoRiferimento() {
        return progressivoRiferimento;
    }

    public void setProgressivoRiferimento(String progressivoRiferimento) {
        this.progressivoRiferimento = progressivoRiferimento;
    }

    public String getRdac() {
        return rdac;
    }

    public void setRdac(String rdac) {
        this.rdac = rdac;
    }

    public String getRipartitore() {
        return ripartitore;
    }

    public void setRipartitore(String ripartitore) {
        this.ripartitore = ripartitore;
    }

    public String getScala() {
        return scala;
    }

    public void setScala(String scala) {
        this.scala = scala;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getTelefonoAggiuntivo1() {
        return telefonoAggiuntivo1;
    }

    public void setTelefonoAggiuntivo1(String telefonoAggiuntivo1) {
        this.telefonoAggiuntivo1 = telefonoAggiuntivo1;
    }

    public String getTelefonoAggiuntivo2() {
        return telefonoAggiuntivo2;
    }

    public void setTelefonoAggiuntivo2(String telefonoAggiuntivo2) {
        this.telefonoAggiuntivo2 = telefonoAggiuntivo2;
    }

    public String getTelefonoAggiuntivo3() {
        return telefonoAggiuntivo3;
    }

    public void setTelefonoAggiuntivo3(String telefonoAggiuntivo3) {
        this.telefonoAggiuntivo3 = telefonoAggiuntivo3;
    }

    public String getTelefonoAggiuntivo4() {
        return telefonoAggiuntivo4;
    }

    public void setTelefonoAggiuntivo4(String telefonoAggiuntivo4) {
        this.telefonoAggiuntivo4 = telefonoAggiuntivo4;
    }

    public String getTelefonoAggiuntivo5() {
        return telefonoAggiuntivo5;
    }

    public void setTelefonoAggiuntivo5(String telefonoAggiuntivo5) {
        this.telefonoAggiuntivo5 = telefonoAggiuntivo5;
    }

    public String getTelefonoAggiuntivo6() {
        return telefonoAggiuntivo6;
    }

    public void setTelefonoAggiuntivo6(String telefonoAggiuntivo6) {
        this.telefonoAggiuntivo6 = telefonoAggiuntivo6;
    }

    public String getTelefonoAggiuntivo7() {
        return telefonoAggiuntivo7;
    }

    public void setTelefonoAggiuntivo7(String telefonoAggiuntivo7) {
        this.telefonoAggiuntivo7 = telefonoAggiuntivo7;
    }

    public String getTipoCessazione() {
        return tipoCessazione;
    }

    public void setTipoCessazione(String tipoCessazione) {
        this.tipoCessazione = tipoCessazione;
    }

    public String getTipoClc() {
        return tipoClc;
    }

    public void setTipoClc(String tipoClc) {
        this.tipoClc = tipoClc;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUservlan() {
        return uservlan;
    }

    public void setUservlan(String uservlan) {
        this.uservlan = uservlan;
    }

    public String getUtr() {
        return utr;
    }

    public void setUtr(String utr) {
        this.utr = utr;
    }

    public String getVciSp() {
        return vciSp;
    }

    public void setVciSp(String vciSp) {
        this.vciSp = vciSp;
    }

    public String getVciUtente() {
        return vciUtente;
    }

    public void setVciUtente(String vciUtente) {
        this.vciUtente = vciUtente;
    }

    public String getVelocitaAggancioDown() {
        return velocitaAggancioDown;
    }

    public void setVelocitaAggancioDown(String velocitaAggancioDown) {
        this.velocitaAggancioDown = velocitaAggancioDown;
    }

    public String getVelocitaAggancioUp() {
        return velocitaAggancioUp;
    }

    public void setVelocitaAggancioUp(String velocitaAggancioUp) {
        this.velocitaAggancioUp = velocitaAggancioUp;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getVpiRete() {
        return vpiRete;
    }

    public void setVpiRete(String vpiRete) {
        this.vpiRete = vpiRete;
    }

    public String getVpiSp() {
        return vpiSp;
    }

    public void setVpiSp(String vpiSp) {
        this.vpiSp = vpiSp;
    }

    public String getVpiUtente() {
        return vpiUtente;
    }

    public void setVpiUtente(String vpiUtente) {
        this.vpiUtente = vpiUtente;
    }

    public List<SezioneAggiuntiviOutputDTO> getSezioneAggiuntivi() {
        return sezioneAggiuntivi;
    }

    public void setSezioneAggiuntivi(List<SezioneAggiuntiviOutputDTO> sezioneAggiuntivi) {
        this.sezioneAggiuntivi = sezioneAggiuntivi;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codiceImpianto == null) ? 0 : codiceImpianto.hashCode());
        result = prime * result + ((codiceIndirizzo == null) ? 0 : codiceIndirizzo.hashCode());
        result = prime * result + ((codiceIstatComune == null) ? 0 : codiceIstatComune.hashCode());
        result = prime * result + ((complesso == null) ? 0 : complesso.hashCode());
        result = prime * result + ((comune == null) ? 0 : comune.hashCode());
        result = prime * result + ((coppia == null) ? 0 : coppia.hashCode());
        result = prime * result + ((dac == null) ? 0 : dac.hashCode());
        result = prime * result + ((dataAppuntamento == null) ? 0 : dataAppuntamento.hashCode());
        result = prime * result + ((dataAsu == null) ? 0 : dataAsu.hashCode());
        result = prime * result + ((dataChiusura == null) ? 0 : dataChiusura.hashCode());
        result = prime * result + ((dataInvioRichiesta == null) ? 0 : dataInvioRichiesta.hashCode());
        result = prime * result + ((dataPermutaArmadio == null) ? 0 : dataPermutaArmadio.hashCode());
        result = prime * result + ((dataTelefonata == null) ? 0 : dataTelefonata.hashCode());
        result = prime * result + ((des == null) ? 0 : des.hashCode());
        result = prime * result + ((descrizioneProv == null) ? 0 : descrizioneProv.hashCode());
        result = prime * result + ((destinazioneDUso == null) ? 0 : destinazioneDUso.hashCode());
        result = prime * result + ((distr == null) ? 0 : distr.hashCode());
        result = prime * result + ((dlciUtente == null) ? 0 : dlciUtente.hashCode());
        result = prime * result + ((dpnr == null) ? 0 : dpnr.hashCode());
        result = prime * result + ((dps == null) ? 0 : dps.hashCode());
        result = prime * result + ((esito == null) ? 0 : esito.hashCode());
        result = prime * result + ((fasciaOraria == null) ? 0 : fasciaOraria.hashCode());
        result = prime * result + ((idArlTi == null) ? 0 : idArlTi.hashCode());
        result = prime * result + ((idOdr == null) ? 0 : idOdr.hashCode());
        result = prime * result + ((idRichOlo == null) ? 0 : idRichOlo.hashCode());
        result = prime * result + ((idVlan == null) ? 0 : idVlan.hashCode());
        result = prime * result + ((idarlolo == null) ? 0 : idarlolo.hashCode());
        result = prime * result + ((idsluco == null) ? 0 : idsluco.hashCode());
        result = prime * result + ((idullpa == null) ? 0 : idullpa.hashCode());
        result = prime * result + ((impresa == null) ? 0 : impresa.hashCode());
        result = prime * result + ((indicatoreDiAssrce == null) ? 0 : indicatoreDiAssrce.hashCode());
        result = prime * result + ((indicatoreDiScaffale == null) ? 0 : indicatoreDiScaffale.hashCode());
        result = prime * result + ((indirizzoIp1 == null) ? 0 : indirizzoIp1.hashCode());
        result = prime * result + ((indirizzoIp2 == null) ? 0 : indirizzoIp2.hashCode());
        result = prime * result + ((indirizzoIp3 == null) ? 0 : indirizzoIp3.hashCode());
        result = prime * result + ((indirizzoIp4 == null) ? 0 : indirizzoIp4.hashCode());
        result = prime * result + ((intermediateAgent == null) ? 0 : intermediateAgent.hashCode());
        result = prime * result + ((interno == null) ? 0 : interno.hashCode());
        result = prime * result + ((istatProv == null) ? 0 : istatProv.hashCode());
        result = prime * result + ((istatVia == null) ? 0 : istatVia.hashCode());
        result = prime * result + ((localita == null) ? 0 : localita.hashCode());
        result = prime * result + ((lunghezzaCoda == null) ? 0 : lunghezzaCoda.hashCode());
        result = prime * result + ((margineDiRumoreDown == null) ? 0 : margineDiRumoreDown.hashCode());
        result = prime * result + ((margineDiRumoreUp == null) ? 0 : margineDiRumoreUp.hashCode());
        result = prime * result + ((modemReteTi == null) ? 0 : modemReteTi.hashCode());
        result = prime * result + ((modemSedeCliente == null) ? 0 : modemSedeCliente.hashCode());
        result = prime * result + ((montante1 == null) ? 0 : montante1.hashCode());
        result = prime * result + ((montante2 == null) ? 0 : montante2.hashCode());
        result = prime * result + ((nodo1 == null) ? 0 : nodo1.hashCode());
        result = prime * result + ((nodo2 == null) ? 0 : nodo2.hashCode());
        result = prime * result + ((notePerOlo == null) ? 0 : notePerOlo.hashCode());
        result = prime * result + ((numeroCoppieRame == null) ? 0 : numeroCoppieRame.hashCode());
        result = prime * result + ((oraAppuntamento == null) ? 0 : oraAppuntamento.hashCode());
        result = prime * result + ((oraDes == null) ? 0 : oraDes.hashCode());
        result = prime * result + ((oraTelefonata == null) ? 0 : oraTelefonata.hashCode());
        result = prime * result + ((paglietta11 == null) ? 0 : paglietta11.hashCode());
        result = prime * result + ((paglietta12 == null) ? 0 : paglietta12.hashCode());
        result = prime * result + ((paglietta21 == null) ? 0 : paglietta21.hashCode());
        result = prime * result + ((paglietta22 == null) ? 0 : paglietta22.hashCode());
        result = prime * result + ((particellaTopon == null) ? 0 : particellaTopon.hashCode());
        result = prime * result + ((permutaArmadio == null) ? 0 : permutaArmadio.hashCode());
        result = prime * result + ((piano == null) ? 0 : piano.hashCode());
        result = prime * result + ((posizioneArlOlo1 == null) ? 0 : posizioneArlOlo1.hashCode());
        result = prime * result + ((posizioneArlOlo2 == null) ? 0 : posizioneArlOlo2.hashCode());
        result = prime * result + ((posizioneArlTi1 == null) ? 0 : posizioneArlTi1.hashCode());
        result = prime * result + ((posizioneArlTi2 == null) ? 0 : posizioneArlTi2.hashCode());
        result = prime * result + ((posizioneCoda == null) ? 0 : posizioneCoda.hashCode());
        result = prime * result + ((posizionePermutatore1 == null) ? 0 : posizionePermutatore1.hashCode());
        result = prime * result + ((posizionePermutatore2 == null) ? 0 : posizionePermutatore2.hashCode());
        result = prime * result + ((progressivoRiferimento == null) ? 0 : progressivoRiferimento.hashCode());
        result = prime * result + ((rdac == null) ? 0 : rdac.hashCode());
        result = prime * result + ((ripartitore == null) ? 0 : ripartitore.hashCode());
        result = prime * result + ((scala == null) ? 0 : scala.hashCode());
        result = prime * result + ((sezioneAggiuntivi == null) ? 0 : sezioneAggiuntivi.hashCode());
        result = prime * result + ((tecnologia == null) ? 0 : tecnologia.hashCode());
        result = prime * result + ((telefonoAggiuntivo1 == null) ? 0 : telefonoAggiuntivo1.hashCode());
        result = prime * result + ((telefonoAggiuntivo2 == null) ? 0 : telefonoAggiuntivo2.hashCode());
        result = prime * result + ((telefonoAggiuntivo3 == null) ? 0 : telefonoAggiuntivo3.hashCode());
        result = prime * result + ((telefonoAggiuntivo4 == null) ? 0 : telefonoAggiuntivo4.hashCode());
        result = prime * result + ((telefonoAggiuntivo5 == null) ? 0 : telefonoAggiuntivo5.hashCode());
        result = prime * result + ((telefonoAggiuntivo6 == null) ? 0 : telefonoAggiuntivo6.hashCode());
        result = prime * result + ((telefonoAggiuntivo7 == null) ? 0 : telefonoAggiuntivo7.hashCode());
        result = prime * result + ((tipoCessazione == null) ? 0 : tipoCessazione.hashCode());
        result = prime * result + ((tipoClc == null) ? 0 : tipoClc.hashCode());
        result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
        result = prime * result + ((uservlan == null) ? 0 : uservlan.hashCode());
        result = prime * result + ((utr == null) ? 0 : utr.hashCode());
        result = prime * result + ((vciSp == null) ? 0 : vciSp.hashCode());
        result = prime * result + ((vciUtente == null) ? 0 : vciUtente.hashCode());
        result = prime * result + ((velocitaAggancioDown == null) ? 0 : velocitaAggancioDown.hashCode());
        result = prime * result + ((velocitaAggancioUp == null) ? 0 : velocitaAggancioUp.hashCode());
        result = prime * result + ((via == null) ? 0 : via.hashCode());
        result = prime * result + ((vpiRete == null) ? 0 : vpiRete.hashCode());
        result = prime * result + ((vpiSp == null) ? 0 : vpiSp.hashCode());
        result = prime * result + ((vpiUtente == null) ? 0 : vpiUtente.hashCode());
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
        DettaglioDtuOutputDTO other = (DettaglioDtuOutputDTO) obj;
        if (codiceImpianto == null) {
            if (other.codiceImpianto != null)
                return false;
        } else if (!codiceImpianto.equals(other.codiceImpianto))
            return false;
        if (codiceIndirizzo == null) {
            if (other.codiceIndirizzo != null)
                return false;
        } else if (!codiceIndirizzo.equals(other.codiceIndirizzo))
            return false;
        if (codiceIstatComune == null) {
            if (other.codiceIstatComune != null)
                return false;
        } else if (!codiceIstatComune.equals(other.codiceIstatComune))
            return false;
        if (complesso == null) {
            if (other.complesso != null)
                return false;
        } else if (!complesso.equals(other.complesso))
            return false;
        if (comune == null) {
            if (other.comune != null)
                return false;
        } else if (!comune.equals(other.comune))
            return false;
        if (coppia == null) {
            if (other.coppia != null)
                return false;
        } else if (!coppia.equals(other.coppia))
            return false;
        if (dac == null) {
            if (other.dac != null)
                return false;
        } else if (!dac.equals(other.dac))
            return false;
        if (dataAppuntamento == null) {
            if (other.dataAppuntamento != null)
                return false;
        } else if (!dataAppuntamento.equals(other.dataAppuntamento))
            return false;
        if (dataAsu == null) {
            if (other.dataAsu != null)
                return false;
        } else if (!dataAsu.equals(other.dataAsu))
            return false;
        if (dataChiusura == null) {
            if (other.dataChiusura != null)
                return false;
        } else if (!dataChiusura.equals(other.dataChiusura))
            return false;
        if (dataInvioRichiesta == null) {
            if (other.dataInvioRichiesta != null)
                return false;
        } else if (!dataInvioRichiesta.equals(other.dataInvioRichiesta))
            return false;
        if (dataPermutaArmadio == null) {
            if (other.dataPermutaArmadio != null)
                return false;
        } else if (!dataPermutaArmadio.equals(other.dataPermutaArmadio))
            return false;
        if (dataTelefonata == null) {
            if (other.dataTelefonata != null)
                return false;
        } else if (!dataTelefonata.equals(other.dataTelefonata))
            return false;
        if (des == null) {
            if (other.des != null)
                return false;
        } else if (!des.equals(other.des))
            return false;
        if (descrizioneProv == null) {
            if (other.descrizioneProv != null)
                return false;
        } else if (!descrizioneProv.equals(other.descrizioneProv))
            return false;
        if (destinazioneDUso == null) {
            if (other.destinazioneDUso != null)
                return false;
        } else if (!destinazioneDUso.equals(other.destinazioneDUso))
            return false;
        if (distr == null) {
            if (other.distr != null)
                return false;
        } else if (!distr.equals(other.distr))
            return false;
        if (dlciUtente == null) {
            if (other.dlciUtente != null)
                return false;
        } else if (!dlciUtente.equals(other.dlciUtente))
            return false;
        if (dpnr == null) {
            if (other.dpnr != null)
                return false;
        } else if (!dpnr.equals(other.dpnr))
            return false;
        if (dps == null) {
            if (other.dps != null)
                return false;
        } else if (!dps.equals(other.dps))
            return false;
        if (esito == null) {
            if (other.esito != null)
                return false;
        } else if (!esito.equals(other.esito))
            return false;
        if (fasciaOraria == null) {
            if (other.fasciaOraria != null)
                return false;
        } else if (!fasciaOraria.equals(other.fasciaOraria))
            return false;
        if (idArlTi == null) {
            if (other.idArlTi != null)
                return false;
        } else if (!idArlTi.equals(other.idArlTi))
            return false;
        if (idOdr == null) {
            if (other.idOdr != null)
                return false;
        } else if (!idOdr.equals(other.idOdr))
            return false;
        if (idRichOlo == null) {
            if (other.idRichOlo != null)
                return false;
        } else if (!idRichOlo.equals(other.idRichOlo))
            return false;
        if (idVlan == null) {
            if (other.idVlan != null)
                return false;
        } else if (!idVlan.equals(other.idVlan))
            return false;
        if (idarlolo == null) {
            if (other.idarlolo != null)
                return false;
        } else if (!idarlolo.equals(other.idarlolo))
            return false;
        if (idsluco == null) {
            if (other.idsluco != null)
                return false;
        } else if (!idsluco.equals(other.idsluco))
            return false;
        if (idullpa == null) {
            if (other.idullpa != null)
                return false;
        } else if (!idullpa.equals(other.idullpa))
            return false;
        if (impresa == null) {
            if (other.impresa != null)
                return false;
        } else if (!impresa.equals(other.impresa))
            return false;
        if (indicatoreDiAssrce == null) {
            if (other.indicatoreDiAssrce != null)
                return false;
        } else if (!indicatoreDiAssrce.equals(other.indicatoreDiAssrce))
            return false;
        if (indicatoreDiScaffale == null) {
            if (other.indicatoreDiScaffale != null)
                return false;
        } else if (!indicatoreDiScaffale.equals(other.indicatoreDiScaffale))
            return false;
        if (indirizzoIp1 == null) {
            if (other.indirizzoIp1 != null)
                return false;
        } else if (!indirizzoIp1.equals(other.indirizzoIp1))
            return false;
        if (indirizzoIp2 == null) {
            if (other.indirizzoIp2 != null)
                return false;
        } else if (!indirizzoIp2.equals(other.indirizzoIp2))
            return false;
        if (indirizzoIp3 == null) {
            if (other.indirizzoIp3 != null)
                return false;
        } else if (!indirizzoIp3.equals(other.indirizzoIp3))
            return false;
        if (indirizzoIp4 == null) {
            if (other.indirizzoIp4 != null)
                return false;
        } else if (!indirizzoIp4.equals(other.indirizzoIp4))
            return false;
        if (intermediateAgent == null) {
            if (other.intermediateAgent != null)
                return false;
        } else if (!intermediateAgent.equals(other.intermediateAgent))
            return false;
        if (interno == null) {
            if (other.interno != null)
                return false;
        } else if (!interno.equals(other.interno))
            return false;
        if (istatProv == null) {
            if (other.istatProv != null)
                return false;
        } else if (!istatProv.equals(other.istatProv))
            return false;
        if (istatVia == null) {
            if (other.istatVia != null)
                return false;
        } else if (!istatVia.equals(other.istatVia))
            return false;
        if (localita == null) {
            if (other.localita != null)
                return false;
        } else if (!localita.equals(other.localita))
            return false;
        if (lunghezzaCoda == null) {
            if (other.lunghezzaCoda != null)
                return false;
        } else if (!lunghezzaCoda.equals(other.lunghezzaCoda))
            return false;
        if (margineDiRumoreDown == null) {
            if (other.margineDiRumoreDown != null)
                return false;
        } else if (!margineDiRumoreDown.equals(other.margineDiRumoreDown))
            return false;
        if (margineDiRumoreUp == null) {
            if (other.margineDiRumoreUp != null)
                return false;
        } else if (!margineDiRumoreUp.equals(other.margineDiRumoreUp))
            return false;
        if (modemReteTi == null) {
            if (other.modemReteTi != null)
                return false;
        } else if (!modemReteTi.equals(other.modemReteTi))
            return false;
        if (modemSedeCliente == null) {
            if (other.modemSedeCliente != null)
                return false;
        } else if (!modemSedeCliente.equals(other.modemSedeCliente))
            return false;
        if (montante1 == null) {
            if (other.montante1 != null)
                return false;
        } else if (!montante1.equals(other.montante1))
            return false;
        if (montante2 == null) {
            if (other.montante2 != null)
                return false;
        } else if (!montante2.equals(other.montante2))
            return false;
        if (nodo1 == null) {
            if (other.nodo1 != null)
                return false;
        } else if (!nodo1.equals(other.nodo1))
            return false;
        if (nodo2 == null) {
            if (other.nodo2 != null)
                return false;
        } else if (!nodo2.equals(other.nodo2))
            return false;
        if (notePerOlo == null) {
            if (other.notePerOlo != null)
                return false;
        } else if (!notePerOlo.equals(other.notePerOlo))
            return false;
        if (numeroCoppieRame == null) {
            if (other.numeroCoppieRame != null)
                return false;
        } else if (!numeroCoppieRame.equals(other.numeroCoppieRame))
            return false;
        if (oraAppuntamento == null) {
            if (other.oraAppuntamento != null)
                return false;
        } else if (!oraAppuntamento.equals(other.oraAppuntamento))
            return false;
        if (oraDes == null) {
            if (other.oraDes != null)
                return false;
        } else if (!oraDes.equals(other.oraDes))
            return false;
        if (oraTelefonata == null) {
            if (other.oraTelefonata != null)
                return false;
        } else if (!oraTelefonata.equals(other.oraTelefonata))
            return false;
        if (paglietta11 == null) {
            if (other.paglietta11 != null)
                return false;
        } else if (!paglietta11.equals(other.paglietta11))
            return false;
        if (paglietta12 == null) {
            if (other.paglietta12 != null)
                return false;
        } else if (!paglietta12.equals(other.paglietta12))
            return false;
        if (paglietta21 == null) {
            if (other.paglietta21 != null)
                return false;
        } else if (!paglietta21.equals(other.paglietta21))
            return false;
        if (paglietta22 == null) {
            if (other.paglietta22 != null)
                return false;
        } else if (!paglietta22.equals(other.paglietta22))
            return false;
        if (particellaTopon == null) {
            if (other.particellaTopon != null)
                return false;
        } else if (!particellaTopon.equals(other.particellaTopon))
            return false;
        if (permutaArmadio == null) {
            if (other.permutaArmadio != null)
                return false;
        } else if (!permutaArmadio.equals(other.permutaArmadio))
            return false;
        if (piano == null) {
            if (other.piano != null)
                return false;
        } else if (!piano.equals(other.piano))
            return false;
        if (posizioneArlOlo1 == null) {
            if (other.posizioneArlOlo1 != null)
                return false;
        } else if (!posizioneArlOlo1.equals(other.posizioneArlOlo1))
            return false;
        if (posizioneArlOlo2 == null) {
            if (other.posizioneArlOlo2 != null)
                return false;
        } else if (!posizioneArlOlo2.equals(other.posizioneArlOlo2))
            return false;
        if (posizioneArlTi1 == null) {
            if (other.posizioneArlTi1 != null)
                return false;
        } else if (!posizioneArlTi1.equals(other.posizioneArlTi1))
            return false;
        if (posizioneArlTi2 == null) {
            if (other.posizioneArlTi2 != null)
                return false;
        } else if (!posizioneArlTi2.equals(other.posizioneArlTi2))
            return false;
        if (posizioneCoda == null) {
            if (other.posizioneCoda != null)
                return false;
        } else if (!posizioneCoda.equals(other.posizioneCoda))
            return false;
        if (posizionePermutatore1 == null) {
            if (other.posizionePermutatore1 != null)
                return false;
        } else if (!posizionePermutatore1.equals(other.posizionePermutatore1))
            return false;
        if (posizionePermutatore2 == null) {
            if (other.posizionePermutatore2 != null)
                return false;
        } else if (!posizionePermutatore2.equals(other.posizionePermutatore2))
            return false;
        if (progressivoRiferimento == null) {
            if (other.progressivoRiferimento != null)
                return false;
        } else if (!progressivoRiferimento.equals(other.progressivoRiferimento))
            return false;
        if (rdac == null) {
            if (other.rdac != null)
                return false;
        } else if (!rdac.equals(other.rdac))
            return false;
        if (ripartitore == null) {
            if (other.ripartitore != null)
                return false;
        } else if (!ripartitore.equals(other.ripartitore))
            return false;
        if (scala == null) {
            if (other.scala != null)
                return false;
        } else if (!scala.equals(other.scala))
            return false;
        if (sezioneAggiuntivi == null) {
            if (other.sezioneAggiuntivi != null)
                return false;
        } else if (!sezioneAggiuntivi.equals(other.sezioneAggiuntivi))
            return false;
        if (tecnologia == null) {
            if (other.tecnologia != null)
                return false;
        } else if (!tecnologia.equals(other.tecnologia))
            return false;
        if (telefonoAggiuntivo1 == null) {
            if (other.telefonoAggiuntivo1 != null)
                return false;
        } else if (!telefonoAggiuntivo1.equals(other.telefonoAggiuntivo1))
            return false;
        if (telefonoAggiuntivo2 == null) {
            if (other.telefonoAggiuntivo2 != null)
                return false;
        } else if (!telefonoAggiuntivo2.equals(other.telefonoAggiuntivo2))
            return false;
        if (telefonoAggiuntivo3 == null) {
            if (other.telefonoAggiuntivo3 != null)
                return false;
        } else if (!telefonoAggiuntivo3.equals(other.telefonoAggiuntivo3))
            return false;
        if (telefonoAggiuntivo4 == null) {
            if (other.telefonoAggiuntivo4 != null)
                return false;
        } else if (!telefonoAggiuntivo4.equals(other.telefonoAggiuntivo4))
            return false;
        if (telefonoAggiuntivo5 == null) {
            if (other.telefonoAggiuntivo5 != null)
                return false;
        } else if (!telefonoAggiuntivo5.equals(other.telefonoAggiuntivo5))
            return false;
        if (telefonoAggiuntivo6 == null) {
            if (other.telefonoAggiuntivo6 != null)
                return false;
        } else if (!telefonoAggiuntivo6.equals(other.telefonoAggiuntivo6))
            return false;
        if (telefonoAggiuntivo7 == null) {
            if (other.telefonoAggiuntivo7 != null)
                return false;
        } else if (!telefonoAggiuntivo7.equals(other.telefonoAggiuntivo7))
            return false;
        if (tipoCessazione == null) {
            if (other.tipoCessazione != null)
                return false;
        } else if (!tipoCessazione.equals(other.tipoCessazione))
            return false;
        if (tipoClc == null) {
            if (other.tipoClc != null)
                return false;
        } else if (!tipoClc.equals(other.tipoClc))
            return false;
        if (transactionId == null) {
            if (other.transactionId != null)
                return false;
        } else if (!transactionId.equals(other.transactionId))
            return false;
        if (uservlan == null) {
            if (other.uservlan != null)
                return false;
        } else if (!uservlan.equals(other.uservlan))
            return false;
        if (utr == null) {
            if (other.utr != null)
                return false;
        } else if (!utr.equals(other.utr))
            return false;
        if (vciSp == null) {
            if (other.vciSp != null)
                return false;
        } else if (!vciSp.equals(other.vciSp))
            return false;
        if (vciUtente == null) {
            if (other.vciUtente != null)
                return false;
        } else if (!vciUtente.equals(other.vciUtente))
            return false;
        if (velocitaAggancioDown == null) {
            if (other.velocitaAggancioDown != null)
                return false;
        } else if (!velocitaAggancioDown.equals(other.velocitaAggancioDown))
            return false;
        if (velocitaAggancioUp == null) {
            if (other.velocitaAggancioUp != null)
                return false;
        } else if (!velocitaAggancioUp.equals(other.velocitaAggancioUp))
            return false;
        if (via == null) {
            if (other.via != null)
                return false;
        } else if (!via.equals(other.via))
            return false;
        if (vpiRete == null) {
            if (other.vpiRete != null)
                return false;
        } else if (!vpiRete.equals(other.vpiRete))
            return false;
        if (vpiSp == null) {
            if (other.vpiSp != null)
                return false;
        } else if (!vpiSp.equals(other.vpiSp))
            return false;
        if (vpiUtente == null) {
            if (other.vpiUtente != null)
                return false;
        } else if (!vpiUtente.equals(other.vpiUtente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DettaglioDtuOutputDTO [codiceImpianto=" + codiceImpianto + ", codiceIndirizzo=" + codiceIndirizzo + ", codiceIstatComune=" + codiceIstatComune
                + ", complesso=" + complesso + ", comune=" + comune + ", coppia=" + coppia + ", dac=" + dac + ", dataAppuntamento=" + dataAppuntamento
                + ", dataAsu=" + dataAsu + ", dataChiusura=" + dataChiusura + ", dataInvioRichiesta=" + dataInvioRichiesta + ", dataPermutaArmadio="
                + dataPermutaArmadio + ", dataTelefonata=" + dataTelefonata + ", des=" + des + ", descrizioneProv=" + descrizioneProv + ", destinazioneDUso="
                + destinazioneDUso + ", distr=" + distr + ", dlciUtente=" + dlciUtente + ", dpnr=" + dpnr + ", dps=" + dps + ", esito=" + esito
                + ", fasciaOraria=" + fasciaOraria + ", idArlTi=" + idArlTi + ", idOdr=" + idOdr + ", idVlan=" + idVlan + ", idarlolo=" + idarlolo
                + ", idRichOlo=" + idRichOlo + ", idsluco=" + idsluco + ", idullpa=" + idullpa + ", impresa=" + impresa + ", indicatoreDiAssrce="
                + indicatoreDiAssrce + ", indicatoreDiScaffale=" + indicatoreDiScaffale + ", indirizzoIp1=" + indirizzoIp1 + ", indirizzoIp2=" + indirizzoIp2
                + ", indirizzoIp3=" + indirizzoIp3 + ", indirizzoIp4=" + indirizzoIp4 + ", intermediateAgent=" + intermediateAgent + ", interno=" + interno
                + ", istatProv=" + istatProv + ", istatVia=" + istatVia + ", localita=" + localita + ", lunghezzaCoda=" + lunghezzaCoda
                + ", margineDiRumoreDown=" + margineDiRumoreDown + ", margineDiRumoreUp=" + margineDiRumoreUp + ", modemReteTi=" + modemReteTi
                + ", modemSedeCliente=" + modemSedeCliente + ", montante1=" + montante1 + ", montante2=" + montante2 + ", nodo1=" + nodo1 + ", nodo2=" + nodo2
                + ", notePerOlo=" + notePerOlo + ", numeroCoppieRame=" + numeroCoppieRame + ", oraAppuntamento=" + oraAppuntamento + ", oraDes=" + oraDes
                + ", oraTelefonata=" + oraTelefonata + ", paglietta11=" + paglietta11 + ", paglietta12=" + paglietta12 + ", paglietta21=" + paglietta21
                + ", paglietta22=" + paglietta22 + ", particellaTopon=" + particellaTopon + ", permutaArmadio=" + permutaArmadio + ", piano=" + piano
                + ", posizioneArlOlo1=" + posizioneArlOlo1 + ", posizioneArlOlo2=" + posizioneArlOlo2 + ", posizioneArlTi1=" + posizioneArlTi1
                + ", posizioneArlTi2=" + posizioneArlTi2 + ", posizioneCoda=" + posizioneCoda + ", posizionePermutatore1=" + posizionePermutatore1
                + ", posizionePermutatore2=" + posizionePermutatore2 + ", progressivoRiferimento=" + progressivoRiferimento + ", rdac=" + rdac
                + ", ripartitore=" + ripartitore + ", scala=" + scala + ", tecnologia=" + tecnologia + ", telefonoAggiuntivo1=" + telefonoAggiuntivo1
                + ", telefonoAggiuntivo2=" + telefonoAggiuntivo2 + ", telefonoAggiuntivo3=" + telefonoAggiuntivo3 + ", telefonoAggiuntivo4="
                + telefonoAggiuntivo4 + ", telefonoAggiuntivo5=" + telefonoAggiuntivo5 + ", telefonoAggiuntivo6=" + telefonoAggiuntivo6
                + ", telefonoAggiuntivo7=" + telefonoAggiuntivo7 + ", tipoCessazione=" + tipoCessazione + ", tipoClc=" + tipoClc + ", transactionId="
                + transactionId + ", uservlan=" + uservlan + ", utr=" + utr + ", vciSp=" + vciSp + ", vciUtente=" + vciUtente + ", velocitaAggancioDown="
                + velocitaAggancioDown + ", velocitaAggancioUp=" + velocitaAggancioUp + ", via=" + via + ", vpiRete=" + vpiRete + ", vpiSp=" + vpiSp
                + ", vpiUtente=" + vpiUtente + ", sezioneAggiuntivi=" + sezioneAggiuntivi + "]";
    }
	

	
}
