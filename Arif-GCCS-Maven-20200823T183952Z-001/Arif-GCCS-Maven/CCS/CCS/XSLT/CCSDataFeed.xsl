<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:fox="http://xml.apache.org/fop/extensions" xmlns:foa="http://fabio">
	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
		<xsl:apply-templates />
	</xsl:template>
	<xsl:template match="@*|node()">
		<xsl:if test="self::APPLIEDTO">
				<xsl:copy>
					<xsl:apply-templates select="@*[ancestor::POADetails]|node()[ancestor::POADetails]"/>
				</xsl:copy>			
		</xsl:if>
		<xsl:if test="not(self::APPLIEDTO)">
			<xsl:copy>
				<xsl:apply-templates select="@*[not(ancestor-or-self::POADetails)]|node()[not(ancestor-or-self::POADetails)]"/>
			</xsl:copy>
		</xsl:if>	
	</xsl:template>
</xsl:stylesheet>
