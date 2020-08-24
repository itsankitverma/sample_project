package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.Factory;
import org.apache.commons.collections.ListUtils;

import com.fedex.lacitd.cashcontrol.datatier.valueobject.BankVO;

/**
 * Admin Bank Account screen form class
 * 
 * @author  Arturo Gonzalez
 */

public class AdminBankForm extends ActionForm implements java.io.Serializable{
    
    private Integer bankId;
    private String countryCd;
    private String bankShtDesc;
    private String bankCd;
    private String bankNm;
    
    /** Holds value of property check. */
    private boolean check=false;
    
    /**
     * @return Returns the bankCd.
     */
    public String getBankCd() {
        return bankCd;
    }
    /**
     * @param bankCd The bankCd to set.
     */
    public void setBankCd(String bankCd) {
        this.bankCd = bankCd;
    }
    /**
     * @return Returns the bankId.
     */
    public Integer getBankId() {
        return bankId;
    }
    /**
     * @param bankId The bankId to set.
     */
    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }
    /**
     * @return Returns the bankShtDesc.
     */
    public String getBankShtDesc() {
        return bankShtDesc;
    }
    /**
     * @param bankShtDesc The bankShtDesc to set.
     */
    public void setBankShtDesc(String bankShtDesc) {
        this.bankShtDesc = bankShtDesc;
    }
    /**
     * @return Returns the countryCd.
     */
    public String getCountryCd() {
        return countryCd;
    }
    /**
     * @param countryCd The countryCd to set.
     */
    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }
    /**
     * @return Returns the bankNm.
     */
    public String getBankNm() {
        return bankNm;
    }
    /**
     * @param bankNm The bankNm to set.
     */
    public void setBankNm(String bankNm) {
        this.bankNm = bankNm;
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {   ActionErrors errors = new ActionErrors();
        
    	if(this.isCheck()){
    	    if(this.bankNm==null || this.bankNm.trim().length()==0)
    	       errors.add("BankNm",new ActionError("errors.messages.BankNameNotEntered"));
    	}
        return errors;
    }
    
    /**
     * @return Returns the check.
     */
    public boolean isCheck() {
        return check;
    }
    /**
     * @param check The check to set.
     */
    public void setCheck(boolean check) {
        this.check = check;
    }
}