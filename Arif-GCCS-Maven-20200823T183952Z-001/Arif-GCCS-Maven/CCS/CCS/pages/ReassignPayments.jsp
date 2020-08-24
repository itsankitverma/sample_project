<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>

<head>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
<title><bean:message key="app.messages.ReassignPayments" /></title></head>
<script>
	function reassignPayments(){
		var frm=document.forms['reassignPayments'];
        var isRecPage = frm.rec.value;
        var errors=validate();

		if(errors==""){
            var frmParent=opener.document.forms[0];
            if(isRecPage == "true"){
                frmParent.elements['locationCd'].value=frm.newLocation.options[frm.newLocation.selectedIndex].value;
                frmParent.elements['recEmployeeId'].value=frm.newEmployee.value;
                frmParent.elements['action'].value="ReassignReceivables";
            } else {
                frmParent.elements['newReassLocationCd'].value=frm.newLocation.options[frm.newLocation.selectedIndex].value;
                if(frm.summary.value=="true"){
                    frmParent.elements['reassROD'].value=frm.reassROD.checked?1:0;
                    frmParent.elements['reassPRP'].value=frm.reassPRP.checked?1:0;
                    frmParent.elements['reassPOA'].value=frm.reassPOA.checked?1:0;
                    frmParent.elements['reassGRN'].value=frm.reassGRN.checked?1:0;
                }

                if(frm.multipleSelected.value!="true"){
                    frmParent.elements['newEmployeeId'].value=frm.newEmployee.value;
                }
                frmParent.elements['action'].value="ReassignPayments";
            }
            if(frmParent.elements['reload']) frmParent.elements['reload'].value='YES'
            //alert("Llamo a este action: " + frmParent.elements['action'].value);
            frmParent.submit();
            window.close();

		}else{
			alert(errors);
		}

	}
	function validate(){
		var frm=document.forms['reassignPayments'];
		var mesg="";

        if(frm.newEmployee.value.length==0){
			mesg="<bean:message key="app.messages.CourierRequired" />\n";
            frm.newEmployee.focus();
        }else if(isNaN(frm.newEmployee.value)){
                mesg="<bean:message key="app_messages.js.MustEnterOnlyNumbers" />\n";
                frm.newEmployee.value="";
                frm.newEmployee.focus();
        }

        if(frm.summary.value=="true" && !frm.reassROD.checked && !frm.reassPRP.checked && !frm.reassPOA.checked && !frm.reassGRN.checked){
			mesg="<bean:message key="app.messages.MustSelectSource" />\n";
		}

		if(!frm.summary.multipleSelected=="true" && (frm.newEmployee.value=="" || frm.newEmployee.value.legth>10)){
			mesg="<bean:message key="app.messages.CourierRequired" />\n";
		}

        if(frm.rec.value == "true" && (frm.newEmployee.value=="" || frm.newEmployee.value.legth>10)){
			mesg="<bean:message key="app.messages.CourierRequired" />\n";
		}

        return mesg;
	}
</script>
<body>
<div align="center" style="width: 250; height: 170">
<form name="reassignPayments">
        <input type="hidden" name="multipleSelected" value="<%=request.getParameter("multipleSelected")%>">
		<input type="hidden" name="summary" value="<%=request.getParameter("summary")%>">
        <input type="hidden" name="rec"     value="<%=request.getParameter("rec")%>">
        <table border="0" cellspacing="1" cellpadding="0" bgcolor="#000000" width="360" >

<%if(!"true".equals(request.getParameter("multipleSelected"))){%>		
		    <tr>
			  <td bgcolor="#C0C0C0" align="right" width="200" height="22">
              <font face="Arial" size="2">New Employee&nbsp;&nbsp;&nbsp;&nbsp;
              </font>
			  </td>
			
			  <td bgcolor="#FFFF9C" width="252" height="22">
			  <p align="left">
                  <input type="text" name="newEmployee" maxlength="10" tabindex="1" value="<%=request.getParameter("oldEmployee").length()==0?"000000":request.getParameter("oldEmployee")%>" size="15"></td>
		    </tr>
<%}%>		  
		  <tr>
			<td bgcolor="#C0C0C0" align="right" height="22">
            <font face="Arial" size="2">New Location&nbsp;&nbsp;&nbsp;&nbsp;
            </font></td>
                        
                            <td bgcolor="#FFFF9C" width="252" height="22">
                                <select name="newLocation">
                                			<option value="">Select</option>
                                		<bean:define id="locations" scope="session" name="userProfile" property="locations" />	
                                		<bean:define id="loggedLoc" scope="session" name="userProfile" property="locationCd" type="java.lang.String" />	                                		
                                		<logic:iterate name="locations" id="loc" type="com.fedex.lacitd.cashcontrol.datatier.valueobject.LocationVO">                                			
                                			<option <%=(loggedLoc.equals(loc.getLocationCd()))?"selected":""%> value="<bean:write name="loc" property="locationCd" />"><bean:write name="loc" property="locationCd" /></option>
                                		</logic:iterate>
									</select>
							</td>
                        
                        
		  </tr>

<%if("true".equals(request.getParameter("summary"))){%>
		  <tr>
			<td height="20" align="right" nowrap bgcolor="#C0C0C0" >
            <font face="Arial" size="2">Payment Sources</font><font size="2" face="Arial" color="#000000">&nbsp;&nbsp;&nbsp;&nbsp;
			</font></td>
      <td bgcolor="#FFFF9C" width="252" height="20">
	    <font size="2" face="Arial" color="#000000">
      <input type="checkbox" name="reassROD" value="on">ROD
      <input type="checkbox" name="reassPRP" value="on">Prepaid
      <br>
      <input type="checkbox" name="reassPOA" value="on">POA
      <input type="checkbox" name="reassGRN" value="on">Ground
		</font>
      </td>
<%}%>
                        
                        
		  </tr>
  		  
		  
		  <tr>
			  <td colspan="2" bgcolor="#FFFF9C" width="280" height="50">
			  <p align="center">
			  
                          
                                
                                    <a href="javascript:reassignPayments();"><img  align="center" border="0" src="<html:rewrite page="/images/ReassignPayments" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></a>
                                
                          
                          <a href="javascript:close();"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></a>
                          </p>
			  </td>
		  </tr>
		  </table>
  </form>
</div> 
 


        </td>
    </tr>
</table>
</body>
<head>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</head>
</html>