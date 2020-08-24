/*
 * InCageExceptionsRunnable.java
 *
 * Created on 20 de diciembre de 2002, 16:02
 */

package com.examples;

import java.sql.*;
import java.util.*;
import java.io.*;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Provider;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.*;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.FedExEmployee;
import com.fedex.lacitd.cashcontrol.biztier.facades.SystemUtilsBean;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;


/**
 *
 * @author  ccardenas
 */
public class ManagersMail implements java.io.Serializable{
	
	public String mailText;

    public static void main (String[] args) throws Exception{
    	ManagersMail mm=new ManagersMail();
    	Map emps=mm.getManagersEmployees();
    	mm.initMailText();
    	
    	Iterator iterKeys=emps.keySet().iterator();
        while(iterKeys.hasNext()){
        	String currentKey=(String)iterKeys.next();
        	 
        	mm.sendMail(currentKey,(Collection)emps.get(currentKey));
        }
   }  
    
   public Map getManagersEmployees() throws Exception{
   		Class.forName("oracle.jdbc.OracleDriver");
   	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@lac-findb01.corp.fedex.com:1522:oradb01","ccs_report","fedexcc");
   	    
   	    Statement stmt=con.createStatement();
   	    ResultSet rs=stmt.executeQuery("SELECT e.EMP_ID_NBR,e.EMP_NM,r.ROLE_NM,r.ROLE_DESC,elr.LOC_CD FROM EMP_X_LOCATION_X_ROLE elr,EMPLOYEE e,ROLE r WHERE elr.EMP_ID_NBR=e.EMP_ID_NBR AND elr.ROLE_ID_NBR=r.ROLE_ID_NBR ORDER BY e.EMP_ID_NBR,e.EMP_NM,r.ROLE_NM,elr.LOC_CD");
   	    String lastEmp="nn";
   	    String lastRole="nn";
   	    Collection employees=new ArrayList();
   	    EmpRolesLocs currentEmp=null;
   	    
   	    while(rs.next()){
   	    	if((lastEmp!=null && !lastEmp.equals(rs.getString("emp_id_nbr"))) ||
   	    	   (lastRole!=null && !lastRole.equals(rs.getString("role_nm")))){
   	    		  currentEmp=new EmpRolesLocs();
   	    		  currentEmp.setEmployeeId(rs.getString("emp_id_nbr"));
   	    		  currentEmp.setEmployeeNm(rs.getString("emp_nm"));
   	    		  currentEmp.setRole(rs.getString("role_nm"));
   	    		  currentEmp.setLocs(rs.getString("loc_cd"));
   	    		  employees.add(currentEmp);
   	    	}else{
   	    		  currentEmp.setLocs(currentEmp.getLocs()+", "+rs.getString("loc_cd"));
   	    	}
   	    	
   	    	lastEmp=currentEmp.getEmployeeId();
   	    	lastRole=currentEmp.getRole();
   	    }	
   	    
   	    lastEmp="nn";
   	   	Map manEmp=new HashMap();  
   	   	String manId=null;
   	    SystemUtilsBean sub=new SystemUtilsBean();   	    
   	    Iterator iterEmps=employees.iterator();   	    
   	    while(iterEmps.hasNext()){
   	    	currentEmp=(EmpRolesLocs)iterEmps.next();
   	    	
   	    	if(lastEmp!=null && !lastEmp.equals(currentEmp.getEmployeeId())){
   	    	    Iterator iterEmp=sub.findUsers(currentEmp.getEmployeeId()).iterator();
   	    		
   	    		if(iterEmp.hasNext()){
   	    			FedExEmployee fe=(FedExEmployee)iterEmp.next();   	    			
					manId=fe.get(FedExEmployee.MANAGER); 
			    	manId=manId.substring(manId.indexOf("uid=")+4);
			    	manId=manId.substring(0,manId.indexOf(","));
                }
            }
   	    
   	    	if(manId!=null && manEmp.get(manId)!=null){
   	    		Collection col=(Collection)manEmp.get(manId);
   	    		col.add(currentEmp);
   	    	}else{
   	    		Collection col=new ArrayList();
   	    		col.add(currentEmp);
   	    		manEmp.put(manId,col);
   	    	}

   	    }
   	    return manEmp;
   }
   
