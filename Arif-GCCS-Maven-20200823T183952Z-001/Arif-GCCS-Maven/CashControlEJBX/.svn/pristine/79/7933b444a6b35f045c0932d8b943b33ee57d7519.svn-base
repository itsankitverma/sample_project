/**
 * @(#)OacManagerBean.java			Tue Aug 02 15:38:51 VET 2005
 * 
 * FedEx
 * Cash Control
 * 
 * FedEx
 * Santiago, Chile
 * 
 * Copyright (c) 2001 FedEx, All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of FedEx. ("Confidential Information").
 * 
 * Visit our website at http://www.fedex.com for more information
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.manager;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import java.rmi.RemoteException;
import java.util.*;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class OacManagerBean implements SessionBean {

    private SessionContext _ctx;
    /**
     * Called by Container. This method initialization the session
     */
    public void ejbCreate() {
    }

    /**
     * Called by Container.  Implementation can acquire needed resources
     */
    public void ejbActivate() {
    }

    /**
     * Called by Container.  Releases held resources for passivation
     */
    public void ejbPassivate() {
    }

    /**
     * EJB Container calls this method right before it remove the Session bean 
     */
    public void ejbRemove() {
    }

    /**
     * Called by Container. Associates this Bean instance with a particular context environment.
     */
    public void setSessionContext(SessionContext ctx) {
        _ctx = ctx;
    }

    /**
     * This method create new Oac object
     * @param oacVO a value object the Oac bean
     */
    public void setOac(OacVO oacVO)
        throws OacException {
        //-- we do not accept null value for the parameter.
        if (oacVO == null) {
            throw new IllegalArgumentException("oacVO parameter was null in setOac() method from OacManager class");
        }
        
        try {
            
            //-- create new Oac object
            getOacLocalHome().create(
                oacVO.getObAncSvcDt(),
                oacVO.getLocationCd(),
                oacVO.getPymtCurrCd(),
                oacVO.getCashPymtAmt(),
                oacVO.getOtherPymtAmt(),
                oacVO.getOtherPymtTypeCd(),
                oacVO.getOtherDocNbr(),
                oacVO.getChngStatusEmpIdNbr(),
                oacVO.getChngStatusDt(),
                oacVO.getCloseEmpIdNbr(),
                oacVO.getCloseDt(),
                oacVO.getEodEmpIdNbr(),
                oacVO.getEodDt(),
                oacVO.getChkinAgentComDesc(),
                oacVO.getStatusCd(),
                oacVO.getExchRateAmt(),
                oacVO.getCourEmpIdNbr(),
                oacVO.getCashDepSlipIdNbr(),
                oacVO.getOtherDepSlipIdNbr(),
                oacVO.getEodIdNbr(),
                oacVO.getOtherComDesc(),
                oacVO.getRcptNbr(),
                oacVO.getOrigRcptNbr(),
                oacVO.getRcptChngEmpNbr(),
                oacVO.getOrigEmpNbr(),
                oacVO.getRsgnEmpNbr(),
                oacVO.getDualObAncIdNbr());
        }
        catch (CreateException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred in setOac() method from OacManager class";
            throw new OacException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in setOac() method from OacManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets a Oac object
     * @return oacVO - a value object of the Oac bean
     */
    public OacVO getOac(Integer obAncSvcIdNbr)
        throws FinderException {
        //-- we do not accept null values for any parameters.
        if (obAncSvcIdNbr == null) {
            throw new IllegalArgumentException("obAncSvcIdNbr parameter was null in getOac() method from OacManager class");
        }
        
        try {
            //-- get the local interface by the primary key
            OacLocal oacLocal = getOacLocalHome().findByPrimaryKey(obAncSvcIdNbr);
            //-- create new value object to store the data
            OacVO oacVO = new OacVO();
            //-- populate the new value object
            oacVO.setObAncSvcIdNbr(oacLocal.getObAncSvcIdNbr());
            oacVO.setObAncSvcDt(oacLocal.getObAncSvcDt());
            oacVO.setLocationCd(oacLocal.getLocationCd());
            oacVO.setPymtCurrCd(oacLocal.getPymtCurrCd());
            oacVO.setCashPymtAmt(oacLocal.getCashPymtAmt());
            oacVO.setOtherPymtAmt(oacLocal.getOtherPymtAmt());
            oacVO.setOtherPymtTypeCd(oacLocal.getOtherPymtTypeCd());
            oacVO.setOtherDocNbr(oacLocal.getOtherDocNbr());
            oacVO.setChngStatusEmpIdNbr(oacLocal.getChngStatusEmpIdNbr());
            oacVO.setChngStatusDt(oacLocal.getChngStatusDt());
            oacVO.setCloseEmpIdNbr(oacLocal.getCloseEmpIdNbr());
            oacVO.setCloseDt(oacLocal.getCloseDt());
            oacVO.setEodEmpIdNbr(oacLocal.getEodEmpIdNbr());
            oacVO.setEodDt(oacLocal.getEodDt());
            oacVO.setChkinAgentComDesc(oacLocal.getChkinAgentComDesc());
            oacVO.setStatusCd(oacLocal.getStatusCd());
            oacVO.setExchRateAmt(oacLocal.getExchRateAmt());
            oacVO.setCourEmpIdNbr(oacLocal.getCourEmpIdNbr());
            oacVO.setCashDepSlipIdNbr(oacLocal.getCashDepSlipIdNbr());
            oacVO.setOtherDepSlipIdNbr(oacLocal.getOtherDepSlipIdNbr());
            oacVO.setEodIdNbr(oacLocal.getEodIdNbr());
            oacVO.setOtherComDesc(oacLocal.getOtherComDesc());
            oacVO.setRcptNbr(oacLocal.getRcptNbr());
            oacVO.setOrigRcptNbr(oacLocal.getOrigRcptNbr());
            oacVO.setRcptChngEmpNbr(oacLocal.getRcptChngEmpNbr());
            oacVO.setOrigEmpNbr(oacLocal.getOrigEmpNbr());
            oacVO.setRsgnEmpNbr(oacLocal.getRsgnEmpNbr());
            oacVO.setDualObAncIdNbr(oacLocal.getDualObAncIdNbr());
            return oacVO;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getOac() method from OacManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method removes an existing Oac object
     * @param obAncSvcIdNbr - the Oac bean primary key
     */
    public void removeOac(Integer obAncSvcIdNbr)
        throws RemoveException {
        //-- we do not accept null value for the parameter.
        if (obAncSvcIdNbr == null) {
            throw new IllegalArgumentException("obAncSvcIdNbr parameter was null in removeOac() method from OacManager class");
        }
        
        try {
            getOacLocalHome().remove(obAncSvcIdNbr);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in removeOac() method from OacManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method updates an existing Oac object
     * @param oacVO - the value object of the Oac bean
     */
    public void updateOac(OacVO oacVO)
        throws OacException {
        //-- we do not accept null value for the parameter.
        if (oacVO == null) {
            throw new IllegalArgumentException("oacVO parameter was null in updateOac() method from OacManager class");
        }
        
        try {
            Integer obAncSvcIdNbr = oacVO.getObAncSvcIdNbr();
            
            OacLocal oacLocal = getOacLocalHome().findByPrimaryKey(obAncSvcIdNbr);
            //-- update Oac entity bean
            oacLocal.setObAncSvcDt(oacVO.getObAncSvcDt());
            oacLocal.setLocationCd(oacVO.getLocationCd());
            oacLocal.setPymtCurrCd(oacVO.getPymtCurrCd());
            oacLocal.setCashPymtAmt(oacVO.getCashPymtAmt());
            oacLocal.setOtherPymtAmt(oacVO.getOtherPymtAmt());
            oacLocal.setOtherPymtTypeCd(oacVO.getOtherPymtTypeCd());
            oacLocal.setOtherDocNbr(oacVO.getOtherDocNbr());
            oacLocal.setChngStatusEmpIdNbr(oacVO.getChngStatusEmpIdNbr());
            oacLocal.setChngStatusDt(oacVO.getChngStatusDt());
            oacLocal.setCloseEmpIdNbr(oacVO.getCloseEmpIdNbr());
            oacLocal.setCloseDt(oacVO.getCloseDt());
            oacLocal.setEodEmpIdNbr(oacVO.getEodEmpIdNbr());
            oacLocal.setEodDt(oacVO.getEodDt());
            oacLocal.setChkinAgentComDesc(oacVO.getChkinAgentComDesc());
            oacLocal.setStatusCd(oacVO.getStatusCd());
            oacLocal.setExchRateAmt(oacVO.getExchRateAmt());
            oacLocal.setCourEmpIdNbr(oacVO.getCourEmpIdNbr());
            oacLocal.setCashDepSlipIdNbr(oacVO.getCashDepSlipIdNbr());
            oacLocal.setOtherDepSlipIdNbr(oacVO.getOtherDepSlipIdNbr());
            oacLocal.setEodIdNbr(oacVO.getEodIdNbr());
            oacLocal.setOtherComDesc(oacVO.getOtherComDesc());
            oacLocal.setRcptNbr(oacVO.getRcptNbr());
            oacLocal.setOrigRcptNbr(oacVO.getOrigRcptNbr());
            oacLocal.setRcptChngEmpNbr(oacVO.getRcptChngEmpNbr());
            oacLocal.setOrigEmpNbr(oacVO.getOrigEmpNbr());
            oacLocal.setRsgnEmpNbr(oacVO.getRsgnEmpNbr());
            oacLocal.setDualObAncIdNbr(oacVO.getDualObAncIdNbr());
        }
        catch (FinderException ex) {
            _ctx.setRollbackOnly();
            String errorMsg = "Error occurred when locate the requested bean in updateOac() method from OacManager class";
            throw new OacException(errorMsg, ex);
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in updateOac() method from OacManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findAllOacs objects
     * @return Collection - a collection of the Oac objects
     */
    public Collection getAllOacs() {
        try {
            //-- gets the local home interface and call the findAllOacs method
            Collection oacCol = getOacLocalHome().findAllOacs();
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (oacCol != null && oacCol.size() > 0) {
                Iterator it = oacCol.iterator();
                while (it.hasNext()) {
                    OacLocal oacLocal = (OacLocal) it.next();
                    //-- get the primary key of the Oac EJB object
                    Integer obAncSvcIdNbr = (Integer)oacLocal.getPrimaryKey();
                    //-- get the value object for the Oac EJB using the primary key
                    if (obAncSvcIdNbr != null) {
                        OacVO oacVO = getOac(obAncSvcIdNbr);
                        //-- add the value object to the collection
                        list.add(oacVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getAllOacs() method from OacManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getAllOacs() method from OacManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByPymtCurrCd objects
     * @return Collection - a collection of the Oac objects
     */
    public Collection getOacByPymtCurrCd(String pymtCurrCd) {
        try {
            //-- gets the local home interface and call the findByPymtCurrCd method
            Collection oacCol = getOacLocalHome().findByPymtCurrCd(pymtCurrCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (oacCol != null && oacCol.size() > 0) {
                Iterator it = oacCol.iterator();
                while (it.hasNext()) {
                    OacLocal oacLocal = (OacLocal) it.next();
                    //-- get the primary key of the Oac EJB object
                    Integer obAncSvcIdNbr = (Integer)oacLocal.getPrimaryKey();
                    //-- get the value object for the Oac EJB using the primary key
                    if (obAncSvcIdNbr != null) {
                        OacVO oacVO = getOac(obAncSvcIdNbr);
                        //-- add the value object to the collection
                        list.add(oacVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getOacByPymtCurrCd() method from OacManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getOacByPymtCurrCd() method from OacManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByLocCd objects
     * @return Collection - a collection of the Oac objects
     */
    public Collection getOacByLocCd(String locCd) {
        try {
            //-- gets the local home interface and call the findByLocCd method
            Collection oacCol = getOacLocalHome().findByLocCd(locCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (oacCol != null && oacCol.size() > 0) {
                Iterator it = oacCol.iterator();
                while (it.hasNext()) {
                    OacLocal oacLocal = (OacLocal) it.next();
                    //-- get the primary key of the Oac EJB object
                    Integer obAncSvcIdNbr = (Integer)oacLocal.getPrimaryKey();
                    //-- get the value object for the Oac EJB using the primary key
                    if (obAncSvcIdNbr != null) {
                        OacVO oacVO = getOac(obAncSvcIdNbr);
                        //-- add the value object to the collection
                        list.add(oacVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getOacByLocCd() method from OacManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getOacByLocCd() method from OacManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByStatusCd objects
     * @return Collection - a collection of the Oac objects
     */
    public Collection getOacByStatusCd(Integer statusCd) {
        try {
            //-- gets the local home interface and call the findByStatusCd method
            Collection oacCol = getOacLocalHome().findByStatusCd(statusCd);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (oacCol != null && oacCol.size() > 0) {
                Iterator it = oacCol.iterator();
                while (it.hasNext()) {
                    OacLocal oacLocal = (OacLocal) it.next();
                    //-- get the primary key of the Oac EJB object
                    Integer obAncSvcIdNbr = (Integer)oacLocal.getPrimaryKey();
                    //-- get the value object for the Oac EJB using the primary key
                    if (obAncSvcIdNbr != null) {
                        OacVO oacVO = getOac(obAncSvcIdNbr);
                        //-- add the value object to the collection
                        list.add(oacVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getOacByStatusCd() method from OacManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getOacByStatusCd() method from OacManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This method gets findByEodIdNbr objects
     * @return Collection - a collection of the Oac objects
     */
    public Collection getOacByEodIdNbr(Integer eodIdNbr) {
        try {
            //-- gets the local home interface and call the findByEodIdNbr method
            Collection oacCol = getOacLocalHome().findByEodIdNbr(eodIdNbr);
            //-- create a new collection to hold the result
            Collection list = new ArrayList();
            if (oacCol != null && oacCol.size() > 0) {
                Iterator it = oacCol.iterator();
                while (it.hasNext()) {
                    OacLocal oacLocal = (OacLocal) it.next();
                    //-- get the primary key of the Oac EJB object
                    Integer obAncSvcIdNbr = (Integer)oacLocal.getPrimaryKey();
                    //-- get the value object for the Oac EJB using the primary key
                    if (obAncSvcIdNbr != null) {
                        OacVO oacVO = getOac(obAncSvcIdNbr);
                        //-- add the value object to the collection
                        list.add(oacVO);
                    }
                }
            }
            return list;
        }
        catch (FinderException ex) {
            String errorMsg = "No results were found in getOacByEodIdNbr() method from OacManager class";
            return null;
        }
        catch (Exception ex) {
            String errorMsg = "Error occurred in getOacByEodIdNbr() method from OacManager class";
            throw new EJBException(errorMsg, ex);
        }
    }

    /**
     * This methods gets the Oac local home interface
     */
    private OacLocalHome getOacLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (OacLocalHome) service.getEJBLocalHome(ServiceConstants.OAC_LOCAL_JNDI);
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getOacLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

}
