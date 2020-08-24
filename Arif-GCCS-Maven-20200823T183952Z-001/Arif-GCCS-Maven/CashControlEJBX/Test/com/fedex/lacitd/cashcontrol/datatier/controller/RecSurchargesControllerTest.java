package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RecSurchargesVO;

public class RecSurchargesControllerTest {
	
	RecSurchargesController recSurchargesController = new RecSurchargesController();

	RecSurchargesVO recSurchargesVO = new RecSurchargesVO();
	
	public RecSurchargesVO getVO() {
		RecSurchargesVO recSurchargesVO = new RecSurchargesVO();
		recSurchargesVO.setRecId(14660836);
		recSurchargesVO.setAppliedAmt(300);
		recSurchargesVO.setSurchargeCd("SERVTAX");
		return recSurchargesVO;
	}
	
	@Test
	public void testSetRecSurcharges() throws BusinessDelegateException {
		recSurchargesController.setRecSurcharges(recSurchargesVO);
	}
	
	@Test
	public void testGetRecSurcharges() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK recSurchargesPK = new RecSurchargesPK();
		recSurchargesPK.setRecId(14660836);
		recSurchargesPK.setSurchargeCd("SERVTAX");
		recSurchargesController.getRecSurcharges(recSurchargesPK);
	}
	
	@Test
	public void testGetAllRecSurcharges() throws BusinessDelegateException {
		recSurchargesController.getAllRecSurcharges();
	}
	
	@Test
	public void testGetRecSurchargesByReceivable() throws BusinessDelegateException {
		int recId = 14660836;
		recSurchargesController.getRecSurchargesByReceivable(recId);
	}
	
	@Test
	public void testRemoveRecSurcharges() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.RecSurchargesPK recSurchargesPK = new RecSurchargesPK();
		recSurchargesPK.setRecId(14660836);
		recSurchargesPK.setSurchargeCd("SERVTAX");
		recSurchargesController.removeRecSurcharges(recSurchargesPK);
	}
	
	@Test
	public void testUpdateRecSurcharges() throws BusinessDelegateException {
		recSurchargesController.updateRecSurcharges(recSurchargesVO);
	}
	
	@Test
	public void testGetRecSurchargesManager() throws BusinessDelegateException {
		recSurchargesController.getRecSurchargesManager();
	}
}
