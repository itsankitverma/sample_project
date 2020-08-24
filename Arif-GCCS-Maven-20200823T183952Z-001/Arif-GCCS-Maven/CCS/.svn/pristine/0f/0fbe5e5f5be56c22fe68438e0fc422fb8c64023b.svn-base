/**
 * PoaBreakoutAction.java
 *
 * 
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.common.*;

/**
 * This class is in charge of the Breakouts
 * entering for POA
 * @author  ccardenas
 */
public class PoaBreakoutAction extends Action implements java.io.Serializable{
    public PoaBreakoutAction() {
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
     * This method is executed to prepare the information
     * for the page that allow the modifications on the
     * breakouts for the payment
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
    	PoaBreakoutForm frm=null;
    	try{
    		EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
    		frm=(PoaBreakoutForm)form;
    		
    		Collection colAllSC=null;
    		
    		Map mapSC=(Map)request.getSession().getAttribute("POASurCharges");
    		
    		//get the map containing the breakouts
    		if(mapSC!=null && !mapSC.isEmpty()) colAllSC=(Collection)mapSC.get(frm.getInvoiceNbr());
    		
    		//if the surcharges are in the session
    		if(colAllSC!=null && !colAllSC.isEmpty()){
    			frm.setSurcharges((List)colAllSC);
    			Iterator iterSr=colAllSC.iterator();
    			frm.setTotalCollected(0);
    			while(iterSr.hasNext()){
    				GenericSurchargeVO gsVO=(GenericSurchargeVO)iterSr.next();
    				frm.setTotalCollected(frm.getTotalCollected()+gsVO.getCollectedAmt());
    			}	
    		}else{
    		//if it is needed to get them from db	
	    		SurchargesController sc=new SurchargesController();
	    		PoaSurchargesController rsc=new PoaSurchargesController();
	    		Collection colScLoc=sc.getSurchargesByPoa(ep.getLocationCd());
	    		
	    		Collection colScPoa=rsc.getPoaSurchargesByPoaDetail(new Integer(frm.getPoaDetailId()));
	
	    		colAllSC=new ArrayList();
	    		Iterator iterScLoc=colScLoc.iterator();
	    		
	    		frm.setTotalCollected(0);
	    		
	    		boolean hasAppliedPymts=true;
	    		if(colScPoa.isEmpty()){
	    			hasAppliedPymts=false;
	    		}
	    		
	    		while(iterScLoc.hasNext()){
	    			SurchargesVO sVO=(SurchargesVO)iterScLoc.next();
	    			GenericSurchargeVO gsVO=new GenericSurchargeVO();
	    			gsVO.setSurchargeCd(sVO.getSurchargeCd());
	    			gsVO.setSurchargeDesc(sVO.getShtDesc());
	    			gsVO.setNewSurcharge(true);
	    			
	    			if(hasAppliedPymts){ 
	    				Iterator iterScPoa=colScPoa.iterator();
	    				while(iterScPoa.hasNext()){
	    					PoaSurchargesVO rs=(PoaSurchargesVO)iterScPoa.next();
	    					if(gsVO.getSurchargeCd().equals(rs.getSurchargeCd())){
	    						gsVO.setNewSurcharge(false);
	    						gsVO.setCollectedAmt(rs.getAppliedAmt());
	    						frm.setTotalCollected(frm.getTotalCollected()+gsVO.getCollectedAmt());
	    						iterScPoa.remove();
	    						break;
	    					}
	    				}
	    			}else{
	    				if("APPLAMT".equalsIgnoreCase(gsVO.getSurchargeCd())){
	    					gsVO.setCollectedAmt(frm.getParentTotal());
	    					frm.setTotalCollected(frm.getParentTotal());
	    				}	
	    			}
	    			
	    			colAllSC.add(gsVO);
	    			
	    		}
    		}	
    		frm.setSurcharges((List)colAllSC);
    		request.setAttribute("PoaBreakoutForm",frm);
    	}catch(Exception e){ 
    		Constants.logger.debug(Utils.stackTraceToString(e));              
    		ActionErrors ae=new ActionErrors();
    		ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
    		saveErrors(request,ae);
    		frm.setSurcharges(new ArrayList()); 
    		request.setAttribute("PoaBreakoutForm",frm);
    	}
    	return mapping.findForward("Success");
    }
    
    /**
     * This method is executed to save the entered breakouts
     * in the session
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
    	PoaBreakoutForm frm=null;
    	try{
    		EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
    		frm=(PoaBreakoutForm)form;
    		
    		Map mapSC=(Map)request.getSession().getAttribute("POASurCharges");
    		if(mapSC==null) mapSC=new HashMap();
    		
 		    //save the breakouts in the session
    		mapSC.put(frm.getInvoiceNbr(),frm.getSurcharges());
    		
    		request.getSession().setAttribute("POASurCharges",mapSC);
    		
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