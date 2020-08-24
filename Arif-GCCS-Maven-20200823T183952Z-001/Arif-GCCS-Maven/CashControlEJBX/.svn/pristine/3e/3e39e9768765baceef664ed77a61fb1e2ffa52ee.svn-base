package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.DepTemplLocVO;

public class DepTemplLocControllerTest {
	
	DepTemplLocController depTemplLocController = new DepTemplLocController();

	DepTemplLocVO depTemplLocVO = getVO();
	
	public DepTemplLocVO getVO() {
		DepTemplLocVO depTemplLocVO = new DepTemplLocVO();
		depTemplLocVO.setLocationCd("YIPA");
		depTemplLocVO.setTemplId(361);
		return depTemplLocVO;
	}
	
	@Test
	public void testSetDepTemplLoc() throws BusinessDelegateException {
		depTemplLocController.setDepTemplLoc(depTemplLocVO);
	}
	
	@Test
	public void testGetDepTemplLoc() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK = new DepTemplLocPK();
		depTemplLocPK.setLocationCd("TRAA");
		depTemplLocPK.setLocationCd("50");
		depTemplLocController.getDepTemplLoc(depTemplLocPK);
	}
	
	@Test
	public void testGetAllDepTemplLocs() throws BusinessDelegateException {
		depTemplLocController.getAllDepTemplLocs();
	}
	
	@Test
	public void testRemoveDepTemplLoc() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK = new DepTemplLocPK();
		depTemplLocPK.setLocationCd("TRAA");
		depTemplLocPK.setLocationCd("50");
		depTemplLocController.removeDepTemplLoc(depTemplLocPK);
	}
	
	@Test
	public void testUpdateDepTemplLoc() throws BusinessDelegateException {
		depTemplLocController.updateDepTemplLoc(depTemplLocVO);
	}
	
	@Test
	public void testGetDepTemplLocManager() throws BusinessDelegateException {
		depTemplLocController.getDepTemplLocManager();
	}

}
