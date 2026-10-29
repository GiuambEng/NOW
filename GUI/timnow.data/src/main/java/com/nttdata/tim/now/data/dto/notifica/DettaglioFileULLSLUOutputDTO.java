package com.nttdata.tim.now.data.dto.notifica;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.notifica.DettaglioFileULLSLUBean;
import com.nttdata.tim.now.data.dto.base.ResultDTO;

@JsonInclude(Include.NON_NULL)
public class DettaglioFileULLSLUOutputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("listacampi")
    private List<DettaglioFileULLSLUBean> listacampi;

    @JsonProperty("result")
    private ResultDTO result;

    public List<DettaglioFileULLSLUBean> getListacampi() {
        return listacampi;
    }

    public void setListacampi(List<DettaglioFileULLSLUBean> listacampi) {
        this.listacampi = listacampi;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }
}