/*
 * ProcessLastScanRunnable.java
 *
 * Created on September 28, 2002, 3:31 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* new Import used for new cosmos ese.jar
 * jeena paul*/
import com.fedex.asn.IA5String.masterlist_.MasterList;
import com.fedex.asn.IA5String.shipmentprofile_.ShipmentProfile;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.PrepaidVISAFileVO;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CosmosScanVO;


/**
 * This class is in charge of process the scans
 * for a list of non-checked-in AWBs
 * @author  ccardenas
 */
public class PrepNotCheckedScanRunn implements Runnable, java.io.Serializable {
    
    /** Holds value of property errors. */
    private Collection errors;
    
    /** Holds value of property awbs. */
    private Collection awbs;
    
    private Collection notProcessed1;
    
    private Collection localResults=new ArrayList();

    /** Holds value of property results. */
    private java.util.Collection results;
    
    /** Creates a new instance of ProcessLastScanRunnable */
    public PrepNotCheckedScanRunn() {
    }
    
    /**
     * This methods is started in his own thread.
     * It will order the processing of the scans scans for a list of AWBs
     * and will collect the errors produced
     */
    public void run() {
        try{
            Collection np=processLastScans(awbs);
            if(np!=null && !np.isEmpty()){
                notProcessed1.add(np);
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
    
    /** Getter for property notProcessed.
     * @return Value of property notProcessed.
     */
    public Collection getNotProcessed() {
        return this.notProcessed1;
    }
    
    /** Setter for property notProcessed.
     * @param notProcessed New value of property notProcessed.
     */
    public void setNotProcessed(Collection notProcessed) {
        this.notProcessed1 = notProcessed;
    }
    
    /**
     * Returns a Collection with the AWB couldn't be processed properly. 
     * @param  awbs will be processed
     */
    public Collection processLastScans(java.util.Collection colAWBs) throws Exception{
    	System.out.println("here we are as there is some problem - PrepNot Checked Scan");
    	
        Collection colNotProcessed=new ArrayList();
        Iterator iterAWBs=colAWBs.iterator();
        ShipmentProfile shiprof=null;
        Collection colMasterList=null;
        /*----Iterating on the AWBs. extLoop tag allows to continue
         * 	  in the most external loop----*/  
extLoop: while(iterAWBs.hasNext()){
            shiprof=null;
            colMasterList=null;
            PrepaidVISAFileVO prepVO=null;
            String paymentCurrency=null;
            try{
                prepVO=(PrepaidVISAFileVO)iterAWBs.next();
                paymentCurrency=prepVO.getPaymentCurrency();
                CosmosScanUtils csu=new CosmosScanUtils();
                System.out.println("Prepaid scan call:"+prepVO.getAwbNbr()+", "+prepVO.getTinUniqId());
                colMasterList=csu.getPrepaidScans(prepVO.getAwbNbr(),prepVO.getTinUniqId(),colNotProcessed,null,null,false);


                if(colMasterList!=null && !colMasterList.isEmpty()){
                	System.out.println("here we get something in the pre paid cosmosscan list");
                    /*----------------Main process--------------------------*/
                    Iterator iterMasterList=colMasterList.iterator();
                    if(prepVO.getCosmosScans()==null) prepVO.setCosmosScans(new ArrayList());

                    //iterate over the scans
                    while(iterMasterList.hasNext()){
                    	System.out.println("here we get something in list");
                        MasterList ml=(MasterList)iterMasterList.next();
                        String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                        String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();
                        if(prepVO.getTinUniqId()==null || "".equals(prepVO.getTinUniqId())) prepVO.setTinUniqId(ml.getTracking_item_unique_id()==null?null:ml.getTracking_item_unique_id().stringValue());
                        System.out.println("AWB_number - "+prepVO.getAwbNbr()+", Tin UniqID : "+prepVO.getTinUniqId());
                        
                        if (trackType!=null){
                        	
                        	//processing the PUX16 scans
                            if("29".equals(trackType) && "16".equals(codeType)) //PUX16
                            {
                                CosmosScanVO scanVO=new CosmosScanVO();

                                scanVO.setCourierId(ml.getEmployee_number()==null?null:ml.getEmployee_number().stringValue());

                                scanVO.setScanLocationCd(ml.getTrack_location_code()==null?null:ml.getTrack_location_code().stringValue());
                                scanVO.setAwbNbr(prepVO.getAwbNbr());
                                scanVO.setTinUniqId(prepVO.getTinUniqId());
                                scanVO.setScanSeqNbr(ml.getEvent_sequence_nbr()==null?null:ml.getEvent_sequence_nbr().stringValue());
                                String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();
                                scanVO.setScanDt(csu.parseDatesFromCosmos(datepart,timepart));
                                scanVO.setScanType("PUX16");
                                
                                prepVO.getCosmosScans().add(scanVO);
                                
                                prepVO.setLocationCd(scanVO.getScanLocationCd());

                                prepVO.setCourierId(scanVO.getCourierId());

                                prepVO.setCustomerNm(ml.getShipper_name()==null?null:ml.getShipper_name().stringValue());


                                prepVO.setLastScanType(scanVO.getScanType());
                                prepVO.setLastScanDate(scanVO.getScanDt());
                                prepVO.setPaymentCurrency(ml.getIso_currency_type()==null?null:ml.getIso_currency_type().stringValue());

                                int decsDivider=(int) Math.pow(10,(double)("USD".equals(prepVO.getPaymentCurrency())?prepVO.getScansUsdDecs():prepVO.getScansLocalDecs()));
                                prepVO.setCoupPymtAmt(ml.getCoupon_amt()!=null?(Double.parseDouble(ml.getCoupon_amt().stringValue())/decsDivider):0);

                                double amount=ml.getInt_payment_amount()!=null?Double.parseDouble(ml.getInt_payment_amount().stringValue()):
                                              ml.getPayment_amount()!=null?Double.parseDouble(ml.getPayment_amount().stringValue()):
                                              ml.getCash_payment_amt()!=null?Double.parseDouble(ml.getCash_payment_amt().stringValue()):
                                              ml.getCheck_payment_amt()!=null?Double.parseDouble(ml.getCheck_payment_amt().stringValue()):
                                              ml.getCredit_card_payment_amt()!=null?Double.parseDouble(ml.getCredit_card_payment_amt().stringValue()):0;

                                amount=(amount/decsDivider)-prepVO.getCoupPymtAmt();//in case they pay by coupon and money
                                            
                                if(amount>0){
                                                if(ml.getCash_payment_amt()!=null){
                                                        prepVO.setCashPaymentAmt(amount);
                                                }else{                                                
                                                        prepVO.setOtherPaymentAmt(amount);
                                                        if(ml.getCredit_card_payment_amt()!=null || ml.getCredit_card_nbr()!=null){
                                                              if(ml.getCredit_card_nbr()!=null){
                                                                  String ccNbr=ml.getCredit_card_nbr().stringValue();
                                                                  int start=ccNbr.length()-4;
                                                                  if(start<0)start=0;                                                                  
                                                                  prepVO.setOtherDocNbr(ccNbr.substring(start));                                                                  
                                                              }
                                                              prepVO.setOtherPaymentType(3);                                                        
                                                        }else{
                                                              prepVO.setOtherPaymentType(1); 
                                                              prepVO.setOtherDocNbr(ml.getCheck_nbr()!=null?ml.getCheck_nbr().stringValue():null);                                                              
                                                        }
                                                }
                                }
                                                
                                prepVO.setPux16CashPayment(prepVO.getCashPaymentAmt());
                                prepVO.setPux16OtherPaymentAmt(prepVO.getOtherPaymentAmt());
                                prepVO.setPux16OtherDocNbr(prepVO.getOtherDocNbr());
                                prepVO.setPux16ScanSeqNbr(scanVO.getScanSeqNbr());
                                prepVO.setPux16CoupPymtAmt(prepVO.getCoupPymtAmt());
                                prepVO.setPux16FreightAmt(ml.getFreight_charge_amount()==null?0:Double.parseDouble(ml.getFreight_charge_amount().stringValue())/decsDivider);
                                prepVO.setPUX(true);
                                break;
                            }else{ //process PUP scans
                                if("08".equals(trackType)){
                                    prepVO.setLocationCd(ml.getTrack_location_code()==null?null:ml.getTrack_location_code().stringValue());                                                                    
                                    prepVO.setCourierId(ml.getEmployee_number()==null?null:ml.getEmployee_number().stringValue());
                                    prepVO.setPUP(true);
                                }else{ //process PUX23 scans
		                                if("29".equals(trackType) && "23".equals(codeType)){
		                                	prepVO.setLocationCd(ml.getTrack_location_code()==null?null:ml.getTrack_location_code().stringValue());                                                                    
		                                	prepVO.setCourierId(ml.getEmployee_number()==null?null:ml.getEmployee_number().stringValue());
		                                	prepVO.setPUP(true);
		                                }  
                                }
                            
                            } 
                        }      
                }
                
                //add changes to local results
                localResults.add(prepVO);
            }else{
                Constants.logger.debug("MasterList doesn't exist. AWB: "+prepVO.getAwbNbr());
                localResults.add(prepVO);
            }
    }catch(Exception e){
        Constants.logger.debug("Scan Processing Error: "+Utils.stackTraceToString(e));
        localResults.add(prepVO);
    }

    //making sure a payment currency is assigned
    if(prepVO!=null && (prepVO.getPaymentCurrency()==null || "".equals(prepVO.getPaymentCurrency()))){
    	if(paymentCurrency!=null && !"".equals(paymentCurrency)){
    		prepVO.setPaymentCurrency(paymentCurrency);
    	}else{
    		prepVO.setPaymentCurrency("USD");
    	}
    }
    
    if(prepVO.getCourierId()==null || "".equals(prepVO.getCourierId())) prepVO.setCourierId("000000");
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
    

}

