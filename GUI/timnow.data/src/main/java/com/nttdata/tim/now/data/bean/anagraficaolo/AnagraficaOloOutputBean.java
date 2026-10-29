package com.nttdata.tim.now.data.bean.anagraficaolo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class AnagraficaOloOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 797283319439967603L;

	@JsonProperty("id")
	private String id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("codiceOLO")
	private String codiceOLO;

	@JsonProperty("accorpante")
	private boolean accorpante;
	
	//RU_1180
	@JsonProperty("codiceOLONumerico")
	private String codiceOLONumerico;

	public String getNome() {
		return nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceOLO() {
		return codiceOLO;
	}

	public void setCodiceOLO(String codiceOLO) {
		this.codiceOLO = codiceOLO;
	}

	public boolean isAccorpante() {
		return accorpante;
	}

	public void setAccorpante(boolean accorpante) {
		this.accorpante = accorpante;
	}

	public String getCodiceOLONumerico() {
		return codiceOLONumerico;
	}

	public void setCodiceOLONumerico(String codiceOLONumerico) {
		this.codiceOLONumerico = codiceOLONumerico;
	}

}