package com.fedex.lacitd.cashcontrol.prestier.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;


import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;


import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPPart;



import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import weblogic.webservice.core.soap.SOAPBodyImpl;

import com.bea.xbean.inst2xsd.util.Element;
import com.bea.xml.XmlObject;
import com.bea.xml.XmlOptions;


import com.fedex.xmlns.enterpriseCustomer.AccountIdForInquiry;
import com.fedex.xmlns.enterpriseCustomer.AccountInquiryDocument;
import com.fedex.xmlns.enterpriseCustomer.AccountInquiryResponseDocument;
import com.fedex.xmlns.enterpriseCustomer.AccountRequestInquiryDocument;
import com.fedex.xmlns.enterpriseCustomer.AccountRequestInquiryResponseDocument;
import com.fedex.xmlns.enterpriseCustomer.DataSource;
import com.fedex.xmlns.enterpriseCustomer.ErrorDescriptor;
import com.fedex.xmlns.enterpriseCustomer.OpcoCode;
import com.fedex.xmlns.enterpriseCustomer.ReplyHeader;
import com.fedex.xmlns.enterpriseCustomer.SearchWindow;
import com.fedex.xmlns.enterpriseCustomer.AccountInquiryDocument.AccountInquiry;

import com.fedex.xmlns.enterpriseCustomer.AccountRequestInquiryDocument.AccountRequestInquiry;

import com.fedex.xmlns.enterpriseCustomer.AccountId;

import com.fedex.xmlns.enterpriseCustomer.AccountIdForInquiry;


import com.fedex.xmlns.enterpriseCustomer.AccountInquiryDocument.AccountInquiry.ResultOptions;

import com.fedex.xmlns.enterpriseCustomer.AccountInquiryResponseDocument.AccountInquiryResponse;

import com.fedex.xmlns.enterpriseCustomer.AccountRequestInquiryResponseDocument.AccountRequestInquiryResponse;

public class CiamWebService2 {
	
