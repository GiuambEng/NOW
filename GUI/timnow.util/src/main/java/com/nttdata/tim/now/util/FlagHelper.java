package com.nttdata.tim.now.util;

public class FlagHelper {
	private static final String N = "N";
	private static final String SI = "Si";
	private static final String S = "S";
	private static final String YES = "Yes";
	private static final String Y = "Y";

	private FlagHelper() {
	}

	// DTO -> Bean
	public static boolean convertFromBE(String source) {
		if ((source != null) && (source.equalsIgnoreCase(Y) || source.equalsIgnoreCase(YES) || source.equalsIgnoreCase(S) || source.equalsIgnoreCase(SI))) {
			return true;
		}
		return false;
	}

	// Bean -> DTO
	public static String convertFromFE(boolean source) {
		if (source) {
			return Y;
		}
		return N;
	}

}
