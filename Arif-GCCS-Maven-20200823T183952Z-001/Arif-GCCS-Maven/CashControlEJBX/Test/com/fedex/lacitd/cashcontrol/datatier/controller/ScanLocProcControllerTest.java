package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ScanLocProcVO;

public class ScanLocProcControllerTest {
	
	ScanLocProcController scanLocProcController = new ScanLocProcController();

	ScanLocProcVO scanLocProcVO = getVO();
	
	public ScanLocProcVO getVO() {
		ScanLocProcVO scanLocProcVO = new ScanLocProcVO();
		scanLocProcVO.setScanLocProcId(5);
		return scanLocProcVO;
	}
	
	@Test
	public void testSetScanLocProc() throws BusinessDelegateException {
		scanLocProcController.setScanLocProc(scanLocProcVO);
	}
	
	@Test
	public void testGetScanLocProc() throws BusinessDelegateException {
		int scanLocProcId = 5;
		scanLocProcController.getScanLocProc(scanLocProcId);
	}
	
	@Test
	public void testGetAllScanLocProcs() throws BusinessDelegateException {
		scanLocProcController.getAllScanLocProcs();
	}
	
	@Test
	public void testRemoveScanLocProc() throws BusinessDelegateException {
		int scanLocProcId = 5;
		scanLocProcController.removeScanLocProc(scanLocProcId);
	}
	
	@Test
	public void testUpdateScanLocProc() throws BusinessDelegateException {
		scanLocProcController.updateScanLocProc(scanLocProcVO);
	}
	
	@Test
	public void testGetScanLocProcManager() throws BusinessDelegateException {
		scanLocProcController.getScanLocProcManager();
	}
}
