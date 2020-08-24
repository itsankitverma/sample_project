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
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;

/**
 * This Action class manage the requests from the Add Ground Tracking Number page. *
 * @author  ralvarez
 */
public class AddGrndTrakNbrsAction extends Action implements java.io.Serializable{
    public AddGrndTrakNbrsAction() {
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
                   

        if("SaveTrakNbrs".equals(request.getParameter("action"))){
            return save(mapping,form,request,response);
        }else{
            return show(mapping,form,request,response);
        }
         
    }
    /**
     * This methods is executed by default.
     * It will show the page Add Ground Tracking Number allowing the user to enter AWBs.
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
           AddGrndTrakNbrsForm frm=(AddGrndTrakNbrsForm)form;
           
           if(frm.getTrakNbrs()==null) frm.setTrakNbrs(new ArrayList());
           //creating 25 GroundVO that will create the 25 text box in the page
           for(int idx=frm.getTrakNbrs().size();idx<25;idx++) frm.getTrakNbrs().add(new GroundVO());
          
           request.setAttribute("AddGrndTrakNbrsForm",frm);

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
    private ActionForward save(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
            String nextPage=null;
            ActionErrors ae=new ActionErrors();
            try{ 
            	//checking if the user is logged in
                EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
                if(ep==null) return mapping.findForward("logout");
                
                AddGrndTrakNbrsForm frm=(AddGrndTrakNbrsForm)form;
                
                PrepPoaBizDelegate biz=new PrepPoaBizDelegate();

                //removing the empty objects
                int befRemove=frm.getTrakNbrs().size();
                Iterator iterTrakNbrs=frm.getTrakNbrs().iterator();
                while(iterTrakNbrs.hasNext()){
                    GroundVO groundVO=(GroundVO)iterTrakNbrs.next();
                    if(groundVO.getGrndTrakNbr()==null || "".equals(groundVO.getGrndTrakNbr())){
                        iterTrakNbrs.remove();
                    }else{
                        groundVO.setCourEmpIdNbr(frm.getCourierId());
                        groundVO.setExchRateAmt(frm.getExchRate());
                        groundVO.setPaymentCurrency(frm.getCurrentCurrency());
                        groundVO.setLocationCd(ep.getLocationCd());
                        groundVO.setGrndShpDt(new Date());
                    }
                }

                if(frm.getTrakNbrs().size()==befRemove){
                    nextPage="ShowToEnter";
                }else{
                    nextPage="CloseWindow";                    
                }
                //determining if the system inserted something in the db
                boolean hasInserted=true;

                //applying the scans data in the db
                Iterator iterErrors=biz.saveGrndTrakNbrs(frm.getTrakNbrs()).iterator();

                //collecting the errors
                while(iterErrors.hasNext()){
                	  ae.add(ActionErrors.GLOBAL_ERROR,new ActionError((String)iterErrors.next()));
                      hasInserted=false;
                }

                //If it inserted something, reload parent window
                if(hasInserted) request.setAttribute("submitParent","submitParent");

                if(ae.size()>0){
                    saveErrors(request,ae);
                    return mapping.findForward("ShowToEnter");
                }
                
            }catch(Exception e){
                Constants.logger.debug(Utils.stackTraceToString(e));
                ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.SaveGrndTrakNbrsError"));
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