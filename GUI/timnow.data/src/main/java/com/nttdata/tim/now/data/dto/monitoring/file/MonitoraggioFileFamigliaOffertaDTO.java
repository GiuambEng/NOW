package com.nttdata.tim.now.data.dto.monitoring.file;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitoraggioFileFamigliaOffertaDTO implements Serializable {

	private static final long serialVersionUID = 7316419917809722121L;

	@JsonProperty("nomeFamigliaOfferta")
	private String nomeFamigliaOfferta;

	@JsonProperty("dataXFile")
	private List<MonitoraggioFileDatiFileDTO> statiFile;

	public String getNomeFamigliaOfferta() {
		return nomeFamigliaOfferta;
	}
 
	public void setNomeFamigliaOfferta(String nomeFamigliaOfferta) {
		this.nomeFamigliaOfferta = nomeFamigliaOfferta;
	}

	public List<MonitoraggioFileDatiFileDTO> getStatiFile() {
		return statiFile;
	}

	public void setStatiFile(List<MonitoraggioFileDatiFileDTO> statiFile) {
		this.statiFile = statiFile;
	}

	@Override
	public String toString() {
		return "MonitoraggioFileDTO [nomeFamigliaOfferta=" + nomeFamigliaOfferta + ", statiFile=" + statiFile + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeFamigliaOfferta == null) ? 0 : nomeFamigliaOfferta.hashCode());
		result = prime * result + ((statiFile == null) ? 0 : statiFile.hashCode());
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
		MonitoraggioFileFamigliaOffertaDTO other = (MonitoraggioFileFamigliaOffertaDTO) obj;
		if (nomeFamigliaOfferta == null) {
			if (other.nomeFamigliaOfferta != null)
				return false;
		} else if (!nomeFamigliaOfferta.equals(other.nomeFamigliaOfferta))
			return false;
		if (statiFile == null) {
			if (other.statiFile != null)
				return false;
		} else if (!statiFile.equals(other.statiFile))
			return false;
		return true;
	}

}
