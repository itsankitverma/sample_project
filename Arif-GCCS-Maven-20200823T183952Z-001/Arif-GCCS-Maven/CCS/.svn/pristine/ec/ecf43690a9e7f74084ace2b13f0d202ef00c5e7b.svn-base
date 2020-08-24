/**
 * AddFTCReceivablesAction.java
 *
 * 
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.common.*;

import org.apache.struts.action.*;
import java.util.*;
import java.text.*;


/**
 * This Action class manage the requests from the Add/Reassign Awbs feature. * 
 * @author  ccardenas
 */
public class AddFTCReceivablesAction extends Action implements java.io.Serializable{
    public AddFTCReceivablesAction() {
    }

    private Collection addItem(Collection recs, ReceivablesByAwbVO rec)
    {
        Iterator it_1 = recs.iterator();

        while(it_1.hasNext())
        {
            ReceivablesByAwbVO rec_1 = (ReceivablesByAwbVO) it_1.next();

/*
            if(rec_1.getRecAwbNumber() != null && rec_1.getRecAwbNumber().equals( rec.getRecAwbNumber()) &&
               rec_1.getRecCustomerName() != null && rec_1.getRecCustomerName().equals( rec.getRecCustomerName()) &&
               rec_1.getStatusId() == rec.getStatusId() &&
               rec_1.getLocCd() != null && rec_1.getLocCd().equals( rec.getLocCd()) &&
               rec_1.getRecAmount() != null && rec_1.getRecAmount().equals( rec.getRecAmount()) &&
               rec_1.getRecDate() != null && rec_1.getRecDate().equals( rec.getRecDate()))
*/
            if(rec_1.getRecId() == rec.getRecId())
            
                return recs;
        }

        recs.add( rec);
        
        return recs;
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

        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");  
        if(ep==null) return mapping.findForward("CloseWindow");

        AddFTCReceivableForm frm=(AddFTCReceivableForm)form;

        if("FindReceivable".equals(request.getParameter("action"))){
            return findInvoices(mapping,form,request,response);
        }else if("CreateNew".equals(request.getParameter("action"))){
            return createNew(mapping,form,request,response);
        } else if("AssignThis".equals(request.getParameter("action"))){
            return assingThis(mapping,form,request,response);
        } else if("SaveAssignThis".equals(request.getParameter("action"))){
            return saveAssignThis(mapping,form,request,response);
        } else if("ShowToAssign".equals(request.getParameter("action"))){
            return showToAssign(mapping,form,request,response);
        } else if("ReassignReceivables".equals(request.getParameter("action"))){
            return reassignReceivables(mapping,form,request,response);
        } else {
            request.setAttribute("AddFTCReceivableForm",form);
            if (frm.getCurrencyCode()==null || "".equals(frm.getCurrencyCode())){
                 frm.setCurrencyCode(ep.getDefaultCurrency());
            }
            frm.setLocationCd(ep.getLocationCd());

            if(frm.getAwbs()==null) frm.setAwbs(new ArrayList());
            //creating 25 ReceivablesVO that will create the 25 text box in the page
            for(int idx=frm.getAwbs().size();idx<50;idx++)
                frm.getAwbs().add(new ReceivablesByAwbVO());

            return mapping.findForward("EnterAWBToFind");
        }
    }