	/*public boolean getResponseNew(String BillToAcct) throws Exception{
		
		try{
		String request = Constants.CI_SOAP_XML;
		request = request.replaceAll("user_Tocken", getToken());
		request = request.replaceAll("input_Account_Number", accountnumber);
		System.out.println("Before Ci Response");
		Source source = ciClient.ciResponse(request);
		Document doc = ApplicationUtils.toDocument(source);
		
		Document ciDocument = transform.applyTransformation(doc,"ClientDO");
		String response = ApplicationUtils.convertDocumentToString(ciDocument);	
		System.out.println("CI response is---"+response);	
		}
		catch(Exception e){
			System.out.println("Exception is"+e.getMessage());
			
		}
    }  */
	public boolean getResponse(String BillToAcct) throws Exception
    {					    
		    
		    System.out.println("Calling getResponse! ");	  		    		    
		    		  		    
		    String messageBody = null;
		    boolean isSubmittedSuccessfully = false;
		    boolean returnValue = true;	    
		    File file = null;  
            String inputFileName = null;
            String requestMethod = null;
            String responseMethod = null;
            String namespace = null;
            String cfamWSDL = null;
            Properties prop=null;		
            String empId = null;
            String empOpCo = null;
            String srcSystem = null;
            XmlObject outputResponse = null;
            XmlOptions options = new XmlOptions();                                                                    
            requestMethod = "accountInquiry";    
            responseMethod = "accountInquiryResponse";
            
            empId = "GCCSFusionUser";
            //empOpCo = "FDSV";
            empOpCo = "FX";
            //srcSystem = "CFAM";
            srcSystem = "CustomerAccountService";
            
            prop= Utils.getProperties("P");
            
            namespace = prop.getProperty("ciam.namespace");
            //namespace = "http://xmlns.fedex.com/EnterpriseCustomer";
            System.out.println("ciam.namespace from database=="+namespace);
            
            cfamWSDL = prop.getProperty("ciam.url");
            //cfamWSDL = "https://fajaxdevtest.idev.fedex.com/cfcore/EnterpriseService?WSDL";               
            System.out.println("ciam.url from database=="+cfamWSDL);
		    try
		    {

			    //messageBody = createNewXml(BillToAcct);	
			    messageBody = createLatestXml(BillToAcct);
			    
			    System.out.println("messageBody=="+messageBody);
				XmlObject xmlObject = getXmlObject(messageBody);
				System.out.println("xmlObject of string=="+xmlObject);
												
				//SOAPElement headerElement = createSOAPHeaderElement(empId, empOpCo, srcSystem, namespace);
				String headerElement = createSOAPHeaderElement(empId, empOpCo, srcSystem, namespace);
				//System.out.println("headerElement==="+headerElement);
				
				String TextBody = constructSOAPBody(xmlObject,headerElement);
				
				System.out.println("Entire Soap Message==jun 28 2018=="+TextBody);
				
				SOAPMessage request = convertXmlObject2SOAPMsg(XmlObject.Factory.parse(TextBody));
						
	            printsoapMessage(request);
	           	           
				SOAPMessage response = submitRequest(request, cfamWSDL);
				System.out.println("Response=="+response);

	            if (response != null){
					isSubmittedSuccessfully = true;				
			    }		
				
				if (isSubmittedSuccessfully){	
					//getResponseForClient(response);		
					/*Document docs = getResponseForClient(response);		
					System.out.println("docs Doc"+ docs);	
					NodeList nodes = docs.getElementsByTagName("customer:statusCode");
					System.out.println("nodes length =="+ nodes.getLength());						       		
					for (int i = 0; i < nodes.getLength(); i++) {
					       Element element = (Element) nodes.item(i);
					       System.out.println("element nameee"+(Element) nodes.item(i));
					}*/

					
					String strd = getResponseForClient(response);	
					System.out.println("strd String jul-10-2018== "+strd);
					
					//System.out.println("VALUEEEEEEEE"+Arrays.toString(getTagValues(strd).toArray())); 
					String strValue=Arrays.toString(getTagValues(strd).toArray());
					System.out.println("str VALUEEE123 NOW="+strValue);
					
					if (!strValue.contains("A")){ //active , archive
						return false;
					}										
										
					/*AccountInquiryResponseDocument accountInquiryResponseDocument = (AccountInquiryResponseDocument) XmlObject.Factory.parse(strd);
														    
				    AccountInquiryResponse accountInquiryResponse = accountInquiryResponseDocument.getAccountInquiryResponse();
				    
				    System.out.println("OUTPUT : \n " + accountInquiryResponse.xmlText( options));
				    
				    ReplyHeader replyHeader = accountInquiryResponse.getHeader(); 
				    
				    //ReplyHeader replyHeader = accountRequestInquiryResponse.getHeader();
				    if (replyHeader.sizeOfErrorStatusArray()>0)
		            {
		                System.out.println("something went wrong..");
		            	System.out.println("Size of error array is <" + replyHeader.sizeOfErrorStatusArray() + ">");

		    	        // something went wrong ....    	        
			        	for(int i = 0;
			        	     i < replyHeader.sizeOfErrorStatusArray();
			        	     i++)
			        	{
			        		ErrorDescriptor ed = replyHeader.getErrorStatusArray( i);
			        		
			        		System.out.println("ed.getCode() " + ed.getCode());
			        		System.out.println("ed.getDescription() " + ed.getDescription());
			        	}
			        	
			        	return false;
		            }  */ 
									
			    }
				else {
					System.out.println("no response!!");
				}
		    }	
			catch(Exception ex){
					System.out.println(" Exception");
					ex.printStackTrace();
					throw ex;
			}
			return isSubmittedSuccessfully;
			
    }
	
	private static List<String> getTagValues(final String str) {
	    final List<String> tagValues = new ArrayList<String>();
	    final Matcher matcher = TAG_REGEX.matcher(str);
	    while (matcher.find()) {
	        tagValues.add(matcher.group(1));
	    }
	    return tagValues;
	}
	
	private static final Pattern TAG_REGEX = Pattern.compile("<customer:statusCode>(.+?)</customer:statusCode>");
	
