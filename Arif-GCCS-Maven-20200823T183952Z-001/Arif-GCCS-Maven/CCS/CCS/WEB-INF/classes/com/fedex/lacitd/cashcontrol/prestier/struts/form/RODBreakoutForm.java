package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;
import java.util.*;
import org.apache.commons.collections.*;


/**
 * ROD Breakouts screen form class
 * @author  ccardenas
 */
public class RODBreakoutForm extends ActionForm implements java.io.Serializable{
	private int recId;
	private double totalExpected;
	private double totalCollected;
	private double parentTotal;
	private int parentIndex;
	private List surcharges=ListUtils.lazyList(new ArrayList(),new Factory() {
		public Object create() {
			return new GenericSurchargeVO();
		}
	} );
	
	public void setSurcharges(List receivables){
		this.surcharges = ListUtils.lazyList(receivables,new Factory() {
			public Object create() {
				return new GenericSurchargeVO();
			}
		} );
	}

	public List getSurcharges(){
		return surcharges;
	}	
	
    
	/**
	 * @return Returns the recId.
	 */
	public int getRecId() {
		return recId;
	}

	/**
	 * @param recId The recId to set.
	 */
	public void setRecId(int recId) {
		this.recId = recId;
	}

	/**
	 * @return Returns the totalCollected.
	 */
	public double getTotalCollected() {
		return totalCollected;
	}

	/**
	 * @param totalCollected The totalCollected to set.
	 */
	public void setTotalCollected(double totalCollected) {
		this.totalCollected = totalCollected;
	}

	/**
	 * @return Returns the totalExpected.
	 */
	public double getTotalExpected() {
		return totalExpected;
	}

	/**
	 * @param totalExpected The totalExpected to set.
	 */
	public void setTotalExpected(double totalExpected) {
		this.totalExpected = totalExpected;
	}

	/**
	 * @return Returns the parentTotal.
	 */
	public double getParentTotal() {
		return parentTotal;
	}

	/**
	 * @param parentTotal The parentTotal to set.
	 */
	public void setParentTotal(double parentTotal) {
		this.parentTotal = parentTotal;
	}

	/**
	 * @return Returns the parentIndex.
	 */
	public int getParentIndex() {
		return parentIndex;
	}

	/**
	 * @param parentIndex The parentIndex to set.
	 */
	public void setParentIndex(int parentIndex) {
		this.parentIndex = parentIndex;
	}

	private double ancCharges;
	private double rodAmt;

	/**
	 * @return Returns the ancCharges.
	 */
	public double getAncCharges() {
		return ancCharges;
	}

	/**
	 * @param ancCharges The ancCharges to set.
	 */
	public void setAncCharges(double ancCharges) {
		this.ancCharges = ancCharges;
	}

	/**
	 * @return Returns the rodAmt.
	 */
	public double getRodAmt() {
		return rodAmt;
	}

	/**
	 * @param rodAmt The rodAmt to set.
	 */
	public void setRodAmt(double rodAmt) {
		this.rodAmt = rodAmt;
	}

}
