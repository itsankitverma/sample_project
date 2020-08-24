/**
 * AdminLocationAction.java
 *
 * Created on June 3, 2003, 11:27 AM
 */

package com.fedex.lacitd.cashcontrol.prestier.struts.action;

import com.fedex.lacitd.cashcontrol.prestier.struts.form.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;

import com.fedex.lacitd.cashcontrol.common.*;
import com.fedex.lacitd.cashcontrol.common.monitoring.*;

import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.prestier.helper.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import org.apache.struts.action.*;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.TreeSet;
import java.io.Serializable;
import javax.servlet.http.*;
import javax.servlet.ServletContext;

/**
 * @author Arturo Gonz�lez
 */
public class AdminLocationAction extends Action implements Serializable {

    AdminBizDelegate abd = new AdminBizDelegate();

    /**
     * Creates a new instance of AdminLocationAction *
     */
    public AdminLocationAction() {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        AdminLocationForm frm = (AdminLocationForm) form;
        ActionForward actionForward = null;
        String action = request.getParameter("action");

        EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
        if (ep == null) return mapping.findForward("logout");

        frm.setLocationCd(request.getParameter("locationCd"));

        if (frm.getLocationCd() == null) {
            frm.setLocationCd(ep.getLocationCd());
        }
        
        //Get All locations from DataBase
        Collection locations = (ArrayList) getAllLocations(request);

        frm.setLocations(locations);

        if (action.equals("getLocation")) {
            getLocation(frm, request);
            request.setAttribute("AdminLocationForm", frm);
            actionForward = mapping.findForward("ShowLocationData");
        }
        else if (action.equals("updateLocation")) {
            updateLocation(frm, request);
            getLocation(frm, request);
            actionForward = mapping.findForward("SavedLocation");
        }
        else if ("addLocation".equals(action)) {
            actionForward = mapping.findForward("AddLocation");
        }
        else if ("saveLocation".equals(action)) {
            actionForward = saveLocation(frm, request, mapping);
        }
        return actionForward;
    }

    private void getLocation(AdminLocationForm frm, HttpServletRequest request) {
        ActionErrors ae = new ActionErrors();
        try {
            LocationVO location =
                    abd.getLocation(frm.getLocationCd());
            frm.setLocationCd(location.getLocationCd());
            frm.setParentLocationCd(location.getParentLocationCd());
            frm.setActiveLocation(location.getActiveLocation());
            frm.setLocationNm(location.getLocationNm());
            frm.setLocationType(location.getLocationType());
            frm.setLocationTmZn(location.getLocationTmZn());
            frm.setSplitDepSource(location.getSplitDepBySrc());
            frm.setSplitDepCurrency(location.getSplitDepByCurr());
            frm.setSplitDepPaymentType(location.getSplitDepByPymtType());
            frm.setLocalDefaultAccount(location.getLocalDefaultAcc());
            frm.setUsdDefaultAccount(location.getUsdDefaultAcc());
            frm.setManCreditCard(location.getManCreditCard());
            frm.setCreditCardPaymentType(location.getCreditCardPymtType());
            frm.setDelayDaysAllowed(location.getAllowPrpDelay());
            frm.setCountryCd(location.getCountryCd());
            frm.setCosmosRefreshEnabled(location.getPrScanRfshFlg());
            frm.setCosmosRefreshInterval(location.getPrScanRfshIntvlNbr());
            frm.setHoldLocation(location.getHoldLocation());
            frm.setDualCurrencyLocation(location.getDualCurrFlg());
            frm.setInCageTskIdNumber(location.getInCageTskIdNbr());
            frm.setRihTskIdNumber(location.getRihTskIdNbr());
            //frm.setFdxTntLocationCd(location.getFdxTntLinkCd());
            //Check if timeZones Collection is already in ApplicationObject
            ServletContext app = this.getServlet().getServletContext();
            Collection timeZones = (Collection)app.getAttribute("timeZones");

            if(timeZones==null){
                timeZones = abd.getTimeZones();
                app.setAttribute("timeZones",timeZones);
            }

            //Add TimeZones Collection to frm
            Object timeZones2[] = ((ArrayList)timeZones).toArray();

            //Add ParentLocation Collection to frm
            Collection parentLocations = (Collection)abd.getPossibleParentLocations(location.getLocationCd(),location.getCountryCd());

            TreeSet ts=new TreeSet(new LocationToCompare());
            ts.addAll(parentLocations);

            frm.setParentLocations(ts);

            frm.setTimeZones(timeZones2);
            
            //Add fdxTNTLocation Collection to frm
            /*Collection fdxTNTLocations = (Collection)abd.getPossibleFdxTNTLocations(location.getLocationCd(),location.getCountryCd());
            TreeSet ts1=new TreeSet(new LocationToCompare());
            ts1.addAll(fdxTNTLocations);
            frm.setFdxTNTLocations(ts1); */

        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotGetLocation"));
            saveErrors(request, ae);
        }
    }

