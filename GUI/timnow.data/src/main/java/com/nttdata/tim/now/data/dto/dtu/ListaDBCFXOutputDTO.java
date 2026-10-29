package com.nttdata.tim.now.data.dto.dtu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ListaDBCFXOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = -2977269177942196358L;

	@JsonProperty("outputAggDbcfx")
	private List<DbcfxOutputDTO> dbcfx;

	public List<DbcfxOutputDTO> getDbcfx() {
		return dbcfx;
	}

	public void setDbcfx(List<DbcfxOutputDTO> dbcfx) {
		this.dbcfx = dbcfx;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dbcfx == null) ? 0 : dbcfx.hashCode());
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
		ListaDBCFXOutputDTO other = (ListaDBCFXOutputDTO) obj;
		if (dbcfx == null) {
			if (other.dbcfx != null)
				return false;
		} else if (!dbcfx.equals(other.dbcfx))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaDBCFXOutputDTO [dbcfx=" + dbcfx + "]";
	}


}
