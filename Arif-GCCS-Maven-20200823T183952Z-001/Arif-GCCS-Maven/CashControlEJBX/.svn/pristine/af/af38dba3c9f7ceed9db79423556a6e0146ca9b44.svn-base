package com.fedex.lacitd.cashcontrol.datatier.manager;

import java.util.Date;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.FTC_ReceivablesException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.FTC_ReceivablesVO;

public class FTC_ReceivablesManagerBeanTest {
	
	FTC_ReceivablesManagerBean ftc_ReceivablesManagerBean = new FTC_ReceivablesManagerBean();
	
	FTC_ReceivablesVO FTC_receivablesVO = getVO();
	
	public FTC_ReceivablesVO getVO() {
		
		FTC_ReceivablesVO FTC_receivablesVO = new FTC_ReceivablesVO();
		
		FTC_receivablesVO.setAmtChngEmpId("945053");
		FTC_receivablesVO.setAncChargeAmt(100);
		FTC_receivablesVO.setAwbNbr("505144746947");
		FTC_receivablesVO.setbillAccount("");
		FTC_receivablesVO.setCashDepositSlipId(2003);
		FTC_receivablesVO.setCashDepositSlipNbr("121212");
		FTC_receivablesVO.setCashPaymentAmt(100);
		FTC_receivablesVO.setChkinAgentComment("test values");
		FTC_receivablesVO.setChngStatusDt(new Date());
		FTC_receivablesVO.setChngStatusEmployeeId("945053");
		FTC_receivablesVO.setCloseDt(new Date());
		FTC_receivablesVO.setCloseEmployeeId("945053");
		FTC_receivablesVO.setCreditCardBatchId("201");
		FTC_receivablesVO.setCustChngEmpId("945053");
		FTC_receivablesVO.setCustomerNm("sumitgaba");
		FTC_receivablesVO.setDualRecIdNbr(2001);
		FTC_receivablesVO.setDupAwbFlg(null);
		FTC_receivablesVO.setEmployeeId("945053");
		FTC_receivablesVO.setEodDt(new Date());
		FTC_receivablesVO.setEodEmployeeId("945053");
		FTC_receivablesVO.setEodId(120);
		FTC_receivablesVO.setExchRateClnUsed(1.0);
		FTC_receivablesVO.setInvCurrency("USD");
		FTC_receivablesVO.setLastScanDate(new Date());
		FTC_receivablesVO.setLastScanType(null);
		FTC_receivablesVO.setLocationCd("BOMA");
		FTC_receivablesVO.setMiscDate(new Date());
		FTC_receivablesVO.setMiscNbr("123");
		FTC_receivablesVO.setOrigCustNm("test customer");
		FTC_receivablesVO.setOrigEmployeeId("945053");
		FTC_receivablesVO.setOrigRcptNbr("123");
		FTC_receivablesVO.setOrigRecAmt(125);
		FTC_receivablesVO.setOtherComment(null);
		FTC_receivablesVO.setOtherDepositSlipId(1313);
		FTC_receivablesVO.setOtherDocNbr(null);
		FTC_receivablesVO.setOtherPaymentAmt(133);
		FTC_receivablesVO.setOtherPaymentType(1);
		FTC_receivablesVO.setPaymentCurrency("USD");
		FTC_receivablesVO.setPymtImpDt(new Date());
		FTC_receivablesVO.setRcptChngEmpId("945053");
		FTC_receivablesVO.setRcptNbr("123132");
		FTC_receivablesVO.setReassEmpId("945053");
		FTC_receivablesVO.setRecAmt(123);
		FTC_receivablesVO.setRecDt(new Date());
		FTC_receivablesVO.setRecId(575989);
		FTC_receivablesVO.setRecNbr("abc");
		FTC_receivablesVO.setRecvPrepyAmt(123);
		FTC_receivablesVO.setStatusId(1);
		FTC_receivablesVO.setTinUniqId(null);
		FTC_receivablesVO.setTrackingStatus(1);
		
		return FTC_receivablesVO; 
	}
	@Test
	public void testSetFTC_Receivables() throws BusinessDelegateException, FTC_ReceivablesException {
		ftc_ReceivablesManagerBean.setFTC_Receivables(FTC_receivablesVO);
	}
	
	@Test
	public void testGetFTC_Receivables() throws BusinessDelegateException, FinderException {
		int recId = 575989;
		ftc_ReceivablesManagerBean.getFTC_Receivables(recId);
	}
	
	@Test
	public void testGetAllFTC_Receivables() throws BusinessDelegateException {
		ftc_ReceivablesManagerBean.getAllFTC_Receivables();
	}
	
	@Test
	public void testGetFTC_ReceivablesReceivablesByAwbNbr() throws BusinessDelegateException {
		String awbNbr = "505144746947";
		ftc_ReceivablesManagerBean.getFTC_ReceivablesReceivablesByAwbNbr(awbNbr);
	}
	
	@Test
	public void testGetFTC_ReceivablesByEodId() throws BusinessDelegateException {
		int eodId = 120;
		ftc_ReceivablesManagerBean.getFTC_ReceivablesByEodId(eodId);
	}
	
	@Test
	public void testRemoveFTC_Receivables() throws BusinessDelegateException, RemoveException {
		int recId = 575989;
		ftc_ReceivablesManagerBean.removeFTC_Receivables(recId);
	}
	
	@Test
	public void testUpdateFTC_Receivables() throws BusinessDelegateException, FTC_ReceivablesException {
		ftc_ReceivablesManagerBean.updateFTC_Receivables(FTC_receivablesVO);
	}
}