	public static String createLatestXml(String billToAcctnumber){
		 
		 try{
		    System.out.println("in createLatestNew - NEW-2018");		
		    String request="<customer:accountInquiryRequest minorVersion=\"1\" majorVersion=\"0\" xmlns:customer=\"http://xmlns.fedex.com/customer\">"+
			"<customer:accountNumber>" + billToAcctnumber +  "</customer:accountNumber>"+
			"<customer:resultOptions>"+
			"<customer:contacts>"+
			"<customer:opco>FX</customer:opco>"+
			"<customer:contactTypeCode>PA</customer:contactTypeCode>"+
			"<customer:contactTypeCode>PBA</customer:contactTypeCode>"+
			"</customer:contacts>"+
			"<customer:coreCustomerDetail>"+
			"<customer:customer>"+
			"<customer:enterpriseAssociatedAccounts/>"+
			"<customer:enterpriseProfile/>"+
			"<customer:expressAccountCreationProfile/>"+
			"<customer:expressAccountProfile/>"+
			"</customer:customer>"+	
			"</customer:coreCustomerDetail>"+
			"</customer:resultOptions>"+
			"</customer:accountInquiryRequest>";
			
		    
		    return request;
		 }
		 catch(Exception ex)
		    {
		       ex.printStackTrace();
		       return null;
		    }
		
		}

	
	
	 
	 public static String createNewXml(String billToAcctnumber)
		{
		 try{
		    System.out.println("in createXmlNew - NEW-2018");		
		 		
		 	AccountInquiryDocument accountInquiryDocument = AccountInquiryDocument.Factory.newInstance();		 		
	     	AccountInquiry accountInquiry = accountInquiryDocument.addNewAccountInquiry();	     		     	
		 		    
	     	
	     	//accountInquiry.setSchemaVersion("4.4.15");	     	
	        ResultOptions resultOptions = accountInquiry.addNewResultOptions();
	        resultOptions.addNewContacts();
	     	AccountIdForInquiry accountId = accountInquiry.addNewAccountId();
	     	accountId.setNumber( billToAcctnumber);
	     	
	     	
	     	
	     	
	        //ResultOptions resultOptions = accountInquiry.addNewResultOptions();
	        //resultOptions.addNewContacts();	        
	        accountId.setOpco(OpcoCode.Enum.forString("FX"));
	        //DataSource dataSource = accountInquiry.addNewDataSourceOptions();
	        
	        //dataSource.setActiveDatabase(true);
	        //dataSource.setArchiveDatabase(false);

	        //AccountIdForInquiry accountId = accountInquiry.addNewAccountId();
	        //accountId.setOpco(OpcoCode.Enum.forString("FDSV"));
	        //accountId.setNumber( billToAcctnumber);	       	        
	        //SearchWindow window = accountInquiry.addNewWindow();
	        //window.setMaxResults(BigInteger.ZERO);
	 
	        //Document requestDoc = (Document) accountInquiryDocument.newDomNode();
	        
	        //requestDoc.getDocumentElement().removeAttribute("schemaVersion");

	        //requestDoc.getDocumentElement().setAttribute("schemaVersion", "4.4.15");
	        
	        accountInquiryDocument.setAccountInquiry(accountInquiry);
	        return accountInquiryDocument.toString();	     
		 }
		 catch(Exception ex)
		    {
		       ex.printStackTrace();
		       return null;
		    }
		
		}
	 
	 public static XmlObject getXmlObject(String str) throws Exception{
		 XmlObject xmlobject=null;
		 try{   			
	        xmlobject=XmlObject.Factory.parse(str);	     	       	
		 }
			catch(Exception e){
				e.printStackTrace();
			}
			return xmlobject;
	 }


	 //public static SOAPElement createSOAPHeaderElement(String employeeId,
			public static String createSOAPHeaderElement(String employeeId,
              String employeeOpCo,
              String callingAppSourceSystemCode,
              String namespace) throws Exception {

		 		
		 		
		 	//========= Token thing ============================///////
				  String token_code="";
				  String token_filepath = null;
				  String str="";
				  Properties prop=null;
				  prop= Utils.getProperties("P");
				  token_filepath= prop.getProperty("ciam.token.filepath");
				  System.out.println("ciam.token.filepath from database=="+token_filepath);

				  try {
			
					  BufferedReader in = new BufferedReader(new FileReader(token_filepath));
					  while ((str = in.readLine()) != null) {
						  token_code = str;
					  }//end while
					  in.close();
				 } catch (IOException e) {
					 e.printStackTrace();
				 }//end try
			//================= End Token Code ================/////////

				//String prefix = "cfam";
				String prefix = "wsse";
				SOAPMessage message = null;
				SOAPElement cfamHeader = null;
				String cfamHeaderTest = null;
				try{
					
					cfamHeaderTest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:customer=\"http://xmlns.fedex.com/customer\">"+
					"<soapenv:Header>"+
					"<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">"+
					"<wsse:UsernameToken>"+
					"<wsse:Username>"+token_code+
					"</wsse:Username>"+
					"</wsse:UsernameToken>"+
					"</wsse:Security>"+
					"</soapenv:Header>";
					System.out.println("cfamHeaderTest==.."+cfamHeaderTest);
				/*System.out.println("in createSoapHeader Element..");
					MessageFactory msgFactory = MessageFactory.newInstance();
					message = msgFactory.createMessage();
					System.out.println("message=="+message);
					System.out.println("namespace NEW=="+namespace);
					javax.xml.soap.SOAPPart soapPart = message.getSOAPPart();
					SOAPEnvelope se = soapPart.getEnvelope();
					//System.out.println("se=="+se);

					SOAPHeader header = se.getHeader();					

					cfamHeader = header.addHeaderElement(se.createName("header", prefix, namespace));
					System.out.println("header=="+header);
					SOAPElement security = cfamHeader.addChildElement(se.createName("Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\", prefix, namespace));
					System.out.println("Security=="+security);
					SOAPElement employee = security.addChildElement(se.createName("employee", prefix, namespace));
					System.out.println("employee=="+employee);
					employee.addAttribute(se.createName("opco"), employeeOpCo);
					//employee.addAttribute(se.createName("number"), employeeId);
					SOAPElement sourceSystem = security.addChildElement(se.createName("sourceSystem", prefix, namespace));
					sourceSystem.addTextNode(callingAppSourceSystemCode);
					SOAPElement token = security.addChildElement(se.createName("token", prefix, namespace));
					token.addTextNode(token_code); */
				}

				catch(Exception e){
					e.printStackTrace();
				}
				//return cfamHeader;
				return cfamHeaderTest;
			}

	 
	 //public static String constructSOAPBody(XmlObject xmlobject, SOAPElement headerElement) {
		 public static String constructSOAPBody(XmlObject xmlobject, String header) {
		    System.out.println("in constructSOAPBody ");		    
			/*String topPart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
			"<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"> " +
			"<SOAP-ENV:Header> "; 			
			System.out.println("topPart== "+topPart);*/
			//String header = headerElement.toString();
			//System.out.println("header== "+header);
			String bottomPart = "</soapenv:Body></soapenv:Envelope>";
			//String bottomPart = "</SOAP-ENV:Body></SOAP-ENV:Envelope>";

			//String messageString = topPart + header+ "</SOAP-ENV:Header>" + "<SOAP-ENV:Body>" +xmlobject.toString() + bottomPart;			
			String messageString = header + "<soapenv:Body>" +xmlobject.toString() + bottomPart;
			//System.out.println("messageString== "+messageString);
			return messageString;
		}
	   
	 
	 
