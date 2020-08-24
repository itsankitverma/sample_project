package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplPymtTypePK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.DepTemplPymtTypeVO;

public class DepTemplPymtTypeControllerTest {

	DepTemplPymtTypeController depTemplPymtTypeController = new DepTemplPymtTypeController();
	
	DepTemplPymtTypeVO depTemplPymtTypeVO = getVO();
	
	public DepTemplPymtTypeVO getVO() {
		DepTemplPymtTypeVO depTemplPymtTypeVO = new DepTemplPymtTypeVO();
		depTemplPymtTypeVO.setPaymentTypeId(1);
		depTemplPymtTypeVO.setTemplId(22);
		return depTemplPymtTypeVO;
	}
	
	@Test
	public void testSetDepTemplPymtType() throws BusinessDelegateException {
		depTemplPymtTypeController.setDepTemplPymtType(depTemplPymtTypeVO);
	}
	
	@Test
	public void testGetDepTemplPymtType() throws BusinessDelegateException {
		DepTemplPymtTypePK depTemplPymtTypePK = new DepTemplPymtTypePK();
		depTemplPymtTypePK.setPaymentTypeId(0);
		depTemplPymtTypePK.setTemplId(22);
		depTemplPymtTypeController.getDepTemplPymtType(depTemplPymtTypePK);
	}
	
	@Test
	public void testGetAllDepTemplPymtTypes() throws BusinessDelegateException {
		depTemplPymtTypeController.getAllDepTemplPymtTypes();
	}
	
	@Test
	public void testRemoveDepTemplPymtType() throws BusinessDelegateException {
		DepTemplPymtTypePK depTemplPymtTypePK = new DepTemplPymtTypePK();
		depTemplPymtTypePK.setPaymentTypeId(0);
		depTemplPymtTypePK.setTemplId(22);
		depTemplPymtTypeController.removeDepTemplPymtType(depTemplPymtTypePK);
	}
	
	@Test
	public void testUpdateDepTemplPymtType() throws BusinessDelegateException {
		depTemplPymtTypeController.updateDepTemplPymtType(depTemplPymtTypeVO);
	}
	
	@Test
	public void testGetDepTemplPymtTypeManager() throws BusinessDelegateException {
		depTemplPymtTypeController.getDepTemplPymtTypeManager();
	}
}
