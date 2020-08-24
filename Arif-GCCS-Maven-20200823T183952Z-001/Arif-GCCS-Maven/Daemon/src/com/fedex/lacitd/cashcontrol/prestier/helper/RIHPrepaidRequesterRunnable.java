/**
 * RIHPrepaidRequesterRunnable.java
 * 
 * Created on 20 de diciembre de 2002, 16:02
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import java.util.*;
import java.text.*;
import javax.naming.*;
import javax.jms.*;
import javax.jms.Queue;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import java.util.*;
import java.text.*;
import javax.naming.*;
import javax.jms.*;
import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import java.util.*;
import java.text.*;
import javax.naming.*;
import javax.jms.*;
import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
/**
 *
 * @author  ccardenas
 */
public class RIHPrepaidRequesterRunnable implements java.io.Serializable,java.lang.Runnable {
    
	private Properties prop=null;
    /** Holds value of property thread. */
    private java.lang.Thread thread;
    
    private String requestFooter=null;
    
    /** Creates a new instance of InCageExceptionsRunnable */
    public RIHPrepaidRequesterRunnable() {

    }
    
    /**
     * This methods is started in his own thread.
     * This code is running all the time monitoring
     * if the task to collect In Cage exceptions has to
     * be run in any location.
     */
    public void run() {
           while(!"STOP_THREAD".equals(thread.getName())){
                try{
                    prop=Utils.getProperties("P");
                	PrepPoaBizDelegate ppBiz=new PrepPoaBizDelegate();
                	TasksLogController tlCont=new TasksLogController();

                	Collection colLocations=ppBiz.getLocationsRIHFeed();

                	if(colLocations!=null && !colLocations.isEmpty()){
                		requestPrepaidRIH(colLocations);
                	}	
                	
                    Thread.sleep(Constants.RIHRequesterTaskInterval);                    
                }catch(Exception e){
                    try{
                        Constants.logger.debug(Utils.stackTraceToString(e));
                        Utils.notifyError(prop.getProperty("prepaid.rih.notifications.mail"),"RIH Request Problem.",Utils.stackTraceToString(e));
                        try{
                            Thread.sleep(Constants.RIHRequesterTaskInterval);
                        }catch(Exception e2){}
                     }catch(Exception e3){}

                }
            }
    }
    
    /** Getter for property thread.
     * @return Value of property thread.
     */
    public java.lang.Thread getThread() {
        return this.thread;
    }
    
    /** Setter for property thread.
     * @param thread New value of property thread.
     */
    public void setThread(java.lang.Thread thread) {
        this.thread = thread;
    }
    
    private void requestPrepaidRIH(Collection colLocations){
    	
    	try{
    		Date now=new Date();
    		
    		Iterator iterLoc=colLocations.iterator();
    		String textXml=null;
    		TasksLogController tlc=new TasksLogController();
    	
    		while(iterLoc.hasNext()){
    			TasksVO tVO=(TasksVO) iterLoc.next();
    			
    			textXml=createFileRequest(tVO.getLocationCd(),tVO.getRunMonTime());//this will hold the date to be queried. It is a workaround to reuse TasksVO class
    			
    			String jmsCorId=tVO.getLocationCd()+"-"+String.valueOf(System.currentTimeMillis());
				
    			sendRIHRequest(textXml,jmsCorId);
    			
    			TasksLogVO tlVO=new TasksLogVO();
    			tlVO.setTasksId(tVO.getTasksId().intValue());
    			tlVO.setRunDt(now);
    			tlVO.setMessage("successful - "+jmsCorId);
    			tlVO.setResult(1);
    			
    			tlc.setTasksLog(tlVO);
    			
    		}
    	
    	}catch(Exception e){
    		Constants.logger.debug(Utils.stackTraceToString(e));
    		Utils.notifyError(prop.getProperty("prepaid.rih.notifications.mail"),"RIH Request Problem.",e.toString());
    	}
    }
    
