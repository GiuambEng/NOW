package com.nttdata.tim.now.data.bean.monitoring.rigenerazionemail;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class ListaRichiesteMonitoraggioRigenerazioneMailOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -2544589929674309868L;

    @JsonProperty("richieste")
	private List<RichiesteMonitoraggioRigenerazioneMailOutputBean> richieste;

	@JsonProperty("idExportFile")
	private String idExportFile;

	public List<RichiesteMonitoraggioRigenerazioneMailOutputBean> getRichieste() {
		return richieste;
	}

	public void setRichieste(List<RichiesteMonitoraggioRigenerazioneMailOutputBean> richieste) {
		this.richieste = richieste;
	}

	public String getIdExportFile() {
		return idExportFile;
	}

	public void setIdExportFile(String idExportFile) {
		this.idExportFile = idExportFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idExportFile == null) ? 0 : idExportFile.hashCode());
		result = prime * result + ((richieste == null) ? 0 : richieste.hashCode());
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
		ListaRichiesteMonitoraggioRigenerazioneMailOutputBean other = (ListaRichiesteMonitoraggioRigenerazioneMailOutputBean) obj;
		if (idExportFile == null) {
			if (other.idExportFile != null)
				return false;
		} else if (!idExportFile.equals(other.idExportFile))
			return false;
		if (richieste == null) {
			if (other.richieste != null)
				return false;
		} else if (!richieste.equals(other.richieste))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaRichiesteMonitoraggioRigenerazioneMailOutputBean [richieste=" + richieste + ", idExportFile="
				+ idExportFile + "]";
	}



}