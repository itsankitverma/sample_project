package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.OacException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.OacVO;
public class OacManagerBeanTest {
	
	OacManagerBean oacManagerBean = new OacManagerBean();

	OacVO oacVO = getVO();
	
	public OacVO getVO() {
		OacVO oacVO = new OacVO();
		oacVO.setObAncSvcIdNbr(42);
		return oacVO;
	}
	
	@Test
	public void testSetOac() throws BusinessDelegateException, OacException {
		oacManagerBean.setOac(oacVO);
	}

	@Test
	public void testGetOac() throws BusinessDelegateException, FinderException {
		int obAncSvcIdNbr = 42;
		oacManagerBean.getOac(obAncSvcIdNbr);
	}
	
	@Test
	public void testGetAllOacs() throws BusinessDelegateException {
		oacManagerBean.getAllOacs();
	}
	
	@Test
	public void testGetOacByPymtCurrCd() throws BusinessDelegateException {
		String pymtCurrCd = "CAD";
		oacManagerBean.getOacByPymtCurrCd(pymtCurrCd);
	}
	
	@Test
	public void testGetOacByLocCd() throws BusinessDelegateException {
		String locCd = null;
		oacManagerBean.getOacByLocCd(locCd);
	}
	
	@Test
	public void testGetOacByStatusCd() throws BusinessDelegateException {
		int statusCd = 0;
		oacManagerBean.getOacByStatusCd(statusCd);
	}
	
	@Test
	public void testGetOacByEodIdNbr() throws BusinessDelegateException {
		int eodIdNbr = 0;
		oacManagerBean.getOacByEodIdNbr(eodIdNbr);
	}
	
	@Test
	public void testRemoveOac() throws BusinessDelegateException, RemoveException {
		int obAncSvcIdNbr = 0;
		oacManagerBean.removeOac(obAncSvcIdNbr);
	}
	
	@Test
	public void testUpdateOac() throws BusinessDelegateException, OacException {
		oacManagerBean.updateOac(oacVO);
	}
}
