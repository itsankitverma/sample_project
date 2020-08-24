package com.fedex.lacitd.cashcontrol.biztier.facades;

import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
//import com.fedex.lacitd.cashcontrol.common.ServiceLocator;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.dao.CommonOpsDaoLocal;
import com.fedex.lacitd.cashcontrol.datatier.dao.CommonOpsDaoLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.dao.CODDaoLocal;
import com.fedex.lacitd.cashcontrol.datatier.dao.CODDaoLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.COD_ReceivablesException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import java.util.*;

public class CODFacadeBean implements javax.ejb.SessionBean {
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
            COD_ReceivablesController rc = new COD_ReceivablesController();
            Iterator iterRec = colRec.iterator();
            while (iterRec.hasNext()) {
                COD_ReceivablesVO recVO = (COD_ReceivablesVO) iterRec.next();
                rc.setCOD_Receivables(recVO);
            }

        } catch (Exception e) {
            context.setRollbackOnly();
            throw new FacadeException("Exception ocurred in loadInvoices() method from COD_CODFacadeBean: " + e.toString(), e);
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

            CODDaoLocal dao = getCODDaoLocal();

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
                    if (!dao.existsRecDuplicates(COD_recVO)) {
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
                                    rlog.setMessage("The surcharge type " + esVO.getSurchargeCd() + " is not allowed for COD in the location. AWB " + recVO.getAwbNbr());
                                    rlog.setStatusCd(0);
                                    rlog.setLocationCd(recVO.getLocationCd());
                                    dao.insertCODFileProcLog(rlog);
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
                    CodFileProcLogVO log = ((CodFileProcLogVO) iterLoc.next());
                    log.setMessage(msg);
                    log.setStatusCd(1);
                    dao.insertCODFileProcLog(log);
                }
            } else {
                rlog.setMessage("The file was processed previously.");
                rlog.setStatusCd(0);
                rlog.setLocationCd("");
                new RodFileProcLogController().setRodFileProcLog(rlog);
            }
            return true;
        } catch (BusinessDelegateException e) {
            Constants.logger.debug("Exception ocurred in loadInvoices() method from CODFacadeBean: \n" + Utils.stackTraceToString(e));
            return false;
        } catch (Exception e) {
            rlog.setMessage(e.getMessage());
            rlog.setStatusCd(0);
            rlog.setLocationCd("");
            try {
                new RodFileProcLogController().setRodFileProcLog(rlog);
            } catch (BusinessDelegateException e1) {
                Constants.logger.debug("Exception ocurred in loadInvoices() method from CODFacadeBean: \n" + Utils.stackTraceToString(e1));
            }

            Constants.logger.debug("Exception ocurred in loadInvoices() method from CODFacadeBean: \n" + Utils.stackTraceToString(e));
            return true;
        }
    }
