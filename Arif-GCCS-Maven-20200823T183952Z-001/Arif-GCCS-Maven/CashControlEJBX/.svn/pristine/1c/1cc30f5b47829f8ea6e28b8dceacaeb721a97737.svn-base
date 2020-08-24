package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.OtherPymtCtgException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.OtherPymtCtgVO;
public class OtherPymtCtgManagerBeanTest {
	OtherPymtCtgManagerBean otherPymtCtgManagerBean = new OtherPymtCtgManagerBean();
	
	OtherPymtCtgVO otherPymtCtgVO = getVO();
	
	public OtherPymtCtgVO getVO() {
		OtherPymtCtgVO otherPymtCtgVO = new OtherPymtCtgVO();
		otherPymtCtgVO.setOtherPaymentCtgId(301);
		return otherPymtCtgVO;
	}
	
	@Test
	public void testSetOtherPymtCtg() throws BusinessDelegateException, OtherPymtCtgException {
		otherPymtCtgManagerBean.setOtherPymtCtg(otherPymtCtgVO);
	}
	
	public void testGetOtherPymtCtg() throws BusinessDelegateException, FinderException {
		int otherPaymentCtgId = 301;
		otherPymtCtgManagerBean.getOtherPymtCtg(otherPaymentCtgId);
	}
	
	public void testGetAllPaymentCtgs() throws BusinessDelegateException {
		otherPymtCtgManagerBean.getAllPaymentCtgs();
	}
	
	public void testRemoveOtherPymtCtg() throws BusinessDelegateException, RemoveException {
		int otherPaymentCtgId = 301;
		otherPymtCtgManagerBean.removeOtherPymtCtg(otherPaymentCtgId);
	}
	
	public void testUpdateOtherPymtCtg() throws BusinessDelegateException, OtherPymtCtgException {
		otherPymtCtgManagerBean.updateOtherPymtCtg(otherPymtCtgVO);
	}
}

