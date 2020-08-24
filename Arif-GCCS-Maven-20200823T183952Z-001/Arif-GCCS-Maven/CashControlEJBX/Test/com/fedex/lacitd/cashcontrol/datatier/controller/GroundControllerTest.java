package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.GroundVO;

public class GroundControllerTest {
	
	GroundController groundController = new GroundController();
	GroundVO groundVO = getVO();
	
	public GroundVO getVO() {
		GroundVO groundVO = new GroundVO();
		groundVO.setGrndShpIdNbr(244681);
		return groundVO;
	}

	@Test
	public void testSetGround() throws BusinessDelegateException {
		groundController.setGround(groundVO);
	}
	
	@Test
	public void testGetGround() throws BusinessDelegateException {
		int grndShpIdNbr = 244681;
		groundController.getGround(grndShpIdNbr);
	}
	
	@Test
	public void testGetAllGrounds() throws BusinessDelegateException {
		groundController.getAllGrounds();
	}

	@Test
	public void testGetGroundByGrndShpIdNbr() throws BusinessDelegateException {
		int grndShpIdNbr = 244681;
		groundController.getGroundByGrndShpIdNbr(grndShpIdNbr);
	}
	
	@Test
	public void testRemoveGround() throws BusinessDelegateException {
		int grndShpIdNbr = 244681;
		groundController.removeGround(grndShpIdNbr);
	}
	
	@Test
	public void testUpdateGround() throws BusinessDelegateException {
		groundController.updateGround(groundVO);
	}
	
	public void testGetGroundManager() throws BusinessDelegateException {
		groundController.getGroundManager();
	}
}
