package com.fedex.lacitd.cashcontrol.biztier.common;

import java.io.Serializable;

public class StationsAdminVO implements Serializable {

	String fedexId;
	String dateEntered;
	int status;
	String comments;
	String locCode;
	String certificationTypeDescription;

	public StationsAdminVO() {
	}

	/**
	 * @return the fedexId
	 */
	public String getFedexId() {
		return fedexId;
	}

	/**
	 * @param fedexId the fedexId to set
	 */
	public void setFedexId(String fedexId) {
		this.fedexId = fedexId;
	}

	/**
	 * @return the dateEntered
	 */
	public String getDateEntered() {
		return dateEntered;
	}

	/**
	 * @param dateEntered the dateEntered to set
	 */
	public void setDateEntered(String dateEntered) {
		this.dateEntered = dateEntered;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the locCode
	 */
	public String getLocCode() {
		return locCode;
	}

	/**
	 * @param locCode the locCode to set
	 */
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}

	/**
	 * @return the certificationTypeDescription
	 */
	public String getCertificationTypeDescription() {
		return certificationTypeDescription;
	}

	/**
	 * @param certificationTypeDescription the certificationTypeDescription to set
	 */
	public void setCertificationTypeDescription(String certificationTypeDescription) {
		this.certificationTypeDescription = certificationTypeDescription;
	}

}
