package com.nttdata.tim.now.util.data.converter;

import org.dozer.DozerConverter;

public class StringToBooleanConverter extends DozerConverter<String, Boolean> {

	private static final String N = "N";
	private static final String SI = "Si";
	private static final String S = "S";
	private static final String YES = "Yes";
	private static final String Y = "Y";

	public StringToBooleanConverter() {
		super(String.class, Boolean.class);
	}

	public Boolean convertTo(String source, Boolean destination) {
		return source != null && (source.equalsIgnoreCase(Y) || source.equalsIgnoreCase(YES) || source.equalsIgnoreCase(S) || source.equalsIgnoreCase(SI) || source.equalsIgnoreCase(Boolean.TRUE.toString()));
	}

	public String convertFrom(Boolean source, String destination) {
		return null != source && source ? Y : N;
	}

}
