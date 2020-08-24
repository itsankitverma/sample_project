package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.OacVO;

public class OacControllerTest {
	
	OacController oacController = new OacController();

	OacVO oacVO = getVO();
	
	public OacVO getVO() {
		OacVO oacVO = new OacVO();
		oacVO.setObAncSvcIdNbr(42);
		return oacVO;
	}
	
	@Test
	public void testSetOac() throws BusinessDelegateException {
		oacController.setOac(oacVO);
	}

	@Test
	public void testGetOac() throws BusinessDelegateException {
		int obAncSvcIdNbr = 42;
		oacController.getOac(obAncSvcIdNbr);
	}
	
	@Test
	public void testGetAllOacs() throws BusinessDelegateException {
		oacController.getAllOacs();
	}
	
	@Test
	public void testGetOacByPymtCurrCd() throws BusinessDelegateException {
		String pymtCurrCd = "CAD";
		oacController.getOacByPymtCurrCd(pymtCurrCd);
	}
	
	@Test
	public void testGetOacByLocCd() throws BusinessDelegateException {
		String locCd = null;
		oacController.getOacByLocCd(locCd);
	}
	
	@Test
	public void testGetOacByStatusCd() throws BusinessDelegateException {
		int statusCd = 0;
		oacController.getOacByStatusCd(statusCd);
	}
	
	@Test
	public void testGetOacByEodIdNbr() throws BusinessDelegateException {
		int eodIdNbr = 0;
		oacController.getOacByEodIdNbr(eodIdNbr);
	}
	
	@Test
	public void testRemoveOac() throws BusinessDelegateException {
		int obAncSvcIdNbr = 0;
		oacController.removeOac(obAncSvcIdNbr);
	}
	
	@Test
	public void testUpdateOac() throws BusinessDelegateException {
		oacController.updateOac(oacVO);
	}
	
	@Test
	public void testGetOacManager() throws BusinessDelegateException {
		oacController.getOacManager();
	}
	
}
