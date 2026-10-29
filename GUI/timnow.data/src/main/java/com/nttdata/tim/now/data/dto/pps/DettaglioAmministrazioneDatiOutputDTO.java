package com.nttdata.tim.now.data.dto.pps;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DettaglioAmministrazioneDatiOutputDTO implements Serializable {

	private static final long serialVersionUID = -7610388578877857935L;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("Fine_Validita")
	private Date dataFineValidita;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("Inizio_Validita")
	private Date dataInizioValidita;

	@JsonProperty("Descrizione")
	private String descrizioneSoglia;

	@JsonProperty("Causale")
	private String idCausale;

	@JsonProperty("Famiglia_Offerta")
	private String idFamigliaOfferta;

	@JsonProperty("Offerta")
	private String idOfferta;

	@JsonProperty("Richiesta")
	private String idRichiesta;

	@JsonProperty("StatoFile")
	private String idStatoFile;

	@JsonProperty("Lavorazione")
	private String idTipologiaLavorazione;

	@JsonProperty("Tipo_Soglia")
	private String idTipologiaSoglia;

	@JsonProperty("Sotto_Lavorazione")
	private String idTipologiaSottoLavorazione;

	@JsonProperty("Soglia")
	private String nomeSoglia;

	@JsonProperty("Valore")
	private String valoreSoglia;

	@JsonProperty("Id_Pps_Soglia_Analisi")
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
