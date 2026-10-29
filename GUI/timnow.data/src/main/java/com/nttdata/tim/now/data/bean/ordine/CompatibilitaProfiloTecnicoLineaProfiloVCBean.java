package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.vc.VCBean;

public class CompatibilitaProfiloTecnicoLineaProfiloVCBean implements Serializable {

	private static final long serialVersionUID = -1136690847983182392L;

	@JsonProperty("lavorazione")
	private String lavorazione;
	
	@JsonProperty("caratteristica")
	private String caratteristica;
	
	@JsonProperty("profiloTecnicoLinea")
	private String profiloTecnicoLinea;
	
	@JsonProperty("VC")
	private List<VCBean> vc;
	
	@JsonProperty("idAsset")
	private String idAsset;
	
	@JsonProperty("idOfferta")
	private String idOfferta;
	
	public String getLavorazione() {
		return lavorazione;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public String getCaratteristica() {
		return caratteristica;
	}

	public void setCaratteristica(String caratteristica) {
		this.caratteristica = caratteristica;
	}

	public String getProfiloTecnicoLinea() {
		return profiloTecnicoLinea;
	}

	public void setProfiloTecnicoLinea(String profiloTecnicoLinea) {
		this.profiloTecnicoLinea = profiloTecnicoLinea;
	}

	public List<VCBean> getVc() {
		return vc;
	}

	public void setVc(List<VCBean> vc) {
		this.vc = vc;
	}

	public String getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(String idAsset) {
		this.idAsset = idAsset;
	}
	
	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

	@Override
    public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + ((lavorazione == null) ? 0 : lavorazione.hashCode());
          result = prime * result + ((caratteristica == null) ? 0 : caratteristica.hashCode());
          result = prime * result + ((profiloTecnicoLinea == null) ? 0 : profiloTecnicoLinea.hashCode());
          result = prime * result + ((profiloTecnicoLinea == null) ? 0 : profiloTecnicoLinea.hashCode());
          result = prime * result + ((vc == null) ? 0 : vc.hashCode());
          result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
          result = prime * result + ((idOfferta == null) ? 0 : idOfferta.hashCode());
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
	          CompatibilitaProfiloTecnicoLineaProfiloVCBean other = (CompatibilitaProfiloTecnicoLineaProfiloVCBean) obj;
	          if (lavorazione == null) {
	                 if (other.lavorazione != null)
	                       return false;
	          } else if (!lavorazione.equals(other.lavorazione))
	                 return false;
	          if (caratteristica == null) {
	              if (other.caratteristica != null)
	                    return false;
	       } else if (!caratteristica.equals(other.caratteristica))
	              return false;
	          if (profiloTecnicoLinea == null) {
	              if (other.profiloTecnicoLinea != null)
	                    return false;
	       } else if (!profiloTecnicoLinea.equals(other.profiloTecnicoLinea))
	              return false;
	          if (vc == null) {
	              if (other.vc != null)
	                    return false;
	       } else if (!vc.equals(other.vc))
	              return false;
	          if (idAsset == null) {
	              if (other.idAsset != null)
	                    return false;
	       } else if (!idAsset.equals(other.idAsset))
	              return false;
	          if (idOfferta == null) {
	              if (other.idOfferta != null)
	                    return false;
	       } else if (!idOfferta.equals(other.idOfferta))
	              return false;
	          return true;
	    }
	
	 @Override
	    public String toString() {
	          return "CompatibilitaProfiloTecnicoLineaProfiloVCBean [lavorazione=" + lavorazione + ", caratteristica=" + 
	        		  caratteristica + ", profiloTecnicoLinea=" + profiloTecnicoLinea 
	        		  + ", vc=" + vc
	        		  + ", idOfferta=" + idOfferta
	        		  + ", idAsset=" + idAsset + "]";
	    }

}
