package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.util.date.DateHelper;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class DatiClienteFinaleInputBean implements Serializable {

    private static final long serialVersionUID = -1018801470046617724L;

    @JsonProperty("nome_cliente")
    private String nome;

    @JsonProperty("cognome_cliente")
    private String cognomeRagioneSociale;

    @JsonProperty("codice_fiscale_cliente")
    private String cf;

    @JsonProperty("partita_iva_cliente")
    private String pIva;
       
    //RU_915
    @JsonProperty("numero_bolletta_cliente")
    private String numeroBolletta;
    
    //RU_915
    @JsonProperty("bimestre_riferimento")
    private String bimestreRiferimento;
    
    //RU_915
    @JsonProperty("tipo_documento_cliente")
    private String tipoDocumento;
    
    //RU_915
    @JsonProperty("numero_documento_cliente")
    private String numeroDocumento;
    
    //RU_915
    @JsonProperty("autorita_emittente")
    private String autoritaEmittente;
    
	//RU_915
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_emissione")
	private String dataEmissione;
	
    //RU_915
    @JsonProperty("codice_ripensamento_mai_richiesto")
    private String codiceRipensamentoMaiRichiesto;
    
	//RU_915
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_sottoscrizione_nuovo_contratto")
	private String dataSottoscrizioneNuovoContratto;
	
	//RU_915
	@JsonFormat(pattern = DateHelper.DATE_FE, shape = JsonFormat.Shape.STRING)
	@JsonProperty("data_richiesta_cessazione")
	private String dataRichiestaCessazione;
	
    //RU_915
    @JsonProperty("codice_olo_cessazione")
    private String codiceOloCessazione;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognomeRagioneSociale() {
        return cognomeRagioneSociale;
    }
    public void setCognomeRagioneSociale(String cognomeRagioneSociale) {
        this.cognomeRagioneSociale = cognomeRagioneSociale;
    }
    public String getCf() {
        return cf;
    }
    public void setCf(String cf) {
        this.cf = cf;
    }
    public String getpIva() {
        return pIva;
    }
    public void setpIva(String pIva) {
        this.pIva = pIva;
    }
	public String getNumeroBolletta() {
		return numeroBolletta;
	}
	public void setNumeroBolletta(String numeroBolletta) {
		this.numeroBolletta = numeroBolletta;
	}
	public String getBimestreRiferimento() {
		return bimestreRiferimento;
	}
	public void setBimestreRiferimento(String bimestreRiferimento) {
		this.bimestreRiferimento = bimestreRiferimento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getAutoritaEmittente() {
		return autoritaEmittente;
	}
	public void setAutoritaEmittente(String autoritaEmittente) {
		this.autoritaEmittente = autoritaEmittente;
	}
	public String getDataEmissione() {
		return dataEmissione;
	}
	public void setDataEmissione(String dataEmissione) {
		this.dataEmissione = dataEmissione;
	}
	public String getCodiceRipensamentoMaiRichiesto() {
		return codiceRipensamentoMaiRichiesto;
	}
	public void setCodiceRipensamentoMaiRichiesto(String codiceRipensamentoMaiRichiesto) {
		this.codiceRipensamentoMaiRichiesto = codiceRipensamentoMaiRichiesto;
	}
	public String getDataSottoscrizioneNuovoContratto() {
		return dataSottoscrizioneNuovoContratto;
	}
	public void setDataSottoscrizioneNuovoContratto(String dataSottoscrizioneNuovoContratto) {
		this.dataSottoscrizioneNuovoContratto = dataSottoscrizioneNuovoContratto;
	}
	public String getDataRichiestaCessazione() {
		return dataRichiestaCessazione;
	}
	public void setDataRichiestaCessazione(String dataRichiestaCessazione) {
		this.dataRichiestaCessazione = dataRichiestaCessazione;
	}
	public String getCodiceOloCessazione() {
		return codiceOloCessazione;
	}
	public void setCodiceOloCessazione(String codiceOloCessazione) {
		this.codiceOloCessazione = codiceOloCessazione;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autoritaEmittente == null) ? 0 : autoritaEmittente.hashCode());
		result = prime * result + ((bimestreRiferimento == null) ? 0 : bimestreRiferimento.hashCode());
		result = prime * result + ((cf == null) ? 0 : cf.hashCode());
		result = prime * result + ((codiceOloCessazione == null) ? 0 : codiceOloCessazione.hashCode());
		result = prime * result + ((codiceRipensamentoMaiRichiesto == null) ? 0 : codiceRipensamentoMaiRichiesto.hashCode());
		result = prime * result + ((cognomeRagioneSociale == null) ? 0 : cognomeRagioneSociale.hashCode());
		result = prime * result + ((dataEmissione == null) ? 0 : dataEmissione.hashCode());
		result = prime * result + ((dataRichiestaCessazione == null) ? 0 : dataRichiestaCessazione.hashCode());
		result = prime * result
				+ ((dataSottoscrizioneNuovoContratto == null) ? 0 : dataSottoscrizioneNuovoContratto.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroBolletta == null) ? 0 : numeroBolletta.hashCode());
		result = prime * result + ((numeroDocumento == null) ? 0 : numeroDocumento.hashCode());
		result = prime * result + ((pIva == null) ? 0 : pIva.hashCode());
		result = prime * result + ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
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
		DatiClienteFinaleInputBean other = (DatiClienteFinaleInputBean) obj;
		if (autoritaEmittente == null) {
			if (other.autoritaEmittente != null)
				return false;
		} else if (!autoritaEmittente.equals(other.autoritaEmittente))
			return false;
		if (bimestreRiferimento == null) {
			if (other.bimestreRiferimento != null)
				return false;
		} else if (!bimestreRiferimento.equals(other.bimestreRiferimento))
			return false;
		if (cf == null) {
			if (other.cf != null)
				return false;
		} else if (!cf.equals(other.cf))
			return false;
		if (codiceOloCessazione == null) {
			if (other.codiceOloCessazione != null)
				return false;
		} else if (!codiceOloCessazione.equals(other.codiceOloCessazione))
			return false;
		if (codiceRipensamentoMaiRichiesto == null) {
			if (other.codiceRipensamentoMaiRichiesto != null)
				return false;
		} else if (!codiceRipensamentoMaiRichiesto.equals(other.codiceRipensamentoMaiRichiesto))
			return false;
		if (cognomeRagioneSociale == null) {
			if (other.cognomeRagioneSociale != null)
				return false;
		} else if (!cognomeRagioneSociale.equals(other.cognomeRagioneSociale))
			return false;
		if (dataEmissione == null) {
			if (other.dataEmissione != null)
				return false;
		} else if (!dataEmissione.equals(other.dataEmissione))
			return false;
		if (dataRichiestaCessazione == null) {
			if (other.dataRichiestaCessazione != null)
				return false;
		} else if (!dataRichiestaCessazione.equals(other.dataRichiestaCessazione))
			return false;
		if (dataSottoscrizioneNuovoContratto == null) {
			if (other.dataSottoscrizioneNuovoContratto != null)
				return false;
		} else if (!dataSottoscrizioneNuovoContratto.equals(other.dataSottoscrizioneNuovoContratto))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroBolletta == null) {
			if (other.numeroBolletta != null)
				return false;
		} else if (!numeroBolletta.equals(other.numeroBolletta))
			return false;
		if (numeroDocumento == null) {
			if (other.numeroDocumento != null)
				return false;
		} else if (!numeroDocumento.equals(other.numeroDocumento))
			return false;
		if (pIva == null) {
			if (other.pIva != null)
				return false;
		} else if (!pIva.equals(other.pIva))
			return false;
		if (tipoDocumento == null) {
			if (other.tipoDocumento != null)
				return false;
		} else if (!tipoDocumento.equals(other.tipoDocumento))
			return false;
		return true;
	}
    @Override
	public String toString() {
		return "DatiClienteFinaleInputBean [nome=" + nome + ", cognomeRagioneSociale=" + cognomeRagioneSociale + ", cf="
				+ cf + ", pIva=" + pIva + ", numeroBolletta=" + numeroBolletta + ", bimestreRiferimento="
				+ bimestreRiferimento + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento
				+ ", autoritaEmittente=" + autoritaEmittente + ", dataEmissione=" + dataEmissione
				+ ", codiceRipensamentoMaiRichiesto=" + codiceRipensamentoMaiRichiesto + ", dataSottoscrizioneNuovoContratto="
				+ dataSottoscrizioneNuovoContratto + ", dataRichiestaCessazione=" + dataRichiestaCessazione
				+ ", codiceOloCessazione=" + codiceOloCessazione + "]";
	}


}