    public Collection getAllLocations(HttpServletRequest request) {
        ActionErrors ae = new ActionErrors();
        ArrayList locations = new ArrayList();

        try {
            EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");
            if (ep.isAdmin()) {
                locations = (ArrayList) abd.getAllLocations();
                request.getSession().setAttribute("locations", locations);
            } else if (ep.isCountryAdmin()) {
                locations = (ArrayList) abd.getLocationsForAdminCountryRole(ep.getEmployeeId(), Constants.COUNTRYADMIN);
            } else {
                locations = (ArrayList) request.getSession().getAttribute("locations");
            }
                    
            //Order locations alphabetically 
            LocationToCompare comp = new LocationToCompare();
            Collections.sort((ArrayList) locations, comp);
        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotGetLocationsFromDB"));
            saveErrors(request, ae);
        }
        return locations;
    }

    private void updateLocation(AdminLocationForm frm, HttpServletRequest request) {
        ActionErrors ae = new ActionErrors();
        try {
            LocationVO location = new LocationController().getLocation(frm.getLocationCd());
            location.setCountryCd(frm.getCountryCd());
            location.setLocationCd(frm.getLocationCd());

            if("NO PARENT".equals(frm.getParentLocationCd()))
                location.setParentLocationCd(null);
            else
                location.setParentLocationCd(frm.getParentLocationCd());

            location.setLocationNm(frm.getLocationNm());
            location.setLocationType(frm.getLocationType());
            location.setLocationTmZn(frm.getLocationTmZn());
            location.setSplitDepBySrc(frm.getSplitDepSource());
            location.setSplitDepByCurr(frm.getSplitDepCurrency());
            location.setSplitDepByPymtType(frm.getSplitDepPaymentType());
            location.setManCreditCard(frm.getManCreditCard());
            location.setCreditCardPymtType(frm.getCreditCardPaymentType());
            location.setAllowPrpDelay(frm.getDelayDaysAllowed());
            location.setActiveLocation(frm.getActiveLocation());
            location.setPrScanRfshFlg(frm.getCosmosRefreshEnabled());
            location.setPrScanRfshIntvlNbr(frm.getCosmosRefreshInterval());
            location.setHoldLocation(frm.getHoldLocation());
            location.setDualCurrFlg(frm.getDualCurrencyLocation());
            location.setInCageTskIdNbr(frm.getInCageTskIdNumber());
            location.setRihTskIdNbr(frm.getRihTskIdNumber());
            //location.setFdxTntLinkCd(frm.getFdxTntLocationCd());

            EmployeeProfile ep = (EmployeeProfile) request.getSession().getAttribute("userProfile");

            if (location.getDualCurrFlg() == 1) {
                ep.setSplitCurrency(true);
            }else {
                ep.setSplitCurrency(false);
            }

            //Check the in-cage flag to set the in-cage task ir nbr value
            String inCageFlag = request.getParameter("inCage");
            String rihFlag    = request.getParameter("rih");

            Constants.logger.debug("\n\n *** Veamos in cage :" +inCageFlag);
            Constants.logger.debug("\n\n *** Veamos tasks id :" +frm.getInCageTskIdNumber());

            request.getSession().setAttribute("userProfile", ep);
            abd.updateLocation(location, inCageFlag, rihFlag);


            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "AdminLocationAction updateLocation()", frm.getLocationCd(), true);

        } catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSaveLocation"));
            saveErrors(request, ae);

            LogEventHelper.logEvent(request, Monitoring.MONITORING_EVENT_UPDATE, "AdminLocationAction updateLocation()", frm.getLocationCd(), false);
        }
    }

    public ActionForward saveLocation(AdminLocationForm frm, HttpServletRequest request, ActionMapping mapping) {
        ActionForward forward = mapping.findForward("AddLocation");
        try {
            LocationController controller = new LocationController();
            String newCode = frm.getLocationNm();
            if(newCode != null && newCode.trim().length() > 0) {
                LocationVO locationVO = controller.getLocation(frm.getLocationCd());

                locationVO.setLocationCd(newCode);
                locationVO.setParentLocationCd(null);
                controller.setLocation(locationVO);
                request.setAttribute("action","getLocation");
                request.setAttribute("locationCd",newCode);
                forward = mapping.findForward("SuccessTransaction");
            }
            else {
                ActionErrors ae = new ActionErrors();
                ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.LocationIsRequired"));
                saveErrors(request,ae);
            }
        }
        catch (Exception e) {
            Constants.logger.debug(Utils.stackTraceToString(e));
            ActionErrors ae = new ActionErrors();
            ae.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.messages.CouldNotSaveLocation"));
            saveErrors(request,ae);
        }
        return forward;
    }
}
