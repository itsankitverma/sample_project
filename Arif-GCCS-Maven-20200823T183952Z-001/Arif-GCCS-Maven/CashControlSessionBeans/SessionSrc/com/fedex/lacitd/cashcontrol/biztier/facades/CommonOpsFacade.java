package com.fedex.lacitd.cashcontrol.biztier.facades;


import com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.DepTemplVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PymtImptLogVO;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Date;

/**
 * Created 18/11/2003 15:58:50
 * Code generated by the Sun ONE Studio EJB Builder
 *
 * @author ccardenas
 */

public interface CommonOpsFacade extends javax.ejb.EJBObject {

    public boolean closeCouriers(String checkInEmpCodePk, String locationCodePk, java.util.Collection employeeSummaries) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public java.util.Collection getPaymentsSummaryByEmp(String locationCodePk) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public java.util.Collection getCreditCardPaymentsBatchs(String locationCodePk) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public java.util.Hashtable getDepositSlipReport(String locationCodePk, Integer pageNumber) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public void addDepositSlipComment(int depSlipId, String newComment) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public java.util.Collection getEmployeesWithPayments(String location) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public int existsEmployeeLocation(String loc, String emp) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public java.util.Collection getBankAccByLocation(String locationCodePk) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public void addCCBatchComment(int ccpId, String newComment) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public int processEndOfDay(String locationCodePk, String employeeCodePk) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public int openEndOfDay(String locationCodePk, String employeeCodePk, int openDeposits) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public void saveCCBatch(java.util.Collection ccb, java.lang.String employeeId, java.util.Date dt) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public void saveDepositSlip(java.util.Collection depos, java.lang.String employeeId) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public java.util.Collection saveDepTempl(DepTemplVO templVO, String[] locs, Integer[] paymentTypes) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public Collection getExternalFilesImportingStatus(String empId) throws FacadeException, java.rmi.RemoteException;

    public void saveErrorsPymtImpt(PymtImptLogVO plVO, Collection errorsDetail) throws java.rmi.RemoteException, FacadeException;

    public PymtImptLogVO getImportingExternalLog(Integer logId) throws java.rmi.RemoteException, FacadeException;

    public Collection getImportingExternalLogDetailsByLogId(Integer logId) throws java.rmi.RemoteException, FacadeException;

    public Collection getComments(java.lang.String countryCd) throws java.rmi.RemoteException, FacadeException;

    public Collection getLocationCdByCountry(java.lang.String countryCd) throws FacadeException, java.rmi.RemoteException;

    public void markWriteOff() throws FacadeException, java.rmi.RemoteException;

    public Collection getDailyDtrcUpload(int dayOffSet) throws FacadeException, java.rmi.RemoteException;

    public Collection getBatchesToAdmin(String locationCd, Date startDt, Date endDt) throws FacadeException, java.rmi.RemoteException;

    public void openSpecificEndOfDay(String locationCd, String eodId) throws FacadeException, java.rmi.RemoteException;

    public void changePaymentsDate(String locationCd, String eodId, String toDt) throws FacadeException, java.rmi.RemoteException;

    public void changeDepoPaymentsDate(String locationCd, int depoId, String dt) throws FacadeException, java.rmi.RemoteException;

    public void quickClear(String locationCd) throws FacadeException, java.rmi.RemoteException;

    public void quickCollectLaters(String locationCd) throws FacadeException, java.rmi.RemoteException;

    public void moveToSYDX() throws FacadeException, RemoteException;

    public void reassignPayments(String oldEmployee, String newEmployee, String oldLocation, String newLocation, String reassEmployee, boolean moveRec, boolean movePrep, boolean movePoa, boolean moveGrn) throws FacadeException, RemoteException;

    public int getSplitCountTable(String locationCd, String courier, String operation) throws FacadeException, RemoteException;

    public Collection getMorePaymentsSummaryByEmp(String locationCd) throws FacadeException, RemoteException;

    public java.util.HashMap getCreditCardPymt(String entityCd, Date startDate, Date endDate) throws FacadeException, RemoteException;

    public void saveCreditCardPymtLog(String employeeId, String entityCd, String locationCd, String startDateTxt, String endDateTxt) throws FacadeException, RemoteException;

    public java.util.Collection getEntities() throws FacadeException, RemoteException;

    public java.util.Collection getEntities(String employeeId) throws FacadeException, RemoteException;

}

