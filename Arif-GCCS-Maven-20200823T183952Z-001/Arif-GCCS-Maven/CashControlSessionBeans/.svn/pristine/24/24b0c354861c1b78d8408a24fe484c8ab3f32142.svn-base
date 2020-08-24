/**
 * DataHarvestBizDelegate.java
 *
 * Created on 11 de julio de 2002, 07:11 PM
 */

package com.fedex.lacitd.cashcontrol.biztier.bizdelegates;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.TotalSummaryVO;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.biztier.facades.RODFacade;
import com.fedex.lacitd.cashcontrol.biztier.facades.RODFacadeHome;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
//import com.fedex.lacitd.cashcontrol.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ReceivablesVO;

import javax.ejb.CreateException;
import java.util.Collection;
import java.util.Hashtable;


/**
 * @author ccardenas
 */
public class RODBizDelegate implements java.io.Serializable {

    /**
     * Creates a new instance of DataHarvestBizDelegate
     */
    public RODBizDelegate() {
    }

    public void loadInvoices(Collection colRec) throws BizDelegateException {
        try {
            getRODFacade().loadInvoices(colRec);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in loadInvoices() method of class RODBizDelegate", e);
        }
    }

    public Collection getAwbToQueryCosmos(String locationCd, String employeeId) throws BizDelegateException {
        try {
            return getRODFacade().getAwbToQueryCosmos(locationCd, employeeId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getAwbToQueryCosmos() method of class RODBizDelegate", e);
        }
    }


    public Collection applyScans(Collection colChanges) throws BizDelegateException {
        try {
            return getRODFacade().applyScans(colChanges);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in applyScans() method of class RODBizDelegate", e);
        }
    }

    public Hashtable getCourierCashRecapTable(String locationCd, String employeeId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getRODFacade().getCourierCashRecapTable(locationCd, employeeId, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getPaymentsSummaryByEmp() method of class RODBizDelegate", e);
        }
    }

    public Collection getAllRecStatus() throws BizDelegateException {
        try {
            return getRODFacade().getAllRecStatus();
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getAllRecStatus() method of class RODBizDelegate", e);
        }
    }

    public void changeRecPaymentCurrency(int recPk, String newCurrency) throws BizDelegateException {
        try {
            getRODFacade().changeRecPaymentCurrency(recPk, newCurrency);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in changeRecPaymentCurrency() method of class RODBizDelegate", e);
        }
    }

    public void changeRecCurrency(int recPk, String newCurrency) throws BizDelegateException {
        try {
            getRODFacade().changeRecCurrency(recPk, newCurrency);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in changeRecCurrency() method of class RODBizDelegate", e);
        }
    }

    public void applyCheckinAgentChanges(java.util.Collection colChanges) throws BizDelegateException {
        try {
            getRODFacade().applyCheckinAgentChanges(colChanges);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in applyCheckinAgentChanges() method of class RODBizDelegate", e);
        }
    }

    public boolean addReceivable(ReceivablesVO recVO) throws BizDelegateException {
        try {
            return getRODFacade().addReceivable(recVO);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in addReceivable() method of class RODBizDelegate", e);
        }
    }

    public ReceivablesVO getReceivables(int recPk) throws BizDelegateException {
        try {
            return getRODFacade().getReceivables(recPk);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getReceivables() method of class RODBizDelegate", e);
        }
    }

    public Collection getInvoicesByAwb(String awbNumber) throws BizDelegateException {
        try {
            return getRODFacade().getInvoicesByAwb(awbNumber);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getInvoicesByAwb() method of class RODBizDelegate", e);
        }
    }

    public int reassignReceivableToCourier(int recPk, String locationCd, String employeeId) throws BizDelegateException {
        try {
            return getRODFacade().reassignReceivableToCourier(recPk, locationCd, employeeId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in reassignReceivableToCourier() method of class RODBizDelegate", e);
        }
    }


    public Collection getCouriersWithPendents(String location) throws BizDelegateException {
        try {
            return getRODFacade().getCouriersWithPendents(location);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCouriersWithPendents() method from RODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public java.util.Collection getRODUsedCurrencies(java.lang.String locationCd, java.lang.String employeeId) throws BizDelegateException {
        try {
            return getRODFacade().getRODUsedCurrencies(locationCd, employeeId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getRODUsedCurrencies() method from RODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void runInCageExceptionsTask() throws BizDelegateException {
        try {
            getRODFacade().runInCageExceptionsTask();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in runInCageExceptionsTask() method from RODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getAwbToQuerySTAT44() throws BizDelegateException {
        try {
            return getRODFacade().getAwbToQuerySTAT44();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAwbToQuerySTAT44() method from RODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public void saveSTAT44Scans(Collection col) throws BizDelegateException {
        try {
            getRODFacade().saveSTAT44Scans(col);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveSTAT44Scans() method from RODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public boolean loadInvoices(Collection colRec, String filename) throws BizDelegateException {
        try {
            return getRODFacade().loadInvoices(colRec, filename);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in loadInvoices() method from RODFacadeBean class";
            Constants.logger.debug(Utils.stackTraceToString(e));
            throw new BizDelegateException(errorMsg, e);

        }
    }

    public Collection getRodFilesImportingStatus(String empId) throws BizDelegateException {
        try {
            return getRODFacade().getRodFilesImportingStatus(empId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getRodFilesImportingStatus() method from RODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public Collection getRodFilesImportingDetails(int logId) throws BizDelegateException {
        try {
            return getRODFacade().getRodFilesImportingDetails(logId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getRodFilesImportingDetails() method from RODFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    private RODFacade getRODFacade() throws java.rmi.RemoteException, ServiceLocatorException, CreateException {
        //ServiceLocator service=ServiceLocator.getInstance();
        RODFacadeHome home = (RODFacadeHome) ServiceLocator.getInstance().getEJBHome(Constants.RODFacadeEJB_Remote, RODFacadeHome.class);
        RODFacade remote = home.create();
        return remote;
    }

    public Collection saveScans(Collection scans, String currentCurrency, double exchRate) throws BizDelegateException {
        try {
            return getRODFacade().saveScans(scans, currentCurrency, exchRate);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in saveScans() method of class RODBizDelegate", e);
        }

    }

    public void splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) throws BizDelegateException {
        try {
            getRODFacade().splitCurrency(receivables, tabType, exchangeRate, amountToChange);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) method of class RODBizDelegate", e);
        }
    }

    public Hashtable getSplitCourierCashRecapTable(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getRODFacade().getSplitCourierCashRecapTable(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getSplitCourierCashRecapTable(String locationCd,String employeeId) method of class RODBizDelegate", e);
        }
    }

    public Collection applyPaymentToInvoices(String courierId, String locationCd, String countryCd, String paymentCurrency, int paymentType, String otherDocNbr, boolean isCash, boolean isFindByAWB, Collection invoices) throws BizDelegateException {
        try {
            return getRODFacade().applyPaymentToInvoices(courierId, locationCd, countryCd, paymentCurrency, paymentType, otherDocNbr, isCash, isFindByAWB, invoices);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) method of class RODBizDelegate", e);
        }
    }

    public TotalSummaryVO getRODDetailsTotal(String locationCd, String employeeId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getRODFacade().getRODDetailsTotal(locationCd, employeeId, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getRODDetailsTotal() method of class RODBizDelegate", e);
        }
    }

    public TotalSummaryVO getRODDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getRODFacade().getRODDetailsSplitTotal(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getRODDetailsSplitTotal() method of class RODBizDelegate", e);
        }
    }
}
