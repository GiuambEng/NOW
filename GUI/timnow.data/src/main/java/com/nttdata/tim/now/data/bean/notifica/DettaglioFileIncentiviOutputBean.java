package com.nttdata.tim.now.data.bean.notifica;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1312
public class DettaglioFileIncentiviOutputBean extends AbstractOutputBean{

	private static final long serialVersionUID = -8013589730811154556L;

	@JsonProperty("idRisorsa")
	private String idRisorsa;
	
	@JsonProperty("clli")
	private String clli;
	
	@JsonProperty("offerta")
	private String offerta;
	
	@JsonProperty("dataIn")
	private String dataIn;
	
	@JsonProperty("dataOut")
	private String dataOut;
	
	@JsonProperty("descrizioneErrore")
	private String descrizioneErrore;

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getDataIn() {
		return dataIn;
	}

	public void setDataIn(String dataIn) {
		this.dataIn = dataIn;
	}

	public String getDataOut() {
		return dataOut;
	}

	public void setDataOut(String dataOut) {
		this.dataOut = dataOut;
	}

	public String getDescrizioneErrore() {
		return descrizioneErrore;
	}

	public void setDescrizioneErrore(String descrizioneErrore) {
		this.descrizioneErrore = descrizioneErrore;
	}
}
