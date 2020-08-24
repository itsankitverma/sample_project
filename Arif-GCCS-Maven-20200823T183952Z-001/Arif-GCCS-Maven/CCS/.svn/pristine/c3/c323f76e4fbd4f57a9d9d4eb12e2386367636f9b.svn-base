 /**
 * ProcessLastScansAction.java
 *
 * 
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;
import com.fedex.lacitd.cashcontrol.prestier.helper.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import org.apache.struts.action.*;
import java.util.*;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.PrepaidController;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PrepaidVO;
import com.fedex.lacitd.cashcontrol.datatier.controller.COD_ReceivablesController;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.COD_ReceivablesVO;

import com.fedex.common.j2ee.mcd.MCD;
import com.fedex.lacitd.cashcontrol.prestier.helper.AppInit;
//import com.fedex.lacitd.cashcontrol.prestier.helper.McDUtils;
//import com.fedex.lacitd.cashcontrol.prestier.helper.AppUtils;
//import com.fedex.lacitd.cashcontrol.prestier.helper.AppLogger;
/**
 * This class is in charge of manage the requests
 * for scans processing for ROD
 * @author  ccardenas
 */
public class ProcessLastScansAction extends Action implements java.io.Serializable {
    public ProcessLastScansAction() {
    	
    }

    /**
     * This method is executed by Struts framework when a request to the
     * related URI is done. It has all the code to start the processing
     * of the scans
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */ 
    public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
    	System.out.println("Process Cosmos SCAN EXECUTE");
    	AppInit.startMcd();
    	 long startTime = System.currentTimeMillis() ;
         try {
        	 System.out.println("Mcd in Process Cosmos SCAN");
             // Beginning of request. Inform McD
             MCD.processEvent("server",
                 "GCCS",
                 "ProcessLastScansAction",
                 //AppUtils.getHostname(),
                 AppInit.getHostname(),
                 null,
                 "OR",
                 "processCosmosScans",
                 null,
                 null,
                 -1,
                 null);
         } catch (Exception e) {
        	 System.out.println("McD Exception while processing GCCS.processCosmosScans") ;
        	 e.printStackTrace();
             //AppLogger.error("McD Exception while processing GCCS.processCosmosScans", e) ;
         }
    	    	
    	
            RODBizDelegate biz=new RODBizDelegate();
            CODBizDelegate bizCOD=new CODBizDelegate();
            
            PrepPoaBizDelegate bizPRP=new PrepPoaBizDelegate();
            PrepaidController contPRP=new PrepaidController();
            
