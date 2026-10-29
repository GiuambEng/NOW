package com.nttdata.tim.now.data.bean.monitoring.generanotifiche;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class CodiceRichiestaBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 8691407942073504165L;

    @JsonProperty("idNotifica")
	private String idNotifica;

	@JsonProperty("codiceTipologiaNotifica")
	private String codiceTipologiaNotifica;

	@JsonProperty("strutturaRichiesta")
	private String strutturaRichiesta;

	public String getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	public String getCodiceTipologiaNotifica() {
		return codiceTipologiaNotifica;
	}

	public void setCodiceTipologiaNotifica(String codiceTipologiaNotifica) {
		this.codiceTipologiaNotifica = codiceTipologiaNotifica;
	}

	public String getStrutturaRichiesta() {
		return strutturaRichiesta;
	}

	public void setStrutturaRichiesta(String strutturaRichiesta) {
		this.strutturaRichiesta = strutturaRichiesta;
	}

}