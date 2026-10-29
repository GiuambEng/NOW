package com.nttdata.tim.now.data.bean.indirizzo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class IndirizzoOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -5549726222186158758L;

    @JsonProperty("items")
	private List<String> items;

	@JsonProperty("type")
	private String type;
	
    @JsonProperty("civico")
	private List<String> civico;
	
    @JsonProperty("codiceEgon")
	private List<String> codiceEgon;

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getCivico() {
		return civico;
	}

	public void setCivico(List<String> civico) {
		this.civico = civico;
	}

	public List<String> getCodiceEgon() {
		return codiceEgon;
	}

	public void setCodiceEgon(List<String> codiceEgon) {
		this.codiceEgon = codiceEgon;
	}

}