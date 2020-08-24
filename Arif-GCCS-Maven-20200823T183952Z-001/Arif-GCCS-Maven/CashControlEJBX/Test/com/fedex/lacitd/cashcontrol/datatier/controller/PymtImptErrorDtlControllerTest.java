package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PymtImptErrorDtlVO;

public class PymtImptErrorDtlControllerTest {

	PymtImptErrorDtlController pymtImptErrorDtlController = new PymtImptErrorDtlController();
	
	PymtImptErrorDtlVO pymtImptErrorDtlVO = getVO();
	
	public PymtImptErrorDtlVO getVO() {
		PymtImptErrorDtlVO pymtImptErrorDtlVO = new PymtImptErrorDtlVO();
		pymtImptErrorDtlVO.setImptId(375);
		return pymtImptErrorDtlVO;
	}
	
	@Test
	public void testSetPymtImptErrorDtl() throws BusinessDelegateException {
		pymtImptErrorDtlController.setPymtImptErrorDtl(pymtImptErrorDtlVO);
	}
	
	@Test
	public void testGetPymtImptErrorDtl() throws BusinessDelegateException {
		int imptErrorDtlId = 375;
		pymtImptErrorDtlController.getPymtImptErrorDtl(imptErrorDtlId);
	}
	
	@Test
	public void testGetAllPymtImptErrorDtls() throws BusinessDelegateException {
		pymtImptErrorDtlController.getAllPymtImptErrorDtls();
	}
	
	@Test
	public void testRemovePymtImptErrorDtl() throws BusinessDelegateException {
		int imptErrorDtlId = 375;
		pymtImptErrorDtlController.removePymtImptErrorDtl(imptErrorDtlId);
	}
	
	@Test
	public void testUpdatePymtImptErrorDtl() throws BusinessDelegateException {
		pymtImptErrorDtlController.updatePymtImptErrorDtl(pymtImptErrorDtlVO);
	}
	
	@Test
	public void testGetPymtImptErrorDtlManager() throws BusinessDelegateException {
		pymtImptErrorDtlController.getPymtImptErrorDtlManager();
	}
	
}