    private String createFileRequest(String locationCd,String dt)throws Exception{
//this is using the String instead jaxb because of one issue found in the jaxb classes    	
    	if(requestFooter==null){
    		StringBuffer sb=new StringBuffer();
			
			sb.append("	<FileFormat fileType=\"XML\">");
			sb.append("		<mdeElement tagName=\"awbNbr\">mdeAirbillNumber</mdeElement>");
			sb.append("		<mdeElement tagName=\"origLocation\">mdeOrigLoc</mdeElement>");
			sb.append("		<mdeElement tagName=\"destLocation\">mdeDestLoc</mdeElement>");
			sb.append("		<mdeElement tagName=\"shipDt\">mdeShipDt</mdeElement>");
			sb.append("		<mdeElement tagName=\"origCountry\">mdeOrigLocCountry</mdeElement>");			
			sb.append("		<mdeElement tagName=\"destCountry\">mdeDestLocCountry</mdeElement>");
			sb.append("		<mdeElement tagName=\"freightChargeAmt\">mdeFreightChargeAmt</mdeElement>");
			sb.append("		<mdeElement tagName=\"shipperCompany\">mdeShipperCompany</mdeElement>");
			sb.append("		<mdeElement tagName=\"shipperNm\">mdeShipperNm</mdeElement>");
			sb.append("	</FileFormat>");
			sb.append("</MDE_Request>");
			
			requestFooter=sb.toString();
    	}	

    	StringBuffer sbSel=new StringBuffer();
    	
    	int offset=0;
    	try{
    		offset=Integer.parseInt(prop.getProperty("prepaid.rih.requester.daysoffset"));
    	}catch(Exception e){
    		offset=0;
    	}
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	dt=sdf.format(new Date(sdf.parse(dt).getTime()-(offset*24*60*60*1000)));
    	
    	sbSel.append("<MDE_Request>");
    	sbSel.append("	<ShipmentSelectorGroup>");
    	sbSel.append("		<Selector selectionType=\"Equal\" elementName=\"mdeInputDate\">#date "+dt+"</Selector>");
    	sbSel.append("		<Selector selectionType=\"Equal\" elementName=\"mdeOrigLoc\">"+locationCd+"</Selector>");
    	sbSel.append("		<Selector selectionType=\"Equal\" elementName=\"mdeBillToPaymentMethodCd\">5</Selector>");
    	sbSel.append("	</ShipmentSelectorGroup>");
   	
    	sbSel.append("	<Access transport=\""+prop.getProperty("prepaid.rih.transport")+"\" location=\""+prop.getProperty("prepaid.rih.ftpServer")+"\" userName=\""+prop.getProperty("prepaid.rih.ftpUserName")+"\" password=\""+prop.getProperty("prepaid.rih.ftpPwd")+"\" directory=\""+prop.getProperty("prepaid.rih.dir")+"\"/>");
    	
    	return sbSel.toString()+requestFooter;
    }
	
