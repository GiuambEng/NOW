package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaCompatibilitaLavorazioneInputBean implements Serializable {
    
	private static final long serialVersionUID = -7766822015340802164L;

	@JsonProperty("offertaRichiesta")
    private String offertaRichiesta;
    
    @JsonProperty("tipologiaLineaRichiesta")
    private String tipologiaLineaRichiesta;
    
    @JsonProperty("lavorazioneRichiesta")
    private String lavorazioneRichiesta;
    
    @JsonProperty("flagNPAsset")
    private String flagNPAsset;
    
    @JsonProperty("destinazioneUsoRichiestaOlo")
    private String destinazioneUsoRichiestaOlo;
    
    @JsonProperty("idRichiestaOlo")
    private String idRichiestaOlo;
    
    @JsonProperty("codiceRisorsa1")
    private String codiceRisorsa1;
    
    @JsonProperty("codiceRisorsa2")
    private String codiceRisorsa2;
    
    @JsonProperty("codificaOloAgcom")
    private String codificaOloAgcom;
    
    @JsonProperty("codificaOloAgcomRecipient")
    private String codificaOloAgcomRecipient;
    
    @JsonProperty("codiceSessione1")
    private String codiceSessione1;
    
    @JsonProperty("codiceSessione2")
    private String codiceSessione2;

	public String getOffertaRichiesta() {
		return offertaRichiesta;
	}

	public void setOffertaRichiesta(String offertaRichiesta) {
		this.offertaRichiesta = offertaRichiesta;
	}

	public String getTipologiaLineaRichiesta() {
		return tipologiaLineaRichiesta;
	}

	public void setTipologiaLineaRichiesta(String tipologiaLineaRichiesta) {
		this.tipologiaLineaRichiesta = tipologiaLineaRichiesta;
	}

	public String getLavorazioneRichiesta() {
		return lavorazioneRichiesta;
	}

	public void setLavorazioneRichiesta(String lavorazioneRichiesta) {
		this.lavorazioneRichiesta = lavorazioneRichiesta;
	}

	public String getFlagNPAsset() {
		return flagNPAsset;
	}

	public void setFlagNPAsset(String flagNPAsset) {
		this.flagNPAsset = flagNPAsset;
	}

	public String getDestinazioneUsoRichiestaOlo() {
		return destinazioneUsoRichiestaOlo;
	}

	public void setDestinazioneUsoRichiestaOlo(String destinazioneUsoRichiestaOlo) {
		this.destinazioneUsoRichiestaOlo = destinazioneUsoRichiestaOlo;
	}

	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}

	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
	}

	public String getCodiceRisorsa1() {
		return codiceRisorsa1;
	}

	public void setCodiceRisorsa1(String codiceRisorsa1) {
		this.codiceRisorsa1 = codiceRisorsa1;
	}

	public String getCodiceRisorsa2() {
		return codiceRisorsa2;
	}

	public void setCodiceRisorsa2(String codiceRisorsa2) {
		this.codiceRisorsa2 = codiceRisorsa2;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getCodificaOloAgcomRecipient() {
		return codificaOloAgcomRecipient;
	}

	public void setCodificaOloAgcomRecipient(String codificaOloAgcomRecipient) {
		this.codificaOloAgcomRecipient = codificaOloAgcomRecipient;
	}

	public String getCodiceSessione1() {
		return codiceSessione1;
	}

	public void setCodiceSessione1(String codiceSessione1) {
		this.codiceSessione1 = codiceSessione1;
	}

	public String getCodiceSessione2() {
		return codiceSessione2;
	}

	public void setCodiceSessione2(String codiceSessione2) {
		this.codiceSessione2 = codiceSessione2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceRisorsa1 == null) ? 0 : codiceRisorsa1.hashCode());
		result = prime * result + ((codiceRisorsa2 == null) ? 0 : codiceRisorsa2.hashCode());
		result = prime * result + ((codiceSessione1 == null) ? 0 : codiceSessione1.hashCode());
		result = prime * result + ((codiceSessione2 == null) ? 0 : codiceSessione2.hashCode());
		result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
		result = prime * result + ((codificaOloAgcomRecipient == null) ? 0 : codificaOloAgcomRecipient.hashCode());
		result = prime * result + ((destinazioneUsoRichiestaOlo == null) ? 0 : destinazioneUsoRichiestaOlo.hashCode());
		result = prime * result + ((flagNPAsset == null) ? 0 : flagNPAsset.hashCode());
		result = prime * result + ((idRichiestaOlo == null) ? 0 : idRichiestaOlo.hashCode());
		result = prime * result + ((lavorazioneRichiesta == null) ? 0 : lavorazioneRichiesta.hashCode());
		result = prime * result + ((offertaRichiesta == null) ? 0 : offertaRichiesta.hashCode());
		result = prime * result + ((tipologiaLineaRichiesta == null) ? 0 : tipologiaLineaRichiesta.hashCode());
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
		VerificaCompatibilitaLavorazioneInputBean other = (VerificaCompatibilitaLavorazioneInputBean) obj;
		if (codiceRisorsa1 == null) {
			if (other.codiceRisorsa1 != null)
				return false;
		} else if (!codiceRisorsa1.equals(other.codiceRisorsa1))
			return false;
		if (codiceRisorsa2 == null) {
			if (other.codiceRisorsa2 != null)
				return false;
		} else if (!codiceRisorsa2.equals(other.codiceRisorsa2))
			return false;
		if (codiceSessione1 == null) {
			if (other.codiceSessione1 != null)
				return false;
		} else if (!codiceSessione1.equals(other.codiceSessione1))
			return false;
		if (codiceSessione2 == null) {
			if (other.codiceSessione2 != null)
				return false;
		} else if (!codiceSessione2.equals(other.codiceSessione2))
			return false;
		if (codificaOloAgcom == null) {
			if (other.codificaOloAgcom != null)
				return false;
		} else if (!codificaOloAgcom.equals(other.codificaOloAgcom))
			return false;
		if (codificaOloAgcomRecipient == null) {
			if (other.codificaOloAgcomRecipient != null)
				return false;
		} else if (!codificaOloAgcomRecipient.equals(other.codificaOloAgcomRecipient))
			return false;
		if (destinazioneUsoRichiestaOlo == null) {
			if (other.destinazioneUsoRichiestaOlo != null)
				return false;
		} else if (!destinazioneUsoRichiestaOlo.equals(other.destinazioneUsoRichiestaOlo))
			return false;
		if (flagNPAsset == null) {
			if (other.flagNPAsset != null)
				return false;
		} else if (!flagNPAsset.equals(other.flagNPAsset))
			return false;
		if (idRichiestaOlo == null) {
			if (other.idRichiestaOlo != null)
				return false;
		} else if (!idRichiestaOlo.equals(other.idRichiestaOlo))
			return false;
		if (lavorazioneRichiesta == null) {
			if (other.lavorazioneRichiesta != null)
				return false;
		} else if (!lavorazioneRichiesta.equals(other.lavorazioneRichiesta))
			return false;
		if (offertaRichiesta == null) {
			if (other.offertaRichiesta != null)
				return false;
		} else if (!offertaRichiesta.equals(other.offertaRichiesta))
			return false;
		if (tipologiaLineaRichiesta == null) {
			if (other.tipologiaLineaRichiesta != null)
				return false;
		} else if (!tipologiaLineaRichiesta.equals(other.tipologiaLineaRichiesta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificaCompatibilitaLavorazioneInputBean [offertaRichiesta=" + offertaRichiesta
				+ ", tipologiaLineaRichiesta=" + tipologiaLineaRichiesta + ", lavorazioneRichiesta="
				+ lavorazioneRichiesta + ", flagNPAsset=" + flagNPAsset + ", destinazioneUsoRichiestaOlo="
				+ destinazioneUsoRichiestaOlo + ", idRichiestaOlo=" + idRichiestaOlo + ", codiceRisorsa1="
				+ codiceRisorsa1 + ", codiceRisorsa2=" + codiceRisorsa2 + ", codificaOloAgcom=" + codificaOloAgcom
				+ ", codificaOloAgcomRecipient=" + codificaOloAgcomRecipient + ", codiceSessione1=" + codiceSessione1
				+ ", codiceSessione2=" + codiceSessione2 + "]";
	}

}
