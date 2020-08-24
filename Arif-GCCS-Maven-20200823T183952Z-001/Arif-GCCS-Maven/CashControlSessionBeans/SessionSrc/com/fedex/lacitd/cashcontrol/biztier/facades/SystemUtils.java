package com.fedex.lacitd.cashcontrol.biztier.facades;

import com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * Created Sep 26, 2002 12:15:23 PM
 * Code generated by the Forte For Java EJB Builder
 *
 * @author ccardenas
 */

public interface SystemUtils extends javax.ejb.EJBObject {

    public Collection login(java.lang.String userName, java.lang.String password) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public Collection login(java.lang.String userName) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO findFedExEmployee(String empNbr) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public Collection findUsers(String empNbr) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public Properties getProperties(String category) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public String getCheckDecodeJS(String countryCd) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public Collection getCountryCurrencies(String countryCd) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;

    public void runPurgeCosmosScans() throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;
        /**
     * Method to get URLS and ROLES for security purposes - INFOSEC compliant
     * @throws com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException
     */
    public HashMap getUrlsAndRoles() throws FacadeException, RemoteException;
  //Miscellaneous enhancements
    public List getEmailCertificationAddresses(int role_id_nbr) throws java.rmi.RemoteException, com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;


}

