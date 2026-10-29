package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DettaglioAssetOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 7990702394950979840L;

	// campi aggiunti per RU da specifiche
	@JsonProperty("codiceOrdineOaoPrimoOrdine")
	private String codiceOrdineOaoPrimoOrdine;

	@JsonProperty("primoOrdineTi")
	private String primoOrdineTi;
	// END campi aggiunti per RU da specifiche

	// nuovi campi aggiunti 03012017
	@JsonProperty("nome")
	private String nome;

	@JsonProperty("cognome_ragSociale")
	private String cognomeRagSociale;

	@JsonProperty("cf")
	private String cf;

	@JsonProperty("piva")
	private String piva;
	// fine nuovi campi aggiunti 03012017

	@JsonProperty("idAsset")
	private String idAsset;

//    @JsonProperty("codiceProgetto") SM_8255
//    private String codiceProgetto;

	@JsonProperty("centrale")
	private String centrale;

	@JsonProperty("identificativoAssetDa")
	private String identificativoAssetDa;

	@JsonProperty("identificativoContratto")
	private String identificativoContratto;

	@JsonProperty("codcontratto")
	private String codcontratto;

	@JsonProperty("nomecontratto")
	private String nomecontratto;

	@JsonProperty("statoContratto")
	private String statoContratto;

	@JsonProperty("provincia")
	private String provincia;

	@JsonProperty("comune")
	private String comune;

	@JsonProperty("localita")
	private String localita;

	@JsonProperty("descParticellaToponomastica")
	private String descParticellaToponomastica;

	@JsonProperty("via")
	private String via;

	@JsonProperty("numero")
	private String numero;

	@JsonProperty("cap")
	private String cap;

	@JsonProperty("complesso")
	private String complesso;

	@JsonProperty("interno")
	private String interno;

	@JsonProperty("scala")
	private String scala;

	@JsonProperty("piano")
	private String piano;

	// RU_628
