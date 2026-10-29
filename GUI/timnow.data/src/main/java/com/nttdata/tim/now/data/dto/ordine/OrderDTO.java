package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class OrderDTO implements Serializable {
	
	private static final long serialVersionUID = 6379881338923556685L;

	@JsonProperty("codiceordineolo")
	private String codiceordineolo;

	@JsonProperty("cod_olo_now")
	private String codOloNow;

	@JsonProperty("cod_causal_olo")
	private String descrizCausalOlo;

	@JsonProperty("tipoRichiesta")
	private String tipoRichiesta;

	@JsonProperty("codiceordineti")
	private String codiceordineti;

	@JsonProperty("codfc_olo_agcom")
	private String codfcOloAgcom;

	@JsonProperty("canalerichiesta")
	private String canalerichiesta;

	@JsonProperty("statorichiesteolo")
	private String statorichiesteolo;

	@JsonProperty("statorichiestanow")
	private String statorichiestanow;

	@JsonProperty("descrz_caus_now_dg")
	private String descrzCausNowDg;

	@JsonProperty("idRichiestaOlo")
	private String idRichiestaOlo;
	
	@JsonProperty("flagOpereSpeciali")
    private String flagOpereSpeciali;
	
	@JsonProperty("idOfferta")
    private String idOfferta;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInvio")
	private Date dataInvio;

    @JsonProperty("idRisorsa")
    private String idRisorsa;

    @JsonProperty("tipoLavorazione")
    private String tipoLavorazione;

    @JsonProperty("offerta")
    private String offerta;

    @JsonProperty("inAttesaDesospensioneDaOao")
    private String inAttesaDesospensioneDaOao;
    
    //RU_1492
    @JsonProperty("codOrdineOF")
    private String codOrdineOF;
    
    @JsonProperty("noteFiberstream")
    private String noteFiberstream;
    
    @JsonProperty("idRisorsaOF")
    private String idRisorsaOF;
    
    @JsonProperty("statoOF")
    private String statoOF;
    
    @JsonProperty("sottolavorazione")
    private String sottolavorazione;

	public String getCodiceordineolo() {
		return codiceordineolo;
	}

	public void setCodiceordineolo(String codiceordineolo) {
		this.codiceordineolo = codiceordineolo;
	}

	public String getCodOloNow() {
		return codOloNow;
	}

	public void setCodOloNow(String codOloNow) {
		this.codOloNow = codOloNow;
	}

	public String getDescrizCausalOlo() {
		return descrizCausalOlo;
	}

	public void setDescrizCausalOlo(String descrizCausalOlo) {
		this.descrizCausalOlo = descrizCausalOlo;
	}

	public String getTipoRichiesta() {
		return tipoRichiesta;
	}

	public void setTipoRichiesta(String tipoRichiesta) {
		this.tipoRichiesta = tipoRichiesta;
	}

	public String getCodiceordineti() {
		return codiceordineti;
	}

	public void setCodiceordineti(String codiceordineti) {
		this.codiceordineti = codiceordineti;
	}

	public String getCodfcOloAgcom() {
		return codfcOloAgcom;
	}

	public void setCodfcOloAgcom(String codfcOloAgcom) {
		this.codfcOloAgcom = codfcOloAgcom;
	}

	public String getCanalerichiesta() {
		return canalerichiesta;
	}

	public void setCanalerichiesta(String canalerichiesta) {
		this.canalerichiesta = canalerichiesta;
	}

	public String getStatorichiesteolo() {
		return statorichiesteolo;
	}

	public void setStatorichiesteolo(String statorichiesteolo) {
		this.statorichiesteolo = statorichiesteolo;
	}

	public String getStatorichiestanow() {
		return statorichiestanow;
	}

	public void setStatorichiestanow(String statorichiestanow) {
		this.statorichiestanow = statorichiestanow;
	}

	public String getDescrzCausNowDg() {
		return descrzCausNowDg;
	}

	public void setDescrzCausNowDg(String descrzCausNowDg) {
		this.descrzCausNowDg = descrzCausNowDg;
	}

	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}

	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
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

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getTipoLavorazione() {
		return tipoLavorazione;
	}

	public void setTipoLavorazione(String tipoLavorazione) {
		this.tipoLavorazione = tipoLavorazione;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getInAttesaDesospensioneDaOao() {
		return inAttesaDesospensioneDaOao;
	}

	public void setInAttesaDesospensioneDaOao(String inAttesaDesospensioneDaOao) {
		this.inAttesaDesospensioneDaOao = inAttesaDesospensioneDaOao;
	}

	public String getCodOrdineOF() {
		return codOrdineOF;
	}

	public void setCodOrdineOF(String codOrdineOF) {
		this.codOrdineOF = codOrdineOF;
	}

	public String getNoteFiberstream() {
		return noteFiberstream;
	}

	public void setNoteFiberstream(String noteFiberstream) {
		this.noteFiberstream = noteFiberstream;
	}

	public String getIdRisorsaOF() {
		return idRisorsaOF;
	}

	public void setIdRisorsaOF(String idRisorsaOF) {
		this.idRisorsaOF = idRisorsaOF;
	}

	public String getStatoOF() {
		return statoOF;
	}

	public void setStatoOF(String statoOF) {
		this.statoOF = statoOF;
	}

	public String getSottolavorazione() {
		return sottolavorazione;
	}

	public void setSottolavorazione(String sottolavorazione) {
		this.sottolavorazione = sottolavorazione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(canalerichiesta, codOloNow, codOrdineOF, codfcOloAgcom, codiceordineolo, codiceordineti,
				dataInvio, descrizCausalOlo, descrzCausNowDg, flagOpereSpeciali, idOfferta, idRichiestaOlo, idRisorsa,
				idRisorsaOF, inAttesaDesospensioneDaOao, noteFiberstream, offerta, statoOF, statorichiestanow,
				statorichiesteolo, tipoLavorazione, tipoRichiesta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDTO other = (OrderDTO) obj;
		return Objects.equals(canalerichiesta, other.canalerichiesta) && Objects.equals(codOloNow, other.codOloNow)
				&& Objects.equals(codOrdineOF, other.codOrdineOF) && Objects.equals(codfcOloAgcom, other.codfcOloAgcom)
				&& Objects.equals(codiceordineolo, other.codiceordineolo)
				&& Objects.equals(codiceordineti, other.codiceordineti) && Objects.equals(dataInvio, other.dataInvio)
				&& Objects.equals(descrizCausalOlo, other.descrizCausalOlo)
				&& Objects.equals(descrzCausNowDg, other.descrzCausNowDg)
				&& Objects.equals(flagOpereSpeciali, other.flagOpereSpeciali)
				&& Objects.equals(idOfferta, other.idOfferta) && Objects.equals(idRichiestaOlo, other.idRichiestaOlo)
				&& Objects.equals(idRisorsa, other.idRisorsa) && Objects.equals(idRisorsaOF, other.idRisorsaOF)
				&& Objects.equals(inAttesaDesospensioneDaOao, other.inAttesaDesospensioneDaOao)
				&& Objects.equals(noteFiberstream, other.noteFiberstream) && Objects.equals(offerta, other.offerta)
				&& Objects.equals(statoOF, other.statoOF) && Objects.equals(statorichiestanow, other.statorichiestanow)
				&& Objects.equals(statorichiesteolo, other.statorichiesteolo)
				&& Objects.equals(tipoLavorazione, other.tipoLavorazione)
				&& Objects.equals(tipoRichiesta, other.tipoRichiesta);
	}

	@Override
	public String toString() {
		return "OrderDTO [codiceordineolo=" + codiceordineolo + ", codOloNow=" + codOloNow + ", descrizCausalOlo="
				+ descrizCausalOlo + ", tipoRichiesta=" + tipoRichiesta + ", codiceordineti=" + codiceordineti
				+ ", codfcOloAgcom=" + codfcOloAgcom + ", canalerichiesta=" + canalerichiesta + ", statorichiesteolo="
				+ statorichiesteolo + ", statorichiestanow=" + statorichiestanow + ", descrzCausNowDg="
				+ descrzCausNowDg + ", idRichiestaOlo=" + idRichiestaOlo + ", flagOpereSpeciali=" + flagOpereSpeciali
				+ ", idOfferta=" + idOfferta + ", dataInvio=" + dataInvio + ", idRisorsa=" + idRisorsa
				+ ", tipoLavorazione=" + tipoLavorazione + ", offerta=" + offerta + ", inAttesaDesospensioneDaOao="
				+ inAttesaDesospensioneDaOao + ", codOrdineOF=" + codOrdineOF + ", noteFiberstream=" + noteFiberstream
				+ ", idRisorsaOF=" + idRisorsaOF + ", statoOF=" + statoOF + "]";
	}
}
