package com.nttdata.tim.now.data.bean.result;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Result implements Serializable {

    private static final long serialVersionUID = -2682737593735898871L;
    private String code;
	private String description;
	private String message;
	private String severity;
	private String details;
	
	public Result() {
		//Default empty constructor
	}
	
	public Result(String code, String description, String message) {
		super();
		this.code = code;
		this.description = description;
		this.message = message;
	}

	public Result(String code, String description, String message, String severity, String details) {
		super();
		this.code = code;
		this.description = description;
		this.message = message;
		this.severity = severity;
		this.details = details;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
}
