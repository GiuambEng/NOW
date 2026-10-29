package com.nttdata.tim.now.data.dto.monitoring.notificheolo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DettaglioMonitoraggioNotificheOloOutputDTO implements Serializable {

	private static final long serialVersionUID = 2798531842812067586L;

	@JsonProperty("ambito")
	private String ambito;

	@JsonProperty("ordineOLO")
	private String ordineOlo;

	@JsonProperty("ordineTI")
	private String ordineTi;

	@JsonProperty("codificaOAO")
	private String codificaOao;

	@JsonProperty("idRichiesta")
	private String idRichiesta;

	@JsonProperty("lavorazione")
	private String lavorazione;

	@JsonProperty("stato_A")
	private String statoA;

	@JsonProperty("stato_DA")
	private String statoDa;

	@JsonProperty("rowID_Tracciamento")
	private String rowIdTracciamento;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataNotifica")
	private Date dataNotifica;

	@JsonProperty("idNotifica")
	private String idNotifica;

	@JsonProperty("descrizione")
	private String descrizione;

	@JsonProperty("tipologiaOLO")
	private String tipologiaOlo;

	@JsonProperty("rowIDNotifica")
	private String rowIdNotifica;

	@JsonProperty("canale")
	private String canale;

	@JsonProperty("tracciato_Errore")
	private String tracciatoErrore;

	@JsonProperty("famigliaOfferta")
	private String famigliaOfferta;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("nomeFILE_NotificaOraria")
	private String nomeFileNotificaOraria;

	@JsonProperty("nomeFILE_NotificaGiornaliera")
	private String nomeFileNotificaGiornaliera;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInserimento_File")
	private Date dataInserimentoFile;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInvio_File")
	private Date dataInvioFile;

	@JsonProperty("esito_Invio")
	private String esitoInvio;

	@JsonProperty("attesa")
	private String attesa;

	@JsonProperty("stato")
	private String stato;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataPassaggio_Stato")
	private Date dataPassaggioStato;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataAcquisizione_Ordine")
	private Date dataAcquisizioneOrdine;

	@JsonProperty("numeroTelefono_Cliente")
	private String numeroTelefonoCliente;

	@JsonProperty("soglia")
	private String soglia;

	public String getOrdineOlo() {
		return ordineOlo;
	}

	public void setOrdineOlo(String ordineOlo) {
		this.ordineOlo = ordineOlo;
	}

	public String getOrdineTi() {
		return ordineTi;
	}

	public void setOrdineTi(String ordineTi) {
		this.ordineTi = ordineTi;
	}

	public String getCodificaOao() {
		return codificaOao;
	}

	public void setCodificaOao(String codificaOao) {
		this.codificaOao = codificaOao;
	}

	public String getIdRichiesta() {
		return idRichiesta;
	}

	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getStatoA() {
		return statoA;
	}

	public void setStatoA(String statoA) {
		this.statoA = statoA;
	}

	public String getStatoDa() {
		return statoDa;
	}

	public void setStatoDa(String statoDa) {
		this.statoDa = statoDa;
	}

	public String getRowIdTracciamento() {
		return rowIdTracciamento;
	}

	public void setRowIdTracciamento(String rowIdTracciamento) {
		this.rowIdTracciamento = rowIdTracciamento;
	}

	public Date getDataNotifica() {
		return dataNotifica;
	}

	public void setDataNotifica(Date dataNotifica) {
		this.dataNotifica = dataNotifica;
	}

	public String getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTipologiaOlo() {
		return tipologiaOlo;
	}

	public void setTipologiaOlo(String tipologiaOlo) {
		this.tipologiaOlo = tipologiaOlo;
	}

	public String getRowIdNotifica() {
		return rowIdNotifica;
	}

	public void setRowIdNotifica(String rowIdNotifica) {
		this.rowIdNotifica = rowIdNotifica;
	}

	public String getCanale() {
		return canale;
	}

	public void setCanale(String canale) {
		this.canale = canale;
	}

	public String getTracciatoErrore() {
		return tracciatoErrore;
	}

	public void setTracciatoErrore(String tracciatoErrore) {
		this.tracciatoErrore = tracciatoErrore;
	}

	public String getFamigliaOfferta() {
		return famigliaOfferta;
	}

	public void setFamigliaOfferta(String famigliaOfferta) {
		this.famigliaOfferta = famigliaOfferta;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getNomeFileNotificaOraria() {
		return nomeFileNotificaOraria;
	}

	public void setNomeFileNotificaOraria(String nomeFileNotificaOraria) {
		this.nomeFileNotificaOraria = nomeFileNotificaOraria;
	}

	public String getNomeFileNotificaGiornaliera() {
		return nomeFileNotificaGiornaliera;
	}

	public void setNomeFileNotificaGiornaliera(String nomeFileNotificaGiornaliera) {
		this.nomeFileNotificaGiornaliera = nomeFileNotificaGiornaliera;
	}

	public Date getDataInserimentoFile() {
		return dataInserimentoFile;
	}

	public void setDataInserimentoFile(Date dataInserimentoFile) {
		this.dataInserimentoFile = dataInserimentoFile;
	}

	public Date getDataInvioFile() {
		return dataInvioFile;
	}

	public void setDataInvioFile(Date dataInvioFile) {
		this.dataInvioFile = dataInvioFile;
	}

	public String getEsitoInvio() {
		return esitoInvio;
	}

	public void setEsitoInvio(String esitoInvio) {
		this.esitoInvio = esitoInvio;
	}

	public String getAttesa() {
		return attesa;
	}

	public void setAttesa(String attesa) {
		this.attesa = attesa;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDataPassaggioStato() {
		return dataPassaggioStato;
	}

	public void setDataPassaggioStato(Date dataPassaggioStato) {
		this.dataPassaggioStato = dataPassaggioStato;
	}

	public Date getDataAcquisizioneOrdine() {
		return dataAcquisizioneOrdine;
	}

	public void setDataAcquisizioneOrdine(Date dataAcquisizioneOrdine) {
		this.dataAcquisizioneOrdine = dataAcquisizioneOrdine;
	}

	public String getNumeroTelefonoCliente() {
		return numeroTelefonoCliente;
	}

	public void setNumeroTelefonoCliente(String numeroTelefonoCliente) {
		this.numeroTelefonoCliente = numeroTelefonoCliente;
	}

	public String getSoglia() {
		return soglia;
	}

	public void setSoglia(String soglia) {
		this.soglia = soglia;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	@Override
	public String toString() {
		return "DettaglioMonitoraggioNotificheOloDTO [ambito=" + ambito + ", ordineOlo=" + ordineOlo + ", ordineTi="
				+ ordineTi + ", codificaOao=" + codificaOao + ", idRichiesta=" + idRichiesta + ", lavorazione="
				+ lavorazione + ", statoA=" + statoA + ", statoDa=" + statoDa + ", rowIdTracciamento="
				+ rowIdTracciamento + ", dataNotifica=" + dataNotifica + ", idNotifica=" + idNotifica + ", descrizione="
				+ descrizione + ", tipologiaOlo=" + tipologiaOlo + ", rowIdNotifica=" + rowIdNotifica + ", canale="
				+ canale + ", tracciatoErrore=" + tracciatoErrore + ", famigliaOfferta=" + famigliaOfferta
				+ ", offerta=" + offerta + ", nomeFileNotificaOraria=" + nomeFileNotificaOraria
				+ ", nomeFileNotificaGiornaliera=" + nomeFileNotificaGiornaliera + ", dataInserimentoFile="
				+ dataInserimentoFile + ", dataInvioFile=" + dataInvioFile + ", esitoInvio=" + esitoInvio + ", attesa="
				+ attesa + ", stato=" + stato + ", dataPassaggioStato=" + dataPassaggioStato
				+ ", dataAcquisizioneOrdine=" + dataAcquisizioneOrdine + ", numeroTelefonoCliente="
				+ numeroTelefonoCliente + ", soglia=" + soglia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambito == null) ? 0 : ambito.hashCode());
		result = prime * result + ((attesa == null) ? 0 : attesa.hashCode());
		result = prime * result + ((canale == null) ? 0 : canale.hashCode());
		result = prime * result + ((codificaOao == null) ? 0 : codificaOao.hashCode());
		result = prime * result + ((dataAcquisizioneOrdine == null) ? 0 : dataAcquisizioneOrdine.hashCode());
		result = prime * result + ((dataInserimentoFile == null) ? 0 : dataInserimentoFile.hashCode());
		result = prime * result + ((dataInvioFile == null) ? 0 : dataInvioFile.hashCode());
		result = prime * result + ((dataNotifica == null) ? 0 : dataNotifica.hashCode());
		result = prime * result + ((dataPassaggioStato == null) ? 0 : dataPassaggioStato.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((esitoInvio == null) ? 0 : esitoInvio.hashCode());
		result = prime * result + ((famigliaOfferta == null) ? 0 : famigliaOfferta.hashCode());
		result = prime * result + ((idNotifica == null) ? 0 : idNotifica.hashCode());
		result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
		result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
		result = prime * result + ((nomeFileNotificaGiornaliera == null) ? 0 : nomeFileNotificaGiornaliera.hashCode());
		result = prime * result + ((nomeFileNotificaOraria == null) ? 0 : nomeFileNotificaOraria.hashCode());
		result = prime * result + ((numeroTelefonoCliente == null) ? 0 : numeroTelefonoCliente.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((ordineOlo == null) ? 0 : ordineOlo.hashCode());
		result = prime * result + ((ordineTi == null) ? 0 : ordineTi.hashCode());
		result = prime * result + ((rowIdNotifica == null) ? 0 : rowIdNotifica.hashCode());
		result = prime * result + ((rowIdTracciamento == null) ? 0 : rowIdTracciamento.hashCode());
		result = prime * result + ((soglia == null) ? 0 : soglia.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((statoA == null) ? 0 : statoA.hashCode());
		result = prime * result + ((statoDa == null) ? 0 : statoDa.hashCode());
		result = prime * result + ((tipologiaOlo == null) ? 0 : tipologiaOlo.hashCode());
		result = prime * result + ((tracciatoErrore == null) ? 0 : tracciatoErrore.hashCode());
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
		DettaglioMonitoraggioNotificheOloOutputDTO other = (DettaglioMonitoraggioNotificheOloOutputDTO) obj;
		if (ambito == null) {
			if (other.ambito != null)
				return false;
		} else if (!ambito.equals(other.ambito))
			return false;
		if (attesa == null) {
			if (other.attesa != null)
				return false;
		} else if (!attesa.equals(other.attesa))
			return false;
		if (canale == null) {
			if (other.canale != null)
				return false;
		} else if (!canale.equals(other.canale))
			return false;
		if (codificaOao == null) {
			if (other.codificaOao != null)
				return false;
		} else if (!codificaOao.equals(other.codificaOao))
			return false;
		if (dataAcquisizioneOrdine == null) {
			if (other.dataAcquisizioneOrdine != null)
				return false;
		} else if (!dataAcquisizioneOrdine.equals(other.dataAcquisizioneOrdine))
			return false;
		if (dataInserimentoFile == null) {
			if (other.dataInserimentoFile != null)
				return false;
		} else if (!dataInserimentoFile.equals(other.dataInserimentoFile))
			return false;
		if (dataInvioFile == null) {
			if (other.dataInvioFile != null)
				return false;
		} else if (!dataInvioFile.equals(other.dataInvioFile))
			return false;
		if (dataNotifica == null) {
			if (other.dataNotifica != null)
				return false;
		} else if (!dataNotifica.equals(other.dataNotifica))
			return false;
		if (dataPassaggioStato == null) {
			if (other.dataPassaggioStato != null)
				return false;
		} else if (!dataPassaggioStato.equals(other.dataPassaggioStato))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (esitoInvio == null) {
			if (other.esitoInvio != null)
				return false;
		} else if (!esitoInvio.equals(other.esitoInvio))
			return false;
		if (famigliaOfferta == null) {
			if (other.famigliaOfferta != null)
				return false;
		} else if (!famigliaOfferta.equals(other.famigliaOfferta))
			return false;
		if (idNotifica == null) {
			if (other.idNotifica != null)
				return false;
		} else if (!idNotifica.equals(other.idNotifica))
			return false;
		if (idRichiesta == null) {
			if (other.idRichiesta != null)
				return false;
		} else if (!idRichiesta.equals(other.idRichiesta))
			return false;
		if (lavorazione == null) {
			if (other.lavorazione != null)
				return false;
		} else if (!lavorazione.equals(other.lavorazione))
			return false;
		if (nomeFileNotificaGiornaliera == null) {
			if (other.nomeFileNotificaGiornaliera != null)
				return false;
		} else if (!nomeFileNotificaGiornaliera.equals(other.nomeFileNotificaGiornaliera))
			return false;
		if (nomeFileNotificaOraria == null) {
			if (other.nomeFileNotificaOraria != null)
				return false;
		} else if (!nomeFileNotificaOraria.equals(other.nomeFileNotificaOraria))
			return false;
		if (numeroTelefonoCliente == null) {
			if (other.numeroTelefonoCliente != null)
				return false;
		} else if (!numeroTelefonoCliente.equals(other.numeroTelefonoCliente))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (ordineOlo == null) {
			if (other.ordineOlo != null)
				return false;
		} else if (!ordineOlo.equals(other.ordineOlo))
			return false;
		if (ordineTi == null) {
			if (other.ordineTi != null)
				return false;
		} else if (!ordineTi.equals(other.ordineTi))
			return false;
		if (rowIdNotifica == null) {
			if (other.rowIdNotifica != null)
				return false;
		} else if (!rowIdNotifica.equals(other.rowIdNotifica))
			return false;
		if (rowIdTracciamento == null) {
			if (other.rowIdTracciamento != null)
				return false;
		} else if (!rowIdTracciamento.equals(other.rowIdTracciamento))
			return false;
		if (soglia == null) {
			if (other.soglia != null)
				return false;
		} else if (!soglia.equals(other.soglia))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (statoA == null) {
			if (other.statoA != null)
				return false;
		} else if (!statoA.equals(other.statoA))
			return false;
		if (statoDa == null) {
			if (other.statoDa != null)
				return false;
		} else if (!statoDa.equals(other.statoDa))
			return false;
		if (tipologiaOlo == null) {
			if (other.tipologiaOlo != null)
				return false;
		} else if (!tipologiaOlo.equals(other.tipologiaOlo))
			return false;
		if (tracciatoErrore == null) {
			if (other.tracciatoErrore != null)
				return false;
		} else if (!tracciatoErrore.equals(other.tracciatoErrore))
			return false;
		return true;
	}

}
