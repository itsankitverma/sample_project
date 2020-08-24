<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<html>
<head>
<title>Add Outbound Ancillary Charges </title>
</head>
<body>
<html:errors/>
<nested:form method="Post" action="/OAC/AddOAC.do" focus="courier">
<logic:present name="AddOACForm" scope="request" >
<script src="<html:rewrite page="/scripts/ccs_scripts.js" />"></script>
<script>
    function saveNewOacs()
    {  var form = document.forms['AddOACForm'];
       form.elements['action'].value='saveOacs';
       form.submit();
    }

    function addNewOac(){
        var msg=validate();
        if(msg.length>0) {
          alert(msg);
        }else{
                var form=document.forms['AddOACForm'];
                form.elements['action'].value='addNewOac';
                select();
                form.submit();
        }
    }

    function delNewOac(item){
        var form=document.forms['AddOACForm'];
        form.elements['action'].value='delNewOac';
        form.elements['item'].value=item;
        form.submit();
    }

    function validateEnteredAwb(obj){
        if(obj.value.length>0){
            var form=document.forms['AddOACForm'];
            var awbNbr=extractAWB(obj.value);

            if(validaAWBNbr(awbNbr)){
                obj.value=awbNbr;
            }else{
                obj.select();
                alert("<bean:message key="app.messages.js.MustEnterAwbNumber" />");
                obj.focus();
            }
        }
    }

    function move(op){
		var frm=document.forms['AddOACForm'];
		var src;
		var trg;
        var selectedCount=Number(0);
        var sortingLimit=50;

		if(op=="add"){
			src=frm.awbSelected;
			trg=frm['newOac.awbs'];
		}else{
			src=frm['newOac.awbs'];
			trg=frm.awbSelected;
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
        if(selectedCount > 0) notSavedChanges=true;
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

    function addOtherAwb(){
        var frm  		= document.forms['AddOACForm'];
		var otherAwb	= frm.otherAwb.value;
        var opts;

        opts = frm['newOac.awbs'];
        if(otherAwb != ""){
		    opts.options[opts.length] = new Option(otherAwb,otherAwb);
            frm.otherAwb.value = "";
        }
    }

    function deselect(){
        var frm  		= document.forms['AddOACForm'];
        var newAwbs     = frm['newOac.awbs'];
        var awbs        = frm['awbSelected'];

        /*
        for(i=0;i<newAwbs.length;i++){
            newAwbs.options[i].selected=false;
        }*/
        if(awbs.length>0){
            for(i=0;i<awbs.length;i++){
               //eval("awbs.options["+i+"]").selected=false;
               //awbs.options[i].selected=false;
            }
        }
    }

    function select(){
        var frm  		= document.forms['AddOACForm'];
        var newAwbs     = frm['newOac.awbs'];
        var awbs        = frm['awbSelected'];

        for(i=0;i<newAwbs.length;i++){
            newAwbs.options[i].selected=true;
        }
        for(i=0;i<awbs.length;i++){
            awbs.options[i].selected=true;
        }
    }

    function validate() {
        var  errMessage = "";

        var date = document.forms['AddOACForm'].elements['newOac.oacDateText'].value;
        var receipt = document.forms['AddOACForm'].elements['newOac.rcptNbr'].value;
        var amount = document.forms['AddOACForm'].elements['newOac.cashPayment'].value;
        var awbsLength = document.forms['AddOACForm'].elements['newOac.awbs'].length;
        var courier = document.forms['AddOACForm'].elements['courier'].value;

        if(awbsLength==0){
           errMessage=errMessage+": <bean:message key="app.messages.MustEnterAtLeastOneAwb" />\n";
        }

        if(courier.length==0){
            errMessage=errMessage+": <bean:message key="app.messages.js.CourierRequired" />\n";
        }else{
              if(isNaN(courier)){
                errMessage=errMessage+": <bean:message key="app_messages.js.MustEnterOnlyNumbers" />\n";
              }
        }

        if(!validateUSDate(date)){
            errMessage=errMessage+": <bean:message key="app.message.js.MustEnterAValidDate" />\n";
        }

        if(amount==0 || isNaN(amount)){
           errMessage=errMessage+": <bean:message key="app.messages.js.BadMonto" />\n";
        }

        if(receipt.length==0){
           errMessage=errMessage+": <bean:message key="app.messages.js.ReEnterNewReceipt" />\n";
        }

        return errMessage;
    }
</script>
<input type="hidden" name="action">
<input type="hidden" name="item" value="">
<table border="0" cellspacing="0" align="center" >
  <tr>
    <td bgcolor="#73148C"><b><font size="2" color="#FFFFFF" face="Verdana"><bean:message key="app.title.AwbsFromPrepaid"/></font></b></td>
    <td bgcolor="#FFFFFF" rowspan="8"><b><font face="Verdana" size="2"><input type="button" onclick="move('add');" value="&gt;&gt;" name="B1" style="font-size: 10 pt; font-weight: bold"><hr><input type="button" onclick="move('remove');" value="&lt;&lt;" name="B1" style="font-size: 10 pt; font-weight: bold"></font></b></td>
    <td bgcolor="#73148C" colspan="4">
      <p align="center"><b><font color="#FFFFFF" size="2" face="Verdana"><bean:message key="app.title.LinkAwbToOac"/></font></b></td>
  </tr>
  <tr>
    <td bgcolor="#FFFF9C" rowspan="5">
      <p align="center"><font face="Verdana" size="3">
      <html:select property="awbSelected" multiple="true" size="12">
         <html:options property="awbs" name="AddOACForm"/>
      </html:select>
     </font></td>
    <td bgcolor="#FFFF9C" rowspan="8">&nbsp;</td>
    <td bgcolor="#FFFF9C" rowspan="8"><font face="Verdana" size="3">
      <html:select property="newOac.awbs" multiple="true" size="12">
         <html:options property="newOac.awbs" name="AddOACForm"/>
      </html:select>
      </font></td>
    <td bgcolor="#FFFF9C" colspan="2">
      <p align="center"><font face="Verdana" size="2"><u><b><bean:message key="app.title.OacDetails"/></b></u></font></p>
    </td>
  </tr>
  <tr>
    <td bgcolor="#FFFF9C"><b><font face="Verdana" size="2"><bean:message key="app.messages.CourierEmployeeID"/></font></b></td>
    <td bgcolor="#FFFF9C" align="left"><b><font face="Verdana" color="#000000" size="2"><nested:text property="courier" maxlength="10" size="10"/></FONT></B></td>
  </tr>
  <tr>
    <td bgcolor="#FFFF9C"><b><font face="Verdana" size="2"><bean:message key="app.title.ReceiptDate"/></font></b></td>
    <td bgcolor="#FFFF9C" align="left"><b><font face="Verdana" color="#000000" size="2"><nested:text property="newOac.oacDateText"/></FONT></B></td>
  </tr>
  <tr>
    <td bgcolor="#FFFF9C"><b><font face="Verdana" size="2"><bean:message key="app.messages.ReceiptNbr"/></font></b></td>
    <td bgcolor="#FFFF9C"><b><font face="Verdana" color="#000000" size="2"><nested:text property="newOac.rcptNbr"/></FONT></B>
    </td>
  </tr>
  <tr>
    <td bgcolor="#FFFF9C">
      <p align="left"><b><bean:message key="app.messages.Amount"/></b></td>
    <td bgcolor="#FFFF9C"><b><font face="Verdana" color="#000000" size="2"><nested:text property="newOac.cashPayment"/></FONT></B>
    </td>
  </tr>
  <tr>
    <td bgcolor="#73148C" rowspan="2"><b><font size="2" color="#FFFFFF" face="Verdana"><bean:message key="app.title.NewAwbToOac"/></font></b></td>
    <td bgcolor="#FFFF9C"><b><bean:message key="app.messages.Currency"/></b></td>
    <td bgcolor="#FFFF9C">
        <nested:select property="newOac.paymentCurrency">
            <c:forEach var="currency" items="${AddOACForm.currencySupported}">
                <option><c:out value="${currency.currencyCode}"/></option>
            </c:forEach>
        </nested:select>
    </td>
  </tr>
  <tr>
    <td bgcolor="#FFFF9C" colspan="2" rowspan="2"><b><font face="Verdana" size="2"><input type="button" value="<bean:message key="app.message.AddOaclist"/>" name="B1" onClick="addNewOac();" style="font-size: 8 pt; font-weight: bold"></font></b></td>
  </tr>
  <tr>
    <td bgcolor="#FFFF9C">
      <p align="center"><b><font face="Verdana" color="#000000" size="2"><input type="text" name="otherAwb" maxlength="20" size="12" value="" onblur="validateEnteredAwb(this)" style="text-align: right; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10 pt"> <input type="button" onclick="addOtherAwb();" value="&gt;&gt;" name="B1" style="font-size: 10 pt; font-weight: bold"></font></b></td>
  </tr>
</table>
<hr>
                                    <nested:hidden property="currencyCd"/>
                                    <nested:hidden property="locationCd"/>
						            <table border="0" bgcolor="#000000" cellspacing="1">
							            <tr>
                                            <td bgColor="#73148C" colspan="3">
                                              <p align="center"><b><font color="#FFFFFF" size="2" face="Verdana"><bean:message key="app.title.OacList"/></font></b></td>
                                            <td bgColor="#73148C" colspan="5">
                                              <p align="right"><b><font size="2" face="Verdana"><input type="button" value="<bean:message key="app.message.SaveOacList"/>" name="B1" onClick="saveNewOacs();" style="font-size: 8 pt; font-weight: bold"></font></b></td>
							            </tr>
							            <tr>
                                            <td bgColor="#73148C" rowspan="2"><b><p align="center"><font face="Verdana" color="#FFFFFF" size="2">#</font></p></b></td>
							                <td bgColor="#73148C" align="center" rowspan="2">
                                                <font face="Verdana" size="2" color="#FFFFFF"><b>AWBs</b></font>
                                            </td>
            							    <td bgColor="#73148C" align="center" colspan="2" rowspan="2"><b><font color="#FFFFFF" size="2" face="Verdana"><bean:message key="app.title.ReceiptDate"/></font></b></td>
            							    <td bgColor="#73148C" align="center" rowspan="2"><b><p align="center"><font color="#FFFFFF" size="2" face="Verdana"><bean:message key="app.messages.ReceiptNbr"/></font></b></td>
            							    <td bgColor="#73148C" align="center" colspan="3"><font color="#FFFFFF" size="2" face="Verdana"><bean:message key="app.messages.Amount"/></font></td>
							            </tr>
							            <tr>
            							    <td bgColor="#73148C" align="center"><font color="#FFFFFF" size="2" face="Verdana">Local$</font></td>
            							    <td bgColor="#73148C" align="center"><font color="#FFFFFF" size="2" face="Verdana">US$</font></td>
            							    <td bgColor="#73148C" align="center"><font color="#FFFFFF" size="2" face="Verdana"><bean:message key="app.messages.Action"/></font></td>
							            </tr>
                                        <nested:iterate property="oacList" id="oacVO" indexId="idx" type="com.fedex.lacitd.cashcontrol.biztier.common.OACDetailsTableVO">
                                        <tr>
                                            <nested:hidden property="oacDateText"/>
                                            <nested:hidden property="rcptNbr"/>
                                            <nested:hidden property="cashPayment"/>
                                            <nested:hidden property="paymentCurrency"/>
                                            <nested:hidden property="courierId"/>
                                            <td bgColor="#73148C"><bean:write name="idx"/></td>
                                            <td bgColor="#C0C0C0" align="center"><font size="2" face="Verdana">
                                            <nested:select property="awbs" multiple="true" size="2">
                                                <html:options property="awbs" name="oacVO"/>
                                            </nested:select>
                                            </font></td>
                                            <td bgColor="#C0C0C0" align="center" colspan="2"><font face="Verdana" color="#000000" size="2"><nested:write property="oacDateText" formatKey="app.format.Date"/></font></td>
                                            <td bgColor="#C0C0C0" align="center"><font face="Verdana" size="2"><nested:write property="rcptNbr"/></font></td>
                                            <c:choose>
                                                <c:when test="${oacVO.paymentCurrency eq 'USD'}">
                                                    <td bgColor="#C0C0C0" align="center">&nbsp;</td>
                                                    <td bgColor="#C0C0C0" align="center"><font face="Verdana" size="2"><nested:write property="cashPayment" formatKey="app.format.NumberFormat"/></font></td>
                                                </c:when>
                                                <c:otherwise>
                                                        <td bgColor="#C0C0C0" align="center"><font face="Verdana" size="2"><nested:write property="cashPayment" formatKey="app.format.NumberFormat"/></font></td>
                                                        <td bgColor="#C0C0C0" align="center">&nbsp;</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td bgColor="#C0C0C0" align="center"><a href="javascript:delNewOac('<%=idx.intValue()%>')"><font color="#000000" face="Verdana" size="1">delete</font></a></td>
                                         </tr>
                                    </nested:iterate>
							        </table>
</logic:present>
</nested:form>
</body>
</html>