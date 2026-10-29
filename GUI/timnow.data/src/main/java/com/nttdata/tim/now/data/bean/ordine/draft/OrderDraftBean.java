package com.nttdata.tim.now.data.bean.ordine.draft;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class OrderDraftBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 6373737566960401888L;

    @JsonProperty("codOloAgcom")
	private String codOloAgcom;

	@JsonProperty("codOloNum")
	private String codOloNum;

	@JsonProperty("ordineBozza")
	private String ordineBozza;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("codOrdineOlo")
	private String codOrdineOlo;

	@JsonProperty("tipologiaLavorazione")
	private String tipologiaLavorazione;

	@JsonProperty("note")
	private String note;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("ultimoAggiornamento")
	private Date ultimoAggiornamento;
	
	//added only for RU_532 not mapped into DTO
	@JsonProperty("operationType")
	private String operationType;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getCodOloNum() {
		return codOloNum;
	}

	public void setCodOloNum(String codOloNum) {
		this.codOloNum = codOloNum;
	}

	public String getOrdineBozza() {
		return ordineBozza;
	}

	public void setOrdineBozza(String ordineBozza) {
		this.ordineBozza = ordineBozza;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCodOrdineOlo() {
		return codOrdineOlo;
	}

	public void setCodOrdineOlo(String codOrdineOlo) {
		this.codOrdineOlo = codOrdineOlo;
	}

	public String getTipologiaLavorazione() {
		return tipologiaLavorazione;
	}

	public void setTipologiaLavorazione(String tipologiaLavorazione) {
		this.tipologiaLavorazione = tipologiaLavorazione;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getUltimoAggiornamento() {
		return ultimoAggiornamento;
	}

	public void setUltimoAggiornamento(Date ultimoAggiornamento) {
		this.ultimoAggiornamento = ultimoAggiornamento;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + ((codOloNum == null) ? 0 : codOloNum.hashCode());
		result = prime * result + ((codOrdineOlo == null) ? 0 : codOrdineOlo.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((operationType == null) ? 0 : operationType.hashCode());
		result = prime * result + ((ordineBozza == null) ? 0 : ordineBozza.hashCode());
		result = prime * result + ((tipologiaLavorazione == null) ? 0 : tipologiaLavorazione.hashCode());
		result = prime * result + ((ultimoAggiornamento == null) ? 0 : ultimoAggiornamento.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		OrderDraftBean other = (OrderDraftBean) obj;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (codOloNum == null) {
			if (other.codOloNum != null)
				return false;
		} else if (!codOloNum.equals(other.codOloNum))
			return false;
		if (codOrdineOlo == null) {
			if (other.codOrdineOlo != null)
				return false;
		} else if (!codOrdineOlo.equals(other.codOrdineOlo))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (operationType == null) {
			if (other.operationType != null)
				return false;
		} else if (!operationType.equals(other.operationType))
			return false;
		if (ordineBozza == null) {
			if (other.ordineBozza != null)
				return false;
		} else if (!ordineBozza.equals(other.ordineBozza))
			return false;
		if (tipologiaLavorazione == null) {
			if (other.tipologiaLavorazione != null)
				return false;
		} else if (!tipologiaLavorazione.equals(other.tipologiaLavorazione))
			return false;
		if (ultimoAggiornamento == null) {
			if (other.ultimoAggiornamento != null)
				return false;
		} else if (!ultimoAggiornamento.equals(other.ultimoAggiornamento))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDraftBean [codOloAgcom=" + codOloAgcom + ", codOloNum=" + codOloNum + ", ordineBozza="
				+ ordineBozza + ", userId=" + userId + ", codOrdineOlo=" + codOrdineOlo + ", tipologiaLavorazione="
				+ tipologiaLavorazione + ", note=" + note + ", ultimoAggiornamento=" + ultimoAggiornamento
				+ ", operationType=" + operationType + "]";
	}


}