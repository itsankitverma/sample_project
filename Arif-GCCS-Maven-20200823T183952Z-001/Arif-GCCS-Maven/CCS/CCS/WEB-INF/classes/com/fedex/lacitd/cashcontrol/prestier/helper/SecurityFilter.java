package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.SystemUtilsBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Part;
import javax.naming.Context;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * Autor: Andres Vasquez
 * Date: 18-04-2007
 * Time: 10:30:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class SecurityFilter extends HttpServlet implements Filter {
   private FilterConfig filterConfig;
   private String error_page;


   public void init(FilterConfig filterConfig)
      throws ServletException {
      this.filterConfig = filterConfig;

      if (filterConfig != null) {
           error_page = filterConfig.getInitParameter("error_page");
      }
      SystemUtilsBizDelegate biz = new SystemUtilsBizDelegate();
      HashMap map;
      try{
            map = biz.getUrlsAndRoles();

            ServletContext application = filterConfig.getServletContext();
            application.setAttribute("URLAccess", map);
      }catch(Exception e){
         e.printStackTrace();
      }
   }

   /*
    public void init(FilterConfig filterConfig)
      throws ServletException {
      this.filterConfig = filterConfig;
   }
     */

   //Process the request/response pair
   public void doFilter(ServletRequest request,
                        ServletResponse response,
                        FilterChain filterChain) {
   try {
       ServletContext application = filterConfig.getServletContext();
       HashMap mapURLAccess = (HashMap)application.getAttribute("URLAccess");


       String URI = ((HttpServletRequest)request).getRequestURI();
       String urlAccess = URI.substring(5,URI.indexOf(".do")) + ".do";


       EmployeeProfile ep=(EmployeeProfile)((HttpServletRequest)request).getSession().getAttribute("userProfile");
       // Only filter this request if it is multipart encoding

       boolean access = true;
       if (ep != null && !ep.isAdmin() && mapURLAccess.containsKey(urlAccess))
       {
            String locCd = ep.getLocationCd();

            if (locCd != null)
            {
                Map mapRol = null;
                if (ep.getLocationsRoles().size() == 1)
                    mapRol = (Map)ep.getLocationsRoles();
                else if (ep.getLocationsRoles().containsKey(locCd))
                    mapRol = (Map)ep.getLocationsRoles().get(locCd);


                    if (mapRol == null)
                    {
                         access = false;
                    } else
                    {
                        access = false;
                        ArrayList listAccess = ((ArrayList)mapURLAccess.get(urlAccess));
                        Iterator iter = listAccess.iterator();
                        for (;iter.hasNext();)
                        {
                            Integer rolAccess = (Integer)iter.next();
                            Integer myRol = (Integer)mapRol.values().iterator().next();
                            if (rolAccess.equals(myRol))
                            {
                                access = true;
                                break;
                            }
                        }


                    }

            }
       }


       if (access)
            filterChain.doFilter(request, response);
       else
            ((HttpServletResponse)response).sendRedirect(error_page);

   } catch (ServletException sx) {
      filterConfig.getServletContext().log(sx.getMessage());
   } catch (IOException iox) {
      filterConfig.getServletContext().log(iox.getMessage());
   }
}

}