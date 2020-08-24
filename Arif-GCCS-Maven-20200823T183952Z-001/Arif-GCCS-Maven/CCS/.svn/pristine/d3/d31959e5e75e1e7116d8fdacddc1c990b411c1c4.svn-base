/**
 * FTCAddAwbsAction.java
 *
 * Created on April 10, 2003, 1:16 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import com.fedex.lacitd.cashcontrol.prestier.helper.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import org.apache.struts.action.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.common.*;
import java.io.*;
/**
 *
 * @author  Arturo Gonzalez
 */
public class FTCAddAwbsAction extends Action implements Serializable {
    
    /** Creates a new instance of FTCAddAwbsAction */
    public FTCAddAwbsAction() {
    }
    
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)throws Exception {

                //Here is checks the Session to know if there is an userProfile to follow the workflow
                //If there is not an user Profile return to logout page
                EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
                if(ep==null) return mapping.findForward("CloseWindow");

                //Review what will be action follow the workflow
                 if("addAwb".equals(request.getParameter("action"))){
                     return addAwb(mapping,form,request,response);
                 }else{
                       if("saveAwbs".equals(request.getParameter("action"))){
                          return saveAwbs(mapping,form,request,response);                
                       }else{
                             if("deleteAwb".equals(request.getParameter("action"))){
                                return deleteAwb(mapping,form,request,response);                
                             }else{
                                   return show(mapping,form,request,response);
                              }
                            }
                      }  
       }//Close execute
    
    
    private ActionForward addAwb(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
    throws Exception
    {
         FTCAddAwbsForm frm=(FTCAddAwbsForm)form;
         if(frm==null)  frm=new FTCAddAwbsForm();
         
         frm.getAwbsList().add(0,new FTC_RecChangesFromScans());        
         
         request.setAttribute("FTCAddAwbsForm",frm);
         return mapping.findForward("ShowToEnter");
    }
    
    private ActionForward deleteAwb(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
    throws Exception
    {
         FTCAddAwbsForm frm=(FTCAddAwbsForm)form;
         if(frm==null)  frm=new FTCAddAwbsForm();
         
         frm.getAwbsList().remove(frm.getDelIndex());
         request.setAttribute("FTCAddAwbsForm",frm);
         return mapping.findForward("ShowToEnter");
    }     
    
    private ActionForward saveAwbs(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
    throws Exception {
        FTCAddAwbsForm frm = (FTCAddAwbsForm)form;
        if(frm==null) frm  = new FTCAddAwbsForm();

        //Remove the first record to no insert a void record
        frm.getAwbsList().remove(0);
        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
        frm.getRecChangesFromScans().setLocationCd(ep.getLocationCd());

        Collection awbs     = new ArrayList(frm.getAwbsList());
        Collection results  = null;
        Collection np       = null;
        ActionErrors ae      =new ActionErrors();


        // This code is used to get the Cosmos data to complete the information of the FTC payments
           try{
                FTCBizDelegate biz  = new FTCBizDelegate();
                CommonOpsBizDelegate comBiz  = new CommonOpsBizDelegate();
                results  = Collections.synchronizedCollection(new ArrayList());
                FTCScanProcessor sp = new FTCScanProcessor();
                sp.setKeepWhenNotFound(true);

               //Check if process Cosmos Scans is desired
                if(frm.getCosmosScansEnabled()){
                	np=sp.processLastScans(awbs,results,ep.getLocationCd(),comBiz.getLocationCdByCountry(ep.getCountryCd()),ep.getScansLocalDecs(),ep.getScansUsdDecs());
                }else{
                         np = new ArrayList();

                        //Iterate over awbs to put the location
                        Iterator awbsIt =awbs.iterator();
                        while(awbsIt.hasNext()){
                              FTC_RecChangesFromScans recChanges = (FTC_RecChangesFromScans)awbsIt.next();
                              if(recChanges.getLocationCd()==null)recChanges.setLocationCd(ep.getLocationCd());
                              if(recChanges.getRecEmployeeId()==null)recChanges.setRecEmployeeId("000000");
                              recChanges.setCosmosScans(new ArrayList());
                              results.add(recChanges);
                        }
                     }


                Constants.logger.debug("\n Size of results:"+String.valueOf(results.size()));

                np.addAll(biz.saveScans(results,frm.getCurrentCurrency(),frm.getExchRate()));
                
                Constants.logger.debug("\n Problems:"+String.valueOf(np.size()));
                //Fill ActionErrors to show the problems on the windows
                if(np.size()>0)
                {   Iterator it = np.iterator();
                    ScansProcessingError scape = null;
                    while(it.hasNext())
                    {   scape = new ScansProcessingError();
                        scape = (ScansProcessingError)it.next();
                        ae.add("AwbNumber", new ActionError(scape.getErrorMessage(), scape.getAwbNumber()));
                        Constants.logger.debug(scape.getErrorMessage() + " : " + scape.getAwbNumber());
                        Constants.logger.debug("\n Errors to page :" +  ae.size());
                        saveErrors(request,ae);
                    } 

                    request.setAttribute("NotProcessed",np);
                }
           }catch(Exception e){
                Constants.logger.debug(Utils.stackTraceToString(e));
                ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.ScansProcessingError"));
                saveErrors(request,ae);
                request.setAttribute("NotProcessed",(np==null?new ArrayList():np));
           }

        //}//End checking cosmos scans desired
        
        //Clearing the form
        frm.getAwbsList().clear();
        frm.getAwbsList().add(0,new FTC_RecChangesFromScans());
        frm.setCurrentCurrency("");
        frm.setExchRate(1);
        
        //request.setAttribute("FTCAddAwbsForm",frm);
        return mapping.findForward("ShowToEnter");
    }
    
    private ActionForward show(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
    throws Exception
    {
         FTCAddAwbsForm frm=(FTCAddAwbsForm)form;
         if(frm==null) frm=new FTCAddAwbsForm();
          
         frm.getAwbsList().add(0,new FTC_RecChangesFromScans());
         request.setAttribute("FTCAddAwbsForm",frm);
         return mapping.findForward("ShowToEnter");
    }
}//Close FTCAddAwbsAction class