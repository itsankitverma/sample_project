/**
 * ProcessLastScanRunnable.java
 *
 * Created on September 28, 2002, 3:31 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

/* new Import used for new cosmos ese.jar
 * jeena paul*/
//import com.fedex.ese.masterlist_.MasterList;
//import com.fedex.ese.shipmentprofile_.ShipmentProfile;
import com.fedex.asn.IA5String.masterlist_.MasterList;
import com.fedex.asn.IA5String.shipmentprofile_.ShipmentProfile;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.ScansProcessingError;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CosmosScanVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 *
 * @author  ccardenas
 */
public class RODProcessSTAT44Runnable implements Runnable, java.io.Serializable {
    
    /** Holds value of property errors. */
    private Collection errors;
    
    /** Holds value of property awbs. */
    private Collection awbs;
    
    private Collection notProcessed;
    
    private Collection localResults=new ArrayList();
    
    /** Holds value of property results. */
    private java.util.Collection results;
    
    /** Creates a new instance of ProcessLastScanRunnable */
    public RODProcessSTAT44Runnable() {
    }
    
    public void run() {
        try{
            Collection np=processLastScans(awbs);
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
     * Returns a Collection with the AWB couldn't be processed properly.
     */
    public Collection processLastScans(java.util.Collection colAWBs) {//throws Exception{
        Collection colNotProcessed=new ArrayList();
        int att=0;
        Iterator iterAWBs=colAWBs.iterator();
        ShipmentProfile shiprof=null;
        Collection colMasterList=null;
        
extLoop: while(iterAWBs.hasNext()){
            shiprof=null;
            colMasterList=null;
            CosmosScanVO csVO=null;
            try{
                csVO=(CosmosScanVO)iterAWBs.next();
                CosmosScanUtils csu=new CosmosScanUtils();
                colMasterList=csu.getRODScans(csVO.getAwbNbr(),csVO.getTinUniqId(),colNotProcessed,null,null,false);

                    if(colMasterList!=null && !colMasterList.isEmpty()){
                        /*----------------Main process--------------------------*/
                        Iterator iterMasterList=colMasterList.iterator();
                        boolean touched=false;
                        
                        while(iterMasterList.hasNext()){
                            MasterList ml=(MasterList)iterMasterList.next();
                            if(ml.getEvent_sequence_nbr()!=null && Long.parseLong(ml.getEvent_sequence_nbr().stringValue())>Long.parseLong(csVO.getScanSeqNbr())){
                                
                                String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                                String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();
                                if(csVO.getTinUniqId()==null || "".equals(csVO.getTinUniqId())) csVO.setTinUniqId(ml.getTracking_item_unique_id()==null?null:ml.getTracking_item_unique_id().stringValue());

                                if (trackType!=null){
                                    if("07".equals(trackType) && "44".equals(codeType)){ //STAT44
                                        csVO.setCourierId(ml.getEmployee_number()==null?null:ml.getEmployee_number().stringValue());
                                        csVO.setScanLocationCd(ml.getTrack_location_code()==null?null:ml.getTrack_location_code().stringValue());
                                        csVO.setScanSeqNbr(ml.getEvent_sequence_nbr()==null?null:ml.getEvent_sequence_nbr().stringValue());
                                        String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                        String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();
                                        csVO.setScanDt(csu.parseDatesFromCosmos(datepart,timepart));
                                        csVO.setScanType("STAT44");
                                        touched=true;
                                    }
                                }
                            }
                        }
                    if(touched){
                        localResults.add(csVO);
                    }
                }else{
                    Constants.logger.debug("MasterList doesn't exist. AWB: "+csVO.getAwbNbr());
                    colNotProcessed.add(new ScansProcessingError(csVO.getAwbNbr(),"app.messages.CannotFindDetailedScans", null, "","",""));
                }
        }catch(Exception e){
            Constants.logger.debug("Scan Processing Error: "+Utils.stackTraceToString(e));
            colNotProcessed.add(new ScansProcessingError(csVO.getAwbNbr(),"app.messages.UnknownError", null, "","",""));
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


}

