package com.fedex.lacitd.cashcontrol.prestier.servlets.error;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.config.ExceptionConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

/**
 * Created by IntelliJ IDEA.
 * User: 684195
 * Date: Apr 24, 2008
 * Time: 5:31:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnHandledException extends org.apache.struts.action.ExceptionHandler
{
        public ActionForward execute( Exception ex,
                                      ExceptionConfig exConfig,
                                      ActionMapping mapping,
                                      ActionForm formInstance,
                                      HttpServletRequest request,
                                      HttpServletResponse response
          ) throws ServletException {

            request.setAttribute("exception", ex);

            return mapping.findForward("error");
        }
}
