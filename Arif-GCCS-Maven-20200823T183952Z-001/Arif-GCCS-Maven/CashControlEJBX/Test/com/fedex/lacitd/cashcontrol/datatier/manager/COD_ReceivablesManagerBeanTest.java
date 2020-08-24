package com.fedex.lacitd.cashcontrol.datatier.manager;

import java.util.Date;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.junit.Test;

import com.fedex.lacitd.cashcontrol.datatier.exception.BusinessDelegateException;
import com.fedex.lacitd.cashcontrol.datatier.exception.COD_ReceivablesException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.COD_ReceivablesVO;

public class COD_ReceivablesManagerBeanTest {
	COD_ReceivablesManagerBean cod_ReceivablesManagerBean = new COD_ReceivablesManagerBean();
	COD_ReceivablesVO cod_ReceivablesVO = getVO();
	
	public COD_ReceivablesVO getVO() {
		COD_ReceivablesVO cod_ReceivablesVO = new COD_ReceivablesVO();
		
		cod_ReceivablesVO.setAmtChngEmpId("945053");
		cod_ReceivablesVO.setAncChargeAmt(100);
		cod_ReceivablesVO.setAwbNbr("505144746947");
		cod_ReceivablesVO.setbillAccount("");
		cod_ReceivablesVO.setCashDepositSlipId(2003);
		cod_ReceivablesVO.setCashDepositSlipNbr("121212");
		cod_ReceivablesVO.setCashPaymentAmt(100);
		cod_ReceivablesVO.setChkinAgentComment("test values");
		cod_ReceivablesVO.setChngStatusDt(new Date());
		cod_ReceivablesVO.setChngStatusEmployeeId("945053");
		cod_ReceivablesVO.setCloseDt(new Date());
		cod_ReceivablesVO.setCloseEmployeeId("945053");
		cod_ReceivablesVO.setCodAmt(100);
		cod_ReceivablesVO.setCreditCardBatchId("201");
		cod_ReceivablesVO.setCustChngEmpId("945053");
		cod_ReceivablesVO.setCustomerNm("sumitgaba");
		cod_ReceivablesVO.setDex11CashPayment(0.0);
		cod_ReceivablesVO.setDex11FreightAmt(0.0);
		cod_ReceivablesVO.setDex11OtherDocNbr(null);
		cod_ReceivablesVO.setDex11ScanSeqNbr(null);
		cod_ReceivablesVO.setDualRecIdNbr(2001);
		cod_ReceivablesVO.setDupAwbFlg(null);
		cod_ReceivablesVO.setEmployeeId("945053");
		cod_ReceivablesVO.setEodDt(new Date());
		cod_ReceivablesVO.setEodEmployeeId("945053");
		cod_ReceivablesVO.setEodId(120);
		cod_ReceivablesVO.setExchRateClnUsed(1.0);
		cod_ReceivablesVO.setInvCurrency("USD");
		cod_ReceivablesVO.setLastScanDate(new Date());
		cod_ReceivablesVO.setLastScanType(null);
		cod_ReceivablesVO.setLocationCd("BOMA");
		cod_ReceivablesVO.setMiscDate(new Date());
		cod_ReceivablesVO.setMiscNbr("123");
		cod_ReceivablesVO.setOrigCustNm("test customer");
		cod_ReceivablesVO.setOrigEmployeeId("945053");
		cod_ReceivablesVO.setOrigRcptNbr("123");
		cod_ReceivablesVO.setOrigRecAmt(125);
		cod_ReceivablesVO.setOtherComment(null);
		cod_ReceivablesVO.setOtherDepositSlipId(1313);
		cod_ReceivablesVO.setOtherDocNbr(null);
		cod_ReceivablesVO.setOtherPaymentAmt(133);
		cod_ReceivablesVO.setOtherPaymentType(1);
		cod_ReceivablesVO.setPaymentCurrency("USD");
		cod_ReceivablesVO.setPymtImpDt(new Date());
		cod_ReceivablesVO.setRcptChngEmpId("945053");
		cod_ReceivablesVO.setRcptNbr("123132");
		cod_ReceivablesVO.setReassEmpId("945053");
		cod_ReceivablesVO.setRecAmt(123);
		cod_ReceivablesVO.setRecDt(new Date());
		cod_ReceivablesVO.setRecId(575989);
		cod_ReceivablesVO.setRecNbr("abc");
		cod_ReceivablesVO.setRecvPrepyAmt(123);
		cod_ReceivablesVO.setStatusId(1);
		cod_ReceivablesVO.setTinUniqId(null);
		cod_ReceivablesVO.setTrackingStatus(1);
		
		return cod_ReceivablesVO; 
	}
	
	@Test
	public void testSetCOD_Receivables() throws BusinessDelegateException, COD_ReceivablesException {
		cod_ReceivablesManagerBean.setCOD_Receivables(cod_ReceivablesVO);
	}
	
	@Test
	public void testGetCOD_Receivables() throws BusinessDelegateException, FinderException {
		Integer recId = 575989;
		cod_ReceivablesManagerBean.getCOD_Receivables(recId);
	}
	
	@Test
	public void testGetAllCOD_Receivables() throws BusinessDelegateException {
		cod_ReceivablesManagerBean.getAllCOD_Receivables();
	}
	
	@Test
	public void testGetCOD_ReceivablesReceivablesByAwbNbr() throws BusinessDelegateException {
		String awbNbr = null;
		cod_ReceivablesManagerBean.getCOD_ReceivablesReceivablesByAwbNbr(awbNbr);
	}
	
	@Test
	public void testGetCOD_ReceivablesByEodId() throws BusinessDelegateException {
		int eodId = 945053;
		cod_ReceivablesManagerBean.getCOD_ReceivablesByEodId(eodId);
	}
	
	@Test
	public void testRemoveCOD_Receivables() throws BusinessDelegateException, RemoveException {
		Integer recId= 575989;
		cod_ReceivablesManagerBean.removeCOD_Receivables(recId);
	}
	
	@Test
	public void testUpdateCOD_Receivables() throws BusinessDelegateException, COD_ReceivablesException {
		cod_ReceivablesManagerBean.updateCOD_Receivables(cod_ReceivablesVO);
	}
}
