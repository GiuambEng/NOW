package com.nttdata.tim.now.data.bean.monitoring.rimodulazionedac;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RimodulazioneDACInfoOutputBean implements Serializable {

    private static final long serialVersionUID = -2852413794254740207L;

    @JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataScadenza")
    private Date dataScadenza;

    @JsonProperty("richiesteInScadenza")
    private String richiesteInScadenza;

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public String getRichiesteInScadenza() {
        return richiesteInScadenza;
    }

    public void setRichiesteInScadenza(String richiesteInScadenza) {
        this.richiesteInScadenza = richiesteInScadenza;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataScadenza == null) ? 0 : dataScadenza.hashCode());
        result = prime * result + ((richiesteInScadenza == null) ? 0 : richiesteInScadenza.hashCode());
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
        RimodulazioneDACInfoOutputBean other = (RimodulazioneDACInfoOutputBean) obj;
        if (dataScadenza == null) {
            if (other.dataScadenza != null)
                return false;
        } else if (!dataScadenza.equals(other.dataScadenza))
            return false;
        if (richiesteInScadenza == null) {
            if (other.richiesteInScadenza != null)
                return false;
        } else if (!richiesteInScadenza.equals(other.richiesteInScadenza))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RimodulazioneDACInfoOutputBean [dataScadenza=" + dataScadenza + ", richiesteInScadenza=" + richiesteInScadenza +" ]";
    }
    

}
