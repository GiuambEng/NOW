package com.nttdata.tim.now.data.dto.monitoring.koolo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DettaglioMonitoraggioKoOloOutputDTO implements Serializable {

	private static final long serialVersionUID = -5892619543506382811L;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("DataInvioRichiesta")
    private Date dataInvioRichiesta;

    @JsonProperty("CodificaOloAgcom")
    private String codificaOloAgcom;

    @JsonProperty("CodificaOloNow")
    private String codificaOloNow;

    @JsonProperty("ordineTI")
    private String ordineTI;

    @JsonProperty("statoNOW")
    private String statoNOW;

    @JsonProperty("statoOLO")
    private String statoOLO;

    @JsonProperty("IdRichiesta")
    private String idRichiesta;

    @JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("DRO")
    private Date dro;

    @JsonProperty("idRisorsa")
    private String idRisorsa;

    @JsonProperty("ambito")
    private String ambito;

    @JsonProperty("offerta")
    private String offerta;

    public Date getDataInvioRichiesta() {
        return dataInvioRichiesta;
    }

    public void setDataInvioRichiesta(Date dataInvioRichiesta) {
        this.dataInvioRichiesta = dataInvioRichiesta;
    }

    public String getCodificaOloAgcom() {
        return codificaOloAgcom;
    }

    public void setCodificaOloAgcom(String codificaOloAgcom) {
        this.codificaOloAgcom = codificaOloAgcom;
    }

    public String getCodificaOloNow() {
        return codificaOloNow;
    }

    public void setCodificaOloNow(String codificaOloNow) {
        this.codificaOloNow = codificaOloNow;
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
        return "DettaglioMonitoraggioKoOloOutputDTO [dataInvioRichiesta=" + dataInvioRichiesta + ", codificaOloAgcom=" + codificaOloAgcom + ", codificaOloNow="
                + codificaOloNow + ", ordineTI=" + ordineTI + ", statoNOW=" + statoNOW + ", statoOLO=" + statoOLO + ", idRichiesta=" + idRichiesta + ", dro="
                + dro + ", idRisorsa=" + idRisorsa + ", ambito=" + ambito + ", offerta=" + offerta + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ambito == null) ? 0 : ambito.hashCode());
        result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
        result = prime * result + ((codificaOloNow == null) ? 0 : codificaOloNow.hashCode());
        result = prime * result + ((dataInvioRichiesta == null) ? 0 : dataInvioRichiesta.hashCode());
        result = prime * result + ((dro == null) ? 0 : dro.hashCode());
        result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
        result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
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
        DettaglioMonitoraggioKoOloOutputDTO other = (DettaglioMonitoraggioKoOloOutputDTO) obj;
        if (ambito == null) {
            if (other.ambito != null)
                return false;
        } else if (!ambito.equals(other.ambito))
            return false;
        if (codificaOloAgcom == null) {
            if (other.codificaOloAgcom != null)
                return false;
        } else if (!codificaOloAgcom.equals(other.codificaOloAgcom))
            return false;
        if (codificaOloNow == null) {
            if (other.codificaOloNow != null)
                return false;
        } else if (!codificaOloNow.equals(other.codificaOloNow))
            return false;
        if (dataInvioRichiesta == null) {
            if (other.dataInvioRichiesta != null)
                return false;
        } else if (!dataInvioRichiesta.equals(other.dataInvioRichiesta))
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
        if (statoOLO == null) {
            if (other.statoOLO != null)
                return false;
        } else if (!statoOLO.equals(other.statoOLO))
            return false;
        return true;
    }

}
