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
					<xsl:apply-templates select="/REPORT/ON_STATION/RECEIVABLES"/>
					<xsl:apply-templates select="/REPORT/DELIVERED/RECEIVABLES"/>
					<xsl:apply-templates select="/REPORT/ON_STATION/COD_RECEIVABLES"/>
					<xsl:apply-templates select="/REPORT/DELIVERED/COD_RECEIVABLES"/>
					<xsl:apply-templates select="/REPORT/ON_STATION/FTC_RECEIVABLES"/>
					<xsl:apply-templates select="/REPORT/DELIVERED/FTC_RECEIVABLES"/>					
                    <xsl:apply-templates select="/REPORT/OACS"/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	

	<xsl:template match="REPORT/HEADER/LOCATION" foa:name="Month" foa:class="block" foa:group="paragraph">
		<fo:block xsl:use-attribute-sets=" CenteredBlock">
             		     Open Receivables Report
    		</fo:block>
		<fo:block text-align="center" font-size="16pt" font-weight="bold">
		  	Location: <xsl:apply-templates/>           Date: <xsl:value-of select="/REPORT/HEADER/DATE"/>
		</fo:block>
		
		<fo:block text-align="center" font-size="14pt" space-before="2cm" font-weight="bold">
  		          ROD Summary
		</fo:block>		
		
		<fo:table table-layout="fixed" width="10cm" text-align="center" space-before="0.2cm" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="4cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-column column-number="3" column-width="3cm"/>
			<fo:table-column column-number="4" column-width="4cm"/>

			<fo:table-header>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Nº of Invoices
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Total Amount
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="left">
						<fo:block>
	                       			 On Station
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
	                       			 <xsl:value-of select="count(//ON_STATION/RECEIVABLES/RECEIVABLE)" />
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//ON_STATION/RECEIVABLES/RECEIVABLE/REC_AMOUNT),'###########0.00')"/>
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="left">
						<fo:block>
	                       			 Delivered
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
	                       			 <xsl:value-of select="count(//DELIVERED/RECEIVABLES/RECEIVABLE)" />
	                  			 </fo:block>
					</fo:table-cell>

					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//DELIVERED/RECEIVABLES/RECEIVABLE/REC_AMOUNT),'###########0.00')"/>
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell text-align="right">
						<fo:block>
	                       			 Total
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
	                       			 <xsl:value-of select="count(//RECEIVABLES/RECEIVABLE)" />
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//RECEIVABLES/RECEIVABLE/REC_AMOUNT),'###########0.00')"/>
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>

		<fo:block text-align="center" font-size="14pt" space-before="2cm" font-weight="bold">
  		          OAC Summary
		</fo:block>

        <fo:table table-layout="fixed" width="10cm" text-align="center" space-before="0.2cm" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="4cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-column column-number="3" column-width="3cm"/>
			<fo:table-column column-number="4" column-width="4cm"/>
            <fo:table-column column-number="5" column-width="4cm"/>

			<fo:table-header>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Nº of Invoices
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Total Local Amount
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Total USD Amount
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="left">
						<fo:block>
	                       			 OAC
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
	                       			 <xsl:value-of select="count(//OACS/OAC)" />
	                  			 </fo:block>
					</fo:table-cell>

					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//OACS/OAC[CURR_CD!='USD']/OTHER_PYMT_AMT|//OACS/OAC[CURR_CD!='USD']/CASH_PYMT_AMT),'###########0.00')"/>
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//OACS/OAC[CURR_CD='USD']/OTHER_PYMT_AMT|//OACS/OAC[CURR_CD='USD']/CASH_PYMT_AMT),'###########0.00')"/>
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>

		<fo:block text-align="center" font-size="14pt" space-before="2cm" font-weight="bold">
  		          COD Summary
		</fo:block>		
		
		<fo:table table-layout="fixed" width="10cm" text-align="center" space-before="0.2cm" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="4cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-column column-number="3" column-width="3cm"/>
			<fo:table-column column-number="4" column-width="4cm"/>

			<fo:table-header>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Nº of Invoices
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Total Amount
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="left">
						<fo:block>
	                       			 On Station
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
	                       			 <xsl:value-of select="count(//ON_STATION/COD_RECEIVABLES/COD_RECEIVABLE)" />
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//ON_STATION/COD_RECEIVABLES/COD_RECEIVABLE/COD_REC_AMOUNT),'###########0.00')"/>
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="left">
						<fo:block>
	                       			 Delivered
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
	                       			 <xsl:value-of select="count(//DELIVERED/COD_RECEIVABLES/COD_RECEIVABLE)" />
	                  			 </fo:block>
					</fo:table-cell>

					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//DELIVERED/COD_RECEIVABLES/COD_RECEIVABLE/COD_REC_AMOUNT),'###########0.00')"/>
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell text-align="right">
						<fo:block>
	                       			 Total
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
	                       			 <xsl:value-of select="count(//COD_RECEIVABLES/COD_RECEIVABLE)" />
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//COD_RECEIVABLES/COD_RECEIVABLE/COD_REC_AMOUNT),'###########0.00')"/>
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		
		
		<fo:block text-align="center" font-size="14pt" space-before="2cm" font-weight="bold">
  		          FTC Summary
		</fo:block>		
		
		<fo:table table-layout="fixed" width="10cm" text-align="center" space-before="0.2cm" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="4cm"/>
			<fo:table-column column-number="2" column-width="3cm"/>
			<fo:table-column column-number="3" column-width="3cm"/>
			<fo:table-column column-number="4" column-width="4cm"/>

			<fo:table-header>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Nº of Invoices
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                       			 Total Amount
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-body>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="left">
						<fo:block>
	                       			 On Station
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
	                       			 <xsl:value-of select="count(//ON_STATION/FTC_RECEIVABLES/FTC_RECEIVABLE)" />
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//ON_STATION/FTC_RECEIVABLES/FTC_RECEIVABLE/FTC_REC_AMOUNT),'###########0.00')"/>
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="left">
						<fo:block>
	                       			 Delivered
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
	                       			 <xsl:value-of select="count(//DELIVERED/FTC_RECEIVABLES/FTC_RECEIVABLE)" />
	                  			 </fo:block>
					</fo:table-cell>

					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//DELIVERED/FTC_RECEIVABLES/FTC_RECEIVABLE/FTC_REC_AMOUNT),'###########0.00')"/>
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
				<fo:table-row>
					<fo:table-cell />
					<fo:table-cell text-align="right">
						<fo:block>
	                       			 Total
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
	                       			 <xsl:value-of select="count(//FTC_RECEIVABLES/FTC_RECEIVABLE)" />
	                  			 </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
						<fo:block>
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//FTC_RECEIVABLES/FTC_RECEIVABLE/FTC_REC_AMOUNT),'###########0.00')"/>
	                  			 </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-body>
		</fo:table>
		
	</xsl:template>
	
