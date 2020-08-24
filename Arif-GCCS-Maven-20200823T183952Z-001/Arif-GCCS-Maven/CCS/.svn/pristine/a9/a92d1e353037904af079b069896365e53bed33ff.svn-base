/*
 * Created on Feb 26, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.examples;

import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.CosmosCCUtils;




public class Scans {
	public static void main(String[] a) throws Exception{
        String[] awbs=getAWBs();
        CosmosCCUtils ccu=new CosmosCCUtils();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<awbs.length;i++){
            CreditCardReportVO ccvo=new CreditCardReportVO();
            ccvo.setAwbNbr(awbs[i]);
            ccu.getPrepaidCCInfo(ccvo);
            sb.append(ccvo.getAwbNbr()+" - "+ccvo.getCreditCardNbr()+" - "+ccvo.getCreditCardExpDt()+"\n");
        }

        System.out.println(sb.toString());
	}
	
    private static String[] getAWBs(){
       return new String[]{"852892878332",
               "852173033904",
               "852173035171",
               "852173506503",
               "852890287213",
               "852892880170",
               "852173035150",
               "852173035160",
               "852892878170",
               "852892878148",
               "852173033959",
               "842347978636",
               "842347978647",
               "847191394308",
               "852168446424",
               "852168465761",
               "849588165760",
               "849588165737",
               "849588165770",
               "849588165781",
               "849588165440",
               "849588165428",
               "849588212221",
               "852168465783",
               "849588165439",
               "846572472989",
               "852882663046",
               "852882663116",
               "852168515200"
};


    }
}
