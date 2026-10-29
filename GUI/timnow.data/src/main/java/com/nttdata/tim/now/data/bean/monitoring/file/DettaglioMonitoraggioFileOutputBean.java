
package com.nttdata.tim.now.data.bean.monitoring.file;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DettaglioMonitoraggioFileOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 2005629548318213336L;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataCreazioneRichiesta")
    private Date dataCreazioneRichiesta;

    @JsonProperty("codificaOao")
    private String codificaOao;

    @JsonProperty("codiceOao")
    private String codiceOao;

    @JsonProperty("ordineTi")
    private String ordineTi;

    @JsonProperty("statoNow")
    private String statoNow;

    @JsonProperty("statoOlo")
    private String statoOlo;

    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dro")
    private Date dro;

    @JsonProperty("idRisorsa")
    private String idRisorsa;

    @JsonProperty("ambito")
    private String ambito;

    @JsonProperty("offerta")
    private String offerta;

    @JsonProperty("idRichiesta")
    private String idRichiesta;

    public Date getDataCreazioneRichiesta() {
        return dataCreazioneRichiesta;
    }

    public void setDataCreazioneRichiesta(Date dataCreazioneRichiesta) {
        this.dataCreazioneRichiesta = dataCreazioneRichiesta;
    }

    public String getCodificaOao() {
        return codificaOao;
    }

    public void setCodificaOao(String codificaOao) {
        this.codificaOao = codificaOao;
    }

    public String getCodiceOao() {
        return codiceOao;
    }

    public void setCodiceOao(String codiceOao) {
        this.codiceOao = codiceOao;
    }

    public String getOrdineTi() {
        return ordineTi;
    }

    public void setOrdineTi(String ordineTi) {
        this.ordineTi = ordineTi;
    }

    public String getStatoNow() {
        return statoNow;
    }

    public void setStatoNow(String statoNow) {
        this.statoNow = statoNow;
    }

    public String getStatoOlo() {
        return statoOlo;
    }

    public void setStatoOlo(String statoOlo) {
        this.statoOlo = statoOlo;
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
        return "DettaglioMonitoraggioFileOutputBean [dataCreazioneRichiesta=" + dataCreazioneRichiesta + ", codificaOao=" + codificaOao + ", codiceOao="
                + codiceOao + ", ordineTi=" + ordineTi + ", statoNow=" + statoNow + ", statoOlo=" + statoOlo + ", dro=" + dro + ", idRisorsa=" + idRisorsa
                + ", ambito=" + ambito + ", offerta=" + offerta + ", idRichiesta=" + idRichiesta + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ambito == null) ? 0 : ambito.hashCode());
        result = prime * result + ((codiceOao == null) ? 0 : codiceOao.hashCode());
        result = prime * result + ((codificaOao == null) ? 0 : codificaOao.hashCode());
        result = prime * result + ((dataCreazioneRichiesta == null) ? 0 : dataCreazioneRichiesta.hashCode());
        result = prime * result + ((dro == null) ? 0 : dro.hashCode());
        result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
        result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
        result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
        result = prime * result + ((ordineTi == null) ? 0 : ordineTi.hashCode());
        result = prime * result + ((statoNow == null) ? 0 : statoNow.hashCode());
        result = prime * result + ((statoOlo == null) ? 0 : statoOlo.hashCode());
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
        DettaglioMonitoraggioFileOutputBean other = (DettaglioMonitoraggioFileOutputBean) obj;
        if (ambito == null) {
            if (other.ambito != null)
                return false;
        } else if (!ambito.equals(other.ambito))
            return false;
        if (codiceOao == null) {
            if (other.codiceOao != null)
                return false;
        } else if (!codiceOao.equals(other.codiceOao))
            return false;
        if (codificaOao == null) {
            if (other.codificaOao != null)
                return false;
        } else if (!codificaOao.equals(other.codificaOao))
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
        if (ordineTi == null) {
            if (other.ordineTi != null)
                return false;
        } else if (!ordineTi.equals(other.ordineTi))
            return false;
        if (statoNow == null) {
            if (other.statoNow != null)
                return false;
        } else if (!statoNow.equals(other.statoNow))
            return false;
        if (statoOlo == null) {
            if (other.statoOlo != null)
                return false;
        } else if (!statoOlo.equals(other.statoOlo))
            return false;
        return true;
    }

}