<!-- Start ROD -->	
	<xsl:template match="/REPORT/ON_STATION/RECEIVABLES" foa:name="List" foa:class="table" foa:group="simple-table">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			On Station Open Receivables
		</fo:block>	
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<xsl:choose>
				<xsl:when test="count(RECEIVABLE/LOC_CD) &gt; 0">
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="2.5cm"/>
					<fo:table-column column-number="5" column-width="3cm"/>
					<fo:table-column column-number="6" column-width="2.5cm"/>
					<fo:table-column column-number="7" column-width="2.0cm"/>
					<fo:table-column column-number="8" column-width="2.5cm"/>
				</xsl:when>
				<xsl:otherwise>
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="4cm"/>
					<fo:table-column column-number="5" column-width="2.5cm"/>
					<fo:table-column column-number="6" column-width="3cm"/>
					<fo:table-column column-number="7" column-width="3cm"/>
				</xsl:otherwise>
			</xsl:choose>	
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        			AWB Number
			                 		  </fo:block>
					</fo:table-cell>
					<xsl:if test="count(RECEIVABLE/LOC_CD) &gt; 0">
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
							<fo:block>
								Location 
							</fo:block>
						</fo:table-cell>
					</xsl:if>		
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        Courier
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Inv. Number
	                   </fo:block>
					</fo:table-cell>					
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Customer Name
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Date
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Amount
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Status
	                   </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>					
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//ON_STATION/RECEIVABLES/RECEIVABLE/REC_AMOUNT),'###########0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>					
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	
	<xsl:template match="/REPORT/DELIVERED/RECEIVABLES" foa:name="List" foa:class="table" foa:group="simple-table">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			Delivered Open Receivables
		</fo:block>		
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<xsl:choose>
				<xsl:when test="count(RECEIVABLE/LOC_CD) &gt; 0">
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="2.5cm"/>
					<fo:table-column column-number="5" column-width="3cm"/>
					<fo:table-column column-number="6" column-width="2.5cm"/>
					<fo:table-column column-number="7" column-width="2.0cm"/>
					<fo:table-column column-number="8" column-width="2.5cm"/>
				</xsl:when>
				<xsl:otherwise>
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="4cm"/>
					<fo:table-column column-number="5" column-width="2.5cm"/>
					<fo:table-column column-number="6" column-width="3cm"/>
					<fo:table-column column-number="7" column-width="3cm"/>
				</xsl:otherwise>
			</xsl:choose>	
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        		AWB Number	
			                   </fo:block>
					</fo:table-cell>
					<xsl:if test="count(RECEIVABLE/LOC_CD) &gt; 0">
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
							<fo:block>
								Location	
							</fo:block>
						</fo:table-cell>
					</xsl:if>	
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        Courier
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Inv. Number
	                   </fo:block>
					</fo:table-cell>					
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Customer Name
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Date
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Amount
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Status
	                   </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>					
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//DELIVERED/RECEIVABLES/RECEIVABLE/REC_AMOUNT),'###########0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>					
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates/>
			</fo:table-body>
		</fo:table>
	</xsl:template>

