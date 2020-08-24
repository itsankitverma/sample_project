/**
 * UserProfileToAdmin.java
 *
 * Created on April 23, 2003, 5:28 PM
 */

package com.fedex.lacitd.cashcontrol.biztier.common;

import java.io.Serializable;

/**
 * @author Arturo Gonzalez
 */
public class UserProfileToAdmin implements Serializable {

    /**
     * Holds value of property employeeCodePk.
     */
    private String employeeCodePk;

    /**
     * Holds value of property employeeName.
     */
    private String employeeName;

    /**
     * Holds value of property employeeCountryCode.
     */
    private String countryCodePk;

    /**
     * Holds value of property locations.
     */
    private java.util.Collection locations;

    /**
     * Holds value of property locationRole.
     */
    private java.util.HashMap locationRoles;


    /**
     * Creates a new instance of UserProfileToAdmin
     */
    public UserProfileToAdmin() {
    }

    /**
     * Getter for property locations.
     *
     * @return Value of property locations.
     */
    public java.util.Collection getLocations() {
        return locations;
    }

    /**
     * Setter for property locations.
     *
     * @param locations New value of property locations.
     */
    public void setLocations(java.util.Collection locations) {
        this.locations = locations;
    }

    /**
     * Getter for property locationRoles.
     *
     * @return Value of property locationRoles.
     */
    public java.util.HashMap getLocationRoles() {
        return locationRoles;
    }

    /**
     * Setter for property locationRoles.
     *
     * @param locationRoles New value of property locationRoles.
     */
    public void setLocationRoles(java.util.HashMap locationRoles) {
        this.locationRoles = locationRoles;
    }

    /**
     * Getter for property employeeName.
     *
     * @return Value of property employeeName.
     */
    public java.lang.String getEmployeeName() {
        return employeeName;
    }

    /**
     * Setter for property employeeName.
     *
     * @param employeeName New value of property employeeName.
     */
    public void setEmployeeName(java.lang.String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Getter for property employeeCodePk.
     *
     * @return Value of property employeeCodePk.
     */
    public java.lang.String getEmployeeCodePk() {
        return employeeCodePk;
    }

    /**
     * Setter for property employeeCodePk.
     *
     * @param employeeCodePk New value of property employeeCodePk.
     */
    public void setEmployeeCodePk(java.lang.String employeeCodePk) {
        this.employeeCodePk = employeeCodePk;
    }

    /**
     * Getter for property countryCodePk.
     *
     * @return Value of property countryCodePk.
     */
    public java.lang.String getCountryCodePk() {
        return countryCodePk;
    }

    /**
     * Setter for property countryCodePk.
     *
     * @param countryCodePk New value of property countryCodePk.
     */
    public void setCountryCodePk(java.lang.String countryCodePk) {
        this.countryCodePk = countryCodePk;
    }

}
