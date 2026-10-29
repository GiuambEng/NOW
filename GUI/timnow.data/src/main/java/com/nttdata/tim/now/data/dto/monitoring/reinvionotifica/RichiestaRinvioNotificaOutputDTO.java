package com.nttdata.tim.now.data.dto.monitoring.reinvionotifica;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RichiestaRinvioNotificaOutputDTO implements Serializable {
	
	private static final long serialVersionUID = 3439841849942698078L;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataCreazioneRichiesta")
	private Date dataCreazioneRichiesta;

	@JsonProperty("ordineTI")
	private String ordineTI;

	@JsonProperty("statoNOW")
	private String statoNOW;

	@JsonProperty("statoOLO")
	private String statoOLO;

	@JsonProperty("idRisorsaNow")
	protected String idRisorsaNow;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("DRO")
	private Date dro;

	@JsonProperty("idRisorsa")
	private String idRisorsa;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("idrichiestaolo")
	protected String idRichiestaolo;

	@JsonProperty("ambito")
	protected String ambito;

	@JsonProperty("idOfferta")
	protected String idOfferta;

    @JsonProperty("codiceOrdineOLO")
    protected String codiceOrdineOLO;

	@JsonProperty("idStatoNow")
	protected String idStatoNow;

	public Date getDataCreazioneRichiesta() {
		return dataCreazioneRichiesta;
	}

	public void setDataCreazioneRichiesta(Date dataCreazioneRichiesta) {
		this.dataCreazioneRichiesta = dataCreazioneRichiesta;
	}

	public String getOrdineTI() {
		return ordineTI;
	}

	public void setOrdineTI(String ordineTI) {
		this.ordineTI = ordineTI;
	}

	public String getStatoNOW() {
		return statoNOW;
	}

	public void setStatoNOW(String statoNOW) {
		this.statoNOW = statoNOW;
	}

	public String getStatoOLO() {
		return statoOLO;
	}

	public void setStatoOLO(String statoOLO) {
		this.statoOLO = statoOLO;
	}

	public String getIdRisorsaNow() {
		return idRisorsaNow;
	}

	public void setIdRisorsaNow(String idRisorsaNow) {
		this.idRisorsaNow = idRisorsaNow;
	}

	public Date getDro() {
		return dro;
	}

	public void setDro(Date dro) {
		this.dro = dro;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getIdRichiestaolo() {
		return idRichiestaolo;
	}

	public void setIdRichiestaolo(String idRichiestaolo) {
		this.idRichiestaolo = idRichiestaolo;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

    public String getCodiceOrdineOLO() {
        return codiceOrdineOLO;
    }

    public void setCodiceOrdineOLO(String codiceOrdineOLO) {
        this.codiceOrdineOLO = codiceOrdineOLO;
    }

	public String getIdStatoNow() {
		return idStatoNow;
	}

	public void setIdStatoNow(String idStatoNow) {
		this.idStatoNow = idStatoNow;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambito == null) ? 0 : ambito.hashCode());
        result = prime * result + ((codiceOrdineOLO == null) ? 0 : codiceOrdineOLO.hashCode());
		result = prime * result + ((dataCreazioneRichiesta == null) ? 0 : dataCreazioneRichiesta.hashCode());
		result = prime * result + ((dro == null) ? 0 : dro.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((idRichiestaolo == null) ? 0 : idRichiestaolo.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((idRisorsaNow == null) ? 0 : idRisorsaNow.hashCode());
		result = prime * result + ((idStatoNow == null) ? 0 : idStatoNow.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((ordineTI == null) ? 0 : ordineTI.hashCode());
		result = prime * result + ((statoNOW == null) ? 0 : statoNOW.hashCode());
		result = prime * result + ((statoOLO == null) ? 0 : statoOLO.hashCode());
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
		RichiestaRinvioNotificaOutputDTO other = (RichiestaRinvioNotificaOutputDTO) obj;
		if (ambito == null) {
			if (other.ambito != null)
				return false;
		} else if (!ambito.equals(other.ambito))
			return false;
        if (codiceOrdineOLO == null) {
            if (other.codiceOrdineOLO != null)
                return false;
        } else if (!codiceOrdineOLO.equals(other.codiceOrdineOLO))
            return false;
		if (dataCreazioneRichiesta == null) {
			if (other.dataCreazioneRichiesta != null)
				return false;
		} else if (!dataCreazioneRichiesta.equals(other.dataCreazioneRichiesta))
			return false;
		if (dro == null) {
			if (other.dro != null)
				return false;
		} else if (!dro.equals(other.dro))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (idRichiestaolo == null) {
			if (other.idRichiestaolo != null)
				return false;
		} else if (!idRichiestaolo.equals(other.idRichiestaolo))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (idRisorsaNow == null) {
			if (other.idRisorsaNow != null)
				return false;
		} else if (!idRisorsaNow.equals(other.idRisorsaNow))
			return false;
		if (idStatoNow == null) {
			if (other.idStatoNow != null)
				return false;
		} else if (!idStatoNow.equals(other.idStatoNow))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (ordineTI == null) {
			if (other.ordineTI != null)
				return false;
		} else if (!ordineTI.equals(other.ordineTI))
			return false;
		if (statoNOW == null) {
			if (other.statoNOW != null)
				return false;
		} else if (!statoNOW.equals(other.statoNOW))
			return false;
		if (statoOLO == null) {
			if (other.statoOLO != null)
				return false;
		} else if (!statoOLO.equals(other.statoOLO))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "RichiestaRinvioNotificaOutputDTO [dataCreazioneRichiesta=" + dataCreazioneRichiesta + ", ordineTI=" + ordineTI + ", statoNOW=" + statoNOW
                + ", statoOLO=" + statoOLO + ", idRisorsaNow=" + idRisorsaNow + ", dro=" + dro + ", idRisorsa=" + idRisorsa + ", offerta=" + offerta
                + ", idRichiestaolo=" + idRichiestaolo + ", ambito=" + ambito + ", idOfferta=" + idOfferta + ", codiceOrdineOLO=" + codiceOrdineOLO
                + ", idStatoNow=" + idStatoNow + "]";
    }

}
