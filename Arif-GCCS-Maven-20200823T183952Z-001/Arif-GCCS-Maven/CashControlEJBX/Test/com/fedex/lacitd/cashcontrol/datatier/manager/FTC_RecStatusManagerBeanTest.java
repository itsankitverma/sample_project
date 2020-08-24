package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.FTC_RecStatusException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.FTC_RecStatusVO;

public class FTC_RecStatusManagerBeanTest {
	
	FTC_RecStatusManagerBean ftc_RecStatusManagerBean = new FTC_RecStatusManagerBean();
	
	FTC_RecStatusVO FTC_recStatusVO = getVO();
	
	public FTC_RecStatusVO getVO() {
		FTC_RecStatusVO FTC_recStatusVO = new FTC_RecStatusVO();
		FTC_recStatusVO.setStatusId(1);
		return FTC_recStatusVO;
	}

	@Test
	public void testSetFTC_RecStatus() throws BusinessDelegateException, FTC_RecStatusException {
		ftc_RecStatusManagerBean.setFTC_RecStatus(FTC_recStatusVO);
	}
	
	@Test
	public void testGetFTC_RecStatus() throws BusinessDelegateException, FinderException {
		int statusId = 1;
		ftc_RecStatusManagerBean.getFTC_RecStatus(statusId);
	}
	
	@Test
	public void testGetAllFTC_RecStatus() throws BusinessDelegateException {
		ftc_RecStatusManagerBean.getAllFTC_RecStatus();
	}
	
	@Test
	public void testRemoveFTC_RecStatus() throws BusinessDelegateException, RemoveException {
		int statusId = 1;
		ftc_RecStatusManagerBean.removeFTC_RecStatus(statusId);
	}
	
	@Test
	public void testUpdateFTC_RecStatus() throws BusinessDelegateException, FTC_RecStatusException {
		ftc_RecStatusManagerBean.updateFTC_RecStatus(FTC_recStatusVO);
	}
}
