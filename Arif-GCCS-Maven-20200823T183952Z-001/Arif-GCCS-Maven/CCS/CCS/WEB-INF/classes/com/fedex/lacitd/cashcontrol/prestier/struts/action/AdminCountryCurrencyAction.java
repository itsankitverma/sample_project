/**
 * AdminCountryCurrencyAction.java
 *
 * Created on June 3, 2003, 11:27 AM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.LogEventHelper;
import com.fedex.lacitd.cashcontrol.biztier.common.*;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.common.monitoring.*;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.datatier.controller.CountryController;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import org.apache.struts.action.*;
import java.util.ArrayList;
import java.io.Serializable;
import javax.servlet.http.*;

/**
 * @author  Arturo Gonzalez
 */
public class AdminCountryCurrencyAction extends Action implements Serializable {
    
    AdminBizDelegate abd = new AdminBizDelegate();
    
    /** Creates a new instance of AdminLocationAction **/
    public AdminCountryCurrencyAction() {
    }
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        AdminCountryCurrencyForm frm       = null;
        ActionForward actionForward = null;
        String action               = request.getParameter("action");
        
        EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");
        if(ep==null) return mapping.findForward("logout");
        
        if(form==null)
        {  frm=new AdminCountryCurrencyForm();
        }else    
            frm=(AdminCountryCurrencyForm)form;
        
        //Get All locations fron DataBase callin to the AdminLocationAction
        AdminLocationAction ala=new AdminLocationAction();
        ArrayList locations = (ArrayList)ala.getAllLocations(request);
        
        frm.setLocations(locations);        

        if(action.equals("getCountryCurrency"))
        {  
           if((frm.getCountryCd()== null) || (frm.getCountryCd().length()==0))
           {   frm.setCountryCd(request.getParameter("countryCd"));
               frm.setLocationCd(request.getParameter("locationCd"));
           }else{
                 frm.setCountryCd(geCountryFromtLocation(frm.getLocationCd(),request));
                }
           getCountryCurrency(frm, request);
           request.setAttribute("AdminCountryCurrencyForm",frm);
           actionForward = mapping.findForward("ShowCountryCurrencyData");
        }else if(action.equals("updateCountryCurrency"))
         {  updateCountryCurrency(frm,request);
            getCountryCurrency(frm, request);
            actionForward = mapping.findForward("SavedCountryCurrency"); 
         }
        return actionForward;
    }
    
    private void getCountryCurrency(AdminCountryCurrencyForm frm, HttpServletRequest request)
    {   ActionErrors ae = new ActionErrors();
        try{
            CountryConfigVO countryCurrency=abd.getCountryCurrency(frm.getCountryCd());
            CountryVO cVO=new CountryController().getCountry(frm.getCountryCd());
            if(countryCurrency==null || countryCurrency.getCurrencyCd()==null)
            {
                    frm.setCntryCurrencyId(null);
                    frm.setCountryCd( cVO.getCountryCd());
                    frm.setCurrencyCd(null);
                    frm.setCurrencyNm(null);
                    frm.setCurrencySymbol(null);
                    frm.setExchRateMax(0);
                    frm.setExchRateMin(0);
                    frm.setDtrcUpldFlg(0);
                    frm.setCashUpldFlg(0);
                    frm.setWoffUpldFlg(0);
                    frm.setPsOperId(null);
                    frm.setOperation("I");
                    frm.setCheck(false);
            }else{
                    frm.setCntryCurrencyId(countryCurrency.getCntryCurrencyId());
                    frm.setCountryCd(countryCurrency.getCountryCd());
                    frm.setCurrencyCd(countryCurrency.getCurrencyCd());
                    frm.setCurrencyNm(countryCurrency.getCurrencyNm());
                    frm.setCurrencySymbol(countryCurrency.getCurrencySymbol());
                    frm.setExchRateMax(countryCurrency.getExchRateMax());
                    frm.setExchRateMin(countryCurrency.getExchRateMin());
                    frm.setDtrcUpldFlg(countryCurrency.getDtrcUpldFlg());
                    frm.setCashUpldFlg(countryCurrency.getCashUpldFlg());
                    frm.setWoffUpldFlg(countryCurrency.getWoffUpldFlg());
                    frm.setPsOperId(countryCurrency.getPsOperId());
                    frm.setOperation("U");
                    frm.setCheck(true);
                }
            frm.setQuickStatus(cVO.getQuickApplyFlg());
            frm.setActGroundFlg(cVO.getGndUsedFlag());
            frm.setActOACFlg(cVO.getOacUsedFlag());
            frm.setActCollectlaterFlg(cVO.getCollectlaterFlag());
            frm.setActCODFlg(cVO.getCodUsedFlag());
            frm.setActFTCFlg(cVO.getFtcUsedFlag());
                        
            frm.setScanUsdDecimals(cVO.getScanUsdDecNbr());
            frm.setScanLocalDecimals(cVO.getScanLocalDecNbr());
        }catch(Exception e)
          { Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetCountryCurrency"));
            saveErrors(request, ae);
          }
    }
    
    private void updateCountryCurrency(AdminCountryCurrencyForm frm, HttpServletRequest request)
    {   ActionErrors ae     = new ActionErrors();
        String operation    = null;
        try{
            CountryCurrencyVO countryCurrency = new CountryCurrencyVO();
            countryCurrency.setCntryCurrencyId(frm.getCntryCurrencyId());
            countryCurrency.setCountryCd(frm.getCountryCd());
            countryCurrency.setCurrencyCd(frm.getCurrencyCd());
            countryCurrency.setCurrencyNm(frm.getCurrencyNm());
            countryCurrency.setCurrencySymbol(frm.getCurrencySymbol());
            countryCurrency.setExchRateMax(frm.getExchRateMax());
            countryCurrency.setExchRateMin(frm.getExchRateMin());            

            abd.updateCountryCurrency(countryCurrency, frm.getOperation());
            
            CountryController cc=new CountryController();
            CountryVO cVO=cc.getCountry(frm.getCountryCd());
            cVO.setQuickApplyFlg(frm.getQuickStatus());
            cVO.setScanUsdDecNbr(frm.getScanUsdDecimals());
            cVO.setScanLocalDecNbr(frm.getScanLocalDecimals());
            cVO.setGndUsedFlag(frm.getActGroundFlg());
            cVO.setOacUsedFlag(frm.getActOACFlg());
            cVO.setCodUsedFlag(frm.getActCODFlg());
            cVO.setFtcUsedFlag(frm.getActFTCFlg());
            cVO.setCollectlaterFlag(frm.getActCollectlaterFlg());
            cc.updateCountry(cVO);

            abd.updateCountryFlags(cVO.getCountryCd(),frm.getDtrcUpldFlg(),frm.getCashUpldFlg(),frm.getWoffUpldFlg(),frm.getPsOperId());

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "AdminCountryCurrencyAction updateCountryCurrency()", frm.getCountryCd(), true);

        }catch(Exception e)
          {Constants.logger.debug(Utils.stackTraceToString(e));
           ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotSaveCountryCurrency"));
           saveErrors(request, ae);

           LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "AdminCountryCurrencyAction updateCountryCurrency()", frm.getCountryCd(), false);
          }
    }   
    
    private String geCountryFromtLocation(String locationCd, HttpServletRequest request)
    {   
        ActionErrors ae = new ActionErrors();
        String countryCd = null;
        
        try{
            countryCd = abd.getLocation(locationCd).getCountryCd();
        }catch(Exception e)    
         {  Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.CouldNotGetLocation"));
            saveErrors(request, ae);
         }
            
       return countryCd;
    }
}
