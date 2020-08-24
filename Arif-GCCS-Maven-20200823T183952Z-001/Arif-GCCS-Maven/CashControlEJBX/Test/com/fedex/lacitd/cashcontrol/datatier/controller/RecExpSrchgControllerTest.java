package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.RecExpSrchgVO;

public class RecExpSrchgControllerTest {
	
	RecExpSrchgController recExpSrchgController = new RecExpSrchgController();

	RecExpSrchgVO recExpSrchgVO = getVO();
	
	public RecExpSrchgVO getVO() {
		RecExpSrchgVO recExpSrchgVO = new RecExpSrchgVO();
		recExpSrchgVO.setRecId(14660836);
		recExpSrchgVO.setAppliedAmt(300);
		recExpSrchgVO.setSurchargeCd("SERVTAX");
		return recExpSrchgVO;
	}
	
	@Test
	public void testSetRecExpSrchg() throws BusinessDelegateException {
		recExpSrchgController.setRecExpSrchg(recExpSrchgVO);
	}
	
	@Test
	public void testGetRecExpSrchg() throws BusinessDelegateException {
		com.fedex.lacitd.cashcontrol.datatier.entities.RecExpSrchgPK recExpSrchgPK = new RecExpSrchgPK();
		recExpSrchgPK.setRecId(14660836);
		recExpSrchgPK.setSurchargeCd("SERVTAX");
		recExpSrchgController.getRecExpSrchg(recExpSrchgPK);
	}
	
	@Test
	public void testGetAllRecExpSrchgs() throws BusinessDelegateException {
		recExpSrchgController.getAllRecExpSrchgs();
	}
	
	@Test
	public void testGetRecExpSrchgByReceivable() throws BusinessDelegateException {
		int recId = 14660836;
		recExpSrchgController.getRecExpSrchgByReceivable(recId);
	}
	
	@Test
	public void testRemoveRecExpSrchg() throws BusinessDelegateException {
		RecExpSrchgPK recExpSrchgPK = new RecExpSrchgPK();
		recExpSrchgPK.setRecId(14660836);
		recExpSrchgPK.setSurchargeCd("SERVTAX");
		recExpSrchgController.removeRecExpSrchg(recExpSrchgPK);
	}
	
	@Test
	public void testUpdateRecExpSrchg() throws BusinessDelegateException {
		recExpSrchgController.updateRecExpSrchg(recExpSrchgVO);
	}
	
	@Test
	public void testGetRecExpSrchgManager() throws BusinessDelegateException {
		recExpSrchgController.getRecExpSrchgManager();
	}
	
}
