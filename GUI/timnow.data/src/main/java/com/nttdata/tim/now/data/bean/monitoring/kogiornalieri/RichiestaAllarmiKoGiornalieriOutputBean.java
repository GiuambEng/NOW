package com.nttdata.tim.now.data.bean.monitoring.kogiornalieri;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RichiestaAllarmiKoGiornalieriOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 8502103985905349444L;

    @JsonProperty("codiceOrdineOAO")
    private String codiceOrdineOAO;

    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataCreazioneRichiesta")
    private Date dataCreazioneRichiesta;

    @JsonProperty("codificaOAO")
    private String codificaOAO;

    @JsonProperty("codiceOAO")
    private String codiceOAO;

    @JsonProperty("ordineTI")
    private String ordineTI;

    @JsonProperty("idStatoNow")
    private String idStatoNow;

    @JsonProperty("statoNOW")
    private String statoNOW;

    @JsonProperty("statoOAO")
    private String statoOAO;

    @JsonProperty("codiceOrdineTI")
    private String codiceOrdineTI;

    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dro")
    private Date dro;

    @JsonProperty("statoOLO")
    private String statoOLO;

    @JsonProperty("idRisorsa")
    private String idRisorsa;

    @JsonProperty("idOfferta")
    private String idOfferta;

    @JsonProperty("offerta")
    private String offerta;

    @JsonProperty("ambito")
    private String ambito;

    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("DataInvioRichiesta")
    private Date dataInvioRichiesta;

    @JsonProperty("idRisorsaNow")
    private String idRisorsaNow;

    @JsonProperty("codOloAgcom")
    private String codOloAgcom;

    @JsonProperty("codOloNow")
    private String codOloNow;

    @JsonProperty("codificaOloAgcom")
    private String codificaOloAgcom;

    @JsonProperty("codificaOloNow")
    private String codificaOloNow;

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

    public String getIdStatoNow() {
        return idStatoNow;
    }

    public void setIdStatoNow(String idStatoNow) {
        this.idStatoNow = idStatoNow;
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

    public String getCodiceOrdineTI() {
        return codiceOrdineTI;
    }

    public void setCodiceOrdineTI(String codiceOrdineTI) {
        this.codiceOrdineTI = codiceOrdineTI;
    }

    public Date getDro() {
        return dro;
    }

    public void setDro(Date dro) {
        this.dro = dro;
    }

    public String getStatoOLO() {
        return statoOLO;
    }

    public void setStatoOLO(String statoOLO) {
        this.statoOLO = statoOLO;
    }

    public String getIdRisorsa() {
        return idRisorsa;
    }

    public void setIdRisorsa(String idRisorsa) {
        this.idRisorsa = idRisorsa;
    }

    public String getIdOfferta() {
        return idOfferta;
    }

    public void setIdOfferta(String idOfferta) {
        this.idOfferta = idOfferta;
    }

    public String getOfferta() {
        return offerta;
    }

    public void setOfferta(String offerta) {
        this.offerta = offerta;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Date getDataInvioRichiesta() {
        return dataInvioRichiesta;
    }

    public void setDataInvioRichiesta(Date dataInvioRichiesta) {
        this.dataInvioRichiesta = dataInvioRichiesta;
    }

    public String getIdRisorsaNow() {
        return idRisorsaNow;
    }

    public void setIdRisorsaNow(String idRisorsaNow) {
        this.idRisorsaNow = idRisorsaNow;
    }

    public String getCodOloAgcom() {
        return codOloAgcom;
    }

    public void setCodOloAgcom(String codOloAgcom) {
        this.codOloAgcom = codOloAgcom;
    }

    public String getCodOloNow() {
        return codOloNow;
    }

    public void setCodOloNow(String codOloNow) {
        this.codOloNow = codOloNow;
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
        result = prime * result + ((ambito == null) ? 0 : ambito.hashCode());
        result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
        result = prime * result + ((codOloNow == null) ? 0 : codOloNow.hashCode());
        result = prime * result + ((codiceOAO == null) ? 0 : codiceOAO.hashCode());
        result = prime * result + ((codiceOrdineOAO == null) ? 0 : codiceOrdineOAO.hashCode());
        result = prime * result + ((codiceOrdineTI == null) ? 0 : codiceOrdineTI.hashCode());
        result = prime * result + ((codificaOAO == null) ? 0 : codificaOAO.hashCode());
        result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
        result = prime * result + ((codificaOloNow == null) ? 0 : codificaOloNow.hashCode());
        result = prime * result + ((dataCreazioneRichiesta == null) ? 0 : dataCreazioneRichiesta.hashCode());
        result = prime * result + ((dataInvioRichiesta == null) ? 0 : dataInvioRichiesta.hashCode());
        result = prime * result + ((dro == null) ? 0 : dro.hashCode());
        result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
        result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
        result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
        result = prime * result + ((idRisorsaNow == null) ? 0 : idRisorsaNow.hashCode());
        result = prime * result + ((idStatoNow == null) ? 0 : idStatoNow.hashCode());
        result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
        result = prime * result + ((ordineTI == null) ? 0 : ordineTI.hashCode());
        result = prime * result + ((statoNOW == null) ? 0 : statoNOW.hashCode());
        result = prime * result + ((statoOAO == null) ? 0 : statoOAO.hashCode());
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
        RichiestaAllarmiKoGiornalieriOutputBean other = (RichiestaAllarmiKoGiornalieriOutputBean) obj;
        if (ambito == null) {
            if (other.ambito != null)
                return false;
        } else if (!ambito.equals(other.ambito))
            return false;
        if (codOloAgcom == null) {
            if (other.codOloAgcom != null)
                return false;
        } else if (!codOloAgcom.equals(other.codOloAgcom))
            return false;
        if (codOloNow == null) {
            if (other.codOloNow != null)
                return false;
        } else if (!codOloNow.equals(other.codOloNow))
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
        if (codiceOrdineTI == null) {
            if (other.codiceOrdineTI != null)
                return false;
        } else if (!codiceOrdineTI.equals(other.codiceOrdineTI))
            return false;
        if (codificaOAO == null) {
            if (other.codificaOAO != null)
                return false;
        } else if (!codificaOAO.equals(other.codificaOAO))
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
        if (idOfferta == null) {
            if (other.idOfferta != null)
                return false;
        } else if (!idOfferta.equals(other.idOfferta))
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
        if (statoOAO == null) {
            if (other.statoOAO != null)
                return false;
        } else if (!statoOAO.equals(other.statoOAO))
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
        return "AllarmeKoGiornalieroLiv1OutputBean [codiceOrdineOAO=" + codiceOrdineOAO + ", dataCreazioneRichiesta=" + dataCreazioneRichiesta
                + ", codificaOAO=" + codificaOAO + ", codiceOAO=" + codiceOAO + ", ordineTI=" + ordineTI + ", idStatoNow=" + idStatoNow + ", statoNOW="
                + statoNOW + ", statoOAO=" + statoOAO + ", codiceOrdineTI=" + codiceOrdineTI + ", dro=" + dro + ", statoOLO=" + statoOLO + ", idRisorsa="
                + idRisorsa + ", idOfferta=" + idOfferta + ", offerta=" + offerta + ", ambito=" + ambito + ", dataInvioRichiesta=" + dataInvioRichiesta
                + ", idRisorsaNow=" + idRisorsaNow + ", codOloAgcom=" + codOloAgcom + ", codOloNow=" + codOloNow + ", codificaOloAgcom=" + codificaOloAgcom
                + ", codificaOloNow=" + codificaOloNow + ", idRichiesta=" + idRichiesta + "]";
    }

   
}
    
