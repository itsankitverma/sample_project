/**
 *
 * Created on September 28, 2002, 3:31 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;
import org.apache.struts.action.ActionError;
import java.util.*;

/* new Import used for new cosmos ese.jar
 * jeena paul*/
import com.fedex.asn.IA5String.masterlist_.MasterList;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;


/**
 * This class is in charge of process the scans from Cosmos
 * for the Add Prepaid feature. It is a Runnable class that
 * will run in its own thread. 
 * @author  ccardenas
 */
public class PrepaidScanRunnable implements Runnable, java.io.Serializable {
    private String tzName; 
    /** Holds value of property errors. */
    private Collection errors;
    
    /** Holds value of property awbs. */
    private Collection awbs;
    
    /** Holds value of property locationCd. */
    private String locationCd;
    
    private Collection notProcessed;
    
    private Collection localResults=new ArrayList();
    
    /** Holds value of property results. */
    private java.util.Collection results;
    
    /** Holds value of property courierId. */
    private String courierId;
    
    /** Holds value of property currentCurrency. */
    private String currentCurrency;

    public Collection getValidLocations() {
        return validLocations;
    }

    public void setValidLocations(Collection validLocations) {
        this.validLocations = validLocations;
    }

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
    public PrepaidScanRunnable() {
    }
    
