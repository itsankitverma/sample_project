package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PrepaidVO;

public class PrepaidControllerTest {
	
	PrepaidController prepaidController = new PrepaidController();

	PrepaidVO prepaidVO = getVO();
	
	public PrepaidVO getVO() {
		PrepaidVO prepaidVO = new PrepaidVO();
		prepaidVO.setPrepaidId(108251);
		return prepaidVO;
	}
	
	@Test
	public void testSetPrepaid() throws BusinessDelegateException {
		prepaidController.setPrepaid(prepaidVO);
	}
	
	@Test
	public void testGetPrepaid() throws BusinessDelegateException {
		int prepaidId = 108251;
		prepaidController.getPrepaid(prepaidId);
	}
	
	@Test
	public void testGetAllPrepaids() throws BusinessDelegateException {
		prepaidController.getAllPrepaids();
	}
	
	
	@Test
	public void testGetPrepaidPrepaidByAwbNbr() throws BusinessDelegateException {
		String awbNbr = null;
		prepaidController.getPrepaidPrepaidByAwbNbr(awbNbr);
	}
	
	@Test
	public void testGetPrepaidByEodId() throws BusinessDelegateException {
		int eodId = 0;
		prepaidController.getPrepaidByEodId(eodId);
	}
	
	@Test
	public void testGetPrepaidPRPWithoutScan() throws BusinessDelegateException {
		String courierId = null;
		String locationCd = null;
		int statusId = 0;
		prepaidController.getPrepaidPRPWithoutScan(courierId, locationCd, statusId);
	}
	
	@Test
	public void testGetPrepaidPRPQueryCosmos() throws BusinessDelegateException {
		String locationCd = null;
		int statusId = 0;
		prepaidController.getPrepaidPRPQueryCosmos(locationCd, statusId);
	}
	
	@Test
	public void testRemovePrepaid() throws BusinessDelegateException {
		int prepaidId = 0;
		prepaidController.removePrepaid(prepaidId);
	}
	
	@Test
	public void testUpdatePrepaid() throws BusinessDelegateException {
		prepaidController.updatePrepaid(prepaidVO);
	}
	
	@Test
	public void testGetPrepaidManager() throws BusinessDelegateException {
		prepaidController.getPrepaidManager();
	}
	
}
