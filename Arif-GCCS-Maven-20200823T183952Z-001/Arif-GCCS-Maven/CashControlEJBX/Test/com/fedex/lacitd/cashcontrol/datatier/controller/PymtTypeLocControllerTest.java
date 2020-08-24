package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PymtTypeLocVO;

public class PymtTypeLocControllerTest {
	
	PymtTypeLocController pymtTypeLocController = new PymtTypeLocController();

	PymtTypeLocVO pymtTypeLocVO = getVO();
	
	public PymtTypeLocVO getVO() {
		PymtTypeLocVO pymtTypeLocVO = new PymtTypeLocVO();
		pymtTypeLocVO.setLocationCd("JCJA");
		pymtTypeLocVO.setPaymentTypeId(26);
		return pymtTypeLocVO;
	}
	
	@Test
	public void testSetPymtTypeLoc() throws BusinessDelegateException {
		pymtTypeLocController.setPymtTypeLoc(pymtTypeLocVO);
	}
	
	@Test
	public void testGetPymtTypeLoc() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK = new PymtTypeLocPK();
		pymtTypeLocPK.setLocationCd("JCJA");
		pymtTypeLocPK.setPaymentTypeId(26);
		pymtTypeLocController.getPymtTypeLoc(pymtTypeLocPK);
	}
	
	@Test
	public void testGetAllPymtTypeLocs() throws BusinessDelegateException {
		pymtTypeLocController.getAllPymtTypeLocs();
	}
	
	@Test
	public void testGetPymtTypeLocLocationsByPayment() throws BusinessDelegateException {
		int ptId = 26;
		pymtTypeLocController.getPymtTypeLocLocationsByPayment(ptId);
	}
	
	@Test
	public void testRemovePymtTypeLoc() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK = new PymtTypeLocPK();
		pymtTypeLocPK.setLocationCd("JCJA");
		pymtTypeLocPK.setPaymentTypeId(26);
		pymtTypeLocController.removePymtTypeLoc(pymtTypeLocPK);
	}
	
	@Test
	public void testUpdatePymtTypeLoc() throws BusinessDelegateException {
		pymtTypeLocController.updatePymtTypeLoc(pymtTypeLocVO);
	}
	
	@Test
	public void testgetPymtTypeLocManager() throws BusinessDelegateException {
		pymtTypeLocController.getPymtTypeLocManager();
	}
}
