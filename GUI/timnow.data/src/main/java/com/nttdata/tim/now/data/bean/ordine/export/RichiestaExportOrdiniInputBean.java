package com.nttdata.tim.now.data.bean.ordine.export;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.ricerca.RicercaAvanzataInputBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RichiestaExportOrdiniInputBean implements Serializable {

	private static final long serialVersionUID = 3635941021339301387L;

	@JsonProperty("userID")
	private String userID;

	@JsonProperty("idRichiesta")
	private List<String> idRichiesta;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;

	@JsonProperty("tipoProfilo")
	private String tipoProfilo;

	@JsonProperty("tipoLista")
	private String tipoLista;

	@JsonProperty("advancedResearch")
	private RicercaAvanzataInputBean advancedResearch;

	/**
	 * 
	 * @return The userID
	 */
	@JsonProperty("userID")
	public String getUserID() {
		return userID;
	}

	/**
	 * 
	 * @param userID
	 *            The User_ID
	 */
	@JsonProperty("userID")
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * 
	 * @return The idRichiesta
	 */
	@JsonProperty("idRichiesta")
	public List<String> getIdRichiesta() {
		return idRichiesta;
	}

	/**
	 * 
	 * @param idRichiesta
	 *            The ID_Richiesta
	 */
	@JsonProperty("idRichiesta")
	public void setIdRichiesta(List<String> idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	/**
	 * 
	 * @return The cODOLOAGCOM
	 */
	@JsonProperty("codOloAgcom")
	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	/**
	 * 
	 * @param codOloAgcom
	 *            The codOloAgcom
	 */
	@JsonProperty("codOloAgcom")
	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	/**
	 * 
	 * @return The tipoProfilo
	 */
	@JsonProperty("tipoProfilo")
	public String getTipoProfilo() {
		return tipoProfilo;
	}

	/**
	 * 
	 * @param tipoProfilo
	 *            The tipoProfilo
	 */
	@JsonProperty("tipoProfilo")
	public void setTipoProfilo(String tipoProfilo) {
		this.tipoProfilo = tipoProfilo;
	}

	/**
	 * 
	 * @return The tipoLista
	 */
	@JsonProperty("tipoLista")
	public String getTipoLista() {
		return tipoLista;
	}

	/**
	 * 
	 * @param tipoLista
	 *            The tipoLista
	 */
	@JsonProperty("tipoLista")
	public void setTipoLista(String tipoLista) {
		this.tipoLista = tipoLista;
	}

	public RicercaAvanzataInputBean getAdvancedResearch() {
		return advancedResearch;
	}

	public void setAdvancedResearch(RicercaAvanzataInputBean advancedResearch) {
		this.advancedResearch = advancedResearch;
	}

	@Override
	public String toString() {
		return "RequestOrderExportInputBean [userID=" + userID + ", idRichiesta=" + idRichiesta + ", codOloAgcom="
				+ codOloAgcom + ", tipoProfilo=" + tipoProfilo + ", tipoLista=" + tipoLista + "]";
	}

}