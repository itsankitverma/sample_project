package com.fedex.lacitd.cashcontrol.biztier.common;

import java.util.HashMap;

public class FedExEmployee extends HashMap {

    public static final String FIRST_NAME = "givenname";
    public static final String LAST_NAME = "sn";
    public static final String MIDDLE_INITIAL = "initials";
    public static final String COUNTRY_CODE = "countrycode";
    public static final String PAGER = "pager";
    public static final String MAIL = "mail";
    public static final String EMPLOYEE_NUMBER = "uid";
    public static final String COMAT_STATION_ID = "comatstationid";
    public static final String COST_CENTER = "costcenter";
    public static final String DEPARTMENT_NUMBER = "departmentnumber";
    public static final String ADDRESS = "postaladdress";
    public static final String STATE = "st";
    public static final String PHONE = "telephonenumber";
    public static final String MAIL_ALTERNATE = "mailalternateaddress";
    public static final String FAX = "faxcommunity";
    public static final String STREET = "street";
    public static final String INTERNATIONAL_COUNTRY = "internationalcountry";
    public static final String TITLE = "title";
    public static final String DEPARTMENT_NAME = "departmentname";
    public static final String SUITE = "supplementaladdress";
    public static final String MANAGER = "manager";
    public static final String PERSONAL_REP = "personnelrepempno";
    public static final String NICKNAME = "nickname";
    public static final String COMAT = "comat";
    public static final String PWD = "pwd";


    public void put(String key, Object value) {
        super.put(key, value);
    }

    public String get(String key) {
        Object value = super.get(key);
        if (value == null)
            return "";
        else
            return value.toString();
    }
}
