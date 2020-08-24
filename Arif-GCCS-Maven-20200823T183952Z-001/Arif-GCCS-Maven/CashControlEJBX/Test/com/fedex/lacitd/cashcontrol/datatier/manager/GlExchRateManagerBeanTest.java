package com.fedex.lacitd.cashcontrol.datatier.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.entities.GlExchRatePK;
import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.GlExchRateException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.GlExchRateVO;
public class GlExchRateManagerBeanTest {

	GlExchRateManagerBean exchRateManagerBean = new GlExchRateManagerBean();
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
	public void testsetGlExchRate() throws BusinessDelegateException, GlExchRateException {
		exchRateManagerBean.setGlExchRate(glExchRateVO);
	}
	
	@Test
	public void testGetGlExchRate() throws BusinessDelegateException, FinderException {
		GlExchRatePK glExchRatePK = new GlExchRatePK();
		glExchRatePK.setCurrCd("BHD");
		try {
			glExchRatePK.setPerdDt(new SimpleDateFormat("dd-mmm-yy").parse("01-FEB-05"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		exchRateManagerBean.getGlExchRate(glExchRatePK);
	}
	
	@Test
	public void testGetAllGlExchRate() throws BusinessDelegateException {
		exchRateManagerBean.getAllGlExchRate();
	}
	
	@Test
	public void testRemoveGlExchRate() throws BusinessDelegateException, RemoveException {
		GlExchRatePK glExchRatePK = new GlExchRatePK();
		glExchRatePK.setCurrCd("BHD");
		try {
			glExchRatePK.setPerdDt(new SimpleDateFormat("dd-mmm-yy").parse("01-FEB-05"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		exchRateManagerBean.removeGlExchRate(glExchRatePK);
	}
	
	@Test
	public void testUpdateGlExchRate() throws BusinessDelegateException, GlExchRateException {
		exchRateManagerBean.updateGlExchRate(glExchRateVO);
	}
}
