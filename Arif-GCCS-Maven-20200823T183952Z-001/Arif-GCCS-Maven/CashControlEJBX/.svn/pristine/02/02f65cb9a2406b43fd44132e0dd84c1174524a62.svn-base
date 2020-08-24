package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PrepaidException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PrepaidVO;

public class PrepaidManagerBeanTest {
	
	PrepaidManagerBean prepaidManagerBean = new PrepaidManagerBean();

	PrepaidVO prepaidVO = getVO();
	
	public PrepaidVO getVO() {
		PrepaidVO prepaidVO = new PrepaidVO();
		prepaidVO.setPrepaidId(108251);
		return prepaidVO;
	}
	
	@Test
	public void testSetPrepaid() throws BusinessDelegateException, PrepaidException {
		prepaidManagerBean.setPrepaid(prepaidVO);
	}
	
	@Test
	public void testGetPrepaid() throws BusinessDelegateException, FinderException {
		int prepaidId = 108251;
		prepaidManagerBean.getPrepaid(prepaidId);
	}
	
	@Test
	public void testGetAllPrepaids() throws BusinessDelegateException {
		prepaidManagerBean.getAllPrepaids();
	}
	
	
	@Test
	public void testGetPrepaidPrepaidByAwbNbr() throws BusinessDelegateException {
		String awbNbr = null;
		prepaidManagerBean.getPrepaidPrepaidByAwbNbr(awbNbr);
	}
	
	@Test
	public void testGetPrepaidByEodId() throws BusinessDelegateException {
		int eodId = 0;
		prepaidManagerBean.getPrepaidByEodId(eodId);
	}
	
	@Test
	public void testGetPrepaidPRPWithoutScan() throws BusinessDelegateException {
		String courierId = null;
		String locationCd = null;
		int statusId = 0;
		prepaidManagerBean.getPrepaidPRPWithoutScan(courierId, locationCd, statusId);
	}
	
	@Test
	public void testGetPrepaidPRPQueryCosmos() throws BusinessDelegateException {
		String locationCd = null;
		int statusId = 0;
		prepaidManagerBean.getPrepaidPRPQueryCosmos(locationCd, statusId);
	}
	
	@Test
	public void testRemovePrepaid() throws BusinessDelegateException, RemoveException {
		int prepaidId = 0;
		prepaidManagerBean.removePrepaid(prepaidId);
	}
	
	@Test
	public void testUpdatePrepaid() throws BusinessDelegateException, PrepaidException {
		prepaidManagerBean.updatePrepaid(prepaidVO);
	}
	
}
