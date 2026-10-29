package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1129
@JsonInclude(Include.NON_NULL)
public class VerificaTipologiaContrattoFwaOutputBean implements Serializable {

	private static final long serialVersionUID = -37165057985258124L;
	
	 @JsonProperty("esito")
	    private String esito;

	    @JsonProperty("message")
	    private String message;

	    @JsonProperty("profili")
	    private List<String> profili;

		public String getEsito() {
			return esito;
		}

		public void setEsito(String esito) {
			this.esito = esito;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public List<String> getProfili() {
			return profili;
		}

		public void setProfili(List<String> profili) {
			this.profili = profili;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((esito == null) ? 0 : esito.hashCode());
			result = prime * result + ((message == null) ? 0 : message.hashCode());
			result = prime * result + ((profili == null) ? 0 : profili.hashCode());
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
			VerificaTipologiaContrattoFwaOutputBean other = (VerificaTipologiaContrattoFwaOutputBean) obj;
			if (esito == null) {
				if (other.esito != null)
					return false;
			} else if (!esito.equals(other.esito))
				return false;
			if (message == null) {
				if (other.message != null)
					return false;
			} else if (!message.equals(other.message))
				return false;
			if (profili == null) {
				if (other.profili != null)
					return false;
			} else if (!profili.equals(other.profili))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "VerificaTipologiaContrattoFwaOutputBean [esito=" + esito + ", message=" + message + ", profili="
					+ profili + "]";
		}

}
