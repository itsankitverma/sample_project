<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:fox="http://xml.apache.org/fop/extensions" xmlns:foa="http://fabio">
	<!--xsl:import href="http://lac-memapp01.prod.fedex.com:9999/CCS/XSLT/stylesAtts.xsl"/-->
  <xsl:attribute-set name="TableCell1" foa:class="table-cell">
    <xsl:attribute name="padding-left">2.4pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">0cm</xsl:attribute>
    <xsl:attribute name="padding-top">0cm</xsl:attribute>
    <xsl:attribute name="width">252.05pt</xsl:attribute>
    <xsl:attribute name="padding-right">2.4pt</xsl:attribute>
    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="font-size">10</xsl:attribute>
  </xsl:attribute-set>
  <xsl:attribute-set name="TableCell1Right" foa:class="table-cell">
    <xsl:attribute name="padding-left">2.4pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">0cm</xsl:attribute>
    <xsl:attribute name="padding-top">0cm</xsl:attribute>
    <xsl:attribute name="width">252.05pt</xsl:attribute>
    <xsl:attribute name="padding-right">2.4pt</xsl:attribute>
    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="text-align">right</xsl:attribute>
    <xsl:attribute name="font-size">10</xsl:attribute>    
  </xsl:attribute-set>
  <xsl:attribute-set name="Table1" foa:class="table">
    <xsl:attribute name="space-before">0.7cm</xsl:attribute>
    <xsl:attribute name="border-collapse">collapse</xsl:attribute>
    <xsl:attribute name="border-style">none</xsl:attribute>
  </xsl:attribute-set>
  <xsl:attribute-set name="TableRow1" foa:class="table-row">
  </xsl:attribute-set>
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
				<fo:simple-page-master margin-left="0.5cm" page-width="280mm" margin-right="0.5cm" margin-bottom="1cm" margin-top="1cm" master-name="Page" page-height="216mm">
					<fo:region-body margin-left="0cm" margin-right="0cm" margin-bottom="1cm" margin-top="1cm"/>
				</fo:simple-page-master>
				<fo:page-sequence-master master-name="PageSeq">
					<fo:repeatable-page-master-reference master-reference="Page"/>
				</fo:page-sequence-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="PageSeq">
				<fo:flow flow-name="xsl-region-body">
					<xsl:apply-templates select="/REPORT/HEADER/LOCATION"/>
					<xsl:apply-templates select="/REPORT/ROD_RECEIVABLES"/>
					<xsl:apply-templates select="/REPORT/COD_RECEIVABLES"/>
					<xsl:apply-templates select="/REPORT/FTC_RECEIVABLES"/>
					<xsl:apply-templates select="/REPORT/PREP_AWBS"/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<xsl:template match="REPORT/HEADER/LOCATION" foa:name="Month" foa:class="block" foa:group="paragraph">
		<fo:block xsl:use-attribute-sets=" CenteredBlock">
             		     Cleared Receivables with Exceptions
    		</fo:block>
		<fo:block text-align="center" font-size="16">
  		           Location: <xsl:apply-templates/>           Date: <xsl:value-of select="/REPORT/HEADER/DATE"/>
		</fo:block>
	</xsl:template>
	<!--ROD PART-->
	<xsl:template match="REPORT/ROD_RECEIVABLES" foa:name="List" foa:class="table" foa:group="simple-table">
		<xsl:if test="count(//REPORT/ROD_RECEIVABLES/RECEIVABLE)">
			<fo:block text-align="left" space-before="1cm" font-size="16">
  		           ROD Receivables Exceptions
		</fo:block>
			<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="25.3cm" space-before="0.5cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
				<fo:table-column column-number="1" column-width="1cm"/>
				<fo:table-column column-number="2" column-width="1.9cm"/>
				<fo:table-column column-number="3" column-width="1.5cm"/>
				<fo:table-column column-number="4" column-width="1.9cm"/>
				<fo:table-column column-number="5" column-width="1.9cm"/>
				<fo:table-column column-number="6" column-width="1.6cm"/>
				<fo:table-column column-number="7" column-width="1.6cm"/>
				<fo:table-column column-number="8" column-width="1.6cm"/>
				<fo:table-column column-number="9" column-width="1.6cm"/>
				<fo:table-column column-number="10" column-width="1.4cm"/>
				<fo:table-column column-number="11" column-width="1.5cm"/>
				<fo:table-column column-number="12" column-width="0.7cm"/>
				<fo:table-column column-number="13" column-width="1.5cm"/>	
				<fo:table-column column-number="14" column-width="2cm"/>	
				<fo:table-column column-number="15" column-width="2cm"/>	
																											
				<fo:table-header>
					<fo:table-row>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				C.Agent
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				AWB Nbr.
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Rec. Nbr.
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Courier
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Inv. Amount
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Scan
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Cash
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Check
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Deposit
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				C.Card
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Doc. Nbr.
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Crrcy
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Comment
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Misc. #
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Misc. Date
			                  		 </fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-header>
				<fo:table-body>
					<xsl:apply-templates/>
				</fo:table-body>
			</fo:table>
		</xsl:if>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE" foa:name="List" foa:class="table-row" foa:group="simple-table" foa:type="table-row">
		<fo:table-row foa:name="List" foa:group="simple-table" xsl:use-attribute-sets=" TableRow1">
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/CHNG_STATUS_EMPLOYEE_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/AWB_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/REC_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/COURIER_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/REC_AMT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/SCAN_AMOUNT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/CASH_PAYMENT_AMT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/CHECK_PAYMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/DEPOSIT_PAYMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/CREDIT_CARD_PAYMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/OTHER_DOC_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/CURRENCY" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/CHKIN_AGENT_COMMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/MISCELLANEOUS_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	<xsl:template match="REPORT/ROD_RECEIVABLES/RECEIVABLE/MISCELLANEOUS_DATE" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
<!--COD PART-->
	<xsl:template match="REPORT/COD_RECEIVABLES" foa:name="List" foa:class="table" foa:group="simple-table">
		<xsl:if test="count(//REPORT/COD_RECEIVABLES/COD_RECEIVABLE)">
			<fo:block text-align="left" space-before="1cm" font-size="16">
  		           COD Receivables Exceptions
		</fo:block>
			<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="25.3cm" space-before="0.5cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
				<fo:table-column column-number="1" column-width="1cm"/>
				<fo:table-column column-number="2" column-width="1.9cm"/>
				<fo:table-column column-number="3" column-width="1.5cm"/>
				<fo:table-column column-number="4" column-width="1.9cm"/>
				<fo:table-column column-number="5" column-width="1.9cm"/>
				<fo:table-column column-number="6" column-width="1.6cm"/>
				<fo:table-column column-number="7" column-width="1.6cm"/>
				<fo:table-column column-number="8" column-width="1.6cm"/>
				<fo:table-column column-number="9" column-width="1.6cm"/>
				<fo:table-column column-number="10" column-width="1.4cm"/>
				<fo:table-column column-number="11" column-width="1.5cm"/>
				<fo:table-column column-number="12" column-width="0.7cm"/>
				<fo:table-column column-number="13" column-width="1.5cm"/>	
				<fo:table-column column-number="14" column-width="2cm"/>	
				<fo:table-column column-number="15" column-width="2cm"/>																								
				<fo:table-header>
					<fo:table-row>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				C.Agent
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				AWB Nbr.
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Rec. Nbr.
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Courier
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Inv. Amount
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Scan
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Cash
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Check
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Deposit
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				C.Card
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Doc. Nbr.
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Crrcy
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Comment
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Misc. #
			            	 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Misc. Date
			            	 </fo:block>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-header>
				<fo:table-body>
					<xsl:apply-templates/>
				</fo:table-body>
			</fo:table>
		</xsl:if>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE" foa:name="List" foa:class="table-row" foa:group="simple-table" foa:type="table-row">
		<fo:table-row foa:name="List" foa:group="simple-table" xsl:use-attribute-sets=" TableRow1">
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/CHNG_STATUS_EMPLOYEE_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/AWB_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/REC_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/COURIER_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/REC_AMT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/SCAN_AMOUNT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/CASH_PAYMENT_AMT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/CHECK_PAYMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/DEPOSIT_PAYMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/CREDIT_CARD_PAYMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/OTHER_DOC_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/CURRENCY" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/COD_RECEIVABLES/COD_RECEIVABLE/CHKIN_AGENT_COMMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	<xsl:template match="REPORT/ROD_RECEIVABLES/COD_RECEIVABLE/MISCELLANEOUS_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	<xsl:template match="REPORT/ROD_RECEIVABLES/COD_RECEIVABLE/MISCELLANEOUS_DATE" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	
	
	<!--FTC PART-->
	<xsl:template match="REPORT/FTC_RECEIVABLES" foa:name="List" foa:class="table" foa:group="simple-table">
		<xsl:if test="count(//REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE)">
			<fo:block text-align="left" space-before="1cm" font-size="16">
  		           FTC Receivables Exceptions
		</fo:block>
			<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="25.3cm" space-before="0.5cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
				<fo:table-column column-number="1" column-width="1cm"/>
				<fo:table-column column-number="2" column-width="1.9cm"/>
				<fo:table-column column-number="3" column-width="1.5cm"/>
				<fo:table-column column-number="4" column-width="1.9cm"/>
				<fo:table-column column-number="5" column-width="1.9cm"/>
				<fo:table-column column-number="6" column-width="1.6cm"/>
				<fo:table-column column-number="7" column-width="1.6cm"/>
				<fo:table-column column-number="8" column-width="1.6cm"/>
				<fo:table-column column-number="9" column-width="1.6cm"/>
				<fo:table-column column-number="10" column-width="1.4cm"/>
				<fo:table-column column-number="11" column-width="1.5cm"/>
				<fo:table-column column-number="12" column-width="0.7cm"/>
				<fo:table-column column-number="13" column-width="1.5cm"/>	
				<fo:table-column column-number="14" column-width="2cm"/>	
				<fo:table-column column-number="15" column-width="2cm"/>																							
				<fo:table-header>
					<fo:table-row>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				C.Agent
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				AWB Nbr.
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Rec. Nbr.
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Courier
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Inv. Amount
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Scan
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Cash
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Check
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Deposit
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				C.Card
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Doc. Nbr.
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Crrcy
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Comment
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Misc. #
			            	 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Misc. Date
			            	 </fo:block>
						</fo:table-cell>						
					</fo:table-row>
				</fo:table-header>
				<fo:table-body>
					<xsl:apply-templates/>
				</fo:table-body>
			</fo:table>
		</xsl:if>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE" foa:name="List" foa:class="table-row" foa:group="simple-table" foa:type="table-row">
		<fo:table-row foa:name="List" foa:group="simple-table" xsl:use-attribute-sets=" TableRow1">
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/CHNG_STATUS_EMPLOYEE_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/AWB_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/REC_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/COURIER_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/REC_AMT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/SCAN_AMOUNT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/CASH_PAYMENT_AMT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/CHECK_PAYMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/DEPOSIT_PAYMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/CREDIT_CARD_PAYMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/OTHER_DOC_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/CURRENCY" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/FTC_RECEIVABLES/FTC_RECEIVABLE/CHKIN_AGENT_COMMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	<xsl:template match="REPORT/ROD_RECEIVABLES/FTC_RECEIVABLE/MISCELLANEOUS_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	<xsl:template match="REPORT/ROD_RECEIVABLES/FTC_RECEIVABLE/MISCELLANEOUS_DATE" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
											
	<!--PREPAID PART-->
	<xsl:template match="REPORT/PREP_AWBS" foa:name="List" foa:class="table" foa:group="simple-table">
		<xsl:if test="count(//REPORT/PREP_AWBS/AWBS)">
			<fo:block text-align="left" space-before="1cm" font-size="16">
  		           Prepaid AWBs Exceptions
		</fo:block>
			<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="24.1cm" space-before="0.5cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
				<fo:table-column column-number="1" column-width="1cm"/>
				<fo:table-column column-number="2" column-width="2cm"/>
				<fo:table-column column-number="3" column-width="2cm"/>
				<fo:table-column column-number="4" column-width="1.8cm"/>
				<fo:table-column column-number="5" column-width="1.8cm"/>
				<fo:table-column column-number="6" column-width="1.8cm"/>
				<fo:table-column column-number="7" column-width="1.8cm"/>
				<fo:table-column column-number="8" column-width="1.8cm"/>
				<fo:table-column column-number="9" column-width="1.6cm"/>
				<fo:table-column column-number="10" column-width="1cm"/>
				<fo:table-column column-number="11" column-width="2cm"/>
				<fo:table-column column-number="12" column-width="2cm"/>
				<fo:table-column column-number="13" column-width="2cm"/>
				<fo:table-header>
					<fo:table-row>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Chk Agent
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				AWB Nbr.
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Courier
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Scan
			                  		 </fo:block>
						</fo:table-cell>						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Cash
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Check
			                  		 </fo:block>
						</fo:table-cell>
						
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Coupon
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				C.Card
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"  font-size="7"  text-align="center">
							<fo:block font-size="8pt">
	                        				Doc. Nbr.
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Crrcy
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Comment
			                  		 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Misc. #
			            	 </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1"   font-size="7" text-align="center">
							<fo:block font-size="8pt">
	                        				Misc. Date
			            	 </fo:block>
						</fo:table-cell>							
					</fo:table-row>
				</fo:table-header>
				<fo:table-body>
					<xsl:apply-templates/>
				</fo:table-body>
			</fo:table>
		</xsl:if>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS" foa:name="List" foa:class="table-row" foa:group="simple-table" foa:type="table-row">
		<fo:table-row foa:name="List" foa:group="simple-table" xsl:use-attribute-sets=" TableRow1">
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS/CHNG_STATUS_EMPLOYEE_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS/AWB_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS/COURIER_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS/SCAN_AMOUNT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS/CASH_PAYMENT_AMT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS/CHECK_PAYMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS/COUP_PYMT_AMT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS/CREDIT_CARD_PAYMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:value-of select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS/OTHER_DOC_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="right" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS/CURRENCY" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS/CHKIN_AGENT_COMMENT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="REPORT/PREP_AWBS/AWBS//MISCELLANEOUS_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	<xsl:template match="REPORT/PREP_AWBS/AWBS//MISCELLANEOUS_DATE" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table"   font-size="7"  text-align="left" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="8pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	
</xsl:stylesheet>		