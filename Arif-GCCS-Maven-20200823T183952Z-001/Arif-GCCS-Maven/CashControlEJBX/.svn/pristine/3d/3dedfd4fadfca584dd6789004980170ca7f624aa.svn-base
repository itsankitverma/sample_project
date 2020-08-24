package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PrepSurchargesException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PrepSurchargesVO;

public class PrepSurchargesManagerBeanTest {
	
	PrepSurchargesManagerBean prepSurchargesManagerBean = new PrepSurchargesManagerBean();
	
	PrepSurchargesVO prepSurchargesVO = getVO();
	
	public PrepSurchargesVO getVO() {
		PrepSurchargesVO prepSurchargesVO = new PrepSurchargesVO();
		return prepSurchargesVO;
	}

	@Test
	public void testSetPrepSurcharges() throws BusinessDelegateException, PrepSurchargesException {
		PrepSurchargesVO prepSurchargesVO = new PrepSurchargesVO();
		prepSurchargesManagerBean.setPrepSurcharges(prepSurchargesVO);
	}

	@Test
	public void testGetPrepSurcharges() throws BusinessDelegateException, FinderException {
		com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK = new PrepSurchargesPK();
		prepSurchargesManagerBean.getPrepSurcharges(prepSurchargesPK);
	}
	
	@Test
	public void testGetAllPrepSurcharges() throws BusinessDelegateException {
		prepSurchargesManagerBean.getAllPrepSurcharges();
	}
	
	@Test
	public void testGetPrepSurchargesByPrepaid() throws BusinessDelegateException {
		int prepId = 0;
		prepSurchargesManagerBean.getPrepSurchargesByPrepaid(prepId);
	}
	
	@Test
	public void testRemovePrepSurcharges() throws BusinessDelegateException, RemoveException {
		com.fedex.lacitd.cashcontrol.datatier.entities.PrepSurchargesPK prepSurchargesPK = new PrepSurchargesPK();
		prepSurchargesManagerBean.removePrepSurcharges(prepSurchargesPK);
	}
	
	@Test
	public void testUpdatePrepSurcharges() throws BusinessDelegateException, PrepSurchargesException {
		PrepSurchargesVO prepSurchargesVO = new PrepSurchargesVO();
		prepSurchargesManagerBean.updatePrepSurcharges(prepSurchargesVO);
	}
}
