package com.nttdata.tim.now.data.dto.gestioneautonoma;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1393
@JsonInclude(Include.NON_NULL)
public class AssociazioneOaoImpresaAreaOutputDTO implements Serializable {

	private static final long serialVersionUID = 1977887153724714676L;
	
	@JsonProperty("codOloAgcom")
    private String codOloAgcom;
	
	//RU_1447
	@JsonProperty("codAreaDiCentrale")
    private String codAreaDiCentrale;
	
	@JsonProperty("codImpresa")
    private String codImpresa;
	
	@JsonProperty("ragioneSociale")
    private String ragioneSociale;
	
	@JsonProperty("descrizioneTipologiaImpresa")
    private String descrizioneTipologiaImpresa;
	
	@JsonProperty("presaAppuntamento")
    private String presaAppuntamento;
	
    @JsonProperty("dataInizioValiditaProvisioning")
    private String dataInizioValiditaProvisioning;
    
    @JsonProperty("dataFineValiditaProvisioning")
    private String dataFineValiditaProvisioning;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getDescrizioneTipologiaImpresa() {
		return descrizioneTipologiaImpresa;
	}

	public void setDescrizioneTipologiaImpresa(String descrizioneTipologiaImpresa) {
		this.descrizioneTipologiaImpresa = descrizioneTipologiaImpresa;
	}

	public String getPresaAppuntamento() {
		return presaAppuntamento;
	}

	public void setPresaAppuntamento(String presaAppuntamento) {
		this.presaAppuntamento = presaAppuntamento;
	}

	public String getDataInizioValiditaProvisioning() {
		return dataInizioValiditaProvisioning;
	}

	public void setDataInizioValiditaProvisioning(String dataInizioValiditaProvisioning) {
		this.dataInizioValiditaProvisioning = dataInizioValiditaProvisioning;
	}

	public String getDataFineValiditaProvisioning() {
		return dataFineValiditaProvisioning;
	}

	public void setDataFineValiditaProvisioning(String dataFineValiditaProvisioning) {
		this.dataFineValiditaProvisioning = dataFineValiditaProvisioning;
	}

	public String getCodAreaDiCentrale() {
		return codAreaDiCentrale;
	}

	public void setCodAreaDiCentrale(String codAreaDiCentrale) {
		this.codAreaDiCentrale = codAreaDiCentrale;
	}

	public String getCodImpresa() {
		return codImpresa;
	}

	public void setCodImpresa(String codImpresa) {
		this.codImpresa = codImpresa;
	}


}
