/*
 * InCageExceptionsRunnable.java
 *
 * Created on 20 de diciembre de 2002, 16:02
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.oro.text.perl.Perl5Util;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.FedExEmployee;
import com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;
import com.fedex.lacitd.cashcontrol.biztier.facades.SystemUtilsBean;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.dao.AdminDao;
import com.fedex.lacitd.cashcontrol.datatier.dao.AdminDaoHome;
import com.fedex.lacitd.cashcontrol.datatier.exception.DAOException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;


/**
 * @author ccardenas
 */
public class ManagersMail implements Serializable {
    public String mailText;

    public Map getCountryAdminEmployees(Collection extEmp) {
        InitialContext ic = null;
        Map countryAdminEmp = new HashMap();
        try {
            Collection employees = getEmpRoleLocations(extEmp);
            EmpRolesLocs currentEmp = null;
            ///////////////////////////////////////////////////////
            // Getting employee's country admin
            ///////////////////////////////////////////////////////
            ic = new InitialContext();
            AdminDaoHome adminBizhome = (AdminDaoHome) ic.lookup(Constants.AdminDaoEJB_Remote);
            AdminDao adminBiz = adminBizhome.create();
            Iterator iterEmps = employees.iterator();
            while (iterEmps.hasNext()) {
                currentEmp = (EmpRolesLocs) iterEmps.next();
                Collection ca = adminBiz.getCountryAdminByEmployeeId(currentEmp.getEmployeeId());
                Iterator itCa = ca.iterator();
                while (itCa.hasNext()) {
                    EmployeeVO employeeVO = (EmployeeVO) itCa.next();
                    if (countryAdminEmp.get(employeeVO.getEmployeeId()) != null) {
                        Collection emps = (Collection) countryAdminEmp.get(employeeVO.getEmployeeId());
                        emps.add(currentEmp);
                        countryAdminEmp.put(employeeVO.getEmployeeId(), emps);
                    }
                    else if (countryAdminEmp.get(employeeVO.getEmployeeId()) == null) {
                        Collection emps = new ArrayList();
                        emps.add(currentEmp);
                        countryAdminEmp.put(employeeVO.getEmployeeId(), emps);
                    }
                }
            }
        }
        catch (NamingException e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }
        catch(CreateException e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }
        catch (RemoteException e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }
        catch (DAOException e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }
        catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }

