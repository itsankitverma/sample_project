<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:fox="http://xml.apache.org/fop/extensions"	xmlns:foa="http://fabio">
	<xsl:attribute-set name="TableCell" foa:class="table-cell">
		<xsl:attribute name="padding-left">5.4pt</xsl:attribute>
		<xsl:attribute name="padding-bottom">0cm</xsl:attribute>
		<xsl:attribute name="padding-top">0cm</xsl:attribute>
		<xsl:attribute name="width">142.05pt</xsl:attribute>
		<xsl:attribute name="padding-right">5.4pt</xsl:attribute>
		<xsl:attribute name="border-style">solid</xsl:attribute>
		<xsl:attribute name="font-size">10</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="TableCellRight" foa:class="table-cell">
		<xsl:attribute name="padding-left">5.4pt</xsl:attribute>
		<xsl:attribute name="padding-bottom">0cm</xsl:attribute>
		<xsl:attribute name="padding-top">0cm</xsl:attribute>
		<xsl:attribute name="width">142.05pt</xsl:attribute>
		<xsl:attribute name="padding-right">5.4pt</xsl:attribute>
		<xsl:attribute name="border-style">solid</xsl:attribute>
		<xsl:attribute name="text-align">right</xsl:attribute>
		<xsl:attribute name="font-size">10</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="Table" foa:class="table">
		<xsl:attribute name="space-before">0.7cm</xsl:attribute>
		<xsl:attribute name="border-collapse">collapse</xsl:attribute>
		<xsl:attribute name="border-style">none</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="TableRow" foa:class="table-row"/>
	<xsl:attribute-set name="NormalBlock" foa:class="block">
		<xsl:attribute name="space-after">0.5cm</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="CenteredBlock" foa:class="block">
		<xsl:attribute name="space-after">2cm</xsl:attribute>
		<xsl:attribute name="text-align">center</xsl:attribute>
		<xsl:attribute name="font-family">Helvetica</xsl:attribute>
		<xsl:attribute name="font-weight">bold</xsl:attribute>
		<xsl:attribute name="font-size">24pt</xsl:attribute>
	</xsl:attribute-set>
	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>
	<xsl:variable name="dots">l</xsl:variable>
	<xsl:variable name="circles">m</xsl:variable>
	<xsl:variable name="squares">n</xsl:variable>
	<xsl:strip-space elements="RECEIVABLE"/>
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master margin-left="0.5cm" page-width="216mm" margin-right="0.5cm"
					margin-bottom="1cm" margin-top="1cm" master-name="Page" page-height="280mm">
					<fo:region-body margin-left="0cm" margin-right="0cm" margin-bottom="1cm"
						margin-top="1cm"/>
				</fo:simple-page-master>
				<fo:page-sequence-master master-name="PageSeq">
					<fo:repeatable-page-master-reference master-reference="Page"/>
				</fo:page-sequence-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="PageSeq">
				<fo:flow flow-name="xsl-region-body">
                    <fo:block xsl:use-attribute-sets="CenteredBlock"> Missing Invoice Report </fo:block>
					<xsl:apply-templates select="/REPORT/RECEIVABLES"/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<xsl:template match="REPORT/RECEIVABLES" foa:name="List" foa:class="table" foa:group="simple-table">
		<fo:table table-layout="fixed" width="20cm" xsl:use-attribute-sets="Table"  table-omit-footer-at-break="true">
            <fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-column column-number="3" column-width="4cm"/>
			<fo:table-column column-number="4" column-width="4cm"/>
			<fo:table-column column-number="5" column-width="3cm"/>
			<fo:table-column column-number="6" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell" text-align="center">
                        <fo:block> Location </fo:block>
                    </fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell" text-align="center">
						<fo:block> AWB Nbr </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell" text-align="center">
						<fo:block> Customer </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell" text-align="center">
						<fo:block> Inv. Number </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell" text-align="center">
						<fo:block> Date </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell" text-align="center">
						<fo:block> Rec. Amount </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<xsl:for-each select="RECEIVABLE">
					<fo:table-row xsl:use-attribute-sets=" TableRow">
                        <fo:table-cell text-align="center" xsl:use-attribute-sets="TableCellRight">
                            <fo:block font-size="10pt">
                                <xsl:value-of select="LOC_CD"/>
                            </fo:block>
                        </fo:table-cell>
						<fo:table-cell text-align="center" xsl:use-attribute-sets="TableCellRight">
							<fo:block font-size="10pt">
								<xsl:value-of select="AWB_NBR"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell">
							<fo:block font-size="10pt">
								<xsl:value-of select="CUST_NM"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="center" xsl:use-attribute-sets="TableCellRight">
							<fo:block font-size="10pt">
								<xsl:value-of select="REC_NBR"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="center" xsl:use-attribute-sets="TableCellRight">
							<fo:block font-size="10pt">
								<xsl:value-of select="REC_DT"/>
							</fo:block>
						</fo:table-cell>
						<fo:table-cell text-align="right" xsl:use-attribute-sets="TableCell">
							<fo:block font-size="10pt">
								<xsl:value-of select="REC_AMT"/>
							</fo:block>
						</fo:table-cell>
					</fo:table-row>
				</xsl:for-each>
			</fo:table-body>
		</fo:table>
	</xsl:template>
</xsl:stylesheet>
