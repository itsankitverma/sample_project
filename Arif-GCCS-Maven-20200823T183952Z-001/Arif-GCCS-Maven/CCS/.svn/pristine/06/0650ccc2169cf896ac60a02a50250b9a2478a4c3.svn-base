package com.fedex.lacitd.cashcontrol.prestier.helper;
import java.util.*;
import java.net.URLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.*;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.common.monitoring.Monitoring;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.GlExchRateVO;
import com.fedex.lacitd.cashcontrol.datatier.controller.GlExchRateController;

/**
 * Created by IntelliJ IDEA.
 * User: ccardenas
 * Date: Jan 13, 2005
 * Time: 12:22:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReadExchRateExcelFile {

    private Properties prop=null;

    public  ReadExchRateExcelFile(){
        try{
            prop=Utils.getProperties("P");
        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            prop=new Properties();
        }
    }

    public  ReadExchRateExcelFile(Properties p){
            prop=p;
    }

   public void publishExchRates(String dt){
       Collection colER=readFile(dt);
       Iterator iterER=colER.iterator();
       GlExchRateController glCont=new GlExchRateController();
       while(iterER.hasNext()){
           GlExchRateVO erVO=(GlExchRateVO)iterER.next();
           try{
                glCont.setGlExchRate(erVO);
           }catch(Exception ex){
                Constants.logger.debug("GL Exch Rate already exist. "+erVO);
           }

       }
   }

   private Collection readFile(String dt){
       Collection colExchRates=new ArrayList();

       POIFSFileSystem fs = null;
       HSSFWorkbook wb = null;
       String exchRtDtStr=null;

       if(dt==null){
            exchRtDtStr=this.getDateOfRates(new Date());
       }else{
            exchRtDtStr=dt;
       }

       try {
            URL url = new URL(prop.get("psupload.exchRate.url")+"rates"+exchRtDtStr+".xls");
            URLConnection urlConn = url.openConnection();

            fs = new POIFSFileSystem(urlConn.getInputStream());
            wb = new HSSFWorkbook( fs );
       } catch ( java.io.IOException ex ) {
           Constants.logger.debug(Utils.stackTraceToString(ex));

       }

       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       Date exchRtDt=null;
       try{
            exchRtDt=sdf.parse(exchRtDtStr+"-01");
       }catch(Exception e){
            exchRtDt=new Date();
       }

       HSSFSheet sheet = wb.getSheetAt(0);
       int rowNum=Integer.parseInt((String)prop.get("psupload.exchRate.firstRow"));
       HSSFRow row=sheet.getRow(rowNum);

       while(row!=null && row.getCell(Short.parseShort((String) prop.get("psupload.exchRate.currencyCdColumn")))!=null){
           GlExchRateVO erVO=new GlExchRateVO();
           erVO.setCurrCd(row.getCell(Short.parseShort((String)prop.get("psupload.exchRate.currencyCdColumn"))).getStringCellValue());
           erVO.setAvgExchRtAmt(row.getCell(Short.parseShort((String)prop.get("psupload.exchRate.avgExchRateColumn"))).getNumericCellValue());
           erVO.setCurExchRtAmt(row.getCell(Short.parseShort((String)prop.get("psupload.exchRate.currentExchRateColumn"))).getNumericCellValue());
           erVO.setPerdDt(exchRtDt);

           colExchRates.add(erVO);
           rowNum++;
           row=sheet.getRow(rowNum);
       }


       return colExchRates;
   }

   private String getDateOfRates(Date dt){
        String year=new SimpleDateFormat("yyyy").format(dt);
        String month=new SimpleDateFormat("MM").format(dt);

        if("01".equals(month)){
            month="12";
            year=String.valueOf(Integer.parseInt(year)-1);
        }else{
            month=String.valueOf(Integer.parseInt(month)-1);
            month=(month.length()==1?"0"+month:month);
        }

        return year+"-"+month;
   }
}
