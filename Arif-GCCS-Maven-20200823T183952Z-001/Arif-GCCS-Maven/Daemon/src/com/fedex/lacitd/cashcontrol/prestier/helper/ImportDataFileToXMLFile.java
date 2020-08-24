/**
 * ImportDataFileToXMLFile.java
 *
 * Created on March 21, 2003, 4:43 PM
 * By Arturo Gonzalez
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

//import com.enterprisedt.net.ftp.FTPClient;
import com.fedex.lacitd.common.gccsftp.FTPClient;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.interfaces.clearance.ObjectFactory;
import com.fedex.lacitd.cashcontrol.interfaces.clearance.Receivable;
import com.fedex.lacitd.cashcontrol.interfaces.clearance.ReceivableList;

import javax.servlet.ServletContext;
import javax.xml.bind.*;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This class will create an ROD XML File
 * from a text file comming from DTRC
 * @author  Arturo Gonzalez
 */

public class ImportDataFileToXMLFile implements java.io.Serializable,java.lang.Runnable {

    private static Properties props     = new Properties();
    private static Properties dataProps = new Properties();
    private static ArrayList  orderTags = new ArrayList();
    private ServletContext servletCtx;
    private String dataFileDTRC         = null;
    private String[] files              = new String[0];
    /** Holds value of property thread. */
    private java.lang.Thread thread;

    /** Creates a new instance of ImportDataFileToXMLFile */
    public ImportDataFileToXMLFile() {
    }


    /** Creates a new instance of generaXML */
    public void run() {
        FTPClient clt = null;
          while(!"STOP_THREAD".equals(thread.getName())){
                getProperties();
          try{
              clt = new FTPClient(props.getProperty("dtrc.ftpServer"));
              clt.login(props.getProperty("dtrc.ftpUserName"),props.getProperty("dtrc.ftpPwd"));
              
              for(int idx=0;idx<files.length;idx++)
              {   if(files[idx].toLowerCase().indexOf(props.getProperty("dtrc.dataExtension"))!=-1){

                      dataFileDTRC = files[idx];
                      String XML = getXML(props, dataProps);
                      
                      if(XML==null){  
                    	  Constants.logger.debug("Cannot Process the Data File.\n") ;
                      }else{
                          sendRODFile(XML, props);
                          Constants.logger.debug(dataFileDTRC + " Process Completed Successfully.\n" ) ;
                       }
                      //Constants.logger.debug("\n XML : " + XML);
                      /*
                      if(XML==null)
                      {  Constants.logger.debug("Cannot Process the Data File.\n") ;
                      }else if(validateXML(XML)){
                              sendRODFile(XML, props);
                              Constants.logger.debug(dataFileDTRC + " Process Completed Successfully.\n" ) ;
                       }else{
                                Constants.logger.debug("Cannot send the XML file, maybe it is a no valid XML file.\n");
                        }
                        */
                  }
              }
            }catch(Exception e){
                 Constants.logger.debug(Utils.stackTraceToString(e));
                 try{
                    Thread.sleep(Constants.Process_DTRC_File_Task);
                 }catch(InterruptedException ie){}
            }

            files=new String[0];               

            try{
                clt.chdir(props.getProperty("dtrc.ftpDataImport.dir"));
                files=clt.dir();

                if(files.length==1 && files[0].toLowerCase().indexOf(".dat") == -1)
                   Constants.logger.debug("\n ImportDataFileToXMLFile: There are no files to process.");
                   
                Thread.sleep(Constants.Process_DTRC_File_Task);
            }catch(FTPException fte){
                    Constants.logger.debug("\n FTPException : " + fte.getMessage());
                    try{
                        Thread.sleep(Constants.Process_DTRC_File_Task);
                    }catch(InterruptedException ie){}
            }catch(Exception e){
                    Constants.logger.debug("\n Exception : " + e.getMessage());
                    try{
                        Thread.sleep(Constants.Process_DTRC_File_Task);
                    }catch(InterruptedException ie){}
            }
       }//Close while
    }//Close run method

