/*
 * DataHarvestTasksAction.java
 *
 * Created on 16 de julio de 2002, 04:57 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RodFileProcLogVO;

/** 
 * This class is in charge of get the ROD xml file
 * importing logs to show the status of the imported files
 * 
 * @author  ccardenas
 */
public class RodFileImpStatusAction extends Action implements java.io.Serializable{
	
	/**
	 * This method is executed by Struts framework when a request to the
	 * related URI is done. It has all the code to get the logs for the
	 * imported ROD files. 
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
        try{
        	if(request.getSession().getAttribute("userProfile")==null) return mapping.findForward("logout");
        	EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
        	RODBizDelegate biz=new RODBizDelegate();
        	
        	if("Details".equals(request.getParameter("action"))){
        		request.setAttribute("colRodFileDetails",biz.getRodFilesImportingDetails(Integer.parseInt(request.getParameter("logId"))));
        		return mapping.findForward("Details");
        	}
            
            Collection colRodFileStatus=biz.getRodFilesImportingStatus(ep.getEmployeeId());
            Iterator iterLogs=colRodFileStatus.iterator();
            String prevFileNm="";
            RodFileProcLogVO currFile=null;
            while(iterLogs.hasNext()){
            	RodFileProcLogVO rVO=(RodFileProcLogVO)iterLogs.next();
            	
            	if(!prevFileNm.equals(rVO.getFileNm())){
            		currFile=rVO;
            	}else{
            		currFile.setLocationCd(currFile.getLocationCd()+" "+rVO.getLocationCd());
            		currFile.setAwbQty(currFile.getAwbQty()+rVO.getAwbQty());
            		currFile.setTotalLocalAmt(currFile.getTotalLocalAmt()+rVO.getTotalLocalAmt());
            		currFile.setTotalUsdAmt(currFile.getTotalUsdAmt()+rVO.getTotalUsdAmt());
            		iterLogs.remove();
            	}
            	
            	prevFileNm=rVO.getFileNm();
            }
            
            request.setAttribute("colRodFileStatus",colRodFileStatus);
        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));            
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);  
            request.setAttribute("colRodFileStatus",new ArrayList());
            
        }
        
        return mapping.findForward("Success");
     
    }
    
}