package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PaymentTypeException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PaymentTypeVO;
public class PaymentTypeManagerBeanTest {

	PaymentTypeManagerBean paymentTypeManagerBean = new PaymentTypeManagerBean();
	
	PaymentTypeVO paymentTypeVO = getVO();
	
	public PaymentTypeVO getVO() {
		PaymentTypeVO paymentTypeVO = new PaymentTypeVO();
		paymentTypeVO.setPaymentTypeId(151);
		return paymentTypeVO;
	}
	
	@Test
	public void testSetPaymentType() throws BusinessDelegateException, PaymentTypeException {
		paymentTypeManagerBean.setPaymentType(paymentTypeVO);
	}
	
	@Test
	public void testGetPaymentType() throws BusinessDelegateException, FinderException {
		int paymentTypeId = 151;
		paymentTypeManagerBean.getPaymentType(paymentTypeId);
	}
	
	@Test
	public void testAddLocation() throws BusinessDelegateException, PaymentTypeException {
		int paymentTypeId = 151;
		String locationCd = null;
		paymentTypeManagerBean.addLocation(paymentTypeId, locationCd);
	}
	
	@Test
	public void testRemoveLocation() throws BusinessDelegateException, PaymentTypeException {
		int paymentTypeId = 151;
		String locationCd = null;
		paymentTypeManagerBean.removeLocation(paymentTypeId, locationCd);
	}
	
	@Test
	public void testGetLocations() throws BusinessDelegateException, PaymentTypeException {
		int paymentTypeId = 151;
		paymentTypeManagerBean.getLocations(paymentTypeId);
	}
	
	@Test
	public void testAddDepTempl() throws BusinessDelegateException, PaymentTypeException {
		int paymentTypeId = 151;
		int templId = 0;
		paymentTypeManagerBean.addDepTempl(paymentTypeId, templId);
	}
	
	@Test
	public void testRemoveDepTempl() throws BusinessDelegateException, PaymentTypeException {
		int paymentTypeId = 151;
		int templId = 0;
		paymentTypeManagerBean.removeDepTempl(paymentTypeId, templId);
	}
	
	@Test
	public void testGetDepTempls() throws BusinessDelegateException, PaymentTypeException {
		int paymentTypeId = 151;
		paymentTypeManagerBean.getDepTempls(paymentTypeId);
	}
	
	@Test
	public void testGetAllPaymentTypes() throws BusinessDelegateException {
		paymentTypeManagerBean.getAllPaymentTypes();
	}
	
	@Test
	public void testGetAllActivePaymentTypes() throws BusinessDelegateException {
		paymentTypeManagerBean.getAllActivePaymentTypes();
	}
	
	@Test
	public void testGetPaymentTypeByRodLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeManagerBean.getPaymentTypeByRodLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByCodLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeManagerBean.getPaymentTypeByCodLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByFtcLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeManagerBean.getPaymentTypeByFtcLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByPrpLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeManagerBean.getPaymentTypeByPrpLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByPoaLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeManagerBean.getPaymentTypeByPrpLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByOtherLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeManagerBean.getPaymentTypeByOtherLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeManagerBean.getPaymentTypeByLocation(locationCd);
	}
	
	@Test
	public void testGetPaymentTypeByCode() throws BusinessDelegateException {
		String paymentCd = null;
		paymentTypeManagerBean.getPaymentTypeByCode(paymentCd);
	}
	
	@Test
	public void testGetPaymentTypeByGndLocation() throws BusinessDelegateException {
		String locationCd = null;
		paymentTypeManagerBean.getPaymentTypeByGndLocation(locationCd);
	}
	
	@Test
	public void testRemovePaymentType() throws BusinessDelegateException, RemoveException {
		int paymentTypeId = 0;
		paymentTypeManagerBean.removePaymentType(paymentTypeId);
	}
	
	@Test
	public void testUpdatePaymentType() throws BusinessDelegateException, PaymentTypeException {
		paymentTypeManagerBean.updatePaymentType(paymentTypeVO);
	}
}