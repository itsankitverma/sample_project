package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PymtImptLogException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PymtImptLogVO;

public class PymtImptLogManagerBeanTest {

	PymtImptLogManagerBean pymtImptLogManagerBean = new PymtImptLogManagerBean();
	
	PymtImptLogVO pymtImptLogVO = getVO();
	
	public PymtImptLogVO getVO() {
		PymtImptLogVO pymtImptLogVO = new PymtImptLogVO();
		pymtImptLogVO.setImptId(372);
		return pymtImptLogVO;
	}
	
	@Test
	public void testSetPymtImptLog() throws BusinessDelegateException, PymtImptLogException {
		pymtImptLogManagerBean.setPymtImptLog(pymtImptLogVO);
	}
	
	@Test
	public void testGetPymtImptLog() throws BusinessDelegateException, FinderException {
		int imptId = 372;
		pymtImptLogManagerBean.getPymtImptLog(imptId);
	}
	
	@Test
	public void testGetPymtImptErrorDtls() throws BusinessDelegateException, PymtImptLogException {
		int imptId = 372;
		pymtImptLogManagerBean.getPymtImptErrorDtls(imptId);
	}
	
	@Test
	public void testGgetAllPymtImptLogs() throws BusinessDelegateException {
		pymtImptLogManagerBean.getAllPymtImptLogs();
	}
	
	@Test
	public void testRemovePymtImptLog() throws BusinessDelegateException, RemoveException {
		int imptId = 372;
		pymtImptLogManagerBean.removePymtImptLog(imptId);
	}
	
	@Test
	public void testUpdatePymtImptLog() throws BusinessDelegateException, PymtImptLogException {
		pymtImptLogManagerBean.updatePymtImptLog(pymtImptLogVO);
	}
}
