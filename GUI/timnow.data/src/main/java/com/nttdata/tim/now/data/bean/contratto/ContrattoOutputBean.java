package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;
import com.nttdata.tim.now.data.bean.oao.OaoBean;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class ContrattoOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 8845692016419690583L;

    @JsonProperty("idContratto")
	private int idContratto;

	@JsonProperty("codiceContratto")
	private String codiceContratto;

	@JsonProperty("codificaOAO")
	private String codificaOAO;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("tipo")
	private String tipo;

	@JsonProperty("tipoServizio")
	private String idTipoServizio;

	@JsonProperty("stato")
	private String stato;

	@JsonProperty("tipoProdotti")
	private String tipoProdotti;

	@JsonProperty("idContrattoPadre")
	private String idContrattoPadre;

	@JsonProperty("statoStandard")
	private String statoStandard;

	@JsonProperty("identificativoContrattoCRMW")
	private String identificativoContrattoCRMW;

	@JsonProperty("nomeStandard")
	private String nomeStandard;

	@JsonProperty("tipologiaContratto")
	private String identificativoTipologiaContratto;

	@JsonProperty("tipoContratto")
	private String tipoContratto;

	@JsonProperty("flagNPD")
	private boolean flagNPD;

	@JsonProperty("flagAbilitato")
	private boolean flagAbilitato;

	@JsonProperty("flagValido")
	private boolean flagValido;

	@JsonProperty("flagStandard")
	private boolean flagStandard;

	@JsonProperty("flagFileNotify")
	private boolean flagFileNotify;

	@JsonProperty("flagDiffidato")
	private boolean flagDiffidato;

	@JsonProperty("flagAnfibio")
	private boolean flagAnfibio;

	@JsonProperty("oao")
	private OaoBean oao;
	
	@JsonProperty("idSistemaCompetente")
	private String idSistemaCompetente;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizio")
	private Date dataInizio;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFine")
	private Date dataFine;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataUltimoAggiornamento")
	private Date dataUltimoAggiornamento;

	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInserimento")
	private Date dataInserimento;

	@JsonProperty("codOlo")
	private String codOlo;

	@JsonProperty("idFamigliaOfferta")
	private String idFamigliaOfferta;

	@JsonProperty("idSottofamigliaOfferta")
	private String idSottofamigliaOfferta;

	@JsonProperty("idStatoContratto")
	private String idStatoContratto;

	@JsonProperty("operatoreRete")
	private String operatoreRete;

	@JsonProperty("idOperatoreRete")
	private String idOperatoreRete;
	
	//SM_9996
	@JsonProperty("contrattoFwaDecommissioning")
	private String contrattoFwaDecommissioning;
	
	@JsonProperty("contrattoFwaPlus")
	private String contrattoFwaPlus;
	
	@JsonProperty("contrattoFwaInfratel")
	private String contrattoFwaInfratel;
	
	//RU_1164
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInizioCoinvestimento")
	private Date dataInizioCoinvestimento;
	
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataFineCoinvestimento")
	private Date dataFineCoinvestimento;
	
	//RU_1202
	@JsonProperty("datiMulticast")
	private DatiMulticastOutputBean datiMulticast;
	
	@JsonProperty("bouquet")
	private String bouquet;
	
	@JsonProperty("flagMulticast")
	private boolean flagMulticast;
	
	//Task #36401
	@JsonProperty("datiSospensioneServizio")
	private DatiSospensioneServizioOutputBean datiSospensioneServizio;
	
	@JsonProperty("idOfferta")
	private String idOfferta;
	
	@JsonProperty("offerta")
	private String offerta;
	
	//SM_11396
    @JsonProperty("emailOffertaFwa1GigaSardegna")
    private String emailOffertaFwa1GigaSardegna;

	public int getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(int idContratto) {
		this.idContratto = idContratto;
	}

	public String getCodiceContratto() {
		return codiceContratto;
	}

	public void setCodiceContratto(String codiceContratto) {
		this.codiceContratto = codiceContratto;
	}

	public String getCodificaOAO() {
		return codificaOAO;
	}

	public void setCodificaOAO(String codificaOAO) {
		this.codificaOAO = codificaOAO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIdTipoServizio() {
		return idTipoServizio;
	}

	public void setIdTipoServizio(String idTipoServizio) {
		this.idTipoServizio = idTipoServizio;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getTipoProdotti() {
		return tipoProdotti;
	}

	public void setTipoProdotti(String tipoProdotti) {
		this.tipoProdotti = tipoProdotti;
	}

	public String getIdContrattoPadre() {
		return idContrattoPadre;
	}

	public void setIdContrattoPadre(String idContrattoPadre) {
		this.idContrattoPadre = idContrattoPadre;
	}

	public String getStatoStandard() {
		return statoStandard;
	}

	public void setStatoStandard(String statoStandard) {
		this.statoStandard = statoStandard;
	}

	public String getIdentificativoContrattoCRMW() {
		return identificativoContrattoCRMW;
	}

	public void setIdentificativoContrattoCRMW(String identificativoContrattoCRMW) {
		this.identificativoContrattoCRMW = identificativoContrattoCRMW;
	}

	public String getNomeStandard() {
		return nomeStandard;
	}

	public void setNomeStandard(String nomeStandard) {
		this.nomeStandard = nomeStandard;
	}

	public String getIdentificativoTipologiaContratto() {
		return identificativoTipologiaContratto;
	}

	public void setIdentificativoTipologiaContratto(String identificativoTipologiaContratto) {
		this.identificativoTipologiaContratto = identificativoTipologiaContratto;
	}

	public String getTipoContratto() {
		return tipoContratto;
	}

	public void setTipoContratto(String tipoContratto) {
		this.tipoContratto = tipoContratto;
	}

	public boolean isFlagNPD() {
		return flagNPD;
	}

	public void setFlagNPD(boolean flagNPD) {
		this.flagNPD = flagNPD;
	}

	public boolean isFlagAbilitato() {
		return flagAbilitato;
	}

	public void setFlagAbilitato(boolean flagAbilitato) {
		this.flagAbilitato = flagAbilitato;
	}

	public boolean isFlagValido() {
		return flagValido;
	}

	public void setFlagValido(boolean flagValido) {
		this.flagValido = flagValido;
	}

	public boolean isFlagStandard() {
		return flagStandard;
	}

	public void setFlagStandard(boolean flagStandard) {
		this.flagStandard = flagStandard;
	}

	public boolean isFlagFileNotify() {
		return flagFileNotify;
	}

	public void setFlagFileNotify(boolean flagFileNotify) {
		this.flagFileNotify = flagFileNotify;
	}

	public boolean isFlagDiffidato() {
		return flagDiffidato;
	}

	public void setFlagDiffidato(boolean flagDiffidato) {
		this.flagDiffidato = flagDiffidato;
	}

	public boolean isFlagAnfibio() {
		return flagAnfibio;
	}

	public void setFlagAnfibio(boolean flagAnfibio) {
		this.flagAnfibio = flagAnfibio;
	}

	public OaoBean getOao() {
		return oao;
	}

	public void setOao(OaoBean oao) {
		this.oao = oao;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}

	public void setDataUltimoAggiornamento(Date dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getCodOlo() {
		return codOlo;
	}

	public void setCodOlo(String codOlo) {
		this.codOlo = codOlo;
	}

	public String getIdFamigliaOfferta() {
		return idFamigliaOfferta;
	}

	public void setIdFamigliaOfferta(String idFamigliaOfferta) {
		this.idFamigliaOfferta = idFamigliaOfferta;
	}

	public String getIdSottofamigliaOfferta() {
		return idSottofamigliaOfferta;
	}

	public void setIdSottofamigliaOfferta(String idSottofamigliaOfferta) {
		this.idSottofamigliaOfferta = idSottofamigliaOfferta;
	}

	public String getIdStatoContratto() {
		return idStatoContratto;
	}

	public void setIdStatoContratto(String idStatoContratto) {
		this.idStatoContratto = idStatoContratto;
	}

	public String getOperatoreRete() {
		return operatoreRete;
	}

	public void setOperatoreRete(String operatoreRete) {
		this.operatoreRete = operatoreRete;
	}

	public String getIdOperatoreRete() {
		return idOperatoreRete;
	}

	public void setIdOperatoreRete(String idOperatoreRete) {
		this.idOperatoreRete = idOperatoreRete;
	}
	
	public String getIdSistemaCompetente() {
		return idSistemaCompetente;
	}

	public void setIdSistemaCompetente(String idSistemaCompetente) {
		this.idSistemaCompetente = idSistemaCompetente;
	}

	public String getContrattoFwaDecommissioning() {
		return contrattoFwaDecommissioning;
	}

	public String getContrattoFwaPlus() {
		return contrattoFwaPlus;
	}

	public String getContrattoFwaInfratel() {
		return contrattoFwaInfratel;
	}

	public void setContrattoFwaDecommissioning(String contrattoFwaDecommissioning) {
		this.contrattoFwaDecommissioning = contrattoFwaDecommissioning;
	}

	public void setContrattoFwaPlus(String contrattoFwaPlus) {
		this.contrattoFwaPlus = contrattoFwaPlus;
	}

	public void setContrattoFwaInfratel(String contrattoFwaInfratel) {
		this.contrattoFwaInfratel = contrattoFwaInfratel;
	}

	public Date getDataInizioCoinvestimento() {
		return dataInizioCoinvestimento;
	}

	public Date getDataFineCoinvestimento() {
		return dataFineCoinvestimento;
	}

	public void setDataInizioCoinvestimento(Date dataInizioCoinvestimento) {
		this.dataInizioCoinvestimento = dataInizioCoinvestimento;
	}

	public void setDataFineCoinvestimento(Date dataFineCoinvestimento) {
		this.dataFineCoinvestimento = dataFineCoinvestimento;
	}

	public DatiMulticastOutputBean getDatiMulticast() {
		return datiMulticast;
	}

	public void setDatiMulticast(DatiMulticastOutputBean datiMulticast) {
		this.datiMulticast = datiMulticast;
	}

	public String getBouquet() {
		return bouquet;
	}

	public void setBouquet(String bouquet) {
		this.bouquet = bouquet;
	}

	public boolean isFlagMulticast() {
		return flagMulticast;
	}

	public void setFlagMulticast(boolean flagMulticast) {
		this.flagMulticast = flagMulticast;
	}

	public DatiSospensioneServizioOutputBean getDatiSospensioneServizio() {
		return datiSospensioneServizio;
	}

	public void setDatiSospensioneServizio(DatiSospensioneServizioOutputBean datiSospensioneServizio) {
		this.datiSospensioneServizio = datiSospensioneServizio;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
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
		result = prime * result + ((codOlo == null) ? 0 : codOlo.hashCode());
		result = prime * result + ((codiceContratto == null) ? 0 : codiceContratto.hashCode());
		result = prime * result + ((codificaOAO == null) ? 0 : codificaOAO.hashCode());
		result = prime * result + ((contrattoFwaDecommissioning == null) ? 0 : contrattoFwaDecommissioning.hashCode());
		result = prime * result + ((contrattoFwaInfratel == null) ? 0 : contrattoFwaInfratel.hashCode());
		result = prime * result + ((contrattoFwaPlus == null) ? 0 : contrattoFwaPlus.hashCode());
		result = prime * result + ((dataFine == null) ? 0 : dataFine.hashCode());
		result = prime * result + ((dataFineCoinvestimento == null) ? 0 : dataFineCoinvestimento.hashCode());
		result = prime * result + ((dataInizio == null) ? 0 : dataInizio.hashCode());
		result = prime * result + ((dataInizioCoinvestimento == null) ? 0 : dataInizioCoinvestimento.hashCode());
		result = prime * result + ((dataInserimento == null) ? 0 : dataInserimento.hashCode());
		result = prime * result + ((dataUltimoAggiornamento == null) ? 0 : dataUltimoAggiornamento.hashCode());
		result = prime * result + ((datiMulticast == null) ? 0 : datiMulticast.hashCode());
		result = prime * result + ((datiSospensioneServizio == null) ? 0 : datiSospensioneServizio.hashCode());
		result = prime * result + (flagAbilitato ? 1231 : 1237);
		result = prime * result + (flagAnfibio ? 1231 : 1237);
		result = prime * result + (flagDiffidato ? 1231 : 1237);
		result = prime * result + (flagFileNotify ? 1231 : 1237);
		result = prime * result + (flagMulticast ? 1231 : 1237);
		result = prime * result + (flagNPD ? 1231 : 1237);
		result = prime * result + (flagStandard ? 1231 : 1237);
		result = prime * result + (flagValido ? 1231 : 1237);
		result = prime * result + idContratto;
		result = prime * result + ((idContrattoPadre == null) ? 0 : idContrattoPadre.hashCode());
		result = prime * result + ((idFamigliaOfferta == null) ? 0 : idFamigliaOfferta.hashCode());
		result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime * result + ((idOperatoreRete == null) ? 0 : idOperatoreRete.hashCode());
		result = prime * result + ((idSistemaCompetente == null) ? 0 : idSistemaCompetente.hashCode());
		result = prime * result + ((idSottofamigliaOfferta == null) ? 0 : idSottofamigliaOfferta.hashCode());
		result = prime * result + ((idStatoContratto == null) ? 0 : idStatoContratto.hashCode());
		result = prime * result + ((idTipoServizio == null) ? 0 : idTipoServizio.hashCode());
		result = prime * result + ((identificativoContrattoCRMW == null) ? 0 : identificativoContrattoCRMW.hashCode());
		result = prime * result
				+ ((identificativoTipologiaContratto == null) ? 0 : identificativoTipologiaContratto.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeStandard == null) ? 0 : nomeStandard.hashCode());
		result = prime * result + ((oao == null) ? 0 : oao.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + ((operatoreRete == null) ? 0 : operatoreRete.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((statoStandard == null) ? 0 : statoStandard.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((tipoContratto == null) ? 0 : tipoContratto.hashCode());
		result = prime * result + ((tipoProdotti == null) ? 0 : tipoProdotti.hashCode());
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
		ContrattoOutputBean other = (ContrattoOutputBean) obj;
		if (bouquet == null) {
			if (other.bouquet != null)
				return false;
		} else if (!bouquet.equals(other.bouquet))
			return false;
		if (codOlo == null) {
			if (other.codOlo != null)
				return false;
		} else if (!codOlo.equals(other.codOlo))
			return false;
		if (codiceContratto == null) {
			if (other.codiceContratto != null)
				return false;
		} else if (!codiceContratto.equals(other.codiceContratto))
			return false;
		if (codificaOAO == null) {
			if (other.codificaOAO != null)
				return false;
		} else if (!codificaOAO.equals(other.codificaOAO))
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
		if (dataFine == null) {
			if (other.dataFine != null)
				return false;
		} else if (!dataFine.equals(other.dataFine))
			return false;
		if (dataFineCoinvestimento == null) {
			if (other.dataFineCoinvestimento != null)
				return false;
		} else if (!dataFineCoinvestimento.equals(other.dataFineCoinvestimento))
			return false;
		if (dataInizio == null) {
			if (other.dataInizio != null)
				return false;
		} else if (!dataInizio.equals(other.dataInizio))
			return false;
		if (dataInizioCoinvestimento == null) {
			if (other.dataInizioCoinvestimento != null)
				return false;
		} else if (!dataInizioCoinvestimento.equals(other.dataInizioCoinvestimento))
			return false;
		if (dataInserimento == null) {
			if (other.dataInserimento != null)
				return false;
		} else if (!dataInserimento.equals(other.dataInserimento))
			return false;
		if (dataUltimoAggiornamento == null) {
			if (other.dataUltimoAggiornamento != null)
				return false;
		} else if (!dataUltimoAggiornamento.equals(other.dataUltimoAggiornamento))
			return false;
		if (datiMulticast == null) {
			if (other.datiMulticast != null)
				return false;
		} else if (!datiMulticast.equals(other.datiMulticast))
			return false;
		if (datiSospensioneServizio == null) {
			if (other.datiSospensioneServizio != null)
				return false;
		} else if (!datiSospensioneServizio.equals(other.datiSospensioneServizio))
			return false;
		if (flagAbilitato != other.flagAbilitato)
			return false;
		if (flagAnfibio != other.flagAnfibio)
			return false;
		if (flagDiffidato != other.flagDiffidato)
			return false;
		if (flagFileNotify != other.flagFileNotify)
			return false;
		if (flagMulticast != other.flagMulticast)
			return false;
		if (flagNPD != other.flagNPD)
			return false;
		if (flagStandard != other.flagStandard)
			return false;
		if (flagValido != other.flagValido)
			return false;
		if (idContratto != other.idContratto)
			return false;
		if (idContrattoPadre == null) {
			if (other.idContrattoPadre != null)
				return false;
		} else if (!idContrattoPadre.equals(other.idContrattoPadre))
			return false;
		if (idFamigliaOfferta == null) {
			if (other.idFamigliaOfferta != null)
				return false;
		} else if (!idFamigliaOfferta.equals(other.idFamigliaOfferta))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (idOperatoreRete == null) {
			if (other.idOperatoreRete != null)
				return false;
		} else if (!idOperatoreRete.equals(other.idOperatoreRete))
			return false;
		if (idSistemaCompetente == null) {
			if (other.idSistemaCompetente != null)
				return false;
		} else if (!idSistemaCompetente.equals(other.idSistemaCompetente))
			return false;
		if (idSottofamigliaOfferta == null) {
			if (other.idSottofamigliaOfferta != null)
				return false;
		} else if (!idSottofamigliaOfferta.equals(other.idSottofamigliaOfferta))
			return false;
		if (idStatoContratto == null) {
			if (other.idStatoContratto != null)
				return false;
		} else if (!idStatoContratto.equals(other.idStatoContratto))
			return false;
		if (idTipoServizio == null) {
			if (other.idTipoServizio != null)
				return false;
		} else if (!idTipoServizio.equals(other.idTipoServizio))
			return false;
		if (identificativoContrattoCRMW == null) {
			if (other.identificativoContrattoCRMW != null)
				return false;
		} else if (!identificativoContrattoCRMW.equals(other.identificativoContrattoCRMW))
			return false;
		if (identificativoTipologiaContratto == null) {
			if (other.identificativoTipologiaContratto != null)
				return false;
		} else if (!identificativoTipologiaContratto.equals(other.identificativoTipologiaContratto))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeStandard == null) {
			if (other.nomeStandard != null)
				return false;
		} else if (!nomeStandard.equals(other.nomeStandard))
			return false;
		if (oao == null) {
			if (other.oao != null)
				return false;
		} else if (!oao.equals(other.oao))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
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
		if (statoStandard == null) {
			if (other.statoStandard != null)
				return false;
		} else if (!statoStandard.equals(other.statoStandard))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
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
		return true;
	}

	@Override
	public String toString() {
		return "ContrattoOutputBean [idContratto=" + idContratto + ", codiceContratto=" + codiceContratto
				+ ", codificaOAO=" + codificaOAO + ", nome=" + nome + ", tipo=" + tipo + ", idTipoServizio="
				+ idTipoServizio + ", stato=" + stato + ", tipoProdotti=" + tipoProdotti + ", idContrattoPadre="
				+ idContrattoPadre + ", statoStandard=" + statoStandard + ", identificativoContrattoCRMW="
				+ identificativoContrattoCRMW + ", nomeStandard=" + nomeStandard + ", identificativoTipologiaContratto="
				+ identificativoTipologiaContratto + ", tipoContratto=" + tipoContratto + ", flagNPD=" + flagNPD
				+ ", flagAbilitato=" + flagAbilitato + ", flagValido=" + flagValido + ", flagStandard=" + flagStandard
				+ ", flagFileNotify=" + flagFileNotify + ", flagDiffidato=" + flagDiffidato + ", flagAnfibio="
				+ flagAnfibio + ", oao=" + oao + ", idSistemaCompetente=" + idSistemaCompetente + ", dataInizio="
				+ dataInizio + ", dataFine=" + dataFine + ", dataUltimoAggiornamento=" + dataUltimoAggiornamento
				+ ", dataInserimento=" + dataInserimento + ", codOlo=" + codOlo + ", idFamigliaOfferta="
				+ idFamigliaOfferta + ", idSottofamigliaOfferta=" + idSottofamigliaOfferta + ", idStatoContratto="
				+ idStatoContratto + ", operatoreRete=" + operatoreRete + ", idOperatoreRete=" + idOperatoreRete
				+ ", contrattoFwaDecommissioning=" + contrattoFwaDecommissioning + ", contrattoFwaPlus="
				+ contrattoFwaPlus + ", contrattoFwaInfratel=" + contrattoFwaInfratel + ", dataInizioCoinvestimento="
				+ dataInizioCoinvestimento + ", dataFineCoinvestimento=" + dataFineCoinvestimento + ", datiMulticast="
				+ datiMulticast + ", bouquet=" + bouquet + ", flagMulticast=" + flagMulticast
				+ ", datiSospensioneServizio=" + datiSospensioneServizio + ", idOfferta=" + idOfferta + ", offerta="
				+ offerta + "]";
	}
}