package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PoaSurchargesVO;

public class PoaSurchargesControllerTest {
	
	PoaSurchargesController poaSurchargesController = new PoaSurchargesController();

	PoaSurchargesVO poaSurchargesVO = getVO();
	
	public PoaSurchargesVO getVO() {
		PoaSurchargesVO poaSurchargesVO = new PoaSurchargesVO();
		poaSurchargesVO.setPoaDetailId(4925250);
		poaSurchargesVO.setSurchargeCd("APPLAMT");
		poaSurchargesVO.setAppliedAmt(15.2);
		return poaSurchargesVO;
	}
	
	@Test
	public void testSetPoaSurcharges() throws BusinessDelegateException {
		poaSurchargesController.setPoaSurcharges(poaSurchargesVO);
	}
	
	@Test
	public void testGetPoaSurcharges() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK poaSurchargesPK = new PoaSurchargesPK();
		poaSurchargesPK.setPoaDetailId(4925250);
		poaSurchargesPK.setSurchargeCd("APPLAMT");
		poaSurchargesController.getPoaSurcharges(poaSurchargesPK);
	}
	
	@Test
	public void testGetAllPoaSurcharges() throws BusinessDelegateException {
		poaSurchargesController.getAllPoaSurcharges();
	}
	
	@Test
	public void testGetPoaSurchargesByPoaDetail() throws BusinessDelegateException {
		int poaDetailId = 4925250;
		poaSurchargesController.getPoaSurchargesByPoaDetail(poaDetailId);
	}
	
	@Test
	public void testRemovePoaSurcharges() throws BusinessDelegateException {
		PoaSurchargesPK poaSurchargesPK = new PoaSurchargesPK();
		poaSurchargesPK.setPoaDetailId(4925250);
		poaSurchargesPK.setSurchargeCd("APPLAMT");
		poaSurchargesController.removePoaSurcharges(poaSurchargesPK);
	}
	
	@Test
	public void testUpdatePoaSurcharges() throws BusinessDelegateException {
		poaSurchargesController.updatePoaSurcharges(poaSurchargesVO);
	}
	
	@Test
	public void testGetPoaSurchargesManager() throws BusinessDelegateException {
		poaSurchargesController.getPoaSurchargesManager();
	}
}
