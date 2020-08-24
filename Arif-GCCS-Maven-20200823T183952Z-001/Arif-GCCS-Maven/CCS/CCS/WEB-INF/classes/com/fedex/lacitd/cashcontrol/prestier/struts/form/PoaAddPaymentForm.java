package com.fedex.lacitd.cashcontrol.prestier.struts.form;
import org.apache.struts.action.*;
import javax.servlet.http.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.prestier.helper.ValidateExpressionsUtil;

/**
 * Add Poa Payment screen form class
 * @author  ccardenas
 */
public class PoaAddPaymentForm extends ActionForm implements java.io.Serializable{

    private List details=ListUtils.lazyList(new ArrayList(),new Factory() {
                                                                          public Object create() {
                                                                                return new PoaDetailSurchargesVO();
                                                                          }
                                                                       } );

    private List invoices=ListUtils.lazyList(new ArrayList(),new Factory() {
        public Object create() {
            return new PoaOutstInvoicesVO();
        }
    } );
    private String custNmPrev;
    private String rcptNbrPrev;
    private String rcptChngEmpId;
    private Integer pageNumber;

    public String getCustNmPrev() {
        return custNmPrev;
    }

    public void setCustNmPrev(String custNmPrev) {
        this.custNmPrev = custNmPrev;
    }


    /**
     * @return Returns the rcptChngEmpId.
     */
    public String getRcptChngEmpId() {
        return rcptChngEmpId;
    }
    /**
     * @param rcptChngEmpId The rcptChngEmpId to set.
     */
    public void setRcptChngEmpId(String rcptChngEmpId) {
        this.rcptChngEmpId = rcptChngEmpId;
    }
    /**
     * @return Returns the rcptNbrPrev.
     */
    public String getRcptNbrPrev() {
        return rcptNbrPrev;
    }
    /**
     * @param rcptNbrPrev The rcptNbrPrev to set.
     */
    public void setRcptNbrPrev(String rcptNbrPrev) {
        this.rcptNbrPrev = rcptNbrPrev;
    }

    private String filter;

    /** Holds value of property courier. */
    private String courier;

    /** Holds value of property courierName. */
    private String fixedCourier;

    /** Holds value of property exchRate. */
    private double exchRate;

    /** Holds value of property currentCurrency. */
    private String currentCurrency;

    /** Holds value of property payment. */
    private PoaPaymentVO payment=new PoaPaymentVO();

    /** Holds value of property delIndex. */
    private int delIndex;

    /** Holds value of property remainingAmount. */
    private double remainingAmount;

    /** Holds value of property paymentTypes. */
    private java.util.Collection paymentTypes;

    /** Holds value of property countryBanks. */
    private java.util.Collection countryBanks;

    public void setCountryBanks(Collection cb){
        this.countryBanks=cb;
    }

    public Collection getCountryBanks(){
        return this.countryBanks;
    }

    public PoaAddPaymentForm() {
    }

    public void setDetails(List details){
        this.details = ListUtils.lazyList(details,new Factory() {
                                                                  public Object create() {
                                                                         return new PoaDetailSurchargesVO();
                                                                  }
                                                                });
    }

    public List getDetails(){
        return details;
    }

    public void setInvoices(List invoices){
        this.invoices = ListUtils.lazyList(invoices,new Factory() {
            public Object create() {
                return new PoaOutstInvoicesVO();
            }
        });
    }

    public List getInvoices(){
        return invoices;
    }


    /** Getter for property courier.
     * @return Value of property courier.
     */
    public String getCourierId() {
        return this.courier;
    }

    /** Setter for property courier.
     * @param courier New value of property courier.
     */
    public void setCourierId(String courier) {
        this.courier = courier;
    }

    /** Getter for property fixedCourier.
     * @return Value of property fixedCourier.
     */
    public String getFixedCourier() {
        return this.fixedCourier;
    }

    /** Setter for property courierName.
     * @param fixedCourier New value of property fixedCourier.
     */
    public void setFixedCourier(String fixedCourier) {
        this.fixedCourier = fixedCourier;
    }

    /** Getter for property exchRate.
     * @return Value of property exchRate.
     */
    public double getExchRate() {
        return this.exchRate;
    }

    /** Setter for property exchRate.
     * @param exchRate New value of property exchRate.
     */
    public void setExchRate(double exchRate) {
        this.exchRate = exchRate;
    }

