package com.fedex.lacitd.cashcontrol.biztier.facades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;
import javax.ejb.EJBException;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.CourierCashRecapTableVO;
import com.fedex.lacitd.cashcontrol.biztier.common.RecChangesFromScans;
import com.fedex.lacitd.cashcontrol.biztier.common.ReceivablesSurchargesVO;
import com.fedex.lacitd.cashcontrol.biztier.common.ScansProcessingError;
import com.fedex.lacitd.cashcontrol.biztier.common.TotalSummaryVO;
import com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.controller.CosmosScanController;
import com.fedex.lacitd.cashcontrol.datatier.controller.EmployeeController;
import com.fedex.lacitd.cashcontrol.datatier.controller.RecExpSrchgController;
import com.fedex.lacitd.cashcontrol.datatier.controller.ReceivablesController;
import com.fedex.lacitd.cashcontrol.datatier.controller.RodFileProcLogController;
import com.fedex.lacitd.cashcontrol.datatier.controller.SurchargesController;
import com.fedex.lacitd.cashcontrol.datatier.dao.CommonOpsDaoLocal;
import com.fedex.lacitd.cashcontrol.datatier.dao.CommonOpsDaoLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.dao.RODDaoLocal;
import com.fedex.lacitd.cashcontrol.datatier.dao.RODDaoLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.entities.BankAccLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.entities.DepositSlipLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.entities.EmployeeLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.entities.PoaPaymentLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.entities.ReceivablesLocal;
import com.fedex.lacitd.cashcontrol.datatier.entities.ReceivablesLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ReceivablesException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CosmosScanVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RecExpSrchgVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ReceivablesVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RodFileProcLogVO;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.SurchargesVO;

public class RODFacadeBean implements javax.ejb.SessionBean {
    private javax.ejb.SessionContext context;


    /**
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(javax.ejb.SessionContext aContext) {
        context = aContext;
    }


    /**
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() {

    }


    /**
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() {

    }


    /**
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() {

    }


    /**
     * See section 7.10.3 of the EJB 2.0 specification
     */
    public void ejbCreate() {

    }

    public void loadInvoices(Collection colRec) throws FacadeException {
        try {
            ReceivablesController rc = new ReceivablesController();
            Iterator iterRec = colRec.iterator();
            while (iterRec.hasNext()) {
                ReceivablesVO recVO = (ReceivablesVO) iterRec.next();
                rc.setReceivables(recVO);
            }

        } catch (Exception e) {
            context.setRollbackOnly();
            throw new FacadeException("Exception ocurred in loadInvoices() method from RODFacadeBean: " + e.toString(), e);
        }
    }


