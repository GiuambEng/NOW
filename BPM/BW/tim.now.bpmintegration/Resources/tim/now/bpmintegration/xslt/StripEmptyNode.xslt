<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema-instance">
    <xsl:output method="xml" indent="yes" omit-xml-declaration="yes"/>
	<xsl:strip-space elements="*"/>
	<xsl:template match="/">  
		<Output>  
		   <xsl:apply-templates select="node()/node()//*"/>
		</Output>
		<!--<Output>  Utile se  si vuol far comparire EVENTO NOTIFICA e TESTATA con tutti i valori uniti.
            <xsl:apply-templates select="//*"/> 
        </Output>   -->
	</xsl:template>
	<xsl:template match="*">
		<Coppia>
			<NodeName><xsl:value-of select="local-name()"/></NodeName>
			<NodeValue><xsl:value-of select="."/></NodeValue>
			<NodeCount>
				<xsl:value-of select="count(parent::*/preceding-sibling::*)+1"/>
			</NodeCount>       
		</Coppia>
	</xsl:template>
</xsl:stylesheet>