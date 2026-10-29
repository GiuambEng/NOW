package com.nttdata.tim.now.data.dto.monitoring.tempiattraversamento;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultExportDTO;

@JsonInclude(Include.NON_NULL)
public class TempiAttraversamentoOutputDTO extends ESBResultExportDTO {

	private static final long serialVersionUID = 1039180137735851549L;

	@JsonProperty("Aggregato")
	private List<AggregatoDTO> aggregates;

	@JsonProperty("Gui")
	private List<GuiDTO> guis;

	@JsonProperty("DettaglioTempiAttr")
	private List<DettaglioTempiAttraversamentoDTO> crossingTimes;

	@JsonProperty("Treshold")
	private ListaSoglieDTO treshold;

	public List<AggregatoDTO> getAggregates() {
		return aggregates;
	}

	public void setAggregates(List<AggregatoDTO> aggregates) {
		this.aggregates = aggregates;
	}

	public List<GuiDTO> getGuis() {
		return guis;
	}

	public void setGuis(List<GuiDTO> guis) {
		this.guis = guis;
	}

	public List<DettaglioTempiAttraversamentoDTO> getCrossingTimes() {
		return crossingTimes;
	}

	public void setCrossingTimes(List<DettaglioTempiAttraversamentoDTO> crossingTimes) {
		this.crossingTimes = crossingTimes;
	}

	public ListaSoglieDTO getTreshold() {
		return treshold;
	}

	public void setTreshold(ListaSoglieDTO treshold) {
		this.treshold = treshold;
	}

	@Override
	public String toString() {
		return "TempiAttraversamentoDTO [aggregates=" + aggregates + ", guis=" + guis + ", crossingTimes="
				+ crossingTimes + ", treshold=" + treshold + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aggregates == null) ? 0 : aggregates.hashCode());
		result = prime * result + ((crossingTimes == null) ? 0 : crossingTimes.hashCode());
		result = prime * result + ((guis == null) ? 0 : guis.hashCode());
		result = prime * result + ((treshold == null) ? 0 : treshold.hashCode());
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
		TempiAttraversamentoOutputDTO other = (TempiAttraversamentoOutputDTO) obj;
		if (aggregates == null) {
			if (other.aggregates != null)
				return false;
		} else if (!aggregates.equals(other.aggregates))
			return false;
		if (crossingTimes == null) {
			if (other.crossingTimes != null)
				return false;
		} else if (!crossingTimes.equals(other.crossingTimes))
			return false;
		if (guis == null) {
			if (other.guis != null)
				return false;
		} else if (!guis.equals(other.guis))
			return false;
		if (treshold == null) {
			if (other.treshold != null)
				return false;
		} else if (!treshold.equals(other.treshold))
			return false;
		return true;
	}

}
