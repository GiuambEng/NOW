package com.nttdata.tim.now.data.dto.ordine.export;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RichiestaExportOrdiniInputDTO implements Serializable {
	
	private static final long serialVersionUID = 4725374302585874006L;

	@JsonProperty("User_ID")
	private String userID;

	@JsonProperty("ID_Richiesta")
	private List<String> idRichiesta;

	@JsonProperty("COD_OLO_AGCOM")
	private String codOloAgcom;

	@JsonProperty("Tipo_Profilo")
	private String tipoProfilo;

	@JsonProperty("Tipo_Lista")
	private String tipoLista;

	@JsonProperty("RicercaAvanzata_xmlToExcel")
	private AdvancedResearchInputDTO advancedResearch;

	/**
	 * 
	 * @return The userID
	 */
	@JsonProperty("User_ID")
	public String getUserID() {
		return userID;
	}

	/**
	 * 
	 * @param userID
	 *            The User_ID
	 */
	@JsonProperty("User_ID")
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * 
	 * @return The idRichiesta
	 */
	@JsonProperty("ID_Richiesta")
	public List<String> getIdRichiesta() {
		return idRichiesta;
	}

	/**
	 * 
	 * @param idRichiesta
	 *            The ID_Richiesta
	 */
	@JsonProperty("ID_Richiesta")
	public void setIdRichiesta(List<String> idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	/**
	 * 
	 * @return The cODOLOAGCOM
	 */
	@JsonProperty("COD_OLO_AGCOM")
	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	/**
	 * 
	 * @param codOloAgcom
	 *            The COD_OLO_AGCOM
	 */
	@JsonProperty("COD_OLO_AGCOM")
	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	/**
	 * 
	 * @return The tipoProfilo
	 */
	@JsonProperty("Tipo_Profilo")
	public String getTipoProfilo() {
		return tipoProfilo;
	}

	/**
	 * 
	 * @param tipoProfilo
	 *            The Tipo_Profilo
	 */
	@JsonProperty("Tipo_Profilo")
	public void setTipoProfilo(String tipoProfilo) {
		this.tipoProfilo = tipoProfilo;
	}

	/**
	 * 
	 * @return The tipoLista
	 */
	@JsonProperty("Tipo_Lista")
	public String getTipoLista() {
		return tipoLista;
	}

	/**
	 * 
	 * @param tipoLista
	 *            The Tipo_Lista
	 */
	@JsonProperty("Tipo_Lista")
	public void setTipoLista(String tipoLista) {
		this.tipoLista = tipoLista;
	}

	public AdvancedResearchInputDTO getAdvancedResearch() {
		return advancedResearch;
	}

	public void setAdvancedResearch(AdvancedResearchInputDTO advancedResearch) {
		this.advancedResearch = advancedResearch;
	}

	@Override
	public String toString() {
		return "RequestOrderExportInputDTO [userID=" + userID + ", idRichiesta=" + idRichiesta + ", codOloAgcom=" + codOloAgcom + ", tipoProfilo=" + tipoProfilo + ", tipoLista=" + tipoLista + "]";
	}

}