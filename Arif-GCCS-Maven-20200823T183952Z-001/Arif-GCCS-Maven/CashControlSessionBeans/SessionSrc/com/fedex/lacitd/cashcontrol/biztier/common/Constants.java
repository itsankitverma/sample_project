package com.fedex.lacitd.cashcontrol.biztier.common;

import com.fedex.lacitd.cashcontrol.common.Utils;



public class Constants implements java.io.Serializable {
    /**
     * ******Data Sources JNDI Names***********
     */
    public static String CCSDataSource = "jdbc/CashControlDS";

    /**
     * ***Data Access Object Session Beans*****
     */
    public static String RODDaoEJB_Local = "RODDaoEJBLocal";
    public static String CODDaoEJB_Local = "CODDaoEJBLocal";
    public static String FTCDaoEJB_Local = "FTCDaoEJBLocal";
    public static String RODDaoEJB_Remote = "RODDaoEJB";
    public static String CODDaoEJB_Remote = "CODDaoEJB";
    public static String FTCDaoEJB_Remote = "FTCDaoEJB";
    public static String SystemUtilsDaoEJB_Local = "SystemUtilsDaoEJBLocal";
    public static String SystemUtilsDaoEJB_Remote = "SystemUtilsDaoEJB";
    public static String AdminDaoEJB_Local = "AdminDaoEJBLocal";
    public static String AdminDaoEJB_Remote = "AdminDaoEJB";
    public static String CommonOpsDaoEJB_Local = "CommonOpsDaoEJBLocal";
    public static String CommonOpsDaoEJB_Remote = "CommonOpsDaoEJB";
    public static String PrepPoaDaoEJB_Local = "PrepPoaDaoEJBLocal";
    public static String PrepPoaDaoEJB_Remote = "PrepPoaDaoEJB";


    /**
     * ***Facades Session Beans*****
     */
    public static String RODFacadeEJB_Local = "RODFacadeEJBLocal";
    public static String CODFacadeEJB_Local = "CODFacadeEJBLocal";
    public static String FTCFacadeEJB_Local = "FTCFacadeEJBLocal";
    public static String RODFacadeEJB_Remote = "RODFacadeEJB";
    public static String CODFacadeEJB_Remote = "CODFacadeEJB";
    public static String FTCFacadeEJB_Remote = "FTCFacadeEJB";
    public static String SystemUtilsEJB_Local = "SystemUtilsEJBLocal";
    public static String SystemUtilsEJB_Remote = "SystemUtilsEJB";
    public static String AdminFacadeEJB_Remote = "AdminFacadeEJB";
    public static String CommonOpsFacadeEJB_Local = "CommonOpsFacadeEJBLocal";
    public static String CommonOpsFacadeEJB_Remote = "CommonOpsFacadeEJB";
    public static String PrepPoaFacadeEJB_Local = "PrepPoaFacadeEJBLocal";
    public static String PrepPoaFacadeEJB_Remote = "PrepPoaFacadeEJB";

    /**
     * ***eCQS Access Settings*****
     */
    public static int threadsNumber=15;
	//static {
      //  threadsNumber = Integer.parseInt(Utils.getThreadsNumber());
    //}
	

    //Old Prod
    //public static String urlECQS="http://ecqsmem.prod.fedex.com:8011/ecqs/query";
    //New test and prod
    //public static String urlECQS = "http://ecqsintl.prod.fedex.com:8011/ecqs/query";
    public static String urlECQS = "http://ecqscons.prod.fedex.com:8011/ecqs/query";
    

    static {
        urlECQS = Utils.getUrlECQS();
        System.out.println("urlECQS Oct 31===="+urlECQS);
    }

    public static String qNameParamName = "qName";
    public static String qNameSummaryValue = "trkNo";
    public static String qNameDetailValue = "detailUid";
    public static String tinParamName = "trkNo";
    public static String tuidParamName = "c2001Uid";
    public static String qNameDetailFull = "detailFull"; // do not in user anymore
    public static String qNameDetailRecent = "detailRecent";

    /**
     * ***Logging Object********************
     */
    //public static NonCatalogLogger logger = new NonCatalogLogger("Global_Cash_Control_System");
    public static NewLogger logger = new NewLogger ("Global_Cash_Control_System");


    /**
     * ***Tasks running intervals************
     */
    public static int InCageExceptionsTaskInterval = 300000;
    public static int ImportXMLFilesTaskInterval = 300000;
    public static int VISAFileProcTaskInterval = 300000;
    public static int RIHFileProcTaskInterval = 300000;
    public static int RIHRequesterTaskInterval = 300000;
    public static int Process_DTRC_File_Task = 300000;
    public static int Process_External_File_Task = 300000;
    public static int WriteOffTaskInterval = 24 * 3600000; //one day
    public static int DTRCUploadTaskInterval = 24 * 3600000; //one day


