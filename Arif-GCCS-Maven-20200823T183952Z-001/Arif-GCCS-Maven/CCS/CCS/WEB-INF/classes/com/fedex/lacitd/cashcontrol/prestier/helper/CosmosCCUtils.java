/**
 * RODProcessLastScanRunnable.java
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
import java.net.*;
import java.io.*;


import java.text.*;
import com.oss.asn1.*;

/**
 * This class is in charge of getting the scans from Cosmos
 * @author  ccardenas
 */
public class CosmosCCUtils implements Serializable {
    /** Creates a new instance of CosmosScanUtils */
     public CosmosCCUtils() {
     }

    /**
     * It gets the ROD Credit Card information
     * @param ccrVO is the object with AWBs info
     * @return a CreditCardReportVO having CC information
     */
    public CreditCardReportVO getRODCCInfo(CreditCardReportVO ccrVO){
           Collection allScans=new CosmosScanUtils().getRODScans(ccrVO.getAwbNbr(),null,null,null,null,false);
           if(allScans==null) allScans=new ArrayList();
           Iterator iterAllScans=allScans.iterator();
           while(iterAllScans.hasNext()){
                 MasterList ml=(MasterList)iterAllScans.next();

                 String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                 String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();

                 if("31".equals(trackType) && "16".equals(codeType)){ //DDEX16
                       ccrVO.setCreditCardNbr(ml.getCredit_card_nbr()==null?"":ml.getCredit_card_nbr().stringValue());
                       ccrVO.setCreditCardExpDt(ml.getCredit_card_expr_date()==null?"":ml.getCredit_card_expr_date().stringValue());
                 }
           }
           return ccrVO;
    }

    /**
     * It gets the PREPAID Credit Card information
     * @param ccrVO is the object with AWBs info
     * @return a CreditCardReportVO having CC information
     */
    public CreditCardReportVO getPrepaidCCInfo(CreditCardReportVO ccrVO){
           Collection allScans=new CosmosScanUtils().getPrepaidScans(ccrVO.getAwbNbr(),null,null,null,null,false);
           if(allScans==null) allScans=new ArrayList();
           Iterator iterAllScans=allScans.iterator();
           while(iterAllScans.hasNext()){
                 MasterList ml=(MasterList)iterAllScans.next();

                 String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                 String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();

                 if("29".equals(trackType) && "16".equals(codeType)){ //PUX16
                       ccrVO.setCreditCardNbr(ml.getCredit_card_nbr()==null?"":ml.getCredit_card_nbr().stringValue());
                       ccrVO.setCreditCardExpDt(ml.getCredit_card_expr_date()==null?"":ml.getCredit_card_expr_date().stringValue());
                 }
           }
           return ccrVO;
    }
}

