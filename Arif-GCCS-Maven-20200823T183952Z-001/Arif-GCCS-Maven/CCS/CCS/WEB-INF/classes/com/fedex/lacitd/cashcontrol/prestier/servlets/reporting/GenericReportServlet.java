package com.fedex.lacitd.cashcontrol.prestier.servlets.reporting;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.w3c.dom.Document;
import org.apache.fop.apps.Driver;
import org.apache.fop.messaging.MessageHandler;
import org.apache.fop.tools.xslt.XSLTransform;
import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.avalon.framework.logger.Logger;
import javax.xml.parsers.*;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;

/**
 * An abstract class encapsulating the Postcript
 * and PDF generation with XSL:FO. All the reporting servlets must
 * extend this class and implement the getXMLInputStream method
 * to produce the XML used in the report.
 *
 * @author  Cristian Cardenas
 */
public abstract class GenericReportServlet extends HttpServlet {
    Logger log = null;
                               
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException {    
          doGet(request,response);
    }                          

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException {
        if(log == null) {
	     log = new ConsoleLogger(ConsoleLogger.LEVEL_WARN);
	     MessageHandler.setScreenLogger(log);
        }
        try {            
            InputStream is=getXMLInputStream(request,response);
            renderXML(is,getServletContext().getResourceAsStream(request.getParameter("StyleSheet")),request.getParameter("Format"),response);            
        } catch (ServletException ex) {
            throw ex;
        }
        catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    public void renderXML(InputStream xml,InputStream xsl,
                         String format,HttpServletResponse response) throws ServletException {
        try {

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            Driver driver = new Driver();            
            /*--If PS or PDF is requested--*/
            if("PS".equalsIgnoreCase(format)){            
                response.setContentType("application/postcript");
                driver.setRenderer(Driver.RENDER_PS);
            }else{
                response.setContentType("application/pdf");
                driver.setRenderer(Driver.RENDER_PDF);                
            }    
            
            driver.setLogger(log);            
            driver.setOutputStream(out);


            /*-Produce and Document from the xml-*/
            Document docXML=DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);

            /*-Create the target Document-*/
            Document docFO=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            /*-Execute the transformation to obtain the XSL:FO result-*/
            XSLTransform.transform(docXML,xsl,docFO);

            /*-Render the document-*/
            driver.render(docFO);
            
            /*-Send the response to the browser-*/
            byte[] content = out.toByteArray();
            response.setContentLength(content.length);
            response.getOutputStream().write(content);
            response.getOutputStream().flush();
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
    
    /**
     * Method to be implemented by the subclasses.
     */
    public abstract InputStream getXMLInputStream(HttpServletRequest request,HttpServletResponse response)throws ServletException;

}