    /**
     * ***LDAP Settings************
     */
    public static String LDAPInitialContextFactory = "com.sun.jndi.ldap.LdapCtxFactory";
    public static String LDAPProvider = "ldap://directory.fedex.com/o=fedex,c=us";

    /**
     * ****** Mail Session Setting ***********
     */
    public static String MAILSession = "CCSMailSession";
    public static String FROMADDRESS = "CashControl System";

    public static String SUBJECT_LOCKED = "User Locked. Revision Required.";
    public static String BODY_LOCKED = "One user tried to login into GCCS, but his/her password was locked before LDAP password change was implemented. \n" +
            "Please, check and unlock the following employee : \n" +
            "Id: fedexId - Name: employeeName - Email: employeeEmail \n" +
            "Server Type: serverType - Comat: employeeComat - Country: employeeCountry - Phone: employeePhone \n\n" +
            "Thank you very much. \n\n" +
            "Global CashControl System";
    public static String BODYCLIENT_LOCKED = "You tried to login into GCCS but your user was locked before LDAP password change was implemented. \n" +
            "Your administrator has been informed to unlock your user. \n" +
            "Id: fedexId - Name: employeeName - Remote Host: hostClient - Remote IP: ipClient \n\n" +
            "Thank you very much. \n\n" +
            "Global CashControl System";


    public static String SUBJECT_USER_DISABLED_ADMIN = "User Disabled. Revision Required.";
    public static String BODY_USER_DISABLED_ADMIN = "One user tried to login into GCCS, but his/her user was disabled due to inactivity. \n" +
            "Please, check and enable the following employee : \n" +
            "Id: fedexId - Name: employeeName - Email: employeeEmail \n" +
            "Server Type: serverType - Comat: employeeComat - Country: employeeCountry - Phone: employeePhone \n\n" +
            "Thank you very much. \n\n" +
            "Global CashControl System";

    public static String SUBJECTNEWPASSWORD = "New User Password.";
    public static String BODYNEWPASSWORD = "You have a new password.\n" +
            "New Password: employeePassword \n" +
            "You can use CashControl now.\n\n" +
            "Sincerely.\n\n" +
            "Global CashControl System";

    public static String BODYADMINNEWPASSWORD = "This employee doesn't have email to notiy the new password. \n " +
            "Please, create new email and notify him/her new password. \n " +
            "New Password: employeePassword \n " +
            "Sincerely.\n\n" +
            "Global CashControl System";

    //To unlock users locked for password before LDAP password was implemented
    public static String SUBJECT_USER_UNLOCKED = "User Unlocked.";
    public static String BODY_USER_UNLOCKED = "Your user has been unlocked.\n" +
            "You can access CashControl now using your Enterprise Password (LDAP).\n\n" +
            "Sincerely.\n\n" +
            "Global CashControl System";

    public static String SUBJECT_USER_ENABLED = "User Enabled.";
    public static String BODY_USER_ENABLED = "Your user has been enabled.\n" +
            "You can access CashControl now using your Enterprise Password (LDAP).\n\n" +
            "Sincerely.\n\n" +
            "Global CashControl System";


    public static String SUBJECT_USER_DISABLED = "User Disabled.";
    public static String BODY_USER_DISABLED = "You tried to login into GCCS but your user was disabled due to inactivity. \n" +
            "Your administrator has been informed to enable your user. \n" +
            "Id: fedexId - Name: employeeName - Remote Host: hostClient - Remote IP: ipClient \n\n" +
            "Thank you very much. \n\n" +
            "Global CashControl System";

    public static String SUBJECFILEPROCESS = "Exception at Process a Payment File.";
    public static String BODYFILEPROCESS = "An exception ocurred when try to process a importing: \n" +
            "File Name : file - Process Name : Import External File - Country : country \n\n" +
            "Please check this problem.\n\n" +
            "Global CashControl System";

