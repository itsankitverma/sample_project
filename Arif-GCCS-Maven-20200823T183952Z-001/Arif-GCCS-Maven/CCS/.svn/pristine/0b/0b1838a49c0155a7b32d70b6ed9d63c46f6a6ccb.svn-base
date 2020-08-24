 /**
 * ProcessVISAFileRunnable.java
 * 
 * Created on 20 de diciembre de 2002, 16:02
 */

package com.examples;

import java.text.SimpleDateFormat;
import java.util.*;
import  java.io.*;

import javax.servlet.ServletContext;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.PrepaidVISAFileVO;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.PrepPoaBizDelegate;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.prestier.helper.PrepNotCheckedScanProc;

 /**
 *
 * @author  ccardenas
 */
public class ProcessVISAFileUtil{
    private String[] files=new String[0];    
    
    /** Holds value of property prop. */
    private ServletContext servletCtx;
    
    /** Holds value of property thread. */
    private java.lang.Thread thread;
    
    /** Creates a new instance of InCageExceptionsRunnable */
    public ProcessVISAFileUtil() {
    }
    
    public static void main(String[] a) throws Exception{

        Constants.logger.debug(".-----");
        
        BufferedReader br=new BufferedReader(new InputStreamReader(

                new FileInputStream("C:\\Sistemas\\work\\CashControl\\Desarrollo\\Deployment\\Realease 4.1.3INFOSEC\\visa3.txt")

        ));
        String buf=null;
        ArrayList col=col=new ArrayList();
        	int line=1;
        	
       //      while((buf=br.readLine())!=null){
                 //col.add(buf);
       //          System.out.println("\n linea " + line + " : \n " + buf);
                 
       //          line++;
       //     }
        col = (ArrayList) parseString(br);
        PrepaidVISAFileVO pre = null;
        
        Collection results=new ArrayList();
        PrepNotCheckedScanProc procScan=new PrepNotCheckedScanProc();
        procScan.processLastScans(col,results);

        for(int i=0;i<col.size();i++){
            pre = (PrepaidVISAFileVO)col.get(i);

            System.out.println("\n linea " + i + "  => " + pre.getAwbNbr() + " - " + pre.getOrigLocation());
            System.out.println("\n linea " + i + "  => " + pre.getAwbNbr() + " - " + pre.getLocationCd());
            System.out.println("\n linea " + i + "  => " + pre.getLastScanDate() + " - " + pre.getLastScanType());
        }
             
    }
    
    static Collection parseString(BufferedReader br){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Collection result=new ArrayList();
        String buf;
        try{
            while((buf=br.readLine())!=null){
                try{
                    if("X".equalsIgnoreCase(buf.substring(71,72).trim())){
                        PrepaidVISAFileVO pvf=new PrepaidVISAFileVO();
                        pvf.setAwbNbr(buf.substring(0,12).trim());
                        pvf.setOrigLocation(buf.substring(13,18).trim());
                        pvf.setOrigCountry(buf.substring(43,45).trim());
                        pvf.setShipDate(sdf.parse(buf.substring(34,42).trim()));
                        try{
                            pvf.setProduct(Integer.parseInt(buf.substring(51,53).trim()));
                        }catch(Exception e){
                            pvf.setProduct(0);
                        }                        
                        pvf.setNumberPkgs(Integer.parseInt(buf.substring(54,62).trim()));
                        pvf.setWeight(Double.parseDouble(buf.substring(63,70).trim()));
                        result.add(pvf);            
                    }    
                }catch(Exception e){
                    Constants.logger.debug("Error parsing VISA File:\n"+Utils.stackTraceToString(e));
                }     
            }
        }catch(Exception e){
            Constants.logger.debug("Fatal Error parsing VISA File:\n"+Utils.stackTraceToString(e));            
        }    
        
        return result;
    }  
        
/*
             Collections.sort(col,new Comparator(){
                                public int compare(Object a,Object b){
                                    String s1=(String)a;
                                    String s2=(String)b;

                                    return s1.substring(13,18).trim().compareTo(s2.substring(13,18).trim());

                                }
                               });

            
System.out.println(col.size());        
            FileWriter fw=new FileWriter("c:\\VISADTL2.txt");            
            Iterator i=col.iterator();
            while (i.hasNext()){
                fw.write((String) i.next() + "\n");
            }
            fw.flush();
            fw.close();
*/

}     