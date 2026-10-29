package com.nttdata.tim.now.data.bean.jpub;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class JpubOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 8836525234441079479L;

    @JsonFormat(pattern = DateHelper.DATE_FE_LONG, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataRichiesta")
    private Date dataRichiesta;

    @JsonProperty("verso")
    private String verso;

    @JsonProperty("identificativoOrdineComposto")
    private String identificativoOrdineComposto;

    @JsonProperty("identificativoRichiestaJpub")
    private String identificativoRichiestaJpub;

    @JsonProperty("statoElaborazioneStaging")
    private String statoElaborazioneStaging;

    @JsonProperty("contenutoXML")
    private String contenutoXML;

    @JsonProperty("flagConsuntivo")
    private String flagConsuntivo;

    public Date getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getVerso() {
        return verso;
    }

    public void setVerso(String verso) {
        this.verso = verso;
    }

    public String getIdentificativoOrdineComposto() {
        return identificativoOrdineComposto;
    }

    public void setIdentificativoOrdineComposto(String identificativoOrdineComposto) {
        this.identificativoOrdineComposto = identificativoOrdineComposto;
    }

    public String getIdentificativoRichiestaJpub() {
        return identificativoRichiestaJpub;
    }

    public void setIdentificativoRichiestaJpub(String identificativoRichiestaJpub) {
        this.identificativoRichiestaJpub = identificativoRichiestaJpub;
    }

    public String getStatoElaborazioneStaging() {
        return statoElaborazioneStaging;
    }

    public void setStatoElaborazioneStaging(String statoElaborazioneStaging) {
        this.statoElaborazioneStaging = statoElaborazioneStaging;
    }

    public String getContenutoXML() {
        return contenutoXML;
    }

    public void setContenutoXML(String contenutoXML) {
        this.contenutoXML = contenutoXML;
    }

    public String getFlagConsuntivo() {
        return flagConsuntivo;
    }

    public void setFlagConsuntivo(String flagConsuntivo) {
        this.flagConsuntivo = flagConsuntivo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contenutoXML == null) ? 0 : contenutoXML.hashCode());
        result = prime * result + ((dataRichiesta == null) ? 0 : dataRichiesta.hashCode());
        result = prime * result + ((flagConsuntivo == null) ? 0 : flagConsuntivo.hashCode());
        result = prime * result + ((identificativoOrdineComposto == null) ? 0 : identificativoOrdineComposto.hashCode());
        result = prime * result + ((identificativoRichiestaJpub == null) ? 0 : identificativoRichiestaJpub.hashCode());
        result = prime * result + ((statoElaborazioneStaging == null) ? 0 : statoElaborazioneStaging.hashCode());
        result = prime * result + ((verso == null) ? 0 : verso.hashCode());
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
        JpubOutputBean other = (JpubOutputBean) obj;
        if (contenutoXML == null) {
            if (other.contenutoXML != null)
                return false;
        } else if (!contenutoXML.equals(other.contenutoXML))
            return false;
        if (dataRichiesta == null) {
            if (other.dataRichiesta != null)
                return false;
        } else if (!dataRichiesta.equals(other.dataRichiesta))
            return false;
        if (flagConsuntivo == null) {
            if (other.flagConsuntivo != null)
                return false;
        } else if (!flagConsuntivo.equals(other.flagConsuntivo))
            return false;
        if (identificativoOrdineComposto == null) {
            if (other.identificativoOrdineComposto != null)
                return false;
        } else if (!identificativoOrdineComposto.equals(other.identificativoOrdineComposto))
            return false;
        if (identificativoRichiestaJpub == null) {
            if (other.identificativoRichiestaJpub != null)
                return false;
        } else if (!identificativoRichiestaJpub.equals(other.identificativoRichiestaJpub))
            return false;
        if (statoElaborazioneStaging == null) {
            if (other.statoElaborazioneStaging != null)
                return false;
        } else if (!statoElaborazioneStaging.equals(other.statoElaborazioneStaging))
            return false;
        if (verso == null) {
            if (other.verso != null)
                return false;
        } else if (!verso.equals(other.verso))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "JpubOutputBean [dataRichiesta=" + dataRichiesta + ", verso=" + verso + ", identificativoOrdineComposto=" + identificativoOrdineComposto
                + ", identificativoRichiestaJpub=" + identificativoRichiestaJpub + ", statoElaborazioneStaging=" + statoElaborazioneStaging + ", contenutoXML="
                + contenutoXML + ", flagConsuntivo=" + flagConsuntivo + "]";
    }



}