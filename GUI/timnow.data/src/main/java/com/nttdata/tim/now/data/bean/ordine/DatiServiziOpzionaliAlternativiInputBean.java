package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1485
@JsonInclude(Include.NON_NULL)
public class DatiServiziOpzionaliAlternativiInputBean implements Serializable{

	private static final long serialVersionUID = -3996430531314211875L;
	
    @JsonProperty("id")
    private String id;

    @JsonProperty("codiceServizio")
    private String codiceServizio;
    
    @JsonProperty("descrizioneServizio")
    private String descrizioneServizio;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodiceServizio() {
		return codiceServizio;
	}

	public void setCodiceServizio(String codiceServizio) {
		this.codiceServizio = codiceServizio;
	}

	public String getDescrizioneServizio() {
		return descrizioneServizio;
	}

	public void setDescrizioneServizio(String descrizioneServizio) {
		this.descrizioneServizio = descrizioneServizio;
	}	
}
