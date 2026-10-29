package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

//RU_980
@JsonInclude(Include.NON_NULL)
public class DatiPresaAppuntamentoInputDTO implements Serializable {

	private static final long serialVersionUID = -7478270449433406003L;

	@JsonProperty("ownerPresaAppuntamento")
    private String ownerPresaAppuntamento;
    
	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataAppuntamento")
    private String dataAppuntamento;
    
    @JsonProperty("fasciaOraria")
    private String fasciaOraria;

	public String getOwnerPresaAppuntamento() {
		return ownerPresaAppuntamento;
	}

	public void setOwnerPresaAppuntamento(String ownerPresaAppuntamento) {
		this.ownerPresaAppuntamento = ownerPresaAppuntamento;
	}

	public String getDataAppuntamento() {
		return dataAppuntamento;
	}

	public void setDataAppuntamento(String dataAppuntamento) {
		this.dataAppuntamento = dataAppuntamento;
	}

	public String getFasciaOraria() {
		return fasciaOraria;
	}

	public void setFasciaOraria(String fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAppuntamento == null) ? 0 : dataAppuntamento.hashCode());
		result = prime * result + ((fasciaOraria == null) ? 0 : fasciaOraria.hashCode());
		result = prime * result + ((ownerPresaAppuntamento == null) ? 0 : ownerPresaAppuntamento.hashCode());
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
		DatiPresaAppuntamentoInputDTO other = (DatiPresaAppuntamentoInputDTO) obj;
		if (dataAppuntamento == null) {
			if (other.dataAppuntamento != null)
				return false;
		} else if (!dataAppuntamento.equals(other.dataAppuntamento))
			return false;
		if (fasciaOraria == null) {
			if (other.fasciaOraria != null)
				return false;
		} else if (!fasciaOraria.equals(other.fasciaOraria))
			return false;
		if (ownerPresaAppuntamento == null) {
			if (other.ownerPresaAppuntamento != null)
				return false;
		} else if (!ownerPresaAppuntamento.equals(other.ownerPresaAppuntamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatiPresaAppuntamentoInputDTO [ownerPresaAppuntamento=" + ownerPresaAppuntamento
				+ ", dataAppuntamento=" + dataAppuntamento + ", fasciaOraria=" + fasciaOraria + "]";
	}

}