        return countryAdminEmp;
    }

    public Map getManagersEmployees(Collection extEmp) {
        Map manEmp = new HashMap();
        try {
            Collection employees = getEmpRoleLocations(extEmp);
            String lastEmp = "nn";
            EmpRolesLocs currentEmp = null;
   	   	    String manId=null;
   	        SystemUtilsBean sub=new SystemUtilsBean();
   	        Iterator iterEmps=employees.iterator();
            Perl5Util perl = new Perl5Util();
   	        while(iterEmps.hasNext()) {
   	    	    currentEmp=(EmpRolesLocs)iterEmps.next();
   	    	    if(lastEmp!=null && !lastEmp.equals(currentEmp.getEmployeeId())) {
   	    	        Iterator iterEmp=sub.findUsers(currentEmp.getEmployeeId()).iterator();
   	    		    if(iterEmp.hasNext()) {
   	    			    FedExEmployee fe=(FedExEmployee)iterEmp.next();
					    manId=fe.get(FedExEmployee.MANAGER).trim();
                        manId = perl.substitute("s/uid=//",manId);
                        manId = perl.substitute("s/,.*$//",manId);
                    }
                }

   	    	    if(manId!=null && manEmp.get(manId)!=null) {
   	    		    Collection col=(Collection)manEmp.get(manId);
   	    		    col.add(currentEmp);
   	    	    }
                else {
   	    		    Collection col=new ArrayList();
   	    		    col.add(currentEmp);
   	    		    manEmp.put(manId,col);
   	    	    }
   	        }
   	    }
        catch (FacadeException e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }
        catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }

        return manEmp;
    }

    public void initMailText(String type) {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("<meta http-equiv='Content-Language' content='es'>\n");
        sb.append("<meta name='GENERATOR' content='Microsoft FrontPage 5.0'>\n");
        sb.append("  <meta name='ProgId' content='FrontPage.Editor.Document'>\n");
        sb.append(" <meta http-equiv='Content-Type' content='text/html; charset=windows-1252'>\n");
        sb.append(" <title>In order to strengthen security controls</title>\n");
        sb.append(" </head>\n");
        sb.append(" <body>\n");

        if("C".equals(type)){
            sb.append(" <p><font face='Arial'>In order to strengthen security controls, we are asking \n");
            sb.append(" country administrators to confirm that the individuals in their department with \n");
            sb.append(" Global Cash Control access still require that access in order to perform their functions.\n");
            sb.append(" The individuals in your department with access to the Global Cash Control System \n");
            sb.append(" may have various levels of access. This access may be for query only or it may include \n");
            sb.append(" update and/or maintenance capabilities. \n");

        }else if("M".equals(type)){
            sb.append(" <p><font face='Arial'>In order to strengthen security controls, we are asking \n");
            sb.append(" managers to confirm that the individuals in their department with Global Cash Control \n");
            sb.append(" access still require that access in order to perform their functions. The individuals \n");
            sb.append(" in your department with access to the Global Cash Control System may have various \n");
            sb.append(" levels of access. This access may be for query only or it may include update and/or \n");
            sb.append(" maintenance capabilities. \n");

        }else if("D".equals(type)){ //Users disabled
            sb.append(" <p><font face='Arial'>In order to strengthen security controls, we have included a list \n");
            sb.append(" of users that has been disabled from the system due to 90 days of inactivity.\n");
            sb.append("   The individuals in your department with access to the Global Cash Control Access \n");
            sb.append(" may have various levels of access. This access may be for query only or it may \n");
            sb.append(" include update and/or maintenance capabilities. <br>\n");

        }else if("T".equals(type)){ //Users deleted "Terminated"
            sb.append(" <p><font face='Arial'>In order to strengthen security controls, we have included a list \n");
            sb.append(" of users that has been deleted due to one year inactivity.");
            sb.append("   The individuals in your department with access to the Global Cash Control Access \n");
            sb.append(" may have various levels of access. This access may be for query only or it may \n");
            sb.append(" include update and/or maintenance capabilities. <br>\n");

        }
        sb.append("   <br>\n");

        sb.append("   For your convenience, we have included a roster and the various roles each employee has. Please \n");
        sb.append("   review with your employees their level of access to determine if it is correct for their job function.\n");
        sb.append("   Then submit a Regional (APAC, LAC, CAN) Help Request to positively confirm that their current access \n");
        sb.append("   is acceptable. If their security access requires modification, you may request changes also through \n");
        sb.append("   a Help Request. Please see the GCCSSUP site for links to your respective Regional Help system. Please \n");
        sb.append("   be sure to do this operation as soon as possible. \n");

        sb.append("   Should you have any questions please contact your GCCS Country Administrator. </font></p>\n");

        sb.append("    <table border='1' cellpadding='0' cellspacing='0' style='border-collapse: collapse' bordercolor='#111111' width='100%' id='AutoNumber1'>\n");
        sb.append("       <tr>\n");

        sb.append("         <td width='12%' bgcolor='#C0C0C0' align='center'><font face='Arial'>Employee\n");
        sb.append("         Id</font></td>\n");
        sb.append("        <td width='31%' bgcolor='#C0C0C0' align='center'><font face='Arial'>Name</font></td>\n");
        sb.append("        <td width='12%' bgcolor='#C0C0C0' align='center'><font face='Arial'>Date Last Login (MM/dd/yyyy)</font></td>\n");
        sb.append("        <td width='17%' bgcolor='#C0C0C0' align='center'><font face='Arial'>Role(*)</font></td>\n");
        sb.append("         <td width='28%' bgcolor='#C0C0C0' align='center'><font face='Arial'>\n");
        sb.append("         Locations</font></td>\n");
        sb.append("      </tr>\n");

        mailText = sb.toString();
    }


    public void sendMail(String manager, Collection emps) throws Exception {
        try {
            EmailSender1 mail = new EmailSender1();
            mail.setPersonalName(Constants.FROMADDRESS);

            SystemUtilsBean sub = new SystemUtilsBean();
            String to = null;
            Iterator iterEmp = sub.findUsers(manager).iterator();
            if (iterEmp.hasNext()) {
                FedExEmployee fe = (FedExEmployee) iterEmp.next();
                to = fe.get(FedExEmployee.MAIL);
            }
            Constants.logger.debug("Mail to: " + to);
            System.out.println("Mail to: " + to);

            if("YES".equals(Utils.getProperties("P").getProperty("VALID_USER_DEV")))
                to = "jeena.paul@fedex.com";

            HashMap emails = new HashMap();
            emails.put("Subject:","Confirmation of GCCS Access");
            emails.put("Body:",mailText+createDynamicMailText(emps));
            emails.put("TO:",to);
            emails.put("MIMETYPE:","text/html");
            mail.setEmails(emails);
            mail.send();
        }
        catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        }
    }

    public String createDynamicMailText(Collection col) {
        StringBuffer sb = new StringBuffer();
        Iterator iter = col.iterator();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String employeePwSinceDtString;
        while (iter.hasNext()) {
            EmpRolesLocs erl = (EmpRolesLocs) iter.next();
            employeePwSinceDtString = (erl.getEmployeePwSinceDt() != null)?df.format(erl.getEmployeePwSinceDt()):"&nbsp;";
            sb.append("      <tr>\n");
            sb.append("          <td width='12%'><font face='Arial'>" + erl.getEmployeeId() + "</td>\n");
            sb.append("          <td width='31%'><font face='Arial'>" + erl.getEmployeeNm() + "</td>\n");
            sb.append("          <td width='12%' align='center'><font face='Arial'>" + employeePwSinceDtString + "</td>\n");
            sb.append("          <td width='17%' align='center'><font face='Arial'>" + erl.getRole() + "</td>\n");
            sb.append("          <td width='28%'><font face='Arial'>" + erl.getLocs() + "</td>\n");
            sb.append("      </tr>\n");
        }

        sb.append("    </table>\n");
        sb.append(" <p><font face='Arial'>");
        sb.append("(*) Role Descriptions<br>");
        sb.append("Check-In Agent - Checks monies  and updates GCCS<br>");
        sb.append("Operation Manager - Checks monies, prepares deposits, updates GCCS, reviews reports<br>");
        sb.append("Controller - Report review<br>");
        sb.append("Country Admin - Updates users, updates location information for specific countries<br>");
        sb.append("Administrator - Updates users, updates location information<br>");
        sb.append("    </body>\n");
        sb.append("   </html>  \n");

        return sb.toString();
    }

    public Collection getEmpRoleLocations(Collection extEmp) {
        InitialContext ic = null;
        DataSource ds = null;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Collection employees = new ArrayList();
        try {
            ic = new InitialContext();
            ds = (DataSource) ic.lookup(Constants.CCSDataSource);
            con = ds.getConnection();
            Perl5Util perl = new Perl5Util();

            StringBuffer condition = new StringBuffer("");
            Iterator it = extEmp.iterator();
            int i = 0;

            String lastEmp = "nn";
            String lastRole = "nn";
            EmpRolesLocs currentEmp = null;

            while (it.hasNext()) {
                EmployeeVO employeeVO = (EmployeeVO) it.next();
                if (i < 500) {
                    condition.append("'" + employeeVO.getEmployeeId() + "',");
                    i++;
                } else {
                    condition = new StringBuffer(perl.substitute("s/,$//", condition.toString()));
                    String query = "SELECT e.EMP_ID_NBR, " +
                            "e.EMP_NM,r.ROLE_NM, " +
                            "r.ROLE_DESC, " +
                            "elr.LOC_CD, " +
                            "e.PW_SINCE_DT " +
                            "FROM EMP_X_LOCATION_X_ROLE elr, " +
                            "EMPLOYEE e, " +
                            "ROLE r " +
                            "WHERE elr.EMP_ID_NBR=e.EMP_ID_NBR AND " +
                            "elr.ROLE_ID_NBR=r.ROLE_ID_NBR AND " +
                            "elr.EMP_ID_NBR in (" + condition.toString() + ") " +
                            "ORDER BY e.EMP_ID_NBR,e.EMP_NM,r.ROLE_NM,elr.LOC_CD";

                    Constants.logger.debug("*** ManagersMail SQL to process:" + query);

                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);
                    java.sql.Date employeePwSinceDt;
                    while (rs.next()) {
                        if ((lastEmp != null && !lastEmp.equals(rs.getString("emp_id_nbr"))) ||
                                (lastRole != null && !lastRole.equals(rs.getString("role_nm")))) {
                            currentEmp = new EmpRolesLocs();
                            currentEmp.setEmployeeId(rs.getString("emp_id_nbr"));
                            currentEmp.setEmployeeNm(rs.getString("emp_nm"));
                            currentEmp.setRole(rs.getString("role_nm"));
                            currentEmp.setLocs(rs.getString("loc_cd"));
                            employeePwSinceDt=rs.getDate("pw_since_dt");
                            if(employeePwSinceDt!=null)//Only set when Date comes
                                currentEmp.setEmployeePwSinceDt(new java.util.Date(employeePwSinceDt.getTime()));
                            employees.add(currentEmp);
                        } else {
                            currentEmp.setLocs(currentEmp.getLocs() + ", " + rs.getString("loc_cd"));
                        }
                        lastEmp = currentEmp.getEmployeeId();
                        lastRole = currentEmp.getRole();
                    }
                    condition = new StringBuffer("");
                    i = 0;
                }
            }

            /////////////////////////////////////////////
            // If there are more employees not processed
            /////////////////////////////////////////////

            if (i > 0) {
                condition = new StringBuffer(perl.substitute("s/,$//", condition.toString()));
                String query = "SELECT e.EMP_ID_NBR, " +
                        "e.EMP_NM,r.ROLE_NM, " +
                        "r.ROLE_DESC, " +
                        "elr.LOC_CD, " +
                        "e.PW_SINCE_DT " +
                        "FROM EMP_X_LOCATION_X_ROLE elr, " +
                        "EMPLOYEE e, " +
                        "ROLE r " +
                        "WHERE elr.EMP_ID_NBR=e.EMP_ID_NBR AND " +
                        "elr.ROLE_ID_NBR=r.ROLE_ID_NBR AND " +
                        "elr.EMP_ID_NBR in (" + condition.toString() + ") " +
                        "ORDER BY e.EMP_ID_NBR,e.EMP_NM,r.ROLE_NM,elr.LOC_CD";

                Constants.logger.debug("*** ManagersMail SQL to process:" + query);                

                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                java.sql.Date employeePwSinceDt;

                while (rs.next()) {
                    if ((lastEmp != null && !lastEmp.equals(rs.getString("emp_id_nbr"))) ||
                            (lastRole != null && !lastRole.equals(rs.getString("role_nm")))) {
                        currentEmp = new EmpRolesLocs();
                        currentEmp.setEmployeeId(rs.getString("emp_id_nbr"));
                        currentEmp.setEmployeeNm(rs.getString("emp_nm"));
                        currentEmp.setRole(rs.getString("role_nm"));
                        currentEmp.setLocs(rs.getString("loc_cd"));
                        employeePwSinceDt=rs.getDate("pw_since_dt");
                        if(employeePwSinceDt!=null)//Only set when Date comes
                            currentEmp.setEmployeePwSinceDt(new java.util.Date(employeePwSinceDt.getTime()));
                        employees.add(currentEmp);
                    } else {
                        currentEmp.setLocs(currentEmp.getLocs() + ", " + rs.getString("loc_cd"));
                    }
                    lastEmp = currentEmp.getEmployeeId();
                    lastRole = currentEmp.getRole();
                }
                i = 0;
                condition = new StringBuffer("");
            }
        } catch (SQLException sqle) {
            Constants.logger.debug(Utils.stackTraceToString(sqle));
        } catch (NamingException ne) {
            Constants.logger.debug(Utils.stackTraceToString(ne));
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {

                }
            }
            if(con !=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return employees;
    }
}