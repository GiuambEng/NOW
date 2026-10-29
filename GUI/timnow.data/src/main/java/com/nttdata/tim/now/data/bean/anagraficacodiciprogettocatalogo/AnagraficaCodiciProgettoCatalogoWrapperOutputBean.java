package com.nttdata.tim.now.data.bean.anagraficacodiciprogettocatalogo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1485
@JsonInclude(Include.NON_NULL)
public class AnagraficaCodiciProgettoCatalogoWrapperOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = -5929954073169687506L;

	@JsonProperty("listaServiziOpzionaliDefault")
    private List<ServiziOpzionaliDefaultOutputBean> listaServiziOpzionaliDefault;
	
	@JsonProperty("listaServiziOpzionaliAlternativi")
	private List<ServiziOpzionaliAlternativiOutputBean> listaServiziOpzionaliAlternativi;

	public List<ServiziOpzionaliDefaultOutputBean> getListaServiziOpzionaliDefault() {
		return listaServiziOpzionaliDefault;
	}

	public void setListaServiziOpzionaliDefault(List<ServiziOpzionaliDefaultOutputBean> listaServiziOpzionaliDefault) {
		this.listaServiziOpzionaliDefault = listaServiziOpzionaliDefault;
	}

	public List<ServiziOpzionaliAlternativiOutputBean> getListaServiziOpzionaliAlternativi() {
		return listaServiziOpzionaliAlternativi;
	}

	public void setListaServiziOpzionaliAlternativi(
			List<ServiziOpzionaliAlternativiOutputBean> listaServiziOpzionaliAlternativi) {
		this.listaServiziOpzionaliAlternativi = listaServiziOpzionaliAlternativi;
	}	
}
