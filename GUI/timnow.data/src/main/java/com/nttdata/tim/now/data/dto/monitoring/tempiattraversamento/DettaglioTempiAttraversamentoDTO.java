package com.nttdata.tim.now.data.dto.monitoring.tempiattraversamento;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DettaglioTempiAttraversamentoDTO implements Serializable {

	private static final long serialVersionUID = 6634160180224793706L;

	@JsonProperty("codiceOrdineOAO")
	private String codiceOrdineOAO;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataCreazioneRichiesta")
	private Date dataCreazioneRichiesta;

	@JsonProperty("codificaOAO")
	private String codificaOAO;

	@JsonProperty("codiceOAO")
	private String codiceOAO;

	@JsonProperty("ordineTI")
	private String ordineTI;

	@JsonProperty("statoNOW")
	private String statoNOW;

	@JsonProperty("statoOAO")
	private String statoOAO;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("DRO")
	private Date dro;

	@JsonProperty("idRisorsa")
	private String idRisorsa;

	@JsonProperty("ambito")
	private String ambito;

	@JsonProperty("offerta")
	private String offerta;

    @JsonProperty("idRichiesta")
    private String idRichiesta;

	public String getCodiceOrdineOAO() {
		return codiceOrdineOAO;
	}

	public void setCodiceOrdineOAO(String codiceOrdineOAO) {
		this.codiceOrdineOAO = codiceOrdineOAO;
	}

	public Date getDataCreazioneRichiesta() {
		return dataCreazioneRichiesta;
	}

	public void setDataCreazioneRichiesta(Date dataCreazioneRichiesta) {
		this.dataCreazioneRichiesta = dataCreazioneRichiesta;
	}

	public String getCodificaOAO() {
		return codificaOAO;
	}

	public void setCodificaOAO(String codificaOAO) {
		this.codificaOAO = codificaOAO;
	}

	public String getCodiceOAO() {
		return codiceOAO;
	}

	public void setCodiceOAO(String codiceOAO) {
		this.codiceOAO = codiceOAO;
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

	public String getStatoOAO() {
		return statoOAO;
	}

	public void setStatoOAO(String statoOAO) {
		this.statoOAO = statoOAO;
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

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

    public String getIdRichiesta() {
        return idRichiesta;
    }

    public void setIdRichiesta(String idRichiesta) {
        this.idRichiesta = idRichiesta;
    }

	@Override
	public String toString() {
        return "DettaglioTempiAttraversamentoDTO [codiceOrdineOAO=" + codiceOrdineOAO + ", dataCreazioneRichiesta=" + dataCreazioneRichiesta + ", codificaOAO="
                + codificaOAO + ", codiceOAO=" + codiceOAO + ", ordineTI=" + ordineTI + ", statoNOW=" + statoNOW + ", statoOAO=" + statoOAO + ", dro=" + dro
                + ", idRisorsa=" + idRisorsa + ", ambito=" + ambito + ", offerta=" + offerta + ", idRichiesta=" + idRichiesta + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambito == null) ? 0 : ambito.hashCode());
		result = prime * result + ((codiceOAO == null) ? 0 : codiceOAO.hashCode());
		result = prime * result + ((codiceOrdineOAO == null) ? 0 : codiceOrdineOAO.hashCode());
		result = prime * result + ((codificaOAO == null) ? 0 : codificaOAO.hashCode());
		result = prime * result + ((dataCreazioneRichiesta == null) ? 0 : dataCreazioneRichiesta.hashCode());
		result = prime * result + ((dro == null) ? 0 : dro.hashCode());
        result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((ordineTI == null) ? 0 : ordineTI.hashCode());
		result = prime * result + ((statoNOW == null) ? 0 : statoNOW.hashCode());
		result = prime * result + ((statoOAO == null) ? 0 : statoOAO.hashCode());
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
		DettaglioTempiAttraversamentoDTO other = (DettaglioTempiAttraversamentoDTO) obj;
		if (ambito == null) {
			if (other.ambito != null)
				return false;
		} else if (!ambito.equals(other.ambito))
			return false;
		if (codiceOAO == null) {
			if (other.codiceOAO != null)
				return false;
		} else if (!codiceOAO.equals(other.codiceOAO))
			return false;
		if (codiceOrdineOAO == null) {
			if (other.codiceOrdineOAO != null)
				return false;
		} else if (!codiceOrdineOAO.equals(other.codiceOrdineOAO))
			return false;
		if (codificaOAO == null) {
			if (other.codificaOAO != null)
				return false;
		} else if (!codificaOAO.equals(other.codificaOAO))
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
        if (idRichiesta == null) {
            if (other.idRichiesta != null)
                return false;
        } else if (!idRichiesta.equals(other.idRichiesta))
            return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
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
		if (statoOAO == null) {
			if (other.statoOAO != null)
				return false;
		} else if (!statoOAO.equals(other.statoOAO))
			return false;
		return true;
	}

}