     private void sendRODFile(String XML, Properties props){
        FTPClient clt = null;
        try {
            clt = new FTPClient(props.getProperty("dtrc.ftpServer") );
            clt.login(props.getProperty("dtrc.ftpUserName"),props.getProperty("dtrc.ftpPwd"));

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyMMdd");
            String prename        = sdf1.format(new Date());
            String newFile        =  props.getProperty("dtrc.xmlExport.dir") + "/" +dataFileDTRC + ".xml";

            clt.setType(FTPTransferType.BINARY);
            clt.put(XML.getBytes("UTF-8"),newFile);

            //Now move the file processed to the processed directory
            String oldFile         = props.getProperty("dtrc.ftpDataImport.dir") + "/" + dataFileDTRC;
            String processedFile   = props.getProperty("dtrc.processedDatDir") + "/" + dataFileDTRC;

            clt.rename(oldFile,processedFile);
            clt.quit();
        } catch(IOException e) {
            Constants.logger.debug("Error: sendFile() \n" + e.toString());
        } catch(FTPException eftp){
            Constants.logger.debug("Error: sendFile() \n" + eftp.toString());
        }
        return;
    }

   /**
    * Create the XML file from the dat File
    * and tags in the XML file from the Properties file.
    */
    private String getXML(Properties props, Properties dataProps)
    {
        ArrayList xmlElements = (ArrayList)getXMLElemetsFromDataFile(props, dataProps);
        //Constants.logger.debug("xmlElements \n" + xmlElements.toString());
        Set keys = null;
        Iterator it = null;
        HashMap elementos = new HashMap();
        if(xmlElements ==null)
           return null;
        String xmlString = getXMLString(xmlElements);
        return xmlString;
    }

    private void getProperties() {
          try {
          	props = Utils.getProperties("P");
          }catch (Exception e) {
                Constants.logger.debug("Error Exception in props.load() : " + e.getMessage());
          }

          try {
          	dataProps = Utils.getProperties("D");
          }catch (Exception e) {
          	Constants.logger.debug("Error Exception in props.load() : " + e.getMessage());
          }
    }

