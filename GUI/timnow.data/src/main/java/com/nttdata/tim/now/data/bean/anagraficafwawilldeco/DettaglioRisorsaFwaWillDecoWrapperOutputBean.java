package com.nttdata.tim.now.data.bean.anagraficafwawilldeco;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_1335
@JsonInclude(Include.NON_NULL)
public class DettaglioRisorsaFwaWillDecoWrapperOutputBean extends AbstractOutputBean  implements Serializable {

	private static final long serialVersionUID = -3995664228084584279L;

	@JsonProperty("dettaglioRisorsa")
    private DettaglioRisorsaFwaWillDecoOutputBean dettaglioRisorsa;

	public DettaglioRisorsaFwaWillDecoOutputBean getDettaglioRisorsa() {
		return dettaglioRisorsa;
	}

	public void setDettaglioRisorsa(DettaglioRisorsaFwaWillDecoOutputBean dettaglioRisorsa) {
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
		DettaglioRisorsaFwaWillDecoWrapperOutputBean other = (DettaglioRisorsaFwaWillDecoWrapperOutputBean) obj;
		return Objects.equals(dettaglioRisorsa, other.dettaglioRisorsa);
	}

	@Override
	public String toString() {
		return "DettaglioRisorsaFwaWillDecoWrapperOutputBean [dettaglioRisorsa=" + dettaglioRisorsa + "]";
	}
    
}
