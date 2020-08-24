/**
 * ProcessRIHFileRunnable.java
 *
 * Created on 13 de mayo de 2004, 16:02
 */

package com.examples;

/* new Import used for new cosmos ese.jar
 * jeena paul*/
import com.fedex.asn.IA5String.Ia5string;
import com.fedex.asn.IA5String.enhancedevent_.EnhancedEvent;
import com.fedex.asn.IA5String.masterlist_.MasterList;
import com.fedex.asn.IA5String.shipmentprofile_.ShipmentProfile;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.prestier.helper.CosmosScanUtils;
import com.oss.asn1.DecodeFailedException;
import com.oss.asn1.DecodeNotSupportedException;
import com.oss.asn1.Coder;
import java.io.*;
import java.util.*;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.HttpURLConnection;



/**
 *
 * @author  ccardenas
 */
public class BancoPrueba implements  java.io.Serializable {
	public static void main(String[] b) throws Exception{
        String[] aaa=getAWBS();
        StringBuffer sb=new StringBuffer();
        String destLoc=null;
        for(int i=0;i<aaa.length;i++){
             Collection colSP=new CosmosScanUtils().getRODScans(aaa[i],null,null,null,null,false);
             if(colSP!=null && !colSP.isEmpty()){
                 MasterList sp=((MasterList)colSP.toArray()[colSP.size()-1]);

                 destLoc=sp.hasTrack_location_code()?sp.getTrack_location_code().stringValue():"NOT FOUND";
                 if("NOT FOUND".equals(destLoc)){
                     colSP=getShipmentProfile(aaa[i]);
                     if(colSP!=null && !colSP.isEmpty()){
                         ShipmentProfile sp1=(ShipmentProfile) colSP.toArray()[0];
                         destLoc=sp1.hasDest_location_code()?sp1.getDest_location_code().stringValue():
                                 sp1.hasLast_known_location_cd()?sp1.getLast_known_location_cd().stringValue():"NOT FOUND";
                     }
                 }
                 sb.append(destLoc+": "+aaa[i]+"\n");
             }else{
                 colSP=getShipmentProfile(aaa[i]);
                 if(colSP!=null && !colSP.isEmpty()){
                     ShipmentProfile sp1=(ShipmentProfile) colSP.toArray()[0];
                     destLoc=sp1.hasDest_location_code()?sp1.getDest_location_code().stringValue():
                             sp1.hasLast_known_location_cd()?sp1.getLast_known_location_cd().stringValue():"NOT FOUND";
                     sb.append(destLoc+": "+aaa[i]+"\n");

                 }else{
                    sb.append("NOT FOUND: "+aaa[i]+"\n");
                 }
             }
        }
        System.out.println(sb.toString());

    }

    public static String[] getAWBS(){
        return new String[]{

            "461373801391",
            "494801267730",
            "611050411420",
            "612317124221",
            "612317124232",
            "616941437009",
            "617861107908",
            "617964479653",
            "618152568075",
            "618377898042",
            "618897160446",
            "618897160620",
            "618897161100",
            "625791793607",
            "626301179144",
            "628483058388",
            "632292600108",
            "632842142260",
            "633375351817",
            "633650717151",
            "635143192272",
            "641566779441",
            "641765968004",
            "650318187289",
            "652742909733",
            "655985592480",
            "655989378291",
            "655993736016",
            "655994167302",
            "655994180045",
            "655994184603",
            "655994209520",
            "655994234829",
            "655994253835",
            "655994625674",
            "655997009913",
            "655997032290",
            "655997034064",
            "655997034215",
            "655997034899",
            "658657117418",
            "662703800244",
            "671969611272",
            "673502904134",
            "674619169145",
            "675337589178",
            "686778732996",
            "688978721243",
            "690033458985",
            "690207850641",
            "690207850652",
            "690207850663",
            "690207850674",
            "692319469306",
            "693997505224",
            "695271317237",
            "696262010924",
            "697536826289",
            "697542962930",
            "699805958392",
            "699805960212",
            "699805961962",
            "699805962720",
            "699805962903",
            "699805963120",
            "699805965203",
            "699805979769",
            "699805979910",
            "699805980041",
            "699805980225",
            "699805980946",
            "699805982478",
            "699805985352",
            "699805985396",
            "699805985400",
            "699805985411",
            "699805985503",
            "699805985558",
            "699805985569",
            "699805985580",
            "699805986326",
            "699805986738",
            "699805987024",
            "699805987252",
            "699805987377",
            "699805987610",
            "699805988215",
            "699805988443",
            "699805988524",
            "699805988774",
            "699805989840",
            "699805989895",
            "699805989954",
            "699805990101",
            "702611452861",
            "705320563801",
            "707026961949",
            "711304151552",
            "718232705367",
            "790103574531",
            "790539473946",
            "790558365182",
            "790581472520",
            "791102408608",
            "791114202148",
            "791124617500",
            "791134715820",
            "791147175988",
            "791152239514",
            "791155120968",
            "791161687945",
            "791162274789",
            "829003037832",
            "830945789741",
            "831539144202",
            "836202484770",
            "836858739238",
            "838015264830",
            "838015264840",
            "838100692680",
            "843702507483",
            "843921148347",
            "844302439209",
            "844582727515",
            "844620824925",
            "845173333598",
            "848016803691",
            "848391254748",
            "848552582814",
            "848556821584",
            "848588365585",
            "849021478396",
            "849023775593",
            "849516650305",
            "849524812786",
            "849535444387",
            "849546917899",
            "849576402715",
            "849582814910",
            "849616365840",
            "850119743731",
            "850244575286",
            "850251152985",
            "850251808896",
            "850251808900",
            "850689320589",
            "850691720410",
            "850702985491",
            "850949603681",
            "850951576651",
            "850961766175",
            "850971684172",
            "851555866752",
            "851559544159",
            "852401823569",
            "852802079317",
            "852843121071",
            "852845465255",
            "852845745836",
            "852845843674",
            "852847396872",
            "852847817794",
            "852867631246",
            "852867739651",
            "853113958627",
            "853322681590",
            "853322681605",
            "898255037309",
            "791654458441",
            "791678693480",
            "791680838481",
            "791693097434",
            "792346077229",
            "792346300730",
            "792346332450",
            "792956387486",
            "792963838509",
            "792988908605"
};

    }

