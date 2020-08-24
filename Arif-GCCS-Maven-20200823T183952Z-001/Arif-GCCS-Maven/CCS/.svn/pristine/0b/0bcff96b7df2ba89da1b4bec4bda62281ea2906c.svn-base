/**
 * AddPrepaidAwbsAction.java
 *
 * Created on 16 de j ulio de 2002, 04:57 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.*;
import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.common.*;
import javax.servlet.http.*;

/**
 * This Action class manage the requests from the Add Prepaid Awbs page. * 
 * @author  ccardenas
 */
public class AddPrepaidAwbsAction extends Action implements java.io.Serializable{
    public AddPrepaidAwbsAction() {
    }
	/**
	 * This methods is run by Struts framework when a request to the
	 * related URI is done.
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
        if(request.getSession().getAttribute("userProfile")==null) return mapping.findForward("CloseWindow"); 
                   

        if("SaveAwbs".equals(request.getParameter("action"))){
            return saveAwbs(mapping,form,request,response);
        }else{
            return show(mapping,form,request,response);
        }
         
    }
    /**
     * This methods is executed by default.
     * It will show the page Add Prepaid AWBs allowing the user to enter AWBs. 
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */
    private ActionForward show(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
           AddPrepaidAwbsForm frm=(AddPrepaidAwbsForm)form;
           
           if(frm.getAwbs()==null) frm.setAwbs(new ArrayList());
           //creating 50 PrepaidScansVO that will create the 50 text box in the page
           for(int idx=frm.getAwbs().size();idx<50;idx++) frm.getAwbs().add(new PrepaidScansVO());
          
           request.setAttribute("AddPrepaidAwbsForm",frm);
           
           return mapping.findForward("ShowToEnter");
    } 
    
    /**
     * This methods is executed when the user select to save the Prepaid AWBs
     * in the Database. It will get the scans and insert the prepaids.  
     *
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */
    
    private ActionForward saveAwbs(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
            String nextPage=null;
            CommonOpsBizDelegate comBiz  = new CommonOpsBizDelegate();
            try{
            	//checking if the user is logged in
                EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
                if(ep==null) return mapping.findForward("logout");
                
                AddPrepaidAwbsForm frm=(AddPrepaidAwbsForm)form;
                
                PrepPoaBizDelegate biz=new PrepPoaBizDelegate();
                
                //removing the empty objects
                int befRemove=frm.getAwbs().size();
                Iterator iterAwbs=frm.getAwbs().iterator();
                while(iterAwbs.hasNext()){
                    PrepaidScansVO prepVO=(PrepaidScansVO)iterAwbs.next();
                    if(prepVO.getAwbNbr()==null || "".equals(prepVO.getAwbNbr())) iterAwbs.remove();
                }
                
                if(frm.getAwbs().size()==befRemove){
                    nextPage="ShowToEnter";
                }else{
                    nextPage="CloseWindow";                    
                }
                
                //creating the results collection
                Collection results=Collections.synchronizedCollection(new ArrayList());               
               
                PrepaidScanProcessor sp=new PrepaidScanProcessor();
                
                //processing the scans
                Collection np=sp.processLastScans(frm.getAwbs(),results,ep.getLocationCd(),frm.getCourierId(),frm.getCurrentCurrency(),ep.getLocationTimeZone(),ep.getScansLocalDecs(),ep.getScansUsdDecs(),comBiz.getLocationCdByCountry(ep.getCountryCd()) );

                //applying the scans data in the db
                Iterator iterErrors=biz.applyPrepaidScans(results).iterator();
                
                //collecting the errors
                while(iterErrors.hasNext()){
                	ScansProcessingError spe=(ScansProcessingError)iterErrors.next();
                	np.add(new ActionError(spe.getErrorMessage(),spe.getArg0(),spe.getArg0(),spe.getArg0()));
                }
                
                //leaving the bad awbs in the collection
                //to be shown in the page
                Collection colBadAwbs=new ArrayList();
                if(np!=null && !np.isEmpty()){
                    Iterator iterNP=np.iterator();
                    ActionErrors ae=new ActionErrors();                    
                    while(iterNP.hasNext()){
                       ActionError actError=(ActionError)iterNP.next();
                       ae.add(ActionErrors.GLOBAL_ERROR,actError);                       
                       if(actError.getKey().equals("app.messages.PUX16CourierDoesNotMatch") ||
                          actError.getKey().equals("app.messages.AWBExists") ||   
                          actError.getKey().equals("app.messages.NoPUXForAWB") ||                           
                          actError.getKey().equals("app.messages.ErrorInsertingAwb") 
                         ){
                           colBadAwbs.add(actError.getValues()[0]); //storing bad AWBs.
                       }
                    }
                    saveErrors(request,ae);
                    nextPage="ShowToEnter";
                }
                
                //determining if the system inserted something in the db
                boolean hasInserted=false;
                if(colBadAwbs.isEmpty()){
                    frm.getAwbs().clear();
                    hasInserted=true;                    
                }else{
                    iterAwbs=frm.getAwbs().iterator();
                    while(iterAwbs.hasNext()){
                        if(colBadAwbs.isEmpty()){
                            iterAwbs.next();
                            iterAwbs.remove();
                            hasInserted=true;
                        }else{
                            PrepaidScansVO prepVO=(PrepaidScansVO)iterAwbs.next();
                            if(colBadAwbs.contains(prepVO.getAwbNbr())){
                                colBadAwbs.remove(prepVO.getAwbNbr());
                            }else{
                                iterAwbs.remove();
                                hasInserted=true;                                
                            }
                        }
                    }
                }
                
                //If it inserted something, reload parent window
                if(hasInserted) request.setAttribute("submitParent","submitParent");
                 
            }catch(Exception e){
                Constants.logger.debug(Utils.stackTraceToString(e));
                ActionErrors ae=new ActionErrors();
                ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.ScansProcessingError"));
                saveErrors(request,ae);  
                return mapping.findForward("ShowToEnter");
            }
            
            if("ShowToEnter".equals(nextPage)){
                return show(mapping,form,request,response);
            }else{
                return mapping.findForward(nextPage);
            }    
    }    

}