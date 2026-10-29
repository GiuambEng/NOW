package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL) 
public class RecuperoDettaglioContrattoOutputItemBean implements Serializable {

	private static final long serialVersionUID = -7065527760636845772L;

	@JsonProperty("flagAbilitato")
	private String flagAbilitato;
	
	@JsonProperty("flagFileNotify")
	private String flagFileNotify;
	
	@JsonProperty("flagValido")
	private String flagValido;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioValiditaContratto")
	private String dataInizioValiditaContratto;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineValiditaContratto")
	private String dataFineValiditaContratto;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioAssociazioneOffertaContratto")
	private String dataInizioAssociazioneOffertaContratto;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineAssociazioneOffertaContratto")
	private String dataFineAssociazioneOffertaContratto;

	@JsonProperty("idContrattoOffertaCatalogo")
	private String idContrattoOffertaCatalogo;
	
	@JsonProperty("codiceContratto")
	private String codiceContratto;
	
	@JsonProperty("codiceOloNumerico")
	private String codiceOloNumerico;
	
	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonProperty("nomeContratto")
	private String nomeContratto;

	@JsonProperty("tipoServizio")
	private String tipoServizio;
	
	@JsonProperty("offerta")
	private String offerta;
	
	@JsonProperty("tipoContratto")
	private String tipoContratto;
	
	@JsonProperty("tipoProdotti")
	private String tipoProdotti;
	
	//SM_9996
	@JsonProperty("contrattoFwaInfratel")
	private String contrattoFwaInfratel;
	
	@JsonProperty("contrattoFwaPlus")
	private String contrattoFwaPlus;
	
	@JsonProperty("contrattoFwaDecommissioning")
	private String contrattoFwaDecommissioning;
	
	//RU_1164
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioCoinvestimento")
	private String dataInizioCoinvestimento;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineCoinvestimento")
	private String dataFineCoinvestimento;
	
	//RU_1180
	@JsonProperty("flagMulticast")
	private String flagMulticast;
	
	//SM_11396
    @JsonProperty("emailOffertaFwa1GigaSardegna")
    private String emailOffertaFwa1GigaSardegna;
	
	@JsonProperty("listaFileCsv")
	private List<FileMulticastSimpleOutputBean> listaFileCsv;
	
	@JsonProperty("bouquet")
	private String bouquet;
	
	//SM_10292
	@JsonProperty("datiSospensioneServizio")
	private DatiSospensioneServizioOutputBean datiSospensioneServizio;

	public String getFlagAbilitato() {
		return flagAbilitato;
	}

	public void setFlagAbilitato(String flagAbilitato) {
		this.flagAbilitato = flagAbilitato;
	}

	public String getFlagFileNotify() {
		return flagFileNotify;
	}

	public void setFlagFileNotify(String flagFileNotify) {
		this.flagFileNotify = flagFileNotify;
	}

	public String getFlagValido() {
		return flagValido;
	}

	public void setFlagValido(String flagValido) {
		this.flagValido = flagValido;
	}

	public String getDataInizioValiditaContratto() {
		return dataInizioValiditaContratto;
	}

	public void setDataInizioValiditaContratto(String dataInizioValiditaContratto) {
		this.dataInizioValiditaContratto = dataInizioValiditaContratto;
	}

	public String getDataFineValiditaContratto() {
		return dataFineValiditaContratto;
	}

	public void setDataFineValiditaContratto(String dataFineValiditaContratto) {
		this.dataFineValiditaContratto = dataFineValiditaContratto;
	}

	public String getDataInizioAssociazioneOffertaContratto() {
		return dataInizioAssociazioneOffertaContratto;
	}

	public void setDataInizioAssociazioneOffertaContratto(String dataInizioAssociazioneOffertaContratto) {
		this.dataInizioAssociazioneOffertaContratto = dataInizioAssociazioneOffertaContratto;
	}

	public String getDataFineAssociazioneOffertaContratto() {
		return dataFineAssociazioneOffertaContratto;
	}

	public void setDataFineAssociazioneOffertaContratto(String dataFineAssociazioneOffertaContratto) {
		this.dataFineAssociazioneOffertaContratto = dataFineAssociazioneOffertaContratto;
	}

	public String getIdContrattoOffertaCatalogo() {
		return idContrattoOffertaCatalogo;
	}

