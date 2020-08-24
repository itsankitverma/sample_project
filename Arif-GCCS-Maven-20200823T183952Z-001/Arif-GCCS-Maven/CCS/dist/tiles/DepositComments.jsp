<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fedex.lacitd.cashcontrol.prestier.helper.*"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:errors />

<script>
    function saveComment(){
        if(document.forms['DepSlipAddCommentForm'].newComment.value.length==0){
            alert('<bean:message key="app.messages.js.MustEnterAComment" />');
        }else{
            opener.saveDeposits();
            document.forms['DepSlipAddCommentForm'].action.value='addComment';
            document.forms['DepSlipAddCommentForm'].submit();
        }    
    }
</script>
<nested:form action="/DepSlipAddComment" >
    <nested:hidden property="currentDepositSlipId" />
    <nested:hidden property="oldComment" />
<input type="hidden" name="action">
<table border="0" width="100%" cellspacing="0" cellpadding="0" bgcolor="#808080">
    <tr>
	   <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
		<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" height="1"></td>
		<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
    </tr>
    <tr>
	   <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="3"></td>
		<td  width="1" bgcolor="#FFFF9C"><img src="<html:rewrite page="/images/spacer.gif" />" height="3"></td>
		<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="3"></td>
    </tr>

    <tr>
      <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="3"></td>
      <td bgcolor="#FFFF9C">
		 <div align="center">
                    <a name="saveLink" href="javascript:saveComment()"><img name="saveImg" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" width="114" height="38"></a>
                    <a name="saveLink" href="javascript:window.close();"><img name="saveImg" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" width="114" height="38"></a>
                 </div>
	<!--  ******************************************** -->     
	  <table border="0" bgcolor="#808080" cellspacing="1" cellpadding="0" width="99%" bordercolor="#000000" align="center">
            <tr> 
	    	<td align="center" bgcolor="#73148C" nowrap><b><font color="#FFFFFF" face="Arial" size="3"></b>
                        <bean:message key="app.messages.Comments" />
                </td>
	    </tr>
	    <tr> 
	    	<td align="center" bgcolor="#73148C" ><b><font color="#FFFFFF" face="Arial" size="3"></b>
                        <nested:textarea cols="50" rows="10" property="newComment" />
                </td>
	    </tr>
            <nested:notEmpty property="oldComment">
	    <tr> 
	    	<td  bgcolor="#FFFFFF" align="left"><font color="#000000" face="Arial" size="3">
                        <ul>
                        <nested:write property="oldComment" filter="true" />                        
                        </ul>
                </td>
	    </tr>
            </nested:notEmpty>

	  </table>      
	 	<!--  ****************** END *********************** -->     
      </td>
      <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="3"></td>
    </tr>
    <tr>
	   <td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
		<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" height="1"></td>
		<td  width="1" bgcolor="#808080"><img src="<html:rewrite page="/images/spacer.gif" />" width="1" height="1"></td>
    </tr>
  </table>
</nested:form>

