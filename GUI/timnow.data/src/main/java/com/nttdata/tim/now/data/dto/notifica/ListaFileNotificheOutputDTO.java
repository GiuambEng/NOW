package com.nttdata.tim.now.data.dto.notifica;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.export.ExportableDataOutputDTO;

@JsonInclude(Include.NON_NULL)
public class ListaFileNotificheOutputDTO extends ExportableDataOutputDTO {

	private static final long serialVersionUID = 5713801883761476525L;

	@JsonProperty("listaFileNotifiche")	
    private List<FileNotificheOutputDTO> notificationFiles;

    public List<FileNotificheOutputDTO> getNotificationFiles() {
	return notificationFiles;
    }

    public void setNotificationFiles(List<FileNotificheOutputDTO> notificationFiles) {
	this.notificationFiles = notificationFiles;
    }

}
