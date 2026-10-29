package com.nttdata.tim.now.data.bean.monitoring.reinvionotifiche;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RinvioNotificheOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -4814945726240010474L;

    @JsonProperty("tipologiaNotifica")
	private String tipologiaNotifica;

	@JsonProperty("causaleInterno")
	private String causaleInterno;

	@JsonProperty("causaleNowDg")
	private String causaleNowDg;

	@JsonProperty("descrizioneCausaleOlo")
	private String descrizioneCausaleOlo;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataCreazione")
	private Date dataCreazione;

	@JsonProperty("idNotifica")
	private String idNotifica;

	@JsonProperty("tipologiaNtfGiornaliero")
	private String tipologiaNtfGiornaliero;

    @JsonProperty("tipologiaNtfMensile")
    private String tipologiaNtfMensile;

	@JsonProperty("tipologiaNtfOrario")
	private String tipologiaNtfOrario;

	@JsonProperty("origineNotifica")
	private String origineNotifica;

	@JsonProperty("strutturaRichiesta")
	private String strutturaRichiesta;

	@JsonProperty("tracciatoFile")
	private String tracciatoFile;

    @JsonProperty("tracciatoMail")
    private String tracciatoMail;

	@JsonProperty("flagNotificaStandard")
    private String flagNotificaStandard;

	@JsonProperty("flagNotificaStraordinaria")
    private String flagNotificaStraordinaria;

	@JsonProperty("flagNotificaMail")
    private String flagNotificaMail;

	@JsonProperty("idRichiesta")
	private String idRichiesta;

	public String getTipologiaNotifica() {
		return tipologiaNotifica;
	}

	public void setTipologiaNotifica(String tipologiaNotifica) {
		this.tipologiaNotifica = tipologiaNotifica;
	}

	public String getCausaleInterno() {
		return causaleInterno;
	}

	public void setCausaleInterno(String causaleInterno) {
		this.causaleInterno = causaleInterno;
	}

	public String getCausaleNowDg() {
		return causaleNowDg;
	}

	public void setCausaleNowDg(String causaleNowDg) {
		this.causaleNowDg = causaleNowDg;
	}

	public String getDescrizioneCausaleOlo() {
		return descrizioneCausaleOlo;
	}

	public void setDescrizioneCausaleOlo(String descrizioneCausaleOlo) {
		this.descrizioneCausaleOlo = descrizioneCausaleOlo;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public String getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	public String getTipologiaNtfGiornaliero() {
		return tipologiaNtfGiornaliero;
	}

	public void setTipologiaNtfGiornaliero(String tipologiaNtfGiornaliero) {
		this.tipologiaNtfGiornaliero = tipologiaNtfGiornaliero;
	}

    public String getTipologiaNtfMensile() {
        return tipologiaNtfMensile;
    }

    public void setTipologiaNtfMensile(String tipologiaNtfMensile) {
        this.tipologiaNtfMensile = tipologiaNtfMensile;
    }

	public String getTipologiaNtfOrario() {
		return tipologiaNtfOrario;
	}

	public void setTipologiaNtfOrario(String tipologiaNtfOrario) {
		this.tipologiaNtfOrario = tipologiaNtfOrario;
	}

	public String getOrigineNotifica() {
		return origineNotifica;
	}

	public void setOrigineNotifica(String origineNotifica) {
		this.origineNotifica = origineNotifica;
	}

	public String getStrutturaRichiesta() {
		return strutturaRichiesta;
	}

	public void setStrutturaRichiesta(String strutturaRichiesta) {
		this.strutturaRichiesta = strutturaRichiesta;
	}

	public String getTracciatoFile() {
		return tracciatoFile;
	}

	public void setTracciatoFile(String tracciatoFile) {
		this.tracciatoFile = tracciatoFile;
	}

    public String getTracciatoMail() {
        return tracciatoMail;
    }

    public void setTracciatoMail(String tracciatoMail) {
        this.tracciatoMail = tracciatoMail;
    }

    public String getFlagNotificaStandard() {
		return flagNotificaStandard;
	}

    public void setFlagNotificaStandard(String flagNotificaStandard) {
		this.flagNotificaStandard = flagNotificaStandard;
	}

    public String getFlagNotificaStraordinaria() {
        return flagNotificaStraordinaria;
    }

    public void setFlagNotificaStraordinaria(String flagNotificaStraordinaria) {
        this.flagNotificaStraordinaria = flagNotificaStraordinaria;
    }

    public String getFlagNotificaMail() {
        return flagNotificaMail;
    }

    public void setFlagNotificaMail(String flagNotificaMail) {
        this.flagNotificaMail = flagNotificaMail;
    }

    public String getIdRichiesta() {
        return idRichiesta;
    }

    public void setIdRichiesta(String idRichiesta) {
        this.idRichiesta = idRichiesta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((causaleInterno == null) ? 0 : causaleInterno.hashCode());
        result = prime * result + ((causaleNowDg == null) ? 0 : causaleNowDg.hashCode());
        result = prime * result + ((dataCreazione == null) ? 0 : dataCreazione.hashCode());
        result = prime * result + ((descrizioneCausaleOlo == null) ? 0 : descrizioneCausaleOlo.hashCode());
        result = prime * result + ((flagNotificaMail == null) ? 0 : flagNotificaMail.hashCode());
        result = prime * result + ((flagNotificaStandard == null) ? 0 : flagNotificaStandard.hashCode());
        result = prime * result + ((flagNotificaStraordinaria == null) ? 0 : flagNotificaStraordinaria.hashCode());
        result = prime * result + ((idNotifica == null) ? 0 : idNotifica.hashCode());
        result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
        result = prime * result + ((origineNotifica == null) ? 0 : origineNotifica.hashCode());
        result = prime * result + ((strutturaRichiesta == null) ? 0 : strutturaRichiesta.hashCode());
        result = prime * result + ((tipologiaNotifica == null) ? 0 : tipologiaNotifica.hashCode());
        result = prime * result + ((tipologiaNtfGiornaliero == null) ? 0 : tipologiaNtfGiornaliero.hashCode());
        result = prime * result + ((tipologiaNtfMensile == null) ? 0 : tipologiaNtfMensile.hashCode());
        result = prime * result + ((tipologiaNtfOrario == null) ? 0 : tipologiaNtfOrario.hashCode());
        result = prime * result + ((tracciatoFile == null) ? 0 : tracciatoFile.hashCode());
        result = prime * result + ((tracciatoMail == null) ? 0 : tracciatoMail.hashCode());
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
        RinvioNotificheOutputBean other = (RinvioNotificheOutputBean) obj;
        if (causaleInterno == null) {
            if (other.causaleInterno != null)
                return false;
        } else if (!causaleInterno.equals(other.causaleInterno))
            return false;
        if (causaleNowDg == null) {
            if (other.causaleNowDg != null)
                return false;
        } else if (!causaleNowDg.equals(other.causaleNowDg))
            return false;
        if (dataCreazione == null) {
            if (other.dataCreazione != null)
                return false;
        } else if (!dataCreazione.equals(other.dataCreazione))
            return false;
        if (descrizioneCausaleOlo == null) {
            if (other.descrizioneCausaleOlo != null)
                return false;
        } else if (!descrizioneCausaleOlo.equals(other.descrizioneCausaleOlo))
            return false;
        if (flagNotificaMail == null) {
            if (other.flagNotificaMail != null)
                return false;
        } else if (!flagNotificaMail.equals(other.flagNotificaMail))
            return false;
        if (flagNotificaStandard == null) {
            if (other.flagNotificaStandard != null)
                return false;
        } else if (!flagNotificaStandard.equals(other.flagNotificaStandard))
            return false;
        if (flagNotificaStraordinaria == null) {
            if (other.flagNotificaStraordinaria != null)
                return false;
        } else if (!flagNotificaStraordinaria.equals(other.flagNotificaStraordinaria))
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
        if (origineNotifica == null) {
            if (other.origineNotifica != null)
                return false;
        } else if (!origineNotifica.equals(other.origineNotifica))
            return false;
        if (strutturaRichiesta == null) {
            if (other.strutturaRichiesta != null)
                return false;
        } else if (!strutturaRichiesta.equals(other.strutturaRichiesta))
            return false;
        if (tipologiaNotifica == null) {
            if (other.tipologiaNotifica != null)
                return false;
        } else if (!tipologiaNotifica.equals(other.tipologiaNotifica))
            return false;
        if (tipologiaNtfGiornaliero == null) {
            if (other.tipologiaNtfGiornaliero != null)
                return false;
        } else if (!tipologiaNtfGiornaliero.equals(other.tipologiaNtfGiornaliero))
            return false;
        if (tipologiaNtfMensile == null) {
            if (other.tipologiaNtfMensile != null)
                return false;
        } else if (!tipologiaNtfMensile.equals(other.tipologiaNtfMensile))
            return false;
        if (tipologiaNtfOrario == null) {
            if (other.tipologiaNtfOrario != null)
                return false;
        } else if (!tipologiaNtfOrario.equals(other.tipologiaNtfOrario))
            return false;
        if (tracciatoFile == null) {
            if (other.tracciatoFile != null)
                return false;
        } else if (!tracciatoFile.equals(other.tracciatoFile))
            return false;
        if (tracciatoMail == null) {
            if (other.tracciatoMail != null)
                return false;
        } else if (!tracciatoMail.equals(other.tracciatoMail))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RinvioNotificheOutputBean [tipologiaNotifica=" + tipologiaNotifica + ", causaleInterno=" + causaleInterno + ", causaleNowDg=" + causaleNowDg
                + ", descrizioneCausaleOlo=" + descrizioneCausaleOlo + ", dataCreazione=" + dataCreazione + ", idNotifica=" + idNotifica
                + ", tipologiaNtfGiornaliero=" + tipologiaNtfGiornaliero + ", tipologiaNtfMensile=" + tipologiaNtfMensile + ", tipologiaNtfOrario="
                + tipologiaNtfOrario + ", origineNotifica=" + origineNotifica + ", strutturaRichiesta=" + strutturaRichiesta + ", tracciatoFile="
                + tracciatoFile + ", tracciatoMail=" + tracciatoMail + ", flagNotificaStandard=" + flagNotificaStandard + ", flagNotificaStraordinaria="
                + flagNotificaStraordinaria + ", flagNotificaMail=" + flagNotificaMail + ", idRichiesta=" + idRichiesta + "]";
    }


}