    /**
     * This method gets the data from the data file and build an HashMap object
     * @return HasMap
     */
    private  Collection getXMLElemetsFromDataFile(Properties props, Properties dataProps)
    {
        HashMap    dataElements  = null;
        ArrayList  allElements   = new ArrayList();

        int position = 0;
        int large    = 0;
        int decimal  = 0;
        int i        = 0;

        String element;
        String line             = null;
        BufferedReader bufInput = null;

        try{
            bufInput = receiveRODFile();

            if(bufInput==null)
               return null;
            //so it begins in the first line of the data file
            line = bufInput.readLine();
            //line = bufInput.readLine();
            //Loop over each record in the data file
            String countryCode      = "";
            String currencyCountry  = "";
            String advancedFee      = "";

            while (line != null) {
            //Constants.logger.debug("\n line : " + line);
                
            //First review if the type of record is a data record, i.e., it begins with 1
            //and if the data field "Cash in Advanced" has an 'R'
                String eleHashMap       = null;
                int posType  = Integer.parseInt(dataProps.getProperty("record.type.pos"));
                int posCash  = Integer.parseInt(dataProps.getProperty("record.cash.pos"));
                String type  = line.substring(posType,posType +1 );
                String cash  = line.substring(posCash,posCash +1 );

               //It gets the currency according to the country from the header of the property file
               if("0".equals(line.substring(0,1)))//Record type Header
               {    //Gets the countryCode from the Property object
                    element  = dataProps.getProperty("countryCode");
                    position = Integer.parseInt(dataProps.getProperty("ini_"+ element)) -1;
                    large    = Integer.parseInt(dataProps.getProperty("lar_"+ element));
                    countryCode     = line.substring(position, (position + large)).trim();
                    currencyCountry = props.getProperty("currency."+countryCode);
               }

               if(type.equals(dataProps.getProperty("record.type.data")) && cash.equals(dataProps.getProperty("record.cash.data")))
               {
                   dataElements  = new HashMap();
                //Process each line
                //To each record need to obtain the same elements and
                //put them into the data HashMap

                  //[location]
                    element  = dataProps.getProperty("location");
                    //Gets the location from the Property object
                    position = Integer.parseInt(dataProps.getProperty("ini_"+ element)) -1;
                    large    = Integer.parseInt(dataProps.getProperty("lar_"+ element));

                    if(position >0)
                       eleHashMap = props.getProperty("dtrc.location."+line.substring(position, (position + large)).trim());
                    else
                       eleHashMap =  "";

                    dataElements.put(element,eleHashMap);

                  //[mtn]
                    element  = dataProps.getProperty("mtn");
                    position = Integer.parseInt(dataProps.getProperty("ini_"+ element)) -1;
                    large    = Integer.parseInt(dataProps.getProperty("lar_"+ element));
                    if(position >0)
                       eleHashMap = line.substring(position, (position + large)).trim();
                    else
                        eleHashMap =  "";

                    dataElements.put(element,eleHashMap);

                  //[customer]
                    element  = dataProps.getProperty("customer");
                    position = Integer.parseInt(dataProps.getProperty("ini_"+ element)) -1;
                    large    = Integer.parseInt(dataProps.getProperty("lar_"+ element));
                    if(position >0)
                    {    eleHashMap = line.substring(position, (position + large)).trim();
                          //Replace the customer person by the contact as the customer is "" or empty
                          if(eleHashMap.equals("") || eleHashMap.length() == 0)
                            {   //[contact]
                                   String contact  = dataProps.getProperty("contact");
                                   position = Integer.parseInt(dataProps.getProperty("ini_"+ contact)) -1;
                                   large    = Integer.parseInt(dataProps.getProperty("lar_"+ contact));
                                   eleHashMap = line.substring(position, (position + large)).trim();
                            }
                    }else
                        eleHashMap =  "";

                    dataElements.put(element,eleHashMap);

                  //[recDate]
                    element  = dataProps.getProperty("recDate");
                    position = Integer.parseInt(dataProps.getProperty("ini_"+ element)) -1;
                    large    = Integer.parseInt(dataProps.getProperty("lar_"+ element));
                    if(position >0)
                       eleHashMap = line.substring(position, (position + large)).trim();
                    else
                        eleHashMap =  "";

                    //this code gives format to the date with yyyy-mm-dd format
                      eleHashMap = formatXMLDate(eleHashMap);
                      dataElements.put(element,eleHashMap);

                  //[recNumber]
                    element  = dataProps.getProperty("recNumber");
                    position = Integer.parseInt(dataProps.getProperty("ini_"+ element)) -1;
                    large    = Integer.parseInt(dataProps.getProperty("lar_"+ element));
                    if(position >0)
                       eleHashMap = line.substring(position, (position + large)).trim();
                    else
                        eleHashMap =  "";

                    dataElements.put(element,eleHashMap);

                  //[recCurrency]
                    element  = dataProps.getProperty("recCurrency");
                    position = Integer.parseInt(dataProps.getProperty("ini_"+ element)) -1;
                    large    = Integer.parseInt(dataProps.getProperty("lar_"+ element));
                    if(position >0)
                       eleHashMap = line.substring(position, (position + large)).trim();
                    else
                        eleHashMap =  "0";

                    //if the currencyCountry has a valid value then the application use that value
                    if(currencyCountry.length() != 0)
                       eleHashMap = currencyCountry;

                    dataElements.put(element,eleHashMap);

                  //[exchRate]
                    element  = dataProps.getProperty("exchRate");
                    position = Integer.parseInt(dataProps.getProperty("ini_"+ element)) -1;
                    large    = Integer.parseInt(dataProps.getProperty("lar_"+ element));
                    if(position >0)
                       eleHashMap = line.substring(position, (position + large)).trim();
                    else
                        eleHashMap =  "1";

                    dataElements.put(element,eleHashMap);

                  //It gets the advanced fee from the property file according to the countryCode
                    advancedFee = props.getProperty("advancedFee." + countryCode);

                  //[recAmount]
                    element  = dataProps.getProperty("recAmount");
                    position = Integer.parseInt(dataProps.getProperty("ini_"+ element)) -1;
                    large    = Integer.parseInt(dataProps.getProperty("lar_"+ element));
                    decimal  = Integer.parseInt(dataProps.getProperty("dec_"+ element));
                    if(position >0)
                       eleHashMap = line.substring(position, (position + large)).trim();
                    else
                        eleHashMap =  "0";

                    //Put the decimals to the recAmount number
                      eleHashMap = formatXMLNumberDecimal(eleHashMap, decimal);

                    if(advancedFee.length()>0)
                       eleHashMap = String.valueOf(Double.parseDouble(eleHashMap) + Double.parseDouble(advancedFee));

                    dataElements.put(element,eleHashMap);

                  //[rodAmount]
                    element  = dataProps.getProperty("rodAmount");
                    position = Integer.parseInt(dataProps.getProperty("ini_"+ element)) -1;
                    large    = Integer.parseInt(dataProps.getProperty("lar_"+ element));
                    decimal  = Integer.parseInt(dataProps.getProperty("dec_"+ element));
                    if(position >0)
                       eleHashMap = line.substring(position, (position + large)).trim();
                    else
                        eleHashMap =  "0";

                    //Put the decimals to the rodAmount number
                    eleHashMap = formatXMLNumberDecimal(eleHashMap, decimal);
                    dataElements.put(element,eleHashMap);

                  //[anchargeAmount]
                    element  = dataProps.getProperty("anchargeAmount");
                    
                    position = Integer.parseInt(dataProps.getProperty("ini_"+ element)) -1;
                    large    = Integer.parseInt(dataProps.getProperty("lar_"+ element));
                    if(position >0)
                    {  eleHashMap = line.substring(position, (position + large)).trim();
                    }else
                        eleHashMap =  "0";
                    //Put teh advanced fee when exist, in the property file, a valid value for a specific country
                    if(advancedFee.length()>0)
                       eleHashMap =   advancedFee ;

                    dataElements.put(element,eleHashMap);

                    //Put an entire record in the output HashMap
                      allElements.add(dataElements);
            }//Close if
                    //gets a new line
                    line = bufInput.readLine();
                    i++;
        }//Close while

            bufInput.close();
        }catch(NullPointerException npe)
         {Constants.logger.debug("\n Cannot open the file: " + npe.getMessage());
        }catch(IOException ioe)
         {Constants.logger.debug("\n Problem for in/out exception");
        }catch(Exception e){
            Constants.logger.debug("\n Unknown exception: " + e.getMessage());
            Constants.logger.debug(Utils.stackTraceToString(e));
        }

        return allElements;
    }


