package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.RodFileProcLogException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RodFileProcLogVO;

public class RodFileProcLogManagerBeanTest {

	RodFileProcLogManagerBean rodFileProcLogManagerBean = new RodFileProcLogManagerBean();
	
	RodFileProcLogVO rodFileProcLogVO = getVO();
	
	public RodFileProcLogVO getVO() {
		RodFileProcLogVO rodFileProcLogVO = new RodFileProcLogVO();
		rodFileProcLogVO.setRodFilePrLogId(7087);
		return rodFileProcLogVO;
	}
	
	@Test
	public void testSetRodFileProcLog() throws BusinessDelegateException, RodFileProcLogException {
		rodFileProcLogManagerBean.setRodFileProcLog(rodFileProcLogVO);
	}
	
	@Test
	public void testGetRodFileProcLog() throws BusinessDelegateException, FinderException {
		int rodFilePrLogId = 7087;
		rodFileProcLogManagerBean.getRodFileProcLog(rodFilePrLogId);
	}
	
	@Test
	public void testGetAllRodFileProcLogs() throws BusinessDelegateException {
		rodFileProcLogManagerBean.getAllRodFileProcLogs();
	}
	
	@Test
	public void testRemoveRodFileProcLog() throws BusinessDelegateException, RemoveException {
		int rodFilePrLogId = 7087;
		rodFileProcLogManagerBean.removeRodFileProcLog(rodFilePrLogId);
	}
	
	@Test
	public void testUpdateRodFileProcLog() throws BusinessDelegateException, RodFileProcLogException {
		rodFileProcLogManagerBean.updateRodFileProcLog(rodFileProcLogVO);
	}
}

