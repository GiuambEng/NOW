package com.nttdata.tim.now.data.dto.file;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ListaFileScaricatiDTO implements Serializable {
	
	private static final long serialVersionUID = -4757433839570428291L;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;

	@JsonProperty("idFile")
	private List<String> ids;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

}
