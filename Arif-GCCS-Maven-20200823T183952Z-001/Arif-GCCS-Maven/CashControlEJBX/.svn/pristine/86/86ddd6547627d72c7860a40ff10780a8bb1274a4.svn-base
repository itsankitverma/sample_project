package com.fedex.lacitd.cashcontrol.datatier.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.GlExchRateVO;

public class GlExchRateControllerTest {

	GlExchRateController exchRateController = new GlExchRateController();
	GlExchRateVO glExchRateVO = getVO();
	
	public GlExchRateVO getVO() {
		GlExchRateVO glExchRateVO = new GlExchRateVO();
		glExchRateVO.setAvgExchRtAmt(0.3764);
		glExchRateVO.setCurExchRtAmt(0.3762);
		glExchRateVO.setCurrCd("BHD");
		try {
			glExchRateVO.setPerdDt(new SimpleDateFormat("dd-mmm-yy").parse("01-FEB-05"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return glExchRateVO;
	}
	
	
	@Test
	public void testsetGlExchRate() throws BusinessDelegateException {
		exchRateController.setGlExchRate(glExchRateVO);
	}
	
	@Test
	public void testGetGlExchRate() throws BusinessDelegateException {
		GlExchRatePK glExchRatePK = new GlExchRatePK();
		glExchRatePK.setCurrCd("BHD");
		try {
			glExchRatePK.setPerdDt(new SimpleDateFormat("dd-mmm-yy").parse("01-FEB-05"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		exchRateController.getGlExchRate(glExchRatePK);
	}
	
	@Test
	public void testGetAllGlExchRate() throws BusinessDelegateException {
		exchRateController.getAllGlExchRate();
	}
	
	@Test
	public void testRemoveGlExchRate() throws BusinessDelegateException {
		GlExchRatePK glExchRatePK = new GlExchRatePK();
		glExchRatePK.setCurrCd("BHD");
		try {
			glExchRatePK.setPerdDt(new SimpleDateFormat("dd-mmm-yy").parse("01-FEB-05"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		exchRateController.removeGlExchRate(glExchRatePK);
	}
	
	@Test
	public void testUpdateGlExchRate() throws BusinessDelegateException {
		exchRateController.updateGlExchRate(glExchRateVO);
	}
	
	@Test
	public void testGetGlExchRateManager() throws BusinessDelegateException {
		exchRateController.getGlExchRateManager();
	}

}
