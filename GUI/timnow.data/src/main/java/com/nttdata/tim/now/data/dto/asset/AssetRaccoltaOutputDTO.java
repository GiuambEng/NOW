package com.nttdata.tim.now.data.dto.asset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1188
@JsonInclude(Include.NON_NULL)
public class AssetRaccoltaOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 3069343552472460479L;

	@JsonProperty("codiceOrdineOao")
	private String codiceOrdineOao;
	
	@JsonProperty("codificaOAO")
	private String codificaOao;
	
	@JsonProperty("codiceTdKit")
	private String codiceTdKit;
	
	@JsonProperty("offerta")
	private String offerta;
	
	@JsonProperty("codiceOrdineTi")
	private String codiceOrdineTi;
	
	@JsonProperty("idRisorsa")
	private String idRisorsa;

	@JsonProperty("statoAsset")
	private String statoAsset;
	
	@JsonProperty("idAsset")
	private String idAsset;

	public String getCodiceOrdineOao() {
		return codiceOrdineOao;
	}

	public String getCodificaOao() {
		return codificaOao;
	}

	public String getCodiceTdKit() {
		return codiceTdKit;
	}

	public String getOfferta() {
		return offerta;
	}

	public String getCodiceOrdineTi() {
		return codiceOrdineTi;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public String getStatoAsset() {
		return statoAsset;
	}

	public void setCodiceOrdineOao(String codiceOrdineOao) {
		this.codiceOrdineOao = codiceOrdineOao;
	}

	public void setCodificaOao(String codificaOao) {
		this.codificaOao = codificaOao;
	}

	public void setCodiceTdKit(String codiceTdKit) {
		this.codiceTdKit = codiceTdKit;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public void setCodiceOrdineTi(String codiceOrdineTi) {
		this.codiceOrdineTi = codiceOrdineTi;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public void setStatoAsset(String statoAsset) {
		this.statoAsset = statoAsset;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}
	
}
