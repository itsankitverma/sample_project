package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.PoaSurchargesException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.PoaSurchargesVO;
public class PoaSurchargesManagerBeanTest {
	
	PoaSurchargesManagerBean poaSurchargesManagerBean = new PoaSurchargesManagerBean();

	PoaSurchargesVO poaSurchargesVO = getVO();
	
	public PoaSurchargesVO getVO() {
		PoaSurchargesVO poaSurchargesVO = new PoaSurchargesVO();
		poaSurchargesVO.setPoaDetailId(4925250);
		poaSurchargesVO.setSurchargeCd("APPLAMT");
		poaSurchargesVO.setAppliedAmt(15.2);
		return poaSurchargesVO;
	}
	
	@Test
	public void testSetPoaSurcharges() throws BusinessDelegateException, PoaSurchargesException {
		poaSurchargesManagerBean.setPoaSurcharges(poaSurchargesVO);
	}
	
	@Test
	public void testGetPoaSurcharges() throws BusinessDelegateException, FinderException {
		com.fedex.lacitd.cashcontrol.datatier.entities.PoaSurchargesPK poaSurchargesPK = new PoaSurchargesPK();
		poaSurchargesPK.setPoaDetailId(4925250);
		poaSurchargesPK.setSurchargeCd("APPLAMT");
		poaSurchargesManagerBean.getPoaSurcharges(poaSurchargesPK);
	}
	
	@Test
	public void testGetAllPoaSurcharges() throws BusinessDelegateException {
		poaSurchargesManagerBean.getAllPoaSurcharges();
	}
	
	@Test
	public void testGetPoaSurchargesByPoaDetail() throws BusinessDelegateException {
		int poaDetailId = 4925250;
		poaSurchargesManagerBean.getPoaSurchargesByPoaDetail(poaDetailId);
	}
	
	@Test
	public void testRemovePoaSurcharges() throws BusinessDelegateException, RemoveException {
		PoaSurchargesPK poaSurchargesPK = new PoaSurchargesPK();
		poaSurchargesPK.setPoaDetailId(4925250);
		poaSurchargesPK.setSurchargeCd("APPLAMT");
		poaSurchargesManagerBean.removePoaSurcharges(poaSurchargesPK);
	}
	
	@Test
	public void testUpdatePoaSurcharges() throws BusinessDelegateException, PoaSurchargesException {
		poaSurchargesManagerBean.updatePoaSurcharges(poaSurchargesVO);
	}
}
