package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.SystemUtilsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.controller.EmployeeController;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;

/**
 * @author clazo
 */
public class ValidateUsersByQuarterWSSO implements Job {
    public ValidateUsersByQuarterWSSO() {
    }

    //This method will check the list of users every quarter to:
    // 1. Report users using the system
    // 2. Report users not usign the system for more than 90 days
    // 3. Report users not usign the system for more than 1 year
    // 4. Inactivate users not usign the system for more than 90 days
    // 5. Delete users not listed in LDAP
    // 6. Delete users not using the system for more than 1 year or in state REVOKED

public void executeNew() throws Exception{
	try{
		System.out.println("***aaaaaaaa");
        AdminBizDelegate admin = new AdminBizDelegate();
        System.out.println("***bbbbbbbbbbb");
        SystemUtilsBizDelegate sysUtils = new SystemUtilsBizDelegate();
        System.out.println("***cccccccccc");
        EmployeeController ctrlEmployee = new EmployeeController();
        System.out.println("***ddddddddddd");
        Integer empStatusCd=2;
		// Get all employees recorded in GCCS
        Collection users = ctrlEmployee.getAllEmployees();
        System.out.println("***inside here users eeeeeeee= "+users.size());
    
        // This collection will have fedex employees that must be informed to managers
        Collection fedexEmployees = new ArrayList();
        Collection deletedUsers = new ArrayList();
        Collection disabledUsers = new ArrayList();

//For testing purposes
//WARNING

        users.add(ctrlEmployee.getEmployee("609358"));

//END WARNING

        Iterator userIt = users.iterator();
        EmployeeVO emp;
        Date disabledUserDate;
        Date activeUserDate;
        int i = 0;
        //Evaluate if exist the employee in LDAP
        while (userIt.hasNext()) {
            Constants.logger.debug("*** validating userssssssssss("+ i++ + "/"+users.size()+")");
            System.out.println("*** validating users("+ i++ + "/"+users.size()+")");
            emp = (EmployeeVO) userIt.next();

            System.out.println("emp.getEmployeeId()"+emp.getEmployeeId());
            
            Collection employees = sysUtils.findUsers(emp.getEmployeeId());
            
            System.out.println("*** employeessize.."+employees.size());
            
            //Iterator itFedex = employees.iterator();
            if (employees.size() == 0) { // && emp.getEmpStatusCd() != Constants.REVOKEDUSER) {
                admin.deleteUserPermanently(emp.getEmployeeId()); //delete employee from GCCS

            }else{
            	System.out.println("in else");
                Calendar todayCal = Calendar.getInstance();
                switch(emp.getEmpStatusCd()){
                    case Constants.REVOKEDUSER :
                                                deletedUsers.add(emp);
                                                admin.deleteUserPermanently(emp.getEmployeeId());
                                                break;

                    case Constants.DISABLEDUSER :
                                                Calendar lastLoginCalPlusOneYear = Calendar.getInstance();
                                                disabledUserDate = emp.getPwdDate();
                                                if (disabledUserDate==null)
                                                    continue; //Data error, not possible

                                                lastLoginCalPlusOneYear.setTime(disabledUserDate);
                                                lastLoginCalPlusOneYear.add(Calendar.YEAR,1);

                                                if(todayCal.after(lastLoginCalPlusOneYear)){ //User disabled for more than 1 year
                                                     deletedUsers.add(emp);
                                                     admin.deleteUserPermanently(emp.getEmployeeId());
                                                } else {
                                                    disabledUsers.add(emp);
                                                }
                                                break;

                    case Constants.ACTIVEUSER :
                                                Calendar lastLoginCalPlusThreeMonths = Calendar.getInstance();
                                                activeUserDate = emp.getPwdDate();
                                                if (activeUserDate!=null)
                                                    lastLoginCalPlusThreeMonths.setTime(activeUserDate);
                                                else
                                                    lastLoginCalPlusThreeMonths.setTime(new Date());
                                                
                                                lastLoginCalPlusThreeMonths.add(Calendar.MONTH,3);

                                                if(todayCal.after(lastLoginCalPlusThreeMonths)){ //User inactive for more than 3 months
                                                    disabledUsers.add(emp);
                                                    admin.disableUser(emp.getEmployeeId());
                                                } else {
                                                    fedexEmployees.add(emp);
                                                }
                                                break;
                    default: //Users added automatically - not important to inform managers
                        Constants.logger.debug("*** validating users EMPLOYEE wrong data [" + emp.getEmployeeId() + "]");
                        System.out.println("*** validating users EMPLOYEE wrong data [" + emp.getEmployeeId() + "]");

                }
            }
        }
                
        // Employees are reported to Manager by email //

         if(fedexEmployees != null && fedexEmployees.size() > 0) {
        	 System.out.println("fedexEmployees not null 111");
             ManagersMail mm = new  ManagersMail();
             Map fedEmps = mm.getManagersEmployees(fedexEmployees);
             mm.initMailText("M");
             Iterator iterKeys = fedEmps.keySet().iterator();
             while (iterKeys.hasNext()) {
                 String currentKey = (String) iterKeys.next();
                 System.out.println("fedexEmployees not null");
                 mm.sendMail(currentKey, (Collection) fedEmps.get(currentKey));
             }
         }

         if(disabledUsers!= null && disabledUsers.size() > 0) {
        	 System.out.println("disabledUsers not null 1111");
             ManagersMail mm = new  ManagersMail();
             Map disEmps = mm.getManagersEmployees(disabledUsers);
             mm.initMailText("D");
             Iterator iterKeys = disEmps.keySet().iterator();
             while (iterKeys.hasNext()) {
                 String currentKey = (String) iterKeys.next();
                 System.out.println("disabledUsers not null");
                 //mm.sendMail(currentKey, (Collection) disEmps.get(currentKey));
             }
         }

         if(deletedUsers != null && deletedUsers.size() > 0) {
        	 System.out.println("deletedUsers not null 1111");
             ManagersMail mm = new  ManagersMail();
             Map delEmps = mm.getManagersEmployees(deletedUsers);
             mm.initMailText("T");
             Iterator iterKeys = delEmps.keySet().iterator();
             while (iterKeys.hasNext()) {
                 String currentKey = (String) iterKeys.next();
                 System.out.println("deletedUsers not null");
                 //mm.sendMail(currentKey, (Collection) delEmps.get(currentKey));
             }
         }
         

         System.out.println("\n *** Validation of Users from GCCS ran well. *** ");        
        
	}catch(Exception e){
          System.out.println("\n\n Exception in Validation of Users from GCCS, Details : \n " + Utils.stackTraceToString(e));
		
	}
	
}



    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
        	System.out.println("***111111");
            AdminBizDelegate admin = new AdminBizDelegate();
            System.out.println("***22222");
            SystemUtilsBizDelegate sysUtils = new SystemUtilsBizDelegate();
            System.out.println("***333333");
            EmployeeController ctrlEmployee = new EmployeeController();
            System.out.println("***4444444");
            Integer empStatusCd=2;
			// Get all employees recorded in GCCS
            Collection users = ctrlEmployee.getAllEmployees();
            System.out.println("***inside here users= "+users.size());
            //Collection users=new ArrayList(); //For testing purposes

