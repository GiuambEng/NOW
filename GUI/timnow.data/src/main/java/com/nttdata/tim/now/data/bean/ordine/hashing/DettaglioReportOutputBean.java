package com.nttdata.tim.now.data.bean.ordine.hashing;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.asset.AssetOutputBean;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.ordine.OrdineOutputBean;
import com.nttdata.tim.now.data.bean.ordine.donating.OrdineDonatingOutputBean;

//R1F-21-0411
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DettaglioReportOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -2039380268476053617L;
	
	@JsonProperty("listaOrdiniDonatingOutput")
	private List<OrdineDonatingOutputBean> listaOrdiniDonatingOutput;
	
	@JsonProperty("listaOrdiniOutput")
	private List<OrdineOutputBean> listaOrdiniOutput;
	
	@JsonProperty("listaAssetOutput")
	private List<AssetOutputBean> listaAssetOutput;

	public List<OrdineDonatingOutputBean> getListaOrdiniDonatingOutput() {
		return listaOrdiniDonatingOutput;
	}

	public void setListaOrdiniDonatingOutput(List<OrdineDonatingOutputBean> listaOrdiniDonatingOutput) {
		this.listaOrdiniDonatingOutput = listaOrdiniDonatingOutput;
	}

	public List<OrdineOutputBean> getListaOrdiniOutput() {
		return listaOrdiniOutput;
	}

	public void setListaOrdiniOutput(List<OrdineOutputBean> listaOrdiniOutput) {
		this.listaOrdiniOutput = listaOrdiniOutput;
	}

	public List<AssetOutputBean> getListaAssetOutput() {
		return listaAssetOutput;
	}

	public void setListaAssetOutput(List<AssetOutputBean> listaAssetOutput) {
		this.listaAssetOutput = listaAssetOutput;
	}

}
