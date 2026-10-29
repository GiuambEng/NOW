<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"  xmlns:tns="http://www.example.org/MonitoraggioAgcom" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	<Monitoraggio>
	<xsl:for-each select="tns:MonitoraggioAgcomT1/tns:MonitoraggioAgcomT1ListOut" >
	<xsl:if test="tns:OLO='WIND'">
	<wind>
	<dataRif>
	        <data><xsl:value-of select="tns:dataRif" /></data>
	        <lavorati><xsl:value-of select="tns:lavorati" /></lavorati>
			<OK><xsl:value-of select="tns:OK" /></OK>
			<KO><xsl:value-of select="tns:KO" /></KO>
			<entroPrimaDAC_SLA><xsl:value-of select="tns:entroPrimaDAC_SLA" /></entroPrimaDAC_SLA>
			<oltrePrimaDAC_SLA><xsl:value-of select="tns:oltrePrimaDAC_SLA" /></oltrePrimaDAC_SLA>
			<diCuiGiacenzaRIM><xsl:value-of select="tns:diCuiGiacenzaRIM" /></diCuiGiacenzaRIM>
			<diCuiFuoriSLA><xsl:value-of select="tns:diCuiFuoriSLA" /></diCuiFuoriSLA>
			<diCuiGiacenzaDAC_Scaduta><xsl:value-of select="tns:diCuiGiacenzaDAC_Scaduta" /></diCuiGiacenzaDAC_Scaduta>
			<giacenzaScadutaTotaleDACeSLA><xsl:value-of select="tns:giacenzaScadutaTotaleDACeSLA" /></giacenzaScadutaTotaleDACeSLA>
			<giacenzaScadutaTotaleSuGiacenza><xsl:value-of select="tns:giacenzaScadutaTotaleSuGiacenza" /></giacenzaScadutaTotaleSuGiacenza>
			
       </dataRif>
	</wind>
	</xsl:if>
		<xsl:if test="tns:OLO='VODAFONE'">
		
	<vodafone>
	<dataRif>
	        <data><xsl:value-of select="tns:dataRif" /></data>
	        <lavorati><xsl:value-of select="tns:lavorati" /></lavorati>
			<OK><xsl:value-of select="tns:OK" /></OK>
			<KO><xsl:value-of select="tns:KO" /></KO>
			<entroPrimaDAC_SLA><xsl:value-of select="tns:entroPrimaDAC_SLA" /></entroPrimaDAC_SLA>
			<oltrePrimaDAC_SLA><xsl:value-of select="tns:oltrePrimaDAC_SLA" /></oltrePrimaDAC_SLA>
			<diCuiGiacenzaRIM><xsl:value-of select="tns:diCuiGiacenzaRIM" /></diCuiGiacenzaRIM>
			<diCuiFuoriSLA><xsl:value-of select="tns:diCuiFuoriSLA" /></diCuiFuoriSLA>
			<diCuiGiacenzaDAC_Scaduta><xsl:value-of select="tns:diCuiGiacenzaDAC_Scaduta" /></diCuiGiacenzaDAC_Scaduta>
			<giacenzaScadutaTotaleDACeSLA><xsl:value-of select="tns:giacenzaScadutaTotaleDACeSLA" /></giacenzaScadutaTotaleDACeSLA>
			<giacenzaScadutaTotaleSuGiacenza><xsl:value-of select="tns:giacenzaScadutaTotaleSuGiacenza" /></giacenzaScadutaTotaleSuGiacenza>
			
       </dataRif>
	
	</vodafone>
	</xsl:if>
	
		 
		<xsl:if test="tns:OLO='ALBACOM'">
		
	<albacom>
	<dataRif>
	        <data><xsl:value-of select="tns:dataRif" /></data>
	        <lavorati><xsl:value-of select="tns:lavorati" /></lavorati>
			<OK><xsl:value-of select="tns:OK" /></OK>
			<KO><xsl:value-of select="tns:KO" /></KO>
			<entroPrimaDAC_SLA><xsl:value-of select="tns:entroPrimaDAC_SLA" /></entroPrimaDAC_SLA>
			<oltrePrimaDAC_SLA><xsl:value-of select="tns:oltrePrimaDAC_SLA" /></oltrePrimaDAC_SLA>
			<diCuiGiacenzaRIM><xsl:value-of select="tns:diCuiGiacenzaRIM" /></diCuiGiacenzaRIM>
			<diCuiFuoriSLA><xsl:value-of select="tns:diCuiFuoriSLA" /></diCuiFuoriSLA>
			<diCuiGiacenzaDAC_Scaduta><xsl:value-of select="tns:diCuiGiacenzaDAC_Scaduta" /></diCuiGiacenzaDAC_Scaduta>
			<giacenzaScadutaTotaleDACeSLA><xsl:value-of select="tns:giacenzaScadutaTotaleDACeSLA" /></giacenzaScadutaTotaleDACeSLA>
			<giacenzaScadutaTotaleSuGiacenza><xsl:value-of select="tns:giacenzaScadutaTotaleSuGiacenza" /></giacenzaScadutaTotaleSuGiacenza>
			
       </dataRif>
	
	</albacom>
	</xsl:if>	
	 
		<xsl:if test="tns:OLO='FASTWEB'">
		
	<fastweb>
	<dataRif>
	        <data><xsl:value-of select="tns:dataRif" /></data>
	        <lavorati><xsl:value-of select="tns:lavorati" /></lavorati>
			<OK><xsl:value-of select="tns:OK" /></OK>
			<KO><xsl:value-of select="tns:KO" /></KO>
			<entroPrimaDAC_SLA><xsl:value-of select="tns:entroPrimaDAC_SLA" /></entroPrimaDAC_SLA>
			<oltrePrimaDAC_SLA><xsl:value-of select="tns:oltrePrimaDAC_SLA" /></oltrePrimaDAC_SLA>
			<diCuiGiacenzaRIM><xsl:value-of select="tns:diCuiGiacenzaRIM" /></diCuiGiacenzaRIM>
			<diCuiFuoriSLA><xsl:value-of select="tns:diCuiFuoriSLA" /></diCuiFuoriSLA>
			<diCuiGiacenzaDAC_Scaduta><xsl:value-of select="tns:diCuiGiacenzaDAC_Scaduta" /></diCuiGiacenzaDAC_Scaduta>
			<giacenzaScadutaTotaleDACeSLA><xsl:value-of select="tns:giacenzaScadutaTotaleDACeSLA" /></giacenzaScadutaTotaleDACeSLA>
			<giacenzaScadutaTotaleSuGiacenza><xsl:value-of select="tns:giacenzaScadutaTotaleSuGiacenza" /></giacenzaScadutaTotaleSuGiacenza>
			
       </dataRif>
	
	</fastweb>
	</xsl:if>
	 <xsl:if test="tns:OLO='NODETTAGLIO'">
		
	<nodettaglio>
	<dataRif>
	        <data><xsl:value-of select="tns:dataRif" /></data>
	        <lavorati><xsl:value-of select="tns:lavorati" /></lavorati>
			<OK><xsl:value-of select="tns:OK" /></OK>
			<KO><xsl:value-of select="tns:KO" /></KO>
			<entroPrimaDAC_SLA><xsl:value-of select="tns:entroPrimaDAC_SLA" /></entroPrimaDAC_SLA>
			<oltrePrimaDAC_SLA><xsl:value-of select="tns:oltrePrimaDAC_SLA" /></oltrePrimaDAC_SLA>
			<diCuiGiacenzaRIM><xsl:value-of select="tns:diCuiGiacenzaRIM" /></diCuiGiacenzaRIM>
			<diCuiFuoriSLA><xsl:value-of select="tns:diCuiFuoriSLA" /></diCuiFuoriSLA>
			<diCuiGiacenzaDAC_Scaduta><xsl:value-of select="tns:diCuiGiacenzaDAC_Scaduta" /></diCuiGiacenzaDAC_Scaduta>
			<giacenzaScadutaTotaleDACeSLA><xsl:value-of select="tns:giacenzaScadutaTotaleDACeSLA" /></giacenzaScadutaTotaleDACeSLA>
			<giacenzaScadutaTotaleSuGiacenza><xsl:value-of select="tns:giacenzaScadutaTotaleSuGiacenza" /></giacenzaScadutaTotaleSuGiacenza>
			
       </dataRif>
	
	</nodettaglio>
	</xsl:if>
	</xsl:for-each>
	</Monitoraggio>
		 
	</xsl:template>
	 
</xsl:stylesheet>
