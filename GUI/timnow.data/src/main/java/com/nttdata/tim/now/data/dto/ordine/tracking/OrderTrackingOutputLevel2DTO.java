package com.nttdata.tim.now.data.dto.ordine.tracking;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class OrderTrackingOutputLevel2DTO implements Serializable {

	private static final long serialVersionUID = -3883845060978608287L;

	@JsonFormat(pattern = DateHelper.DATE_BE_LONG2, shape = JsonFormat.Shape.STRING)
	@JsonProperty("timestampTracciamento")
	private Date timestampTracciamento;

	@JsonProperty("statoNOW_A")
	private String statoNOWA;

	@JsonProperty("statoNOW_DA")
	private String statoNOWDA;

	@JsonProperty("statoOLO_A")
	private String statoOLOA;

	@JsonProperty("statoOLO_DA")
	private String statoOLODA;
	
	@JsonProperty("FlagNotifiche")
	private String flagNotifiche;
	
	@JsonProperty("inizio_tracciamento")
	private String inizioTracciamento;

	@JsonProperty("fine_tracciamento")
	private String fineTracciamento;

	 @JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	 @JsonProperty("DAC_A")
	 private Date dacA;

	 @JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	 @JsonProperty("DAC_DA")
	 private Date dacDa;
	 
	 @JsonProperty("desc_causale_now")
	 private String descCausaleNow;

	 @JsonProperty("desc_causale_olo")
	 private String descCausaleOlo;

	 @JsonProperty("cod_oloAgcom_destinatario")
	 private String codOloAgcomDestinatario;

	 @JsonProperty("desc_tipo_destinatario")
	 private String descTipoDestinatario;

	 @JsonProperty("desc_tipo_notif")
	 private String descTipoNotif;

	 @JsonProperty("tracciato_file")
	 private String tracciatoFile;

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

	public String getFlagNotifiche() {
		return flagNotifiche;
	}

	public void setFlagNotifiche(String flagNotifiche) {
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

	public Date getDacA() {
		return dacA;
	}

	public void setDacA(Date dacA) {
		this.dacA = dacA;
	}

	public Date getDacDa() {
		return dacDa;
	}

	public void setDacDa(Date dacDa) {
		this.dacDa = dacDa;
	}

	public String getDescCausaleNow() {
		return descCausaleNow;
	}

	public void setDescCausaleNow(String descCausaleNow) {
		this.descCausaleNow = descCausaleNow;
	}

	public String getDescCausaleOlo() {
		return descCausaleOlo;
	}

	public void setDescCausaleOlo(String descCausaleOlo) {
		this.descCausaleOlo = descCausaleOlo;
	}

	public String getCodOloAgcomDestinatario() {
		return codOloAgcomDestinatario;
	}

	public void setCodOloAgcomDestinatario(String codOloAgcomDestinatario) {
		this.codOloAgcomDestinatario = codOloAgcomDestinatario;
	}

	public String getDescTipoDestinatario() {
		return descTipoDestinatario;
	}

	public void setDescTipoDestinatario(String descTipoDestinatario) {
		this.descTipoDestinatario = descTipoDestinatario;
	}

	public String getDescTipoNotif() {
		return descTipoNotif;
	}

	public void setDescTipoNotif(String descTipoNotif) {
		this.descTipoNotif = descTipoNotif;
	}

	public String getTracciatoFile() {
		return tracciatoFile;
	}

	public void setTracciatoFile(String tracciatoFile) {
		this.tracciatoFile = tracciatoFile;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcomDestinatario == null) ? 0 : codOloAgcomDestinatario.hashCode());
		result = prime * result + ((dacA == null) ? 0 : dacA.hashCode());
		result = prime * result + ((dacDa == null) ? 0 : dacDa.hashCode());
		result = prime * result + ((descCausaleNow == null) ? 0 : descCausaleNow.hashCode());
		result = prime * result + ((descCausaleOlo == null) ? 0 : descCausaleOlo.hashCode());
		result = prime * result + ((descTipoDestinatario == null) ? 0 : descTipoDestinatario.hashCode());
		result = prime * result + ((descTipoNotif == null) ? 0 : descTipoNotif.hashCode());
		result = prime * result + ((fineTracciamento == null) ? 0 : fineTracciamento.hashCode());
		result = prime * result + ((flagNotifiche == null) ? 0 : flagNotifiche.hashCode());
		result = prime * result + ((inizioTracciamento == null) ? 0 : inizioTracciamento.hashCode());
		result = prime * result + ((statoNOWA == null) ? 0 : statoNOWA.hashCode());
		result = prime * result + ((statoNOWDA == null) ? 0 : statoNOWDA.hashCode());
		result = prime * result + ((statoOLOA == null) ? 0 : statoOLOA.hashCode());
		result = prime * result + ((statoOLODA == null) ? 0 : statoOLODA.hashCode());
		result = prime * result + ((timestampTracciamento == null) ? 0 : timestampTracciamento.hashCode());
		result = prime * result + ((tracciatoFile == null) ? 0 : tracciatoFile.hashCode());
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
		OrderTrackingOutputLevel2DTO other = (OrderTrackingOutputLevel2DTO) obj;
		if (codOloAgcomDestinatario == null) {
			if (other.codOloAgcomDestinatario != null)
				return false;
		} else if (!codOloAgcomDestinatario.equals(other.codOloAgcomDestinatario))
			return false;
		if (dacA == null) {
			if (other.dacA != null)
				return false;
		} else if (!dacA.equals(other.dacA))
			return false;
		if (dacDa == null) {
			if (other.dacDa != null)
				return false;
		} else if (!dacDa.equals(other.dacDa))
			return false;
		if (descCausaleNow == null) {
			if (other.descCausaleNow != null)
				return false;
		} else if (!descCausaleNow.equals(other.descCausaleNow))
			return false;
		if (descCausaleOlo == null) {
			if (other.descCausaleOlo != null)
				return false;
		} else if (!descCausaleOlo.equals(other.descCausaleOlo))
			return false;
		if (descTipoDestinatario == null) {
			if (other.descTipoDestinatario != null)
				return false;
		} else if (!descTipoDestinatario.equals(other.descTipoDestinatario))
			return false;
		if (descTipoNotif == null) {
			if (other.descTipoNotif != null)
				return false;
		} else if (!descTipoNotif.equals(other.descTipoNotif))
			return false;
		if (fineTracciamento == null) {
			if (other.fineTracciamento != null)
				return false;
		} else if (!fineTracciamento.equals(other.fineTracciamento))
			return false;
		if (flagNotifiche == null) {
			if (other.flagNotifiche != null)
				return false;
		} else if (!flagNotifiche.equals(other.flagNotifiche))
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
		if (tracciatoFile == null) {
			if (other.tracciatoFile != null)
				return false;
		} else if (!tracciatoFile.equals(other.tracciatoFile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderTrackingOutputLevel2DTO [timestampTracciamento=" + timestampTracciamento + ", statoNOWA="
				+ statoNOWA + ", statoNOWDA=" + statoNOWDA + ", statoOLOA=" + statoOLOA + ", statoOLODA=" + statoOLODA
				+ ", flagNotifiche=" + flagNotifiche + ", inizioTracciamento=" + inizioTracciamento
				+ ", fineTracciamento=" + fineTracciamento + ", dacA=" + dacA + ", dacDa=" + dacDa + ", descCausaleNow="
				+ descCausaleNow + ", descCausaleOlo=" + descCausaleOlo + ", codOloAgcomDestinatario="
				+ codOloAgcomDestinatario + ", descTipoDestinatario=" + descTipoDestinatario + ", descTipoNotif="
				+ descTipoNotif + ", tracciatoFile=" + tracciatoFile + "]";
	}
	 
	 


}
