<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el" %>
<%@taglib uri="/WEB-INF/gccs-util.tld" prefix="util" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@taglib uri="/WEB-INF/struts-bean-el.tld" prefix="bean-el" %>
<bean:define toScope="page" id="userProfile" name="userProfile" type="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" />
<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
%>

<html:errors />
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<jsp:include page="PrepaidDetailsJS.jsp" flush="true" />

<!-- Include comments functionality -->
<jsp:include page="../Comments.jsp" flush="true" />
<logic:present name="PRPCourierCashRecapForm">
    <nested:form action="/Prepaid/PrepaidDetails.do">
        <input type="hidden" name="action">
        <input type="hidden" name="prepaidId">
        <input type="hidden" name="oacId">
        <input type="hidden" name="reload">
        <input type="hidden" name="newCurr">

        <input type="hidden" name="newReassLocationCd">
        <input type="hidden" name="newEmployeeId">
        <input type="hidden" name="origEmployeeId">
        <input type="hidden" name="reassEmployeeId">

        <!-- Code for split currency operation -->
        <input type="hidden" name="exchangeRate">
        <input type="hidden" name="amountToChange">

        <nested:hidden property="currentCurrency" />
        <nested:hidden property="previousCurrencyCode" />
        <nested:hidden property="pageNumber" />
        <nested:hidden property="sortColumn" />
        <nested:hidden property="sortDirection" />
        <div align="left">
            <table cellpadding="0" cellspacing="1" border="0" width="100%" bgcolor="#808080">
                <tr>
                    <td bgcolor="#FFFFFF">
                        <p align="center">
                            <font color="#73148C"><font face="Arial" size="3"><b>
                            <html:link href="javascript:previousCourier();">
                                <html:img page="/images/Back.gif" border="0"  width="17" height="17"/>
                            </html:link>&nbsp;&nbsp;&nbsp;
                            <bean:message key="app.messages.AWBDetailsForEmployee" />
                            <nested:select property="courier" onchange="changeCourier();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                 <option value="ALL">ALL COURIERS</option>
                            <nested:root name="PRPCourierCashRecapForm">
                                 <nested:optionsCollection property="employeesWithPayments" label="value" value="key" />
                            </nested:root>
                            </nested:select>
                            &nbsp;&nbsp;&nbsp;
                            <html:link href="javascript:nextCourier();">
                                <html:img page="/images/Next.gif" border="0"  width="17" height="17"/>
                            </html:link>
                            </b></font>
                        </p>
                    </td>
                    <td bgcolor="#FFFFFF">
                        <p align="center"><a href="javascript:courierReceiptReport();">
                            <img border="0" src="<html:rewrite page="/images/CreateReceipt"/><bean:message key="app.Language" />.gif" width="114" height="38"></a><A href="javascript:closeEmployee();"><img border="0" src="<html:rewrite page="/images/CloseEmployee" /><bean:message key="app.Language" />.gif" width="114" height="38"></A>
                        </p>
                    </td>
                </tr>
            </table>
        </div>
        <!-- Tabla separadora-->
        <!-- TABLA DE TABS SUPERIORES -->
        <div align="left">
            <table cellpadding="0" cellspacing="1" border="0" width="100%" bgcolor="#FFFFFF">
                <tr height="1">
	                <td colspan="1" width="5" bgcolor="#FFFFFF">&nbsp;</td>
  					<td rowspan="2">	
  	                	<html:link href="javascript:toROD();" >
	                		<img border="0" src="<html:rewrite page="/images/rod1.gif" />" width="135" height="33">
	                	</html:link>
	                	<img border="0" src="<html:rewrite page="/images/prepaid.gif" />" width="135" height="33">
	                	<html:link href="javascript:toPOA();" >
	                		<img border="0" src="<html:rewrite page="/images/poa1.gif" />" width="135" height="33">
	                	</html:link>
	                	<logic:equal name="userProfile" property="gndUsedFlag" value="true" >
	                		<html:link href="javascript:toGRND();" >
	                			<img border="0" src="<html:rewrite page="/images/ground1.gif" />" width="135" height="33">
	                		</html:link>
	                	</logic:equal>
	                	<logic:equal name="userProfile" property="codUsedFlag" value="true" >
	                	<html:link href="javascript:toCOD();" >
	                		<img border="0" src="<html:rewrite page="/images/cod1.gif" />" width="135" height="33">
	                	</html:link>
	                	</logic:equal>
	                	<logic:equal name="userProfile" property="ftcUsedFlag" value="true" >
	                	<html:link href="javascript:toFTC();" >
	                		<img border="0" src="<html:rewrite page="/images/ftc1.gif" />" width="135" height="33">
	                	</html:link>
	                	</logic:equal>
	                </td>
	                <td colspan="1" bgcolor="#FFFFFF" >&nbsp;</td>
                </tr>
                <tr height="1">
	                <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
	                <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                </tr>
            </table>
        </div>
        <!-- tabla de contenidos del tab activo: tabs interiores, tabla de detalles y totales -->
        <div align="left">
            <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
                <tr>
                    <!-- Fila para mantener color del tab activo-->
	                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
	                <td bgcolor="#FFFF9C"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="5"></td>
	                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                </tr>
                <tr>
	                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
	                <td bgcolor="#FFFF9C">
	                <!-- TABS INTERNOS, TABLA DE DETALLES Y TABLA DE TOTALES -->
		            <!-- Tabs internos -->
		                <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
		                    <tr height="1">
			                    <td width="8" bgcolor="#FFFF9C" align="left">&nbsp;</td>
			                    <td bgcolor="#FFFF9C" align="left" width="300">
                                    <nested:define id="currentCurrency1" property="currentCurrency" type="java.lang.String"/>
                                    <c:forEach var="currency" items="${PRPCourierCashRecapForm.currentlyUsedCurrencies}">
                                        <c:choose>
                                            <c:when test="${currency.currencyCode eq PRPCourierCashRecapForm.currentCurrency}">
                                                <c:choose>
                                                    <c:when test="${currency.currencyCode eq 'USD'}">
                                                        <IMG src="<html:rewrite page="/images/usd.gif" />">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <IMG src="<html:rewrite page="/images/local.gif" />">
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:when>
                                            <c:otherwise>
                                                <c:choose>
                                                    <c:when test="${currency.currencyCode eq 'USD'}">
                                                        <a href="javascript:changeTab('<c:out value="${currency.currencyCode}" escapeXml="true" />')"> <IMG src="<html:rewrite page="/images/usd1.gif" />" border="0"></a>

                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="javascript:changeTab('<c:out value="${currency.currencyCode}" escapeXml="true" />')"> <IMG src="<html:rewrite page="/images/local1.gif" />" border="0"></a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <!-- code to support dual currency -->
                                    <c:if test="${PRPCourierCashRecapForm.dualCurrency eq 'true' }">
                                        <c:choose>
                                            <c:when test="${userProfile.splitCurrency eq 'true' and PRPCourierCashRecapForm.currentCurrency ne 'split'}">
                                                  <a href="javascript:changeTab('split')"> <IMG src="<html:rewrite page="/images/split1.gif" />" border="0"></a>
                                            </c:when>
                                            <c:when test="${userProfile.splitCurrency eq 'true' and PRPCourierCashRecapForm.currentCurrency eq 'split'}">
                                                  <IMG src="<html:rewrite page="/images/split.gif" />">
                                            </c:when>
                                        </c:choose>
                                    </c:if>
                                    <logic:notPresent name="alternativeCurrency" >
                                        <c:forEach var="currency" items="${PRPCourierCashRecapForm.supportedCurrencies}">
                                            <c:if test="${currency.currencyCode ne currentCurrency1}">
                                                <nested:define toScope="request"  id="alternativeCurrency" name="currency" property="currencyCode"/>
                                            </c:if>
                                        </c:forEach>
                                    </logic:notPresent>
                                    </font>
                                </td>
			                    <td bgcolor="#FFFF9C" colspan="2">
                                    <font size="2" face="Verdana"><b>
                                        <c:choose>
                                               <c:when test="${userProfile.oacUsedFlag}">
                                                       <html:radio property="showFreightOAC" value="FRE" onclick="javascript:toFreOac('OAC');"><bean:message key="app.messages.ViewFreightValues" /></html:radio>
                                                       <html:radio property="showFreightOAC" value="OAC" onclick="javascript:toFreOac('FRE');"><bean:message key="app.messages.ViewOACValues" /></html:radio>
                                              </c:when>
                                              <c:otherwise>
                                                      <html:hidden property="showFreightOAC" value="FRE"/>
                                              </c:otherwise>
                                        </c:choose>
                                    </b></font>
                                </td>
                            </tr>
		                    <tr height="1">
			                    <td bgcolor="#808080" colspan="1" height="1" width="9px" align="left"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
			                    <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
			                    <td bgcolor="#808080" colspan="1" height="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
		                    </tr>
		                </table>
                        <c:choose>
                            <c:when test="${PRPCourierCashRecapForm.showFreightOAC eq 'FRE'}">
                                <jsp:include page="/tiles/Prepaid/PrepaidFreightCashRecapList.jsp"/>
                            </c:when>
                            <c:otherwise>
                                <jsp:include page="/tiles/Prepaid/PrepaidOACCashRecapList.jsp"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </div>

        <div align="left">
            <table cellpadding="0" cellspacing="0" border="0" width="100%" bgcolor="#CE9AFF">
                <tr>
	                <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
	                <td bgcolor="#FFFF9C"></td>
                    <!-- AQUI TERMINAN LOS DETALLES -->
				    <td bgcolor="#FFFF9C" width="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                </tr>
                <tr>
                    <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                    <td bgcolor="#FFFF9C">&nbsp;</td>
                    <td bgcolor="#FFFF9C" width="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                </tr>
                <tr>
                    <td width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                    <td bgcolor="#FFFF9C">
                    <!-- comienzo tabla de totales -->
                        <div align="center">
                            <table border="0" width="837" bgcolor="#000000" cellspacing="1" cellpadding="0">
                                <!-- Code to support Dual Currency -->
                                <c:choose>
                                    <c:when test="${PRPCourierCashRecapForm.dualCurrency ne 'true' or PRPCourierCashRecapForm.currentCurrency ne 'split'}"> <!-- If not Dual currency tab selected -->
                                        <tr>
                                            <td bgcolor="#FFFF9C" colspan="8" align="center" width="795">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td bgcolor="#73148C" align="center" width="118">
                                              <p align="left"><b><font face="Verdana" color="#FFFFFF" size="2"><bean:message key="app.messages.Totals" arg0="<%=currentCurrency1%>" /></font></b></p>
                                            </td>
                                            <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.CouponTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                            <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.CashTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                            <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.CheckTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                            <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.CreditCardTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                            <td bgColor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.DepositTotal" arg0="<%=currentCurrency1%>" /></font></b></td>
                                            <td bgcolor="#C0C0C0" align="center"><b><font size="1" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.TotalPayments" arg0="<%=currentCurrency1%>" /></font></b></td>
                                            <td bgcolor="#C0C0C0" align="center">&nbsp;</td>
                                        </tr>
                                        <bean:define id="frm" name="PRPCourierCashRecapForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.PRPCourierCashRecapForm"/>
                                        <tr>
                                            <td bgcolor="#73148C" align="right" width="118"><p align="right"><b><font color="#FFFFFF">Freight</font></b></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="couponTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCouponTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="cashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCashTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="checkTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCheckTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="creditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCreditCardTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="depositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getDepositTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="totalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getTotalPayments())%>"></p></td>
                                            <td bgcolor="#C0C0C0" align="center">&nbsp;</td>
                                        </tr>

                                        <tr>
                                            <td bgcolor="#73148C" align="right" width="118"><font size="2" face="Verdana" color="#FFFFFF"><b>OAC</b></font></td>
                                            <td bgColor="#C0C0C0" width="118" align="right">&nbsp;</td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="oacCashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getOacCashTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="oacCheckTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getOacCheckTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="oacCreditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getOacCreditCardTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="oacDepositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getOacDepositTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="oacTotalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getOacTotalPayments())%>"></p></td>
                                            <td bgcolor="#C0C0C0" align="center" width="2">&nbsp;</td>
                                        </tr>

                                        <tr>
                                            <td bgcolor="#73148C" align="right" width="118"><font size="2" face="Verdana" color="#FFFFFF"><b>Grand Total</b></font></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandCouponTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandCoupon())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandCashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandCash())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandCheckTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandCheck())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandCreditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandCreditCard())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandDepositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandDeposit())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandTotalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandTotal())%>"></p></td>
                                            <td bgcolor="#C0C0C0" align="center" width="2">&nbsp;</td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise> <!-- Else if it is Dual currency tab selected -->
                                        <tr>
                                            <td bgcolor="#FFFF9C" colspan="8" align="center" width="795">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td bgcolor="#73148C" align="center" width="118">
                                              <p align="left"><b><font face="Verdana" color="#FFFFFF" size="2"><bean:message key="app.messages.Totals" arg0="<%=currentCurrency1%>" /></font></b></p>
                                            </td>
                                            <c:set var="localCurrency" value="split" />
                                                <c:forEach var="currency" items="${PRPCourierCashRecapForm.currentlyUsedCurrencies}">
                                                        <c:if test="${currency.currencyCode ne 'USD'}">
                                                              <c:set var="localCurrency" value="${currency.currencyCode}" />
                                                        </c:if>
                                                </c:forEach>
                                            <bean:define id="frm" name="PRPCourierCashRecapForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.PRPCourierCashRecapForm"/>
                                            <td bgcolor="#73148C" align="center" width="118"><font color="#FFFFFF"><b><bean-el:message key="app.messages.CouponTotal" arg0="${localCurrency}" /></b></font></td>
                                            <td bgcolor="#73148C" align="center" width="118"><b><font size="2" face="Verdana" color="#FFFFFF"><bean-el:message key="app.messages.CashTotal" arg0="${localCurrency}" /></font></b></td>
                                            <td bgcolor="#73148C" align="center" width="119"><b><font size="2" face="Verdana" color="#FFFFFF"><bean-el:message key="app.messages.CheckTotal" arg0="${localCurrency}" /></font></b></td>
                                            <td bgcolor="#73148C" align="center" width="119"><b><font size="2" face="Verdana" color="#FFFFFF"><bean-el:message key="app.messages.CreditCardTotal" arg0="${localCurrency}" /></font></b></td>
                                            <td bgcolor="#73148C" align="center" width="119"><b><font size="2" face="Verdana" color="#FFFFFF"><bean-el:message key="app.messages.DepositTotal" arg0="${localCurrency}" /></font></b></td>
                                            <td bgcolor="#73148C" align="center" width="119"><b><font size="2" face="Verdana" color="#FFFFFF"><bean-el:message key="app.messages.TotalPayments" arg0="${localCurrency}"/></font></b></td>
                                            <td bgcolor="#73148C" align="center" width="2">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td bgcolor="#73148C" align="right" width="118"><p align="right"><b><font color="#FFFFFF">Freight</font></b></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="couponTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCouponTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="cashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCashTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="checkTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCheckTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="creditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getCreditCardTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="depositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getDepositTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="totalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getTotalPayments())%>"></p></td>
                                            <td bgcolor="#C0C0C0" align="center">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td bgcolor="#73148C" align="right" width="118"><font size="2" face="Verdana" color="#FFFFFF"><b>OAC</b></font></td>
                                            <td bgColor="#C0C0C0" width="118" align="right">&nbsp;</td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="oacCashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getOacCashTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="oacCheckTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getOacCheckTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="oacCreditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getOacCreditCardTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="oacDepositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getOacDepositTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="oacTotalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getOacTotalPayments())%>"></p></td>
                                            <td bgcolor="#C0C0C0" align="center" width="2">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td bgcolor="#73148C" align="right" width="118"><font size="2" face="Verdana" color="#FFFFFF"><b>Grand Total</b></font></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandCouponTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandCoupon())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandCashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandCash())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandCheckTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandCheck())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandCreditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandCreditCard())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandDepositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandDeposit())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="grandTotalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getGrandTotal())%>"></p></td>
                                            <td bgcolor="#C0C0C0" align="center" width="2">&nbsp;</td>
                                        </tr>

                                        <tr>
                                            <td bgColor="#73148C" width="118" align="right">&nbsp;</td>
                                            <td bgcolor="#73148C" align="center" width="118"><font color="#FFFFFF"><b><bean:message key="app.messages.CouponTotal" arg0="USD" /></b></font></td>
                                            <td bgcolor="#73148C" align="center" width="118"><b><font size="2" face="Verdana" color="#FFFFFF"><bean-el:message key="app.messages.CashTotal" arg0="USD" /></font></b></td>
                                            <td bgcolor="#73148C" align="center" width="119"><b><font size="2" face="Verdana" color="#FFFFFF"><bean-el:message key="app.messages.CheckTotal" arg0="USD" /></font></b></td>
                                            <td bgcolor="#73148C" align="center" width="119"><b><font size="2" face="Verdana" color="#FFFFFF"><bean-el:message key="app.messages.CreditCardTotal" arg0="USD" /></font></b></td>
                                            <td bgcolor="#73148C" align="center" width="119"><b><font size="2" face="Verdana" color="#FFFFFF"><bean-el:message key="app.messages.DepositTotal" arg0="USD" /></font></b></td>
                                            <td bgcolor="#73148C" align="center" width="119"><b><font size="2" face="Verdana" color="#FFFFFF"><bean-el:message key="app.messages.TotalPayments" arg0="USD" /></font></b></td>
                                            <td bgcolor="#73148C" align="center" width="2">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td bgcolor="#73148C" align="right" width="118"><p align="right"><b><font color="#FFFFFF">Freight</font></b></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdCouponTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdCouponTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdCashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdCashTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdCheckTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdCheckTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdCreditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdCreditCardTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdDepositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdDepositTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdTotalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdTotalPayments())%>"></p></td>
                                            <td bgcolor="#C0C0C0" align="center" width="2">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td bgcolor="#73148C" align="right" width="118"><font size="2" face="Verdana" color="#FFFFFF"><b>OAC</b></font></td>
                                            <td bgColor="#C0C0C0" width="118" align="right">&nbsp;</td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdOacCashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdOacCashTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdOacCheckTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdOacCheckTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdOacCreditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdOacCreditCardTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdOacDepositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdOacDepositTotal())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdOacTotalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdOacTotalPayments())%>"></p></td>
                                            <td bgcolor="#C0C0C0" align="center" width="2">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td bgcolor="#73148C" align="right" width="118"><font size="2" face="Verdana" color="#FFFFFF"><b>Grand Total</b></font></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdGrandCouponTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdGrandCoupon())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdGrandCashTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdGrandCash())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdGrandCheckTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdGrandCheck())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdGrandCreditCardTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdGrandCreditCard())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdGrandDepositTotal" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdGrandDeposit())%>"></p></td>
                                            <td bgColor="#C0C0C0"><p align="center"><input type="text" size="10" name="usdGrandTotalPayments" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onfocus="this.blur();" value="<%=formatter.format(frm.getUsdGrandTotal())%>"></p></td>
                                            <td bgcolor="#C0C0C0" align="center" width="2">&nbsp;</td>
                                        </tr>
                                    </c:otherwise>
                               </c:choose>
                            </table>
                         </div>

                    </td>
				    <!-- fin tables de totales -->
 				    <td width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                </tr>
                <tr bgcolor="#808080" height="1">
                    <td colspan=3><html:img page="/images/pixel.gif" width="1" height="1"/></td>
                </tr>
            </table>
        </div>
		<!-- CIERRE TABLA TABS INTERNOS, DETALLES Y TOTALES -->
    </td>
	<td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
</tr>
<!--Fila para mantener color de borde (gris) -->
<tr>
    <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
    <td bgcolor="#FFFF9C"><img src="<html:rewrite page="/images/pixel.gif" />" width="1" height="5"></td>
    <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
</tr>
<tr bgcolor="#808080" height="1">
    <td colspan=3><html:img page="/images/pixel.gif" width="1" height="1"/></td>
</tr>
</table>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
</nested:form>
</logic:present>
<form name="createReports" method="POST">
        <input type="HIDDEN" name="Format" value="PDF">
        <input type="HIDDEN" name="locationCd" value="<bean:write name="userProfile" property="locationCd" />">
        <input type="HIDDEN" name="employeeId" value="<bean:write name="PRPCourierCashRecapForm" property="courier" />">
        <input type="HIDDEN" name="chkEmpId" value="<bean:write name="userProfile" property="employeeId" />">
        <input type="HIDDEN" name="StyleSheet" value="">
</form>