package com.nttdata.tim.now.data.dto.dtu;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class DtuOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -5253110173481182193L;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG2, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataNotificaDaDtu")
	private Date dataNotificaDaDtu;

	@JsonProperty("statoEventoDaDtu")
	private String statoEventoDaDtu;

	@JsonProperty("notificaDtu")
	private String notificaDtu;

    @JsonProperty("identificativoEventoOrdineNowWholesale")
    private String identificativoEventoOrdineNowWholesale;

    @JsonProperty("progressivoEventoDtu")
    private String progressivoEventoDtu;

    @JsonProperty("identificativoRichiestaDtu")
    private String identificativoRichiestaDtu;

    public Date getDataNotificaDaDtu() {
        return dataNotificaDaDtu;
    }

    public void setDataNotificaDaDtu(Date dataNotificaDaDtu) {
        this.dataNotificaDaDtu = dataNotificaDaDtu;
    }

    public String getStatoEventoDaDtu() {
        return statoEventoDaDtu;
    }

    public void setStatoEventoDaDtu(String statoEventoDaDtu) {
        this.statoEventoDaDtu = statoEventoDaDtu;
    }

    public String getNotificaDtu() {
        return notificaDtu;
    }

    public void setNotificaDtu(String notificaDtu) {
        this.notificaDtu = notificaDtu;
    }

    public String getIdentificativoEventoOrdineNowWholesale() {
        return identificativoEventoOrdineNowWholesale;
    }

    public void setIdentificativoEventoOrdineNowWholesale(String identificativoEventoOrdineNowWholesale) {
        this.identificativoEventoOrdineNowWholesale = identificativoEventoOrdineNowWholesale;
    }

    public String getProgressivoEventoDtu() {
        return progressivoEventoDtu;
    }

    public void setProgressivoEventoDtu(String progressivoEventoDtu) {
        this.progressivoEventoDtu = progressivoEventoDtu;
    }

    public String getIdentificativoRichiestaDtu() {
        return identificativoRichiestaDtu;
    }

    public void setIdentificativoRichiestaDtu(String identificativoRichiestaDtu) {
        this.identificativoRichiestaDtu = identificativoRichiestaDtu;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataNotificaDaDtu == null) ? 0 : dataNotificaDaDtu.hashCode());
        result = prime * result + ((identificativoEventoOrdineNowWholesale == null) ? 0 : identificativoEventoOrdineNowWholesale.hashCode());
        result = prime * result + ((identificativoRichiestaDtu == null) ? 0 : identificativoRichiestaDtu.hashCode());
        result = prime * result + ((notificaDtu == null) ? 0 : notificaDtu.hashCode());
        result = prime * result + ((progressivoEventoDtu == null) ? 0 : progressivoEventoDtu.hashCode());
        result = prime * result + ((statoEventoDaDtu == null) ? 0 : statoEventoDaDtu.hashCode());
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
        DtuOutputDTO other = (DtuOutputDTO) obj;
        if (dataNotificaDaDtu == null) {
            if (other.dataNotificaDaDtu != null)
                return false;
        } else if (!dataNotificaDaDtu.equals(other.dataNotificaDaDtu))
            return false;
        if (identificativoEventoOrdineNowWholesale == null) {
            if (other.identificativoEventoOrdineNowWholesale != null)
                return false;
        } else if (!identificativoEventoOrdineNowWholesale.equals(other.identificativoEventoOrdineNowWholesale))
            return false;
        if (identificativoRichiestaDtu == null) {
            if (other.identificativoRichiestaDtu != null)
                return false;
        } else if (!identificativoRichiestaDtu.equals(other.identificativoRichiestaDtu))
            return false;
        if (notificaDtu == null) {
            if (other.notificaDtu != null)
                return false;
        } else if (!notificaDtu.equals(other.notificaDtu))
            return false;
        if (progressivoEventoDtu == null) {
            if (other.progressivoEventoDtu != null)
                return false;
        } else if (!progressivoEventoDtu.equals(other.progressivoEventoDtu))
            return false;
        if (statoEventoDaDtu == null) {
            if (other.statoEventoDaDtu != null)
                return false;
        } else if (!statoEventoDaDtu.equals(other.statoEventoDaDtu))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DtuOutputDTO [dataNotificaDaDtu=" + dataNotificaDaDtu + ", statoEventoDaDtu=" + statoEventoDaDtu + ", notificaDtu=" + notificaDtu
                + ", identificativoEventoOrdineNowWholesale=" + identificativoEventoOrdineNowWholesale + ", progressivoEventoDtu=" + progressivoEventoDtu
                + ", identificativoRichiestaDtu=" + identificativoRichiestaDtu + "]";
    }


    
}
