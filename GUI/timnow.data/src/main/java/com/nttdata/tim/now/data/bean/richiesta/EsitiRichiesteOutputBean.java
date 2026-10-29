package com.nttdata.tim.now.data.bean.richiesta;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.notifica.NotificaOutputBean;

@JsonInclude(Include.NON_NULL)
public class EsitiRichiesteOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 5077851732066661136L;

    @JsonProperty("notifications")
	private List<NotificaOutputBean> notifications;

	@JsonProperty("outcomesRequests")
	private List<EsitoRichiestaBean> outcomesRequired;

	public List<NotificaOutputBean> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<NotificaOutputBean> notifications) {
		this.notifications = notifications;
	}

	public List<EsitoRichiestaBean> getOutcomesRequired() {
		return outcomesRequired;
	}

	public void setOutcomesRequired(List<EsitoRichiestaBean> outcomesRequired) {
		this.outcomesRequired = outcomesRequired;
	}

}