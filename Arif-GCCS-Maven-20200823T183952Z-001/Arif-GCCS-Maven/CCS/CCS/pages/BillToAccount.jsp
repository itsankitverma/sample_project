<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html>
    <head>
    	<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
    	<META HTTP-EQUIV="Expires" CONTENT="-1">
    	<title><bean:message key="app.messages.BillAccountReport" /></title>
    </head>	
    
	
    <script>
    	function saveBillAccountNew(){        	
    		var frm=document.forms['BillAccountForm'];
        	var errors=validate();

        	if(errors==""){
            	var frmParent=opener.document.forms[0];
            	var index = <%=request.getParameter("index")%>;            
            	         
            	if (frm.elements['billAccount'].value != '999999999'){            		
            		frm.submit();             		
            	}
            	else{
            		//alert("AccNbr is 999999999. No validation required!");	
            		//alert(frmParent.name);
            		 switch(frmParent.name){       	    	  
            		 case "RODCourierCashRecapForm":                		
                		frmParent.elements['receivables['+index+'].billAccount'].value = frm.elements['billAccount'].value;	    	 
	       	    	  break;
	       	    	  case "PRPCourierCashRecapForm": 
	       	    		frmParent.elements['awbs['+index+'].billAccount'].value = frm.elements['billAccount'].value;	       	    			 	       	    	  
	       	    	  break;
	       	    	  case "GroundCashRecapForm" : 
	       	    		frmParent.elements['trackNbrs['+index+'].billAccount'].value = frm.elements['billAccount'].value;	       	    	  	       	    	  
	       	    	  break;
	       	    	  case "FTCCourierCashRecapForm" : 
		       	    		frmParent.elements['receivables['+index+'].billAccount'].value = frm.elements['billAccount'].value;	       	    	  	       	    	  
		       	   		break;	       	    	  
	       	    	  }
                	window.close();
            	} 
            	                                     	          
	        
    	    }else{
        	  alert("Error!"+errors);
        	  //alert(errors);
        	}
    	}

    	function validate(){
        	var frm = document.forms['BillAccountForm'];
		var msg="";

        	if(frm.billAccount.value == "" || frm.billAccount.value.length != 9 || isNaN(frm.billAccount.value) ){
					msg = "<bean:message key="app.messages.MustEnterAValidAccountNbr" />";
            	}

        	return msg;	
    	}



    	function closeNew(){
		   
		   var frm=document.forms['BillAccountForm'];
		
	    	var frmParent=opener.document.forms[0];
	    	
	    	var index = <%=request.getParameter("index")%>;
	    	formName = "<%=request.getParameter("FormName")%>";	    	
	
	    	 switch(frmParent.name){
	    	  
	    	  case "RODCourierCashRecapForm" : 
	    	  if (frmParent.elements['receivables['+index+'].billAccount'].value == ""){
	    	  frmParent.elements['receivables['+index+'].recStatusId'].value = frmParent.elements['receivables['+index+'].recStatusIdPrev'].value;
	    	  }
	    	  break;
	    	  case "PRPCourierCashRecapForm": 
	    	  if (frmParent.elements['awbs['+index+'].billAccount'].value == ""){
	    	  frmParent.elements['awbs['+index+'].statusId'].value = frmParent.elements['awbs['+index+'].statusIdPrev'].value; 
	    	  }
	    	  break;
	    	  case "GroundCashRecapForm" : 
	    	  if (frmParent.elements['trackNbrs['+index+'].billAccount'].value == ""){
	    	  frmParent.elements['trackNbrs['+index+'].statusId'].value = frmParent.elements['trackNbrs['+index+'].statusIdPrev'].value;
	    	  }
	    	  break;
	    	  case "FTCCourierCashRecapForm" : 
		    	  if (frmParent.elements['receivables['+index+'].billAccount'].value == ""){
		    	  frmParent.elements['receivables['+index+'].recStatusId'].value = frmParent.elements['receivables['+index+'].recStatusIdPrev'].value;
		    	  }
		    	  break;
	    	  	    	  
	    	  }
	    	
	    	window.close();	
    	}

    	

    </script>
    
    <body>
        <div align="center" style="width: 250; height: 170">

		<FORM  name="BillAccountForm" ACTION="<html:rewrite page="/ROD/BillToAccount.do" />" METHOD="POST" TYPE="com.fedex.lacitd.cashcontrol.prestier.struts.form.BillToAccountForm">
     
                <table border="0" cellspacing="1" cellpadding="0" bgcolor="#000000" width="296">
                      <tr>
                        <td width="250" height="15" align="right" bgcolor="#C0C0C0">
							<b><font face="Arial" color="#800080"><bean:message key="app.BillToAccount.msg"/>&nbsp;&nbsp;&nbsp;&nbsp;</font></b>
                        </td>
 					  </tr>
						<tr>
	                        <td bgcolor="#FFFF9C" width="184" height="22">
	                          <p align="center">
	                              <input type="text" name="billAccount"  maxlength="9" tabindex="1" size="15" value="">
								  <input type="hidden" name="index" value='<%=(String)request.getParameter("index")%>'>		
	                          </p>
	                        </td>
					   </tr>
                     

                      <tr>
                         <td colspan="2" bgcolor="#FFFF9C" height="50">
						 <!-- input type="submit" value="Submit" / -->
                         <a href="javascript:saveBillAccountNew();"><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></a>
                         <a href="javascript:closeNew();"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></a>  
                         </td>
                      </tr>
                </table>
        </FORM>
        </div>
    </body>
</html>