package com.nttdata.tim.now.data.dto.ordine.hashing;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.asset.AssetOutputDTO;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.ordine.OrderDTO;
import com.nttdata.tim.now.data.dto.ordine.donating.OrdineDonatingOutputDTO;

//R1F-21-0411
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DettaglioReportOutputDTO extends ESBResultDTO implements Serializable{

	private static final long serialVersionUID = 7659892932195250757L;
	
	@JsonProperty("listaOrdiniDonatingOutput")
	private List<OrdineDonatingOutputDTO> listaOrdiniDonatingOutput;
	
	@JsonProperty("listaOrdiniOutput")
	private List<OrderDTO> listaOrdiniOutput;
	
	@JsonProperty("listaAssetOutput")
	private List<AssetOutputDTO> listaAssetOutput;

	public List<OrdineDonatingOutputDTO> getListaOrdiniDonatingOutput() {
		return listaOrdiniDonatingOutput;
	}

	public void setListaOrdiniDonatingOutput(List<OrdineDonatingOutputDTO> listaOrdiniDonatingOutput) {
		this.listaOrdiniDonatingOutput = listaOrdiniDonatingOutput;
	}

	public List<OrderDTO> getListaOrdiniOutput() {
		return listaOrdiniOutput;
	}

	public void setListaOrdiniOutput(List<OrderDTO> listaOrdiniOutput) {
		this.listaOrdiniOutput = listaOrdiniOutput;
	}

	public List<AssetOutputDTO> getListaAssetOutput() {
		return listaAssetOutput;
	}

	public void setListaAssetOutput(List<AssetOutputDTO> listaAssetOutput) {
		this.listaAssetOutput = listaAssetOutput;
	}
}
