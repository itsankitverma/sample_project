/**
 * DataHarvestBizDelegate.java
 *
 * Created on 11 de julio de 2002, 07:11 PM
 */

package com.fedex.lacitd.cashcontrol.biztier.bizdelegates;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;
import com.fedex.lacitd.cashcontrol.biztier.facades.CommonOpsFacade;
import com.fedex.lacitd.cashcontrol.biztier.facades.CommonOpsFacadeHome;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
//import com.fedex.lacitd.cashcontrol.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.DepTemplVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PymtImptLogVO;

import javax.ejb.CreateException;
import java.util.Collection;
import java.util.Date;

/**
 * @author ccardenas
 */
public class CommonOpsBizDelegate implements java.io.Serializable {

    /**
     * Creates a new instance of DataHarvestBizDelegate
     */
    public CommonOpsBizDelegate() {
    }


    public Collection getPaymentsSummaryByEmp(String locationCd) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getPaymentsSummaryByEmp(locationCd);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getPaymentsSummaryByEmp() method of class RODBizDelegate", e);
        }
    }

    public boolean closeCouriers(String employeeId, String locationCd, Collection colCouriers) throws BizDelegateException {
        try {
        	System.out.println("here we are at the very 5 step");
            return getCommonOpsFacade().closeCouriers(employeeId, locationCd, colCouriers);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in closeCouriers () method of class RODBizDelegate", e);
        }
    }

    public int processEndOfDay(String locationCd, String employeeId) throws BizDelegateException {
        try {
            return getCommonOpsFacade().processEndOfDay(locationCd, employeeId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in processEndOfDay() method of class RODBizDelegate", e);
        }
    }

    public void reassignPayments(String oldEmployee, String newEmployee, String oldLocation, String newLocation, String reassEmployee, boolean moveRec, boolean movePrep, boolean movePoa, boolean moveGrn) throws BizDelegateException {
        try {
            getCommonOpsFacade().reassignPayments(oldEmployee, newEmployee, oldLocation, newLocation, reassEmployee, moveRec, movePrep, movePoa, moveGrn);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in reassignPayments() method of class RODBizDelegate", e);
        }
    }

    public int openEndOfDay(String locationCd, String employeeId, int openDeposits) throws BizDelegateException {
        try {
            return getCommonOpsFacade().openEndOfDay(locationCd, employeeId, openDeposits);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in openEndOfDay() method of class RODBizDelegate", e);
        }
    }

    public java.util.Hashtable getDepositSlipReport(String locationCd, Integer pageNumber) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getDepositSlipReport(locationCd, pageNumber);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getDepositSlipReport() method from CommonOpsFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public java.util.Collection getBatchesToAdmin(String locationCd, Date startDt, Date endDt) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getBatchesToAdmin(locationCd, startDt, endDt);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getBatchesToAdmin() method from CommonOpsFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }


    public java.util.Collection getCreditCardPaymentsBatchs(String locationCd) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getCreditCardPaymentsBatchs(locationCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCreditCardPaymentsBatchs() method from CommonOpsFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public java.util.Collection getBankAccByLocation(String locationCd) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getBankAccByLocation(locationCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getBankAccByLocation() method from CommonOpsFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void saveDepositSlip(Collection depos, String empId) throws BizDelegateException {
        try {
            getCommonOpsFacade().saveDepositSlip(depos, empId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAssingDepositSlipNumber() method from CommonOpsFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void addDepositSlipComment(int depSlipId, String newComment) throws BizDelegateException {
        try {
            getCommonOpsFacade().addDepositSlipComment(depSlipId, newComment);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in addDepositSlip() method from CommonOpsFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }


    public void saveCCBatch(Collection cc, String empId, java.util.Date dt) throws BizDelegateException {
        try {
            getCommonOpsFacade().saveCCBatch(cc, empId, dt);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveCCBatch() method from CommonOpsFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void addCCBatchComment(int ccpId, String newComment) throws BizDelegateException {
        try {
            getCommonOpsFacade().addCCBatchComment(ccpId, newComment);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in addCCBatchComment() method from CommonOpsFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public int existsEmployeeLocation(String loc, String emp) throws BizDelegateException {
        try {
            return getCommonOpsFacade().existsEmployeeLocation(loc, emp);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in existsEmployeeLocation() method from CommonOpsFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    private CommonOpsFacade getCommonOpsFacade() throws java.rmi.RemoteException, ServiceLocatorException, CreateException {
        ServiceLocator service = ServiceLocator.getInstance();
        CommonOpsFacadeHome home = (CommonOpsFacadeHome) ServiceLocator.getInstance().getEJBHome(Constants.CommonOpsFacadeEJB_Remote, CommonOpsFacadeHome.class);
        CommonOpsFacade remote = home.create();
        return remote;
    }

    public Collection getEmployeesWithPayments(String locationCd) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getEmployeesWithPayments(locationCd);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getEmployeesWithPayments() method of class RODBizDelegate", e);
        }
    }

    public java.util.Collection saveDepTempl(DepTemplVO templVO, java.lang.String[] locs, java.lang.Integer[] paymentTypes) throws BizDelegateException {
        try {
            return getCommonOpsFacade().saveDepTempl(templVO, locs, paymentTypes);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in validateTemplOverlaps() method of class RODBizDelegate", e);
        }
    }

    public void saveErrorsPymtImpt(PymtImptLogVO plVO, Collection errorsDetail) throws BizDelegateException {
        try {
            getCommonOpsFacade().saveErrorsPymtImpt(plVO, errorsDetail);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in saveErrorsPymtImpt(plVO, errorsDetail) method of class CommonOpsBizDelegate", e);
        }
    }

    public Collection getExternalFilesImportingStatus(String empId) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getExternalFilesImportingStatus(empId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in saveErrorsPymtImpt(plVO, errorsDetail) method of class CommonOpsBizDelegate", e);
        }
    }

    public PymtImptLogVO getImportingExternalLog(Integer logId) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getImportingExternalLog(logId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getImportingExternalLog(logId) method of class CommonOpsBizDelegate", e);
        }
    }

    public Collection getImportingExternalLogDetailsByLogId(Integer logId) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getImportingExternalLogDetailsByLogId(logId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getImportingExternalLogDetailsByLogId(logId) method of class CommonOpsBizDelegate", e);
        }
    }

    public Collection getComments(String countryCd) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getComments(countryCd);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getComments(String countryCd) method of class CommonOpsBizDelegate", e);
        }
    }

    public void markWriteOff() throws BizDelegateException {
        try {
            getCommonOpsFacade().markWriteOff();
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in markWriteOff method of class CommonOpsBizDelegate", e);
        }
    }

    public Collection getLocationCdByCountry(String countryCd) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getLocationCdByCountry(countryCd);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getLocationCdByCountry(String countryCd) method of class CommonOpsBizDelegate", e);
        }
    }

    public Collection getDailyDtrcUpload(int dayOffSet) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getDailyDtrcUpload(dayOffSet);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getDailyDtrcUpload(String countryCd) method of class CommonOpsBizDelegate", e);
        }
    }

    public void openSpecificEndOfDay(String locationCd, String eodId) throws FacadeException {
        try {
            getCommonOpsFacade().openSpecificEndOfDay(locationCd, eodId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in openSpecificEndOfDay() method from CommonOpsBizDelegate class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void changePaymentsDate(String locationCd, String eodId, String toDt) throws FacadeException {
        try {
            getCommonOpsFacade().changePaymentsDate(locationCd, eodId, toDt);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in changePaymentsDate() method from CommonOpsBizDelegate class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void changeDepoPaymentsDate(String locationCd, int depoId, String dt) throws FacadeException {
        try {
            getCommonOpsFacade().changeDepoPaymentsDate(locationCd, depoId, dt);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in changeDepoPaymentsDate() method from CommonOpsBizDelegate class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void quickClear(String locationCd) throws FacadeException {
        try {
            getCommonOpsFacade().quickClear(locationCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in quickClear() method from CommonOpsBizDelegate class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void quickCollectLaters(String locationCd) throws FacadeException {
        try {
            getCommonOpsFacade().quickCollectLaters(locationCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in quickCollectLaters() method from CommonOpsBizDelegate class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void moveToSYDX() throws BizDelegateException {
        try {
            getCommonOpsFacade().moveToSYDX();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in moveToSYDX() method from CommonOpsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public int getSplitCountTable(String locationCd, String courier, String operation) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getSplitCountTable(locationCd, courier, operation);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getSplitCountTable(String locationCd, String courier, String operation) method from CommonOpsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getMorePaymentsSummaryByEmp(String locationCd) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getMorePaymentsSummaryByEmp(locationCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getMorePaymentsSummaryByEmp(String locationCd) method from CommonOpsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public java.util.HashMap getCreditCardPymt(String entityCd, Date beginDate, Date endDate) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getCreditCardPymt(entityCd, beginDate, endDate);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getCreditCardPymt() method of class RODBizDelegate", e);
        }
    }

    public void saveCreditCardPymtLog(String employeeId, String entityCd, String locationCd, String startDateTxt, String endDateTxt) throws BizDelegateException {
        try {
            getCommonOpsFacade().saveCreditCardPymtLog(employeeId, entityCd, locationCd, startDateTxt, endDateTxt);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in saveCreditCardPymtLog() method of class RODBizDelegate", e);
        }
    }

    public Collection getEntities() throws BizDelegateException {
        try {
            return getCommonOpsFacade().getEntities();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEntities() method from CommonOpsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getEntities(String employeeId) throws BizDelegateException {
        try {
            return getCommonOpsFacade().getEntities(employeeId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEntities(" + employeeId + ") method from CommonOpsBizDelegate class";
            throw new BizDelegateException(errorMsg, e);
        }
    }


}
