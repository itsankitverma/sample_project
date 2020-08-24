/**
 * DataHarvestBizDelegate.java
 *
 * Created on 11 de julio de 2002, 07:11 PM
 */

package com.fedex.lacitd.cashcontrol.biztier.bizdelegates;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.TotalSummaryVO;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.biztier.facades.CODFacade;
import com.fedex.lacitd.cashcontrol.biztier.facades.CODFacadeHome;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
//import com.fedex.lacitd.cashcontrol.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.COD_ReceivablesVO;

import javax.ejb.CreateException;
import java.util.Collection;
import java.util.Hashtable;


/**
 * @author ccardenas
 */
public class CODBizDelegate implements java.io.Serializable {

    /**
     * Creates a new instance of DataHarvestBizDelegate
     */
    public CODBizDelegate() {
    }
/*
    public void loadInvoices(Collection colRec) throws BizDelegateException {
        try {
            getCODFacade().loadInvoices(colRec);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in loadInvoices() method of class CODBizDelegate", e);
        }
    }
*/
    public Collection getAwbToQueryCosmos(String locationCd, String employeeId) throws BizDelegateException {
        try {
            return getCODFacade().getAwbToQueryCosmos(locationCd, employeeId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getAwbToQueryCosmos() method of class CODBizDelegate", e);
        }
    }


    public Collection applyCODScans(Collection colChanges) throws BizDelegateException {
        try {
            return getCODFacade().applyCODScans(colChanges);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in applyCODScans() method of class CODBizDelegate", e);
        }
    }

    public Hashtable getCourierCashRecapTable(String locationCd, String employeeId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getCODFacade().getCourierCashRecapTable(locationCd, employeeId, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getPaymentsSummaryByEmp() method of class CODBizDelegate", e);
        }
    }

    public Collection getAllCOD_RecStatus() throws BizDelegateException {
        try {
            return getCODFacade().getAllCOD_RecStatus();
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getAllCOD_RecStatus() method of class CODBizDelegate", e);
        }
    }

    public void changeRecPaymentCurrency(int recPk, String newCurrency) throws BizDelegateException {
        try {
            getCODFacade().changeRecPaymentCurrency(recPk, newCurrency);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in changeRecPaymentCurrency() method of class CODBizDelegate", e);
        }
    }

    public void changeRecCurrency(int recPk, String newCurrency) throws BizDelegateException {
        try {
            getCODFacade().changeRecCurrency(recPk, newCurrency);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in changeRecCurrency() method of class CODBizDelegate", e);
        }
    }

    public void applyCheckinAgentChanges(java.util.Collection colChanges) throws BizDelegateException {
        try {
            getCODFacade().applyCheckinAgentChanges(colChanges);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in applyCheckinAgentChanges() method of class CODBizDelegate", e);
        }
    }

    public boolean addCOD_Receivable(COD_ReceivablesVO recVO) throws BizDelegateException {
        try {
            return getCODFacade().addCOD_Receivable(recVO);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in addReceivable() method of class CODBizDelegate", e);
        }
    }

    public COD_ReceivablesVO getCOD_Receivables(int recPk) throws BizDelegateException {
        try {
            return getCODFacade().getCOD_Receivables(recPk);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getReceivables() method of class CODBizDelegate", e);
        }
    }

    public Collection getInvoicesByAwb(String awbNumber) throws BizDelegateException {
        try {
            return getCODFacade().getInvoicesByAwb(awbNumber);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getInvoicesByAwb() method of class CODBizDelegate", e);
        }
    }

    public int reassignReceivableToCourier(int recPk, String locationCd, String employeeId) throws BizDelegateException {
        try {
            return getCODFacade().reassignReceivableToCourier(recPk, locationCd, employeeId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in reassignReceivableToCourier() method of class CODBizDelegate", e);
        }
    }


    public Collection getCouriersWithPendents(String location) throws BizDelegateException {
        try {
            return getCODFacade().getCouriersWithPendents(location);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCouriersWithPendents() method from CODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public java.util.Collection getCODUsedCurrencies(java.lang.String locationCd, java.lang.String employeeId) throws BizDelegateException {
        try {
            return getCODFacade().getCODUsedCurrencies(locationCd, employeeId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCODUsedCurrencies() method from CODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void runInCageExceptionsTask() throws BizDelegateException {
        try {
            getCODFacade().runInCageExceptionsTask();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in runInCageExceptionsTask() method from CODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getAwbToQuerySTAT44() throws BizDelegateException {
        try {
            return getCODFacade().getAwbToQuerySTAT44();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAwbToQuerySTAT44() method from CODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void saveSTAT44Scans(Collection col) throws BizDelegateException {
        try {
            getCODFacade().saveSTAT44Scans(col);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveSTAT44Scans() method from CODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }
/*
    public boolean loadInvoices(Collection colRec, String filename) throws BizDelegateException {
        try {
            return getCODFacade().loadInvoices(colRec, filename);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in loadInvoices() method from CODFacadeBean class";
            Constants.logger.debug(Utils.stackTraceToString(e));
            throw new BizDelegateException(errorMsg, e);

        }
    }
*/
    public Collection getCODFilesImportingStatus(String empId) throws BizDelegateException {
        try {
            return getCODFacade().getCodFilesImportingStatus(empId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCODFilesImportingStatus() method from CODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getCODFilesImportingDetails(int logId) throws BizDelegateException {
        try {
            return getCODFacade().getCodFilesImportingDetails(logId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCODFilesImportingDetails() method from CODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    private CODFacade getCODFacade() throws java.rmi.RemoteException, ServiceLocatorException, CreateException {
        //ServiceLocator service=ServiceLocator.getInstance();
        CODFacadeHome home = (CODFacadeHome) ServiceLocator.getInstance().getEJBHome(Constants.CODFacadeEJB_Remote, CODFacadeHome.class);
        CODFacade remote = home.create();
        return remote;
    }

    public Collection saveScans(Collection scans, String currentCurrency, double exchRate) throws BizDelegateException {
        try {
            return getCODFacade().saveScans(scans, currentCurrency, exchRate);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in saveScans() method of class CODBizDelegate", e);
        }

    }

    public void splitCurrency(Collection COD_receivables, String tabType, double exchangeRate, double amountToChange) throws BizDelegateException {
        try {
            getCODFacade().splitCurrency(COD_receivables, tabType, exchangeRate, amountToChange);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) method of class CODBizDelegate", e);
        }
    }

    public Hashtable getSplitCourierCashRecapTable(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getCODFacade().getSplitCourierCashRecapTable(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getSplitCourierCashRecapTable(String locationCd,String employeeId) method of class CODBizDelegate", e);
        }
    }

    public Collection applyPaymentToInvoices(String courierId, String locationCd, String countryCd, String paymentCurrency, int paymentType, String otherDocNbr, boolean isCash, boolean isFindByAWB, Collection invoices) throws BizDelegateException {
        try {
            return getCODFacade().applyPaymentToInvoices(courierId, locationCd, countryCd, paymentCurrency, paymentType, otherDocNbr, isCash, isFindByAWB, invoices);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) method of class CODBizDelegate", e);
        }
    }

    public TotalSummaryVO getCODDetailsTotal(String locationCd, String employeeId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getCODFacade().getCODDetailsTotal(locationCd, employeeId, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getCODDetailsTotal() method of class CODBizDelegate", e);
        }
    }

    public TotalSummaryVO getCODDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getCODFacade().getCODDetailsSplitTotal(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getCODDetailsSplitTotal() method of class CODBizDelegate", e);
        }
    }
}
