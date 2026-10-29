package com.nttdata.tim.now.data.dto.lan;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class CodiceVlanSVlanOutputDTO implements Serializable {

	private static final long serialVersionUID = 2016424194147037965L;

	@JsonProperty("codicevlan")
	private String codicevlan;

	@JsonProperty("tipobanda")
	private String tipobanda;

	@JsonProperty("tipocos")
	private String tipocos;

	@JsonProperty("tipologia")
	private String tipologia;

	@JsonProperty("stato")
	private String stato;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("clli")
	private String clli;

	@JsonProperty("nomecentrale")
	private String nomecentrale;

	@JsonProperty("codicekit")
	private String codicekit;

	@JsonProperty("codiceareadiraccolta")
	private String codiceareadiraccolta;

	@JsonProperty("descareadiraccolta")
	private String descareadiraccolta;

	@JsonProperty("codicemacroarea")
	private String codicemacroarea;

	@JsonProperty("codicesupermacroarea")
	private String codicesupermacroarea;

	@JsonProperty("tipotrasporto")
	private String tipotrasporto;

	@JsonProperty("idvlanolo")
	private String idvlanolo;

	@JsonProperty("descmacroarea")
	private String descmacroarea;

	@JsonProperty("descsupermacroarea")
	private String descsupermacroarea;

	@JsonProperty("dslamType")
	private String dslamType;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dec")
	private Date dec;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("decattivazione")
	private Date decattivazione;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataconsegnaolo")
	private Date dataconsegnaolo;

	@JsonProperty("flagencapsulation")
	private String flagencapsulation;

	@JsonProperty("flagvlantranslation")
	private String flagvlantranslation;

	@JsonProperty("operatoreRete")
	private String operatoreRete;
	
	//RU_963
	@JsonProperty("tipologiaClusterComune")
	private String tipologiaClusterComune;
	
	@JsonProperty("flagFtthOnly")
	private String flagFtthOnly;

	public String getCodicevlan() {
		return codicevlan;
	}

	public void setCodicevlan(String codicevlan) {
		this.codicevlan = codicevlan;
	}

	public String getTipobanda() {
		return tipobanda;
	}

	public void setTipobanda(String tipobanda) {
		this.tipobanda = tipobanda;
	}

	public String getTipocos() {
		return tipocos;
	}

	public void setTipocos(String tipocos) {
		this.tipocos = tipocos;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getNomecentrale() {
		return nomecentrale;
	}

	public void setNomecentrale(String nomecentrale) {
		this.nomecentrale = nomecentrale;
	}

	public String getCodicekit() {
		return codicekit;
	}

	public void setCodicekit(String codicekit) {
		this.codicekit = codicekit;
	}

	public String getCodiceareadiraccolta() {
		return codiceareadiraccolta;
	}

	public void setCodiceareadiraccolta(String codiceareadiraccolta) {
		this.codiceareadiraccolta = codiceareadiraccolta;
	}

	public String getDescareadiraccolta() {
		return descareadiraccolta;
	}

	public void setDescareadiraccolta(String descareadiraccolta) {
		this.descareadiraccolta = descareadiraccolta;
	}

	public String getCodicemacroarea() {
		return codicemacroarea;
	}

	public void setCodicemacroarea(String codicemacroarea) {
		this.codicemacroarea = codicemacroarea;
	}

	public String getCodicesupermacroarea() {
		return codicesupermacroarea;
	}

	public void setCodicesupermacroarea(String codicesupermacroarea) {
		this.codicesupermacroarea = codicesupermacroarea;
	}

	public String getTipotrasporto() {
		return tipotrasporto;
	}

	public void setTipotrasporto(String tipotrasporto) {
		this.tipotrasporto = tipotrasporto;
	}

	public String getIdvlanolo() {
		return idvlanolo;
	}

	public void setIdvlanolo(String idvlanolo) {
		this.idvlanolo = idvlanolo;
	}

	public String getDescmacroarea() {
		return descmacroarea;
	}

	public void setDescmacroarea(String descmacroarea) {
		this.descmacroarea = descmacroarea;
	}

	public String getDescsupermacroarea() {
		return descsupermacroarea;
	}

	public void setDescsupermacroarea(String descsupermacroarea) {
		this.descsupermacroarea = descsupermacroarea;
	}

	public String getDslamType() {
		return dslamType;
	}

	public void setDslamType(String dslamType) {
		this.dslamType = dslamType;
	}

	public Date getDec() {
		return dec;
	}

	public void setDec(Date dec) {
		this.dec = dec;
	}

	public Date getDecattivazione() {
		return decattivazione;
	}

	public void setDecattivazione(Date decattivazione) {
		this.decattivazione = decattivazione;
	}

	public Date getDataconsegnaolo() {
		return dataconsegnaolo;
	}

	public void setDataconsegnaolo(Date dataconsegnaolo) {
		this.dataconsegnaolo = dataconsegnaolo;
	}

	public String getFlagencapsulation() {
		return flagencapsulation;
	}

	public void setFlagencapsulation(String flagencapsulation) {
		this.flagencapsulation = flagencapsulation;
	}

	public String getFlagvlantranslation() {
		return flagvlantranslation;
	}

	public void setFlagvlantranslation(String flagvlantranslation) {
		this.flagvlantranslation = flagvlantranslation;
	}

	public String getOperatoreRete() {
		return operatoreRete;
	}

	public void setOperatoreRete(String operatoreRete) {
		this.operatoreRete = operatoreRete;
	}

	public String getTipologiaClusterComune() {
		return tipologiaClusterComune;
	}

	public void setTipologiaClusterComune(String tipologiaClusterComune) {
		this.tipologiaClusterComune = tipologiaClusterComune;
	}

	public String getFlagFtthOnly() {
		return flagFtthOnly;
	}

	public void setFlagFtthOnly(String flagFtthOnly) {
		this.flagFtthOnly = flagFtthOnly;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clli == null) ? 0 : clli.hashCode());
		result = prime * result + ((codiceareadiraccolta == null) ? 0 : codiceareadiraccolta.hashCode());
		result = prime * result + ((codicekit == null) ? 0 : codicekit.hashCode());
		result = prime * result + ((codicemacroarea == null) ? 0 : codicemacroarea.hashCode());
		result = prime * result + ((codicesupermacroarea == null) ? 0 : codicesupermacroarea.hashCode());
		result = prime * result + ((codicevlan == null) ? 0 : codicevlan.hashCode());
		result = prime * result + ((dataconsegnaolo == null) ? 0 : dataconsegnaolo.hashCode());
		result = prime * result + ((dec == null) ? 0 : dec.hashCode());
		result = prime * result + ((decattivazione == null) ? 0 : decattivazione.hashCode());
		result = prime * result + ((descareadiraccolta == null) ? 0 : descareadiraccolta.hashCode());
		result = prime * result + ((descmacroarea == null) ? 0 : descmacroarea.hashCode());
		result = prime * result + ((descsupermacroarea == null) ? 0 : descsupermacroarea.hashCode());
		result = prime * result + ((dslamType == null) ? 0 : dslamType.hashCode());
		result = prime * result + ((flagFtthOnly == null) ? 0 : flagFtthOnly.hashCode());
		result = prime * result + ((flagencapsulation == null) ? 0 : flagencapsulation.hashCode());
		result = prime * result + ((flagvlantranslation == null) ? 0 : flagvlantranslation.hashCode());
		result = prime * result + ((idvlanolo == null) ? 0 : idvlanolo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomecentrale == null) ? 0 : nomecentrale.hashCode());
		result = prime * result + ((operatoreRete == null) ? 0 : operatoreRete.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((tipobanda == null) ? 0 : tipobanda.hashCode());
		result = prime * result + ((tipocos == null) ? 0 : tipocos.hashCode());
		result = prime * result + ((tipologia == null) ? 0 : tipologia.hashCode());
		result = prime * result + ((tipologiaClusterComune == null) ? 0 : tipologiaClusterComune.hashCode());
		result = prime * result + ((tipotrasporto == null) ? 0 : tipotrasporto.hashCode());
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
		CodiceVlanSVlanOutputDTO other = (CodiceVlanSVlanOutputDTO) obj;
		if (clli == null) {
			if (other.clli != null)
				return false;
		} else if (!clli.equals(other.clli))
			return false;
		if (codiceareadiraccolta == null) {
			if (other.codiceareadiraccolta != null)
				return false;
		} else if (!codiceareadiraccolta.equals(other.codiceareadiraccolta))
			return false;
		if (codicekit == null) {
			if (other.codicekit != null)
				return false;
		} else if (!codicekit.equals(other.codicekit))
			return false;
		if (codicemacroarea == null) {
			if (other.codicemacroarea != null)
				return false;
		} else if (!codicemacroarea.equals(other.codicemacroarea))
			return false;
		if (codicesupermacroarea == null) {
			if (other.codicesupermacroarea != null)
				return false;
		} else if (!codicesupermacroarea.equals(other.codicesupermacroarea))
			return false;
		if (codicevlan == null) {
			if (other.codicevlan != null)
				return false;
		} else if (!codicevlan.equals(other.codicevlan))
			return false;
		if (dataconsegnaolo == null) {
			if (other.dataconsegnaolo != null)
				return false;
		} else if (!dataconsegnaolo.equals(other.dataconsegnaolo))
			return false;
		if (dec == null) {
			if (other.dec != null)
				return false;
		} else if (!dec.equals(other.dec))
			return false;
		if (decattivazione == null) {
			if (other.decattivazione != null)
				return false;
		} else if (!decattivazione.equals(other.decattivazione))
			return false;
		if (descareadiraccolta == null) {
			if (other.descareadiraccolta != null)
				return false;
		} else if (!descareadiraccolta.equals(other.descareadiraccolta))
			return false;
		if (descmacroarea == null) {
			if (other.descmacroarea != null)
				return false;
		} else if (!descmacroarea.equals(other.descmacroarea))
			return false;
		if (descsupermacroarea == null) {
			if (other.descsupermacroarea != null)
				return false;
		} else if (!descsupermacroarea.equals(other.descsupermacroarea))
			return false;
		if (dslamType == null) {
			if (other.dslamType != null)
				return false;
		} else if (!dslamType.equals(other.dslamType))
			return false;
		if (flagFtthOnly == null) {
			if (other.flagFtthOnly != null)
				return false;
		} else if (!flagFtthOnly.equals(other.flagFtthOnly))
			return false;
		if (flagencapsulation == null) {
			if (other.flagencapsulation != null)
				return false;
		} else if (!flagencapsulation.equals(other.flagencapsulation))
			return false;
		if (flagvlantranslation == null) {
			if (other.flagvlantranslation != null)
				return false;
		} else if (!flagvlantranslation.equals(other.flagvlantranslation))
			return false;
		if (idvlanolo == null) {
			if (other.idvlanolo != null)
				return false;
		} else if (!idvlanolo.equals(other.idvlanolo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomecentrale == null) {
			if (other.nomecentrale != null)
				return false;
		} else if (!nomecentrale.equals(other.nomecentrale))
			return false;
		if (operatoreRete == null) {
			if (other.operatoreRete != null)
				return false;
		} else if (!operatoreRete.equals(other.operatoreRete))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (tipobanda == null) {
			if (other.tipobanda != null)
				return false;
		} else if (!tipobanda.equals(other.tipobanda))
			return false;
		if (tipocos == null) {
			if (other.tipocos != null)
				return false;
		} else if (!tipocos.equals(other.tipocos))
			return false;
		if (tipologia == null) {
			if (other.tipologia != null)
				return false;
		} else if (!tipologia.equals(other.tipologia))
			return false;
		if (tipologiaClusterComune == null) {
			if (other.tipologiaClusterComune != null)
				return false;
		} else if (!tipologiaClusterComune.equals(other.tipologiaClusterComune))
			return false;
		if (tipotrasporto == null) {
			if (other.tipotrasporto != null)
				return false;
		} else if (!tipotrasporto.equals(other.tipotrasporto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CodiceVlanSVlanOutputDTO [codicevlan=" + codicevlan + ", tipobanda=" + tipobanda + ", tipocos="
				+ tipocos + ", tipologia=" + tipologia + ", stato=" + stato + ", nome=" + nome + ", clli=" + clli
				+ ", nomecentrale=" + nomecentrale + ", codicekit=" + codicekit + ", codiceareadiraccolta="
				+ codiceareadiraccolta + ", descareadiraccolta=" + descareadiraccolta + ", codicemacroarea="
				+ codicemacroarea + ", codicesupermacroarea=" + codicesupermacroarea + ", tipotrasporto="
				+ tipotrasporto + ", idvlanolo=" + idvlanolo + ", descmacroarea=" + descmacroarea
				+ ", descsupermacroarea=" + descsupermacroarea + ", dslamType=" + dslamType + ", dec=" + dec
				+ ", decattivazione=" + decattivazione + ", dataconsegnaolo=" + dataconsegnaolo + ", flagencapsulation="
				+ flagencapsulation + ", flagvlantranslation=" + flagvlantranslation + ", operatoreRete="
				+ operatoreRete + ", tipologiaClusterComune=" + tipologiaClusterComune + ", flagFtthOnly="
				+ flagFtthOnly + "]";
	}
	

}
