package com.nttdata.tim.now.data.bean.fe;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.utente.UserBean;

@JsonInclude(Include.NON_NULL)
public class FEInitBean extends AbstractOutputBean implements Serializable {
	private static final long serialVersionUID = -7339955718034370819L;

	@JsonProperty("config")
	private transient Map<String, Object> config;

	@JsonProperty("authorizations")
	private transient Map<String, List<String>> authorizations;

	@JsonProperty("user")
	private UserBean user;

	public Map<String, Object> getConfig() {
		return config;
	}

	public void setConfig(Map<String, Object> config) {
		this.config = config;
	}

	public Map<String, List<String>> getAuthorizations() {
		return authorizations;
	}

	public void setAuthorizations(Map<String, List<String>> authorizations) {
		this.authorizations = authorizations;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

}
