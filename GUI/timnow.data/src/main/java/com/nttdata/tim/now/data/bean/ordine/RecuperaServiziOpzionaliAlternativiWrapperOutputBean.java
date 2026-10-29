package com.nttdata.tim.now.data.bean.ordine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1485
public class RecuperaServiziOpzionaliAlternativiWrapperOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 1L;

	@JsonProperty("listaServiziOpzionaliAlternativi")
    private List<ServiziOpzionaliAlternativiOutputBean> listaServiziOpzionaliAlternativi;

	public List<ServiziOpzionaliAlternativiOutputBean> getListaServiziOpzionaliAlternativi() {
		return listaServiziOpzionaliAlternativi;
	}

	public void setListaServiziOpzionaliAlternativi(
			List<ServiziOpzionaliAlternativiOutputBean> listaServiziOpzionaliAlternativi) {
		this.listaServiziOpzionaliAlternativi = listaServiziOpzionaliAlternativi;
	}
	
}

