package com.nttdata.tim.now.data.dto.profilolinea;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class LineProfileDTO implements Serializable {

	private static final long serialVersionUID = 2288181614022854165L;
	
	@JsonProperty("idProfiloTecnicoLinea")
	private int idProfiloTecnicoLinea;

	@JsonProperty("profiloTecnicoLinea")
	private String profiloTecnicoLinea;
	
	@JsonProperty("idOfferta")
	private int idOfferta;

	@JsonProperty("offerta")
	private String offerta;
	
	@JsonProperty("flagVendibilita")
	private String flagVendibilita;
	
	@JsonProperty("maxVCxCF")
	private int maxVCxCF;
	
	@JsonProperty("profiloCommercialeDown")
	private int profiloCommercialeDown;

	@JsonProperty("profiloCommercialeUp")
	private int profiloCommercialeUp;
	
	@JsonProperty("velocitaAggancioDownMax")
	private int velocitaAggancioDownMax;

	@JsonProperty("velocitaAggancioDownMin")
	private int velocitaAggancioDownMin;

	@JsonProperty("velocitaAggancioUpMax")
	private int velocitaAggancioUpMax;

	@JsonProperty("velocitaAggancioUpMin")
	private int velocitaAggancioUpMin;

	@JsonProperty("bandaNetta")
	private String bandaNetta;

	@JsonProperty("codiceModem")
	private String codiceModem;

	@JsonProperty("modem")
	private String modem;

	@JsonProperty("modelloAccesso")
	private String modelloAccesso;

	@JsonProperty("protocollo")
	private String protocollo;

	@JsonProperty("tecnologiaOlo")
	private String tecnologiaOlo;

	@JsonProperty("tipoModulazione")
	private String tipoModulazione;

	@JsonProperty("idProfiloBMD")
	private int idProfiloBMD;

	@JsonProperty("flagOscurabile")
	private String flagOscurabile;

	public int getIdProfiloTecnicoLinea() {
		return idProfiloTecnicoLinea;
	}

	public void setIdProfiloTecnicoLinea(int idProfiloTecnicoLinea) {
		this.idProfiloTecnicoLinea = idProfiloTecnicoLinea;
	}

	public String getProfiloTecnicoLinea() {
		return profiloTecnicoLinea;
	}

	public void setProfiloTecnicoLinea(String profiloTecnicoLinea) {
		this.profiloTecnicoLinea = profiloTecnicoLinea;
	}

	public int getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(int idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getFlagVendibilita() {
		return flagVendibilita;
	}

	public void setFlagVendibilita(String flagVendibilita) {
		this.flagVendibilita = flagVendibilita;
	}

	public int getMaxVCxCF() {
		return maxVCxCF;
	}

	public void setMaxVCxCF(int maxVCxCF) {
		this.maxVCxCF = maxVCxCF;
	}

	public int getProfiloCommercialeDown() {
		return profiloCommercialeDown;
	}

	public void setProfiloCommercialeDown(int profiloCommercialeDown) {
		this.profiloCommercialeDown = profiloCommercialeDown;
	}

	public int getProfiloCommercialeUp() {
		return profiloCommercialeUp;
	}

	public void setProfiloCommercialeUp(int profiloCommercialeUp) {
		this.profiloCommercialeUp = profiloCommercialeUp;
	}

	public int getVelocitaAggancioDownMax() {
		return velocitaAggancioDownMax;
	}

	public void setVelocitaAggancioDownMax(int velocitaAggancioDownMax) {
		this.velocitaAggancioDownMax = velocitaAggancioDownMax;
	}

	public int getVelocitaAggancioDownMin() {
		return velocitaAggancioDownMin;
	}

	public void setVelocitaAggancioDownMin(int velocitaAggancioDownMin) {
		this.velocitaAggancioDownMin = velocitaAggancioDownMin;
	}

	public int getVelocitaAggancioUpMax() {
		return velocitaAggancioUpMax;
	}

	public void setVelocitaAggancioUpMax(int velocitaAggancioUpMax) {
		this.velocitaAggancioUpMax = velocitaAggancioUpMax;
	}

	public int getVelocitaAggancioUpMin() {
		return velocitaAggancioUpMin;
	}

	public void setVelocitaAggancioUpMin(int velocitaAggancioUpMin) {
		this.velocitaAggancioUpMin = velocitaAggancioUpMin;
	}

	public String getBandaNetta() {
		return bandaNetta;
	}

	public void setBandaNetta(String bandaNetta) {
		this.bandaNetta = bandaNetta;
	}

	public String getCodiceModem() {
		return codiceModem;
	}

	public void setCodiceModem(String codiceModem) {
		this.codiceModem = codiceModem;
	}

	public String getModem() {
		return modem;
	}

	public void setModem(String modem) {
		this.modem = modem;
	}

	public String getModelloAccesso() {
		return modelloAccesso;
	}

	public void setModelloAccesso(String modelloAccesso) {
		this.modelloAccesso = modelloAccesso;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getTecnologiaOlo() {
		return tecnologiaOlo;
	}

	public void setTecnologiaOlo(String tecnologiaOlo) {
		this.tecnologiaOlo = tecnologiaOlo;
	}

	public String getTipoModulazione() {
		return tipoModulazione;
	}

	public void setTipoModulazione(String tipoModulazione) {
		this.tipoModulazione = tipoModulazione;
	}

	public int getIdProfiloBMD() {
		return idProfiloBMD;
	}

	public void setIdProfiloBMD(int idProfiloBMD) {
		this.idProfiloBMD = idProfiloBMD;
	}

	public String getFlagOscurabile() {
		return flagOscurabile;
	}

	public void setFlagOscurabile(String flagOscurabile) {
		this.flagOscurabile = flagOscurabile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bandaNetta == null) ? 0 : bandaNetta.hashCode());
		result = prime * result + ((codiceModem == null) ? 0 : codiceModem.hashCode());
		result = prime * result + ((flagOscurabile == null) ? 0 : flagOscurabile.hashCode());
		result = prime * result + ((flagVendibilita == null) ? 0 : flagVendibilita.hashCode());
		result = prime * result + idOfferta;
		result = prime * result + idProfiloBMD;
		result = prime * result + idProfiloTecnicoLinea;
		result = prime * result + maxVCxCF;
		result = prime * result + ((modelloAccesso == null) ? 0 : modelloAccesso.hashCode());
		result = prime * result + ((modem == null) ? 0 : modem.hashCode());
		result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
		result = prime * result + profiloCommercialeDown;
		result = prime * result + profiloCommercialeUp;
		result = prime * result + ((profiloTecnicoLinea == null) ? 0 : profiloTecnicoLinea.hashCode());
		result = prime * result + ((protocollo == null) ? 0 : protocollo.hashCode());
		result = prime * result + ((tecnologiaOlo == null) ? 0 : tecnologiaOlo.hashCode());
		result = prime * result + ((tipoModulazione == null) ? 0 : tipoModulazione.hashCode());
		result = prime * result + velocitaAggancioDownMax;
		result = prime * result + velocitaAggancioDownMin;
		result = prime * result + velocitaAggancioUpMax;
		result = prime * result + velocitaAggancioUpMin;
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
		LineProfileDTO other = (LineProfileDTO) obj;
		if (bandaNetta == null) {
			if (other.bandaNetta != null)
				return false;
		} else if (!bandaNetta.equals(other.bandaNetta))
			return false;
		if (codiceModem == null) {
			if (other.codiceModem != null)
				return false;
		} else if (!codiceModem.equals(other.codiceModem))
			return false;
		if (flagOscurabile == null) {
			if (other.flagOscurabile != null)
				return false;
		} else if (!flagOscurabile.equals(other.flagOscurabile))
			return false;
		if (flagVendibilita == null) {
			if (other.flagVendibilita != null)
				return false;
		} else if (!flagVendibilita.equals(other.flagVendibilita))
			return false;
		if (idOfferta != other.idOfferta)
			return false;
		if (idProfiloBMD != other.idProfiloBMD)
			return false;
		if (idProfiloTecnicoLinea != other.idProfiloTecnicoLinea)
			return false;
		if (maxVCxCF != other.maxVCxCF)
			return false;
		if (modelloAccesso == null) {
			if (other.modelloAccesso != null)
				return false;
		} else if (!modelloAccesso.equals(other.modelloAccesso))
			return false;
		if (modem == null) {
			if (other.modem != null)
				return false;
		} else if (!modem.equals(other.modem))
			return false;
		if (offerta == null) {
			if (other.offerta != null)
				return false;
		} else if (!offerta.equals(other.offerta))
			return false;
		if (profiloCommercialeDown != other.profiloCommercialeDown)
			return false;
		if (profiloCommercialeUp != other.profiloCommercialeUp)
			return false;
		if (profiloTecnicoLinea == null) {
			if (other.profiloTecnicoLinea != null)
				return false;
		} else if (!profiloTecnicoLinea.equals(other.profiloTecnicoLinea))
			return false;
		if (protocollo == null) {
			if (other.protocollo != null)
				return false;
		} else if (!protocollo.equals(other.protocollo))
			return false;
		if (tecnologiaOlo == null) {
			if (other.tecnologiaOlo != null)
				return false;
		} else if (!tecnologiaOlo.equals(other.tecnologiaOlo))
			return false;
		if (tipoModulazione == null) {
			if (other.tipoModulazione != null)
				return false;
		} else if (!tipoModulazione.equals(other.tipoModulazione))
			return false;
		if (velocitaAggancioDownMax != other.velocitaAggancioDownMax)
			return false;
		if (velocitaAggancioDownMin != other.velocitaAggancioDownMin)
			return false;
		if (velocitaAggancioUpMax != other.velocitaAggancioUpMax)
			return false;
		if (velocitaAggancioUpMin != other.velocitaAggancioUpMin)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LineProfileDTO [idProfiloTecnicoLinea=" + idProfiloTecnicoLinea + ", profiloTecnicoLinea="
				+ profiloTecnicoLinea + ", idOfferta=" + idOfferta + ", offerta=" + offerta + ", flagVendibilita="
				+ flagVendibilita + ", maxVCxCF=" + maxVCxCF + ", profiloCommercialeDown=" + profiloCommercialeDown
				+ ", profiloCommercialeUp=" + profiloCommercialeUp + ", velocitaAggancioDownMax="
				+ velocitaAggancioDownMax + ", velocitaAggancioDownMin=" + velocitaAggancioDownMin
				+ ", velocitaAggancioUpMax=" + velocitaAggancioUpMax + ", velocitaAggancioUpMin="
				+ velocitaAggancioUpMin + ", bandaNetta=" + bandaNetta + ", codiceModem=" + codiceModem + ", modem="
				+ modem + ", modelloAccesso=" + modelloAccesso + ", protocollo=" + protocollo + ", tecnologiaOlo="
				+ tecnologiaOlo + ", tipoModulazione=" + tipoModulazione + ", idProfiloBMD=" + idProfiloBMD
				+ ", flagOscurabile=" + flagOscurabile + "]";
	}

	
}
