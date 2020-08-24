package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.GroundException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.GroundVO;

public class GroundManagerBeanTest {
	
	GroundManagerBean groundManagerBean = new GroundManagerBean();
	GroundVO groundVO = getVO();
	
	public GroundVO getVO() {
		GroundVO groundVO = new GroundVO();
		groundVO.setGrndShpIdNbr(244681);
		return groundVO;
	}

	@Test
	public void testSetGround() throws BusinessDelegateException, GroundException {
		groundManagerBean.setGround(groundVO);
	}
	
	@Test
	public void testGetGround() throws BusinessDelegateException, FinderException {
		int grndShpIdNbr = 244681;
		groundManagerBean.getGround(grndShpIdNbr);
	}
	
	@Test
	public void testGetAllGrounds() throws BusinessDelegateException {
		groundManagerBean.getAllGrounds();
	}

	@Test
	public void testGetGroundByGrndShpIdNbr() throws BusinessDelegateException {
		int grndShpIdNbr = 244681;
		groundManagerBean.getGroundByGrndShpIdNbr(grndShpIdNbr);
	}
	
	@Test
	public void testRemoveGround() throws BusinessDelegateException, RemoveException {
		int grndShpIdNbr = 244681;
		groundManagerBean.removeGround(grndShpIdNbr);
	}
	
	@Test
	public void testUpdateGround() throws BusinessDelegateException, GroundException {
		groundManagerBean.updateGround(groundVO);
	}
}
