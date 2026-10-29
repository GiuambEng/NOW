package com.nttdata.tim.now.data.bean.ordine.hashing;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.ricerca.ConditionBean;

//R1F-21-0411
@JsonInclude(Include.NON_NULL)
public class CreazioneReportInputBean implements Serializable {
	
	private static final long serialVersionUID = -3428008623889592075L;

	@JsonProperty("nomeReport")
	private String nomeReport;
	
	@JsonProperty("tipoLista")
	private String tipoLista;

	@JsonProperty("strutturaCondition")
	private List<ConditionBean> strutturaCondition;
	
	@JsonProperty("operatore")
	private String operatore;
	
	@JsonProperty("ipClient")
	private String ipClient;
	
	@JsonProperty("codOloAgcom")
	private String codOloAgcom;
	
	@JsonProperty("codOrdineTi")
	private String codOrdineTi;
	
	@JsonProperty("nomeFileNotifica")
	private String nomeFileNotifica;
	
	@JsonProperty("idRisorsa")
	private String idRisorsa;
	
	@JsonProperty("codiceSessione")
	private String codiceSessione;

	public String getNomeReport() {
		return nomeReport;
	}

	public void setNomeReport(String nomeReport) {
		this.nomeReport = nomeReport;
	}

	public String getTipoLista() {
		return tipoLista;
	}

	public void setTipoLista(String tipoLista) {
		this.tipoLista = tipoLista;
	}

	public List<ConditionBean> getStrutturaCondition() {
		return strutturaCondition;
	}

	public void setStrutturaCondition(List<ConditionBean> strutturaCondition) {
		this.strutturaCondition = strutturaCondition;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getIpClient() {
		return ipClient;
	}

	public void setIpClient(String ipClient) {
		this.ipClient = ipClient;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getCodOrdineTi() {
		return codOrdineTi;
	}

	public void setCodOrdineTi(String codOrdineTi) {
		this.codOrdineTi = codOrdineTi;
	}

	public String getNomeFileNotifica() {
		return nomeFileNotifica;
	}

	public void setNomeFileNotifica(String nomeFileNotifica) {
		this.nomeFileNotifica = nomeFileNotifica;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getCodiceSessione() {
		return codiceSessione;
	}

	public void setCodiceSessione(String codiceSessione) {
		this.codiceSessione = codiceSessione;
	}

}
