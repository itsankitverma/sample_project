<%@ page import="java.text.DecimalFormat,
                 java.text.DecimalFormatSymbols,
                 java.util.Locale"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html-el" %>
<%@taglib uri="/WEB-INF/gccs-util.tld" prefix="util" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@taglib uri="/WEB-INF/struts-bean-el.tld" prefix="bean-el" %>
<%@ taglib uri="/WEB-INF/gccs-util.tld" prefix="calendar" %>

<script src="<html:rewrite page="/scripts/calendar.js" />"></script>
<script src="<html:rewrite page="/scripts/calendar-msgs-" /><bean:message key="app.Language" />.js"></script>
<script src="<html:rewrite page="/scripts/calendar-setup.js" />"></script>
<LINK REL ="stylesheet" TYPE="text/css" HREF="<html:rewrite page="/styles/calendar.css" />" TITLE="Style">

<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
%>

<%
	// to resolve the calendar discripancy 
	int id = 0;
%>

<script>
function updateField(codeVal, index, otherComment)
    {
        if(codeVal.length > 0)
		{  document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasComment.gif"/>';
		   document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].alt=codeVal;
		}else{
				document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasNoComment.gif"/>';
			    document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].alt='<bean:message key="app.messages.js.ViewAddComment"/>';
			}
		document.forms['PRPCourierCashRecapForm'].elements['awbs['+index+'].comment'].value=codeVal;

		if(otherComment.length>0)
		{  if(codeVal.length == 0)
	       {   document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasComment.gif"/>';
		   	   document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].alt="";
		   }
		}else{
				if(codeVal.length == 0)
				{   document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasNoComment.gif"/>';
		   		   document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].alt='<bean:message key="app.messages.js.ViewAddComment"/>';
				}
			 }
		document.forms['PRPCourierCashRecapForm'].elements['awbs['+index+'].otherComment'].value=otherComment;
    }
    
function validateForAlphanumeric(id) {
	var value = document.getElementById(id).value;
	
	var pattern = new RegExp("^([0-9a-zA-Z]*)$");
	
	if(!pattern.test(value)) {
		value = value.substring(0,value.length-1);
		document.getElementById(id).value = value;
	}
	
}    
</script>
<!-- Tabla interna para detalles y totales -->
<input type="hidden" name="prepaidType" value="FRE">
<div align="center">
    <table cellpadding="0" cellspacing="0" border="0" bgcolor="#808080" width="90%">
        <tr>
            <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            <td bgcolor="#FFFF9C"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            <td bgcolor="#FFFF9C" width="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
        </tr>
        <tr>
            <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            <td bgcolor="#FFFF9C" align="center">
            <!-- AQUI VAN LOS DETALLES -->
            <div align="center">
                <table border="0" width="100%" cellspacing="0" cellpadding="0" bgcolor="#000000">
                    <tr>
                        <td bgcolor="#FFFF9C" align="left">
                            <c:if test="${PRPCourierCashRecapForm.currentCurrency ne 'split'}">
                            <%--<c:if test="${userProfile.splitCurrency ne 'true' or PRPCourierCashRecapForm.currentCurrency ne 'split'}">--%>
                                  <html:link href="javascript:reassignPayments()">
                                        <img border="0" src="<html:rewrite page="/images/ReassignPayments" /><bean:message key="app.Language" />.gif" width="113" height="38" >
                                  </html:link>
                           </c:if>
                           <c:if test="${userProfile.splitCurrency eq 'true'and PRPCourierCashRecapForm.currentCurrency ne 'split'}">
                                 <html:link href="javascript:splitCurrency()">
                                        <img border="0" src="<html:rewrite page="/images/SplitCurrency" /><bean:message key="app.Language" />.gif" width="113" height="38" >
                                </html:link>
                           </c:if>
                           <c:if test="${userProfile.quickStatus eq 'true'}">
                                 <html:link href="javascript:quickApplyStatus()">
                                        <img border="0" src="<html:rewrite page="/images/QuickClearPRP" /><bean:message key="app.Language" />.gif" width="113" height="38" >
                                 </html:link>
                           </c:if>
                           <a href="javascript:processScans();"><img border="0" src="<html:rewrite page="/images/ProcessScan"/><bean:message key="app.Language"/>.gif"></a>
                           <a href="javascript:addAwbs();"><img border="0" src="<html:rewrite page="/images/addPrepaid"/><bean:message key="app.Language" />.gif"></a>
                        </td>
                        <td bgcolor="#FFFF9C" align="center">
                           <%--<paging:pagesnav property="awbs" page="currentPage" length="length" showPage="javascript:showPage(${page},${length});"/>--%>
                           <util:paging numberOfPages="${PRPCourierCashRecapForm.numberOfPages}" pageNumber="${PRPCourierCashRecapForm.pageNumber}" varStatus="std">
                                <html-el:link href="javascript:showPage(${std.count})"><c:out value="${std.count}"/></html-el:link>
                           </util:paging>
                        </td>
                        <td bgcolor="#FFFF9C" align="right">
                            <A href="javascript:updateInformation();"><img border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif"></A>
                            <html:link page="/ShowChkAgtCashRecap.do" ><img border="0" src="<html:rewrite page="/images/Summary" /><bean:message key="app.Language" />.gif"></html:link>
                        </td>
                    </tr>
                </table>
            </div>
            </td>
            <td bgcolor="#FFFF9C" colspan="1">&nbsp;</td>
       </tr>
    </table>
