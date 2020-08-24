<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:fox="http://xml.apache.org/fop/extensions" xmlns:foa="http://fabio">
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
					<fo:region-after extent="1cm" />
				</fo:simple-page-master>
				<fo:page-sequence-master master-name="PageSeq">
					<fo:repeatable-page-master-reference master-reference="Page"/>
				</fo:page-sequence-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="PageSeq">
				  <fo:static-content flow-name="xsl-region-after" >
				    <!-- Miscellaneous changes FOOTER MMM -->
					<xsl:call-template name="FOOTER"/>
				    	<fo:block text-align="end" font-size="9pt">
				     		 <fo:page-number />&#160;&#160;&#160;&#160;
				    	</fo:block>
				  </fo:static-content>			
				<fo:flow flow-name="xsl-region-body">
					<xsl:apply-templates select="/REPORT/HEADER/LOCATION"/>
					<xsl:apply-templates select="/REPORT/BATCHS"/>
					<xsl:apply-templates select="/REPORT/BATCHS/BATCH"/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<!-- Miscellaneous changes FOOTER MMM -->
<xsl:template name="FOOTER">
		<fo:block text-align="center" font-size="9pt">
				  End of Day:  <xsl:value-of select="/REPORT/FOOTER/END_OF_DAY"/>
 		          Processed by: <xsl:value-of select="/REPORT/FOOTER/PROCESSED_BY_EID"/>
 		          - <xsl:value-of select="/REPORT/FOOTER/PROCESSED_BY_ENAME"/>
 		          Signature: 
				  </fo:block>
