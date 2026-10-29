package com.nttdata.tim.now.data.dto.profiledfunctions;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ProfiledFunctionsDTO implements Serializable {
	
	private static final long serialVersionUID = 5417548366171287187L;

	@JsonProperty("idArea")
	private String idArea;

	@JsonProperty("idFunction")
	private String idFunction;

	@JsonProperty("label")
	private String label;

	@JsonProperty("enabledProfiles")
	private List<String> enabledProfiles;

	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getIdFunction() {
		return idFunction;
	}

	public void setIdFunction(String idFunction) {
		this.idFunction = idFunction;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<String> getEnabledProfiles() {
		return enabledProfiles;
	}

	public void setEnabledProfiles(List<String> enabledProfiles) {
		this.enabledProfiles = enabledProfiles;
	}

}