    public boolean loadInvoices(Collection colRec, String filename) throws FacadeException {
        RodFileProcLogVO rlog = null;
        try {
            rlog = new RodFileProcLogVO();
            rlog.setFileNm(filename);

            if (colRec.isEmpty()) {
                rlog.setProcessDt(new java.util.Date());
            } else {
                rlog.setProcessDt(((ReceivablesSurchargesVO) ((List) colRec).get(0)).getReceivable().getRodXmlImpDt());
            }

            RODDaoLocal dao = getRODDaoLocal();

            //If the file was not processed successfully before
            if (!dao.existsFileProcessed(filename)) {
                Map mapLoc = new HashMap();
                Map mapLocLog = new HashMap();
                ReceivablesController rc = new ReceivablesController();
                RecExpSrchgController rsc = new RecExpSrchgController();
                String msg = "No errors";
                Iterator iterRec = colRec.iterator();
                SurchargesController sc = new SurchargesController();

                //Iterate between Receivables List
                while (iterRec.hasNext()) {
                    ReceivablesSurchargesVO rsVO = (ReceivablesSurchargesVO) iterRec.next();
                    ReceivablesVO recVO = rsVO.getReceivable();

                    RodFileProcLogVO locLog = (RodFileProcLogVO) mapLocLog.get(recVO.getLocationCd());
                    if (locLog == null) {
                        locLog = new RodFileProcLogVO();
                        locLog.setFileNm(rlog.getFileNm());
                        locLog.setProcessDt(rlog.getProcessDt());
                        locLog.setLocationCd(recVO.getLocationCd());

                        mapLocLog.put(recVO.getLocationCd(), locLog);
                    }

                    locLog.setAwbQty(locLog.getAwbQty() + 1);
                    if ("USD".equals(recVO.getInvCurrency())) {
                        locLog.setTotalUsdAmt(locLog.getTotalUsdAmt() + recVO.getRecAmt());
                    } else {
                        locLog.setTotalLocalAmt(locLog.getTotalLocalAmt() + recVO.getRecAmt());
                    }

                    //if the invoice was not in the db
                    if (!dao.existsRecDuplicates(recVO)) {
                        Integer recId = setReceivables(recVO); //inserting Receivable

                        Collection colSurcharges = rsVO.getRecExpSurcharges(); //getting the surcharges related to the receivable

                        //If there are surcharges
                        if (colSurcharges != null && !colSurcharges.isEmpty()) {
                            Collection colValidSC = null;

                            //If the valid surcharges are in the Map
                            if (mapLoc.get(recVO.getLocationCd()) != null) {
                                colValidSC = (Collection) mapLoc.get(recVO.getLocationCd());
                            } else {//If the valid surcharges are NOT in the Map
                                //Obtain from the DB
                                Collection colSC = sc.getSurchargesByRod(recVO.getLocationCd());
                                colValidSC = new ArrayList();
                                if (colSC != null) {
                                    Iterator it = colSC.iterator();
                                    while (it.hasNext()) {
                                        SurchargesVO sVO = (SurchargesVO) it.next();
                                        colValidSC.add(sVO.getSurchargeCd());
                                    }
                                }
                                mapLoc.put(recVO.getLocationCd(), colValidSC); //Put the location and its valid surcharges codes
                            }

                            Iterator iterSC = colSurcharges.iterator();
                            while (iterSC.hasNext()) {
                                RecExpSrchgVO esVO = (RecExpSrchgVO) iterSC.next();
                                if (colValidSC.contains(esVO.getSurchargeCd())) {
                                    esVO.setRecId(recId);
                                    rsc.setRecExpSrchg(esVO);
                                } else {
                                    rlog.setMessage("The surcharge type " + esVO.getSurchargeCd() + " is not allowed for ROD in the location. AWB " + recVO.getAwbNbr());
                                    rlog.setStatusCd(0);
                                    rlog.setLocationCd(recVO.getLocationCd());
                                    dao.insertRODFileProcLog(rlog);
                                    context.setRollbackOnly();
                                    return false;
                                }
                            }
                        } else { //If there were NOT surcharges
                            mapLoc.put(recVO.getLocationCd(), null);//Put the location
                        }
                    } else { //If the file was in the db
                        mapLoc.put(recVO.getLocationCd(), null);
                        msg = "The file contains duplicate invoices.";
                    }
                }

                Iterator iterLoc = mapLocLog.values().iterator();
                while (iterLoc.hasNext()) {
                    RodFileProcLogVO log = ((RodFileProcLogVO) iterLoc.next());
                    log.setMessage(msg);
                    log.setStatusCd(1);
                    dao.insertRODFileProcLog(log);
                }
            } else {
                rlog.setMessage("The file was processed previously.");
                rlog.setStatusCd(0);
                rlog.setLocationCd("");
                new RodFileProcLogController().setRodFileProcLog(rlog);
            }
            return true;
        } catch (BusinessDelegateException e) {
            Constants.logger.debug("Exception ocurred in loadInvoices() method from RODFacadeBean: \n" + Utils.stackTraceToString(e));
            return false;
        } catch (Exception e) {
            rlog.setMessage(e.getMessage());
            rlog.setStatusCd(0);
            rlog.setLocationCd("");
            try {
                new RodFileProcLogController().setRodFileProcLog(rlog);
            } catch (BusinessDelegateException e1) {
                Constants.logger.debug("Exception ocurred in loadInvoices() method from RODFacadeBean: \n" + Utils.stackTraceToString(e1));
            }

            Constants.logger.debug("Exception ocurred in loadInvoices() method from RODFacadeBean: \n" + Utils.stackTraceToString(e));
            return true;
        }
    }

