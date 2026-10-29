
package com.nttdata.tim.now.data.bean.monitoring.file;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileInElaborazioneOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = -2349712130437626343L;

	@JsonProperty("tot")
	private String tot;

	@JsonProperty("gui")
	private String gui;

	@JsonProperty("sftp")
	private String sftp;

	public String getTot() {
		return tot;
	}

	public void setTot(String tot) {
		this.tot = tot;
	}

	public String getGui() {
		return gui;
	}

	public void setGui(String gui) {
		this.gui = gui;
	}

	public String getSftp() {
		return sftp;
	}

	public void setSftp(String sftp) {
		this.sftp = sftp;
	}

	@Override
	public String toString() {
		return "FileAcquisitiOutputBean [tot=" + tot + ", gui=" + gui + ", sftp=" + sftp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gui == null) ? 0 : gui.hashCode());
		result = prime * result + ((sftp == null) ? 0 : sftp.hashCode());
		result = prime * result + ((tot == null) ? 0 : tot.hashCode());
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
		FileInElaborazioneOutputBean other = (FileInElaborazioneOutputBean) obj;
		if (gui == null) {
			if (other.gui != null)
				return false;
		} else if (!gui.equals(other.gui))
			return false;
		if (sftp == null) {
			if (other.sftp != null)
				return false;
		} else if (!sftp.equals(other.sftp))
			return false;
		if (tot == null) {
			if (other.tot != null)
				return false;
		} else if (!tot.equals(other.tot))
			return false;
		return true;
	}

}
