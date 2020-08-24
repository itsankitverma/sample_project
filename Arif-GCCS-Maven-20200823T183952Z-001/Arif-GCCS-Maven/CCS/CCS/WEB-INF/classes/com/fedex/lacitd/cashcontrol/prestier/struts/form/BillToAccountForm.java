package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.ActionForm;

public class BillToAccountForm extends ActionForm implements java.io.Serializable{

	private String billToAccountNbr;
	
	/** Getter for property billAccountNbr.
     * @return Value of property billAccountNbr.
     */
    public String getBillToAccountNbr() {
        return this.billToAccountNbr;
    }
    
    /** Setter for property billAccountNbr.
     * @param billAccountNbr New value of property billAccountNbr.
     */
    public void setBillToAccountNbr(String billToAccountNbr) {
        this.billToAccountNbr = billToAccountNbr;
    }
	

}
