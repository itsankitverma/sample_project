/**
 * AdminBizDelegate.java
 *
 * Created on April 21, 2003, 12:47 PM
 */

package com.fedex.lacitd.cashcontrol.biztier.bizdelegates;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.CountryConfigVO;
import com.fedex.lacitd.cashcontrol.biztier.common.EntityAcctAdminVO;
import com.fedex.lacitd.cashcontrol.biztier.common.EntityAdminVO;
import com.fedex.lacitd.cashcontrol.biztier.common.StationsAdminVO;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.biztier.facades.AdminFacade;
import com.fedex.lacitd.cashcontrol.biztier.facades.AdminFacadeHome;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
//import com.fedex.lacitd.cashcontrol.common.ServiceLocator;

import com.fedex.lacitd.cashcontrol.datatier.controller.TasksController;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;

import javax.ejb.CreateException;

import java.rmi.RemoteException;
import java.util.*;

/**
 * @author Arturo Gonzalez
 */
public class AdminBizDelegate implements java.io.Serializable {

    /**
     * Creates a new instance of AdminBizDelegate
     */
    public AdminBizDelegate() {
    }

    /**
     * This method gets users profiles calling to the method
     * getUserProfileToAdmin of the Session Bean AdminFacade
     *
     * @param country_cd
     * @return Collection usersPrfiles
     * @throws BizDelegateException
     */
    public Collection getUserProfileToAdmin(String country_cd, String locCd) throws BizDelegateException {
        //ArrayList usersProfiles = new ArrayList();
        try {
            return getAdminFacade().getUserProfileToAdmin(country_cd, locCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getUserProfileToAdmin(country_cd) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    /**
     * This method retrieves information about countries that exist in the database
     *
     * @return Collection of Countries
     * @throws BizDelegateException
     */
    public Collection getAllCountry() throws BizDelegateException {
        try {
            return getAdminFacade().getAllCountry();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAllCountry(country_cd) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public EmployeeVO getEmployee(String userId) throws BizDelegateException {
        EmployeeVO employee = null;
        try {
            employee = getAdminFacade().getEmployee(userId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEmployee(userId) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
        return employee;
    }

    public void deleteUser(String userId, String countryCd) throws BizDelegateException {
        try {
            getAdminFacade().deleteUser(userId, countryCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in deleteUser(userId) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void deleteUserPermanently(String userId) throws BizDelegateException {
        try {
            getAdminFacade().deleteUserPermanently(userId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in deleteUserPermanently(userId) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void disableUser(String userId) throws BizDelegateException {
        try {
            getAdminFacade().disableUser(userId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in disableUser(userId) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void deleteLocation(String userId, String locationCd) throws BizDelegateException {
        try {
            getAdminFacade().deleteLocation(userId, locationCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in deleteLocation(userId, locationCd) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void deleteRole(String userId, String locationCd, Integer roleId) throws BizDelegateException {
        try {
            getAdminFacade().deleteRole(userId, locationCd, roleId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in deleteRole(userId ,locationCd, roleId) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getLocationsByCountry(java.lang.String country) throws BizDelegateException {
        try {
            return getAdminFacade().getLocationsByCountry(country);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getLocationsByCountry(country) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getAllRoles() throws BizDelegateException {
        try {
            return getAdminFacade().getAllRoles();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAllRoles() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void updateUser(EmployeeVO employee) throws BizDelegateException {
        try {
            getAdminFacade().updateEmployee(employee);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in updateUser(employee) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void saveUserLocationRole(EmployeeVO employee, EmpXLocationXRoleVO empLocRole) throws BizDelegateException {
        try {
            getAdminFacade().addEmployee(employee, empLocRole);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveUserLocationRole() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void addUserLocationRole(EmployeeVO employee, EmpXLocationXRoleVO empLocRole) throws BizDelegateException {
        try {
            getAdminFacade().addUser(employee, empLocRole);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in addUserLocationRole() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void addLocationRole(EmpXLocationXRoleVO empLocRole) throws BizDelegateException {
        try {
            getAdminFacade().addLocationRole(empLocRole);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in addLocationRole() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getLocationsByEmployee(String country, String userId) throws BizDelegateException {
        try {
            return getAdminFacade().getLocationsByCountryEmployee(country, userId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in addLocationRole() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public LocationVO getLocation(String locationCd) throws BizDelegateException {
        try {
            return getAdminFacade().getLocation(locationCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getLocation() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void updateLocation(LocationVO location, String inCageFlag, String rihFlag) throws BizDelegateException {
        try {
            getAdminFacade().updateLocation(location, inCageFlag, rihFlag);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in updateLocation() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public CountryConfigVO getCountryCurrency(String countryCd) throws BizDelegateException {
        try {
            return getAdminFacade().getCountryCurrency(countryCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCountryCurrency() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void updateCountryCurrency(CountryCurrencyVO countryCurrency, String operation) throws BizDelegateException {
        try {
            getAdminFacade().updateCountryCurrency(countryCurrency, operation);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in updateCountryCurrency() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getAllLocations() throws BizDelegateException {
        try {
            return getAdminFacade().getAllLocations();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAllLocations() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public String getPasswordCoded(String employeeId, String password) throws BizDelegateException {
        try {
            return getAdminFacade().getCodedPassword(employeeId, password);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getPasswordCoded() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }

    }

    public Collection getEmployeesByRole(Integer roleId) throws BizDelegateException {
        try {
            return getAdminFacade().getEmployeesByRole(roleId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEmployeesByRole(Integer roleId) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getAdminEmployees(String countryCd) throws BizDelegateException {
        try {
            return getAdminFacade().getAdminEmployees(countryCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEmployeesByRole(Integer roleId) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    /**
     * This method get the accounts by Banks for the country
     * and location selected
     *
     * @param country
     * @param location
     * @return collection of BankAccountLocationVO
     */
    public Collection getBankAccounts(String country, Integer bank, String location) throws BizDelegateException {
        try {
            return getAdminFacade().getBankAccounts(country, bank, location);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getBankAccounts(String country, Integer bank, String location) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void saveBankAccount(BankAccVO bankAccount, Collection locations) throws BizDelegateException {
        try {
            getAdminFacade().saveBankAccount(bankAccount, locations);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveBankAccount(BankAccVO bankAccount, Collection locations) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void deleteAccount(Integer accountCd) throws BizDelegateException {
        try {
            getAdminFacade().deleteAccount(accountCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in deleteAccount(Integer accountCd) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getLocationsForAdminCountryRole(String employeeId, Integer roleId) throws BizDelegateException {
        try {
            return getAdminFacade().getLocationsForAdminCountryRole(employeeId, roleId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getLocationsForAdminCountryRole(Integer employeeId, Integer roleId) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getCountriesForAdminCountryRole(String employeeId, Integer roleId) throws BizDelegateException {
        try {
            return getAdminFacade().getCountriesForAdminCountryRole(employeeId, roleId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getLocationsForAdminCountryRole(Integer employeeId, Integer roleId) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void revokeEmployee(List employeeToRevokeList, String adminId) throws BizDelegateException {
        try {
            getAdminFacade().revokeEmployee(employeeToRevokeList, adminId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in revokeEmployee(List employeeToRevokeList, HttpServletRequest request) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }
    
	public HashMap getAdminTableByTableName(String table) throws BizDelegateException {
        try {
            return getAdminFacade().getAdminTableByTableName(table);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAdminTableByTableName(String table) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getDataForTableAdmin(String sql, String tableName, int pageNumber, String sqlCount) throws BizDelegateException {
        try {
            return getAdminFacade().getDataForTableAdmin(sql, tableName, pageNumber, sqlCount);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getDataForTableAdmin(String sql, Collection columns) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getRow(String primaryKey, String table) throws BizDelegateException {
        try {
            return getAdminFacade().getRow(primaryKey, table);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getRow(String primaryKey, String table) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void updateAdminMainTable(Collection columnToUpdate) throws BizDelegateException {
        try {
            getAdminFacade().updateAdminMainTable(columnToUpdate);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in updateAdminMainTable(Collection columnToUpdate) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getEntityPSActiveEnt(String oper) throws BizDelegateException {
        try {
            return getAdminFacade().getEntityPSActiveEnt(oper);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEntityPSActiveEnt(Collection columnToUpdate) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getCashInBankPSUpload(String ent) throws BizDelegateException {
        try {
            return getAdminFacade().getCashInBankPSUpload(ent);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCashInBankPSUpload(Collection columnToUpdate) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getWriteOffPSUpload(String ent) throws BizDelegateException {
        try {
            return getAdminFacade().getWriteOffPSUpload(ent);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getWriteOffPSUpload(Collection columnToUpdate) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Date getNextClosingDate() throws BizDelegateException {
        try {
            return getAdminFacade().getNextClosingDate();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getNextClosingDate() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void updateCountryFlags(String countryCd, int dtrcUpldFlg, int psCashUpldFlg, int psWoffUpldFlg, String psOperId) throws BizDelegateException {
        try {
            getAdminFacade().updateCountryFlags(countryCd, dtrcUpldFlg, psCashUpldFlg, psWoffUpldFlg, psOperId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in updateCountryFlags(String countryCd,int dtrcUpldFlg,int psCashUpldFlg, int psWoffUpldFlg,String psOperId) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public TasksVO getTasks(Integer tasksId) throws BizDelegateException {
        TasksController tc = new TasksController();

        try {
            return getAdminFacade().getTasks(tasksId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getTasks(Integer tasksId) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void updateTasks(TasksVO tasks) throws BizDelegateException {
        try {
            getAdminFacade().updateTasks(tasks);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in updateTasks(TasksVO tasks) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    private AdminFacade getAdminFacade() throws ServiceLocatorException, CreateException, RemoteException {
        ServiceLocator service = ServiceLocator.getInstance();
        AdminFacadeHome home = (AdminFacadeHome) service.getEJBHome(Constants.AdminFacadeEJB_Remote, AdminFacadeHome.class);
        AdminFacade af = home.create();
        return af;
    }

    public Collection getAllTables() throws BizDelegateException {
        try {
            return getAdminFacade().getAllTables();
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAllTables() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getAllAdminTables() throws BizDelegateException {
        try {
            return getAdminFacade().getAllAdminTables();
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAllAdminTables() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getAllColumnsOfTable(String name) throws BizDelegateException {
        try {
            return getAdminFacade().getAllColumnsOfTable(name);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAllColumnsOfTable(name) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getColumnsOfAdminTable(String name) throws BizDelegateException {
        try {
            return getAdminFacade().getColumnsOfAdminTable(name);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getColumnsOfAdminTable(name) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void createAdminTable(String name) throws BizDelegateException {
        try {
            getAdminFacade().createAdminTable(name);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in createAdminTable(name) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void updateAdminTableColumn(String table, String column, String flag, String value) throws BizDelegateException {
        try {
            getAdminFacade().updateAdminTableColumn(table, column, flag, value);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in updateAdminTableColumn(table,column,flag,value) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void removeAdminTableColumn(String table, String column) throws BizDelegateException {
        try {
            getAdminFacade().removeAdminTableColumn(table, column);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in removeAdminTableColumn(table,column) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void removeAdminTable(String table) throws BizDelegateException {
        try {
            getAdminFacade().removeAdminTable(table);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in removeAdminTable(table) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void createAdminTableColumn(String table, String column) throws BizDelegateException {
        try {
            getAdminFacade().createAdminTableColumn(table, column);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in createAdminTableColumn(table,column) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }


    public EntityAdminVO getEntity(String entCd) throws BizDelegateException {
        try {
            return getAdminFacade().getEntity(entCd);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEntity() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }


    public void setEntity(EntityAdminVO entVO) throws BizDelegateException {
        try {
            getAdminFacade().setEntity(entVO);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in setEntity(table,column) method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getEntities() throws BizDelegateException {
        try {
            return getAdminFacade().getEntities();
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEntities method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public EntityAcctAdminVO getEntAcct(String entCd, int bankAcct) throws BizDelegateException {
        try {
            return getAdminFacade().getEntAcct(entCd, bankAcct);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEntAcct method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }


    public void setEntAcct(EntityAcctAdminVO entVO) throws BizDelegateException {
        try {
            getAdminFacade().setEntAcct(entVO);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in setEntAcct method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void removeEntAcct(EntityAcctAdminVO entVO) throws BizDelegateException {
        try {
            getAdminFacade().removeEntAcct(entVO);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in removeEntAcct method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }


    public Collection getEntCntryAccounts(String entCd) throws BizDelegateException {
        try {
            return getAdminFacade().getEntCntryAccounts(entCd);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEntCntryAccounts method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getTimeZones() throws BizDelegateException {
        try {
            return getAdminFacade().getTimeZones();
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getTimeZones() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getPossibleParentLocations(String locationCd, String countryCd) throws BizDelegateException {
        try {
            return getAdminFacade().getPossibleParentLocations(locationCd, countryCd);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getParentLocations() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }
//Miscellaneous enhancements 
    
    public void saveStationsAdminInput(StationsAdminVO stationsAdminVO) throws BizDelegateException {
        try {
        	System.out.println("in ADminBIZDELEGATE BEFORE =  "+stationsAdminVO.getComments());
            getAdminFacade().saveStationsAdminInput(stationsAdminVO);
            System.out.println("in ADminBIZDELEGATE AFTER =  "+stationsAdminVO.getComments());
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveStationsAdminInput() method from AdminBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

}//AdminBizDelegate
