package com.fedex.lacitd.cashcontrol.datatier.manager;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.DepTemplException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.DepTemplVO;
public class DepTemplManagerBeanTest {
	
	DepTemplManagerBean depTemplManagerBean = new DepTemplManagerBean();
	
	DepTemplVO depTemplVO = getVO();
	
	public DepTemplVO getVO() {
		DepTemplVO depTemplVO = new DepTemplVO();
		depTemplVO.setTemplId(167);
		depTemplVO.setTemplCd("OTHUSDCK2");
		return depTemplVO;
	}

	@Test
	public void testSetDepTempl() throws BusinessDelegateException, DepTemplException {
		depTemplManagerBean.setDepTempl(depTemplVO);
	}
	
	@Test
	public void testGetDepTempl() throws BusinessDelegateException, FinderException {
		int templId = 167;
		depTemplManagerBean.getDepTempl(templId);
	}
	
	@Test
	public void testAddLocation() throws BusinessDelegateException, DepTemplException {
		int templId = 167;
		String locationCd = null;
		depTemplManagerBean.addLocation(templId, locationCd);
	}
	
	@Test
	public void testRemoveLocation() throws BusinessDelegateException, DepTemplException {
		int templId = 167;
		String locationCd = null;
		depTemplManagerBean.removeLocation(templId, locationCd);
	}
	
	@Test
	public void testGetLocations() throws BusinessDelegateException, DepTemplException {
		int templId = 167;
		depTemplManagerBean.getLocations(templId);
	}
	
	@Test
	public void testAddPaymentType() throws BusinessDelegateException, DepTemplException {
		int templId = 167;
		int paymentTypeId = 0;
		depTemplManagerBean.addPaymentType(templId, paymentTypeId);
	}
	
	@Test
	public void testRemovePaymentType() throws BusinessDelegateException, DepTemplException {
		int templId = 167;
		int paymentTypeId = 0;
		depTemplManagerBean.removePaymentType(templId, paymentTypeId);
	}
	
	@Test
	public void testGetPaymentTypes() throws BusinessDelegateException, DepTemplException {
		int templId = 167;
		depTemplManagerBean.getPaymentTypes(templId);
	}
	
	@Test
	public void testGetAllDepTempls() throws BusinessDelegateException {
		depTemplManagerBean.getAllDepTempls();
	}
	
	@Test
	public void testGetAllActiveDepTempls() throws BusinessDelegateException {
		depTemplManagerBean.getAllActiveDepTempls();
	}
	
	@Test
	public void testGetDepTemplDepTemplsbyCode() throws BusinessDelegateException {
		String templCd = "OTHUSDCK2";
		depTemplManagerBean.getDepTemplDepTemplsbyCode(templCd);
	}
	
	@Test
	public void testRemoveDepTempl() throws BusinessDelegateException, RemoveException {
		int templId = 167;
		depTemplManagerBean.removeDepTempl(templId);
	}
	
	@Test
	public void testUpdateDepTempl() throws BusinessDelegateException, DepTemplException {
		depTemplManagerBean.updateDepTempl(depTemplVO);
	}
}

