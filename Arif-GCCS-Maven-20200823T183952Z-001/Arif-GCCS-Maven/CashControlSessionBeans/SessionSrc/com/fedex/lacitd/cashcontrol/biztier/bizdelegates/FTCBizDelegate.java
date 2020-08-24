/**
 * DataHarvestBizDelegate.java
 *
 * Created on 11 de julio de 2002, 07:11 PM
 */

package com.fedex.lacitd.cashcontrol.biztier.bizdelegates;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.TotalSummaryVO;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.biztier.facades.FTCFacade;
import com.fedex.lacitd.cashcontrol.biztier.facades.FTCFacadeHome;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
//import com.fedex.lacitd.cashcontrol.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.FTC_ReceivablesVO;

import javax.ejb.CreateException;
import java.util.Collection;
import java.util.Hashtable;


/**
 * @author ccardenas
 */
public class FTCBizDelegate implements java.io.Serializable {

    /**
     * Creates a new instance of DataHarvestBizDelegate
     */
    public FTCBizDelegate() {
    }
/*
    public void loadInvoices(Collection colRec) throws BizDelegateException {
        try {
            getFTCFacade().loadInvoices(colRec);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in loadInvoices() method of class FTCBizDelegate", e);
        }
    }
*/
    public Collection getAwbToQueryCosmos(String locationCd, String employeeId) throws BizDelegateException {
        try {
            return getFTCFacade().getAwbToQueryCosmos(locationCd, employeeId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getAwbToQueryCosmos() method of class FTCBizDelegate", e);
        }
    }


    public Collection applyFTCScans(Collection colChanges) throws BizDelegateException {
        try {
            return getFTCFacade().applyFTCScans(colChanges);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in applyFTCScans() method of class FTCBizDelegate", e);
        }
    }

    public Hashtable getCourierCashRecapTable(String locationCd, String employeeId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getFTCFacade().getCourierCashRecapTable(locationCd, employeeId, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getPaymentsSummaryByEmp() method of class FTCBizDelegate", e);
        }
    }

    public Collection getAllFTC_RecStatus() throws BizDelegateException {
        try {
            return getFTCFacade().getAllFTC_RecStatus();
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getAllFTC_RecStatus() method of class FTCBizDelegate", e);
        }
    }

    public void changeRecPaymentCurrency(int recPk, String newCurrency) throws BizDelegateException {
        try {
            getFTCFacade().changeRecPaymentCurrency(recPk, newCurrency);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in changeRecPaymentCurrency() method of class FTCBizDelegate", e);
        }
    }

    public void changeRecCurrency(int recPk, String newCurrency) throws BizDelegateException {
        try {
            getFTCFacade().changeRecCurrency(recPk, newCurrency);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in changeRecCurrency() method of class FTCBizDelegate", e);
        }
    }

    public void applyCheckinAgentChanges(java.util.Collection colChanges) throws BizDelegateException {
        try {
            getFTCFacade().applyCheckinAgentChanges(colChanges);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in applyCheckinAgentChanges() method of class FTCBizDelegate", e);
        }
    }

    public boolean addFTC_Receivable(FTC_ReceivablesVO recVO) throws BizDelegateException {
        try {
            return getFTCFacade().addFTC_Receivable(recVO);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in addReceivable() method of class FTCBizDelegate", e);
        }
    }

    public FTC_ReceivablesVO getFTC_Receivables(int recPk) throws BizDelegateException {
        try {
            return getFTCFacade().getFTC_Receivables(recPk);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getReceivables() method of class FTCBizDelegate", e);
        }
    }

    public Collection getInvoicesByAwb(String awbNumber) throws BizDelegateException {
        try {
            return getFTCFacade().getInvoicesByAwb(awbNumber);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getInvoicesByAwb() method of class FTCBizDelegate", e);
        }
    }

    public int reassignReceivableToCourier(int recPk, String locationCd, String employeeId) throws BizDelegateException {
        try {
            return getFTCFacade().reassignReceivableToCourier(recPk, locationCd, employeeId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in reassignReceivableToCourier() method of class FTCBizDelegate", e);
        }
    }


    public Collection getCouriersWithPendents(String location) throws BizDelegateException {
        try {
            return getFTCFacade().getCouriersWithPendents(location);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCouriersWithPendents() method from FTCFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public java.util.Collection getFTCUsedCurrencies(java.lang.String locationCd, java.lang.String employeeId) throws BizDelegateException {
        try {
            return getFTCFacade().getFTCUsedCurrencies(locationCd, employeeId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getFTCUsedCurrencies() method from FTCFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void runInCageExceptionsTask() throws BizDelegateException {
        try {
            getFTCFacade().runInCageExceptionsTask();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in runInCageExceptionsTask() method from FTCFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getAwbToQuerySTAT44() throws BizDelegateException {
        try {
            return getFTCFacade().getAwbToQuerySTAT44();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAwbToQuerySTAT44() method from FTCFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void saveSTAT44Scans(Collection col) throws BizDelegateException {
        try {
            getFTCFacade().saveSTAT44Scans(col);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveSTAT44Scans() method from FTCFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }
/*
    public boolean loadInvoices(Collection colRec, String filename) throws BizDelegateException {
        try {
            return getFTCFacade().loadInvoices(colRec, filename);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in loadInvoices() method from FTCFacadeBean class";
            Constants.logger.debug(Utils.stackTraceToString(e));
            throw new BizDelegateException(errorMsg, e);

        }
    }
*/
    public Collection getFTCFilesImportingStatus(String empId) throws BizDelegateException {
        try {
            return getFTCFacade().getFtcFilesImportingStatus(empId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getFTCFilesImportingStatus() method from FTCFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getFTCFilesImportingDetails(int logId) throws BizDelegateException {
        try {
            return getFTCFacade().getFtcFilesImportingDetails(logId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getFTCFilesImportingDetails() method from FTCFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    private FTCFacade getFTCFacade() throws java.rmi.RemoteException, ServiceLocatorException, CreateException {
        //ServiceLocator service=ServiceLocator.getInstance();
        FTCFacadeHome home = (FTCFacadeHome) ServiceLocator.getInstance().getEJBHome(Constants.FTCFacadeEJB_Remote, FTCFacadeHome.class);
        FTCFacade remote = home.create();
        return remote;
    }

    public Collection saveScans(Collection scans, String currentCurrency, double exchRate) throws BizDelegateException {
        try {
            return getFTCFacade().saveScans(scans, currentCurrency, exchRate);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in saveScans() method of class FTCBizDelegate", e);
        }

    }

    public void splitCurrency(Collection FTC_receivables, String tabType, double exchangeRate, double amountToChange) throws BizDelegateException {
        try {
            getFTCFacade().splitCurrency(FTC_receivables, tabType, exchangeRate, amountToChange);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) method of class FTCBizDelegate", e);
        }
    }

    public Hashtable getSplitCourierCashRecapTable(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getFTCFacade().getSplitCourierCashRecapTable(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getSplitCourierCashRecapTable(String locationCd,String employeeId) method of class FTCBizDelegate", e);
        }
    }

    public Collection applyPaymentToInvoices(String courierId, String locationCd, String countryCd, String paymentCurrency, int paymentType, String otherDocNbr, boolean isCash, boolean isFindByAWB, Collection invoices) throws BizDelegateException {
        try {
            return getFTCFacade().applyPaymentToInvoices(courierId, locationCd, countryCd, paymentCurrency, paymentType, otherDocNbr, isCash, isFindByAWB, invoices);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) method of class FTCBizDelegate", e);
        }
    }

    public TotalSummaryVO getFTCDetailsTotal(String locationCd, String employeeId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getFTCFacade().getFTCDetailsTotal(locationCd, employeeId, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getFTCDetailsTotal() method of class FTCBizDelegate", e);
        }
    }

    public TotalSummaryVO getFTCDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getFTCFacade().getFTCDetailsSplitTotal(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getFTCDetailsSplitTotal() method of class FTCBizDelegate", e);
        }
    }
}