    /** Getter for property currentCurrency.
     * @return Value of property currentCurrency.
     */
    public String getCurrentCurrency() {
        return this.currentCurrency;
    }

    /** Setter for property currentCurrency.
     * @param currentCurrency New value of property currentCurrency.
     */
    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }

    /** Getter for property payment.
     * @return Value of property payment.
     */
    public PoaPaymentVO getPayment() {
        return this.payment;
    }

    /** Setter for property payment.
     * @param payment New value of property payment.
     */
    public void setPayment(PoaPaymentVO payment) {
        this.payment = payment;
    }

    /** Getter for property delIndex.
     * @return Value of property delIndex.
     */
    public int getDelIndex() {
        return this.delIndex;
    }

    /** Setter for property delIndex.
     * @param delIndex New value of property delIndex.
     */
    public void setDelIndex(int delIndex) {
        this.delIndex = delIndex;
    }


    public double getTotalAmount() {
        if(details==null || details.isEmpty()) return 0.0;
        double total=0.0;
        Iterator iter=details.iterator();
        while(iter.hasNext()){
            PoaDetailSurchargesVO poa=(PoaDetailSurchargesVO) iter.next();
            total=total+poa.getPoaDetail().getAmount();
        }
        return total;
    }

    public double getTotalCoupon() {
        if(details==null || details.isEmpty()) return 0.0;
        double total=0.0;
        Iterator iter=details.iterator();
        while(iter.hasNext()){
            PoaDetailSurchargesVO poa=(PoaDetailSurchargesVO) iter.next();
            total=total+poa.getPoaDetail().getCouponAmt();
        }
        return total;
    }

    public double getTotalUsd() {
        if(details==null || details.isEmpty()) return 0.0;
        double total=0.0;
        Iterator iter=details.iterator();
        while(iter.hasNext()){
            PoaDetailSurchargesVO poa=(PoaDetailSurchargesVO) iter.next();
            total=total+poa.getUsdAmount();
        }
        return total;
    }

    /** Getter for property remainingAmount.
     * @return Value of property remainingAmount.
     */
    public double getRemainingAmount() {
        if(getPayment()==null) return 0;
        setRemainingAmount(getPayment().getPaymentAmt()-getTotalAmount());

        if(this.remainingAmount<0) setRemainingAmount(0);

        return this.remainingAmount;
    }

    /** Setter for property remainingAmount.
     * @param remainingAmount New value of property remainingAmount.
     */
    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }
    /*
    public ActionErrors validate(ActionMapping am, HttpServletRequest req){
          if(payment.getPaymentType()==3 && payment.getOtherDocNbr().length()>4)
                  payment.setOtherDocNbr(payment.getOtherDocNbr().substring(payment.getOtherDocNbr().length()-4));

          return new ActionErrors();
    } */

    /** Getter for property paymentTypes.
     * @return Value of property paymentTypes.
     */
    public java.util.Collection getPaymentTypes() {
        return this.paymentTypes;
    }

    /** Setter for property paymentTypes.
     * @param paymentTypes New value of property paymentTypes.
     */
    public void setPaymentTypes(java.util.Collection paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    /**
     * @return Returns the filter.
     */
    public String getFilter() {
        return filter;
    }

    /**
     * @param filter The filter to set.
     */
    public void setFilter(String filter) {
        this.filter = filter;
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

       /* 
       ValidateExpressionsUtil valUtil = ValidateExpressionsUtil.getInstance();
       String action = (String)request.getParameter("action");
       if (errors == null) errors = new ActionErrors();

       if (action != null && action.equals("savePayment"))
       {

           String expressions[] = {"JavaScriptInjection.bl"};

           if(!valUtil.isValid(expressions,this.getPayment().getCustomerNm()))
                    errors.add("customerNm",new ActionError("wl.error.noValidChars"));

           if(errors.isEmpty())
           {
               if(!valUtil.isValid(expressions,this.getPayment().getRcptNbr()))
                        errors.add("rcptNbr",new ActionError("wl.error.noValidChars"));
           }

           if(errors.isEmpty())
           {
               if(!valUtil.isValid(expressions,this.getPayment().getOtherComment()))
                    errors.add("otherComment",new ActionError("wl.error.noValidChars"));
           }


       }
       */
       return errors;
    }

}
