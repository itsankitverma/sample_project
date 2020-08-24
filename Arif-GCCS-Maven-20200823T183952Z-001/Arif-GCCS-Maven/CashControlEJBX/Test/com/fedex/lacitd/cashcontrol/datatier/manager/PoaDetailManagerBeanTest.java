package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PoaDetailException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PoaDetailVO;

public class PoaDetailManagerBeanTest {
	
	PoaDetailManagerBean poaDetailManagerBean = new PoaDetailManagerBean();
	
	PoaDetailVO poaDetailVO = getVO();
	
	public PoaDetailVO getVO() {
		PoaDetailVO poaDetailVO = new PoaDetailVO();
		poaDetailVO.setPoaDetailId(4809034);
		return poaDetailVO;
	}

	@Test
	public void testSetPoaDetail() throws BusinessDelegateException, PoaDetailException {
		poaDetailManagerBean.setPoaDetail(poaDetailVO);
	}
	
	@Test
	public void testGetPoaDetail() throws BusinessDelegateException, FinderException {
		int poaDetailId = 4809034;
		poaDetailManagerBean.getPoaDetail(poaDetailId);
	}
	
	@Test
	public void testGetAllPoaDetails() throws BusinessDelegateException {
		poaDetailManagerBean.getAllPoaDetails();
	}
	
	@Test
	public void testGetPoaDetailPoaDetails() throws BusinessDelegateException {
		int poaPaymentsId = 4809034;
		poaDetailManagerBean.getPoaDetailPoaDetails(poaPaymentsId);
	}
	
	@Test
	public void testRemovePoaDetail() throws BusinessDelegateException, RemoveException {
		int poaDetailId = 4809034;
		poaDetailManagerBean.removePoaDetail(poaDetailId);
	}
	
	@Test
	public void testUpdatePoaDetail() throws BusinessDelegateException, PoaDetailException {
		poaDetailManagerBean.updatePoaDetail(poaDetailVO);
	}
}
