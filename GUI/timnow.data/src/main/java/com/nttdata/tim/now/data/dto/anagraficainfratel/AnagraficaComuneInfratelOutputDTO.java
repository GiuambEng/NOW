package com.nttdata.tim.now.data.dto.anagraficainfratel;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnagraficaComuneInfratelOutputDTO implements Serializable {

	private static final long serialVersionUID = 924881977948410597L;

	@JsonProperty("codificaOloAgcom")
    private String codificaOloAgcom;
	
    @JsonProperty("dataInizioValidita")
    private String dataInizioValidita;
    
    @JsonProperty("timestampInserimento")
    private String timestampInserimento;
    
    @JsonProperty("codiceIstatComune")
    private String codiceIstatComune;
    
    @JsonProperty("timestampAggiornamento")
    private String timestampAggiornamento;   
    
    @JsonProperty("dataFineValidita")
    private String dataFineValidita;
        
    @JsonProperty("nota")
    private String nota;

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public String getDataInizioValidita() {
		return dataInizioValidita;
	}

	public String getTimestampInserimento() {
		return timestampInserimento;
	}

	public String getCodiceIstatComune() {
		return codiceIstatComune;
	}

	public String getTimestampAggiornamento() {
		return timestampAggiornamento;
	}

	public String getDataFineValidita() {
		return dataFineValidita;
	}

	public String getNota() {
		return nota;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public void setDataInizioValidita(String dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public void setTimestampInserimento(String timestampInserimento) {
		this.timestampInserimento = timestampInserimento;
	}

	public void setCodiceIstatComune(String codiceIstatComune) {
		this.codiceIstatComune = codiceIstatComune;
	}

	public void setTimestampAggiornamento(String timestampAggiornamento) {
		this.timestampAggiornamento = timestampAggiornamento;
	}

	public void setDataFineValidita(String dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceIstatComune == null) ? 0 : codiceIstatComune.hashCode());
		result = prime * result + ((codificaOloAgcom == null) ? 0 : codificaOloAgcom.hashCode());
		result = prime * result + ((dataFineValidita == null) ? 0 : dataFineValidita.hashCode());
		result = prime * result + ((dataInizioValidita == null) ? 0 : dataInizioValidita.hashCode());
		result = prime * result + ((nota == null) ? 0 : nota.hashCode());
		result = prime * result + ((timestampAggiornamento == null) ? 0 : timestampAggiornamento.hashCode());
		result = prime * result + ((timestampInserimento == null) ? 0 : timestampInserimento.hashCode());
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
		AnagraficaComuneInfratelOutputDTO other = (AnagraficaComuneInfratelOutputDTO) obj;
		if (codiceIstatComune == null) {
			if (other.codiceIstatComune != null)
				return false;
		} else if (!codiceIstatComune.equals(other.codiceIstatComune))
			return false;
		if (codificaOloAgcom == null) {
			if (other.codificaOloAgcom != null)
				return false;
		} else if (!codificaOloAgcom.equals(other.codificaOloAgcom))
			return false;
		if (dataFineValidita == null) {
			if (other.dataFineValidita != null)
				return false;
		} else if (!dataFineValidita.equals(other.dataFineValidita))
			return false;
		if (dataInizioValidita == null) {
			if (other.dataInizioValidita != null)
				return false;
		} else if (!dataInizioValidita.equals(other.dataInizioValidita))
			return false;
		if (nota == null) {
			if (other.nota != null)
				return false;
		} else if (!nota.equals(other.nota))
			return false;
		if (timestampAggiornamento == null) {
			if (other.timestampAggiornamento != null)
				return false;
		} else if (!timestampAggiornamento.equals(other.timestampAggiornamento))
			return false;
		if (timestampInserimento == null) {
			if (other.timestampInserimento != null)
				return false;
		} else if (!timestampInserimento.equals(other.timestampInserimento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnagraficaComuneInfratelOutputDTO [codificaOloAgcom=" + codificaOloAgcom + ", dataInizioValidita="
				+ dataInizioValidita + ", timestampInserimento=" + timestampInserimento + ", codiceIstatComune="
				+ codiceIstatComune + ", timestampAggiornamento=" + timestampAggiornamento + ", dataFineValidita="
				+ dataFineValidita + ", nota=" + nota + "]";
	}

	

}
