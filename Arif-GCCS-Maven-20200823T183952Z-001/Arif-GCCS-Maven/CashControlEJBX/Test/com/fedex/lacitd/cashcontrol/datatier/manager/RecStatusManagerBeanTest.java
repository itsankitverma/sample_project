package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.RecStatusException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RecStatusVO;

public class RecStatusManagerBeanTest {
	
	RecStatusManagerBean recStatusManagerBean = new RecStatusManagerBean();
	
	RecStatusVO recStatusVO = getVO();
	
	public RecStatusVO getVO() {
		RecStatusVO recStatusVO = new RecStatusVO();
		recStatusVO.setStatusId(1);
		return recStatusVO;
	}
	
	@Test
	public void testSetRecStatus() throws BusinessDelegateException, RecStatusException {
		recStatusManagerBean.setRecStatus(recStatusVO);
	}

	@Test
	public void testGetRecStatus() throws BusinessDelegateException, FinderException {
		int statusId = 1;
		recStatusManagerBean.getRecStatus(statusId);
	}
	
	@Test
	public void testGetAllRecStatus() throws BusinessDelegateException {
		recStatusManagerBean.getAllRecStatus();
	}
	
	@Test
	public void testRemoveRecStatus() throws BusinessDelegateException, RemoveException {
		int statusId = 1;
		recStatusManagerBean.removeRecStatus(statusId);
	}
	
	@Test
	public void testUpdateRecStatus() throws BusinessDelegateException, RecStatusException {
		recStatusManagerBean.updateRecStatus(recStatusVO);
	}
}