    public void sendRIHRequest(String xmlRequestStr,String jmsCorId)
	{
    	try	{
    		Hashtable env = new Hashtable();
    		env.put( Context.INITIAL_CONTEXT_FACTORY, prop.getProperty("prepaid.rih.jndi.InitialContextFactory") );
    		env.put( Context.PROVIDER_URL, prop.getProperty("prepaid.rih.jdni.server"));
    		InitialContext jndiContext = new InitialContext( env );
    		
    		QueueConnectionFactory queueFactory = (javax.jms.QueueConnectionFactory) jndiContext.lookup( prop.getProperty("prepaid.rih.jms.ConnFactory") );
    		QueueConnection connection = queueFactory.createQueueConnection();
    		QueueSession mdeQueueSession = connection.createQueueSession( false, Session.AUTO_ACKNOWLEDGE );
    		Queue sendQueue = (Queue) jndiContext.lookup(prop.getProperty("prepaid.rih.jms.SendQueue"));
    		QueueSender producer = mdeQueueSession.createSender( sendQueue );

    		Queue replyQueue = (Queue) jndiContext.lookup(prop.getProperty("prepaid.rih.jms.ReplyQueue"));
    		TextMessage message = mdeQueueSession.createTextMessage();
    		message.setText(xmlRequestStr);
    		message.setJMSReplyTo( replyQueue );
    		message.setJMSCorrelationID(jmsCorId);  

    		connection.start();
    		producer.send( message, DeliveryMode.PERSISTENT, Message.DEFAULT_PRIORITY, 0 );
    		connection.stop();
    	}
    	catch ( NamingException e )
		{
    		Constants.logger.debug(Utils.stackTraceToString(e));
    		Utils.notifyError(prop.getProperty("prepaid.rih.notifications.mail"),"RIH Request Problem.",e.toString());    		
    	}
    	catch ( JMSException e )
		{
    		Constants.logger.debug(Utils.stackTraceToString(e));
    		Utils.notifyError(prop.getProperty("prepaid.rih.notifications.mail"),"RIH Request Problem.",e.toString());    		
    	}
    }
    
}
/*
 * 
     		
    		JAXBContext jc = JAXBContext.newInstance("com.fedex.rih.mde_download.lac.generator.xmlBinding.fileGeneration");
    		
    		Marshaller m = jc.createMarshaller();
    		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );

    		StringWriter xmlRequest = new StringWriter();
    		m.marshal(mr,xmlRequest);
    		
    		
 ObjectFactory of=new ObjectFactory();
 
 MDERequest mr=createRequestFooter(of);
 List selectors=mr.getShipmentSelectorGroup();

 Selector selDate=of.createSelector();
 selDate.setElementName("mdeInputDate");
 selDate.setSelectionType("Equal");
 selDate.setValue("#date 2004-05-18");//this will hold the date to be queried. It is a workaround to reuse TasksVO class    		
 selectors.add(selDate);
 
 Selector selLoc=of.createSelector();
 selLoc.setElementName("mdeOrigLoc");
 selLoc.setSelectionType("Equal");
 selLoc.setValue("SCL");    		
 selectors.add(selLoc);
 
 Selector selBillMethodCd=of.createSelector();
 selBillMethodCd.setElementName("mdeBillToPaymentMethodCd");
 selBillMethodCd.setSelectionType("Equal");
 selBillMethodCd.setValue("5");
 selectors.add(selBillMethodCd);

 Iterator iterLoc=colLocations.iterator();
 
 while(iterLoc.hasNext()){
 TasksVO tVO=(TasksVO) iterLoc.next();
 
//    			selDate.setValue("#date "+tVO.getRunMonTime());//this will hold the date to be queried. It is a workaround to reuse TasksVO class
//    			selLoc.setValue(tVO.getLocationCd());
 
 sendRIHRequest(mr);
 
 TasksLogVO tlVO=new TasksLogVO();
 tlVO.setTasksId(tVO.getTasksId().intValue());
 tlVO.setRunDt(now);
 tlVO.setMessage("successful");
 tlVO.setResult(1); 
 
 }
 
     	
    	//ObjectFactory of=new ObjectFactory();
    	MDERequest mr = (MDERequest) of.createMDERequest();
    	
    	Access ac=of.createAccess();
    	ac.setTransport(prop.getProperty("prepaid.rih.transport"));
    	ac.setLocation(prop.getProperty("prepaid.rih.ftpServer"));
    	ac.setDirectory(prop.getProperty("prepaid.rih.dir"));
    	ac.setUserName("prepaid.rih.ftpUserName");
    	ac.setPassword("prepaid.rih.ftpPwd");
    	
    	mr.setAccess(ac);
    	
    	FileFormat ff=of.createFileFormat();
    	mr.setFileFormat(ff);
    	
    	ff.setFileType("XML");
    	List mdeList=ff.getMdeElement();
    	
    	MdeElement mde=of.createMdeElement();
    	mde.setTagName("awbNbr");
    	mde.setValue("mdeAirbillNumber");
    	mdeList.add(mde);
    	
    	mde=of.createMdeElement();
    	mde.setTagName("origLocation");
    	mde.setValue("mdeOrigLoc");
    	mdeList.add(mde);
    	
    	mde=of.createMdeElement();
    	mde.setTagName("destLocation");
    	mde.setValue("mdeDestLoc");
    	mdeList.add(mde);
    	
    	mde=of.createMdeElement();
    	mde.setTagName("shipDt");
    	mde.setValue("mdeShipDt");
    	mdeList.add(mde);
    	
    	mde=of.createMdeElement();
    	mde.setTagName("origCountry");
    	mde.setValue("mdeOrigLocCountry");
    	mdeList.add(mde);
    	
    	mde=of.createMdeElement();
    	mde.setTagName("destCountry");
    	mde.setValue("mdeDestLocCountry");
    	mdeList.add(mde);
    	
    	mde=of.createMdeElement();
    	mde.setTagName("freightChargeAmt");
    	mde.setValue("mdeFreightChargeAmt");
    	mdeList.add(mde);
    	
    	mde=of.createMdeElement();
    	mde.setTagName("shipperCompany");
    	mde.setValue("mdeShipperCompany");
    	mdeList.add(mde);
    	
    	mde=of.createMdeElement();
    	mde.setTagName("shipperNm");
    	mde.setValue("mdeShipperNm");
    	mdeList.add(mde);
 *
 *
 **/