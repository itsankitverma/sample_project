package com.fedex.lacitd.cashcontrol.datatier.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.EodException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EodVO;

public class EodManagerBeanTest {
	
	EodManagerBean eodManagerBean = new EodManagerBean();
	
	EodVO eodVO = getVO();
	
	public EodVO getVO() {
		EodVO eodVO = getVO();
		eodVO.setEmployeeId("281917");
		try {
			eodVO.setEodDt(new SimpleDateFormat("dd/mm/yyyy").parse("16/10/2002"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		eodVO.setEodId(4901);
		eodVO.setLocationCd("GDLPC");
		return eodVO;
	}
	
	@Test
	public void testSetEod() throws BusinessDelegateException, EodException {
		eodManagerBean.setEod(eodVO);
	}
	
	@Test
	public void testGetEod() throws BusinessDelegateException, FinderException {
		int eodId = 4901;
		eodManagerBean.getEod(eodId);
	}
	
	@Test
	public void testGetAllEods() throws BusinessDelegateException {
		eodManagerBean.getAllEods();
	}
	
	@Test
	public void testGetEodByEodDt() throws BusinessDelegateException {
		Date eodDt = null;
		try {
			eodDt = new SimpleDateFormat("dd/mm/yyyy").parse("16/10/2002");
		} catch (Exception e) {
			e.printStackTrace();
		}
		eodManagerBean.getEodByEodDt(eodDt);
	}

	@Test
	public void testGetEodByLocationCd() throws BusinessDelegateException {
		String locationCd = "GDLPC";
		eodManagerBean.getEodByLocationCd(locationCd);
	}
	
	@Test
	public void testGetEodByLocationDt() throws BusinessDelegateException {
		String locationCd = "GDLPC";
		Date eodDt = null;
		try {
			eodDt = new SimpleDateFormat("dd/mm/yyyy").parse("16/10/2002");
		} catch (Exception e) {
			e.printStackTrace();
		}
		eodManagerBean.getEodByLocationDt(locationCd, eodDt);
	}
	
	@Test
	public void testRemoveEod() throws BusinessDelegateException, RemoveException {
		int eodId = 4901;
		eodManagerBean.removeEod(eodId);
	}
	
	@Test
	public void testUpdateEod() throws BusinessDelegateException, EodException {
		eodManagerBean.updateEod(eodVO);
	}
}
