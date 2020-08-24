package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.RODBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.CommonOpsBizDelegate;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.ErrorForm;

import java.util.Collection;
import java.util.ArrayList;

import weblogic.logging.NonCatalogLogger;

/**
 * Created by IntelliJ IDEA.
 * User: 684195
 * Date: Apr 25, 2008
 * Time: 9:47:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class ErrorAction  extends Action implements java.io.Serializable {

    private static NonCatalogLogger logger = new NonCatalogLogger("Global_Cash_Control_System");

    public ActionForward execute(ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response)
    throws Exception
    {
        ErrorForm frm = (ErrorForm) form;

        Exception ex = (Exception)request.getAttribute("exception");


        if(ex != null)
            logger.debug( ex.getMessage(), ex);

        
        return mapping.findForward("show");
    }
}
