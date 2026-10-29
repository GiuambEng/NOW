package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1188
@JsonInclude(Include.NON_NULL)
public class RaccoltaVpOutputBean implements Serializable {

	private static final long serialVersionUID = -6333332092649888433L;
	
    @JsonProperty("bandapcr")
    private String bandaPcr;

    @JsonProperty("idrisorsa")
    private String idRisorsa;
    
    @JsonProperty("bandamcr")
    private String bandaMcr;
    
    @JsonProperty("codicetdkit")
    private String codiceTdKit;
    
    @JsonProperty("vpirete")
    private String vpiRete;
    
    @JsonProperty("caratteristicavp")
    private String caratteristicaVp;
    
    @JsonProperty("codiceclli")
    private String codiceClli;
    
    @JsonProperty("trasporto")
    private String trasporto;
    
    @JsonProperty("vpi")
    private String vpi;

	public String getBandaPcr() {
		return bandaPcr;
	}

	public String getIdRisorsa() {
		return idRisorsa;
	}

	public String getBandaMcr() {
		return bandaMcr;
	}

	public String getCodiceTdKit() {
		return codiceTdKit;
	}

	public String getVpiRete() {
		return vpiRete;
	}

	public String getCaratteristicaVp() {
		return caratteristicaVp;
	}

	public String getCodiceClli() {
		return codiceClli;
	}

	public String getTrasporto() {
		return trasporto;
	}

	public String getVpi() {
		return vpi;
	}

	public void setBandaPcr(String bandaPcr) {
		this.bandaPcr = bandaPcr;
	}

	public void setIdRisorsa(String idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public void setBandaMcr(String bandaMcr) {
		this.bandaMcr = bandaMcr;
	}

	public void setCodiceTdKit(String codiceTdKit) {
		this.codiceTdKit = codiceTdKit;
	}

	public void setVpiRete(String vpiRete) {
		this.vpiRete = vpiRete;
	}

	public void setCaratteristicaVp(String caratteristicaVp) {
		this.caratteristicaVp = caratteristicaVp;
	}

	public void setCodiceClli(String codiceClli) {
		this.codiceClli = codiceClli;
	}

	public void setTrasporto(String trasporto) {
		this.trasporto = trasporto;
	}

	public void setVpi(String vpi) {
		this.vpi = vpi;
	}
    
}
