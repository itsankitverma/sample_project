package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplPymtTypePK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.DepTemplPymtTypeException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.DepTemplPymtTypeVO;
public class DepTemplPymtTypeManagerBeanTest {

	DepTemplPymtTypeManagerBean depTemplPymtTypeManagerBean = new DepTemplPymtTypeManagerBean();
	
	DepTemplPymtTypeVO depTemplPymtTypeVO = getVO();
	
	public DepTemplPymtTypeVO getVO() {
		DepTemplPymtTypeVO depTemplPymtTypeVO = new DepTemplPymtTypeVO();
		depTemplPymtTypeVO.setPaymentTypeId(1);
		depTemplPymtTypeVO.setTemplId(22);
		return depTemplPymtTypeVO;
	}
	
	@Test
	public void testSetDepTemplPymtType() throws BusinessDelegateException, DepTemplPymtTypeException {
		depTemplPymtTypeManagerBean.setDepTemplPymtType(depTemplPymtTypeVO);
	}
	
	@Test
	public void testGetDepTemplPymtType() throws BusinessDelegateException, FinderException {
		DepTemplPymtTypePK depTemplPymtTypePK = new DepTemplPymtTypePK();
		depTemplPymtTypePK.setPaymentTypeId(0);
		depTemplPymtTypePK.setTemplId(22);
		depTemplPymtTypeManagerBean.getDepTemplPymtType(depTemplPymtTypePK);
	}
	
	@Test
	public void testGetAllDepTemplPymtTypes() throws BusinessDelegateException {
		depTemplPymtTypeManagerBean.getAllDepTemplPymtTypes();
	}
	
	@Test
	public void testRemoveDepTemplPymtType() throws BusinessDelegateException, RemoveException {
		DepTemplPymtTypePK depTemplPymtTypePK = new DepTemplPymtTypePK();
		depTemplPymtTypePK.setPaymentTypeId(0);
		depTemplPymtTypePK.setTemplId(22);
		depTemplPymtTypeManagerBean.removeDepTemplPymtType(depTemplPymtTypePK);
	}
	
	@Test
	public void testUpdateDepTemplPymtType() throws BusinessDelegateException, DepTemplPymtTypeException {
		depTemplPymtTypeManagerBean.updateDepTemplPymtType(depTemplPymtTypeVO);
	}
}

