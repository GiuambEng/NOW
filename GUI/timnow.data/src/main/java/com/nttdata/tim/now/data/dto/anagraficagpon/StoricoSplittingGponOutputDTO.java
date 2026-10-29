package com.nttdata.tim.now.data.dto.anagraficagpon;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1338
public class StoricoSplittingGponOutputDTO implements Serializable {

	private static final long serialVersionUID = 629539607473614900L;

	@JsonProperty("fattoreDiSplittingAttuale")
    private String fattoreDiSplittingAttuale;
	
    @JsonProperty("dataFineRegistrazioneFattoreSplitting")
    private String dataFineRegistrazioneFattoreSplitting;
	
	@JsonProperty("dataRegistrazioneFattoreSplitting")
    private String dataRegistrazioneFattoreSplitting;
	
	@JsonProperty("fattoreDiSplittingOld")
    private String fattoreDiSplittingOld;

	public String getFattoreDiSplittingAttuale() {
		return fattoreDiSplittingAttuale;
	}

	public void setFattoreDiSplittingAttuale(String fattoreDiSplittingAttuale) {
		this.fattoreDiSplittingAttuale = fattoreDiSplittingAttuale;
	}

	public String getDataFineRegistrazioneFattoreSplitting() {
		return dataFineRegistrazioneFattoreSplitting;
	}

	public void setDataFineRegistrazioneFattoreSplitting(String dataFineRegistrazioneFattoreSplitting) {
		this.dataFineRegistrazioneFattoreSplitting = dataFineRegistrazioneFattoreSplitting;
	}

	public String getDataRegistrazioneFattoreSplitting() {
		return dataRegistrazioneFattoreSplitting;
	}

	public void setDataRegistrazioneFattoreSplitting(String dataRegistrazioneFattoreSplitting) {
		this.dataRegistrazioneFattoreSplitting = dataRegistrazioneFattoreSplitting;
	}

	public String getFattoreDiSplittingOld() {
		return fattoreDiSplittingOld;
	}

	public void setFattoreDiSplittingOld(String fattoreDiSplittingOld) {
		this.fattoreDiSplittingOld = fattoreDiSplittingOld;
	}

}
