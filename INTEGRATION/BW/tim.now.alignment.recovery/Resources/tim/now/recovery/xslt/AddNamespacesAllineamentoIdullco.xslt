<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/|comment()|processing-instruction()">
		<xsl:copy>
			<xsl:apply-templates/>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="*">
		<xsl:element name="{local-name()}" namespace="http://www.tim.com/NOW/xsd/AcquisizioneIDULCOOLO.recovery/">
			<!-- go process attributes and children -->
			<xsl:apply-templates select="@*|node()"/>
		</xsl:element>
	</xsl:template>
	<xsl:template match="@*">
		<xsl:attribute name="{local-name()}"><xsl:value-of select="."/></xsl:attribute>
	</xsl:template>
</xsl:stylesheet>