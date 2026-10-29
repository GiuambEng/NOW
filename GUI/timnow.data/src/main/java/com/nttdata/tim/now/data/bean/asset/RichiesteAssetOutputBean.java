package com.nttdata.tim.now.data.bean.asset;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class RichiesteAssetOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 6580843470753888853L;

	@JsonProperty("codificaOAO")
	private String codificaOAO;

	@JsonFormat(pattern = DateHelper.DATE_FE_LONG, shape = JsonFormat.Shape.STRING, timezone = DateHelper.TIMEZONE_IT)
	@JsonProperty("dataInvio")
	private Date dataInvio;

	@JsonProperty("idRisorsa")
	private String idRisorsa;
	
	@JsonProperty("tipologiaRichiesta")
	private String tipologiaRichiesta;
	
	@JsonProperty("tipologiaLavorazione")
	private String tipologiaLavorazione;
	
	@JsonProperty("offerta")
	private String offerta;
	
	@JsonProperty("statoOao")
	private String statoOao;

	@JsonProperty("descrizioneCausale")
	private String descrizioneCausale;

	public String getCodificaOAO() {
		return codificaOAO;
	}

	public void setCodificaOAO(String codificaOAO) {
		this.codificaOAO = codificaOAO;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getTipologiaRichiesta() {
		return tipologiaRichiesta;
	}

	public void setTipologiaRichiesta(String tipologiaRichiesta) {
		this.tipologiaRichiesta = tipologiaRichiesta;
	}

	public String getTipologiaLavorazione() {
		return tipologiaLavorazione;
	}

	public void setTipologiaLavorazione(String tipologiaLavorazione) {
		this.tipologiaLavorazione = tipologiaLavorazione;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getStatoOao() {
		return statoOao;
	}

	public void setStatoOao(String statoOao) {
		this.statoOao = statoOao;
	}

	public String getDescrizioneCausale() {
		return descrizioneCausale;
	}

	public void setDescrizioneCausale(String descrizioneCausale) {
		this.descrizioneCausale = descrizioneCausale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codificaOAO == null) ? 0 : codificaOAO.hashCode());
		result = prime * result + ((dataInvio == null) ? 0 : dataInvio.hashCode());
		result = prime * result + ((descrizioneCausale == null) ? 0 : descrizioneCausale.hashCode());
		result = prime * result + ((idRisorsa == null) ? 0 : idRisorsa.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((statoOao == null) ? 0 : statoOao.hashCode());
		result = prime * result + ((tipologiaLavorazione == null) ? 0 : tipologiaLavorazione.hashCode());
		result = prime * result + ((tipologiaRichiesta == null) ? 0 : tipologiaRichiesta.hashCode());
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
		RichiesteAssetOutputBean other = (RichiesteAssetOutputBean) obj;
		if (codificaOAO == null) {
			if (other.codificaOAO != null)
				return false;
		} else if (!codificaOAO.equals(other.codificaOAO))
			return false;
		if (dataInvio == null) {
			if (other.dataInvio != null)
				return false;
		} else if (!dataInvio.equals(other.dataInvio))
			return false;
		if (descrizioneCausale == null) {
			if (other.descrizioneCausale != null)
				return false;
		} else if (!descrizioneCausale.equals(other.descrizioneCausale))
			return false;
		if (idRisorsa == null) {
			if (other.idRisorsa != null)
				return false;
		} else if (!idRisorsa.equals(other.idRisorsa))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (statoOao == null) {
			if (other.statoOao != null)
				return false;
		} else if (!statoOao.equals(other.statoOao))
			return false;
		if (tipologiaLavorazione == null) {
			if (other.tipologiaLavorazione != null)
				return false;
		} else if (!tipologiaLavorazione.equals(other.tipologiaLavorazione))
			return false;
		if (tipologiaRichiesta == null) {
			if (other.tipologiaRichiesta != null)
				return false;
		} else if (!tipologiaRichiesta.equals(other.tipologiaRichiesta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RichiesteAssetOutputBean [codificaOAO=" + codificaOAO + ", dataInvio=" + dataInvio + ", idRisorsa="
				+ idRisorsa + ", tipologiaRichiesta=" + tipologiaRichiesta + ", tipologiaLavorazione="
				+ tipologiaLavorazione + ", offerta=" + offerta + ", statoOao=" + statoOao + ", descrizioneCausale="
				+ descrizioneCausale + "]";
	}


	
}
