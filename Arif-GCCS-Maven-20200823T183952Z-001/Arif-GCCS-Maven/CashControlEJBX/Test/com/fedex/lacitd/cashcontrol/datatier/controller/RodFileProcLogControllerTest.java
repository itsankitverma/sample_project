package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RodFileProcLogVO;

public class RodFileProcLogControllerTest {

	RodFileProcLogController rodFileProcLogController = new RodFileProcLogController();
	
	RodFileProcLogVO rodFileProcLogVO = getVO();
	
	public RodFileProcLogVO getVO() {
		RodFileProcLogVO rodFileProcLogVO = new RodFileProcLogVO();
		rodFileProcLogVO.setRodFilePrLogId(7087);
		return rodFileProcLogVO;
	}
	
	@Test
	public void testSetRodFileProcLog() throws BusinessDelegateException {
		rodFileProcLogController.setRodFileProcLog(rodFileProcLogVO);
	}
	
	@Test
	public void testGetRodFileProcLog() throws BusinessDelegateException {
		int rodFilePrLogId = 7087;
		rodFileProcLogController.getRodFileProcLog(rodFilePrLogId);
	}
	
	@Test
	public void testGetAllRodFileProcLogs() throws BusinessDelegateException {
		rodFileProcLogController.getAllRodFileProcLogs();
	}
	
	@Test
	public void testRemoveRodFileProcLog() throws BusinessDelegateException {
		int rodFilePrLogId = 7087;
		rodFileProcLogController.removeRodFileProcLog(rodFilePrLogId);
	}
	
	@Test
	public void testUpdateRodFileProcLog() throws BusinessDelegateException {
		rodFileProcLogController.updateRodFileProcLog(rodFileProcLogVO);
	}
	
	@Test
	public void testGetRodFileProcLogManager() throws BusinessDelegateException {
		rodFileProcLogController.getRodFileProcLogManager();
	}
}
