package com.nttdata.tim.now.data.dto.monitoring.notificheolo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class MonitoraggioNotificheOloOutputDTO implements Serializable {

	private static final long serialVersionUID = 1422321924184161254L;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("Tipologia_OLO")
	private String tipologiaOlo;

	@JsonProperty("TOT_Attese")
	private String totAttese;

	@JsonProperty("TOT_InUscita")
	private String totInUscita;

	@JsonProperty("TOT_InUscita_FuoriSLA")
	private String totInUscitaFuoriSla;

	@JsonProperty("TOT_InUscita_InSLA")
	private String totInUscitaInSla;

	@JsonProperty("TOT_InErrore")
	private String totInErrore;

	@JsonProperty("TOT_InErrore_InSLA")
	private String totInErroreInSla;

	@JsonProperty("TOT_InErrore_FuoriSLA")
	private String totInErroreFuoriSla;

	@JsonProperty("TOT_Prodotte")
	private String totProdotte;

	@JsonProperty("TOT_Prodotte_InSLA")
	private String totProdotteInSla;

	@JsonProperty("TOT_Prodotte_FuoriSLA")
	private String totProdotteFuoriSla;

	@JsonProperty("TOT_Inviate")
	private String totInviate;

	@JsonProperty("TOT_Inviate_InSLA")
	private String totInviateInSla;

	@JsonProperty("TOT_Inviate_FuoriSLA")
	private String totInviateFuoriSla;

	@JsonProperty("TOT_Mancanti")
	private String totMancanti;

	@JsonProperty("TOT_Mancanti_InSLA")
	private String totMancantiInSla;

	@JsonProperty("TOT_Mancanti_FuoriSLA")
	private String totMancantiFuoriSla;

	@JsonProperty("TOT_NonAttese")
	private String totNonAttese;

	public String getTipologiaOlo() {
		return tipologiaOlo;
	}

	public void setTipologiaOlo(String tipologiaOlo) {
		this.tipologiaOlo = tipologiaOlo;
	}

	public String getTotAttese() {
		return totAttese;
	}

	public void setTotAttese(String totAttese) {
		this.totAttese = totAttese;
	}

	public String getTotInUscita() {
		return totInUscita;
	}

	public void setTotInUscita(String totInUscita) {
		this.totInUscita = totInUscita;
	}

	public String getTotInUscitaFuoriSla() {
		return totInUscitaFuoriSla;
	}

	public void setTotInUscitaFuoriSla(String totInUscitaFuoriSla) {
		this.totInUscitaFuoriSla = totInUscitaFuoriSla;
	}

	public String getTotInUscitaInSla() {
		return totInUscitaInSla;
	}

	public void setTotInUscitaInSla(String totInUscitaInSla) {
		this.totInUscitaInSla = totInUscitaInSla;
	}

	public String getTotInErrore() {
		return totInErrore;
	}

	public void setTotInErrore(String totInErrore) {
		this.totInErrore = totInErrore;
	}

	public String getTotInErroreInSla() {
		return totInErroreInSla;
	}

	public void setTotInErroreInSla(String totInErroreInSla) {
		this.totInErroreInSla = totInErroreInSla;
	}

	public String getTotInErroreFuoriSla() {
		return totInErroreFuoriSla;
	}

	public void setTotInErroreFuoriSla(String totInErroreFuoriSla) {
		this.totInErroreFuoriSla = totInErroreFuoriSla;
	}

	public String getTotProdotte() {
		return totProdotte;
	}

	public void setTotProdotte(String totProdotte) {
		this.totProdotte = totProdotte;
	}

	public String getTotProdotteInSla() {
		return totProdotteInSla;
	}

	public void setTotProdotteInSla(String totProdotteInSla) {
		this.totProdotteInSla = totProdotteInSla;
	}

	public String getTotProdotteFuoriSla() {
		return totProdotteFuoriSla;
	}

	public void setTotProdotteFuoriSla(String totProdotteFuoriSla) {
		this.totProdotteFuoriSla = totProdotteFuoriSla;
	}

	public String getTotInviate() {
		return totInviate;
	}

	public void setTotInviate(String totInviate) {
		this.totInviate = totInviate;
	}

	public String getTotInviateInSla() {
		return totInviateInSla;
	}

	public void setTotInviateInSla(String totInviateInSla) {
		this.totInviateInSla = totInviateInSla;
	}

	public String getTotInviateFuoriSla() {
		return totInviateFuoriSla;
	}

	public void setTotInviateFuoriSla(String totInviateFuoriSla) {
		this.totInviateFuoriSla = totInviateFuoriSla;
	}

	public String getTotMancanti() {
		return totMancanti;
	}

	public void setTotMancanti(String totMancanti) {
		this.totMancanti = totMancanti;
	}

	public String getTotMancantiInSla() {
		return totMancantiInSla;
	}

	public void setTotMancantiInSla(String totMancantiInSla) {
		this.totMancantiInSla = totMancantiInSla;
	}

	public String getTotMancantiFuoriSla() {
		return totMancantiFuoriSla;
	}

	public void setTotMancantiFuoriSla(String totMancantiFuoriSla) {
		this.totMancantiFuoriSla = totMancantiFuoriSla;
	}

	public String getTotNonAttese() {
		return totNonAttese;
	}

	public void setTotNonAttese(String totNonAttese) {
		this.totNonAttese = totNonAttese;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	@Override
	public String toString() {
		return "MonitoraggioNotificheOloDTO [offerta=" + offerta + ", tipologiaOlo=" + tipologiaOlo + ", totAttese="
				+ totAttese + ", totInUscita=" + totInUscita + ", totInUscitaFuoriSla=" + totInUscitaFuoriSla
				+ ", totInUscitaInSla=" + totInUscitaInSla + ", totInErrore=" + totInErrore + ", totInErroreInSla="
				+ totInErroreInSla + ", totInErroreFuoriSla=" + totInErroreFuoriSla + ", totProdotte=" + totProdotte
				+ ", totProdotteInSla=" + totProdotteInSla + ", totProdotteFuoriSla=" + totProdotteFuoriSla
				+ ", totInviate=" + totInviate + ", totInviateInSla=" + totInviateInSla + ", totInviateFuoriSla="
				+ totInviateFuoriSla + ", totMancanti=" + totMancanti + ", totMancantiInSla=" + totMancantiInSla
				+ ", totMancantiFuoriSla=" + totMancantiFuoriSla + ", totNonAttese=" + totNonAttese + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((tipologiaOlo == null) ? 0 : tipologiaOlo.hashCode());
		result = prime * result + ((totAttese == null) ? 0 : totAttese.hashCode());
		result = prime * result + ((totInErrore == null) ? 0 : totInErrore.hashCode());
		result = prime * result + ((totInErroreFuoriSla == null) ? 0 : totInErroreFuoriSla.hashCode());
		result = prime * result + ((totInErroreInSla == null) ? 0 : totInErroreInSla.hashCode());
		result = prime * result + ((totInUscita == null) ? 0 : totInUscita.hashCode());
		result = prime * result + ((totInUscitaFuoriSla == null) ? 0 : totInUscitaFuoriSla.hashCode());
		result = prime * result + ((totInUscitaInSla == null) ? 0 : totInUscitaInSla.hashCode());
		result = prime * result + ((totInviate == null) ? 0 : totInviate.hashCode());
		result = prime * result + ((totInviateFuoriSla == null) ? 0 : totInviateFuoriSla.hashCode());
		result = prime * result + ((totInviateInSla == null) ? 0 : totInviateInSla.hashCode());
		result = prime * result + ((totMancanti == null) ? 0 : totMancanti.hashCode());
		result = prime * result + ((totMancantiFuoriSla == null) ? 0 : totMancantiFuoriSla.hashCode());
		result = prime * result + ((totMancantiInSla == null) ? 0 : totMancantiInSla.hashCode());
		result = prime * result + ((totNonAttese == null) ? 0 : totNonAttese.hashCode());
		result = prime * result + ((totProdotte == null) ? 0 : totProdotte.hashCode());
		result = prime * result + ((totProdotteFuoriSla == null) ? 0 : totProdotteFuoriSla.hashCode());
		result = prime * result + ((totProdotteInSla == null) ? 0 : totProdotteInSla.hashCode());
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
		MonitoraggioNotificheOloOutputDTO other = (MonitoraggioNotificheOloOutputDTO) obj;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (tipologiaOlo == null) {
			if (other.tipologiaOlo != null)
				return false;
		} else if (!tipologiaOlo.equals(other.tipologiaOlo))
			return false;
		if (totAttese == null) {
			if (other.totAttese != null)
				return false;
		} else if (!totAttese.equals(other.totAttese))
			return false;
		if (totInErrore == null) {
			if (other.totInErrore != null)
				return false;
		} else if (!totInErrore.equals(other.totInErrore))
			return false;
		if (totInErroreFuoriSla == null) {
			if (other.totInErroreFuoriSla != null)
				return false;
		} else if (!totInErroreFuoriSla.equals(other.totInErroreFuoriSla))
			return false;
		if (totInErroreInSla == null) {
			if (other.totInErroreInSla != null)
				return false;
		} else if (!totInErroreInSla.equals(other.totInErroreInSla))
			return false;
		if (totInUscita == null) {
			if (other.totInUscita != null)
				return false;
		} else if (!totInUscita.equals(other.totInUscita))
			return false;
		if (totInUscitaFuoriSla == null) {
			if (other.totInUscitaFuoriSla != null)
				return false;
		} else if (!totInUscitaFuoriSla.equals(other.totInUscitaFuoriSla))
			return false;
		if (totInUscitaInSla == null) {
			if (other.totInUscitaInSla != null)
				return false;
		} else if (!totInUscitaInSla.equals(other.totInUscitaInSla))
			return false;
		if (totInviate == null) {
			if (other.totInviate != null)
				return false;
		} else if (!totInviate.equals(other.totInviate))
			return false;
		if (totInviateFuoriSla == null) {
			if (other.totInviateFuoriSla != null)
				return false;
		} else if (!totInviateFuoriSla.equals(other.totInviateFuoriSla))
			return false;
		if (totInviateInSla == null) {
			if (other.totInviateInSla != null)
				return false;
		} else if (!totInviateInSla.equals(other.totInviateInSla))
			return false;
		if (totMancanti == null) {
			if (other.totMancanti != null)
				return false;
		} else if (!totMancanti.equals(other.totMancanti))
			return false;
		if (totMancantiFuoriSla == null) {
			if (other.totMancantiFuoriSla != null)
				return false;
		} else if (!totMancantiFuoriSla.equals(other.totMancantiFuoriSla))
			return false;
		if (totMancantiInSla == null) {
			if (other.totMancantiInSla != null)
				return false;
		} else if (!totMancantiInSla.equals(other.totMancantiInSla))
			return false;
		if (totNonAttese == null) {
			if (other.totNonAttese != null)
				return false;
		} else if (!totNonAttese.equals(other.totNonAttese))
			return false;
		if (totProdotte == null) {
			if (other.totProdotte != null)
				return false;
		} else if (!totProdotte.equals(other.totProdotte))
			return false;
		if (totProdotteFuoriSla == null) {
			if (other.totProdotteFuoriSla != null)
				return false;
		} else if (!totProdotteFuoriSla.equals(other.totProdotteFuoriSla))
			return false;
		if (totProdotteInSla == null) {
			if (other.totProdotteInSla != null)
				return false;
		} else if (!totProdotteInSla.equals(other.totProdotteInSla))
			return false;
		return true;
	}

}
