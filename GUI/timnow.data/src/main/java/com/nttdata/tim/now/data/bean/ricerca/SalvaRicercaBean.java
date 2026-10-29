package com.nttdata.tim.now.data.bean.ricerca;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class SalvaRicercaBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 3807261279729636574L;

    @JsonProperty("description")
	private String description;

	@JsonProperty("nomeFiltro")
	private String nomeFiltro;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("codFunzione")
	private String codFunzione;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("timestampInserimento")
	private Date timestampInserimento;

	@JsonProperty("filters")
	private List<ConditionBean> filters;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ConditionBean> getFilters() {
		return filters;
	}

	public void setFilters(List<ConditionBean> filters) {
		this.filters = filters;
	}

	public Date getTimestampInserimento() {
		return timestampInserimento;
	}

	public void setTimestampInserimento(Date timestampInserimento) {
		this.timestampInserimento = timestampInserimento;
	}

    @Override
    public String toString() {
        return "SalvaRicercaBean [description=" + description + ", nomeFiltro=" + nomeFiltro + ", userId=" + userId + ", codFunzione=" + codFunzione
                + ", timestampInserimento=" + timestampInserimento + ", filters=" + filters + "]";
    }

	
}