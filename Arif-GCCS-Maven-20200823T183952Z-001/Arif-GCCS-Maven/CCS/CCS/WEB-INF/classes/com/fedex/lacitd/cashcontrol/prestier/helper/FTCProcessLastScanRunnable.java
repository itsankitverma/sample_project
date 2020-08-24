/**
 * FTCProcessLastScanRunnable.java
 *
 * Created on September 28, 2002, 3:31 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.util.*;

/* new Import used for new cosmos ese.jar
 * jeena paul*/
import com.fedex.asn.IA5String.masterlist_.MasterList;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;


/**
 * This class is in charge of process the scans from Cosmos
 * for the FTC feature. It is a Runnable class that
 * will run in its own thread. 
 * @author  ccardenas
 * @noinspection ALL
 */
public class FTCProcessLastScanRunnable implements Runnable, java.io.Serializable {

    /** Holds value of property errors. */
    private Collection errors;

    /** Holds value of property awbs. */
    private Collection awbs; 

    /** Holds value of property locationCodePk. */
    private String locationCodePk;
    
    private String countryCd;    

    private Collection notProcessed;

    private Collection localResults=new ArrayList();

    /** Holds value of property results. */
    private java.util.Collection results;

    /** Holds value of property keepWhenNotFound. */
    private boolean keepWhenNotFound;
    
    /** Holds value of property validLocations. */
    private Collection validLocations;

    public int getScansUsdDecs() {
        return scansUsdDecs;
    }

    public void setScansUsdDecs(int scansUsdDecs) {
        this.scansUsdDecs = scansUsdDecs;
    }

    public int getScansLocalDecs() {
        return scansLocalDecs;
    }

    public void setScansLocalDecs(int scansLocalDecs) {
        this.scansLocalDecs = scansLocalDecs;
    }

    private int scansUsdDecs;

    private int scansLocalDecs;

    /** Creates a new instance of ProcessLastScanRunnable */
    public FTCProcessLastScanRunnable() {
    }

    public void run() {
        try{
            Collection np=processLastScans(awbs,locationCodePk);
            if(np!=null && !np.isEmpty()){
                notProcessed.add(np);
            }
        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            errors.add(e);
        }
    }

    /** Getter for property errors.
     * @return Value of property errors.
     */
    public Collection getErrors() {
        return this.errors;
    }

    /** Setter for property errors.
     * @param errors New value of property errors.
     */
    public void setErrors(Collection errors) {
        this.errors = errors;
    }

    /** Getter for property awbs.
     * @return Value of property awbs.
     */
    public Collection getAwbs() {
        return this.awbs;
    }

    /** Setter for property awbs.
     * @param awbs New value of property awbs.
     */
    public void setAwbs(Collection awbs) {
        this.awbs = awbs;
    }

    /** Getter for property locationCodePk.
     * @return Value of property locationCodePk.
     */
    public String getLocationCodePk() {
        return this.locationCodePk;
    }

    /** Setter for property locationCodePk.
     * @param locationCodePk New value of property locationCodePk.
     */
    public void setLocationCodePk(String locationCodePk) {
        this.locationCodePk = locationCodePk;
    }

    public String getCountryCd() {
        return this.countryCd;
    }

    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    /** Getter for property notProcessed.
     * @return Value of property notProcessed.
     */
    public Collection getNotProcessed() {
        return this.notProcessed;
    }

    /** Setter for property notProcessed.
     * @param notProcessed New value of property notProcessed.
     */
    public void setNotProcessed(Collection notProcessed) {
        this.notProcessed = notProcessed;
    }

