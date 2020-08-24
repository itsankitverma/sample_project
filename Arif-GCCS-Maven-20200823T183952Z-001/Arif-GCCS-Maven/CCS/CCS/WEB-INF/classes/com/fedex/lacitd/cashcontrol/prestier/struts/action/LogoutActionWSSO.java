package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;

import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Properties;
import java.io.OutputStream;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.common.Utils;

/**
 * This class is used to manage the requests
 * for logout
 * @author  ccardenas
 */
public class LogoutActionWSSO extends Action implements java.io.Serializable{

    /**
     * This method is executed by Struts framework when a request to the
     * related URI is done. It has all the code to manage the logout of the
     * users
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

        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String serverURL;
        String logoutPath;
        String WSSOPath;

        if (serverPort==80)
            serverURL="http://" + serverName;
        else
            serverURL="http://" + serverName + ":" + serverPort;

        logoutPath = serverURL + "/logout.html";
        WSSOPath = serverURL + "/GCCS";

        try{
        	Properties prop = null;
            prop= Utils.getProperties("P");
            logoutPath = prop.getProperty("gccs.server.url");
        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            e.printStackTrace();
        }
        
        request.getSession().removeAttribute("userProfile");
        request.getSession().removeAttribute("AttemptNumber");
        request.getSession().removeAttribute("oldUserId");
        request.getSession().removeAttribute("comments");
        request.getSession().removeAttribute("countries");
        request.getSession().invalidate();

        String action = request.getParameter("accion");
        Constants.logger.debug("LogoutActionWSSO was called using action:"+action);
/*
        if("LOGOUT".equals(action)) //If logout was called
            response.sendRedirect(logoutPath);
        else {//GCCS time-out was reached
            URL url=new URL(logoutPath);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.connect();


            int code = con.getResponseCode();
            String msg = con.getResponseMessage();
            for (int n=1;; ++n) {
                if (con.getHeaderFieldKey(n) == null)
                    break;
                System.out.println(con.getHeaderFieldKey(n) + " " + con.getHeaderField(n));
            }
            ///////////////////////////////
            response.sendRedirect(WSSOPath);
        }
*/
        response.sendRedirect(logoutPath);
        return mapping.findForward("logout");
    }
}
