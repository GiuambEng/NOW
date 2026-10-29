package com.nttdata.tim.now.data.dto.notifica;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ResultDTO;

@JsonInclude(Include.NON_NULL)
public class DeleteULLSLUOutputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("result")
    private ResultDTO result;

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }
}