    /**
     * Process the scans from Cosmos for the FTC feature.
     * Returns a Collection with the AWB couldn't be processed properly.
     * 
     * @param     a Collection of FTCRecChangesFromScans objects containing the AWBs
     * @param     location where the user is working
     */
    public Collection processLastScans(java.util.Collection colAWBs, String locationCodePk) {//throws Exception{
        
    	if(colAWBs==null){
   			Constants.logger.debug("FTCProcessLastScanRunnable.java > processLastScans: colAWBs = null");
    	}//end if
    	
    	Collection colNotProcessed=new ArrayList();
        Iterator iterAWBs=colAWBs.iterator();
         
        Collection colMasterList=null;
        /*----Iterating on the AWBs. extLoop tag allows to continue
         * 	  in the most external loop----*/        
extLoop: while(iterAWBs.hasNext()){
            colMasterList=null;
            FTC_RecChangesFromScans recChanges=null;

            try{
                recChanges=(FTC_RecChangesFromScans)iterAWBs.next();

                if(recChanges.getLocationCd()==null)recChanges.setLocationCd(locationCodePk);
                if(recChanges.getRecEmployeeId()==null)recChanges.setRecEmployeeId("000000");
                recChanges.setCosmosScans(new ArrayList());
                CosmosScanUtils csu=new CosmosScanUtils();


                System.out.println("\nFTCProcessLastScanRunnable.java> AWB: " + recChanges.getRecAwbNumber());

                colMasterList=csu.getFTCScans(recChanges.getRecAwbNumber(),recChanges.getRecTinUniqueId(),colNotProcessed,null,getValidLocations(),false);

                if(colMasterList!=null && !colMasterList.isEmpty()){

                	System.out.println("\nFTCProcessLastScanRunnable.java> colMasterList: IS NOT EMPTY");
                	
                    /*----------------Main process--------------------------*/
                    Iterator iterMasterList=colMasterList.iterator();
                    boolean touched=false;
                    CosmosScanVO scanVO=null;
                    while(iterMasterList.hasNext()){
                       MasterList ml=(MasterList)iterMasterList.next();

                       if(ml.getEvent_sequence_nbr()!=null && Long.parseLong(ml.getEvent_sequence_nbr().stringValue())>Long.parseLong((recChanges.getRecLastScan()==null?"0":recChanges.getRecLastScan()))){
                            String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                            String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();
                            String trackLocationCd=ml.getTrack_location_code()==null?null:ml.getTrack_location_code().stringValue();
                            if(recChanges.getRecTinUniqueId()==null || "".equals(recChanges.getRecTinUniqueId())) recChanges.setRecTinUniqueId(ml.getTracking_item_unique_id()==null?null:ml.getTracking_item_unique_id().stringValue());

                            scanVO=new CosmosScanVO();
                            scanVO.setCourierId(ml.getEmployee_number()==null?null:ml.getEmployee_number().stringValue());
                            scanVO.setScanLocationCd(trackLocationCd);
                            scanVO.setAwbNbr(recChanges.getRecAwbNumber());
                            scanVO.setTinUniqId(recChanges.getRecTinUniqueId());
                            scanVO.setScanSeqNbr(ml.getEvent_sequence_nbr()==null?null:ml.getEvent_sequence_nbr().stringValue());
                            String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                            String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();
                            scanVO.setScanDt(csu.parseDatesFromCosmos(datepart,timepart));

                            recChanges.getCosmosScans().add(scanVO);
                            recChanges.setLocationCd(scanVO.getScanLocationCd());
                            recChanges.setRecEmployeeId(scanVO.getCourierId());
                            recChanges.setRecLastScanDate(scanVO.getScanDt());

                                if("16".equals(trackType) || //VAN SCAN
                                ("30".equals(trackType) && !"16".equals(codeType)) ||//DEX !=16
                                ("31".equals(trackType) && !"16".equals(codeType)) //DDEX !=16
                                ){  
                                    if("16".equals(trackType)){
                                        scanVO.setScanType("VAN");
                                        recChanges.setInCage(false);
                                    }else{
                                        if("31".equals(trackType)){
                                            scanVO.setScanType("DDEX"+codeType);
                                            recChanges.setInCage(true);
                                        }else{
                                        		scanVO.setScanType("DEX"+codeType);                                        		
                                        		recChanges.setInCage(true);
                                        }    
                                    }

                                    recChanges.setRecTrackingStatus(1);
                                    touched=true;
                                }else{

                                    if(("07".equals(trackType) && "44".equals(codeType)) || //STAT44
                                    	"02".equals(trackType)){ //SIP
                                        if("02".equals(trackType)){
                                        	scanVO.setScanType("SIP");
                                        }else{ 
                                        	scanVO.setScanType("STAT44");
                                        }
                                        recChanges.setInCage(true);
                                        recChanges.setRecTrackingStatus(1); 

                                        touched=true;
                                    }else{
                                        if("20".equals(trackType) || //POD SCAN
                                        ("31".equals(trackType) && "16".equals(codeType)) //DDEX =16
                                        ){
                                            if("20".equals(trackType))
                                                scanVO.setScanType("POD");
                                            else
                                                scanVO.setScanType("DDEX16");

                                            recChanges.setInCage(false);
                                            recChanges.setRecPaymentCurrency(ml.getIso_currency_type()==null?null:ml.getIso_currency_type().stringValue());

                                            int decsDivider=(int) Math.pow(10,(double)("USD".equals(recChanges.getRecPaymentCurrency())?scansUsdDecs:scansLocalDecs));

                                            if("31".equals(trackType) && "16".equals(codeType)){
                                            	 double amount=ml.getInt_duty_tax_amount()!=null?Double.parseDouble(ml.getInt_duty_tax_amount().stringValue()):
                                                     ml.getInt_payment_amount()!=null?Double.parseDouble(ml.getInt_payment_amount().stringValue()):
                                                     ml.getPayment_amount()!=null?Double.parseDouble(ml.getPayment_amount().stringValue()):
                                                     ml.getCash_payment_amt()!=null?Double.parseDouble(ml.getCash_payment_amt().stringValue()):
                                                     ml.getCheck_payment_amt()!=null?Double.parseDouble(ml.getCheck_payment_amt().stringValue()):
                                                     ml.getCredit_card_payment_amt()!=null?Double.parseDouble(ml.getCredit_card_payment_amt().stringValue()):0;                  



                                        if(ml.getCash_payment_amt()!=null){
                                            recChanges.setRecCashPayment(amount/decsDivider);
                                        }else{
                                            recChanges.setRecOtherPayment(amount/decsDivider);
                                            if(ml.getCheck_payment_amt()!=null){
                                                recChanges.setOtherPaymentType(1);
                                                recChanges.setRecOtherDocNumber(ml.getCheck_nbr()!=null?ml.getCheck_nbr().stringValue():null);                                                        
                                            }else{
                                                 if(ml.getCredit_card_payment_amt()!=null || ml.getCredit_card_nbr()!=null){
                                                      if(ml.getCredit_card_nbr()!=null){
                                                          String ccNbr=ml.getCredit_card_nbr().stringValue();
                                                          int start=ccNbr.length()-4;
                                                          if(start<0)start=0;                        
                                                          recChanges.setRecOtherDocNumber(ccNbr.substring(start));                                                                  
                                                      }
                                                      recChanges.setOtherPaymentType(3);
                                                 }else{                                                        
                                                      recChanges.setOtherPaymentType(2);
                                                 }     
                                            }    
                                        }
                                                recChanges.setRecDex16CashPayment(recChanges.getRecCashPayment());
                                                recChanges.setRecDex16OtherPayment(recChanges.getRecOtherPayment());
                                                recChanges.setRecDex16OtherDocNumber(recChanges.getRecOtherDocNumber());
                                                recChanges.setRecDex16CosmosScanSeqNbr(scanVO.getScanSeqNbr());
                                                recChanges.setRecDex16FreightAmount(ml.getFreight_charge_amount()==null?0:Double.parseDouble(ml.getFreight_charge_amount().stringValue())/decsDivider);

                                                if(recChanges.getRecCashPayment()>0){
                                                    recChanges.setRecCashPayment(recChanges.getRecCashPayment()+recChanges.getRecDex16FreightAmount());
                                                }else{
                                                    recChanges.setRecOtherPayment(recChanges.getRecOtherPayment()+recChanges.getRecDex16FreightAmount());
                                                }
                                                
                                                touched=true; //DDEX16 NOT MORE
                                                recChanges.setRecTrackingStatus(3);
                                                break;
                                            }else{
                                                if((recChanges.getRecCashPayment()+recChanges.getRecOtherPayment())>0)
                                                    recChanges.setRecTrackingStatus(3);
                                                else
                                                    recChanges.setRecTrackingStatus(2);
                                            }
                                            touched=true;
                                        }
                                    }
                                }

                          }
                        }
                        //SET SCAN TYPE
                        recChanges.setRecLastScanType(scanVO.getScanType());
                        if(touched || keepWhenNotFound){  
                           localResults.add(recChanges);
                        }
                    }else{
                        if(keepWhenNotFound){
                              localResults.add(recChanges);
                        }
                    }
            }catch(Exception e){
                Constants.logger.debug("Scan Processing Error: "+Utils.stackTraceToString(e));
                colNotProcessed.add(new ScansProcessingError(recChanges.getRecAwbNumber(),"app.messages.UnknownError", null, "","",""));
                /*--If it needs insert it even if it is not found--*/ 
                if(keepWhenNotFound){
                      localResults.add(recChanges);
                }                        
                
            }
        }
        results.addAll(localResults);
        return colNotProcessed;
    }

    /** Getter for property results.
     * @return Value of property results.
     */
    public java.util.Collection getResults() {
        return this.results;
    }

    /** Setter for property results.
     * @param results New value of property results.
     */
    public void setResults(java.util.Collection results) {
        this.results = results;
    }

    /** Getter for property keepWhenNotFound.
     * @return Value of property keepWhenNotFound.
     */
    public boolean isKeepWhenNotFound() {
        return this.keepWhenNotFound;
    }
    
    /** Setter for property keepWhenNotFound.
     * @param keepWhenNotFound New value of property keepWhenNotFound.
     */
    public void setKeepWhenNotFound(boolean keepWhenNotFound) {
        this.keepWhenNotFound = keepWhenNotFound;
    }
    
    /** Getter for property validLocations.
     * @return Value of property validLocations.
     */
    public Collection getValidLocations() {
        return this.validLocations;
    }
    
    /** Setter for property validLocations.
     * @param validLocations New value of property validLocations.
     */
    public void setValidLocations(Collection validLocations) {
        this.validLocations = validLocations;
    }
    
}

