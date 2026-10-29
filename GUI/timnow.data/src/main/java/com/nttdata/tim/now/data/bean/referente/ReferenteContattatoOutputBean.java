package com.nttdata.tim.now.data.bean.referente;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class ReferenteContattatoOutputBean extends AbstractOutputBean implements Serializable {
	
    private static final long serialVersionUID = 1190970685463789945L;

    @JsonProperty("oraContatto")
	private String oraContatto;

	@JsonProperty("progressivoEventoDtu")
	private String progressivoEventoDtu;

	@JsonProperty("oraVisitaContatto")
	private String oraVisitaContatto;

	@JsonProperty("progressivoReferente")
	private String progressivoReferente;

	@JsonProperty("nominativo")
	private String nominativoContatto;

	@JsonProperty("esito")
	private String esitoChiamataContatto;

	@JsonProperty("nota")
	private String notaUlterioreContatto;

	@JsonProperty("riferimentoMobile")
	private String telefonoMobileReferente;

	@JsonProperty("riferimentoFisso")
	private String telefonoFissoReferente;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInserimento")
	private Date timestampInserimento;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataVisita")
	private Date dataVisitaContatto;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataContatto")
	private Date dataContatto;
	
	//SM_10597
	@JsonProperty("qualifica")
	private String qualifica;

	public String getOraContatto() {
		return oraContatto;
	}

	public void setOraContatto(String oraContatto) {
		this.oraContatto = oraContatto;
	}

	public String getProgressivoEventoDtu() {
		return progressivoEventoDtu;
	}

	public void setProgressivoEventoDtu(String progressivoEventoDtu) {
		this.progressivoEventoDtu = progressivoEventoDtu;
	}

	public String getOraVisitaContatto() {
		return oraVisitaContatto;
	}

	public void setOraVisitaContatto(String oraVisitaContatto) {
		this.oraVisitaContatto = oraVisitaContatto;
	}

	public String getProgressivoReferente() {
		return progressivoReferente;
	}

	public void setProgressivoReferente(String progressivoReferente) {
		this.progressivoReferente = progressivoReferente;
	}

	public String getNominativoContatto() {
		return nominativoContatto;
	}

	public void setNominativoContatto(String nominativoContatto) {
		this.nominativoContatto = nominativoContatto;
	}

	public String getEsitoChiamataContatto() {
		return esitoChiamataContatto;
	}

	public void setEsitoChiamataContatto(String esitoChiamataContatto) {
		this.esitoChiamataContatto = esitoChiamataContatto;
	}

	public String getNotaUlterioreContatto() {
		return notaUlterioreContatto;
	}

	public void setNotaUlterioreContatto(String notaUlterioreContatto) {
		this.notaUlterioreContatto = notaUlterioreContatto;
	}

	public String getTelefonoMobileReferente() {
		return telefonoMobileReferente;
	}

	public void setTelefonoMobileReferente(String telefonoMobileReferente) {
		this.telefonoMobileReferente = telefonoMobileReferente;
	}

	public String getTelefonoFissoReferente() {
		return telefonoFissoReferente;
	}

	public void setTelefonoFissoReferente(String telefonoFissoReferente) {
		this.telefonoFissoReferente = telefonoFissoReferente;
	}

	public Date getTimestampInserimento() {
		return timestampInserimento;
	}

	public void setTimestampInserimento(Date timestampInserimento) {
		this.timestampInserimento = timestampInserimento;
	}

	public Date getDataVisitaContatto() {
		return dataVisitaContatto;
	}

	public void setDataVisitaContatto(Date dataVisitaContatto) {
		this.dataVisitaContatto = dataVisitaContatto;
	}

	public Date getDataContatto() {
		return dataContatto;
	}

	public void setDataContatto(Date dataContatto) {
		this.dataContatto = dataContatto;
	}

	public String getQualifica() {
		return qualifica;
	}

	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}

	@Override
	public String toString() {
		return "ReferenteContattatoOutputBean [oraContatto=" + oraContatto + ", progressivoEventoDtu="
				+ progressivoEventoDtu + ", oraVisitaContatto=" + oraVisitaContatto + ", progressivoReferente="
				+ progressivoReferente + ", nominativoContatto=" + nominativoContatto + ", esitoChiamataContatto="
				+ esitoChiamataContatto + ", notaUlterioreContatto=" + notaUlterioreContatto
				+ ", telefonoMobileReferente=" + telefonoMobileReferente + ", telefonoFissoReferente="
				+ telefonoFissoReferente + ", timestampInserimento=" + timestampInserimento + ", dataVisitaContatto="
				+ dataVisitaContatto + ", dataContatto=" + dataContatto + ", qualifica=" + qualifica + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataContatto == null) ? 0 : dataContatto.hashCode());
		result = prime * result + ((dataVisitaContatto == null) ? 0 : dataVisitaContatto.hashCode());
		result = prime * result + ((esitoChiamataContatto == null) ? 0 : esitoChiamataContatto.hashCode());
		result = prime * result + ((nominativoContatto == null) ? 0 : nominativoContatto.hashCode());
		result = prime * result + ((notaUlterioreContatto == null) ? 0 : notaUlterioreContatto.hashCode());
		result = prime * result + ((oraContatto == null) ? 0 : oraContatto.hashCode());
		result = prime * result + ((oraVisitaContatto == null) ? 0 : oraVisitaContatto.hashCode());
		result = prime * result + ((progressivoEventoDtu == null) ? 0 : progressivoEventoDtu.hashCode());
		result = prime * result + ((progressivoReferente == null) ? 0 : progressivoReferente.hashCode());
		result = prime * result + ((qualifica == null) ? 0 : qualifica.hashCode());
		result = prime * result + ((telefonoFissoReferente == null) ? 0 : telefonoFissoReferente.hashCode());
		result = prime * result + ((telefonoMobileReferente == null) ? 0 : telefonoMobileReferente.hashCode());
		result = prime * result + ((timestampInserimento == null) ? 0 : timestampInserimento.hashCode());
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
		ReferenteContattatoOutputBean other = (ReferenteContattatoOutputBean) obj;
		if (dataContatto == null) {
			if (other.dataContatto != null)
				return false;
		} else if (!dataContatto.equals(other.dataContatto))
			return false;
		if (dataVisitaContatto == null) {
			if (other.dataVisitaContatto != null)
				return false;
		} else if (!dataVisitaContatto.equals(other.dataVisitaContatto))
			return false;
		if (esitoChiamataContatto == null) {
			if (other.esitoChiamataContatto != null)
				return false;
		} else if (!esitoChiamataContatto.equals(other.esitoChiamataContatto))
			return false;
		if (nominativoContatto == null) {
			if (other.nominativoContatto != null)
				return false;
		} else if (!nominativoContatto.equals(other.nominativoContatto))
			return false;
		if (notaUlterioreContatto == null) {
			if (other.notaUlterioreContatto != null)
				return false;
		} else if (!notaUlterioreContatto.equals(other.notaUlterioreContatto))
			return false;
		if (oraContatto == null) {
			if (other.oraContatto != null)
				return false;
		} else if (!oraContatto.equals(other.oraContatto))
			return false;
		if (oraVisitaContatto == null) {
			if (other.oraVisitaContatto != null)
				return false;
		} else if (!oraVisitaContatto.equals(other.oraVisitaContatto))
			return false;
		if (progressivoEventoDtu == null) {
			if (other.progressivoEventoDtu != null)
				return false;
		} else if (!progressivoEventoDtu.equals(other.progressivoEventoDtu))
			return false;
		if (progressivoReferente == null) {
			if (other.progressivoReferente != null)
				return false;
		} else if (!progressivoReferente.equals(other.progressivoReferente))
			return false;
		if (qualifica == null) {
			if (other.qualifica != null)
				return false;
		} else if (!qualifica.equals(other.qualifica))
			return false;
		if (telefonoFissoReferente == null) {
			if (other.telefonoFissoReferente != null)
				return false;
		} else if (!telefonoFissoReferente.equals(other.telefonoFissoReferente))
			return false;
		if (telefonoMobileReferente == null) {
			if (other.telefonoMobileReferente != null)
				return false;
		} else if (!telefonoMobileReferente.equals(other.telefonoMobileReferente))
			return false;
		if (timestampInserimento == null) {
			if (other.timestampInserimento != null)
				return false;
		} else if (!timestampInserimento.equals(other.timestampInserimento))
			return false;
		return true;
	}

}