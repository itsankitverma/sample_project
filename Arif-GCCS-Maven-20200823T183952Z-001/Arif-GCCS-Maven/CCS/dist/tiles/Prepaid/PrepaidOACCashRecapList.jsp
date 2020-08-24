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

<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
%>


<script type="text/javascript">
function updateField(codeVal, index, otherComment)
    {
        if(codeVal.length > 0)
		{  document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasComment.gif"/>';
		   document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].alt=codeVal;
		}else{
				document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].src='<html:rewrite page="/images/hasNoComment.gif"/>';
			    document.forms['PRPCourierCashRecapForm'].elements['imgComment'+index].alt='<bean:message key="app.messages.js.ViewAddComment"/>';
			}
		document.forms['PRPCourierCashRecapForm'].elements['oacs['+index+'].comment'].value=codeVal;

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
		document.forms['PRPCourierCashRecapForm'].elements['oacs['+index+'].otherComment'].value=otherComment;
    }

    function addOAC(){
          var w=600;
          var h=550;
          if(w>screen.width)w=screen.width;
          if(h>screen.height)h=screen.height;
          var leftpos=(screen.width-w) / 2;
          var toppos=(screen.height-h) / 2;

          window.open("<html:rewrite page="/OAC/AddOAC.do" />?courierId=<bean:write name="PRPCourierCashRecapForm" property="courier"/>&currencyCd=<bean:write name="PRPCourierCashRecapForm" property="currentCurrency"/>", "addOAC", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no");

          window.onfocus="win.focus();";
		  document.onmousedown="win.focus;";
		  document.onkeydown="win.focus;"
    }


</script>
<input type="hidden" name="prepaidType" value="OAC">
<div align="center">
    <table cellpadding="0" cellspacing="0" border="0" bgcolor="#808080" width="90%">
        <tr>
            <td  width="1" bgcolor="#808080"><font size="2" face="Verdana"><html:img page="images/pixel.gif" height="1" width="1"/></font></td>
            <td bgcolor="#FFFF9C"><font size="2" face="Verdana"><html:img page="images/pixel.gif" height="1" width="1"/></font></td>
            <td bgcolor="#FFFF9C" width="1"><font size="2" face="Verdana"><html:img page="images/pixel.gif" height="1" width="1"/></font></td>
        </tr>
        <tr>
            <td  width="1" bgcolor="#808080"><font size="2" face="Verdana"><html:img page="images/pixel.gif" height="1" width="1"/></font></td>
            <td bgcolor="#FFFF9C" align="center">
                <!-- AQUI VAN LOS DETALLES -->
                <div align="center">
                    <table border="0" width="100%" cellspacing="0" cellpadding="0" bgcolor="#000000">
                        <tr>
                            <td bgcolor="#FFFF9C" align="left">
                                    <a href="javascript:addOAC();"><img border="0" src="<html:rewrite page="/images/addOAC"/><bean:message key="app.Language" />.gif"></a>
                                    <c:if test="${userProfile.splitCurrency eq 'true'and PRPCourierCashRecapForm.currentCurrency ne 'split'}">
                                        <html:link href="javascript:splitCurrencyOAC()">
                                            <img border="0" src="<html:rewrite page="/images/SplitCurrency" /><bean:message key="app.Language" />.gif" width="113" height="38" >
                                        </html:link>
                                    </c:if>
                            </td>
                            <td bgcolor="#FFFF9C" align="center">
                                <b><font face="Verdana" size="3"><bean:message key="app.messages.OutboundAncillaryCharges"/></font></b>
                            </td>
                            <td bgcolor="#FFFF9C" align="right">
                                <font size="2" face="Verdana">
                                    <A href="javascript:updateInformation();"><img border="0" src="<html:rewrite page="/images/Save"/><bean:message key="app.Language" />.gif" width="114" height="38"></A>
                                    <html:link page="/ShowChkAgtCashRecap.do" ><img border="0" src="<html:rewrite page="/images/Summary" /><bean:message key="app.Language" />.gif"></html:link>
                                </font>
                            </td>
                        </tr>
                    </table>
                </div>
                <div align="left">
                    <table border="0" bgcolor="#000000" cellspacing="1">
                        <tr>
                            <td bgColor="#73148C" width="2%" rowspan="2"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">&nbsp;</font></p></b></td>
                            <td bgColor="#73148C" width="2%" rowspan="2"><b><p align="center"><font face="Verdana" color="#FFFFFF" size="2">#</font></p></b></td>
                            <td bgColor="#73148C" width="8%" align="center" rowspan="2">
                                <b><font size="2" face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF"><bean:message key="app.messages.AWBNumber" /></font></b>
                            </td>
                            <td bgColor="#73148C" width="8%" align="center" rowspan="2"><b><p align="center"><font color="#FFFFFF" size="2" face="Verdana"><bean:message key="app.messages.ReceiptNbr" /></font></b></td>
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
                            <c:if test="${RODCourierCashREcap.dualCurrency eq 'true' or PRPCourierCashRecapForm.currentCurrency eq 'split'}">
                                <td bgColor="#73148C" rowspan="2"><p align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><b><bean:message key="app.messages.Currency" /></b></font></p></td>
                            </c:if>
                            <td bgColor="#73148C" width="8%" rowspan="2" align="center"><b><font face="Verdana" size="2" color="#FFFFFF"><bean:message key="app.messages.Cash" /></font></b></td>
                            <td bgColor="#73148C" width="8%" colspan="3" align="center"><b><font face="Verdana" size="2" color="#FFFFFF"><bean:message key="app.messages.PaymentDocument" /></font></b></td>
                            <td bgColor="#73148C" width="12%" rowspan="2" align="center"><b><font color="#FFFFFF" size="2" face="Verdana"><bean:message key="app.messages.Comments" /></font></b></td>
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
                        </tr>
                        <tr>
                            <td bgColor="#73148C" align="center"><b><font color="#FFFFFF" size="2" face="Verdana"><bean:message key="app.messages.Amount" /></font></b></td>
                            <td bgColor="#73148C" align="center"><b><font color="#FFFFFF" size="2" face="Verdana"><bean:message key="app.messages.Number" /></font></b></td>
                            <td bgColor="#73148C" align="center"><b><font color="#FFFFFF" size="2" face="Verdana"><bean:message key="app.messages.Type" /></font></b></td>
                        </tr>
                    <nested:iterate property="oacs" id="rec" indexId="idx" name="PRPCourierCashRecapForm" type="com.fedex.lacitd.cashcontrol.biztier.common.OACDetailsTableVO">
                        <nested:hidden property="oacId" />
                        <nested:hidden property="comment" />
                        <nested:hidden property="otherComment" />
                        <nested:hidden property="cashPaymentPrev" />
                        <nested:hidden property="otherPaymentPrev" />
                        <nested:hidden property="otherDocNumberPrev" />
                        <nested:hidden property="otherPaymentTypePrev" />
                        <nested:hidden property="commentPrev" />
                        <nested:hidden property="statusIdPrev" />
                        <nested:hidden property="paymentCurrency" />

                        <%
                            String bgColor=((idx.intValue()%2)==0?"#C0C0C0":"#ffffff");
                        %>
                        <tr>
                            <!-- if no split currency operation -->
                            <c:choose>
                                <c:when test="${PRPCourierCashRecapForm.dualCurrency ne 'true' or PRPCourierCashRecapForm.currentCurrency ne 'split'}">
                                <td bgColor="#73148C"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><nested:checkbox property="selected" /></font></p></b></td>
                                <td bgColor="#73148C"><b><p align="center"><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1"><%=idx.intValue()+1%></font></p></b></td>
                                <td bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1">
                                        <nested:select property="oacAwbs" size="2" >
                                                <nested:options property="awbs"/>
                                        </nested:select>
                                    </font></b></td>
                                <td nowrap bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1">
                                    <nested:notEmpty property="rcptNbr">
                                        <a href="javascript:changeReceiptNbr(<%=idx%>)"><IMG border="0" src="<html:rewrite page="/images/change.gif" />"></a>
                                        <%String styleStr="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\";  border: 0; font-weight: bold";%>
                                        <nested:text property="rcptNbr" maxlength="20" onfocus="blur()"  size="9" style="<%=styleStr%>"/>
                                    </nested:notEmpty>
                                    <nested:empty property="rcptNbr">
                                        <nested:text property="rcptNbr" onblur="checkRcptNbr(this)" maxlength="20" size="9" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt;font-weight: bold"/></FONT></B>
                                    </nested:empty>
                                </td>
                                <td bgColor="<%=bgColor%>" align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1"><nested:write property="oacDate" formatKey="app.format.Date" /></font></b></td>
                                <td bgColor="<%=bgColor%>" align="center" nowrap><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                            <logic:present name="alternativeCurrency" >
                                                <A href="javascript:changePaymentCurr(<nested:write property="oacId" />,'<bean:write name="alternativeCurrency" />')"><IMG border="0" src="<html:rewrite page="/images/info.gif" />"></A>
                                            </logic:present>
                                            <nested:text property="cashPayment" onchange="oacCashChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getCashPayment())%>" /></font></b></p>
                                </td>
                                <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherPayment" onchange="oacOtherChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getOtherPayment())%>" /></font></b></p></td>
                                <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherDocNumber" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onkeypress="docNbrKey(event,this)" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onfocus="this.style.backgroundColor='#FFFFBF'" maxlength="50" /></font></b></p></td>
                                <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                    <nested:select property="otherPaymentType"  onchange="oacOtherChanged();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                        <option>None</option>
                                        <html:optionsCollection name="PRPCourierCashRecapForm" property="paymentTypes" label="shtDesc" value="paymentTypeId"  />
                                    </nested:select>
                                </font></b></p></td>
                                <td bgColor="#C0C0C0" align="center">
                                    <font size="2" face="Verdana">
                                    <!-- Pone la figura para indicar si tiene o no comentarios -->
                                    <A href="javascript:showCommentsWindow(<%=idx.intValue()%>,'oacs','PRPCourierCashRecapForm','comment', 'otherComment','');">
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
                                    </font>
                                </td>
                                <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                    <nested:select property="statusId" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onchange="changeOacStatus(this);">
                                        <nested:root name="PRPCourierCashRecapForm">
                                            <nested:optionsCollection property="oacStatus" label="statusDesc" value="statusIdNbr" />
                                        </nested:root>
                                    </nested:select>
                                </font></b></p></td>
                              </c:when>
                              <c:otherwise> <!-- if split currency operation -->
                                <c:choose>
                                    <c:when test="${idx%2 eq 0}">
                                        <td bgColor="#73148C" rowspan="2" align="center"><b><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">&nbsp;</font></b></td>
                                        <td bgColor="#73148C" rowspan="2" align="center"><b><font face="Verdana,Arial, Helvetica, sans-serif" color="#FFFFFF" size="1">
                                            <c:choose>
                                                <c:when test="${idx eq 0}">
                                                   <c:out value="${idx+1}"></c:out>
                                                </c:when>
                                                <c:otherwise>
                                                    <% int intRow = (idx.intValue()/2) + 1;
                                                       String strRow = Integer.toString(intRow);
                                                    %>
                                                    <%=strRow%>
                                                </c:otherwise>
                                            </c:choose>
                                        </font></b></td>
                                        <td bgColor="<%=bgColor%>" align="center" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1">
                                            <nested:select property="oacAwbs" size="2" >
                                                <nested:options property="awbs"/>
                                            </nested:select>
                                            </font></b>
                                        </td>
                                        <td nowrap bgColor="<%=bgColor%>" align="center" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1">
                                            <nested:notEmpty property="rcptNbr">
                                                <a href="javascript:changeReceiptNbr(<%=idx%>)"><html:img border="0" page="/images/change.gif"/></a>
                                                <%String styleStr="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt; background-color: \"+bgColor+\";  border: 0; font-weight: bold";%>
                                                <nested:text property="rcptNbr" maxlength="20" onfocus="blur()"  size="9" style="<%=styleStr%>"/></FONT></B>
                                            </nested:notEmpty>
                                            <nested:empty property="rcptNbr">
                                                <nested:text property="rcptNbr" onblur="checkRcptNbr(this)" maxlength="20" size="9" style="TEXT-ALIGN: right;font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 7 pt;font-weight: bold"/>
                                            </nested:empty>
                                        </td>
                                        <td bgColor="<%=bgColor%>" align="center" rowspan="2"><b><font face="Verdana, Arial, Helvetica, sans-serif" color="#000000" size="1"><nested:write property="oacDate" formatKey="app.format.Date" /></font></b></td>
                                    </c:when>
                                    <c:otherwise>
                                        <nested:hidden property="rcptNbr"/>
                                    </c:otherwise>
                                    <TD align="center" bgColor="<%=bgColor%>">
                                       <FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1">
                                             <b><nested:write property="paymentCurrency"/></b>
                                       </FONT>
                                    </TD>
                                    <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="cashPayment" onchange="oacCashChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getCashPayment())%>" /></font></b></p></td>
                                    <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherPayment" onchange="oacOtherChanged();" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt;TEXT-ALIGN: right;" value="<%=formatter.format(rec.getOtherPayment())%>" /></font></b></p></td>
                                    <td bgColor="<%=bgColor%>" align="center"><p align="right"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><nested:text property="otherDocNumber" size="10" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onkeypress="docNbrKey(event,this)" onblur="this.style.backgroundColor='#ffffff';parseDocNbr(this);" onfocus="this.style.backgroundColor='#FFFFBF'" maxlength="50" /></font></b></p></td>
                                    <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                        <nested:select property="otherPaymentType"  onchange="oacOtherChanged();" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
                                            <option>None</option>
                                            <html:optionsCollection name="PRPCourierCashRecapForm" property="paymentTypes" label="shtDesc" value="paymentTypeId"  />
                                        </nested:select>
                                    </font></b></p></td>
                                    <td bgColor="<%=bgColor%>" align="center">
                                        <font size="2" face="Verdana">
                                        <!-- Pone la figura para indicar si tiene o no comentarios -->
                                        <A href="javascript:showCommentsWindow(<%=idx.intValue()%>,'oacs','PRPCourierCashRecapForm','comment', 'otherComment','');">
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
                                        </font>
                                    </td>
                                    <td bgColor="<%=bgColor%>" align="center"><p align="center"><b><font face="Verdana, Arial, Helvetica, sans-serif" size="2">
                                        <nested:select property="statusId" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt" onchange="changeOacStatus(this);">
                                            <nested:root name="PRPCourierCashRecapForm">
                                                <nested:optionsCollection property="preStatus" label="statusDesc" value="statusIdNbr" />
                                            </nested:root>
                                        </nested:select>
                                    </font></b></p></td>

                                </c:choose>
                              </c:otherwise>
                           </c:choose>
                        </tr>
                </nested:iterate>
                  <td bgcolor="#FFFF9C" colspan="12" align="center">
                   <util:paging numberOfPages="${PRPCourierCashRecapForm.numberOfPages}" pageNumber="${PRPCourierCashRecapForm.pageNumber}" varStatus="std">
                        <html-el:link href="javascript:showPage(${std.count})"><c:out value="${std.count}"/></html-el:link>
                   </util:paging>
                  </td>
                </table>
            </div>
            <!-- AQUI TERMINAN LOS DETALLES -->
        </td>
        <td bgcolor="#FFFF9C" width="1"><font size="2" face="Verdana"><html:img page="images/pixel.gif" height="1" width="1"/></font></td>
    </tr>
    </table>
</div>