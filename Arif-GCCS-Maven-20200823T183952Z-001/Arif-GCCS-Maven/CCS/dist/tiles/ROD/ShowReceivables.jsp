<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>
    function assignThis(recId){
        document.forms['AddReceivableForm'].recId.value=recId;
        document.forms['AddReceivableForm'].action.value="ShowToAssign";
        document.forms['AddReceivableForm'].submit();        
    }
    function createNew(){
        document.forms['AddReceivableForm'].action.value="CreateNew";
        document.forms['AddReceivableForm'].submit();        
    }

    function reassignAll(){
        document.forms['AddReceivableForm'].action.value="ReassignReceivables";
        document.forms['AddReceivableForm'].submit();
    }

    function reassignPayments(){
        var form=document.forms['AddReceivableForm'];
        var w=400;
        var h=200;
        var index=Number(0);
        var count=Number(0);
        var empId;

        while(eval("form.elements['awbs["+index+"].selected']") && count<2){
          if(eval("form.elements['awbs["+index+"].selected']").checked){
             count++;
          }
          index++;
        }

        if(count==0){
          alert("<bean:message key="app.messages.MustSelectPaymentReassign"/> ");
          return;
        }

        empId=form.recEmployeeId.value;
        var params="multipleSelected=false&oldEmployee="+empId+"&rec=true&";

        if(w>screen.width)w=screen.width;
        if(h>screen.height)h=screen.height;
        var leftpos=(screen.width-w) / 2;
        var toppos=(screen.height-h) / 2;

        window.open("<html:rewrite page="/ReassignPayments.do" />?"+params,"reassign","scrollbars=yes,toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no,width="+w+", height="+h+",left="+leftpos+",top="+toppos);
    }

    function selectUnselect(){
        var form=document.forms['AddReceivableForm'];
        var index=0;
        var selAll=false;

        selAll = eval(form.selectAll.checked);

        if(selAll == true){
            while(eval("form.elements['awbs["+index+"].selected']")){
                form.elements['awbs['+index+'].selected'].checked=true;
                index++;
                }
        } else{
            while(eval("form.elements['awbs["+index+"].selected']")){
                form.elements['awbs['+index+'].selected'].checked=false;
                index++;
                }
        }
    }

</script>
<html:errors />
<nested:form action="/ROD/AddReceivable.do">
    <input type="hidden" name="recId" value=""/>
    <input type="hidden" name="recEmployeeId" value="<c:out value='${AddReceivableForm.recEmployeeId}'/>"/>
    <input type="hidden" name="currencyCode" value="<c:out value='${AddReceivableForm.currencyCode}'/>"/>
    <input type="hidden" name="recAwbNumber" value="<c:out value='${AddReceivableForm.recAwbNumber}'/>"/>
    <input type="hidden" name="locationCd" value="<c:out value='${AddReceivableForm.locationCd}'/>"/>
    <input type="hidden" name="action" value="ShowToAssign">
<TABLE cellSpacing=1 cellPadding=0 width="100%" align=center bgColor="#000000">
  <TBODY>
  <TR>
    <TD bgcolor="#73148C" colSpan=8>
      <DIV align=center><FONT face="Arial" color="#FFFFFF" size=3><B><bean:message key="app.messages.ListOfReceivables" /></B></FONT></DIV>
    </TD>
  </TR>
  <TR>
    <TD align=middle bgColor="#73148C"><FONT face="Arial" color="#ffffff" size=3><input type="checkbox" name="selectAll" onclick="selectUnselect()"/></FONT> </TD>
    <TD align=middle bgColor="#73148C"><FONT face="Arial" color="#ffffff" size=3><B><bean:message key="app.messages.AWBNumber" /></B></FONT> </TD>
    <TD align=middle bgColor="#73148C"><FONT face="Arial" color="#ffffff" size=3><B><bean:message key="app.messages.Location" /></B></FONT> </TD>
    <TD align=middle bgColor="#73148C"><FONT face="Arial" color="#ffffff" size=3><B><bean:message key="app.messages.CustomerName" /></B></FONT> </TD>
    <TD align=middle bgColor="#73148C"><FONT face="Arial" color="#ffffff" size=3><B><bean:message key="app.messages.InvoiceNumber" /></B></FONT> </TD>
    <TD align=middle bgColor="#73148C"><FONT face="Arial" color="#ffffff" size=3><B><bean:message key="app.messages.InvoiceDate" /></B></FONT> </TD>
    <TD align=middle bgColor="#73148C"><FONT face="Arial" color="#ffffff" size=3><B><bean:message key="app.messages.InvoiceAmt" /></B></FONT> </TD>
    <TD align=middle bgColor="#73148C"><FONT face="Arial" color="#ffffff" size=3><B><bean:message key="app.messages.Status" /></B></FONT> </TD>
  </TR>
<nested:iterate property="awbs" id="rec" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.ReceivablesByAwbVO">
  <% String bgColor=((idx.intValue()%2)==0?"#c8ced7":"#ffffff"); %>  
  <TR>
    <nested:hidden property="recId"/>
    <nested:hidden property="recAwbNumber"/>
    <TD align=middle bgColor="<%=bgColor%>"><B><FONT  face="Verdana, Arial, Helvetica, sans-serif" size="1" color="#FFFFFF"><nested:checkbox property="selected"/></FONT></B></TD>
    <TD align=middle bgColor="<%=bgColor%>"><FONT face="Arial">

        <% //
           // Add/Reasign Receivables!
           //
        %>
        <%if(rec.getStatusId()==1 ){ /*|| rec.getStatusId()==3){ */ %>
            <bean:write name="rec" property="recAwbNumber"/>
        <%}else{ %>
            <A href="javascript:assignThis('<bean:write name="rec" property="recId"/>')"><bean:write name="rec" property="recAwbNumber"/></A>
        <%}%>
        </FONT>
    </TD>
    <TD align=middle bgColor="<%=bgColor%>"><FONT face="Arial">&nbsp;<bean:write name="rec" property="locCd"/></FONT></TD>
    <TD align=middle bgColor="<%=bgColor%>"><FONT face="Arial">&nbsp;<bean:write name="rec" property="recCustomerName"/></FONT></TD>
    <TD align=middle bgColor="<%=bgColor%>"><FONT face="Arial">&nbsp;<bean:write name="rec" property="recNumber"/></FONT></TD>
    <TD align=middle bgColor="<%=bgColor%>"><FONT face="Arial">&nbsp;<bean:write name="rec" property="recDate"/></FONT></TD>
    <TD align=right  bgColor="<%=bgColor%>"><FONT face="Arial">&nbsp;<bean:write name="rec" property="recAmount"/></FONT></TD>
    <TD align=center bgColor="<%=bgColor%>"><FONT face="Arial">&nbsp;<bean:write name="rec" property="statusDesc"/></FONT></TD>
  </TR>
</nested:iterate>
  <TR>
    <TD align="right" bgColor="#ffffff" colSpan=4><INPUT type="button" onclick="reassignPayments();" value="<bean:message key="app.messages.AssignReceivable" />"></TD>
    <TD align="left"  bgColor="#ffffff" colSpan=4><INPUT type="button" onclick="createNew();" value="<bean:message key="app.messages.CreateNewReceivable" />"></TD>
  </TR>
</TBODY>
</TABLE>
</nested:form>