    public Collection getAwbToQueryCosmos(String locationCodePk, String employeeCodePk) throws FacadeException {
        try {
            return getRODDaoLocal().getAwbToQueryCosmos(locationCodePk, employeeCodePk);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAwbToQueryCosmos() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    private RODDaoLocal getRODDaoLocal() throws ServiceLocatorException, CreateException {
        RODDaoLocalHome daoHome = (RODDaoLocalHome) ServiceLocator.getInstance().getEJBLocalHome(Constants.RODDaoEJB_Local);
        RODDaoLocal dao = daoHome.create();
        return dao;
    }

    private SystemUtilsLocal getSystemUtilsLocal() throws ServiceLocatorException, CreateException {
        SystemUtilsLocalHome utilHome = (SystemUtilsLocalHome) ServiceLocator.getInstance().getEJBLocalHome(Constants.SystemUtilsEJB_Local);
        SystemUtilsLocal util = utilHome.create();
        return util;
    }

    public Collection applyScans(java.util.Collection colChanges) throws FacadeException {
        try {
            return getRODDaoLocal().applyRODScans(colChanges);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in applyScans() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    public Hashtable getCourierCashRecapTable(String locationCodePk, String employeeCodePk, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getRODDaoLocal().getCourierCashRecapTable(locationCodePk, employeeCodePk, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCourierCashRecapTable() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    public Collection getAllRecStatus() throws FacadeException {
        try {
            return getRODDaoLocal().getAllRecStatus();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAllRecStatus() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void applyCheckinAgentChanges(java.util.Collection colChanges) throws FacadeException {
        Collection colErrors = new ArrayList();
        Iterator iterChanges = colChanges.iterator();

        while (iterChanges.hasNext()) {
            CourierCashRecapTableVO recChanges = (CourierCashRecapTableVO) iterChanges.next();

            ReceivablesController recContr = null;
            ReceivablesVO recVO = null;
            try {
                recContr = new ReceivablesController();
                recVO = recContr.getReceivables(new Integer(recChanges.getRecId()));

                recVO.setCashPaymentAmt(recChanges.getRecCashPayment());
                recVO.setOtherPaymentAmt(recChanges.getRecOtherPayment());
                recVO.setOtherDocNbr(recChanges.getRecOtherDocNumber());
                recVO.setOtherPaymentType(recChanges.getOtherPaymentType());
                recVO.setChkinAgentComment(recChanges.getOtherComment());
                recVO.setStatusId(recChanges.getRecStatusId());
                recVO.setChngStatusEmployeeId(recChanges.getRecChngStatusEmployeeId());
                recVO.setChngStatusDt(recChanges.getRecChngStatusDate());
                recVO.setOtherComment(recChanges.getRecComment());
                recVO.setRecvPrepyAmt(recChanges.getRecvPrepyAmt());
                recVO.setbillAccount(recChanges.getBillAccount());
                //change done to add two column
                //changes applied to get the string to date
                if(recChanges.getMiscDate().length() != 0) {
                	recVO.setMiscDate(new java.text.SimpleDateFormat("MM/dd/yyyy").parse(recChanges.getMiscDate()));
                }
                
                if(recChanges.getMiscNbr() != null) {
                	recVO.setMiscNbr(recChanges.getMiscNbr());
                }

                if (recChanges.getCustChngEmpId() != null) {
                    recVO.setCustomerNm(recChanges.getCustomerNm());
                    recVO.setOrigCustNm(recChanges.getCustomerNmPrev());
                    recVO.setCustChngEmpId(recChanges.getCustChngEmpId());
                }

                if (recChanges.getAmtChngEmpId() != null) {
                    recVO.setRecAmt(recChanges.getRecAmount());
                    recVO.setOrigRecAmt(recChanges.getRecAmtPrev());
                    recVO.setAmtChngEmpId(recChanges.getAmtChngEmpId());
                }

                if (recChanges.getRcptChngEmpId() != null) {
                    recVO.setRcptNbr(recChanges.getRcptNbr());
                    recVO.setOrigRcptNbr(recChanges.getRcptNbrPrev());
                    recVO.setRcptChngEmpId(recChanges.getRcptChngEmpId());
                }

                if (recChanges.getRecDex16Amount() > 0 || recChanges.getRecCashPayment() > 0 || recChanges.getRecOtherPayment() > 0)
                {
                    recVO.setPaymentCurrency(recChanges.getRecPaymentCurrency());
                }

                recContr.updateReceivables(recVO);

            } catch (Exception e) {
                String errorMsg = e.getClass().getName() + " occurred in applyCheckinAgentChanges() method from RODFacadeBean class";
                throw new FacadeException(errorMsg, e);
            }
        }
    }

    public void changeRecCurrency(int recPk, String newCurrency) throws FacadeException {
        ReceivablesController recContr = null;
        ReceivablesVO recVO = null;
        try {
            recContr = new ReceivablesController();
            recVO = recContr.getReceivables(new Integer(recPk));
            recVO.setInvCurrency(newCurrency);
            recContr.updateReceivables(recVO);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in changeRecCurrency() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void changeRecPaymentCurrency(int recPk, String newCurrency) throws FacadeException {
        ReceivablesController recContr = null;
        ReceivablesVO recVO = null;
        try {
            recContr = new ReceivablesController();
            recVO = recContr.getReceivables(new Integer(recPk));
            recVO.setPaymentCurrency(newCurrency);
            recContr.updateReceivables(recVO);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in applyCheckinAgentChanges() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getInvoicesByAwb(String awbNumber) throws FacadeException {
        try {
            return getRODDaoLocal().getInvoicesByAwb(awbNumber);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getInvoicesByAwb() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public boolean addReceivable(com.fedex.lacitd.cashcontrol.datatier.valueobject.ReceivablesVO recVO) {
        try {
            new ReceivablesController().setReceivables(recVO);
            return true;
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            return false;
        }
    }

    public com.fedex.lacitd.cashcontrol.datatier.valueobject.ReceivablesVO getReceivables(int recPk) {
        try {
            return new ReceivablesController().getReceivables(new Integer(recPk));
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            return null;
        }
    }

    /*    
       0 : success
      -1 : unknow error
      -2 : status awb is "clear"
     */

    public int reassignReceivableToCourier(int recPk, String locationCodePk, java.lang.String employeeCodePk) {
        try
        {
            ReceivablesController con = new ReceivablesController();
            ReceivablesVO recVO = con.getReceivables(new Integer(recPk));

            // Jorge Quiroz Request Add/Reassign Receivables

            if(!(recVO.getStatusId() == 2 || recVO.getStatusId() == 4)){

                // EOD Process has been executed
                if((recVO.getEodDt() != null && recVO.getEodEmployeeId() != null) &&
                   (recVO.getStatusId() == 1 || recVO.getStatusId() == 3 || recVO.getStatusId() == 5))
                  return -2;
            }

            recVO.setLocationCd(locationCodePk);
            recVO.setEmployeeId(employeeCodePk);
            recVO.setCloseEmployeeId(null);
            recVO.setCloseDt(null);

            recVO.setEodEmployeeId(null);
            recVO.setEodDt(null);
            //changes made for the two columns added
            recVO.setMiscDate(null);
            recVO.setMiscNbr(null);

            // the status will remain unchanged
            // if status is 2 or 4 the final status is reset to NONE
            if(recVO.getStatusId() == 2 || recVO.getStatusId() == 4){
               recVO.setStatusId( 0);}

            //Validate Currency for the country
            String curResult = Utils.validateCountryCurencyInProcess(recVO.getLocationCd(), recVO.getPaymentCurrency());
            if (curResult != null) {
                recVO.setInvCurrency(curResult);
                recVO.setPaymentCurrency(curResult);
            }

            con.updateReceivables(recVO);
            return 0;
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            return -1;
        }
    }

    public Collection getCouriersWithPendents(String location) throws FacadeException {
        try {
            return getRODDaoLocal().getCouriersWithPendents(location);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCouriersWithPendents() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }

    }


    public java.util.Collection getRODUsedCurrencies(java.lang.String locationCodePk, java.lang.String employeeCodePk) throws FacadeException {
        try {
            return getRODDaoLocal().getRODUsedCurrencies(locationCodePk, employeeCodePk);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getRODUsedCurrencies() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void runInCageExceptionsTask() throws FacadeException {
        try {
            getRODDaoLocal().runInCageExceptionsTask();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in runInCageExceptionsTask() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getAwbToQuerySTAT44() throws FacadeException {
        try {
            return getRODDaoLocal().getAwbToQuerySTAT44();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAwbToQuerySTAT44() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void saveSTAT44Scans(Collection col) throws FacadeException {
        try {
            CosmosScanController csc = new CosmosScanController();
            Iterator iter = col.iterator();
            while (iter.hasNext()) {
                CosmosScanVO csVO = (CosmosScanVO) iter.next();
                int result = getCommonOpsDaoLocal().existsEmployeeLocation(csVO.getScanLocationCd(), csVO.getCourierId());
                if (result == 0 || result == 1) {
                    if (result == 1) {
                        EmployeeVO empVO = getSystemUtilsLocal().findFedExEmployee(csVO.getCourierId());
                        if (empVO == null) {
                            empVO = new EmployeeVO(csVO.getCourierId(), "Unknown Employee", "", "", "ROD", null, "0", 0, null, 0, 0, null, 1);
                        }
                        new EmployeeController().setEmployee(empVO);
                    }
                    csc.setCosmosScan(csVO);
                }
            }
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveSTAT44Scans() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getRodFilesImportingStatus(String empId) throws FacadeException {
        try {
            return getRODDaoLocal().getRodFilesImportingStatus(empId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getRodFilesImportingStatus() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getRodFilesImportingDetails(int logId) throws FacadeException {
        try {
            return getRODDaoLocal().getRodFilesImportingDetails(logId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getRodFilesImportingDetails() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    private void updateReceivables(ReceivablesVO receivablesVO)
            throws ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (receivablesVO == null) {
            throw new IllegalArgumentException("receivablesVO parameter was null in updateReceivables() method from ReceivablesManager class");
        }

        try {
            Integer recId = receivablesVO.getRecId();

            ReceivablesLocal receivablesLocal = getReceivablesLocalHome().findByPrimaryKey(recId);
            //-- update Receivables entity bean
            receivablesLocal.setRecNbr(receivablesVO.getRecNbr());
            receivablesLocal.setCustomerNm(receivablesVO.getCustomerNm());
            receivablesLocal.setRecDt(receivablesVO.getRecDt());
            receivablesLocal.setInvCurrency(receivablesVO.getInvCurrency());
            receivablesLocal.setRodAmt(receivablesVO.getRodAmt());
            receivablesLocal.setAncChargeAmt(receivablesVO.getAncChargeAmt());
            receivablesLocal.setRecAmt(receivablesVO.getRecAmt());
            receivablesLocal.setLocationCd(receivablesVO.getLocationCd());
            receivablesLocal.setAwbNbr(receivablesVO.getAwbNbr());
            receivablesLocal.setTinUniqId(receivablesVO.getTinUniqId());
            receivablesLocal.setExchRateClnUsed(receivablesVO.getExchRateClnUsed());
            receivablesLocal.setEmployeeId(receivablesVO.getEmployeeId());
            receivablesLocal.setPaymentCurrency(receivablesVO.getPaymentCurrency());
            receivablesLocal.setCashPaymentAmt(receivablesVO.getCashPaymentAmt());
            receivablesLocal.setOtherPaymentAmt(receivablesVO.getOtherPaymentAmt());
            receivablesLocal.setOtherPaymentType(receivablesVO.getOtherPaymentType());
            receivablesLocal.setOtherDocNbr(receivablesVO.getOtherDocNbr());
            receivablesLocal.setDex16CashPayment(receivablesVO.getDex16CashPayment());
            receivablesLocal.setDex16FreightAmt(receivablesVO.getDex16FreightAmt());
            receivablesLocal.setDex16OtherPaymentAmt(receivablesVO.getDex16OtherPaymentAmt());
            receivablesLocal.setDex16OtherDocNbr(receivablesVO.getDex16OtherDocNbr());
            receivablesLocal.setDex16ScanSeqNbr(receivablesVO.getDex16ScanSeqNbr());
            receivablesLocal.setChngStatusEmployeeId(receivablesVO.getChngStatusEmployeeId());
            receivablesLocal.setChngStatusDt(receivablesVO.getChngStatusDt());
            receivablesLocal.setCloseEmployeeId(receivablesVO.getCloseEmployeeId());
            receivablesLocal.setCloseDt(receivablesVO.getCloseDt());
            receivablesLocal.setEodEmployeeId(receivablesVO.getEodEmployeeId());
            receivablesLocal.setEodDt(receivablesVO.getEodDt());
            receivablesLocal.setLastScanType(receivablesVO.getLastScanType());
            receivablesLocal.setLastScanDate(receivablesVO.getLastScanDate());
            receivablesLocal.setChkinAgentComment(receivablesVO.getChkinAgentComment());
            receivablesLocal.setTrackingStatus(receivablesVO.getTrackingStatus());
            receivablesLocal.setStatusId(receivablesVO.getStatusId());
            receivablesLocal.setCashDepositSlipId(receivablesVO.getCashDepositSlipId());
            receivablesLocal.setOtherDepositSlipId(receivablesVO.getOtherDepositSlipId());
            receivablesLocal.setCashDepositSlipNbr(receivablesVO.getCashDepositSlipNbr());
            receivablesLocal.setOtherDepositSlipNbr(receivablesVO.getOtherDepositSlipNbr());
            //changes made to add two new columns miscDate, miscNbr
            receivablesLocal.setMiscDate(receivablesVO.getMiscDate());
            receivablesLocal.setMiscNbr(receivablesVO.getMiscNbr());
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateReceivables() method from ReceivablesManager class";
            throw new ReceivablesException(errorMsg, ex);
        }
    }


    public Collection saveScans(Collection scans, String currentCurrency, double exchRate) {
        Collection colErrors = new ArrayList();
        Iterator iterChanges = scans.iterator();
        boolean errorUpdating = false;

        while (iterChanges.hasNext()) {
            RecChangesFromScans recChanges = (RecChangesFromScans) iterChanges.next();

            ReceivablesController recContr = null;
            ReceivablesVO recVO = null;
            errorUpdating = false;
            RODDaoLocal dao = null;
            CommonOpsDaoLocal daoComm = null;

            try {
                dao = getRODDaoLocal();
                daoComm = getCommonOpsDaoLocal();
                recContr = new ReceivablesController();

                //recVO=recContr.getReceivables(new Integer(recChanges.getRecId()));

                recVO = new ReceivablesVO();
                int result = daoComm.existsEmployeeLocation(recChanges.getLocationCd(), recChanges.getRecEmployeeId());

                boolean canInsert = true;
                switch (result) {
                    case 0: { //If exist employee

                        recVO.setInvCurrency(currentCurrency);
                        recVO.setExchRateClnUsed(exchRate);
                        recVO.setLocationCd(recChanges.getLocationCd());
                        recVO.setEmployeeId(recChanges.getRecEmployeeId());
                        break;
                    }
                    case 1: {//If does not exist employee, it creates it
                        EmployeeVO empVO = getSystemUtilsLocal().findFedExEmployee(recChanges.getRecEmployeeId());
                        if (empVO == null) {
                            empVO = new EmployeeVO(recChanges.getRecEmployeeId(), "Unknown Employee", "", "", "ROD", null, "0", 0, null, 0, 0, null, 1);
                        }
                        new EmployeeController().setEmployee(empVO);

                        recVO.setInvCurrency(currentCurrency);
                        recVO.setExchRateClnUsed(exchRate);
                        recVO.setLocationCd(recChanges.getLocationCd());
                        recVO.setEmployeeId(recChanges.getRecEmployeeId());
                        colErrors.add(new ScansProcessingError(recVO.getAwbNbr(), "app.messages.EmployeeNonExist", null, recChanges.getRecEmployeeId(), "", ""));
                        break;
                    }
                    default: {
                        colErrors.add(new ScansProcessingError(recVO.getAwbNbr(), "app.messages.LocationNonExist", null, recChanges.getLocationCd(), "", ""));
                        canInsert = false;
                        break;
                    }
                }

                if (canInsert) {
                    recVO.setRecId(new Integer(recChanges.getRecId()));
                    recVO.setAwbNbr(recChanges.getRecAwbNumber());
                    recVO.setRecAmt(recChanges.getRodAmt() + recChanges.getAncChargeAmt());
                    recVO.setCustomerNm("Unknown Customer");
                    recVO.setRecDt(new java.util.Date());
                    recVO.setRodAmt(recChanges.getRodAmt());
                    recVO.setAncChargeAmt(recChanges.getAncChargeAmt());
                    recVO.setTinUniqId(recChanges.getRecTinUniqueId());
                    recVO.setCashPaymentAmt(recChanges.getRecCashPayment());
                    recVO.setOtherPaymentAmt(recChanges.getRecOtherPayment());
                    recVO.setOtherDocNbr(recChanges.getRecOtherDocNumber());
                    recVO.setOtherPaymentType(recChanges.getOtherPaymentType());
                    recVO.setDex16CashPayment(recChanges.getRecDex16CashPayment());
                    recVO.setDex16OtherPaymentAmt(recChanges.getRecDex16OtherPayment());
                    recVO.setDex16OtherDocNbr(recChanges.getRecDex16OtherDocNumber());
                    recVO.setDex16ScanSeqNbr(recChanges.getRecDex16CosmosScanSeqNbr());
                    recVO.setDex16FreightAmt(recChanges.getRecDex16FreightAmount());
                    recVO.setLastScanType(recChanges.getRecLastScanType());
                    recVO.setLastScanDate(recChanges.getRecLastScanDate());
                    recVO.setPaymentCurrency(recChanges.getRecPaymentCurrency());
                    recVO.setTrackingStatus(recChanges.getRecTrackingStatus());
                    if (recChanges.isInCage() && recVO.getStatusId() != 4) {
                        recVO.setStatusId(4);
                    } else {
                        if (!recChanges.isInCage() && recVO.getStatusId() == 4) {
                            recVO.setStatusId(0);
                        }
                    }

                    if (dao.existsRecDuplicates(recVO)) {
                        colErrors.add(new ScansProcessingError(recVO.getAwbNbr(), "app.messages.DuplicateAWB", null, "", "", ""));
                        errorUpdating = true;
                    } else {
                        recContr.setReceivables(recVO);      //else insert db.
                    }
                }

            } catch (Exception e) {
                Constants.logger.debug(Utils.stackTraceToString(e));
                colErrors.add(new ScansProcessingError(recVO.getAwbNbr(), "app.messages.UnknownError", null, e.getMessage(), "", ""));
                errorUpdating = true;
            }

            if (!errorUpdating) {
                try {
                    Iterator iterScans = recChanges.getCosmosScans().iterator();
                    while (iterScans.hasNext()) {
                        daoComm.insertCosmosScan((CosmosScanVO) iterScans.next());
                    }
                } catch (Exception e) {
                }
            }
        }
        return colErrors;
    }

    public Integer setReceivables(ReceivablesVO receivablesVO)
            throws ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (receivablesVO == null) {
            throw new IllegalArgumentException("receivablesVO parameter was null in setReceivables() method from ReceivablesManager class");
        }

        try {

            //-- create new Receivables object
            ReceivablesLocal rl = getReceivablesLocalHome().create(
                    receivablesVO.getRecNbr(),
                    receivablesVO.getCustomerNm(),
                    receivablesVO.getRecDt(),
                    receivablesVO.getInvCurrency(),
                    receivablesVO.getRodAmt(),
                    receivablesVO.getAncChargeAmt(),
                    receivablesVO.getRecAmt(),
                    receivablesVO.getLocationCd(),
                    receivablesVO.getAwbNbr(),
                    receivablesVO.getTinUniqId(),
                    receivablesVO.getExchRateClnUsed(),
                    receivablesVO.getEmployeeId(),
                    receivablesVO.getPaymentCurrency(),
                    receivablesVO.getCashPaymentAmt(),
                    receivablesVO.getOtherPaymentAmt(),
                    receivablesVO.getOtherPaymentType(),
                    receivablesVO.getOtherDocNbr(),
                    receivablesVO.getDex16CashPayment(),
                    receivablesVO.getDex16FreightAmt(),
                    receivablesVO.getDex16OtherPaymentAmt(),
                    receivablesVO.getDex16OtherDocNbr(),
                    receivablesVO.getDex16ScanSeqNbr(),
                    receivablesVO.getChngStatusEmployeeId(),
                    receivablesVO.getChngStatusDt(),
                    receivablesVO.getCloseEmployeeId(),
                    receivablesVO.getCloseDt(),
                    receivablesVO.getEodEmployeeId(),
                    receivablesVO.getEodDt(),
                    receivablesVO.getLastScanType(),
                    receivablesVO.getLastScanDate(),
                    receivablesVO.getChkinAgentComment(),
                    receivablesVO.getTrackingStatus(),
                    receivablesVO.getStatusId(),
                    receivablesVO.getCashDepositSlipId(),
                    receivablesVO.getCashDepositSlipNbr(),
                    receivablesVO.getOtherDepositSlipId(),
                    receivablesVO.getOtherDepositSlipNbr(),
                    receivablesVO.getCreditCardBatchId(),
                    receivablesVO.getEodId(),
                    receivablesVO.getRodXmlImpDt(),
                    receivablesVO.getPymtImpDt(),
                    receivablesVO.getOtherComment(),
                    receivablesVO.getRecvPrepyAmt(),
                    receivablesVO.getOrigCustNm(),
                    receivablesVO.getCustChngEmpId(),
                    receivablesVO.getOrigRecAmt(),
                    receivablesVO.getAmtChngEmpId(),
                    receivablesVO.getRcptNbr(),
                    receivablesVO.getOrigRcptNbr(),
                    receivablesVO.getRcptChngEmpId(), null, null,
                    receivablesVO.getDualRecIdNbr(),
                    receivablesVO.getDupAwbFlg(),
                    receivablesVO.getbillAccount(),
                    //changes made to add the two columns miscDate,miscNbr
                    receivablesVO.getMiscDate(), 
                    receivablesVO.getMiscNbr()
            );
            return rl.getRecId();
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setReceivables() method from ReceivablesManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * Method to split the value of money between local currency and USD currency
     *
     * @param receivables  Collection
     * @param exchangeRate double value
     * @throws FacadeException
     */
    public void splitCurrency(Collection receivables, String currencyCd, double exchangeRate, double amountToChange) throws FacadeException {
        ReceivablesController recCtrl = new ReceivablesController();
        Integer newRecId = null;

        try {
            int count = receivables.size();
            double tabSourceAmount = 0, tabDestAmount = 0, exchAmount = 0;
            double centValue = 0;

            CourierCashRecapTableVO courierRec = null;
            ReceivablesVO recNew = null;
            ReceivablesVO recOld = null;

            Iterator recIt = receivables.iterator();
            if (count == 1) {
                //If number of rec is 1 then use exchange rate value passed as parameter
                //Compute is different for count greater than 1
                while (recIt.hasNext()) {
                    courierRec = (CourierCashRecapTableVO) recIt.next();
                    recOld = recCtrl.getReceivables(new Integer(courierRec.getRecId()));
                    recNew = recCtrl.getReceivables(new Integer(courierRec.getRecId()));
                    tabSourceAmount = recOld.getCashPaymentAmt() + recOld.getOtherPaymentAmt();
                    tabSourceAmount = tabSourceAmount - amountToChange;
                    if (currencyCd.equals("USD")) {
                        tabDestAmount = amountToChange / exchangeRate;
                    } else {
                        tabDestAmount = amountToChange * exchangeRate;
                    }

                    if (recOld.getCashPaymentAmt() > 0) {
                        recOld.setCashPaymentAmt(tabSourceAmount);
                        recNew.setCashPaymentAmt(tabDestAmount);
                    } else {
                        recOld.setOtherPaymentAmt(tabSourceAmount);
                        recNew.setOtherPaymentAmt(tabDestAmount);
                    }

                    //Set the receivables id in the object to produce the duality.
                    recNew.setDualRecIdNbr(recOld.getRecId());
                    //Insert the receivable new
                    recNew.setRecId(null);
                    recNew.setPaymentCurrency(currencyCd);
                    recNew.setChkinAgentComment("Exchange rate");
                    recNew.setOtherComment("SPLT;");
                    recNew.setStatusId(1);
                    newRecId = this.setReceivables(recNew);
                    recNew.setRecId(newRecId);

                    //Update receivable old
                    recOld.setOtherComment((recOld.getOtherComment() == null ? "" : recOld.getOtherComment()) + "SPLT;");
                    recOld.setChkinAgentComment(recOld.getChkinAgentComment() == null ? "Exchange rate" : recOld.getOtherComment() + ",Exchange rate");
                    recOld.setStatusId(1);
                    recOld.setDualRecIdNbr(newRecId);
                    recCtrl.updateReceivables(recOld);
                }//Close while
            } else if (count > 1) {
                //If number of rec greater than 1
                while (recIt.hasNext()) {
                    courierRec = (CourierCashRecapTableVO) recIt.next();
                    recOld = recCtrl.getReceivables(new Integer(courierRec.getRecId()));
                    recNew = recCtrl.getReceivables(new Integer(courierRec.getRecId()));
                    tabSourceAmount = recOld.getCashPaymentAmt() + recOld.getOtherPaymentAmt();
                    centValue = 0;

                    /*
                      String totalAmt = new Double(tabSourceAmount).toString();
                      String iPart = perl.substitute("s/\\..*$//",totalAmt);
                      String dPart = perl.substitute("s/^.*?\\.//",totalAmt);

                      if(dPart.trim().length() > 0)
                      {  centValue = Double.parseDouble(dPart);
                         centValue /= 100;
                      }
                      if(iPart.trim().length() > 0)
                         tabSourceAmount = Double.parseDouble(iPart);
                    */

                    int tabSourceAmountInt = new Double(tabSourceAmount).intValue();
                    centValue = tabSourceAmount - tabSourceAmountInt;
                    tabSourceAmount = tabSourceAmountInt;

                    if (currencyCd.equals("USD")) {
                        if (centValue > 0) {
                            tabDestAmount = centValue / exchangeRate;
                        }
                    } else
                        tabDestAmount = centValue * exchangeRate;

                    if (recOld.getCashPaymentAmt() > 0) {
                        recOld.setCashPaymentAmt(tabSourceAmount);
                        recNew.setCashPaymentAmt(tabDestAmount);
                    } else {
                        recOld.setOtherPaymentAmt(tabSourceAmount);
                        recNew.setOtherPaymentAmt(tabDestAmount);
                    }

                    //Set the receivables id in the object to produce the duality.
                    recNew.setDualRecIdNbr(recOld.getRecId());
                    //Insert the receivable new
                    recNew.setRecId(null);
                    recNew.setPaymentCurrency(currencyCd);
                    recNew.setChkinAgentComment("Exchange rate");
                    recNew.setOtherComment("SPLT;");
                    recNew.setStatusId(1);
                    newRecId = this.setReceivables(recNew);
                    recNew.setRecId(newRecId);

                    //Update receivable old
                    recOld.setOtherComment((recOld.getOtherComment() == null ? "" : recOld.getOtherComment()) + "SPLT;");
                    recOld.setChkinAgentComment(recOld.getChkinAgentComment() == null ? "Exchange rate" : recOld.getOtherComment() + ",Exchange rate");
                    recOld.setStatusId(1);
                    recOld.setDualRecIdNbr(newRecId);
                    recCtrl.updateReceivables(recOld);

                }//close while

            }//Close if
        } catch (Exception e) {
            String errorMsg = "Error occurred in splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) method of RODFacadeBean class";
            throw new EJBException(errorMsg, e);
        }
    }


    public Hashtable getSplitCourierCashRecapTable(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getRODDaoLocal().getSplitCourierCashRecapTable(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getSplitCourierCashRecapTable(String locationCd,String employeeId) method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection applyPaymentToInvoices(String courierId, String locationCd, String countryCd, String paymentCurrency, int paymentType, String otherDocNbr, boolean isCash, boolean isFindByAWB, Collection invoices) throws FacadeException {
        try {
            return getRODDaoLocal().applyPaymentToInvoices(courierId, locationCd, countryCd, paymentCurrency, paymentType, otherDocNbr, isCash, isFindByAWB, invoices);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in applyPaymentToInvoices() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    private PoaPaymentLocalHome getPoaPaymentLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (PoaPaymentLocalHome) service.getEJBLocalHome("PoaPaymentEJB.PoaPaymentLocalHome");
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getPoaPaymentLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    private DepositSlipLocalHome getDepositSlipLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (DepositSlipLocalHome) service.getEJBLocalHome("DepositSlipEJB.DepositSlipLocalHome");
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepositSlipLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    private BankAccLocalHome getBankAccLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (BankAccLocalHome) service.getEJBLocalHome("BankAccEJB.BankAccLocalHome");
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankAccLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }


    private EmployeeLocalHome getEmployeeLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (EmployeeLocalHome) service.getEJBLocalHome("EmployeeEJB.EmployeeLocalHome");
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEmployeeLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Receivables local home interface
     */
    private ReceivablesLocalHome getReceivablesLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (ReceivablesLocalHome) service.getEJBLocalHome("ReceivablesEJB.ReceivablesLocalHome");
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getReceivablesLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    private CommonOpsDaoLocal getCommonOpsDaoLocal() throws ServiceLocatorException, CreateException {
        CommonOpsDaoLocalHome daoHome = (CommonOpsDaoLocalHome) ServiceLocator.getInstance().getEJBLocalHome(Constants.CommonOpsDaoEJB_Local);
        CommonOpsDaoLocal dao = daoHome.create();
        return dao;
    }

    public TotalSummaryVO getRODDetailsTotal(String locationCodePk, String employeeCodePk, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getRODDaoLocal().getRODDetailsTotal(locationCodePk, employeeCodePk, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getRODDetailsTotal() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public TotalSummaryVO getRODDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getRODDaoLocal().getRODDetailsSplitTotal(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getRODDetailsSplitTotal() method from RODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

}//Close class RODFacadeBean
