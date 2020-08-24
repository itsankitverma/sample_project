/**
 * ExternalFilesImportingStatusAction.java
 * Created on 18 de diciembre de 2003, 18:52
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import java.io.*;
import java.util.*;
import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;

/**
 * @author  Arturo Gonzalez
 */
public class ExternalFilesImportingStatusAction extends Action implements Serializable{
    
    /** Creates a new instance of ExternalFilesImportingStatusAction */
    public ExternalFilesImportingStatusAction() {
    }
    
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
                                     
        try{
            if(request.getSession().getAttribute("userProfile")==null) return mapping.findForward("logout");
            CommonOpsBizDelegate biz    = new CommonOpsBizDelegate();
            Collection colExtFileStatus = null;
            
            String action = request.getParameter("action");
            
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
            
            if(action == null)
            {  colExtFileStatus=biz.getExternalFilesImportingStatus(ep.getEmployeeId());
               request.setAttribute("colExtFileStatus",colExtFileStatus);
            }else{
                  String id=request.getParameter("id");
                  Integer idInt=new Integer(id);

                  PymtImptLogVO errorLog = biz.getImportingExternalLog(idInt);
                  request.setAttribute("logError", errorLog);
                  
                  Collection detailsErrorLog = biz.getImportingExternalLogDetailsByLogId(idInt);

                Iterator i = detailsErrorLog.iterator();
                
                        while(i.hasNext())
                        {
                            PymtImptErrorDtlVO p = (PymtImptErrorDtlVO) i.next();
                        }

                  request.setAttribute("logErrorDetails", detailsErrorLog);
                  return mapping.findForward("Details");
            }
        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetDataFromDB"));
            saveErrors(request,ae);  
            request.setAttribute("colExtFileStatus",new ArrayList());
        }
       
       return mapping.findForward("Success");                         
    }
}
