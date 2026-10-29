package com.nttdata.tim.now.data.bean.ordine.verifichevlan;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//RU_1502
@JsonInclude(Include.NON_NULL)
public class VerificaSpostamentoVLANInputBean implements Serializable {

	private static final long serialVersionUID = 7335336042062843997L;
	
	@JsonProperty("idRichiestaOlo")
	private String idRichiestaOlo;
	
	@JsonProperty("caratterizzazioneCarRic")
	private String caratterizzazioneCarRic;
	
	@JsonProperty("caratterizzazioneCarCons")
	private String caratterizzazioneCarCons;
	
	@JsonProperty("superMacroareaRic")
	private String superMacroareaRic;
	
	@JsonProperty("superMacroareaCons")
	private String superMacroareaCons;
	
	@JsonProperty("idRisorsa")
	private String idRisorsa;
	
	@JsonProperty("nomeMacroAreaRic")
	private String nomeMacroAreaRic;
	
	@JsonProperty("nomeMacroAreaCons")
	private String nomeMacroAreaCons;
	
	@JsonProperty("lavorazione")
	private String lavorazione;
	
	@JsonProperty("offerta")
	private String offerta;
	
	public String getIdRichiestaOlo() {
		return idRichiestaOlo;
	}
	public void setIdRichiestaOlo(String idRichiestaOlo) {
		this.idRichiestaOlo = idRichiestaOlo;
	}
	public String getCaratterizzazioneCarRic() {
		return caratterizzazioneCarRic;
	}
	public void setCaratterizzazioneCarRic(String caratterizzazioneCarRic) {
		this.caratterizzazioneCarRic = caratterizzazioneCarRic;
	}
	public String getCaratterizzazioneCarCons() {
		return caratterizzazioneCarCons;
	}
	public void setCaratterizzazioneCarCons(String caratterizzazioneCarCons) {
		this.caratterizzazioneCarCons = caratterizzazioneCarCons;
	}
	public String getSuperMacroareaRic() {
		return superMacroareaRic;
	}
	public void setSupermacroareaRic(String supermacroareaRic) {
		this.superMacroareaRic = supermacroareaRic;
	}
	public String getSuperMacroareaCons() {
		return superMacroareaCons;
	}
	public void setSuperMacroareaCons(String superMacroareaCons) {
		this.superMacroareaCons = superMacroareaCons;
	}
	public String getIdRisorsa() {
		return idRisorsa;
	}
	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}
	public String getNomeMacroAreaRic() {
		return nomeMacroAreaRic;
	}
	public void setNomeMacroAreaRic(String nomeMacroAreaRic) {
		this.nomeMacroAreaRic = nomeMacroAreaRic;
	}
	public String getNomeMacroAreaCons() {
		return nomeMacroAreaCons;
	}
	public void setNomeMacroAreaCons(String nomeMacroAreaCons) {
		this.nomeMacroAreaCons = nomeMacroAreaCons;
	}
	public String getLavorazione() {
		return lavorazione;
	}
	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}
	public String getOfferta() {
		return offerta;
	}
	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

}