    public void run() {
        try{
            Collection np=processLastScans(awbs,locationCd,courierId,currentCurrency);
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
    
    /** Getter for property locationCd.
     * @return Value of property locationCd.
     */
    public String getLocationCd() {
        return this.locationCd;
    }
    
    /** Setter for property locationCd.
     * @param locationCd New value of property locationCd.
     */
    public void setLocationCd(String locationCd) {
        this.locationCd = locationCd;
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
     * Process the scans from Cosmos for the Add Prepaid feature.
     * Returns a Collection with the AWB couldn't be processed properly.
     * 
     * @param     a Collection of PrepaidScansVO objects containing the awb numbers
     * @param     location where the user is working
     * @param     courier Id related to the AWB
     * @param     currency code the user is using
     * @return    a Collection with the AWB couldn't be processed properly.
     */    
    public Collection processLastScans(java.util.Collection colAWBs, String locationCd,String courierId,String currencyCode) {
        Collection colNotProcessed=new ArrayList();
        Iterator iterAWBs=colAWBs.iterator();
        Collection colMasterList=null;
        
        /*----Iterating on the AWBs. extLoop tag allows to continue
         * 	  in the most external loop----*/
extLoop: while(iterAWBs.hasNext()){
            colMasterList=null;
            PrepaidScansVO prepScansVO=null;
            PrepaidVO prepVO=null;
            try{
                prepScansVO=(PrepaidScansVO)iterAWBs.next();
                prepVO=prepScansVO.getPrepaidVO();
                prepScansVO.setLastScanSeqNbr(prepVO.getPux16ScanSeqNbr()==null?"0":prepVO.getPux16ScanSeqNbr());
                prepScansVO.setAwbNbr(prepVO.getAwbNbr());

                //Constants.logger.debug(" :" + prepScansVO.getAwbNbr());

                CosmosScanUtils csu=new CosmosScanUtils();
                colMasterList=csu.getPrepaidScans(prepScansVO.getAwbNbr(),prepVO.getTinUniqId(),null,null,validLocations,false);

                    if(colMasterList!=null &&  !colMasterList.isEmpty()){
                        /*----------------Main process--------------------------*/
                        Iterator iterMasterList=colMasterList.iterator();
                        if(prepScansVO.getCosmosScans()==null) prepScansVO.setCosmosScans(new ArrayList());                        
                        
                        String pux16Emp=null;
                        /*------Iterating over the scans-------*/
                        while(iterMasterList.hasNext()){
                            MasterList ml=(MasterList)iterMasterList.next();
                            
                            /*---If the scan sequence number is greater that the last scan processed for the awb
                             * 	 process the scan. If not just ignore it---*/                            
                            if(ml.getEvent_sequence_nbr()!=null && Long.parseLong(ml.getEvent_sequence_nbr().stringValue())>Long.parseLong(prepScansVO.getLastScanSeqNbr())){

                                String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                                String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();
                                if(prepVO.getTinUniqId()==null || "".equals(prepVO.getTinUniqId())) prepVO.setTinUniqId(ml.getTracking_item_unique_id()==null?null:ml.getTracking_item_unique_id().stringValue());

                                if (trackType!=null){
                                    if("29".equals(trackType) && "16".equals(codeType)) //PUX16
                                    {   
                                        pux16Emp=ml.getEmployee_number()==null?null:ml.getEmployee_number().stringValue();
                                        
                                        /*---If the provided courier is null or the provided courier is not null and 
                                         *   it matches with the courier comming in the scan, process it.
                                         *   if not just ignore it---*/
                                        if (courierId==null || "".equals(courierId) || (courierId!=null && !"".equals(courierId) && pux16Emp!= null && !"".equals(pux16Emp) && pux16Emp.equals(courierId)))
                                        {
                                            CosmosScanVO scanVO=new CosmosScanVO();

                                            //Assigning values to the scan that will be inserted in the db
                                            scanVO.setCourierId(pux16Emp);
                                            scanVO.setScanLocationCd(ml.getTrack_location_code()==null?null:ml.getTrack_location_code().stringValue());
                                            scanVO.setAwbNbr(prepVO.getAwbNbr());
                                            scanVO.setTinUniqId(prepVO.getTinUniqId());
                                            scanVO.setScanSeqNbr(ml.getEvent_sequence_nbr()==null?null:ml.getEvent_sequence_nbr().stringValue());
                                            String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                            String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();
                                            scanVO.setScanDt(csu.parseDatesFromCosmos(datepart,timepart));
                                            scanVO.setScanType("PUX16");

                                            prepScansVO.getCosmosScans().add(scanVO);

                                            //Assigning values comming from scan to the prepaid will be inserted in the db
                                            prepVO.setLocationCd(locationCd);
                                            prepVO.setCourierId(pux16Emp); 
                                            prepVO.setCustomerNm(ml.getShipper_name()==null?null:ml.getShipper_name().stringValue());                                            
                                            prepVO.setLastScanType(scanVO.getScanType());
                                            prepVO.setLastScanDate(scanVO.getScanDt());
                                            prepVO.setAwbDt(scanVO.getScanDt());
                                            prepVO.setPaymentCurrency(ml.getIso_currency_type()==null?currencyCode:ml.getIso_currency_type().stringValue());
                                            int decsDivider=(int) Math.pow(10,(double)("USD".equals(prepVO.getPaymentCurrency())?scansUsdDecs:scansLocalDecs));

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
                                            break;
                                        }
                                      }else{
                                          if("08".equals(trackType)){ //PUP
                                          		//Assigning values comming from scan to the prepaid will be inserted in the db
                                                pux16Emp=ml.getEmployee_number()==null?null:ml.getEmployee_number().stringValue();                                                
                                                prepVO.setCourierId(pux16Emp);
                                                String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                                String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();
                                                prepVO.setPaymentCurrency(currencyCode);
                                                prepVO.setAwbDt(csu.parseDatesFromCosmos(datepart,timepart));
                                                
                                          }else{
                                          		//Assigning values comming from scan to the prepaid will be inserted in the db
                                          		if("29".equals(trackType) && "23".equals(codeType)){ //PUX23
                                          			pux16Emp=ml.getEmployee_number()==null?null:ml.getEmployee_number().stringValue();                                                
                                          			prepVO.setCourierId(pux16Emp);
                                          			String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                          			String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();
                                          			prepVO.setPaymentCurrency(currencyCode);
                                          			prepVO.setAwbDt(csu.parseDatesFromCosmos(datepart,timepart));
                                          		} 
                                          }    
                                      }                                        
                                    }
                               
                            }
                        }
                        
                        /*---If the courier in the scan doesn not match the courier the user is working with
                         *   the system will show an error and won't insert the AWB---*/
                        if(pux16Emp!=null && !"".equals(pux16Emp) && courierId!=null && !"".equals(courierId) && !pux16Emp.equals(courierId)){
                            Constants.logger.debug("PUX16 Employee does not match "+prepVO.getAwbNbr());
                            colNotProcessed.add(new ActionError("app.messages.PUX16CourierDoesNotMatch",prepVO.getAwbNbr(),pux16Emp,courierId));                            
                        }else{
                        	/*---If there is not PUP or PUX scan and courier Id was not provided,
                        	 *   the system will show an error and won't insert the AWB---*/
                            if((pux16Emp==null || "".equals(pux16Emp)) && (courierId==null || "".equals(courierId))){
                                Constants.logger.debug("No PUX for AWB "+prepVO.getAwbNbr()+". No Courier ID provided ");
                                colNotProcessed.add(new ActionError("app.messages.NoPUXForAWB",prepVO.getAwbNbr()));                            
                            }else{
                            	/*---If there is not PUP or PUX scan and courier Id was provided
                            	 *   assign the provided courier to the prepaid---*/
                                if(pux16Emp==null || "".equals(pux16Emp) ){
                                    prepScansVO.getPrepaidVO().setCourierId(courierId);
                                }else{
                                    prepScansVO.getPrepaidVO().setCourierId(pux16Emp);
                                }

                                /*---Just in case the courier id was not assigned, set it with the provided one---*/                                
                                if(prepScansVO.getPrepaidVO().getCourierId()==null ){
                                    prepScansVO.getPrepaidVO().setCourierId(courierId);
                                }                            

                                /*---Just in case the location was not assigned, set it with the provided one---*/                                
                                if(prepScansVO.getPrepaidVO().getLocationCd()==null){
                                    prepScansVO.getPrepaidVO().setLocationCd(locationCd);
                                }

                                /*---Just in case the currency was not assigned, set it with the provided one---*/                                
                                if(prepScansVO.getPrepaidVO().getPaymentCurrency()==null){
                                    prepScansVO.getPrepaidVO().setPaymentCurrency(currentCurrency);
                                }    

                                /*---Just in case the date was not assigned, set it with the current date---*/
                                if(prepScansVO.getPrepaidVO().getAwbDt()==null){
                                    prepScansVO.getPrepaidVO().setAwbDt(new java.util.Date());
                                }    
                            

                                localResults.add(prepScansVO);
                            }   
                        }
                    }else{
                        if (courierId==null || "".equals(courierId)){
                                colNotProcessed.add(new ActionError("app.messages.NoPUXForAWB",prepVO.getAwbNbr()));  
                        }else{
                                colNotProcessed.add(new ActionError("app.messages.DecodingError1",prepVO.getAwbNbr()));
                                prepScansVO.getPrepaidVO().setLocationCd(locationCd);                
                                prepScansVO.getPrepaidVO().setCourierId(courierId);                
                                prepScansVO.getPrepaidVO().setPaymentCurrency(currentCurrency);
                                prepScansVO.getPrepaidVO().setAwbDt(Utils.changeDateToTZ(new Date(),this.tzName));
                                localResults.add(prepScansVO);
                        }

                    }



            }catch(Exception e){
                Constants.logger.debug("Scan Processing Error: "+Utils.stackTraceToString(e));
                
                if (courierId==null || "".equals(courierId)){
                	/*------If courier was not provided show error and don't insert the AWB-----*/
                     colNotProcessed.add(new ActionError("app.messages.NoPUXForAWB",prepVO.getAwbNbr()));  
                }else{
                	/*------If courier was provided show error and insert the AWB-----*/                	
                     colNotProcessed.add(new ActionError("app.messages.DecodingError1",prepVO.getAwbNbr()));
                     prepScansVO.getPrepaidVO().setLocationCd(locationCd);                
                     prepScansVO.getPrepaidVO().setCourierId(courierId);                
                     prepScansVO.getPrepaidVO().setPaymentCurrency(currentCurrency);
                     prepScansVO.getPrepaidVO().setAwbDt(Utils.changeDateToTZ(new Date(),this.tzName));
                     localResults.add(prepScansVO);
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
    
    /** Getter for property courierId.
     * @return Value of property courierId.
     */
    public String getCourierId() {
        return this.courierId;
    }
    
    /** Setter for property courierId.
     * @param courierId New value of property courierId.
     */
    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }
    
    /** Getter for property currentCurrency.
     * @return Value of property currentCurrency.
     */
    public String getCurrentCurrency() {
        return this.currentCurrency;
    }
    
    /** Setter for property currentCurrency.
     * @param currentCurrency New value of property currentCurrency.
     */
    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }
    
	/**
	 * @return Returns the tzName.
	 */
	public String getTzName() {
		return tzName;
	}

	/**
	 * @param tzName The tzName to set.
	 */
	public void setTzName(String tzName) {
		this.tzName = tzName;
	}

}

