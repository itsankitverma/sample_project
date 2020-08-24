/**
 * 
 * EmailSender.java
 *
 * Created on 9 de diciembre de 2003, 11:12
 *
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;
//MMMMMM
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.oro.text.perl.Perl5Util;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.SystemUtilsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.FedExEmployee;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;

//To use Regular expressions

/**
 * @author Arturo Gonzalez
 */
public class EmailSender1 implements java.io.Serializable {

    /* Email List */
    private HashMap emails;
    /* Email To Adrress*/
    
    /* Destiny of the message */
    private String to;

    /* subject of the message */
    private String subject;

    /* body of the message */
    private String body;

    /* Other Destiny of message */
    private String cc;

    private InitialContext ic = null;
    private Session session = null;

    private InternetAddress internetAddress = null;
    private String personalName;
    private String mimeType;

    /* Business Delegate */
    SystemUtilsBizDelegate sysUtils = new SystemUtilsBizDelegate();
    AdminBizDelegate adminBizDelegate = new AdminBizDelegate();

    /**
     * Creates a new instance of EmailSender
     */
    public EmailSender1() {
        init();
    }

    /* Initialize email sender class */
    private void init() {
        try {
            ic = new InitialContext();
            setSession((Session) ic.lookup(Constants.MAILSession));
            internetAddress = InternetAddress.getLocalAddress(getSession());
        } catch (NamingException ne) {
            Constants.logger.debug(Utils.stackTraceToString(ne));
        }
    }

    public void setEmails(HashMap emails) {
        this.emails = emails;
    }

    public HashMap getEmails() {
        return this.emails;
    }

    public InternetAddress getInternetAddress() {
        return this.internetAddress;
    }

    public void setPersonalName(String name) throws UnsupportedEncodingException {
        internetAddress.setPersonal(name);
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * This method send the email message to the receivers
     */
    public void send() {
        try {
            if (emails.size() == 0) {
                return;                                  
            }

            //Gets TO: and Subject: and Body:
            to = (String) emails.get("TO:");
            cc = (String) emails.get("CC:");
            subject = (String) emails.get("Subject:");
            body = (String) emails.get("Body:");
            mimeType = (String) emails.get("MIMETYPE:");

            /*
                Constants.logger.debug("\n\n email To: " + to);
                Constants.logger.debug("\n\n email Cc: " + cc);
                Constants.logger.debug("\n\n email Subject: " + subject);
                Constants.logger.debug("\n\n email Body: " + body);
             */

            Message msg = new MimeMessage(getSession());

            String from=getSession().getProperty("mail.app");
	    	msg.setFrom(InternetAddress.parse(from)[0]);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            //Put CC only if it is not null
            if (cc != null) {
                msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));
            }

            msg.setSubject(subject);
            msg.setSentDate(new Date());

            // Content is stored in a MIME multi-part message
            // with one body part
            MimeBodyPart mbp = new MimeBodyPart();
            if("text/html".equals(mimeType))
                mbp.setContent(body, "text/html");
            else
                mbp.setText(body);
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp);
            msg.setContent(mp);