   public void initMailText(){
   	    StringBuffer sb=new StringBuffer();
   	    sb.append("<html>\n");
   	    sb.append("<head>\n");
   	    sb.append("<meta http-equiv='Content-Language' content='es'>\n");
   	    sb.append("<meta name='GENERATOR' content='Microsoft FrontPage 5.0'>\n");
	   	sb.append("  <meta name='ProgId' content='FrontPage.Editor.Document'>\n");
	   	sb.append(" <meta http-equiv='Content-Type' content='text/html; charset=windows-1252'>\n");
	   	sb.append(" <title>In order to strengthen security controls</title>\n");
	   	sb.append(" </head>\n");
	   	sb.append(" <body>\n");
	   	sb.append(" <p><font face='Arial'>In order to strengthen security controls, we are asking\n");
	   	sb.append(" managers to confirm that the individuals in their department with Global Cash \n");
	   	sb.append("  Control access still require that access in order to perform their functions. \n");
	   	sb.append("  The individuals in your department with access to the Global Cash Control Access \n");
	   	sb.append("   may have various levels of access. This access may be for query only or it may \n");
	   	sb.append("   include update and/or maintenance capabilities. <br>\n");
	   	sb.append("   <br>\n");
	   	sb.append("   For your convenience, we have included a roster and the various roles each\n"); 
	   	sb.append("   employee has. Please review with your employees their level of access to \n");
	   	sb.append("   determine if it is correct for their job function. Then submit a LAC HELP \n");
	   	sb.append("    REQUEST, Project: GCCS to positively confirm that the access they have currently is acceptable.\n"); 
	   	sb.append("   If their security access requires modification, you may request changes also \n");
	   	sb.append("    through LAC HELP. Please, be sure to do this operations by Friday, December 3rd.<br>\n");
	   	sb.append("    <br>\n");
	   	sb.append("   <a href='http://lachelp.corp.fedex.com/'>http://lachelp.corp.fedex.com/</a> <br>\n");
	   	sb.append("    <br>\n");
	   	sb.append("    Should you have any questions please contact Joan Whitcomb at 786 388 2881</font></p>\n");
	   	sb.append("    <table border='1' cellpadding='0' cellspacing='0' style='border-collapse: collapse' bordercolor='#111111' width='100%' id='AutoNumber1'>\n");
	   	sb.append("       <tr>\n");
	   	sb.append("         <td width='12%' bgcolor='#C0C0C0' align='center'><font face='Arial'>Employee\n"); 
	   	sb.append("         Id</font></td>\n");
	   	sb.append("        <td width='31%' bgcolor='#C0C0C0' align='center'><font face='Arial'>Name</font></td>\n");
	   	sb.append("        <td width='17%' bgcolor='#C0C0C0' align='center'><font face='Arial'>Role(*)</font></td>\n");
	   	sb.append("         <td width='40%' bgcolor='#C0C0C0' align='center'><font face='Arial'>\n");
	   	sb.append("         Locations</font></td>\n");
	   	sb.append("      </tr>\n");
	   	
	   	mailText=sb.toString();
   }
   
   
   public void sendMail(String manager,Collection emps)throws Exception{
	try{
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.mail.fedex.com");

       Session session1 = Session.getDefaultInstance(props, null);    	
    	
    	SystemUtilsBean sub=new SystemUtilsBean();
String name=null;    	
    	String to=null;
   	    Iterator iterEmp=sub.findUsers(manager).iterator();
   		
   		if(iterEmp.hasNext()){
   			FedExEmployee fe=(FedExEmployee)iterEmp.next();   	    			
			to=fe.get(FedExEmployee.MAIL);
        }
  
		System.out.println("Mail to: "+to);

   		
    	Message msg = new MimeMessage(session1);
    	msg.setFrom(new InternetAddress("gccs@fedex.com"));
    	
    	msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to, false));
    	msg.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("cristian.cardenas@fedex.com", false));    	
    	msg.setSubject("Confirmation of GCCS Access");

    	String body=mailText+createDynamicMailText(emps);
    	msg.setDataHandler(new DataHandler(body, "text/html"));
    	
    	Transport.send(msg);
	}catch(Exception e){
		Constants.logger.debug(Utils.stackTraceToString(e));
	}       
   }
   
   public String createDynamicMailText(Collection col){
   	    StringBuffer sb=new StringBuffer();
   		Iterator iter=col.iterator();   		
   		while(iter.hasNext()){
   			EmpRolesLocs erl=(EmpRolesLocs)iter.next();
		  	sb.append("      <tr>\n");
		  	sb.append("         <td width='12%'><font face='Arial'>"+erl.getEmployeeId()+"</td>\n");
		  	sb.append("        <td width='31%'><font face='Arial'>"+erl.getEmployeeNm()+"</td>\n");
		  	sb.append("       <td width='17%' align='center'><font face='Arial'>"+erl.getRole()+"</td>\n");
		  	sb.append("        <td width='40%'><font face='Arial'>"+erl.getLocs()+"</td>\n");
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
 
}