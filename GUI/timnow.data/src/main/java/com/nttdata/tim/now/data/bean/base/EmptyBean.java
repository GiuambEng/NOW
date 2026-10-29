package com.nttdata.tim.now.data.bean.base;

import java.io.Serializable;

import com.nttdata.tim.now.data.bean.result.Result;

public class EmptyBean extends AbstractOutputBean implements Serializable {
	private static final long serialVersionUID = 1329042395436454236L;

	public EmptyBean(Result result) {
		this.result = result;
	}

	public EmptyBean() {
		// Default empty constructor.
	}
}
