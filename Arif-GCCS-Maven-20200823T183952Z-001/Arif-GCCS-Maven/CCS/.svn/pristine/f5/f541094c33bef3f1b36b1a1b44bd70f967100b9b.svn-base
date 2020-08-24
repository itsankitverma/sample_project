package com.fedex.lacitd.cashcontrol.prestier.struts.form;
import org.apache.struts.action.*;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.Factory;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.fedex.lacitd.cashcontrol.biztier.common.ReceivablesByAwbVO;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.prestier.helper.ValidateExpressionsUtil;
import com.fedex.lacitd.cashcontrol.common.Utils;

import javax.servlet.http.HttpServletRequest;


/**
 * Add receivable screen form class
 * @author  ccardenas
 */
public class AddReceivableForm extends ActionForm implements java.io.Serializable{
    private List awbs=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new ReceivablesByAwbVO();
                                                                          }
                                                                       } );

    /** Holds value of property awbNumber. */
    private String recAwbNumber;

    /** Holds value of property recNumber. */
    private String recNumber;

    /** Holds value of property recCustomerName. */
    private String recCustomerName;

    /** Holds value of property recPaymentAmount. */
    private double recAmount;

    /** Holds value of property recId. */
    private int recId;

    /** Holds value of property recemployeeId. */
    private String recemployeeId;

    /** Holds value of property currencyCode. */
    private String currencyCode;

    /** Holds value of property exchangeRateUsed. */
    private double exchangeRateUsed;

    /** Holds value of property locationCd. */
    private String locationCd;

    /** Holds value of property recDate. */
    private java.util.Date recDate;

    /** Holds value of property recDateText. */
    private String recDateText;

    private Date recDateValidation;

    public AddReceivableForm() {
    }

    /** Getter for property awbNumber.
     * @return Value of property awbNumber.
     */
    public String getRecAwbNumber() {
        return this.recAwbNumber;
    }

    /** Setter for property awbNumber.
     * @param recAwbNumber New value of property awbNumber.
     */
    public void setRecAwbNumber(String recAwbNumber) {
        this.recAwbNumber = recAwbNumber;
    }

    /** Getter for property recNumber.
     * @return Value of property recNumber.
     */
    public String getRecNumber() {
        return this.recNumber;
    }

    /** Setter for property recNumber.
     * @param recNumber New value of property recNumber.
     */
    public void setRecNumber(String recNumber) {
        this.recNumber = recNumber;
    }

    /** Getter for property recCustomerName.
     * @return Value of property recCustomerName.
     */
    public String getRecCustomerName() {
        return this.recCustomerName;
    }

    /** Setter for property recCustomerName.
     * @param recCustomerName New value of property recCustomerName.
     */
    public void setRecCustomerName(String recCustomerName) {
        this.recCustomerName = recCustomerName;
    }

    /** Getter for property recPaymentAmount.
     * @return Value of property recPaymentAmount.
     */
    public double getRecAmount() {
        return this.recAmount;
    }

    /** Setter for property recPaymentAmount.
     * @param recPaymentAmount New value of property recPaymentAmount.
     */
    public void setRecAmount(double recPaymentAmount) {
        this.recAmount = recPaymentAmount;
    }

    /** Getter for property recId.
     * @return Value of property recId.
     */
    public int getRecId() {
        return this.recId;
    }

    /** Setter for property recId.
     * @param recId New value of property recId.
     */
    public void setRecId(int recId) {
        this.recId = recId;
    }

    /** Getter for property recemployeeId.
     * @return Value of property recemployeeId.
     */
    public String getRecEmployeeId() {
        return this.recemployeeId;
    }

    /** Setter for property recemployeeId.
     * @param recemployeeId New value of property recemployeeId.
     */
    public void setRecEmployeeId(String recemployeeId) {
        this.recemployeeId = recemployeeId;
    }

    /** Getter for property currencyCode.
     * @return Value of property currencyCode.
     */
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    /** Setter for property currencyCode.
     * @param currencyCode New value of property currencyCode.
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /** Getter for property exchangeRateUsed.
     * @return Value of property exchangeRateUsed.
     */
    public double getExchangeRateUsed() {
        return this.exchangeRateUsed;
    }

    /** Setter for property exchangeRateUsed.
     * @param exchangeRateUsed New value of property exchangeRateUsed.
     */
    public void setExchangeRateUsed(double exchangeRateUsed) {
        this.exchangeRateUsed = exchangeRateUsed;
    }

    /** Getter for property locationCd.
     * @return Value of property locationCd.
     */
    public String getLocationCd() {
        return this.locationCd;
    }

    /** Setter for property locationCd.
     * @param locationCd New value of property locationCd.
     */
    public void setLocationCd(String locationCd) {
        this.locationCd = locationCd;
    }

    /** Getter for property recDate.
     * @return Value of property recDate.
     */
    public java.util.Date getRecDate() {
        return this.recDate;
    }

    /** Setter for property recDate.
     * @param recDate New value of property recDate.
     */
    public void setRecDate(java.util.Date recDate) {
        this.recDate = recDate;
    }

    /** Getter for property recDateText.
     * @return Value of property recDateText.
     */
    public String getRecDateText() {
        return this.recDateText;
    }

    /** Setter for property recDateText.
     * @param recDateText New value of property recDateText.
     */
    public void setRecDateText(String recDateText) {
        this.recDateText = recDateText;
    }


    public List getAwbs() {
        return awbs;
    }

    public void setAwbs(List awbs) {
        this.awbs = awbs;
    }

    public ActionErrors validate(ActionMapping mapping,
                                     HttpServletRequest request)
    {

       ActionErrors errors = super.validate(mapping, request);
       ValidateExpressionsUtil valUtil = ValidateExpressionsUtil.getInstance();
       String action = (String)request.getParameter("action");
      {

       if (errors == null) errors = new ActionErrors();
       if (action != null && action.equals("SaveAssignThis"))

       try {

           String expressions[] = {"JustChars.wl"};

           if(!valUtil.isValid(expressions,this.getRecCustomerName()))
                    errors.add("recCustomerName",new ActionError("wl.error.noValidChars"));


           String expressions1[] = {"JustNumbers.wl"};

           if(!valUtil.isValid(expressions1,this.getRecEmployeeId()))
                    errors.add("recEmployeeId",new ActionError("wl.error.noValidChars"));

           //Validations for rec date
           SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");

           if(valUtil.isOneYearBefore(sdf.parse(this.getRecDateText())))
                    errors.add("recDate",new ActionError("app.error.isLessThanOneYear.Message"));

           if(valUtil.isSoFar3Days(sdf.parse(this.getRecDateText())))
                    errors.add("recDate",new ActionError("app.error.isNotSoFar3Days.Message"));

        }catch(ParseException pe){
           Constants.logger.debug(Utils.stackTraceToString(pe));
        }
    }



       return errors;
    }

}
