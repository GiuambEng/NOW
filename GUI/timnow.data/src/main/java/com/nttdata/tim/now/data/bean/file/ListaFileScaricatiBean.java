package com.nttdata.tim.now.data.bean.file;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListaFileScaricatiBean implements Serializable {

    private static final long serialVersionUID = 4717912153325497235L;

    @JsonProperty("codOloAgcom")
	private String codOloAgcom;

	@JsonProperty("ids")
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
