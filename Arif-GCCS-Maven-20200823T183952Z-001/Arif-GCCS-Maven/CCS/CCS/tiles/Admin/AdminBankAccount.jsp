<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<SCRIPT>
		function sendToServer(action)
		{ var f = document.forms['AdminAccountForm'];
		  f.action.value = action;
		  prepareLocations(f);
		  f.submit();	
		}
		
		function prepareLocations(f)
		{  var sel=f.locationsSelected;
		   
		   for(i=0;i<sel.length;i++) 
		   {   if(Number(sel.options[i].value)!=0)
			   	  sel.options[i].selected=true;
		   }

		   var selByCountry=f.locationsByCountry;
		   for(i=0;i<selByCountry.length;i++)
		   {   if(Number(selByCountry.options[i].value)!=0)
		   	   	  selByCountry.options[i].selected=true;
		   }	   	  		   	   
        }
        
		function move(op){
			var frm=document.forms['AdminAccountForm'];
			var src;
			var trg;
                var selectedCount=Number(0);

                var sortingLimit=50;

				if(op=="add"){
					src=frm.locationsByCountry;
					trg=frm.locationsSelected;
				}else{
					src=frm.locationsSelected;
					trg=frm.locationsByCountry;
				}

			
			for(i=src.length-1;i>=0;i--){
				if(src.options[i].selected){
        	                selectedCount++;
                             
                            if(selectedCount>sortingLimit || trg.length>sortingLimit){
                               trg.options[trg.length]=new Option(src.options[i].text,src.options[i].value);
                            }else{
                                 for(j=trg.length;j>=0;j--){ //to keep the options sorted if this does not take so much time.

                                            if(j==0 || trg.options[j-1].text<=src.options[i].text){
                                                    trg.options[j]=new Option(src.options[i].text,src.options[i].value);
                                                    break;
                                            }else{
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
			var frm=document.forms['AdminAccountForm'];
			var sel;
    	    var msg;

			if(op=="add"){
				sel=frm.locationsByCountry;
                msg="<bean:message key="app.messages.js.AddAllLocations" />";
			}else{
				sel=frm.locationsSelected;
                msg="<bean:message key="app.messages.js.RemoveAllLocations" />";
			}
                
            if(confirm(msg)){
               for(i=0;i<sel.length;i++)
               {   if(Number(sel.options[i].value)!=0)
               		  sel.options[i].selected=true;}
               move(op);
            }    
		}
</SCRIPT>



<html:errors />
<nested:form method="post" action="/Admin/AdminAccount.do" focus="accountNbr">
<input type="hidden" name="action">
<nested:hidden property="accountCd"/>
<div align="center">
  <table border="0" width="600" cellspacing="0" cellpadding="0" bgcolor="#000000" style="border-collapse: collapse" bordercolor="#111111" height="219" align="center">
    <tr> 
      <td bgcolor="#808080" width="1" height="3"> <font face="Arial"> <img border="0" src="pixel.gif" width="1" height="1"></font></td>
      <td bgcolor="#808080" colspan="2" height="3"> <font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
      <td bgcolor="#808080" width="1" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
    </tr>
    <tr> 
      <td bgcolor="#808080" width="1" height="10">&nbsp; </td>
      <td height="10" colspan="2" align="center" bgcolor="#73148c">
      		<font face=arial color="#ffffff" size="+1"><b><nested:message key="app.messages.AccountConf"/></b></font>
      </td>
      <td bgcolor="#808080" width="1" height="10">&nbsp;</td>
    </tr>
     <tr> 
      <td bgcolor="#808080" width="1" height="3"> <font face="Arial"> <img border="0" src="pixel.gif" width="1" height="1"></font></td>
      <td bgcolor="#808080" colspan="2" height="3"> <font face="Arial"><img border="0" src="pixel.gif" height="1"></font></td>
      <td bgcolor="#808080" width="1" height="3"><img border="0" src="pixel.gif" width="1" height="1"></td>
    </tr>
    <tr> 
      <td bgcolor="#808080" width="1" height="20"> <font face="Arial"> <img border="0" src="pixel.gif" width="1"></font></td>
      <td bgcolor="#FFFF9C" align="center" colspan="2" height="20">&nbsp; </td>
      <td bgcolor="#808080" width="1" height="20"><img border="0" src="pixel.gif" width="1"></td>
    </tr>
    <tr> 
      <td bgcolor="#808080" width="3" height="22">&nbsp; </td>
      <td bgcolor="#FFFF9C" align="right" height="22" width="422">
      	<table>
      		<tr>
      			<td align="center">
			      	<b><font face="Arial" size="2"> 
	    		    	<bean:message key="app.country" />
	       			</font>
	       		</td>
	       		<td>
					<nested:select property="country" onchange="javascript:sendToServer('changeCountry')"> 
	    			   <logic:present name="countries" scope="session">
	     	   			<html:options collection="countries" property="countryCd" name="countries" labelProperty="countryNm"/>
		    	       </logic:present>
    			    </nested:select></font>      	
	       		</td>
	       	</tr>	
	       	<tr>
      			<td align="center">
			      	<b><font face="Arial" size="2"> 
	    		    	<bean:message key="app.bank" />
	       			</font>
	       		</td>
	       		<td>
					<nested:select property="bankId"> 
	    			   		<nested:optionsCollection property="bankByCountry" label="bankNm" value="bankId"/>
    			    </nested:select></font>      	
	       		</td>
	       	</tr>	
	       	<tr>
      			<td align="center">
			      	<b><font face="Arial" size="2"> 
	    		    	<nested:message key="app.messages.accountNbr" />
	       			</font>
	       		</td>
	       		<td>
					<nested:text property="accountNbr" size="20"/>
	       		</td>
	       	</tr>	
	       	<tr>
      			<td align="center">
			      	<b><font face="Arial" size="2"> 
	    		    	<nested:message key="app.messages.brach" />
	       			</font>
	       		</td>
	       		<td>
					<nested:text property="brach" size="20"/>
	       		</td>
	       	</tr>
	       	<tr>
      			<td align="center">
			      	<b><font face="Arial" size="2"> 
	    		    	<bean:message key="app.messages.Currency" />
	       			</font>
	       		</td>
	       		<td>
	       			<nested:select property="currency" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 8 pt">
				           <html:optionsCollection name="AdminAccountForm" property="supportedCurrencies" label="currencyCode" value="currencyCode" />
				    </nested:select>
	       		</td>
	       	</tr>
	       	
	       	<!-- 
		       	Introduced a new field Orgination Number
	            Changes Done Kapil R
	       	 -->
	       	<tr>
      			<td align="center">
			      	<b><font face="Arial" size="2"> 
	    		    	<nested:message key="app.messages.OriginationNumber" />
	       			</font>
	       		</td>
	       		<td>
					<nested:text property="originationNbr" size="20"/>
	       		</td>
	       	</tr>
	       	
	    </table>  
	  </td>
      <td bgcolor="#FFFF9C" height="22" width="484" align="center">
     	<table width="222" border="0" cellpadding="0" cellspacing="0" bordercolor="#111111" bgcolor="#000000" style="border-collapse: collapse">
			<tr>
			    <td bgcolor="#808080" height="3" colspan=7> <font face="Arial"> <img border="0" src="pixel.gif" width="1" height="1"></font></td>
			</tr>
      		<tr>
		        <td bgcolor="#808080" width="2" height="3"> <font face="Arial"> <img border="0" src="pixel.gif" width="1" height="1"></font></td>
      			<td colspan="5" bgcolor="#73148c" align="center">
					<font face=arial color="#ffffff" size="2"><b><nested:message key="app.messages.SetLocations"/></b></font>
      			</td>
		        <td bgcolor="#808080" width="2" height="3"> <font face="Arial"> <img border="0" src="pixel.gif" width="1" height="1"></font></td>
      		</tr>
      		<tr>
			    <td bgcolor="#808080" width="2" height="3"> <font face="Arial"> <img border="0" src="pixel.gif" width="1" height="1"></font></td>
				<td bgcolor="#FFFF9C" width="18" height="3"> <font face="Arial"> <img border="0" src="pixel.gif" width="1" height="1"></font></td>
      			<td width="59" align="center" valign="middle" bgcolor="#FFFF9C">
      				<nested:select property="locationsByCountry" multiple="true" size="12">
	      				<nested:optionsCollection property="locationsByCountry" label="locationCd" value="locationCd"/>
      				</nested:select>
      			</td>
      			<td bgcolor="#FFFF9C" height="230" width="58">
					<p align="center"><input type="button"  onclick="moveAll('add');" value="&gt;&gt;" name="B3"></p>
        		    <p align="center"><input type="button"  onclick="move('add');" value=" &gt; " name="B2"></p>
		            <p align="center"><input type="button"  onclick="move('remove');" value=" &lt; " name="B1"></p>
		            <p align="center"><input type="button"  onclick="moveAll('remove');" value="&lt;&lt;" name="B4">
      			</td>
      			<td width="63" align="center" valign="middle" bgcolor="#FFFF9C">
 		      			<nested:select property="locationsSelected" multiple="true" size="12" >
 		      					<nested:empty property="locationsSelected">
 		      						<option>&nbsp;</option>
 		      					</nested:empty>
		      					<nested:notEmpty property="locationsSelected">
			      					<nested:optionsCollection property="locationsSelected" label="locationCd" value="locationCd"/>
			      				</nested:notEmpty>	
	  					</nested:select>

      			</td>
				<td bgcolor="#FFFF9C" width="18" height="3"> <font face="Arial"> <img border="0" src="pixel.gif" width="1" height="1"></font></td>
		        <td bgcolor="#808080" width="2" height="3"> <font face="Arial"> <img border="0" src="pixel.gif" width="1" height="1"></font></td>
      		</tr>
			<tr>
			    <td bgcolor="#808080" height="3" colspan=7> <font face="Arial"> <img border="0" src="pixel.gif" width="1" height="1"></font></td>
			</tr>	
      	</table>
	  </td>
      <td bgcolor="#808080" width="1" height="22">&nbsp;</td>
    </tr>
    <tr> 
      <td bgcolor="#808080" width="1" height="10">&nbsp; </td>
      <td bgcolor="#FFFF9C" align="right" width="422" height="10">&nbsp; </td>
      <td bgcolor="#FFFF9C" height="10" width="375">&nbsp; </td>
      <td bgcolor="#808080" width="1" height="10">&nbsp;</td>
    </tr>
    <tr> 
      <td bgcolor="#808080" width="1" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
      <td bgcolor="#FFFF9C" colspan="2" height="3"><p align="center">
   		<html:link href="javascript:sendToServer('saveAccount');" ><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif"  align="left" width="114" height="38">
        </html:link> 
        <html:link href="javascript:sendToServer('showAccounts');" ><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="113" height="38">
        </html:link></p></td>
      <td bgcolor="#808080" width="1" height="3"><font face="Arial"><img border="0" src="pixel.gif" width="1" height="1"></font></td>
    </tr>
    <tr> 
      <td bgcolor="#808080" width="1" height="20"> <font face="Arial"> <img border="0" src="pixel.gif" width="1"></font></td>
      <td bgcolor="#FFFF9C" align="center" colspan="2" height="20">&nbsp; </td>
      <td bgcolor="#808080" width="1" height="20"><img border="0" src="pixel.gif" width="1"></td>
    </tr>
    <tr> 
      <td bgcolor="#808080" width="1" height="4"> <font face="Arial"> <img border="0" src="pixel.gif" width="1" height="1"></font></td>
      <td bgcolor="#808080" colspan="2" height="4"> <font face="Arial"> 
        <img border="0" src="pixel.gif" height="1"></font></td>
      <td bgcolor="#808080" width="1" height="4"><img border="0" src="pixel.gif" width="1" height="1"></td>
    </tr>
   </table>
</div>
</nested:form>
