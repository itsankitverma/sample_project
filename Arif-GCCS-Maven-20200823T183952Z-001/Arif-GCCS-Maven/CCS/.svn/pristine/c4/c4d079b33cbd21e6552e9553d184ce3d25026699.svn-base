<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.*,
                java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<bean:define id="userProfile" name="userProfile" scope="session" type="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile" />
<%
    Collection defaultPages=new ArrayList();
    defaultPages.add(new Entry("ROD","ROD"));
    defaultPages.add(new Entry("PREPAID","PREPAID"));
    defaultPages.add(new Entry("POA","POA"));
    defaultPages.add(new Entry("COD","COD"));
    pageContext.setAttribute("defaultPages",defaultPages);
%>
<script>
		function closeWindow(action)
		{   var f = document.forms['AdminUserListForm'];
            	  /*opener.document.location.href ="<html:rewrite page="/Admin/AdminUserList.do" />?accion=" + action + "&countrySelected=" + f.country.value;*/
            	    window.close();    
       }
		
		function validateUser()
		{  var message="";
			var f = document.forms['AdminUserListForm'];
			
			return message;
		}
		
		function saveUser(action)
		{   var f 		 = document.forms['AdminUserListForm'];
		    f.accion.value	 = action;
		    
		    if(action=="insertUser")
			   prepareLocations(f);
			   
		    f.submit();  
		}
		
		function prepareLocations(f)
		{  var sel=f.locationAlreadySelected;
		   
		   for(i=0;i<sel.length;i++) 
		   {   if(Number(sel.options[i].value)!=0)
			   	  sel.options[i].selected=true;
		   }

		   var selByCountries=f.locationDefault;
		   for(i=0;i<selByCountries.length;i++)
		   {   if(Number(selByCountries.options[i].value)!=0)
		   	   	  selByCountries.options[i].selected=true;
		   }	   	  		   	   
        }
        
		function checkGroup(array, object)
		{	var i = 0;
			var exist = false;
			
			if(array.length==0)
			   return i;
			   
			while(i<array.length)
			{	
				if(array[i].value==object)
				{  exist = true;	
				   break;
				}
				i+=1;
			}
			if(exist==false)
			   i=0;
			else if(exist == true && i==0)
					return -1; 
			   
			return i;
		}
		
		function addOtherLocations()
		{	var f 		 = document.forms['AdminUserListForm'];
			var locs 	 = f.otherLocations.value;
			var location = locs.split(",");
			var i = 0;
			
			//Check all locations must have 4 to 6 letter.
			var others = "";
			for(x=0;x<location.length;x++)
			{	match  = location[x].match(/([a-zA-Z]{4})/);

				if(match==null || location[x].length>6)
				{	others= others + " " + location[x];}
			}
			
			if(others != "")
			{  alert("<bean:message key='app.messages.CorrectLocation'/>");
			   f.otherLocations.focus();
			   return;
			}
			
			if(Number(locs)==0)
			{  f.otherLocations.value="";
			   f.otherLocations.focus();
			   return;
			}
			
			while(i<location.length)
			{
				var j = checkGroup(f.locationAlreadySelected, location[i]);
				if(j==0)
				{ f.locationAlreadySelected.options[f.locationAlreadySelected.length]=new Option(location[i],location[i]);}
				i+=1;
			}
		}
			
	function move(op){
		var frm=document.forms['AdminUserListForm'];
		var src;
		var trg;
                var selectedCount=Number(0);

                var sortingLimit=50;

		if(op=="add"){
			src=frm.locationDefault;
			trg=frm.locationAlreadySelected;
		}else{
			src=frm.locationAlreadySelected;
			trg=frm.locationDefault;
		}



		for(i=src.length-1;i>=0;i--){
			if(src.options[i].selected){
                                selectedCount++;
                                
                                if(selectedCount>sortingLimit || trg.length>sortingLimit){
                                       trg.options[trg.length]=new Option(src.options[i].text,src.options[i].value);
                                }else{
                                    for(j=trg.length;j>=0;j--){ //to keep the options sorted if this does not take so much time.

                                            if(j==0 || trg.options[j-1].text<=src.options[i].text){
													if(checkGroup(trg,src.options[i].value)==0)
	                                                   trg.options[j]=new Option(src.options[i].text,src.options[i].value);
                                                break;
                                            }else{
                                                 	if(checkGroup(trg,src.options[i].value)==0)
	                                                   trg.options[j]=new Option(trg.options[j-1].text,trg.options[j-1].value);;
                                            }
                                    }
                                }
				src.options[i]=null;
			}
		}

                if(selectedCount>0) notSavedChanges=true;
	}

	function moveAll(op){
            
            
		var frm=document.forms['AdminUserListForm'];
		var sel;
                var msg;

		if(op=="add"){
			sel=frm.locationDefault;
                        msg="<bean:message key="app.messages.js.AddAllLocations" />";
		}else{
			sel=frm.locationAlreadySelected;
                        msg="<bean:message key="app.messages.js.RemoveAllLocations" />";
		}
                
                if(confirm(msg)){
                    for(i=0;i<sel.length;i++) sel.options[i].selected=true;
                    move(op);
                }    
	}
		
		
