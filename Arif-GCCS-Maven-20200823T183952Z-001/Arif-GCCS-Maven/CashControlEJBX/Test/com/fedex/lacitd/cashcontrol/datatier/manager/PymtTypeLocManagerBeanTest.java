package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PymtTypeLocException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PymtTypeLocVO;

public class PymtTypeLocManagerBeanTest {
	
	PymtTypeLocManagerBean pymtTypeLocManagerBean = new PymtTypeLocManagerBean();

	PymtTypeLocVO pymtTypeLocVO = getVO();
	
	public PymtTypeLocVO getVO() {
		PymtTypeLocVO pymtTypeLocVO = new PymtTypeLocVO();
		pymtTypeLocVO.setLocationCd("JCJA");
		pymtTypeLocVO.setPaymentTypeId(26);
		return pymtTypeLocVO;
	}
	
	@Test
	public void testSetPymtTypeLoc() throws BusinessDelegateException, PymtTypeLocException {
		pymtTypeLocManagerBean.setPymtTypeLoc(pymtTypeLocVO);
	}
	
	@Test
	public void testGetPymtTypeLoc() throws BusinessDelegateException, FinderException {
		com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK = new PymtTypeLocPK();
		pymtTypeLocPK.setLocationCd("JCJA");
		pymtTypeLocPK.setPaymentTypeId(26);
		pymtTypeLocManagerBean.getPymtTypeLoc(pymtTypeLocPK);
	}
	
	@Test
	public void testGetAllPymtTypeLocs() throws BusinessDelegateException {
		pymtTypeLocManagerBean.getAllPymtTypeLocs();
	}
	
	@Test
	public void testGetPymtTypeLocLocationsByPayment() throws BusinessDelegateException {
		int ptId = 26;
		pymtTypeLocManagerBean.getPymtTypeLocLocationsByPayment(ptId);
	}
	
	@Test
	public void testRemovePymtTypeLoc() throws BusinessDelegateException, RemoveException {
		com.fedex.lacitd.cashcontrol.datatier.entities.PymtTypeLocPK pymtTypeLocPK = new PymtTypeLocPK();
		pymtTypeLocPK.setLocationCd("JCJA");
		pymtTypeLocPK.setPaymentTypeId(26);
		pymtTypeLocManagerBean.removePymtTypeLoc(pymtTypeLocPK);
	}
	
	@Test
	public void testUpdatePymtTypeLoc() throws BusinessDelegateException, PymtTypeLocException {
		pymtTypeLocManagerBean.updatePymtTypeLoc(pymtTypeLocVO);
	}
}
