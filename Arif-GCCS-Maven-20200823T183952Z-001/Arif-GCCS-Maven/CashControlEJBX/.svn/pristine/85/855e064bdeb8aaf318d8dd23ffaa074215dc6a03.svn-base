package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.DepTemplVO;

public class DepTemplControllerTest {
	
	DepTemplController depTemplController = new DepTemplController();
	
	DepTemplVO depTemplVO = getVO();
	
	public DepTemplVO getVO() {
		DepTemplVO depTemplVO = new DepTemplVO();
		depTemplVO.setTemplId(167);
		depTemplVO.setTemplCd("OTHUSDCK2");
		return depTemplVO;
	}

	@Test
	public void testSetDepTempl() throws BusinessDelegateException {
		depTemplController.setDepTempl(depTemplVO);
	}
	
	@Test
	public void testGetDepTempl() throws BusinessDelegateException {
		int templId = 167;
		depTemplController.getDepTempl(templId);
	}
	
	@Test
	public void testAddLocation() throws BusinessDelegateException {
		int templId = 167;
		String locationCd = null;
		depTemplController.addLocation(templId, locationCd);
	}
	
	@Test
	public void testRemoveLocation() throws BusinessDelegateException {
		int templId = 167;
		String locationCd = null;
		depTemplController.removeLocation(templId, locationCd);
	}
	
	@Test
	public void testGetLocations() throws BusinessDelegateException {
		int templId = 167;
		depTemplController.getLocations(templId);
	}
	
	@Test
	public void testAddPaymentType() throws BusinessDelegateException {
		int templId = 167;
		int paymentTypeId = 0;
		depTemplController.addPaymentType(templId, paymentTypeId);
	}
	
	@Test
	public void testRemovePaymentType() throws BusinessDelegateException {
		int templId = 167;
		int paymentTypeId = 0;
		depTemplController.removePaymentType(templId, paymentTypeId);
	}
	
	@Test
	public void testGetPaymentTypes() throws BusinessDelegateException {
		int templId = 167;
		depTemplController.getPaymentTypes(templId);
	}
	
	@Test
	public void testGetAllDepTempls() throws BusinessDelegateException {
		depTemplController.getAllDepTempls();
	}
	
	@Test
	public void testGetAllActiveDepTempls() throws BusinessDelegateException {
		depTemplController.getAllActiveDepTempls();
	}
	
	@Test
	public void testGetDepTemplDepTemplsbyCode() throws BusinessDelegateException {
		String templCd = "OTHUSDCK2";
		depTemplController.getDepTemplDepTemplsbyCode(templCd);
	}
	
	@Test
	public void testRemoveDepTempl() throws BusinessDelegateException {
		int templId = 167;
		depTemplController.removeDepTempl(templId);
	}
	
	@Test
	public void testUpdateDepTempl() throws BusinessDelegateException {
		depTemplController.updateDepTempl(depTemplVO);
	}
	
	@Test
	public void testGetDepTemplManager() throws BusinessDelegateException {
		depTemplController.getDepTemplManager();
	}
}