</div>
<div align="center">
    <table cellpadding="0" cellspacing="0" border="0" bgcolor="#808080" width="90%">
        <tr>
            <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            <td bgcolor="#FFFF9C"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            <td bgcolor="#FFFF9C" width="1"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
        </tr>
        <tr>
            <td  width="1" bgcolor="#808080"><html:img page="/images/pixel.gif" width="1" height="1"/></td>
            <td bgcolor="#FFFF9C" align="center">
            <div align="center">
            <table border="0" bgcolor="#000000" cellspacing="1">
                <tr>
                    <td bgColor="#73148C" width="2%" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">&nbsp;</font></p></b></td>
                    <td bgColor="#73148C" width="2%" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">#</font></p></b></td>
                    <td bgColor="#73148C" width="8%" align="center" rowspan="2">
                        <c:choose>
                            <c:when test="${PRPCourierCashRecapForm.sortColumn ne 'awb_nbr'}">
                                <a href="javascript:sortTable('awb_nbr','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.AWBNumber" /></font></b></a>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${PRPCourierCashRecapForm.sortDirection eq 'desc'}">
                                        <a href="javascript:sortTable('awb_nbr','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.AWBNumber" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/desc.gif" />"></b></a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="javascript:sortTable('awb_nbr','desc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.AWBNumber" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/asc.gif" />"></b></a>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td bgColor="#73148C" width="8%" align="center" rowspan="2"><b><p align="center"><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.ReceiptNbr" /></font></b></td>
                    <td bgColor="#73148C" width="10%" align="center" rowspan="2">
                        <c:choose>
                            <c:when test="${PRPCourierCashRecapForm.sortColumn ne 'awb_dt'}">
                                <a href="javascript:sortTable('awb_dt','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.date" /></font></b></a>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${PRPCourierCashRecapForm.sortDirection eq 'desc'}">
                                        <a href="javascript:sortTable('awb_dt','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.date" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/desc.gif" />"></b></a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="javascript:sortTable('awb_dt','desc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.date" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/asc.gif" />"></b></a>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td bgColor="#73148C" width="8%" align="center" rowspan="2"><b><p align="center"><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.ScanAmount1" /></font></b></td>
                    <c:if test="${RODCourierCashREcap.dualCurrency eq 'true' or PRPCourierCashRecapForm.currentCurrency eq 'split'}">
                          <td bgColor="#73148C" rowspan="2"><p align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Currency" /></b></font></p></td>
                    </c:if>
                    <td bgColor="#73148C" width="8%" rowspan="2" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Coupon" /></font></b></td>
                    <td bgColor="#73148C" width="8%" rowspan="2" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.Cash" /></font></b></td>
                    <td bgColor="#73148C" width="8%" colspan="3" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2" color="#FFFFFF"><bean:message key="app.messages.PaymentDocument" /></font></b></td>
                    <td bgColor="#73148C" width="12%" rowspan="2" align="center"><b><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.Comments" /></font></b></td>
                    <td bgColor="#73148C" width="8%" rowspan="2" align="center">
                        <c:choose>
                            <c:when test="${PRPCourierCashRecapForm.sortColumn ne 'status_cd'}">
                                <a href="javascript:sortTable('status_cd','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Status" /></font></b></a>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${PRPCourierCashRecapForm.sortDirection eq 'desc'}">
                                        <a href="javascript:sortTable('status_cd','asc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Status" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/desc.gif" />"></b></a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="javascript:sortTable('status_cd','desc');" ><b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.Status" /></font>&nbsp;<img border="0" src="<html:rewrite page="/images/asc.gif" />"></b></a>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <!--changes for MISCELLANEOUS_DATE  Saurabh: 08/06/2013-->
                    <td bgColor="#73148C" rowspan="2" colspan="1">
                    	<b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.MISCELLANEOUSDATE" /></font></b>
                    </td>
                    <td bgColor="#73148C" rowspan="2" colspan="1">
                    	<b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.MISCELLANEOUSNBR" /></font></b>
                    </td>                                                        
                    <!--changes for MISCELLANEOUS_DATE  Saurabh: 08/06/2013-->                    
                </tr>
                <tr>
                    <td bgColor="#73148C" align="center"><b><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.Amount" /></font></b></td>
                    <td bgColor="#73148C" align="center"><b><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.Number" /></font></b></td>
                    <td bgColor="#73148C" align="center"><b><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><bean:message key="app.messages.Type" /></font></b></td>
                </tr>
                <nested:iterate property="awbs" id="rec" indexId="idx" name="PRPCourierCashRecapForm" type="com.fedex.lacitd.cashcontrol.biztier.common.PrepaidDetailsTableVO">
                    <nested:hidden property="prepaidId" />
                    <nested:hidden property="awbNumber" />
                    <nested:hidden property="scanAmount" />
                    <nested:hidden property="comment" />
                    <nested:hidden property="otherComment" />
                    <nested:hidden property="couponPaymentPrev" />
                    <nested:hidden property="cashPaymentPrev" />
                    <nested:hidden property="otherPaymentPrev" />
                    <nested:hidden property="otherDocNumberPrev" />
                    <nested:hidden property="otherPaymentTypePrev" />
                    <nested:hidden property="commentPrev" />
                    <nested:hidden property="statusIdPrev" />
                    <nested:hidden property="otherCommentPrev" />
                    <nested:hidden property="surChargesTotal"/>
                    <nested:hidden property="rcptNbrPrev" />
                    <nested:hidden property="paymentCurrency" />
					<nested:hidden property="billAccount" />
                    <nested:hidden property="billAccountPrev" />
                    <%
                        String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff");
                        String surchrgImg=null;
                        if(rec.getSurChargesTotal()==0){
                            surchrgImg="/images/moneyGray.gif";
                        }else{
                            if(rec.getSurChargesTotal()==(rec.getOtherPayment()+rec.getCashPayment())){
                                surchrgImg="/images/moneyGreen.gif";
                            }else{
                                surchrgImg="/images/moneyRed.gif";
                            }
                        }
                    %>
                         <tr>
                          <!-- if for split currency operation -->
                           <c:choose>
                                   <c:when test="${PRPCourierCashRecapForm.dualCurrency ne 'true' or PRPCourierCashRecapForm.currentCurrency ne 'split'}">
                                        <td bgColor="#73148C"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><nested:checkbox property="selected" /></font></p></b></td>
                                        <td bgColor="#73148C"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><%=idx.intValue()+1%></font></p></b></td>
                                        <td bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1"><nested:write property="awbNumber" /></font></b>
                                            <a href="javascript:showScans('<nested:write property="awbNumber"/>')"><IMG border="0" src="<html:rewrite page="/images/scans.gif" />"></a>
                                        </td>
                                        <td nowrap bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1">
                                            <nested:notEmpty property="rcptNbr">
                                                <a href="javascript:changeReceiptNbr(<%=idx%>)"><IMG border="0" src="<html:rewrite page="/images/change.gif" />"></a>
                                                <%String styleStr="TEXT-ALIGN: right;font-family: Verdana, AriaVISADTL.TXTWed_Feb_22_05_40_08_CST_2006l, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\";  border: 0; font-weight: bold";%>
                                                <nested:text property="rcptNbr" maxlength="20" onfocus="blur()"  size="9" style="<%=styleStr%>"/></FONT></B>
                                            </nested:notEmpty>
                                            <nested:empty property="rcptNbr">
                                                <nested:text property="rcptNbr" onblur="checkRcptNbr(this)" maxlength="20" size="9" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt;font-weight: bold"/>
                                            </nested:empty>
                                        </td>
                                        <td bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1"><nested:write property="awbDate" formatKey="app.format.Date" /></font></b></td>
                                        <td bgColor="<%=bgColor%>" align="center"><b><p align="right"><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1">
                                            <nested:write property="scanAmount" formatKey="app.format.NumberFormat" />
                                            <logic:present name="alternativeCurrency" >
                                                <A href="javascript:changePaymentCurr(<nested:write property="prepaidId" />,'<bean:write name="alternativeCurrency" />')"><IMG border="0" src="<html:rewrite page="/images/info.gif"/>"/></A>
                                            </logic:present>
                                            </font></p></b>
                                        </td>
                                        <td bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:text property="couponPayment" onchange="couponChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getCouponPayment())%>" /></font></b></td>
                                        <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="cashPayment" onchange="cashChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getCashPayment())%>" /></font></b></p></td>
                                        <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherPayment" onchange="otherChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getOtherPayment())%>" /></font></b></p></td>
                                        <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherDocNumber" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onkeypress="docNbrKey(event,this)" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onfocus="this.style.backgroundColor='#FFFFBF'" maxlength="50" /></font></b></p></td>
                                        <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                            <nested:select property="otherPaymentType"  onchange="otherChanged();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                                <option>None</option>
                                                <html:optionsCollection name="PRPCourierCashRecapForm" property="paymentTypes" label="shtDesc" value="paymentTypeId"  />
                                            </nested:select>
                                        </font></b></p></td>
                                        <td bgColor="<%=bgColor%>" align="center">
                                        <!-- Pone la figura para indicar si tiene o no comentarios -->
                                            <A href="javascript:showCommentsWindow(<%=idx.intValue()%>,'awbs','PRPCourierCashRecapForm','comment', 'otherComment', document.PRPCourierCashRecapForm.elements['awbs['+<%=idx.intValue()%>+'].billAccount'].value);">
                                                <logic:notEmpty name="rec" property="comment">
                                                    <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>" alt="<bean:write name="rec" property="comment"/>">
                                                </logic:notEmpty>
                                                <logic:empty name="rec" property="comment">
                                                    <logic:notEmpty name="rec" property="otherComment">
                                                        <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>">
                                                    </logic:notEmpty>
                                                    <logic:empty name="rec" property="otherComment">
                                                        <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasNoComment.gif"/>" alt="<bean:message key="app.messages.ViewAddComment"/>">
                                                    </logic:empty>
                                                </logic:empty>
                                            </A>
                                            <a href="javascript:viewSurcharges(<nested:write property="prepaidId" />,<%=idx%>)">
                                                <html:img imageName="surchrgImg<%=idx%>" border="0" page="<%=surchrgImg%>"/>
                                            </a>
                                        </td>
                                        
                                        <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                                <nested:select property="statusId" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onchange="changeStatus(this);">
                                                    <nested:root name="PRPCourierCashRecapForm">
                                                        <nested:optionsCollection property="preStatus" label="statusDesc" value="statusIdNbr" />
                                                    </nested:root>
                                            </nested:select>
                                            </font></b></p>
                                        </td>
                                        
                                         <TD align="left" bgColor="<%=bgColor%>">
                                         	<FONT face="Verdana, Arial, Helvetica, sans-serif" size=1>
                                         		<!--calendar js  -->
                                         		<%String iconUrl=request.getContextPath()+"/images/cal.gif";%>
                                         		<input type="text" id="miscDate<%=id %>" name="awbs[<%=id%>].miscDate" value="<bean:write name="rec" property="miscDate"/>" maxlength="10" size="10"/><a href="#"><img id="triggermiscDate<%=id %>" src="<%=iconUrl%>" border="0"/></a>


												<script type="text/javascript">
													Calendar.setup({inputField     :    "miscDate<%=id %>",ifFormat       :    "%m/%d/%Y",button         :    "triggermiscDate<%=id %>",align          :    "Bl",singleClick    :    true});
												</script>
                                                <!--calendar js  -->
                                         	</FONT>
                                         </TD>
                                         <TD align="center" bgColor="<%=bgColor%>">
                                         	<FONT face="Verdana, Arial, Helvetica, sans-serif" size=1>
                                         		<input id="miscNbr<%=id %>" onkeyup="validateForAlphanumeric('miscNbr<%=id %>')" type="text" name="awbs[<%=id++ %>].miscNbr" value="<bean:write name="rec" property="miscNbr"/>" maxlength="15" size="15"/>
                                          </FONT>
                                         </TD>                                          
                                                                                 
                                  </c:when>
                                  <c:otherwise>
                                             <c:choose>
                                                <c:when test="${idx%2 eq 0}">
                                                        <td bgColor="#73148C" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><nested:checkbox property="selected" /></font></p></b></td>
                                                        <td bgColor="#73148C" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">
                                                                <c:choose>
                                                                        <c:when test="${idx eq 0}">
                                                                               <c:out value="${idx+1}"></c:out>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                                <% int intRow = (idx.intValue()/2) + 1;
                                                                                   String strRow = new Integer(intRow).toString();
                                                                                %>
                                                                                <%=strRow%>
                                                                        </c:otherwise>
                                                                </c:choose>
                                                        </font></p></b></td>
                                                        <td bgColor="<%=bgColor%>" align="center" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1"><nested:write property="awbNumber" /></font></b>
                                                            <a href="javascript:showScans('<nested:write property="awbNumber"/>')"><IMG border="0" src="<html:rewrite page="/images/scans.gif" />"></a>
                                                        </td>
                                                        <td nowrap bgColor="<%=bgColor%>" align="center" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1">
                                                            <nested:notEmpty property="rcptNbr">
                                                                <a href="javascript:changeReceiptNbr(<%=idx%>)"><IMG border="0" src="<html:rewrite page="/images/change.gif" />"></a>
                                                                <%String styleStr="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\";  border: 0; font-weight: bold";%>
                                                                <nested:text property="rcptNbr" maxlength="20" onfocus="blur()"  size="9" style="<%=styleStr%>"/></FONT></B>
                                                            </nested:notEmpty>
                                                            <nested:empty property="rcptNbr">
                                                                <nested:text property="rcptNbr" onblur="checkRcptNbr(this)" maxlength="20" size="9" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; font-weight: bold"/>
                                                            </nested:empty>
                                                        </td>
                                                        <td bgColor="<%=bgColor%>" align="center" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1"><nested:write property="awbDate" formatKey="app.format.Date" /></font></b></td>
                                                        <td bgColor="<%=bgColor%>" align="center" rowspan="2"><b><p align="right"><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1">
                                                            <nested:write property="scanAmount" formatKey="app.format.NumberFormat" />
                                                            <%--<logic:present name="alternativeCurrency" >
                                                                <A href="javascript:changePaymentCurr(<nested:write property="prepaidId" />,'<bean:write name="alternativeCurrency" />')"><IMG border="0" src="<html:rewrite page="/images/info.gif" />"></A>
                                                            </logic:present>--%>
                                                            </font></p></b>
                                                        </td>
                                                </c:when>
                                                <c:otherwise>
                                                            <!-- Hidden fields to support dual currency -->
                                                            <nested:hidden property="awbNumber"/>
                                                            <nested:hidden property="rcptNbr"/>
                                                            <%-- <nested:hidden property="awbDate"/> --%>
                                                            <nested:hidden property="scanAmount"/>
                                                </c:otherwise>
                                             </c:choose>
                                            <TD align=center nowrap  bgColor="<%=bgColor%>" align="center"><p align="center"><b>
                                                            <FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1">
                                                                    <nested:write property="paymentCurrency"/></FONT></B></p>
                                            </TD>
                                            <td bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="1"><nested:text property="couponPayment" onchange="couponChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getCouponPayment())%>" /></font></b></td>
                                            <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="cashPayment" onchange="cashChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getCashPayment())%>" /></font></b></p></td>
                                            <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherPayment" onchange="otherChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getOtherPayment())%>" /></font></b></p></td>
                                            <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherDocNumber" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onkeypress="docNbrKey(event,this)" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onfocus="this.style.backgroundColor='#FFFFBF'"/></font></b></p></td>
                                            <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                                <nested:select property="otherPaymentType"  onchange="otherChanged();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                                    <option>None</option>
                                                    <html:optionsCollection name="PRPCourierCashRecapForm" property="paymentTypes" label="shtDesc" value="paymentTypeId"  />
                                                </nested:select>
                                            </font></b></p></td>
                                            <td bgColor="<%=bgColor%>" align="center">
                                            <!-- Pone la figura para indicar si tiene o no comentarios -->
                                                <A href="javascript:showCommentsWindow(<%=idx.intValue()%>,'awbs','PRPCourierCashRecapForm','comment', 'otherComment', document.PRPCourierCashRecapForm.elements['awbs['+<%=idx.intValue()%>+'].billAccount'].value);">
                                                    <logic:notEmpty name="rec" property="comment">
                                                        <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>" alt="<bean:write name="rec" property="comment"/>">
                                                    </logic:notEmpty>
                                                    <logic:empty name="rec" property="comment">
                                                        <logic:notEmpty name="rec" property="otherComment">
                                                            <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasComment.gif"/>">
                                                        </logic:notEmpty>
                                                        <logic:empty name="rec" property="otherComment">
                                                            <IMG border="0" name="imgComment<%=idx%>" src="<html:rewrite page="/images/hasNoComment.gif"/>" alt="<bean:message key="app.messages.ViewAddComment"/>">
                                                        </logic:empty>
                                                    </logic:empty>
                                                </A>
                                                <a href="javascript:viewSurcharges(<nested:write property="prepaidId" />,<%=idx%>)">
                                                    <%--<IMG name="surchrgImg<%=idx%>" border="0" src="<html:rewrite page="${pageScope.surchrgImg}"/>">--%>
                                                    <html:img imageName="surchrgImg<%=idx%>" border="0" page="<%=surchrgImg%>"/>
                                                </a>
                                            </td>
                                            <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                                <nested:select property="statusId" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onchange="changeStatus(this);">
                                                    <nested:root name="PRPCourierCashRecapForm">
                                                        <nested:optionsCollection property="preStatus" label="statusDesc" value="statusIdNbr" />
                                                    </nested:root>
                                                </nested:select>
                                                </font></b></p>
                                            </td>
                                 </c:otherwise>
                           </c:choose>
                        </tr>
                </nested:iterate>
                <td bgcolor="#FFFF9C" colspan="14" align="center">
                   <%--<paging:pagesnav property="awbs" page="currentPage" length="length" showPage="javascript:showPage(${page},${length});"/>--%>
                   <util:paging numberOfPages="${PRPCourierCashRecapForm.numberOfPages}" pageNumber="${PRPCourierCashRecapForm.pageNumber}" varStatus="std">
                        <html-el:link href="javascript:showPage(${std.count})"><c:out value="${std.count}"/></html-el:link>
                   </util:paging>
                </td>
            </table>
            </div>
            </td>
        </tr>
    </table>
</div>