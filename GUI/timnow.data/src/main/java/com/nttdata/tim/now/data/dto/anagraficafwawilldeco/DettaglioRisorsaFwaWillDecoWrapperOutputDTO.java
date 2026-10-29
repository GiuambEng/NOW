package com.nttdata.tim.now.data.dto.anagraficafwawilldeco;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class DettaglioRisorsaFwaWillDecoWrapperOutputDTO extends ESBResultDTO  implements Serializable {

	private static final long serialVersionUID = -3995664228084584279L;

	@JsonProperty("dettaglioRisorsa")
    private DettaglioRisorsaFwaWillDecoOutputDTO dettaglioRisorsa;

	public DettaglioRisorsaFwaWillDecoOutputDTO getDettaglioRisorsa() {
		return dettaglioRisorsa;
	}

	public void setDettaglioRisorsa(DettaglioRisorsaFwaWillDecoOutputDTO dettaglioRisorsa) {
		this.dettaglioRisorsa = dettaglioRisorsa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dettaglioRisorsa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DettaglioRisorsaFwaWillDecoWrapperOutputDTO other = (DettaglioRisorsaFwaWillDecoWrapperOutputDTO) obj;
		return Objects.equals(dettaglioRisorsa, other.dettaglioRisorsa);
	}

	@Override
	public String toString() {
		return "DettaglioRisorsaFwaWillDecoOutputDTO [dettaglioRisorsa=" + dettaglioRisorsa + "]";
	}
    
}
