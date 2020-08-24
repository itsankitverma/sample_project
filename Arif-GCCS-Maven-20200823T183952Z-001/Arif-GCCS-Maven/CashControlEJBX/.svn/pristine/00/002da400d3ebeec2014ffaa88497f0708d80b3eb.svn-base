package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.SurchargesException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.SurchargesVO;

public class SurchargesManagerBeanTest {

	SurchargesManagerBean surchargesManagerBean = new SurchargesManagerBean();
	
	SurchargesVO surchargesVO = getVO();
	
	public SurchargesVO getVO() {
		SurchargesVO surchargesVO = new SurchargesVO();
		surchargesVO.setSurchargeCd("PrePayment");
		return surchargesVO;
	}
	
	@Test
	public void testSetSurcharges() throws BusinessDelegateException, SurchargesException {
		surchargesManagerBean.setSurcharges(surchargesVO);
	}
	
	@Test
	public void testGetSurcharges() throws BusinessDelegateException, FinderException {
		String surchargeCd = "PrePayment";
		surchargesManagerBean.getSurcharges(surchargeCd);
	}
	
	@Test
	public void testGetAllSurcharges() throws BusinessDelegateException {
		surchargesManagerBean.getAllSurcharges();
	}
	
	@Test
	public void testGetSurchargesByRod() throws BusinessDelegateException {
		String locationCd = "BOMA";
		surchargesManagerBean.getSurchargesByRod(locationCd);
	}
	
	@Test
	public void testGetSurchargesByPrepaid() throws BusinessDelegateException {
		String locationCd = "BOMA";
		surchargesManagerBean.getSurchargesByPrepaid(locationCd);
	}
	
	@Test
	public void testGetSurchargesByPoa() throws BusinessDelegateException {
		String locationCd = "BOMA";
		surchargesManagerBean.getSurchargesByPoa(locationCd);
	}
	
	@Test
	public void testRemoveSurcharges() throws BusinessDelegateException, RemoveException {
		String surchargeCd = "PrePayment";
		surchargesManagerBean.removeSurcharges(surchargeCd);
	}
	
	@Test
	public void testUpdateSurcharges() throws BusinessDelegateException, SurchargesException {
		surchargesManagerBean.updateSurcharges(surchargesVO);
	}
}
