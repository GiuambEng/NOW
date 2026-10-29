package com.nttdata.tim.now.data.bean.monitoring.rimodulazionedac;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioRimodulazioniDACOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 4226112106832512596L;

    @JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataScadenza")
    private Date dataScadenza;
    
    @JsonProperty("operatore")
    private String operatore;
    
    @JsonProperty("dacInfo")
    private List<RimodulazioneDACInfoOutputBean> dacInfo;
    
    @JsonProperty("statoRefresh")
    private boolean statoRefresh;
    
    @JsonProperty("descStatoRefresh")
    private String descStatoRefresh;

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public String getOperatore() {
        return operatore;
    }

    public void setOperatore(String operatore) {
        this.operatore = operatore;
    }

    public List<RimodulazioneDACInfoOutputBean> getDacInfo() {
        return dacInfo;
    }

    public void setDacInfo(List<RimodulazioneDACInfoOutputBean> dacInfo) {
        this.dacInfo = dacInfo;
    }

    public boolean isStatoRefresh() {
        return statoRefresh;
    }

    public void setStatoRefresh(boolean statoRefresh) {
        this.statoRefresh = statoRefresh;
    }

    public String getDescStatoRefresh() {
        return descStatoRefresh;
    }

    public void setDescStatoRefresh(String descStatoRefresh) {
        this.descStatoRefresh = descStatoRefresh;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dacInfo == null) ? 0 : dacInfo.hashCode());
        result = prime * result + ((dataScadenza == null) ? 0 : dataScadenza.hashCode());
        result = prime * result + ((descStatoRefresh == null) ? 0 : descStatoRefresh.hashCode());
        result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
        result = prime * result + (statoRefresh ? 1231 : 1237);
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
        MonitoraggioRimodulazioniDACOutputBean other = (MonitoraggioRimodulazioniDACOutputBean) obj;
        if (dacInfo == null) {
            if (other.dacInfo != null)
                return false;
        } else if (!dacInfo.equals(other.dacInfo))
            return false;
        if (dataScadenza == null) {
            if (other.dataScadenza != null)
                return false;
        } else if (!dataScadenza.equals(other.dataScadenza))
            return false;
        if (descStatoRefresh == null) {
            if (other.descStatoRefresh != null)
                return false;
        } else if (!descStatoRefresh.equals(other.descStatoRefresh))
            return false;
        if (operatore == null) {
            if (other.operatore != null)
                return false;
        } else if (!operatore.equals(other.operatore))
            return false;
        if (statoRefresh != other.statoRefresh)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MonitoraggioRimodulazioniDACOutputBean [dataScadenza=" + dataScadenza + ", operatore=" + operatore + ", dacInfo=" + dacInfo + ", statoRefresh="
                + statoRefresh + ", descStatoRefresh=" + descStatoRefresh + "]";
    }

    
}
