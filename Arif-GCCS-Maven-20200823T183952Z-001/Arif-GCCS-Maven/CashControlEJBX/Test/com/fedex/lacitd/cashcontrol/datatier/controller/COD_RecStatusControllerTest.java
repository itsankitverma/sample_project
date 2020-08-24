package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.COD_RecStatusVO;

public class COD_RecStatusControllerTest {
	COD_RecStatusController cod_RecStatusController = new COD_RecStatusController();

	COD_RecStatusVO cod_RecStatusVO = getVO();
	
	private COD_RecStatusVO getVO() {
		COD_RecStatusVO cod_RecStatusVO = new COD_RecStatusVO();
		cod_RecStatusVO.setCodPgFlg(1);
		cod_RecStatusVO.setDescription("Clear");
		cod_RecStatusVO.setStatusId(1);
		return cod_RecStatusVO;
	}
	
	@Test
	public void testSetCOD_RecStatus() throws BusinessDelegateException {
		cod_RecStatusController.setCOD_RecStatus(cod_RecStatusVO);
	}
	
	@Test
	public void testGetCOD_RecStatus() throws BusinessDelegateException {
		Integer statusId = 1;
		cod_RecStatusController.getCOD_RecStatus(statusId);
	}
	
	@Test
	public void testGetAllCOD_RecStatus() throws BusinessDelegateException {
		cod_RecStatusController.getAllCOD_RecStatus();
	}
	
	@Test
	public void testRemoveCOD_RecStatus() throws BusinessDelegateException {
		Integer statusId = 1;
		cod_RecStatusController.removeCOD_RecStatus(statusId);
	}
	
	@Test
	public void testUpdateCOD_RecStatus() throws BusinessDelegateException {
		cod_RecStatusController.updateCOD_RecStatus(cod_RecStatusVO);
	}
	
	@Test
	public void testGetCOD_RecStatusManager() throws BusinessDelegateException {
		cod_RecStatusController.getCOD_RecStatusManager();
	}
}
