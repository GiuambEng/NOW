package com.nttdata.tim.now.data.bean.pps;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DettaglioAmministrazioneDatiOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -8135638819866279202L;

    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineValidita")
	private Date dataFineValidita;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioValidita")
	private Date dataInizioValidita;

	@JsonProperty("descrizioneSoglia")
	private String descrizioneSoglia;

	@JsonProperty("idCausale")
	private String idCausale;

	@JsonProperty("idFamigliaOfferta")
	private String idFamigliaOfferta;

	@JsonProperty("idOfferta")
	private String idOfferta;

	@JsonProperty("idRichiesta")
	private String idRichiesta;

	@JsonProperty("idStatoFile")
	private String idStatoFile;

	@JsonProperty("idTipologiaLavorazione")
	private String idTipologiaLavorazione;

	@JsonProperty("idTipologiaSoglia")
	private String idTipologiaSoglia;

	@JsonProperty("idTipologiaSottoLavorazione")
	private String idTipologiaSottoLavorazione;

	@JsonProperty("nomeSoglia")
	private String nomeSoglia;

	@JsonProperty("valoreSoglia")
	private String valoreSoglia;

	@JsonProperty("idSoglia")
	private String idSoglia;

	public Date getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(Date dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public Date getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public String getDescrizioneSoglia() {
		return descrizioneSoglia;
	}

	public void setDescrizioneSoglia(String descrizioneSoglia) {
		this.descrizioneSoglia = descrizioneSoglia;
	}

	public String getIdCausale() {
		return idCausale;
	}

	public void setIdCausale(String idCausale) {
		this.idCausale = idCausale;
	}

	public String getIdFamigliaOfferta() {
		return idFamigliaOfferta;
	}

	public void setIdFamigliaOfferta(String idFamigliaOfferta) {
		this.idFamigliaOfferta = idFamigliaOfferta;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getIdRichiesta() {
		return idRichiesta;
	}

	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	public String getIdStatoFile() {
		return idStatoFile;
	}

	public void setIdStatoFile(String idStatoFile) {
		this.idStatoFile = idStatoFile;
	}

	public String getIdTipologiaLavorazione() {
		return idTipologiaLavorazione;
	}

	public void setIdTipologiaLavorazione(String idTipologiaLavorazione) {
		this.idTipologiaLavorazione = idTipologiaLavorazione;
	}

	public String getIdTipologiaSoglia() {
		return idTipologiaSoglia;
	}

	public void setIdTipologiaSoglia(String idTipologiaSoglia) {
		this.idTipologiaSoglia = idTipologiaSoglia;
	}

	public String getIdTipologiaSottoLavorazione() {
		return idTipologiaSottoLavorazione;
	}

	public void setIdTipologiaSottoLavorazione(String idTipologiaSottoLavorazione) {
		this.idTipologiaSottoLavorazione = idTipologiaSottoLavorazione;
	}

	public String getNomeSoglia() {
		return nomeSoglia;
	}

	public void setNomeSoglia(String nomeSoglia) {
		this.nomeSoglia = nomeSoglia;
	}

	public String getValoreSoglia() {
		return valoreSoglia;
	}

	public void setValoreSoglia(String valoreSoglia) {
		this.valoreSoglia = valoreSoglia;
	}

	public String getIdSoglia() {
		return idSoglia;
	}

	public void setIdSoglia(String idSoglia) {
		this.idSoglia = idSoglia;
	}

}