</script>

<% String country = (String)request.getAttribute("countrySelected") ;%>

<html:errors />
<br>
<br>
<div align="center">
<html:form action="/Admin/AdminHandler.do" name="AdminUserListForm" type="com.fedex.lacitd.cashcontrol.prestier.struts.form.AdminUserListForm" focus="userId">
<html:hidden property="accion" value=""/>
<logic:empty name="AdminUserListForm" property="country">
    <html:hidden property="country" value="<%=country%>"/>
</logic:empty>
<logic:notEmpty name="AdminUserListForm" property="country">
    <html:hidden name="AdminUserListForm" property="country"/>
    <bean:define id="con" name="AdminUserListForm" property="country" type="java.lang.String"/>
    <%country=con;%>
</logic:notEmpty>
<html:hidden name="AdminUserListForm" property="reviewLocationRole"/>
<html:hidden name="AdminUserListForm" property="reviewData"/>
    <table border="0" cellspacing="1" cellpadding="0" bgcolor="#000000">
        <tr>
            <td bgcolor="#73148C" colspan="4"><p align="center"><font color="#FFFFFF" face="Arial">
			  <b><bean:message key="app.message.AdminUser" arg0="<%=country%>" /></b></font></td>
		</tr>
		<tr>
			<td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
			    <bean:message key="app.message.FedexId"/></font>
			</td>
			
			<td bgcolor="#FFFF9C" colspan="3">
			    <p align="left">
				<html:text  maxlength="10" name="AdminUserListForm" property="userId" tabindex="1" readonly="true"/>
    			<html:hidden name="AdminUserListForm" property="extlCustFlg" value="0"/>
	       	</td>
		</tr>
		<tr>
			<td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000"><bean:message key="app.userName"/></font></td>
            <logic:equal  name="AdminUserListForm" property="reviewData" value="true">
                <td bgcolor="#FFFF9C" colspan="3"><html:text  maxlength="35" name="AdminUserListForm"  property="userName" tabindex="2" size="35"/></td>
            </logic:equal>
            <logic:equal  name="AdminUserListForm" property="reviewData" value="false">
                <td bgcolor="#FFFF9C" colspan="3"><html:text  maxlength="35" name="AdminUserListForm"  property="userName" tabindex="2" size="35" readonly="true"/></td>
            </logic:equal>
		</tr>
        <logic:equal  name="AdminUserListForm" property="reviewData" value="true">
            <logic:equal  name="AdminUserListForm" property="disabledFlg" value="true">
                <tr>
			        <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
			            <bean:message key="app.DisabledStatus"/></font>
			        </td>
                    <td bgcolor="#FFFF9C" colspan="2"><html:checkbox name="AdminUserListForm" property="disabledFlg"/>
                        <font size="2" face="Arial" color="#000000">
                        <bean:message key="app.DisabledStatusExplanation"/></font>
                    </td>
                </tr>
            </logic:equal>
        </logic:equal>
		<tr>
		    <td height="20" align="left" bgcolor="#C0C0C0"><font size="2" face="Arial" color="#000000">
				<bean:message key="app.Email"/>
			</font>
            </td>
            <logic:equal  name="AdminUserListForm" property="reviewData" value="true">
                          
                <td bgcolor="#FFFF9C" colspan="3"> <html:text  maxlength="35" name="AdminUserListForm" property="email" tabindex="5" size="30"/>
	                <font size="2" face="Arial" color="#000000">
                        <html:img page="/images/Email.gif" alt="Email" align="middle"/> <html:checkbox property="sendEmail"/><bean:message key="app.SendEmail"/>
		            </font>
                </td>
            </logic:equal>
            <logic:equal  name="AdminUserListForm" property="reviewData" value="false">
                <td bgcolor="#FFFF9C" colspan="3"><html:text  maxlength="35" name="AdminUserListForm" property="email" tabindex="5" size="30" readonly="true"/></td>
            </logic:equal>
        </tr>
        <logic:equal  name="AdminUserListForm" property="reviewLocationRole" value="true">
            <tr>
		     <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000"> 
        	 <bean:message key="app.newLocation" /></font> </td>
             <td bgcolor="#FFFF9C" colspan="3">
             	<table width="100%">
             		<tr>
             			<td width="40%" align="center">
			               <html:select property="locationDefault" multiple="true" size="12">
            			 	  <html:options collection="locations" name="AdminUserListForm" property="locationCd" labelName="locationCd" />
            			   </html:select>
		           	    </td>
		           	    <td width="20%" align="center">
							<p align="center"><input type="button"  onclick="moveAll('add');" value="&gt;&gt;" name="B3"></p>
						    <p align="center"><input type="button"  onclick="move('add');" value=" &gt; " name="B2"></p>
					        <p align="center"><input type="button"  onclick="move('remove');" value=" &lt; " name="B1"></p>
					        <p align="center"><input type="button"  onclick="moveAll('remove');" value="&lt;&lt;" name="B4"></td>
		           	    <td width="40%" align="center">
		           	       <html:select property="locationAlreadySelected" multiple="true" size="12">
            			 	  <html:options collection="locationSelected" name="AdminUserListForm" property="locationCd" labelName="locationCd" />
            			   </html:select>
		           	    </td>
	             	</tr>
             	</table>
             </td>
          </tr>
