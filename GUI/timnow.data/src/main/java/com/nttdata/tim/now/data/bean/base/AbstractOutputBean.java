package com.nttdata.tim.now.data.bean.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.nttdata.tim.now.data.bean.result.Result;

@JsonInclude(Include.NON_NULL)
public abstract class AbstractOutputBean implements Serializable  {

    private static final long serialVersionUID = -1853100054742328437L;
    protected Result result;
    protected Boolean isLimitedList;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Boolean getIsLimitedList() {
		return isLimitedList;
	}

	public void setIsLimitedList(Boolean isLimitedList) {
		this.isLimitedList = isLimitedList;
	}

}
