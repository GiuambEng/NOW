package com.nttdata.tim.now.data.dto.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1188
@JsonInclude(Include.NON_NULL)
public class RaccoltaVlanVulaOutputDTO implements Serializable {

	private static final long serialVersionUID = 7630058282882958921L;

	@JsonProperty("nomearearaccolta")
    private String nomeAreaRaccolta;
    
    @JsonProperty("codicetdkit")
    private String codiceTdKit;
    
    @JsonProperty("tipologiavlan")
    private String tipologiaVlan;
    
    @JsonProperty("nomeclli")
    private String nomeClli;
    
    @JsonProperty("identificativovlanolo")
    private String identificativoVlanOlo;
    
    @JsonProperty("idvlanrete")
    private String idVlanRete;
    
    @JsonProperty("distanzanodo")
    private String distanzaNodo;
    
    @JsonProperty("idrisorsa")
    private String idRisorsa;
    
    @JsonProperty("puntoconsegna")
    private String puntoConsegna;
    
    @JsonProperty("qinqflag")
    private String qinqFlag;
    
    @JsonProperty("nomemacroarea")
    private String nomeMacroarea;
    
    @JsonProperty("codiceclli")
    private String codiceClli;
    
    @JsonProperty("trasporto")
    private String trasporto;
    
    @JsonProperty("tipovlan")
    private String tipoVlan;
    
    @JsonProperty("intermediateagentdhcpoption82")
    private String intermediateAgentDhcpOption82;

	public String getNomeAreaRaccolta() {
		return nomeAreaRaccolta;
	}

	public String getCodiceTdKit() {
		return codiceTdKit;
	}

	public String getTipologiaVlan() {
		return tipologiaVlan;
	}

	public String getNomeClli() {
		return nomeClli;
	}

	public String getIdentificativoVlanOlo() {
		return identificativoVlanOlo;
	}

	public String getIdVlanRete() {
		return idVlanRete;
	}

	public String getDistanzaNodo() {
		return distanzaNodo;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public String getPuntoConsegna() {
		return puntoConsegna;
	}

	public String getQinqFlag() {
		return qinqFlag;
	}

	public String getNomeMacroarea() {
		return nomeMacroarea;
	}

	public String getCodiceClli() {
		return codiceClli;
	}

	public String getTrasporto() {
		return trasporto;
	}

	public String getTipoVlan() {
		return tipoVlan;
	}

	public String getIntermediateAgentDhcpOption82() {
		return intermediateAgentDhcpOption82;
	}

	public void setNomeAreaRaccolta(String nomeAreaRaccolta) {
		this.nomeAreaRaccolta = nomeAreaRaccolta;
	}

	public void setCodiceTdKit(String codiceTdKit) {
		this.codiceTdKit = codiceTdKit;
	}

	public void setTipologiaVlan(String tipologiaVlan) {
		this.tipologiaVlan = tipologiaVlan;
	}

	public void setNomeClli(String nomeClli) {
		this.nomeClli = nomeClli;
	}

	public void setIdentificativoVlanOlo(String identificativoVlanOlo) {
		this.identificativoVlanOlo = identificativoVlanOlo;
	}

	public void setIdVlanRete(String idVlanRete) {
		this.idVlanRete = idVlanRete;
	}

	public void setDistanzaNodo(String distanzaNodo) {
		this.distanzaNodo = distanzaNodo;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public void setPuntoConsegna(String puntoConsegna) {
		this.puntoConsegna = puntoConsegna;
	}

	public void setQinqFlag(String qinqFlag) {
		this.qinqFlag = qinqFlag;
	}

	public void setNomeMacroarea(String nomeMacroarea) {
		this.nomeMacroarea = nomeMacroarea;
	}

	public void setCodiceClli(String codiceClli) {
		this.codiceClli = codiceClli;
	}

	public void setTrasporto(String trasporto) {
		this.trasporto = trasporto;
	}

	public void setTipoVlan(String tipoVlan) {
		this.tipoVlan = tipoVlan;
	}

	public void setIntermediateAgentDhcpOption82(String intermediateAgentDhcpOption82) {
		this.intermediateAgentDhcpOption82 = intermediateAgentDhcpOption82;
	}}
