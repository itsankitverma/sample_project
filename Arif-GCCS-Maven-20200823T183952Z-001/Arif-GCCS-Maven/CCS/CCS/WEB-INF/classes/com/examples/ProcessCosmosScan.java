package com.examples;

/* new Import used for new cosmos ese.jar
 * jeena paul*/


import com.fedex.lacitd.cashcontrol.biztier.common.RecChangesFromScans;
import com.fedex.lacitd.cashcontrol.biztier.common.ScansProcessingError;
import com.fedex.lacitd.cashcontrol.prestier.helper.CosmosScanUtils;
import com.fedex.asn.IA5String.masterlist_.MasterList;


import javax.naming.InitialContext;
import javax.naming.Context;
import javax.sql.DataSource;
import java.util.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.CallableStatement;


/**
 * Created by IntelliJ IDEA.
 * User: arturog
 * Date: 25-07-2006
 * Time: 04:49:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProcessCosmosScan {

    public static void main(String[] a) throws Exception{

        Collection recAwbs = new ArrayList();
        RecChangesFromScans scanRecord=null;

        scanRecord=new RecChangesFromScans();
        //scanRecord.setRecAwbNumber("975964056424");
        scanRecord.setRecAwbNumber("864284280449");
        
        recAwbs.add(scanRecord);

         ArrayList awbsWithoutDDEX16=new ArrayList();
         awbsWithoutDDEX16.addAll(recAwbs);
         CosmosScanUtils rodsp  = new CosmosScanUtils();
         Collection awbsToROD    = new ArrayList();
         //ScoreCardDataProcessBizDelegate scBizDel = new ScoreCardDataProcessBizDelegate();
        ///// CODE TO TEST SCANS

            //Note from developer
            //Last two parameters set to 2 decimals, nomatter if country has decimals, this process in scorecard does not update amounts
            System.out.println("\n Starting processing scans for ROD...");
            System.out.println("\n Starting search for ROD AWB without DDEX16...");
            System.out.println("Number of elements in Collection Before run scans:" + (awbsWithoutDDEX16).size());

            Collection locations = new ArrayList();
            locations.add("TSAA");

            //Collection colsNotProcessedWithoutDDEX16 = rodsp.getPrepaidScans("849155222907",null,awbsToROD, null,null,true);
            Collection colsNotProcessedWithoutDDEX16 = rodsp.getRODScans("797002081914",null,awbsToROD, null,locations,true);


             Iterator it = awbsToROD.iterator();
            System.out.println("Number of elements after run the scans awbsToROD: " + awbsToROD.size());

            RecChangesFromScans recChanges;
            String scanType = null;

            //System.out.println("Number of elements in Collection:" + awbsToROD.size());
            System.out.println("ECQS URL:" + com.fedex.lacitd.cashcontrol.biztier.common.Constants.urlECQS);

            while (it.hasNext()) {
                recChanges  = (RecChangesFromScans) it.next();
                scanType    = recChanges.getRecLastScanType();

                System.out.println("\n getRecTinUniqueId : " + recChanges.getRecTinUniqueId());
                System.out.println("\n getRecLastScan : " + recChanges.getRecLastScan());
                System.out.println("\n getRecLastScanDate : " + recChanges.getRecLastScanDate());
                System.out.println("\n getRecLastScanType : " + recChanges.getRecLastScanType());
                System.out.println("\n getRecPaymentCurrency : " + recChanges.getRecPaymentCurrency());
                System.out.println("\n getRodAmt() : " + recChanges.getRodAmt());
                System.out.println("\n getAncChargeAmt() : " + recChanges.getAncChargeAmt());
                System.out.println("\n getRecCashPayment() : " + recChanges.getRecCashPayment());
            }

            System.out.println("\n Search for ROD AWB without DDEX16 finished OK...");
            //scBizDel.updateScansDDEX16(awbsToROD);
            System.out.println("Processing scans for ROD finished...");

           //processLastScans(recAwbs,null);//"BUEA");
    }

    public static void processLastScans(java.util.Collection colAWBs, String locationCodePk) {//throws Exception{
        Collection colNotProcessed=new ArrayList();
        Iterator iterAWBs=colAWBs.iterator();
        Collection colMasterList=null;
        Collection locations = new ArrayList();

        locations.add("TSAA");
        /*locations.add("YVRA");
        locations.add("MBJA");
        locations.add("BHZA");
        locations.add("YVRA");
        locations.add("SJOA");
        locations.add("SJOFR");
        locations.add("VLNA");
        locations.add("BDAA");
        */
        System.out.println("\n Before the while with colAWBs: " + colAWBs.toString());
        
        /*----Iterating on the AWBs. extLoop tag allows to continue
         * 	  in the most external loop----*/
        while(iterAWBs.hasNext()){
            colMasterList=null;
            RecChangesFromScans recChanges=null;

            try{
                recChanges=(RecChangesFromScans)iterAWBs.next();
                CosmosScanUtils csu=new CosmosScanUtils();
                colMasterList=csu.getRODScans(recChanges.getRecAwbNumber(),recChanges.getRecTinUniqueId(),colNotProcessed,null,locations,false);

                if(colMasterList!=null && !colMasterList.isEmpty()){
                    /*----------------Main process--------------------------*/
                    Iterator iterMasterList=colMasterList.iterator();
                    boolean touched=false;

                    while(iterMasterList.hasNext()){
                       MasterList ml=(MasterList)iterMasterList.next();

                       System.out.println("Sequence number: "+ml.getEvent_sequence_nbr());

                       // AWB_NBR
                       // Scan
                       // Date
                       // Time
                       // Location
                       // Employee
                       // SRC
                       // SVC
                       // Amount
                       // Currency
                       // Type
                   //    if(ml.getEvent_sequence_nbr()!=null){
                          String scan = ml.getScan_type_description()==null?null:ml.getScan_type_description().stringValue();
                          String scanDate = ml.getTrack_date()==null?null:ml.getTrack_date().stringValue();
                          String timepart=ml.getTrack_scan_time()==null?null:ml.getTrack_scan_time().stringValue();
                          String trackLocationCd=ml.getTrack_location_code()==null?null:ml.getTrack_location_code().stringValue();
                          String employee=ml.getEmployee_number()==null?null:ml.getEmployee_number().stringValue();
                          String src=ml.getSource_id()==null?null:ml.getSource_id().stringValue();
                          String svc=ml.getSvc_commit_timestamp()==null?null:ml.getSvc_commit_timestamp().stringValue();
                          String scanCurrency=ml.getIso_currency_type()==null?null:ml.getIso_currency_type().stringValue();                          
                          String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                          String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();

                          double scanAmount=ml.getInt_duty_tax_amount()!=null?Double.parseDouble(ml.getInt_duty_tax_amount().stringValue()):
                                            ml.getInt_payment_amount()!=null?Double.parseDouble(ml.getInt_payment_amount().stringValue()):
                                            ml.getPayment_amount()!=null?Double.parseDouble(ml.getPayment_amount().stringValue()):
                                            ml.getCash_payment_amt()!=null?Double.parseDouble(ml.getCash_payment_amt().stringValue()):
                                            ml.getCheck_payment_amt()!=null?Double.parseDouble(ml.getCheck_payment_amt().stringValue()):
                                            ml.getCredit_card_payment_amt()!=null?Double.parseDouble(ml.getCredit_card_payment_amt().stringValue()):0;

                          System.out.println("AWB: "+recChanges.getRecAwbNumber());
                          System.out.println("scan: "+scan);
                          System.out.println("scan date : "+scanDate);
                          System.out.println("scan time : "+timepart);
                          System.out.println("trackLocationCd: "+trackLocationCd);
                          System.out.println("employee: "+employee);
                          System.out.println("src: "+src);
                          System.out.println("svc: "+svc);
                          System.out.println("scan Amount: "+scanAmount);
                          System.out.println("scan currency: "+scanCurrency);
                          System.out.println("trackType: "+trackType);
                          System.out.println("codeType: "+codeType);

                    //   }
                    }
                }
            }catch(Exception e){
                System.out.println("Scan Processing Error: "+com.fedex.lacitd.cashcontrol.common.Utils.stackTraceToString(e));
                colNotProcessed.add(new ScansProcessingError(recChanges.getRecAwbNumber(),"app.messages.UnknownError", null, "","",""));
            }
        }
    }
}