<%if(userProfile.isAdmin() || userProfile.isFinController() || userProfile.isCountryAdmin()){%>
          <tr>
                <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                        <bean:message key="app.quicklyLocations"/></font></td>
                <td bgcolor="#FFFF9C" colspan="3">
                        <html:text property="otherLocations" name="AdminUserListForm" maxlength="50" onblur="javascript:this.value=this.value.toUpperCase();"/>
                        <input type="button"  onclick="javascript:addOtherLocations();" value="+ Locs" name="addLocations">
                </td>
          </tr>
<%}%>
          </logic:equal>
          <logic:equal  name="AdminUserListForm" property="reviewLocationRole" value="true">
          <tr>
                <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                        <bean:message key="app.newRole"/></font></td>
                <td bgcolor="#FFFF9C" colspan="3">
                        <html:select property="roleDefault">
                                <option value="" >Select</option> 
                                <html:options collection="roles" name="AdminUserListForm" property="roleId"  labelProperty="role" />
                        </html:select>
                </td>
          </tr>
          </logic:equal>
		  <tr>
			<td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000"><bean:message key="app.messages.DefaultPage"/></font></td>
                        <td bgcolor="#FFFF9C" colspan="3">
                                <html:select name="AdminUserListForm"  property="pageDetailDefault" >
                                        <html:options collection="defaultPages" property="key" labelProperty="value" />
                                </html:select>
                        </td>
		  </tr>
		  <tr>
			  <td colspan="4" bgcolor="#FFFF9C">
			  	<p align="center">
				  <logic:equal  name="AdminUserListForm" property="reviewLocationRole" value="true">
					<html:link href="javascript:saveUser('insertUser');"><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>						
				  </logic:equal>
            	  <logic:equal  name="AdminUserListForm" property="reviewLocationRole" value="false">
                	<logic:equal  name="AdminUserListForm" property="reviewData" value="true">
	                   <html:link href="javascript:saveUser('updateUser');"><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
    	            </logic:equal>
        	      </logic:equal>
            	  <html:link href="javascript:closeWindow('seeProfile');"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
                  </p>
			  </td>
		  </tr>
		  </table>
  </html:form>
</div> 
 

