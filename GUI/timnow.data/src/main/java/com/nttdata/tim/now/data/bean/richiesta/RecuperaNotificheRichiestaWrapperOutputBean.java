package com.nttdata.tim.now.data.bean.richiesta;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.notifica.RecuperaNotificheRichiestaOutputBean;

@JsonInclude(Include.NON_NULL)
public class RecuperaNotificheRichiestaWrapperOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -8365831784526384504L;
	
	@JsonProperty("outputRecuperaNotificheRichiesta")
	private List<RecuperaNotificheRichiestaOutputBean> outputRecuperaNotificheRichiesta;

	public List<RecuperaNotificheRichiestaOutputBean> getOutputRecuperaNotificheRichiesta() {
		return outputRecuperaNotificheRichiesta;
	}

	public void setOutputRecuperaNotificheRichiesta(List<RecuperaNotificheRichiestaOutputBean> outputRecuperaNotificheRichiesta) {
		this.outputRecuperaNotificheRichiesta = outputRecuperaNotificheRichiesta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((outputRecuperaNotificheRichiesta == null) ? 0 : outputRecuperaNotificheRichiesta.hashCode());
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
		RecuperaNotificheRichiestaWrapperOutputBean other = (RecuperaNotificheRichiestaWrapperOutputBean) obj;
		if (outputRecuperaNotificheRichiesta == null) {
			if (other.outputRecuperaNotificheRichiesta != null)
				return false;
		} else if (!outputRecuperaNotificheRichiesta.equals(other.outputRecuperaNotificheRichiesta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperaNotificheRichiestaWrapperOutputBean [outputRecuperaNotificheRichiesta="
				+ outputRecuperaNotificheRichiesta + "]";
	}

}