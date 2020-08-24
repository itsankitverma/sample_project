/*
 * CreditCardPymtAction.java
 *
 * Created on 16 de julio de 2002, 04:57 PM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.CosmosCCUtils;
import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;
import org.apache.struts.action.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * This class is used to manage the
 * request to show the Credit Card Payments
 * batchs 
 * @author  ccardenas
 */
public class CreditCardPymtReportAction extends Action implements java.io.Serializable{
    public CreditCardPymtReportAction() {
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
            EmployeeProfile ep = (EmployeeProfile)request.getSession().getAttribute("userProfile");

            String employeeId = ep.getEmployeeId();
            String locationCd = ep.getLocationCd();

            CommonOpsBizDelegate bizComm=new CommonOpsBizDelegate();

            String entityCd = request.getParameter("entityCd");
            String startDateTxt = request.getParameter("reportDate");
            String endDateTxt = request.getParameter("endDate");
            Date startDate = null;
            Date endDate = null;
            ArrayList recList = null;
            ArrayList preList = null;

            CreditCardPymtReportVO creditCardPymtVO = null;
            CreditCardReportVO creditCardVO = null;

            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");


            if(startDateTxt!=null)
                startDate = sdf.parse(startDateTxt);
            if(endDateTxt!=null)
                endDate = sdf.parse(endDateTxt);

            bizComm.saveCreditCardPymtLog(employeeId, entityCd, locationCd, startDateTxt, endDateTxt);
            HashMap pymts = bizComm.getCreditCardPymt(entityCd,startDate,endDate);

            recList = new ArrayList((Collection)pymts.get("RECEIVABLES"));
            preList = new ArrayList((Collection)pymts.get("PREPAID"));

            CosmosCCUtils cosmosCCUtils = new CosmosCCUtils();

            //Getting information of Credit Card from eCQS

            for (int i=0; i<recList.size(); i++) {
                creditCardVO = new CreditCardReportVO();
                creditCardPymtVO = (CreditCardPymtReportVO)recList.get(i);
                creditCardVO.setAwbNbr(creditCardPymtVO.getAwbNbr());
                creditCardVO = cosmosCCUtils.getRODCCInfo(creditCardVO);
                creditCardPymtVO.setCreditCardNbr(creditCardVO.getCreditCardNbr());
                creditCardPymtVO.setCreditCardExpDt(creditCardVO.getCreditCardExpDt());
                recList.set(i,creditCardPymtVO);
            }

            //Getting information of Credit Card from eCQS
            for (int j=0; j<preList.size(); j++) {
                creditCardVO = new CreditCardReportVO();
                creditCardPymtVO = (CreditCardPymtReportVO)preList.get(j);
                creditCardVO.setAwbNbr(creditCardPymtVO.getAwbNbr());
                creditCardVO = cosmosCCUtils.getPrepaidCCInfo(creditCardVO);
                creditCardPymtVO.setCreditCardNbr(creditCardVO.getCreditCardNbr());
                creditCardPymtVO.setCreditCardExpDt(creditCardVO.getCreditCardExpDt());
                preList.set(j,creditCardPymtVO);
            }

            request.setAttribute("pymtRODList", pymts.get("RECEIVABLES"));
            request.setAttribute("pymtPREPAIDList", pymts.get("PREPAID"));
            request.setAttribute("pymtOACList", pymts.get("OAC"));
            request.setAttribute("pymtPOAList", pymts.get("POA"));
            request.setAttribute("pymtOTHERList", pymts.get("OTHER"));
            request.setAttribute("pymtGROUNDList", pymts.get("GROUND"));
            if(startDateTxt!=null) request.setAttribute("startDate",startDateTxt);
            if(endDateTxt!=null) request.setAttribute("endDate",endDateTxt);


            return mapping.findForward("Success");
        }    
}