            CommonOpsBizDelegate comBiz  = new CommonOpsBizDelegate();
            Collection np=new ArrayList();
            try{
                EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
                if(ep==null) return mapping.findForward("logout");
                
                if(ep.isRefreshEnable()){
                	if("T".equals(request.getParameter("firstTime"))){
                		addRefreshLocation(ep.getLocationCd());
                	}else{
                		if(!existRefreshLocation(ep.getLocationCd())){
                			request.setAttribute("firstTime","T");
                			request.setAttribute("refreshStopped","refreshStopped");
                            request.setAttribute("NotProcessed",(np==null)?new ArrayList():np);
                            return mapping.findForward("Success");
                			
                		}
                	}
                	request.setAttribute("firstTime","F");
                }
                System.out.println("before Mcd in Process ROD COSMOS SCAN");
                AppInit.startMcd();
                long startTime1 = System.currentTimeMillis() ;
	            try {
	                // Beginning of request. Inform McD
	            	System.out.println("Mcd in Process ROD COSMOS SCAN");
	                MCD.processEvent("server",
	                    "GCCS",
	                    "ProcessLastScansAction",
	                    //AppUtils.getHostname(),
	                    AppInit.getHostname(),
	                    null,
	                    "OR",
	                    "processRodCosmosScans",
	                    null,
	                    null,
	                    -1,
	                    null);
	            } catch (Exception e) {
	                //AppLogger.error("McD Exception while processing GCCS.processRodCosmosScans", e) ;
	            	 System.out.println("McD Exception while processing GCCS.processRodCosmosScans") ;
	            	 e.printStackTrace();
	            }
                /*-PROCESSING ROD COSMOS SCANS--*/
                //getting the AWBs to be processed
	            
                Collection awbs=biz.getAwbToQueryCosmos(ep.getLocationCd(),null);
                
                //creating the results collection
                Collection results=Collections.synchronizedCollection(new ArrayList());
                
                RODScanProcessor sp=new RODScanProcessor();
                
                //processing the scans. np will contain the errors ocurred                
                np=sp.processLastScans(awbs,results,ep.getLocationCd(),comBiz.getLocationCdByCountry(ep.getCountryCd()),ep.getScansLocalDecs(),ep.getScansUsdDecs());
                
                //applying the scans in the db. np will contain the errors ocurred                
                np.addAll(biz.applyScans(results));
                
             // End of request. Inform McD
                try {
                    MCD.processEvent("server",
    	                "GCCS",
    	                "ProcessLastScansAction",
                        //AppUtils.getHostname(),
                        AppInit.getHostname(),
                        null,
                        "IP",
                        "processRodCosmosScans",
                        null,
                        null,
                        System.currentTimeMillis() - startTime1,
                        null);
                } catch (Exception e) {
                    //AppLogger.error("McD exception while processing GCCS.processRodCosmosScans", e) ;
                	System.out.println("McD Exception while processing GCCS.processRodCosmosScans") ;
	            	e.printStackTrace();
                }
       
                /* =============================================================================== */
                /*- START  PROCESSING COD COSMOS SCANS--*/
                //getting the AWBs to be processed
	            
                Collection awbsCOD=bizCOD.getAwbToQueryCosmos(ep.getLocationCd(),null);
                
                //creating the results collection
                results=Collections.synchronizedCollection(new ArrayList());
                
                CODScanProcessor spCOD=new CODScanProcessor();
                
                //processing the scans. np will contain the errors ocurred                
                Collection npCOD=spCOD.processLastScans(awbsCOD,results,ep.getLocationCd(),comBiz.getLocationCdByCountry(ep.getCountryCd()),ep.getScansLocalDecs(),ep.getScansUsdDecs());
                
                //applying the scans in the db. np will contain the errors ocurred                
                npCOD.addAll(bizCOD.applyCODScans(results));
                             
                /*----- End Processing COD Cosmo Scan-----*/
                /* ================================================================================ */
                
                /*-PROCESSING PREPAID COSMOS SCANS--*/
                //getting the AWBs to be processed   
                
                long startTime2 = System.currentTimeMillis() ;
	            try {
	                // Beginning of request. Inform McD
	            	System.out.println("Mcd in Process PREPAID COSMOS SCAN");
	                MCD.processEvent("server",
	                    "GCCS",
	                    "ProcessLastScansAction",
	                    //AppUtils.getHostname(),
	                    AppInit.getHostname(),
	                    null,
	                    "OR",
	                    "processPrepaidCosmosScans",
	                    null,
	                    null,
	                    -1,
	                    null);
	            } catch (Exception e) {
	                //AppLogger.error("McD Exception while processing GCCS.processPrepaidCosmosScans", e) ;
	                System.out.println("McD Exception while processing GCCS.processPrepaidCosmosScans") ;
	            	e.printStackTrace();
	            }
	            
                Collection awbsPRP=contPRP.getPrepaidPRPQueryCosmos(ep.getLocationCd(),new Integer(1));
             
                awbs=new ArrayList();                
				Iterator it=awbsPRP.iterator();
				while(it.hasNext()){
					  PrepaidVO pp=(PrepaidVO)it.next();
					  PrepaidScansVO psvo = new PrepaidScansVO();
					  psvo.setPrepaidVO(pp);
					  awbs.add(psvo);	
				}                
                
                //creating the results collection
                results=Collections.synchronizedCollection(new ArrayList());


                PrepaidScanProcessor spPRP=new PrepaidScanProcessor();
                
                //processing the scans. np will contain the errors ocurred
                Collection npPRP=spPRP.processLastScans(awbs,results,ep.getLocationCd(),null,ep.getDefaultCurrency(),ep.getLocationTimeZone(),ep.getScansLocalDecs(),ep.getScansUsdDecs(),comBiz.getLocationCdByCountry(ep.getCountryCd()));
                
                //applying the scans in the db. np will contain the errors ocurred                
                bizPRP.updatePRPWithScanProcessed(results); 


                Iterator npPRPIter=npPRP.iterator();
                
                while(npPRPIter.hasNext()){
                	ActionError ae=(ActionError)npPRPIter.next();
               	
                	if("app.messages.DecodingError1".equals(ae.getKey()) || "app.messages.NoPUXForAWB".equals(ae.getKey())){
                		ScansProcessingError spe=new ScansProcessingError((String)ae.getValues()[0],ae.getKey(), null, "","","");
						spe.setPrepaid(true);
                		np.add(spe);
                	}
                	
                }
                
                request.setAttribute("NotProcessed",(np==null)?new ArrayList():np);
                
                // End of request. Inform McD                
                try {
                    MCD.processEvent("server",
    	                "GCCS",
    	                "ProcessLastScansAction",
                        //AppUtils.getHostname(),
                        AppInit.getHostname(),
                        null,
                        "IP",
                        "processPrepaidCosmosScans",
                        null,
                        null,
                        System.currentTimeMillis() - startTime2,
                        null);
                } catch (Exception e) {
                    //AppLogger.error("McD exception while processing GCCS.processPrepaidCosmosScans", e) ;
                	System.out.println("McD Exception while processing GCCS.processPrepaidCosmosScans") ;
	            	e.printStackTrace();
                }
                
            }catch(Exception e){
                Constants.logger.debug(Utils.stackTraceToString(e));
                ActionErrors ae=new ActionErrors();
                ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.ScansProcessingError"));
                saveErrors(request,ae);
                request.setAttribute("NotProcessed",(np==null)?new ArrayList():np);
            }
                    
         // End of request. Inform McD
            try {
                MCD.processEvent("server",
	                "GCCS",
	                "ProcessLastScansAction",
                    //AppUtils.getHostname(),
                    AppInit.getHostname(),
                    null,
                    "IP",
                    "processCosmosScans",
                    null,
                    null,
                    System.currentTimeMillis() - startTime,
                    null);
            } catch (Exception e) {
                //AppLogger.error("McD exception while processing GCCS.processCosmosScans", e) ;
                System.out.println("McD Exception while processing GCCS.processCosmosScans") ;
            	e.printStackTrace();
            }
            return mapping.findForward("Success");
    }

    private void addRefreshLocation(String locationCd){
    	TreeSet ts=(TreeSet)getServlet().getServletContext().getAttribute("refreshLocations");
    	if(ts==null){
    		ts=new TreeSet();
    		getServlet().getServletContext().setAttribute("refreshLocations",ts);
    	}
    	
    	if(!ts.contains(locationCd)){
    		ts.add(locationCd);
    	}
    }

    private boolean existRefreshLocation(String locationCd){
    	TreeSet ts=(TreeSet)getServlet().getServletContext().getAttribute("refreshLocations");
    	
    	return (ts!=null && ts.contains(locationCd));
    }    
        
}