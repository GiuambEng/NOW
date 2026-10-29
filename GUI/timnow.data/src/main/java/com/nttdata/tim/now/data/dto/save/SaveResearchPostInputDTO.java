package com.nttdata.tim.now.data.dto.save;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.ricerca.ConditionDTO;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class SaveResearchPostInputDTO implements Serializable {
	
	private static final long serialVersionUID = 5623722554177766491L;

	@JsonProperty("DESCR")
	private String description;

	@JsonProperty("NOME_FILTRO")
	private String nomeFiltro;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("TIMSTP_INSMTO")
	private Date timestampInserimento;

	@JsonProperty("strutturaCondition")
	private List<ConditionDTO> filters;

	public String getNomeFiltro() {
		return nomeFiltro;
	}

	public void setNomeFiltro(String nomeFiltro) {
		this.nomeFiltro = nomeFiltro;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ConditionDTO> getFilters() {
		return filters;
	}

	public void setFilters(List<ConditionDTO> filters) {
		this.filters = filters;
	}

	public Date getTimestampInserimento() {
		return timestampInserimento;
	}

	public void setTimestampInserimento(Date timestampInserimento) {
		this.timestampInserimento = timestampInserimento;
	}

}