	 public static SOAPMessage convertXmlObject2SOAPMsg(XmlObject xmlObjectSoapBody) throws SOAPException
		{
	        System.out.println("ENTERED INTO CONVERTXMLOBJECT2SOAPMsg ");
			Node node = xmlObjectSoapBody.newDomNode();

			MessageFactory msgFactory = MessageFactory.newInstance();
			SOAPMessage message = msgFactory.createMessage();

			SOAPPart soapPart = message.getSOAPPart();

			DOMSource domSource = new DOMSource(node);
			soapPart.setContent(domSource);
//	        SOAPEnvelope msgEnv = soapPart.getEnvelope();
			soapPart = message.getSOAPPart () ;

			return message;
	}
	 
	   
	    
	    public static void printsoapMessage(SOAPMessage request) throws Exception
		{
	        System.out.println("---------- START OF SOAP MESSAGE --------------------------");	        
			request.writeTo(System.out) ;			
			System.out.println("----------END OF SOAP MESSAGE--------------------------");
			

		}
	    
	   	    

		
		
		
		public static String getResponseForClient(SOAPMessage response)   
		//public static Document getResponseForClient(SOAPMessage response)
        		throws   SOAPException, IOException, TransformerException {
			Document document = null;
			String str = null;
			try{
				
			System.out.println("SOAPMessage response=="+response);
			System.out.println("response.getSOAPHeader()="+response.getSOAPHeader());
			System.out.println("response.getSOAPBody()="+response.getSOAPBody());
						
			System.out.println("response.getSOAPPart()="+response.getSOAPPart());
			SOAPPart sp = response.getSOAPPart();		
			
		    SOAPEnvelope se = sp.getEnvelope();
		    SOAPBody soapBody = se.getBody();
		    System.out.println("==============================================");
		    System.out.println("soapBody="+soapBody);				
		 

		    //Iterator iter1 =soapBody.getChildElements();
		    //str= iter1.next().toString();		    
		    //System.out.println("str==="+str);
		    
		    Iterator iter1 =response.getSOAPBody().getChildElements();
		    str= iter1.next().toString();		    
		    System.out.println("str jj==="+str);
		    
		   
		    
		    /*DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    
		    document = builder.parse(new InputSource(new StringReader(str)));*/
		    
		    //InputSource is = new InputSource( new StringReader( str ) );
		    //d = builder.parse(is);
		   
		    //System.out.println("document=="+document);
		    	    
			}
			catch(Exception e){
				e.printStackTrace();
			}
					
			 return str;
			 //return document;
			
              
		}
		
		
	
		 public static javax.xml.soap.SOAPMessage submitRequest(SOAPMessage request, String url) throws Exception
	      {
			String endpoint = null;
			javax.xml.soap.SOAPMessage response = null;		
           try{           	
           	
				endpoint = new String(url);
				System.out.println("URL: <" + endpoint +">");	
				
				SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
				SOAPConnection connection = soapConnectionFactory.createConnection();
				System.out.println("Connection created.." + connection);	
				
				if(connection == null) {
					System.out.println("Connection is null........");
				}
				response = connection.call(request, endpoint);
				System.out.println("Getting response---");			
				//response.writeTo(System.out);
				
           }					 
			catch (Exception exception) {
				System.out.println("Problem in connecting to the web service.  Error:" +	exception);
				
				exception.printStackTrace();
			}
			if (response == null) {
				System.out.println("submitRequest() found request return value is null");
				
			}
			
			return response;
		  }


}
