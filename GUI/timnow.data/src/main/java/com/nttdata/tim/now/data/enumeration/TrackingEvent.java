package com.nttdata.tim.now.data.enumeration;

public enum TrackingEvent {
    LOGIN("LOGIN", "LOGIN"),
    LOGOUT("LOGOUT", "LOGOUT"),
	BANDE("Bande Picco", "Bande Picco"),
	FAQ_MANAGEMENT("FAQ Management", "FAQ Management"),
	HELP_MANAGEMENT("iHelp Management", "iHelp Management"),
	ATM("Kit ATM", "Kit ATM"),
	NEWS_INFORMATIVE("News e Informative Migrazione", "News e Informative Migrazione"),
	PROFILI_LINEA("Profili Linea", "Profili Linea"),
	VC("Profili VC", "Profili VC"),
	SLA("SLA Time", "SLA Time"),
	LAN("VLAN/SVLAN", "VLAN/SVLAN"),
	VP("VP", "VP"),
	CLIENTE("Cliente", "Cliente"),
	CONTATTO("Contatto", "Contatto"),
	CONTRATTO("Contratto", "Contratto"),
	CESSAZIONE("Cessazione", "Cessazione"),
	ASSET("Lista Asset", "Lista Asset"),
	CATALOGO("Catalogo", "Catalogo"),
	NOTIFICHE("File di Notifiche", "File di Notifiche"),
	STATO_FILE("Stato File Ordini e Richieste", "Stato File Ordini e Richieste"),
	UPLOAD("Upload File Ordini e Richieste", "Upload File Ordini e Richieste"),
	FAQ("FAQ", "FAQ"),
	HELP("iHelp", "iHelp"),
	MANUALE("Manuale", "Manuale"),
	NEWS("News", "News"),
	STORICO_NEWS("Storico News", "Storico News"),
	ORDER_TRACKING("Order Tracking", "Order Tracking"),
	ORDINI("Lista Ordini", "Lista Ordini"),
	NUOVA_RICHIESTA("Nuova Richiesta", "Nuova Richiesta"),
	NUOVO_ORDINE("Nuovo Ordine", "Nuovo Ordine"),
	ACCODATI("Ordini Accodati", "Ordini Accodati"),
	BOZZA("Ordini in Bozza", "Ordini in Bozza"),
	SOSPESI("Ordini Sospesi", "Ordini Sospesi"),
	DISAMBIGUAZIONE("Pagina di Disambiguazione", "Pagina di Disambiguazione"),
	FATTURAZIONE("Monitoraggio Fatturazione", "Monitoraggio Fatturazione"),
	MONITORAGGIO_FILE("Monitoraggio File", "Monitoraggio File"),
	MONITORAGGIO_GIACENZA("Monitoraggio Giacenza", "Monitoraggio Giacenza"),
	MONITORAGGIO_KO("Monitoraggio KO", "Monitoraggio KO"),
	MONITORAGGIO_NOTIFICHE("Monitoraggio Notifiche", "Monitoraggio Notifiche"),
	MONITORAGGIO_ODV("Monitoraggio ODV", "Monitoraggio ODV"),
	MONITORAGGIO_DAC("Monitoraggio Rimodulazioni DAC", "Monitoraggio Rimodulazioni DAC"),
	MONITORAGGIO_INTERFACCE("Monitoraggio Staging Interfacce NOW", "Monitoraggio Staging Interfacce NOW"),
	MONITORAGGIO_TEMPI("Monitoraggio Tempi di Attraversamento", "Monitoraggio Tempi di Attraversamento"),
	TRACKING("Tracking Applicativo", "Tracking Applicativo"),
	
	//RU_902
	DOWNLOAD("Download file", "Download file"),
	EXPORT("Export file", "Export file");
	
	private final String code;
	private final String description;
	
	private TrackingEvent(String code, String description) {
		this.code = code;
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
}
