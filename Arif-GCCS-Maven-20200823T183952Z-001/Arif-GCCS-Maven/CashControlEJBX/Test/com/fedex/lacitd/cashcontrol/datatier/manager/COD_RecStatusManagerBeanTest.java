package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.COD_RecStatusException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.COD_RecStatusVO;

public class COD_RecStatusManagerBeanTest {
	COD_RecStatusManagerBean cod_RecStatusManagerBean = new COD_RecStatusManagerBean();

	COD_RecStatusVO cod_RecStatusVO = getVO();
	
	private COD_RecStatusVO getVO() {
		COD_RecStatusVO cod_RecStatusVO = new COD_RecStatusVO();
		cod_RecStatusVO.setCodPgFlg(1);
		cod_RecStatusVO.setDescription("Clear");
		cod_RecStatusVO.setStatusId(1);
		return cod_RecStatusVO;
	}
	
	@Test
	public void testSetCOD_RecStatus() throws BusinessDelegateException, COD_RecStatusException {
		cod_RecStatusManagerBean.setCOD_RecStatus(cod_RecStatusVO);
	}
	
	@Test
	public void testGetCOD_RecStatus() throws BusinessDelegateException, FinderException {
		Integer statusId = 1;
		cod_RecStatusManagerBean.getCOD_RecStatus(statusId);
	}
	
	@Test
	public void testGetAllCOD_RecStatus() throws BusinessDelegateException {
		cod_RecStatusManagerBean.getAllCOD_RecStatus();
	}
	
	@Test
	public void testRemoveCOD_RecStatus() throws BusinessDelegateException, RemoveException {
		Integer statusId = 1;
		cod_RecStatusManagerBean.removeCOD_RecStatus(statusId);
	}
	
	@Test
	public void testUpdateCOD_RecStatus() throws BusinessDelegateException, COD_RecStatusException {
		cod_RecStatusManagerBean.updateCOD_RecStatus(cod_RecStatusVO);
	}

}
