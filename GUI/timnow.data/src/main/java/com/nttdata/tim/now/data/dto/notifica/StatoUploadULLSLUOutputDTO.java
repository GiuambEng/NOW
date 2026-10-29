package com.nttdata.tim.now.data.dto.notifica;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.notifica.StatoFileMigrazioneUllSluBean;
import com.nttdata.tim.now.data.dto.base.ResultDTO;

@JsonInclude(Include.NON_NULL)
public class StatoUploadULLSLUOutputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("listacampi")
    private List<StatoFileMigrazioneUllSluBean> listacampi;

    @JsonProperty("result")
    private ResultDTO result;

    public List<StatoFileMigrazioneUllSluBean> getListacampi() {
        return listacampi;
    }

    public void setListacampi(List<StatoFileMigrazioneUllSluBean> listacampi) {
        this.listacampi = listacampi;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }
}