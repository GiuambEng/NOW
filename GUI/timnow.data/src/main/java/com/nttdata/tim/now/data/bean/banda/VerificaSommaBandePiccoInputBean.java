package com.nttdata.tim.now.data.bean.banda;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaSommaBandePiccoInputBean implements Serializable {

	private static final long serialVersionUID = -4684358173199396325L;

	@JsonProperty("profiloTecnicoLinea")
	private String profiloTecnicoLinea;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("bande")
    private List<BandaOutputBean> userVlan;

	public String getProfiloTecnicoLinea() {
		return profiloTecnicoLinea;
	}

	public void setProfiloTecnicoLinea(String profiloTecnicoLinea) {
		this.profiloTecnicoLinea = profiloTecnicoLinea;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

    public List<BandaOutputBean> getUserVlan() {
        return userVlan;
	}

    public void setUserVlan(List<BandaOutputBean> userVlan) {
        this.userVlan = userVlan;
    }

    @Override
    public String toString() {
        return "VerificaSommaBandePiccoInputBean [profiloTecnicoLinea=" + profiloTecnicoLinea + ", offerta=" + offerta + ", userVlan=" + userVlan + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((offerta == null) ? 0 : offerta.hashCode());
        result = prime * result + ((profiloTecnicoLinea == null) ? 0 : profiloTecnicoLinea.hashCode());
        result = prime * result + ((userVlan == null) ? 0 : userVlan.hashCode());
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
        VerificaSommaBandePiccoInputBean other = (VerificaSommaBandePiccoInputBean) obj;
        if (offerta == null) {
            if (other.offerta != null)
                return false;
        } else if (!offerta.equals(other.offerta))
            return false;
        if (profiloTecnicoLinea == null) {
            if (other.profiloTecnicoLinea != null)
                return false;
        } else if (!profiloTecnicoLinea.equals(other.profiloTecnicoLinea))
            return false;
        if (userVlan == null) {
            if (other.userVlan != null)
                return false;
        } else if (!userVlan.equals(other.userVlan))
            return false;
        return true;
	}

}