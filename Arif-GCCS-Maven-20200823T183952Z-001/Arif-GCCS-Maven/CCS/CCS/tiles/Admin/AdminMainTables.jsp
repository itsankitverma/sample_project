<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html-el.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>

	<script language="JavaScript">
        var conditionsRaw = new Array();
        var conditions = new Array();
        function sendToServer(action,pk) {

           var f = document.forms['AdminMainTablesForm'];
           var condition="";
           f.action.value=action;
           if(action=='data') {

               for (var i = 0; i < f.conditions.options.length; i++)
                  condition = condition + " " + f.conditions.options[i].value;
               
              f.sqlCondition.value=condition;
              if(selectCondition()==0)
              {   alert("You need add filters before execute a Query.");
                  return;
              }
           }
           else if(action=='update') {
                    var table = f.tableSelected.options[f.tableSelected.selectedIndex].value;
                    var w=630;
			        var h=600;
                    if(w>screen.width)w=screen.width;
                    if(h>screen.height)h=screen.height;
                    var leftpos=(screen.width-w) / 2;
                    var toppos=(screen.height-h) / 2;
                    window.open("<html:rewrite page="/Admin/AdminMainTables.do" />?action=" + action + "&pk=" + pk + "&tableName="+table,"Update", "scrollbars=yes,innerHeight="+h+",innerWidth="+w+",width="+w+", height="+h+",left="+leftpos+",top="+toppos+",toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=yes");
                    return;
           }
           f.submit();
        }                                                   

        function selectCondition() {
           var f = document.forms['AdminMainTablesForm'];
           for (var i = 0; i < f.conditions.options.length; i++)
				f.conditions.options[i].selected=true;

           return f.conditions.options.length;
        }

        function ValidateInput( inputValue)
        {
            var f = document.AdminMainTablesForm;
            var pattern = f.inputPatterns.value;
			var regexp = new RegExp(pattern);

			//var regexp1 = new RegExp(pattern, "g");
            
            //alert(regexp1.test(inputValue));
            //var patt1=new RegExp("/(?:)/");
            //alert('here we are :'+patt1.test(inputValue));
			//if(patt1.test(inputValue) == true)
            if(inputValue.match(regexp) != null)
            {
               var msg = "<bean:message key="wl.error.noValidCharsN"/>";
               msg = msg.replace("null", inputValue);
               //alert(msg);
                
               //return false;
            }

            return true;
        }
        
        function addCondition(value) {
            var cond = "";
            var frm = document.AdminMainTablesForm;
            var column = frm.columnSelected.options[frm.columnSelected.selectedIndex].value;
            var operator = frm.operator.options[frm.operator.selectedIndex].value;
            var logical = frm.logical.options[frm.logical.selectedIndex].value;

            var columnValue = frm.conditionValue.value;

            if(!ValidateInput(columnValue)) return;

            if(column.match(/_DT$/i)) {
               if(operator == '=') {
                  column = 'TRUNC('+column+')';
                  columnValue = "TO_DATE('"+ columnValue +"','MM/DD/YYYY')";
               }
               else if(operator == '>' || operator == '<') {
                  columnValue = "TO_DATE('" + columnValue + "','MM/DD/YYYY HH24:MI:SS')";
               }
            }
            else {
                columnValue = "'" + columnValue + "'";
            }
            cond = cond + column + operator + columnValue;
            var condition = new Object();
            condition.text = cond;
            condition.logical = logical;
            conditions.push(condition);
            showConditions();
        }

        function showConditions() {
			var frm = document.AdminMainTablesForm;
			for (var j = 0; j < frm.conditions.options.length; j++)
				frm.conditions.options[j] = null;

			for (var i = 0; i < conditions.length; i++) {
	   			if(conditions.length == 1 || i == (conditions.length -1))
					frm.conditions.options[i] = new Option(conditions[i].text,conditions[i].text);
				else
					frm.conditions.options[i] = new Option(conditions[i].text + ' ' + conditions[i].logical,conditions[i].text + ' ' + conditions[i].logical);
			}
		}

		function removeCondition(delindex) {
			var size = conditions.length;
            if(size > 0) {
                for (var i=0; i < size; i++) {
                    conditions[i] = ((i == delindex) ? "delete" : conditions[i]);
                }
                for (var j = delindex; j <= size ; j++) {
                    conditions[j] = conditions[j + 1];
                }
                conditions.length = size - 1;
                showConditions();
            }
		}

        function recreateConditions() {
            var frm = document.AdminMainTablesForm;
            for (var i = 0; i < frm.conditions.options.length; i++) {
                var value = frm.conditions.options[i].value;
                var logical = frm.logical[frm.logical.selectedIndex].value;
                var condition = new Object();
                if(value.match(/AND$/)) {
		            condition.text = value.substring(0,value.length - 4);
                    logical = 'AND';
                }
                else if(value.match(/OR$/)) {
                    condition.text = value.substring(0,value.length - 3);
                    logical = 'OR';
                }
                else {
                    condition.text = value;
                }
                condition.logical = logical;
                conditions[i] = condition;
            }
        }

    </script>

    <html:errors/> <br>

    <body>
        <html:link page="/Admin/AdminTablesManager.do"><bean:message key="app.title.AdminTablesManager"/></html:link>
		<nested:form action="/Admin/AdminMainTables.do" focus="tableSelected">

			<table border="0" width="500" cellpadding="0" cellspacing="1" align="center" bgcolor="#000000">
				<tr bgcolor="#73148C">
					<td><div align="center"><font size="2" color="#FFFFFF" face="Arial, Helvetica, sans-serif"><strong>
                            ADD CRITERIA TO QUERY</strong></font></div></td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="0" width="1" cellspacing="1" cellpadding="2">
							<tr bgcolor="#ffff99">
                                <td bgcolor="#999999" width="20%" align="right"><font size="1">TABLE:</font></td>
								<td width="30%">
									<nested:select property="tableSelected" onchange="javascript:if(this.value!=-1)sendToServer('table','');" >
      									<option value="-1" ><font size="1">SELECT TABLE</font></option>
                                        <nested:options property="tables"/>
									</nested:select>
								</td>
                                <c:if test="${not empty AdminMainTablesForm.columnToFilter}">
                                    <td width="50%" colspan="4">
                                        &nbsp;&nbsp;<font size="2" face="Arial" color="#0000CC" > For date use this format "mm/dd/yyyy"</font>
                                    </td>
                                </c:if>
							</tr>
                            <c:if test="${not empty AdminMainTablesForm.columnToFilter}">
                                    <tr  bgcolor="#ffff99">
                                        <td bgcolor="#999999" width="20%" align="right"> <font size="1">COLUMN</font>:</td>
                                        <td width="25%">
                                            <font size="2" face="Arial, Helvetica, sans-serif">
                                                <nested:select property="columnSelected">
                                                    <nested:options property="columnToFilter"/>
                                                </nested:select>
                                            </font>
                                        </td>
									    <td width="10%" align="center">
											<select name="operator">
                                                <option value="=">=</option>
                                                <option value=">">&gt;</option>
                                                <option value="<">&lt;</option>
                                            </select>
                                        </td>
                                        <td width="25%">
                                            <font size="1"><html:text property="conditionValue" size="20"/></font>
                                        </td>
                                        <td width="10%">
                                            <font size="2" face="Arial, Helvetica, sans-serif">
                                                <select name="logical">
                                                    <option value="AND" selected>AND</option>
                                                    <option value="OR">OR</option>
                                                </select>
                                            </font>
                                        </td>
                                        <td width="10%">
                                            <input type="button" name="add" value="Add Filter" onclick="addCondition(AdminMainTablesForm.conditionValue.value)">
                                        </td>
                                    </tr>
                                    <tr bgcolor="#ffff99">
                                        <td bgcolor="#999999">&nbsp;</td>
                                        <td colspan="4">
                                            <font size="2" face="Arial, Helvetica, sans-serif">
                                                <nested:select property="conditions" multiple="multiple" size="6" style="width:385" onkeydown="if(window.event.keyCode == '46'){removeCondition(this.selectedIndex)};">
                                                    <nested:notEmpty property="conditions">
                                                        <nested:options property="conditions"/>
                                                    </nested:notEmpty>
                                                </nested:select>
                                            </font>
                                        </td>
                                        <td valign="top">
                                            <input type="button" name="remove" value="Remove" onclick="removeCondition(document.AdminMainTablesForm.conditions.selectedIndex)">
                                            <br><br>
                                            <table>
                                                <tr>
                                                    <td valign="top">
                                                        <html:link href="javascript:sendToServer('data','');">
                                                             <img  align="center" border="0" src="<html:rewrite page="/images/ProccessSQL" /><bean:message key="app.Language" />.gif" align="left" width="130" heigth="35">
                                                        </html:link>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr bgcolor="#ffff99">
                                        <td><bean:message key="app.message.orderByColumn"/></td>
                                        <td>
                                            <nested:select property="orderByColumn1">
                                                <html:option key="app.messages.selectColumn" value="none"/>
                                                <nested:options property="columnToSelect"/>
                                            </nested:select>
                                        </td>
                                        <td><bean:message key="app.message.orderByColumn"/></td>
                                        <td>
                                            <nested:select property="orderByColumn2">
                                                <html:option key="app.messages.selectColumn" value="none"/>
                                                <nested:options property="columnToSelect"/>
                                            </nested:select>
                                        </td>
                                        <td><bean:message key="app.message.orderByColumn"/></td>
                                        <td>
                                            <nested:select property="orderByColumn3">
                                                <html:option key="app.messages.selectColumn" value="none"/>
                                                <nested:options property="columnToSelect"/>
                                            </nested:select>
                                        </td>
                                    </tr>
                              </c:if>
						</table>
					</td>
				</tr>
    <input type="hidden" name="action"/>

    <nested:hidden property="sqlCondition"/>
    <nested:hidden property="inputPatterns"/>