<!-- End ROD -->

<!-- Start COD -->	
	<xsl:template match="/REPORT/ON_STATION/COD_RECEIVABLES" foa:name="List" foa:class="table" foa:group="simple-table">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			On Station Open COD Receivables
		</fo:block>	
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<xsl:choose>
				<xsl:when test="count(COD_RECEIVABLE/LOC_CD) &gt; 0">
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="2.5cm"/>
					<fo:table-column column-number="5" column-width="3cm"/>
					<fo:table-column column-number="6" column-width="2.5cm"/>
					<fo:table-column column-number="7" column-width="2.0cm"/>
					<fo:table-column column-number="8" column-width="2.5cm"/>
				</xsl:when>
				<xsl:otherwise>
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="4cm"/>
					<fo:table-column column-number="5" column-width="2.5cm"/>
					<fo:table-column column-number="6" column-width="3cm"/>
					<fo:table-column column-number="7" column-width="3cm"/>
				</xsl:otherwise>
			</xsl:choose>	
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        			AWB Number
			                 		  </fo:block>
					</fo:table-cell>
					<xsl:if test="count(COD_RECEIVABLE/LOC_CD) &gt; 0">
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
							<fo:block>
								Location 
							</fo:block>
						</fo:table-cell>
					</xsl:if>		
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        Courier
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Inv. Number
	                   </fo:block>
					</fo:table-cell>					
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Customer Name
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Date
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Amount
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Status
	                   </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>					
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//ON_STATION/COD_RECEIVABLES/COD_RECEIVABLE/COD_REC_AMOUNT),'###########0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>					
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	
	<xsl:template match="/REPORT/DELIVERED/COD_RECEIVABLES" foa:name="List" foa:class="table" foa:group="simple-table">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			Delivered Open COD Receivables
		</fo:block>		
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<xsl:choose>
				<xsl:when test="count(COD_RECEIVABLE/LOC_CD) &gt; 0">
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="2.5cm"/>
					<fo:table-column column-number="5" column-width="3cm"/>
					<fo:table-column column-number="6" column-width="2.5cm"/>
					<fo:table-column column-number="7" column-width="2.0cm"/>
					<fo:table-column column-number="8" column-width="2.5cm"/>
				</xsl:when>
				<xsl:otherwise>
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="4cm"/>
					<fo:table-column column-number="5" column-width="2.5cm"/>
					<fo:table-column column-number="6" column-width="3cm"/>
					<fo:table-column column-number="7" column-width="3cm"/>
				</xsl:otherwise>
			</xsl:choose>	
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        		AWB Number	
			                   </fo:block>
					</fo:table-cell>
					<xsl:if test="count(COD_RECEIVABLE/LOC_CD) &gt; 0">
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
							<fo:block>
								Location	
							</fo:block>
						</fo:table-cell>
					</xsl:if>	
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        Courier
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Inv. Number
	                   </fo:block>
					</fo:table-cell>					
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Customer Name
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Date
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Amount
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Status
	                   </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>					
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//DELIVERED/COD_RECEIVABLES/COD_RECEIVABLE/COD_REC_AMOUNT),'###########0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>					
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates/>
			</fo:table-body>
		</fo:table>
	</xsl:template>

<!-- End COD -->


