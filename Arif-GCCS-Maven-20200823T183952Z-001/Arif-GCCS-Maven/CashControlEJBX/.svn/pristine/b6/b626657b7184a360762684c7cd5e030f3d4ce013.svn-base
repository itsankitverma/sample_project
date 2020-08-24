package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.SurchargeLocException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.SurchargeLocVO;

public class SurchargeLocManagerBeanTest {
	
	SurchargeLocManagerBean surchargeLocManagerBean = new SurchargeLocManagerBean();

	SurchargeLocVO surchargeLocVO = getVO();
	
	public SurchargeLocVO getVO() {
		SurchargeLocVO surchargeLocVO = new SurchargeLocVO();
		surchargeLocVO.setLocationCd("SYDA");
		surchargeLocVO.setSurchargeCd("Quarantine");
		return surchargeLocVO;
	}
	
	@Test
	public void testSetSurchargeLoc() throws BusinessDelegateException, SurchargeLocException {
		surchargeLocManagerBean.setSurchargeLoc(surchargeLocVO);
	}
	
	@Test
	public void testGetSurchargeLoc() throws BusinessDelegateException, FinderException {
		com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK = new SurchargeLocPK();
		surchargeLocPK.setLocationCd("SYDA");
		surchargeLocPK.setSurchargeCd("Quarantine");
		surchargeLocManagerBean.getSurchargeLoc(surchargeLocPK);
	}
	
	@Test
	public void testGetAllSurchargeLocs() throws BusinessDelegateException {
		surchargeLocManagerBean.getAllSurchargeLocs();
	}
	
	@Test
	public void testRemoveSurchargeLoc() throws BusinessDelegateException, RemoveException {
		com.fedex.lacitd.cashcontrol.datatier.entities.SurchargeLocPK surchargeLocPK = new SurchargeLocPK();
		surchargeLocPK.setLocationCd("SYDA");
		surchargeLocPK.setSurchargeCd("Quarantine");
		surchargeLocManagerBean.removeSurchargeLoc(surchargeLocPK);
	}
	
	@Test
	public void testUpdateSurchargeLoc() throws BusinessDelegateException, SurchargeLocException {
		surchargeLocManagerBean.updateSurchargeLoc(surchargeLocVO);
	}
}

