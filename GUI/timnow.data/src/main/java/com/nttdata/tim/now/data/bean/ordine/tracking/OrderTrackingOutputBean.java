package com.nttdata.tim.now.data.bean.ordine.tracking;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class OrderTrackingOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -7293394447857507986L;

    @JsonFormat(pattern = DateHelper.DATE_FE_LONG, timezone = DateHelper.TIMEZONE_IT, shape = JsonFormat.Shape.STRING)
    @JsonProperty("timestampTracciamento")
    private Date timestampTracciamento;

	@JsonProperty("statoNOWA")
	private String statoNOWA;

	@JsonProperty("statoNOWDA")
	private String statoNOWDA;

	@JsonProperty("statoOLOA")
	private String statoOLOA;

	@JsonProperty("statoOLODA")
	private String statoOLODA;
	
	@JsonProperty("FlagNotifiche")
	private boolean  flagNotifiche;
	
	@JsonProperty("inizioTracciamento")
	private String inizioTracciamento;

	@JsonProperty("fineTracciamento")
	private String fineTracciamento;

	public Date getTimestampTracciamento() {
		return timestampTracciamento;
	}

	public void setTimestampTracciamento(Date timestampTracciamento) {
		this.timestampTracciamento = timestampTracciamento;
	}

	public String getStatoNOWA() {
		return statoNOWA;
	}

	public void setStatoNOWA(String statoNOWA) {
		this.statoNOWA = statoNOWA;
	}

	public String getStatoNOWDA() {
		return statoNOWDA;
	}

	public void setStatoNOWDA(String statoNOWDA) {
		this.statoNOWDA = statoNOWDA;
	}

	public String getStatoOLOA() {
		return statoOLOA;
	}

	public void setStatoOLOA(String statoOLOA) {
		this.statoOLOA = statoOLOA;
	}

	public String getStatoOLODA() {
		return statoOLODA;
	}

	public void setStatoOLODA(String statoOLODA) {
		this.statoOLODA = statoOLODA;
	}

	public boolean isFlagNotifiche() {
		return flagNotifiche;
	}

	public void setFlagNotifiche(boolean flagNotifiche) {
		this.flagNotifiche = flagNotifiche;
	}

	public String getInizioTracciamento() {
		return inizioTracciamento;
	}

	public void setInizioTracciamento(String inizioTracciamento) {
		this.inizioTracciamento = inizioTracciamento;
	}

	public String getFineTracciamento() {
		return fineTracciamento;
	}

	public void setFineTracciamento(String fineTracciamento) {
		this.fineTracciamento = fineTracciamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fineTracciamento == null) ? 0 : fineTracciamento.hashCode());
		result = prime * result + (flagNotifiche ? 1231 : 1237);
		result = prime * result + ((inizioTracciamento == null) ? 0 : inizioTracciamento.hashCode());
		result = prime * result + ((statoNOWA == null) ? 0 : statoNOWA.hashCode());
		result = prime * result + ((statoNOWDA == null) ? 0 : statoNOWDA.hashCode());
		result = prime * result + ((statoOLOA == null) ? 0 : statoOLOA.hashCode());
		result = prime * result + ((statoOLODA == null) ? 0 : statoOLODA.hashCode());
		result = prime * result + ((timestampTracciamento == null) ? 0 : timestampTracciamento.hashCode());
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
		OrderTrackingOutputBean other = (OrderTrackingOutputBean) obj;
		if (fineTracciamento == null) {
			if (other.fineTracciamento != null)
				return false;
		} else if (!fineTracciamento.equals(other.fineTracciamento))
			return false;
		if (flagNotifiche != other.flagNotifiche)
			return false;
		if (inizioTracciamento == null) {
			if (other.inizioTracciamento != null)
				return false;
		} else if (!inizioTracciamento.equals(other.inizioTracciamento))
			return false;
		if (statoNOWA == null) {
			if (other.statoNOWA != null)
				return false;
		} else if (!statoNOWA.equals(other.statoNOWA))
			return false;
		if (statoNOWDA == null) {
			if (other.statoNOWDA != null)
				return false;
		} else if (!statoNOWDA.equals(other.statoNOWDA))
			return false;
		if (statoOLOA == null) {
			if (other.statoOLOA != null)
				return false;
		} else if (!statoOLOA.equals(other.statoOLOA))
			return false;
		if (statoOLODA == null) {
			if (other.statoOLODA != null)
				return false;
		} else if (!statoOLODA.equals(other.statoOLODA))
			return false;
		if (timestampTracciamento == null) {
			if (other.timestampTracciamento != null)
				return false;
		} else if (!timestampTracciamento.equals(other.timestampTracciamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderTrackingOutputBean [timestampTracciamento=" + timestampTracciamento + ", statoNOWA=" + statoNOWA
				+ ", statoNOWDA=" + statoNOWDA + ", statoOLOA=" + statoOLOA + ", statoOLODA=" + statoOLODA
				+ ", flagNotifiche=" + flagNotifiche + ", inizioTracciamento=" + inizioTracciamento
				+ ", fineTracciamento=" + fineTracciamento + "]";
	}

    
	
}