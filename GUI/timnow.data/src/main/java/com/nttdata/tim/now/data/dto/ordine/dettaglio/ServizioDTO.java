package com.nttdata.tim.now.data.dto.ordine.dettaglio;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ServizioDTO implements Serializable {

	private static final long serialVersionUID = 5453305116835715378L;

	@JsonProperty("Azione")
	private String azione;
	
	@JsonProperty("Prodotto")
	private String product;

	@JsonProperty("CodiceTI")
	private String codeOrderTI;	
	
	@JsonProperty("DAC")
	private String dac;

	@JsonProperty("customizzazione")
	private List<CustomizzazioneDTO> customizations;

	public String getAzione() {
		return azione;
	}

	public void setAzione(String azione) {
		this.azione = azione;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getCodeOrderTI() {
		return codeOrderTI;
	}

	public void setCodeOrderTI(String codeOrderTI) {
		this.codeOrderTI = codeOrderTI;
	}

	public String getDac() {
		return dac;
	}

	public void setDac(String dac) {
		this.dac = dac;
	}

	public List<CustomizzazioneDTO> getCustomizations() {
		return customizations;
	}

	public void setCustomizations(List<CustomizzazioneDTO> customizations) {
		this.customizations = customizations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((azione == null) ? 0 : azione.hashCode());
		result = prime * result + ((codeOrderTI == null) ? 0 : codeOrderTI.hashCode());
		result = prime * result + ((customizations == null) ? 0 : customizations.hashCode());
		result = prime * result + ((dac == null) ? 0 : dac.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		ServizioDTO other = (ServizioDTO) obj;
		if (azione == null) {
			if (other.azione != null)
				return false;
		} else if (!azione.equals(other.azione))
			return false;
		if (codeOrderTI == null) {
			if (other.codeOrderTI != null)
				return false;
		} else if (!codeOrderTI.equals(other.codeOrderTI))
			return false;
		if (customizations == null) {
			if (other.customizations != null)
				return false;
		} else if (!customizations.equals(other.customizations))
			return false;
		if (dac == null) {
			if (other.dac != null)
				return false;
		} else if (!dac.equals(other.dac))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServizioDTO [azione=" + azione + ", product=" + product + ", codeOrderTI=" + codeOrderTI + ", dac="
				+ dac + ", customizations=" + customizations + "]";
	}


}