</table>
<c:if test="${not empty AdminMainTablesForm.columnToSelect}">
        <c:if test="${AdminMainTablesForm.pageNumber ne 0}">
            <b><font face="Arial" color="#000066" >Go to page : </font></b>
            <nested:select property="currentPageNumber" name="AdminMainTablesForm" onchange="javascript:sendToServer('data','');" >
                <c:forEach var="page" begin="1" end="${AdminMainTablesForm.pageNumber}">
                    <c:choose>
                        <c:when test="${AdminMainTablesForm.currentPageNumber eq page}">
                            <option value="<c:out value="${page}" escapeXml="true" />" selected> <c:out value="${page}" escapeXml="true" /> of <c:out value="${AdminMainTablesForm.pageNumber}" escapeXml="true" /> </option>
                        </c:when>
                        <c:otherwise>
                            <option value="<c:out value="${page}" escapeXml="true" />"> <c:out value="${page}" escapeXml="true" /> of <c:out value="${AdminMainTablesForm.pageNumber}" escapeXml="true" /> </option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </nested:select>
       </c:if>
  <table width="100%" bgcolor="#000000">
    <tr>
         <td bgcolor="#73148C">
             <font size="1" color="#FFFFFF"><b>#</b></font>
         </td>
         <!-- For Each to iterate and add the primary key first in the table -->
         <c:forEach var="column" items="${AdminMainTablesForm.columnToSelect}">
               <c:if test="${AdminMainTablesForm.primaryKey eq column}">
                 <td bgcolor="#73148C" align="center">
                   <font size="1" color="#FFFFFF"><b><c:out value="${column}"/></b></font>
                 </td>
               </c:if>
         </c:forEach>
         <!-- For Each to iterate and add column but not the primary key -->
         <c:forEach var="column" items="${AdminMainTablesForm.columnToSelect}">
               <c:if test="${AdminMainTablesForm.primaryKey ne column}">
                 <td bgcolor="#73148C" align="center">
                   <font size="1" color="#FFFFFF"><b><c:out value="${column}"/></b></font>
                 </td>
               </c:if>
         </c:forEach>
    </tr>
    <c:if test="${not empty AdminMainTablesForm.dataToShow}">
       <c:forEach var="row" items="${AdminMainTablesForm.dataToShow}" varStatus="statusRow">
           <c:choose>
               <c:when test="${statusRow.count % 2 == 0}">
                  <tr bgcolor="#C0C0C0">
               </c:when>
               <c:otherwise>
                   <tr bgcolor="#ffffff">
               </c:otherwise>
           </c:choose>
           <c:forEach var="column" items="${row}" varStatus="statusCol">
                <c:choose>
                   <c:when test="${statusCol.count eq 2}">
                        <td align="center" >
                            <font size="1"><b>
                               <c:set var="primaryKey" value="${column}"/>
                               <a href="javascript:sendToServer('update','<c:out value="${primaryKey.columnValue}" escapeXml="true" />')"><c:out value="${primaryKey.columnValue}" escapeXml="true" /></a>

                            </b></font>
                        </td>
                   </c:when>
                   <c:otherwise>
                       <td>
                            <font size="1"><b>
                               <c:out value="${column.columnValue}"/>
                            </b></font>
                       </td>
                   </c:otherwise>
                </c:choose>
             </c:forEach>
          </tr>
       </c:forEach>
    </c:if>
</c:if>
</nested:form>
<script>
    var f = document.forms['AdminMainTablesForm'];
    if(f.conditions) {
        for (var i = 0; i < f.conditions.options.length; i++)
             f.conditions.options[i].selected=false;
        recreateConditions();
    }
</script>
