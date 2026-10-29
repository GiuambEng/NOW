package com.nttdata.tim.now.data.dto.richiesta;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RequestDTO implements Serializable {
	
	private static final long serialVersionUID = 2854102148397986222L;
	
	@JsonProperty("CausaleRichiesta")
	private String causaleRichiesta;
	
	@JsonProperty("OAO")
	private String oao;
	
	@JsonProperty("operatore")
	private String operatore;
	
	@JsonProperty("CodiceRichiesta")
	private String codiceRichiesta;
	
	@JsonProperty("CodiceOrdineTI")
	private String codiceOrdineTI;
	
	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("DAD")
	private Date dad;
	
	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dac")
	private Date dac;
	
	@JsonProperty("FasciaOraria")
	private String fasciaOraria;
	
    @JsonProperty("noteDaOperatore")
    private String noteDaOperatore;
	
    @JsonProperty("noteAltreLavorazioni")
    private String noteAltreLavorazioni;

    @JsonProperty("flagAccettazione")
    private String flagAccettazione;
	
    @JsonProperty("riscontroCodiceSessione")
    private String riscontroCodiceSessione;
    
    @JsonProperty("causaleRifiuto")
    private String causaleRifiuto;
    
    @JsonProperty("codiceMotivoRifiuto")
    private String codiceMotivoRifiuto;
    
    @JsonProperty("motivoRifiuto")
    private String motivoRifiuto;
    
	@JsonProperty("ReferenteDesospensione")
	private RequestReferentDTO referente;

	@JsonProperty("idRichiestaOlo")
	private String idRichiestaOlo;

	@JsonProperty("codiceOrdineOlo")
	private String codiceOrdineOlo;

	public String getCausaleRichiesta() {
		return causaleRichiesta;
	}

	public void setCausaleRichiesta(String causaleRichiesta) {
		this.causaleRichiesta = causaleRichiesta;
	}

	public String getOao() {
		return oao;
	}

	public void setOao(String oao) {
		this.oao = oao;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getCodiceRichiesta() {
		return codiceRichiesta;
	}

	public void setCodiceRichiesta(String codiceRichiesta) {
		this.codiceRichiesta = codiceRichiesta;
	}

	public String getCodiceOrdineTI() {
		return codiceOrdineTI;
	}

	public void setCodiceOrdineTI(String codiceOrdineTI) {
		this.codiceOrdineTI = codiceOrdineTI;
	}

	public Date getDad() {
		return dad;
	}

	public void setDad(Date dad) {
		this.dad = dad;
	}

	public Date getDac() {
		return dac;
	}

	public void setDac(Date dac) {
		this.dac = dac;
	}

	public String getFasciaOraria() {
		return fasciaOraria;
	}

	public void setFasciaOraria(String fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}

	public String getNoteDaOperatore() {
		return noteDaOperatore;
	}

	public void setNoteDaOperatore(String noteDaOperatore) {
		this.noteDaOperatore = noteDaOperatore;
	}

	public String getNoteAltreLavorazioni() {
		return noteAltreLavorazioni;
	}

	public void setNoteAltreLavorazioni(String noteAltreLavorazioni) {
		this.noteAltreLavorazioni = noteAltreLavorazioni;
	}

	public String getFlagAccettazione() {
		return flagAccettazione;
	}

	public void setFlagAccettazione(String flagAccettazione) {
		this.flagAccettazione = flagAccettazione;
	}

	public String getRiscontroCodiceSessione() {
		return riscontroCodiceSessione;
	}

	public void setRiscontroCodiceSessione(String riscontroCodiceSessione) {
		this.riscontroCodiceSessione = riscontroCodiceSessione;
	}

	public String getCausaleRifiuto() {
		return causaleRifiuto;
	}

	public void setCausaleRifiuto(String causaleRifiuto) {
		this.causaleRifiuto = causaleRifiuto;
	}

	public String getCodiceMotivoRifiuto() {
		return codiceMotivoRifiuto;
	}

	public void setCodiceMotivoRifiuto(String codiceMotivoRifiuto) {
		this.codiceMotivoRifiuto = codiceMotivoRifiuto;
	}

	public String getMotivoRifiuto() {
		return motivoRifiuto;
	}

	public void setMotivoRifiuto(String motivoRifiuto) {
		this.motivoRifiuto = motivoRifiuto;
	}

	public RequestReferentDTO getReferente() {
		return referente;
	}

	public void setReferente(RequestReferentDTO referente) {
		this.referente = referente;
	}

	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}

	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
	}

	public String getCodiceOrdineOlo() {
		return codiceOrdineOlo;
	}

	public void setCodiceOrdineOlo(String codiceOrdineOlo) {
		this.codiceOrdineOlo = codiceOrdineOlo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((causaleRichiesta == null) ? 0 : causaleRichiesta.hashCode());
		result = prime * result + ((causaleRifiuto == null) ? 0 : causaleRifiuto.hashCode());
		result = prime * result + ((codiceMotivoRifiuto == null) ? 0 : codiceMotivoRifiuto.hashCode());
		result = prime * result + ((codiceOrdineOlo == null) ? 0 : codiceOrdineOlo.hashCode());
		result = prime * result + ((codiceOrdineTI == null) ? 0 : codiceOrdineTI.hashCode());
		result = prime * result + ((codiceRichiesta == null) ? 0 : codiceRichiesta.hashCode());
		result = prime * result + ((dac == null) ? 0 : dac.hashCode());
		result = prime * result + ((dad == null) ? 0 : dad.hashCode());
		result = prime * result + ((fasciaOraria == null) ? 0 : fasciaOraria.hashCode());
		result = prime * result + ((flagAccettazione == null) ? 0 : flagAccettazione.hashCode());
		result = prime * result + ((idRichiestaOlo == null) ? 0 : idRichiestaOlo.hashCode());
		result = prime * result + ((motivoRifiuto == null) ? 0 : motivoRifiuto.hashCode());
		result = prime * result + ((noteAltreLavorazioni == null) ? 0 : noteAltreLavorazioni.hashCode());
		result = prime * result + ((noteDaOperatore == null) ? 0 : noteDaOperatore.hashCode());
		result = prime * result + ((oao == null) ? 0 : oao.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		result = prime * result + ((referente == null) ? 0 : referente.hashCode());
		result = prime * result + ((riscontroCodiceSessione == null) ? 0 : riscontroCodiceSessione.hashCode());
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
		RequestDTO other = (RequestDTO) obj;
		if (causaleRichiesta == null) {
			if (other.causaleRichiesta != null)
				return false;
		} else if (!causaleRichiesta.equals(other.causaleRichiesta))
			return false;
		if (causaleRifiuto == null) {
			if (other.causaleRifiuto != null)
				return false;
		} else if (!causaleRifiuto.equals(other.causaleRifiuto))
			return false;
		if (codiceMotivoRifiuto == null) {
			if (other.codiceMotivoRifiuto != null)
				return false;
		} else if (!codiceMotivoRifiuto.equals(other.codiceMotivoRifiuto))
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
		if (codiceRichiesta == null) {
			if (other.codiceRichiesta != null)
				return false;
		} else if (!codiceRichiesta.equals(other.codiceRichiesta))
			return false;
		if (dac == null) {
			if (other.dac != null)
				return false;
		} else if (!dac.equals(other.dac))
			return false;
		if (dad == null) {
			if (other.dad != null)
				return false;
		} else if (!dad.equals(other.dad))
			return false;
		if (fasciaOraria == null) {
			if (other.fasciaOraria != null)
				return false;
		} else if (!fasciaOraria.equals(other.fasciaOraria))
			return false;
		if (flagAccettazione == null) {
			if (other.flagAccettazione != null)
				return false;
		} else if (!flagAccettazione.equals(other.flagAccettazione))
			return false;
		if (idRichiestaOlo == null) {
			if (other.idRichiestaOlo != null)
				return false;
		} else if (!idRichiestaOlo.equals(other.idRichiestaOlo))
			return false;
		if (motivoRifiuto == null) {
			if (other.motivoRifiuto != null)
				return false;
		} else if (!motivoRifiuto.equals(other.motivoRifiuto))
			return false;
		if (noteAltreLavorazioni == null) {
			if (other.noteAltreLavorazioni != null)
				return false;
		} else if (!noteAltreLavorazioni.equals(other.noteAltreLavorazioni))
			return false;
		if (noteDaOperatore == null) {
			if (other.noteDaOperatore != null)
				return false;
		} else if (!noteDaOperatore.equals(other.noteDaOperatore))
			return false;
		if (oao == null) {
			if (other.oao != null)
				return false;
		} else if (!oao.equals(other.oao))
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		if (referente == null) {
			if (other.referente != null)
				return false;
		} else if (!referente.equals(other.referente))
			return false;
		if (riscontroCodiceSessione == null) {
			if (other.riscontroCodiceSessione != null)
				return false;
		} else if (!riscontroCodiceSessione.equals(other.riscontroCodiceSessione))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequestDTO [causaleRichiesta=" + causaleRichiesta + ", oao=" + oao + ", operatore=" + operatore
				+ ", codiceRichiesta=" + codiceRichiesta + ", codiceOrdineTI=" + codiceOrdineTI + ", dad=" + dad
				+ ", dac=" + dac + ", fasciaOraria=" + fasciaOraria + ", noteDaOperatore=" + noteDaOperatore
				+ ", noteAltreLavorazioni=" + noteAltreLavorazioni + ", flagAccettazione=" + flagAccettazione
				+ ", riscontroCodiceSessione=" + riscontroCodiceSessione + ", causaleRifiuto=" + causaleRifiuto
				+ ", codiceMotivoRifiuto=" + codiceMotivoRifiuto + ", motivoRifiuto=" + motivoRifiuto + ", referente="
				+ referente + ", idRichiestaOlo=" + idRichiestaOlo + ", codiceOrdineOlo=" + codiceOrdineOlo + "]";
	}

	
}
