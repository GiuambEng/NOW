package com.nttdata.tim.now.data.bean.vc;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VCBean implements Serializable {
    	
	private static final long serialVersionUID = -4839663638087085590L;

	@JsonProperty("VPI")
	@JsonInclude(Include.NON_NULL)//SM_8252
	private String vpi;
	
	@JsonProperty("VCI")
	@JsonInclude(Include.NON_NULL)//SM_8252
	private String vci;
	
	@JsonProperty("tipoProfilo")
	private String tipoProfilo;
	
	public String getVpi() {
		return vpi;
	}

	public void setVpi(String vpi) {
		this.vpi = vpi;
	}

	public String getVci() {
		return vci;
	}

	public void setVci(String vci) {
		this.vci = vci;
	}

	public String getTipoProfilo() {
		return tipoProfilo;
	}

	public void setTipoProfilo(String tipoProfilo) {
		this.tipoProfilo = tipoProfilo;
	}

	@Override
    public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + ((vpi == null) ? 0 : vpi.hashCode());
          result = prime * result + ((vci == null) ? 0 : vci.hashCode());
          result = prime * result + ((tipoProfilo == null) ? 0 : tipoProfilo.hashCode());
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
          VCBean other = (VCBean) obj;
          if (vpi == null) {
                 if (other.vpi != null)
                       return false;
          } else if (!vpi.equals(other.vpi))
                 return false;
          if (vci == null) {
              if (other.vci != null)
                    return false;
       } else if (!vci.equals(other.vci))
              return false;
          if (tipoProfilo == null) {
              if (other.tipoProfilo != null)
                    return false;
       } else if (!tipoProfilo.equals(other.tipoProfilo))
              return false;
          return true;
    }

    @Override
    public String toString() {
          return "VCBean [vpi=" + vpi + ", vci=" + vci + ", tipoProfilo=" + tipoProfilo + "]";
    }
	
}
