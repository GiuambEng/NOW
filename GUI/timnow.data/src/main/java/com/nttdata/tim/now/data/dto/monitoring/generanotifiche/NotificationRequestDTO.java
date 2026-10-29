package com.nttdata.tim.now.data.dto.monitoring.generanotifiche;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class NotificationRequestDTO implements Serializable {

	private static final long serialVersionUID = -1705418419273454358L;

	@JsonProperty("id_notifica")
	private String idNotifica;

	@JsonProperty("cod_tplg_ntf")
	private String codiceTipologiaNotifica;

	@JsonProperty("struttura_richiesta")
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
