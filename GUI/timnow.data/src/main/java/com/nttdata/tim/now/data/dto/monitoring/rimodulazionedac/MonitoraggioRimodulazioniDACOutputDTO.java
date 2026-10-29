package com.nttdata.tim.now.data.dto.monitoring.rimodulazionedac;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioRimodulazioniDACOutputDTO implements Serializable {
	
    private static final long serialVersionUID = -8927529017514184716L;
    
    @JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataScadenza")
    private Date dataScadenza;

    @JsonProperty("operatore")
    private String operatore;
    
    @JsonProperty("richiesteInScadenza_1")
    private String richiesteInScadenza1;
    
    @JsonProperty("richiesteInScadenza_2")
    private String richiesteInScadenza2;
    
    @JsonProperty("richiesteInScadenza_3")
    private String richiesteInScadenza3;
    
    @JsonProperty("richiesteInScadenza_4")
    private String richiesteInScadenza4;
    
    @JsonProperty("richiesteInScadenza_5")
    private String richiesteInScadenza5;
    
    @JsonProperty("richiesteInScadenza_6")
    private String richiesteInScadenza6;
    
    @JsonProperty("richiesteInScadenza_7")
    private String richiesteInScadenza7;
    
    @JsonProperty("richiesteInScadenza_8")
    private String richiesteInScadenza8;
    
    @JsonProperty("exportData")
    private String exportData;
    
    @JsonProperty("sizeFile")
    private String sizeFile;
    
    @JsonProperty("nomeFileToExport")
    private String nomeFileToExport;
    
    @JsonProperty("statoRefresh")
    private String statoRefresh;
    
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

    public String getRichiesteInScadenza1() {
        return richiesteInScadenza1;
    }

    public void setRichiesteInScadenza1(String richiesteInScadenza1) {
        this.richiesteInScadenza1 = richiesteInScadenza1;
    }

    public String getRichiesteInScadenza2() {
        return richiesteInScadenza2;
    }

    public void setRichiesteInScadenza2(String richiesteInScadenza2) {
        this.richiesteInScadenza2 = richiesteInScadenza2;
    }

    public String getRichiesteInScadenza3() {
        return richiesteInScadenza3;
    }

    public void setRichiesteInScadenza3(String richiesteInScadenza3) {
        this.richiesteInScadenza3 = richiesteInScadenza3;
    }

    public String getRichiesteInScadenza4() {
        return richiesteInScadenza4;
    }

    public void setRichiesteInScadenza4(String richiesteInScadenza4) {
        this.richiesteInScadenza4 = richiesteInScadenza4;
    }

    public String getRichiesteInScadenza5() {
        return richiesteInScadenza5;
    }

    public void setRichiesteInScadenza5(String richiesteInScadenza5) {
        this.richiesteInScadenza5 = richiesteInScadenza5;
    }

    public String getRichiesteInScadenza6() {
        return richiesteInScadenza6;
    }

    public void setRichiesteInScadenza6(String richiesteInScadenza6) {
        this.richiesteInScadenza6 = richiesteInScadenza6;
    }

    public String getRichiesteInScadenza7() {
        return richiesteInScadenza7;
    }

    public void setRichiesteInScadenza7(String richiesteInScadenza7) {
        this.richiesteInScadenza7 = richiesteInScadenza7;
    }

    public String getRichiesteInScadenza8() {
        return richiesteInScadenza8;
    }

    public void setRichiesteInScadenza8(String richiesteInScadenza8) {
        this.richiesteInScadenza8 = richiesteInScadenza8;
    }

    public String getExportData() {
        return exportData;
    }

    public void setExportData(String exportData) {
        this.exportData = exportData;
    }

    public String getSizeFile() {
        return sizeFile;
    }

    public void setSizeFile(String sizeFile) {
        this.sizeFile = sizeFile;
    }

    public String getNomeFileToExport() {
        return nomeFileToExport;
    }

    public void setNomeFileToExport(String nomeFileToExport) {
        this.nomeFileToExport = nomeFileToExport;
    }

    public String getStatoRefresh() {
        return statoRefresh;
    }

    public void setStatoRefresh(String statoRefresh) {
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
        result = prime * result + ((dataScadenza == null) ? 0 : dataScadenza.hashCode());
        result = prime * result + ((descStatoRefresh == null) ? 0 : descStatoRefresh.hashCode());
        result = prime * result + ((exportData == null) ? 0 : exportData.hashCode());
        result = prime * result + ((nomeFileToExport == null) ? 0 : nomeFileToExport.hashCode());
        result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
        result = prime * result + ((richiesteInScadenza1 == null) ? 0 : richiesteInScadenza1.hashCode());
        result = prime * result + ((richiesteInScadenza2 == null) ? 0 : richiesteInScadenza2.hashCode());
        result = prime * result + ((richiesteInScadenza3 == null) ? 0 : richiesteInScadenza3.hashCode());
        result = prime * result + ((richiesteInScadenza4 == null) ? 0 : richiesteInScadenza4.hashCode());
        result = prime * result + ((richiesteInScadenza5 == null) ? 0 : richiesteInScadenza5.hashCode());
        result = prime * result + ((richiesteInScadenza6 == null) ? 0 : richiesteInScadenza6.hashCode());
        result = prime * result + ((richiesteInScadenza7 == null) ? 0 : richiesteInScadenza7.hashCode());
        result = prime * result + ((richiesteInScadenza8 == null) ? 0 : richiesteInScadenza8.hashCode());
        result = prime * result + ((sizeFile == null) ? 0 : sizeFile.hashCode());
        result = prime * result + ((statoRefresh == null) ? 0 : statoRefresh.hashCode());
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
        MonitoraggioRimodulazioniDACOutputDTO other = (MonitoraggioRimodulazioniDACOutputDTO) obj;
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
        if (exportData == null) {
            if (other.exportData != null)
                return false;
        } else if (!exportData.equals(other.exportData))
            return false;
        if (nomeFileToExport == null) {
            if (other.nomeFileToExport != null)
                return false;
        } else if (!nomeFileToExport.equals(other.nomeFileToExport))
            return false;
        if (operatore == null) {
            if (other.operatore != null)
                return false;
        } else if (!operatore.equals(other.operatore))
            return false;
        if (richiesteInScadenza1 == null) {
            if (other.richiesteInScadenza1 != null)
                return false;
        } else if (!richiesteInScadenza1.equals(other.richiesteInScadenza1))
            return false;
        if (richiesteInScadenza2 == null) {
            if (other.richiesteInScadenza2 != null)
                return false;
        } else if (!richiesteInScadenza2.equals(other.richiesteInScadenza2))
            return false;
        if (richiesteInScadenza3 == null) {
            if (other.richiesteInScadenza3 != null)
                return false;
        } else if (!richiesteInScadenza3.equals(other.richiesteInScadenza3))
            return false;
        if (richiesteInScadenza4 == null) {
            if (other.richiesteInScadenza4 != null)
                return false;
        } else if (!richiesteInScadenza4.equals(other.richiesteInScadenza4))
            return false;
        if (richiesteInScadenza5 == null) {
            if (other.richiesteInScadenza5 != null)
                return false;
        } else if (!richiesteInScadenza5.equals(other.richiesteInScadenza5))
            return false;
        if (richiesteInScadenza6 == null) {
            if (other.richiesteInScadenza6 != null)
                return false;
        } else if (!richiesteInScadenza6.equals(other.richiesteInScadenza6))
            return false;
        if (richiesteInScadenza7 == null) {
            if (other.richiesteInScadenza7 != null)
                return false;
        } else if (!richiesteInScadenza7.equals(other.richiesteInScadenza7))
            return false;
        if (richiesteInScadenza8 == null) {
            if (other.richiesteInScadenza8 != null)
                return false;
        } else if (!richiesteInScadenza8.equals(other.richiesteInScadenza8))
            return false;
        if (sizeFile == null) {
            if (other.sizeFile != null)
                return false;
        } else if (!sizeFile.equals(other.sizeFile))
            return false;
        if (statoRefresh == null) {
            if (other.statoRefresh != null)
                return false;
        } else if (!statoRefresh.equals(other.statoRefresh))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MonitoraggioRimodulazioniDACOutputDTO [dataScadenza=" + dataScadenza + ", operatore=" + operatore
                + ", richiesteInScadenza1=" + richiesteInScadenza1 + ", richiesteInScadenza2=" + richiesteInScadenza2 + ", richiesteInScadenza3="
                + richiesteInScadenza3 + ", richiesteInScadenza4=" + richiesteInScadenza4 + ", richiesteInScadenza5=" + richiesteInScadenza5
                + ", richiesteInScadenza6=" + richiesteInScadenza6 + ", richiesteInScadenza7=" + richiesteInScadenza7 + ", richiesteInScadenza8="
                + richiesteInScadenza8 + ", exportData=" + exportData + ", sizeFile=" + sizeFile + ", nomeFileToExport=" + nomeFileToExport + ", statoRefresh="
                + statoRefresh + ", descStatoRefresh=" + descStatoRefresh + "]";
    }

    
}
