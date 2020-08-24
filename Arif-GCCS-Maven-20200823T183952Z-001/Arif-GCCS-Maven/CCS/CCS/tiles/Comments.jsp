<%@page import="com.fedex.lacitd.cashcontrol.datatier.valueobject.ChkinAgtCommentVO,
                java.util.ArrayList"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile"%>
<%@page import="com.fedex.lacitd.cashcontrol.biztier.common.Constants"%>

<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%
  ArrayList comments = (ArrayList)request.getSession().getAttribute("comments");
%>

<script>

	function showCommentsWindow(indexItem,object,form,field,other,billToAcct)
    {
		
		var commentStr, otherComm, billAcct;
		var commentArray;
		var f=document.forms[form];

		
		//billAcct		= billToAcct;
		if(indexItem.length==0)
		{   commentStr		= f.elements[object+'.'+field].value;
			//billAcct		= f.elements[object+'.'+billToAcct].value;
		}else{
			commentStr		= f.elements[object+'['+indexItem+'].'+field].value;
			//billAcct		= f.elements[object+'['+indexItem+'].'+billToAcct].value;
			}
		
		commentArray	= commentStr.split(';');

		pop = window.open("","_blank","toolbar=no,menubar=no,location=no,status=no,width=380,height=420,scrollbars=yes")
	  	document.onmousedown=pop.focus;
        document.onkeydown	=pop.focus;

		pop.document.write('<html>')
		pop.document.write('<head>')
		pop.document.write('</head>')

	 /* Write a javascript function, SubmitCode, to put the selected comment code back on the parent windows */
	 	pop.document.write('<script language=JavaScript>')
		pop.document.write('function SubmitCodes(indexItem){ ')
		pop.document.write('	var selectedComm="", otherComment="";')
		pop.document.write('	var i=0;')
		pop.document.write('	var box,comm;')
		pop.document.write('	var f=document.forms["commentFORM"];')
		pop.document.write('	var commentArray = f.elements["comment"];')
        pop.document.write('	var nComment=0;')

        pop.document.write('for (i=0;i<commentArray.length;i++){')
		pop.document.write('	box = commentArray[i];')
		pop.document.write('	if (box.checked == true)')
  	    pop.document.write('	{ comm=f.elements["C"+i].value;')
		pop.document.write('	  selectedComm=selectedComm.concat(comm,";");')

        pop.document.write('	  nComment ++;')
        pop.document.write('	  if(nComment > 5) { ')
        pop.document.write('	     alert("<bean:message key="app.messages.js.TooManyComments" />"); ')
        pop.document.write('	     return false;')
        pop.document.write('	  }')
        pop.document.write('	}')

		pop.document.write('}')

		pop.document.write('if(f.elements["other"].checked==true)')
		pop.document.write('  {otherComment = f.elements["otherText"].value;}')

		pop.document.write('if (window.opener && !window.opener.closed) { ')
		pop.document.write('	self.opener.updateField(selectedComm,indexItem,otherComment);')
		pop.document.write('	window.close(); }')
		pop.document.write('}')
		pop.document.write('<\/script>')

		pop.document.write('<body>')
		pop.document.write('<form name="commentFORM" method="post" action="">');
		pop.document.write('<table align="center" bgcolor="#808080">')

		<%	int size=comments.size();
			ChkinAgtCommentVO commentDB = new ChkinAgtCommentVO();

			 // this is for deferred ROD excluding certain comment code for non deferred rod location
			  EmployeeProfile ep = (EmployeeProfile)request.getSession().getAttribute("userProfile");   
			  if(!ep.getLocationCd().equals("KULHQ")&&!ep.getLocationCd().equals("KULAX")){
					Iterator commentIterator = comments.iterator();
					while (commentIterator.hasNext()) {
					   commentDB = (ChkinAgtCommentVO)commentIterator.next(); // must be called before you can call i.remove()
					   if(commentDB.getCommentCd().equals("DRVL")||commentDB.getCommentCd().equals("DPWL")||commentDB.getCommentCd().equals("RVCF")||commentDB.getCommentCd().equals("DDSP")||commentDB.getCommentCd().equals("HDEX")){						  
					   	commentIterator.remove();
					   }//end if
					}//end if
				}//end if emp loc cd = deferred rod loc cd

				size=comments.size(); //re-checking the comment arraylist after removing some deferred rod comment
		%>
			pop.document.write('<tr><td bgColor="#73148C" colspan="4"><font face="Arial" color="#FFFFFF" size="2"><b> Select Comments </b></font>')	
			pop.document.write('</td></tr><tr>')	
		<%	
			for(int i=0;i<size;i++){ %>
				pop.document.write('<td align="left" bgcolor="#FFFF9C">')
				<% commentDB = (ChkinAgtCommentVO)comments.get(i);%>

				if(findComment(commentArray, '<%=commentDB.getCommentCd()%>')){
				   pop.document.write('<input type="hidden" name="C<%=i%>" value="<%=commentDB.getCommentCd()%>"/>')
	 			   pop.document.write('<input type=checkbox name="comment" value="on" CHECKED />')
  				   pop.document.write('<a href="#"><IMG border="0" name="img" src="<%=request.getContextPath()%>/images/transparent.gif" alt="<%=commentDB.getCommentDesc()%>"></a>')
				}else{
	 				  pop.document.write('<input type="hidden" name="C<%=i%>" value="<%=commentDB.getCommentCd()%>"/>')
					  pop.document.write('<input type=checkbox name="comment" value="on"/>')
	  				  pop.document.write('<a href="#"><IMG border="0" name="img" src="<%=request.getContextPath()%>/images/transparent.gif" alt="<%=commentDB.getCommentDesc()%>"></a>')
					 }
				pop.document.write('&nbsp;<%=commentDB.getCommentCd()%>&nbsp;</td>')
				<%	if(((i+1)%4)==0){ %>
				   	   pop.document.write('</tr><tr>')
				<% 	}
			}
		%>
		pop.document.write('</td><tr><td colspan="4" align="left">')
		
		pop.document.write('<font face="Arial" color="#FFFFFF"><b>&nbsp;Bill To Account &nbsp;</b></font>')
		pop.document.write('<input type="text" name="billAcct" disabled="true" size="9" />')
		pop.document.write('</tr><tr><td  colspan="4" align="left">')
		pop.document.write('<input type="checkbox" name="other" value="on" onClick="if(other.checked==false){otherText.disabled=true;done.focus();}else{otherText.disabled=false; otherText.focus();}"/>')
		pop.document.write('<font face="Arial" color="#FFFFFF"><b>&nbsp;OTHER &nbsp;</b></font>')
		pop.document.write('<input type="text" name="otherText" disabled="true" size="25" maxlength="60"/>')
		
		/* Put other comment if it is applicable into the child window */
		if(indexItem.length==0)
		{  otherComm = f.elements[object+'.'+other].value;
		}else{
			otherComm = f.elements[object+'['+indexItem+'].'+other].value;}
		
		if(otherComm.length>0){
		   pop.document.forms["commentFORM"].other.checked	 	= true;
		   pop.document.forms["commentFORM"].otherText.value	= otherComm;
		   pop.document.forms["commentFORM"].otherText.disabled = false;
		}

		if (billToAcct.length>0){
			pop.document.forms["commentFORM"].billAcct.value	= billToAcct;
		}
		pop.document.write('</tr><tr><td colspan="4" align="center" bgcolor="#FFFF9C">')
		pop.document.write('<input type="button" value="Done" name="done" onclick = "javascript:SubmitCodes('+indexItem+');" />')
		pop.document.write('</td></tr></table>')
		pop.document.write('</form></body></html>')
    }
	
	function findComment(commentArray, comment)
	{  var exist=false;
	   var commentCurier;	
	   
	   for(i=0;i<commentArray.length;i++){
		   commentCurier=commentArray[i];	   
		   if(commentCurier==comment) 
		   {  exist=true;
		   	  break;}
	   }	
	 	return exist;
	}
</script>