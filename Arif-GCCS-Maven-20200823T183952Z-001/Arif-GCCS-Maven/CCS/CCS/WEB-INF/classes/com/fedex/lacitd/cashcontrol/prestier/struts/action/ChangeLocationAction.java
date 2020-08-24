/**
 * ChangeLocationAction.java
 *
 * 
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import java.util.*;

import com.fedex.lacitd.cashcontrol.common.*;

/** 
 *This class is used to manage the request for the 
 *Change Location feature.
 */
public class ChangeLocationAction extends Action implements java.io.Serializable{
	
	/**
	 * This methods is run by Struts framework when a request to the
	 * related URI is done. It has the code to change the location
	 * of the logger user.
	 *
	 * @param    mapping object
	 * @param    form object
	 * @param    request object
	 * @param    response object
	 * @return   Struts action forward 
	 * @exception Exception
	 */	
    public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws Exception {
        
        CommonOpsBizDelegate commonOps = new CommonOpsBizDelegate();
        SystemUtilsBizDelegate sysUtils   = new SystemUtilsBizDelegate();
        AdminBizDelegate adminBiz = new AdminBizDelegate();
        //if it is not logged in, go to the logout page
        if(request.getSession().getAttribute("userProfile")==null) return mapping.findForward("logout");
        
        try{
        
            LoginForm logFrm=(LoginForm)form;
            
            // if the user has not selected a location,
            // show an error.
            if(logFrm.getLocationCd()==null || "".equals(logFrm.getLocationCd())){
                    ActionErrors ae=new ActionErrors();
                    ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.MustSelectALocation"));
                    saveErrors(request,ae);   
                    return mapping.findForward("selectLocation");            
            }
            
            
            EmployeeProfile ep=(EmployeeProfile)request.getSession().getAttribute("userProfile");                   
            
            Iterator iterLoc=ep.getLocations().iterator();
            
            //iterate between the user locations
            while(iterLoc.hasNext()){
                LocationVO lVO=(LocationVO)iterLoc.next();
                
                //if current location is equal to the selected location                
                if(lVO.getLocationCd().equals(logFrm.getLocationCd())){
                	 //set location/country as the current location/country
                     ep.setLocationCd(logFrm.getLocationCd());

                     //Set flag to know if employee can see the split currency button accoding with the configuration of the location
                     LocationController cntrlLocation=new LocationController();
                     lVO = cntrlLocation.getLocation(lVO.getLocationCd());
                     if(lVO.getDualCurrFlg()==1)
                        ep.setSplitCurrency(true);
                     else
                        ep.setSplitCurrency(false);

                     ep.setRefreshEnable(lVO.getPrScanRfshFlg()==1);
                     ep.setRefreshInterval(lVO.getPrScanRfshIntvlNbr());                     
                     
                     ep.setCountryCd(lVO.getCountryCd());

                     if(!ep.isAdmin()){
                        if(ep.getAdminCountries().contains(ep.getCountryCd())){
                           ep.setCountryAdmin(true);
                        }else{
                              ep.setCountryAdmin(false);
                        }
                     }

                        //Get Comments from data base and put it into the session
                        try{
                        	String checkDecJS=sysUtils.getCheckDecodeJS(ep.getCountryCd());
                        	if(checkDecJS==null || "".equals(checkDecJS)) checkDecJS="function parseDocNbr(obj){}";
                        	request.getSession().setAttribute("checkDecodeJS",checkDecJS);

                            if(ep.getCountryCd() != null)
                            {
                               request.getSession().setAttribute("countryBanks",new CountryController().getBanks(ep.getCountryCd()));
                               Collection comments = commonOps.getComments(ep.getCountryCd());
                               request.getSession().setAttribute("comments",comments);
                            }
                            else
                            {
                                request.getSession().setAttribute("countryBanks",new ArrayList());
                                request.getSession().setAttribute("comments", new ArrayList());
                            }
                          }catch(Exception e)
                           {Constants.logger.debug(Utils.stackTraceToString(e));}
                     
                     //set timezone, role and supported currencies     
                     ep.setLocationTimeZone(lVO.getLocationTmZn());
                     ep.setEmployeeRole((Map)ep.getLocationsRoles().get(logFrm.getLocationCd()));

                    if(lVO.getCountryCd() != null)
                        ep.setSupportedCurrencies((Collection)ep.getCountryCurrencies().get(lVO.getCountryCd()));
                    else
                        ep.setSupportedCurrencies( new ArrayList());                    

                     //set threshold
                     CountryVO cVO=new CountryController().getCountry(lVO.getCountryCd());
                     ep.setErrorThresholdLocal(cVO.getErrThldLocCurr());
                     ep.setErrorThresholdUsd(cVO.getErrThldUsd());
                     ep.setScansLocalDecs(cVO.getScanLocalDecNbr());
                     ep.setScansUsdDecs(cVO.getScanUsdDecNbr());

                     ep.setQuickStatus(cVO.getQuickApplyFlg()==1);
                     ep.setGndUsedFlag(cVO.getGndUsedFlag()==1);
                     ep.setOacUsedFlag(cVO.getOacUsedFlag()==1);                    
                     ep.setCollectlaterFlag(cVO.getCollectlaterFlag()==1);                   
                     ep.setCodUsedFlag(cVO.getCodUsedFlag()==1);
                     ep.setFtcUsedFlag(cVO.getFtcUsedFlag()==1);
                     
                     CountryCurrencyVO ccVO=new AdminBizDelegate().getCountryCurrency(lVO.getCountryCd());
                     
                     if(ccVO==null){
                        ActionErrors ae=new ActionErrors();
                        ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("app.messages.MustConfigureCurrency"));
                        saveErrors(request,ae);   
                        return mapping.findForward("selectLocation");     
                     }		
                     
                     ep.setExchRateMax(ccVO.getExchRateMax());
                     ep.setExchRateMin(ccVO.getExchRateMin());

                     if(ep.getSupportedCurrencies()!=null){
                         //set default currency
                         Iterator iterCurr=ep.getSupportedCurrencies().iterator();
                         while(iterCurr.hasNext()){
                                SupportedCurrencyVO sc=(SupportedCurrencyVO)iterCurr.next();
                                if(sc.isDefaultCurrency()){
                                   ep.setDefaultCurrency(sc.getCurrencyCode());
                                   break;
                                }
                         }
                     }
                }
            }

            request.getSession().setAttribute("userProfile",ep); //needed for cluster session update.
            return mapping.findForward("menu"); 
        }catch(Exception e){
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae=new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.messages.ThereWereErrors"));
            saveErrors(request,ae);   
            return mapping.findForward("selectLocation");
        }
    }
}