package com.nttdata.tim.now.web.controller;

import java.net.FileNameMap;
import java.net.URLConnection;

import com.nttdata.tim.now.data.bean.file.FileScaricatoBean;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public abstract class FileDownloadController extends GenericController {

	protected ResponseEntity<byte[]> getFileResponseEntity(FileScaricatoBean fileBean) {
		//MimetypesFileTypeMap map = new MimetypesFileTypeMap();
		//String mediaType = map.getContentType(fileBean.getName());
		FileNameMap map = URLConnection.getFileNameMap();
		String mediaType = map.getContentTypeFor(fileBean.getName());
		if (StringUtils.isEmpty(mediaType)) {
			mediaType = org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("charset", "utf-8");
		responseHeaders.setContentType(MediaType.valueOf(mediaType));
		responseHeaders.setContentLength((int) fileBean.getSize());
		responseHeaders.set("Content-disposition", "attachment; filename=" + "\"" + fileBean.getName() + "\"");

		return new ResponseEntity<>(fileBean.getFileData(), responseHeaders, HttpStatus.OK);
	}
	
}
