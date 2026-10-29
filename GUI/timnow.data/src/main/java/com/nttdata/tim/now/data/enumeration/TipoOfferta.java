package com.nttdata.tim.now.data.enumeration;

public enum TipoOfferta {
	SLU("SLU", "regolatorio"), ULL("ULL", "regolatorio"), ULLDati("ULLDati", "regolatorio"),
	BITSTREAM_NGA_FTTCAB("BitstreamNGAFTTCAB", "nga-vula"), BITSTREAM_NGA_FTTH("BitstreamNGAFTTH", "nga-vula"),
	BITSTREAM_ATMA_SIMMETRICOFLAT("BitstreamATMAsimmetricoFlat", "atm"),
	BITSTREAM_ATMA_SIMMETRICOHL("BitstreamATMAsimmetricoHL", "atm"),
	BITSTREAM_ATM_SIMMETRICOFLAT("BitstreamATMSimmetricoFlat", "atm"),
	BITSTREAM_ATM_SIMMETRICOHL("BitstreamATMSimmetricoHL", "atm"),
	BITSTREAM_ATMA_SIMMETRICOLITE("BitstreamATMAsimmetricoLite", "atm"),
	BITSTREAM_GBEA_SIMMETRICOFLAT("BitstreamGBEAsimmetricoFlat", "gbe"),
	BITSTREAM_GBE_SIMMETRICOFLAT("BitstreamGBESimmetricoFlat", "gbe"), VULAFTTCAB("VULAFTTCAB", "nga-vula"),
	VULAFTTH("VULAFTTH", "nga-vula"), EASYIP_BASEPLUSFLAT("EasyIPBasePlusFlat", "easyip"),
	EASYIP_BASEPLUSLITE("EasyIPBasePlusLite", "easyip"),
	EASYIP_SPECIALPROFILEFLAT("EasyIPSpecialProfileFlat", "easyip"),
	EASYIP_SPECIALPROFILELITE("EasyIPSpecialProfileLite", "easyip"), EASYIP_IPUBBFTTCAB("EasyIPUBBFTTCAB", "nga-vula"),
	EASYIP_IPUBBFTTH("EasyIPUBBFTTH", "nga-vula"), Fixed_Wireless_Access("FixedWirelessAccess", "FWA"), // RU_716
	WLR("WLR", "regolatorio"), NP("NP", "regolatorio"), VULL("VULL", "regolatorio"), SHA("SHA", "regolatorio"),
	ALL("ALL", "regolatorio"),
	// RU_915
	CPS("CPS", "cps"),
	// RU_1058
	VLANNGA("VLANNGA", "vlan"), VLANVULA("VLANVULA", "vlan"), VLAN("VLAN", "vlan"), VP("VP", "VP"),
	// RU_1150
	UBBFULLGPON("UBBFULLGPON", "UBBFULLGPON"), UBBFSEMIGPON("UBBSEMIGPON", "UBBSEMIGPON"),
	// RU_1164
	SEMI_VULA_FTTH("SEMIVULAFTTH", "SEMIVULAFTTH"),
	SEMI_BITSTREAM_NGA_FTTH("SEMIBitstreamNGAFTTH", "SEMIBitstreamNGAFTTH"),
	SEMI_EASYIP_UBB_FTTH("SEMIEasyIPUBBFTTH", "SEMIEasyIPUBBFTTH"),
	// RU_1180
	FEEDER("FEEDER", "FEEDER"),
	// RU_1462
	FIBERSTREAM("FIBERSTREAM", "FIBERSTREAM"),
	// RU_1475
	FWAITALIA1GIGASARDEGNA("FWAITALIA1GIGASARDEGNA", "FWAITALIA1GIGASARDEGNA"),
	// RU_1543
	FULLGPONPLUS("FULLGPONPLUS", "FULLGPONPLUS"), 
	FULLGPONPLUSNGA("FULLGPONPLUSNGA", "FULLGPONPLUSNGA"),
	// RU_1581
	SEMIGPON1BPNRR("SEMIGPON1BPNRR", "SEMIGPON1BPNRR"),
	FULLGPON1BPNRR("FULLGPON1BPNRR", "FULLGPON1BPNRR")
	;

	private String offerName;
	private String offerFamily;

	private TipoOfferta(String name, String family) {
		this.offerName = name;
		this.offerFamily = family;
	}

	public String getOfferName() {
		return offerName;
	}

	public String getOfferFamily() {
		return offerFamily;
	}

	public static String getFamilyFromString(String name) {
		for (TipoOfferta item : TipoOfferta.values()) {
			// System.out.println("*****************item.getOfferName()=
			// "+item.getOfferName()+" | name= "+name);
			if (item.getOfferName().equals(name)) {
				return item.getOfferFamily();
			}
		}
		throw new IllegalArgumentException("L'offerta " + name + " non esiste");
	}

}