	public void setIdContrattoOffertaCatalogo(String idContrattoOffertaCatalogo) {
		this.idContrattoOffertaCatalogo = idContrattoOffertaCatalogo;
	}

	public String getCodiceContratto() {
		return codiceContratto;
	}

	public void setCodiceContratto(String codiceContratto) {
		this.codiceContratto = codiceContratto;
	}

	public String getCodiceOloNumerico() {
		return codiceOloNumerico;
	}

	public void setCodiceOloNumerico(String codiceOloNumerico) {
		this.codiceOloNumerico = codiceOloNumerico;
	}

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getNomeContratto() {
		return nomeContratto;
	}

	public void setNomeContratto(String nomeContratto) {
		this.nomeContratto = nomeContratto;
	}

	public String getTipoServizio() {
		return tipoServizio;
	}

	public void setTipoServizio(String tipoServizio) {
		this.tipoServizio = tipoServizio;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getTipoContratto() {
		return tipoContratto;
	}

	public void setTipoContratto(String tipoContratto) {
		this.tipoContratto = tipoContratto;
	}

	public String getTipoProdotti() {
		return tipoProdotti;
	}

	public void setTipoProdotti(String tipoProdotti) {
		this.tipoProdotti = tipoProdotti;
	}

	public String getContrattoFwaInfratel() {
		return contrattoFwaInfratel;
	}

	public String getContrattoFwaPlus() {
		return contrattoFwaPlus;
	}

	public String getContrattoFwaDecommissioning() {
		return contrattoFwaDecommissioning;
	}

	public void setContrattoFwaInfratel(String contrattoFwaInfratel) {
		this.contrattoFwaInfratel = contrattoFwaInfratel;
	}

	public void setContrattoFwaPlus(String contrattoFwaPlus) {
		this.contrattoFwaPlus = contrattoFwaPlus;
	}

	public void setContrattoFwaDecommissioning(String contrattoFwaDecommissioning) {
		this.contrattoFwaDecommissioning = contrattoFwaDecommissioning;
	}

	public String getDataInizioCoinvestimento() {
		return dataInizioCoinvestimento;
	}

	public String getDataFineCoinvestimento() {
		return dataFineCoinvestimento;
	}

	public void setDataInizioCoinvestimento(String dataInizioCoinvestimento) {
		this.dataInizioCoinvestimento = dataInizioCoinvestimento;
	}

	public void setDataFineCoinvestimento(String dataFineCoinvestimento) {
		this.dataFineCoinvestimento = dataFineCoinvestimento;
	}

	public String getFlagMulticast() {
		return flagMulticast;
	}

	public void setFlagMulticast(String flagMulticast) {
		this.flagMulticast = flagMulticast;
	}

	public List<FileMulticastSimpleOutputBean> getListaFileCsv() {
		return listaFileCsv;
	}

	public void setListaFileCsv(List<FileMulticastSimpleOutputBean> listaFileCsv) {
		this.listaFileCsv = listaFileCsv;
	}

	public String getBouquet() {
		return bouquet;
	}

	public void setBouquet(String bouquet) {
		this.bouquet = bouquet;
	}

	public DatiSospensioneServizioOutputBean getDatiSospensioneServizio() {
		return datiSospensioneServizio;
	}

	public void setDatiSospensioneServizio(DatiSospensioneServizioOutputBean datiSospensioneServizio) {
		this.datiSospensioneServizio = datiSospensioneServizio;
	}

	public String getEmailOffertaFwa1GigaSardegna() {
		return emailOffertaFwa1GigaSardegna;
	}

	public void setEmailOffertaFwa1GigaSardegna(String emailOffertaFwa1GigaSardegna) {
		this.emailOffertaFwa1GigaSardegna = emailOffertaFwa1GigaSardegna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bouquet == null) ? 0 : bouquet.hashCode());
		result = prime * result + ((codiceContratto == null) ? 0 : codiceContratto.hashCode());
		result = prime * result + ((codiceOloNumerico == null) ? 0 : codiceOloNumerico.hashCode());
		result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
		result = prime * result + ((contrattoFwaDecommissioning == null) ? 0 : contrattoFwaDecommissioning.hashCode());
		result = prime * result + ((contrattoFwaInfratel == null) ? 0 : contrattoFwaInfratel.hashCode());
		result = prime * result + ((contrattoFwaPlus == null) ? 0 : contrattoFwaPlus.hashCode());
		result = prime * result + ((dataFineAssociazioneOffertaContratto == null) ? 0
				: dataFineAssociazioneOffertaContratto.hashCode());
		result = prime * result + ((dataFineCoinvestimento == null) ? 0 : dataFineCoinvestimento.hashCode());
		result = prime * result + ((dataFineValiditaContratto == null) ? 0 : dataFineValiditaContratto.hashCode());
		result = prime * result + ((dataInizioAssociazioneOffertaContratto == null) ? 0
				: dataInizioAssociazioneOffertaContratto.hashCode());
		result = prime * result + ((dataInizioCoinvestimento == null) ? 0 : dataInizioCoinvestimento.hashCode());
		result = prime * result + ((dataInizioValiditaContratto == null) ? 0 : dataInizioValiditaContratto.hashCode());
		result = prime * result + ((datiSospensioneServizio == null) ? 0 : datiSospensioneServizio.hashCode());
		result = prime * result + ((flagAbilitato == null) ? 0 : flagAbilitato.hashCode());
		result = prime * result + ((flagFileNotify == null) ? 0 : flagFileNotify.hashCode());
		result = prime * result + ((flagMulticast == null) ? 0 : flagMulticast.hashCode());
		result = prime * result + ((flagValido == null) ? 0 : flagValido.hashCode());
		result = prime * result + ((idContrattoOffertaCatalogo == null) ? 0 : idContrattoOffertaCatalogo.hashCode());
		result = prime * result + ((listaFileCsv == null) ? 0 : listaFileCsv.hashCode());
		result = prime * result + ((nomeContratto == null) ? 0 : nomeContratto.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((tipoContratto == null) ? 0 : tipoContratto.hashCode());
		result = prime * result + ((tipoProdotti == null) ? 0 : tipoProdotti.hashCode());
		result = prime * result + ((tipoServizio == null) ? 0 : tipoServizio.hashCode());
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
		RecuperoDettaglioContrattoOutputItemBean other = (RecuperoDettaglioContrattoOutputItemBean) obj;
		if (bouquet == null) {
			if (other.bouquet != null)
				return false;
		} else if (!bouquet.equals(other.bouquet))
			return false;
		if (codiceContratto == null) {
			if (other.codiceContratto != null)
				return false;
		} else if (!codiceContratto.equals(other.codiceContratto))
			return false;
		if (codiceOloNumerico == null) {
			if (other.codiceOloNumerico != null)
				return false;
		} else if (!codiceOloNumerico.equals(other.codiceOloNumerico))
			return false;
		if (codificaOloAgcom == null) {
			if (other.codificaOloAgcom != null)
				return false;
		} else if (!codificaOloAgcom.equals(other.codificaOloAgcom))
			return false;
		if (contrattoFwaDecommissioning == null) {
			if (other.contrattoFwaDecommissioning != null)
				return false;
		} else if (!contrattoFwaDecommissioning.equals(other.contrattoFwaDecommissioning))
			return false;
		if (contrattoFwaInfratel == null) {
			if (other.contrattoFwaInfratel != null)
				return false;
		} else if (!contrattoFwaInfratel.equals(other.contrattoFwaInfratel))
			return false;
		if (contrattoFwaPlus == null) {
			if (other.contrattoFwaPlus != null)
				return false;
		} else if (!contrattoFwaPlus.equals(other.contrattoFwaPlus))
			return false;
		if (dataFineAssociazioneOffertaContratto == null) {
			if (other.dataFineAssociazioneOffertaContratto != null)
				return false;
		} else if (!dataFineAssociazioneOffertaContratto.equals(other.dataFineAssociazioneOffertaContratto))
			return false;
		if (dataFineCoinvestimento == null) {
			if (other.dataFineCoinvestimento != null)
				return false;
		} else if (!dataFineCoinvestimento.equals(other.dataFineCoinvestimento))
			return false;
		if (dataFineValiditaContratto == null) {
			if (other.dataFineValiditaContratto != null)
				return false;
		} else if (!dataFineValiditaContratto.equals(other.dataFineValiditaContratto))
			return false;
		if (dataInizioAssociazioneOffertaContratto == null) {
			if (other.dataInizioAssociazioneOffertaContratto != null)
				return false;
		} else if (!dataInizioAssociazioneOffertaContratto.equals(other.dataInizioAssociazioneOffertaContratto))
			return false;
		if (dataInizioCoinvestimento == null) {
			if (other.dataInizioCoinvestimento != null)
				return false;
		} else if (!dataInizioCoinvestimento.equals(other.dataInizioCoinvestimento))
			return false;
		if (dataInizioValiditaContratto == null) {
			if (other.dataInizioValiditaContratto != null)
				return false;
		} else if (!dataInizioValiditaContratto.equals(other.dataInizioValiditaContratto))
			return false;
		if (datiSospensioneServizio == null) {
			if (other.datiSospensioneServizio != null)
				return false;
		} else if (!datiSospensioneServizio.equals(other.datiSospensioneServizio))
			return false;
		if (flagAbilitato == null) {
			if (other.flagAbilitato != null)
				return false;
		} else if (!flagAbilitato.equals(other.flagAbilitato))
			return false;
		if (flagFileNotify == null) {
			if (other.flagFileNotify != null)
				return false;
		} else if (!flagFileNotify.equals(other.flagFileNotify))
			return false;
		if (flagMulticast == null) {
			if (other.flagMulticast != null)
				return false;
		} else if (!flagMulticast.equals(other.flagMulticast))
			return false;
		if (flagValido == null) {
			if (other.flagValido != null)
				return false;
		} else if (!flagValido.equals(other.flagValido))
			return false;
		if (idContrattoOffertaCatalogo == null) {
			if (other.idContrattoOffertaCatalogo != null)
				return false;
		} else if (!idContrattoOffertaCatalogo.equals(other.idContrattoOffertaCatalogo))
			return false;
		if (listaFileCsv == null) {
			if (other.listaFileCsv != null)
				return false;
		} else if (!listaFileCsv.equals(other.listaFileCsv))
			return false;
		if (nomeContratto == null) {
			if (other.nomeContratto != null)
				return false;
		} else if (!nomeContratto.equals(other.nomeContratto))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (tipoContratto == null) {
			if (other.tipoContratto != null)
				return false;
		} else if (!tipoContratto.equals(other.tipoContratto))
			return false;
		if (tipoProdotti == null) {
			if (other.tipoProdotti != null)
				return false;
		} else if (!tipoProdotti.equals(other.tipoProdotti))
			return false;
		if (tipoServizio == null) {
			if (other.tipoServizio != null)
				return false;
		} else if (!tipoServizio.equals(other.tipoServizio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecuperoDettaglioContrattoOutputItemBean [flagAbilitato=" + flagAbilitato + ", flagFileNotify="
				+ flagFileNotify + ", flagValido=" + flagValido + ", dataInizioValiditaContratto="
				+ dataInizioValiditaContratto + ", dataFineValiditaContratto=" + dataFineValiditaContratto
				+ ", dataInizioAssociazioneOffertaContratto=" + dataInizioAssociazioneOffertaContratto
				+ ", dataFineAssociazioneOffertaContratto=" + dataFineAssociazioneOffertaContratto
				+ ", idContrattoOffertaCatalogo=" + idContrattoOffertaCatalogo + ", codiceContratto=" + codiceContratto
				+ ", codiceOloNumerico=" + codiceOloNumerico + ", codificaOloAgcom=" + codificaOloAgcom
				+ ", nomeContratto=" + nomeContratto + ", tipoServizio=" + tipoServizio + ", offerta=" + offerta
				+ ", tipoContratto=" + tipoContratto + ", tipoProdotti=" + tipoProdotti + ", contrattoFwaInfratel="
				+ contrattoFwaInfratel + ", contrattoFwaPlus=" + contrattoFwaPlus + ", contrattoFwaDecommissioning="
				+ contrattoFwaDecommissioning + ", dataInizioCoinvestimento=" + dataInizioCoinvestimento
				+ ", dataFineCoinvestimento=" + dataFineCoinvestimento + ", flagMulticast=" + flagMulticast
				+ ", listaFileCsv=" + listaFileCsv + ", bouquet=" + bouquet + ", datiSospensioneServizio="
				+ datiSospensioneServizio + "]";
	}
}
