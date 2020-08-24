package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.SurchargesVO;

public class SurchargesControllerTest {

	SurchargesController surchargesController = new SurchargesController();
	
	SurchargesVO surchargesVO = getVO();
	
	public SurchargesVO getVO() {
		SurchargesVO surchargesVO = new SurchargesVO();
		surchargesVO.setSurchargeCd("PrePayment");
		return surchargesVO;
	}
	
	@Test
	public void testSetSurcharges() throws BusinessDelegateException {
		surchargesController.setSurcharges(surchargesVO);
	}
	
	@Test
	public void testGetSurcharges() throws BusinessDelegateException {
		String surchargeCd = "PrePayment";
		surchargesController.getSurcharges(surchargeCd);
	}
	
	@Test
	public void testGetAllSurcharges() throws BusinessDelegateException {
		surchargesController.getAllSurcharges();
	}
	
	@Test
	public void testGetSurchargesByRod() throws BusinessDelegateException {
		String locationCd = "BOMA";
		surchargesController.getSurchargesByRod(locationCd);
	}
	
	@Test
	public void testGetSurchargesByPrepaid() throws BusinessDelegateException {
		String locationCd = "BOMA";
		surchargesController.getSurchargesByPrepaid(locationCd);
	}
	
	@Test
	public void testGetSurchargesByPoa() throws BusinessDelegateException {
		String locationCd = "BOMA";
		surchargesController.getSurchargesByPoa(locationCd);
	}
	
	@Test
	public void testRemoveSurcharges() throws BusinessDelegateException {
		String surchargeCd = "PrePayment";
		surchargesController.removeSurcharges(surchargeCd);
	}
	
	@Test
	public void testUpdateSurcharges() throws BusinessDelegateException {
		surchargesController.updateSurcharges(surchargesVO);
	}
	
	@Test
	public void testGetSurchargesManager() throws BusinessDelegateException {
		surchargesController.getSurchargesManager();
	}
}
