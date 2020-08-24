package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PymtImptLogVO;

public class PymtImptLogControllerTest {

	PymtImptLogController pymtImptLogController = new PymtImptLogController();
	
	PymtImptLogVO pymtImptLogVO = getVO();
	
	public PymtImptLogVO getVO() {
		PymtImptLogVO pymtImptLogVO = new PymtImptLogVO();
		pymtImptLogVO.setImptId(372);
		return pymtImptLogVO;
	}
	
	@Test
	public void testSetPymtImptLog() throws BusinessDelegateException {
		pymtImptLogController.setPymtImptLog(pymtImptLogVO);
	}
	
	@Test
	public void testGetPymtImptLog() throws BusinessDelegateException {
		int imptId = 372;
		pymtImptLogController.getPymtImptLog(imptId);
	}
	
	@Test
	public void testGetPymtImptErrorDtls() throws BusinessDelegateException {
		int imptId = 372;
		pymtImptLogController.getPymtImptErrorDtls(imptId);
	}
	
	@Test
	public void testGgetAllPymtImptLogs() throws BusinessDelegateException {
		pymtImptLogController.getAllPymtImptLogs();
	}
	
	@Test
	public void testRemovePymtImptLog() throws BusinessDelegateException {
		int imptId = 372;
		pymtImptLogController.removePymtImptLog(imptId);
	}
	
	@Test
	public void testUpdatePymtImptLog() throws BusinessDelegateException {
		pymtImptLogController.updatePymtImptLog(pymtImptLogVO);
	}
	
	@Test
	public void testgetPymtImptLogManager() throws BusinessDelegateException {
		pymtImptLogController.getPymtImptLogManager();
	}
}