    /**
      * Get all the Shipment Profiles from eCQS for the AWB.
      * @param     the AWB number
      * @param     the location where the user is working
      * @return    the Shipment Profile.
      */
     private static Collection getShipmentProfile(String awbNumber)throws MalformedURLException,IOException,ProtocolException,DecodeFailedException,DecodeNotSupportedException{
         URL url=new URL(Constants.urlECQS);
         /*----Creating the params string----*/
         String params= Constants.qNameParamName+"="+Constants.qNameSummaryValue+"&"+Constants.tinParamName+"="+awbNumber;
         /*----Opening the connection and sending the paramters to the eCQS web server ----*/
         HttpURLConnection con = (HttpURLConnection)url.openConnection();
         con.setRequestMethod("POST");
         byte[] bytes = params.getBytes();
         con.setDoOutput(true);
         con.setDoInput(true);
         OutputStream out = con.getOutputStream();
         out.write(bytes);
         out.flush();


         con.connect();
         /*----Receiving and printing headers----*/
         int code = con.getResponseCode();
         String msg = con.getResponseMessage();
         //System.out.println("response-message " + code + " " + msg);
         for (int n=1;; ++n) {
             if (con.getHeaderFieldKey(n) == null) break;
             System.out.println(
             con.getHeaderFieldKey(n) + " " +
             con.getHeaderField(n));
         }
         /*----Creating the ASN.1 decoder----*/
         InputStream is = con.getInputStream();
         EnhancedEvent sink = new EnhancedEvent();
       //Coder coder = Enhancedevent.getDefaultCoder();
         Coder coder = Ia5string.getDefaultCoder();
         coder.disableDecoderConstraints();

         final int contentLength = con.getHeaderFieldInt("Content-Length",0);
         /*----Receiving the response----*/
         byte[] buffer = new byte[contentLength];
         int bytesCopied = 0;
         while (bytesCopied < contentLength) {
             int result = is.read(buffer, bytesCopied, contentLength-bytesCopied);
             System.out.println(result);
             if (result == -1) break;
             bytesCopied += result;
         }
         is.close();
         is = new ByteArrayInputStream(buffer);
         /*------Decoding the octec stram comming from eCQS-------*/
         Collection colEE=new ArrayList();
         while (is.available() > 0) {
             EnhancedEvent result = (EnhancedEvent)coder.decode(is,sink);
             colEE.add(result);
         }

         Collection colShipProf=new ArrayList();
         Iterator iterEE=colEE.iterator();
         while(iterEE.hasNext()){
               EnhancedEvent ee=(EnhancedEvent)iterEE.next();
                if(ee.hasShipment_profile()){
                     colShipProf.add(ee.getShipment_profile());
               }
         }
         return colShipProf;

     }
    
}