<%@page contentType="text/html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:errors />
<html>
<script>
function closeNew(){	   
	   var frm=document.forms['validAccountForm'];	  
       var frmParent=opener.document.forms[0];    	   
       var index = <%=request.getParameter("index")%>;
         
    	
    	switch(frmParent.name){
    	case "PRPCourierCashRecapForm": frmParent.elements['awbs['+index+'].billAccount'].value = frm.elements['billToAcct'].value;
    
						//alert("AWBS Bill Account : "+frmParent.elements['awbs['+index+'].billAccount'].value);
						//alert("comments value == : "+frmParent.elements['awbs['+index+'].otherComment'].value);
						break;
    	case "RODCourierCashRecapForm"	  : frmParent.elements['receivables['+index+'].billAccount'].value = frm.elements['billToAcct'].value;
    
    					//alert("Receivables Bill Account : "+frmParent.elements['receivables['+index+'].billAccount'].value);
    					//alert("comments value == : "+frmParent.elements['receivables['+index+'].otherComment'].value);						
    					break;
    	case "GroundCashRecapForm" : frmParent.elements['trackNbrs['+index+'].billAccount'].value = frm.elements['billToAcct'].value;
    
						//alert("Ground Bill Account : "+frmParent.elements['trackNbrs['+index+'].billAccount'].value);
						//alert("comments value == : "+frmParent.elements['trackNbrs['+index+'].otherComment'].value);
						break;  		
    	case "FTCCourierCashRecapForm" : frmParent.elements['receivables['+index+'].billAccount'].value = frm.elements['billToAcct'].value;
        
		//alert("Receivables Bill Account : "+frmParent.elements['receivables['+index+'].billAccount'].value);
		//alert("comments value == : "+frmParent.elements['receivables['+index+'].otherComment'].value);						
		break;
						
    	}		
    	//if (window.opener && !window.opener.closed) {    	
    	//	  self.opener.updateField("",index,frm.elements['otherComment'].value);       
    	//}	    	
    	window.close();

    	
}


</script>
<body>  
<form name="validAccountForm" method="POST">
<tr>
<td bgcolor="#FFFF9C">
        <div align="center">
            <table border="0" width="98%" cellspacing="1" cellpadding="0">
                <tr>                    
					<td bgcolor="#FFFFFF" width="20%">
              			<b>
							<font face="Arial" color="#347C2C" >
                      			<bean:message key="app.validAccount.msg"/>
                 		   </font>
              			</b>
            		</td>
				</tr>
                <tr>
					<td>
						<html:hidden property="billToAcct" value ='<%=(String)request.getAttribute("billToAccount")%>'/>
						<html:hidden property="index" value ='<%=(String)request.getAttribute("ind")%>'/>

					</td>
                   
                </tr>
            </table>
        </div>
    </td>


  <td>
	<!--  href="javascript:close();"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></a -->
<a href="javascript:closeNew();"><img  align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></a>
  </td>

</tr>
</body>
</form>
</html>
