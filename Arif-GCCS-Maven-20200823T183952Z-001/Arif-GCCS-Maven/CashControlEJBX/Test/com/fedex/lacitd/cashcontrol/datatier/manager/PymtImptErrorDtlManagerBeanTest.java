package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PymtImptErrorDtlException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PymtImptErrorDtlVO;
public class PymtImptErrorDtlManagerBeanTest {

	PymtImptErrorDtlManagerBean pymtImptErrorDtlManagerBean = new PymtImptErrorDtlManagerBean();
	
	PymtImptErrorDtlVO pymtImptErrorDtlVO = getVO();
	
	public PymtImptErrorDtlVO getVO() {
		PymtImptErrorDtlVO pymtImptErrorDtlVO = new PymtImptErrorDtlVO();
		pymtImptErrorDtlVO.setImptId(375);
		return pymtImptErrorDtlVO;
	}
	
	@Test
	public void testSetPymtImptErrorDtl() throws BusinessDelegateException, PymtImptErrorDtlException {
		pymtImptErrorDtlManagerBean.setPymtImptErrorDtl(pymtImptErrorDtlVO);
	}
	
	@Test
	public void testGetPymtImptErrorDtl() throws BusinessDelegateException, FinderException {
		int imptErrorDtlId = 375;
		pymtImptErrorDtlManagerBean.getPymtImptErrorDtl(imptErrorDtlId);
	}
	
	@Test
	public void testGetAllPymtImptErrorDtls() throws BusinessDelegateException {
		pymtImptErrorDtlManagerBean.getAllPymtImptErrorDtls();
	}
	
	@Test
	public void testRemovePymtImptErrorDtl() throws BusinessDelegateException, RemoveException {
		int imptErrorDtlId = 375;
		pymtImptErrorDtlManagerBean.removePymtImptErrorDtl(imptErrorDtlId);
	}
	
	@Test
	public void testUpdatePymtImptErrorDtl() throws BusinessDelegateException, PymtImptErrorDtlException {
		pymtImptErrorDtlManagerBean.updatePymtImptErrorDtl(pymtImptErrorDtlVO);
	}
}
