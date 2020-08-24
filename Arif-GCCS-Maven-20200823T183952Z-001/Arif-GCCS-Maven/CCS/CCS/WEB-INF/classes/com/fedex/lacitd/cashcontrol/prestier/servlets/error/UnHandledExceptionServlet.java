package com.fedex.lacitd.cashcontrol.prestier.servlets.error;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.config.ExceptionConfig;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;

import weblogic.logging.NonCatalogLogger;

/**
 * Created by IntelliJ IDEA.
 * User: 684195
 * Date: Apr 24, 2008
 * Time: 2:40:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnHandledExceptionServlet extends HttpServlet {

        private static NonCatalogLogger logger = new NonCatalogLogger("Global_Cash_Control_System");

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            logger.debug("Handling exception in ErrorHandlerServlet");

            Throwable exception = null;

            // Check if struts has placed an exception object in request
            Object obj = request.getAttribute(Globals.EXCEPTION_KEY);

            if (obj == null) {
            // Since no struts exception is found,
            // check if a JSP exception is available in request.
            obj = request.getAttribute("javax.servlet.jsp.jspException");
            }

            if ((obj != null) && (obj instanceof Throwable)) {
            exception = (Throwable) obj;
            }

            logger.debug("Request URI: " + request.getAttribute("javax.servlet.forward.request_uri"));

            // request uri containing the original URL value will be available
            // only on servers implementing servlet 2.4 spec
            String requestURI = (String) request.getAttribute("javax.servlet.forward.request_uri");

            logger.error("Exception while handling request: " + requestURI, exception);
            response.sendRedirect("pages/Error.jsp");
        } catch (Exception e) {
            // Throwing exceptions from this method can result in request
            // going in to an infinite loop forwarding to the error servlet recursively.
            e.printStackTrace();
        }
        }
}
