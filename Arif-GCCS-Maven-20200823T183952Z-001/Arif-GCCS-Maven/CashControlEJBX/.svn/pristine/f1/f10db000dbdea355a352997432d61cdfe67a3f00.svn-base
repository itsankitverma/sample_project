package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PaymentTypeVO;

public class PaymentTypeControllerTest {

	PaymentTypeController paymentTypeController = new PaymentTypeController();
	
	PaymentTypeVO paymentTypeVO = getVO();
	
	public PaymentTypeVO getVO() {
		PaymentTypeVO paymentTypeVO = new PaymentTypeVO();
		paymentTypeVO.setPaymentTypeId(151);
		return paymentTypeVO;
	}
	
	@Test
	public void testSetPaymentType() throws BusinessDelegateException {
		paymentTypeController.setPaymentType(paymentTypeVO);
	}
	
	@Test
	public void testGetPaymentType() throws BusinessDelegateException {
		int paymentTypeId = 151;
		paymentTypeController.getPaymentType(paymentTypeId);
	}
	
	@Test
	public void testAddLocation() throws BusinessDelegateException {
		int paymentTypeId = 151;
		String locationCd = null;
		paymentTypeController.addLocation(paymentTypeId, locationCd);
	}
	
	@Test
	public void testRemoveLocation() throws BusinessDelegateException {
		int paymentTypeId = 151;
		String locationCd = null;
		paymentTypeController.removeLocation(paymentTypeId, locationCd);
	}
	
	@Test
	public void testGetLocations() throws BusinessDelegateException {
		int paymentTypeId = 151;
		paymentTypeController.getLocations(paymentTypeId);
	}
	
	@Test
	public void testAddDepTempl() throws BusinessDelegateException {
		int paymentTypeId = 151;
		int templId = 0;
		paymentTypeController.addDepTempl(paymentTypeId, templId);
	}
	
	@Test
	public void testRemoveDepTempl() throws BusinessDelegateException {
		int paymentTypeId = 151;
		int templId = 0;
		paymentTypeController.removeDepTempl(paymentTypeId, templId);
	}
	
	@Test
	public void testGetDepTempls() throws BusinessDelegateException {
		int paymentTypeId = 151;
		paymentTypeController.getDepTempls(paymentTypeId);
	}
	
	@Test
	public void testGetAllPaymentTypes() throws BusinessDelegateException {
		paymentTypeController.getAllPaymentTypes();
	}
	
	@Test
	public void testGetAllActivePaymentTypes() throws BusinessDelegateException {
		paymentTypeController.getAllActivePaymentTypes();
	}
	
	@Test
	public void testGetPaymentTypeByRodLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeController.getPaymentTypeByRodLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByCodLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeController.getPaymentTypeByCodLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByFtcLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeController.getPaymentTypeByFtcLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByPrpLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeController.getPaymentTypeByPrpLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByPoaLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeController.getPaymentTypeByPrpLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByOtherLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeController.getPaymentTypeByOtherLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeController.getPaymentTypeByLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByCode() throws BusinessDelegateException {
		String paymentCd = null;
		paymentTypeController.getPaymentTypeByCode(paymentCd);
	}
	
	@Test
	public void testGetPaymentTypeByGndLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeController.getPaymentTypeByGndLocation(locationCd);
	}
	
	@Test
	public void testRemovePaymentType() throws BusinessDelegateException {
		int paymentTypeId = 0;
		paymentTypeController.removePaymentType(paymentTypeId);
	}
	
	@Test
	public void testUpdatePaymentType() throws BusinessDelegateException {
		paymentTypeController.updatePaymentType(paymentTypeVO);
	}
	
	@Test
	public void testGetPaymentTypeManager() throws BusinessDelegateException {
		paymentTypeController.getPaymentTypeManager();
	}
}
