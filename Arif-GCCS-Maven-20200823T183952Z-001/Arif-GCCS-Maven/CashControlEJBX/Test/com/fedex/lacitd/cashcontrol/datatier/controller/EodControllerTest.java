package com.fedex.lacitd.cashcontrol.datatier.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EodVO;

public class EodControllerTest {
	
	EodController eodController = new EodController();
	
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
	public void testSetEod() throws BusinessDelegateException {
		eodController.setEod(eodVO);
	}
	
	@Test
	public void testGetEod() throws BusinessDelegateException {
		int eodId = 4901;
		eodController.getEod(eodId);
	}
	
	@Test
	public void testGetAllEods() throws BusinessDelegateException {
		eodController.getAllEods();
	}
	
	@Test
	public void testGetEodByEodDt() throws BusinessDelegateException {
		Date eodDt = null;
		try {
			eodDt = new SimpleDateFormat("dd/mm/yyyy").parse("16/10/2002");
		} catch (Exception e) {
			e.printStackTrace();
		}
		eodController.getEodByEodDt(eodDt);
	}

	@Test
	public void testGetEodByLocationCd() throws BusinessDelegateException {
		String locationCd = "GDLPC";
		eodController.getEodByLocationCd(locationCd);
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
		eodController.getEodByLocationDt(locationCd, eodDt);
	}
	
	@Test
	public void testRemoveEod() throws BusinessDelegateException {
		int eodId = 4901;
		eodController.removeEod(eodId);
	}
	
	@Test
	public void testUpdateEod() throws BusinessDelegateException {
		eodController.updateEod(eodVO);
	}
	
	@Test
	public void testGetEodManager() throws BusinessDelegateException {
		eodController.getEodManager();
	}
}
