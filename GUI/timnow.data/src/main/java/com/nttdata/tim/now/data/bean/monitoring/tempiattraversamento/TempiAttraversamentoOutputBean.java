package com.nttdata.tim.now.data.bean.monitoring.tempiattraversamento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractExportBean;

@JsonInclude(Include.NON_NULL)
public class TempiAttraversamentoOutputBean extends AbstractExportBean implements Serializable {
  
    private static final long serialVersionUID = 5026253318302504310L;

    @JsonProperty("aggregates")
    private List<AggregatoBean> aggregates;

    @JsonProperty("guis")
    private List<GuiBean> guis;

    @JsonProperty("crossingTimes")
    private List<DettaglioTempiAttraversamentoBean> crossingTimes;

    @JsonProperty("treshold")
    private ListaSoglieBean treshold;

    public List<AggregatoBean> getAggregates() {
        return aggregates;
    }

    public void setAggregates(List<AggregatoBean> aggregates) {
        this.aggregates = aggregates;
    }

    public List<GuiBean> getGuis() {
        return guis;
    }

    public void setGuis(List<GuiBean> guis) {
        this.guis = guis;
    }

    public List<DettaglioTempiAttraversamentoBean> getCrossingTimes() {
        return crossingTimes;
    }

    public void setCrossingTimes(List<DettaglioTempiAttraversamentoBean> crossingTimes) {
        this.crossingTimes = crossingTimes;
    }

    public ListaSoglieBean getTreshold() {
        return treshold;
    }

    public void setTreshold(ListaSoglieBean treshold) {
        this.treshold = treshold;
    }

    @Override
    public String toString() {
        return "TempiAttraversamentoOutputBean [aggregates=" + aggregates + ", guis=" + guis + ", crossingTimes=" + crossingTimes + ", treshold=" + treshold
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aggregates == null) ? 0 : aggregates.hashCode());
        result = prime * result + ((crossingTimes == null) ? 0 : crossingTimes.hashCode());
        result = prime * result + ((guis == null) ? 0 : guis.hashCode());
        result = prime * result + ((treshold == null) ? 0 : treshold.hashCode());
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
        TempiAttraversamentoOutputBean other = (TempiAttraversamentoOutputBean) obj;
        if (aggregates == null) {
            if (other.aggregates != null)
                return false;
        } else if (!aggregates.equals(other.aggregates))
            return false;
        if (crossingTimes == null) {
            if (other.crossingTimes != null)
                return false;
        } else if (!crossingTimes.equals(other.crossingTimes))
            return false;
        if (guis == null) {
            if (other.guis != null)
                return false;
        } else if (!guis.equals(other.guis))
            return false;
        if (treshold == null) {
            if (other.treshold != null)
                return false;
        } else if (!treshold.equals(other.treshold))
            return false;
        return true;
    }

}