package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.OacAwbVO;

public class OacAwbControllerTest {
	
	OacAwbController oacAwbController = new OacAwbController();

	OacAwbVO oacAwbVO = getVO();
	
	public OacAwbVO getVO() {
		OacAwbVO oacAwbVO = new OacAwbVO();
		oacAwbVO.setAwbNbr("849545098446");
		oacAwbVO.setObAncSvcIdNbr(1);
		return oacAwbVO;
	}
	
	@Test
	public void testSetOacAwb() throws BusinessDelegateException {
		oacAwbController.setOacAwb(oacAwbVO);
	}

	@Test
	public void testGetOacAwb() throws BusinessDelegateException {
		OacAwbPK oacAwbPK = new OacAwbPK();
		oacAwbPK.setAwbNbr("849545098446");
		oacAwbPK.setObAncSvcIdNbr(1);
		oacAwbController.getOacAwb(oacAwbPK);
	}
	
	@Test
	public void testGetAllOacAwbs() throws BusinessDelegateException {
		oacAwbController.getAllOacAwbs();
	}
	
	@Test
	public void testGetOacAwbOacAwbsByOacId() throws BusinessDelegateException {
		int oacId = 1;
		oacAwbController.getOacAwbOacAwbsByOacId(oacId);
	}
	
	@Test
	public void testRemoveOacAwb() throws BusinessDelegateException {
		OacAwbPK oacAwbPK = new OacAwbPK();
		oacAwbPK.setAwbNbr("849545098446");
		oacAwbPK.setObAncSvcIdNbr(1);
		oacAwbController.removeOacAwb(oacAwbPK);
	}
	
	@Test
	public void testUpdateOacAwb() throws BusinessDelegateException {
		oacAwbController.updateOacAwb(oacAwbVO);
	}
	
	@Test
	public void testGetOacAwbManager() throws BusinessDelegateException {
		oacAwbController.getOacAwbManager();
	}
}
