package com.nttdata.tim.now.data.enumeration;

public enum ProfiloCRM {
	CRM_DG,
	CRM_DGRO,
	CRM_DGRO_CON,
	CRM_DG_CON,
	CRM_DG_REG_UO,
	CRM_GA,
	CRM_NEWS,
	CRM_OLO,
	CRM_OLORO,
	CRM_PPS;
	
	public static ProfiloCRM getProfilo(String nomeProfilo){
		for (ProfiloCRM profilo : ProfiloCRM.values()) {
			if (profilo.name().equals(nomeProfilo)) {
				return profilo;
			}
		}
		return null;
	}
}
