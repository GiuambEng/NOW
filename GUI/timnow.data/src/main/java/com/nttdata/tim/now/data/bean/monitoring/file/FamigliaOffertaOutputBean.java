
package com.nttdata.tim.now.data.bean.monitoring.file;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FamigliaOffertaOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 2103081824248826547L;

	@JsonProperty("nomeFamigliaOfferta")
	private String nomeFamigliaOfferta;

	@JsonProperty("datiFile")
	private List<DatiFileOutputBean> statiFile;

	public String getNomeFamigliaOfferta() {
		return nomeFamigliaOfferta;
	}

	public void setNomeFamigliaOfferta(String nomeFamigliaOfferta) {
		this.nomeFamigliaOfferta = nomeFamigliaOfferta;
	}

	public List<DatiFileOutputBean> getStatiFile() {
		return statiFile;
	}

	public void setStatiFile(List<DatiFileOutputBean> statiFile) {
		this.statiFile = statiFile;
	}

	@Override
	public String toString() {
		return "MonitoraggioFileBean [nomeFamigliaOfferta=" + nomeFamigliaOfferta + ", statiFile=" + statiFile + "]";
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
		FamigliaOffertaOutputBean other = (FamigliaOffertaOutputBean) obj;
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
