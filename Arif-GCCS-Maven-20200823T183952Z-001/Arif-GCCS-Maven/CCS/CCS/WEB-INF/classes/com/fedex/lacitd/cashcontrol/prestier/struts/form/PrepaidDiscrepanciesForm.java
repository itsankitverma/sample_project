package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.PrepPoaBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.exception.BizDelegateException;
import com.fedex.lacitd.cashcontrol.prestier.helper.ValidateExpressionsUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Prepaid Discrepancies screen form class
 * @author  ccardenas
 */
public class PrepaidDiscrepanciesForm extends ActionForm implements java.io.Serializable{
    private Integer pageNumber;
    private List dscr=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new PrepaidDscrTableVO();
                                                                          }
                                                                       } );


    public PrepaidDiscrepanciesForm() {
    }

    public void setPrepaidDscr(List dscr){
        this.dscr = ListUtils.lazyList(dscr,new Factory() {
                                                                        public Object create() {
                                                                           return new PrepaidDscrTableVO();
                                                                        }
                                                                     } );
    }

    public List getPrepaidDscr(){
        return dscr;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request)
    {
       ActionErrors errors = super.validate(mapping, request);
       ValidateExpressionsUtil valUtil = ValidateExpressionsUtil.getInstance();

       try {
           if (errors == null) errors = new ActionErrors();

           String expressions[] = {"JavaScriptInjection.bl"};

           Collection dscr = getPrepaidDscr();
           Iterator iter = dscr.iterator();
           if(iter.hasNext())
           {
               while (iter.hasNext()) {
                    PrepaidDscrTableVO dep = (PrepaidDscrTableVO) iter.next();

                    if(!valUtil.isValid(expressions,dep.getComments()))
                    {
                        errors.add("oldComment",new ActionError("wl.error.noValidChars"));
                        break;
                    }

               }

               EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
               Integer pageNumber = getPageNumber();
               if(pageNumber == null)
                        pageNumber = new Integer(1); //First page

               PrepPoaBizDelegate bizPrP = new PrepPoaBizDelegate();
               Hashtable result =  bizPrP.getPrepaidDiscrepanciesTable(ep.getLocationCd(),pageNumber);
                           List dscrRS = (List) result.get("RESULTSET");
               PrepaidDiscrepanciesForm ccrForm = new PrepaidDiscrepanciesForm();
               ccrForm.setPrepaidDscr(dscrRS);
               ccrForm.setPageNumber(pageNumber);

               request.setAttribute("PrepaidDiscrepanciesForm", ccrForm);
               request.setAttribute("numberOfPages", result.get("NUMBEROFPAGES"));
           }
       }catch (BizDelegateException e)
        {
            e.printStackTrace();
        }

       return errors;
    }

}
