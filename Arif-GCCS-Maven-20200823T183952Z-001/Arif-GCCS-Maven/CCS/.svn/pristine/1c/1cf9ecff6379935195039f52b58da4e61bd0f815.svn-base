/*
 * InCageExceptionsRunnable.java
 *
 * Created on 20 de diciembre de 2002, 16:02
 */

package com.examples;

/* new Import used for new cosmos ese.jar
 * jeena paul*/
import com.fedex.asn.IA5String.masterlist_.MasterList;

import com.fedex.lacitd.cashcontrol.prestier.helper.CosmosScanUtils;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;





/**
 *
 * @author  ccardenas
 */
public class BancoPrueba_1 implements java.io.Serializable{

    public static void main (String[] args){
           Collection allScans=new CosmosScanUtils().getRODScans("844557525056",null,null,null,null,true);
           if(allScans==null) allScans=new ArrayList();
           Iterator iterAllScans=allScans.iterator();

           while(iterAllScans.hasNext()){
                 MasterList ml=(MasterList)iterAllScans.next();
                 System.out.println(ml.toString());
                 ml.getCredit_card_typ_code();

                 String trackType=ml.getTrack_type()==null?null:ml.getTrack_type().stringValue();
                 String codeType=ml.getTrack_exception_code()==null?null:ml.getTrack_exception_code().stringValue();

                 if("29".equals(trackType) && "16".equals(codeType)){ //DDEX16
                 }
           }


   }  

}