    private static boolean validateXML(String xml){
         try{
            if(xml == null || xml.equals(""))
               return false;

            JAXBContext jc = JAXBContext.newInstance( "com.fedex.lacitd.cashcontrol.interfaces.clearance"); //this is a workaround because of one bug in beta of jaxb.
            Unmarshaller um = jc.createUnmarshaller();
            um.setValidating(true);

            ReceivableList rl = (ReceivableList)um.unmarshal(new ByteArrayInputStream(xml.getBytes("UTF-8")));
            return true;
         }catch( UnmarshalException je ) {
            Constants.logger.debug("\n UnmarshalException : " + je.getMessage());
            return false;
         }catch( JAXBException je ) {
            Constants.logger.debug("\n JAXBException : " + je.getMessage());
            return false;
         }catch(Exception je){
            Constants.logger.debug("\n Exception : " + je.getMessage());
            return false;
         }
   }

   public String getPropsAsString(){
       getProperties();
       String sProps="";

        TreeSet propsSet=new TreeSet(new Comparator(){
                            public int compare(Object obj1, Object obj2) {
                                try{
                                    Map.Entry lvo1=(Map.Entry)obj1;
                                    Map.Entry lvo2=(Map.Entry)obj2;

                                    return ((String)lvo1.getKey()).toLowerCase().compareTo( ((String)lvo2.getKey()).toLowerCase() );

                                }catch(Exception pe){
                                    return -1;
                                }
                            }
                            });

        propsSet.addAll(props.entrySet());

       Iterator propIt = propsSet.iterator();

       while ( propIt.hasNext() ) {
            Map.Entry  propMap =  (Map.Entry)propIt.next();
            sProps = sProps + propMap.getKey() + " = " + propMap.getValue() + " \n";
       }
       return sProps;
   }

