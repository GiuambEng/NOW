package com.nttdata.tim.now.data.bean.atm;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class KitAtmOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -8052217644413782408L;

	@JsonProperty("codiceKit")
	private String codiceKit;

	@JsonProperty("stato")
	private String stato;

	@JsonProperty("clli")
	private String clli;

	@JsonProperty("codiceAreaRaccolta")
	private String codiceAreaRaccolta;

	@JsonProperty("descAreaRaccolta")
	private String descAreaRaccolta;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonProperty("codiceOlo")
	private String codiceOlo;

	@JsonProperty("identificativoPrimeContractor")
	private String identificativoPrimeContractor;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("decAttivazione")
	private Date decAttivazione;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dec")
	private Date dec;

	public String getCodiceKit() {
		return codiceKit;
	}

	public void setCodiceKit(String codiceKit) {
		this.codiceKit = codiceKit;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getCodiceAreaRaccolta() {
		return codiceAreaRaccolta;
	}

	public void setCodiceAreaRaccolta(String codiceAreaRaccolta) {
		this.codiceAreaRaccolta = codiceAreaRaccolta;
	}

	public String getDescAreaRaccolta() {
		return descAreaRaccolta;
	}

	public void setDescAreaRaccolta(String descAreaRaccolta) {
		this.descAreaRaccolta = descAreaRaccolta;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getCodiceOlo() {
		return codiceOlo;
	}

	public void setCodiceOlo(String codiceOlo) {
		this.codiceOlo = codiceOlo;
	}

	public String getIdentificativoPrimeContractor() {
		return identificativoPrimeContractor;
	}

	public void setIdentificativoPrimeContractor(String identificativoPrimeContractor) {
		this.identificativoPrimeContractor = identificativoPrimeContractor;
	}

	public Date getDecAttivazione() {
		return decAttivazione;
	}

	public void setDecAttivazione(Date decAttivazione) {
		this.decAttivazione = decAttivazione;
	}

	public Date getDec() {
		return dec;
	}

	public void setDec(Date dec) {
		this.dec = dec;
	}

}