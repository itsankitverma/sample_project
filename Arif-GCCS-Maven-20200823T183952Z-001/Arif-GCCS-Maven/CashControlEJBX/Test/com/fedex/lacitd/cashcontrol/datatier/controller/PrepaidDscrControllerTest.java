package com.fedex.lacitd.cashcontrol.datatier.controller;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PrepaidDscrVO;

public class PrepaidDscrControllerTest {
	
	PrepaidDscrController prepaidDscrController = new PrepaidDscrController();
	
	PrepaidDscrVO prepaidDscrVO = getVO();
	
	public PrepaidDscrVO getVO() {
		PrepaidDscrVO prepaidDscrVO = new PrepaidDscrVO();
		prepaidDscrVO.setPrepaidDscrId(1677);
		return prepaidDscrVO;
	}
	
	@Test
	public void testSetPrepaidDscr() throws BusinessDelegateException {
		prepaidDscrController.setPrepaidDscr(prepaidDscrVO);
	}

	@Test
	public void testGetPrepaidDscr() throws BusinessDelegateException {
		int prepaidDscrId = 1677;
		prepaidDscrController.getPrepaidDscr(prepaidDscrId);
	}
	
	@Test
	public void testGetAllPrepaidDscrs() throws BusinessDelegateException {
		prepaidDscrController.getAllPrepaidDscrs();
	}
	
	@Test
	public void testremovePrepaidDscr() throws BusinessDelegateException {
		int prepaidDscrId = 1677;
		prepaidDscrController.removePrepaidDscr(prepaidDscrId);
	}
	
	@Test
	public void testUpdatePrepaidDscr() throws BusinessDelegateException {
		prepaidDscrController.updatePrepaidDscr(prepaidDscrVO);
	}
	
	@Test
	public void testGetPrepaidDscrManager() throws BusinessDelegateException {
		prepaidDscrController.getPrepaidDscrManager();
	}
}
