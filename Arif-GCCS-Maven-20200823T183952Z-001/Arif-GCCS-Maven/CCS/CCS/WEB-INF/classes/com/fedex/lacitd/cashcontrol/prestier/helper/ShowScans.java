package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* new Import used for new cosmos ese.jar
 * jeena paul*/
import com.fedex.asn.IA5String.masterlist_.MasterList;
import com.fedex.asn.IA5String.shipmentprofile_.ShipmentProfile;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.CosmosScansTableVO;
import com.fedex.lacitd.cashcontrol.biztier.common.ScansProcessingError;
import com.fedex.lacitd.cashcontrol.common.Utils;


/**
 * This class is in charge of process the scans from Cosmos
 * for the ROD feature. It is a Runnable class that
 * will run in its own thread. 
 * @author  ccardenas
 */
public class ShowScans implements java.io.Serializable {

	Collection errors=new ArrayList();

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

    /**
     * Obtain the scans from Cosmos for the ROD feature.
     * Returns a Collection with the scans.
     * 
     * @param     AWB Number
     * @param     location where the user is working
     */
    public Collection getRODScans(String awbNumber,String locationCodePk) {//throws Exception{
        Collection colMasterList=null;
        Collection colResults=new ArrayList();

        try{
                    CosmosScanUtils csu=new CosmosScanUtils();
                    colMasterList=csu.getRODScans(awbNumber,null,errors,null,null,true);

                    if(colMasterList!=null){
                        /*----------------Main process--------------------------*/
                        Iterator iterMasterList=colMasterList.iterator();
                        boolean touched=false;

                        while(iterMasterList.hasNext()){
                        	MasterList ml=(MasterList)iterMasterList.next();
                        	CosmosScansTableVO scanVO=null;
                            String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                            String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();
                            String trackLocationCd=ml.getTrack_location_code()==null?"Not Found":ml.getTrack_location_code().stringValue();

                                if("11".equals(trackType) || //VAN SCAN
                                ("30".equals(trackType) && !"16".equals(codeType)) ||//DEX !=16
                                ("31". equals(trackType) && !"16".equals(codeType)) //DDEX !=16
                                ){  
                                    scanVO=new CosmosScansTableVO();
                                    scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                    scanVO.setLocationCd(trackLocationCd);
 
                                    String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                    String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                    scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                    scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);
                                    if("11".equals(trackType)){
                                        scanVO.setScanType("VAN");  
                                        scanVO.setFontColor("#0000FF");                                        
                                    }else{
                                        if("31".equals(trackType)){
                                            scanVO.setScanType("DDEX"+codeType);  
                                            scanVO.setFontColor("#FF0000");
                                        }else{
                                        		scanVO.setScanType("DEX"+codeType);
                                        		scanVO.setFontColor("#FF0000");
                                        }    
                                    }

                                }else{
                                    if(("07".equals(trackType) && "44".equals(codeType)) || //STAT44
                                    	"02".equals(trackType)){ //SIP
                                        scanVO=new CosmosScansTableVO();
                                        scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                        scanVO.setLocationCd(trackLocationCd);

                                        String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                        String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                        scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                        
                                        if("02".equals(trackType)){
                                        	scanVO.setScanType("SIP");
                                        	scanVO.setFontColor("#FF00FF");
                                        }else{ 
                                        	scanVO.setScanType("STAT44");
                                        	scanVO.setFontColor("#FF9933");
                                        }
                                        scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);

                                    }else{
                                        if("20".equals(trackType) || //POD SCAN
                                        ("31".equals(trackType) && "16".equals(codeType)) //DDEX =16
                                        ){

                                            scanVO=new CosmosScansTableVO();
                                            scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                            scanVO.setLocationCd(trackLocationCd);

                                            String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                            String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                            scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                            
                                            if("20".equals(trackType)){
                                                scanVO.setScanType("POD");
                                                scanVO.setFontColor("#808000");
                                            }else{
                                                scanVO.setScanType("DDEX16");
                                                scanVO.setFontColor("#008000");
                                            }

                                            if("31".equals(trackType) && "16".equals(codeType)){
                                                double amount=ml.getInt_duty_tax_amount()!=null?Double.parseDouble(ml.getInt_duty_tax_amount().stringValue()):
                                                             ml.getInt_payment_amount()!=null?Double.parseDouble(ml.getInt_payment_amount().stringValue()):
                                                             ml.getPayment_amount()!=null?Double.parseDouble(ml.getPayment_amount().stringValue()):
                                                             ml.getCash_payment_amt()!=null?Double.parseDouble(ml.getCash_payment_amt().stringValue()):
                                                             ml.getCheck_payment_amt()!=null?Double.parseDouble(ml.getCheck_payment_amt().stringValue()):
                                                             ml.getCredit_card_payment_amt()!=null?Double.parseDouble(ml.getCredit_card_payment_amt().stringValue()):0;
                                                             
                                                String currency=ml.getIso_currency_type()==null?null:ml.getIso_currency_type().stringValue();
                                                int decsDivider=(int) Math.pow(10,(double)("USD".equals(currency)?scansUsdDecs:scansLocalDecs));


                                                if(ml.getCash_payment_amt()!=null){
                                                    scanVO.setDetails("Cash Payment "+amount/decsDivider+" "+currency);
                                                }else{
                                                    
                                                    if(ml.getCredit_card_payment_amt()!=null || ml.getCredit_card_nbr()!=null){
                                                    	scanVO.setDetails("Credit Card Payment "+amount/decsDivider+" "+currency);
                                                    }else{
                                                    	scanVO.setDetails("Check Payment "+amount/decsDivider+" "+currency);
                                                    }    
                                                }
 
                                            }

                                        }else{
                                        	if("90".equals(trackType)){
                                                scanVO=new CosmosScansTableVO();
                                                scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                                scanVO.setLocationCd(trackLocationCd);

                                                String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                                String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                                scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                                scanVO.setScanType("COMM");
                                                scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);
                                                scanVO.setFontColor("#000000");	
                                        	}else{
                                                if("41".equals(trackType)){
                                                    scanVO=new CosmosScansTableVO();
                                                    scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                                    scanVO.setLocationCd(trackLocationCd);

                                                    String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                                    String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                                    scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                                    scanVO.setScanType("HAL");
                                                    scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);
                                                    scanVO.setFontColor("#000000");
                                        	    }
                                            }
                                        }
                                    }
                                }
                                if(scanVO!=null)colResults.add(scanVO);
                            }
                    }
            }catch(Exception e){
                Constants.logger.debug("Scan Processing Error: "+Utils.stackTraceToString(e));
                errors.add(new ScansProcessingError(awbNumber,"app.messages.UnknownError", null, "","",""));
            }
            return colResults;
    }
    

    /**
     * Obtain the scans from Cosmos for the COD feature.
     * Returns a Collection with the scans.
     * 
     * @param     AWB Number
     * @param     location where the user is working
     */
    public Collection getCODScans(String awbNumber,String locationCodePk) {//throws Exception{
        Collection colMasterList=null;
        Collection colResults=new ArrayList();

        try{
                    CosmosScanUtils csu=new CosmosScanUtils();
                    colMasterList=csu.getCODScans(awbNumber,null,errors,null,null,true);

                    if(colMasterList!=null){
                        /*----------------Main process--------------------------*/
                        Iterator iterMasterList=colMasterList.iterator();
                        boolean touched=false;

                        while(iterMasterList.hasNext()){
                        	MasterList ml=(MasterList)iterMasterList.next();
                        	CosmosScansTableVO scanVO=null;
                            String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                            String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();
                            String trackLocationCd=ml.getTrack_location_code()==null?"Not Found":ml.getTrack_location_code().stringValue();

                            System.out.println("\n\nShowScans.java > trackType="+trackType + " | codeType=" + codeType + " | trackLocationCd = "+trackLocationCd);
                              
                            if("11".equals(trackType) || //VAN SCAN
                                ("30".equals(trackType) && !"11".equals(codeType)) ||//DEX !=11
                                ("31". equals(trackType) && !"11".equals(codeType)) //DDEX !=11
                                ){  
                                    scanVO=new CosmosScansTableVO();
                                    scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                    scanVO.setLocationCd(trackLocationCd);
 
                                    String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                    String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                    scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                    scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);
                                    if("11".equals(trackType)){
                                        scanVO.setScanType("VAN");  
                                        scanVO.setFontColor("#0000FF");                                        
                                    }else{
                                        if("31".equals(trackType)){
                                            scanVO.setScanType("DDEX"+codeType);  
                                            scanVO.setFontColor("#FF0000");
                                        }else{
                                        		scanVO.setScanType("DEX"+codeType);
                                        		scanVO.setFontColor("#FF0000");
                                        }    
                                    }

                                }else{
                                    if(("07".equals(trackType) && "44".equals(codeType)) || //STAT44
                                    	"02".equals(trackType)){ //SIP
                                        scanVO=new CosmosScansTableVO();
                                        scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                        scanVO.setLocationCd(trackLocationCd);

                                        String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                        String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                        scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                        
                                        if("02".equals(trackType)){
                                        	scanVO.setScanType("SIP");
                                        	scanVO.setFontColor("#FF00FF");
                                        }else{ 
                                        	scanVO.setScanType("STAT44");
                                        	scanVO.setFontColor("#FF9933");
                                        }
                                        scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);

                                    }else{
                                        if("20".equals(trackType) || //POD SCAN
                                        ("31".equals(trackType) && "11".equals(codeType)) //DDEX =11
                                        ){

                                            scanVO=new CosmosScansTableVO();
                                            scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                            scanVO.setLocationCd(trackLocationCd);

                                            String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                            String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                            scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                            
                                            if("20".equals(trackType)){
                                                scanVO.setScanType("POD");
                                                scanVO.setFontColor("#808000");
                                            }else{
                                                scanVO.setScanType("DDEX11");
                                                scanVO.setFontColor("#008000");
                                            }

                                            if("31".equals(trackType) && "11".equals(codeType)){    //DEX = 11
                                            	String cod_check_type = "";
                                            	cod_check_type = ml.getCod_check_type()==null?null:ml.getCod_check_type().stringValue();
                                                
                                            	double amount=0;
                                               	amount = ml.getCod_collected_amount()!=null?Double.parseDouble(ml.getCod_collected_amount().stringValue()):0;
                                               	String currency = "";
                                               	currency = ml.getCod_collected_amt_currency_code()==null?null:ml.getCod_collected_amt_currency_code().stringValue();
                                                
                                                int decsDivider=(int) Math.pow(10,(double)("USD".equals(currency)?scansUsdDecs:scansLocalDecs));

                                                if(cod_check_type.equals("R") && amount>0){
                                                	
                                                    scanVO.setDetails("Cash Payment "+amount/decsDivider+" "+currency);
                                                    
                                                }else{
                                                    
                                                    if(cod_check_type.equals("S") && amount>0 ||cod_check_type.equals("U") && amount>0){
                                                    	scanVO.setDetails("Check Payment "+amount/decsDivider+" "+currency);

                                                    }else if(amount>0){
                                                    	scanVO.setDetails("Credit Card Payment "+amount/decsDivider+" "+currency);

                                                    }    
                                                }
                                                
                                                /*
                                                System.out.println("\n ml.getInt_duty_tax_amount() = "+ml.getInt_duty_tax_amount()+"\n"+
                                                		"ml.getInt_payment_amount() = "+ml.getInt_payment_amount()+"\n"+
                                                		"ml.getPayment_amount() = "+ml.getPayment_amount()+"\n"+
                                                		"ml.getCash_payment_amt() = "+ml.getCash_payment_amt()+"\n"+
                                                		"ml.getInt_payment_amount() = "+ml.getInt_payment_amount()+"\n"+
                                                		"ml.getCheck_payment_amt() = "+ml.getCheck_payment_amt()+"\n"+
                                                		"ml.getCredit_card_payment_amt() = "+ml.getCredit_card_payment_amt()+"\n"+
                                                		"ml.getCod_check_nbr() = "+ml.getCod_check_nbr()+"\n"+
                                                		"ml.getCod_check_type() = "+ml.getCod_check_type()+"\n"+
                                                		"ml.getCod_collected_amount() = "+ml.getCod_collected_amount()+"\n"+
                                                		"ml.getCod_collected_amt_currency_code() = "+ml.getCod_collected_amt_currency_code()+"\n"+
                                                		"ml.getCod_status() = "+ml.getCod_status()+"\n");
												*/

                                            }

                                        }else{
                                        	if("90".equals(trackType)){
                                                scanVO=new CosmosScansTableVO();
                                                scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                                scanVO.setLocationCd(trackLocationCd);

                                                String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                                String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                                scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                                scanVO.setScanType("COMM");
                                                scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);
                                                scanVO.setFontColor("#000000");	
                                        	}else{
                                                if("41".equals(trackType)){
                                                    scanVO=new CosmosScansTableVO();
                                                    scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                                    scanVO.setLocationCd(trackLocationCd);

                                                    String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                                    String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                                    scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                                    scanVO.setScanType("HAL");
                                                    scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);
                                                    scanVO.setFontColor("#000000");
                                        	    }
                                            }
                                        }
                                    }
                                }
                                if(scanVO!=null)colResults.add(scanVO);
                             }
                    }
            }catch(Exception e){
                Constants.logger.debug("Scan Processing Error: "+Utils.stackTraceToString(e));
                errors.add(new ScansProcessingError(awbNumber,"app.messages.UnknownError", null, "","",""));
            }
            return colResults;
    }
    
    
    

    /**
     * Obtain the scans from Cosmos for the FTC feature.
     * Returns a Collection with the scans.
     * 
     * @param     AWB Number
     * @param     location where the user is working
     */
    public Collection getFTCScans(String awbNumber,String locationCodePk) {//throws Exception{
        Collection colMasterList=null;
        Collection colResults=new ArrayList();

        try{
                    CosmosScanUtils csu=new CosmosScanUtils();
                    colMasterList=csu.getFTCScans(awbNumber,null,errors,null,null,true);

                    if(colMasterList!=null){
                        /*----------------Main process--------------------------*/
                        Iterator iterMasterList=colMasterList.iterator();
                        boolean touched=false;

                        while(iterMasterList.hasNext()){
                        	MasterList ml=(MasterList)iterMasterList.next();
                        	CosmosScansTableVO scanVO=null;
                            String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                            String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();
                            String trackLocationCd=ml.getTrack_location_code()==null?"Not Found":ml.getTrack_location_code().stringValue();

                            System.out.println("\n\nShowScans.java > trackType="+trackType + " | codeType=" + codeType + " | trackLocationCd = "+trackLocationCd);
                              
                            if("11".equals(trackType) || //VAN SCAN
                                ("30".equals(trackType) && !"16".equals(codeType)) ||//DEX !=16
                                ("31". equals(trackType) && !"16".equals(codeType)) //DDEX !=16
                                ){  
                                    scanVO=new CosmosScansTableVO();
                                    scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                    scanVO.setLocationCd(trackLocationCd);
 
                                    String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                    String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                    scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                    scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);
                                    if("11".equals(trackType)){
                                        scanVO.setScanType("VAN");  
                                        scanVO.setFontColor("#0000FF");                                        
                                    }else{
                                        if("31".equals(trackType)){
                                            scanVO.setScanType("DDEX"+codeType);  
                                            scanVO.setFontColor("#FF0000");
                                        }else{
                                        		scanVO.setScanType("DEX"+codeType);
                                        		scanVO.setFontColor("#FF0000");
                                        }    
                                    }

                                }else{
                                    if(("07".equals(trackType) && "44".equals(codeType)) || //STAT44
                                    	"02".equals(trackType)){ //SIP
                                        scanVO=new CosmosScansTableVO();
                                        scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                        scanVO.setLocationCd(trackLocationCd);

                                        String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                        String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                        scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                        
                                        if("02".equals(trackType)){
                                        	scanVO.setScanType("SIP");
                                        	scanVO.setFontColor("#FF00FF");
                                        }else{ 
                                        	scanVO.setScanType("STAT44");
                                        	scanVO.setFontColor("#FF9933");
                                        }
                                        scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);

                                    }else{
                                        if("20".equals(trackType) || //POD SCAN
                                        ("31".equals(trackType) && "16".equals(codeType)) //DDEX =16
                                        ){

                                            scanVO=new CosmosScansTableVO();
                                            scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                            scanVO.setLocationCd(trackLocationCd);

                                            String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                            String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                            scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                            
                                            if("20".equals(trackType)){
                                                scanVO.setScanType("POD");
                                                scanVO.setFontColor("#808000");
                                            }else{
                                                scanVO.setScanType("DDEX16");
                                                scanVO.setFontColor("#008000");
                                            }

                                            if("31".equals(trackType) && "16".equals(codeType)){    //DEX = 16
                                            	  double amount=ml.getInt_duty_tax_amount()!=null?Double.parseDouble(ml.getInt_duty_tax_amount().stringValue()):
                                                      ml.getInt_payment_amount()!=null?Double.parseDouble(ml.getInt_payment_amount().stringValue()):
                                                      ml.getPayment_amount()!=null?Double.parseDouble(ml.getPayment_amount().stringValue()):
                                                      ml.getCash_payment_amt()!=null?Double.parseDouble(ml.getCash_payment_amt().stringValue()):
                                                      ml.getCheck_payment_amt()!=null?Double.parseDouble(ml.getCheck_payment_amt().stringValue()):
                                                      ml.getCredit_card_payment_amt()!=null?Double.parseDouble(ml.getCredit_card_payment_amt().stringValue()):0;
                                                      
				                                         String currency=ml.getIso_currency_type()==null?null:ml.getIso_currency_type().stringValue();
				                                         int decsDivider=(int) Math.pow(10,(double)("USD".equals(currency)?scansUsdDecs:scansLocalDecs));
				
				
				                                         if(ml.getCash_payment_amt()!=null){
				                                             scanVO.setDetails("Cash Payment "+amount/decsDivider+" "+currency);
				                                         }else{
				                                             
				                                             if(ml.getCredit_card_payment_amt()!=null || ml.getCredit_card_nbr()!=null){
				                                             	scanVO.setDetails("Credit Card Payment "+amount/decsDivider+" "+currency);
				                                             }else{
				                                             	scanVO.setDetails("Check Payment "+amount/decsDivider+" "+currency);
				                                             }    
				                                         }
                                                
                                                /*
                                                System.out.println("\n ml.getInt_duty_tax_amount() = "+ml.getInt_duty_tax_amount()+"\n"+
                                                		"ml.getInt_payment_amount() = "+ml.getInt_payment_amount()+"\n"+
                                                		"ml.getPayment_amount() = "+ml.getPayment_amount()+"\n"+
                                                		"ml.getCash_payment_amt() = "+ml.getCash_payment_amt()+"\n"+
                                                		"ml.getInt_payment_amount() = "+ml.getInt_payment_amount()+"\n"+
                                                		"ml.getCheck_payment_amt() = "+ml.getCheck_payment_amt()+"\n"+
                                                		"ml.getCredit_card_payment_amt() = "+ml.getCredit_card_payment_amt()+"\n"+
                                                		"ml.getFtc_check_nbr() = "+ml.getFtc_check_nbr()+"\n"+
                                                		"ml.getFtc_check_type() = "+ml.getFtc_check_type()+"\n"+
                                                		"ml.getFtc_collected_amount() = "+ml.getFtc_collected_amount()+"\n"+
                                                		"ml.getFtc_collected_amt_currency_code() = "+ml.getFtc_collected_amt_currency_code()+"\n"+
                                                		"ml.getFtc_status() = "+ml.getFtc_status()+"\n");
												*/

                                            }

                                        }else{
                                        	if("90".equals(trackType)){
                                                scanVO=new CosmosScansTableVO();
                                                scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                                scanVO.setLocationCd(trackLocationCd);

                                                String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                                String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                                scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                                scanVO.setScanType("COMM");
                                                scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);
                                                scanVO.setFontColor("#000000");	
                                        	}else{
                                                if("41".equals(trackType)){
                                                    scanVO=new CosmosScansTableVO();
                                                    scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                                    scanVO.setLocationCd(trackLocationCd);

                                                    String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                                    String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                                    scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                                    scanVO.setScanType("HAL");
                                                    scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);
                                                    scanVO.setFontColor("#000000");
                                        	    }
                                            }
                                        }
                                    }
                                }
                                if(scanVO!=null)colResults.add(scanVO);
                             }
                    }
            }catch(Exception e){
                Constants.logger.debug("Scan Processing Error: "+Utils.stackTraceToString(e));
                errors.add(new ScansProcessingError(awbNumber,"app.messages.UnknownError", null, "","",""));
            }
            return colResults;
    }
    
    
    
    
    /**
     * Obtain the scans from Cosmos for the Prepaid feature.
     * Returns a Collection with the scans.
     * 
     * @param     AWB Number
     * @param     location where the user is working
     */  
    public Collection getPrepaidScans(String awbNumber,String locationCodePk) {//throws Exception{
        ShipmentProfile shiprof=null;
        Collection colMasterList=null;
        String tinUniqueId=null;
        Collection colResults=new ArrayList();
        int att=0;

        try{
                    CosmosScanUtils csu=new CosmosScanUtils();
                    colMasterList=csu.getPrepaidScans(awbNumber,null,errors,null,null,true);
                    
                    if(colMasterList!=null){
                        /*----------------Main process--------------------------*/
                        Iterator iterMasterList=colMasterList.iterator();
                        boolean touched=false;

                        while(iterMasterList.hasNext()){
                        	MasterList ml=(MasterList)iterMasterList.next();
                        	CosmosScansTableVO scanVO=null;
                            String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                            String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();
                            String trackLocationCd=ml.getTrack_location_code()==null?"Not Found":ml.getTrack_location_code().stringValue();

                                if("29".equals(trackType) && "16".equals(codeType)){ //pux16 
                                    scanVO=new CosmosScansTableVO();
                                    scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                    scanVO.setLocationCd(trackLocationCd);

                                    String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                    String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                    scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                    scanVO.setFontColor("#008000");
                                    scanVO.setScanType("PUX16");
                                    
                                    double amount=ml.getInt_duty_tax_amount()!=null?Double.parseDouble(ml.getInt_duty_tax_amount().stringValue()):
                                        ml.getInt_payment_amount()!=null?Double.parseDouble(ml.getInt_payment_amount().stringValue()):
                                        ml.getPayment_amount()!=null?Double.parseDouble(ml.getPayment_amount().stringValue()):
                                        ml.getCash_payment_amt()!=null?Double.parseDouble(ml.getCash_payment_amt().stringValue()):
                                        ml.getCheck_payment_amt()!=null?Double.parseDouble(ml.getCheck_payment_amt().stringValue()):
                                        ml.getCredit_card_payment_amt()!=null?Double.parseDouble(ml.getCredit_card_payment_amt().stringValue()):0;
                                        
                                    String currency=ml.getIso_currency_type()==null?null:ml.getIso_currency_type().stringValue();
                                    int decsDivider=(int) Math.pow(10,(double)("USD".equals(currency)?scansUsdDecs:scansLocalDecs));


		                           if(ml.getCash_payment_amt()!=null){
		                               scanVO.setDetails("Cash Payment "+amount/decsDivider+" "+currency);
		                           }else{
		                               
		                               if(ml.getCredit_card_payment_amt()!=null || ml.getCredit_card_nbr()!=null){
		                               	scanVO.setDetails("Credit Card Payment "+amount/decsDivider+" "+currency);
		                               }else{
		                               	scanVO.setDetails("Check Payment "+amount/decsDivider+" "+currency);
		                               }    
		                           }
                                    
                                }else{
                                    if("08".equals(trackType)){ //pup
                                        scanVO=new CosmosScansTableVO();
                                        scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                        scanVO.setLocationCd(trackLocationCd);

                                        String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                        String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                        scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                        scanVO.setFontColor("#00FF00");
                                        scanVO.setScanType("PUP");
                                        scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);
                                    }else{
                                        if("29".equals(trackType) && "23".equals(codeType)){//pux23
                                        	
                                            scanVO=new CosmosScansTableVO();
                                            scanVO.setFontColor("#0000FF");
                                            scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                            scanVO.setLocationCd(trackLocationCd);
                                            scanVO.setScanType("PUX23");
                                            String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                            String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                            scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                            scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);

                                        }else{
                                        	if("90".equals(trackType)){
                                                scanVO=new CosmosScansTableVO();
                                                scanVO.setEmployeeId(ml.getEmployee_number()==null?"Not Found":ml.getEmployee_number().stringValue());
                                                scanVO.setLocationCd(trackLocationCd);

                                                String datepart=ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                                                String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();

                                                scanVO.setScanDtTm(csu.parseDatesFromCosmos(datepart,timepart));
                                                scanVO.setScanType("COMM");
                                                scanVO.setDetails(ml.getComment()!=null?ml.getComment().stringValue():ml.getComments()!=null?ml.getComments().stringValue():null);
                                                scanVO.setFontColor("#000000");
                                             		
                                        	}
                                        }
                                    }
                                }
                                if(scanVO!=null)colResults.add(scanVO);
                            }
                    }
            }catch(Exception e){
                Constants.logger.debug("Scan Processing Error: "+Utils.stackTraceToString(e));
                errors.add(new ScansProcessingError(awbNumber,"app.messages.UnknownError", null, "","",""));
            }
            return colResults;
    }    

	/**
	 * @return Returns the errors.
	 */
	public Collection getErrors() {
		return errors;
	}
	/**
	 * @param errors The errors to set.
	 */
	public void setErrors(Collection errors) {
		this.errors = errors;
	}
}

