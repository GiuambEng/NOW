package com.nttdata.tim.now.data.bean.monitoring.notificheolo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RichiestaMonitoraggioNotificheOloOutputBean extends AbstractOutputBean implements Serializable {
 
    private static final long serialVersionUID = -6338548874041233323L;

    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataCreazioneRichiesta")
    private Date dataCreazioneRichiesta;

    @JsonProperty("codificaOloAgcom")
    private String codificaOloAgcom;

    @JsonProperty("codificaOloNow")
    private String codificaOloNow;

    @JsonProperty("ordineTI")
    protected String ordineTI;

    @JsonProperty("statoNOW")
    protected String statoNOW;

    @JsonProperty("statoOLO")
    protected String statoOLO;

    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dro")
    protected Date dro;

    @JsonProperty("idRisorsa")
    protected String idRisorsa;

    @JsonProperty("ambito")
    private String ambito;

    @JsonProperty("offerta")
    protected String offerta;

    @JsonProperty("idRichiesta")
    private String idRichiesta;

    public Date getDataCreazioneRichiesta() {
        return dataCreazioneRichiesta;
    }

    public void setDataCreazioneRichiesta(Date dataCreazioneRichiesta) {
        this.dataCreazioneRichiesta = dataCreazioneRichiesta;
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
        return "RichiestaMonitoraggioNotificheOloOutputBean [dataCreazioneRichiesta=" + dataCreazioneRichiesta + ", codificaOloAgcom=" + codificaOloAgcom
                + ", codificaOloNow=" + codificaOloNow + ", ordineTI=" + ordineTI + ", statoNOW=" + statoNOW + ", statoOLO=" + statoOLO + ", dro=" + dro 
                + ", idRisorsa=" + idRisorsa + ", ambito=" + ambito + ", offerta=" + offerta + ", idRichiesta=" + idRichiesta
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ambito == null) ? 0 : ambito.hashCode());
        result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
        result = prime * result + ((codificaOloNow == null) ? 0 : codificaOloNow.hashCode());
        result = prime * result + ((dataCreazioneRichiesta == null) ? 0 : dataCreazioneRichiesta.hashCode());
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
        RichiestaMonitoraggioNotificheOloOutputBean other = (RichiestaMonitoraggioNotificheOloOutputBean) obj;
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
        if (statoOLO == null) {
            if (other.statoOLO != null)
                return false;
        } else if (!statoOLO.equals(other.statoOLO))
            return false;
        return true;
    }

}