            //Send the message.
            Transport.send(msg);
        } catch (MessagingException me) {
            Constants.logger.debug(Utils.stackTraceToString(me));
        }
    }


    /**
     * This method select what kind of email will be send: to the administrator, password changed, etc..
     *
     * @param Integer selectTo
     * @param String  employee Id
     * @return HashMap emails data
     * @throws Exception
     */
    public HashMap selectEmail(Integer selectTo, String parameter1, HttpServletRequest request, String parameter2) throws BizDelegateException, Exception {
        HashMap emails = new HashMap();
        String to = "";
        String body = "";
        Perl5Util perl = new Perl5Util();
        FedExEmployee employee = null;

        if (!(selectTo==null || Constants.PROCESSFILE.equals(selectTo))) {
            try {
                //Search User Data from fedex ldap storage
                Collection employees = sysUtils.findUsers(parameter1);
                Iterator itFedex = employees.iterator();
                if (itFedex.hasNext()) {
                    employee = (FedExEmployee) itFedex.next();
                }
            } catch (Exception e) {
            }

            if (employee == null) {
                Constants.logger.debug("\n\n ===> User doesn't exist in Fedex Directory yet: " + parameter1);
                return emails;
            }
        }

        try {
            if (Constants.ADMINROLE.equals(selectTo)) {
                Properties prop = getSession().getProperties();

                //First, gets users administrators from database to obtain their email address
                //Collection empByRoles = adminBizDelegate.getEmployeesByRole(Constants.ADMINROLE);
                to = this.getEmailsOfAdministrators(null);

                //Now Body is formatted properly using Regular Expressions
                emails.put("Subject:", Constants.SUBJECT_USER_ENABLED);
                body = Constants.BODY_USER_ENABLED;
                if (perl.match("/fedexId/", body)) {
                    body = perl.substitute("s/fedexId/" + parameter1 + "/", body);
                }
                if (perl.match("/employeeName/", body)) {
                    body = perl.substitute("s/employeeName/" + employee.get(FedExEmployee.FIRST_NAME) + " " + employee.get(FedExEmployee.LAST_NAME) + "/", body);
                }
                if (perl.match("/employeeEmail/", body)) {
                    body = perl.substitute("s/employeeEmail/" + employee.get(FedExEmployee.MAIL) + "/", body);
                }
                if (perl.match("/employeeComat/", body)) {
                    body = perl.substitute("s/employeeComat/" + employee.get(FedExEmployee.COMAT) + "/", body);
                }
                if (perl.match("/employeeCountry/", body)) {
                    body = perl.substitute("s/employeeCountry/" + employee.get(FedExEmployee.COUNTRY_CODE) + "/", body);
                }
                if (perl.match("/employeePhone/", body)) {
                    body = perl.substitute("s/employeePhone/" + employee.get(FedExEmployee.PHONE).replace('/', ' ') + "/", body);
                }
                if (perl.match("/serverType/", body)) {
                    body = perl.substitute("s/serverType/" + prop.getProperty("mail.app") + "/", body);
                }
            } else if (Constants.USERLOCKED.equals(selectTo)) {
                //email for user
                /* Send email to the user also, to notify about the problem with other body*/
                to = employee.get(FedExEmployee.MAIL);
                emails.put("Subject:", Constants.SUBJECT_LOCKED);
                body = Constants.BODY_LOCKED;
                if (perl.match("/fedexId/", body)) {
                    body = perl.substitute("s/fedexId/" + parameter1 + "/", body);
                }
                if (perl.match("/employeeName/", body)) {
                    body = perl.substitute("s/employeeName/" + employee.get(FedExEmployee.FIRST_NAME) + " " + employee.get(FedExEmployee.LAST_NAME) + "/", body);
                }
                if (perl.match("/hostClient/", body)) {
                    body = perl.substitute("s/hostClient/" + request.getRemoteHost() + "/", body);
                }
                if (perl.match("/ipClient/", body)) {
                    body = perl.substitute("s/ipClient/" + request.getRemoteAddr() + "/", body);
                }
            } else if (Constants.USERUNLOCKED.equals(selectTo)) {
                //email for user unlocked
                to = employee.get(FedExEmployee.MAIL);
                emails.put("Subject:", Constants.SUBJECTNEWPASSWORD);
                body = Constants.BODYNEWPASSWORD;
                if (perl.match("/fedexId/", body)) {
                    body = perl.substitute("s/fedexId/" + parameter1 + "/", body);
                }
                if (perl.match("/employeePassword/", body)) {
                    body = perl.substitute("s/employeePassword/" + parameter2 + "/", body);
                }
            } else if (Constants.PROCESSFILE.equals(selectTo)) {
                //email for administrators to alert a problem
                to = this.getEmailsOfAdministrators(parameter2);
                emails.put("Subject:", Constants.SUBJECFILEPROCESS);
                body = Constants.BODYFILEPROCESS;
                if (perl.match("/file/", body)) {
                    body = perl.substitute("s/file/" + parameter1 + "/", body);
                }
                if (perl.match("/country/", body)) {
                    body = perl.substitute("s/country/" + parameter2 + "/", body);
                }

            } else  //Default send an email to all the administrators.
               {    to = this.getEmailsOfAdministrators(null);
                    emails.put("Subject:", parameter1);
                    body = parameter2;
               }
            //Close main if

            emails.put("Body:", body);
            emails.put("TO:", to);
        } catch (BizDelegateException bde) {
            throw bde;
        } catch (Exception e) {
            throw e;
        }

        return emails; //return email data to send email
    }//Close select email


    private String getEmailsOfAdministrators(String country) throws BizDelegateException, Exception {
        //First, gets users administrators from database to obtain their email address
        //Collection empByRoles = adminBizDelegate.getEmployeesByRole(Constants.ADMINROLE);
        String emails = "";
        try {
            Collection adminEmp = adminBizDelegate.getAdminEmployees(country);
            if (adminEmp != null) {
                Iterator itEmp = adminEmp.iterator();
                //Get employee from ldap directory and then get email to concat into "to" variable
                EmployeeVO emp = null;
                while (itEmp.hasNext()) {
                    emp = (EmployeeVO) itEmp.next();
                    //emp = sysUtils.findFedExEmployee(((EmpXLocationXRoleVO)itEmp.next()).getEmployeeId());
                    if(emp.getEmail()!=null){
                        emails = emp.getEmail() + "," + emails;
                    }    
                }//Close while
            }//Close if empByRoles
        } catch (BizDelegateException bde) {
            throw bde;
        } catch (Exception e) {
            throw e;
        }

        return emails;
    }

    /**
     * @return Returns the cc.
     */
    public String getCc() {
        return cc;
    }

    /**
     * @param cc The cc to set.
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getPersonalName() {
        return personalName;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
