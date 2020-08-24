package com.fedex.lacitd.cashcontrol.biztier.facades;

import com.fedex.lacitd.cashcontrol.biztier.common.TotalSummaryVO;
import com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PoaPaymentVO;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Hashtable;

/**
 * Created 18/11/2003 15:54:49
 * Code generated by the Sun ONE Studio EJB Builder
 *
 * @author ccardenas
 */

public interface PrepPoaFacade extends javax.ejb.EJBObject {
    public void applyPrepaidChanges(java.util.Collection colChanges) throws RemoteException, FacadeException;

    public Collection applyPrepaidScans(java.util.Collection colPrep) throws RemoteException, FacadeException;

    public void applyPrepNotCheckedScans(Collection colScansVISA) throws FacadeException, RemoteException;

    public void changePOAPaymentCurrency(int poaPaymentId, String newCurrency) throws RemoteException, FacadeException;

    public Hashtable getPoaSummaryTable(String locationCd, String courierId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws RemoteException, FacadeException;

    public Collection getPoaUsedCurrencies(String locationCodePk, String employeeCodePk) throws java.rmi.RemoteException, FacadeException;

    public Hashtable getPrepaidDetailsTable(String locationCodePk, String employeeCodePk, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws RemoteException, FacadeException;

    public Hashtable getPrepaidDiscrepanciesTable(String locationCd, Integer pageNumber) throws RemoteException, FacadeException;

    public Collection getPrepaidUsedCurrencies(String locationCodePk, String employeeCodePk) throws RemoteException, FacadeException;

    public Collection processVISAFile(Collection colVISA) throws FacadeException, RemoteException;

    public void updatePoaPayment(PoaPaymentVO ppVO, Collection pdCol) throws RemoteException, FacadeException;

    public int savePoaPayment(PoaPaymentVO ppVO, Collection pdCol) throws RemoteException, FacadeException;

    public void savePrepaidDscr(Collection dscr, java.lang.String employeeId) throws RemoteException, FacadeException;

    public double getSurchargesTotalByPoaDetail(int poaDetail) throws RemoteException, FacadeException;

    public Hashtable getPoaOustInvoices(String accountNbr, String invoiceNbr, Integer pageNumber) throws RemoteException, FacadeException;

    public void updatePRPWithScanProcessed(Collection awbs) throws RemoteException, FacadeException;

    public Collection getLocationsRIHFeed() throws RemoteException, FacadeException;

    public Hashtable getSplitPrepaidTable(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException, RemoteException;

    public void splitCurrency(Collection prepaids, String currencyCd, double exchangeRate, double amountToChange) throws FacadeException, RemoteException;

    public Collection getAllPreStatus() throws FacadeException, RemoteException;

    public TotalSummaryVO getPrepaidDetailsTotal(String locationCodePk, String employeeCodePk, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws RemoteException, FacadeException;

    public TotalSummaryVO getPrepaidDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws RemoteException, FacadeException;

    public Hashtable getGroundDetailsTable(String locationCd, String employeeId, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws RemoteException, FacadeException;

    public Hashtable getSplitGroundDetailsTable(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws RemoteException, FacadeException;

    public Collection getGroundUsedCurrencies(String locationCd, String courier) throws RemoteException, FacadeException;

    public Collection saveGrndTrakNbrs(java.util.Collection colTrakNbrs) throws FacadeException, RemoteException;

    public void applyGroundChanges(Collection trackNbrs) throws FacadeException, RemoteException;

    public TotalSummaryVO getGroundDetailsTotal(String locationCd, String employeeId, String currentCurrencyCd, Integer pageNumber, Integer rowsByPage) throws FacadeException, RemoteException;

    public TotalSummaryVO getGroundDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage) throws FacadeException, RemoteException;

    public TotalSummaryVO getPoaDetailsTotal(String locationCodePk, String employeeCodePk, String currencyCode, Integer pageNumber, Integer rowsByPage) throws RemoteException, FacadeException;

    public void applyOacChanges(Collection colChanges) throws FacadeException, RemoteException;

    public Hashtable getOacDetailsTable(String locationCd, String courier, String currentCurrency, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException, RemoteException;

    public Collection getAwbsToOacs(String locationCd, String employeeId, String currencyCode) throws FacadeException, RemoteException;

    public Hashtable getSplitOacTable(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException, RemoteException;

    public void splitOacCurrency(Collection oacs, String currencyCd, double exchangeRate, double amountToChange) throws FacadeException, RemoteException;

    public Collection getOacUsedCurrencies(String locationCd, String employeeId) throws FacadeException, RemoteException;

    public TotalSummaryVO getOacDetailsTotal(String locationCd, String employeeId, String currentCurrencyCd, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException, RemoteException;

    public TotalSummaryVO getOacDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException, RemoteException;

    public void saveOacs(Collection oacList, String locationCd) throws FacadeException, RemoteException;

    public void splitGroundCurrency(Collection groundsSelected, String currencyCode, double exchangeRate, double amountToChange) throws FacadeException, RemoteException;
    
    public boolean isInvoiceFedexAcctMatch(String accountNbr, String invoiceNbr) throws FacadeException, RemoteException;
}