    //To check environment
    public static String SUBJECTCHECKENV = "Wrong environment configuration.";
    public static String BODYCHECKENV = "This is an alert !!!. \n " +
            "The DB parameters are not well configured for this environment. \n " +
            "Weblogic Environment setting do not match with GCCS Database parameters setting. \n " +
            "GCCS is not completely up. \n " +
            "Please contact the support team to solve this problem. \n\n " +
            "Global CashControl System";
    
  
    //Miscellaneous enhancements annual mail to manager
    public static String SUBJECT_EMAIL_CERTIFICATION = "Email Certification";
    public static String BODY_EMAIL_CERTIFICATION = "As part of an annual review of internal controls, please take a moment to review the GCCS Payment Handling Controls and Procedures. \n " +
    //<a href="http://expresspmo.web.fedex.com/EBS/GCCS/Support/Procedures/Payment%20Handling%20Procedures_Feb%202007.pdf"> http://expresspmo.web.fedex.com/EBS/GCCS/Support/Procedures/Payment%20Handling%20Procedures_Feb%202007.pdf</a>
    "     LINK     \n " +
    "If your station(s) are in compliance with this document and have no exceptions to these procedures, please click the [Confirm] button below. \n " +
    "If you have an exception to this process in your station, please click the button below [Exception] and enter a description of your exception. \n " +
    "Your GCCS Divisional Administrator will contact you within 24 hours to follow-up to document the exception for proper internal control and audit purposes.  Should you have any exceptions to this document during the year, please contact your GCCS Divisional Administrator. \n\n " +
    "GCCS Global Administrator";
    /*
    <TABLE>
<TR>
<TD >
<form action="http://www.google.com=confir?yes" method="get"> <input type="submit" value="CONFIRM"/></form>
<TD>

<TD >
<form action="http://www.yahoo.com" method="get""> <input type="submit" value="EXCEPTION"/></form>
<TD>
</TR>
</TABLE>
    */
    
    
    /*
    <HTML>

<BODY>

Dear Station Manager,

<br>
<br>
As part of an annual review of internal controls, please take a moment to review the GCCS Payment Handling Controls and Procedures.

<br>
<br>
<a href="http://expresspmo.web.fedex.com/EBS/GCCS/Support/Procedures/Payment%20Handling%20Procedures_Feb%202007.pdf"> http://expresspmo.web.fedex.com/EBS/GCCS/Support/Procedures/Payment%20Handling%20Procedures_Feb%202007.pdf</a>

<br>
<br>
If your station(s) are in compliance with this document and have no exceptions to these procedures, please click the [Confirm] button below.

<br>
<br>
If you have an exception to this process in your station, please click the button below [Exception] and enter a description of your exception.

<br>
<br>
Your GCCS Divisional Administrator will contact you within 24 hours to follow-up to document the exception for proper internal control and audit purposes.  Should you have any exceptions to this document during the year, please contact your GCCS Divisional Administrator.

<br>
<br>
Thanks,
<br>
GCCS Global Administrator
<br>


<br>
<TABLE>
<TR>
<TD >
<form action="http://www.google.com" method="get"> <input type="submit" value="CONFIRM"/></form>
<TD>

<TD >
<form action="http://www.yahoo.com" method="get""> <input type="submit" value="EXCEPTION"/></form>
<TD>
</TR>
</TABLE>
<br>
</BODY>

</HTML>


    */

    public static Integer ADMINROLE_LOCKED = new Integer(6);
    public static Integer ADMINROLE = new Integer(5);
    public static Integer OPSMANAGERROLE = new Integer(3);
    public static Integer OPSCONTROLLERROLE = new Integer(4);
    public static Integer COUNTRYADMIN = new Integer(7);
    public static Integer FINCONTROLLER = new Integer(8);
    public static Integer USERENABLED = new Integer(4); //New status since GCCS 3.4 LDAP password
    public static Integer USERDISABLED = new Integer(3); //New status since GCCS 3.4 LDAP password
    public static Integer PROCESSFILE = new Integer(2);
    public static Integer USERLOCKED = new Integer(1);
    public static Integer USERUNLOCKED = new Integer(0);
    


    public static final int DISABLEDUSER = 3; //New status since GCCS 3.4 LDAP password
    public static final int REVOKEDUSER = 2;
    public static final int ACTIVEUSER = 1;
    public static final int ROWSBYPAGEADMIN = 50;

    public static final String EMAILADDRTASKS = "cristian.cardenas@fedex.com";

    //Comments for not Prepaid Discrepancies
    public static final String[] PRPCOMNOTDSCR = {"XMPT", "GOVT", "EMBAS", "VOID", "DSTR", "PRED", "THFT"};

    /**
     * ***Validation White List Separator*****
     */
    public static String REG_EXP_SEPARATOR = "~";

    public static final String WLUSER="jndi_user";
    public static final String WLPWD="weblogic";


    public static final int notFoundCode = 1403; // oracle not found code.
}
