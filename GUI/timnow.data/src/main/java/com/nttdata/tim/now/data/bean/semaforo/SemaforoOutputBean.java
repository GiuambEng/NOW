package com.nttdata.tim.now.data.bean.semaforo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class SemaforoOutputBean extends AbstractOutputBean implements Serializable {
    private static final long serialVersionUID = -4835493400841170309L;

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("filesize")
    private String filesize;

    @JsonProperty("idRejectReason")
    private String idRejectReason;

    @JsonProperty("koRecordNumber")
    private String koRecordNumber;

    @JsonProperty("nowRecordNumber")
    private String nowRecordNumber;

    @JsonProperty("okRecordNumber")
    private String okRecordNumber;

    @JsonProperty("totalRecordNumber")
    private String totalRecordNumber;

    @JsonProperty("totRichiesteFuoriAmbito")
    private String totRichiesteFuoriAmbito;

    @JsonProperty("interfaceId")
    private String interfaceId;

    @JsonProperty("idEsecProfile")
    private String idEsecProfile;

    @JsonProperty("outcome")
    private String outcome;

    @JsonProperty("agcomOloCode")
    private String agcomOloCode;

    @JsonProperty("acquisitionStateDescription")
    private String acquisitionStateDescription;

    @JsonProperty("idFile")
    private String idFile;

    @JsonProperty("color")
    private String color;

    @JsonProperty("type")
    private String type;

    @JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
    @JsonProperty("datafile")
    private Date datafile;

    @JsonFormat(pattern = DateHelper.DATE_FE, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
    @JsonProperty("arrivalDate")
    private Date arrivalDate;

    @JsonFormat(pattern = DateHelper.DATE_FE_LONG, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
    @JsonProperty("fileOpening")
    private Date fileOpening;

    @JsonFormat(pattern = DateHelper.DATE_FE_LONG, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
    @JsonProperty("fileClosing")
    private Date fileClosing;
    
    @JsonProperty("flagRisottomissione")
    private boolean flagRisottomissione;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getIdRejectReason() {
        return idRejectReason;
    }

    public void setIdRejectReason(String idRejectReason) {
        this.idRejectReason = idRejectReason;
    }

    public String getKoRecordNumber() {
        return koRecordNumber;
    }

    public void setKoRecordNumber(String koRecordNumber) {
        this.koRecordNumber = koRecordNumber;
    }

    public String getNowRecordNumber() {
        return nowRecordNumber;
    }

    public void setNowRecordNumber(String nowRecordNumber) {
        this.nowRecordNumber = nowRecordNumber;
    }

    public String getOkRecordNumber() {
        return okRecordNumber;
    }

    public void setOkRecordNumber(String okRecordNumber) {
        this.okRecordNumber = okRecordNumber;
    }

    public String getTotalRecordNumber() {
        return totalRecordNumber;
    }

    public void setTotalRecordNumber(String totalRecordNumber) {
        this.totalRecordNumber = totalRecordNumber;
    }

    public String getTotRichiesteFuoriAmbito() {
        return totRichiesteFuoriAmbito;
    }

    public void setTotRichiesteFuoriAmbito(String totRichiesteFuoriAmbito) {
        this.totRichiesteFuoriAmbito = totRichiesteFuoriAmbito;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getIdEsecProfile() {
        return idEsecProfile;
    }

    public void setIdEsecProfile(String idEsecProfile) {
        this.idEsecProfile = idEsecProfile;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getAgcomOloCode() {
        return agcomOloCode;
    }

    public void setAgcomOloCode(String agcomOloCode) {
        this.agcomOloCode = agcomOloCode;
    }

    public String getAcquisitionStateDescription() {
        return acquisitionStateDescription;
    }

    public void setAcquisitionStateDescription(String acquisitionStateDescription) {
        this.acquisitionStateDescription = acquisitionStateDescription;
    }

    public String getIdFile() {
        return idFile;
    }

    public void setIdFile(String idFile) {
        this.idFile = idFile;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDatafile() {
        return datafile;
    }

    public void setDatafile(Date datafile) {
        this.datafile = datafile;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getFileOpening() {
        return fileOpening;
    }

    public void setFileOpening(Date fileOpening) {
        this.fileOpening = fileOpening;
    }

    public Date getFileClosing() {
        return fileClosing;
    }

    public void setFileClosing(Date fileClosing) {
        this.fileClosing = fileClosing;
    }

    public boolean isFlagRisottomissione() {
        return flagRisottomissione;
    }

    public void setFlagRisottomissione(boolean flagRisottomissione) {
        this.flagRisottomissione = flagRisottomissione;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((acquisitionStateDescription == null) ? 0 : acquisitionStateDescription.hashCode());
        result = prime * result + ((agcomOloCode == null) ? 0 : agcomOloCode.hashCode());
        result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((datafile == null) ? 0 : datafile.hashCode());
        result = prime * result + ((fileClosing == null) ? 0 : fileClosing.hashCode());
        result = prime * result + ((fileOpening == null) ? 0 : fileOpening.hashCode());
        result = prime * result + ((filename == null) ? 0 : filename.hashCode());
        result = prime * result + ((filesize == null) ? 0 : filesize.hashCode());
        result = prime * result + (flagRisottomissione ? 1231 : 1237);
        result = prime * result + ((idEsecProfile == null) ? 0 : idEsecProfile.hashCode());
        result = prime * result + ((idFile == null) ? 0 : idFile.hashCode());
        result = prime * result + ((idRejectReason == null) ? 0 : idRejectReason.hashCode());
        result = prime * result + ((interfaceId == null) ? 0 : interfaceId.hashCode());
        result = prime * result + ((koRecordNumber == null) ? 0 : koRecordNumber.hashCode());
        result = prime * result + ((nowRecordNumber == null) ? 0 : nowRecordNumber.hashCode());
        result = prime * result + ((okRecordNumber == null) ? 0 : okRecordNumber.hashCode());
        result = prime * result + ((outcome == null) ? 0 : outcome.hashCode());
        result = prime * result + ((totRichiesteFuoriAmbito == null) ? 0 : totRichiesteFuoriAmbito.hashCode());
        result = prime * result + ((totalRecordNumber == null) ? 0 : totalRecordNumber.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        SemaforoOutputBean other = (SemaforoOutputBean) obj;
        if (acquisitionStateDescription == null) {
            if (other.acquisitionStateDescription != null)
                return false;
        } else if (!acquisitionStateDescription.equals(other.acquisitionStateDescription))
            return false;
        if (agcomOloCode == null) {
            if (other.agcomOloCode != null)
                return false;
        } else if (!agcomOloCode.equals(other.agcomOloCode))
            return false;
        if (arrivalDate == null) {
            if (other.arrivalDate != null)
                return false;
        } else if (!arrivalDate.equals(other.arrivalDate))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (datafile == null) {
            if (other.datafile != null)
                return false;
        } else if (!datafile.equals(other.datafile))
            return false;
        if (fileClosing == null) {
            if (other.fileClosing != null)
                return false;
        } else if (!fileClosing.equals(other.fileClosing))
            return false;
        if (fileOpening == null) {
            if (other.fileOpening != null)
                return false;
        } else if (!fileOpening.equals(other.fileOpening))
            return false;
        if (filename == null) {
            if (other.filename != null)
                return false;
        } else if (!filename.equals(other.filename))
            return false;
        if (filesize == null) {
            if (other.filesize != null)
                return false;
        } else if (!filesize.equals(other.filesize))
            return false;
        if (flagRisottomissione != other.flagRisottomissione)
            return false;
        if (idEsecProfile == null) {
            if (other.idEsecProfile != null)
                return false;
        } else if (!idEsecProfile.equals(other.idEsecProfile))
            return false;
        if (idFile == null) {
            if (other.idFile != null)
                return false;
        } else if (!idFile.equals(other.idFile))
            return false;
        if (idRejectReason == null) {
            if (other.idRejectReason != null)
                return false;
        } else if (!idRejectReason.equals(other.idRejectReason))
            return false;
        if (interfaceId == null) {
            if (other.interfaceId != null)
                return false;
        } else if (!interfaceId.equals(other.interfaceId))
            return false;
        if (koRecordNumber == null) {
            if (other.koRecordNumber != null)
                return false;
        } else if (!koRecordNumber.equals(other.koRecordNumber))
            return false;
        if (nowRecordNumber == null) {
            if (other.nowRecordNumber != null)
                return false;
        } else if (!nowRecordNumber.equals(other.nowRecordNumber))
            return false;
        if (okRecordNumber == null) {
            if (other.okRecordNumber != null)
                return false;
        } else if (!okRecordNumber.equals(other.okRecordNumber))
            return false;
        if (outcome == null) {
            if (other.outcome != null)
                return false;
        } else if (!outcome.equals(other.outcome))
            return false;
        if (totRichiesteFuoriAmbito == null) {
            if (other.totRichiesteFuoriAmbito != null)
                return false;
        } else if (!totRichiesteFuoriAmbito.equals(other.totRichiesteFuoriAmbito))
            return false;
        if (totalRecordNumber == null) {
            if (other.totalRecordNumber != null)
                return false;
        } else if (!totalRecordNumber.equals(other.totalRecordNumber))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SemaforoOutputBean [filename=" + filename + ", filesize=" + filesize + ", idRejectReason=" + idRejectReason + ", koRecordNumber="
                + koRecordNumber + ", nowRecordNumber=" + nowRecordNumber + ", okRecordNumber=" + okRecordNumber + ", totalRecordNumber=" + totalRecordNumber
                + ", totRichiesteFuoriAmbito=" + totRichiesteFuoriAmbito + ", interfaceId=" + interfaceId + ", idEsecProfile=" + idEsecProfile + ", outcome="
                + outcome + ", agcomOloCode=" + agcomOloCode + ", acquisitionStateDescription=" + acquisitionStateDescription + ", idFile=" + idFile
                + ", color=" + color + ", type=" + type + ", datafile=" + datafile + ", arrivalDate=" + arrivalDate + ", fileOpening=" + fileOpening
                + ", fileClosing=" + fileClosing + ", flagRisottomissione=" + flagRisottomissione + "]";
    }


}