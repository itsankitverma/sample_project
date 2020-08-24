<%--
  Created by IntelliJ IDEA.
  User: arturog
  Date: 22-03-2005
  Time: 12:07:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<script>
    function closeWindow()
    {   var f = document.forms['AdminTasksForm'];
        /*opener.document.location.href ="<html:rewrite page="/Admin/AdminUserList.do" />?accion=" + action + "&countrySelected=" + f.country.value;*/
        window.close();
    }

    function saveTaskTimer(){
        var f = document.forms['AdminTasksForm'];
        f.action.value='updateTasks';
        if(!validateForm())
           alert("Please complete the form correctly, time format is hh:mm");
        else
           f.submit();
    }

    function pasteValue(){
        var ft = document.forms['AdminTasksForm'];
        var fl = opener.document.forms['AdminLocationForm'];

        if(ft.taskTypeCd.value=="1")
            fl.inCageTskIdNumber.value = ft.tasksId.value;
        else
            fl.rihTskIdNumber.value    = ft.tasksId.value ;
    }

    function validateForm(){
        var f = document.forms['AdminTasksForm'];

        if(f.runSun.checked && !validateTime(f.runSunTime)) return false;
        if(!f.runSun.checked) f.runSunTime.value = "";
        if(f.runMon.checked && !validateTime(f.runMonTime)) return false;
        if(!f.runMon.checked) f.runMonTime.value = "";
        if(f.runTue.checked && !validateTime(f.runTueTime)) return false;
        if(!f.runTue.checked) f.runTueTime.value = "";
        if(f.runWed.checked && !validateTime(f.runWedTime)) return false;
        if(!f.runWed.checked) f.runWedTime.value = "";
        if(f.runThu.checked && !validateTime(f.runThuTime)) return false;
        if(!f.runThu.checked) f.runThuTime.value = "";
        if(f.runFri.checked && !validateTime(f.runFriTime)) return false;
        if(!f.runFri.checked) f.runFriTime.value = "";
        if(f.runSat.checked && !validateTime(f.runSatTime)) return false;
        if(!f.runSat.checked) f.runSatTime.value = "";

        return true;
    }

    function validateTime(time){
        var baseTime = time.value.split(":");
        var hh = baseTime[0];
        var mm  = baseTime[1];

        if(isNaN(hh) || isNaN(mm) || ( hh < 0  || hh > 24 ) || (mm < 0 || mm > 59))
            return false;
        else
            if(hh==24 && mm > 0)
                return false;
            else
                return true;
    }
</script>

<html:errors />
<title><bean:message key="app.message.Time"/></title>
<div align="center">
<nested:form action="/Admin/AdminTasks.do">
<nested:hidden property="action" value=""/>
<nested:hidden property="tasksId"/>
<nested:hidden property="locationCd"/>
<nested:hidden property="taskTypeCd"/>
<nested:hidden property="emailWarning"/>
    <table border="0" cellspacing="1" cellpadding="0" bgcolor="#000000">
            <tr>
              <td bgcolor="#73148C" colspan="2"><p align="center"><font color="#FFFFFF" face="Arial">
                  <nested:equal property="taskTypeCd" value="1">
                  <b><bean:message key="app.location.InCageExceptions" />
                  </nested:equal>
                  <nested:equal property="taskTypeCd" value="2">
                  <b><bean:message key="app.location.rih" />
                  </nested:equal>
                     &nbsp;(<nested:write property="locationCd"/>)
                  </b></font>
              </td>
            </tr>
            <tr>
              <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:checkbox property="runSun" value="1" /> Run Sun
              </font></td>
              <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:message key="app.message.Time"/>  :
                    <font size="2" face="Arial" color="#000000">
                        <nested:text property="runSunTime" size="5" maxlength="5"  />
                    </font></td>
           </tr>
           <tr>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:checkbox property="runMon" value="1" /> Run Mon
            </font></td>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:message key="app.message.Time"/>  :
                    <nested:text property="runMonTime" size="5" maxlength="5"  />
            </font></td>
          </tr>
          <tr>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:checkbox property="runTue" value="1" /> Run Tue
            </font></td>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:message key="app.message.Time"/>  :
                    <nested:text property="runTueTime" size="5" maxlength="5"  />
            </font></td>
          </tr>
          <tr>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:checkbox property="runWed" value="1" /> Run Wed
            </font></td>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:message key="app.message.Time"/>  :
                    <nested:text property="runWedTime" size="5" maxlength="5"  />
            </font></td>
          </tr>
          <tr>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:checkbox property="runThu" value="1" /> Run Thu
            </font></td>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:message key="app.message.Time"/>  :
                    <nested:text property="runThuTime" size="5" maxlength="5"  />
            </font></td>
          </tr>
          <tr>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:checkbox property="runFri" value="1" /> Run Fri
            </font></td>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:message key="app.message.Time"/>  :
                    <nested:text property="runFriTime" size="5" maxlength="5"  />
            </font></td>
          </tr>
          <tr>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:checkbox property="runSat" value="1" /> Run Sat
            </font></td>
            <td bgcolor="#C0C0C0" align="left"><font size="2" face="Arial" color="#000000">
                    <nested:message key="app.message.Time"/>  :
                 <font size="2" face="Arial" color="#000000">
                    <nested:text property="runSatTime" size="5" maxlength="5"  />
                </font></td>
          </tr>
          <tr>
              <td colspan="2" bgcolor="#FFFF9C">
                <p align="center">
                  <html:link href="javascript:saveTaskTimer();"><img  align="center" border="0" src="<html:rewrite page="/images/Save" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
                  <html:link href="javascript:closeWindow();"><img align="center" border="0" src="<html:rewrite page="/images/Close" /><bean:message key="app.Language" />.gif" align="left" width="114" height="38"></html:link>
                </p>
              </td>
          </tr>
      </table>
 <script>pasteValue()</script>
 </nested:form>
</div>
