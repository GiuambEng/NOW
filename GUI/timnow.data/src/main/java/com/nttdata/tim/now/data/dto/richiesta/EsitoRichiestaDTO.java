package com.nttdata.tim.now.data.dto.richiesta;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonInclude(Include.NON_NULL)
public class EsitoRichiestaDTO implements Serializable {

	private static final long serialVersionUID = 7096913747750782350L;

	@JsonFormat(pattern = DateHelper.DATE_BE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("dataInvio")
	private Date dataInvio;

	@JsonProperty("statoNow")
	private String statoNow;

	@JsonProperty("statoOao")
	private String statoOao;

	@JsonProperty("lavorazioneRichiesta")
	private String lavorazioneRichiesta;

	@JsonProperty("idRichiestaOlo")
	private String idRichiestaOlo;

    @JsonProperty("codiceRichiestaOao")
    private String codiceRichiestaOao;

    @JsonProperty("xml")
    private String xml;

    @JsonProperty("userId")
    private String userId;

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public String getStatoNow() {
		return statoNow;
	}

	public void setStatoNow(String statoNow) {
		this.statoNow = statoNow;
	}

	public String getStatoOao() {
		return statoOao;
	}

	public void setStatoOao(String statoOao) {
		this.statoOao = statoOao;
	}

	public String getLavorazioneRichiesta() {
		return lavorazioneRichiesta;
	}

	public void setLavorazioneRichiesta(String lavorazioneRichiesta) {
		this.lavorazioneRichiesta = lavorazioneRichiesta;
	}

	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}

	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
	}

	public String getCodiceRichiestaOao() {
		return codiceRichiestaOao;
	}

	public void setCodiceRichiestaOao(String codiceRichiestaOao) {
		this.codiceRichiestaOao = codiceRichiestaOao;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceRichiestaOao == null) ? 0 : codiceRichiestaOao.hashCode());
		result = prime * result + ((dataInvio == null) ? 0 : dataInvio.hashCode());
		result = prime * result + ((idRichiestaOlo == null) ? 0 : idRichiestaOlo.hashCode());
		result = prime * result + ((lavorazioneRichiesta == null) ? 0 : lavorazioneRichiesta.hashCode());
		result = prime * result + ((statoNow == null) ? 0 : statoNow.hashCode());
		result = prime * result + ((statoOao == null) ? 0 : statoOao.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((xml == null) ? 0 : xml.hashCode());
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
		EsitoRichiestaDTO other = (EsitoRichiestaDTO) obj;
		if (codiceRichiestaOao == null) {
			if (other.codiceRichiestaOao != null)
				return false;
		} else if (!codiceRichiestaOao.equals(other.codiceRichiestaOao))
			return false;
		if (dataInvio == null) {
			if (other.dataInvio != null)
				return false;
		} else if (!dataInvio.equals(other.dataInvio))
			return false;
		if (idRichiestaOlo == null) {
			if (other.idRichiestaOlo != null)
				return false;
		} else if (!idRichiestaOlo.equals(other.idRichiestaOlo))
			return false;
		if (lavorazioneRichiesta == null) {
			if (other.lavorazioneRichiesta != null)
				return false;
		} else if (!lavorazioneRichiesta.equals(other.lavorazioneRichiesta))
			return false;
		if (statoNow == null) {
			if (other.statoNow != null)
				return false;
		} else if (!statoNow.equals(other.statoNow))
			return false;
		if (statoOao == null) {
			if (other.statoOao != null)
				return false;
		} else if (!statoOao.equals(other.statoOao))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (xml == null) {
			if (other.xml != null)
				return false;
		} else if (!xml.equals(other.xml))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EsitoRichiestaDTO [dataInvio=" + dataInvio + ", statoNow=" + statoNow + ", statoOao=" + statoOao
				+ ", lavorazioneRichiesta=" + lavorazioneRichiesta + ", idRichiestaOlo=" + idRichiestaOlo
				+ ", codiceRichiestaOao=" + codiceRichiestaOao + ", xml=" + xml + ", userId=" + userId + "]";
	}


    
}
