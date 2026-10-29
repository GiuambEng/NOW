package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1205
@JsonInclude(Include.NON_NULL)
public class ClliFeederSuccessivoInputDTO implements Serializable {

	private static final long serialVersionUID = -3767278767344896595L;
	
	@JsonProperty("id")
	private Integer id;
		
	@JsonProperty("clliFeederSuccessivo")
	private String clliFeederSuccessivo;

	public Integer getId() {
		return id;
	}

	public String getClliFeederSuccessivo() {
		return clliFeederSuccessivo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setClliFeederSuccessivo(String clliFeederSuccessivo) {
		this.clliFeederSuccessivo = clliFeederSuccessivo;
	}

}