            // This collection will have fedex employees that must be informed to managers
            Collection fedexEmployees = new ArrayList();
            Collection deletedUsers = new ArrayList();
            Collection disabledUsers = new ArrayList();

//For testing purposes
// WARNING

            users.add(ctrlEmployee.getEmployee("609358"));

//END WARNING

            Iterator userIt = users.iterator();
            EmployeeVO emp;
            Date disabledUserDate;
            Date activeUserDate;
            int i = 0;
            //Evaluate if exist the employee in LDAP
            while (userIt.hasNext()) {                
                
                System.out.println("*** validating users("+ i++ + "/"+users.size()+")");
                emp = (EmployeeVO) userIt.next();

                Collection employees = sysUtils.findUsers(emp.getEmployeeId());
                
                System.out.println("emp.getEmployeeId()"+emp.getEmployeeId());
                //Iterator itFedex = employees.iterator();
                if (employees.size() == 0) { // && emp.getEmpStatusCd() != Constants.REVOKEDUSER) {
                    admin.deleteUserPermanently(emp.getEmployeeId()); //delete employee from GCCS

                }else{
                	System.out.println("in else old execute");
                    Calendar todayCal = Calendar.getInstance();
                    switch(emp.getEmpStatusCd()){
                        case Constants.REVOKEDUSER :
                                                    deletedUsers.add(emp);
                                                    admin.deleteUserPermanently(emp.getEmployeeId());
                                                    break;

                        case Constants.DISABLEDUSER :
                                                    Calendar lastLoginCalPlusOneYear = Calendar.getInstance();
                                                    disabledUserDate = emp.getPwdDate();
                                                    if (disabledUserDate==null)
                                                        continue; //Data error, not possible

                                                    lastLoginCalPlusOneYear.setTime(disabledUserDate);
                                                    lastLoginCalPlusOneYear.add(Calendar.YEAR,1);

                                                    if(todayCal.after(lastLoginCalPlusOneYear)){ //User disabled for more than 1 year
                                                         deletedUsers.add(emp);
                                                         admin.deleteUserPermanently(emp.getEmployeeId());
                                                    } else {
                                                        disabledUsers.add(emp);
                                                    }
                                                    break;

                        case Constants.ACTIVEUSER :
                                                    Calendar lastLoginCalPlusThreeMonths = Calendar.getInstance();
                                                    activeUserDate = emp.getPwdDate();
                                                    if (activeUserDate!=null)
                                                        lastLoginCalPlusThreeMonths.setTime(activeUserDate);
                                                    else
                                                        lastLoginCalPlusThreeMonths.setTime(new Date());
                                                    
                                                    lastLoginCalPlusThreeMonths.add(Calendar.MONTH,3);

                                                    if(todayCal.after(lastLoginCalPlusThreeMonths)){ //User inactive for more than 3 months
                                                        disabledUsers.add(emp);
                                                        admin.disableUser(emp.getEmployeeId());
                                                    } else {
                                                        fedexEmployees.add(emp);
                                                    }
                                                    break;
                        default: //Users added automatically - not important to inform managers
                            Constants.logger.debug("*** validating users EMPLOYEE wrong data [" + emp.getEmployeeId() + "]");
                            System.out.println("*** validating users EMPLOYEE wrong data [" + emp.getEmployeeId() + "]");

                    }
                }
            }

