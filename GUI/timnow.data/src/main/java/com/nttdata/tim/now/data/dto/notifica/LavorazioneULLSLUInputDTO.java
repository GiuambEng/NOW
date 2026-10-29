package com.nttdata.tim.now.data.dto.notifica;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class LavorazioneULLSLUInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("nomeFile")
    private String nomeFile;

    public String getNomeFile() {
        return nomeFile;
    }

    public void setNomeFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }
}