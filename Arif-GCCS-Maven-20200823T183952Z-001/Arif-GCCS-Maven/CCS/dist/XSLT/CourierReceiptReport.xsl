<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:fox="http://xml.apache.org/fop/extensions" xmlns:foa="http://fabio">
	<!--xsl:import href="http://lac-memapp01.prod.fedex.com:9999/CCS/XSLT/stylesAtts.xsl"/-->
  <xsl:attribute-set name="TableCell1" foa:class="table-cell">
    <xsl:attribute name="padding-left">5.4pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">0cm</xsl:attribute>
    <xsl:attribute name="padding-top">0cm</xsl:attribute>
    <xsl:attribute name="width">142.05pt</xsl:attribute>
    <xsl:attribute name="padding-right">5.4pt</xsl:attribute>
    <xsl:attribute name="border-style">solid</xsl:attribute>
    <xsl:attribute name="font-size">10</xsl:attribute>
  </xsl:attribute-set>
  <xsl:attribute-set name="TableCell1Right" foa:class="table-cell">
    <xsl:attribute name="padding-left">5.4pt</xsl:attribute>
    <xsl:attribute name="padding-bottom">0cm</xsl:attribute>
    <xsl:attribute name="padding-top">0cm</xsl:attribute>
    <xsl:attribute name="width">142.05pt</xsl:attribute>
    <xsl:attribute name="padding-right">5.4pt</xsl:attribute>
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
				<fo:simple-page-master margin-left="0.5cm" page-width="216mm" margin-right="0.5cm" margin-bottom="1cm" margin-top="1cm" master-name="Page" page-height="280mm">
					<fo:region-body margin-left="0cm" margin-right="0cm" margin-bottom="1cm" margin-top="1cm"/>
				</fo:simple-page-master>
				<fo:page-sequence-master master-name="PageSeq">
					<fo:repeatable-page-master-reference master-reference="Page"/>
				</fo:page-sequence-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="PageSeq">
				<fo:flow flow-name="xsl-region-body">
					<xsl:apply-templates select="/REPORT/HEADER/LOCATION"/>
					<xsl:apply-templates select="/REPORT/ROD_PART"/>
					<xsl:apply-templates select="/REPORT/PREP_PART"/>
                    <xsl:apply-templates select="/REPORT/OAC_PART"/>
					<xsl:apply-templates select="/REPORT/POA_PART"/>
                    <xsl:apply-templates select="/REPORT/GRND_PART"/>
                    <xsl:apply-templates select="/REPORT/COD_PART"/>
                    <xsl:apply-templates select="/REPORT/FTC_PART"/>
                    
					<!--xsl:call-template name="Summary"/-->
					<xsl:apply-templates select="/REPORT/ROD_PART/ROD_CURR_PART"/>
					<xsl:apply-templates select="/REPORT/PREP_PART/PREP_CURR_PART"/>
                    <xsl:apply-templates select="/REPORT/OAC_PART/OAC_CURR_PART"/>
					<xsl:apply-templates select="/REPORT/POA_PART/POA_CURR_PART"/>
                    <xsl:apply-templates select="/REPORT/GRND_PART/GRND_CURR_PART"/>
                    <xsl:apply-templates select="/REPORT/COD_PART/COD_CURR_PART"/>
                    <xsl:apply-templates select="/REPORT/FTC_PART/FTC_CURR_PART"/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<!-- TITLES AND SUMMARY -->
	<xsl:template match="REPORT/HEADER/LOCATION">
		<fo:block text-align="center" font-family="Helvetica" font-weight="bold" font-size="24pt" space-after="1cm">
             		 Courier Payments Receipt
    		</fo:block>
		<fo:block text-align="center" font-size="18pt">
  		           Location: <xsl:apply-templates/>
		</fo:block>
		<fo:block text-align="center" font-size="18pt" space-before="0.5cm" >
  		          Courier: <xsl:value-of select="/REPORT/HEADER/COURIER_ID"/> - <xsl:value-of select="/REPORT/HEADER/COURIER_NAME"/>
		</fo:block>	
		<fo:block text-align="center" font-size="18pt" space-before="0.5cm" >
  		          Check-In Agent: <xsl:value-of select="/REPORT/HEADER/CHKING_AGENT_ID"/> - <xsl:value-of select="/REPORT/HEADER/CHKING_AGENT_NAME"/>
		</fo:block>			
		<fo:block text-align="center" font-size="18pt" space-before="0.5cm" space-after="1cm">
  		          Date: <xsl:value-of select="/REPORT/HEADER/REPORT_DATE"/>
		</fo:block>
	</xsl:template>
	<xsl:template match="REPORT/ROD_PART">
		<fo:block text-align="center" font-size="20">
  		           ROD Totals
		</fo:block>
		<fo:table table-layout="fixed" width="19cm" text-align="center" space-after="1cm" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-column column-number="3" column-width="3cm"/>
			<fo:table-column column-number="4" column-width="3cm"/>
			<fo:table-column column-number="5" column-width="3cm"/>
			<fo:table-column column-number="6" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Currency
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Cash
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Check
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Deposit
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Credit Card
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Total
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<xsl:call-template name="RODSummary"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template name="RODSummary">
		<xsl:for-each select="/REPORT/ROD_PART/ROD_CURR_PART">
			<xsl:variable name="cashTotal" select="sum(ROD_RECEIVABLES/ROD_RECEIVABLE/CASH_PAYMENT_AMT)"/>
			<xsl:variable name="checkTotal" select="sum(ROD_RECEIVABLES/ROD_RECEIVABLE/CHECK_PAYMENT)"/>
			<xsl:variable name="depositTotal" select="sum(ROD_RECEIVABLES/ROD_RECEIVABLE/DEPOSIT_PAYMENT)"/>
			<xsl:variable name="creditCardTotal" select="sum(ROD_RECEIVABLES/ROD_RECEIVABLE/CREDIT_CARD_PAYMENT)"/>
			
			<fo:table-row xsl:use-attribute-sets=" TableRow1">
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="CURRENCY_CODE"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($checkTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($depositTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($creditCardTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal+$checkTotal+$depositTotal+$creditCardTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</xsl:for-each>
	</xsl:template>

	<xsl:template match="REPORT/COD_PART">
		<fo:block text-align="center" font-size="20">
  		           COD Totals
		</fo:block>
		<fo:table table-layout="fixed" width="19cm" text-align="center" space-after="1cm" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-column column-number="3" column-width="3cm"/>
			<fo:table-column column-number="4" column-width="3cm"/>
			<fo:table-column column-number="5" column-width="3cm"/>
			<fo:table-column column-number="6" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Currency
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Cash
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Check
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Deposit
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Credit Card
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Total
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<xsl:call-template name="CODSummary"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template name="CODSummary">
		<xsl:for-each select="/REPORT/COD_PART/COD_CURR_PART">
			<xsl:variable name="cashTotal" select="sum(COD_RECEIVABLES/COD_RECEIVABLE/CASH_PAYMENT_AMT)"/>
			<xsl:variable name="checkTotal" select="sum(COD_RECEIVABLES/COD_RECEIVABLE/CHECK_PAYMENT)"/>
			<xsl:variable name="depositTotal" select="sum(COD_RECEIVABLES/COD_RECEIVABLE/DEPOSIT_PAYMENT)"/>
			<xsl:variable name="creditCardTotal" select="sum(COD_RECEIVABLES/COD_RECEIVABLE/CREDIT_CARD_PAYMENT)"/>
			
			<fo:table-row xsl:use-attribute-sets=" TableRow1">
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="CURRENCY_CODE"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($checkTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($depositTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($creditCardTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal+$checkTotal+$depositTotal+$creditCardTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</xsl:for-each>
	</xsl:template>


	<xsl:template match="REPORT/FTC_PART">
		<fo:block text-align="center" font-size="20">
  		           FTC Totals
		</fo:block>
		<fo:table table-layout="fixed" width="19cm" text-align="center" space-after="1cm" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-column column-number="3" column-width="3cm"/>
			<fo:table-column column-number="4" column-width="3cm"/>
			<fo:table-column column-number="5" column-width="3cm"/>
			<fo:table-column column-number="6" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Currency
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Cash
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Check
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Deposit
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Credit Card
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Total
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<xsl:call-template name="FTCSummary"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template name="FTCSummary">
		<xsl:for-each select="/REPORT/FTC_PART/FTC_CURR_PART">
			<xsl:variable name="cashTotal" select="sum(FTC_RECEIVABLES/FTC_RECEIVABLE/CASH_PAYMENT_AMT)"/>
			<xsl:variable name="checkTotal" select="sum(FTC_RECEIVABLES/FTC_RECEIVABLE/CHECK_PAYMENT)"/>
			<xsl:variable name="depositTotal" select="sum(FTC_RECEIVABLES/FTC_RECEIVABLE/DEPOSIT_PAYMENT)"/>
			<xsl:variable name="creditCardTotal" select="sum(FTC_RECEIVABLES/FTC_RECEIVABLE/CREDIT_CARD_PAYMENT)"/>
			
			<fo:table-row xsl:use-attribute-sets=" TableRow1">
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="CURRENCY_CODE"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($checkTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($depositTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($creditCardTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal+$checkTotal+$depositTotal+$creditCardTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</xsl:for-each>
	</xsl:template>



    <xsl:template match="REPORT/PREP_PART">
		<fo:block text-align="center" font-size="20">
  		           Prepaid Totals
		</fo:block>
		<fo:table table-layout="fixed" width="19cm" text-align="center" space-after="1cm"  table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-column column-number="3" column-width="3cm"/>
			<fo:table-column column-number="4" column-width="3cm"/>
			<fo:table-column column-number="5" column-width="3cm"/>
			<fo:table-column column-number="6" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Currency
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Cash
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Check
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Coupon
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Credit Card
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Total
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<xsl:call-template name="PREPSummary"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template name="PREPSummary">
		<xsl:for-each select="/REPORT/PREP_PART/PREP_CURR_PART">
			<xsl:variable name="cashTotal" select="sum(PREP_AWBS/PREP_AWB/CASH_PAYMENT_AMT)"/>
			<xsl:variable name="checkTotal" select="sum(PREP_AWBS/PREP_AWB/CHECK_PAYMENT)"/>
			<xsl:variable name="couponTotal" select="sum(PREP_AWBS/PREP_AWB/COUP_PYMT_AMT)"/>
			<xsl:variable name="creditCardTotal" select="sum(PREP_AWBS/PREP_AWB/CREDIT_CARD_PAYMENT)"/>
			<fo:table-row xsl:use-attribute-sets=" TableRow1">
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="CURRENCY_CODE"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($checkTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($couponTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($creditCardTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal+$checkTotal+$couponTotal+$creditCardTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</xsl:for-each>
	</xsl:template>

	<xsl:template match="REPORT/OAC_PART">
		<fo:block text-align="center" font-size="20">
  		           OAC Totals
		</fo:block>
		<fo:table table-layout="fixed" width="19cm" text-align="center" space-after="1cm"  table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-column column-number="3" column-width="3cm"/>
			<fo:table-column column-number="4" column-width="3cm"/>
			<fo:table-column column-number="5" column-width="3cm"/>
			<!--<fo:table-column column-number="6" column-width="3cm"/>  -->
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Currency
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Cash
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Check
	                  			 </fo:block>
					</fo:table-cell>
					<!--<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Coupon
	                  			 </fo:block>
					</fo:table-cell>   -->
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Credit Card
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Total
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<xsl:call-template name="OACSummary"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template name="OACSummary">
		<xsl:for-each select="/REPORT/OAC_PART/OAC_CURR_PART">
			<xsl:variable name="cashTotal" select="sum(OAC_AWBS/OAC_AWB/CASH_PAYMENT_AMT)"/>
			<xsl:variable name="checkTotal" select="sum(OAC_AWBS/OAC_AWB/CHECK_PAYMENT)"/>
			<!--<xsl:variable name="couponTotal" select="sum(OAC_AWBS/OAC_AWB/COUP_PYMT_AMT)"/>-->
			<xsl:variable name="creditCardTotal" select="sum(OAC_AWBS/OAC_AWB/CREDIT_CARD_PAYMENT)"/>
			<fo:table-row xsl:use-attribute-sets=" TableRow1">
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="CURRENCY_CODE"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($checkTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<!--<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($couponTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>-->
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($creditCardTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal+$checkTotal+$creditCardTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</xsl:for-each>
	</xsl:template>

	<xsl:template match="REPORT/POA_PART">
		<fo:block text-align="center" font-size="20">
  		           POA Totals
		</fo:block>
		<fo:table table-layout="fixed" width="19cm" text-align="center" space-after="1cm" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-column column-number="3" column-width="3cm"/>
			<fo:table-column column-number="4" column-width="3cm"/>
			<fo:table-column column-number="5" column-width="3cm"/>
			<fo:table-column column-number="6" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Currency
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Cash
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Check
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Credit Card
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Deposit
	                  			 </fo:block>
					</fo:table-cell>					
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			Total
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<xsl:call-template name="POASummary"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template name="POASummary">
		<xsl:for-each select="/REPORT/POA_PART/POA_CURR_PART">
			<xsl:variable name="cashTotal" select="sum(POA_PAYMENTS/POA_PAYMENT/CASH_PAYMENT_AMT)"/>
			<xsl:variable name="checkTotal" select="sum(POA_PAYMENTS/POA_PAYMENT/CHECK_PAYMENT)"/>
			<xsl:variable name="creditCardTotal" select="sum(POA_PAYMENTS/POA_PAYMENT/CREDIT_CARD_PAYMENT)"/>			
			<xsl:variable name="depositTotal" select="sum(POA_PAYMENTS/POA_PAYMENT/DEPOSIT_PAYMENT)"/>			
			<fo:table-row xsl:use-attribute-sets=" TableRow1">
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="CURRENCY_CODE"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($checkTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($creditCardTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($depositTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>				
				<fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
					<fo:block font-size="10pt">
						<xsl:value-of select="format-number($cashTotal+$checkTotal+$creditCardTotal+$depositTotal,'############0.00')"/>
					</fo:block>
				</fo:table-cell>
			</fo:table-row>
		</xsl:for-each>
	</xsl:template>

    <xsl:template match="REPORT/GRND_PART">
        <fo:block text-align="center" font-size="20">
                     Ground Totals
        </fo:block>
        <fo:table table-layout="fixed" width="19cm" text-align="center" space-after="1cm"  table-omit-footer-at-break="true">
            <fo:table-column column-number="1" column-width="3cm"/>
            <fo:table-column column-number="2" column-width="3cm"/>
            <fo:table-column column-number="3" column-width="3cm"/>
            <fo:table-column column-number="4" column-width="3cm"/>
            <fo:table-column column-number="5" column-width="3cm"/>
            <fo:table-column column-number="6" column-width="3cm"/>
            <fo:table-header>
                <fo:table-row>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                        Currency
                                   </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                        Cash
                                   </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                        Check
                                   </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                        Coupon
                                   </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                       Credit Card
                                   </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                       Total
                                   </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-header>
            <fo:table-body>
                <xsl:call-template name="GRNDSummary"/>
            </fo:table-body>
        </fo:table>
    </xsl:template>
    <xsl:template name="GRNDSummary">
        <xsl:for-each select="/REPORT/GRND_PART/GRND_CURR_PART">
            <xsl:variable name="cashTotal" select="sum(GRND_TRAK_NBRS/GRND_TRAK_NBR/CASH_PAYMENT_AMT)"/>
            <xsl:variable name="checkTotal" select="sum(GRND_TRAK_NBRS/GRND_TRAK_NBR/CHECK_PAYMENT)"/>
            <xsl:variable name="couponTotal" select="sum(GRND_TRAK_NBRS/GRND_TRAK_NBR/COUP_PYMT_AMT)"/>
            <xsl:variable name="creditCardTotal" select="sum(GRND_TRAK_NBRS/GRND_TRAK_NBR/CREDIT_CARD_PAYMENT)"/>
            <fo:table-row xsl:use-attribute-sets=" TableRow1">
                <fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
                    <fo:block font-size="10pt">
                        <xsl:value-of select="CURRENCY_CODE"/>
                    </fo:block>
                </fo:table-cell>
                <fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
                    <fo:block font-size="10pt">
                        <xsl:value-of select="format-number($cashTotal,'############0.00')"/>
                    </fo:block>
                </fo:table-cell>
                <fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
                    <fo:block font-size="10pt">
                        <xsl:value-of select="format-number($checkTotal,'############0.00')"/>
                    </fo:block>
                </fo:table-cell>
                <fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
                    <fo:block font-size="10pt">
                        <xsl:value-of select="format-number($couponTotal,'############0.00')"/>
                    </fo:block>
                </fo:table-cell>
                <fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
                    <fo:block font-size="10pt">
                        <xsl:value-of select="format-number($creditCardTotal,'############0.00')"/>
                    </fo:block>
                </fo:table-cell>
                <fo:table-cell xsl:use-attribute-sets=" TableCell1Right">
                    <fo:block font-size="10pt">
                        <xsl:value-of select="format-number($cashTotal+$checkTotal+$couponTotal+$creditCardTotal,'############0.00')"/>
                    </fo:block>
                </fo:table-cell>
            </fo:table-row>
        </xsl:for-each>
    </xsl:template>

	<xsl:template name="Summary">
		<xsl:for-each select="//REPORT/ROD_PART/ROD_CURR_PART/CURRENCY_CODE|/REPORT/PREP_PART/PREP_CURR_PART/CURRENCY_CODE|/REPORT/OAC_PART/OAC_CURR_PART/CURRENCY_CODE|/REPORT/POA_PART/POA_CURR_PART/CURRENCY_CODE">
			<xsl:sort select="." data-type="text" order="ascending"/>
			<xsl:if test="not(. = preceding::CURRENCY_CODE)">
				<xsl:variable name="currentCurrency" select="."/>
				<xsl:variable name="cashTotal" select="format-number(sum(//REPORT/ROD_PART/ROD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/ROD_RECEIVABLES/ROD_RECEIVABLE/CASH_PAYMENT_AMT|//REPORT/PREP_PART/PREP_CURR_PART[CURRENCY_CODE = $currentCurrency ]/PREP_AWBS/PREP_AWB/CASH_PAYMENT_AMT|//REPORT/OAC_PART/OAC_CURR_PART[CURRENCY_CODE = $currentCurrency ]/OAC_AWBS/OAC_AWB/CASH_PAYMENT_AMT|//REPORT/POA_PART/POA_CURR_PART[CURRENCY_CODE = $currentCurrency ]/POA_PAYMENTS/POA_PAYMENT/CASH_PAYMENT_AMT),'############0.00')"/>
				<xsl:variable name="checkTotal" select="format-number(sum(//REPORT/ROD_PART/ROD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/ROD_RECEIVABLES/ROD_RECEIVABLE/CHECK_PAYMENT|//REPORT/PREP_PART/PREP_CURR_PART[CURRENCY_CODE = $currentCurrency ]/PREP_AWBS/PREP_AWB/CHECK_PAYMENT|//REPORT/OAC_PART/OAC_CURR_PART[CURRENCY_CODE = $currentCurrency ]/OAC_AWBS/OAC_AWB/CHECK_PAYMENT|//REPORT/POA_PART/POA_CURR_PART[CURRENCY_CODE = $currentCurrency ]/POA_PAYMENTS/POA_PAYMENT/CHECK_PAYMENT),'############0.00')"/>
				<fo:block font-size="20" space-before="0.5cm" text-align="center">
					Cash Deposit Total (<xsl:value-of select="$currentCurrency" />)
				</fo:block>
				<fo:table table-layout="fixed" width="15cm" text-align="center" space-after="0.5cm" table-omit-footer-at-break="true">
					<fo:table-column column-number="1" column-width="5cm"/>
					<fo:table-column column-number="2" column-width="5cm"/>
					<fo:table-column column-number="3" column-width="5cm"/>
					<fo:table-header>
						<fo:table-row>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
		                       			 Cash
		                  			 </fo:block>
							</fo:table-cell>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
		                       			 Check
		                  			 </fo:block>
							</fo:table-cell>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
		                       			Subtotal
		                  			 </fo:block>
							</fo:table-cell>
						</fo:table-row>
					</fo:table-header>
					<fo:table-body>
						<fo:table-row>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
		                       			<xsl:value-of select="format-number($cashTotal,'############0.00')" />
		                  			 </fo:block>
							</fo:table-cell>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
		                       			<xsl:value-of select="format-number($checkTotal,'############0.00')" />
		                  			 </fo:block>
							</fo:table-cell>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
		                       			<xsl:value-of select="format-number($cashTotal+$checkTotal,'############0.00')" />
		                  			 </fo:block>
							</fo:table-cell>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell/>
							<fo:table-cell>
								<fo:block text-align="right" font-size="12">
		                       			Adjustments
		                  			 </fo:block>
							</fo:table-cell>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1"/>
						</fo:table-row>
						<fo:table-row>
							<fo:table-cell/>
							<fo:table-cell>
								<fo:block text-align="right" font-size="12">
		                       			 Final Deposit Totals
		                  			 </fo:block>
							</fo:table-cell>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1"/>
						</fo:table-row>
					</fo:table-body>
				</fo:table>
			</xsl:if>
		</xsl:for-each>
		<fo:block font-size="20" space-before="1cm" text-align="center">
					Adjustments descriptions
				</fo:block>
		<fo:table>
			<fo:table-column column-number="1" column-width="19cm"/>
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" height="5cm">
						<fo:block/>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<!--DETAILS ROD-->
	<xsl:template match="/REPORT/ROD_PART/ROD_CURR_PART">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			ROD Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="2.8cm"/>
			<fo:table-column column-number="2" column-width="2.2cm"/>
			<fo:table-column column-number="3" column-width="2.5cm"/>
			<fo:table-column column-number="4" column-width="2.5cm"/>
			<fo:table-column column-number="5" column-width="2.5cm"/>
			<fo:table-column column-number="6" column-width="2.5cm"/>
			<fo:table-column column-number="7" column-width="2.5cm"/>
			<fo:table-column column-number="8" column-width="2.3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Awb Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
							Inv. Number
			                    </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Inv. Amount
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Cash
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                       Check
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Deposit
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        C. Card
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Doc. Number
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell/>
					<fo:table-cell text-align="right">
						<fo:block>
							Totals
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(ROD_RECEIVABLES/ROD_RECEIVABLE/REC_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(ROD_RECEIVABLES/ROD_RECEIVABLE/CASH_PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(ROD_RECEIVABLES/ROD_RECEIVABLE/CHECK_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(ROD_RECEIVABLES/ROD_RECEIVABLE/DEPOSIT_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(ROD_RECEIVABLES/ROD_RECEIVABLE/CREDIT_CARD_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="ROD_RECEIVABLES/ROD_RECEIVABLE"/>
			</fo:table-body>
		</fo:table>
<!--ROD CHECKS-->	
        <xsl:if test="count(//ROD_CHECKS/ROD_CHECK)>0">
		<fo:block break-before="page" font-size="14pt" text-align="center" font-weight="bold">
			ROD Checks in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="10cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Check Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(ROD_CHECKS/ROD_CHECK/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="ROD_CHECKS/ROD_CHECK"/>
			</fo:table-body>
		</fo:table>	
	  </xsl:if>			
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/AWB_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/REC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/REC_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/CASH_PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/CHECK_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/DEPOSIT_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/CREDIT_CARD_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_CHECKS/ROD_CHECK">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="ROD_CHECKS/ROD_CHECK/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_CHECKS/ROD_CHECK/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>	





<!--DETAILS COD-->
	<xsl:template match="/REPORT/COD_PART/COD_CURR_PART">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			COD Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="2.8cm"/>
			<fo:table-column column-number="2" column-width="2.2cm"/>
			<fo:table-column column-number="3" column-width="2.5cm"/>
			<fo:table-column column-number="4" column-width="2.5cm"/>
			<fo:table-column column-number="5" column-width="2.5cm"/>
			<fo:table-column column-number="6" column-width="2.5cm"/>
			<fo:table-column column-number="7" column-width="2.5cm"/>
			<fo:table-column column-number="8" column-width="2.3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Awb Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
							Inv. Number
			                    </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Inv. Amount
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Cash
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                       Check
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Deposit
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        C. Card
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Doc. Number
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell/>
					<fo:table-cell text-align="right">
						<fo:block>
							Totals
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(COD_RECEIVABLES/COD_RECEIVABLE/COD_REC_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(COD_RECEIVABLES/COD_RECEIVABLE/CASH_PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(COD_RECEIVABLES/COD_RECEIVABLE/CHECK_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(COD_RECEIVABLES/COD_RECEIVABLE/DEPOSIT_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(COD_RECEIVABLES/COD_RECEIVABLE/CREDIT_CARD_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="COD_RECEIVABLES/COD_RECEIVABLE"/>
			</fo:table-body>
		</fo:table>
<!--COD CHECKS-->	
        <xsl:if test="count(//COD_CHECKS/COD_CHECK)>0">
		<fo:block break-before="page" font-size="14pt" text-align="center" font-weight="bold">
			COD Checks in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="10cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Check Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(COD_CHECKS/COD_CHECK/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="COD_CHECKS/COD_CHECK"/>
			</fo:table-body>
		</fo:table>	
	  </xsl:if>			
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/AWB_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/COD_REC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/COD_REC_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/CASH_PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/CHECK_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/DEPOSIT_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/CREDIT_CARD_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_CHECKS/COD_CHECK">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="COD_CHECKS/COD_CHECK/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_CHECKS/COD_CHECK/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>	




<!--DETAILS FTC-->
	<xsl:template match="/REPORT/FTC_PART/FTC_CURR_PART">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			FTC Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="2.8cm"/>
			<fo:table-column column-number="2" column-width="2.2cm"/>
			<fo:table-column column-number="3" column-width="2.5cm"/>
			<fo:table-column column-number="4" column-width="2.5cm"/>
			<fo:table-column column-number="5" column-width="2.5cm"/>
			<fo:table-column column-number="6" column-width="2.5cm"/>
			<fo:table-column column-number="7" column-width="2.5cm"/>
			<fo:table-column column-number="8" column-width="2.3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Awb Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
							Inv. Number
			                    </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Inv. Amount
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Cash
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                       Check
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Deposit
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        C. Card
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Doc. Number
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell/>
					<fo:table-cell text-align="right">
						<fo:block>
							Totals
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(FTC_RECEIVABLES/FTC_RECEIVABLE/FTC_REC_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(FTC_RECEIVABLES/FTC_RECEIVABLE/CASH_PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(FTC_RECEIVABLES/FTC_RECEIVABLE/CHECK_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(FTC_RECEIVABLES/FTC_RECEIVABLE/DEPOSIT_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(FTC_RECEIVABLES/FTC_RECEIVABLE/CREDIT_CARD_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="FTC_RECEIVABLES/FTC_RECEIVABLE"/>
			</fo:table-body>
		</fo:table>
<!--FTC CHECKS-->	
        <xsl:if test="count(//FTC_CHECKS/FTC_CHECK)>0">
		<fo:block break-before="page" font-size="14pt" text-align="center" font-weight="bold">
			FTC Checks in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="10cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Check Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(FTC_CHECKS/FTC_CHECK/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="FTC_CHECKS/FTC_CHECK"/>
			</fo:table-body>
		</fo:table>	
	  </xsl:if>			
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/AWB_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/FTC_REC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/FTC_REC_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/CASH_PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/CHECK_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/DEPOSIT_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/CREDIT_CARD_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_CHECKS/FTC_CHECK">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="FTC_CHECKS/FTC_CHECK/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_CHECKS/FTC_CHECK/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>	





<!--DETAILS PREPAID-->
	<xsl:template match="/REPORT/PREP_PART/PREP_CURR_PART">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			Prepaid Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="2.5cm"/>
			<fo:table-column column-number="2" column-width="2.5cm"/>
			<fo:table-column column-number="3" column-width="2.5cm"/>
			<fo:table-column column-number="4" column-width="2.5cm"/>
			<fo:table-column column-number="5" column-width="2.5cm"/>
			<fo:table-column column-number="6" column-width="2.5cm"/>
			<fo:table-column column-number="7" column-width="2.5cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Awb Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Scan Amount
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Cash
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                       Check
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Coupon
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        C. Card
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Doc. Number
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell>
						<fo:block text-align="right">
			                        Totals
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(PREP_AWBS/PREP_AWB/SCAN_AMOUNT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(PREP_AWBS/PREP_AWB/CASH_PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(PREP_AWBS/PREP_AWB/CHECK_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(PREP_AWBS/PREP_AWB/COUP_PYMT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(PREP_AWBS/PREP_AWB/CREDIT_CARD_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="PREP_AWBS/PREP_AWB" />
			</fo:table-body>
		</fo:table>
<!--PREP CHECKS-->	
        <xsl:if test="count(//PREP_CHECKS/PREP_CHECK)>0">
		<fo:block break-before="page" font-size="14pt" text-align="center" font-weight="bold">
			Prepaid Checks in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="10cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Check Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(PREP_CHECKS/PREP_CHECK/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="PREP_CHECKS/PREP_CHECK"/>
			</fo:table-body>
		</fo:table>
       </xsl:if>			
	</xsl:template>	
	<xsl:template match="PREP_AWBS/PREP_AWB">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/AWB_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/SCAN_AMOUNT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/CASH_PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/CHECK_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/COUP_PYMT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/CREDIT_CARD_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:value-of select="."/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_CHECKS/PREP_CHECK">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="PREP_CHECKS/PREP_CHECK/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_CHECKS/PREP_CHECK/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
    <!--DETAILS OAC-->
	<xsl:template match="/REPORT/OAC_PART/OAC_CURR_PART">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			OAC Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="2.5cm"/>
			<fo:table-column column-number="2" column-width="2.5cm"/>
			<fo:table-column column-number="3" column-width="2.5cm"/>
			<fo:table-column column-number="4" column-width="2.5cm"/>
			<fo:table-column column-number="5" column-width="2.5cm"/>
			<fo:table-column column-number="6" column-width="2.5cm"/>
			<!--<fo:table-column column-number="7" column-width="2.5cm"/>-->
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Number
	       		            </fo:block>
					</fo:table-cell>
					<!--<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Scan Amount
	       		            </fo:block>
					</fo:table-cell> -->
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Cash
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                       Check
	       		            </fo:block>
					</fo:table-cell>
					<!--<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Coupon
	       		            </fo:block>
					</fo:table-cell>-->
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        C. Card
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Doc. Number
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell>
						<fo:block text-align="right">
			                        Totals
	       		            </fo:block>
					</fo:table-cell>
					<!--<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(OAC_AWBS/OAC_AWB/SCAN_AMOUNT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>-->
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(OAC_AWBS/OAC_AWB/CASH_PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(OAC_AWBS/OAC_AWB/CHECK_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<!--<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(OAC_AWBS/OAC_AWB/COUP_PYMT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>-->
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(OAC_AWBS/OAC_AWB/CREDIT_CARD_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="OAC_AWBS/OAC_AWB" />
			</fo:table-body>
		</fo:table>
<!--OAC CHECKS-->
        <xsl:if test="count(//OAC_CHECKS/OAC_CHECK)>0">
		<fo:block break-before="page" font-size="14pt" text-align="center" font-weight="bold">
			OAC Checks in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="10cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Check Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(OAC_CHECKS/OAC_CHECK/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="OAC_CHECKS/OAC_CHECK"/>
			</fo:table-body>
		</fo:table>
       </xsl:if>
	</xsl:template>
	<xsl:template match="OAC_AWBS/OAC_AWB">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="OAC_AWBS/OAC_AWB/OB_ANC_SVC_ID_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<!--<xsl:template match="OAC_AWBS/OAC_AWB/SCAN_AMOUNT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>-->
	<xsl:template match="OAC_AWBS/OAC_AWB/CASH_PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC_AWBS/OAC_AWB/CHECK_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<!--<xsl:template match="OAC_AWBS/OAC_AWB/COUP_PYMT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>-->
	<xsl:template match="OAC_AWBS/OAC_AWB/CREDIT_CARD_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC_AWBS/OAC_AWB/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:value-of select="."/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC_CHECKS/OAC_CHECK">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="OAC_CHECKS/OAC_CHECK/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC_CHECKS/OAC_CHECK/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<!--DETAILS POA-->
	<xsl:template match="/REPORT/POA_PART/POA_CURR_PART">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			POA Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="2.4cm"/>
			<fo:table-column column-number="2" column-width="3.2cm"/>
			<fo:table-column column-number="3" column-width="2.5cm"/>
			<fo:table-column column-number="4" column-width="2.5cm"/>
			<fo:table-column column-number="5" column-width="2.5cm"/>
			<fo:table-column column-number="6" column-width="2.5cm"/>
			<fo:table-column column-number="7" column-width="2.2cm"/>			
			<fo:table-column column-number="8" column-width="3.2cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Account Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
							Customer
			                    </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Cash
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                       Check
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        C. Card
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Deposit
	       		            </fo:block>
					</fo:table-cell>					
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Doc. Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Comments
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell/>
					<fo:table-cell text-align="right">
						<fo:block>
							Totals
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(POA_PAYMENTS/POA_PAYMENT/CASH_PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(POA_PAYMENTS/POA_PAYMENT/CHECK_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(POA_PAYMENTS/POA_PAYMENT/CREDIT_CARD_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(POA_PAYMENTS/POA_PAYMENT/DEPOSIT_PAYMENT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
					<fo:table-cell/>					
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="POA_PAYMENTS/POA_PAYMENT"/>
			</fo:table-body>
		</fo:table>
<!--POA CHECKS-->
     <xsl:if test="count(//POA_CHECKS/POA_CHECK)>0">	
		<fo:block break-before="page" font-size="14pt" text-align="center" font-weight="bold">
			POA Checks in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="10cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="3cm"/>
			<fo:table-column column-number="2" column-width="5cm"/>			
			<fo:table-column column-number="3" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Check Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Customer
	       		            </fo:block>
					</fo:table-cell>					
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
	       		            </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(POA_CHECKS/POA_CHECK/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="POA_CHECKS/POA_CHECK"/>
			</fo:table-body>
		</fo:table>	
	   </xsl:if>		
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/ACCOUNT_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/CUSTOMER_NM">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/CASH_PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/CHECK_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/CREDIT_CARD_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/DEPOSIT_PAYMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>	
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/CHKIN_AGENT_COMMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_CHECKS/POA_CHECK">
		<fo:table-row>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="POA_CHECKS/POA_CHECK/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_CHECKS/POA_CHECK/CUSTOMER_NM">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="left">
				<xsl:apply-templates />
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	<xsl:template match="POA_CHECKS/POA_CHECK/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
    <!--DETAILS GROUND-->
    <xsl:template match="/REPORT/GRND_PART/GRND_CURR_PART">
        <fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
            Ground Payments in <xsl:value-of select="CURRENCY_CODE"/>
        </fo:block>
        <fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
            <fo:table-column column-number="1" column-width="3.5cm"/>
            <fo:table-column column-number="2" column-width="2.5cm"/>
            <fo:table-column column-number="3" column-width="2.5cm"/>
            <fo:table-column column-number="4" column-width="2.5cm"/>
            <fo:table-column column-number="5" column-width="2.5cm"/>
            <fo:table-column column-number="6" column-width="2.5cm"/>
            <fo:table-column column-number="7" column-width="2.5cm"/>
            <fo:table-header>
                <fo:table-row>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Tracking Number
                               </fo:block>
                    </fo:table-cell>
                    <!--<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Scan Amount
                               </fo:block>
                    </fo:table-cell>!-->
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Cash
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                   Check
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Coupon
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    C. Card
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Doc. Number
                               </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-header>
            <fo:table-footer>
                <fo:table-row>
                    <fo:table-cell>
                        <fo:block text-align="right">
                                    Totals
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                        <fo:block font-size="10pt">
                            <xsl:value-of disable-output-escaping="yes" select="format-number(sum(GRND_TRAK_NBRS/GRND_TRAK_NBR/CASH_PAYMENT_AMT),'############0.00')"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                        <fo:block font-size="10pt">
                            <xsl:value-of disable-output-escaping="yes" select="format-number(sum(GRND_TRAK_NBRS/GRND_TRAK_NBR/CHECK_PAYMENT),'############0.00')"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                        <fo:block font-size="10pt">
                            <xsl:value-of disable-output-escaping="yes" select="format-number(sum(GRND_TRAK_NBRS/GRND_TRAK_NBR/COUP_PYMT_AMT),'############0.00')"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                        <fo:block font-size="10pt">
                            <xsl:value-of disable-output-escaping="yes" select="format-number(sum(GRND_TRAK_NBRS/GRND_TRAK_NBR/CREDIT_CARD_PAYMENT),'############0.00')"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell/>
                </fo:table-row>
            </fo:table-footer>
            <fo:table-body>
                <xsl:apply-templates select="GRND_TRAK_NBRS/GRND_TRAK_NBR" />
            </fo:table-body>
        </fo:table>
<!--GROUND CHECKS-->
        <xsl:if test="count(//GRND_CHECKS/GRND_CHECK)>0">
        <fo:block break-before="page" font-size="14pt" text-align="center" font-weight="bold">
            Prepaid Checks in <xsl:value-of select="CURRENCY_CODE"/>
        </fo:block>
        <fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="10cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
            <fo:table-column column-number="1" column-width="3cm"/>
            <fo:table-column column-number="2" column-width="3cm"/>
            <fo:table-header>
                <fo:table-row>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Check Number
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Amount
                               </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-header>
            <fo:table-footer>
                <fo:table-row>
                    <fo:table-cell text-align="right">
                        <fo:block>
                            Total
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                        <fo:block font-size="10pt">
                            <xsl:value-of disable-output-escaping="yes" select="format-number(sum(GRND_CHECKS/GRND_CHECK/PAYMENT_AMT),'############0.00')"/>
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-footer>
            <fo:table-body>
                <xsl:apply-templates select="GRND_CHECKS/GRND_CHECK"/>
            </fo:table-body>
        </fo:table>
       </xsl:if>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR">
        <fo:table-row>
            <xsl:apply-templates/>
        </fo:table-row>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/GRND_TRAK_NBR">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="10pt" text-align="center">
                <xsl:apply-templates/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <!--<xsl:template match="PREP_AWBS/PREP_AWB/SCAN_AMOUNT">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="10pt" text-align="right">
                <xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>!-->
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/CASH_PAYMENT_AMT">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="10pt" text-align="right">
                <xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/CHECK_PAYMENT">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="10pt" text-align="right">
                <xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/COUP_PYMT_AMT">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="10pt" text-align="right">
                <xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/CREDIT_CARD_PAYMENT">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="10pt" text-align="right">
                <xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/OTHER_DOC_NBR">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="10pt" text-align="center">
                <xsl:value-of select="."/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_CHECKS/GRND_CHECK">
        <fo:table-row>
            <xsl:apply-templates/>
        </fo:table-row>
    </xsl:template>
    <xsl:template match="GRND_CHECKS/GRND_CHECK/OTHER_DOC_NBR">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="10pt" text-align="right">
                <xsl:apply-templates/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_CHECKS/GRND_CHECK/PAYMENT_AMT">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="10pt" text-align="right">
                <xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
</xsl:stylesheet>
