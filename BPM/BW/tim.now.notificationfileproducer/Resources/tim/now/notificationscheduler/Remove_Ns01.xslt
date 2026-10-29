<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        exclude-result-prefixes="msxsl ns0"
        xmlns:msxsl="urn:schemas-microsoft-com:xslt"
        xmlns:ns01="http://xsd.telecomitalia.it/crm/xdsl/order"
        xmlns:ns0="http://xsd.telecomitalia.it/crm/xdsl/order">
 <xsl:output method="xml" indent="yes"/>

 <xsl:template match="ns01:*">  
  <xsl:element name="ns0:{local-name()}">   
   <xsl:apply-templates select="@* | node()"/>
  </xsl:element>
 </xsl:template>
 <xsl:template match="@ns01:*">
  <xsl:attribute name="ns0:{local-name()}">
   <xsl:value-of select="."/>
  </xsl:attribute>
 </xsl:template>
 <xsl:template match="node()">
  <xsl:copy>
   <xsl:apply-templates select="@* | node()"/>
  </xsl:copy>
 </xsl:template>
 <xsl:template match="@*">
  <xsl:copy/>
 </xsl:template>
</xsl:stylesheet>