    /**
     * This methods is run to find Receivables for one AWB nbr.
     * 
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */
    private ActionForward findInvoices(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
       try{
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");                   
            AddFTCReceivableForm frm=(AddFTCReceivableForm)form;
            FTCBizDelegate biz=new FTCBizDelegate();
            //find awbs

            //Finding all awbs in form
            Collection awbsToFind = frm.getAwbs();
            Collection colRec = new ArrayList();

            ActionErrors ae = new ActionErrors();

            if(!awbsToFind.isEmpty()){
                Iterator it = awbsToFind.iterator();
                ReceivablesByAwbVO rec = null;
                while (it.hasNext()){
                    rec = (ReceivablesByAwbVO) it.next();
                    if (rec.getRecAwbNumber()!=null && rec.getRecAwbNumber().trim().length()>0)
                    {
                        Collection awbs = addWithnoDuplicated(biz, colRec, rec, ae);

                        colRec =  (ArrayList) awbs;
                        //colRec.addAll(biz.getInvoicesByAwb(rec.getRecAwbNumber()));
                    }
                }
            }

            frm.setLocationCd(ep.getLocationCd());
            frm.setAwbs(new ArrayList(colRec));
            request.setAttribute("AddFTCReceivableForm",form);
            
/*
            if(colRec.isEmpty()){
               //if it does not exist show the page to create a new Receivable
               return mapping.findForward("CreateNewReceivable");                
            }else{
*/ {            
               //if it exist show the page to list the receivables	
               //request.setAttribute("listReceivables",colRec);

               saveErrors(request, ae);

               return mapping.findForward("ShowReceivables");                
            }
       }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);    
            return mapping.findForward("EnterAWBToFind");
       }
    }    
    
    /**
     * This methods is executed when the user needs to create a new Receivable.
     * 
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */
    private ActionForward createNew(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
         request.setAttribute("AddFTCReceivableForm",form);         
         return mapping.findForward("CreateNewReceivable");  
    }
    
    /**
     * This methods is executed when the user
     * select an AWB to be reassigned to a different coutier.
     * 
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */    
    private ActionForward assingThis(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
       AddFTCReceivableForm frm=null; 
       try{
            frm=(AddFTCReceivableForm)form;
            FTCBizDelegate biz=new FTCBizDelegate();
            CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate(); 
            SystemUtilsBizDelegate sysBiz=new SystemUtilsBizDelegate();
            
            //check if the location/courier entered exists in the db
            int result=bizComm.existsEmployeeLocation(frm.getLocationCd(),frm.getRecEmployeeId());
            
            switch(result){
                 case 0:    //Employee/Location already exist
                 		    break;
                 			
                 case 1: {
                 		    //Employee does not exist. The system will insert it
                            EmployeeVO empVO=sysBiz.findFedExEmployee(frm.getRecEmployeeId());
                            if(empVO==null){
                                empVO=new EmployeeVO(frm.getRecEmployeeId(),"Unknown Employee","","","FTC",new java.util.Date(),"0",0,null,0,0,null,1);
                            }    
                            new EmployeeController().setEmployee(empVO);                            
                            
                            ActionErrors ae=new ActionErrors();
                            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.EmployeeNonExist",frm.getRecEmployeeId()));
                            saveErrors(request,ae);                                
                            request.setAttribute("AddFTCReceivableForm",frm);
                            return mapping.findForward("ShowError"); 
                         }   
                            
                 default:{
                 		 //location does not exist. Show the error.
                         ActionErrors ae=new ActionErrors();
                         ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.LocationNonExist",frm.getLocationCd()));
                         saveErrors(request,ae);    
                         request.setAttribute("AddFTCReceivableForm",frm);
                         return mapping.findForward("ShowToAssign");                     
                         }
                }            

                //update the AWB with the new employee/location

                /*
                    Issue 136
                    Jorge Quiroz
                 */

                int ret = biz.reassignReceivableToCourier(frm.getRecId(),frm.getLocationCd(),frm.getRecEmployeeId());

                if (ret == 0){
                    request.setAttribute("submitParent","submitParent");
                    return mapping.findForward("CloseWindow");
                }
                else {
                	//could not reassign? show the error.
                    ActionErrors ae=new ActionErrors();
                    if (ret == -2)
                         ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.AwbStatusshouldNotBeClear", frm.getRecAwbNumber()));
                    else
                         ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotReassingReceivableToCourier"));
                    saveErrors(request,ae);
                    request.setAttribute("AddFTCReceivableForm",frm);
                    return mapping.findForward("ShowToAssign");
                }
       }catch(Exception e){
                Constants.logger.debug(Utils.stackTraceToString(e));
                ActionErrors ae=new ActionErrors();
                ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotReassingReceivableToCourier"));
                saveErrors(request,ae);    
                request.setAttribute("AddFTCReceivableForm",frm);
                return mapping.findForward("ShowToAssign"); 
       }
    } 
    
    /**
     * This methods is executed when the user
     * enter a new Receivable.
     * 
     * @param    mapping object
     * @param    form object
     * @param    request object
     * @param    response object
     * @return   Struts action forward 
     * @exception Exception
     */     
    private ActionForward saveAssignThis(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
       AddFTCReceivableForm frm=null;
       try{
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");                   
            frm=(AddFTCReceivableForm)form;
            FTCBizDelegate biz=new FTCBizDelegate();
            CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate(); 
            SystemUtilsBizDelegate sysBiz=new SystemUtilsBizDelegate();
            
            FTC_ReceivablesVO recVO=new FTC_ReceivablesVO();
            
            //check if the location/courier entered exists in the db
            int result=bizComm.existsEmployeeLocation(frm.getLocationCd(),frm.getRecEmployeeId());
            
            switch(result){
                 case 0: //Employee/Location already exist
                 		 break;
                 case 1: {
                 			//Employee does not exist. The system will insert it
                            EmployeeVO empVO=sysBiz.findFedExEmployee(frm.getRecEmployeeId());
                            if(empVO==null){
                                empVO=new EmployeeVO(frm.getRecEmployeeId(),"Unknown Employee","","","FTC",new java.util.Date(),"0",0,null,0,0,null,1);
                            }    
                            new EmployeeController().setEmployee(empVO);  
                            
                            ActionErrors ae=new ActionErrors();
                            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.EmployeeNonExist",frm.getRecEmployeeId()));
                            saveErrors(request,ae);    
                            request.setAttribute("AddFTCReceivableForm",frm);
                            return mapping.findForward("ShowError"); 
                         } 
                 default:{
                 		 //location does not exist. Show the error.
                         ActionErrors ae=new ActionErrors();
                         ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.LocationNonExist",frm.getLocationCd()));
                         saveErrors(request,ae);    
                         request.setAttribute("AddFTCReceivableForm",frm);
                         return mapping.findForward("ShowToAssign");                     
                         }
           }            

        
                SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
                frm.setRecDate(sdf.parse(frm.getRecDateText()));

                recVO.setAwbNbr(frm.getRecAwbNumber());
                recVO.setInvCurrency(frm.getCurrencyCode());
                recVO.setCustomerNm(frm.getRecCustomerName());
                recVO.setEmployeeId(frm.getRecEmployeeId());
                recVO.setRecNbr(frm.getRecNumber());
                
                recVO.setRecAmt(frm.getRecAmount());
                recVO.setLocationCd(frm.getLocationCd());
                recVO.setExchRateClnUsed(frm.getExchangeRateUsed());            
                recVO.setRecDt(frm.getRecDate());   
                
                //insert the AWB  
                if (biz.addFTC_Receivable(recVO)){
                    request.setAttribute("submitParent","submitParent");                    
                    return mapping.findForward("CloseWindow");                
                }else{
                	//could not reassign? show the error.
                    ActionErrors ae=new ActionErrors();
                    ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotCreateInvoice"));
                    saveErrors(request,ae);    
                    request.setAttribute("AddFTCReceivableForm",frm);
                    return mapping.findForward("CreateNewReceivable");
                }
       }catch(ParseException e){
                Constants.logger.debug(Utils.stackTraceToString(e));
                ActionErrors ae=new ActionErrors();
                ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.MustEnterAValidDate"));
                saveErrors(request,ae);    
                request.setAttribute("AddFTCReceivableForm",frm);                
                return mapping.findForward("CreateNewReceivable");
       }catch(Exception e){
                Constants.logger.debug(Utils.stackTraceToString(e));
                ActionErrors ae=new ActionErrors();
                ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotCreateInvoice"));
                saveErrors(request,ae);    
                request.setAttribute("AddFTCReceivableForm",frm);                
                return mapping.findForward("CreateNewReceivable");
       }
    }    
    
    /**
     * This methods is executed when the user
     * select a Receivable to the shown. It shows the 
     * Receivable
     * 
     * @param    Struts action mapping object
     * @param    Struts action form object 
     * @param    http request object
     * @param    http response object
     * @return   Struts action forward 
     * @exception Exception
     */    
    private ActionForward showToAssign(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
       try{
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");              
            AddFTCReceivableForm frm=(AddFTCReceivableForm)form;
            FTCBizDelegate biz=new FTCBizDelegate();
            
            //get the Receivable
            FTC_ReceivablesVO recVO=biz.getFTC_Receivables(frm.getRecId());
            
            //assign the data to the form fields
            frm.setRecAwbNumber(recVO.getAwbNbr());
            frm.setCurrencyCode(recVO.getInvCurrency());
            frm.setRecCustomerName(recVO.getCustomerNm());            
            frm.setRecNumber(recVO.getRecNbr());
            frm.setRecAmount(recVO.getRecAmt());
            
            if(frm.getRecEmployeeId()==null || frm.getRecEmployeeId().length()<5){
               frm.setRecEmployeeId(recVO.getEmployeeId());
            }    
            
            frm.setLocationCd(ep.getLocationCd());            
            frm.setRecDate(recVO.getRecDt());
            frm.setRecDateText(new SimpleDateFormat("MM/dd/yyyy").format(frm.getRecDate()));
            
            
            request.setAttribute("AddFTCReceivableForm",frm);            
            return mapping.findForward("ShowToAssign");                
       }catch(Exception e){
                Constants.logger.debug(Utils.stackTraceToString(e));
                ActionErrors ae=new ActionErrors();
                ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotShowInvoiceToAssign"));
                saveErrors(request,ae);    
                return findInvoices(mapping,form,request,response);
       }
    }          

    private ActionForward reassignReceivables(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
       AddFTCReceivableForm frm=null;


       try{
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
            frm=(AddFTCReceivableForm)form;
            FTCBizDelegate biz=new FTCBizDelegate();
            CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate();
            SystemUtilsBizDelegate sysBiz=new SystemUtilsBizDelegate();

            Collection recs = frm.getAwbs();
            ArrayList recsNew = new ArrayList();
            FTC_ReceivablesVO recVO = null;
            ReceivablesByAwbVO rec = null;

            //check if the location/courier entered exists in the db
            int result=bizComm.existsEmployeeLocation(frm.getLocationCd(),frm.getRecEmployeeId());

            switch(result){
                 case 0: //Employee/Location already exist
                 		 break;
                 case 1: {
                 			//Employee does not exist. The system will insert it
                            EmployeeVO empVO=sysBiz.findFedExEmployee(frm.getRecEmployeeId());
                            if(empVO==null){
                                empVO=new EmployeeVO(frm.getRecEmployeeId(),"Unknown Employee","","","FTC",new java.util.Date(),"0",0,null,0,0,null,1);
                            }
                            new EmployeeController().setEmployee(empVO);

                            ActionErrors ae=new ActionErrors();
                            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.EmployeeNonExist",frm.getRecEmployeeId()));
                            saveErrors(request,ae);
                            request.setAttribute("AddFTCReceivableForm",frm);
                            return mapping.findForward("ShowError");
                         }
                 default:{
                 		 //location does not exist. Show the error.
                         ActionErrors ae=new ActionErrors();
                         ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.LocationNonExist",frm.getLocationCd()));
                         saveErrors(request,ae);
                         request.setAttribute("AddFTCReceivableForm",frm);
                         return mapping.findForward("ShowReceivables");
                         }
            }


            ActionErrors ae=new ActionErrors();
            Iterator it = recs.iterator();
            while(it.hasNext())
            {
                rec = (ReceivablesByAwbVO)it.next();
                if(rec.isSelected())
                {
                    //Tries to reassign REC, if not possible errors are added to actionError object
                    int ret = biz.reassignReceivableToCourier(rec.getRecId(),frm.getLocationCd(),frm.getRecEmployeeId());

                    //update the AWB with the new employee/location

                    /*
                        Issue 136
                        Jorge Quiroz
                    */
                    if (ret<0)
                    {
                	    //could not reassign? show the error.
                        if(ret==-2)
                            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.AwbStatusshouldNotBeClear", "" + rec.getRecAwbNumber()));
                        else
                            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotReassingReceivableToCourier"));

                        saveErrors(request,ae);
                    }
                }

                //Collection awbs = addWithnoDuplicated(biz, recsNew, rec);

                //recsNew =  (ArrayList) awbs;
            }

           return findInvoices(mapping,form,request,response);
           // return mapping.findForward("ShowReceivables");

       }catch(Exception e){
                Constants.logger.debug(Utils.stackTraceToString(e));
                ActionErrors ae=new ActionErrors();
                ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotReassingReceivableToCourier"));
                saveErrors(request,ae);
                request.setAttribute("AddFTCReceivableForm",frm);
                return mapping.findForward("ShowToAssign");
       }
    }

    private Collection addWithnoDuplicated(FTCBizDelegate biz, Collection recsNew, ReceivablesByAwbVO rec, ActionErrors ae) throws BizDelegateException {
        Collection awbs = new ArrayList();

        Collection list = biz.getInvoicesByAwb(rec.getRecAwbNumber());

        if(list.size() == 0)
        {
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.AwbNoExist", rec.getRecAwbNumber()));

            return recsNew;
        }

        Iterator items = list.iterator();

        while (items.hasNext())
        {
            ReceivablesByAwbVO item = (ReceivablesByAwbVO) items.next();

            awbs = addItem( recsNew, item);
        }

        return awbs;
    }
}