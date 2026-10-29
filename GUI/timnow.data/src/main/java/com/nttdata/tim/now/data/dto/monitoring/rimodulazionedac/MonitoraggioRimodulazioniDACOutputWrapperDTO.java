package com.nttdata.tim.now.data.dto.monitoring.rimodulazionedac;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioRimodulazioniDACOutputWrapperDTO extends ESBResultDTO {

    private static final long serialVersionUID = 7719867661310695835L;

    @JsonProperty("OutputMonitoraggioRimodulazioni_DAC")
    private MonitoraggioRimodulazioniDACOutputDTO monitoraggioRimodulazioniDAC;

    public MonitoraggioRimodulazioniDACOutputDTO getMonitoraggioRimodulazioniDAC() {
        return monitoraggioRimodulazioniDAC;
    }

    public void setMonitoraggioRimodulazioniDAC(MonitoraggioRimodulazioniDACOutputDTO monitoraggioRimodulazioniDAC) {
        this.monitoraggioRimodulazioniDAC = monitoraggioRimodulazioniDAC;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((monitoraggioRimodulazioniDAC == null) ? 0 : monitoraggioRimodulazioniDAC.hashCode());
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
        MonitoraggioRimodulazioniDACOutputWrapperDTO other = (MonitoraggioRimodulazioniDACOutputWrapperDTO) obj;
        if (monitoraggioRimodulazioniDAC == null) {
            if (other.monitoraggioRimodulazioniDAC != null)
                return false;
        } else if (!monitoraggioRimodulazioniDAC.equals(other.monitoraggioRimodulazioniDAC))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MonitoraggioRimodulazioniDACOutputWrapperDTO [monitoraggioRimodulazioniDAC=" + monitoraggioRimodulazioniDAC + "]";
    }
    
    

}
