package com.fedex.lacitd.cashcontrol.biztier.facades;

import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
//import com.fedex.lacitd.cashcontrol.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.dao.CommonOpsDaoLocal;
import com.fedex.lacitd.cashcontrol.datatier.dao.CommonOpsDaoLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.dao.FTCDaoLocal;
import com.fedex.lacitd.cashcontrol.datatier.dao.FTCDaoLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.FTC_ReceivablesException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import java.util.*;

public class FTCFacadeBean implements javax.ejb.SessionBean {
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
            FTC_ReceivablesController rc = new FTC_ReceivablesController();
            Iterator iterRec = colRec.iterator();
            while (iterRec.hasNext()) {
                FTC_ReceivablesVO recVO = (FTC_ReceivablesVO) iterRec.next();
                rc.setFTC_Receivables(recVO);
            }

        } catch (Exception e) {
            context.setRollbackOnly();
            throw new FacadeException("Exception ocurred in loadInvoices() method from FTC_FTCFacadeBean: " + e.toString(), e);
        }
    }

/*
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

            FTCDaoLocal dao = getFTCDaoLocal();

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
                    if (!dao.existsRecDuplicates(FTC_recVO)) {
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
                                    rlog.setMessage("The surcharge type " + esVO.getSurchargeCd() + " is not allowed for FTC in the location. AWB " + recVO.getAwbNbr());
                                    rlog.setStatusCd(0);
                                    rlog.setLocationCd(recVO.getLocationCd());
                                    dao.insertFTCFileProcLog(rlog);
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
                    FtcFileProcLogVO log = ((FtcFileProcLogVO) iterLoc.next());
                    log.setMessage(msg);
                    log.setStatusCd(1);
                    dao.insertFTCFileProcLog(log);
                }
            } else {
                rlog.setMessage("The file was processed previously.");
                rlog.setStatusCd(0);
                rlog.setLocationCd("");
                new RodFileProcLogController().setRodFileProcLog(rlog);
            }
            return true;
        } catch (BusinessDelegateException e) {
            Constants.logger.debug("Exception ocurred in loadInvoices() method from FTCFacadeBean: \n" + Utils.stackTraceToString(e));
            return false;
        } catch (Exception e) {
            rlog.setMessage(e.getMessage());
            rlog.setStatusCd(0);
            rlog.setLocationCd("");
            try {
                new RodFileProcLogController().setRodFileProcLog(rlog);
            } catch (BusinessDelegateException e1) {
                Constants.logger.debug("Exception ocurred in loadInvoices() method from FTCFacadeBean: \n" + Utils.stackTraceToString(e1));
            }

            Constants.logger.debug("Exception ocurred in loadInvoices() method from FTCFacadeBean: \n" + Utils.stackTraceToString(e));
            return true;
        }
    }
*/
    public Collection getAwbToQueryCosmos(String locationCodePk, String employeeCodePk) throws FacadeException {
        try {
            return getFTCDaoLocal().getAwbToQueryCosmos(locationCodePk, employeeCodePk);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAwbToQueryCosmos() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    private FTCDaoLocal getFTCDaoLocal() throws ServiceLocatorException, CreateException {
        FTCDaoLocalHome daoHome = (FTCDaoLocalHome) ServiceLocator.getInstance().getEJBLocalHome(Constants.FTCDaoEJB_Local);
        FTCDaoLocal dao = daoHome.create();
        return dao;
    }

    private SystemUtilsLocal getSystemUtilsLocal() throws ServiceLocatorException, CreateException {
        SystemUtilsLocalHome utilHome = (SystemUtilsLocalHome) ServiceLocator.getInstance().getEJBLocalHome(Constants.SystemUtilsEJB_Local);
        SystemUtilsLocal util = utilHome.create();
        return util;
    }

    public Collection applyFTCScans(java.util.Collection colChanges) throws FacadeException {
        try {
            return getFTCDaoLocal().applyFTCScans(colChanges);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in applyFTCScans() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    public Hashtable getCourierCashRecapTable(String locationCodePk, String employeeCodePk, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getFTCDaoLocal().getCourierCashRecapTable(locationCodePk, employeeCodePk, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCourierCashRecapTable() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    public Collection getAllFTC_RecStatus() throws FacadeException {
        try {
            return getFTCDaoLocal().getAllFTC_RecStatus();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAllFTC_RecStatus() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void applyCheckinAgentChanges(java.util.Collection colChanges) throws FacadeException {
        Collection colErrors = new ArrayList();
        Iterator iterChanges = colChanges.iterator();

        while (iterChanges.hasNext()) {
            FTC_CourierCashRecapTableVO recChanges = (FTC_CourierCashRecapTableVO) iterChanges.next();

            FTC_ReceivablesController recContr = null;
            FTC_ReceivablesVO recVO = null;
            try {
                recContr = new FTC_ReceivablesController();
                recVO = recContr.getFTC_Receivables(new Integer(recChanges.getRecId()));

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

                recContr.updateFTC_Receivables(recVO);

            } catch (Exception e) {
                String errorMsg = e.getClass().getName() + " occurred in applyCheckinAgentChanges() method from FTCFacadeBean class";
                throw new FacadeException(errorMsg, e);
            }
        }
    }

    public void changeRecCurrency(int recPk, String newCurrency) throws FacadeException {
        FTC_ReceivablesController recContr = null;
        FTC_ReceivablesVO recVO = null;
        try {
            recContr = new FTC_ReceivablesController();
            recVO = recContr.getFTC_Receivables(new Integer(recPk));
            recVO.setInvCurrency(newCurrency);
            recContr.updateFTC_Receivables(recVO);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in changeRecCurrency() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void changeRecPaymentCurrency(int recPk, String newCurrency) throws FacadeException {
        FTC_ReceivablesController recContr = null;
        FTC_ReceivablesVO recVO = null;
        try {
            recContr = new FTC_ReceivablesController();
            recVO = recContr.getFTC_Receivables(new Integer(recPk));
            recVO.setPaymentCurrency(newCurrency);
            recContr.updateFTC_Receivables(recVO);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in applyCheckinAgentChanges() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getInvoicesByAwb(String awbNumber) throws FacadeException {
        try {
            return getFTCDaoLocal().getInvoicesByAwb(awbNumber);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getInvoicesByAwb() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public boolean addFTC_Receivable(com.fedex.lacitd.cashcontrol.datatier.valueobject.FTC_ReceivablesVO FTC_recVO) {
        try {
            new FTC_ReceivablesController().setFTC_Receivables(FTC_recVO);
            return true;
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            return false;
        }
    }

    public com.fedex.lacitd.cashcontrol.datatier.valueobject.FTC_ReceivablesVO getFTC_Receivables(int recPk) {
        try {
            return new FTC_ReceivablesController().getFTC_Receivables(new Integer(recPk));
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
            FTC_ReceivablesController con = new FTC_ReceivablesController();
            FTC_ReceivablesVO recVO = con.getFTC_Receivables(new Integer(recPk));

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

            con.updateFTC_Receivables(recVO);
            return 0;
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            return -1;
        }
    }

    public Collection getCouriersWithPendents(String location) throws FacadeException {
        try {
            return getFTCDaoLocal().getCouriersWithPendents(location);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCouriersWithPendents() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }

    }


    public java.util.Collection getFTCUsedCurrencies(java.lang.String locationCodePk, java.lang.String employeeCodePk) throws FacadeException {
        try {
            return getFTCDaoLocal().getFTCUsedCurrencies(locationCodePk, employeeCodePk);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getFTCUsedCurrencies() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void runInCageExceptionsTask() throws FacadeException {
        try {
            getFTCDaoLocal().runInCageExceptionsTask();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in runInCageExceptionsTask() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getAwbToQuerySTAT44() throws FacadeException {
        try {
            return getFTCDaoLocal().getAwbToQuerySTAT44();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAwbToQuerySTAT44() method from FTCFacadeBean class";
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
                            empVO = new EmployeeVO(csVO.getCourierId(), "Unknown Employee", "", "", "FTC", null, "0", 0, null, 0, 0, null, 1);
                        }
                        new EmployeeController().setEmployee(empVO);
                    }
                    csc.setCosmosScan(csVO);
                }
            }
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveSTAT44Scans() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getFtcFilesImportingStatus(String empId) throws FacadeException {
        try {
            return getFTCDaoLocal().getFtcFilesImportingStatus(empId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getFtcFilesImportingStatus() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getFtcFilesImportingDetails(int logId) throws FacadeException {
        try {
            return getFTCDaoLocal().getFtcFilesImportingDetails(logId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getFtcFilesImportingDetails() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    private void updateFTC_Receivables(FTC_ReceivablesVO FTC_receivablesVO)
            throws FTC_ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (FTC_receivablesVO == null) {
            throw new IllegalArgumentException("FTC_receivablesVO parameter was null in updateFTC_Receivables() method from ReceivablesManager class");
        }

        try {
            Integer recId = FTC_receivablesVO.getRecId();

            FTC_ReceivablesLocal FTC_receivablesLocal = getFTC_ReceivablesLocalHome().findByPrimaryKey(recId);
            //-- update Receivables entity bean
            FTC_receivablesLocal.setRecNbr(FTC_receivablesVO.getRecNbr());
            FTC_receivablesLocal.setCustomerNm(FTC_receivablesVO.getCustomerNm());
            FTC_receivablesLocal.setRecDt(FTC_receivablesVO.getRecDt());
            FTC_receivablesLocal.setInvCurrency(FTC_receivablesVO.getInvCurrency());
            FTC_receivablesLocal.setFtcAmt(FTC_receivablesVO.getFtcAmt());
            FTC_receivablesLocal.setAncChargeAmt(FTC_receivablesVO.getAncChargeAmt());
            FTC_receivablesLocal.setRecAmt(FTC_receivablesVO.getRecAmt());
            FTC_receivablesLocal.setLocationCd(FTC_receivablesVO.getLocationCd());
            FTC_receivablesLocal.setAwbNbr(FTC_receivablesVO.getAwbNbr());
            FTC_receivablesLocal.setTinUniqId(FTC_receivablesVO.getTinUniqId());
            FTC_receivablesLocal.setExchRateClnUsed(FTC_receivablesVO.getExchRateClnUsed());
            FTC_receivablesLocal.setEmployeeId(FTC_receivablesVO.getEmployeeId());
            FTC_receivablesLocal.setPaymentCurrency(FTC_receivablesVO.getPaymentCurrency());
            FTC_receivablesLocal.setCashPaymentAmt(FTC_receivablesVO.getCashPaymentAmt());
            FTC_receivablesLocal.setOtherPaymentAmt(FTC_receivablesVO.getOtherPaymentAmt());
            FTC_receivablesLocal.setOtherPaymentType(FTC_receivablesVO.getOtherPaymentType());
            FTC_receivablesLocal.setOtherDocNbr(FTC_receivablesVO.getOtherDocNbr());
            FTC_receivablesLocal.setDex16CashPayment(FTC_receivablesVO.getDex16CashPayment());
            FTC_receivablesLocal.setDex16FreightAmt(FTC_receivablesVO.getDex16FreightAmt());
            FTC_receivablesLocal.setDex16OtherPaymentAmt(FTC_receivablesVO.getDex16OtherPaymentAmt());
            FTC_receivablesLocal.setDex16OtherDocNbr(FTC_receivablesVO.getDex16OtherDocNbr());
            FTC_receivablesLocal.setDex16ScanSeqNbr(FTC_receivablesVO.getDex16ScanSeqNbr());
            FTC_receivablesLocal.setChngStatusEmployeeId(FTC_receivablesVO.getChngStatusEmployeeId());
            FTC_receivablesLocal.setChngStatusDt(FTC_receivablesVO.getChngStatusDt());
            FTC_receivablesLocal.setCloseEmployeeId(FTC_receivablesVO.getCloseEmployeeId());
            FTC_receivablesLocal.setCloseDt(FTC_receivablesVO.getCloseDt());
            FTC_receivablesLocal.setEodEmployeeId(FTC_receivablesVO.getEodEmployeeId());
            FTC_receivablesLocal.setEodDt(FTC_receivablesVO.getEodDt());
            FTC_receivablesLocal.setLastScanType(FTC_receivablesVO.getLastScanType());
            FTC_receivablesLocal.setLastScanDate(FTC_receivablesVO.getLastScanDate());
            FTC_receivablesLocal.setChkinAgentComment(FTC_receivablesVO.getChkinAgentComment());
            FTC_receivablesLocal.setTrackingStatus(FTC_receivablesVO.getTrackingStatus());
            FTC_receivablesLocal.setStatusId(FTC_receivablesVO.getStatusId());
            FTC_receivablesLocal.setCashDepositSlipId(FTC_receivablesVO.getCashDepositSlipId());
            FTC_receivablesLocal.setOtherDepositSlipId(FTC_receivablesVO.getOtherDepositSlipId());
            FTC_receivablesLocal.setCashDepositSlipNbr(FTC_receivablesVO.getCashDepositSlipNbr());
            FTC_receivablesLocal.setOtherDepositSlipNbr(FTC_receivablesVO.getOtherDepositSlipNbr());
            //changes made to add two new columns miscDate, miscNbr
            FTC_receivablesLocal.setMiscDate(FTC_receivablesVO.getMiscDate());
            FTC_receivablesLocal.setMiscNbr(FTC_receivablesVO.getMiscNbr());
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateFTC_Receivables() method from ReceivablesManager class";
            throw new FTC_ReceivablesException(errorMsg, ex);
        }
    }


    public Collection saveScans(Collection scans, String currentCurrency, double exchRate) {
        Collection colErrors = new ArrayList();
        Iterator iterChanges = scans.iterator();
        boolean errorUpdating = false;

        while (iterChanges.hasNext()) {
            FTC_RecChangesFromScans recChanges = (FTC_RecChangesFromScans) iterChanges.next();

            FTC_ReceivablesController recContr = null;
            FTC_ReceivablesVO recVO = null;
            errorUpdating = false;
            FTCDaoLocal dao = null;
            CommonOpsDaoLocal daoComm = null;

            try {
                dao = getFTCDaoLocal();
                daoComm = getCommonOpsDaoLocal();
                recContr = new FTC_ReceivablesController();

                //recVO=recContr.getReceivables(new Integer(recChanges.getRecId()));

                recVO = new FTC_ReceivablesVO();
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
                            empVO = new EmployeeVO(recChanges.getRecEmployeeId(), "Unknown Employee", "", "", "FTC", null, "0", 0, null, 0, 0, null, 1);
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
                    recVO.setRecAmt(recChanges.getFtcAmt() + recChanges.getAncChargeAmt());
                    recVO.setCustomerNm("Unknown Customer");
                    recVO.setRecDt(new java.util.Date());
                    recVO.setFtcAmt(recChanges.getFtcAmt());
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
                        recContr.setFTC_Receivables(recVO);      //else insert db.
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

    public Integer setFTC_Receivables(FTC_ReceivablesVO FTC_receivablesVO)
            throws FTC_ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (FTC_receivablesVO == null) {
            throw new IllegalArgumentException("FTC_receivablesVO parameter was null in setFTC_Receivables() method from ReceivablesManager class");
        }

        try {

            //-- create new Receivables object
            FTC_ReceivablesLocal rl = getFTC_ReceivablesLocalHome().create(
                    FTC_receivablesVO.getRecNbr(),
                    FTC_receivablesVO.getCustomerNm(),
                    FTC_receivablesVO.getRecDt(),
                    FTC_receivablesVO.getInvCurrency(),
                    FTC_receivablesVO.getFtcAmt(),
                    FTC_receivablesVO.getAncChargeAmt(),
                    FTC_receivablesVO.getRecAmt(),
                    FTC_receivablesVO.getLocationCd(),
                    FTC_receivablesVO.getAwbNbr(),
                    FTC_receivablesVO.getTinUniqId(),
                    FTC_receivablesVO.getExchRateClnUsed(),
                    FTC_receivablesVO.getEmployeeId(),
                    FTC_receivablesVO.getPaymentCurrency(),
                    FTC_receivablesVO.getCashPaymentAmt(),
                    FTC_receivablesVO.getOtherPaymentAmt(),
                    FTC_receivablesVO.getOtherPaymentType(),
                    FTC_receivablesVO.getOtherDocNbr(),
                    FTC_receivablesVO.getDex16CashPayment(),
                    FTC_receivablesVO.getDex16FreightAmt(),
                    FTC_receivablesVO.getDex16OtherPaymentAmt(),
                    FTC_receivablesVO.getDex16OtherDocNbr(),
                    FTC_receivablesVO.getDex16ScanSeqNbr(),
                    FTC_receivablesVO.getChngStatusEmployeeId(),
                    FTC_receivablesVO.getChngStatusDt(),
                    FTC_receivablesVO.getCloseEmployeeId(),
                    FTC_receivablesVO.getCloseDt(),
                    FTC_receivablesVO.getEodEmployeeId(),
                    FTC_receivablesVO.getEodDt(),
                    FTC_receivablesVO.getLastScanType(),
                    FTC_receivablesVO.getLastScanDate(),
                    FTC_receivablesVO.getChkinAgentComment(),
                    FTC_receivablesVO.getTrackingStatus(),
                    FTC_receivablesVO.getStatusId(),
                    FTC_receivablesVO.getCashDepositSlipId(),
                    FTC_receivablesVO.getCashDepositSlipNbr(),
                    FTC_receivablesVO.getOtherDepositSlipId(),
                    FTC_receivablesVO.getOtherDepositSlipNbr(),
                    FTC_receivablesVO.getCreditCardBatchId(),
                    FTC_receivablesVO.getEodId(),
                    FTC_receivablesVO.getFtcXmlImpDt(),
                    FTC_receivablesVO.getPymtImpDt(),
                    FTC_receivablesVO.getOtherComment(),
                    FTC_receivablesVO.getRecvPrepyAmt(),
                    FTC_receivablesVO.getOrigCustNm(),
                    FTC_receivablesVO.getCustChngEmpId(),
                    FTC_receivablesVO.getOrigRecAmt(),
                    FTC_receivablesVO.getAmtChngEmpId(),
                    FTC_receivablesVO.getRcptNbr(),
                    FTC_receivablesVO.getOrigRcptNbr(),
                    FTC_receivablesVO.getRcptChngEmpId(), null, null,
                    FTC_receivablesVO.getDualRecIdNbr(),
                    FTC_receivablesVO.getDupAwbFlg(),
                    FTC_receivablesVO.getbillAccount(),
                    //to set the value
                    FTC_receivablesVO.getMiscDate(),
                    FTC_receivablesVO.getMiscNbr()
                    
                    
                    
            );
            return rl.getRecId();
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setFTC_Receivables() method from FTC_ReceivablesManager class";
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
    public void splitCurrency(Collection FTC_receivables, String currencyCd, double exchangeRate, double amountToChange) throws FacadeException {
        FTC_ReceivablesController recCtrl = new FTC_ReceivablesController();
        Integer newRecId = null;

        try {
            int count = FTC_receivables.size();
            double tabSourceAmount = 0, tabDestAmount = 0, exchAmount = 0;
            double centValue = 0;

            FTC_CourierCashRecapTableVO courierRec = null;
            FTC_ReceivablesVO recNew = null;
            FTC_ReceivablesVO recOld = null;

            Iterator recIt = FTC_receivables.iterator();
            if (count == 1) {
                //If number of rec is 1 then use exchange rate value passed as parameter
                //Compute is different for count greater than 1
                while (recIt.hasNext()) {
                    courierRec = (FTC_CourierCashRecapTableVO) recIt.next();
                    recOld = recCtrl.getFTC_Receivables(new Integer(courierRec.getRecId()));
                    recNew = recCtrl.getFTC_Receivables(new Integer(courierRec.getRecId()));
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
                    newRecId = this.setFTC_Receivables(recNew);
                    recNew.setRecId(newRecId);

                    //Update receivable old
                    recOld.setOtherComment((recOld.getOtherComment() == null ? "" : recOld.getOtherComment()) + "SPLT;");
                    recOld.setChkinAgentComment(recOld.getChkinAgentComment() == null ? "Exchange rate" : recOld.getOtherComment() + ",Exchange rate");
                    recOld.setStatusId(1);
                    recOld.setDualRecIdNbr(newRecId);
                    recCtrl.updateFTC_Receivables(recOld);
                }//Close while
            } else if (count > 1) {
                //If number of rec greater than 1
                while (recIt.hasNext()) {
                    courierRec = (FTC_CourierCashRecapTableVO) recIt.next();
                    recOld = recCtrl.getFTC_Receivables(new Integer(courierRec.getRecId()));
                    recNew = recCtrl.getFTC_Receivables(new Integer(courierRec.getRecId()));
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
                    newRecId = this.setFTC_Receivables(recNew);
                    recNew.setRecId(newRecId);

                    //Update receivable old
                    recOld.setOtherComment((recOld.getOtherComment() == null ? "" : recOld.getOtherComment()) + "SPLT;");
                    recOld.setChkinAgentComment(recOld.getChkinAgentComment() == null ? "Exchange rate" : recOld.getOtherComment() + ",Exchange rate");
                    recOld.setStatusId(1);
                    recOld.setDualRecIdNbr(newRecId);
                    recCtrl.updateFTC_Receivables(recOld);

                }//close while

            }//Close if
        } catch (Exception e) {
            String errorMsg = "Error occurred in splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) method of FTCFacadeBean class";
            throw new EJBException(errorMsg, e);
        }
    }


    public Hashtable getSplitCourierCashRecapTable(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getFTCDaoLocal().getSplitCourierCashRecapTable(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getSplitCourierCashRecapTable(String locationCd,String employeeId) method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection applyPaymentToInvoices(String courierId, String locationCd, String countryCd, String paymentCurrency, int paymentType, String otherDocNbr, boolean isCash, boolean isFindByAWB, Collection invoices) throws FacadeException {
        try {
            return getFTCDaoLocal().applyPaymentToInvoices(courierId, locationCd, countryCd, paymentCurrency, paymentType, otherDocNbr, isCash, isFindByAWB, invoices);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in applyPaymentToInvoices() method from FTCFacadeBean class";
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
     * This methods gets the FTC_Receivables local home interface
     */
    private FTC_ReceivablesLocalHome getFTC_ReceivablesLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (FTC_ReceivablesLocalHome) service.getEJBLocalHome("FTC_ReceivablesEJB.FTC_ReceivablesLocalHome");
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getFTC_ReceivablesLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    private CommonOpsDaoLocal getCommonOpsDaoLocal() throws ServiceLocatorException, CreateException {
        CommonOpsDaoLocalHome daoHome = (CommonOpsDaoLocalHome) ServiceLocator.getInstance().getEJBLocalHome(Constants.CommonOpsDaoEJB_Local);
        CommonOpsDaoLocal dao = daoHome.create();
        return dao;
    }

    public TotalSummaryVO getFTCDetailsTotal(String locationCodePk, String employeeCodePk, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getFTCDaoLocal().getFTCDetailsTotal(locationCodePk, employeeCodePk, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getFTCDetailsTotal() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public TotalSummaryVO getFTCDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getFTCDaoLocal().getFTCDetailsSplitTotal(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getFTCDetailsSplitTotal() method from FTCFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

}//Close class FTCFacadeBean
