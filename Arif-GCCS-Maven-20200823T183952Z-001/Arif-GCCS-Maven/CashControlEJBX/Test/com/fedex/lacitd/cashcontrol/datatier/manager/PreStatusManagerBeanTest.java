package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PreStatusException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PreStatusVO;

public class PreStatusManagerBeanTest {
	
	PreStatusManagerBean preStatusManagerBean = new PreStatusManagerBean();

	PreStatusVO preStatusVO = getVO();
	
	public PreStatusVO getVO() {
		PreStatusVO preStatusVO = new PreStatusVO();
		preStatusVO.setStatusIdNbr(1);
		return preStatusVO;
	}
	
	@Test
	public void testSetPreStatus() throws BusinessDelegateException, PreStatusException {
		preStatusManagerBean.setPreStatus(preStatusVO);
	}
	
	@Test
	public void testGetPreStatus() throws BusinessDelegateException, FinderException {
		int statusIdNbr = 1;
		preStatusManagerBean.getPreStatus(statusIdNbr);
	}
	
	@Test
	public void testGetAllPreStatus() throws BusinessDelegateException {
		preStatusManagerBean.getAllPreStatus();
	}
	
	@Test
	public void testRemovePreStatus() throws BusinessDelegateException, RemoveException {
		int statusIdNbr = 1;
		preStatusManagerBean.removePreStatus(statusIdNbr);
	}
	
	@Test
	public void testUpdatePreStatus() throws BusinessDelegateException, PreStatusException {
		preStatusManagerBean.updatePreStatus(preStatusVO);
	}
}