<!-- Start FTC -->	
	<xsl:template match="/REPORT/ON_STATION/FTC_RECEIVABLES" foa:name="List" foa:class="table" foa:group="simple-table">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			On Station Open FTC Receivables
		</fo:block>	
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<xsl:choose>
				<xsl:when test="count(FTC_RECEIVABLE/LOC_CD) &gt; 0">
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="2.5cm"/>
					<fo:table-column column-number="5" column-width="3cm"/>
					<fo:table-column column-number="6" column-width="2.5cm"/>
					<fo:table-column column-number="7" column-width="2.0cm"/>
					<fo:table-column column-number="8" column-width="2.5cm"/>
				</xsl:when>
				<xsl:otherwise>
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="4cm"/>
					<fo:table-column column-number="5" column-width="2.5cm"/>
					<fo:table-column column-number="6" column-width="3cm"/>
					<fo:table-column column-number="7" column-width="3cm"/>
				</xsl:otherwise>
			</xsl:choose>	
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        			AWB Number
			                 		  </fo:block>
					</fo:table-cell>
					<xsl:if test="count(FTC_RECEIVABLE/LOC_CD) &gt; 0">
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
							<fo:block>
								Location 
							</fo:block>
						</fo:table-cell>
					</xsl:if>		
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        Courier
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Inv. Number
	                   </fo:block>
					</fo:table-cell>					
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Customer Name
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Date
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Amount
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Status
	                   </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>					
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//ON_STATION/FTC_RECEIVABLES/FTC_RECEIVABLE/FTC_REC_AMOUNT),'###########0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>					
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	
	<xsl:template match="/REPORT/DELIVERED/FTC_RECEIVABLES" foa:name="List" foa:class="table" foa:group="simple-table">
		<fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
			Delivered Open FTC Receivables
		</fo:block>		
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<xsl:choose>
				<xsl:when test="count(FTC_RECEIVABLE/LOC_CD) &gt; 0">
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="2.5cm"/>
					<fo:table-column column-number="5" column-width="3cm"/>
					<fo:table-column column-number="6" column-width="2.5cm"/>
					<fo:table-column column-number="7" column-width="2.0cm"/>
					<fo:table-column column-number="8" column-width="2.5cm"/>
				</xsl:when>
				<xsl:otherwise>
					<fo:table-column column-number="1" column-width="3cm"/>
					<fo:table-column column-number="2" column-width="2cm"/>
					<fo:table-column column-number="3" column-width="3cm"/>			
					<fo:table-column column-number="4" column-width="4cm"/>
					<fo:table-column column-number="5" column-width="2.5cm"/>
					<fo:table-column column-number="6" column-width="3cm"/>
					<fo:table-column column-number="7" column-width="3cm"/>
				</xsl:otherwise>
			</xsl:choose>	
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        		AWB Number	
			                   </fo:block>
					</fo:table-cell>
					<xsl:if test="count(FTC_RECEIVABLE/LOC_CD) &gt; 0">
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
							<fo:block>
								Location	
							</fo:block>
						</fo:table-cell>
					</xsl:if>	
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
						<fo:block>
	                        Courier
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Inv. Number
	                   </fo:block>
					</fo:table-cell>					
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Customer Name
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Date
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Amount
	                   </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
	                        Status
	                   </fo:block>
					</fo:table-cell>
				</fo:table-row>
			</fo:table-header>
			<fo:table-footer>
				<fo:table-row>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell/>					
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block>
							Total
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="10pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(//DELIVERED/FTC_RECEIVABLES/FTC_RECEIVABLE/FTC_REC_AMOUNT),'###########0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>					
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates/>
			</fo:table-body>
		</fo:table>
	</xsl:template>

