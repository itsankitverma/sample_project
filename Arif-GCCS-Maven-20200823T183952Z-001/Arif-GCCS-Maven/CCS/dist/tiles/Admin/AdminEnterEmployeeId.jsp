<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<% String country = request.getParameter("countrySelected") ;%>

<script>
    function findUser(action)
    {	var d          = document;
        var country    = "<%=country%>";

       //Review that Fedex Id. entered be numeric
	   var val=String(Number(userId.value)); //To probe if value has just space

       if(isNaN(Number(userId.value)) || Number(userId.value)<0 || val==0)
       {  alert("<bean:message key="app_messages.js.MustEnterOnlyNumbers" />");
	   	  userId.value="";
          userId.focus();
          return;
	   }
       
       if(userId.value=="" || userId.value.length == 0)
       { alert("<bean:message key="app.messages.js.MustEnterFedexId" />");
  	     userId.value="";
         userId.focus();
         return;
	   }

        accion.value = action;
        var w=530;
		var h=500;
        if(w>screen.width)w=screen.width;
        if(h>screen.height)h=screen.height;
        var leftpos=(screen.width-w) / 2;
        var toppos=(screen.height-h) / 2;
        window.open("<html:rewrite page="/Admin/AdminUserList.do" />?accion=" + action + "&countrySelected=" + country + "&userId=" + userId.value, "addUser", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes");
  }
</script>

<html:errors />

<html:hidden property="accion" value=""/>
<html:hidden property="country" value="<%=country%>"/>

    <table border="0" cellspacing="1" cellpadding="0" bgcolor="#000000" width="100%" heigth="100%">
      <tr>
          <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                        <bean:message key="app.message.FedexId"/></font>
          </td>
          <td bgcolor="#FFFF9C">
            <p align="left">
                <html:text  maxlength="10" name="AdminUserListForm" property="userId" tabindex="1" onmousemove="javascript:userId.focus()"/>
            </p>        
          </td>
	  </tr>
	  <tr>
         <td colspan="4" bgcolor="#FFFF9C">
  			<p align="center">
        		<html:link href="javascript:findUser('addUser');"><img  align="center" border="0" src="<html:rewrite page="/images/Add" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
			</p>
	    </td>
	  </tr>
	</table>


 