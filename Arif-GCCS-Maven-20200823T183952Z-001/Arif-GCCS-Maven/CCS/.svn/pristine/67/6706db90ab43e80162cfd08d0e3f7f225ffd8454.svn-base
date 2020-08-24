

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.common.*;

/**
 * This class manages the requests for 
 * adding and changing the breakouts amounts
 * @author  ccardenas
 */
public class RODBreakoutAction extends Action implements java.io.Serializable{
    public RODBreakoutAction() {
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
     * This method prepares the information
     * for the page that will show the breakouts
     * and will allow to modify them.
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
		RODBreakoutForm frm=null;
    	try{
	        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
	        frm=(RODBreakoutForm)form;
	        
	        SurchargesController sc=new SurchargesController();
	        RecExpSrchgController resc=new RecExpSrchgController();
	        RecSurchargesController rsc=new RecSurchargesController();
	        
	        //getting surcharges valid for ROD in the location
	        Collection colScLoc=sc.getSurchargesByRod(ep.getLocationCd());
	        
	        //getting surcharges assigned to the receivable
	        Collection colScRec=rsc.getRecSurchargesByReceivable(new Integer(frm.getRecId()));

	        //getting expected surcharges assigned to the receivable
	        Collection colExpScRec=resc.getRecExpSrchgByReceivable(new Integer(frm.getRecId()));
	        Collection colAllSC=new ArrayList();
	        Iterator iterScLoc=colScLoc.iterator();
	        
	        //assigning default values to the surcharges
	        if(colExpScRec.isEmpty()){
	        	RecExpSrchgVO exp=null;
	        	
	        	if(frm.getRodAmt()>0){
	        		exp=new RecExpSrchgVO();
	        		exp.setRecId(new Integer(frm.getRecId()));
	        		exp.setSurchargeCd("DUTY");
	        		exp.setAppliedAmt(frm.getRodAmt());	
	        		colExpScRec.add(exp);
	        	}
	        	
	        	if(frm.getAncCharges()>0){
	        		exp=new RecExpSrchgVO();
	        		exp.setRecId(new Integer(frm.getRecId()));
	        		exp.setSurchargeCd("ANCCHRG");
	        		exp.setAppliedAmt(frm.getAncCharges());	 
	        		colExpScRec.add(exp);	        		
	        	}		        	
	        }
	        
	        frm.setTotalExpected(0);
	        frm.setTotalCollected(0);
	        boolean isEmptyRecSc=colScRec.isEmpty();
	       
	        //assigning the values to the surcharges
	        while(iterScLoc.hasNext()){
	        	SurchargesVO sVO=(SurchargesVO)iterScLoc.next();
	        	GenericSurchargeVO gsVO=new GenericSurchargeVO();
	        	gsVO.setSurchargeCd(sVO.getSurchargeCd());
	        	gsVO.setSurchargeDesc(sVO.getShtDesc());
				gsVO.setNewSurcharge(true);
	        	
	        	Iterator iterScRec=colScRec.iterator();
	        	Iterator iterExpScRec=colExpScRec.iterator();
	        	
	        	
	        	if(isEmptyRecSc){
	        			double parentTotal=frm.getParentTotal();
			        	while(iterExpScRec.hasNext()){
			        		RecExpSrchgVO res=(RecExpSrchgVO)iterExpScRec.next();
			        		if(gsVO.getSurchargeCd().equals(res.getSurchargeCd())){
			        			gsVO.setExpectedAmt(res.getAppliedAmt());			        			

			        			if(parentTotal>gsVO.getExpectedAmt()){
			        				gsVO.setCollectedAmt(gsVO.getExpectedAmt());
			        			}else{
			        				gsVO.setCollectedAmt(parentTotal);
			        			}
			        			
			        			frm.setTotalExpected(frm.getTotalExpected()+gsVO.getExpectedAmt());
			        			frm.setTotalCollected(frm.getTotalCollected()+gsVO.getCollectedAmt());			        			
			        			parentTotal=parentTotal-gsVO.getCollectedAmt();
			        			iterExpScRec.remove();
			        			break;
			        		}
			        	}
	        	}else{
		        		while(iterExpScRec.hasNext()){
		        			RecExpSrchgVO res=(RecExpSrchgVO)iterExpScRec.next();
		        			if(gsVO.getSurchargeCd().equals(res.getSurchargeCd())){
		        				gsVO.setExpectedAmt(res.getAppliedAmt());
		        				frm.setTotalExpected(frm.getTotalExpected()+gsVO.getExpectedAmt());
		        				iterExpScRec.remove();
		        				break;
		        			}
		        		}
	        		
			        	while(iterScRec.hasNext()){
			        		RecSurchargesVO rs=(RecSurchargesVO)iterScRec.next();
			        		if(gsVO.getSurchargeCd().equals(rs.getSurchargeCd())){
								gsVO.setNewSurcharge(false);
			        			gsVO.setCollectedAmt(rs.getAppliedAmt());
			        			frm.setTotalCollected(frm.getTotalCollected()+gsVO.getCollectedAmt());
			        			iterScRec.remove();
			        			break;
			        		}
			        	}
	        	}    	
	        	
	        	colAllSC.add(gsVO);
        	
	        }
	        frm.setSurcharges((List)colAllSC);
	        request.setAttribute("RODBreakoutForm",frm);
	    }catch(Exception e){ 
	    	Constants.logger.debug(Utils.stackTraceToString(e));              
	    	ActionErrors ae=new ActionErrors();
	    	ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
	    	saveErrors(request,ae);
			frm.setSurcharges(new ArrayList()); 
	    	request.setAttribute("RODBreakoutForm",frm);
	    }
	    return mapping.findForward("Success");
    }

    /**
     * This method saves the surcharges entered.
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
    	RODBreakoutForm frm=null;
    	try{
	    	EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
	    	frm=(RODBreakoutForm)form;
	    	
	    	RecSurchargesController rsc=new RecSurchargesController();
	    	Collection colScColl=frm.getSurcharges();
	    	Iterator iterScColl=colScColl.iterator();
	    	while(iterScColl.hasNext()){
	    	    GenericSurchargeVO gsVO=(GenericSurchargeVO)iterScColl.next();
	    	    
	    	    if(gsVO.getCollectedAmt()>0 || !gsVO.isNewSurcharge()){
	    	    
		    	    RecSurchargesVO rsVO=new RecSurchargesVO();
		    	    
		    	    rsVO.setRecId(new Integer(frm.getRecId()));
		    	    rsVO.setSurchargeCd(gsVO.getSurchargeCd());
		    	    rsVO.setAppliedAmt(gsVO.getCollectedAmt());
		    	    
		    	    if(gsVO.isNewSurcharge()){
		    	    	rsc.setRecSurcharges(rsVO);
		    	    }else{
		    	    	if (gsVO.getCollectedAmt()>0){
		    	    		rsc.updateRecSurcharges(rsVO);
		    	    	}else{
		    	    		rsc.removeRecSurcharges(new RecSurchargesPK(rsVO.getRecId(),rsVO.getSurchargeCd()));
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