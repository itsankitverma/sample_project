package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.ScanLocProcException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.ScanLocProcVO;
public class ScanLocProcManagerBeanTest {
	
	ScanLocProcManagerBean scanLocProcManagerBean = new ScanLocProcManagerBean();

	ScanLocProcVO scanLocProcVO = getVO();
	
	public ScanLocProcVO getVO() {
		ScanLocProcVO scanLocProcVO = new ScanLocProcVO();
		scanLocProcVO.setScanLocProcId(5);
		return scanLocProcVO;
	}
	
	@Test
	public void testSetScanLocProc() throws BusinessDelegateException, ScanLocProcException {
		scanLocProcManagerBean.setScanLocProc(scanLocProcVO);
	}
	
	@Test
	public void testGetScanLocProc() throws BusinessDelegateException, FinderException {
		int scanLocProcId = 5;
		scanLocProcManagerBean.getScanLocProc(scanLocProcId);
	}
	
	@Test
	public void testGetAllScanLocProcs() throws BusinessDelegateException {
		scanLocProcManagerBean.getAllScanLocProcs();
	}
	
	@Test
	public void testRemoveScanLocProc() throws BusinessDelegateException, RemoveException {
		int scanLocProcId = 5;
		scanLocProcManagerBean.removeScanLocProc(scanLocProcId);
	}
	
	@Test
	public void testUpdateScanLocProc() throws BusinessDelegateException, ScanLocProcException {
		scanLocProcManagerBean.updateScanLocProc(scanLocProcVO);
	}
}