 public static String getXMLString(ArrayList xmlElements)
 {
      String  xmlInString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><receivableList>";

      for(int i=0;i<xmlElements.size();i++){
    	  HashMap elements = (HashMap)xmlElements.get(i);
    	  xmlInString=xmlInString+"<receivable>";
    	  xmlInString=xmlInString+"<location>"+(String)elements.get("location")+"</location>";
    	  xmlInString=xmlInString+"<mtn>"+(String)elements.get("mtn")+"</mtn>";
    	  xmlInString=xmlInString+"<customer>"+(String)elements.get("customer")+"</customer>";
    	  
    	  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          Date date = new Date();
          
    	  xmlInString=xmlInString+"<recDate>"+dateFormat.format(date)+"</recDate>";
    	  xmlInString=xmlInString+"<recNumber>"+(String)elements.get("recNumber")+"</recNumber>";
    	  xmlInString=xmlInString+"<recCurrency>"+(String)elements.get("recCurrency")+"</recCurrency>";
    	  xmlInString=xmlInString+"<exchRate>"+new java.math.BigDecimal((String)elements.get("exchRate"))+"</exchRate>";
    	  xmlInString=xmlInString+"<recAmount>"+new java.math.BigDecimal((String)elements.get("recAmount"))+"</recAmount>";
    	  xmlInString=xmlInString+"<rodAmount>"+new java.math.BigDecimal((String)elements.get("rodAmount"))+"</rodAmount>";
    	  xmlInString=xmlInString+"<anchargeAmount>"+new java.math.BigDecimal((String)elements.get("anchargeAmount"))+"</anchargeAmount>";
    	  xmlInString=xmlInString+"</receivable>";
      }//end for
      
      xmlInString = xmlInString+"</receivableList>";
      /*
      try{
       // create a JAXBContext
          JAXBContext jc = JAXBContext.newInstance("com.fedex.lacitd.cashcontrol.interfaces.clearance");

         // create an empty ListReceivable
            ObjectFactory of=new ObjectFactory();
            ReceivableList rl = of.createReceivableList();

        List lisReceivable = null;

        for(int i=0;i<xmlElements.size();i++)
        {    // Insert child Main
                String valueElement;
                Receivable receivable = of.createReceivable();
                //Set the attribute num to the receivable
                  receivable.setNum(i+1);

                  HashMap elements = (HashMap)xmlElements.get(i);

                  receivable.setLocation((String)elements.get("location"));
                  receivable.setMtn((String)elements.get("mtn"));
                  receivable.setCustomer((String)elements.get("customer"));

                  valueElement = (String)elements.get("recDate");
                  SimpleDateFormat fmter2=new SimpleDateFormat("yyyy-MM-dd");
                  Date dateAfterParser   = fmter2.parse(valueElement);
                  GregorianCalendar gC   = new GregorianCalendar();
                  gC.setTime(dateAfterParser);
                  receivable.setRecDate(gC);
                  receivable.setRecNumber((String)elements.get("recNumber"));
                  receivable.setRecCurrency((String)elements.get("recCurrency"));
                  valueElement = (String)elements.get("exchRate");
                  receivable.setExchRate(new java.math.BigDecimal(valueElement));
                  valueElement = (String)elements.get("recAmount");
                  receivable.setRecAmount(new java.math.BigDecimal(valueElement));
                  valueElement = (String)elements.get("rodAmount");
                  receivable.setRodAmount(new java.math.BigDecimal(valueElement));
                  valueElement = (String)elements.get("anchargeAmount");
                  receivable.setAnchargeAmount(new java.math.BigDecimal(valueElement));
                  lisReceivable = rl.getReceivable();
                  lisReceivable.add(receivable);
        }

           // create a Marshaller and marshal to System.out
               Marshaller m = jc.createMarshaller();
               m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );

               StringWriter str = new StringWriter();
               m.marshal(rl, str);
               xmlInString      = new String(str.getBuffer());

        }catch( JAXBException je ) {
                Constants.logger.debug("\n JAXBException : " + je.getMessage());
        }catch(ParseException pe){
               Constants.logger.debug("\n Date parser : " + pe.getMessage());
          }
          
          */
      return xmlInString;
   }


