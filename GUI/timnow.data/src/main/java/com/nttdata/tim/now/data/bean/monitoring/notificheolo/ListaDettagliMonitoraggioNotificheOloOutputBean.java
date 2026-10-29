package com.nttdata.tim.now.data.bean.monitoring.notificheolo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class ListaDettagliMonitoraggioNotificheOloOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -2544589929674309868L;

    @JsonProperty("detail")
	private List<DettaglioMonitoraggioNotificheOloOutputBean> detail;

	@JsonProperty("idExportFile")
	private String idExportFile;

	public List<DettaglioMonitoraggioNotificheOloOutputBean> getDetail() {
		return detail;
	}

	public void setDetail(List<DettaglioMonitoraggioNotificheOloOutputBean> deatail) {
		this.detail = deatail;
	}

	public String getIdExportFile() {
		return idExportFile;
	}

	public void setIdExportFile(String idExportFile) {
		this.idExportFile = idExportFile;
	}

}