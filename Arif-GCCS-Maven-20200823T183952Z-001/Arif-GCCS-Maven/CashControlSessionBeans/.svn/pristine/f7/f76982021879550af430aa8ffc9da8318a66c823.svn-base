/**
 * DataHarvestBizDelegate.java
 *
 * Created on 11 de julio de 2002, 07:11 PM
 */

package com.fedex.lacitd.cashcontrol.biztier.bizdelegates;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.TotalSummaryVO;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.biztier.facades.PrepPoaFacade;
import com.fedex.lacitd.cashcontrol.biztier.facades.PrepPoaFacadeHome;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
//import com.fedex.lacitd.cashcontrol.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PoaPaymentVO;

import javax.ejb.CreateException;
import java.util.Collection;
import java.util.Hashtable;


/**
 * @author ccardenas
 */
public class PrepPoaBizDelegate implements java.io.Serializable {

    /**
     * Creates a new instance of DataHarvestBizDelegate
     */
    public PrepPoaBizDelegate() {
    }


    public void applyPrepaidChanges(Collection colPrep) throws BizDelegateException {
        try {
            getPrepPoaFacade().applyPrepaidChanges(colPrep);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in applyPrepaidChanges() method of class RODBizDelegate", e);
        }
    }

    public Collection applyPrepaidScans(Collection colPrep) throws BizDelegateException {
        try {
            return getPrepPoaFacade().applyPrepaidScans(colPrep);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in applyPrepaidScans() method of class RODBizDelegate", e);
        }
    }

    public Hashtable getPrepaidDetailsTable(String locationCd, String employeeId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getPrepaidDetailsTable(locationCd, employeeId, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getPrepaidDetailsTable() method of class PrepPoaBizDelegate", e);
        }
    }