<!-- End FTC -->


    <xsl:template match="/REPORT/OACS" foa:name="List" foa:class="table" foa:group="simple-table">
        <fo:block break-before="page" font-size="16pt" text-align="center" font-weight="bold">
            Outbound Ancillary Services
        </fo:block>
        <fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
            <xsl:choose>
                <xsl:when test="count(OAC/LOC_CD) &gt; 0">
                    <fo:table-column column-number="1" column-width="3cm"/>
                    <fo:table-column column-number="2" column-width="2cm"/>
                    <fo:table-column column-number="3" column-width="3cm"/>
                    <fo:table-column column-number="4" column-width="2.5cm"/>
                    <fo:table-column column-number="5" column-width="2cm"/>
                    <fo:table-column column-number="6" column-width="2.5cm"/>
                    <fo:table-column column-number="7" column-width="2.0cm"/>
                    <fo:table-column column-number="8" column-width="2.5cm"/>
                    <fo:table-column column-number="9" column-width="2.5cm"/>
                </xsl:when>
                <xsl:otherwise>
                    <fo:table-column column-number="1" column-width="3cm"/>
                    <fo:table-column column-number="2" column-width="2cm"/>
                    <fo:table-column column-number="3" column-width="3cm"/>
                    <fo:table-column column-number="4" column-width="2cm"/>
                    <fo:table-column column-number="5" column-width="2.5cm"/>
                    <fo:table-column column-number="6" column-width="2.0cm"/>
                    <fo:table-column column-number="7" column-width="2.5cm"/>
                    <fo:table-column column-number="8" column-width="2.5cm"/>
                </xsl:otherwise>
            </xsl:choose>
            <fo:table-header>
                <fo:table-row>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
                        <fo:block>
                            AWB Numbers
                        </fo:block>
                    </fo:table-cell>
                    <xsl:if test="count(OAC/LOC_CD) &gt; 0">
                        <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
                            <fo:block>
                                Location
                            </fo:block>
                        </fo:table-cell>
                    </xsl:if>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center" >
                        <fo:block>
                            Courier
                       </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                            Date
                       </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                            Currency
                       </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                            Cash Amount
                       </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                            Other Amount
                       </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                            Payment Type
                       </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                            Doc.
                       </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-header>
            <fo:table-body>
                <xsl:apply-templates/>
            </fo:table-body>
        </fo:table>
    </xsl:template>

	<xsl:template match="RECEIVABLE" foa:name="List" foa:class="table-row" foa:group="simple-table" foa:type="table-row">
		<fo:table-row foa:name="List" foa:group="simple-table" xsl:use-attribute-sets=" TableRow1">
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="RECEIVABLE/AWB_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="{position()}" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="RECEIVABLE/LOC_CD" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="{position()}" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="RECEIVABLE/EMPLOYEE_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="{position()}" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	<xsl:template match="RECEIVABLE/REC_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="{position()}" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>	
	<xsl:template match="RECEIVABLE/CUSTOMER_NM" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="{position()}" xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="RECEIVABLE/REC_DT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="{position()}" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="RECEIVABLE/REC_AMOUNT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="{position()}" text-align="right" xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt">
				<xsl:value-of select="format-number(.,'###########0.00')" />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="RECEIVABLE/DESCRIPTION" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="{position()}"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>

<!-- COD -->


	<xsl:template match="COD_RECEIVABLE" foa:name="List" foa:class="table-row" foa:group="simple-table" foa:type="table-row">
		<fo:table-row foa:name="List" foa:group="simple-table" xsl:use-attribute-sets=" TableRow1">
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLE/AWB_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="1" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLE/EMPLOYEE_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="2" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	<xsl:template match="COD_RECEIVABLE/COD_REC_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="3" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>	
	<xsl:template match="COD_RECEIVABLE/CUSTOMER_NM" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="4" xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLE/COD_REC_DT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="5" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLE/COD_REC_AMOUNT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="6" text-align="right" xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt">
				<xsl:value-of select="format-number(.,'###########0.00')" />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLE/DESCRIPTION" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>

<!-- end COD -->


<!-- FTC -->


	<xsl:template match="FTC_RECEIVABLE" foa:name="List" foa:class="table-row" foa:group="simple-table" foa:type="table-row">
		<fo:table-row foa:name="List" foa:group="simple-table" xsl:use-attribute-sets=" TableRow1">
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLE/AWB_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="1" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLE/EMPLOYEE_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="2" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>		
	<xsl:template match="FTC_RECEIVABLE/FTC_REC_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="3" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>	
	<xsl:template match="FTC_RECEIVABLE/CUSTOMER_NM" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="4" xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLE/FTC_REC_DT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="5" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLE/FTC_REC_AMOUNT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="6" text-align="right" xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt">
				<xsl:value-of select="format-number(.,'###########0.00')" />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLE/DESCRIPTION" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>

<!-- end FTC -->

	<xsl:template match="OAC" foa:name="List" foa:class="table-row" foa:group="simple-table" foa:type="table-row">
		<fo:table-row foa:name="List" foa:group="simple-table" xsl:use-attribute-sets=" TableRow1">
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="OAC/AWB_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="1" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC/EMPLOYEE_ID" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="2" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC/OAC_DT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="3" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC/CURR_CD" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="4" text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC/CASH_PYMT_AMT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="5" text-align="right" xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt">
				<xsl:value-of select="format-number(.,'###########0.00')" />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC/OTHER_PYMT_AMT" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="6" text-align="right" xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="10pt">
				<xsl:value-of select="format-number(.,'###########0.00')" />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC/PYMT_TYPE" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
		<fo:table-cell foa:name="List" foa:group="simple-table" column-number="7"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
			<fo:block font-size="10pt">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
    <xsl:template match="OAC/OTHER_DOC_NBR" foa:name="List" foa:class="table-cell" foa:group="simple-table" foa:type="table-cell">
        <fo:table-cell foa:name="List" foa:group="simple-table" column-number="8"  text-align="center" xsl:use-attribute-sets=" TableCell1Right">
            <fo:block font-size="10pt">
                <xsl:apply-templates/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
</xsl:stylesheet>
