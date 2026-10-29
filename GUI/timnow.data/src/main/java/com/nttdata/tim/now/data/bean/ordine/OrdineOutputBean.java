package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class OrdineOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -6727963498633765123L;

    @JsonProperty("codiceordineolo")
    private String codiceordineolo;

    @JsonProperty("cod_olo")
    private String codOlo;

    @JsonProperty("descriz_causal_olo")
    private String descrizCausalOlo;

    @JsonProperty("descriz_causal_now")
    private String descrizCausalNow;

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

    @JsonProperty("idRichiestaOlo")
    private String idRichiestaOlo;

    @JsonProperty("tipoRichiesta")
    private String tipoRichiesta;

    @JsonProperty("flagOpereSpeciali")
    private Boolean flagOpereSpeciali;

    @JsonProperty("idOfferta")
    private String idOfferta;

	@JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
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

	public String getCodOlo() {
		return codOlo;
	}

	public void setCodOlo(String codOlo) {
		this.codOlo = codOlo;
	}

	public String getDescrizCausalOlo() {
		return descrizCausalOlo;
	}

	public void setDescrizCausalOlo(String descrizCausalOlo) {
		this.descrizCausalOlo = descrizCausalOlo;
	}

	public String getDescrizCausalNow() {
		return descrizCausalNow;
	}

	public void setDescrizCausalNow(String descrizCausalNow) {
		this.descrizCausalNow = descrizCausalNow;
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

	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}

	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
	}

	public String getTipoRichiesta() {
		return tipoRichiesta;
	}

	public void setTipoRichiesta(String tipoRichiesta) {
		this.tipoRichiesta = tipoRichiesta;
	}

	public Boolean getFlagOpereSpeciali() {
		return flagOpereSpeciali;
	}

	public void setFlagOpereSpeciali(Boolean flagOpereSpeciali) {
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
		return Objects.hash(canalerichiesta, codOlo, codOrdineOF, codfcOloAgcom, codiceordineolo, codiceordineti,
				dataInvio, descrizCausalNow, descrizCausalOlo, flagOpereSpeciali, idOfferta, idRichiestaOlo, idRisorsa,
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
		OrdineOutputBean other = (OrdineOutputBean) obj;
		return Objects.equals(canalerichiesta, other.canalerichiesta) && Objects.equals(codOlo, other.codOlo)
				&& Objects.equals(codOrdineOF, other.codOrdineOF) && Objects.equals(codfcOloAgcom, other.codfcOloAgcom)
				&& Objects.equals(codiceordineolo, other.codiceordineolo)
				&& Objects.equals(codiceordineti, other.codiceordineti) && Objects.equals(dataInvio, other.dataInvio)
				&& Objects.equals(descrizCausalNow, other.descrizCausalNow)
				&& Objects.equals(descrizCausalOlo, other.descrizCausalOlo)
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
		return "OrdineOutputBean [codiceordineolo=" + codiceordineolo + ", codOlo=" + codOlo + ", descrizCausalOlo="
				+ descrizCausalOlo + ", descrizCausalNow=" + descrizCausalNow + ", codiceordineti=" + codiceordineti
				+ ", codfcOloAgcom=" + codfcOloAgcom + ", canalerichiesta=" + canalerichiesta + ", statorichiesteolo="
				+ statorichiesteolo + ", statorichiestanow=" + statorichiestanow + ", idRichiestaOlo=" + idRichiestaOlo
				+ ", tipoRichiesta=" + tipoRichiesta + ", flagOpereSpeciali=" + flagOpereSpeciali + ", idOfferta="
				+ idOfferta + ", dataInvio=" + dataInvio + ", idRisorsa=" + idRisorsa + ", tipoLavorazione="
				+ tipoLavorazione + ", offerta=" + offerta + ", inAttesaDesospensioneDaOao="
				+ inAttesaDesospensioneDaOao + ", codOrdineOF=" + codOrdineOF + ", noteFiberstream=" + noteFiberstream
				+ ", idRisorsaOF=" + idRisorsaOF + ", statoOF=" + statoOF + "]";
	}
    

}