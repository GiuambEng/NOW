package com.nttdata.tim.now.data.bean.anagraficanpng;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1203
public class CampiAnagraficaNpngOutputBean implements Serializable {

	private static final long serialVersionUID = 915084885819698400L;
	
    @JsonProperty("listaPrefissi")
	private List<PrefissoNpngItemOutputBean> listaPrefissi;

    @JsonProperty("listaOpzioneTraffico")
	private List<OpzioneTrafficoNpngItemOutputBean> listaOpzioneTraffico;

	public List<PrefissoNpngItemOutputBean> getListaPrefissi() {
		return listaPrefissi;
	}

	public void setListaPrefissi(List<PrefissoNpngItemOutputBean> listaPrefissi) {
		this.listaPrefissi = listaPrefissi;
	}

	public List<OpzioneTrafficoNpngItemOutputBean> getListaOpzioneTraffico() {
		return listaOpzioneTraffico;
	}

	public void setListaOpzioneTraffico(List<OpzioneTrafficoNpngItemOutputBean> listaOpzioneTraffico) {
		this.listaOpzioneTraffico = listaOpzioneTraffico;
	}
}
