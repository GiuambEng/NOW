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
public class SaveResearchDTO implements Serializable {

	private static final long serialVersionUID = 3908606495691199L;

	@JsonProperty("DESCR")
	private String description;

	@JsonProperty("NOME_FILTRO")
	private String nomeFiltro;

	@JsonProperty("USERID")
	private String userId;

	@JsonProperty("COD_FUNZIONE")
	private String codFunzione;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("TIMSTP_INSMTO")
	private Date timestampInserimento;

	@JsonProperty("strutturaCondition")
	private List<ConditionDTO> filters;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNomeFiltro() {
		return nomeFiltro;
	}

	public void setNomeFiltro(String nomeFiltro) {
		this.nomeFiltro = nomeFiltro;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCodFunzione() {
		return codFunzione;
	}

	public void setCodFunzione(String codFunzione) {
		this.codFunzione = codFunzione;
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
