package com.nttdata.tim.now.data.bean.file;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileScaricatoBean implements Serializable {

    private static final long serialVersionUID = -6280649199032460587L;

    @JsonProperty("name")
	private String name;

	@JsonProperty("mime")
	private String mime;

	@JsonProperty("size")
	private long size;

	@JsonProperty("fileData")
	private byte[] fileData;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

}
