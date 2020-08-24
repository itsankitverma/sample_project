package com.fedex.lacitd.cashcontrol.biztier.facades;


import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceConstants;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
//import com.fedex.lacitd.cashcontrol.common.ServiceLocator;

import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.dao.AdminDaoLocal;
import com.fedex.lacitd.cashcontrol.datatier.dao.AdminDaoLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.DAOException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;

import javax.ejb.CreateException;
import javax.ejb.EJBException;

import java.util.*;

/**
 * Created Apr 21, 2003 12:27:31 PM
 *
 * @author Arturo Gonzalez
 */


public class AdminFacadeBean implements javax.ejb.SessionBean {
    private javax.ejb.SessionContext context;


    /**
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(javax.ejb.SessionContext aContext) {
        context = aContext;
    }


    /**
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() {

    }


    /**
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() {
    }


    /**
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() {

    }


    /**
     * See section 7.10.3 of the EJB 2.0 specification
     */
    public void ejbCreate() {

    }

    /**
     * This method gets users profiles calling to the method
     * getUserProfileToAdmin of the Session Bean AdminDao
     *
     * @param country_cd
     * @return Collection usersProfiles
     * @throws FacadeException
     */
    public Collection getUserProfileToAdmin(String country_cd, String locCd) throws FacadeException {
        try {
            return getAdminDaoLocal().getUsersProfilesToAdmin(country_cd, locCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getUserProfileToAdmin(country_cd) method from AdminFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }

    }

    public Collection getAllCountry() throws FacadeException {
        Collection countries = null;

        try {
            CountryController coCon = new CountryController();
            countries = coCon.getAllCountry();
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getAllCountry() method from AdminFacadeBean: " + e.toString(), e);
        }
        return countries;
    }

    public void addEmployee(EmployeeVO employee, EmpXLocationXRoleVO empLocRole) //throws FacadeException
    {
        ArrayList locations = new ArrayList();
        EmployeeController employeeController = new EmployeeController();
        LocationController locationController = new LocationController();
        EmpXLocationXRoleController empLocaRoleController = new EmpXLocationXRoleController();

        //Sets employee
        try {
            employeeController.setEmployee(employee);
        } catch (Exception ee) {
        }

        try {
            locationController.addEmployee(empLocRole.getLocationCd(), employee.getEmployeeId());
        } catch (Exception lo) {
            Constants.logger.debug(Utils.stackTraceToString(lo));
        }
    }//Close method addEmployee

    public void updateEmployee(EmployeeVO employee) throws FacadeException {
        EmployeeController employeeController = new EmployeeController();

        try {

            AdminDaoLocal dao = getAdminDaoLocal();

            if (employee.getPassword() != null) {
                employee.setPassword(dao.getCodedPassword(employee.getEmployeeId(), employee.getPassword()));
            } else {
                EmployeeVO empVO = employeeController.getEmployee(employee.getEmployeeId());
                employee.setPassword(empVO.getPassword());
            }
            employeeController.updateEmployee(employee);
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in updateEmployee(employee) method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public void disableUser(String userId) throws FacadeException {
        EmployeeController employeeController = new EmployeeController();

        try {

            AdminDaoLocal dao = getAdminDaoLocal();

            EmployeeVO empVO = employeeController.getEmployee(userId);
            empVO.setEmpStatusCd(Constants.DISABLEDUSER);
            employeeController.updateEmployee(empVO);
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in disableUser(userId) method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public void deleteUser(String userId, String countryCd) throws FacadeException {
        try {
            EmployeeController ec = new EmployeeController();
            Collection locations = ec.getLocations(userId);
            Iterator it = locations.iterator();
            LocationVO locationVO = null;
            while (it.hasNext()) {
                locationVO = (LocationVO) it.next();
                if (locationVO.getCountryCd().equals(countryCd))
                    ec.removeLocation(userId, locationVO.getLocationCd());
            }
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in deleteUser() method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public void deleteUserPermanently(String userId) throws FacadeException {
        try {
            EmployeeController ec = new EmployeeController();
            Collection locations = ec.getLocations(userId);
            Iterator it = locations.iterator();
            LocationVO locationVO = null;
            while (it.hasNext()) {
                locationVO = (LocationVO) it.next();
                ec.removeLocation(userId, locationVO.getLocationCd());
            }

            EmployeeVO empVO = ec.getEmployee(userId); //Since 3.4
            empVO.setEmpStatusCd(0);
            ec.updateEmployee(empVO);

        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in deleteUserPermanently() method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public void deleteLocation(String userId, String locationCd) throws FacadeException {
        try {
            LocationController lc = new LocationController();
            lc.removeEmployee(locationCd, userId);
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in deleteLocation() method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public void deleteRole(String userId, String locationCd, Integer roleId) throws FacadeException {
        try {
            EmpXLocationXRoleController empXLocationXRoleController = new EmpXLocationXRoleController();
            EmpXLocationXRolePK empXLocationXRolePK =
                    new EmpXLocationXRolePK(roleId, locationCd, userId);

            empXLocationXRoleController.removeEmpXLocationXRole(empXLocationXRolePK);

            //Now Check if employee has more roles
            ArrayList allEmpLocRoleByEmp = (ArrayList) empXLocationXRoleController.getEmpXLocationXRoleByEmployeeId(userId);
            Iterator it = allEmpLocRoleByEmp.iterator();

            //If count = 0 it must remove location from "employee location" relation
            EmpXLocationXRoleVO empXLocationXRoleVO = new EmpXLocationXRoleVO();
            int count = 0;
            while (it.hasNext()) {
                empXLocationXRoleVO = (EmpXLocationXRoleVO) it.next();
                if (locationCd.equals(empXLocationXRoleVO.getLocationCd())) {
                    count++;
                }
            }

            if (count == 0) {
                LocationController lc = new LocationController();
                lc.removeEmployee(locationCd, userId);
            }

        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in deleteRole() method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public Collection getLocationsByCountry(String countryCd) throws FacadeException {
        try {
            LocationController locationController = new LocationController();
            return locationController.getLocationByCountryCd(countryCd);
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getLocationsByCountry(countryCd) method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public Collection getAllRoles() throws FacadeException {
        try {
            RoleController roleController = new RoleController();
            return roleController.getAllRoles();
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getAllRoles() method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public EmployeeVO getEmployee(String userId) throws FacadeException {
        try {
            EmployeeController employeeController = new EmployeeController();
            return employeeController.getEmployee(userId);
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getEmployee(userId) method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public void addUser(EmployeeVO employee, EmpXLocationXRoleVO empLocRole) throws FacadeException {
        try {
            getAdminDaoLocal().addUser(employee, empLocRole);
        } catch (DAOException de) {
            throw new FacadeException("Exception ocurred in addUser(EmployeeVO, EmpXLocationXRoleVO) method from AdminFacadeBean: " + de.toString(), de);
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in addUser(EmployeeVO, EmpXLocationXRoleVO) method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public void addLocationRole(EmpXLocationXRoleVO empLocRole) throws FacadeException {
        try {
            //Declare object controller to save Location and Role
            EmpXLocationXRoleController empXLocationXRoleController = new EmpXLocationXRoleController();
            EmployeeController ec = new EmployeeController();
            LocationController lc = new LocationController();

            /** Proccess to save location for the employee **/
            ArrayList locationsOfEmployee = (ArrayList) ec.getLocations(empLocRole.getEmployeeId());
            Iterator itLoc = locationsOfEmployee.iterator();
            LocationVO location = null;
            boolean save = true;

            //Review if location exits for the current employee
            while (itLoc.hasNext()) {
                location = (LocationVO) itLoc.next();
                if (location.getLocationCd().equals(empLocRole.getLocationCd()))
                    save = false;
            }
            //Save location in employee location object
            if (save)
                lc.addEmployee(empLocRole.getLocationCd(), empLocRole.getEmployeeId());
            /** Finish Proccess to save location**/

            /** Proccess to save Role for the current employee and current Role **/
            //Review if exist the combination object empXLocationXRoleController for the current employee
            EmpXLocationXRolePK elrPk = new EmpXLocationXRolePK(empLocRole.getRoleId(), empLocRole.getLocationCd(), empLocRole.getEmployeeId());
            ArrayList rolesOfLocations = (ArrayList) empXLocationXRoleController.getEmpXLocationXRoleByLocationCd(empLocRole.getLocationCd());
            Iterator itRolesLocations = rolesOfLocations.iterator();
            EmpXLocationXRoleVO empExist = null;
            save = true;
            while (itRolesLocations.hasNext()) {
                empExist = (EmpXLocationXRoleVO) itRolesLocations.next();
                if (empExist.getEmployeeId().equals(empLocRole.getEmployeeId())) {
                    if (empExist.getLocationCd().equals(empLocRole.getLocationCd())) {
                        if (empExist.getRoleId().equals(empLocRole.getRoleId()))
                            save = false;
                    }
                }
            }

            //Save Role in object employee location role
            if (save)
                empXLocationXRoleController.setEmpXLocationXRole(empLocRole);
            /** Finish Proccess to save Role **/

        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in addLocationRole(EmpXLocationXRoleVO) method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public Collection getLocationsByCountryEmployee(String country, String userId) throws FacadeException {
        try {
            return getAdminDaoLocal().getUsersProfilesByCountryEmployee(country, userId);
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getLocationsByCountryEmployee method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    /**
     * This method get a Location from Database by its prymary key location cd
     *
     * @param locationCd
     * @return Object LocationVO
     * @throws FacadeException
     */
    public LocationVO getLocation(String locationCd) throws FacadeException {
        LocationController lc = new LocationController();

        try {
            return lc.getLocation(locationCd);
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getLocation method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public void updateLocation(LocationVO location, String inCageFlag, String rihFlag) throws FacadeException {
        LocationController lc = new LocationController();
        TasksController tc = new TasksController();
        try {
            if (inCageFlag == null && location.getInCageTskIdNbr() != 0) {
                tc.removeTasks(new Integer(location.getInCageTskIdNbr()));
                location.setInCageTskIdNbr(0);
            }
            if (rihFlag == null && location.getRihTskIdNbr() != 0) {
                tc.removeTasks(new Integer(location.getRihTskIdNbr()));
                getAdminDaoLocal().setCntryLocsRIHTask(location.getLocationCd(), 0);
                location.setRihTskIdNbr(0);
            }
            lc.updateLocation(location);

        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in updateLocation method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    /**
     * Method to get a TasksVO using EJBX according with a tasks id
     *
     * @param tasksId
     * @return TasksVO
     * @throws FacadeException
     */
    public TasksVO getTasks(Integer tasksId) throws FacadeException {
        TasksController tc = new TasksController();

        try {
            return tc.getTasks(tasksId);
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getTasks method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    /**
     * Method to update or insert a tasks into the tasks table.
     *
     * @param tasks
     * @throws FacadeException
     */
    public void updateTasks(TasksVO tasks) throws FacadeException {

        try {
            if (tasks.getTasksId() == null || tasks.getTasksId().intValue() == 0) {
                ServiceLocator service = ServiceLocator.getInstance();
                //TasksLocalHome taskHome = (TasksLocalHome)service.getEJBLocalHome(ServiceConstants.TASKS_LOCAL_JNDI);
                TasksLocalHome taskHome = (TasksLocalHome) service.getEJBLocalHome("TasksEJB.TasksLocalHome");

                TasksLocal tasklocal = taskHome.create(tasks.getLocationCd(), tasks.getTaskTypeCd(), tasks.getEmailWarning(),
                        tasks.getRunSun(), tasks.getRunSunTime(), tasks.getRunMon(), tasks.getRunMonTime(),
                        tasks.getRunTue(), tasks.getRunTueTime(), tasks.getRunWed(), tasks.getRunWedTime(),
                        tasks.getRunThu(), tasks.getRunThuTime(), tasks.getRunFri(), tasks.getRunFriTime(),
                        tasks.getRunSat(), tasks.getRunSatTime()
                );

                tasks.setTasksId(tasklocal.getTasksId());

            } else {
                TasksController tc = new TasksController();
                tc.updateTasks(tasks);
            }

            getAdminDaoLocal().setCntryLocsRIHTask(tasks.getLocationCd(), tasks.getTasksId().intValue());
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in updateTasks method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public CountryConfigVO getCountryCurrency(String countryCd) throws FacadeException {
        CountryController cc = new CountryController();
        ArrayList countryCurrecies = new ArrayList();
        CountryCurrencyVO countryCurrency = null;
        CountryConfigVO cconf = null;
        try {
            cconf = getAdminDaoLocal().getCountryFlags(countryCd);
            countryCurrecies = (ArrayList) cc.getCountryCurrency(countryCd);

            if (countryCurrecies.size() > 0) {
                countryCurrency = (CountryCurrencyVO) countryCurrecies.get(0);
                cconf.setCntryCurrencyId(countryCurrency.getCntryCurrencyId());
                cconf.setCountryCd(countryCurrency.getCountryCd());
                cconf.setCurrencyCd(countryCurrency.getCurrencyCd());
                cconf.setCurrencyNm(countryCurrency.getCurrencyNm());
                cconf.setCurrencySymbol(countryCurrency.getCurrencySymbol());
                cconf.setCurrencyValidSince(countryCurrency.getCurrencyValidSince());
                cconf.setExchRateMax(countryCurrency.getExchRateMax());
                cconf.setExchRateMin(countryCurrency.getExchRateMin());
            }
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getCountryCurrency method from AdminFacadeBean: " + e.toString(), e);
        }

        return cconf;
    }

    public void updateCountryCurrency(CountryCurrencyVO countryCurrency, String operation) throws FacadeException {
        CountryCurrencyController ccc = new CountryCurrencyController();
        try {
            if (operation.equals("U"))
                ccc.updateCountryCurrency(countryCurrency);
            else
                ccc.setCountryCurrency(countryCurrency);

        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in updateCountryCurrency method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public Collection getAllLocations() throws FacadeException {
        Collection locations = null;

        try {
            LocationController lc = new LocationController();
            locations = lc.getAllLocations();
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getAllLocations() method from AdminFacadeBean: " + e.toString(), e);
        }
        return locations;
    }

    public String getCodedPassword(String employeeId, String password) throws FacadeException {
        try {
            return getAdminDaoLocal().getCodedPassword(employeeId, password);
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getCodedPassword() method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    private AdminDaoLocal getAdminDaoLocal() throws ServiceLocatorException, CreateException {
        AdminDaoLocalHome daoHome = (AdminDaoLocalHome) ServiceLocator.getInstance().getEJBLocalHome(Constants.AdminDaoEJB_Local);
        AdminDaoLocal dao = daoHome.create();
        return dao;
    }

    /**
     * This method gets a Collection of empXLocationXRoleVO objects.
     *
     * @return Collection of EmpXLocationXRoleVO
     * @throws FacadeException
     */
    public Collection getEmployeesByRole(Integer roleId) throws FacadeException {
        try {
            EmpXLocationXRoleController elec = new EmpXLocationXRoleController();
            Collection employees = elec.getEmpXLocationXRoleByRoleId(roleId);
            return employees;
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getEmployeesByRole(Integer roleId)) method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    /**
     * This method gets a Collection of employee objects.
     *
     * @return Collection of Employee
     * @throws FacadeException
     */
    public Collection getAdminEmployees(String countryCd) throws FacadeException {
        try {
            EmployeeController emp = new EmployeeController();
            Collection employees = emp.getEmployeeAdminEmployees();

            if (countryCd != null) {
                Collection countryAdm = emp.getEmployeeCountryAdminEmployees(countryCd);
                employees.addAll(countryAdm);
            }

            return employees;
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in getAdminEmployees() method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    /**
     * This method get a collection of objects to show on the admin bank accounts screen
     *
     * @param country
     * @param location
     * @return Collection of BankAccountLocationVO
     */
    public Collection getBankAccounts(String country, Integer bankId, String location) throws FacadeException {
        Collection bankAccountLocationArray = new ArrayList();

        try {
            BankAccountLocationVO bancc = null;
            BankAccController ctrlBancAcc = new BankAccController();
            BankController ctrlBank = new BankController();
            LocationController ctrlLocation = new LocationController();

            Collection banks = ctrlBank.getBankByCountryCd(country);
            Collection bankAccounts = new ArrayList();
            Collection locs = null;
            HashMap accountsLocation = null;

            Iterator itBanks = banks.iterator();
            Iterator itAccLocation = null;

            BankVO bank = null;
            //Get bank accounts per bank 
            while (itBanks.hasNext()) {
                bancc = new BankAccountLocationVO();
                bank = (BankVO) itBanks.next();

                //Compare if the bank is the asked for bank
                if (!bank.getBankId().equals(bankId) && bankId.intValue() != 0) {
                    continue;
                }

                bankAccounts = ctrlBancAcc.getBankAccByBankId(bank.getBankId());

                //Put the bank and bank accounts into the value object for this operation
                bancc.setBank(bank);
                bancc.setBankAccount(bankAccounts);

                BankAccVO account = null;
                accountsLocation = new HashMap();
                //Get locations where each bank account belong
                itAccLocation = bankAccounts.iterator();
                while (itAccLocation.hasNext()) {
                    account = (BankAccVO) itAccLocation.next();

                    locs = ctrlBancAcc.getLocations(account.getBankAccountCd());
                    Iterator locsIt = locs.iterator();
                    String locationField = "";
                    while (locsIt.hasNext()) {
                        String locCD = ((LocationVO) locsIt.next()).getLocationCd();

                        if ((!location.equals(locCD) && !location.equals("all"))) {
                            continue;
                        }

                        locationField = locCD + " | " + locationField;
                    }
                    accountsLocation.put(account.getBankAccountCd(), locationField);
                }
                //Put the location HashMap into the value object for this operation
                bancc.setAccountLocations(accountsLocation);

                bankAccountLocationArray.add(bancc);
            }
        } catch (Exception e) {
            Utils.stackTraceToString(e);
            throw new FacadeException("Exception ocurred in getBankAccounts() method from AdminFacadeBean: " + e.toString(), e);
        }
        return bankAccountLocationArray;
    }


    /**
     * This method is used to insert a new Bank Account and to save the locations where
     * the account will be useful.
     *
     * @param bankAccount
     * @param locations
     * @throws FacadeException
     */
    public void saveBankAccount(BankAccVO bankAccount, Collection locations) throws FacadeException {
        BankAccController ctrlBankAcc = new BankAccController();
        Integer bankAccCode = null;
        try {
            if (bankAccount.getBankAccountCd() == null)//insert
            {
//              -- Get Bank local interface
                Integer bankId = bankAccount.getBankId();
                BankLocal bankLocal = null;
                if (bankId != null) {
                    bankLocal = getBankLocalHome().findByPrimaryKey(bankId);
                }
                //Insert the bank account
                BankAccLocal bankAccLocal =
                        getBankAccLocalHome().create(bankAccount.getAccountNbr(),
                                bankAccount.getBankBranchId(),
                                bankAccount.getCurrencyType(),
                                bankLocal,
                                bankAccount.getOriginationNbr());

                //Get the code generated
                bankAccCode = bankAccLocal.getBankAccountCd();
                bankAccount.setBankAccountCd(bankAccCode);
                Iterator locIt = locations.iterator();

                while (locIt.hasNext()) {  //Now insert the locations associated with the current bank account
                    ctrlBankAcc.addLocation(bankAccCode, (String) locIt.next());
                }
            } else {//update
                bankAccCode = bankAccount.getBankAccountCd();
                //Update the bank account
                ctrlBankAcc.updateBankAcc(bankAccount);
                //Get iterator for the locations selected
                Iterator locIt = locations.iterator();
                //Get the location that exist associated to the current bmank account
                Collection locationsBefore = ctrlBankAcc.getLocations(bankAccount.getBankAccountCd());
                if (locationsBefore.size() == 0)//if it is 0 then insert locations for the current bank account
                {
                    while (locIt.hasNext()) {
                        ctrlBankAcc.addLocation(bankAccCode, (String) locIt.next());
                    }
                } else {//Now process locations
                    LocationVO locBefore = null;
                    Iterator itLocsBefore = locationsBefore.iterator();
                    //Delete the existing locations
                    while (itLocsBefore.hasNext()) {
                        locBefore = (LocationVO) itLocsBefore.next();
                        ctrlBankAcc.removeLocation(bankAccCode, locBefore.getLocationCd());
                    }
                    //Insert the news locations selected
                    while (locIt.hasNext()) {
                        ctrlBankAcc.addLocation(bankAccCode, (String) locIt.next());
                    }
                }
            }
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in saveBankAccount method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    public void deleteAccount(Integer accountCd) throws FacadeException {
        try {
            BankAccController ctrlAccount = new BankAccController();

            Collection locsAssociated = ctrlAccount.getLocations(accountCd);

            //First delete the Locations associated
            String locationCd = null;
            Iterator it = locsAssociated.iterator();
            while (it.hasNext()) {
                locationCd = ((LocationVO) it.next()).getLocationCd();
                ctrlAccount.removeLocation(accountCd, locationCd);
            }
            //Second delete the Bank Account
            ctrlAccount.removeBankAcc(accountCd);
        } catch (Exception e) {
            throw new FacadeException("Exception ocurred in deleteAccount(Integer accountCd) method from AdminFacadeBean: " + e.toString(), e);
        }
    }

    private BankAccLocalHome getBankAccLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (BankAccLocalHome) service.getEJBLocalHome(ServiceConstants.BANKACC_LOCAL_JNDI);
        } catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankAccLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Bank local home interface
     */
    private BankLocalHome getBankLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (BankLocalHome) service.getEJBLocalHome(ServiceConstants.BANK_LOCAL_JNDI);
        } catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methos is useful to get locations that belong to the countries
     * where employee is country admin
     *
     * @param employeeId
     * @param roleId
     * @return Collection of LocationVO
     * @throws FacadeException
     */
    public Collection getLocationsForAdminCountryRole(String employeeId, Integer roleId) throws FacadeException {
        Collection locationsAdminCountryRole = new ArrayList();
        try {
            LocationController ctrlLocation = new LocationController();
            Collection countriesAdmin = getAdminDaoLocal().getCountriesForAdmin(employeeId, roleId);
            Iterator countriesAdminIt = countriesAdmin.iterator();
            String countryCd = null;
            while (countriesAdminIt.hasNext()) {
                countryCd = ((CountryVO) countriesAdminIt.next()).getCountryCd();
                locationsAdminCountryRole.addAll(ctrlLocation.getLocationByCountryCd(countryCd));
            }
        } catch (Exception e) {
            String errorMsg = "Error occurred in getLocationsForAdminCountryRole(Integer employeeId, Integer roleId) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }

        return locationsAdminCountryRole;
    }

    /**
     * This method get the countries where the employee is country admin
     *
     * @param employeeId
     * @param roleId
     * @return Collection of CountryVO
     * @throws FacadeException
     */
    public Collection getCountriesForAdminCountryRole(String employeeId, Integer roleId) throws FacadeException {
        Collection countriesAdminCountryRole = new ArrayList();
        try {
            countriesAdminCountryRole = getAdminDaoLocal().getCountriesForAdmin(employeeId, roleId);
        } catch (Exception e) {
            String errorMsg = "Error occurred in getCountriesForAdminCountryRole(Integer employeeId, Integer roleId) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }

        return countriesAdminCountryRole;
    }

    /**
     * This method is useful to revoke any number of user as administrator want
     *
     * @param employeeToRevokeList
     * @throws FacadeException
     */
    public void revokeEmployee(List employeeToRevokeList, String adminId) throws FacadeException {
        try {
            getAdminDaoLocal().revokeEmployee(employeeToRevokeList, adminId);
        } catch (Exception e) {
            String errorMsg = "Error occurred in revokeEmployee(List employeeToRevokeList) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    /**
     * This method call to the DAO Admin to get information of Tables Admin
     *
     * @param table
     * @return HashMap
     * @throws FacadeException
     */
    public HashMap getAdminTableByTableName(String table) throws FacadeException {
        try {
            return getAdminDaoLocal().getAdminTableByTableName(table);
        } catch (Exception e) {
            String errorMsg = "Error occurred in getAdminTableByTableName(String table) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    /**
     * This method call to DAO Admin to gat data according to the sql and column names
     *
     * @param pageNumber
     * @param sqlCount
     * @return Collection data
     * @throws FacadeException
     */
    public Collection getDataForTableAdmin(String sql, String tableName, int pageNumber, String sqlCount) throws FacadeException {
        try {
            return getAdminDaoLocal().getDataForTableAdmin(sql, tableName, pageNumber, sqlCount);
        } catch (Exception e) {
            String errorMsg = "Error occurred in getDataForTableAdmin(String sql, Collection columns) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    /**
     * Method to get data to update a row of Admin Tables
     *
     * @param primaryKey
     * @param table
     * @return Collection
     * @throws FacadeException
     */
    public Collection getRow(String primaryKey, String table) throws FacadeException {
        try {
            return getAdminDaoLocal().getRow(primaryKey, table);
        } catch (Exception e) {
            String errorMsg = "Error occurred in getRow(String primaryKey, String table) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    /**
     * This method is a facade method to call admin dao to update value in a table, it receive Collection of value
     * object TablesAdminVO which contain information about every updatable column
     *
     * @param columnToUpdate
     * @throws FacadeException
     */
    public void updateAdminMainTable(Collection columnToUpdate) throws FacadeException {
        try {
            getAdminDaoLocal().updateAdminMainTable(columnToUpdate);
        } catch (Exception e) {
            String errorMsg = "Error occurred in updateAdminMainTable(Collection columnToUpdate)";
            throw new FacadeException(errorMsg, e);
        }
    }

    /**
     * This method is a facade method to call admin dao to get active entities to send info
     * to people soft
     *
     * @param oper columnToUpdate
     * @return Collection
     * @throws FacadeException
     */
    public Collection getEntityPSActiveEnt(String oper) throws FacadeException {
        try {
            return getAdminDaoLocal().getEntityPSActiveEnt(oper);
        } catch (Exception e) {
            String errorMsg = "Error occurred in getEntityPSActiveEnt(String a) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getCashInBankPSUpload(String ent) throws FacadeException {
        try {
            return getAdminDaoLocal().getCashInBankPSUpload(ent);
        } catch (Exception e) {
            String errorMsg = "Error occurred in getCashInBankPSUpload(String a) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getWriteOffPSUpload(String ent) throws FacadeException {
        try {
            return getAdminDaoLocal().getWriteOffPSUpload(ent);
        } catch (Exception e) {
            String errorMsg = "Error occurred in getWriteOffPSUpload(String a) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void updateCountryFlags(String countryCd, int dtrcUpldFlg, int psCashUpldFlg, int psWoffUpldFlg, String operId) throws FacadeException {
        try {
            getAdminDaoLocal().updateCountryFlags(countryCd, dtrcUpldFlg, psCashUpldFlg, psWoffUpldFlg, operId);
        } catch (Exception e) {
            String errorMsg = "Error occurred in updateCountryFlags(String countryCd,int dtrcUpldFlg,int psCashUpldFlg, int psWoffUpldFlg) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Date getNextClosingDate() throws FacadeException {
        try {
            return getAdminDaoLocal().getNextClosingDate();
        } catch (Exception e) {
            String errorMsg = "Error occurred in getNextClosingDate() method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getAllTables() throws FacadeException {
        try {
            return getAdminDaoLocal().getAllTables();
        } catch (Exception e) {
            String errorMsg = "Error occurred in getAllTables() method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getAllAdminTables() throws FacadeException {
        try {
            return getAdminDaoLocal().getAllAdminTables();
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in getAllAdminTables() method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getAllColumnsOfTable(String name) throws FacadeException {
        try {
            return getAdminDaoLocal().getAllColumnsOfTable(name);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in getAllColumnsOfTable(name) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getColumnsOfAdminTable(String name) throws FacadeException {
        try {
            return getAdminDaoLocal().getColumnsOfAdminTable(name);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in getColumnsOfAdminTable(name) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void createAdminTable(String name) throws FacadeException {
        try {
            getAdminDaoLocal().createAdminTable(name);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in createAdminTable(name) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void updateAdminTableColumn(String table, String column, String flag, String value) throws FacadeException {
        try {
            getAdminDaoLocal().updateAdminTableColumn(table, column, flag, value);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in updateAdminTableColumn(table,column,flag,value) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void removeAdminTableColumn(String table, String column) throws FacadeException {
        try {
            getAdminDaoLocal().removeAdminTableColumn(table, column);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in removeAdminTableColumn(table,column) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void removeAdminTable(String table) throws FacadeException {
        try {
            getAdminDaoLocal().removeAdminTable(table);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in removeAdminTable(table) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void createAdminTableColumn(String table, String column) throws FacadeException {
        try {
            getAdminDaoLocal().createAdminTableColumn(table, column);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in createAdminTable(table,column) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public EntityAdminVO getEntity(String entCd) throws FacadeException {
        try {
            return getAdminDaoLocal().getEntity(entCd);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in getEntity(String entCd) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void setEntity(EntityAdminVO entVO) throws FacadeException {
        try {
            getAdminDaoLocal().setEntity(entVO);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in setEntity(EntityAdminVO entVO) method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getEntities() throws FacadeException {
        try {
            return getAdminDaoLocal().getEntities();
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in getEntities() method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public EntityAcctAdminVO getEntAcct(String entCd, int bankAcct) throws FacadeException {
        try {
            return getAdminDaoLocal().getEntAcct(entCd, bankAcct);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in getEntAcct() method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void setEntAcct(EntityAcctAdminVO entVO) throws FacadeException {
        try {
            getAdminDaoLocal().setEntAcct(entVO);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in setEntAcct() method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void removeEntAcct(EntityAcctAdminVO entVO) throws FacadeException {
        try {
            getAdminDaoLocal().removeEntAcct(entVO);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in setEntAcct() method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }


    public Collection getEntCntryAccounts(String entCd) throws FacadeException {
        try {
            return getAdminDaoLocal().getEntCntryAccounts(entCd);
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in getEntCntryAccounts() method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getTimeZones() throws FacadeException {
        try {
            //Getting java timezones
            String ids[] = TimeZone.getAvailableIDs();
            ArrayList javaTimeZones = new ArrayList();
            ArrayList oracleTimeZones = null;
            ArrayList timeZones = null;
            Arrays.sort(ids);
            for (int i = 0; i < ids.length; i++)
                javaTimeZones.add(ids[i]);

            //Getting oracle timezones
            oracleTimeZones = (ArrayList) getAdminDaoLocal().getOracleTimeZones();

            //Creating Timezones valid for both domains
            //Throw exception if oracleTimeZones are not in ArrayList
            if (oracleTimeZones == null || oracleTimeZones.isEmpty()) {
                String errorMsg = "Error occurred in getTimeZones() method. OracleTimeZones is null or empty";
                throw new FacadeException(errorMsg, new Exception());
            }

            timeZones = new ArrayList();
            for (int i = 0; i < oracleTimeZones.size(); i++) {
                if (javaTimeZones.contains(oracleTimeZones.get(i)))
                    timeZones.add(oracleTimeZones.get(i));
            }

            return timeZones;
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in getTimeZones() method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getPossibleParentLocations(String locationCd, String countryCd) throws FacadeException {
        try {
            Collection parentLocations = null;

            //Is this location a Parent?
            boolean isParent = getAdminDaoLocal().isLocationParent(locationCd);

            if (isParent)
                return new ArrayList();

            LocationController ctrlLocation = new LocationController();
            parentLocations = ctrlLocation.getAllPossibleParentLocationsByCountry(locationCd, countryCd);

            return parentLocations;
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in getParentLocations() method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }
    //Miscellaneous enhancements 
    public void saveStationsAdminInput(StationsAdminVO stationsAdminVO) throws FacadeException//throws FacadeException
    {
        
    	try {
    		System.out.println("in ADminFACADE BEAN BEFORE =  "+stationsAdminVO.getComments());
            getAdminDaoLocal().saveStationsAdminInput(stationsAdminVO);
            System.out.println("in ADminFACADE BEAN AFTER =  "+stationsAdminVO.getComments());
        }
        catch (Exception e) {
            String errorMsg = "Error occurred in saveStationsAdminInput() method when lookup the local home interface";
            throw new FacadeException(errorMsg, e);
        }
    }//Close method saveStationsAdminInput
    
    
}