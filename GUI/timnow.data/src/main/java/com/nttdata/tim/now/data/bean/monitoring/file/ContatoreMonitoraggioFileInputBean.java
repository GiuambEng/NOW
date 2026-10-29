
package com.nttdata.tim.now.data.bean.monitoring.file;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContatoreMonitoraggioFileInputBean extends AbstractOutputBean {

	private static final long serialVersionUID = -7220434851941574473L;

	@JsonProperty("descrizioneFamigliaOfferta")
	private String descrizioneFamigliaOfferta;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataAcquisizione")
	private Date dataAcquisizione;

	@JsonProperty("statoFileNow")
	private String statoFileNow;

	@JsonProperty("owner")
	private String owner;

	@JsonProperty("canaleAcquisizione")
	private String canaleAcquisizione;
	
	@JsonProperty("flagExport")
	private boolean flagExport;

	public String getDescrizioneFamigliaOfferta() {
		return descrizioneFamigliaOfferta;
	}

	public void setDescrizioneFamigliaOfferta(String descrizioneFamigliaOfferta) {
		this.descrizioneFamigliaOfferta = descrizioneFamigliaOfferta;
	}

	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}

	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}

	public String getStatoFileNow() {
		return statoFileNow;
	}

	public void setStatoFileNow(String statoFileNow) {
		this.statoFileNow = statoFileNow;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCanaleAcquisizione() {
		return canaleAcquisizione;
	}

	public void setCanaleAcquisizione(String canaleAcquisizione) {
		this.canaleAcquisizione = canaleAcquisizione;
	}

	public boolean isFlagExport() {
		return flagExport;
	}

	public void setFlagExport(boolean flagExport) {
		this.flagExport = flagExport;
	}

	@Override
	public String toString() {
		return "ContatoreMonitoraggioFileInputBean [descrizioneFamigliaOfferta=" + descrizioneFamigliaOfferta
				+ ", dataAcquisizione=" + dataAcquisizione + ", statoFileNow=" + statoFileNow + ", owner=" + owner
				+ ", canaleAcquisizione=" + canaleAcquisizione + ", flagExport=" + flagExport + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canaleAcquisizione == null) ? 0 : canaleAcquisizione.hashCode());
		result = prime * result + ((dataAcquisizione == null) ? 0 : dataAcquisizione.hashCode());
		result = prime * result + ((descrizioneFamigliaOfferta == null) ? 0 : descrizioneFamigliaOfferta.hashCode());
		result = prime * result + (flagExport ? 1231 : 1237);
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((statoFileNow == null) ? 0 : statoFileNow.hashCode());
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
		ContatoreMonitoraggioFileInputBean other = (ContatoreMonitoraggioFileInputBean) obj;
		if (canaleAcquisizione == null) {
			if (other.canaleAcquisizione != null)
				return false;
		} else if (!canaleAcquisizione.equals(other.canaleAcquisizione))
			return false;
		if (dataAcquisizione == null) {
			if (other.dataAcquisizione != null)
				return false;
		} else if (!dataAcquisizione.equals(other.dataAcquisizione))
			return false;
		if (descrizioneFamigliaOfferta == null) {
			if (other.descrizioneFamigliaOfferta != null)
				return false;
		} else if (!descrizioneFamigliaOfferta.equals(other.descrizioneFamigliaOfferta))
			return false;
		if (flagExport != other.flagExport)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (statoFileNow == null) {
			if (other.statoFileNow != null)
				return false;
		} else if (!statoFileNow.equals(other.statoFileNow))
			return false;
		return true;
	}

}