</xsl:template>
	<!-- TITLES AND SUMMARY -->
	<xsl:template match="REPORT/HEADER/LOCATION">
		<fo:block text-align="center" font-family="Helvetica" font-weight="bold" font-size="24pt" space-after="1cm">
             		    Daily Cash Recap
    		</fo:block>
		<fo:block text-align="center" font-size="18pt">
  		           Location: <xsl:apply-templates/>
		</fo:block>
		<fo:block text-align="center" font-size="18pt" space-before="0.5cm" space-after="1cm">
  		          Date: <xsl:value-of select="/REPORT/HEADER/REPORT_DATE"/>
		</fo:block>
	</xsl:template>
	<!-- applied fix to reduce the conflict -->
	<!-- <xsl:template match="/REPORT/BATCHS">
		<xsl:apply-templates/>
	</xsl:template> -->
	<xsl:template match="/REPORT/BATCHS/BATCH">
		<fo:block break-before="page" space-after="1cm" font-size="16pt" text-align="center" font-weight="bold">
			Details for Batch <xsl:value-of select="./BATCH_ID"/> - Type <xsl:value-of select="./TEMPL_CD"/> - <xsl:value-of select="/REPORT/HEADER/REPORT_DATE"/>
		</fo:block>	
			<xsl:apply-templates select="./ROD_PART"/>
			<xsl:apply-templates select="./PREP_PART"/>
            <xsl:apply-templates select="./OAC_PART"/>
			<xsl:apply-templates select="./POA_PART"/>
			<xsl:apply-templates select="./OTHER_PART"/>
            <xsl:apply-templates select="./GRND_PART"/>
            <xsl:apply-templates select="./COD_PART"/>
            <xsl:apply-templates select="./FTC_PART"/>

			<xsl:if test="count(CHECK_REGISTERS/CHECK_REGISTER)>0">
				<fo:block break-before="page" font-size="14pt" text-align="left" font-weight="bold">
				Checks Register for Batch <xsl:value-of select="./BATCH_ID"/> - Type <xsl:value-of select="./TEMPL_CD"/> - <xsl:value-of select="/REPORT/HEADER/REPORT_DATE"/>
				</fo:block>
				<fo:block font-size="12pt" text-align="left" font-weight="bold">
					Account: <xsl:value-of select="./BANK_NM"/> - <xsl:value-of select="./BANK_BRANCH"/> - <xsl:value-of select="./ACCOUNT_NBR"/> 
				</fo:block>
				<fo:block font-size="9pt" text-align="left" space-before="1cm" font-weight="bold">
				Items count: <xsl:value-of select="count(./CHECK_REGISTERS/CHECK_REGISTER)"/>
				</fo:block>				
				<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="10cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
					<fo:table-column column-number="1" column-width="0.5cm"/>
					<fo:table-column column-number="2" column-width="3cm"/>
					<fo:table-column column-number="3" column-width="5cm"/>
					<fo:table-column column-number="4" column-width="5cm"/>					
					<fo:table-column column-number="5" column-width="5cm"/>					

					<fo:table-header>
						<fo:table-row>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
			                        #
	       		            		</fo:block>
     	       		            </fo:table-cell>						
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
			                        Type
	       		            </fo:block>
     	       		            </fo:table-cell>
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
							<fo:table-cell/>							
							<fo:table-cell/>
							<fo:table-cell/>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
								<fo:block>
			                                Total
	       		            		</fo:block>
 	       		               </fo:table-cell>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
								<fo:block>
				                    	<xsl:value-of select="format-number(sum(./CHECK_REGISTERS/CHECK_REGISTER/PAYMENT_AMT),'#,###,###,###,##0.00')"/>
	       		            		</fo:block>
							</fo:table-cell>							
						</fo:table-row>
					</fo:table-footer>					
					<fo:table-body>
						<xsl:apply-templates select="./CHECK_REGISTERS"/>
					</fo:table-body>
				</fo:table>
			</xsl:if>
			
			<xsl:if test="count(CCARD_REGISTERS/CCARD_REGISTER)>0">
				<fo:block  break-before="page" font-size="14pt" text-align="left" font-weight="bold">
				Credit Card Register for Batch <xsl:value-of select="./BATCH_ID"/> - Type <xsl:value-of select="./TEMPL_CD"/> - <xsl:value-of select="/REPORT/HEADER/REPORT_DATE"/>
				</fo:block>
				<fo:block font-size="9pt" text-align="left" space-before="1cm" font-weight="bold">
				Items count: <xsl:value-of select="count(./CCARD_REGISTERS/CCARD_REGISTER)"/>
				</fo:block>					
				<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="10cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
					<fo:table-column column-number="1" column-width="0.5cm"/>
					<fo:table-column column-number="2" column-width="3cm"/>
					<fo:table-column column-number="3" column-width="5cm"/>
					<fo:table-column column-number="4" column-width="5cm"/>					
					<fo:table-column column-number="5" column-width="5cm"/>				

					<fo:table-header>					
						<fo:table-row>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
			                        #
	       		            		</fo:block>
     	       		            </fo:table-cell>								
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
			                        Type
	       		            </fo:block>
							</fo:table-cell>

							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
			                        Card Number
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
							<fo:table-cell/>						
							<fo:table-cell/>
							<fo:table-cell/>							
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
								<fo:block>
			                                Total
	       		            		</fo:block>
 	       		               </fo:table-cell>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
								<fo:block>
				                    	<xsl:value-of select="format-number(sum(./CCARD_REGISTERS/CCARD_REGISTER/PAYMENT_AMT),'#,###,###,###,##0.00')"/>
	       		            		</fo:block>
							</fo:table-cell>							
						</fo:table-row>
					</fo:table-footer>					
					<fo:table-body>
						<xsl:apply-templates select="./CCARD_REGISTERS"/>
					</fo:table-body>
				</fo:table>
			</xsl:if>

			<xsl:if test="count(DEPO_REGISTERS/DEPO_REGISTER)>0">
				<fo:block  break-before="page" font-size="14pt" text-align="left" font-weight="bold">
				Deposit Register for Batch <xsl:value-of select="./BATCH_ID"/> - Type <xsl:value-of select="./TEMPL_CD"/> - <xsl:value-of select="/REPORT/HEADER/REPORT_DATE"/>
				</fo:block>
				<fo:block font-size="9pt" text-align="left" space-before="1cm" font-weight="bold">
				Items count: <xsl:value-of select="count(./DEPO_REGISTERS/DEPO_REGISTER)"/>
				</fo:block>	
				<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="10cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
					<fo:table-column column-number="1" column-width="0.5cm"/>
					<fo:table-column column-number="2" column-width="3cm"/>
					<fo:table-column column-number="3" column-width="5cm"/>
					<fo:table-column column-number="4" column-width="5cm"/>					
					<fo:table-column column-number="5" column-width="5cm"/>					

					<fo:table-header>
						<fo:table-row>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
			                        #
	       		            		</fo:block>
     	       		            </fo:table-cell>								
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
			                        Type
	       		            </fo:block>
	       		            </fo:table-cell>
	       		            <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
								<fo:block>
			                        Deposit Number
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
							<fo:table-cell/>						
							<fo:table-cell/>
							<fo:table-cell/>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
								<fo:block>
			                                Total
	       		            		</fo:block>
 	       		               </fo:table-cell>
							<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
								<fo:block>
				                    	<xsl:value-of select="format-number(sum(./DEPO_REGISTERS/DEPO_REGISTER/PAYMENT_AMT),'#,###,###,###,##0.00')"/>
	       		            		</fo:block>
							</fo:table-cell>							
						</fo:table-row>
					</fo:table-footer>					
					<fo:table-body>
						<xsl:apply-templates select="./DEPO_REGISTERS" />
					</fo:table-body>
				</fo:table>
			</xsl:if>

	</xsl:template>
	<!--BATCHS SUMMARY-->
	<xsl:template match="/REPORT/BATCHS">
		<xsl:if test="count(//REPORT/BATCHS/BATCH)>0">
			<fo:block space-before="1cm" font-size="14pt" text-align="center" font-weight="bold">
			Batch Summary
		</fo:block>
			<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
				<fo:table-column column-number="1" column-width="2cm"/>
				<fo:table-column column-number="2" column-width="3cm"/>
				<fo:table-column column-number="3" column-width="2cm"/>
				<fo:table-column column-number="4" column-width="2cm"/>
				<fo:table-column column-number="5" column-width="2cm"/>
				<fo:table-column column-number="6" column-width="2cm"/>
				<fo:table-column column-number="7" column-width="2cm"/>
				<fo:table-column column-number="8" column-width="2cm"/>
				<fo:table-column column-number="9" column-width="2cm"/>
			<!--	<fo:table-column column-number="10" column-width="2cm"/>
				<fo:table-column column-number="11" column-width="2cm"/>-->
				<fo:table-header>
					<fo:table-row>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
							<fo:block font-size="8pt">
			                        ID
	       		            </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
							<fo:block>
			                        Type
	       		            </fo:block>
						</fo:table-cell>
					<!--	<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
							<fo:block font-size="8pt">
			                        Src
	       		            </fo:block>
						</fo:table-cell>-->
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
							<fo:block font-size="8pt">
			                        Curr
	       		            </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
							<fo:block font-size="8pt">
			                        Cash
	       		            </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
							<fo:block font-size="8pt">
			                        Check
	       		            </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
							<fo:block font-size="8pt">
			                        C.Card
	       		            </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
							<fo:block font-size="8pt">
			                        Deposit
	       		            </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
							<fo:block font-size="8pt">
			                        Coupon
	       		            </fo:block>
						</fo:table-cell>
						<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
							<fo:block font-size="8pt">
			                        Amount
	       		            </fo:block>
						</fo:table-cell>
				<!--		<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
							<fo:block font-size="8pt">
			                        Act.Amt.
	       		            </fo:block>
						</fo:table-cell> -->
					</fo:table-row>
				</fo:table-header>
				<fo:table-body>
					<xsl:call-template name="Summary"/>
                    <fo:table-row>
                       <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="left" number-columns-spanned="11" padding-top="0.2cm">
                          <fo:block font-size="9pt">
                              Grand Totals (except DPSMISC)
                             </fo:block>
                       </fo:table-cell>
                    </fo:table-row>
                    <xsl:call-template name="GRANDTotals"/>
                </fo:table-body>
			</fo:table>
            <fo:block font-size="20" space-before="1cm" text-align="center">
						Adjustments descriptions
					</fo:block>
			<fo:table>
				<fo:table-column column-number="1" column-width="19cm"/>
				<fo:table-body>
					<fo:table-row>
						<fo:table-cell xsl:use-attribute-sets="TableCell1" number-columns-spanned="11" height="5cm">
							<fo:block/>
						</fo:table-cell>
					</fo:table-row>
				</fo:table-body>
			</fo:table>			
		</xsl:if>
	</xsl:template>
	<xsl:template name="Summary">
		<xsl:for-each select="/REPORT/BATCHS/BATCH">
			<xsl:variable name="currentBatchId" select="./BATCH_ID"/>
			<fo:table-row>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
					<fo:block font-size="8pt">
						<xsl:value-of select="./BATCH_ID"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
					<fo:block font-size="8pt">
						<xsl:value-of select="./TEMPL_CD"/>
                    </fo:block>
				</fo:table-cell>
			<!--	<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
					<fo:block font-size="8pt">
						<xsl:value-of select="./BATCH_SRC"/>
					</fo:block>
				</fo:table-cell>-->
				<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
					<fo:block font-size="8pt">
						<xsl:value-of select="./TEMPL_CURR"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
					<fo:block font-size="8pt">
						<xsl:value-of select="format-number(sum(./ROD_PART/ROD_CURR_PART/ROD_RECEIVABLES/ROD_RECEIVABLE/CASH_PAYMENT_AMT|./COD_PART/COD_CURR_PART/COD_RECEIVABLES/COD_RECEIVABLE/CASH_PAYMENT_AMT|./FTC_PART/FTC_CURR_PART/FTC_RECEIVABLES/FTC_RECEIVABLE/CASH_PAYMENT_AMT|./PREP_PART/PREP_CURR_PART/PREP_AWBS/PREP_AWB/CASH_PAYMENT_AMT|./OAC_PART/OAC_CURR_PART/OAC_AWBS/OAC_AWB/CASH_PAYMENT_AMT|./POA_PART/POA_CURR_PART/POA_PAYMENTS/POA_PAYMENT[PAYMENT_CTG_ID=5]/PAYMENT_AMT|./OTHER_PART/OTHER_CURR_PART/OTHER_PAYMENTS/OTHER_PAYMENT[PAYMENT_CTG_ID=5]/PAYMENT_AMT|./GRND_PART/GRND_CURR_PART/GRND_TRAK_NBRS/GRND_TRAK_NBR/CASH_PAYMENT_AMT),'#,###,###,###,##0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
					<fo:block font-size="8pt">
						<xsl:value-of select="format-number(sum(./ROD_PART/ROD_CURR_PART/ROD_RECEIVABLES/ROD_RECEIVABLE[PAYMENT_CTG_ID=1]/PAYMENT_AMT|./COD_PART/COD_CURR_PART/COD_RECEIVABLES/COD_RECEIVABLE[PAYMENT_CTG_ID=1]/PAYMENT_AMT|./FTC_PART/FTC_CURR_PART/FTC_RECEIVABLES/FTC_RECEIVABLE[PAYMENT_CTG_ID=1]/PAYMENT_AMT|./PREP_PART/PREP_CURR_PART/PREP_AWBS/PREP_AWB[PAYMENT_CTG_ID=1]/PAYMENT_AMT|./OAC_PART/OAC_CURR_PART/OAC_AWBS/OAC_AWB[PAYMENT_CTG_ID=1]/PAYMENT_AMT|./POA_PART/POA_CURR_PART/POA_PAYMENTS/POA_PAYMENT[PAYMENT_CTG_ID=1]/PAYMENT_AMT|./OTHER_PART/OTHER_CURR_PART/OTHER_PAYMENTS/OTHER_PAYMENT[PAYMENT_CTG_ID=1]/PAYMENT_AMT|./GRND_PART/GRND_CURR_PART/GRND_TRAK_NBRS/GRND_TRAK_NBR[PAYMENT_CTG_ID=1]/PAYMENT_AMT),'#,###,###,###,##0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
					<fo:block font-size="8pt">
						<xsl:value-of select="format-number(sum(./ROD_PART/ROD_CURR_PART/ROD_RECEIVABLES/ROD_RECEIVABLE[PAYMENT_CTG_ID=3]/PAYMENT_AMT|./COD_PART/COD_CURR_PART/COD_RECEIVABLES/COD_RECEIVABLE[PAYMENT_CTG_ID=3]/PAYMENT_AMT|./FTC_PART/FTC_CURR_PART/FTC_RECEIVABLES/FTC_RECEIVABLE[PAYMENT_CTG_ID=3]/PAYMENT_AMT|./PREP_PART/PREP_CURR_PART/PREP_AWBS/PREP_AWB[PAYMENT_CTG_ID=3]/PAYMENT_AMT|./OAC_PART/OAC_CURR_PART/OAC_AWBS/OAC_AWB[PAYMENT_CTG_ID=3]/PAYMENT_AMT|./POA_PART/POA_CURR_PART/POA_PAYMENTS/POA_PAYMENT[PAYMENT_CTG_ID=3]/PAYMENT_AMT|./OTHER_PART/OTHER_CURR_PART/OTHER_PAYMENTS/OTHER_PAYMENT[PAYMENT_CTG_ID=3]/PAYMENT_AMT|./GRND_PART/GRND_CURR_PART/GRND_TRAK_NBRS/GRND_TRAK_NBR[PAYMENT_CTG_ID=3]/PAYMENT_AMT),'#,###,###,###,##0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
					<fo:block font-size="8pt">
						<xsl:value-of select="format-number(sum(./ROD_PART/ROD_CURR_PART/ROD_RECEIVABLES/ROD_RECEIVABLE[PAYMENT_CTG_ID=2]/PAYMENT_AMT|./COD_PART/COD_CURR_PART/COD_RECEIVABLES/COD_RECEIVABLE[PAYMENT_CTG_ID=2]/PAYMENT_AMT|./FTC_PART/FTC_CURR_PART/FTC_RECEIVABLES/FTC_RECEIVABLE[PAYMENT_CTG_ID=2]/PAYMENT_AMT|./PREP_PART/PREP_CURR_PART/PREP_AWBS/PREP_AWB[PAYMENT_CTG_ID=2]/PAYMENT_AMT|./OAC_PART/OAC_CURR_PART/OAC_AWBS/OAC_AWB[PAYMENT_CTG_ID=2]/PAYMENT_AMT|./POA_PART/POA_CURR_PART/POA_PAYMENTS/POA_PAYMENT[PAYMENT_CTG_ID=2]/PAYMENT_AMT|./OTHER_PART/OTHER_CURR_PART/OTHER_PAYMENTS/OTHER_PAYMENT[PAYMENT_CTG_ID=2]/PAYMENT_AMT|./GRND_PART/GRND_CURR_PART/GRND_TRAK_NBRS/GRND_TRAK_NBR[PAYMENT_CTG_ID=2]/PAYMENT_AMT),'#,###,###,###,##0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
					<fo:block font-size="8pt">                                                                                      
						<xsl:value-of select="format-number(sum(./ROD_PART/ROD_CURR_PART/ROD_RECEIVABLES/ROD_RECEIVABLE[PAYMENT_CTG_ID=4]/PAYMENT_AMT|./COD_PART/COD_CURR_PART/COD_RECEIVABLES/COD_RECEIVABLE[PAYMENT_CTG_ID=4]/PAYMENT_AMT|./FTC_PART/FTC_CURR_PART/FTC_RECEIVABLES/FTC_RECEIVABLE[PAYMENT_CTG_ID=4]/PAYMENT_AMT|./PREP_PART/PREP_CURR_PART/PREP_AWBS/PREP_AWB/COUP_PYMT_AMT|./OAC_PART/OAC_CURR_PART/OAC_AWBS/OAC_AWB[PAYMENT_CTG_ID=4]/PAYMENT_AMT|./POA_PART/POA_CURR_PART/POA_PAYMENTS/POA_PAYMENT/COUP_PYMT_AMT|./OTHER_PART/OTHER_CURR_PART/OTHER_PAYMENTS/OTHER_PAYMENT[PAYMENT_CTG_ID=4]/PAYMENT_AMT|./GRND_PART/GRND_CURR_PART/GRND_TRAK_NBRS/GRND_TRAK_NBR/COUP_PYMT_AMT),'#,###,###,###,##0.00')"/>
					</fo:block>
				</fo:table-cell>
				<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right">
					<fo:block font-size="8pt">
						<xsl:value-of select="format-number(./BATCH_TOTAL,'#,###,###,###,##0.00')"/>
					</fo:block>
				</fo:table-cell>
				<!--<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="right"/>-->
			</fo:table-row>
		</xsl:for-each>
	</xsl:template>
    <!--GRAND TOTALS-->
    <xsl:template name="GRANDTotals">
                <xsl:for-each select="//REPORT/BATCHS/BATCH/ROD_PART/ROD_CURR_PART/CURRENCY_CODE|/REPORT/BATCHS/BATCH/COD_PART/COD_CURR_PART/CURRENCY_CODE|/REPORT/BATCHS/BATCH/FTC_PART/FTC_CURR_PART/CURRENCY_CODE|/REPORT/BATCHS/BATCH/PREP_PART/PREP_CURR_PART/CURRENCY_CODE|/REPORT/BATCHS/BATCH/OAC_PART/OAC_CURR_PART/CURRENCY_CODE|/REPORT/BATCHS/BATCH/POA_PART/POA_CURR_PART/CURRENCY_CODE|/REPORT/BATCHS/BATCH/GRND_PART/GRND_CURR_PART/CURRENCY_CODE|/REPORT/BATCHS/BATCH/OTHER_PART/OTHER_CURR_PART/CURRENCY_CODE">
                     <xsl:sort select="." data-type="text" order="ascending"/>
                        <xsl:if test="not(. = preceding::CURRENCY_CODE)">
                            <xsl:variable name="currentCurrency" select="."/>
                            <xsl:variable name="cashGrandTotal" select="sum(//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//ROD_PART/ROD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/ROD_RECEIVABLES/ROD_RECEIVABLE/CASH_PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//COD_PART/COD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/COD_RECEIVABLES/COD_RECEIVABLE/CASH_PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//FTC_PART/FTC_CURR_PART[CURRENCY_CODE = $currentCurrency ]/FTC_RECEIVABLES/FTC_RECEIVABLE/CASH_PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//PREP_PART/PREP_CURR_PART[CURRENCY_CODE = $currentCurrency ]/PREP_AWBS/PREP_AWB/CASH_PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//OAC_PART/OAC_CURR_PART[CURRENCY_CODE = $currentCurrency ]/OAC_AWBS/OAC_AWB/CASH_PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//POA_PART/POA_CURR_PART[CURRENCY_CODE = $currentCurrency ]/POA_PAYMENTS/POA_PAYMENT[PAYMENT_CTG_ID=5]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//OTHER_PART/OTHER_CURR_PART[CURRENCY_CODE = $currentCurrency ]/OTHER_PAYMENTS/OTHER_PAYMENT[PAYMENT_CTG_ID=5]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//GRND_PART/GRND_CURR_PART[CURRENCY_CODE = $currentCurrency ]/GRND_TRAK_NBRS/GRND_TRAK_NBR/CASH_PAYMENT_AMT)"/>
                            <xsl:variable name="checkGrandTotal" select="sum(//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//ROD_PART/ROD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/ROD_RECEIVABLES/ROD_RECEIVABLE[PAYMENT_CTG_ID=1]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//COD_PART/COD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/COD_RECEIVABLES/COD_RECEIVABLE[PAYMENT_CTG_ID=1]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//FTC_PART/FTC_CURR_PART[CURRENCY_CODE = $currentCurrency ]/FTC_RECEIVABLES/FTC_RECEIVABLE[PAYMENT_CTG_ID=1]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//PREP_PART/PREP_CURR_PART[CURRENCY_CODE = $currentCurrency ]/PREP_AWBS/PREP_AWB[PAYMENT_CTG_ID=1]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//OAC_PART/OAC_CURR_PART[CURRENCY_CODE = $currentCurrency ]/OAC_AWBS/OAC_AWB[PAYMENT_CTG_ID=1]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]/POA_PART/POA_CURR_PART[CURRENCY_CODE = $currentCurrency ]/POA_PAYMENTS/POA_PAYMENT[PAYMENT_CTG_ID=1]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]/OTHER_PART/OTHER_CURR_PART[CURRENCY_CODE = $currentCurrency ]/OTHER_PAYMENTS/OTHER_PAYMENT[PAYMENT_CTG_ID=1]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]/GRND_PART/GRND_CURR_PART[CURRENCY_CODE = $currentCurrency ]/GRND_TRAK_NBRS/GRND_TRAK_NBR[PAYMENT_CTG_ID=1]/PAYMENT_AMT)"/>
                            <xsl:variable name="depositGrandTotal" select="sum(//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//ROD_PART/ROD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/ROD_RECEIVABLES/ROD_RECEIVABLE[PAYMENT_CTG_ID=2]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//COD_PART/COD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/COD_RECEIVABLES/COD_RECEIVABLE[PAYMENT_CTG_ID=2]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//FTC_PART/FTC_CURR_PART[CURRENCY_CODE = $currentCurrency ]/FTC_RECEIVABLES/FTC_RECEIVABLE[PAYMENT_CTG_ID=2]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//PREP_PART/PREP_CURR_PART[CURRENCY_CODE = $currentCurrency ]/PREP_AWBS/PREP_AWB[PAYMENT_CTG_ID=2]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//OAC_PART/OAC_CURR_PART[CURRENCY_CODE = $currentCurrency ]/OAC_AWBS/OAC_AWB[PAYMENT_CTG_ID=2]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//POA_PART/POA_CURR_PART[CURRENCY_CODE = $currentCurrency ]/POA_PAYMENTS/POA_PAYMENT[PAYMENT_CTG_ID=2]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//OTHER_PART/OTHER_CURR_PART[CURRENCY_CODE = $currentCurrency ]/OTHER_PAYMENTS/OTHER_PAYMENT[PAYMENT_CTG_ID=2]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//GRND_PART/GRND_CURR_PART[CURRENCY_CODE = $currentCurrency ]/GRND_TRAK_NBRS/GRND_TRAK_NBR[PAYMENT_CTG_ID=2]/PAYMENT_AMT)"/>
                            <xsl:variable name="couponGrandTotal" select="sum(//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//ROD_PART/ROD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/ROD_RECEIVABLES/ROD_RECEIVABLE[PAYMENT_CTG_ID=4]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//COD_PART/COD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/COD_RECEIVABLES/COD_RECEIVABLE[PAYMENT_CTG_ID=4]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//FTC_PART/FTC_CURR_PART[CURRENCY_CODE = $currentCurrency ]/FTC_RECEIVABLES/FTC_RECEIVABLE[PAYMENT_CTG_ID=4]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//PREP_PART/PREP_CURR_PART[CURRENCY_CODE = $currentCurrency ]/PREP_AWBS/PREP_AWB/COUP_PYMT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//POA_PART/POA_CURR_PART[CURRENCY_CODE = $currentCurrency ]/POA_PAYMENTS/POA_PAYMENT/COUP_PYMT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//OTHER_PART/OTHER_CURR_PART[CURRENCY_CODE = $currentCurrency ]/OTHER_PAYMENTS/OTHER_PAYMENT[PAYMENT_CTG_ID=4]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//GRND_PART/GRND_CURR_PART[CURRENCY_CODE = $currentCurrency ]/GRND_TRAK_NBRS/GRND_TRAK_NBR/COUP_PYMT_AMT)"/>
                            <xsl:variable name="creditCardGrandTotal" select="sum(//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//ROD_PART/ROD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/ROD_RECEIVABLES/ROD_RECEIVABLE[PAYMENT_CTG_ID=3]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//COD_PART/COD_CURR_PART[CURRENCY_CODE = $currentCurrency ]/COD_RECEIVABLES/COD_RECEIVABLE[PAYMENT_CTG_ID=3]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//FTC_PART/FTC_CURR_PART[CURRENCY_CODE = $currentCurrency ]/FTC_RECEIVABLES/FTC_RECEIVABLE[PAYMENT_CTG_ID=3]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//PREP_PART/PREP_CURR_PART[CURRENCY_CODE = $currentCurrency ]/PREP_AWBS/PREP_AWB[PAYMENT_CTG_ID=3]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//OAC_PART/OAC_CURR_PART/OAC_AWBS/OAC_AWB[PAYMENT_CTG_ID=3]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//POA_PART/POA_CURR_PART[CURRENCY_CODE = $currentCurrency ]/POA_PAYMENTS/POA_PAYMENT[PAYMENT_CTG_ID=3]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//OTHER_PART/OTHER_CURR_PART[CURRENCY_CODE = $currentCurrency ]/OTHER_PAYMENTS/OTHER_PAYMENT[PAYMENT_CTG_ID=3]/PAYMENT_AMT|//REPORT/BATCHS/BATCH[not(TEMPL_CD='DPSMISC')]//GRND_PART/GRND_CURR_PART[CURRENCY_CODE = $currentCurrency ]/GRND_TRAK_NBRS/GRND_TRAK_NBR[PAYMENT_CTG_ID=3]/PAYMENT_AMT)"/>
                                <fo:table-row>
                                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="center">
                                        <fo:block font-size="8pt"/>
                                    </fo:table-cell>
                                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="center">
                                        <fo:block font-size="8pt"/>
                                    </fo:table-cell>
                                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="center">
                                        <fo:block font-size="8pt">
                                                <xsl:value-of select="$currentCurrency"/>
                                              </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                                         <fo:block font-size="8pt">
                                                <xsl:value-of select="format-number($cashGrandTotal,'#,###,###,###,##0.00')" />
                                          </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                                          <fo:block font-size="8pt">
                                            <xsl:value-of select="format-number($checkGrandTotal,'#,###,###,###,##0.00')" />
                                           </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                                           <fo:block font-size="8pt">
                                               <xsl:value-of select="format-number($creditCardGrandTotal,'#,###,###,###,##0.00')" />
                                             </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                                        <fo:block font-size="8pt">
                                            <xsl:value-of select="format-number($depositGrandTotal,'#,###,###,###,##0.00')" />
                                          </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                                        <fo:block font-size="8pt">
                                            <xsl:value-of select="format-number($couponGrandTotal,'#,###,###,###,##0.00')" />
                                          </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                                        <fo:block font-size="8pt">
                                            <xsl:value-of select="format-number($cashGrandTotal+$checkGrandTotal+$creditCardGrandTotal+$depositGrandTotal+$couponGrandTotal,'#,###,###,###,##0.00')"/>
                                        </fo:block>
                                    </fo:table-cell>
                            </fo:table-row>
                        </xsl:if>
                </xsl:for-each>
    </xsl:template>

    <!--DETAILS ROD-->
	<xsl:template match="/REPORT/BATCHS/BATCH/ROD_PART/ROD_CURR_PART">
		<fo:block font-size="16pt" text-align="left" font-weight="bold">
			ROD Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:block font-size="9pt" text-align="left" space-before="1cm" font-weight="bold">
			Items count: <xsl:value-of select="count(./ROD_RECEIVABLES/ROD_RECEIVABLE)"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="0.5cm"/>
			<fo:table-column column-number="2" column-width="2.8cm"/>
			<fo:table-column column-number="3" column-width="2.5cm"/>
			<fo:table-column column-number="4" column-width="2.2cm"/>
			<fo:table-column column-number="5" column-width="2.3cm"/>
			<fo:table-column column-number="6" column-width="2.5cm"/>
			<fo:table-column column-number="7" column-width="2.3cm"/>
			<fo:table-column column-number="8" column-width="2.5cm"/>
			<fo:table-column column-number="9" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						  <fo:block>
			                        #
	       		            </fo:block>
          		     </fo:table-cell>						
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Awb Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Emp.
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
			                       Pymt Type
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
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
					<fo:table-cell/>				
					<fo:table-cell/>
					<fo:table-cell text-align="right">
						<fo:block>
							Totals
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(ROD_RECEIVABLES/ROD_RECEIVABLE/REC_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(ROD_RECEIVABLES/ROD_RECEIVABLE/CASH_PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(ROD_RECEIVABLES/ROD_RECEIVABLE/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="ROD_RECEIVABLES/ROD_RECEIVABLE"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE">
		<fo:table-row>
			<fo:table-cell xsl:use-attribute-sets=" TableCell1Right" padding-right="0pt" padding-left="0pt">
				<fo:block text-align="right" font-size="9pt">
	                    	<xsl:value-of select="@num"/>
			     </fo:block>
			</fo:table-cell>		
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/AWB_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/EMPLOYEE_ID">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/REC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/REC_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/CASH_PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/PAYMENT_TYPE">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="ROD_RECEIVABLES/ROD_RECEIVABLE/DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>

    <!--DETAILS COD-->
	<xsl:template match="/REPORT/BATCHS/BATCH/COD_PART/COD_CURR_PART">
		<fo:block font-size="16pt" text-align="left" font-weight="bold">
			COD Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:block font-size="9pt" text-align="left" space-before="1cm" font-weight="bold">
			Items count: <xsl:value-of select="count(./COD_RECEIVABLES/COD_RECEIVABLE)"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="0.5cm"/>
			<fo:table-column column-number="2" column-width="2.8cm"/>
			<fo:table-column column-number="3" column-width="2.5cm"/>
			<fo:table-column column-number="4" column-width="2.2cm"/>
			<fo:table-column column-number="5" column-width="2.3cm"/>
			<fo:table-column column-number="6" column-width="2.5cm"/>
			<fo:table-column column-number="7" column-width="2.3cm"/>
			<fo:table-column column-number="8" column-width="2.5cm"/>
			<fo:table-column column-number="9" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						  <fo:block>
			                        #
	       		            </fo:block>
          		     </fo:table-cell>						
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Awb Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Emp.
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
			                       Pymt Type
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
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
					<fo:table-cell/>				
					<fo:table-cell/>
					<fo:table-cell text-align="right">
						<fo:block>
							Totals
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(COD_RECEIVABLES/COD_RECEIVABLE/REC_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(COD_RECEIVABLES/COD_RECEIVABLE/CASH_PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(COD_RECEIVABLES/COD_RECEIVABLE/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="COD_RECEIVABLES/COD_RECEIVABLE"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE">
		<fo:table-row>
			<fo:table-cell xsl:use-attribute-sets=" TableCell1Right" padding-right="0pt" padding-left="0pt">
				<fo:block text-align="right" font-size="9pt">
	                    	<xsl:value-of select="@num"/>
			     </fo:block>
			</fo:table-cell>		
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/AWB_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/EMPLOYEE_ID">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/REC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/REC_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/CASH_PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/PAYMENT_TYPE">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="COD_RECEIVABLES/COD_RECEIVABLE/DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	
	
	    <!--DETAILS FTC-->
	<xsl:template match="/REPORT/BATCHS/BATCH/FTC_PART/FTC_CURR_PART">
		<fo:block font-size="16pt" text-align="left" font-weight="bold">
			FTC Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:block font-size="9pt" text-align="left" space-before="1cm" font-weight="bold">
			Items count: <xsl:value-of select="count(./FTC_RECEIVABLES/FTC_RECEIVABLE)"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="0.5cm"/>
			<fo:table-column column-number="2" column-width="2.8cm"/>
			<fo:table-column column-number="3" column-width="2.5cm"/>
			<fo:table-column column-number="4" column-width="2.2cm"/>
			<fo:table-column column-number="5" column-width="2.3cm"/>
			<fo:table-column column-number="6" column-width="2.5cm"/>
			<fo:table-column column-number="7" column-width="2.3cm"/>
			<fo:table-column column-number="8" column-width="2.5cm"/>
			<fo:table-column column-number="9" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						  <fo:block>
			                        #
	       		            </fo:block>
          		     </fo:table-cell>						
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Awb Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Emp.
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
			                       Pymt Type
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
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
					<fo:table-cell/>				
					<fo:table-cell/>
					<fo:table-cell text-align="right">
						<fo:block>
							Totals
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(FTC_RECEIVABLES/FTC_RECEIVABLE/REC_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(FTC_RECEIVABLES/FTC_RECEIVABLE/CASH_PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(FTC_RECEIVABLES/FTC_RECEIVABLE/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="FTC_RECEIVABLES/FTC_RECEIVABLE"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE">
		<fo:table-row>
			<fo:table-cell xsl:use-attribute-sets=" TableCell1Right" padding-right="0pt" padding-left="0pt">
				<fo:block text-align="right" font-size="9pt">
	                    	<xsl:value-of select="@num"/>
			     </fo:block>
			</fo:table-cell>		
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/AWB_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/EMPLOYEE_ID">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/REC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/REC_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/CASH_PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/PAYMENT_TYPE">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="FTC_RECEIVABLES/FTC_RECEIVABLE/DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	
	
	<!--DETAILS PREPAID-->
	<xsl:template match="/REPORT/BATCHS/BATCH/PREP_PART/PREP_CURR_PART">
		<fo:block font-size="16pt" text-align="left" font-weight="bold">
			Prepaid Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:block font-size="9pt" text-align="left" space-before="1cm" font-weight="bold">
			Items count: <xsl:value-of select="count(./PREP_AWBS/PREP_AWB)"/>
		</fo:block>		
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="0.5cm"/>
			<fo:table-column column-number="2" column-width="2.5cm"/>
			<fo:table-column column-number="3" column-width="2.5cm"/>
			<fo:table-column column-number="4" column-width="2.5cm"/>
			<fo:table-column column-number="5" column-width="2.5cm"/>
			<fo:table-column column-number="6" column-width="2.5cm"/>
			<fo:table-column column-number="7" column-width="2.5cm"/>
			<fo:table-column column-number="8" column-width="2.5cm"/>
			<fo:table-column column-number="9" column-width="3cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        #
	       		            </fo:block>
					</fo:table-cell>				
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Awb Number
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Emp.
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
			                        Coupon
	       		            </fo:block>
					</fo:table-cell>					
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                       Payment Type
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
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
					<fo:table-cell/>
					<fo:table-cell>
						<fo:block text-align="right">
			                        Totals
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(PREP_AWBS/PREP_AWB/SCAN_AMOUNT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(PREP_AWBS/PREP_AWB/CASH_PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(PREP_AWBS/PREP_AWB/COUP_PYMT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(PREP_AWBS/PREP_AWB/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="PREP_AWBS/PREP_AWB"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB">
		<fo:table-row>
			<fo:table-cell xsl:use-attribute-sets=" TableCell1Right" padding-right="0pt" padding-left="0pt">
				<fo:block text-align="right" font-size="9pt">
	                    	<xsl:value-of select="@num"/>
			     </fo:block>
			</fo:table-cell>		
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/AWB_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/COURIER_ID">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/SCAN_AMOUNT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/CASH_PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/COUP_PYMT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>	
	<xsl:template match="PREP_AWBS/PREP_AWB/PAYMENT_TYPE" >
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
					<xsl:apply-templates />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/PAYMENT_AMT" >
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="PREP_AWBS/PREP_AWB/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				 <xsl:apply-templates />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<!--DETAILS OAC-->
	<xsl:template match="/REPORT/BATCHS/BATCH/OAC_PART/OAC_CURR_PART">
		<fo:block font-size="16pt" text-align="left" font-weight="bold">
			OAC Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:block font-size="9pt" text-align="left" space-before="1cm" font-weight="bold">
			Items count: <xsl:value-of select="count(./OAC_AWBS/OAC_AWB)"/>
		</fo:block>
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="0.5cm"/>
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
			                        #
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        AWBs
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Emp.
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Cash
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                       Payment Type
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
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
					<fo:table-cell/>
					<fo:table-cell>
						<fo:block text-align="right">
			                        Totals
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(OAC_AWBS/OAC_AWB/CASH_PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
                    <fo:table-cell/>                    
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(OAC_AWBS/OAC_AWB/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
                    <fo:table-cell/>
					<fo:table-cell/>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="OAC_AWBS/OAC_AWB"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template match="OAC_AWBS/OAC_AWB">
		<fo:table-row>
			<fo:table-cell xsl:use-attribute-sets=" TableCell1Right" padding-right="0pt" padding-left="0pt">
				<fo:block text-align="right" font-size="9pt">
	                    	<xsl:value-of select="@num"/>
			     </fo:block>
			</fo:table-cell>
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
    <xsl:template match="OAC_AWBS/OAC_AWB/AWBS">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC_AWBS/OAC_AWB/COURIER_ID">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC_AWBS/OAC_AWB/CASH_PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC_AWBS/OAC_AWB/PAYMENT_TYPE" >
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
					<xsl:apply-templates />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC_AWBS/OAC_AWB/PAYMENT_AMT" >
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OAC_AWBS/OAC_AWB/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				 <xsl:apply-templates />
			</fo:block>
		</fo:table-cell>
	</xsl:template>

	<!--DETAILS POA-->
	<xsl:template match="/REPORT/BATCHS/BATCH/POA_PART/POA_CURR_PART">
		<fo:block font-size="16pt" text-align="left" font-weight="bold">
			POA Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:block font-size="9pt" text-align="left" space-before="1cm" font-weight="bold">
			Items count: <xsl:value-of select="count(./POA_PAYMENTS/POA_PAYMENT)"/>
		</fo:block>		
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="0.5cm"/>		
			<fo:table-column column-number="2" column-width="2.5cm"/>
			<fo:table-column column-number="3" column-width="2.2cm"/>
			<fo:table-column column-number="4" column-width="3.2cm"/>
			<fo:table-column column-number="5" column-width="2.5cm"/>
			<fo:table-column column-number="6" column-width="2.3cm"/>
			<fo:table-column column-number="7" column-width="2.5cm"/>
			<fo:table-column column-number="8" column-width="2.5cm"/>
			<fo:table-column column-number="9" column-width="2.5cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        #
	       		            </fo:block>
					</fo:table-cell>				
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Emp.
	       		            </fo:block>
					</fo:table-cell>
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
			                        Coupon
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                       Payment Type
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block>
			                        Amount
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
					<fo:table-cell/>
					<fo:table-cell/>
					<fo:table-cell text-align="right">
						<fo:block>
							Totals
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(POA_PAYMENTS/POA_PAYMENT/COUP_PYMT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell />
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(POA_PAYMENTS/POA_PAYMENT/PAYMENT_AMT),'############0.00')"/>
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
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT">
		<fo:table-row>
			<fo:table-cell xsl:use-attribute-sets=" TableCell1Right" padding-right="0pt" padding-left="0pt">
				<fo:block text-align="right" font-size="9pt">
	                    	<xsl:value-of select="@num"/>
			     </fo:block>
			</fo:table-cell>		
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/COURIER_ID">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/ACCOUNT_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/CUSTOMER_NM">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/COUP_PYMT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/PAYMENT_TYPE">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
					<xsl:apply-templates />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="POA_PAYMENTS/POA_PAYMENT/CHKIN_AGENT_COMMENT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<!--DETAILS OTHERS-->
	<xsl:template match="/REPORT/BATCHS/BATCH/OTHER_PART/OTHER_CURR_PART">
		<fo:block font-size="16pt" text-align="left" font-weight="bold">
			Other Payments in <xsl:value-of select="CURRENCY_CODE"/>
		</fo:block>
		<fo:block font-size="9pt" text-align="left" space-before="1cm" font-weight="bold">
			Items count: <xsl:value-of select="count(./OTHER_PAYMENTS/OTHER_PAYMENT)"/>
		</fo:block>			
		<fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
			<fo:table-column column-number="1" column-width="0.5cm"/>		
			<fo:table-column column-number="2" column-width="3.5cm"/>
			<fo:table-column column-number="3" column-width="2cm"/>
			<fo:table-column column-number="4" column-width="2cm"/>
			<fo:table-column column-number="5" column-width="2.5cm"/>
			<fo:table-column column-number="6" column-width="3cm"/>
			<fo:table-column column-number="7" column-width="3cm"/>
			<fo:table-column column-number="8" column-width="2cm"/>
			<fo:table-header>
				<fo:table-row>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block font-size="9pt">
			                        #
	       		            </fo:block>
					</fo:table-cell>				
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block font-size="9pt">
			                        Description
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block font-size="9pt">
			                        Payment Category
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block font-size="9pt">
							Receptor
			                    </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block font-size="9pt">
							AWB Number
			                    </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block font-size="9pt">
			                       Payment Type
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block font-size="9pt">
			                        Amount
	       		            </fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
						<fo:block font-size="9pt">
			                        Doc. Number
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
					<fo:table-cell/>
					<fo:table-cell text-align="right">
						<fo:block>
							Totals
						</fo:block>
					</fo:table-cell>
					<fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
						<fo:block font-size="9pt">
							<xsl:value-of disable-output-escaping="yes" select="format-number(sum(OTHER_PAYMENTS/OTHER_PAYMENT/PAYMENT_AMT),'############0.00')"/>
						</fo:block>
					</fo:table-cell>
					<fo:table-cell/>
				</fo:table-row>
			</fo:table-footer>
			<fo:table-body>
				<xsl:apply-templates select="OTHER_PAYMENTS/OTHER_PAYMENT"/>
			</fo:table-body>
		</fo:table>
	</xsl:template>
	<xsl:template match="OTHER_PAYMENTS/OTHER_PAYMENT">
		<fo:table-row>
			<fo:table-cell xsl:use-attribute-sets=" TableCell1Right" padding-right="0pt" padding-left="0pt">
				<fo:block text-align="right" font-size="7pt">
	                    	<xsl:value-of select="@num"/>
			     </fo:block>
			</fo:table-cell>		
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="OTHER_PAYMENTS/OTHER_PAYMENT/DESCRIPTION">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="7pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OTHER_PAYMENTS/OTHER_PAYMENT/PAYMENT_CATEGORY_SHORT_DESC">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="7pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OTHER_PAYMENTS/OTHER_PAYMENT/CHKIN_AGENT_ID">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="7pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OTHER_PAYMENTS/OTHER_PAYMENT/AWB_NUMBER">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="7pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OTHER_PAYMENTS/OTHER_PAYMENT/PAYMENT_TYPE">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="7pt" text-align="center">
				<xsl:apply-templates />
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OTHER_PAYMENTS/OTHER_PAYMENT/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="7pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="OTHER_PAYMENTS/OTHER_PAYMENT/DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="7pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
    <!--DETAILS GROUND-->
    <xsl:template match="/REPORT/BATCHS/BATCH/GRND_PART/GRND_CURR_PART">
        <fo:block font-size="16pt" text-align="left" font-weight="bold">
            Ground Payments in <xsl:value-of select="CURRENCY_CODE"/>
        </fo:block>
        <fo:block font-size="9pt" text-align="left" space-before="1cm" font-weight="bold">
            Items count: <xsl:value-of select="count(./GRND_TRAK_NBRS/GRND_TRAK_NBR)"/>
        </fo:block>
        <fo:table foa:name="List" foa:group="simple-table" table-layout="fixed" width="19cm" xsl:use-attribute-sets=" Table1" table-omit-footer-at-break="true">
            <fo:table-column column-number="1" column-width="0.5cm"/>
            <fo:table-column column-number="2" column-width="3.5cm"/>
            <fo:table-column column-number="3" column-width="2.5cm"/>
            <fo:table-column column-number="4" column-width="2.5cm"/>
            <fo:table-column column-number="5" column-width="2.5cm"/>
            <fo:table-column column-number="6" column-width="2.5cm"/>
            <fo:table-column column-number="7" column-width="2.5cm"/>
            <fo:table-column column-number="8" column-width="2.5cm"/>
            <fo:table-header>
                <fo:table-row>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    #
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Tracking Number
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Emp.
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Cash
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Coupon
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                   Payment Type
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets=" TableCell1" text-align="center">
                        <fo:block>
                                    Amount
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
                    <fo:table-cell/>
                    <fo:table-cell>
                        <fo:block text-align="right">
                                    Totals
                               </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                        <fo:block font-size="9pt">
                            <xsl:value-of disable-output-escaping="yes" select="format-number(sum(GRND_TRAK_NBRS/GRND_TRAK_NBR/CASH_PAYMENT_AMT),'############0.00')"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                        <fo:block font-size="9pt">
                            <xsl:value-of disable-output-escaping="yes" select="format-number(sum(GRND_TRAK_NBRS/GRND_TRAK_NBR/COUP_PYMT_AMT),'############0.00')"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell />
                    <fo:table-cell xsl:use-attribute-sets="TableCell1" text-align="right">
                        <fo:block font-size="9pt">
                            <xsl:value-of disable-output-escaping="yes" select="format-number(sum(GRND_TRAK_NBRS/GRND_TRAK_NBR/PAYMENT_AMT),'############0.00')"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell/>
                </fo:table-row>
            </fo:table-footer>
            <fo:table-body>
                <xsl:apply-templates select="GRND_TRAK_NBRS/GRND_TRAK_NBR"/>
            </fo:table-body>
        </fo:table>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR">
        <fo:table-row>
            <fo:table-cell xsl:use-attribute-sets=" TableCell1Right" padding-right="0pt" padding-left="0pt">
                <fo:block text-align="right" font-size="9pt">
                            <xsl:value-of select="@num"/>
                 </fo:block>
            </fo:table-cell>
            <xsl:apply-templates/>
        </fo:table-row>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/GRND_TRAK_NBR">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="9pt" text-align="center">
                <xsl:apply-templates/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/COURIER_ID">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="9pt" text-align="center">
                <xsl:apply-templates/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/CASH_PAYMENT_AMT">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="9pt" text-align="right">
                <xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/COUP_PYMT_AMT">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="9pt" text-align="right">
                <xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/PAYMENT_TYPE" >
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="9pt" text-align="center">
                    <xsl:apply-templates />
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/PAYMENT_AMT" >
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="9pt" text-align="right">
                <xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
            </fo:block>
        </fo:table-cell>
    </xsl:template>
    <xsl:template match="GRND_TRAK_NBRS/GRND_TRAK_NBR/OTHER_DOC_NBR">
        <fo:table-cell xsl:use-attribute-sets=" TableCell1">
            <fo:block font-size="9pt" text-align="center">
                 <xsl:apply-templates />
            </fo:block>
        </fo:table-cell>
    </xsl:template>
	<!--CHECK,CCARD AND DEPOSIT REGISTERS-->
	<xsl:template match="/REPORT/BATCHS/BATCH/CHECK_REGISTERS">
			<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/CHECK_REGISTERS/CHECK_REGISTER">
		<fo:table-row>
			<fo:table-cell xsl:use-attribute-sets=" TableCell1Right" padding-right="0pt" padding-left="0pt">
				<fo:block text-align="right" font-size="9pt">
	                    	<xsl:value-of select="@num"/>
			     </fo:block>
			</fo:table-cell>				
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/CHECK_REGISTERS/CHECK_REGISTER/SHT_DESC">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/CHECK_REGISTERS/CHECK_REGISTER/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/CHECK_REGISTERS/CHECK_REGISTER/CUSTOMER_NM">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>	
	<xsl:template match="/REPORT/BATCHS/BATCH/CHECK_REGISTERS/CHECK_REGISTER/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	
	
	<xsl:template match="/REPORT/BATCHS/BATCH/CCARD_REGISTERS">
			<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/CCARD_REGISTERS/CCARD_REGISTER">
		<fo:table-row>
			<fo:table-cell xsl:use-attribute-sets=" TableCell1Right" padding-right="0pt" padding-left="0pt">
				<fo:block text-align="right" font-size="9pt">
	                    	<xsl:value-of select="@num"/>
			     </fo:block>
			</fo:table-cell>		
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/CCARD_REGISTERS/CCARD_REGISTER/SHT_DESC">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/CCARD_REGISTERS/CCARD_REGISTER/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/CCARD_REGISTERS/CCARD_REGISTER/CUSTOMER_NM">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>	
	<xsl:template match="/REPORT/BATCHS/BATCH/CCARD_REGISTERS/CCARD_REGISTER/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>


	<xsl:template match="/REPORT/BATCHS/BATCH/DEPO_REGISTERS">
			<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/DEPO_REGISTERS/DEPO_REGISTER">
		<fo:table-row>
			<fo:table-cell xsl:use-attribute-sets=" TableCell1Right" padding-right="0pt" padding-left="0pt">
				<fo:block text-align="right" font-size="9pt">
	                    	<xsl:value-of select="@num"/>
			     </fo:block>
			</fo:table-cell>		
			<xsl:apply-templates/>
		</fo:table-row>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/DEPO_REGISTERS/DEPO_REGISTER/SHT_DESC">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/DEPO_REGISTERS/DEPO_REGISTER/OTHER_DOC_NBR">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="center">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	<xsl:template match="/REPORT/BATCHS/BATCH/DEPO_REGISTERS/DEPO_REGISTER/CUSTOMER_NM">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="left">
				<xsl:apply-templates/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>	
	<xsl:template match="/REPORT/BATCHS/BATCH/DEPO_REGISTERS/DEPO_REGISTER/PAYMENT_AMT">
		<fo:table-cell xsl:use-attribute-sets=" TableCell1">
			<fo:block font-size="9pt" text-align="right">
				<xsl:value-of disable-output-escaping="yes" select="format-number(.,'############0.00')"/>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	
</xsl:stylesheet>
