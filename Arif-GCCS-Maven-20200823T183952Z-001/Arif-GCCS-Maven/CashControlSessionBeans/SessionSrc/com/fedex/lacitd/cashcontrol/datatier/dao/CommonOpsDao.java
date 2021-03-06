package com.fedex.lacitd.cashcontrol.datatier.dao;

import com.fedex.lacitd.cashcontrol.datatier.exception.DAOException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CosmosScanVO;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Date;

/**
 * Created 18/11/2003 16:01:05
 * Code generated by the Sun ONE Studio EJB Builder
 *
 * @author ccardenas
 */

public interface CommonOpsDao extends javax.ejb.EJBObject {
    public boolean closeCourier(java.lang.String checkInEmpCodePk, java.lang.String locationCodePk, java.lang.String employeeCodePk) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.datatier.exception.DAOException;

    public int processEndOfDay(String locationCodePk, String employeeCodePk) throws java.rmi.RemoteException, DAOException;

    public int openEndOfDay(String locationCd, String employeeId, int openDeposits) throws java.rmi.RemoteException, DAOException;

    public Collection getPaymentsSummaryByEmp(java.lang.String locationCodePk) throws java.rmi.RemoteException, DAOException;

    public int existsEmployeeLocation(String loc, String emp) throws java.rmi.RemoteException, DAOException;

    public java.util.Collection getBankAccByLocation(String locationCodePk) throws java.rmi.RemoteException, DAOException;

    public java.util.Collection getCreditCardPaymentsBatchs(String locationCd) throws java.rmi.RemoteException, DAOException;

    public java.util.Hashtable getDepositSlipReport(String locationCodePk, Integer pageNumber) throws java.rmi.RemoteException, DAOException;

    public java.util.Collection getEmployeesWithPayments(java.lang.String locationCd) throws java.rmi.RemoteException, DAOException;

    public void assignBankReference(int depositId) throws java.rmi.RemoteException, DAOException;

    public void getAssingDepositSlipNumber(Collection depos) throws java.rmi.RemoteException, DAOException;

    public void insertCosmosScan(CosmosScanVO scanVO) throws java.rmi.RemoteException, java.rmi.RemoteException, DAOException;

    public java.util.Collection validateTemplOverlaps(Integer templId) throws DAOException, java.rmi.RemoteException;

    public Collection getExternalFilesImportingStatus(String empId) throws DAOException, java.rmi.RemoteException;

    public Collection getComments(java.lang.String countryCd) throws DAOException, java.rmi.RemoteException;

    public void markWriteOff() throws DAOException, java.rmi.RemoteException;

    public Collection getDailyDtrcUpload(int dayOffSet) throws DAOException, java.rmi.RemoteException;

    public Collection getBatchesToAdmin(String locationCd, Date startDt, Date endDt) throws DAOException, RemoteException;

    public void changePaymentsDate(String locationCd, String eodId, String toDt) throws DAOException, RemoteException;

    public void openSpecificEndOfDay(String locationCd, String eodId) throws DAOException, RemoteException;

    public void changeDepoPaymentsDate(String locationCd, int depoId, String dt) throws DAOException, RemoteException;

    public void quickClear(String locationCd) throws DAOException, RemoteException;

    public void quickCollectLaters(String locationCd) throws DAOException, RemoteException;

    public void moveToSYDX() throws DAOException, RemoteException;

    public void reassignPayments(String oldEmployee, String newEmployee, String oldLocation, String newLocation, String reassEmployee, boolean moveRec, boolean movePrep, boolean movePoa, boolean moveGrn) throws DAOException, RemoteException;

    public int getSplitCountTable(String locationCd, String courier, String operation) throws DAOException, RemoteException;

    public Collection getMorePaymentsSummaryByEmp(String locationCd) throws DAOException, RemoteException;

    public java.util.HashMap getCreditCardPymt(String entityCd, Date startDt, Date endDt) throws DAOException, RemoteException;

    public void saveCreditCardPymtLog(String employeeId, String entityCd, String locationCd, String startDateTxt, String endDateTxt) throws DAOException, RemoteException;

    public Collection getEntities() throws DAOException, RemoteException;

    public Collection getEntities(String employeeId) throws DAOException, RemoteException;
}