//    @JsonProperty("invariante")
//    private String invariante;

	@JsonProperty("lna_la")
	private String lnaLa;

	@JsonProperty("modalitaFatturazione")
	private String modalitaFatturazione;

	@JsonProperty("numeroTelefonica")
	private String numeroTelefonica;

	@JsonProperty("operatore")
	private String operatore;

	@JsonProperty("oraDes")
	private String oraDes;

	@JsonProperty("ro")
	private String ro;

	@JsonProperty("tipoServizio")
	private String tipoServizio;

	@JsonProperty("lineariferimento")
	private String lineariferimento;

	@JsonProperty("idOfferta")
	private String idOfferta;

	@JsonProperty("codiceToponomastica")
	private String codicetoponomastica;

	@JsonProperty("numeroFittizio")
	private String numeroFittizio;

	@JsonProperty("idAssetCRMWS")
	private String idAssetCRMWS;

	@JsonProperty("idRisorsa")
	private String idRisorsa;

	@JsonProperty("idRisorsaNow")
	private String idRisorsaNow;

	@JsonProperty("codOAOAgcom")
	private String codOAOAgcom;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dec")
	private String dec;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("des")
	private String des;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("desPrimoOrdine")
	private String desPrimoOrdine;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("timeStampAggiornamentoAsset")
	private String timeStampAggiornamentoAsset;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("timeInserimentoAsset")
	private String timeInserimentoAsset;

	@JsonProperty("servizi")
	private List<ServizioAssetBean> servizi;

	@JsonProperty("oaoDonating")
	private String oaoDonating;

	@JsonProperty("oaoDonor")
	private String oaoDonor;

	@JsonProperty("dettaglioAsset")
	private String dettaglioAsset;

	@JsonProperty("statoAsset")
	private String statoAsset;

	@JsonProperty("caratteristicaNP")
	private Boolean caratteristicaNP;

	@JsonProperty("nomeOffertaCatalogo")
	private String nomeOffertaCatalogo;

	@JsonProperty("codSlaAssurance")
	private String codSlaAssurance;

	@JsonProperty("codIstatComune")
	private String codIstatComune;

	@JsonProperty("opzioneDinamica")
	private String opzioneDinamica;

	@JsonProperty("statoServizioDinamico")
	private String statoServizioDinamico;

	// RU_628
	@JsonProperty("ordineOao")
	private String ordineOao;

	@JsonProperty("ordineTI")
	private String ordineTI;

	@JsonProperty("idRisorsaOperatoreRete")
	private String idRisorsaOperatoreRete;

	// SM_9839
	@JsonProperty("operatoreRete")
	private String operatoreRete;

	// RU_1180
	@JsonProperty("datiMulticast")
	private List<DatiMulticastOutputBean> datiMulticast;

	// SM_10116
	@JsonProperty("whiteList")
	private String whiteList;

	// SM_10278
	@JsonProperty("statoDisabilitazioneAsset")
	private String statoDisabilitazioneAsset;

	// RU_1525
	@JsonProperty("caratterizzazioneArea")
	private String caratterizzazioneArea;
	
	@JsonProperty("ontOperatore")
	private String ontOperatore;
	
	@JsonProperty("modelloServizioPerValidazioni")
	private String modelloServizioPerValidazioni;
	
	@JsonProperty("codiceOperatoreSecondario")
	private String codiceOperatoreSecondario;
	
	@JsonProperty("descrizioneOperatoreSecondario")
	private String descrizioneOperatoreSecondario;

	public String getCodiceOrdineOaoPrimoOrdine() {
		return codiceOrdineOaoPrimoOrdine;
	}

	public void setCodiceOrdineOaoPrimoOrdine(String codiceOrdineOaoPrimoOrdine) {
		this.codiceOrdineOaoPrimoOrdine = codiceOrdineOaoPrimoOrdine;
	}

	public String getPrimoOrdineTi() {
		return primoOrdineTi;
	}

	public void setPrimoOrdineTi(String primoOrdineTi) {
		this.primoOrdineTi = primoOrdineTi;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognomeRagSociale() {
		return cognomeRagSociale;
	}

	public void setCognomeRagSociale(String cognomeRagSociale) {
		this.cognomeRagSociale = cognomeRagSociale;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}

	public String getCentrale() {
		return centrale;
	}

	public void setCentrale(String centrale) {
		this.centrale = centrale;
	}

	public String getIdentificativoAssetDa() {
		return identificativoAssetDa;
	}

	public void setIdentificativoAssetDa(String identificativoAssetDa) {
		this.identificativoAssetDa = identificativoAssetDa;
	}

	public String getIdentificativoContratto() {
		return identificativoContratto;
	}

	public void setIdentificativoContratto(String identificativoContratto) {
		this.identificativoContratto = identificativoContratto;
	}

	public String getCodcontratto() {
		return codcontratto;
	}

	public void setCodcontratto(String codcontratto) {
		this.codcontratto = codcontratto;
	}

	public String getNomecontratto() {
		return nomecontratto;
	}

	public void setNomecontratto(String nomecontratto) {
		this.nomecontratto = nomecontratto;
	}

	public String getStatoContratto() {
		return statoContratto;
	}

	public void setStatoContratto(String statoContratto) {
		this.statoContratto = statoContratto;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getDescParticellaToponomastica() {
		return descParticellaToponomastica;
	}

	public void setDescParticellaToponomastica(String descParticellaToponomastica) {
		this.descParticellaToponomastica = descParticellaToponomastica;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getComplesso() {
		return complesso;
	}

	public void setComplesso(String complesso) {
		this.complesso = complesso;
	}

	public String getInterno() {
		return interno;
	}

	public void setInterno(String interno) {
		this.interno = interno;
	}

	public String getScala() {
		return scala;
	}

	public void setScala(String scala) {
		this.scala = scala;
	}

	public String getPiano() {
		return piano;
	}

	public void setPiano(String piano) {
		this.piano = piano;
	}

	// RU_628
//	public String getInvariante() {
//		return invariante;
//	}
//
//	public void setInvariante(String invariante) {
//		this.invariante = invariante;
//	}

	public String getLnaLa() {
		return lnaLa;
	}

	public void setLnaLa(String lnaLa) {
		this.lnaLa = lnaLa;
	}

	public String getModalitaFatturazione() {
		return modalitaFatturazione;
	}

	public void setModalitaFatturazione(String modalitaFatturazione) {
		this.modalitaFatturazione = modalitaFatturazione;
	}

	public String getNumeroTelefonica() {
		return numeroTelefonica;
	}

	public void setNumeroTelefonica(String numeroTelefonica) {
		this.numeroTelefonica = numeroTelefonica;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getOraDes() {
		return oraDes;
	}

	public void setOraDes(String oraDes) {
		this.oraDes = oraDes;
	}

	public String getRo() {
		return ro;
	}

	public void setRo(String ro) {
		this.ro = ro;
	}

	public String getTipoServizio() {
		return tipoServizio;
	}

	public void setTipoServizio(String tipoServizio) {
		this.tipoServizio = tipoServizio;
	}

	public String getLineariferimento() {
		return lineariferimento;
	}

	public void setLineariferimento(String lineariferimento) {
		this.lineariferimento = lineariferimento;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getCodicetoponomastica() {
		return codicetoponomastica;
	}

	public void setCodicetoponomastica(String codicetoponomastica) {
		this.codicetoponomastica = codicetoponomastica;
	}

	public String getNumeroFittizio() {
		return numeroFittizio;
	}

	public void setNumeroFittizio(String numeroFittizio) {
		this.numeroFittizio = numeroFittizio;
	}

	public String getIdAssetCRMWS() {
		return idAssetCRMWS;
	}

	public void setIdAssetCRMWS(String idAssetCRMWS) {
		this.idAssetCRMWS = idAssetCRMWS;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getIdRisorsaNow() {
		return idRisorsaNow;
	}

	public void setIdRisorsaNow(String idRisorsaNow) {
		this.idRisorsaNow = idRisorsaNow;
	}

	public String getCodOAOAgcom() {
		return codOAOAgcom;
	}

	public void setCodOAOAgcom(String codOAOAgcom) {
		this.codOAOAgcom = codOAOAgcom;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getDesPrimoOrdine() {
		return desPrimoOrdine;
	}

	public void setDesPrimoOrdine(String desPrimoOrdine) {
		this.desPrimoOrdine = desPrimoOrdine;
	}

	public String getTimeStampAggiornamentoAsset() {
		return timeStampAggiornamentoAsset;
	}

	public void setTimeStampAggiornamentoAsset(String timeStampAggiornamentoAsset) {
		this.timeStampAggiornamentoAsset = timeStampAggiornamentoAsset;
	}

	public String getTimeInserimentoAsset() {
		return timeInserimentoAsset;
	}

	public void setTimeInserimentoAsset(String timeInserimentoAsset) {
		this.timeInserimentoAsset = timeInserimentoAsset;
	}

	public List<ServizioAssetBean> getServizi() {
		return servizi;
	}

	public void setServizi(List<ServizioAssetBean> servizi) {
		this.servizi = servizi;
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

	public String getDettaglioAsset() {
		return dettaglioAsset;
	}

	public void setDettaglioAsset(String dettaglioAsset) {
		this.dettaglioAsset = dettaglioAsset;
	}

	public String getStatoAsset() {
		return statoAsset;
	}

	public void setStatoAsset(String statoAsset) {
		this.statoAsset = statoAsset;
	}

	public Boolean getCaratteristicaNP() {
		return caratteristicaNP;
	}

	public void setCaratteristicaNP(Boolean caratteristicaNP) {
		this.caratteristicaNP = caratteristicaNP;
	}

	public String getNomeOffertaCatalogo() {
		return nomeOffertaCatalogo;
	}

	public void setNomeOffertaCatalogo(String nomeOffertaCatalogo) {
		this.nomeOffertaCatalogo = nomeOffertaCatalogo;
	}

	public String getCodSlaAssurance() {
		return codSlaAssurance;
	}

	public void setCodSlaAssurance(String codSlaAssurance) {
		this.codSlaAssurance = codSlaAssurance;
	}

	public String getCodIstatComune() {
		return codIstatComune;
	}

	public void setCodIstatComune(String codIstatComune) {
		this.codIstatComune = codIstatComune;
	}

	public String getOpzioneDinamica() {
		return opzioneDinamica;
	}

	public void setOpzioneDinamica(String opzioneDinamica) {
		this.opzioneDinamica = opzioneDinamica;
	}

	public String getStatoServizioDinamico() {
		return statoServizioDinamico;
	}

	public void setStatoServizioDinamico(String statoServizioDinamico) {
		this.statoServizioDinamico = statoServizioDinamico;
	}

	public String getOrdineOao() {
		return ordineOao;
	}

	public void setOrdineOao(String ordineOao) {
		this.ordineOao = ordineOao;
	}

	public String getOrdineTI() {
		return ordineTI;
	}

	public void setOrdineTI(String ordineTI) {
		this.ordineTI = ordineTI;
	}

	public String getIdRisorsaOperatoreRete() {
		return idRisorsaOperatoreRete;
	}

	public void setIdRisorsaOperatoreRete(String idRisorsaOperatoreRete) {
		this.idRisorsaOperatoreRete = idRisorsaOperatoreRete;
	}

	public String getOperatoreRete() {
		return operatoreRete;
	}

	public void setOperatoreRete(String operatoreRete) {
		this.operatoreRete = operatoreRete;
	}

	public List<DatiMulticastOutputBean> getDatiMulticast() {
		return datiMulticast;
	}

	public void setDatiMulticast(List<DatiMulticastOutputBean> datiMulticast) {
		this.datiMulticast = datiMulticast;
	}

	public String getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(String whiteList) {
		this.whiteList = whiteList;
	}

	public String getStatoDisabilitazioneAsset() {
		return statoDisabilitazioneAsset;
	}

	public void setStatoDisabilitazioneAsset(String statoDisabilitazioneAsset) {
		this.statoDisabilitazioneAsset = statoDisabilitazioneAsset;
	}

	public String getCaratterizzazioneArea() {
		return caratterizzazioneArea;
	}

	public void setCaratterizzazioneArea(String caratterizzazioneArea) {
		this.caratterizzazioneArea = caratterizzazioneArea;
	}
	
	public String getOntOperatore() {
		return this.ontOperatore;
	}

	public void setOntOperatore(String ontOperatore) {
		this.ontOperatore = ontOperatore;
	}
	
	public String getModelloServizioPerValidazioni() {
		return modelloServizioPerValidazioni;
	}

	public void setModelloServizioPerValidazioni(String modelloServizioPerValidazioni) {
		this.modelloServizioPerValidazioni = modelloServizioPerValidazioni;
	}

	public String getCodiceOperatoreSecondario() {
		return codiceOperatoreSecondario;
	}

	public void setCodiceOperatoreSecondario(String codiceOperatoreSecondario) {
		this.codiceOperatoreSecondario = codiceOperatoreSecondario;
	}

	public String getDescrizioneOperatoreSecondario() {
		return descrizioneOperatoreSecondario;
	}

	public void setDescrizioneOperatoreSecondario(String descrizioneOperatoreSecondario) {
		this.descrizioneOperatoreSecondario = descrizioneOperatoreSecondario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cap == null) ? 0 : cap.hashCode());
		result = prime * result + ((caratteristicaNP == null) ? 0 : caratteristicaNP.hashCode());
		result = prime * result + ((centrale == null) ? 0 : centrale.hashCode());
		result = prime * result + ((cf == null) ? 0 : cf.hashCode());
		result = prime * result + ((codIstatComune == null) ? 0 : codIstatComune.hashCode());
		result = prime * result + ((codOAOAgcom == null) ? 0 : codOAOAgcom.hashCode());
		result = prime * result + ((codSlaAssurance == null) ? 0 : codSlaAssurance.hashCode());
		result = prime * result + ((codcontratto == null) ? 0 : codcontratto.hashCode());
		result = prime * result + ((codiceOrdineOaoPrimoOrdine == null) ? 0 : codiceOrdineOaoPrimoOrdine.hashCode());
		result = prime * result + ((codicetoponomastica == null) ? 0 : codicetoponomastica.hashCode());
		result = prime * result + ((cognomeRagSociale == null) ? 0 : cognomeRagSociale.hashCode());
		result = prime * result + ((complesso == null) ? 0 : complesso.hashCode());
		result = prime * result + ((comune == null) ? 0 : comune.hashCode());
		result = prime * result + ((datiMulticast == null) ? 0 : datiMulticast.hashCode());
		result = prime * result + ((dec == null) ? 0 : dec.hashCode());
		result = prime * result + ((des == null) ? 0 : des.hashCode());
		result = prime * result + ((desPrimoOrdine == null) ? 0 : desPrimoOrdine.hashCode());
		result = prime * result + ((descParticellaToponomastica == null) ? 0 : descParticellaToponomastica.hashCode());
		result = prime * result + ((dettaglioAsset == null) ? 0 : dettaglioAsset.hashCode());
		result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
		result = prime * result + ((idAssetCRMWS == null) ? 0 : idAssetCRMWS.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((idRisorsaNow == null) ? 0 : idRisorsaNow.hashCode());
		result = prime * result + ((idRisorsaOperatoreRete == null) ? 0 : idRisorsaOperatoreRete.hashCode());
		result = prime * result + ((identificativoAssetDa == null) ? 0 : identificativoAssetDa.hashCode());
		result = prime * result + ((identificativoContratto == null) ? 0 : identificativoContratto.hashCode());
		result = prime * result + ((interno == null) ? 0 : interno.hashCode());
		result = prime * result + ((lineariferimento == null) ? 0 : lineariferimento.hashCode());
		result = prime * result + ((lnaLa == null) ? 0 : lnaLa.hashCode());
		result = prime * result + ((localita == null) ? 0 : localita.hashCode());
		result = prime * result + ((modalitaFatturazione == null) ? 0 : modalitaFatturazione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeOffertaCatalogo == null) ? 0 : nomeOffertaCatalogo.hashCode());
		result = prime * result + ((nomecontratto == null) ? 0 : nomecontratto.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((numeroFittizio == null) ? 0 : numeroFittizio.hashCode());
		result = prime * result + ((numeroTelefonica == null) ? 0 : numeroTelefonica.hashCode());
		result = prime * result + ((oaoDonating == null) ? 0 : oaoDonating.hashCode());
		result = prime * result + ((oaoDonor == null) ? 0 : oaoDonor.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		result = prime * result + ((operatoreRete == null) ? 0 : operatoreRete.hashCode());
		result = prime * result + ((opzioneDinamica == null) ? 0 : opzioneDinamica.hashCode());
		result = prime * result + ((oraDes == null) ? 0 : oraDes.hashCode());
		result = prime * result + ((ordineOao == null) ? 0 : ordineOao.hashCode());
		result = prime * result + ((ordineTI == null) ? 0 : ordineTI.hashCode());
		result = prime * result + ((piano == null) ? 0 : piano.hashCode());
		result = prime * result + ((piva == null) ? 0 : piva.hashCode());
		result = prime * result + ((primoOrdineTi == null) ? 0 : primoOrdineTi.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((ro == null) ? 0 : ro.hashCode());
		result = prime * result + ((scala == null) ? 0 : scala.hashCode());
		result = prime * result + ((servizi == null) ? 0 : servizi.hashCode());
		result = prime * result + ((statoAsset == null) ? 0 : statoAsset.hashCode());
		result = prime * result + ((statoContratto == null) ? 0 : statoContratto.hashCode());
		result = prime * result + ((statoDisabilitazioneAsset == null) ? 0 : statoDisabilitazioneAsset.hashCode());
		result = prime * result + ((statoServizioDinamico == null) ? 0 : statoServizioDinamico.hashCode());
		result = prime * result + ((timeInserimentoAsset == null) ? 0 : timeInserimentoAsset.hashCode());
		result = prime * result + ((timeStampAggiornamentoAsset == null) ? 0 : timeStampAggiornamentoAsset.hashCode());
		result = prime * result + ((tipoServizio == null) ? 0 : tipoServizio.hashCode());
		result = prime * result + ((via == null) ? 0 : via.hashCode());
		result = prime * result + ((whiteList == null) ? 0 : whiteList.hashCode());
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
		DettaglioAssetOutputBean other = (DettaglioAssetOutputBean) obj;
		if (cap == null) {
			if (other.cap != null)
				return false;
		} else if (!cap.equals(other.cap))
			return false;
		if (caratteristicaNP == null) {
			if (other.caratteristicaNP != null)
				return false;
		} else if (!caratteristicaNP.equals(other.caratteristicaNP))
			return false;
		if (centrale == null) {
			if (other.centrale != null)
				return false;
		} else if (!centrale.equals(other.centrale))
			return false;
		if (cf == null) {
			if (other.cf != null)
				return false;
		} else if (!cf.equals(other.cf))
			return false;
		if (codIstatComune == null) {
			if (other.codIstatComune != null)
				return false;
		} else if (!codIstatComune.equals(other.codIstatComune))
			return false;
		if (codOAOAgcom == null) {
			if (other.codOAOAgcom != null)
				return false;
		} else if (!codOAOAgcom.equals(other.codOAOAgcom))
			return false;
		if (codSlaAssurance == null) {
			if (other.codSlaAssurance != null)
				return false;
		} else if (!codSlaAssurance.equals(other.codSlaAssurance))
			return false;
		if (codcontratto == null) {
			if (other.codcontratto != null)
				return false;
		} else if (!codcontratto.equals(other.codcontratto))
			return false;
		if (codiceOrdineOaoPrimoOrdine == null) {
			if (other.codiceOrdineOaoPrimoOrdine != null)
				return false;
		} else if (!codiceOrdineOaoPrimoOrdine.equals(other.codiceOrdineOaoPrimoOrdine))
			return false;
		if (codicetoponomastica == null) {
			if (other.codicetoponomastica != null)
				return false;
		} else if (!codicetoponomastica.equals(other.codicetoponomastica))
			return false;
		if (cognomeRagSociale == null) {
			if (other.cognomeRagSociale != null)
				return false;
		} else if (!cognomeRagSociale.equals(other.cognomeRagSociale))
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
		if (datiMulticast == null) {
			if (other.datiMulticast != null)
				return false;
		} else if (!datiMulticast.equals(other.datiMulticast))
			return false;
		if (dec == null) {
			if (other.dec != null)
				return false;
		} else if (!dec.equals(other.dec))
			return false;
		if (des == null) {
			if (other.des != null)
				return false;
		} else if (!des.equals(other.des))
			return false;
		if (desPrimoOrdine == null) {
			if (other.desPrimoOrdine != null)
				return false;
		} else if (!desPrimoOrdine.equals(other.desPrimoOrdine))
			return false;
		if (descParticellaToponomastica == null) {
			if (other.descParticellaToponomastica != null)
				return false;
		} else if (!descParticellaToponomastica.equals(other.descParticellaToponomastica))
			return false;
		if (dettaglioAsset == null) {
			if (other.dettaglioAsset != null)
				return false;
		} else if (!dettaglioAsset.equals(other.dettaglioAsset))
			return false;
		if (idAsset == null) {
			if (other.idAsset != null)
				return false;
		} else if (!idAsset.equals(other.idAsset))
			return false;
		if (idAssetCRMWS == null) {
			if (other.idAssetCRMWS != null)
				return false;
		} else if (!idAssetCRMWS.equals(other.idAssetCRMWS))
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
		if (idRisorsaNow == null) {
			if (other.idRisorsaNow != null)
				return false;
		} else if (!idRisorsaNow.equals(other.idRisorsaNow))
			return false;
		if (idRisorsaOperatoreRete == null) {
			if (other.idRisorsaOperatoreRete != null)
				return false;
		} else if (!idRisorsaOperatoreRete.equals(other.idRisorsaOperatoreRete))
			return false;
		if (identificativoAssetDa == null) {
			if (other.identificativoAssetDa != null)
				return false;
		} else if (!identificativoAssetDa.equals(other.identificativoAssetDa))
			return false;
		if (identificativoContratto == null) {
			if (other.identificativoContratto != null)
				return false;
		} else if (!identificativoContratto.equals(other.identificativoContratto))
			return false;
		if (interno == null) {
			if (other.interno != null)
				return false;
		} else if (!interno.equals(other.interno))
			return false;
		if (lineariferimento == null) {
			if (other.lineariferimento != null)
				return false;
		} else if (!lineariferimento.equals(other.lineariferimento))
			return false;
		if (lnaLa == null) {
			if (other.lnaLa != null)
				return false;
		} else if (!lnaLa.equals(other.lnaLa))
			return false;
		if (localita == null) {
			if (other.localita != null)
				return false;
		} else if (!localita.equals(other.localita))
			return false;
		if (modalitaFatturazione == null) {
			if (other.modalitaFatturazione != null)
				return false;
		} else if (!modalitaFatturazione.equals(other.modalitaFatturazione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeOffertaCatalogo == null) {
			if (other.nomeOffertaCatalogo != null)
				return false;
		} else if (!nomeOffertaCatalogo.equals(other.nomeOffertaCatalogo))
			return false;
		if (nomecontratto == null) {
			if (other.nomecontratto != null)
				return false;
		} else if (!nomecontratto.equals(other.nomecontratto))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (numeroFittizio == null) {
			if (other.numeroFittizio != null)
				return false;
		} else if (!numeroFittizio.equals(other.numeroFittizio))
			return false;
		if (numeroTelefonica == null) {
			if (other.numeroTelefonica != null)
				return false;
		} else if (!numeroTelefonica.equals(other.numeroTelefonica))
			return false;
		if (oaoDonating == null) {
			if (other.oaoDonating != null)
				return false;
		} else if (!oaoDonating.equals(other.oaoDonating))
			return false;
		if (oaoDonor == null) {
			if (other.oaoDonor != null)
				return false;
		} else if (!oaoDonor.equals(other.oaoDonor))
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
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
		if (oraDes == null) {
			if (other.oraDes != null)
				return false;
		} else if (!oraDes.equals(other.oraDes))
			return false;
		if (ordineOao == null) {
			if (other.ordineOao != null)
				return false;
		} else if (!ordineOao.equals(other.ordineOao))
			return false;
		if (ordineTI == null) {
			if (other.ordineTI != null)
				return false;
		} else if (!ordineTI.equals(other.ordineTI))
			return false;
		if (piano == null) {
			if (other.piano != null)
				return false;
		} else if (!piano.equals(other.piano))
			return false;
		if (piva == null) {
			if (other.piva != null)
				return false;
		} else if (!piva.equals(other.piva))
			return false;
		if (primoOrdineTi == null) {
			if (other.primoOrdineTi != null)
				return false;
		} else if (!primoOrdineTi.equals(other.primoOrdineTi))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (ro == null) {
			if (other.ro != null)
				return false;
		} else if (!ro.equals(other.ro))
			return false;
		if (scala == null) {
			if (other.scala != null)
				return false;
		} else if (!scala.equals(other.scala))
			return false;
		if (servizi == null) {
			if (other.servizi != null)
				return false;
		} else if (!servizi.equals(other.servizi))
			return false;
		if (statoAsset == null) {
			if (other.statoAsset != null)
				return false;
		} else if (!statoAsset.equals(other.statoAsset))
			return false;
		if (statoContratto == null) {
			if (other.statoContratto != null)
				return false;
		} else if (!statoContratto.equals(other.statoContratto))
			return false;
		if (statoDisabilitazioneAsset == null) {
			if (other.statoDisabilitazioneAsset != null)
				return false;
		} else if (!statoDisabilitazioneAsset.equals(other.statoDisabilitazioneAsset))
			return false;
		if (statoServizioDinamico == null) {
			if (other.statoServizioDinamico != null)
				return false;
		} else if (!statoServizioDinamico.equals(other.statoServizioDinamico))
			return false;
		if (timeInserimentoAsset == null) {
			if (other.timeInserimentoAsset != null)
				return false;
		} else if (!timeInserimentoAsset.equals(other.timeInserimentoAsset))
			return false;
		if (timeStampAggiornamentoAsset == null) {
			if (other.timeStampAggiornamentoAsset != null)
				return false;
		} else if (!timeStampAggiornamentoAsset.equals(other.timeStampAggiornamentoAsset))
			return false;
		if (tipoServizio == null) {
			if (other.tipoServizio != null)
				return false;
		} else if (!tipoServizio.equals(other.tipoServizio))
			return false;
		if (via == null) {
			if (other.via != null)
				return false;
		} else if (!via.equals(other.via))
			return false;
		if (whiteList == null) {
			if (other.whiteList != null)
				return false;
		} else if (!whiteList.equals(other.whiteList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DettaglioAssetOutputBean [codiceOrdineOaoPrimoOrdine=" + codiceOrdineOaoPrimoOrdine + ", primoOrdineTi="
				+ primoOrdineTi + ", nome=" + nome + ", cognomeRagSociale=" + cognomeRagSociale + ", cf=" + cf
				+ ", piva=" + piva + ", idAsset=" + idAsset + ", centrale=" + centrale + ", identificativoAssetDa="
				+ identificativoAssetDa + ", identificativoContratto=" + identificativoContratto + ", codcontratto="
				+ codcontratto + ", nomecontratto=" + nomecontratto + ", statoContratto=" + statoContratto
				+ ", provincia=" + provincia + ", comune=" + comune + ", localita=" + localita
				+ ", descParticellaToponomastica=" + descParticellaToponomastica + ", via=" + via + ", numero=" + numero
				+ ", cap=" + cap + ", complesso=" + complesso + ", interno=" + interno + ", scala=" + scala + ", piano="
				+ piano + ", lnaLa=" + lnaLa + ", modalitaFatturazione=" + modalitaFatturazione + ", numeroTelefonica="
				+ numeroTelefonica + ", operatore=" + operatore + ", oraDes=" + oraDes + ", ro=" + ro
				+ ", tipoServizio=" + tipoServizio + ", lineariferimento=" + lineariferimento + ", idOfferta="
				+ idOfferta + ", codicetoponomastica=" + codicetoponomastica + ", numeroFittizio=" + numeroFittizio
				+ ", idAssetCRMWS=" + idAssetCRMWS + ", idRisorsa=" + idRisorsa + ", idRisorsaNow=" + idRisorsaNow
				+ ", codOAOAgcom=" + codOAOAgcom + ", dec=" + dec + ", des=" + des + ", desPrimoOrdine="
				+ desPrimoOrdine + ", timeStampAggiornamentoAsset=" + timeStampAggiornamentoAsset
				+ ", timeInserimentoAsset=" + timeInserimentoAsset + ", servizi=" + servizi + ", oaoDonating="
				+ oaoDonating + ", oaoDonor=" + oaoDonor + ", dettaglioAsset=" + dettaglioAsset + ", statoAsset="
				+ statoAsset + ", caratteristicaNP=" + caratteristicaNP + ", nomeOffertaCatalogo=" + nomeOffertaCatalogo
				+ ", codSlaAssurance=" + codSlaAssurance + ", codIstatComune=" + codIstatComune + ", opzioneDinamica="
				+ opzioneDinamica + ", statoServizioDinamico=" + statoServizioDinamico + ", ordineOao=" + ordineOao
				+ ", ordineTI=" + ordineTI + ", idRisorsaOperatoreRete=" + idRisorsaOperatoreRete + ", operatoreRete="
				+ operatoreRete + ", datiMulticast=" + datiMulticast + ", whiteList=" + whiteList
				+ ", statoDisabilitazioneAsset=" + statoDisabilitazioneAsset + "]";
	}

}