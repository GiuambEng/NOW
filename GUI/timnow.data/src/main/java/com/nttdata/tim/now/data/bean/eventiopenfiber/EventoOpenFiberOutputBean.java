package com.nttdata.tim.now.data.bean.eventiopenfiber;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

//RU_1492
@JsonInclude(Include.NON_NULL)
public class EventoOpenFiberOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = -1318629588992217530L;
    
	@JsonProperty("descrizioneErrore")
    private String descrizioneErrore;
    
    @JsonProperty("verso")
    private String verso;

	@JsonFormat(pattern = DateHelper.DATE_FE_LONG, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
    @JsonProperty("timestampRichiesta")
	private Date timestampRichiesta;

	@JsonProperty("codOrdineOlo")
    private String codOrdineOlo;

    @JsonProperty("statoStaging")
    private String statoStaging;

    @JsonProperty("richiestaXml")
    private String richiestaXml;

    @JsonProperty("idTransazione")
    private String idTransazione;

    @JsonProperty("codOrdineOloOF")
    private String codOrdineOloOF;
    
    @JsonProperty("idRisorsa")
    private String idRisorsa;
    
    @JsonProperty("rispostaXml")
    private String rispostaXml;

	public String getDescrizioneErrore() {
		return descrizioneErrore;
	}

	public void setDescrizioneErrore(String descrizioneErrore) {
		this.descrizioneErrore = descrizioneErrore;
	}

	public String getVerso() {
		return verso;
	}

	public void setVerso(String verso) {
		this.verso = verso;
	}

	public Date getTimestampRichiesta() {
		return timestampRichiesta;
	}

	public void setTimestampRichiesta(Date timestampRichiesta) {
		this.timestampRichiesta = timestampRichiesta;
	}

	public String getCodOrdineOlo() {
		return codOrdineOlo;
	}

	public void setCodOrdineOlo(String codOrdineOlo) {
		this.codOrdineOlo = codOrdineOlo;
	}

	public String getStatoStaging() {
		return statoStaging;
	}

	public void setStatoStaging(String statoStaging) {
		this.statoStaging = statoStaging;
	}

	public String getRichiestaXml() {
		return richiestaXml;
	}

	public void setRichiestaXml(String richiestaXml) {
		this.richiestaXml = richiestaXml;
	}

	public String getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(String idTransazione) {
		this.idTransazione = idTransazione;
	}

	public String getCodOrdineOloOF() {
		return codOrdineOloOF;
	}

	public void setCodOrdineOloOF(String codOrdineOloOF) {
		this.codOrdineOloOF = codOrdineOloOF;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getRispostaXml() {
		return rispostaXml;
	}

	public void setRispostaXml(String rispostaXml) {
		this.rispostaXml = rispostaXml;
	}
}