    public java.util.Collection getPrepaidUsedCurrencies(java.lang.String locationCd, java.lang.String employeeId) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getPrepaidUsedCurrencies(locationCd, employeeId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getPrepaidUsedCurrencies() method from PrepPoaFacadeBean class";
            throw new BizDelegateException(e.getMessage(), e);
        }
    }

    public java.util.Collection getPoaUsedCurrencies(java.lang.String locationCd, java.lang.String employeeId) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getPoaUsedCurrencies(locationCd, employeeId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getPoaUsedCurrencies() method from PrepPoaFacadeBean class";
            throw new BizDelegateException(e.getMessage(), e);
        }
    }

    public Collection processVISAFile(Collection colVISA) throws BizDelegateException {
        try {
            return getPrepPoaFacade().processVISAFile(colVISA);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in processVISAFile() method from PrepPoaFacadeBean class";
            throw new BizDelegateException(e.getMessage(), e);
        }
    }

    public void applyPrepNotCheckedScans(Collection colScansVISA) throws BizDelegateException {
        try {
            getPrepPoaFacade().applyPrepNotCheckedScans(colScansVISA);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in applyPrepNotCheckedScans() method from PrepPoaFacadeBean class";
            throw new BizDelegateException(e.getMessage(), e);
        }
    }

    public void changePOAPaymentCurrency(int poaPaymentId, String newCurrency) throws BizDelegateException {
        try {
            getPrepPoaFacade().changePOAPaymentCurrency(poaPaymentId, newCurrency);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in changePOAPaymentCurrency() method from PrepPoaFacadeBean class";
            throw new BizDelegateException(e.getMessage(), e);
        }
    }

    public Hashtable getPoaSummaryTable(String locationCd, String courierId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getPoaSummaryTable(locationCd, courierId, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getPoaSummaryTable() method from PrepPoaFacadeBean class";
            throw new BizDelegateException(e.getMessage(), e);
        }
    }

    public void updatePoaPayment(PoaPaymentVO ppVO, Collection pdCol) throws BizDelegateException {
        try {
            getPrepPoaFacade().updatePoaPayment(ppVO, pdCol);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in updatePoaPayment() method from PrepPoaFacadeBean class";
            throw new BizDelegateException(e.getMessage(), e);
        }
    }

    public int savePoaPayment(PoaPaymentVO ppVO, Collection pdCol) throws BizDelegateException {
        try {
            return getPrepPoaFacade().savePoaPayment(ppVO, pdCol);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in savePoaPayment() method from PrepPoaFacadeBean class";
            throw new BizDelegateException(e.getMessage(), e);
        }
    }

    private PrepPoaFacade getPrepPoaFacade() throws java.rmi.RemoteException, ServiceLocatorException, CreateException {
        PrepPoaFacadeHome home = (PrepPoaFacadeHome) ServiceLocator.getInstance().getEJBHome(Constants.PrepPoaFacadeEJB_Remote, PrepPoaFacadeHome.class);
        PrepPoaFacade remote = home.create();
        return remote;
    }

    public Hashtable getPrepaidDiscrepanciesTable(String locationCd, Integer pageNumber) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getPrepaidDiscrepanciesTable(locationCd, pageNumber);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getPrepaidDiscrepanciesTable() method of class RODBizDelegate", e);
        }

    }

    public void savePrepaidDscr(Collection dscr, String empId) throws BizDelegateException {
        try {
            getPrepPoaFacade().savePrepaidDscr(dscr, empId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in savePrepaidDscr() method of class RODBizDelegate", e);
        }

    }

    public double getSurchargesTotalByPoaDetail(int poaDetailId) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getSurchargesTotalByPoaDetail(poaDetailId);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getSurchargesTotalByPoaDetail() method of class RODBizDelegate", e);
        }

    }

    public Hashtable getPoaOustInvoices(String accountNbr, String invoiceNbr, Integer pageNumber) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getPoaOustInvoices(accountNbr, invoiceNbr, pageNumber);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizDelegateException("ocurred an exception in getPoaOustInvoices() method of class RODBizDelegate", e);
        }

    }

    public void updatePRPWithScanProcessed(Collection awbs) throws BizDelegateException {
        try {
            getPrepPoaFacade().updatePRPWithScanProcessed(awbs);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in updatePRPWithScanProcessed(Collection awbs) method of class RODBizDelegate", e);
        }
    }

    public void splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) throws BizDelegateException {
        try {
            getPrepPoaFacade().splitCurrency(receivables, tabType, exchangeRate, amountToChange);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) method of class RODBizDelegate", e);
        }
    }

    public Hashtable getSplitPrepaidTable(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getSplitPrepaidTable(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getSplitCourierCashRecapTable(String locationCd,String employeeId) method of class PrepPoaBizDelegate", e);
        }
    }

    public Collection getLocationsRIHFeed() throws BizDelegateException {
        try {
            return getPrepPoaFacade().getLocationsRIHFeed();
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in updatePRPWithScanProcessed(Collection awbs) method of class RODBizDelegate", e);
        }
    }

    public Collection getAllPreStatus() throws BizDelegateException {
        try {
            return getPrepPoaFacade().getAllPreStatus();
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getAllPreStatus() method of class PrepPoaBizDelegate", e);
        }
    }

    public TotalSummaryVO getPrepaidDetailsTotal(String locationCd, String employeeId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getPrepaidDetailsTotal(locationCd, employeeId, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getPrepaidDetailsTotal() method of class PrepPoaBizDelegate", e);
        }
    }

    public TotalSummaryVO getPrepaidDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getPrepaidDetailsSplitTotal(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getPrepaidDetailsSplitTotal() method of class PrepPoaBizDelegate", e);
        }
    }

    public Hashtable getGroundDetailsTable(String locationCd, String employeeId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getGroundDetailsTable(locationCd, employeeId, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getGroundDetailsTable() method of class PrepPoaBizDelegate", e);
        }
    }

    public Hashtable getSplitGroundTable(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getSplitGroundDetailsTable(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getSplitGroundTable() method of class PrepPoaBizDelegate", e);
        }
    }

    public Collection getGroundUsedCurrencies(String locationCd, String courier) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getGroundUsedCurrencies(locationCd, courier);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getGroundUsedCurrencies(String locationCd, String courier) method of class PrepPoaBizDelegate", e);
        }
    }

    public Collection saveGrndTrakNbrs(Collection colTrakNbrs) throws BizDelegateException {
        try {
            return getPrepPoaFacade().saveGrndTrakNbrs(colTrakNbrs);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in applyPrepaidScans() method of class PrepPoaBizDelegate", e);
        }
    }

    public void applyGroundChanges(Collection trackNbrs) throws BizDelegateException {
        try {
            getPrepPoaFacade().applyGroundChanges(trackNbrs);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in applyGroundChanges(Collection trackNbrs) method of class PrepPoaBizDelegate", e);
        }
    }

    public TotalSummaryVO getGroundDetailsTotal(String locationCd, String employeeId, String currentCurrencyCd, Integer pageNumber, Integer rowsByPage) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getGroundDetailsTotal(locationCd, employeeId, currentCurrencyCd, pageNumber, rowsByPage);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getGroundDetailsTotal(String locationCd, String employeeId, String currentCurrencyCd, Integer pageNumber, Integer rowsByPage) method of class PrepPoaBizDelegate", e);
        }
    }

    public TotalSummaryVO getGroundDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getGroundDetailsSplitTotal(locationCd, employeeId, pageNumber, rowsByPage);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getGroundDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage) method of class PrepPoaBizDelegate", e);
        }
    }

    public TotalSummaryVO getPoaDetailsTotal(String locationCd, String employeeId, String currencyCode, Integer pageNumber, Integer rowsByPage) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getPoaDetailsTotal(locationCd, employeeId, currencyCode, pageNumber, rowsByPage);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getPoaDetailsTotal() method of class PrepPoaBizDelegate", e);
        }
    }

    public Hashtable getOacDetailsTable(String locationCd, String courier, String currentCurrency, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getOacDetailsTable(locationCd, courier, currentCurrency, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getOacDetailsTable() method of class PrepPoaBizDelegate", e);
        }
    }

    public Collection getAwbsToOacs(String locationCd, String courier, String currentCurrency) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getAwbsToOacs(locationCd, courier, currentCurrency);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getAwbsToOacs(String locationCd, String courier, String currentCurrency) method of class PrepPoaBizDelegate", e);
        }
    }

    public Hashtable getSplitOacTable(String locationCd, String courier, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getSplitOacTable(locationCd, courier, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in getSplitOacTable(String locationCd, String courier, Integer pageNumber, Integer integer, String sortColumn, String sortDirection) method of class PrepPoaBizDelegate", e);
        }
    }

    public void splitOacCurrency(Collection oacs, String tabType, double exchangeRate, double amountToChange) throws BizDelegateException {
        try {
            getPrepPoaFacade().splitOacCurrency(oacs, tabType, exchangeRate, amountToChange);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in splitOacCurrency(Collection oacs, String tabType, double exchangeRate, double amountToChange) method of class RODBizDelegate", e);
        }
    }

    public java.util.Collection getOacUsedCurrencies(java.lang.String locationCd, java.lang.String employeeId) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getOacUsedCurrencies(locationCd, employeeId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getOacUsedCurrencies() method from PrepPoaFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public TotalSummaryVO getOacDetailsTotal(String locationCd, String employeeId, String currentCurrencyCd, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getOacDetailsTotal(locationCd, employeeId, currentCurrencyCd, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getOacDetailsTotal() method from PrepPoaFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }
    }

    public TotalSummaryVO getOacDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws BizDelegateException {
        try {
            return getPrepPoaFacade().getOacDetailsSplitTotal(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getOacDetailsSplitTotal() method from PrepPoaFacadeBean class";
            throw new BizDelegateException(errorMsg, e);
        }

    }

    public void applyOacChanges(Collection oacs) throws BizDelegateException {
        try {
            getPrepPoaFacade().applyOacChanges(oacs);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in applyOacChanges(Collection oacs) method of class RODBizDelegate", e);
        }
    }

    public void saveOacs(Collection oacList, String locationCd) throws BizDelegateException {
        try {
            getPrepPoaFacade().saveOacs(oacList, locationCd);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in saveOacs(Collection oacList) method of class RODBizDelegate", e);
        }

    }

    public void splitGroundCurrency(Collection groundsSelected, String currencyCode, double exchangeRate, double amountToChange) throws BizDelegateException {
        try {
            getPrepPoaFacade().splitGroundCurrency(groundsSelected, currencyCode, exchangeRate, amountToChange);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in splitGroundCurrency(Collection groundsSelected, String currencyCode, double exchangeRate, double amountToChange) method of class PrepPoaBizDelegate", e);
        }

    }
    
    /*
     * Author: Sendil
     * Find wether the Invoice and Fedex account found a match
     * in outstading invoice table 
     */
    public boolean isInvoiceFedexAcctMatch(String accountNbr, String invoiceNbr) throws BizDelegateException {
        try {
            return getPrepPoaFacade().isInvoiceFedexAcctMatch(accountNbr, invoiceNbr);
        } catch (Exception e) {
            throw new BizDelegateException("ocurred an exception in isInvoiceFedexAcctMatch() method of class PrepPoaBizDelegate", e);
        }

    }
}
