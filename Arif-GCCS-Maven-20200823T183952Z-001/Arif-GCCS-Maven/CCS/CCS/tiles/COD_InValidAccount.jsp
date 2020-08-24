<%@page contentType="text/html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:errors />
<html>
<script>
function closeNew(){	   
	   var frm=document.forms['BillAccountForm'];
	
    	var frmParent=opener.document.forms[0];
    	
    	var index = <%=request.getParameter("index")%>;
    	formName = "<%=request.getParameter("FormName")%>";    	

    	switch(frmParent.name){
	    	  
	    	  case "RODCourierCashRecapForm" : 
	    	  //if (frmParent.elements['receivables['+index+'].billAccount'].value == ""){
	    	  frmParent.elements['receivables['+index+'].recStatusId'].value = frmParent.elements['receivables['+index+'].recStatusIdPrev'].value;
	    	  //}
	    	  break;
	    	  case "PRPCourierCashRecapForm": 
	    	  //if (frmParent.elements['awbs['+index+'].billAccount'].value == ""){
	    	  frmParent.elements['awbs['+index+'].statusId'].value = frmParent.elements['awbs['+index+'].statusIdPrev'].value; 
	    	  //}
	    	  break;
	    	  case "GroundCashRecapForm" : 
	    	  //if (frmParent.elements['trackNbrs['+index+'].billAccount'].value == ""){
	    	  frmParent.elements['trackNbrs['+index+'].statusId'].value = frmParent.elements['trackNbrs['+index+'].statusIdPrev'].value;
	    	  //}
	    	  break;
	    	  case "FTCCourierCashRecapForm" : 
		    	  //if (frmParent.elements['receivables['+index+'].billAccount'].value == ""){
		    	  frmParent.elements['receivables['+index+'].recStatusId'].value = frmParent.elements['receivables['+index+'].recStatusIdPrev'].value;
		    	  //}
		    	  break;
	    }    	
    	window.close();	

    	
}

</script>
<body>
<table>
<tr >
    <!-- td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/globalhome_background.jpg" />" width="1" height="1"></td -->
    <td bgcolor="#FFFF9C">
        <div align="center">
            <table border="0" width="98%" cellspacing="1" cellpadding="0">
                <tr>                    
					<td bgcolor="#FFFFFF" width="20%">
              			<b>
							<font face="Arial" color="red" >
                      			<bean:message key="app.InvalidAccount.msg"/>
                 		   </font>
              			</b>
            		</td>
                   
                </tr>
            </table>
        </div>
    </td>
    </td>
</tr>

<tr><td>
<!-- a href="javascript:close();"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></a -->
<a href="javascript:closeNew();"><img  align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></a>
</td></tr>
</body>
</html>
