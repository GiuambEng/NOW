
package com.nttdata.tim.now.data.bean.monitoring.file;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileElaboratiOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = 8027706487475722309L;

	@JsonProperty("tot")
	private String tot;

	@JsonProperty("now")
	private String now;

	@JsonProperty("crmws")
	private String crmws;

	@JsonProperty("sdr")
	private String sdr;
	
	@JsonProperty("dbcfx")
	private String dbcfx;

    public String getTot() {
        return tot;
    }

    public void setTot(String tot) {
        this.tot = tot;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getCrmws() {
        return crmws;
    }

    public void setCrmws(String crmws) {
        this.crmws = crmws;
    }

    public String getSdr() {
        return sdr;
    }

    public void setSdr(String sdr) {
        this.sdr = sdr;
    }

    public String getDbcfx() {
        return dbcfx;
    }

    public void setDbcfx(String dbcfx) {
        this.dbcfx = dbcfx;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((crmws == null) ? 0 : crmws.hashCode());
        result = prime * result + ((dbcfx == null) ? 0 : dbcfx.hashCode());
        result = prime * result + ((now == null) ? 0 : now.hashCode());
        result = prime * result + ((sdr == null) ? 0 : sdr.hashCode());
        result = prime * result + ((tot == null) ? 0 : tot.hashCode());
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
        FileElaboratiOutputBean other = (FileElaboratiOutputBean) obj;
        if (crmws == null) {
            if (other.crmws != null)
                return false;
        } else if (!crmws.equals(other.crmws))
            return false;
        if (dbcfx == null) {
            if (other.dbcfx != null)
                return false;
        } else if (!dbcfx.equals(other.dbcfx))
            return false;
        if (now == null) {
            if (other.now != null)
                return false;
        } else if (!now.equals(other.now))
            return false;
        if (sdr == null) {
            if (other.sdr != null)
                return false;
        } else if (!sdr.equals(other.sdr))
            return false;
        if (tot == null) {
            if (other.tot != null)
                return false;
        } else if (!tot.equals(other.tot))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FileElaboratiOutputBean [tot=" + tot + ", now=" + now + ", crmws=" + crmws + ", sdr=" + sdr + ", dbcfx=" + dbcfx + "]";
    }

    

}
