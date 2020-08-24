

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.common.*;

/**
 * This class is used to manage the requests for breakouts on Prepaid
 * @author  ccardenas
 */
public class PrepaidBreakoutAction extends Action implements java.io.Serializable{
    public PrepaidBreakoutAction() {
    }
    
    /**
     * This method is executed by Struts framework when a request to the
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
        if(request.getSession().getAttribute("userProfile")==null) return mapping.findForward("logout");
        if("save".equals(request.getParameter("action"))){
            return save(mapping,form,request,response);
        }else{
        	return show(mapping,form,request,response);
        }
    }

    /**
     * This method is used to prepare the data for the page
     * that will show the breakouts
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
		PrepaidBreakoutForm frm=null;
    	try{
	        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
	        frm=(PrepaidBreakoutForm)form;
	        
	        SurchargesController sc=new SurchargesController();
	        PrepSurchargesController rsc=new PrepSurchargesController();
	        Collection colScLoc=sc.getSurchargesByPrepaid(ep.getLocationCd());
	        Collection colScPrep=rsc.getPrepSurchargesByPrepaid(new Integer(frm.getPrepaidId()));

	        Collection colAllSC=new ArrayList();
	        Iterator iterScLoc=colScLoc.iterator();
	        
	        frm.setTotalCollected(0);
	        
	        boolean hasAppliedPymts=true;
	        if(colScPrep.isEmpty()){
	        	hasAppliedPymts=false;
	        }
	        
	        while(iterScLoc.hasNext()){
	        	SurchargesVO sVO=(SurchargesVO)iterScLoc.next();
	        	GenericSurchargeVO gsVO=new GenericSurchargeVO();
	        	gsVO.setSurchargeCd(sVO.getSurchargeCd());
	        	gsVO.setSurchargeDesc(sVO.getShtDesc());
				gsVO.setNewSurcharge(true);
	        	
				if(hasAppliedPymts){ 
		        	Iterator iterScPrep=colScPrep.iterator();
		        	while(iterScPrep.hasNext()){
		        		PrepSurchargesVO rs=(PrepSurchargesVO)iterScPrep.next();
		        		if(gsVO.getSurchargeCd().equals(rs.getSurchargeCd())){
							gsVO.setNewSurcharge(false);
		        			gsVO.setCollectedAmt(rs.getAppliedAmt());
		        			frm.setTotalCollected(frm.getTotalCollected()+gsVO.getCollectedAmt());
		        			iterScPrep.remove();
		        			break;
		        		}
		        	}
				}else{
					if("FRGHT".equalsIgnoreCase(gsVO.getSurchargeCd())){
						gsVO.setCollectedAmt(frm.getParentTotal());
						frm.setTotalCollected(frm.getParentTotal());
					}	
				}
	        	
	        	colAllSC.add(gsVO);
        	
	        }
	        frm.setSurcharges((List)colAllSC);
	        request.setAttribute("PrepaidBreakoutForm",frm);
	    }catch(Exception e){ 
	    	Constants.logger.debug(Utils.stackTraceToString(e));              
	    	ActionErrors ae=new ActionErrors();
	    	ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
	    	saveErrors(request,ae);
			frm.setSurcharges(new ArrayList()); 
	    	request.setAttribute("PrepaidBreakoutForm",frm);
	    }
	    return mapping.findForward("Success");
    }
    /**
     * This method will save the breakouts for the current prepaid.
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
    	PrepaidBreakoutForm frm=null;
    	try{
	    	EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
	    	frm=(PrepaidBreakoutForm)form;
	    	
	    	PrepSurchargesController rsc=new PrepSurchargesController();
	    	Collection colScColl=frm.getSurcharges();
	    	Iterator iterScColl=colScColl.iterator();
	    	while(iterScColl.hasNext()){
	    	    GenericSurchargeVO gsVO=(GenericSurchargeVO)iterScColl.next();
	    	    
	    	    if(gsVO.getCollectedAmt()>0 || !gsVO.isNewSurcharge()){
	    	    
		    	    PrepSurchargesVO rsVO=new PrepSurchargesVO();
		    	    
		    	    rsVO.setPrepaidId(new Integer(frm.getPrepaidId()));
		    	    rsVO.setSurchargeCd(gsVO.getSurchargeCd());
		    	    rsVO.setAppliedAmt(gsVO.getCollectedAmt());
		    	    
		    	    if(gsVO.isNewSurcharge()){
		    	    	rsc.setPrepSurcharges(rsVO);
		    	    }else{
		    	    	if (gsVO.getCollectedAmt()>0){
		    	    		rsc.updatePrepSurcharges(rsVO);
		    	    	}else{
		    	    		rsc.removePrepSurcharges(new PrepSurchargesPK(rsVO.getPrepaidId(),rsVO.getSurchargeCd()));
		    	    	}	
		    	    }
	    	    }    	
	    	}
	    	request.setAttribute("submitParent","submitParent");
	    	return mapping.findForward("CloseWindow");
    	}catch(Exception e){ 
    		Constants.logger.debug(Utils.stackTraceToString(e));
    		ActionErrors ae=new ActionErrors();
    		ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotSaveTheData"));
    		saveErrors(request,ae);
    		return show(mapping,form,request,response);
    	}	    	
    }
}