   /**
    * Give the XML format to a Date String to put it into a XML File.
    * @param String Date with a wrong format
    * @return String Date with the right format
    */
    public static String formatXMLDate(String dateToChange)
    {
         SimpleDateFormat fmter1=new SimpleDateFormat("yyMMdd");
         SimpleDateFormat fmter2=new SimpleDateFormat("yyyy-MM-dd");
         String newDate = null;

         try{
             fmter1.setLenient(false);
             fmter2.setLenient(false);
             Date dateAfterParser = fmter1.parse(dateToChange);
             newDate = fmter2.format(dateAfterParser);
         }catch(ParseException pe)
          {     Constants.logger.debug("\n Date parser : " + pe.getMessage());
                return dateToChange;}
      return newDate;
    }

   /**
    * This method gives the right format to a number with decimals
    */
    public static String formatXMLNumberDecimal(String number, int numDecimal)
    {
        if (number==null || number.equals("0"))
            return number;

        double numberOut=Double.parseDouble(number)/(Math.pow(10,numDecimal));

        return String.valueOf(numberOut);
    }


    private BufferedReader receiveRODFile(){
        String pathToReturn = null;
        String localPath    = null;
        BufferedReader br   = null;
        FTPClient clt       = null;
        String processedDir=null;
        String newFile=null;
        String[] files=null;
        try{
            clt = new FTPClient(props.getProperty("dtrc.ftpServer") );
            clt.login(props.getProperty("dtrc.ftpUserName"),props.getProperty("dtrc.ftpPwd"));

            String pwd = clt.pwd().substring( 1);

            processedDir    = props.getProperty("dtrc.processedDatDir");
            newFile         = dataFileDTRC;

            clt.chdir(processedDir);
            try{
               files=clt.dir();
            }catch(Exception e){
            }

            if(files!=null && checkDataFileExists(files, dataFileDTRC))
            {
               Constants.logger.debug("\n File already exits : " + dataFileDTRC);
               return br;
            }

            //clt.chdir("~");//come back to the root
            clt.chdir( pwd);//come back to the root

            clt.setType(FTPTransferType.BINARY);
            br=new BufferedReader(new StringReader(new String(clt.get(props.getProperty("dtrc.ftpDataImport.dir") +"/"+ newFile))));
            clt.quit();
        } catch(IOException e) {
            //Constants.logger.debug("\n Error IO: receiveRODFile() " + e.getMessage()+" | "+processedDir+" | "+dataFileDTRC+" | "+newFile);
            Constants.logger.debug(Utils.stackTraceToString(e));
        } catch(FTPException eftp){
            //Constants.logger.debug("\n Error IO: receiveRODFile() " + eftp.getMessage()+" | "+processedDir+" | "+dataFileDTRC+" | "+newFile);
            Constants.logger.debug(Utils.stackTraceToString(eftp));
        }
      return br;
    }

    /** Getter for property prop.
     * @return Value of property prop.
     */
    public ServletContext getServletCtx() {
        return this.servletCtx;
    }

    /** Setter for property prop.
     * @param prop New value of property prop.
     */
    public void setServletCtx(ServletContext servletCtx) {
        this.servletCtx = servletCtx;
    }

    public Thread getThread() {
        return this.thread;
    }

    public void setThread(Thread thread) {
        this.thread=thread;
    }

   /**
    * This method check if a file name exist into a Names Files Array
    * @param Array String files
    * @param String currentFile
    * return boolean exist
    */
    private static boolean checkDataFileExists(String[] files, String currentFile)
    {
        boolean exist = false;

        for(int i=0;i<files.length;i++)
        {   if(files[i].equals(currentFile))
               exist = true;
        }
        return exist;
    }

}
