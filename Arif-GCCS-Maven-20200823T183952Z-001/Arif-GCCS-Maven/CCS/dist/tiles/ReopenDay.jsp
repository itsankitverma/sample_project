<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

 




<html>
    <head>
    <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
    <META HTTP-EQUIV="Expires" CONTENT="-1">
    <title><bean:message key="app.messages.ReopenDay" /></title></head>
    <script>
        function reopen(openDeps){
            var frm=document.forms['reopenDay'];
            var frmParent=opener.document.forms['CheckInAgentCashRecapForm'];
            frmParent.elements['reopenDeposits'].value=openDeps;
            frmParent.elements['action'].value="ReopenEndDay";
            frmParent.submit();
            window.close();
        }

    </script>
    
        <body>
        <div align="center" style="width: 350; height: 104">
        <form name="reopenDay">
                <table border="0"  bgcolor="#C0C0C0" width="350" style="border-collapse: collapse" bordercolor="#111111" cellpadding="0" cellspacing="0" height="69" >
                      <tr>
                        <td width="350" height="37" align="center" bgcolor="#CCCCCC" >
                             <p align="center">
                             <input type="button" value="<bean:message key="app.messages.ConfirmReopen" />" name="B1" onclick="reopen(0);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                      </tr>

                      <tr>
                         <td bgcolor="#CCCCCC" height="32" >
                             <p align="center">
                             <input type="button" value="<bean:message key="app.messages.ReopenDeposits" />" name="B1" onclick="reopen(1);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      </tr>

                     <tr>
                         <td bgcolor="#CCCCCC" height="32" >
                             <p align="center">
                             <input type="button" value="Cancel" name="B2" onclick="window.close();"></td>
                      </tr>
                </table>
        </form>
        </div>
    </body>
</html>