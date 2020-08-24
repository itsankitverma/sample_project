package com.fedex.lacitd.cashcontrol.prestier.struts.form;

import org.apache.struts.action.*;
import org.apache.commons.collections.*;
import java.util.*;
import com.fedex.lacitd.cashcontrol.biztier.common.*;

/**
 * Prepaid Breakout screen form class
 * @author  ccardenas
 */
public class PrepaidBreakoutForm extends ActionForm implements java.io.Serializable{
	private int prepaidId;
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
    
	/**
	 * @return Returns the prepaidId.
	 */
	public int getPrepaidId() {
		return prepaidId;
	}

	/**
	 * @param prepaidId The prepaidId to set.
	 */
	public void setPrepaidId(int prepaidId) {
		this.prepaidId = prepaidId;
	}

	/**
	 * @return Returns the surcharges.
	 */
	public List getSurcharges() {
		return surcharges;
	}

	private int parentIndex;
	private double parentTotal;
	private double totalCollected;

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

}
