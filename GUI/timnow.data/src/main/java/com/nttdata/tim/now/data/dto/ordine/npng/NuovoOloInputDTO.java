package com.nttdata.tim.now.data.dto.ordine.npng;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

//RU_1203
@JsonInclude(Include.NON_NULL)
public class NuovoOloInputDTO implements Serializable {

	private static final long serialVersionUID = 6717882641257668638L;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataCutOver")
    private Date dataCutOver;
	
	@JsonProperty("olo")
    private String olo;

	public Date getDataCutOver() {
		return dataCutOver;
	}

	public void setDataCutOver(Date dataCutOver) {
		this.dataCutOver = dataCutOver;
	}

	public String getOlo() {
		return olo;
	}

	public void setOlo(String olo) {
		this.olo = olo;
	}
}
