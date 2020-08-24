package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PrepSurchargesVO;

public class PrepSurchargesControllerTest {
	
	PrepSurchargesController prepSurchargesController = new PrepSurchargesController();
	
	PrepSurchargesVO prepSurchargesVO = getVO();
	
	public PrepSurchargesVO getVO() {
		PrepSurchargesVO prepSurchargesVO = new PrepSurchargesVO();
		return prepSurchargesVO;
	}

	@Test
	public void testSetPrepSurcharges() throws BusinessDelegateException {
		PrepSurchargesVO prepSurchargesVO = new PrepSurchargesVO();
		prepSurchargesController.setPrepSurcharges(prepSurchargesVO);
	}

	@Test
	public void testGetPrepSurcharges() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK = new PrepSurchargesPK();
		prepSurchargesController.getPrepSurcharges(prepSurchargesPK);
	}
	
	@Test
	public void testGetAllPrepSurcharges() throws BusinessDelegateException {
		prepSurchargesController.getAllPrepSurcharges();
	}
	
	@Test
	public void testGetPrepSurchargesByPrepaid() throws BusinessDelegateException {
		int prepId = 0;
		prepSurchargesController.getPrepSurchargesByPrepaid(prepId);
	}
	
	@Test
	public void testRemovePrepSurcharges() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK = new PrepSurchargesPK();
		prepSurchargesController.removePrepSurcharges(prepSurchargesPK);
	}
	
	@Test
	public void testUpdatePrepSurcharges() throws BusinessDelegateException {
		PrepSurchargesVO prepSurchargesVO = new PrepSurchargesVO();
		prepSurchargesController.updatePrepSurcharges(prepSurchargesVO);
	}
	
	@Test
	public void testGetPrepSurchargesManager() throws BusinessDelegateException {
		prepSurchargesController.getPrepSurchargesManager();
	}
}
