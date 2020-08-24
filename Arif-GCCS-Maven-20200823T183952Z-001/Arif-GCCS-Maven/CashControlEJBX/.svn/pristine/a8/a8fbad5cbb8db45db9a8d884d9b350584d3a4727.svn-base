package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.OacAwbPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.OacAwbException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.OacAwbVO;

public class OacAwbManagerBeanTest {
	
	OacAwbManagerBean oacAwbManagerBean = new OacAwbManagerBean();

	OacAwbVO oacAwbVO = getVO();
	
	public OacAwbVO getVO() {
		OacAwbVO oacAwbVO = new OacAwbVO();
		oacAwbVO.setAwbNbr("849545098446");
		oacAwbVO.setObAncSvcIdNbr(1);
		return oacAwbVO;
	}
	
	@Test
	public void testSetOacAwb() throws BusinessDelegateException, OacAwbException {
		oacAwbManagerBean.setOacAwb(oacAwbVO);
	}

	@Test
	public void testGetOacAwb() throws BusinessDelegateException, FinderException {
		OacAwbPK oacAwbPK = new OacAwbPK();
		oacAwbPK.setAwbNbr("849545098446");
		oacAwbPK.setObAncSvcIdNbr(1);
		oacAwbManagerBean.getOacAwb(oacAwbPK);
	}
	
	@Test
	public void testGetAllOacAwbs() throws BusinessDelegateException {
		oacAwbManagerBean.getAllOacAwbs();
	}
	
	@Test
	public void testGetOacAwbOacAwbsByOacId() throws BusinessDelegateException {
		int oacId = 1;
		oacAwbManagerBean.getOacAwbOacAwbsByOacId(oacId);
	}
	
	@Test
	public void testRemoveOacAwb() throws BusinessDelegateException, RemoveException {
		OacAwbPK oacAwbPK = new OacAwbPK();
		oacAwbPK.setAwbNbr("849545098446");
		oacAwbPK.setObAncSvcIdNbr(1);
		oacAwbManagerBean.removeOacAwb(oacAwbPK);
	}
	
	@Test
	public void testUpdateOacAwb() throws BusinessDelegateException, OacAwbException {
		oacAwbManagerBean.updateOacAwb(oacAwbVO);
	}

}
