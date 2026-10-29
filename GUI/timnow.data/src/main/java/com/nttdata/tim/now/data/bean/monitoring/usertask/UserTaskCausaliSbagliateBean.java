
package com.nttdata.tim.now.data.bean.monitoring.usertask;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTaskCausaliSbagliateBean implements Serializable {

    private static final long serialVersionUID = 1239110311086491890L;
    @JsonProperty("codiceOrdineOlo")
    private String codiceOrdineOlo;
    @JsonProperty("ordineTI")
    private String ordineTI;
    @JsonProperty("causale")
    private String causale;
    @JsonProperty("statoNOW")
    private String statoNOW;
    @JsonProperty("statoOAO")
    private String statoOAO;
    @JsonProperty("codificaOAO")
    private String codificaOAO;
    @JsonProperty("idRichiestaOlo")
    private String idRichiestaOlo;
    @JsonProperty("idRisorsa")
    private String idRisorsa;
    @JsonProperty("idWorkItem")
    private String idWorkItem;
    @JsonProperty("version")
    private String version;
    @JsonProperty("idAnagraficaCausale")
    private String idAnagraficaCausale;
    @JsonProperty("codCausaleInterno")
    private String codCausaleInterno;
    @JsonProperty("codCausaleNowDG")
    private String codCausaleNowDG;
    @JsonProperty("codCausaleOAO")
    private String codCausaleOAO;
    @JsonProperty("causaleInterno")
    private String causaleInterno;
    @JsonProperty("causaleNowDG")
    private String causaleNowDG;
    @JsonProperty("causaleOAO")
    private String causaleOAO;
    @JsonProperty("offerta")
    private String offerta;
    @JsonProperty("tipoLavorazione")
    private String tipoLavorazione;
    public String getCodiceOrdineOlo() {
        return codiceOrdineOlo;
    }
    public void setCodiceOrdineOlo(String codiceOrdineOlo) {
        this.codiceOrdineOlo = codiceOrdineOlo;
    }
    public String getOrdineTI() {
        return ordineTI;
    }
    public void setOrdineTI(String ordineTI) {
        this.ordineTI = ordineTI;
    }
    public String getCausale() {
        return causale;
    }
    public void setCausale(String causale) {
        this.causale = causale;
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
    public String getCodificaOAO() {
        return codificaOAO;
    }
    public void setCodificaOAO(String codificaOAO) {
        this.codificaOAO = codificaOAO;
    }
    public String getIdRichiestaOlo() {
        return idRichiestaOlo;
    }
    public void setIdRichiestaOlo(String idRichiestaOlo) {
        this.idRichiestaOlo = idRichiestaOlo;
    }
    public String getIdRisorsa() {
        return idRisorsa;
    }
    public void setIdRisorsa(String idRisorsa) {
        this.idRisorsa = idRisorsa;
    }
    public String getIdWorkItem() {
        return idWorkItem;
    }
    public void setIdWorkItem(String idWorkItem) {
        this.idWorkItem = idWorkItem;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getIdAnagraficaCausale() {
        return idAnagraficaCausale;
    }
    public void setIdAnagraficaCausale(String idAnagraficaCausale) {
        this.idAnagraficaCausale = idAnagraficaCausale;
    }
    public String getCodCausaleInterno() {
        return codCausaleInterno;
    }
    public void setCodCausaleInterno(String codCausaleInterno) {
        this.codCausaleInterno = codCausaleInterno;
    }
    public String getCodCausaleNowDG() {
        return codCausaleNowDG;
    }
    public void setCodCausaleNowDG(String codCausaleNowDG) {
        this.codCausaleNowDG = codCausaleNowDG;
    }
    public String getCodCausaleOAO() {
        return codCausaleOAO;
    }
    public void setCodCausaleOAO(String codCausaleOAO) {
        this.codCausaleOAO = codCausaleOAO;
    }
    public String getCausaleInterno() {
        return causaleInterno;
    }
    public void setCausaleInterno(String causaleInterno) {
        this.causaleInterno = causaleInterno;
    }
    public String getCausaleNowDG() {
        return causaleNowDG;
    }
    public void setCausaleNowDG(String causaleNowDG) {
        this.causaleNowDG = causaleNowDG;
    }
    public String getCausaleOAO() {
        return causaleOAO;
    }
    public void setCausaleOAO(String causaleOAO) {
        this.causaleOAO = causaleOAO;
    }
    public String getOfferta() {
        return offerta;
    }
    public void setOfferta(String offerta) {
        this.offerta = offerta;
    }
    public String getTipoLavorazione() {
        return tipoLavorazione;
    }
    public void setTipoLavorazione(String tipoLavorazione) {
        this.tipoLavorazione = tipoLavorazione;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((causale == null) ? 0 : causale.hashCode());
        result = prime * result + ((causaleInterno == null) ? 0 : causaleInterno.hashCode());
        result = prime * result + ((causaleNowDG == null) ? 0 : causaleNowDG.hashCode());
        result = prime * result + ((causaleOAO == null) ? 0 : causaleOAO.hashCode());
        result = prime * result + ((codCausaleInterno == null) ? 0 : codCausaleInterno.hashCode());
        result = prime * result + ((codCausaleNowDG == null) ? 0 : codCausaleNowDG.hashCode());
        result = prime * result + ((codCausaleOAO == null) ? 0 : codCausaleOAO.hashCode());
        result = prime * result + ((codiceOrdineOlo == null) ? 0 : codiceOrdineOlo.hashCode());
        result = prime * result + ((codificaOAO == null) ? 0 : codificaOAO.hashCode());
        result = prime * result + ((idAnagraficaCausale == null) ? 0 : idAnagraficaCausale.hashCode());
        result = prime * result + ((idRichiestaOlo == null) ? 0 : idRichiestaOlo.hashCode());
        result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
        result = prime * result + ((idWorkItem == null) ? 0 : idWorkItem.hashCode());
        result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
        result = prime * result + ((ordineTI == null) ? 0 : ordineTI.hashCode());
        result = prime * result + ((statoNOW == null) ? 0 : statoNOW.hashCode());
        result = prime * result + ((statoOAO == null) ? 0 : statoOAO.hashCode());
        result = prime * result + ((tipoLavorazione == null) ? 0 : tipoLavorazione.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
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
        UserTaskCausaliSbagliateBean other = (UserTaskCausaliSbagliateBean) obj;
        if (causale == null) {
            if (other.causale != null)
                return false;
        } else if (!causale.equals(other.causale))
            return false;
        if (causaleInterno == null) {
            if (other.causaleInterno != null)
                return false;
        } else if (!causaleInterno.equals(other.causaleInterno))
            return false;
        if (causaleNowDG == null) {
            if (other.causaleNowDG != null)
                return false;
        } else if (!causaleNowDG.equals(other.causaleNowDG))
            return false;
        if (causaleOAO == null) {
            if (other.causaleOAO != null)
                return false;
        } else if (!causaleOAO.equals(other.causaleOAO))
            return false;
        if (codCausaleInterno == null) {
            if (other.codCausaleInterno != null)
                return false;
        } else if (!codCausaleInterno.equals(other.codCausaleInterno))
            return false;
        if (codCausaleNowDG == null) {
            if (other.codCausaleNowDG != null)
                return false;
        } else if (!codCausaleNowDG.equals(other.codCausaleNowDG))
            return false;
        if (codCausaleOAO == null) {
            if (other.codCausaleOAO != null)
                return false;
        } else if (!codCausaleOAO.equals(other.codCausaleOAO))
            return false;
        if (codiceOrdineOlo == null) {
            if (other.codiceOrdineOlo != null)
                return false;
        } else if (!codiceOrdineOlo.equals(other.codiceOrdineOlo))
            return false;
        if (codificaOAO == null) {
            if (other.codificaOAO != null)
                return false;
        } else if (!codificaOAO.equals(other.codificaOAO))
            return false;
        if (idAnagraficaCausale == null) {
            if (other.idAnagraficaCausale != null)
                return false;
        } else if (!idAnagraficaCausale.equals(other.idAnagraficaCausale))
            return false;
        if (idRichiestaOlo == null) {
            if (other.idRichiestaOlo != null)
                return false;
        } else if (!idRichiestaOlo.equals(other.idRichiestaOlo))
            return false;
        if (idRisorsa == null) {
            if (other.idRisorsa != null)
                return false;
        } else if (!idRisorsa.equals(other.idRisorsa))
            return false;
        if (idWorkItem == null) {
            if (other.idWorkItem != null)
                return false;
        } else if (!idWorkItem.equals(other.idWorkItem))
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
        if (tipoLavorazione == null) {
            if (other.tipoLavorazione != null)
                return false;
        } else if (!tipoLavorazione.equals(other.tipoLavorazione))
            return false;
        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version.equals(other.version))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "UserTaskCausaliSbagliateBean [codiceOrdineOlo=" + codiceOrdineOlo + ", ordineTI=" + ordineTI + ", causale=" + causale + ", statoNOW=" + statoNOW
                + ", statoOAO=" + statoOAO + ", codificaOAO=" + codificaOAO + ", idRichiestaOlo=" + idRichiestaOlo + ", idRisorsa=" + idRisorsa
                + ", idWorkItem=" + idWorkItem + ", version=" + version + ", idAnagraficaCausale=" + idAnagraficaCausale + ", codCausaleInterno="
                + codCausaleInterno + ", codCausaleNowDG=" + codCausaleNowDG + ", codCausaleOAO=" + codCausaleOAO + ", causaleInterno=" + causaleInterno
                + ", causaleNowDG=" + causaleNowDG + ", causaleOAO=" + causaleOAO + ", offerta=" + offerta + ", tipoLavorazione=" + tipoLavorazione + "]";
    }


}