*/
    public Collection getAwbToQueryCosmos(String locationCodePk, String employeeCodePk) throws FacadeException {
        try {
            return getCODDaoLocal().getAwbToQueryCosmos(locationCodePk, employeeCodePk);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAwbToQueryCosmos() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    private CODDaoLocal getCODDaoLocal() throws ServiceLocatorException, CreateException {
        CODDaoLocalHome daoHome = (CODDaoLocalHome) ServiceLocator.getInstance().getEJBLocalHome(Constants.CODDaoEJB_Local);
        CODDaoLocal dao = daoHome.create();
        return dao;
    }

    private SystemUtilsLocal getSystemUtilsLocal() throws ServiceLocatorException, CreateException {
        SystemUtilsLocalHome utilHome = (SystemUtilsLocalHome) ServiceLocator.getInstance().getEJBLocalHome(Constants.SystemUtilsEJB_Local);
        SystemUtilsLocal util = utilHome.create();
        return util;
    }

    public Collection applyCODScans(java.util.Collection colChanges) throws FacadeException {
        try {
            return getCODDaoLocal().applyCODScans(colChanges);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in applyCODScans() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    public Hashtable getCourierCashRecapTable(String locationCodePk, String employeeCodePk, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getCODDaoLocal().getCourierCashRecapTable(locationCodePk, employeeCodePk, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCourierCashRecapTable() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    public Collection getAllCOD_RecStatus() throws FacadeException {
        try {
            return getCODDaoLocal().getAllCOD_RecStatus();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAllCOD_RecStatus() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void applyCheckinAgentChanges(java.util.Collection colChanges) throws FacadeException {
        Collection colErrors = new ArrayList();
        Iterator iterChanges = colChanges.iterator();

        while (iterChanges.hasNext()) {
            COD_CourierCashRecapTableVO recChanges = (COD_CourierCashRecapTableVO) iterChanges.next();

            COD_ReceivablesController recContr = null;
            COD_ReceivablesVO recVO = null;
            try {
                recContr = new COD_ReceivablesController();
                recVO = recContr.getCOD_Receivables(new Integer(recChanges.getRecId()));

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

                if (recChanges.getRecDex11Amount() > 0 || recChanges.getRecCashPayment() > 0 || recChanges.getRecOtherPayment() > 0)
                {
                    recVO.setPaymentCurrency(recChanges.getRecPaymentCurrency());
                }

                recContr.updateCOD_Receivables(recVO);

            } catch (Exception e) {
                String errorMsg = e.getClass().getName() + " occurred in applyCheckinAgentChanges() method from CODFacadeBean class";
                throw new FacadeException(errorMsg, e);
            }
        }
    }

    public void changeRecCurrency(int recPk, String newCurrency) throws FacadeException {
        COD_ReceivablesController recContr = null;
        COD_ReceivablesVO recVO = null;
        try {
            recContr = new COD_ReceivablesController();
            recVO = recContr.getCOD_Receivables(new Integer(recPk));
            recVO.setInvCurrency(newCurrency);
            recContr.updateCOD_Receivables(recVO);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in changeRecCurrency() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void changeRecPaymentCurrency(int recPk, String newCurrency) throws FacadeException {
        COD_ReceivablesController recContr = null;
        COD_ReceivablesVO recVO = null;
        try {
            recContr = new COD_ReceivablesController();
            recVO = recContr.getCOD_Receivables(new Integer(recPk));
            recVO.setPaymentCurrency(newCurrency);
            recContr.updateCOD_Receivables(recVO);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in applyCheckinAgentChanges() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getInvoicesByAwb(String awbNumber) throws FacadeException {
        try {
            return getCODDaoLocal().getInvoicesByAwb(awbNumber);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getInvoicesByAwb() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public boolean addCOD_Receivable(com.fedex.lacitd.cashcontrol.datatier.valueobject.COD_ReceivablesVO COD_recVO) {
        try {
            new COD_ReceivablesController().setCOD_Receivables(COD_recVO);
            return true;
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            return false;
        }
    }

    public com.fedex.lacitd.cashcontrol.datatier.valueobject.COD_ReceivablesVO getCOD_Receivables(int recPk) {
        try {
            return new COD_ReceivablesController().getCOD_Receivables(new Integer(recPk));
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
            COD_ReceivablesController con = new COD_ReceivablesController();
            COD_ReceivablesVO recVO = con.getCOD_Receivables(new Integer(recPk));

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

            con.updateCOD_Receivables(recVO);
            return 0;
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            return -1;
        }
    }

    public Collection getCouriersWithPendents(String location) throws FacadeException {
        try {
            return getCODDaoLocal().getCouriersWithPendents(location);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCouriersWithPendents() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }

    }


    public java.util.Collection getCODUsedCurrencies(java.lang.String locationCodePk, java.lang.String employeeCodePk) throws FacadeException {
        try {
            return getCODDaoLocal().getCODUsedCurrencies(locationCodePk, employeeCodePk);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCODUsedCurrencies() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void runInCageExceptionsTask() throws FacadeException {
        try {
            getCODDaoLocal().runInCageExceptionsTask();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in runInCageExceptionsTask() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getAwbToQuerySTAT44() throws FacadeException {
        try {
            return getCODDaoLocal().getAwbToQuerySTAT44();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getAwbToQuerySTAT44() method from CODFacadeBean class";
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
                            empVO = new EmployeeVO(csVO.getCourierId(), "Unknown Employee", "", "", "COD", null, "0", 0, null, 0, 0, null, 1);
                        }
                        new EmployeeController().setEmployee(empVO);
                    }
                    csc.setCosmosScan(csVO);
                }
            }
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveSTAT44Scans() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getCodFilesImportingStatus(String empId) throws FacadeException {
        try {
            return getCODDaoLocal().getCodFilesImportingStatus(empId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCodFilesImportingStatus() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getCodFilesImportingDetails(int logId) throws FacadeException {
        try {
            return getCODDaoLocal().getCodFilesImportingDetails(logId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCodFilesImportingDetails() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    private void updateCOD_Receivables(COD_ReceivablesVO COD_receivablesVO)
            throws COD_ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (COD_receivablesVO == null) {
            throw new IllegalArgumentException("COD_receivablesVO parameter was null in updateCOD_Receivables() method from ReceivablesManager class");
        }

        try {
            Integer recId = COD_receivablesVO.getRecId();

            COD_ReceivablesLocal COD_receivablesLocal = getCOD_ReceivablesLocalHome().findByPrimaryKey(recId);
            //-- update Receivables entity bean
            COD_receivablesLocal.setRecNbr(COD_receivablesVO.getRecNbr());
            COD_receivablesLocal.setCustomerNm(COD_receivablesVO.getCustomerNm());
            COD_receivablesLocal.setRecDt(COD_receivablesVO.getRecDt());
            COD_receivablesLocal.setInvCurrency(COD_receivablesVO.getInvCurrency());
            COD_receivablesLocal.setCodAmt(COD_receivablesVO.getCodAmt());
            COD_receivablesLocal.setAncChargeAmt(COD_receivablesVO.getAncChargeAmt());
            COD_receivablesLocal.setRecAmt(COD_receivablesVO.getRecAmt());
            COD_receivablesLocal.setLocationCd(COD_receivablesVO.getLocationCd());
            COD_receivablesLocal.setAwbNbr(COD_receivablesVO.getAwbNbr());
            COD_receivablesLocal.setTinUniqId(COD_receivablesVO.getTinUniqId());
            COD_receivablesLocal.setExchRateClnUsed(COD_receivablesVO.getExchRateClnUsed());
            COD_receivablesLocal.setEmployeeId(COD_receivablesVO.getEmployeeId());
            COD_receivablesLocal.setPaymentCurrency(COD_receivablesVO.getPaymentCurrency());
            COD_receivablesLocal.setCashPaymentAmt(COD_receivablesVO.getCashPaymentAmt());
            COD_receivablesLocal.setOtherPaymentAmt(COD_receivablesVO.getOtherPaymentAmt());
            COD_receivablesLocal.setOtherPaymentType(COD_receivablesVO.getOtherPaymentType());
            COD_receivablesLocal.setOtherDocNbr(COD_receivablesVO.getOtherDocNbr());
            COD_receivablesLocal.setDex11CashPayment(COD_receivablesVO.getDex11CashPayment());
            COD_receivablesLocal.setDex11FreightAmt(COD_receivablesVO.getDex11FreightAmt());
            COD_receivablesLocal.setDex11OtherPaymentAmt(COD_receivablesVO.getDex11OtherPaymentAmt());
            COD_receivablesLocal.setDex11OtherDocNbr(COD_receivablesVO.getDex11OtherDocNbr());
            COD_receivablesLocal.setDex11ScanSeqNbr(COD_receivablesVO.getDex11ScanSeqNbr());
            COD_receivablesLocal.setChngStatusEmployeeId(COD_receivablesVO.getChngStatusEmployeeId());
            COD_receivablesLocal.setChngStatusDt(COD_receivablesVO.getChngStatusDt());
            COD_receivablesLocal.setCloseEmployeeId(COD_receivablesVO.getCloseEmployeeId());
            COD_receivablesLocal.setCloseDt(COD_receivablesVO.getCloseDt());
            COD_receivablesLocal.setEodEmployeeId(COD_receivablesVO.getEodEmployeeId());
            COD_receivablesLocal.setEodDt(COD_receivablesVO.getEodDt());
            COD_receivablesLocal.setLastScanType(COD_receivablesVO.getLastScanType());
            COD_receivablesLocal.setLastScanDate(COD_receivablesVO.getLastScanDate());
            COD_receivablesLocal.setChkinAgentComment(COD_receivablesVO.getChkinAgentComment());
            COD_receivablesLocal.setTrackingStatus(COD_receivablesVO.getTrackingStatus());
            COD_receivablesLocal.setStatusId(COD_receivablesVO.getStatusId());
            COD_receivablesLocal.setCashDepositSlipId(COD_receivablesVO.getCashDepositSlipId());
            COD_receivablesLocal.setOtherDepositSlipId(COD_receivablesVO.getOtherDepositSlipId());
            COD_receivablesLocal.setCashDepositSlipNbr(COD_receivablesVO.getCashDepositSlipNbr());
            COD_receivablesLocal.setOtherDepositSlipNbr(COD_receivablesVO.getOtherDepositSlipNbr());
            //changes made to add two new columns miscDate, miscNbr
            COD_receivablesLocal.setMiscDate(COD_receivablesVO.getMiscDate());
            COD_receivablesLocal.setMiscNbr(COD_receivablesVO.getMiscNbr());
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateCOD_Receivables() method from ReceivablesManager class";
            throw new COD_ReceivablesException(errorMsg, ex);
        }
    }


    public Collection saveScans(Collection scans, String currentCurrency, double exchRate) {
        Collection colErrors = new ArrayList();
        Iterator iterChanges = scans.iterator();
        boolean errorUpdating = false;

        while (iterChanges.hasNext()) {
            COD_RecChangesFromScans recChanges = (COD_RecChangesFromScans) iterChanges.next();

            COD_ReceivablesController recContr = null;
            COD_ReceivablesVO recVO = null;
            errorUpdating = false;
            CODDaoLocal dao = null;
            CommonOpsDaoLocal daoComm = null;

            try {
                dao = getCODDaoLocal();
                daoComm = getCommonOpsDaoLocal();
                recContr = new COD_ReceivablesController();

                //recVO=recContr.getReceivables(new Integer(recChanges.getRecId()));

                recVO = new COD_ReceivablesVO();
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
                            empVO = new EmployeeVO(recChanges.getRecEmployeeId(), "Unknown Employee", "", "", "COD", null, "0", 0, null, 0, 0, null, 1);
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
                    recVO.setRecAmt(recChanges.getCodAmt() + recChanges.getAncChargeAmt());
                    recVO.setCustomerNm("Unknown Customer");
                    recVO.setRecDt(new java.util.Date());
                    recVO.setCodAmt(recChanges.getCodAmt());
                    recVO.setAncChargeAmt(recChanges.getAncChargeAmt());
                    recVO.setTinUniqId(recChanges.getRecTinUniqueId());
                    recVO.setCashPaymentAmt(recChanges.getRecCashPayment());
                    recVO.setOtherPaymentAmt(recChanges.getRecOtherPayment());
                    recVO.setOtherDocNbr(recChanges.getRecOtherDocNumber());
                    recVO.setOtherPaymentType(recChanges.getOtherPaymentType());
                    recVO.setDex11CashPayment(recChanges.getRecDex11CashPayment());
                    recVO.setDex11OtherPaymentAmt(recChanges.getRecDex11OtherPayment());
                    recVO.setDex11OtherDocNbr(recChanges.getRecDex11OtherDocNumber());
                    recVO.setDex11ScanSeqNbr(recChanges.getRecDex11CosmosScanSeqNbr());
                    recVO.setDex11FreightAmt(recChanges.getRecDex11FreightAmount());
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
                        recContr.setCOD_Receivables(recVO);      //else insert db.
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

    public Integer setCOD_Receivables(COD_ReceivablesVO COD_receivablesVO)
            throws COD_ReceivablesException {
        //-- we do not accept null value for the parameter.
        if (COD_receivablesVO == null) {
            throw new IllegalArgumentException("COD_receivablesVO parameter was null in setCOD_Receivables() method from ReceivablesManager class");
        }

        try {

            //-- create new Receivables object
            COD_ReceivablesLocal rl = getCOD_ReceivablesLocalHome().create(
                    COD_receivablesVO.getRecNbr(),
                    COD_receivablesVO.getCustomerNm(),
                    COD_receivablesVO.getRecDt(),
                    COD_receivablesVO.getInvCurrency(),
                    COD_receivablesVO.getCodAmt(),
                    COD_receivablesVO.getAncChargeAmt(),
                    COD_receivablesVO.getRecAmt(),
                    COD_receivablesVO.getLocationCd(),
                    COD_receivablesVO.getAwbNbr(),
                    COD_receivablesVO.getTinUniqId(),
                    COD_receivablesVO.getExchRateClnUsed(),
                    COD_receivablesVO.getEmployeeId(),
                    COD_receivablesVO.getPaymentCurrency(),
                    COD_receivablesVO.getCashPaymentAmt(),
                    COD_receivablesVO.getOtherPaymentAmt(),
                    COD_receivablesVO.getOtherPaymentType(),
                    COD_receivablesVO.getOtherDocNbr(),
                    COD_receivablesVO.getDex11CashPayment(),
                    COD_receivablesVO.getDex11FreightAmt(),
                    COD_receivablesVO.getDex11OtherPaymentAmt(),
                    COD_receivablesVO.getDex11OtherDocNbr(),
                    COD_receivablesVO.getDex11ScanSeqNbr(),
                    COD_receivablesVO.getChngStatusEmployeeId(),
                    COD_receivablesVO.getChngStatusDt(),
                    COD_receivablesVO.getCloseEmployeeId(),
                    COD_receivablesVO.getCloseDt(),
                    COD_receivablesVO.getEodEmployeeId(),
                    COD_receivablesVO.getEodDt(),
                    COD_receivablesVO.getLastScanType(),
                    COD_receivablesVO.getLastScanDate(),
                    COD_receivablesVO.getChkinAgentComment(),
                    COD_receivablesVO.getTrackingStatus(),
                    COD_receivablesVO.getStatusId(),
                    COD_receivablesVO.getCashDepositSlipId(),
                    COD_receivablesVO.getCashDepositSlipNbr(),
                    COD_receivablesVO.getOtherDepositSlipId(),
                    COD_receivablesVO.getOtherDepositSlipNbr(),
                    COD_receivablesVO.getCreditCardBatchId(),
                    COD_receivablesVO.getEodId(),
                    COD_receivablesVO.getCodXmlImpDt(),
                    COD_receivablesVO.getPymtImpDt(),
                    COD_receivablesVO.getOtherComment(),
                    COD_receivablesVO.getRecvPrepyAmt(),
                    COD_receivablesVO.getOrigCustNm(),
                    COD_receivablesVO.getCustChngEmpId(),
                    COD_receivablesVO.getOrigRecAmt(),
                    COD_receivablesVO.getAmtChngEmpId(),
                    COD_receivablesVO.getRcptNbr(),
                    COD_receivablesVO.getOrigRcptNbr(),
                    COD_receivablesVO.getRcptChngEmpId(), null, null,
                    COD_receivablesVO.getDualRecIdNbr(),
                    COD_receivablesVO.getDupAwbFlg(),
                    COD_receivablesVO.getbillAccount(),
                    //changes made to add the two columns miscDate,miscNbr
                    COD_receivablesVO.getMiscDate(), 
                    COD_receivablesVO.getMiscNbr()
            );
            return rl.getRecId();
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setCOD_Receivables() method from COD_ReceivablesManager class";
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
    public void splitCurrency(Collection COD_receivables, String currencyCd, double exchangeRate, double amountToChange) throws FacadeException {
        COD_ReceivablesController recCtrl = new COD_ReceivablesController();
        Integer newRecId = null;

        try {
            int count = COD_receivables.size();
            double tabSourceAmount = 0, tabDestAmount = 0, exchAmount = 0;
            double centValue = 0;

            COD_CourierCashRecapTableVO courierRec = null;
            COD_ReceivablesVO recNew = null;
            COD_ReceivablesVO recOld = null;

            Iterator recIt = COD_receivables.iterator();
            if (count == 1) {
                //If number of rec is 1 then use exchange rate value passed as parameter
                //Compute is different for count greater than 1
                while (recIt.hasNext()) {
                    courierRec = (COD_CourierCashRecapTableVO) recIt.next();
                    recOld = recCtrl.getCOD_Receivables(new Integer(courierRec.getRecId()));
                    recNew = recCtrl.getCOD_Receivables(new Integer(courierRec.getRecId()));
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
                    newRecId = this.setCOD_Receivables(recNew);
                    recNew.setRecId(newRecId);

                    //Update receivable old
                    recOld.setOtherComment((recOld.getOtherComment() == null ? "" : recOld.getOtherComment()) + "SPLT;");
                    recOld.setChkinAgentComment(recOld.getChkinAgentComment() == null ? "Exchange rate" : recOld.getOtherComment() + ",Exchange rate");
                    recOld.setStatusId(1);
                    recOld.setDualRecIdNbr(newRecId);
                    recCtrl.updateCOD_Receivables(recOld);
                }//Close while
            } else if (count > 1) {
                //If number of rec greater than 1
                while (recIt.hasNext()) {
                    courierRec = (COD_CourierCashRecapTableVO) recIt.next();
                    recOld = recCtrl.getCOD_Receivables(new Integer(courierRec.getRecId()));
                    recNew = recCtrl.getCOD_Receivables(new Integer(courierRec.getRecId()));
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
                    newRecId = this.setCOD_Receivables(recNew);
                    recNew.setRecId(newRecId);

                    //Update receivable old
                    recOld.setOtherComment((recOld.getOtherComment() == null ? "" : recOld.getOtherComment()) + "SPLT;");
                    recOld.setChkinAgentComment(recOld.getChkinAgentComment() == null ? "Exchange rate" : recOld.getOtherComment() + ",Exchange rate");
                    recOld.setStatusId(1);
                    recOld.setDualRecIdNbr(newRecId);
                    recCtrl.updateCOD_Receivables(recOld);

                }//close while

            }//Close if
        } catch (Exception e) {
            String errorMsg = "Error occurred in splitCurrency(Collection receivables, String tabType, double exchangeRate, double amountToChange) method of CODFacadeBean class";
            throw new EJBException(errorMsg, e);
        }
    }


    public Hashtable getSplitCourierCashRecapTable(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getCODDaoLocal().getSplitCourierCashRecapTable(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getSplitCourierCashRecapTable(String locationCd,String employeeId) method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection applyPaymentToInvoices(String courierId, String locationCd, String countryCd, String paymentCurrency, int paymentType, String otherDocNbr, boolean isCash, boolean isFindByAWB, Collection invoices) throws FacadeException {
        try {
            return getCODDaoLocal().applyPaymentToInvoices(courierId, locationCd, countryCd, paymentCurrency, paymentType, otherDocNbr, isCash, isFindByAWB, invoices);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in applyPaymentToInvoices() method from CODFacadeBean class";
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
     * This methods gets the COD_Receivables local home interface
     */
    private COD_ReceivablesLocalHome getCOD_ReceivablesLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (COD_ReceivablesLocalHome) service.getEJBLocalHome("COD_ReceivablesEJB.COD_ReceivablesLocalHome");
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getCOD_ReceivablesLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    private CommonOpsDaoLocal getCommonOpsDaoLocal() throws ServiceLocatorException, CreateException {
        CommonOpsDaoLocalHome daoHome = (CommonOpsDaoLocalHome) ServiceLocator.getInstance().getEJBLocalHome(Constants.CommonOpsDaoEJB_Local);
        CommonOpsDaoLocal dao = daoHome.create();
        return dao;
    }

    public TotalSummaryVO getCODDetailsTotal(String locationCodePk, String employeeCodePk, String currencyCode, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getCODDaoLocal().getCODDetailsTotal(locationCodePk, employeeCodePk, currencyCode, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCODDetailsTotal() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public TotalSummaryVO getCODDetailsSplitTotal(String locationCd, String employeeId, Integer pageNumber, Integer rowsByPage, String sortColumn, String sortDirection) throws FacadeException {
        try {
            return getCODDaoLocal().getCODDetailsSplitTotal(locationCd, employeeId, pageNumber, rowsByPage, sortColumn, sortDirection);
        }
        catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCODDetailsSplitTotal() method from CODFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

}//Close class CODFacadeBean
