<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
 <%--
  Created by IntelliJ IDEA.
  User: arturog
  Date: 08-02-2005
  Time: 11:20:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
    DecimalFormat formatter=new DecimalFormat("###########0.00");
    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));

    String count = request.getParameter("count");
%>
<html>
    <head>
    <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
    <title><bean:message key="app.location.DualCurrency" /></title></head>
    <script>
        function splitCurrency(){
            var frm=document.forms['SplitCurrencyForm'];
            var errors=validate();

            if(errors==""){
                var frmParent=opener.document.forms[0];
                frmParent.elements['action'].value="SplitCurrency";
                frmParent.elements['exchangeRate'].value=frm.elements['exchangeRate'].value;

                <%if("1".equals(count)){%>
                    frmParent.elements['amountToChange'].value=frm.elements['amountToChange'].value;
                <%}%>
                frmParent.submit();
                window.close();
            }else{
                alert(errors);
            }

        }
        function validate(){
            var frm=document.forms['SplitCurrencyForm'];
            var mesg="";

            if(isNaN(frm.exchangeRate.value)){
                mesg="<bean:message key="app.messages.MustSelectSource" />\n";
            }

            <%if("1".equals(count)){%>
                if(isNaN(frm.amountToChange.value)){
                   mesg="<bean:message key="app.messages.MustSelectSource" />\n";
                }
            <%}%>

            return mesg;
        }
    </script>
    </head>
        <body>
        <div align="center" style="width: 250; height: 170">
        <form name="SplitCurrencyForm">
                <table border="0" cellspacing="1" cellpadding="0" bgcolor="#000000" width="296">
                      <tr>
                        <td width="109" height="22" align="right" bgcolor="#C0C0C0">
                            <font face="Arial" size="2"><bean:message key="app.messages.ExchangeRate"/>&nbsp;&nbsp;&nbsp;&nbsp;</font>
                        </td>
                        <td bgcolor="#FFFF9C" width="184" height="22">
                          <p align="left">
                              <input type="text" name="exchangeRate" maxlength="10" tabindex="1" size="15" value="0.00">
                        </td>
                      </tr>
                <%if("1".equals(count)){%>
                        <td bgcolor="#C0C0C0" align="left" height="22">
                            <font face="Arial" size="2"><bean:message key="app.messages.AmountToChange"/>&nbsp;&nbsp;&nbsp;&nbsp;</font>
                        </td>
                        <td bgcolor="#FFFF9C" width="184" height="22" align="center">
                          <h2 align="left"> 
                              <input type="text" name="amountToChange" maxlength="10" tabindex="1" size="15" value="0.00">
          </h2></td>
                      </tr>
                <%}%>
                      <tr>
                         <td colspan="2" bgcolor="#FFFF9C" height="50">
                             <p align="center">
                               <a href="javascript:splitCurrency();"><img  align="center" border="0" src="<html:rewrite page="/images/SplitCurrency" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></a>
                               <a href="javascript:close();"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></a>
                             </p>
                         </td>
                      </tr>
                </table>
        </form>
        </div>
    </body>
</html>