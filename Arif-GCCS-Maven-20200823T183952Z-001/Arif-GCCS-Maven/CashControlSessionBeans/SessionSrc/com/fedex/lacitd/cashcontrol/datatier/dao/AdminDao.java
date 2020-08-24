package com.fedex.lacitd.cashcontrol.datatier.dao;

import com.fedex.lacitd.cashcontrol.biztier.common.CountryConfigVO;
import com.fedex.lacitd.cashcontrol.biztier.common.EntityAcctAdminVO;
import com.fedex.lacitd.cashcontrol.biztier.common.EntityAdminVO;
import com.fedex.lacitd.cashcontrol.biztier.common.StationsAdminVO;
import com.fedex.lacitd.cashcontrol.datatier.exception.DAOException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmpXLocationXRoleVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashMap;


/**
 * Created Apr 23, 2003 5:01:28 PM
 * Code generated by the Forte For Java EJB Builder
 *
 * @author ccardenas
 */

public interface AdminDao extends javax.ejb.EJBObject {

    public Collection getUsersProfilesToAdmin(String countryCD, String locCd) throws java.rmi.RemoteException, DAOException;

    public void addUser(EmployeeVO employee, EmpXLocationXRoleVO empLocRole) throws java.rmi.RemoteException, DAOException;

    public String getCodedPassword(String employeeId, String password) throws java.rmi.RemoteException, DAOException;

    public Collection getUsersProfilesByCountryEmployee(String countryCD, String userId) throws java.rmi.RemoteException, DAOException;

    public Collection getBankAccounts(String country, String location) throws RemoteException, DAOException;

    public Collection getCountriesForAdmin(String employeeId, Integer roleId) throws RemoteException, DAOException;

    public Collection getCountryAdminByEmployeeId(String employeeIds) throws DAOException, RemoteException;

    public HashMap getAdminTableByTableName(String table) throws DAOException, RemoteException;

    public Collection getDataForTableAdmin(String sql, String tableName, int pageNumber, String sqlCount) throws DAOException, RemoteException;

    public void updateAdminMainTable(Collection columnToUpdate) throws DAOException, RemoteException;

    public Collection getRow(String primaryKey, String table) throws DAOException, RemoteException;

    public Collection getEntityPSActiveEnt(String oper) throws DAOException, RemoteException;

    public Collection getCashInBankPSUpload(String ent) throws DAOException, RemoteException;

    /**
     * Method to get Write-Off information to be uploaded to PS
     *
     * @param ent String
     * @return Collection of PS info
     * @throws com.fedex.lacitd.cashcontrol.datatier.exception.DAOException
     *
     */
    public Collection getWriteOffPSUpload(String ent) throws DAOException, RemoteException;

    public void updateCountryFlags(String countryCd, int dtrcUpldFlg, int psCashUpldFlg, int psWoffUpldFlg, String operId) throws DAOException, RemoteException;

    public CountryConfigVO getCountryFlags(String countryCd) throws DAOException, RemoteException;

    public java.util.Date getNextClosingDate() throws DAOException, RemoteException;

    public Collection getAllTables() throws DAOException, RemoteException;

    public Collection getAllAdminTables() throws DAOException, RemoteException;

    public Collection getAllColumnsOfTable(String name) throws DAOException, RemoteException;

    public Collection getColumnsOfAdminTable(String name) throws DAOException, RemoteException;

    public void createAdminTable(String name) throws DAOException, RemoteException;

    public void updateAdminTableColumn(String table, String column, String flag, String value) throws DAOException, RemoteException;

    public void removeAdminTableColumn(String table, String column) throws DAOException, RemoteException;

    public void removeAdminTable(String table) throws DAOException, RemoteException;

    public void createAdminTableColumn(String table, String column) throws DAOException, RemoteException;

    public EntityAdminVO getEntity(String entCd) throws DAOException, RemoteException;

    void setEntity(EntityAdminVO entVO) throws DAOException, RemoteException;

    Collection getEntities() throws DAOException, RemoteException;

    void setEntAcct(EntityAcctAdminVO entVO) throws DAOException, RemoteException;

    EntityAcctAdminVO getEntAcct(String entCd, int bankAcct) throws DAOException, RemoteException;

    Collection getEntCntryAccounts(String entCd) throws DAOException, RemoteException;

    void removeEntAcct(EntityAcctAdminVO entVO) throws DAOException, RemoteException;

    public Collection getOracleTimeZones() throws DAOException, RemoteException;

    /**
     * This method updates set the RIHTaskId for all the
     * locations of the same ENTITY
     */
    public void setCntryLocsRIHTask(String locCd, int taskId) throws DAOException, RemoteException;

    public boolean isLocationParent(String locCd) throws DAOException, RemoteException;
    
    //Miscellaneous enhancements 
    public void saveStationsAdminInput(StationsAdminVO stationsAdminVO) throws DAOException, RemoteException;

}
 
