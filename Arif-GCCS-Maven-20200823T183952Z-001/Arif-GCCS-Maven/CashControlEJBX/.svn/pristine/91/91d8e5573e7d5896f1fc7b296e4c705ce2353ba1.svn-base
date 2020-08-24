package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.DepTemplLocException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.DepTemplLocVO;

public class DepTemplLocManagerBeanTest {
	
	DepTemplLocManagerBean depTemplLocManagerBean = new DepTemplLocManagerBean();

	DepTemplLocVO depTemplLocVO = getVO();
	
	public DepTemplLocVO getVO() {
		DepTemplLocVO depTemplLocVO = new DepTemplLocVO();
		depTemplLocVO.setLocationCd("YIPA");
		depTemplLocVO.setTemplId(361);
		return depTemplLocVO;
	}
	
	@Test
	public void testSetDepTemplLoc() throws BusinessDelegateException, DepTemplLocException {
		depTemplLocManagerBean.setDepTemplLoc(depTemplLocVO);
	}
	
	@Test
	public void testGetDepTemplLoc() throws BusinessDelegateException, FinderException {
		com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK = new DepTemplLocPK();
		depTemplLocPK.setLocationCd("TRAA");
		depTemplLocPK.setLocationCd("50");
		depTemplLocManagerBean.getDepTemplLoc(depTemplLocPK);
	}
	
	@Test
	public void testGetAllDepTemplLocs() throws BusinessDelegateException {
		depTemplLocManagerBean.getAllDepTemplLocs();
	}
	
	@Test
	public void testRemoveDepTemplLoc() throws BusinessDelegateException, RemoveException {
		com.fedex.lacitd.cashcontrol.datatier.entities.DepTemplLocPK depTemplLocPK = new DepTemplLocPK();
		depTemplLocPK.setLocationCd("TRAA");
		depTemplLocPK.setLocationCd("50");
		depTemplLocManagerBean.removeDepTemplLoc(depTemplLocPK);
	}
	
	@Test
	public void testUpdateDepTemplLoc() throws BusinessDelegateException, DepTemplLocException {
		depTemplLocManagerBean.updateDepTemplLoc(depTemplLocVO);
	}
}

