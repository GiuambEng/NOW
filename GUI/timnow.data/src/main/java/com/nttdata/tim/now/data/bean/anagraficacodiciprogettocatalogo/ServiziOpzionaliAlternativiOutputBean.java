package com.nttdata.tim.now.data.bean.anagraficacodiciprogettocatalogo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;


//RU_1485
@JsonInclude(Include.NON_NULL)
public class ServiziOpzionaliAlternativiOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = -8033177762621804257L;

	@JsonProperty("codiceProgetto")
    private String codiceProgetto;
	
    @JsonProperty("servizioOpzionalePadre")
    private String servizioOpzionalePadre;
    
    @JsonProperty("servizioOpzionaleAlternativo")
    private String servizioOpzionaleAlternativo;
        
    @JsonProperty("descrizioneAnagraficaServizioOpzionale")
    private String descrizioneAnagraficaServizioOpzionale;
    
    @JsonProperty("dataInizioValidita")
    private String dataInizioValidita;
    
    @JsonProperty("dataFineValidita")
    private String dataFineValidita;
    
    @JsonProperty("datiTecnici")
    private String datiTecnici;
    
    @JsonProperty("vincolanteEspletamento")
    private String vincolanteEspletamento;

	public String getCodiceProgetto() {
		return codiceProgetto;
	}

	public void setCodiceProgetto(String codiceProgetto) {
		this.codiceProgetto = codiceProgetto;
	}

	public String getServizioOpzionalePadre() {
		return servizioOpzionalePadre;
	}

	public void setServizioOpzionalePadre(String servizioOpzionalePadre) {
		this.servizioOpzionalePadre = servizioOpzionalePadre;
	}

	public String getServizioOpzionaleAlternativo() {
		return servizioOpzionaleAlternativo;
	}

	public void setServizioOpzionaleAlternativo(String servizioOpzionaleAlternativo) {
		this.servizioOpzionaleAlternativo = servizioOpzionaleAlternativo;
	}

	public String getDescrizioneAnagraficaServizioOpzionale() {
		return descrizioneAnagraficaServizioOpzionale;
	}

	public void setDescrizioneAnagraficaServizioOpzionale(String descrizioneAnagraficaServizioOpzionale) {
		this.descrizioneAnagraficaServizioOpzionale = descrizioneAnagraficaServizioOpzionale;
	}

	public String getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(String dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public String getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(String dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public String getDatiTecnici() {
		return datiTecnici;
	}

	public void setDatiTecnici(String datiTecnici) {
		this.datiTecnici = datiTecnici;
	}

	public String getVincolanteEspletamento() {
		return vincolanteEspletamento;
	}

	public void setVincolanteEspletamento(String vincolanteEspletamento) {
		this.vincolanteEspletamento = vincolanteEspletamento;
	}
}
