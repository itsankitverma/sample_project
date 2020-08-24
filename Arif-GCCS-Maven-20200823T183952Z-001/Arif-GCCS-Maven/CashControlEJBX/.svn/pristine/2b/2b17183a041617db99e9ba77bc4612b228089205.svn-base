package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PrepaidDscrException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PrepaidDscrVO;
public class PrepaidDscrManagerBeanTest {
	
	PrepaidDscrManagerBean prepaidDscrManagerBean = new PrepaidDscrManagerBean();
	
	PrepaidDscrVO prepaidDscrVO = getVO();
	
	public PrepaidDscrVO getVO() {
		PrepaidDscrVO prepaidDscrVO = new PrepaidDscrVO();
		prepaidDscrVO.setPrepaidDscrId(1677);
		return prepaidDscrVO;
	}
	
	@Test
	public void testSetPrepaidDscr() throws BusinessDelegateException, PrepaidDscrException {
		prepaidDscrManagerBean.setPrepaidDscr(prepaidDscrVO);
	}

	@Test
	public void testGetPrepaidDscr() throws BusinessDelegateException, FinderException {
		int prepaidDscrId = 1677;
		prepaidDscrManagerBean.getPrepaidDscr(prepaidDscrId);
	}
	
	@Test
	public void testGetAllPrepaidDscrs() throws BusinessDelegateException {
		prepaidDscrManagerBean.getAllPrepaidDscrs();
	}
	
	@Test
	public void testremovePrepaidDscr() throws BusinessDelegateException, RemoveException {
		int prepaidDscrId = 1677;
		prepaidDscrManagerBean.removePrepaidDscr(prepaidDscrId);
	}
	
	@Test
	public void testUpdatePrepaidDscr() throws BusinessDelegateException, PrepaidDscrException {
		prepaidDscrManagerBean.updatePrepaidDscr(prepaidDscrVO);
	}
}

