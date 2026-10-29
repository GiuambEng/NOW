package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.asset.TipoCosOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

//RU_1188
@JsonInclude(Include.NON_NULL)
public class DettaglioAssetRaccoltaOutputDTO implements Serializable {

	private static final long serialVersionUID = 5428216730152889331L;

    @JsonProperty("codiceContratto")
    private String codiceContratto;

    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("desPrimoOrdine")
    private String desPrimoOrdine;
	
    @JsonProperty("codificaOao")
    private String codificaOao;
    
    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dec")
    private String dec;
    
    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataAggiornamento")
    private String dataAggiornamento;
    
    @JsonProperty("offerta")
    private String offerta;
    
    @JsonProperty("clli")
    private String clli;
    
    @JsonProperty("idRisorsa")
    private String idRisorsa;
    
    @JsonProperty("oraDes")
    private String oraDes;
    
    @JsonProperty("primoOrdineTi")
    private String primoOrdineTi;
    
	@JsonProperty("statoAsset")
	private String statoAsset;
	
    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("dataInserimento")
    private String dataInserimento;
	
    @JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
    @JsonProperty("des")
    private String des;
	
    @JsonProperty("codiceOrdineTi")
    private String codiceOrdineTi;
	
    @JsonProperty("codiceOrdineOaoPrimoOrdine")
    private String codiceOrdineOaoPrimoOrdine;

    @JsonProperty("codiceOrdineOlo")
    private String codiceOrdineOlo;

    @JsonProperty("nomeContratto")
    private String nomeContratto;
    
    @JsonProperty("raccoltaVp")
    private RaccoltaVpOutputDTO raccoltaVp;
	
    @JsonProperty("raccoltaVlanNga")
    private RaccoltaVlanNgaOutputDTO raccoltaVlanNga;
    
    @JsonProperty("tipocos")
    private List<TipoCosOutputBean> tipoCos;
    
    @JsonProperty("raccoltaVlanVula")
    private RaccoltaVlanVulaOutputDTO raccoltaVlan;
    
    //SM_10344
    @JsonProperty("raccoltaVlanGbe")
    private RaccoltaVlanGbeOutputDTO raccoltaVlanGbe;

	public String getCodiceContratto() {
		return codiceContratto;
	}

	public String getDesPrimoOrdine() {
		return desPrimoOrdine;
	}

	public String getCodificaOao() {
		return codificaOao;
	}

	public String getDec() {
		return dec;
	}

	public String getDataAggiornamento() {
		return dataAggiornamento;
	}

	public String getOfferta() {
		return offerta;
	}

	public String getClli() {
		return clli;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public String getOraDes() {
		return oraDes;
	}

	public String getPrimoOrdineTi() {
		return primoOrdineTi;
	}

	public String getStatoAsset() {
		return statoAsset;
	}

	public String getDataInserimento() {
		return dataInserimento;
	}

	public String getDes() {
		return des;
	}

	public String getCodiceOrdineTi() {
		return codiceOrdineTi;
	}

	public String getCodiceOrdineOaoPrimoOrdine() {
		return codiceOrdineOaoPrimoOrdine;
	}

	public String getCodiceOrdineOlo() {
		return codiceOrdineOlo;
	}

	public String getNomeContratto() {
		return nomeContratto;
	}

	public RaccoltaVpOutputDTO getRaccoltaVp() {
		return raccoltaVp;
	}

	public RaccoltaVlanNgaOutputDTO getRaccoltaVlanNga() {
		return raccoltaVlanNga;
	}

	public List<TipoCosOutputBean> getTipoCos() {
		return tipoCos;
	}

	public RaccoltaVlanVulaOutputDTO getRaccoltaVlan() {
		return raccoltaVlan;
	}

	public RaccoltaVlanGbeOutputDTO getRaccoltaVlanGbe() {
		return raccoltaVlanGbe;
	}

	public void setCodiceContratto(String codiceContratto) {
		this.codiceContratto = codiceContratto;
	}

	public void setDesPrimoOrdine(String desPrimoOrdine) {
		this.desPrimoOrdine = desPrimoOrdine;
	}

	public void setCodificaOao(String codificaOao) {
		this.codificaOao = codificaOao;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public void setDataAggiornamento(String dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public void setOraDes(String oraDes) {
		this.oraDes = oraDes;
	}

	public void setPrimoOrdineTi(String primoOrdineTi) {
		this.primoOrdineTi = primoOrdineTi;
	}

	public void setStatoAsset(String statoAsset) {
		this.statoAsset = statoAsset;
	}

	public void setDataInserimento(String dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public void setCodiceOrdineTi(String codiceOrdineTi) {
		this.codiceOrdineTi = codiceOrdineTi;
	}

	public void setCodiceOrdineOaoPrimoOrdine(String codiceOrdineOaoPrimoOrdine) {
		this.codiceOrdineOaoPrimoOrdine = codiceOrdineOaoPrimoOrdine;
	}

	public void setCodiceOrdineOlo(String codiceOrdineOlo) {
		this.codiceOrdineOlo = codiceOrdineOlo;
	}

	public void setNomeContratto(String nomeContratto) {
		this.nomeContratto = nomeContratto;
	}

	public void setRaccoltaVp(RaccoltaVpOutputDTO raccoltaVp) {
		this.raccoltaVp = raccoltaVp;
	}

	public void setRaccoltaVlanNga(RaccoltaVlanNgaOutputDTO raccoltaVlanNga) {
		this.raccoltaVlanNga = raccoltaVlanNga;
	}

	public void setTipoCos(List<TipoCosOutputBean> tipoCos) {
		this.tipoCos = tipoCos;
	}

	public void setRaccoltaVlan(RaccoltaVlanVulaOutputDTO raccoltaVlan) {
		this.raccoltaVlan = raccoltaVlan;
	}

	public void setRaccoltaVlanGbe(RaccoltaVlanGbeOutputDTO raccoltaVlanGbe) {
		this.raccoltaVlanGbe = raccoltaVlanGbe;
	}
    
}