            Constants.logger.debug("\n *** Nro. de empleados para validar por country admin = " + fedexEmployees.size());

            // Employees are reported to Manager by email //

            if(fedexEmployees != null && fedexEmployees.size() > 0) {
            	System.out.println("fedexEmployees not null jjj");
                ManagersMail mm = new  ManagersMail();
                Map fedEmps = mm.getManagersEmployees(fedexEmployees);
                mm.initMailText("M");
                Iterator iterKeys = fedEmps.keySet().iterator();
                while (iterKeys.hasNext()) {
                    String currentKey = (String) iterKeys.next();
                    mm.sendMail(currentKey, (Collection) fedEmps.get(currentKey));
                }
            }

            if(disabledUsers!= null && disabledUsers.size() > 0) {
                ManagersMail mm = new  ManagersMail();
                Map disEmps = mm.getManagersEmployees(disabledUsers);
                mm.initMailText("D");
                Iterator iterKeys = disEmps.keySet().iterator();
                while (iterKeys.hasNext()) {
                    String currentKey = (String) iterKeys.next();
                    mm.sendMail(currentKey, (Collection) disEmps.get(currentKey));
                }
            }

            if(deletedUsers != null && deletedUsers.size() > 0) {
                ManagersMail mm = new  ManagersMail();
                Map delEmps = mm.getManagersEmployees(deletedUsers);
                mm.initMailText("T");
                Iterator iterKeys = delEmps.keySet().iterator();
                while (iterKeys.hasNext()) {
                    String currentKey = (String) iterKeys.next();
                    mm.sendMail(currentKey, (Collection) delEmps.get(currentKey));
                }
            }
            

            Constants.logger.debug("\n *** Validation of Users from GCCS ran well. *** ");
            System.out.println("\n *** Validation of Users from GCCS ran well. *** ");

        }catch (Exception e) {
            Constants.logger.debug("\n\n Exception in Validation of Users from GCCS, Details : \n " + Utils.stackTraceToString(e));
            System.out.println("\n\n Exception in Validation of Users from GCCS, Details : \n " + Utils.stackTraceToString(e));
        }
    }
}
