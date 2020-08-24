package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.SurchargeLocVO;

public class SurchargeLocControllerTest {
	
	SurchargeLocController surchargeLocController = new SurchargeLocController();

	SurchargeLocVO surchargeLocVO = getVO();
	
	public SurchargeLocVO getVO() {
		SurchargeLocVO surchargeLocVO = new SurchargeLocVO();
		surchargeLocVO.setLocationCd("SYDA");
		surchargeLocVO.setSurchargeCd("Quarantine");
		return surchargeLocVO;
	}
	
	@Test
	public void testSetSurchargeLoc() throws BusinessDelegateException {
		surchargeLocController.setSurchargeLoc(surchargeLocVO);
	}
	
	@Test
	public void testGetSurchargeLoc() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK = new SurchargeLocPK();
		surchargeLocPK.setLocationCd("SYDA");
		surchargeLocPK.setSurchargeCd("Quarantine");
		surchargeLocController.getSurchargeLoc(surchargeLocPK);
	}
	
	@Test
	public void testGetAllSurchargeLocs() throws BusinessDelegateException {
		surchargeLocController.getAllSurchargeLocs();
	}
	
	@Test
	public void testRemoveSurchargeLoc() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK = new SurchargeLocPK();
		surchargeLocPK.setLocationCd("SYDA");
		surchargeLocPK.setSurchargeCd("Quarantine");
		surchargeLocController.removeSurchargeLoc(surchargeLocPK);
	}
	
	@Test
	public void testUpdateSurchargeLoc() throws BusinessDelegateException {
		surchargeLocController.updateSurchargeLoc(surchargeLocVO);
	}
	
	@Test
	public void testGetSurchargeLocManager() throws BusinessDelegateException {
		surchargeLocController.getSurchargeLocManager();
	}
}
